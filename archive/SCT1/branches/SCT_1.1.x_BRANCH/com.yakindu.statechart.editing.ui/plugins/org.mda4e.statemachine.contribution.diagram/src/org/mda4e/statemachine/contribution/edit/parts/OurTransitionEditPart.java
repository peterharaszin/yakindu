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
package org.mda4e.statemachine.contribution.edit.parts;


import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.mda4e.statemachine.contribution.commands.CmdSetTransitionDefault;
import org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorPlugin;
import org.mda4e.statemachine.contribution.tools.Constants;

import statemachine.diagram.edit.parts.TransitionEditPart;

public class OurTransitionEditPart extends TransitionEditPart {
	

//	private String expressionEditorID="mda4e.statemachine.expressions.dsl.editor.StatemachineExpressionsEditor";
//	private String expression;
	//private XTextStorageEditorInput xTextInput;
	//private AbstractXtextEditor expressionEditor;
	private IPreferenceStore store;
	private IPropertyChangeListener propertyChangeListener;
	
	public OurTransitionEditPart(View view) {
		super(view);
		//xTextInput=new XTextStorageEditorInput(getTransition());
		store = OurStatemachineDiagramEditorPlugin.getInstance().getPreferenceStore();
		propertyChangeListener = getPropertyChangeListener();
	}
	
	public void activate() {
		if (!isActive()) {
			super.activate();
			store.addPropertyChangeListener(propertyChangeListener);
		}
	}

	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			store.removePropertyChangeListener(propertyChangeListener);
		}
	}
	/*
	public void performRequest(Request request){
		//System.out.println("OurTransitionEditPart.performRequest "+request.getType().toString());
		if (request.getType() == RequestConstants.REQ_OPEN) {			
			openXTextEdior();
			/*ExpressionEditWindow shell = new ExpressionEditWindow(null,getTransition().getExpression());
			shell.addEventListener(getEventListener());
			shell.setBlockOnOpen(true);
			shell.open();*/
			/*
		}
		else super.performRequest(request);
	}*/
	
	private IPropertyChangeListener getPropertyChangeListener(){
		return new IPropertyChangeListener(){

			public void propertyChange(PropertyChangeEvent event) {
				if (event.getProperty().equals(Constants.P_TRANSITION_LINE_WIDTH) ||
					event.getProperty().equals(Constants.P_TRANSITION_COLOR) ||
					event.getProperty().equals(Constants.P_TRANSITION_SMOTHNESS)) {
					try {
						OperationHistoryFactory.getOperationHistory().execute(new CmdSetTransitionDefault(getEditingDomain(),"set color",OurTransitionEditPart.this),null,OurTransitionEditPart.this);
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
				}
			}
		};
	}
	/*
	private void openXTextEdior(){
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		try {
			page.openEditor(xTextInput, expressionEditorID, true);
			expressionEditor = (AbstractXtextEditor)page.getActiveEditor(); 
			expressionEditor.getDocumentProvider().addElementStateListener(getElementStateListener());
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*
	private IElementStateListener getElementStateListener(){
		return new IElementStateListener(){

			public void elementContentAboutToBeReplaced(Object arg0) {
				//System.out.println("elementContentAboutToBeReplaced "+arg0);
				
			}

			public void elementContentReplaced(Object arg0) {
				//System.out.println("elementContentReplaced "+arg0);
				
			}

			public void elementDeleted(Object arg0) {
				//System.out.println("elementDeleted "+arg0);
				
			}

			public void elementDirtyStateChanged(Object editorInput, boolean isDirty) {
				if (!isDirty) {
					expression = expressionEditor.getDocumentProvider().getDocument(editorInput).get();
					try {
						OperationHistoryFactory.getOperationHistory().execute(
								new AbstractTransactionalCommand(getEditingDomain(),"Expression change",null) {
									
									protected CommandResult doExecuteWithResult(
											IProgressMonitor arg0, IAdaptable arg1)
											throws ExecutionException {				
										getTransition().setExpression(expression);
										return null;
									}
								},null,null);
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
					expressionEditor.close(false);
				}
			}

			public void elementMoved(Object arg0, Object arg1) {
				//System.out.println("elementMoved "+arg0);
				
			}			
		};
	}*/
	
	/*
	private IEventListener getEventListener() {
		return new IEventListener(){
			private String expression;
			public void performEvent(IEvent event) {
				expression=((String)event.getData()).toString();
				//System.out.println("Event "+event.getType());
				if (event.getType() == EventConstants.EV_EXPRESSION){
					//System.out.println(((String)event.getData()).toString());
					try {
						OperationHistoryFactory.getOperationHistory().execute(
								new AbstractTransactionalCommand(getEditingDomain(),"Expression change",null) {
									protected CommandResult doExecuteWithResult(
											IProgressMonitor arg0, IAdaptable arg1)
											throws ExecutionException {
										
										getTransition().setExpression(expression);
										
										return null;
									}
							
								},null,null);
					} catch (ExecutionException e) {
						e.printStackTrace();
					}
					
					Composite window=(Composite) event.getSource();
					window.dispose();
				}
			}
		};
	}*/
	
//	private Transition getTransition(){
//		return (Transition) resolveSemanticElement();
//	}
	
	protected Connection createConnectionFigure() {
		return new OurTransitionFigure();
	}
	
	public class OurTransitionFigure extends TransitionFigure {
				
		private PolygonDecoration df=null;
		
		public OurTransitionFigure(){
			super();
			setLineWidth(store.getInt(Constants.P_TRANSITION_LINE_WIDTH));
			setBackgroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_TRANSITION_COLOR)));
			setForegroundColor(new Color(null,PreferenceConverter.getColor(store, Constants.P_TRANSITION_COLOR)));
			setSmoothness(SMOOTH_NORMAL);
			setTargetDecoration(createTargetDecoration());
			//setSmoothness(store.getInt(Constants.P_TRANSITION_SMOTHNESS));
		}
		
		private RotatableDecoration createTargetDecoration() {
			if (df==null) { 
				df = new PolygonDecoration();
			}
			return df;
		}
		
		public void setLineWidth(int w){
			if (df==null){
				createTargetDecoration();
			}
			df.setLineWidth(w);
			int wMapped = getMapMode().DPtoLP(w);
			if (w>1)
				df.setScale(4*wMapped, 1.0*wMapped);
			else
				df.setScale(8*wMapped, 2*wMapped);
			
			super.setLineWidth(w);
		}
	}
}