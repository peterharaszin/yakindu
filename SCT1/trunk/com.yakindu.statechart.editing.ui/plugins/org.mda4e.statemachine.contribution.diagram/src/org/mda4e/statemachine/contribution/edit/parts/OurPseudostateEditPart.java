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
package org.mda4e.statemachine.contribution.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.Pseudostate;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.figures.customfigures.PseudostateChoiceFigure;
import statemachine.figures.customfigures.PseudostateDeepHistoryFigure;
import statemachine.figures.customfigures.PseudostateEntryPointFigure;
import statemachine.figures.customfigures.PseudostateExitPointFigure;
import statemachine.figures.customfigures.PseudostateForkFigure;
import statemachine.figures.customfigures.PseudostateJoinFigure;
import statemachine.figures.customfigures.PseudostateJunctionFigure;
import statemachine.figures.customfigures.PseudostateShallowHistoryFigure;
import statemachine.figures.customfigures.PseudostateTerminateFigure;
import statemachine.figures.customfigures.VertexFigure;

public class OurPseudostateEditPart extends PseudostateEditPart {

	//public static final int VISUAL_ID = 2003;
	protected IFigure contentPane;
	private NodeFigure figure;
	private IFigure shape, shape2;
	protected IFigure primaryShape;
	protected Adapter modelAdapter; 
	
	public OurPseudostateEditPart(View view) {
		super(view);
	}

	protected IFigure createNodeShape() {
		if (resolveSemanticElement() instanceof Pseudostate) {
			Pseudostate ps = (Pseudostate)resolveSemanticElement();
			switch(ps.getPseudoType()){
			case INITIAL:
				primaryShape = new PseudostateInitialFigure();
				primaryShape.setMinimumSize(new Dimension(getMapMode().DPtoLP(10),
						getMapMode().DPtoLP(10)));
				primaryShape.setMaximumSize(new Dimension(getMapMode().DPtoLP(10),
						getMapMode().DPtoLP(10)));
				primaryShape.setPreferredSize(new Dimension(getMapMode().DPtoLP(10),
						getMapMode().DPtoLP(10)));
				
				primaryShape.setSize(getMapMode().DPtoLP(10), getMapMode().DPtoLP(10));
				return primaryShape;
				
			case DEEP_HISTORY:
				return primaryShape = new PseudostateDeepHistoryFigure();
				
				
			case SHALLOW_HISTORY:
				return primaryShape = new PseudostateShallowHistoryFigure();
				
			case JOIN:
				return primaryShape = new PseudostateJoinFigure();
				
			case FORK:
				return primaryShape =  new PseudostateForkFigure();
				
			case JUNCTION:
				return primaryShape = new PseudostateJunctionFigure(getMapMode());
				
			case CHOICE:
				return primaryShape = new PseudostateChoiceFigure(getMapMode());
				
			case ENTRY_POINT:
				return primaryShape = new PseudostateEntryPointFigure();
				
			case EXIT_POINT:
				return primaryShape = new PseudostateExitPointFigure();
				
			case TERMINATE: 
				return primaryShape = new PseudostateTerminateFigure();
			}

		}
		return new VertexFigure();
		
	}

	protected NodeFigure createNodeFigure() {
		figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	
	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		if (resolveSemanticElement() instanceof Pseudostate) {
			Pseudostate ps = (Pseudostate)resolveSemanticElement();
			switch(ps.getPseudoType()){
			case INITIAL:
			case DEEP_HISTORY:
			case SHALLOW_HISTORY:
				return new DefaultSizeNodeFigure(getMapMode().DPtoLP(20), getMapMode().DPtoLP(20));

			case CHOICE:
				return new DefaultSizeNodeFigure(getMapMode().DPtoLP(15), getMapMode().DPtoLP(15));

			case JUNCTION:
				return new DefaultSizeNodeFigure(getMapMode().DPtoLP(8), getMapMode().DPtoLP(8));

			case JOIN:
			case FORK:

			case ENTRY_POINT:
			case EXIT_POINT:
			case TERMINATE: 
		}}	
		return super.createNodePlate();
			
	}

	
	protected void addSemanticListeners() {
		super.addSemanticListeners();
		getNotationView().getElement().eAdapters().add(provideAdapter());
		updateShape();
	}

	@Override
	protected void removeSemanticListeners() {
		super.removeSemanticListeners();
		if (getNotationView().getElement()!=null)
		getNotationView().getElement().eAdapters().remove(provideAdapter());
	}
	
	protected void updateShape() {
		//figure.remove(shape);
		shape2 = createNodeShape();
		figure.getChildren().clear();
		//figure.remove(shape);
		figure.add(shape2);
		contentPane = setupContentPane(shape2);
	//	this.getFigure().invalidate();
	}

	protected Adapter provideAdapter() {
		if (modelAdapter == null) {
			modelAdapter = new Adapter() {

				private Notifier target;

				public Notifier getTarget() {
					return target;
				}

				public boolean isAdapterForType(Object arg0) {
					return false;
				}

				public void notifyChanged(Notification notification) {
					updateShape();
				}

				public void setTarget(Notifier target) {
					this.target = target;
				}

			};
		}

		return modelAdapter;
	}
}