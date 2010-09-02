package org.eclipselabs.damos.ui.wizards;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
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
import org.eclipselabs.damos.core.natures.DamosProjectNature;
import org.eclipselabs.damos.ui.UIPlugin;

public class NewDamosProjectWizard extends Wizard implements INewWizard {
	
	private WizardNewProjectCreationPage mainPage;
	
	public boolean performFinish() {
		IProgressMonitor monitor = new NullProgressMonitor();
		IProject project = mainPage.getProjectHandle();
		try {
			project.create(monitor);
			project.open(monitor);
			
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = DamosProjectNature.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (CoreException e) {
			UIPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, UIPlugin.PLUGIN_ID,
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
