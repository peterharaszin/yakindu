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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.Pseudostate;
import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.FinalStateEditPart.FinalStateFigure;

public class OurFinalStateEditPart extends FinalStateEditPart {

	public OurFinalStateEditPart(View view) {
		super(view);
	}

	
	protected IFigure createNodeShape() {
		FinalStateFigure figure = new FinalStateFigure();
		figure.setMapMode(getMapMode());
		figure.createContents();
		figure.setPreferredSize(new Dimension(getMapMode().DPtoLP(20),
				getMapMode().DPtoLP(20)));
		figure.setMaximumSize(new Dimension(getMapMode().DPtoLP(20),
				getMapMode().DPtoLP(20)));
		figure.setMinimumSize(new Dimension(getMapMode().DPtoLP(20),
				getMapMode().DPtoLP(20)));
		return primaryShape = figure;
	}
	
	protected NodeFigure createNodePlate() {
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(20), getMapMode().DPtoLP(20));
	}

}
