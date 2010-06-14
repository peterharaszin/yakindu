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
package com.yakindu.simulation.view.statemachine;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;

/**
 * Provides an adapter to register a new simulation engine at the
 * {@link ViewController} instance.
 * 
 * @author Philipp Richter
 */
public class ViewControllerAdapter extends EventDispatcher implements
		ISimulationController {

	/**
	 * Instance of the {@link ViewController}.
	 */
	private ViewController controller = null;

	/**
	 * Creates a new instance of this class.
	 */
	public ViewControllerAdapter() {

		controller = ViewController.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mda4e.simulation.controller.ISimulationController#createControlGroup
	 * (org.eclipse.swt.widgets.Composite)
	 */
	public Group createControlGroup(final Composite parent) {

		return null;
	}

	/*
	 * #(non-Javadoc)
	 * 
	 * @see
	 * org.mda4e.simulation.controller.ISimulationController#getControllerName()
	 */
	public String getControllerName() {

		return controller.getControllerName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mda4e.simulation.core.event.IEventListener#receiveEvent(org.mda4e
	 * .simulation.core.event.IEvent)
	 */
	public void receiveEvent(final IEvent event) {

		// Events are directly referred to the controller instance
		controller.receiveEvent(event);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mda4e.simulation.core.event.EventDispatcher#addEventListener(org.
	 * mda4e.simulation.core.event.IEventListener)
	 */
	@Override
	public void addEventListener(final IEventListener listener) {

		// Register the listener directly at the controller
		controller.addEventListener(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.mda4e.simulation.core.event.EventDispatcher#removeEventListener(org
	 * .mda4e.simulation.core.event.IEventListener)
	 */
	@Override
	public void removeEventListener(final IEventListener listener) {

		// Remove the listener directly at the controller
		controller.addEventListener(listener);
	}

}
