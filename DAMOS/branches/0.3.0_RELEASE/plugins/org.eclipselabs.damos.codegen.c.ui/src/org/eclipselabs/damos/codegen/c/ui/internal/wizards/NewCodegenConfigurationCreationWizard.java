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

package org.eclipselabs.damos.codegen.c.ui.internal.wizards;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbench;
import org.eclipselabs.damos.dconfig.ui.wizards.NewConfigurationCreationWizard;
import org.eclipselabs.damos.dconfig.ui.wizards.WizardNewConfigurationCreationPage;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;

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

		appendable.append(indent);
		appendable.append("\tsourceFolder = \"src-gen\"\n");

		String fragmentName = getMainPage().getFragment().getName();
		if (fragmentName != null && fragmentName.trim().length() > 0) {
			appendable.append(indent);
			appendable.append("\tsystemSourceFile = \"");
			appendable.append(fragmentName.trim());
			appendable.append(".c\"\n");
		}

		appendable.append(indent);
		appendable.append("}\n");
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dconfig.ui.wizards.NewConfigurationCreationWizard#contributesSystemProperties()
	 */
	@Override
	protected boolean contributesSystemProperties() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dconfig.ui.wizards.NewConfigurationCreationWizard#writeSystemProperties(java.lang.String, java.lang.Appendable)
	 */
	@Override
	protected void writeSystemProperties(String indent, Appendable appendable) throws IOException {
		Set<String> prefixes = new HashSet<String>();

		Fragment fragment = getMainPage().getFragment();
		
		String fragmentName = fragment.getName();
		if (fragmentName != null && fragmentName.trim().length() > 0) {
			String prefix = createPrefix(fragmentName, prefixes);
			writePrefixProperty(indent, prefix, appendable);
		}
		
		writeSubsystemProperties(indent, fragment, prefixes, appendable);

		appendable.append(indent);
		appendable.append("//propagate computation {\n");
		appendable.append(indent);
		appendable.append("//\tmap real() to float64\n");
		appendable.append(indent);
		appendable.append("//\tmap int() to int32\n");
		appendable.append(indent);
		appendable.append("//}\n");
	}

	/**
	 * @param indent
	 * @param fragment
	 * @param prefixes
	 * @param appendable
	 * @throws IOException
	 */
	private void writeSubsystemProperties(String indent, Fragment fragment, Set<String> prefixes, Appendable appendable) throws IOException {
		Collection<Subsystem> subsystems = EcoreUtil.getObjectsByType(fragment.getAllComponents(), DMLPackage.eINSTANCE.getSubsystem());
		for (Subsystem subsystem : subsystems) {
			writeSubsystemProperties(indent, fragment, subsystem, prefixes, appendable);
		}
	}

	private void writeSubsystemProperties(String indent, Fragment contextFragment, Subsystem subsystem, Set<String> prefixes, Appendable appendable) throws IOException {
		String subindent = indent + "\t";
		
		appendable.append(indent);
		appendable.append("subsystem ");
		appendable.append(subsystem.getName());
		appendable.append(" {\n");
		
		String prefix = createPrefix(subsystem.getName(), prefixes);
		writePrefixProperty(subindent, prefix, appendable);

		SubsystemRealization realization = subsystem.getRealization(contextFragment);
		if (realization != null) {
			Fragment realizingFragment = realization.getRealizingFragment();
			if (realizingFragment != null) {
				writeSubsystemProperties(subindent, realizingFragment, prefixes, appendable);
			}
		}

		appendable.append(indent);
		appendable.append("}\n");
	}

	/**
	 * @param indent
	 * @param prefix
	 * @param appendable
	 * @throws IOException
	 */
	private void writePrefixProperty(String indent, String prefix, Appendable appendable) throws IOException {
		appendable.append(indent);
		appendable.append("prefix = \"");
		appendable.append(prefix);
		appendable.append("_\"\n");
	}
	
	private String createPrefix(String preferredPrefix, Set<String> prefixes) {
		String prefix = preferredPrefix;
		int i = 2;
		while (!prefixes.add(prefix)) {
			prefix = preferredPrefix + i++;
		}
		return prefix;
	}
	
}
