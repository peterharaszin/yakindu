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
package com.yakindu.statemachine.control.highlight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.mda4e.simulation.controller.ISimulationController;
import org.mda4e.simulation.core.SimulationState;
import org.mda4e.simulation.core.event.EventDispatcher;
import org.mda4e.simulation.core.event.IEvent;
import org.mda4e.simulation.core.event.SimulationEvent;
import org.mda4e.simulation.statemachine.IStatemachineEngine;
import org.mda4e.simulation.statemachine.event.StatemachineEvent;
import org.mda4e.statemachine.contribution.edit.parts.OurStateEditPart;

import com.yakindu.statemachine.control.highlight.commands.CmdEditorLock;
import com.yakindu.statemachine.control.highlight.commands.CmdEditorUnlock;
import com.yakindu.statemachine.control.highlight.commands.CmdFireTransition;
import com.yakindu.statemachine.control.highlight.commands.CmdSetStateDisabled;
import com.yakindu.statemachine.control.highlight.commands.CmdSetStateEnabled;
import com.yakindu.statemachine.control.highlight.commands.CmdSetStatesDisabled;
import com.yakindu.statemachine.control.highlight.misc.StaticMethods;

import statemachine.State;
import statemachine.Statechart;
import statemachine.Transition;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class HighlightController extends EventDispatcher implements
		ISimulationController {

	private EventDispatcher dispatcher = null;
	private StatemachineDiagramEditor actualEditor = null;
	private List<StateEditPart> allStates;
	private List<StateEditPart> allStatesOld;
	private List<TransitionEditPart> allTransitions;
	private IStatemachineEngine simulationEngine = null;
	private final Map<String, List<Integer>> existingStatemachines;

	// private Combo cmbInstance;
	private int instance;

	public HighlightController() {

		instance = -1;
		allStates = new ArrayList<StateEditPart>();
		allStatesOld = new ArrayList<StateEditPart>();
		allTransitions = new ArrayList<TransitionEditPart>();
		actualEditor = null;
		existingStatemachines = new HashMap<String, List<Integer>>();
		dispatcher = new EventDispatcher();
		PlatformUI.getWorkbench().getWorkbenchWindows()[0]
				.getSelectionService().addSelectionListener(
						getEclipseSelectionListener());
	}

	public Group createControlGroup(final Composite parent) {

		final Group highlightGroup = new Group(parent, SWT.NONE);
		highlightGroup.setText("HighLight Control:");
		final GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		highlightGroup.setLayoutData(gd);

		final GridLayout highlightLayout = new GridLayout();
		highlightLayout.numColumns = 2;
		highlightGroup.setLayout(highlightLayout);

		final Label lblText2 = new Label(highlightGroup, SWT.SHADOW_ETCHED_OUT);
		lblText2.setText("Viewed Instance:");

		// cmbInstance = new Combo(highlightGroup, SWT.READ_ONLY);
		// cmbInstance.setEnabled(false);
		//
		// cmbInstance.addSelectionListener(new SelectionListener() {
		//
		// public void widgetDefaultSelected(final SelectionEvent e) {
		//
		// }
		//
		// public void widgetSelected(final SelectionEvent e) {
		//
		// //
		// activateStates(getStatechart(actualEditor).getUUID(),cmbInstance.getSelectionIndex()+1);
		// instance = cmbInstance.getSelectionIndex() + 1;
		// }
		// });
		return highlightGroup;
	}

	private ISelectionListener getEclipseSelectionListener() {

		return new ISelectionListener() {

			// react to Eclipse UI changes:
			public void selectionChanged(final IWorkbenchPart part,
					final ISelection selection) {

				StatemachineDiagramEditor oldEditor;
				if (part instanceof StatemachineDiagramEditor
						&& !(part.equals(actualEditor))) {
					if (simulationEngine.getUUID().equals(getStatechart((StatemachineDiagramEditor)part).getUUID())) {
						if (actualEditor != null) {
							allStatesOld = StaticMethods
									.getAllStateEditParts(StaticMethods
											.getChildren(actualEditor
													.getDiagramEditPart()));
						}
						oldEditor = actualEditor;
						actualEditor = (StatemachineDiagramEditor) part;
						allStates = StaticMethods
								.getAllStateEditParts(StaticMethods
										.getChildren(actualEditor
												.getDiagramEditPart()));
						allTransitions = StaticMethods
								.getAllTransitions(StaticMethods
										.getChildren(actualEditor
												.getDiagramEditPart()));
	
						if (simulationEngine.getSimulationState() != SimulationState.STOPPED
								&& simulationEngine.getSimulationState() != SimulationState.DISPOSED) {
							try {
								if (oldEditor != null && simulationEngine.getUUID().equals(getStatechart(oldEditor).getUUID())) {
									new CmdEditorUnlock("Lock Editor", null,
											oldEditor).execute(null, null);
								}
								new CmdEditorLock("Lock Editor", null, actualEditor)
										.execute(null, null);
							} catch (final ExecutionException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							resetEditParts(allStates, allStatesOld);
	
							// if (cmbInstance != null) {
							// cmbInstance.setEnabled(resetCmbInstance(getUUID()));
							// }
	
							// simulationEngine.getActiveStatesId(((Statechart)actualEditor.getDiagramEditPart().resolveSemanticElement()).getUUID(),
							// instance);
							simulationEngine.sendActiveStates();
						}
					}
				}
			}
		};
	}

	public void receiveEvent(final IEvent newEvent) {

		if (newEvent instanceof SimulationEvent) {
			final SimulationEvent event = (SimulationEvent) newEvent;
			System.out.println(event.getEventType().toString());
			try {
				switch (event.getEventType()) {

				case SimStart: {
					if (actualEditor != null) {
						new CmdEditorLock("Lock Editor", null, actualEditor)
								.execute(null, null);

						// Display.getDefault().asyncExec(new Runnable() {
						//
						// public void run() {
						//
						// if (!cmbInstance.isDisposed()) {
						// cmbInstance
						// .setEnabled(resetCmbInstance(getUUID()));
						// }
						// }
						// });
					}

					/*
					 * Statechart editor = getStatechart(actualEditor); if
					 * (editor!=null) { activateStates(editor.getUUID(), 1); }
					 */
					break;
				}

				case SimStop:
				case EngineDisposed:{

					if (actualEditor != null
							&& actualEditor.getEditingDomain() != null) {

						new CmdEditorUnlock("Unlock Editor", null, actualEditor)
								.execute(null, null);

						// Display.getDefault().asyncExec(new Runnable() {
						//
						// public void run() {
						//
						// if (!cmbInstance.isDisposed()) {
						// // waiting();
						// cmbInstance.removeAll();
						// cmbInstance.setEnabled(false);
						// }
						// }
						// });

						resetEditParts(allStates, allStatesOld);
					}
					break;
				}

				case EngineInitialized: {

					if (event.getSource() instanceof IStatemachineEngine) {

						simulationEngine = (IStatemachineEngine) event
								.getSource();
						
						initializeActualEditor();

						simulationEngine.addEventListener(this);

						final String uuid = simulationEngine.getUUID();

						if (!existingStatemachines.keySet().contains(uuid)) {
							existingStatemachines.put(uuid,
									new LinkedList<Integer>());
						}

						assert !existingStatemachines.get(
								simulationEngine.getUUID()).contains(
								simulationEngine.getInstanceNumber());

						existingStatemachines.get(simulationEngine.getUUID())
								.add(simulationEngine.getInstanceNumber());

						if (instance == -1) {
							instance = simulationEngine.getInstanceNumber();
						}
					}
					break;
				}

				}// End Switch
			} catch (final ExecutionException e) {
				e.printStackTrace();
			}
		} else if (newEvent instanceof StatemachineEvent) {

			final StatemachineEvent event = (StatemachineEvent) newEvent;

			try {

				switch (event.getEventType()) {

				case StateEnabled:

					if (event.getUUID().equals(getUUID())
							&& instance == event.getInstance()) {

						if (event.getSource() instanceof State) {

							final State state = (State) event.getSource();

							StateEditPart selectedElement = null;

							selectedElement = StaticMethods.searchStateNew(
									allStates, state.getId());

							if (selectedElement != null) {
								new CmdSetStateEnabled(selectedElement
										.getEditingDomain(), "setStateEnabled",
										null,
										(OurStateEditPart) selectedElement)
										.execute(null, null);
							}
						}
					}
					break;

				case StateDisabled:

					if (event.getUUID().equals(getUUID())
							&& instance == event.getInstance()) {

						if (event.getSource() instanceof State) {

							final State state = (State) event.getSource();

							StateEditPart selectedElement = null;

							selectedElement = StaticMethods.searchStateNew(
									allStates, state.getId());

							if (selectedElement != null) {
								new CmdSetStateDisabled(selectedElement
										.getEditingDomain(), "setStateEnabled",
										null,
										(OurStateEditPart) selectedElement)
										.execute(null, null);
							}
						}
					}
					break;

				case TransitionFired:

					if (event.getUUID().equals(getUUID())
							&& instance == event.getInstance()) {

						if (event.getSource() instanceof Transition) {

							final Transition transition = (Transition) event
									.getSource();

							TransitionEditPart selectedElement = null;

							selectedElement = StaticMethods
									.searchTransitionNew(allTransitions,
											transition.getId());

							if (selectedElement != null) {
								new CmdFireTransition(selectedElement
										.getEditingDomain(),
										"setTransitionEnabled", selectedElement)
										.execute(null, null);
							}
						}
					}
					break;
				}
			} catch (final ExecutionException e) {
				e.printStackTrace();
			}
		}// If
	}

	private void initializeActualEditor() {
		List<StatemachineDiagramEditor> stateEditors = StaticMethods.getStateEditors();
		for (StatemachineDiagramEditor e:stateEditors) {
			Statechart statechart = getStatechart(e);
			if (statechart != null && statechart.getUUID() != null && statechart.getUUID().equals(simulationEngine.getUUID())) {
				actualEditor = e;
			}
		}
		if (actualEditor != null) {
			allStates = StaticMethods.getAllStateEditParts(StaticMethods
					.getChildren(actualEditor.getDiagramEditPart()));
			allTransitions = StaticMethods.getAllTransitions(StaticMethods
					.getChildren(actualEditor.getDiagramEditPart()));
		}
	}

	// private boolean resetCmbInstance(final String UUID) {
	//
	// cmbInstance.removeAll();
	// boolean isFound = false;
	// // if (existingStatemachines.containsKey(UUID)) {
	// // isFound = true;
	// // cmbInstance.add("Instance " + instance);
	// // for (final Integer number : existingStatemachines.get(UUID)) {
	// // if (number.intValue() != instance) {
	// // cmbInstance.add("Instance " + number.toString());
	// // }
	// // }
	// // }
	//
	// return isFound;
	// }

	private void resetEditParts(final List<StateEditPart> stateList,
			final List<StateEditPart> oldStateList) {

		if (!oldStateList.isEmpty()) {

			try {

				new CmdSetStatesDisabled(
						oldStateList.get(0).getEditingDomain(),
						"disableAllStates", null, oldStateList).execute(null,
						null);

			} catch (final ExecutionException e) {
				e.printStackTrace();
			}
		}
		if (!stateList.isEmpty()) {
			try {
				new CmdSetStatesDisabled(stateList.get(0).getEditingDomain(),
						"disableAllStates", null, stateList)
						.execute(null, null);

			} catch (final ExecutionException e) {
				// e.printStackTrace();
			}
		}
	}

	/*
	 * private void activateStates(String UUID, int instance){ List
	 * <StateEditPart> activeStates = StaticMethods.searchStatesNew(allStates,
	 * simulationEngine.getActiveStatesId(UUID, instance)); if
	 * (!activeStates.isEmpty()) { try { new
	 * CmdSetStatesEnabled(activeStates.get
	 * (0).getEditingDomain(),"setStateEnabled",null,activeStates).execute(null,
	 * null); } catch (ExecutionException e) { e.printStackTrace(); } } }
	 */

	private Statechart getStatechart(
			final StatemachineDiagramEditor actualEditor) {

		if (actualEditor != null && actualEditor.getDiagramEditPart() != null) {

			return (Statechart) actualEditor.getDiagramEditPart()
					.resolveSemanticElement();
		}
		return null;
	}

	private String getUUID() {

		return simulationEngine.getUUID();
//		if (actualEditor != null) {
//			return getStatechart(actualEditor).getUUID();
//		}
//		return "";
	}

	/*
	 * @see
	 * org.mda4e.simulation.controller.ISimulationController#getControllerName()
	 */
	public String getControllerName() {

		return "Yakindu Highlighting Controller";
	}
}