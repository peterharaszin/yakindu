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
package org.mda4e.statemachine.contribution.views;


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.DrillDownAdapter;
import org.eclipse.ui.part.ViewPart;
import org.mda4e.statemachine.contribution.actions.CreateEventAction;
import org.mda4e.statemachine.contribution.actions.CreateVariableAction;
import org.mda4e.statemachine.contribution.actions.DeleteDataElementAction;
import org.mda4e.statemachine.contribution.actions.SetupDataElementAction;
import org.mda4e.statemachine.contribution.model.TreeObject;
import org.mda4e.statemachine.contribution.model.TreeParent;
import org.mda4e.statemachine.contribution.tools.StaticMethods;

import statemachine.Event;
import statemachine.Statechart;
import statemachine.Variable;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class DataElementExplorer extends ViewPart implements Adapter, ISelectionListener {
	private TreeViewer viewer;
	private StatemachineDiagramEditor newEditor=null;
	private DrillDownAdapter drillDownAdapter;
	private Action createVariableAction;
	private Action createEventAction;
	private Action setupDataElementAction;
	private TreeParent variablesRoot, eventsRoot;
	
	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class ViewContentProvider implements IStructuredContentProvider, 
										   ITreeContentProvider {
		private TreeParent invisibleRoot;

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot==null) initialize();
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}
		public Object getParent(Object child) {
			if (child instanceof TreeObject) {
				return ((TreeObject)child).getParent();
			}
			return null;
		}
		public Object [] getChildren(Object parent) {
			if (parent instanceof TreeParent) {
				return ((TreeParent)parent).getChildren();
				
			}
			return new Object[0];
		}
		public boolean hasChildren(Object parent) {
			if (parent instanceof TreeParent)
				return ((TreeParent)parent).hasChildren();
			return false;
		}
		
/*
 * We will set up a model to initialize tree hierarchy.
 * In a real code, you will connect to a real model and
 * expose its hierarchy.
 */
		private void initialize() {
			variablesRoot = new TreeParent("Variables");
			eventsRoot = new TreeParent("Events");
			Statechart statechart = getNewStatechart();
			if (statechart!=null) {
				
				for (int i=0;i<getNewStatechart().getDataElement().size();i++) {
					
					if (statechart.getDataElement().get(i) instanceof Variable) {
						Variable variable = (Variable)statechart.getDataElement().get(i);
						//var.eAdapters().add(this);
						String viewedName = variable.getName()+" ("+variable.getIoType().getLiteral()+", "+variable.getDataType().getLiteral()+", "+variable.getPort()+")";
						TreeObject treeObject = new TreeObject(viewedName);
						treeObject.setObject(variable);
						variable.eAdapters().add(DataElementExplorer.this);
						variablesRoot.addChild(treeObject);
					}
					else if (statechart.getDataElement().get(i) instanceof Event) {
						Event event = (Event)statechart.getDataElement().get(i);
						//event.eAdapters().add(this);
						String viewedName = event.getName()+" ("+event.getIoType().getLiteral()+", "+event.getTrigger().getLiteral()+", "+event.getPort()+")";
						TreeObject treeObject = new TreeObject(viewedName);
						treeObject.setObject(event);
						event.eAdapters().add(DataElementExplorer.this);
						eventsRoot.addChild(treeObject);
					}	
				}
			}
			
			/*TreeParent dataElements = new TreeParent("Data Elements");
			dataElements.addChild(eventsRoot);
			dataElements.addChild(variablesRoot);*/
			
			invisibleRoot = new TreeParent("");
			invisibleRoot.addChild(eventsRoot);
			invisibleRoot.addChild(variablesRoot);
		}
		
		public void editorChanged() {
			this.initialize();
		}
	}
	
	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}
		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof TreeParent)
			   imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
		}
	}
	
	class NameSorter extends ViewerSorter {
	}
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		newEditor=StaticMethods.getStateEditor();
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		drillDownAdapter = new DrillDownAdapter(viewer);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		getSite().setSelectionProvider(viewer);
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().addSelectionListener(this);
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		if (newEditor!=null) hookIntoModel();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				DataElementExplorer.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(createVariableAction);
		manager.add(new Separator());
		manager.add(createEventAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(createVariableAction);
		manager.add(createEventAction);
		manager.add(new Separator());
		manager.add(new DeleteDataElementAction(viewer));
		drillDownAdapter.addNavigationActions(manager);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(createVariableAction);
		manager.add(createEventAction);
		manager.add(new Separator());
		drillDownAdapter.addNavigationActions(manager);
	}

	private void makeActions() {
		createVariableAction = new CreateVariableAction();
		createEventAction = new CreateEventAction();
		setupDataElementAction = new SetupDataElementAction(viewer);
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				if (setupDataElementAction.isEnabled()) {
					setupDataElementAction.run();
					viewer.refresh();
				}
			}
		});
	}
	/*
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Sample View",
			message);
	}*/
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object arg0) {
		return false;
	}

	public void setTarget(Notifier arg0) {
		
	}
	
	//react to EMF model changes:
	public void notifyChanged(Notification notification) {
		//System.out.println("SampleView.notifyChanged(): "+notification);
		switch (notification.getEventType()){
		case Notification.ADD:{
			if (notification.getNewValue() instanceof Variable) {
				Variable variable = (Variable) notification.getNewValue();
				String viewedName = variable.getName()+" ("+variable.getIoType().getLiteral()+", "+variable.getDataType().getLiteral()+", "+variable.getPort()+")";
				TreeObject treeObject = new TreeObject(viewedName);
				treeObject.setObject(variable);
				variablesRoot.addChild(treeObject);
				viewer.refresh();
			}
			else if (notification.getNewValue() instanceof Event) {
				Event event = (Event) notification.getNewValue();
				String viewedName = event.getName()+" ("+event.getIoType().getLiteral()+", "+event.getTrigger().getLiteral()+", "+event.getPort()+")";
				TreeObject treeObject = new TreeObject(viewedName);
				treeObject.setObject(event);
				eventsRoot.addChild(treeObject);
				viewer.refresh();
			}
			break;
		}
		case Notification.REMOVE:{
			if (notification.getOldValue() instanceof Variable){
				TreeObject selectedObject=null;
				Variable variable = (Variable) notification.getOldValue();
				variable.eAdapters().remove(this);
				for (int i=0;i<variablesRoot.getChildren().length;i++){
					if (variablesRoot.getChildren()[i].getBaseName().equals(variable.getName()))
						selectedObject=variablesRoot.getChildren()[i];
				}
				variablesRoot.removeChild(selectedObject);
				viewer.refresh();
			}
			else if (notification.getOldValue() instanceof Event){
				TreeObject selectedObject=null;
				Event event = (Event) notification.getOldValue();
				event.eAdapters().remove(this);
				for (int i=0;i<eventsRoot.getChildren().length;i++){
					if (eventsRoot.getChildren()[i].getBaseName().equals(event.getName()))
						selectedObject=eventsRoot.getChildren()[i];
				}
				eventsRoot.removeChild(selectedObject);
				viewer.refresh();
			}
			break;
		}
		case Notification.SET:{
			if (notification.getNotifier() instanceof Event ||
					notification.getNotifier() instanceof Event){
				viewer.refresh();
				break;
			}
		}
		}//End-Switch
	}
	
	private void hookIntoModel(){
		if (getNewStatechart()!=null && !getNewStatechart().eAdapters().contains(this))
			getNewStatechart().eAdapters().add(this);
	}

	private Statechart getNewStatechart(){
		if (newEditor!=null)
			return (Statechart)newEditor.getDiagramEditPart().resolveSemanticElement();
		return null;
	}
	
	//react to Eclipse UI changes:
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (part instanceof StatemachineDiagramEditor && !(part.equals(newEditor))) {
			newEditor=(StatemachineDiagramEditor) part;
			ViewContentProvider myViewer = (ViewContentProvider) viewer.getContentProvider();
			if (myViewer!=null)
				myViewer.editorChanged();
			hookIntoModel();
			viewer.refresh();
		}
	}
}