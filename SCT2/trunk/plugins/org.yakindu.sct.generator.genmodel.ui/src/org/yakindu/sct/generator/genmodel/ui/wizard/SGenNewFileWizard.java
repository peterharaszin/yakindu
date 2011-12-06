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
package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenNewFileWizard extends Wizard implements INewWizard {

	public static final String ID = "org.yakindu.sct.generator.genmodel.ui.SGenNewFileWizard";

	protected SGenWizardPage1 modelFilePage;

	private IStructuredSelection selection;

	protected SGenWizardPage2 generatorConfigPage;

	@Inject
	private ResourceSet resourceSet;

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		setWindowTitle("New Yakindu SGen Model");
		setNeedsProgressMonitor(true);

	}

	@Override
	public void addPages() {
		modelFilePage = new SGenWizardPage1("fileName", selection, "sgen");
		modelFilePage.setTitle("YAKINDU Statechart Generator Model");
		modelFilePage
				.setDescription("Create a new YAKINDU Statechart Generator Model");
		addPage(modelFilePage);
		generatorConfigPage = new SGenWizardPage2("Statecharts", modelFilePage,
				selection);
		generatorConfigPage
				.setTitle("YAKINDU Statechart Generator Model Configuration");
		generatorConfigPage
				.setDescription("Select the Statecharts and the Generator type");
		addPage(generatorConfigPage);
	}

	@Override
	public boolean performFinish() {
		IRunnableWithProgress op = new WorkspaceModifyOperation(null) {
			@Override
			protected void execute(IProgressMonitor monitor)
					throws CoreException, InterruptedException {
				createDefaultModel(modelFilePage.getURI());
			}
		};
		try {
			getContainer().run(false, true, op);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private void createDefaultModel(URI uri) {
		List<Statechart> statecharts = generatorConfigPage.getStatecharts();
		String generatorId = generatorConfigPage.getGeneratorId();

		ModelCreator creator = new ModelCreator(generatorId, statecharts);
		GeneratorModel model = creator.create();

		Resource resource = resourceSet.createResource(uri);
		resource.getContents().add(model);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public IStructuredSelection getSelection() {
		return selection;
	}

	public void setSelection(IStructuredSelection selection) {
		this.selection = selection;
	}

}
