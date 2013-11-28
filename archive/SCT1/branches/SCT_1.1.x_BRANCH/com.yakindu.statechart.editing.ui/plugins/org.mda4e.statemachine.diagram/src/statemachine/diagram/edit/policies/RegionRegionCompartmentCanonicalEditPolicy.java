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
package statemachine.diagram.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Ratio;
import org.eclipse.gmf.runtime.notation.Size;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.StatemachinePackage;
import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;
import statemachine.diagram.part.StatemachineDiagramUpdater;
import statemachine.diagram.part.StatemachineNodeDescriptor;
import statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class RegionRegionCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = StatemachineDiagramUpdater
				.getRegionRegionCompartment_7001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((StatemachineNodeDescriptor) it.next())
					.getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = StatemachineVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case StateEditPart.VISUAL_ID:
		case PseudostateEditPart.VISUAL_ID:
		case FinalStateEditPart.VISUAL_ID:
		case Pseudostate2EditPart.VISUAL_ID:
		case Pseudostate3EditPart.VISUAL_ID:
		case Pseudostate4EditPart.VISUAL_ID:
		case Pseudostate5EditPart.VISUAL_ID:
			if (!semanticChildren.contains(view.getElement())) {
				return true;
			}
			EObject domainModelElement = view.getElement();
			if (visualID != StatemachineVisualIDRegistry.getNodeVisualID(
					(View) getHost().getModel(), domainModelElement)) {
				List createdViews = createViews(Collections
						.singletonList(domainModelElement));
				assert createdViews.size() == 1;
				final View createdView = (View) ((IAdaptable) createdViews
						.get(0)).getAdapter(View.class);
				if (createdView != null) {
					try {
						new AbstractEMFOperation(host().getEditingDomain(),
								StringStatics.BLANK, Collections.singletonMap(
										Transaction.OPTION_UNPROTECTED,
										Boolean.TRUE)) {
							protected IStatus doExecute(
									IProgressMonitor monitor, IAdaptable info)
									throws ExecutionException {
								populateViewProperties(view, createdView);
								return Status.OK_STATUS;
							}
						}.execute(new NullProgressMonitor(), null);
					} catch (ExecutionException e) {
						StatemachineDiagramEditorPlugin
								.getInstance()
								.logError(
										"Error while copyign view information to newly created view", e); //$NON-NLS-1$
					}
				}
				deleteViews(Collections.singletonList(view).iterator());
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	private void populateViewProperties(View oldView, View newView) {
		if (oldView instanceof Node && newView instanceof Node) {
			Node oldNode = (Node) oldView;
			Node newNode = (Node) newView;
			if (oldNode.getLayoutConstraint() instanceof Location
					&& newNode.getLayoutConstraint() instanceof Location) {
				((Location) newNode.getLayoutConstraint())
						.setX(((Location) oldNode.getLayoutConstraint()).getX());
				((Location) newNode.getLayoutConstraint())
						.setY(((Location) oldNode.getLayoutConstraint()).getY());
			}
			if (oldNode.getLayoutConstraint() instanceof Size
					&& newNode.getLayoutConstraint() instanceof Size) {
				((Size) newNode.getLayoutConstraint()).setWidth(((Size) oldNode
						.getLayoutConstraint()).getWidth());
				((Size) newNode.getLayoutConstraint())
						.setHeight(((Size) oldNode.getLayoutConstraint())
								.getHeight());
			}
			if (oldNode.getLayoutConstraint() instanceof Ratio
					&& newNode.getLayoutConstraint() instanceof Ratio) {
				((Ratio) newNode.getLayoutConstraint())
						.setValue(((Ratio) oldNode.getLayoutConstraint())
								.getValue());
			}
			newNode.persist();
		}
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(StatemachinePackage.eINSTANCE
					.getRegion_State());
		}
		return myFeaturesToSynchronize;
	}

}
