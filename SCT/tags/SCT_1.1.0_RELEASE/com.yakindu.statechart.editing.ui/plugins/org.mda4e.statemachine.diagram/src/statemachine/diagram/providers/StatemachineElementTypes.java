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
package statemachine.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import statemachine.StatemachinePackage;
import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.Region2EditPart;
import statemachine.diagram.edit.parts.RegionEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StatechartEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;

/**
 * @generated
 */
public class StatemachineElementTypes extends ElementInitializers {

	/**
	 * @generated
	 */
	private StatemachineElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static Set KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Statechart_1000 = getElementType("org.mda4e.statemachine.diagram.Statechart_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Region_2001 = getElementType("org.mda4e.statemachine.diagram.Region_2001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType State_3001 = getElementType("org.mda4e.statemachine.diagram.State_3001"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Region_3002 = getElementType("org.mda4e.statemachine.diagram.Region_3002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_3003 = getElementType("org.mda4e.statemachine.diagram.Pseudostate_3003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType FinalState_3004 = getElementType("org.mda4e.statemachine.diagram.FinalState_3004"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_3005 = getElementType("org.mda4e.statemachine.diagram.Pseudostate_3005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_3006 = getElementType("org.mda4e.statemachine.diagram.Pseudostate_3006"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_3007 = getElementType("org.mda4e.statemachine.diagram.Pseudostate_3007"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Pseudostate_3008 = getElementType("org.mda4e.statemachine.diagram.Pseudostate_3008"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Transition_4001 = getElementType("org.mda4e.statemachine.diagram.Transition_4001"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			EStructuralFeature feature = ((EStructuralFeature) element);
			EClass eContainingClass = feature.getEContainingClass();
			EClassifier eType = feature.getEType();
			if (eContainingClass != null && !eContainingClass.isAbstract()) {
				element = eContainingClass;
			} else if (eType instanceof EClass
					&& !((EClass) eType).isAbstract()) {
				element = eType;
			}
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return StatemachineDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();

			elements.put(Statechart_1000, StatemachinePackage.eINSTANCE
					.getStatechart());

			elements
					.put(Region_2001, StatemachinePackage.eINSTANCE.getRegion());

			elements.put(State_3001, StatemachinePackage.eINSTANCE.getState());

			elements
					.put(Region_3002, StatemachinePackage.eINSTANCE.getRegion());

			elements.put(Pseudostate_3003, StatemachinePackage.eINSTANCE
					.getPseudostate());

			elements.put(FinalState_3004, StatemachinePackage.eINSTANCE
					.getFinalState());

			elements.put(Pseudostate_3005, StatemachinePackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_3006, StatemachinePackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_3007, StatemachinePackage.eINSTANCE
					.getPseudostate());

			elements.put(Pseudostate_3008, StatemachinePackage.eINSTANCE
					.getPseudostate());

			elements.put(Transition_4001, StatemachinePackage.eINSTANCE
					.getTransition());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet();
			KNOWN_ELEMENT_TYPES.add(Statechart_1000);
			KNOWN_ELEMENT_TYPES.add(Region_2001);
			KNOWN_ELEMENT_TYPES.add(State_3001);
			KNOWN_ELEMENT_TYPES.add(Region_3002);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3003);
			KNOWN_ELEMENT_TYPES.add(FinalState_3004);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3005);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3006);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3007);
			KNOWN_ELEMENT_TYPES.add(Pseudostate_3008);
			KNOWN_ELEMENT_TYPES.add(Transition_4001);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case StatechartEditPart.VISUAL_ID:
			return Statechart_1000;
		case RegionEditPart.VISUAL_ID:
			return Region_2001;
		case StateEditPart.VISUAL_ID:
			return State_3001;
		case Region2EditPart.VISUAL_ID:
			return Region_3002;
		case PseudostateEditPart.VISUAL_ID:
			return Pseudostate_3003;
		case FinalStateEditPart.VISUAL_ID:
			return FinalState_3004;
		case Pseudostate2EditPart.VISUAL_ID:
			return Pseudostate_3005;
		case Pseudostate3EditPart.VISUAL_ID:
			return Pseudostate_3006;
		case Pseudostate4EditPart.VISUAL_ID:
			return Pseudostate_3007;
		case Pseudostate5EditPart.VISUAL_ID:
			return Pseudostate_3008;
		case TransitionEditPart.VISUAL_ID:
			return Transition_4001;
		}
		return null;
	}

}
