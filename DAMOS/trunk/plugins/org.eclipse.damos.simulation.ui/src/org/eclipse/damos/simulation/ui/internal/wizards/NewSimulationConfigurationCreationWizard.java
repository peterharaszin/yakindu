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

package org.eclipse.damos.simulation.ui.internal.wizards;

import java.io.IOException;

import org.eclipse.damos.dconfig.ui.wizards.NewConfigurationCreationWizard;
import org.eclipse.damos.dconfig.ui.wizards.WizardNewConfigurationCreationPage;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;

/**
 * @author Andreas Unger
 *
 */
public class NewSimulationConfigurationCreationWizard extends NewConfigurationCreationWizard {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Simulation Configuration");
	}

	protected WizardNewConfigurationCreationPage createMainPage() {
		WizardNewConfigurationCreationPage mainPage = new WizardNewConfigurationCreationPage("main", "Simulation Configuration", null, getSelection());
		mainPage.setDescription("Create new simulation configuration");
		mainPage.setConfigurationNamePrefix("Simulate");
		return mainPage;
	}

	protected boolean contributesImports() {
		return true;
	}

	protected void writeImports(String indent, Appendable appendable) throws IOException {
		appendable.append(indent);
		appendable.append("import damos.simulation.*\n");
		appendable.append(indent);
		appendable.append("import damos.simulation.solvers.*\n");
	}

	protected boolean contributesGlobalProperties() {
		return true;
	}

	protected void writeGlobalProperties(String indent, Appendable appendable) throws IOException {
		appendable.append(indent);
		appendable.append("simulationTime = 10(s) // comment out to perform real-time simulation\n\n");

		appendable.append(indent);
		appendable.append("select solver DormandPrince54 {\n");
		
		appendable.append(indent);
		appendable.append("\tminimumStepSize = 1e-10(s)\n");

		appendable.append(indent);
		appendable.append("\tabsoluteTolerance = 1e-10\n");

		appendable.append(indent);
		appendable.append("\trelativeTolerance = 1e-10\n");

		appendable.append(indent);
		appendable.append("}\n");
	}
	
}
