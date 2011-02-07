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

package org.eclipselabs.damos.diagram.ui.palette;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.Tool;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipselabs.damos.diagram.ui.tools.SubsystemCreationTool;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.SystemInterface;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemCreationToolEntry extends ComponentCreationToolEntry {

	public SubsystemCreationToolEntry(IEditorPart editor) {
		super(editor, "Subsystem", "Create subsystem");
	}

	public Tool createTool() {
		try {
			SystemInterface providedInterface = getProvidedInterface();
			if (providedInterface != null) {
				Tool tool = new SubsystemCreationTool(providedInterface);
				tool.setProperties(getToolProperties());
				return tool;
			}
		} catch (Exception e) {
			MessageDialog.openError(getEditor().getSite().getShell(), "Subsystem Creation", "Subsystem creation failed: " + e.getLocalizedMessage());
		}
		return null;
	}

	protected SystemInterface getProvidedInterface() {
		FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				false,
				ResourcesPlugin.getWorkspace().getRoot(),
				IResource.FILE);
		d.setInitialPattern("*.interface.dml");
		
		if (d.open() == Dialog.OK) {
			Object firstResult = d.getFirstResult();
			if (firstResult instanceof IFile) {
				IFile file = (IFile) firstResult;
				ResourceSet resourceSet = getEditingDomain().getResourceSet();
				Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), false), true);
				SystemInterface providedInterface = (SystemInterface) EcoreUtil.getObjectByType(resource.getContents(), DMLPackage.Literals.SYSTEM_INTERFACE);
				if (providedInterface != null) {
					return providedInterface;
				} else {
					throw new IllegalArgumentException("'" + file.getFullPath().toString() + "' does not contain a valid interface");
				}
			}
			throw new IllegalArgumentException("Invalid file");
		}
		return null;
	}

}
