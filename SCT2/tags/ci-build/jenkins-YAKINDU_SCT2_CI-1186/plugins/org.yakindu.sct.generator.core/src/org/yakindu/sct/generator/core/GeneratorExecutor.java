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
package org.yakindu.sct.generator.core;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author holger willebrandt - refactoring
 */
public class GeneratorExecutor {

	// @Inject
	// private XtextResourceSetProvider provider;

	public void executeGenerator(IFile file) {
		Resource resource = loadResource(file);
		GeneratorModel model = (GeneratorModel) resource.getContents().get(0);

		String generatorId = model.getGeneratorId();
		GeneratorDescriptor description = GeneratorExtensions
				.getGeneratorDescriptorForId(generatorId);
		if (description == null)
			return;
		final ISCTGenerator generator = description.createGenerator();
		final EList<GeneratorEntry> entries = model.getEntries();
		Job generatorJob = new Job("Execute SCT Genmodel " + file.getName()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				for (GeneratorEntry generatorEntry : entries) {
					if (monitor.isCanceled()) {
						break;
					}
					generator.generate(generatorEntry);
				}
				return Status.OK_STATUS;
			}
		};
		generatorJob.setRule(file.getProject().getWorkspace().getRuleFactory()
				.buildRule());
		generatorJob.schedule();
	}

	protected Resource loadResource(IFile file) {
		Resource resource = null;
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
		// if (provider != null) {
		// resource = provider.get(file.getProject()).getResource(uri, true);
		// } else {
		resource = new ResourceSetImpl().getResource(uri, true);
		// }
		return resource;
	}

}
