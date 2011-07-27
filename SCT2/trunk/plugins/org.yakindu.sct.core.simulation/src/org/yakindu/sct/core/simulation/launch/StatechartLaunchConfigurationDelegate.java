/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.core.simulation.launch;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.core.simulation.ISGraphExecutionBuilder;
import org.yakindu.sct.core.simulation.ISGraphExecutionFacade;
import org.yakindu.sct.core.simulation.debugmodel.SCTDebugTarget;
import org.yakindu.sct.core.simulation.extensions.Extensions;
import org.yakindu.sct.core.simulation.extensions.IExtensionPoints;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartLaunchConfigurationDelegate implements
		ILaunchConfigurationDelegate, IExtensionPoints {

	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String filename = configuration.getAttribute(
				IStatechartLaunchParameters.FILE_NAME, "");

		Resource resource = loadResource(filename);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		ISGraphExecutionBuilder builder = getBuilder();
		ISGraphExecutionFacade executionFacade = builder.build(statechart);
		IDebugTarget target = new SCTDebugTarget(launch, executionFacade);
		launch.addDebugTarget(target);
	}

	protected ISGraphExecutionBuilder getBuilder() {
		Extensions<ISGraphExecutionBuilder> extensions = new Extensions<ISGraphExecutionBuilder>(
				EXECUTION_BUILDER);
		return extensions.getFirstExtension();
	}


	/**
	 * Loads and returns the Resource for a given filename
	 */
	protected Resource loadResource(String filename) {
		URI uri = URI.createFileURI(filename);
		Factory factory = ResourceFactoryRegistryImpl.INSTANCE.getFactory(uri);
		Resource resource = factory.createResource(uri);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResources().add(resource);
		try {
			resource.load(Collections.EMPTY_MAP);
			return resource;
		} catch (IOException e) {
			throw new IllegalStateException("Error loading resource", e);
		}
	}

}
