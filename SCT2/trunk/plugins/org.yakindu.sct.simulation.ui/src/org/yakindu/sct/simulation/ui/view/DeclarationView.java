/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.view;

import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.AbstractDebugView;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.contexts.DebugContextEvent;
import org.eclipse.debug.ui.contexts.IDebugContextListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.core.runtime.IExecutionFacade;
import org.yakindu.sct.simulation.ui.model.presenter.IDynamicNotationHandler;
import org.yakindu.sct.simulation.ui.view.editing.BooleanEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.IntegerEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.MultiEditingSupport;
import org.yakindu.sct.simulation.ui.view.editing.RealEditingSupport;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DeclarationView extends AbstractDebugView implements
		IDebugContextListener, IDebugEventSetListener {

	private TreeViewer viewer;

	public DeclarationView() {
		DebugUITools.getDebugContextManager().addDebugContextListener(this);
		DebugPlugin.getDefault().addDebugEventListener(this);
	}

	@Override
	public void dispose() {
		super.dispose();
		DebugUITools.getDebugContextManager().removeDebugContextListener(this);
		DebugPlugin.getDefault().removeDebugEventListener(this);
	}

	@Override
	protected Viewer createViewer(Composite parent) {
		viewer = new TreeViewer(parent);
		viewer.getTree().setHeaderVisible(true);
		viewer.getTree().setLinesVisible(true);
		TreeViewerColumn column = new TreeViewerColumn(viewer, SWT.DEFAULT);
		column.getColumn().setText("Name");
		column.getColumn().setMoveable(true);
		column.getColumn().setWidth(200);
		column.setLabelProvider(new ExecutionContextLabelProvider(0));

		TreeViewerColumn valueColumn = new TreeViewerColumn(viewer, SWT.DEFAULT);
		valueColumn.getColumn().setText("Value");
		valueColumn.getColumn().setMoveable(true);
		valueColumn.getColumn().setWidth(100);
		valueColumn.setEditingSupport(new MultiEditingSupport(viewer,
				new BooleanEditingSupport(viewer), new IntegerEditingSupport(
						viewer), new RealEditingSupport(viewer)));
		valueColumn.setLabelProvider(new ExecutionContextLabelProvider(1));

		TreeViewerColumn raiseEventColumn = new TreeViewerColumn(viewer,
				SWT.DEFAULT);
		raiseEventColumn.getColumn().setText("Raise");
		raiseEventColumn.getColumn().setMoveable(true);
		raiseEventColumn.getColumn().setWidth(50);
		raiseEventColumn.setLabelProvider(new ExecutionContextLabelProvider(0));

		viewer.setContentProvider(new ExecutionContextContentProvider());
		return viewer;
	}

	public void debugContextChanged(DebugContextEvent event) {
		if ((event.getFlags() & DebugContextEvent.ACTIVATED) > 0) {
			PlatformObject object = (PlatformObject) ((IStructuredSelection) event
					.getContext()).getFirstElement();
			SCTDebugTarget debugTarget = (SCTDebugTarget) object
					.getAdapter(IDebugTarget.class);
			if (!debugTarget.isTerminated())
				refreshInput(debugTarget);
		}

	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent debugEvent : events) {
			handleDebugEvent(debugEvent);
		}
	}

	private void handleDebugEvent(DebugEvent debugEvent) {
		switch (debugEvent.getKind()) {
		case DebugEvent.TERMINATE:
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					viewer.setInput(null);
				}
			});
			break;
		}
	}

	private void refreshInput(SCTDebugTarget debugTarget) {
		IExecutionFacade facade = (IExecutionFacade) debugTarget
				.getAdapter(IExecutionFacade.class);
		viewer.setInput(facade.getExecutionContext());

	}

	@Override
	protected void createActions() {

	}

	@Override
	protected String getHelpContextId() {
		return null;
	}

	@Override
	protected void fillContextMenu(IMenuManager menu) {

	}

	@Override
	protected void configureToolBar(IToolBarManager tbm) {

	}

	public IExecutionContext getExecutionContext() {
		// TODO Auto-generated method stub
		return null;
	}

	// private TableViewer eventViewer;
	//
	// private TableViewer variableViewer;
	//
	// private Map<Control, SelectionListener> controls;
	// private Map<Control, TableEditor> tableEditors;
	//
	// //private SimulationSession activeSession;
	//
	// public DeclarationView() {
	// controls = new HashMap<Control, SelectionListener>();
	// tableEditors = new HashMap<Control, TableEditor>();
	// }
	//
	// @Override
	// public void init(IViewSite site) throws PartInitException {
	// super.init(site);
	// DebugUITools.getDebugContextManager()
	// .getContextService(site.getWorkbenchWindow())
	// .addDebugContextListener(this);
	// }
	//
	// @Override
	// public void createPartControl(Composite parent) {
	// parent.setLayout(new GridLayout(1, true));
	// createEventViewer(parent);
	// createVariableViewer(parent);
	// }
	//
	// private void createVariableViewer(Composite parent) {
	// variableViewer = createTableViewer(parent);
	// createScopeSlotColumns(variableViewer);
	// setVariableViewerInput();
	// }
	//
	// private void createEventViewer(Composite parent) {
	// eventViewer = createTableViewer(parent);
	// createScopeSlotColumns(eventViewer);
	// createColumn(eventViewer, "raise", 50, 3);
	// setEventViewerInput();
	// }
	//
	// private TableViewer createTableViewer(Composite parent) {
	// TableViewer viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
	// | SWT.V_SCROLL | SWT.FULL_SELECTION);
	// viewer.getTable().setLinesVisible(true);
	// viewer.getTable().setHeaderVisible(true);
	// GridDataFactory.fillDefaults().grab(true, true)
	// .applyTo(viewer.getTable());
	// viewer.setContentProvider(new ArrayContentProvider());
	// return viewer;
	// }
	//
	// private TableViewerColumn createColumn(TableViewer viewer, String text,
	// int width, int index) {
	// TableViewerColumn column = new TableViewerColumn(viewer, SWT.NONE);
	// column.getColumn().setText(text);
	// column.getColumn().setWidth(width);
	// column.getColumn().setResizable(true);
	// column.getColumn().setMoveable(true);
	// column.setLabelProvider(new ScopeSlotLabelProvider(index));
	// return column;
	// }
	//
	// private void createScopeSlotColumns(TableViewer viewer) {
	// // createColumn(viewer, "name", 80, 0);
	// // createColumn(viewer, "type", 80, 1);
	// // TableViewerColumn valueColumn = createColumn(viewer, "value", 80, 2);
	// // valueColumn.setEditingSupport(new MultiEditingSupport(viewer,
	// // new BooleanEditingSupport(viewer, this),
	// // new IntegerEditingSupport(viewer, this),
	// // new RealEditingSupport(viewer, this)));
	// }
	//
	// @Override
	// public void setFocus() {
	// eventViewer.getTable().setFocus();
	// }
	//
	// public void setEventViewerInput() {
	// // if (activeSession != null) {
	// // List<ExecutionEvent> events = activeSession.getExecutionContext()
	// // .getDeclaredEvents();
	// //
	// // eventViewer.setInput(events);
	// //
	// // TableItem[] items = eventViewer.getTable().getItems();
	// // for (TableItem tableItem : items) {
	// // final TableEditor tableEditor = new TableEditor(
	// // eventViewer.getTable());
	// // tableEditor.horizontalAlignment = SWT.LEFT;
	// // tableEditor.grabHorizontal = true;
	// // tableEditor.grabVertical = true;
	// // Button button = new Button(eventViewer.getTable(), SWT.FLAT);
	// // button.setText("raise");
	// // ButtonListener listener = new ButtonListener(
	// // tableItem.getText());
	// // button.addSelectionListener(listener);
	// // tableEditor.setEditor(button, tableItem, 3);
	// // tableEditors.put(button, tableEditor);
	// // controls.put(button, listener);
	// // }
	// // }
	// }
	//
	// private void setVariableViewerInput() {
	// // if (activeSession != null) {
	// // List<ExecutionVariable> variables = activeSession
	// // .getExecutionContext().getVariables();
	// // variableViewer.setInput(variables);
	// // }
	// }
	//
	// public void clearViewerInput(boolean disposeControls) {
	// // clear the viewer input. This has to be done before the Buttons are
	// // disposed. Otherwise listeners the TableViewer adds to Buttons can't
	// // be removed from them what leads to a memory leak.
	// eventViewer.setInput(null);
	// eventViewer.refresh();
	// variableViewer.setInput(null);
	// eventViewer.refresh();
	//
	// for (Control control : controls.keySet()) {
	// if (control instanceof Button) {
	// // Listeners have to be removed manually otherwise the garbage
	// // collector can't cleanup the button
	// if (controls.get(control) != null) {
	// ((Button) control).removeSelectionListener(controls
	// .get(control));
	// }
	// // Same for the tableEditor
	// if (tableEditors.get(control) != null) {
	// tableEditors.get(control).dispose();
	// }
	// }
	// if (disposeControls) {
	// control.dispose();
	// }
	// }
	// // if the controls are disposed they are never used again and should not
	// // use memory anymore.
	// controls.clear();
	// tableEditors.clear();
	// }
	//
	// // @Override
	// // public void dispose() {
	// // clearViewerInput(false);
	// // super.dispose();
	// // }
	//
	// private final class ButtonListener implements SelectionListener {
	//
	// private final String eventName;
	//
	// public ButtonListener(String eventName) {
	// this.eventName = eventName;
	// }
	//
	// public void widgetSelected(SelectionEvent e) {
	// // if (activeSession != null) {
	// // activeSession.raiseEvent(new ExecutionEvent(eventName));
	// // }
	// }
	//
	// public void widgetDefaultSelected(SelectionEvent e) {
	// // Nothing to do
	// }
	//
	// }
	//
	// public void debugContextChanged(DebugContextEvent event) {
	// // StructuredSelection strSel = (StructuredSelection) event.getContext();
	// // PlatformObject firstElement = (PlatformObject)
	// strSel.getFirstElement();
	// // if (firstElement == null) {
	// // return;
	// // }
	// // SimulationSession selectedSession = (SimulationSession) firstElement
	// // .getAdapter(SimulationSession.class);
	// // if (selectedSession == null
	// // || selectedSession.getCurrentState() == SimulationState.TERMINATED) {
	// // activeSession = selectedSession;
	// // clearViewerInput(true);
	// // }
	// // if (!(selectedSession == activeSession) && selectedSession != null) {
	// // if (activeSession != null) {
	// // activeSession.removeSimulationListener(this);
	// // activeSession.getExecutionContext()
	// // .removeExecutionContextListener(this);
	// // }
	// // activeSession = selectedSession;
	// // selectedSession.addSimulationListener(this);
	// // selectedSession.getExecutionContext().addExecutionContextListener(
	// // this);
	// // clearViewerInput(true);
	// // setEventViewerInput();
	// // setVariableViewerInput();
	// // }
	// }
	// //
	// // public SimulationSession getActiveSession() {
	// // return activeSession;
	// // }
	// //
	// // public void simulationStateChanged(SimulationState oldState,
	// // SimulationState newState) {
	// // switch (newState) {
	// // case STARTED:
	// // Display.getDefault().asyncExec(new Runnable() {
	// // public void run() {
	// // setEventViewerInput();
	// // setVariableViewerInput();
	// // }
	// // });
	// // break;
	// // case TERMINATED:
	// // Display.getDefault().asyncExec(new Runnable() {
	// // public void run() {
	// // clearViewerInput(true);
	// // }
	// // });
	// // ;
	// // break;
	// // }
	// // }
	//
	// public void variableDeclared(ExecutionVariable variable) {
	// // Nothing to do
	// }
	//
	// public void eventDeclared(ExecutionEvent event) {
	// // Nothing to do
	// }
	//
	// public void eventRaised(ExecutionEvent event) {
	// Display.getDefault().asyncExec(new Runnable() {
	// public void run() {
	// setEventViewerInput();
	// }
	// });
	// }
	//
	// public void variableValueChanged(ExecutionVariable variable) {
	// Display.getDefault().asyncExec(new Runnable() {
	// public void run() {
	// setVariableViewerInput();
	// }
	// });
	// }
}
