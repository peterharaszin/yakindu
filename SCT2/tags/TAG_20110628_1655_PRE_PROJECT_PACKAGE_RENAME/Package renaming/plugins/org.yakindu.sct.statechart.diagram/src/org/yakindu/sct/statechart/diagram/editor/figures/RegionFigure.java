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
package org.yakindu.sct.statechart.diagram.editor.figures;

import static org.yakindu.sct.statechart.diagram.editor.figures.utils.GraphicsUtil.fillVerticalGradientRectangle;
import static org.yakindu.sct.statechart.diagram.editor.figures.utils.GraphicsUtil.mixColor;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.swt.graphics.Color;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.GridDataFactory;

/**
 * 
 * @author muelder
 * @author terfloth
 * 
 */
public class RegionFigure extends RectangleFigure {

	private WrappingLabel nameLabel;

	private RectangleFigure compartmentPane;

	private final IMapMode mapMode;

	public RegionFigure(IMapMode mapMode) {
		this.mapMode = mapMode;

		GridLayout layoutThis = new GridLayout(1, false);
		// StackLayout layoutThis = new StackLayout();
		layoutThis.verticalSpacing = 2;
		// layoutThis.marginHeight = 2;
		// layoutThis.marginWidth = 2;
		this.setLayoutManager(layoutThis);
		this.setLineWidth(mapMode.DPtoLP(1));
		createContents();
	}

	private void createContents() {

		RectangleFigure labelFigure = new RectangleFigure();
		labelFigure.setOutline(false);
		labelFigure.setFill(false);
		// this.add(labelFigure,
		// GridDataFactory.fillDefaults().align(GridData.CENTER,
		// SWT.END).grab(true, false)
		// .getData());
		GridLayout layout = new GridLayout();
		layout.verticalSpacing = 2;
		layout.numColumns = 1;
		layout.makeColumnsEqualWidth = true;
		labelFigure.setLayoutManager(layout);

		/** name Label **/
		nameLabel = new WrappingLabel();
		nameLabel.setAlignment(PositionConstants.WEST);
		GridData data = GridDataFactory.fillDefaults()
				.align(GridData.CENTER, GridData.BEGINNING).grab(true, false)
				.getData();
		// data.heightHint = mapMode.DPtoLP(10);
		this.add(nameLabel, data);

		/** Compartment container **/
		compartmentPane = new RectangleFigure();
		compartmentPane.setOutline(false);
		GridLayout compartmentLayout = new GridLayout();
		compartmentLayout.numColumns = 1;
		compartmentLayout.makeColumnsEqualWidth = true;
		compartmentPane.setLayoutManager(compartmentLayout);
		compartmentPane.setFill(false);
		this.add(compartmentPane,
				GridDataFactory.fillDefaults().grab(true, true).getData());
	}

	public WrappingLabel getNameLabel() {
		return nameLabel;
	}

	public RectangleFigure getCompartmentPane() {
		return compartmentPane;
	}

	// ========= drawing related methods ============================

	/**
	 * Fill the shape with a vertical color gradient. The gradient mixes a white
	 * into the configured background color.
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		Color c = mixColor(getBackgroundColor(), ColorConstants.white, 220);
		fillVerticalGradientRectangle(graphics, getBounds(),
				getBackgroundColor(), c);
		c.dispose();
	}

	public IMapMode getMapMode() {
		return mapMode;
	}

}
