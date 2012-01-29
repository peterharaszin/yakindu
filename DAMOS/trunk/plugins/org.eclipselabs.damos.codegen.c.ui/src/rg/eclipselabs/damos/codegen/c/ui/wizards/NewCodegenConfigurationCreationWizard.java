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

package rg.eclipselabs.damos.codegen.c.ui.wizards;

import java.io.IOException;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipselabs.damos.dconfig.ui.wizards.NewConfigurationCreationWizard;
import org.eclipselabs.damos.dconfig.ui.wizards.WizardNewConfigurationCreationPage;

/**
 * @author Andreas Unger
 *
 */
public class NewCodegenConfigurationCreationWizard extends NewConfigurationCreationWizard {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New C Code Generator Configuration");
	}

	protected WizardNewConfigurationCreationPage createMainPage() {
		WizardNewConfigurationCreationPage mainPage = new WizardNewConfigurationCreationPage("main", "C Code Generator Configuration", null, getSelection());
		mainPage.setDescription("Create new C code generator configuration");
		mainPage.setConfigurationNamePrefix("Generate");
		return mainPage;
	}

	protected boolean contributesImports() {
		return true;
	}

	protected void writeImports(String indent, Appendable appendable) throws IOException {
		appendable.append(indent);
		appendable.append("import damos.codegen.*\n");
		appendable.append(indent);
		appendable.append("import damos.codegen.c.*\n");
	}

	protected boolean contributesGlobalProperties() {
		return true;
	}

	protected void writeGlobalProperties(String indent, Appendable appendable) throws IOException {
		appendable.append(indent);
		appendable.append("select generator DefaultGenerator {\n");
		
		appendable.append(indent);
		appendable.append("\tprojectName = \"");
		appendable.append(getMainPage().getParentFolder().getProject().getName());
		appendable.append("\"\n");

		String sourceFolder = getMainPage().getParentFolder().getProjectRelativePath().toString();
		if (sourceFolder.length() > 0) {
			appendable.append(indent);
			appendable.append("\tsourceFolder = \"");
			appendable.append(sourceFolder);
			appendable.append("\"\n");
		}

		appendable.append(indent);
		appendable.append("}\n");
	}
	
}
