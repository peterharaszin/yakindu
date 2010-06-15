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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.mda4e.statemachine.contribution.helper.TransitionHelper;

public class ChangePriorityAction extends AbstractTransitionAction {

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// do nothing
	}

	public void run(IAction action) {
		InputDialog ip = new InputDialog(
				Display.getCurrent().getActiveShell(),
				"Change Priority of selected Transition",
				"Specify a new Priority. Conflicting Transitions will automatically be rearranged!",
				"" + getSelectedElement().getPriority(), new IInputValidator() {
					public String isValid(String newText) {
						try {
							Integer.parseInt(newText);
							return null;
						} catch (NumberFormatException e) {
							return "Value has to be a Number.";
						}
					};
				});
		ip.setBlockOnOpen(true);
		ip.open();
		if (ip.getReturnCode() == Window.CANCEL) {
			return;
		}
		int priority = Integer.parseInt(ip.getValue());
		TransitionHelper.changePriorityAndRearrangeTransitions(
				getSelectedElement(), getEditPart().getEditingDomain(),
				priority);

	}

}
