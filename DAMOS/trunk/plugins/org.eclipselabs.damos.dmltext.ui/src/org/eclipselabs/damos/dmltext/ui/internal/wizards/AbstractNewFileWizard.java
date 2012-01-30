package org.eclipselabs.damos.dmltext.ui.internal.wizards;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.util.StringInputStream;

public abstract class AbstractNewFileWizard extends Wizard implements INewWizard {
	
	private IStructuredSelection selection;
	
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}
	
	/**
	 * @return the selection
	 */
	public IStructuredSelection getSelection() {
		return selection;
	}
	
	public boolean performFinish() {
		IProgressMonitor monitor = new NullProgressMonitor();
		IFile file = getNewFileCreationPage().createNewFile();
		try {
			file.setContents(new StringInputStream(getContents()), SWT.NONE, monitor);
		} catch (CoreException e) {
			ErrorDialog.openError(getShell(), getWindowTitle(), "Creation of file '" + file.getName() + "' failed", e.getStatus());
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
	
	/**
	 * @return the newFileCreationPage
	 */
	protected abstract WizardNewFileCreationPage getNewFileCreationPage();
	
	/**
	 * @return the contents
	 */
	protected abstract String getContents();

	/**
	 * 
	 */
	protected void ensureUniqueFileName() {
		if (selection.getFirstElement() instanceof IResource) {
			// Get the resource parent, if its a file.
			//
			IResource selectedResource = (IResource) selection.getFirstElement();
			if (selectedResource.getType() == IResource.FILE) {
				selectedResource = selectedResource.getParent();
			}

			// This gives us a directory...
			//
			if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
				WizardNewFileCreationPage page = getNewFileCreationPage();
				// Set this for the container.
				//
				page.setContainerFullPath(selectedResource.getFullPath());

				// Make up a unique new name here.
				//
				String fileNameBase = page.getFileName();
				String fileExtension = page.getFileExtension();
				String fileName = fileNameBase + "." + fileExtension;
				IContainer container = (IContainer) selectedResource;
				for (int i = 1; container.findMember(fileName) != null; ++i) {
					fileName = fileNameBase + i + "." + fileExtension;
				}
				page.setFileName(fileName);
			}
		}
	}
	
}
