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
package com.yakindu.statemachine.control.highlight.misc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import statemachine.State;
import statemachine.Statechart;
import statemachine.Transition;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.part.StatemachineDiagramEditor;

public class StaticMethods {
	public static Statechart getStatechart(){
		
		if (PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()!=null) {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if (page.getActiveEditor() instanceof StatemachineDiagramEditor) {
				StatemachineDiagramEditor editor = (StatemachineDiagramEditor)page.getActiveEditor();
				DiagramEditPart diagramEditPart = editor.getDiagramEditPart();
				return (Statechart) diagramEditPart.resolveSemanticElement();
			}
		}
		return null;
	}
	
	public static List<StatemachineDiagramEditor> getStateEditors(){
		IWorkbenchWindow window = PlatformUI.getWorkbench().getWorkbenchWindows()[0];
		LinkedList<StatemachineDiagramEditor> result = new LinkedList<StatemachineDiagramEditor>();
		if (window!=null) {
			for (IWorkbenchPage page : window.getPages()){
				//IWorkbenchPage page = getSite().getPage();
				for (IEditorReference editorRef: page.getEditorReferences()) {
					IEditorPart editor = editorRef.getEditor(false);
					if (editor instanceof StatemachineDiagramEditor) 
						result.add((StatemachineDiagramEditor)editor);
				}
			}
		}
		return result;
	}
	/*
	public static IProject getCurrentProject(){
		IEditorPart editor = getStateEditor();
		IEditorInput input =  editor.getEditorInput();
		IFile file = null;
		if(input instanceof IFileEditorInput){
			file = ((IFileEditorInput)input).getFile();
		}
		if(file==null)
			return null;
		IProject project = file.getProject();
		return project;
	}*/
	
	/**
	 * @param editPartList
	 * @param id
	 * @return
	 * 
	 * Diese Methode sucht �ber die EditParts des Editors nach dem State mit der
	 * �bergebenen ID. Wenn der State gefunden wurde gibt die Funktion den zugeh�rigen
	 * Editpart zur�ck.
	 */
	/*
	public static StateEditPart searchState(List editPartList,int id){
		StateEditPart ret=null;
		ShapeNodeEditPart actualRegion=null;
		ShapeCompartmentEditPart regionCompartment=null;
		ShapeCompartmentEditPart selectedstateCompartment=null;
		StateEditPart selectedState=null;
		statemachine.State selectedStateImpl=null;
		int regionIndex=0;
		while (ret==null && regionIndex<editPartList.size()){
			if (editPartList.get(regionIndex) instanceof ShapeNodeEditPart) {
				actualRegion = (ShapeNodeEditPart) editPartList.get(regionIndex);
				regionCompartment=(ShapeCompartmentEditPart)actualRegion.getChildren().get(1);
				
				//Innerhalb eines RegionCompartment alle Elemente (States und Pseudostates)nach passender ID durchsuchen
				int CompIndex=0;
				while (ret==null && CompIndex<regionCompartment.getChildren().size()){
					//Nur States sind interessant; Pseudostates nicht
					if (regionCompartment.getChildren().get(CompIndex) instanceof StateEditPart) {
						selectedState = (StateEditPart)regionCompartment.getChildren().get(CompIndex);
						selectedstateCompartment = (ShapeCompartmentEditPart) selectedState.getChildren().get(4);
						selectedStateImpl = (statemachine.State) selectedState.resolveSemanticElement();
						
						//Wenn gefunden, Element als R�ckgabewert ansonsten pr�fen, ob der State weitere Regions hat -> Funktionsaufruf searchElementInState(...)
						if (selectedStateImpl.getId()==id)
							return selectedState;
						else if ((ret == null) && (selectedstateCompartment.getChildren() != null))
							ret = searchState(selectedstateCompartment.getChildren(),id);
					}
					CompIndex++;
				}//End For-Schleife f�r States
			} //End If-Verzweigung f�r ShapeCompartmentEditParts (Regions)		
			regionIndex++;
		}//End while-Schleife f�r Regions
		return ret;
	}
	/*	
	public static List <StateEditPart> searchStates(List editPartList, List <String> stateIDList){
		List <StateEditPart> ret = new ArrayList<StateEditPart>();
		ShapeNodeEditPart actualRegion=null;
		ShapeCompartmentEditPart regionCompartment=null;
		ShapeCompartmentEditPart selectedstateCompartment=null;
		StateEditPart selectedState=null;
		statemachine.State selectedStateImpl=null;
		for (int regionIndex=0;regionIndex<editPartList.size();regionIndex++){
			if (editPartList.get(regionIndex) instanceof ShapeNodeEditPart) {
				actualRegion = (ShapeNodeEditPart) editPartList.get(regionIndex);
				regionCompartment=(ShapeCompartmentEditPart)actualRegion.getChildren().get(1);
				
				//Innerhalb eines RegionCompartment alle Elemente (States und Pseudostates)nach passender ID durchsuchen
				for (int CompIndex=0;CompIndex<regionCompartment.getChildren().size();CompIndex++){
					//Nur States sind interessant; Pseudostates nicht
					if (regionCompartment.getChildren().get(CompIndex) instanceof StateEditPart) {
						selectedState = (StateEditPart)regionCompartment.getChildren().get(CompIndex);
						selectedstateCompartment = (ShapeCompartmentEditPart) selectedState.getChildren().get(4);
						selectedStateImpl = (statemachine.State) selectedState.resolveSemanticElement();
						
						//Wenn gefunden, Element als R�ckgabewert ansonsten pr�fen, ob der State weitere Regions hat -> Funktionsaufruf searchElementInState(...)
						boolean foundState=false;
						int i=0;
						while (!foundState && i<stateIDList.size()) {
							int id=Integer.valueOf((String)stateIDList.get(i));
							if (selectedStateImpl.getId()==id) {
								ret.add(selectedState);
								foundState=true;
							}
							i++;
						}
						if ((selectedstateCompartment.getChildren() != null))
							ret.addAll(searchStates(selectedstateCompartment.getChildren(),stateIDList));
					}
				}
			} //End If-Verzweigung f�r ShapeCompartmentEditParts (Regions)
		}
		return ret;
	}
	*/
    public static List <StateEditPart> getAllStateEditParts(List<EditPart> editPartList) {
		List <StateEditPart> ret = new ArrayList<StateEditPart>();
		ShapeNodeEditPart actualRegion=null;
		ShapeCompartmentEditPart regionCompartment=null;
		ShapeCompartmentEditPart selectedstateCompartment=null;
		StateEditPart selectedState=null;
		//statemachine.State selectedStateImpl=null;
		for (int regionIndex=0;regionIndex<editPartList.size();regionIndex++){
			if (editPartList.get(regionIndex) instanceof ShapeNodeEditPart) {
				actualRegion = (ShapeNodeEditPart) editPartList.get(regionIndex);
				regionCompartment=(ShapeCompartmentEditPart)actualRegion.getChildren().get(1);
				
				//Innerhalb eines RegionCompartment alle Elemente (States und Pseudostates)nach passender ID durchsuchen
				for (int CompIndex=0;CompIndex<regionCompartment.getChildren().size();CompIndex++){
					
					//Nur States sind interessant; Pseudostates nicht
					if (regionCompartment.getChildren().get(CompIndex) instanceof StateEditPart) {
					
						selectedState = (StateEditPart)regionCompartment.getChildren().get(CompIndex);
						
						if(selectedState.getChildren().size() > 4) {
						
							selectedstateCompartment = (ShapeCompartmentEditPart) selectedState.getChildren().get(4);
							//selectedStateImpl = (statemachine.State) selectedState.resolveSemanticElement();
							ret.add(selectedState);
							if ((selectedstateCompartment.getChildren() != null)) {
						        @SuppressWarnings("unchecked") // Because description under @see org.eclipse.gef.EditPart#getChildren()
						        List<EditPart> editParts = (List<EditPart>)selectedstateCompartment.getChildren();
				                ret.addAll(getAllStateEditParts(editParts));
				        	}
						}
					}
				}
			} //End If-Verzweigung f�r ShapeCompartmentEditParts (Regions)
		}
		return ret;
	}
	
	//searches the State with the given ID. Requires ordered List.
	public static StateEditPart searchStateNew(List <StateEditPart> editPartList,int id) {
		State state = null;
		/*int index = 0;
		int indexOld = 0;
		indexOld = index;
		index = allStateEditParts.size() / 2;
		
		do {
			state = (State) allStateEditParts.get(index).resolveSemanticElement();
			if (state.getId()==id)
				return allStateEditParts.get(index);
			indexOld=index;
			if (state.getId()<id)
				index -= (index / 2);
			else if (state.getId()>id)
				index += (index / 2);
				
		} while (indexOld!=index);
		*/
		//Naive solution for unsorted List;
		if (editPartList!=null)
			for (int index=0;index<editPartList.size();index++) {
				state = (State) editPartList.get(index).resolveSemanticElement();
				if (state.getId()==id) return editPartList.get(index);
			}
		return null;
	}
	/*
	public static List <StateEditPart> searchStatesNew(List  <StateEditPart> editPartList, List <Integer> stateIDList){
		List <StateEditPart> ret = new ArrayList<StateEditPart>();
		if (editPartList!=null)
			for (int index=0;index<stateIDList.size();index++){
				StateEditPart state = null;
				state = searchStateNew(editPartList,stateIDList.get(index).intValue());
				if (state!=null) {
					ret.add(state);
				}
			}
		return ret;
	}
	/*
	public static TransitionEditPart searchTransition(List editPartList,int id){
		TransitionEditPart ret=null;
		ShapeNodeEditPart actualRegion=null;
		ShapeCompartmentEditPart regionCompartment=null;
		TransitionEditPart selectedTransition=null;
		statemachine.Transition selectedTransitionImpl=null;
		
		int regionIndex=0;
		while (ret==null && regionIndex<editPartList.size()){
			if (editPartList.get(regionIndex) instanceof ShapeNodeEditPart) {
				actualRegion = (ShapeNodeEditPart) editPartList.get(regionIndex);
				regionCompartment=(ShapeCompartmentEditPart)actualRegion.getChildren().get(1);
				
				//Innerhalb eines RegionCompartment alle Elemente (States und Pseudostates)nach passender ID durchsuchen
				int CompIndex=0;
				while (ret==null && CompIndex<regionCompartment.getChildren().size()){
					//Nur Transitionen sind interessant
					if (regionCompartment.getChildren().get(CompIndex) instanceof ShapeNodeEditPart) {
						ShapeNodeEditPart selectedShape = (ShapeNodeEditPart)regionCompartment.getChildren().get(CompIndex);
						for (int tranIndex=0; tranIndex<selectedShape.getSourceConnections().size();tranIndex++){
							selectedTransition = (TransitionEditPart)selectedShape.getSourceConnections().get(tranIndex);
							selectedTransitionImpl = (statemachine.Transition) selectedTransition.resolveSemanticElement();
							
							//Wenn gefunden Transition als R�ckgabewert andernfalls Statecompartment nach weiteren Transitionen durchsuchen
							if (selectedTransitionImpl.getId()==id)
								return selectedTransition; 
						}
						if ((ret==null) && (regionCompartment.getChildren().get(CompIndex) instanceof StateEditPart)) {
							StateEditPart selectedState= (StateEditPart) regionCompartment.getChildren().get(CompIndex);
							ShapeCompartmentEditPart stateCompartment=(ShapeCompartmentEditPart) selectedState.getChildren().get(4);
							
							if (stateCompartment.getChildren().size()>0) ret = searchTransition(stateCompartment.getChildren(),id);
						}
					}
					CompIndex++;
				}//End For-Schleife f�r Shapes
				
			}//End If-Verzweigung f�r RegionEditParts
			regionIndex++;	
		}//End For-Schleife f�r Regions
		return ret;
	}*/
	
	public static List <TransitionEditPart> getAllTransitions(List<EditPart> editPartList){
		
		List <TransitionEditPart> ret = new ArrayList<TransitionEditPart>();
		ShapeNodeEditPart actualRegion=null;
		ShapeCompartmentEditPart regionCompartment=null;
		
		for (int regionIndex=0;regionIndex<editPartList.size();regionIndex++){
			if (editPartList.get(regionIndex) instanceof ShapeNodeEditPart) {
				actualRegion = (ShapeNodeEditPart) editPartList.get(regionIndex);
				regionCompartment=(ShapeCompartmentEditPart)actualRegion.getChildren().get(1);
				
				//Innerhalb eines RegionCompartment alle Elemente (States und Pseudostates)nach passender ID durchsuchen
				for (int CompIndex=0;CompIndex<regionCompartment.getChildren().size();CompIndex++) {
					//Nur Transitionen sind interessant
					if (regionCompartment.getChildren().get(CompIndex) instanceof ShapeNodeEditPart) {
						ShapeNodeEditPart selectedShape = (ShapeNodeEditPart)regionCompartment.getChildren().get(CompIndex);
						for (int tranIndex=0; tranIndex<selectedShape.getSourceConnections().size();tranIndex++)
							if (selectedShape.getSourceConnections().get(tranIndex) instanceof TransitionEditPart)
								ret.add((TransitionEditPart)selectedShape.getSourceConnections().get(tranIndex));
						
						if (regionCompartment.getChildren().get(CompIndex) instanceof StateEditPart) {
							StateEditPart selectedState= (StateEditPart) regionCompartment.getChildren().get(CompIndex);
							ShapeCompartmentEditPart stateCompartment=(ShapeCompartmentEditPart) selectedState.getChildren().get(4);
							
							if (stateCompartment.getChildren().size()>0) {
							    @SuppressWarnings("unchecked") // Because description under @see org.eclipse.gef.EditPart#getChildren()
	                                                        List<EditPart> editParts = (List<EditPart>)stateCompartment.getChildren();
                                                            ret.addAll(getAllTransitions(editParts));	                                                        
							}
						}
					}
				}
			}//End For-Schleife f�r Shapes	
		}//End For-Schleife f�r Regions
		return ret;
	}
	
	public static TransitionEditPart searchTransitionNew(List <TransitionEditPart> transitionEditPartList,int id){
		Transition transition = null;

		//Naive solution for unsorted List;
		if (transitionEditPartList!=null)
			for (int index=0;index<transitionEditPartList.size();index++) {
				transition = (Transition) transitionEditPartList.get(index).resolveSemanticElement();
				if (transition.getId()==id) return transitionEditPartList.get(index);
			}
		return null;
	}
	
	public static List <TransitionEditPart> searchTransitionsNew(List <TransitionEditPart> editPartList, List <String> stateIDList){
		List <TransitionEditPart> ret = new ArrayList<TransitionEditPart>();
		if (editPartList!=null)
			for (int index=0;index<stateIDList.size();index++){
				TransitionEditPart state = null;
				state = searchTransitionNew(editPartList,Integer.valueOf(stateIDList.get(index)));
				if (state!=null) {
					ret.add(state);
				}
			}
		return ret;
	}
	
	/*
	public static void setTransitionsVisibility(ShapeCompartmentEditPart regionCompartment, boolean visibility) {
		
		//Innerhalb eines RegionCompartment alle Transitionen von Elementen suchen und Visibility setzen.
		for (int CompIndex=0; CompIndex<regionCompartment.getChildren().size();CompIndex++){
			//Nur States sind interessant; Pseudostates nicht
			ShapeNodeEditPart node = (ShapeNodeEditPart) regionCompartment.getChildren().get(CompIndex);
			for (int i=0; i<node.getTargetConnections().size(); i++) 
				((TransitionEditPart)node.getTargetConnections().get(i)).getFigure().setVisible(visibility);
			for (int i=0; i<node.getSourceConnections().size(); i++) 
				((TransitionEditPart)node.getSourceConnections().get(i)).getFigure().setVisible(visibility);
			
			//Rekursiver Aufruf der Methode um auch Transitionen in tieferen Ebenen zu erreichen.
			if (node instanceof StateEditPart) {
				StateEditPart state = (StateEditPart) node;
				ShapeCompartmentEditPart stateCompartment = (ShapeCompartmentEditPart) state.getChildren().get(4);
				if (stateCompartment != null){
					for (int i=0;i<stateCompartment.getChildren().size();i++){
						ShapeNodeEditPart region = (ShapeNodeEditPart) stateCompartment.getChildren().get(i);
						setTransitionsVisibility((ShapeCompartmentEditPart)region.getChildren().get(1),visibility);
					}			
				}
			}
		}		
	}*/
	
	public static List <TransitionEditPart> getRegionTransitionsEditParts(ShapeCompartmentEditPart regionCompartment){
		List <TransitionEditPart>transitions=new ArrayList<TransitionEditPart>();
		//Innerhalb eines RegionCompartment alle Transitionen von Elementen suchen und Visibility setzen.
		for (int CompIndex=0; CompIndex<regionCompartment.getChildren().size();CompIndex++){
			//Nur States sind interessant; Pseudostates nicht
			ShapeNodeEditPart node = (ShapeNodeEditPart) regionCompartment.getChildren().get(CompIndex);
			for (int i=0; i<node.getTargetConnections().size(); i++) 
				if (!transitions.contains(node.getTargetConnections().get(i)))
					transitions.add((TransitionEditPart)node.getTargetConnections().get(i));
			for (int i=0; i<node.getSourceConnections().size(); i++) 
				if (!transitions.contains(node.getSourceConnections().get(i)))
					transitions.add((TransitionEditPart)node.getSourceConnections().get(i));
			
			//Rekursiver Aufruf der Methode um auch Transitionen in tieferen Ebenen zu erreichen.
			if (node instanceof StateEditPart) {
				StateEditPart state = (StateEditPart) node;
				ShapeCompartmentEditPart stateCompartment = (ShapeCompartmentEditPart) state.getChildren().get(4);
				if (stateCompartment != null){
					for (int i=0;i<stateCompartment.getChildren().size();i++){
						ShapeNodeEditPart region = (ShapeNodeEditPart) stateCompartment.getChildren().get(i);
						List<TransitionEditPart> temp = getRegionTransitionsEditParts((ShapeCompartmentEditPart)region.getChildren().get(1));
						for (int j=0;j<temp.size();j++)
							if (!transitions.contains(temp.get(j)))
								transitions.add(temp.get(j));
					}			
				}
			}
		}
		return transitions;
	}
	
	/**
	 * returns a List of getChildren of given EditPart with cast.
	 * @see org.eclipse.gef.EditPart#getChildren()
	 * @return
	 */
	@SuppressWarnings("unchecked")
        public static List<EditPart> getChildren(EditPart editPart){
	    return (List<EditPart>)editPart.getChildren();
	}
}
