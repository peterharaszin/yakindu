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

package org.eclipse.damos.diagram.ui.figures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.diagram.ui.internal.geometry.Alignment;
import org.eclipse.damos.diagram.ui.internal.geometry.Extents;
import org.eclipse.damos.diagram.ui.internal.geometry.Geometry;
import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

/**
 * @author Andreas Unger
 *
 */
public class StandardComponentLayout extends AbstractLayout {

	private int portPadding = 50;
	private int horizontalContentPadding = 100;
	private int verticalContentPadding = 100;
	
	private boolean equalPortExtents;
	
	private int horizontalContentAlignment = SWT.CENTER;
	private int verticalContentAlignment = SWT.CENTER;
	
	private ComponentMetrics componentMetrics;
	private List<PortFigure> westPortFigures;
	private List<PortFigure> eastPortFigures;
	private List<PortFigure> northPortFigures;
	private List<PortFigure> southPortFigures;
	private IFigure contentFigure;
	
	private Map<IFigure, Object> constraints = new HashMap<IFigure, Object>();
	
	/**
	 * 
	 */
	public StandardComponentLayout() {
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
		ComponentMetrics bm = getComponentMetrics((ComponentFigure) container);
		return new Dimension(bm.preferredWidth, bm.preferredHeight);
	}
	
	protected ComponentMetrics getComponentMetrics(ComponentFigure componentFigure) {
		if (componentMetrics == null) {
			componentMetrics = calculateComponentMetrics(componentFigure);
		}
		return componentMetrics;
	}
	
	protected ComponentMetrics calculateComponentMetrics(ComponentFigure componentFigure) {
		ComponentMetrics bm = new ComponentMetrics();
		
		for (PortFigure portFigure : getWestPortFigures(componentFigure)) {
			bm.west.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.WEST)));
			++bm.west.count;
		}

		for (PortFigure portFigure : getEastPortFigures(componentFigure)) {
			bm.east.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.EAST)));
			++bm.east.count;
		}
		
		for (PortFigure portFigure : getNorthPortFigures(componentFigure)) {
			bm.north.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.NORTH)));
			++bm.north.count;
		}
		
		for (PortFigure portFigure : getSouthPortFigures(componentFigure)) {
			bm.south.extents.union(portFigure.getExtents(Geometry.positionToAngle(PositionConstants.SOUTH)));
			++bm.south.count;
		}
		
		IFigure contentFigure = getContentFigure(componentFigure);
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
		
		IPortLayoutHelper portLayoutHelper = (IPortLayoutHelper) componentFigure.getHelper(IPortLayoutHelper.class);
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
		ComponentFigure componentFigure = (ComponentFigure) container;
		
		ComponentMetrics bm = getComponentMetrics(componentFigure);
		Rectangle bounds = container.getBounds();
		
		IPortLayoutHelper portLayoutHelper = (IPortLayoutHelper) componentFigure.getHelper(IPortLayoutHelper.class);
		
		if (bm.west.count > 0) {
			int spacing = bounds.height / bm.west.count;
			int y = bounds.y + spacing / 2;
			for (PortFigure portFigure : getWestPortFigures(componentFigure)) {
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
			for (PortFigure portFigure : getEastPortFigures(componentFigure)) {
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
			for (PortFigure portFigure : getNorthPortFigures(componentFigure)) {
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
			for (PortFigure portFigure : getSouthPortFigures(componentFigure)) {
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
		
		IFigure contentFigure = getContentFigure(componentFigure);
		if (contentFigure != null) {
			Insets contentInsets = new Insets();
			contentInsets.left = bm.west.extents.right + horizontalContentPadding;
			contentInsets.right = bm.east.extents.left + horizontalContentPadding;
			contentInsets.top = bm.north.extents.bottom + verticalContentPadding;
			contentInsets.bottom = bm.south.extents.top + verticalContentPadding;
			Rectangle contentBounds = bounds.getShrinked(contentInsets);
			
			Dimension preferredSize = contentFigure.getPreferredSize();
			Rectangle childBounds = new Rectangle(
					contentBounds.x,
					contentBounds.y,
					preferredSize.width,
					preferredSize.height);
			
			Alignment contentAlignment = calculateContentAlignment(componentFigure);
			
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
		componentMetrics = null;
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
	
	private List<PortFigure> getWestPortFigures(ComponentFigure componentFigure) {
		if (westPortFigures == null) {
			westPortFigures = getPortFigures(componentFigure, PositionConstants.WEST);
		}
		return westPortFigures;
	}
		
	private List<PortFigure> getEastPortFigures(ComponentFigure componentFigure) {
		if (eastPortFigures == null) {
			eastPortFigures = getPortFigures(componentFigure, PositionConstants.EAST);
		}
		return eastPortFigures;
	}
	
	private List<PortFigure> getNorthPortFigures(ComponentFigure componentFigure) {
		if (northPortFigures == null) {
			northPortFigures = getPortFigures(componentFigure, PositionConstants.NORTH);
		}
		return northPortFigures;
	}
	
	private List<PortFigure> getSouthPortFigures(ComponentFigure componentFigure) {
		if (southPortFigures == null) {
			southPortFigures = getPortFigures(componentFigure, PositionConstants.SOUTH);
		}
		return southPortFigures;
	}
	
	protected IFigure getContentFigure(ComponentFigure componentFigure) {
		if (contentFigure == null) {
			contentFigure = componentFigure.getPrimaryContentFigure();
		}
		return contentFigure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.StandardComponentLayout#calculateContentAlignment()
	 */
	protected Alignment calculateContentAlignment(ComponentFigure componentFigure) {
		return Geometry.transformAlignment(
				new Alignment(getHorizontalContentAlignment(), getVerticalContentAlignment()), componentFigure.isFlipped(), componentFigure.getRotation());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.diagram.figures.StandardComponentLayout#getPortFigures(org.eclipse.draw2d.IFigure, int)
	 */
	protected List<PortFigure> getPortFigures(ComponentFigure componentFigure, int side) {
		int reversedSide = Geometry.reverseTransformSide(side, componentFigure.isFlipped(), componentFigure.getRotation());
		
		List<PortFigure> portFigures = new ArrayList<PortFigure>();
		for (Object o : componentFigure.getChildren()) {
			if (o instanceof PortFigure && getPortSide((PortFigure) o) == reversedSide) {
				portFigures.add((PortFigure) o);
			}
		}
		
		if (componentFigure.isFlipped()) {
			switch (componentFigure.getRotation()) {
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
			switch (componentFigure.getRotation()) {
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
		if (constraint instanceof StandardComponentLayoutData) {
			return ((StandardComponentLayoutData) constraint).sideHint;
		}
		return -1;
	}
	
	private class ComponentMetrics {
		
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
