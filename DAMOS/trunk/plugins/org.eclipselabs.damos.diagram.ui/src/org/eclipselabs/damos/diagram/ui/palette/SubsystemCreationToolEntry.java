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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipselabs.damos.diagram.ui.part.BlockDiagramEditor;
import org.eclipselabs.damos.diagram.ui.tools.SubsystemCreationTool;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.SystemInterface;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemCreationToolEntry extends CombinedTemplateCreationEntry {

	private BlockDiagramEditor editor;
	
	public SubsystemCreationToolEntry(BlockDiagramEditor editor) {
		super("Subsystem", "Create subsystem", null, null, null, null);
		setTemplate(this);
		this.editor = editor;
	}

	public Tool createTool() {
		try {
			SystemInterface systemInterface = getInterface();
			if (systemInterface != null) {
				Tool tool = new SubsystemCreationTool(systemInterface);
				tool.setProperties(getToolProperties());
				return tool;
			}
		} catch (Exception e) {
			MessageDialog.openError(editor.getSite().getShell(), "Subsystem Creation", "Subsystem creation failed: " + e.getLocalizedMessage());
		}
		return null;
	}

	protected SystemInterface getInterface() {
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
				TransactionalEditingDomain editingDomain = editor.getEditingDomain();
				ResourceSet resourceSet = editingDomain.getResourceSet();
				Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), false), true);
				SystemInterface interface_ = (SystemInterface) EcoreUtil.getObjectByType(resource.getContents(), DMLPackage.Literals.SYSTEM_INTERFACE);
				if (interface_ != null) {
					return interface_;
				} else {
					throw new IllegalArgumentException("'" + file.getFullPath().toString() + "' does not contain a valid interface");
				}
			}
			throw new IllegalArgumentException("Invalid file");
		}
		return null;
	}

}
