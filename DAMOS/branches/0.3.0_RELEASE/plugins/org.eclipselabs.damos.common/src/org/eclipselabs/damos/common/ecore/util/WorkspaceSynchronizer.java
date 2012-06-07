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

package org.eclipselabs.damos.common.ecore.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipselabs.damos.common.CommonPlugin;

/**
 * @author Andreas Unger
 *
 */
public class WorkspaceSynchronizer {

	private final TransactionalEditingDomain editingDomain;
	private final Resource owner;
	
	private IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		
		public void resourceChanged(IResourceChangeEvent event) {
			final IResourceDelta delta = event.getDelta();
			try {
				editingDomain.runExclusive(new Runnable() {
					
					public void run() {
						try {
							delta.accept(new ResourceDeltaVisitor(editingDomain));
						} catch (CoreException e) {
							CommonPlugin.getDefault().getLog().log(e.getStatus());
						}
					}
					
				});
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} 
		}

	};
	
	/**
	 * 
	 */
	public WorkspaceSynchronizer(TransactionalEditingDomain editingDomain, Resource owner) {
		this.editingDomain = editingDomain;
		this.owner = owner;
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_CHANGE);
	}
	
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
	}

	private class ResourceDeltaVisitor implements IResourceDeltaVisitor {
		
		private TransactionalEditingDomain editingDomain;
		
		/**
		 * 
		 */
		public ResourceDeltaVisitor(TransactionalEditingDomain editingDomain) {
			this.editingDomain = editingDomain;
		}
		
		public boolean visit(final IResourceDelta delta) throws CoreException {
			if (delta.getResource() instanceof IFile) {
				unloadResource(delta.getMovedToPath());
				unloadResource(delta.getFullPath());
				return false;
			}
			return true;
		}

		private void unloadResource(IPath path) {
			if (path != null) {
				URI uri = URI.createPlatformResourceURI(path.toString(), true);
				Resource resource = editingDomain.getResourceSet().getResource(uri, false);
				if (resource != null && resource != owner) {
					resource.unload();
				}
			}
		}
		
	}

}
