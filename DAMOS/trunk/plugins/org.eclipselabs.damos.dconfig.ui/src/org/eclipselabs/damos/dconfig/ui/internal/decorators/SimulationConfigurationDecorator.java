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

package org.eclipselabs.damos.dconfig.ui.internal.decorators;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
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

/**
 * @author Andreas Unger
 *
 */
public class SimulationConfigurationDecorator extends BaseLabelProvider implements ILightweightLabelDecorator {

	private static final String PLUGIN_ID = "org.eclipselabs.damos.dconfig.ui";
	private static final String SOLVER_PROPERTY_NAME = "damos.simulation.solver";
	
	private IResourceChangeListener resourceChangeListener;

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
	 */
	public void decorate(Object element, IDecoration decoration) {
		if (resourceChangeListener == null) {
			resourceChangeListener = new IResourceChangeListener() {
	
				public void resourceChanged(IResourceChangeEvent event) {
					fireLabelProviderChanged(new LabelProviderChangedEvent(SimulationConfigurationDecorator.this));
				}
	
			};
			ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
		}

		IFile file = null;
		if (element instanceof IFile) {
			file = (IFile) element;
		}
		if (file == null && element instanceof IAdaptable) {
			file = (IFile) ((IAdaptable) element).getAdapter(IFile.class);
		}
		if (file == null || !"dconfig".equals(file.getFileExtension())) {
			return;
		}
		
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(uri, true);
		
		Configuration configuration = (Configuration) EcoreUtil.getObjectByType(resource.getContents(), DconfigPackage.eINSTANCE.getConfiguration());
		if (configuration != null && configuration.getPropertySelectionName(SOLVER_PROPERTY_NAME) != null) {
			decoration.addOverlay(AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, "icons/SimulationOverlay.png"));
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

}
