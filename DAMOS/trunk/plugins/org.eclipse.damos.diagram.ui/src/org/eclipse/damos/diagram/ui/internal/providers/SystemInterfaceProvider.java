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
import org.eclipse.damos.diagram.core.internal.provider.ISystemInterfaceProvider;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.SystemInterface;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

/**
 * @author Andreas Unger
 *
 */
public class SystemInterfaceProvider implements ISystemInterfaceProvider {

	private EditingDomain editingDomain;
	private SystemInterface cachedSystemInterface;
	
	/**
	 * 
	 */
	public SystemInterfaceProvider(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.core.internal.provider.ISystemInterfaceProvider#getSystemInterface()
	 */
	public SystemInterface getSystemInterface() {
		if (cachedSystemInterface == null) {
			FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					false,
					ResourcesPlugin.getWorkspace().getRoot(),
					IResource.FILE);
			d.setTitle("Select System Interface");
			d.setMessage("Select a system interface for the new subsystem (*, ?, or camel case):");
			d.setInitialPattern("*.systeminterface");
			
			if (d.open() == Dialog.OK) {
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					IFile file = (IFile) firstResult;
					ResourceSet resourceSet = editingDomain.getResourceSet();
					try {
						Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), false), true);
						SystemInterface interface_ = (SystemInterface) EcoreUtil.getObjectByType(resource.getContents(), DMLPackage.Literals.SYSTEM_INTERFACE);
						if (interface_ != null) {
							cachedSystemInterface = interface_;
						} else {
							showError("'" + file.getFullPath().toString() + "' does not contain a valid system interface");
						}
					} catch (Exception e) {
						showError("Could not load system interface from '" + file.getFullPath() + "'");
					}
				} else {
					showError("No valid file selected");
				}
			}
		}
		return cachedSystemInterface;
	}

	private void showError(String message) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		MessageDialog.openError(shell, "Choose System Interface", message);
	}

}
