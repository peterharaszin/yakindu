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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.esmp.dsm.diagram.ui.internal.geometry.Alignment;
import org.esmp.dsm.diagram.ui.internal.geometry.Extents;
import org.esmp.dsm.diagram.ui.internal.geometry.Geometry;

/**
 * @author Andreas Unger
 *
 */
public class StandardBlockLayout extends AbstractLayout {

	private int portPadding = 50;
	private int horizontalContentPadding = 100;
	private int verticalContentPadding = 100;
	
	private boolean equalPortExtents;
	
	private int horizontalContentAlignment = SWT.CENTER;
	private int verticalContentAlignment = SWT.CENTER;
	
	private BlockMetrics blockMetrics;
	private List<PortFigure> westPortFigures;
	private List<PortFigure> eastPortFigures;
	private List<PortFigure> northPortFigures;
	private List<PortFigure> southPortFigures;
	private IFigure contentFigure;
	
	private Map<IFigure, Object> constraints = new HashMap<IFigure, Object>();
	
	/**
	 * 
	 */
	public StandardBlockLayout() {
	}
	
	/**
	 * @return the portPadding
	 */
	public int getPortPadding() {
		return portPadding;
	}
	
	/**
	 * @param portPadding the portPadding to set
	 */
	public void setPortPadding(int portPadding) {
		this.portPadding = portPadding;
		invalidate();
	}
	
	/**
	 * @return the horizontalContentPadding
	 */
	public int getHorizontalContentPadding() {
		return horizontalContentPadding;
	}
	
	/**
	 * @param horizontalContentPadding the horizontalContentPadding to set
	 */
	public void setHorizontalContentPadding(int horizontalContentPadding) {
		this.horizontalContentPadding = horizontalContentPadding;
		invalidate();
	}
	
	/**
	 * @return the verticalContentPadding
	 */
	public int getVerticalContentPadding() {
		return verticalContentPadding;
	}
	
	/**
	 * @param verticalContentPadding the verticalContentPadding to set
	 */
	public void setVerticalContentPadding(int verticalContentPadding) {
		this.verticalContentPadding = verticalContentPadding;
		invalidate();
	}
	
	/**
	 * @return the equalPortExtents
	 */
	public boolean isEqualPortExtents() {
		return equalPortExtents;
	}
	
	/**
	 * @param equalPortExtents the equalPortExtents to set
	 */
	public void setEqualPortExtents(boolean equalPortExtents) {
		this.equalPortExtents = equalPortExtents;
		invalidate();
	}
	
	/**
	 * @return the horizontalContentAlignment
	 */
	public int getHorizontalContentAlignment() {
		return horizontalContentAlignment;
	}
	
	/**
	 * @param horizontalContentAlignment the horizontalContentAlignment to set
	 */
	public void setHorizontalContentAlignment(int horizontalContentAlignment) {
		this.horizontalContentAlignment = horizontalContentAlignment;
		invalidate();
	}
	
	/**
	 * @return the verticalContentAlignment
	 */
	public int getVerticalContentAlignment() {
		return verticalContentAlignment;
	}
	
	/**
	 * @param verticalContentAlignment the verticalContentAlignment to set
	 */
	public void setVerticalContentAlignment(int verticalContentAlignment) {
		this.verticalContentAlignment = verticalContentAlignment;
		invalidate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#calculatePreferredSize(org.eclipse.draw2d.IFigure, int, int)
	 */
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		BlockMetrics bm = getBlockMetrics((BlockFigure) container);
		return new Dimension(bm.preferredWidth, bm.preferredHeight);
	}
	
	protected BlockMetrics getBlockMetrics(BlockFigure blockFigure) {
		if (blockMetrics == null) {
			blockMetrics = calculateBlockMetrics(blockFigure);
		}
		return blockMetrics;
	}
	
	protected BlockMetrics calculateBlockMetrics(BlockFigure blockFigure) {
		BlockMetrics bm = new BlockMetrics();
		
		for (PortFigure portFigure : getWestPortFigures(blockFigure)) {
			bm.west.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.WEST)));
			++bm.west.count;
		}

		for (PortFigure portFigure : getEastPortFigures(blockFigure)) {
			bm.east.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.EAST)));
			++bm.east.count;
		}
		
		for (PortFigure portFigure : getNorthPortFigures(blockFigure)) {
			bm.north.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.NORTH)));
			++bm.north.count;
		}
		
		for (PortFigure portFigure : getSouthPortFigures(blockFigure)) {
			bm.south.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.SOUTH)));
			++bm.south.count;
		}
		
		IFigure contentFigure = getContentFigure(blockFigure);
		if (contentFigure != null) {
			Dimension preferredSize = contentFigure.getPreferredSize();
			Dimension minimumSize = contentFigure.getMinimumSize();
			if (preferredSize.width < 0) {
				bm.contentWidth = minimumSize.width;
			} else {
				bm.contentWidth = preferredSize.width;
			}
			if (preferredSize.height < 0) {
				bm.contentHeight = minimumSize.height;
			} else {
				bm.contentHeight = preferredSize.height;
			}
		}
		
		IPortLayoutHelper portLayoutHelper = (IPortLayoutHelper) blockFigure.getHelper(IPortLayoutHelper.class);
		if (portLayoutHelper != null) {
			bm.north.extents.bottom += portLayoutHelper.getMaximumTerminalDisplacement(PositionConstants.NORTH);
			bm.south.extents.top += portLayoutHelper.getMaximumTerminalDisplacement(PositionConstants.SOUTH);
			bm.west.extents.right += portLayoutHelper.getMaximumTerminalDisplacement(PositionConstants.WEST);
			bm.east.extents.left += portLayoutHelper.getMaximumTerminalDisplacement(PositionConstants.EAST);
		}
		
		bm.north.extents.expand(portPadding, 0);
		bm.south.extents.expand(portPadding, 0);
		bm.west.extents.expand(0, portPadding);
		bm.east.extents.expand(0, portPadding);

		if (contentFigure != null) {
			bm.contentWidth += 2 * horizontalContentPadding;
			bm.contentHeight += 2 * verticalContentPadding;
		}
		
		if (equalPortExtents) {
			if (bm.north.extents.bottom < bm.south.extents.top) {
				bm.north.extents.bottom = bm.south.extents.top;
			} else {
				bm.south.extents.top = bm.north.extents.bottom;
			}
			if (bm.west.extents.right < bm.east.extents.left) {
				bm.west.extents.right = bm.east.extents.left;
			} else {
				bm.east.extents.left = bm.west.extents.right;
			}
		}
		
		bm.preferredWidth = bm.west.extents.right + bm.contentWidth + bm.east.extents.left;
		int horizontalPortExtents = Math.max(bm.north.count * bm.north.extents.getWidth(), bm.south.count * bm.south.extents.getWidth());
		if (horizontalPortExtents > bm.preferredWidth) {
			bm.preferredWidth = horizontalPortExtents;
		}
		
		bm.preferredHeight = bm.north.extents.bottom + bm.contentHeight + bm.south.extents.top;
		int verticalPortExtents = Math.max(bm.west.count * bm.west.extents.getHeight(), bm.east.count * bm.east.extents.getHeight());
		if (verticalPortExtents > bm.preferredHeight) {
			bm.preferredHeight = verticalPortExtents;
		}
		
		return bm;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
	 */
	public void layout(IFigure container) {
		BlockFigure blockFigure = (BlockFigure) container;
		
		BlockMetrics bm = getBlockMetrics(blockFigure);
		Rectangle bounds = container.getBounds();
		
		IPortLayoutHelper portLayoutHelper = (IPortLayoutHelper) blockFigure.getHelper(IPortLayoutHelper.class);
		
		if (bm.west.count > 0) {
			int spacing = bounds.height / bm.west.count;
			int y = bounds.y + spacing / 2;
			for (PortFigure portFigure : getWestPortFigures(blockFigure)) {
				portFigure.setRotation(Geometry.positionToAngle(PositionConstants.WEST));
				int x = bounds.x;

				int d = 0;
				if (portLayoutHelper != null) {
					d = portLayoutHelper.getTerminalDisplacement(x, y, PositionConstants.WEST);
					x += d;
				}
				
				IFigure terminalBorderFigure = portFigure.getTerminalBorderFigure();
				if (terminalBorderFigure != null) {
					terminalBorderFigure.setBounds(new Rectangle(bounds.x + d, bounds.y, bounds.width - d, bounds.height));
				}
				
				portFigure.updateBounds(new Point(x, y));
				
				y += spacing;
			}
		}

		if (bm.east.count > 0) {
			int spacing = bounds.height / bm.east.count;
			int y = bounds.y + spacing / 2;
			for (PortFigure portFigure : getEastPortFigures(blockFigure)) {
				portFigure.setRotation(Geometry.positionToAngle(PositionConstants.EAST));
				int x = bounds.x + bounds.width;
				
				int d = 0;
				if (portLayoutHelper != null) {
					d = portLayoutHelper.getTerminalDisplacement(x, y, PositionConstants.EAST);
					x -= d;
				}
				
				IFigure terminalBorderFigure = portFigure.getTerminalBorderFigure();
				if (terminalBorderFigure != null) {
					terminalBorderFigure.setBounds(new Rectangle(bounds.x, bounds.y, bounds.width - d, bounds.height));
				}
				
				portFigure.updateBounds(new Point(x, y));
				
				y += spacing;
			}
		}
		
		if (bm.north.count > 0) {
			int spacing = bounds.width / bm.north.count;
			int x = bounds.x + spacing / 2;
			for (PortFigure portFigure : getNorthPortFigures(blockFigure)) {
				portFigure.setRotation(Geometry.positionToAngle(PositionConstants.NORTH));
				int y = bounds.y;
				
				int d = 0;
				if (portLayoutHelper != null) {
					d = portLayoutHelper.getTerminalDisplacement(x, y, PositionConstants.NORTH);
					y += d;
				}
				
				IFigure terminalBorderFigure = portFigure.getTerminalBorderFigure();
				if (terminalBorderFigure != null) {
					terminalBorderFigure.setBounds(new Rectangle(bounds.x, bounds.y + d, bounds.width, bounds.height - d));
				}
				
				portFigure.updateBounds(new Point(x, y));
				
				x += spacing;
			}
		}
		
		if (bm.south.count > 0) {
			int spacing = bounds.width / bm.south.count;
			int x = bounds.x + spacing / 2;
			for (PortFigure portFigure : getSouthPortFigures(blockFigure)) {
				portFigure.setRotation(Geometry.positionToAngle(PositionConstants.SOUTH));
				int y = bounds.y + bounds.height;
				
				int d = 0;
				if (portLayoutHelper != null) {
					d = portLayoutHelper.getTerminalDisplacement(x, y, PositionConstants.SOUTH);
					y -= d;
				}
				
				IFigure terminalBorderFigure = portFigure.getTerminalBorderFigure();
				if (terminalBorderFigure != null) {
					terminalBorderFigure.setBounds(new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height - d));
				}
				
				portFigure.updateBounds(new Point(x, y));
				
				x += spacing;
			}
		}
		
		IFigure contentFigure = getContentFigure(blockFigure);
		if (contentFigure != null) {
			Insets contentInsets = new Insets();
			contentInsets.left = bm.west.extents.right + horizontalContentPadding;
			contentInsets.right = bm.east.extents.left + horizontalContentPadding;
			contentInsets.top = bm.north.extents.bottom + verticalContentPadding;
			contentInsets.bottom = bm.south.extents.top + verticalContentPadding;
			Rectangle contentBounds = bounds.getCropped(contentInsets);
			
			Dimension preferredSize = contentFigure.getPreferredSize();
			Rectangle childBounds = new Rectangle(
					contentBounds.x,
					contentBounds.y,
					preferredSize.width,
					preferredSize.height);
			
			Alignment contentAlignment = calculateContentAlignment(blockFigure);
			
			switch (contentAlignment.horizontal) {
			case SWT.CENTER:
				childBounds.x += (contentBounds.width - childBounds.width) / 2;
				break;
			case SWT.FILL:
				childBounds.width = contentBounds.width;
				break;
			case SWT.END:
				childBounds.x += contentBounds.width - childBounds.width;
				break;
			}
			
			switch (contentAlignment.vertical) {
			case SWT.CENTER:
				childBounds.y += (contentBounds.height - childBounds.height) / 2;
				break;
			case SWT.FILL:
				childBounds.height = contentBounds.height;
				break;
			case SWT.END:
				childBounds.y += contentBounds.height - childBounds.height;
				break;
			}
			
			contentFigure.setBounds(childBounds);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#invalidate()
	 */
	public void invalidate() {
		super.invalidate();
		blockMetrics = null;
		westPortFigures = null;
		eastPortFigures = null;
		northPortFigures = null;
		southPortFigures = null;
		contentFigure = null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#getConstraint(org.eclipse.draw2d.IFigure)
	 */
	public Object getConstraint(IFigure child) {
		return constraints.get(child);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#setConstraint(org.eclipse.draw2d.IFigure, java.lang.Object)
	 */
	public void setConstraint(IFigure child, Object constraint) {
		super.setConstraint(child, constraint);
		if (constraint != null) {
			constraints.put(child, constraint);
		}
	}
	
	private List<PortFigure> getWestPortFigures(BlockFigure blockFigure) {
		if (westPortFigures == null) {
			westPortFigures = getPortFigures(blockFigure, PositionConstants.WEST);
		}
		return westPortFigures;
	}
		
	private List<PortFigure> getEastPortFigures(BlockFigure blockFigure) {
		if (eastPortFigures == null) {
			eastPortFigures = getPortFigures(blockFigure, PositionConstants.EAST);
		}
		return eastPortFigures;
	}
	
	private List<PortFigure> getNorthPortFigures(BlockFigure blockFigure) {
		if (northPortFigures == null) {
			northPortFigures = getPortFigures(blockFigure, PositionConstants.NORTH);
		}
		return northPortFigures;
	}
	
	private List<PortFigure> getSouthPortFigures(BlockFigure blockFigure) {
		if (southPortFigures == null) {
			southPortFigures = getPortFigures(blockFigure, PositionConstants.SOUTH);
		}
		return southPortFigures;
	}
	
	protected IFigure getContentFigure(BlockFigure blockFigure) {
		if (contentFigure == null) {
			contentFigure = blockFigure.getPrimaryContentFigure();
		}
		return contentFigure;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.StandardBlockLayout#calculateContentAlignment()
	 */
	protected Alignment calculateContentAlignment(BlockFigure blockFigure) {
		return Geometry.transformAlignment(
				new Alignment(getHorizontalContentAlignment(), getVerticalContentAlignment()), blockFigure.isFlipped(), blockFigure.getRotation());
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.StandardBlockLayout#getPortFigures(org.eclipse.draw2d.IFigure, int)
	 */
	protected List<PortFigure> getPortFigures(BlockFigure blockFigure, int side) {
		int reversedSide = Geometry.reverseTransformSide(side, blockFigure.isFlipped(), blockFigure.getRotation());
		
		List<PortFigure> portFigures = new ArrayList<PortFigure>();
		for (Object o : blockFigure.getChildren()) {
			if (o instanceof PortFigure && getPortSide((PortFigure) o) == reversedSide) {
				portFigures.add((PortFigure) o);
			}
		}
		
		if (blockFigure.isFlipped()) {
			switch (blockFigure.getRotation()) {
			case 0:
				if (side == PositionConstants.NORTH || side == PositionConstants.SOUTH) {
					Collections.reverse(portFigures);
				}
				break;
			case 180:
				if (side == PositionConstants.WEST || side == PositionConstants.EAST) {
					Collections.reverse(portFigures);
				}
				break;
			case 270:
				Collections.reverse(portFigures);
				break;
			}
		} else {
			switch (blockFigure.getRotation()) {
			case 90:
				if (side == PositionConstants.WEST || side == PositionConstants.EAST) {
					Collections.reverse(portFigures);
				}
				break;
			case 180:
				Collections.reverse(portFigures);
				break;
			case 270:
				if (side == PositionConstants.NORTH || side == PositionConstants.SOUTH) {
					Collections.reverse(portFigures);
				}
				break;
			}
		}
		return portFigures;
	}

	private int getPortSide(PortFigure portFigure) {
		Object constraint = constraints.get(portFigure);
		if (constraint instanceof StandardBlockPortLayoutData) {
			return ((StandardBlockPortLayoutData) constraint).sideHint;
		}
		return -1;
	}
	
	private class BlockMetrics {
		
		public class PortMetrics {
			public int count;
			public Extents extents = new Extents();
		}
		
		public PortMetrics west = new PortMetrics();
		public PortMetrics east = new PortMetrics();
		public PortMetrics north = new PortMetrics();
		public PortMetrics south = new PortMetrics();
		
		public int contentWidth;
		public int contentHeight;
		
		public int preferredWidth;
		public int preferredHeight;
		
	}
	
}
