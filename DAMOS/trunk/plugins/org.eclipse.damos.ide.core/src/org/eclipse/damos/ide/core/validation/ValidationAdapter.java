/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.ide.core.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.common.markers.IMarkerConstants;
import org.eclipse.damos.ide.core.IDECorePlugin;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;

/**
 * @author Andreas Unger
 *
 */
public class ValidationAdapter extends AdapterImpl {
	
	private final DamosValidator validator = new DamosValidator();
	
	private IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		
		public void resourceChanged(IResourceChangeEvent event) {
			IMarkerDelta[] markerDeltas = event.findMarkerDeltas(IMarkerConstants.PROBLEM_MARKER_ID, false);
			for (IMarkerDelta markerDelta : markerDeltas) {
				Resource resource = getTarget();
				if (resource != null) {
					URI uri = resource.getURI();
					if (markerDelta.getResource().getFullPath().equals(new Path(uri.toPlatformString(true)))) {
						scheduleValidation();
						break;
					}
				}
			}
		}

	};

	private final ResourceSetListener resourceSetListener = new ResourceSetListenerImpl(new ResourceNotificationFilter()) {
		
		/* (non-Javadoc)
		 * @see org.eclipse.emf.transaction.ResourceSetListenerImpl#resourceSetChanged(org.eclipse.emf.transaction.ResourceSetChangeEvent)
		 */
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			super.resourceSetChanged(event);
			scheduleValidation();
		}
		
	};
	
	private volatile List<Problem> problems = Collections.emptyList();
	
	private final List<IValidationListener> validationListeners = new ArrayList<IValidationListener>();
	
	private final Object validationThreadLock = new Object();
	private volatile ValidationThread validationThread;
	
	/**
	 * 
	 */
	private ValidationAdapter() {
		// Hide constructor
	}
	
	public void addValidationListener(IValidationListener l) {
		synchronized (validationListeners) {
			if (!validationListeners.contains(l)) {
				validationListeners.add(l);
			}
		}
	}
	
	public void removeValidationListener(IValidationListener l) {
		synchronized (validationListeners) {
			validationListeners.remove(l);
		}
	}

	/**
	 * @return the markerDescriptors
	 */
	public List<Problem> getProblems() {
		return problems;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#setTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public void setTarget(Notifier newTarget) {
		if (newTarget == null) {
			return;
		}
		
		if (!(newTarget instanceof Resource)) {
			throw new IllegalArgumentException();
		}
		
		super.setTarget(newTarget);

		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_BUILD);

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain((Resource) newTarget);
		if (editingDomain != null) {
			editingDomain.addResourceSetListener(resourceSetListener);
		}
		
		validate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#unsetTarget(org.eclipse.emf.common.notify.Notifier)
	 */
	@Override
	public void unsetTarget(Notifier oldTarget) {
		if (!(oldTarget instanceof Resource)) {
			throw new IllegalArgumentException();
		}

		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain((Resource) oldTarget);
		if (editingDomain != null) {
			editingDomain.removeResourceSetListener(resourceSetListener);
		}
		
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);

		super.unsetTarget(oldTarget);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ValidationAdapter.class;
	}
	
	@Override
	public Resource getTarget() {
		return (Resource) super.getTarget();
	}

	public static ValidationAdapter get(Resource resource) {
		ValidationAdapter adapter = (ValidationAdapter) EcoreUtil.getAdapter(resource.eAdapters(), ValidationAdapter.class);
		if (adapter == null) {
			adapter = new ValidationAdapter();
			resource.eAdapters().add(adapter);
		}
		return adapter;
	}
	
	private void scheduleValidation() {
		synchronized (validationThreadLock) {
			if (validationThread != null) {
				validationThread.cancel();
			}
			validationThread = new ValidationThread();
			validationThread.start();
		}
	}
	
	public void validate() {
		try {
			TransactionalEditingDomain editingDomain = getEditingDomain();
			if (editingDomain == null) {
				return;
			}
			editingDomain.runExclusive(new Runnable() {
				
				public void run() {
					try {
						Resource resource = getTarget();
						if (resource != null) {
							problems = validator.validate(resource, null);
						}
					} catch (CoreException e) {
						IDECorePlugin.getDefault().getLog().log(e.getStatus());
					}
				}
				
			});
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	private void fireValidationEvent(ValidationEvent event) {
		IValidationListener[] listenerArray;
		synchronized (validationListeners) {
			listenerArray = validationListeners.toArray(new IValidationListener[validationListeners.size()]);
		}
		for (IValidationListener l : listenerArray) {
			l.validationPerformed(event);
		}
	}

	private TransactionalEditingDomain getEditingDomain() {
		Resource resource = getTarget();
		if (resource == null) {
			return null;
		}
		return TransactionUtil.getEditingDomain(resource);
	}

	private class ResourceNotificationFilter extends NotificationFilter.Custom {

		/* (non-Javadoc)
		 * @see org.eclipse.emf.transaction.NotificationFilter#matches(org.eclipse.emf.common.notify.Notification)
		 */
		@Override
		public boolean matches(Notification notification) {
			if (notification.getNotifier() == getTarget()) {
				return true;
			} else if (notification.getNotifier() instanceof EObject) {
				EObject eObject = (EObject) notification.getNotifier();
				if (eObject.eResource() == getTarget()) {
					return true;
				}
			}
			return false;
		}
		
	}
	
	private class ValidationThread extends Thread {
		
		private volatile boolean cancel;
		
		public void cancel() {
			cancel = true;
			interrupt();
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run() {
			try {
				sleep(500);
				if (cancel) {
					return;
				}
				validate();
				if (cancel) {
					return;
				}
				fireValidationEvent(new ValidationEvent(ValidationAdapter.this, problems));
			} catch (InterruptedException e) {
				interrupt();
			}
		}
		
	}
	
}
