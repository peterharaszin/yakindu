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

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.figures.FontColorAwareLabel;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;

/**
 * @author Andreas Unger
 *
 */
public class LabeledRectangularComponentEditPart extends RectangularComponentEditPart {

	private Label label;
	
	/**
	 * 
	 */
	public LabeledRectangularComponentEditPart(View view) {
		super(view);
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshText();
	}

	protected void refreshText() {
		label.setText(getText());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		label = createLabel();
		figure.add(label);
		return figure;
	}

	/**
	 * @return
	 */
	protected FontColorAwareLabel createLabel() {
		return new FontColorAwareLabel();
	}
	
	protected String getText() {
		String text = null;
		EObject o = ViewUtil.resolveSemanticElement((View) getModel());
		if (o instanceof Block) {
			BlockType blockType = ((Block) o).getType();
			if (blockType != null) {
				text = blockType.getName();
			}
		}
		if (text == null && o != null) {
			text = o.eClass().getName();
		}
		return text != null ? text : "Block";
	}
	
}
