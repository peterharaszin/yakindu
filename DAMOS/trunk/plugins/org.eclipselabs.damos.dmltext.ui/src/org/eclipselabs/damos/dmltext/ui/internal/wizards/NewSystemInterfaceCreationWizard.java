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

package org.eclipselabs.damos.dmltext.ui.internal.wizards;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.ui.wizards.WizardNewQualifiedElementCreationPage;
import org.eclipselabs.damos.dmltext.util.DMLTextUtil;

/**
 * @author Andreas Unger
 *
 */
public class NewSystemInterfaceCreationWizard extends NewDMLTextCreationWizard {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dmltext.ui.internal.wizards.NewDMLTextCreationWizard#createMainPage()
	 */
	@Override
	protected WizardNewQualifiedElementCreationPage createMainPage() {
		WizardNewQualifiedElementCreationPage mainPage = new WizardNewQualifiedElementCreationPage("main", "System Interface", null, "system interface", "blockdiagram", "systeminterface", getSelection());
		mainPage.setDescription("Create new system interface");
		return mainPage;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dmltext.ui.internal.wizards.NewDMLTextCreationWizard#writeBody(java.lang.Appendable)
	 */
	@Override
	protected void writeBody(Appendable appendable) throws IOException {
		Fragment fragment = getMainPage().getSelectedFragment();
		Collection<Inport> inports = Collections.emptyList();
		Collection<Outport> outports = Collections.emptyList();
		
		if (fragment != null) {
			inports = EcoreUtil.<Inport>getObjectsByType(fragment.getAllComponents(), DMLPackage.eINSTANCE.getInport());
			outports = EcoreUtil.<Outport>getObjectsByType(fragment.getAllComponents(), DMLPackage.eINSTANCE.getOutport());
		}

		appendable.append("systemInterface ");
		appendable.append(getMainPage().getModelName());
		appendable.append(" {\n\n");
		if (inports.isEmpty()) {
			appendable.append("\t// Specify inlets, e.g. 'inlet real myInlet'\n");
		} else {
			writeDataType(appendable, inports, "inlet");
		}
		appendable.append("\n");
		if (inports.isEmpty()) {
			appendable.append("\t// Specify outlets, e.g. 'outlet real myOutlet'\n");
		} else {
			writeDataType(appendable, outports, "outlet");
		}
		appendable.append("\n");
		appendable.append("}\n");
	}
	
	private void writeDataType(Appendable appendable, Collection<? extends Inoutport> inoutports, String keyword) throws IOException {
		for (Inoutport inoutport : inoutports) {
			if (inoutport.getName() == null) {
				continue;
			}
			String name = inoutport.getName().trim();
			if (name.length() == 0) {
				continue;
			}
			appendable.append("\t");
			appendable.append(keyword);
			appendable.append(" ");
			String dataTypeString = null;
			DataTypeSpecification dataType = inoutport.getDataType();
			if (dataType != null) {
				dataTypeString = DMLTextUtil.getText(dataType);
			}
			if (dataTypeString == null) {
				dataTypeString = "real";
			}
			appendable.append(dataTypeString);
			appendable.append(" ");
			appendable.append(name);
			appendable.append("\n");
		}
	}

}
