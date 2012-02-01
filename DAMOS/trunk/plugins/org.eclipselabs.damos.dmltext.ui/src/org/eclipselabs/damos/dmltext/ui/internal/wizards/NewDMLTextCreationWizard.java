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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * @author Andreas Unger
 *
 */
public abstract class NewDMLTextCreationWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;
	private WizardNewDMLTextCreationPage mainPage;
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	protected IStructuredSelection getSelection() {
		return selection;
	}

	protected abstract WizardNewDMLTextCreationPage createMainPage();

	/**
	 * @return the mainPage
	 */
	protected WizardNewDMLTextCreationPage getMainPage() {
		return mainPage;
	}

	/**
	 * @param mainPage the mainPage to set
	 */
	protected void setMainPage(WizardNewDMLTextCreationPage mainPage) {
		this.mainPage = mainPage;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		mainPage = createMainPage();
		addPage(mainPage);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("package ");
			sb.append(mainPage.getPackageName());
			sb.append("\n\n");
			if (contributesImports()) {
				writeImports("", sb);
				sb.append("\n");
			}
			writeBody(sb);
		} catch (IOException e) {
			MessageDialog.openError(getShell(), getWindowTitle(), e.getMessage());
			return false;
		}
		
		IProgressMonitor monitor = new NullProgressMonitor();
		IFile file = mainPage.getModelFile();
		try {
			file.create(new ByteArrayInputStream(sb.toString().getBytes(file.getCharset())), true, monitor);
		} catch (CoreException e) {
			ErrorDialog.openError(getShell(), getWindowTitle(), "Creation of file '" + file.getName() + "' failed", e.getStatus());
			return false;
		} catch (UnsupportedEncodingException e) {
			MessageDialog.openError(getShell(), getWindowTitle(), "Creation of file '" + file.getName() + "' failed: " + e.getMessage());
			return false;
		}
		try {
			IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
		} catch (PartInitException e) {
			ErrorDialog.openError(getShell(), getWindowTitle(), "Opening file '" + file.getName() + "' failed", e.getStatus());
			return false;
		}

		return true;
	}
	
	protected boolean contributesImports() {
		return false;
	}

	protected void writeImports(String indent, Appendable appendable) throws IOException {
	}

	protected void writeBody(Appendable appendable) throws IOException {
	}

}
