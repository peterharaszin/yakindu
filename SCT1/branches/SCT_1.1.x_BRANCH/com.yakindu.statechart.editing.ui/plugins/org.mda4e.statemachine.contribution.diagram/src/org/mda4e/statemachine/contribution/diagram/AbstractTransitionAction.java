/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.diagram;

import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.mda4e.statemachine.contribution.edit.parts.OurTransitionEditPart;

import statemachine.Transition;

public abstract class AbstractTransitionAction implements IObjectActionDelegate {

	private Transition selectedElement;
	private OurTransitionEditPart editPart;

	public void selectionChanged(IAction action, ISelection selection) {
		selectedElement = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof OurTransitionEditPart) {
				editPart = ((OurTransitionEditPart) structuredSelection
						.getFirstElement());
				selectedElement = (Transition) ((View) editPart.getModel())
						.getElement();
			}
		}

	}

	protected Transition getSelectedElement() {
		return selectedElement;
	}

	protected OurTransitionEditPart getEditPart() {
		return editPart;
	}
}
