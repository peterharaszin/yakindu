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

package org.eclipselabs.damos.dscript.ui.internal.wizards;

import java.io.IOException;

import org.eclipselabs.damos.dml.ui.wizards.WizardNewQualifiedElementCreationPage;

/**
 * @author Andreas Unger
 *
 */
public class NewBlockTypeCreationWizard extends NewDscriptCreationWizard {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dscript.ui.internal.wizards.NewDscriptCreationWizard#createMainPage()
	 */
	@Override
	protected WizardNewQualifiedElementCreationPage createMainPage() {
		WizardNewQualifiedElementCreationPage mainPage = new WizardNewQualifiedElementCreationPage("main", "Block Type", null, "block type", "blockdiagram", "blocktype", getSelection());
		mainPage.setDescription("Create new block type");
		mainPage.setInitialModelName("");
		return mainPage;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dscript.ui.internal.wizards.NewDscriptCreationWizard#writeBody(java.lang.Appendable)
	 */
	@Override
	protected void writeBody(Appendable appendable) throws IOException {
		appendable.append("blockType ");
		appendable.append(getMainPage().getModelName());
		appendable.append(" {\n\n");
		appendable.append("\tinput x\n");
		appendable.append("\toutput y\n\n");
		appendable.append("\tparameter gain = 1\n\n");
		appendable.append("\tbehavior {\n");
		appendable.append("\t\tcheck(real) -> real\n\n");		
		appendable.append("\t\tstatic assert gain is real(?) :\n");
		appendable.append("\t\t\terror \"Gain must be real value\"\n\n");
		appendable.append("\t\tstatic assert x is real(?) :\n");
		appendable.append("\t\t\terror \"X must be real value\"\n\n");
		appendable.append("\t\teq y = gain * x\n");
		appendable.append("\t}\n");
		appendable.append("\n}\n");
	}

}
