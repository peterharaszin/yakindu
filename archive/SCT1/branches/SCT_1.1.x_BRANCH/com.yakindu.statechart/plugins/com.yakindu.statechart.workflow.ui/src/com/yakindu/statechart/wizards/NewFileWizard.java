package com.yakindu.statechart.wizards;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * This wizard will create a new workflow-file with structured content.
 * @author lass
 *
 */
public class NewFileWizard extends Wizard implements INewWizard {

	private IStructuredSelection selection;
	private NewFileWizardPage newFileWizardPage;
	private FillNewFileWizardPage fillNewFileWizardPage;
	private IPath containerFullPath;
	private String modelName;
	private String sourceFolder;
	private String platform;
	private boolean defensive;

	public NewFileWizard() {
		setWindowTitle("New Workflowfile");
	}

	/**
	 * This method will add all pages to this wizard.
	 */
	@Override
	public void addPages() {
		newFileWizardPage = new NewFileWizardPage(selection);
		fillNewFileWizardPage = new FillNewFileWizardPage(newFileWizardPage);
		addPage(newFileWizardPage);
		addPage(fillNewFileWizardPage);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard.
	 */
	@Override
	public boolean performFinish() {

		final String fileName = newFileWizardPage.getFileName();
		containerFullPath = newFileWizardPage.getContainerFullPath();

		modelName = fillNewFileWizardPage.getModelNameText();
		sourceFolder = fillNewFileWizardPage.getTargetFolderText();
		platform = fillNewFileWizardPage.getTargetPlatformText();
		defensive = fillNewFileWizardPage.isDefensive();

		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor)
					throws InvocationTargetException {
				try {
					doFinish(fileName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException
					.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * This method will create a new file and fill it with content.
	 * 
	 * @param fileName
	 * @param monitor
	 * @throws CoreException
	 */
	private void doFinish(String fileName, IProgressMonitor monitor)
			throws CoreException {
		// create a sample file
		monitor.beginTask("Creating " + fileName, 2);
		IContainer container = ResourcesPlugin.getWorkspace().getRoot()
				.getFolder(containerFullPath);
		final IFile file = container.getFile(new Path(fileName));
		try {
			InputStream stream = openContentInputStream();
			if (file.exists()) {
				file.setContents(stream, true, true, monitor);
			} else {
				file.create(stream, true, monitor);
			}
			stream.close();
		} catch (IOException e) {
		}
		monitor.worked(1);
		monitor.setTaskName("Opening file for editing...");
		getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchPage page = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				try {
					IDE.openEditor(page, file, true);
				} catch (PartInitException e) {
				}
			}
		});
		monitor.worked(1);
	}

	/**
	 * This method initialize file contents with a sample definition.
	 */
	private InputStream openContentInputStream() {

		String contents = "//This file was created with the wizard.\n";
		contents += "modelFile \"" + modelName + "\"\n";
		contents += "targetDir \"" + sourceFolder + "\"\n";
		contents += "targetPlatform " + platform.toLowerCase()
				+ ((defensive) ? " defensive\n" : "\n");
		return new ByteArrayInputStream(contents.getBytes());
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

}
