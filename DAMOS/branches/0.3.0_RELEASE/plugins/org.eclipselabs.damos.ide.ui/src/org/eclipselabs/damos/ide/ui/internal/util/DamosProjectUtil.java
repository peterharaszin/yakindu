package org.eclipselabs.damos.ide.ui.internal.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

public class DamosProjectUtil {

	private static int getProjectNatureIndex(IProject project, String natureId) throws CoreException {
		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();

		// find project nature
		int index = -1;
		for (int i = 0; i < natures.length && index < 0; ++i) {
			if (natures[i].equals(natureId)) {
				index = i;
			}
		}
		return index;
	}

	public static void applyProjectNature(IProject project, String natureId) throws CoreException {
		if (getProjectNatureIndex(project, natureId) >= 0) {
			return; // already has project nature
		}

		IProjectDescription description = project.getDescription();
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = natureId;
		description.setNatureIds(newNatures);
		project.setDescription(description, null);
	}

	public static void unapplyProjectNature(IProject project, String natureId) throws CoreException {
		// find project nature
		int index = getProjectNatureIndex(project, natureId);

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
