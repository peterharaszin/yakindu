/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.providers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

/**
 * @author Andreas Unger
 *
 */
public class SelectFileBlockTypeProvider extends AbstractFileBlockTypeProvider {

	/**
	 * 
	 */
	public SelectFileBlockTypeProvider(EditingDomain editingDomain) {
		super(editingDomain);
	}
	
	protected IFile getFile() {
		FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				false,
				ResourcesPlugin.getWorkspace().getRoot(),
				IResource.FILE);
		d.setInitialPattern("*.blocktype");
		
		if (d.open() == Dialog.OK) {
			Object firstResult = d.getFirstResult();
			if (firstResult instanceof IFile) {
				return (IFile) firstResult;
			} else {
				showError("No valid file selected");
			}
		}
		return null;
	}

}
