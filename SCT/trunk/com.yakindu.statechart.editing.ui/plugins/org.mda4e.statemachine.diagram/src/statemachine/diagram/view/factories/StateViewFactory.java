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
package statemachine.diagram.view.factories;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.diagram.edit.parts.StateDoEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StateEntryEditPart;
import statemachine.diagram.edit.parts.StateExitEditPart;
import statemachine.diagram.edit.parts.StateNameEditPart;
import statemachine.diagram.edit.parts.StateStateCompartmentEditPart;
import statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class StateViewFactory extends AbstractShapeViewFactory {

	/**
	 * @generated
	 */
	protected List createStyles(View view) {
		List styles = new ArrayList();
		styles.add(NotationFactory.eINSTANCE.createShapeStyle());
		return styles;
	}

	/**
	 * @generated
	 */
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		if (semanticHint == null) {
			semanticHint = StatemachineVisualIDRegistry
					.getType(StateEditPart.VISUAL_ID);
			view.setType(semanticHint);
		}
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);
		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}
		getViewService().createNode(
				eObjectAdapter,
				view,
				StatemachineVisualIDRegistry
						.getType(StateNameEditPart.VISUAL_ID), ViewUtil.APPEND,
				true, getPreferencesHint());
		getViewService().createNode(
				eObjectAdapter,
				view,
				StatemachineVisualIDRegistry
						.getType(StateEntryEditPart.VISUAL_ID),
				ViewUtil.APPEND, true, getPreferencesHint());
		getViewService()
				.createNode(
						eObjectAdapter,
						view,
						StatemachineVisualIDRegistry
								.getType(StateDoEditPart.VISUAL_ID),
						ViewUtil.APPEND, true, getPreferencesHint());
		getViewService().createNode(
				eObjectAdapter,
				view,
				StatemachineVisualIDRegistry
						.getType(StateExitEditPart.VISUAL_ID), ViewUtil.APPEND,
				true, getPreferencesHint());
		getViewService().createNode(
				eObjectAdapter,
				view,
				StatemachineVisualIDRegistry
						.getType(StateStateCompartmentEditPart.VISUAL_ID),
				ViewUtil.APPEND, true, getPreferencesHint());
	}
}
