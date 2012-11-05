/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.editparts;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.diagram.ui.DiagramUIPlugin;
import org.eclipse.damos.diagram.ui.editparts.ComponentAttributeEditPart;
import org.eclipse.damos.diagram.ui.editparts.ComponentEditPart;
import org.eclipse.damos.diagram.ui.editparts.PortEditPart;
import org.eclipse.damos.dml.Block;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * @author Andreas Unger
 *
 */
public class BlockEditPartDelegate extends ComponentEditPartDelegate {

	private NotificationHelper notificationHelper;
	
	/**
	 * 
	 */
	public BlockEditPartDelegate(ComponentEditPart componentEditPart) {
		super(componentEditPart);
		notificationHelper = new NotificationHelper(componentEditPart);
	}
	
	public void addSemanticListeners() {
		super.addSemanticListeners();
		EObject o = editPart.resolveSemanticElement();
		if (o instanceof Block) {
			notificationHelper.addSemanticListeners(((Block) o).getArguments());
		}
	}
	
	public void removeSemanticListeners() {
		notificationHelper.removeSemanticListeners();
		super.removeSemanticListeners();
	}
	
	@Override
	public boolean performRequest(Request request) {
		if (RequestConstants.REQ_OPEN.equals(request.getType())) {
			Block block = (Block) editPart.resolveSemanticElement();
			if (block != null && block.getType() != null) {
				Resource resource = block.getType().eResource();
				if (resource != null) {
					String pathString = resource.getURI().toPlatformString(true);
					if (pathString != null) {
						Path path = new Path(pathString);
						IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
						try {
							IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file, true);
						} catch (PartInitException e) {
							DiagramUIPlugin.getDefault().getLog().log(e.getStatus());
						}
					}
				}
			}
			return true;
		}
		return false;
	}

	public EditPart getPrimaryChildEditPart() {
		// The first non-port and non-attribute edit part is our primary edit part.
		for (Object ep : editPart.getChildren()) {
			if (!(ep instanceof PortEditPart || ep instanceof ComponentAttributeEditPart)) {
				return (EditPart) ep;
			}
		}
		return super.getPrimaryChildEditPart();
	}
	
}
