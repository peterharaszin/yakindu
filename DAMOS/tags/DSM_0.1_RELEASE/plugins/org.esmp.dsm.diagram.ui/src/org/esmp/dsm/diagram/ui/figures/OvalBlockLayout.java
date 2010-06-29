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

package org.esmp.dsm.diagram.ui.figures;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * @author Andreas Unger
 *
 */
public class OvalBlockLayout extends AbstractLayout {
	
	public static final char PORT = 'o';
	public static final char SPACER = '|';

	private String inputPortsArrangement = "";
	private String outputPortsArrangement = "";
	
	/**
	 * @return the inputLayout
	 */
	public String getInputPortsArrangement() {
		return inputPortsArrangement;
	}
	
	/**
	 * @param inputPortsArrangement the inputLayout to set
	 */
	public void setInputPortsArrangement(String inputPortsArrangement) {
		this.inputPortsArrangement = inputPortsArrangement;
		invalidate();
	}
	
	/**
	 * @return the outputLayout
	 */
	public String getOutputPortsArrangement() {
		return outputPortsArrangement;
	}
	
	/**
	 * @param outputPortsArrangement the outputLayout to set
	 */
	public void setOutputPortsArrangement(String outputPortsArrangement) {
		this.outputPortsArrangement = outputPortsArrangement;
		invalidate();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#calculatePreferredSize(org.eclipse.draw2d.IFigure, int, int)
	 */
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		return container.getMinimumSize();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
	 */
	public void layout(IFigure container) {
		BlockFigure blockFigure = (BlockFigure) container;
		layoutInputPortFigures(blockFigure);
		layoutOutputPortFigures(blockFigure);
	}
	
	protected void layoutInputPortFigures(BlockFigure blockFigure) {
		List<PortFigure> portFigures = getInputPortFigures(blockFigure);
		int n = portFigures.size() + countSpacers(inputPortsArrangement);
		double spacing = Math.toRadians(n < 3 ? 90.0 : 180.0 / (n - 1));
		double rotation = Math.toRadians(90);
		int i = 0;
		for (PortFigure portFigure : portFigures) {
			while (i < inputPortsArrangement.length() && inputPortsArrangement.charAt(i++) == SPACER) {
				rotation += spacing;
			}
			layoutPortFigure(blockFigure, portFigure, rotation);
			rotation += spacing;
		}
	}
	
	protected void layoutOutputPortFigures(BlockFigure blockFigure) {
		List<PortFigure> portFigures = getOutputPortFigures(blockFigure);
		int n = portFigures.size() + countSpacers(outputPortsArrangement);
		double spacing = Math.toRadians(n < 3 ? 90.0 : 180.0 / (n - 1));
		double rotation = Math.toRadians(90);
		int i = 0;
		for (PortFigure portFigure : portFigures) {
			while (i < outputPortsArrangement.length() && outputPortsArrangement.charAt(i++) == SPACER) {
				rotation -= spacing;
			}
			layoutPortFigure(blockFigure, portFigure, rotation);
			rotation -= spacing;
		}
	}
	
	private static int countSpacers(String layout) {
		int n = 0;
		for (int i = 0; i < layout.length(); ++i) {
			if (layout.charAt(i) == SPACER) {
				++n;
			}
		}
		return n;
	}
	
	protected void layoutPortFigure(BlockFigure blockFigure, PortFigure portFigure, double rotation) {
		if (blockFigure.isFlipped()) {
			rotation = Math.toRadians(180) - rotation;
		}
		rotation += Math.toRadians(blockFigure.getRotation());
		
		Rectangle bounds = blockFigure.getBounds();
		Point p = new Point(
				(int) Math.round(bounds.x + (Math.cos(rotation) + 1) * bounds.width / 2),
				(int) Math.round(bounds.y - (Math.sin(rotation) - 1) * bounds.height / 2));
		portFigure.setRotation(rotation);
		portFigure.updateBounds(p);

		IFigure terminalBorderFigure = portFigure.getTerminalBorderFigure();
		if (terminalBorderFigure != null) {
			switch (portFigure.getOrientation()) {
			case PositionConstants.NORTH:
			case PositionConstants.SOUTH:
			case PositionConstants.WEST:
			case PositionConstants.EAST:
				terminalBorderFigure.setBounds(bounds);
				break;
			}
		}
	}
	
	protected List<PortFigure> getInputPortFigures(BlockFigure blockFigure) {
		List<PortFigure> portFigures = new ArrayList<PortFigure>();
		for (Object o : blockFigure.getChildren()) {
			if (o instanceof InputPortFigure) {
				portFigures.add((PortFigure) o);
			}
		}
		return portFigures;
	}

	protected List<PortFigure> getOutputPortFigures(BlockFigure blockFigure) {
		List<PortFigure> portFigures = new ArrayList<PortFigure>();
		for (Object o : blockFigure.getChildren()) {
			if (o instanceof OutputPortFigure) {
				portFigures.add((PortFigure) o);
			}
		}
		return portFigures;
	}

}
