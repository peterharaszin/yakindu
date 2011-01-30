package org.eclipselabs.damos.ide.core.natures;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.damos.ide.core.IDECorePlugin;

public class DamosProjectNature implements IProjectNature {

	public static final String NATURE_ID = IDECorePlugin.PLUGIN_ID + ".damosNature";
	public static final String BUILDER_ID = IDECorePlugin.PLUGIN_ID + ".damosBuilder";

	private IProject project;

	public void configure() throws CoreException {
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();
		boolean found = false;

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(BUILDER_ID)) {
				found = true;
				break;
			}
		}

		if (!found) {
			// add builder to project
			ICommand command = desc.newCommand();
			command.setBuilderName(BUILDER_ID);
			ICommand[] newCommands = new ICommand[commands.length + 1];

			// Add it before other builders.
			System.arraycopy(commands, 0, newCommands, 1, commands.length);
			newCommands[0] = command;
			desc.setBuildSpec(newCommands);
			project.setDescription(desc, null);
		}
	}

	public void deconfigure() throws CoreException {
	}

	public IProject getProject() {
		return project;
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	private static int getProjectNatureIndex(IProject project) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		// find project nature
		int index = -1;
		for (int i = 0; i < natures.length && index < 0; ++i) {
			if (natures[i].equals(NATURE_ID)) {
				index = i;
			}
		}
		return index;
	}

	public static void applyProjectNature(IProject project) throws CoreException {
		if (getProjectNatureIndex(project) >= 0) {
			return; // already has project nature
		}

		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 1, natures.length);
		newNatures[0] = NATURE_ID;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}

	public static void unapplyProjectNature(IProject project) throws CoreException {
		// find project nature
		int index = getProjectNatureIndex(project);

		// if nature is applied, unapply it
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		if (index >= 0) {
			String[] newNatures = new String[natures.length - 1];
			for (int i = 0; i < newNatures.length; ++i) {
				if (i >= index) {
					newNatures[i] = natures[i + 1];
				}
			}
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		}
	}

}
