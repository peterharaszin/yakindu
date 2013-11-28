/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.view.statemachine.presentation.utilities.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import com.yakindu.simulation.view.statemachine.nls.Messages;
import com.yakindu.simulation.view.statemachine.presentation.StatemachineView;
import com.yakindu.simulation.view.statemachine.presentation.utilities.StatemachineViewConfig;

/**
 * Defines an action which allows to configure whether the
 * {@link StatemachineView} shall change the view to the last started engine
 * automatically.
 * 
 * @author Philipp Richter
 * 
 */
public class ShowNewEngineAction extends Action {

	/**
	 * Defines the configuration instance which stores the chosen option.
	 */
	private StatemachineViewConfig config = null;

	/**
	 * Creates an instance of this class with the given configuration instance.
	 * 
	 * @param config defines the configuration instance whose method
	 *            {@link StatemachineViewConfig#setShowNewEngine(boolean)
	 *            setShowNewEngine(boolean)} is called to store the chosen
	 *            option.
	 */
	public ShowNewEngineAction(final StatemachineViewConfig config) {

		super(Messages.ShowNewEngineAction_text, IAction.AS_CHECK_BOX);

		this.config = config;

		setToolTipText(Messages.ShowNewEngineAction_tooltip);
		setDescription(Messages.ShowNewEngineAction_description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		if (isChecked()) {
			config.setShowNewEngine(true);
		} else {
			config.setShowNewEngine(false);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#getDisabledImageDescriptor()
	 */
	@Override
	public ImageDescriptor getDisabledImageDescriptor() {

		return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
			ISharedImages.IMG_TOOL_FORWARD_DISABLED);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#getImageDescriptor()
	 */
	@Override
	public ImageDescriptor getImageDescriptor() {

		return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
			ISharedImages.IMG_TOOL_FORWARD);
	}

}
