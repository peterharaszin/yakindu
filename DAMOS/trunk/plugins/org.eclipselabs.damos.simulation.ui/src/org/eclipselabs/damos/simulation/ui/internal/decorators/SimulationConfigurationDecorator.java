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

package org.eclipselabs.damos.simulation.ui.internal.decorators;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.ui.internal.DconfigActivator;
import org.eclipselabs.damos.dconfig.util.PropertyPath;
import org.eclipselabs.damos.simulation.ui.SimulationUIPlugin;

/**
 * @author Andreas Unger
 *
 */
public class SimulationConfigurationDecorator extends BaseLabelProvider implements ILightweightLabelDecorator {

	private static final String DCONFIG_FILE_EXTENSION = "dconfig";
	private static final PropertyPath SOLVER_PROPERTY_PATH = PropertyPath.create("damos.simulation.solver");
	private static final String SIMULATION_OVERLAY_IMAGE = "icons/SimulationOverlay.png";
	
	private IResourceChangeListener resourceChangeListener;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
	 */
	public void decorate(Object element, IDecoration decoration) {
		if (resourceChangeListener == null) {
			resourceChangeListener = new ResourceChangeListener();
			ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
		}

		IFile file = null;
		if (element instanceof IFile) {
			file = (IFile) element;
		}
		if (file == null && element instanceof IAdaptable) {
			file = (IFile) ((IAdaptable) element).getAdapter(IFile.class);
		}
		if (file == null || !DCONFIG_FILE_EXTENSION.equals(file.getFileExtension())) {
			return;
		}
		
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		
		Configuration configuration = (Configuration) EcoreUtil.getObjectByType(resource.getContents(), DconfigPackage.eINSTANCE.getConfiguration());
		if (configuration != null && configuration.getPropertySelectionName(SOLVER_PROPERTY_PATH) != null) {
			decoration.addOverlay(AbstractUIPlugin.imageDescriptorFromPlugin(SimulationUIPlugin.PLUGIN_ID, SIMULATION_OVERLAY_IMAGE));
		}
		
		for (Resource r : resourceSet.getResources()) {
			r.unload();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.BaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {
		if (resourceChangeListener != null) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		}
		super.dispose();
	}
	
	private class ResourceChangeListener implements IResourceChangeListener {
		
		public void resourceChanged(IResourceChangeEvent event) {
			try {
				ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				event.getDelta().accept(visitor);
				IFile[] files = visitor.getFiles();
				if (files != null) {
					fireLabelProviderChanged(new LabelProviderChangedEvent(SimulationConfigurationDecorator.this, files));
				}
			} catch (CoreException e) {
				DconfigActivator.getInstance().getLog().log(new Status(IStatus.ERROR, SimulationUIPlugin.PLUGIN_ID, "Simulation configuration decorator failed", e));
			}
		}

	}
	
	private static class ResourceDeltaVisitor implements IResourceDeltaVisitor {

		private List<IFile> files;
		
		/* (non-Javadoc)
		 * @see org.eclipse.core.resources.IResourceDeltaVisitor#visit(org.eclipse.core.resources.IResourceDelta)
		 */
		public boolean visit(IResourceDelta delta) throws CoreException {
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
			case IResourceDelta.CHANGED:
				if (delta.getResource() instanceof IFile) {
					IFile file = (IFile) delta.getResource();
					if (DCONFIG_FILE_EXTENSION.equals(file.getFileExtension())) {
						if (files == null) {
							files = new ArrayList<IFile>();
						}
						files.add(file);
					}
					return false;
				}
				return true;
			}
			return false;
		}
		
		/**
		 * @return the files
		 */
		public IFile[] getFiles() {
			return files != null ? files.toArray(new IFile[files.size()]) : null;
		}
		
	}

}
