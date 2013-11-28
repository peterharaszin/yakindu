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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartment2EditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartmentEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StateStateCompartmentEditPart;
import statemachine.diagram.edit.parts.StatechartEditPart;
import statemachine.diagram.part.Messages;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;

/**
 * @generated
 */
public class StatemachineModelingAssistantProvider extends
		ModelingAssistantProvider {

	/**
	 * @generated
	 */
	public List getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof RegionRegionCompartmentEditPart) {
			ArrayList types = new ArrayList(7);
			types.add(StatemachineElementTypes.State_3001);
			types.add(StatemachineElementTypes.Pseudostate_3003);
			types.add(StatemachineElementTypes.FinalState_3004);
			types.add(StatemachineElementTypes.Pseudostate_3005);
			types.add(StatemachineElementTypes.Pseudostate_3006);
			types.add(StatemachineElementTypes.Pseudostate_3007);
			types.add(StatemachineElementTypes.Pseudostate_3008);
			return types;
		}
		if (editPart instanceof StateStateCompartmentEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(StatemachineElementTypes.Region_3002);
			return types;
		}
		if (editPart instanceof RegionRegionCompartment2EditPart) {
			ArrayList types = new ArrayList(7);
			types.add(StatemachineElementTypes.State_3001);
			types.add(StatemachineElementTypes.Pseudostate_3003);
			types.add(StatemachineElementTypes.FinalState_3004);
			types.add(StatemachineElementTypes.Pseudostate_3005);
			types.add(StatemachineElementTypes.Pseudostate_3006);
			types.add(StatemachineElementTypes.Pseudostate_3007);
			types.add(StatemachineElementTypes.Pseudostate_3008);
			return types;
		}
		if (editPart instanceof StatechartEditPart) {
			ArrayList types = new ArrayList(1);
			types.add(StatemachineElementTypes.Region_2001);
			return types;
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PseudostateEditPart) {
			return ((PseudostateEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Pseudostate2EditPart) {
			return ((Pseudostate2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Pseudostate3EditPart) {
			return ((Pseudostate3EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Pseudostate4EditPart) {
			return ((Pseudostate4EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Pseudostate5EditPart) {
			return ((Pseudostate5EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof StateEditPart) {
			return ((StateEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PseudostateEditPart) {
			return ((PseudostateEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Pseudostate2EditPart) {
			return ((Pseudostate2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Pseudostate3EditPart) {
			return ((Pseudostate3EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Pseudostate4EditPart) {
			return ((Pseudostate4EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Pseudostate5EditPart) {
			return ((Pseudostate5EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PseudostateEditPart) {
			return ((PseudostateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Pseudostate2EditPart) {
			return ((Pseudostate2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Pseudostate3EditPart) {
			return ((Pseudostate3EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Pseudostate4EditPart) {
			return ((Pseudostate4EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Pseudostate5EditPart) {
			return ((Pseudostate5EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof StateEditPart) {
			return ((StateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PseudostateEditPart) {
			return ((PseudostateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Pseudostate2EditPart) {
			return ((Pseudostate2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Pseudostate3EditPart) {
			return ((Pseudostate3EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Pseudostate4EditPart) {
			return ((Pseudostate4EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Pseudostate5EditPart) {
			return ((Pseudostate5EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof StateEditPart) {
			return ((StateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PseudostateEditPart) {
			return ((PseudostateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FinalStateEditPart) {
			return ((FinalStateEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Pseudostate2EditPart) {
			return ((Pseudostate2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Pseudostate3EditPart) {
			return ((Pseudostate3EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Pseudostate4EditPart) {
			return ((Pseudostate4EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Pseudostate5EditPart) {
			return ((Pseudostate5EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target, getTypesForSource(target,
				relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source, getTypesForTarget(source,
				relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				StatemachineDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog
				.setMessage(Messages.StatemachineModelingAssistantProviderMessage);
		dialog.setTitle(Messages.StatemachineModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
