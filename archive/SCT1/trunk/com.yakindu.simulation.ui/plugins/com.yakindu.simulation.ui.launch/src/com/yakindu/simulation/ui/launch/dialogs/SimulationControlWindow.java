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
package com.yakindu.simulation.ui.launch.dialogs;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.ISimulationEngine;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.IEventListener;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.core.event.SimulationEvent.SimulationEventTypes;

/**
 * The <code>SimulationControlWindow</code> has been conceived for the controlling
 * of simulation engines ({@link ISimulationEngine}). By combining controls which
 * are provided by controller instances ({@link ISimulationController}) this window
 * allows to control the simulation engine and also to get informations about the
 * engine and the simulated system. 
 * 
 * @author Markus M�hlbrandt, Philipp Richter
 */
public class SimulationControlWindow extends ApplicationWindow {

	/**
	 * Defines the simulation engine instance ({@link ISimulationEngine}) which is
	 * controlled by this window.
	 */
	private ISimulationEngine simulationEngine = null;
	
	/**
	 * Defines all current {@link ISimulationController} instances which provide
	 * controls for the <code>simulationEngine</code>.
	 */
	private List<ISimulationController> simulationControllerList = null;
	/**
	 * Defines all controls in the same order as the available controllers in the
	 * <code>simulationControllist</code>.
	 */
	private List<Group> simulationControllerGroups = null;
	
	/**
	 * Contains all controller controls which are available.
	 */
	private Composite comp = null;
	/**
	 * Allows to close the simulation.
	 */
	private Button btnCancel = null;
	
	/**
	 * Provides informations of the used simulation engine ({@link ISimulationEngine}).
	 */
	private Label lEngine = null;
	
	/**
	 * Provides informations of the system which is simulated by this window.
	 */
	private Label lSystem = null;
	
	/**
	 * Provides the instance number of the current simulation. For more informations
	 * see {@link ISimulationEngine#getInstanceNumber()}
	 */
	private Label lInstance = null;
	
	/**
	 * Creates a new instance with all controls of the given {@link ISimulationController}s.
	 * 
	 * @param simulationControllerList	defines all controllers which are provides controls
	 * 									or functionality for the {@link ISimulationEngine}.
	 */
	public SimulationControlWindow(final List<ISimulationController> simulationControllerList) {
		super(null);
		this.simulationControllerList = simulationControllerList;
		
		simulationControllerGroups = new ArrayList<Group>();
	}

	/*
	 * @see org.eclipse.jface.window.Window#createContents(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected Control createContents(final Composite parent) {
		
		synchronized (simulationControllerList) {
			
			// Load the yakindu icon
			InputStream iconStream = SimulationControlWindow.class.getResourceAsStream("/icons/yakindu_icon.png");
			if(iconStream != null) {
				Image iconImage = new Image(parent.getDisplay(), iconStream);
				parent.getShell().setImage(iconImage);
			}
			
			comp = new Composite(parent, SWT.NONE);
			GridLayout topLayout = new GridLayout();
			comp.setLayout(topLayout);
			
			// Add simulation informations
			createEngineInfoGroup(comp);
			
			for (ISimulationController controller : simulationControllerList) {
				Group controlGroup = controller.createControlGroup(comp);
				simulationControllerGroups.add(controlGroup);
			}
			
			btnCancel = new Button(comp,SWT.PUSH);
			btnCancel.setText("Cancel");
			btnCancel.setToolTipText("Cancel launch");
			btnCancel.addSelectionListener(new ControlsListener());
			
			calculateShellSize();
	
			return super.createContents(parent);
		}
	}
	
	/**
	 * Calls the <code>pack()</code> of the <code>Shell</code>. After that
	 * the width of the <code>Shell</code> is set on a certain size.
	 */
	private void calculateShellSize() {
		
		getShell().pack();
		getShell().setSize(300, getShell().getSize().y);
	}

	/**
	 * Creates a <code>Group</code> which provides <code>Label</code>s to inform
	 * the user about the used {@link ISimulationEngine} and the system which
	 * is simulated be this engine.
	 * 
	 * @param comp	defines the parent <code>Composite</code> for this
	 * 				<code>Group</code>
	 */
	private void createEngineInfoGroup(final Composite comp) {
		
		Group infoGroup = new Group(comp, SWT.NONE);
		infoGroup.setText("Engine Informations");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		infoGroup.setLayoutData(gd);
		
		GridLayout infoLayout = new GridLayout();
		infoLayout.numColumns = 2;
		infoLayout.marginHeight = 5;
		infoLayout.marginWidth = 5;
		infoGroup.setLayout(infoLayout);
		
		createInfoLabels(infoGroup);
	}

	/**
	 * Creates the <code>Label</code>s for the <code>Group</code> which shows the
	 * informations about the used {@link ISimulationEngine} and the system which
	 * is simulated be this engine.
	 * 
	 * @param group		defines the parent <code>Group</code> for the
	 * 					<code>Label</code>s
	 */
	private void createInfoLabels(final Group group) {
		
		Label lcEngine = new Label(group, SWT.SHADOW_IN);
		lcEngine.setText("Engine:");
		lcEngine.pack();
		lEngine = new Label(group, SWT.SHADOW_IN);
		
		Label lcSystem = new Label(group, SWT.SHADOW_IN);
		lcSystem.setText("System:");
		lcSystem.pack();
		lSystem = new Label(group, SWT.SHADOW_IN);
		
		Label lcInstance = new Label(group, SWT.SHADOW_IN);
		lcInstance.setText("Instance:");
		lcInstance.pack();
		lInstance = new Label(group, SWT.SHADOW_IN);
		
		updateEngineInfos();
	}

	/**
	 * Updates all labels in the group infoGroup and the window title.
	 */
	private void updateEngineInfos() {
		
		if (getShell() != null) {
			
			getShell().setText("");
			
			if (simulationEngine.getEngineName().equals("")) {
				lEngine.setText("-");
			} else {
				lEngine.setText(simulationEngine.getEngineName());
			}
			
			if (simulationEngine.getSystemName().equals("")) {
				lSystem.setText("-");
			} else {
				lSystem.setText(simulationEngine.getSystemName());
				getShell().setText(simulationEngine.getSystemName());
			}
			
			if (simulationEngine.getInstanceNumber() < 0) {
				lInstance.setText("-");
			} else {
				lInstance.setText(String.valueOf(simulationEngine.getInstanceNumber()));
				getShell().setText(getShell().getText() + " (" + simulationEngine.getInstanceNumber() + ")");
			}
			
			lEngine.pack();
			lSystem.pack();
			lInstance.pack();
		}
	}
	
	/**
	 * Provides an {@link IEventListener} which can be used to receive {@link IEvent}s.
	 * The listener checks whether the respective event is an instance of
	 * {@link SimulationEvent}. If it is true, the event type is checked and if the type
	 * is {@link SimulationEventTypes#EngineCreated EngineCreated} or
	 * {@link SimulationEventTypes#EngineInitialized EngineInitialized} the method calls
	 * the function {@link #updateEngineInfos()} to update all informations.
	 * 
	 * @return The <code>IEventListener</code> which allows to update the engine informations.
	 */
	public IEventListener getSimulationListener() {
		
		return new IEventListener() {

			public void receiveEvent(final IEvent event) {
				
				if (event instanceof SimulationEvent) {
					
					SimulationEvent launchEvent = (SimulationEvent) event;
					
					switch (launchEvent.getEventType()) {
					
						case EngineCreated:
							
							simulationEngine = (ISimulationEngine)event.getSource();
							simulationEngine.addEventListener(this);
							
							updateEngineInfos();
							
							break;
							
						case EngineInitialized: 
				
							updateEngineInfos();
							
							break;
						default:
							break;
							
					} //Switch
				}	
			}
		};
	}
	
	/**
	 * Defines a listener for the <code>btnCancel</code>. The listener closes
	 * this window, if the <code>Button</code> was clicked.
	 */
	private class ControlsListener extends SelectionAdapter {

		public void widgetSelected(final SelectionEvent e) {
			Object source = e.getSource();
			if (source == btnCancel) {
				btnCancel.getShell().close();
			}
		}
	} //SimControlWindowListener

	/**
	 * Allows to remove the control <code>Group</code> of the given controller.
	 * The controller also is deleted from the controller list. After that the
	 * controller and its controls are no longer available. 
	 * 
	 * @param controller	defines the <code>ISimulationController</code> which shall be removed
	 */
	public synchronized void removeController(final ISimulationController controller) {
		
		synchronized (simulationControllerList) {

			if (comp != null) {
				
				int controllerIndex = simulationControllerList.indexOf(controller);
				Control cToRemove = simulationControllerGroups.get(controllerIndex);
				
				for (Control control : comp.getChildren()) {
										
					if (control.equals(cToRemove)) {
						
						// Dispose the control group
						control.dispose();
						
						// Resize the group container
						comp.pack();
						
						// Resize the shell of the container
						calculateShellSize();
						
						control = null;
						simulationControllerGroups.remove(controllerIndex);
						break;
					}
				}
			}
			
			simulationControllerList.remove(controller);
		}
	}
}