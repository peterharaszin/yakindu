package org.eclipselabs.damos.ide.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipselabs.damos.ide.core.natures.DamosProjectNature;
import org.eclipselabs.damos.ide.ui.IDEUIPlugin;

public class NewDamosProjectWizard extends Wizard implements INewWizard {
	
	private WizardNewProjectCreationPage mainPage;
	
	public boolean performFinish() {
		IProgressMonitor monitor = new NullProgressMonitor();
		IProject project = mainPage.getProjectHandle();
		try {
			project.create(monitor);
			project.open(monitor);
			DamosProjectNature.applyProjectNature(project);
		} catch (CoreException e) {
			IDEUIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, IDEUIPlugin.PLUGIN_ID,
					"Creation of project '" + project.getName() + "' failed", e));
			return false;
		}
		return true;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle("New Damos Project");
	}
	
	public void addPages() {
		super.addPages();
		mainPage = new WizardNewDamosProjectCreationPage();
		addPage(mainPage);
	}
	
	private static class WizardNewDamosProjectCreationPage extends WizardNewProjectCreationPage {
		
		public WizardNewDamosProjectCreationPage() {
			super("newDamosProject");
			setTitle("Create a Damos Project");
			setDescription("Enter a project name.");
		}
		
	}

}
