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
package statemachine.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.Pseudostate;
import statemachine.Statechart;
import statemachine.StatemachinePackage;
import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.Region2EditPart;
import statemachine.diagram.edit.parts.RegionEditPart;
import statemachine.diagram.edit.parts.RegionPriority2EditPart;
import statemachine.diagram.edit.parts.RegionPriorityEditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartment2EditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartmentEditPart;
import statemachine.diagram.edit.parts.StateDoEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StateEntryEditPart;
import statemachine.diagram.edit.parts.StateExitEditPart;
import statemachine.diagram.edit.parts.StateNameEditPart;
import statemachine.diagram.edit.parts.StateStateCompartmentEditPart;
import statemachine.diagram.edit.parts.StatechartEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.edit.parts.TransitionExpressionEditPart;
import statemachine.diagram.edit.parts.TransitionPriorityEditPart;

/**
 * This registry is used to determine which type of visual object should be
 * created for the corresponding Diagram, Node, ChildNode or Link represented
 * by a domain model object.
 * 
 * @generated
 */
public class StatemachineVisualIDRegistry {

	/**
	 * @generated
	 */
	private static final String DEBUG_KEY = "org.mda4e.statemachine.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (StatechartEditPart.MODEL_ID.equals(view.getType())) {
				return StatechartEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return statemachine.diagram.part.StatemachineVisualIDRegistry
				.getVisualID(view.getType());
	}

	/**
	 * @generated
	 */
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	 * @generated
	 */
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(
					Platform.getDebugOption(DEBUG_KEY))) {
				StatemachineDiagramEditorPlugin.getInstance().logError(
						"Unable to parse view type as a visualID number: "
								+ type);
			}
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static String getType(int visualID) {
		return String.valueOf(visualID);
	}

	/**
	 * @generated
	 */
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (StatemachinePackage.eINSTANCE.getStatechart().isSuperTypeOf(
				domainElement.eClass())
				&& isDiagram((Statechart) domainElement)) {
			return StatechartEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * Author: Markus M�hlbrandt
	 * Bugfix to support enumerations
	 */
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = statemachine.diagram.part.StatemachineVisualIDRegistry
				.getModelID(containerView);
		if (!StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = statemachine.diagram.part.StatemachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StatechartEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case RegionRegionCompartmentEditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {

				Pseudostate pseudoState = (Pseudostate) domainElement;

				switch (pseudoState.getPseudoType()) {
				case INITIAL:
					return PseudostateEditPart.VISUAL_ID;
				case CHOICE:
					return Pseudostate2EditPart.VISUAL_ID;
				case DEEP_HISTORY:
					return Pseudostate3EditPart.VISUAL_ID;
				case SHALLOW_HISTORY:
					return Pseudostate4EditPart.VISUAL_ID;
				case JUNCTION:
					return Pseudostate5EditPart.VISUAL_ID;
				}
			}
			if (StatemachinePackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			break;
		case StateStateCompartmentEditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return Region2EditPart.VISUAL_ID;
			}
			break;
		case RegionRegionCompartment2EditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {

				Pseudostate pseudoState = (Pseudostate) domainElement;

				switch (pseudoState.getPseudoType()) {
				case INITIAL:
					return PseudostateEditPart.VISUAL_ID;
				case CHOICE:
					return Pseudostate2EditPart.VISUAL_ID;
				case DEEP_HISTORY:
					return Pseudostate3EditPart.VISUAL_ID;
				case SHALLOW_HISTORY:
					return Pseudostate4EditPart.VISUAL_ID;
				case JUNCTION:
					return Pseudostate5EditPart.VISUAL_ID;
				}
			}
			if (StatemachinePackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			break;
		case StatechartEditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return RegionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static int getNodeVisualIDGen(View containerView,
			EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = statemachine.diagram.part.StatemachineVisualIDRegistry
				.getModelID(containerView);
		if (!StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = statemachine.diagram.part.StatemachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StatechartEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case RegionRegionCompartmentEditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			break;
		case StateStateCompartmentEditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return Region2EditPart.VISUAL_ID;
			}
			break;
		case RegionRegionCompartment2EditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getState().isSuperTypeOf(
					domainElement.eClass())) {
				return StateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return PseudostateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getFinalState().isSuperTypeOf(
					domainElement.eClass())) {
				return FinalStateEditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate2EditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate3EditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate4EditPart.VISUAL_ID;
			}
			if (StatemachinePackage.eINSTANCE.getPseudostate().isSuperTypeOf(
					domainElement.eClass())) {
				return Pseudostate5EditPart.VISUAL_ID;
			}
			break;
		case StatechartEditPart.VISUAL_ID:
			if (StatemachinePackage.eINSTANCE.getRegion().isSuperTypeOf(
					domainElement.eClass())) {
				return RegionEditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	 * @generated
	 */
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = statemachine.diagram.part.StatemachineVisualIDRegistry
				.getModelID(containerView);
		if (!StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (StatechartEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = statemachine.diagram.part.StatemachineVisualIDRegistry
					.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = StatechartEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case RegionEditPart.VISUAL_ID:
			if (RegionPriorityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RegionRegionCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateEditPart.VISUAL_ID:
			if (StateNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateEntryEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateDoEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateExitEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (StateStateCompartmentEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Region2EditPart.VISUAL_ID:
			if (RegionPriority2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (RegionRegionCompartment2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionRegionCompartmentEditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StateStateCompartmentEditPart.VISUAL_ID:
			if (Region2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case RegionRegionCompartment2EditPart.VISUAL_ID:
			if (StateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (PseudostateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (FinalStateEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Pseudostate5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case StatechartEditPart.VISUAL_ID:
			if (RegionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case TransitionEditPart.VISUAL_ID:
			if (TransitionExpressionEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (TransitionPriorityEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	 * @generated
	 */
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (StatemachinePackage.eINSTANCE.getTransition().isSuperTypeOf(
				domainElement.eClass())) {
			return TransitionEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	 * User can change implementation of this method to handle some specific
	 * situations not covered by default logic.
	 * 
	 * @generated
	 */
	private static boolean isDiagram(Statechart element) {
		return true;
	}

}
