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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.FinalState;
import statemachine.Node;
import statemachine.Pseudostate;
import statemachine.Region;
import statemachine.State;
import statemachine.Statechart;
import statemachine.StatemachinePackage;
import statemachine.Transition;
import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.Region2EditPart;
import statemachine.diagram.edit.parts.RegionEditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartment2EditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartmentEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StateStateCompartmentEditPart;
import statemachine.diagram.edit.parts.StatechartEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.providers.StatemachineElementTypes;

/**
 * @generated
 */
public class StatemachineDiagramUpdater {

	/**
	 * @generated
	 */
	public static List getSemanticChildren(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case RegionRegionCompartmentEditPart.VISUAL_ID:
			return getRegionRegionCompartment_7001SemanticChildren(view);
		case StateStateCompartmentEditPart.VISUAL_ID:
			return getStateStateCompartment_7002SemanticChildren(view);
		case RegionRegionCompartment2EditPart.VISUAL_ID:
			return getRegionRegionCompartment_7003SemanticChildren(view);
		case StatechartEditPart.VISUAL_ID:
			return getStatechart_1000SemanticChildren(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegionRegionCompartment_7001SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Region modelElement = (Region) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getState().iterator(); it.hasNext();) {
			Node childElement = (Node) it.next();
			int visualID = StatemachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == PseudostateEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == FinalStateEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate2EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate3EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate4EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate5EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStateStateCompartment_7002SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		State modelElement = (State) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRegion().iterator(); it.hasNext();) {
			Region childElement = (Region) it.next();
			int visualID = StatemachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == Region2EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegionRegionCompartment_7003SemanticChildren(View view) {
		if (false == view.eContainer() instanceof View) {
			return Collections.EMPTY_LIST;
		}
		View containerView = (View) view.eContainer();
		if (!containerView.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Region modelElement = (Region) containerView.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getState().iterator(); it.hasNext();) {
			Node childElement = (Node) it.next();
			int visualID = StatemachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == StateEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == PseudostateEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == FinalStateEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate2EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate3EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate4EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
			if (visualID == Pseudostate5EditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getStatechart_1000SemanticChildren(View view) {
		if (!view.isSetElement()) {
			return Collections.EMPTY_LIST;
		}
		Statechart modelElement = (Statechart) view.getElement();
		List result = new LinkedList();
		for (Iterator it = modelElement.getRegion().iterator(); it.hasNext();) {
			Region childElement = (Region) it.next();
			int visualID = StatemachineVisualIDRegistry.getNodeVisualID(view,
					childElement);
			if (visualID == RegionEditPart.VISUAL_ID) {
				result.add(new StatemachineNodeDescriptor(childElement,
						visualID));
				continue;
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static List getContainedLinks(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StatechartEditPart.VISUAL_ID:
			return getStatechart_1000ContainedLinks(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001ContainedLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_3001ContainedLinks(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_3002ContainedLinks(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_3003ContainedLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3004ContainedLinks(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_3005ContainedLinks(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_3006ContainedLinks(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_3007ContainedLinks(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_3008ContainedLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001ContainedLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getIncomingLinks(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001IncomingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_3001IncomingLinks(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_3002IncomingLinks(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_3003IncomingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3004IncomingLinks(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_3005IncomingLinks(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_3006IncomingLinks(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_3007IncomingLinks(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_3008IncomingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001IncomingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getOutgoingLinks(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001OutgoingLinks(view);
		case StateEditPart.VISUAL_ID:
			return getState_3001OutgoingLinks(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_3002OutgoingLinks(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_3003OutgoingLinks(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3004OutgoingLinks(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_3005OutgoingLinks(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_3006OutgoingLinks(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_3007OutgoingLinks(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_3008OutgoingLinks(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001OutgoingLinks(view);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getStatechart_1000ContainedLinks(View view) {
		Statechart modelElement = (Statechart) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getContainedTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3002ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3003ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_3004ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3005ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3006ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3007ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3008ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001ContainedLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3001IncomingLinks(View view) {
		State modelElement = (State) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3002IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3003IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_3004IncomingLinks(View view) {
		FinalState modelElement = (FinalState) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3005IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3006IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3007IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3008IncomingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource()
				.getResourceSet().getResources());
		List result = new LinkedList();
		result.addAll(getIncomingTypeModelFacetLinks_Transition_4001(
				modelElement, crossReferences));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001IncomingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getRegion_2001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getState_3001OutgoingLinks(View view) {
		State modelElement = (State) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getRegion_3002OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3003OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getFinalState_3004OutgoingLinks(View view) {
		FinalState modelElement = (FinalState) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3005OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3006OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3007OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getPseudostate_3008OutgoingLinks(View view) {
		Pseudostate modelElement = (Pseudostate) view.getElement();
		List result = new LinkedList();
		result
				.addAll(getOutgoingTypeModelFacetLinks_Transition_4001(modelElement));
		return result;
	}

	/**
	 * @generated
	 */
	public static List getTransition_4001OutgoingLinks(View view) {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	private static Collection getContainedTypeModelFacetLinks_Transition_4001(
			Statechart container) {
		Collection result = new LinkedList();
		for (Iterator links = container.getTransition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatemachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTargetNode();
			Node src = link.getSourceNode();
			result.add(new StatemachineLinkDescriptor(src, dst, link,
					StatemachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getIncomingTypeModelFacetLinks_Transition_4001(
			Node target, Map crossReferences) {
		Collection result = new LinkedList();
		Collection settings = (Collection) crossReferences.get(target);
		for (Iterator it = settings.iterator(); it.hasNext();) {
			EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it
					.next();
			if (setting.getEStructuralFeature() != StatemachinePackage.eINSTANCE
					.getTransition_TargetNode()
					|| false == setting.getEObject() instanceof Transition) {
				continue;
			}
			Transition link = (Transition) setting.getEObject();
			if (TransitionEditPart.VISUAL_ID != StatemachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node src = link.getSourceNode();
			result.add(new StatemachineLinkDescriptor(src, target, link,
					StatemachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private static Collection getOutgoingTypeModelFacetLinks_Transition_4001(
			Node source) {
		Statechart container = null;
		// Find container element for the link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null && container == null; element = element
				.eContainer()) {
			if (element instanceof Statechart) {
				container = (Statechart) element;
			}
		}
		if (container == null) {
			return Collections.EMPTY_LIST;
		}
		Collection result = new LinkedList();
		for (Iterator links = container.getTransition().iterator(); links
				.hasNext();) {
			EObject linkObject = (EObject) links.next();
			if (false == linkObject instanceof Transition) {
				continue;
			}
			Transition link = (Transition) linkObject;
			if (TransitionEditPart.VISUAL_ID != StatemachineVisualIDRegistry
					.getLinkWithClassVisualID(link)) {
				continue;
			}
			Node dst = link.getTargetNode();
			Node src = link.getSourceNode();
			if (src != source) {
				continue;
			}
			result.add(new StatemachineLinkDescriptor(src, dst, link,
					StatemachineElementTypes.Transition_4001,
					TransitionEditPart.VISUAL_ID));
		}
		return result;
	}

}
