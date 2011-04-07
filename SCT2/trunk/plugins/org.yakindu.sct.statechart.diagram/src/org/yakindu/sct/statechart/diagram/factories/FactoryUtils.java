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
package org.yakindu.sct.statechart.diagram.factories;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.model.sct.statechart.InitialState;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartFactory;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.editor.StatechartDiagramEditor;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;

/**
 * Convenience methods for semantic and notation model element creation.
 * 
 * @author muelder
 * 
 */
public final class FactoryUtils {

	private static final int INITIAL_REGION_WIDTH = 400;
	private static final int INITIAL_REGION_HEIGHT = 400;
	private static final String INITIAL_REGION_NAME = "main region";

	private static final int INITIAL_TEXT_COMPARTMENT_X = 10;
	private static final int INITIAL_TEXT_COMPARTMENT_Y = 10;
	private static final int INITIAL_TEXT_COMPARTMENT_HEIGHT = 400;
	private static final int INITIAL_TEXT_COMPARTMENT_WIDTH = 200;

	private static final int SPACING = 10;

	private FactoryUtils() {
	}

	/**
	 * Creates a Label view
	 * 
	 * @param owner
	 * @param hint
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Node createLabel(View owner, String hint) {
		DecorationNode nameLabel = NotationFactory.eINSTANCE
				.createDecorationNode();
		nameLabel.setType(hint);

		ShapeStyle style = NotationFactory.eINSTANCE.createShapeStyle();
		style.setFontColor(FigureUtilities.RGBToInteger(ColorConstants.black
				.getRGB()));
		nameLabel.getStyles().add(style);

		ViewUtil.insertChildView(owner, nameLabel, ViewUtil.APPEND, true);
		nameLabel.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		return nameLabel;
	}

	/**
	 * Creates a Statechart with an initial Region and an initial State
	 * 
	 * @return instanceof {@link Statechart}
	 */
	public static void createStatechartModel(Resource resource) {
		// Create a statechart
		Statechart statechart = StatechartFactory.eINSTANCE.createStatechart();
		Diagram diagram = ViewService.createDiagram(statechart,
				StatechartDiagramEditor.ID,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		diagram.setElement(statechart);
		// Add to resource
		resource.getContents().add(statechart);
		resource.getContents().add(diagram);
		// Create an initial region
		Region region = StatechartFactory.eINSTANCE.createRegion();
		region.setName(INITIAL_REGION_NAME);
		statechart.getRegions().add(region);
		Node regionView = ViewService
				.createNode(diagram, region, SemanticHints.REGION,
						DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		setRegionViewLayoutConstraint(regionView);
		// // Create an initial state
		InitialState initialState = StatechartFactory.eINSTANCE
				.createInitialState();
		region.getVertices().add(initialState);
		Node initialStateView = ViewService.createNode(
				getRegionCompartmentView(regionView), initialState,
				SemanticHints.INITIALSTATE,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		setInitialStateViewLayoutConstraint(initialStateView);
		// Create the first state
		State state = StatechartFactory.eINSTANCE.createState();
		region.getVertices().add(state);
		Node stateNode = ViewService.createNode(
				getRegionCompartmentView(regionView), state,
				SemanticHints.STATE, DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		setStateViewLayoutConstraint(stateNode);
		// Create the transition from Initial State to State
		Transition transition = StatechartFactory.eINSTANCE.createTransition();
		transition.setSource(initialState);
		transition.setTarget(state);
		initialState.getOutgoingTransitions().add(transition);
		ViewService.createEdge(initialStateView, stateNode, transition,
				SemanticHints.TRANSITION,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		// Create the textcompartment for events / variables
		Node textCompartment = ViewService.createNode(diagram, statechart,
				SemanticHints.STATECHART_TEXT,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		setTextCompartmentLayoutConstraint(textCompartment);

	}

	private static void setStateViewLayoutConstraint(Node stateNode) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(10);
		bounds.setY(80);
		stateNode.setLayoutConstraint(bounds);
	}

	private static void setInitialStateViewLayoutConstraint(
			Node initialStateView) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(20);
		bounds.setY(20);
		initialStateView.setLayoutConstraint(bounds);
	}

	private static View getRegionCompartmentView(View regionView) {
		return (View) regionView.getChildren().get(1);
	}

	private static void setTextCompartmentLayoutConstraint(Node textCompartment) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(INITIAL_TEXT_COMPARTMENT_X);
		bounds.setY(INITIAL_TEXT_COMPARTMENT_Y);
		bounds.setHeight(INITIAL_TEXT_COMPARTMENT_HEIGHT);
		bounds.setWidth(INITIAL_TEXT_COMPARTMENT_WIDTH);
		textCompartment.setLayoutConstraint(bounds);
	}

	private static void setRegionViewLayoutConstraint(Node regionView) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(INITIAL_TEXT_COMPARTMENT_WIDTH + INITIAL_TEXT_COMPARTMENT_X
				+ SPACING);
		bounds.setY(INITIAL_TEXT_COMPARTMENT_Y);
		bounds.setHeight(INITIAL_REGION_HEIGHT);
		bounds.setWidth(INITIAL_REGION_WIDTH);
		regionView.setLayoutConstraint(bounds);
	}

}
