/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.CompartmentViewFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.StatechartDiagramEditor;
import org.yakindu.sct.statechart.diagram.factories.RegionViewFactory;
import org.yakindu.sct.statechart.diagram.factories.StateTextCompartmentViewFactory;
import org.yakindu.sct.statechart.diagram.factories.StateViewFactory;
import org.yakindu.sct.statechart.diagram.factories.StatechartDiagramViewFactory;
import org.yakindu.sct.statechart.diagram.factories.StatechartTextFactory;
import org.yakindu.sct.statechart.diagram.factories.TransitionViewFactory;
import org.yakindu.sct.statechart.diagram.utils.SemanticHintUtil;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartDiagramViewProvider extends AbstractViewProvider
		implements SemanticHints {

	private static final Map<String, Class<?>> factories;
	static {
		factories = new HashMap<String, Class<?>>();
		init();
	}

	private static void init() {
		factories.put(StatechartDiagramEditor.ID,
				StatechartDiagramViewFactory.class);
		factories.put(STATECHART_TEXT, StatechartTextFactory.class);
		factories.put(STATECHART_TEXT_EXPRESSION, ShapeViewFactory.class);
		factories.put(REGION, RegionViewFactory.class);
		factories.put(REGION_COMPARTMENT, ShapeViewFactory.class);
		factories.put(STATE, StateViewFactory.class);
		factories.put(STATE_FIGURE_COMPARTMENT, CompartmentViewFactory.class);
		factories.put(STATE_TEXT_COMPARTMENT,
				StateTextCompartmentViewFactory.class);
		factories
				.put(STATE_TEXT_COMPARTMENT_EXPRESSION, ShapeViewFactory.class);
		factories.put(TRANSITION, TransitionViewFactory.class);
		factories.put(CHOICE, ShapeViewFactory.class);
		factories.put(INITIALSTATE, ShapeViewFactory.class);
		factories.put(FINALSTATE, ShapeViewFactory.class);
		factories.put(JUNCTION, ShapeViewFactory.class);
		factories.put(SHALLOWHISTORY, ShapeViewFactory.class);
		factories.put(DEEPHISTORY, ShapeViewFactory.class);
	}

	private Class<?> getClass(String semanticHint) {
		Class<?> factory = factories.get(semanticHint);
		return factory;
	}

	@Override
	protected Class<?> getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		return getClass(diagramKind);
	}

	@Override
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (semanticHint == null || semanticHint.isEmpty()) {
			semanticHint = SemanticHintUtil
					.getSemanticHint((EObject) semanticAdapter
							.getAdapter(EObject.class));
		}
		return getClass(semanticHint);
	}

	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		if (semanticHint == null || semanticHint.isEmpty()) {
			semanticHint = SemanticHintUtil
					.getSemanticHint((EObject) semanticAdapter
							.getAdapter(EObject.class));
		}
		return getClass(semanticHint);
	}
}
