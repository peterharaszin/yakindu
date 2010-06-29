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
public class FunctionBlockLayout extends AbstractLayout {

	private int portPadding = 50;

	private int horizontalBodyPadding = 100;
	private int topBodyPadding = 100;
	private int bottomBodyPadding = 100;
	
	private int horizontalHeaderPadding = 100;
	private int topHeaderPadding = 50;
	private int bottomHeaderPadding = 50;

	private int horizontalFooterPadding = 100;
	private int topFooterPadding = 50;
	private int bottomFooterPadding = 50;

	private boolean equalPortExtents;
		
	private BlockMetrics blockMetrics;
	
	private List<PortFigure> westPortFigures;
	private List<PortFigure> eastPortFigures;
	
	private IFigure bodyFigure;
	private IFigure headerFigure;
	private IFigure footerFigure;
	
	private Map<IFigure, Object> constraints = new HashMap<IFigure, Object>();
	
	/**
	 * 
	 */
	public FunctionBlockLayout() {
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
		return horizontalBodyPadding;
	}
	
	/**
	 * @param horizontalContentPadding the horizontalContentPadding to set
	 */
	public void setHorizontalContentPadding(int horizontalContentPadding) {
		this.horizontalBodyPadding = horizontalContentPadding;
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
	
	public int getHorizontalBodyPadding() {
		return horizontalBodyPadding;
	}

	public void setHorizontalBodyPadding(int horizontalBodyPadding) {
		this.horizontalBodyPadding = horizontalBodyPadding;
	}

	public int getTopBodyPadding() {
		return topBodyPadding;
	}

	public void setTopBodyPadding(int topBodyPadding) {
		this.topBodyPadding = topBodyPadding;
	}

	public int getBottomBodyPadding() {
		return bottomBodyPadding;
	}

	public void setBottomBodyPadding(int bottomBodyPadding) {
		this.bottomBodyPadding = bottomBodyPadding;
	}

	public int getHorizontalHeaderPadding() {
		return horizontalHeaderPadding;
	}

	public void setHorizontalHeaderPadding(int horizontalHeaderPadding) {
		this.horizontalHeaderPadding = horizontalHeaderPadding;
	}

	public int getTopHeaderPadding() {
		return topHeaderPadding;
	}

	public void setTopHeaderPadding(int topHeaderPadding) {
		this.topHeaderPadding = topHeaderPadding;
	}

	public int getBottomHeaderPadding() {
		return bottomHeaderPadding;
	}

	public void setBottomHeaderPadding(int bottomHeaderPadding) {
		this.bottomHeaderPadding = bottomHeaderPadding;
	}

	public int getHorizontalFooterPadding() {
		return horizontalFooterPadding;
	}

	public void setHorizontalFooterPadding(int horizontalFooterPadding) {
		this.horizontalFooterPadding = horizontalFooterPadding;
	}

	public int getTopFooterPadding() {
		return topFooterPadding;
	}

	public void setTopFooterPadding(int topFooterPadding) {
		this.topFooterPadding = topFooterPadding;
	}

	public int getBottomFooterPadding() {
		return bottomFooterPadding;
	}

	public void setBottomFooterPadding(int bottomFooterPadding) {
		this.bottomFooterPadding = bottomFooterPadding;
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
		
		IFigure bodyFigure = getBodyFigure(blockFigure);
		if (bodyFigure != null) {
			initializeContentFigureSize(bodyFigure, bm.bodySize);
		}
		
		IFigure headerFigure = getHeaderFigure(blockFigure);
		if (headerFigure != null) {
			initializeContentFigureSize(headerFigure, bm.headerSize);
		}

		IFigure footerFigure = getFooterFigure(blockFigure);
		if (footerFigure != null) {
			initializeContentFigureSize(footerFigure, bm.footerSize);
		}
		
		bm.west.extents.expand(0, portPadding);
		bm.east.extents.expand(0, portPadding);

		if (bodyFigure != null) {
			bm.bodySize.expand(2 * horizontalBodyPadding, topBodyPadding + bottomBodyPadding);
		}
		
		if (headerFigure != null) {
			bm.headerSize.expand(2 * horizontalHeaderPadding, topHeaderPadding + bottomHeaderPadding);
		}

		if (footerFigure != null) {
			bm.footerSize.expand(2 * horizontalFooterPadding, topFooterPadding + bottomFooterPadding);
		}

		if (equalPortExtents) {
			if (bm.west.extents.right < bm.east.extents.left) {
				bm.west.extents.right = bm.east.extents.left;
			} else {
				bm.east.extents.left = bm.west.extents.right;
			}
		}
		
		bm.preferredWidth = bm.west.extents.right + bm.bodySize.width + bm.east.extents.left;
		if (bm.headerSize.width > bm.preferredWidth) {
			bm.preferredWidth = bm.headerSize.width;
		}
		if (bm.footerSize.width > bm.preferredWidth) {
			bm.preferredWidth = bm.footerSize.width;
		}
		
		bm.preferredHeight = bm.bodySize.height;
		int verticalPortExtents = Math.max(bm.west.count * bm.west.extents.getHeight(), bm.east.count * bm.east.extents.getHeight());
		if (verticalPortExtents > bm.preferredHeight) {
			bm.preferredHeight = verticalPortExtents;
		}
		bm.preferredHeight += bm.headerSize.height + bm.footerSize.height;
		
		return bm;
	}
	
	private void initializeContentFigureSize(IFigure contentFigure, Dimension size) {
		Dimension preferredSize = contentFigure.getPreferredSize();
		Dimension minimumSize = contentFigure.getMinimumSize();
		if (preferredSize.width < 0) {
			size.width = minimumSize.width;
		} else {
			size.width = preferredSize.width;
		}
		if (preferredSize.height < 0) {
			size.height = minimumSize.height;
		} else {
			size.height = preferredSize.height;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.LayoutManager#layout(org.eclipse.draw2d.IFigure)
	 */
	public void layout(IFigure container) {
		BlockFigure blockFigure = (BlockFigure) container;
		
		BlockMetrics bm = getBlockMetrics(blockFigure);
		Rectangle bounds = blockFigure.getBounds();
		
		if (bm.west.count > 0) {
			int y = bounds.y + bm.west.extents.top + bm.headerSize.height;
			for (PortFigure portFigure : getWestPortFigures(blockFigure)) {
				portFigure.setRotation(Geometry.positionToAngle(PositionConstants.WEST));
				int x = bounds.x;

				IFigure terminalBorderFigure = portFigure.getTerminalBorderFigure();
				if (terminalBorderFigure != null) {
					terminalBorderFigure.setBounds(new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height));
				}
				
				portFigure.updateBounds(new Point(x, y));
				
				y += bm.west.extents.getHeight();
			}
		}

		if (bm.east.count > 0) {
			int y = bounds.y + bm.east.extents.top + bm.headerSize.height;
			for (PortFigure portFigure : getEastPortFigures(blockFigure)) {
				portFigure.setRotation(Geometry.positionToAngle(PositionConstants.EAST));
				int x = bounds.x + bounds.width;
				
				IFigure terminalBorderFigure = portFigure.getTerminalBorderFigure();
				if (terminalBorderFigure != null) {
					terminalBorderFigure.setBounds(new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height));
				}
				
				portFigure.updateBounds(new Point(x, y));
				
				y += bm.east.extents.getHeight();
			}
		}
		
		IFigure bodyFigure = getBodyFigure(blockFigure);
		if (bodyFigure != null) {
			Insets contentInsets = new Insets();
			contentInsets.left = bm.west.extents.right + horizontalBodyPadding;
			contentInsets.right = bm.east.extents.left + horizontalBodyPadding;
			contentInsets.top = topBodyPadding + bm.headerSize.height;
			contentInsets.bottom = bottomBodyPadding + bm.footerSize.height;
			Rectangle contentBounds = bounds.getCropped(contentInsets);
			layoutContentFigure(blockFigure, bodyFigure, contentBounds);
		}

		IFigure headerFigure = getHeaderFigure(blockFigure);
		if (headerFigure != null) {
			Rectangle contentBounds = new Rectangle(
					bounds.x,
					bounds.y + topHeaderPadding,
					bounds.width,
					bm.headerSize.height - topHeaderPadding - bottomHeaderPadding);
			contentBounds.shrink(horizontalHeaderPadding, 0);
			layoutContentFigure(blockFigure, headerFigure, contentBounds);
		}
		
		IFigure footerFigure = getFooterFigure(blockFigure);
		if (footerFigure != null) {
			Rectangle contentBounds = new Rectangle(
					bounds.x,
					bounds.bottom() - bm.footerSize.height + topFooterPadding,
					bounds.width,
					bm.footerSize.height - topFooterPadding - bottomFooterPadding);
			contentBounds.shrink(horizontalFooterPadding, 0);
			layoutContentFigure(blockFigure, footerFigure, contentBounds);
		}
	}
	
	private void layoutContentFigure(BlockFigure blockFigure, IFigure contentFigure, Rectangle contentBounds) {
		Dimension preferredSize = contentFigure.getPreferredSize();
		Rectangle childBounds = new Rectangle(
				contentBounds.x,
				contentBounds.y,
				preferredSize.width,
				preferredSize.height);
		
		Alignment contentAlignment = calculateContentAlignment(blockFigure, contentFigure);
		
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
	
	/* (non-Javadoc)
	 * @see org.eclipse.draw2d.AbstractLayout#invalidate()
	 */
	public void invalidate() {
		super.invalidate();
		blockMetrics = null;
		clearPortFigureCache();
		clearFigureCache();
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
	
	private void clearPortFigureCache() {
		westPortFigures = null;
		eastPortFigures = null;
	}
	
	protected IFigure getBodyFigure(BlockFigure blockFigure) {
		if (bodyFigure == null) {
			initializeContentFigureCache(blockFigure);
		}
		return bodyFigure;
	}
	
	protected IFigure getHeaderFigure(BlockFigure blockFigure) {
		if (headerFigure == null) {
			initializeContentFigureCache(blockFigure);
		}
		return headerFigure;
	}

	protected IFigure getFooterFigure(BlockFigure blockFigure) {
		if (footerFigure == null) {
			initializeContentFigureCache(blockFigure);
		}
		return footerFigure;
	}
 
	private void initializeContentFigureCache(BlockFigure blockFigure) {
		for (IFigure contentFigure : blockFigure.getContentFigures()) {
			Object constraint = constraints.get(contentFigure);
			if (constraint instanceof FunctionBlockLayoutData) {
				FunctionBlockLayoutData layoutData = (FunctionBlockLayoutData) constraint;
				switch (layoutData.contentType) {
				case FunctionBlockLayoutData.BODY:
					bodyFigure = contentFigure;
					break;
				case FunctionBlockLayoutData.HEADER:
					headerFigure = contentFigure;
					break;
				case FunctionBlockLayoutData.FOOTER:
					footerFigure = contentFigure;
					break;
				}
			}
		}
	}

	private void clearFigureCache() {
		bodyFigure = null;
		headerFigure = null;
		footerFigure = null;
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.StandardBlockLayout#calculateContentAlignment()
	 */
	protected Alignment calculateContentAlignment(BlockFigure blockFigure, IFigure contentFigure) {
		int horizontalAlignment = SWT.CENTER;
		int verticalAlignment = SWT.CENTER;
		Object constraint = constraints.get(contentFigure);
		if (constraint instanceof FunctionBlockLayoutData) {
			FunctionBlockLayoutData layoutData = (FunctionBlockLayoutData) constraint;
			horizontalAlignment = layoutData.horizontalAlignment;
			verticalAlignment = layoutData.verticalAlignment;
		}
		return Geometry.transformAlignment(
				new Alignment(horizontalAlignment, verticalAlignment), blockFigure.isFlipped(), 0);
	}
	
	/* (non-Javadoc)
	 * @see org.esmp.dsm.diagram.figures.StandardBlockLayout#getPortFigures(org.eclipse.draw2d.IFigure, int)
	 */
	protected List<PortFigure> getPortFigures(BlockFigure blockFigure, int side) {
		int reversedSide = Geometry.reverseTransformSide(side, blockFigure.isFlipped(), 0);
		
		List<PortFigure> portFigures = new ArrayList<PortFigure>();
		for (Object o : blockFigure.getChildren()) {
			if (o instanceof PortFigure && getPortSide((PortFigure) o) == reversedSide) {
				portFigures.add((PortFigure) o);
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
		
		public Dimension bodySize = new Dimension();
		public Dimension headerSize = new Dimension();
		public Dimension footerSize = new Dimension();

		public int preferredWidth;
		public int preferredHeight;
		
	}
	
}
