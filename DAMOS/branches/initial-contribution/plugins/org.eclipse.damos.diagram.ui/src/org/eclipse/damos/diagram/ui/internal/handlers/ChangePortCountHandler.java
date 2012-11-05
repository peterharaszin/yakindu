/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.diagram.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.damos.diagram.ui.internal.commands.IChangePortCountCommandConstants;
import org.eclipse.damos.diagram.ui.internal.requests.IChangePortCountRequestConstants;
import org.eclipse.damos.diagram.ui.requests.IRequestConstants;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class ChangePortCountHandler extends AbstractHandler {

	@SuppressWarnings("unchecked")
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof IGraphicalEditPart) {
					IGraphicalEditPart editPart = (IGraphicalEditPart) element;
					Request request = new Request();
					String action = event.getParameter(IChangePortCountCommandConstants.PARAMETER__ACTION);
					String kind = event.getParameter(IChangePortCountCommandConstants.PARAMETER__KIND);
					if (IChangePortCountCommandConstants.PARAMETER__ACTION__ADD.equals(action)) {
						if (IChangePortCountCommandConstants.PARAMETER__KIND__INPUT.equals(kind)) {
							request.setType(IRequestConstants.REQ_ADD_INPUT_PORT);
						} else {
							request.setType(IRequestConstants.REQ_ADD_OUTPUT_PORT);
						}
					} else {
						if (IChangePortCountCommandConstants.PARAMETER__KIND__INPUT.equals(kind)) {
							request.setType(IRequestConstants.REQ_REMOVE_INPUT_PORT);
						} else {
							request.setType(IRequestConstants.REQ_REMOVE_OUTPUT_PORT);
						}
					}
					
					String name = event.getParameter(IChangePortCountCommandConstants.PARAMETER__NAME);
					request.getExtendedData().put(IChangePortCountRequestConstants.PARAMETER__NAME, name);
					Command command = editPart.getCommand(request);
					
					DiagramCommandStack commandStack = getDiagramCommandStack(event);
					if (commandStack != null) {
						commandStack.execute(command, new NullProgressMonitor());
					}
				}
			}
		}
		return null;
	}

	protected DiagramCommandStack getDiagramCommandStack(ExecutionEvent event) {
		Object stack = HandlerUtil.getActiveEditor(event).getAdapter(CommandStack.class);
		return (stack instanceof DiagramCommandStack) ? (DiagramCommandStack) stack : null;
	}
	
}
