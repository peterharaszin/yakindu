/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor.impl;

import static org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil.createInlineStyle;
import static org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil.getInlineStyle;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExtractSubdiagramRefactoring extends AbstractRefactoring<View> {

	protected PreferencesHint preferencesHint = DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	private Diagram subdiagram;

	@Override
	public boolean isExecutable() {
		State state = (State) getContextObject().getElement();
		BooleanValueStyle inlineStyle = getInlineStyle(getContextObject());
		return super.isExecutable() && state.isComposite() && (inlineStyle == null || inlineStyle.isBooleanValue());
	}

	@Override
	protected void internalExecute() {
		setNotationStyle();
		subdiagram = createSubdiagram();
		createEntryExitPoints(subdiagram);
		setPreferredSize();
	}

	@Override
	protected boolean internalDoUndo() {
		boolean close = DiagramPartitioningUtil.closeSubdiagramEditors((State) subdiagram.getElement());
		if (!close)
			return false;
		// Since the canonical edit policy creates edges for the semantic
		// transitions and it is not done within the TransactionalCommand we
		// have to delete the created edges manually when undo is executed.
		while (subdiagram.getEdges().size() > 0) {
			EcoreUtil.delete((EObject) subdiagram.getEdges().get(0));
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	protected void createEntryExitPoints(Diagram subdiagram) {
		TreeIterator<EObject> eAllContents = subdiagram.eAllContents();
		List<Edge> entryPointsToCreate = new ArrayList<Edge>();
		List<Edge> exitPointstoCreate = new ArrayList<Edge>();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			if (next instanceof View) {
				EList<Edge> targetEdges = ((View) next).getTargetEdges();
				for (Edge edge : targetEdges) {
					if (!EcoreUtil.isAncestor(subdiagram, edge.getSource()))
						entryPointsToCreate.add(edge);
				}
				EList<Edge> sourceEdges = ((View) next).getSourceEdges();
				for (Edge edge : sourceEdges) {
					if (!EcoreUtil.isAncestor(subdiagram, edge.getTarget()))
						exitPointstoCreate.add(edge);
				}
			}
		}
		for (Edge edge : entryPointsToCreate) {
			createEntryPoint(edge, subdiagram);
		}
		for (Edge edge : exitPointstoCreate) {
			createExitPoint(edge, subdiagram);
		}
	}

	protected void createEntryPoint(Edge edge, Diagram subdiagram) {
		Transition transition = (Transition) edge.getElement();
		String name = getEntryPointName(transition);
		createSemanticEntryPoint(transition, name);
		transition.setTarget((State) subdiagram.getElement());
		EList<ReactionProperty> properties = transition.getProperties();
		EntryPointSpec entryPointSpec = StextFactory.eINSTANCE.createEntryPointSpec();
		entryPointSpec.setEntrypoint(name);
		properties.add(entryPointSpec);
		edge.setTarget(getContextObject());
	}

	protected String getEntryPointName(Transition transition) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("entry_");
		stringBuilder.append(transition.getSource().getName());
		int index = transition.getSource().getOutgoingTransitions().indexOf(transition);
		stringBuilder.append(index);
		return stringBuilder.toString();
	}

	protected String getExitPointName(Transition transition) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("exit_");
		stringBuilder.append(transition.getSource().getName());
		int index = transition.getSource().getOutgoingTransitions().indexOf(transition);
		stringBuilder.append(index);
		return stringBuilder.toString();
	}

	protected void createSemanticEntryPoint(Transition transition, String name) {
		Region entryPointTarget = transition.getTarget().getParentRegion();
		Entry entryPoint = SGraphFactory.eINSTANCE.createEntry();
		entryPoint.setName(name);
		entryPointTarget.getVertices().add(entryPoint);
		Transition entryPointTransition = SGraphFactory.eINSTANCE.createTransition();
		entryPointTransition.setSource(entryPoint);
		entryPointTransition.setTarget(transition.getTarget());
	}

	protected void createExitPoint(Edge edge, Diagram subdiagram) {
		Transition transition = (Transition) edge.getElement();
		String name = getExitPointName(transition);
		createSemanticExitPoint(transition, name);
		transition.setSource((State) subdiagram.getElement());
		EList<ReactionProperty> properties = transition.getProperties();
		EntryPointSpec entryPointSpec = StextFactory.eINSTANCE.createEntryPointSpec();
		entryPointSpec.setEntrypoint(name);
		properties.add(entryPointSpec);
		edge.setSource(getContextObject());
	}

	protected void createSemanticExitPoint(Transition transition, String name) {
		Region exitPointTarget = transition.getSource().getParentRegion();
		Exit exitPoint = SGraphFactory.eINSTANCE.createExit();
		exitPoint.setName(name);
		exitPointTarget.getVertices().add(exitPoint);
		Transition exitPointTransition = SGraphFactory.eINSTANCE.createTransition();
		exitPointTransition.setTarget(exitPoint);
		exitPointTransition.setSource(transition.getSource());
	}

	/**
	 * Sets the GMF inline {@link Style} to true
	 */
	@SuppressWarnings("unchecked")
	protected void setNotationStyle() {
		BooleanValueStyle inlineStyle = getInlineStyle(getContextObject());
		if (inlineStyle == null) {
			inlineStyle = createInlineStyle();
			getContextObject().getStyles().add(inlineStyle);
		}
		inlineStyle.setBooleanValue(false);
	}

	/**
	 * Creates a new {@link Diagram} and copies child elements
	 */
	protected Diagram createSubdiagram() {
		View contextView = getContextObject();
		State contextElement = (State) contextView.getElement();
		Diagram subdiagram = ViewService.createDiagram(contextElement, StatechartDiagramEditor.ID, preferencesHint);
		View figureCompartment = ViewUtil.getChildBySemanticHint(contextView, SemanticHints.STATE_FIGURE_COMPARTMENT);
		getResource().getContents().add(subdiagram);
		while (figureCompartment.getChildren().size() > 0) {
			subdiagram.insertChild((View) figureCompartment.getChildren().get(0));
		}
		return subdiagram;
	}

	protected void setPreferredSize() {
		Node node = (Node) getContextObject();
		Bounds bounds = (Bounds) node.getLayoutConstraint();
		bounds.setWidth(-1);
		bounds.setHeight(-1);
	}
}
