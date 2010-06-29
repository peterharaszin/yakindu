/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.diagram.ui.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.draw2d.ui.figures.LabelEx;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.semantic.blockdiagram.Block;

/**
 * @author Andreas Unger
 *
 */
public class LabeledRectangularBlockEditPart extends RectangularBlockEditPart {

	private Label labelFigure;
	
	/**
	 * 
	 */
	public LabeledRectangularBlockEditPart(View view) {
		super(view);
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
	}

	protected void refreshLabel() {
		labelFigure.setText(getLabel());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		labelFigure = new LabelEx();
		figure.add(labelFigure);
		return figure;
	}
	
	protected String getLabel() {
		String label = "";
		EObject o = ViewUtil.resolveSemanticElement((View) getModel());
		if (o instanceof Block) {
			label = ((Block) o).getType().getName().trim();
		}
		return label.length() == 0 ? "Block" : label;
	}
	
}
