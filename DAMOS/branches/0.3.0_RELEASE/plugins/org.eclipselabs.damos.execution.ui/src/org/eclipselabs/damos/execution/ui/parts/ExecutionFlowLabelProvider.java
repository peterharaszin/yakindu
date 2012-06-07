/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.ui.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.IEntityStyleProvider;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.Node;
import org.eclipselabs.damos.execution.Subgraph;
import org.eclipselabs.damos.execution.TaskGraph;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionFlowLabelProvider extends LabelProvider implements IEntityStyleProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof ComponentNode) {
			return ((ComponentNode) element).getComponent().getName();
		}
		if (element instanceof TaskGraph) {
			TaskGraph taskGraph = (TaskGraph) element;
			if (!taskGraph.getInitialNodes().isEmpty()) {
				Node node = taskGraph.getInitialNodes().get(0);
				if (node instanceof ComponentNode) {
					return ((ComponentNode) node).getComponent().getName() + " Task";
				}
			}
			return "TaskGraph";
		}
		if (element instanceof CompoundNode) {
			CompoundNode compoundNode = (CompoundNode) element;
			if (compoundNode.getCompound() instanceof WhileLoop) {
				return "While Loop";
			}
			if (compoundNode.getCompound() instanceof Action) {
				return "Action";
			}
			return "CompoundNode";
		}
		if (element instanceof EntityConnectionData) {
			return "";
		}
		return super.getText(element);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#getNodeHighlightColor(java.lang.Object)
	 */
	public Color getNodeHighlightColor(Object entity) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#getBorderColor(java.lang.Object)
	 */
	public Color getBorderColor(Object entity) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#getBorderHighlightColor(java.lang.Object)
	 */
	public Color getBorderHighlightColor(Object entity) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#getBorderWidth(java.lang.Object)
	 */
	public int getBorderWidth(Object entity) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#getBackgroundColour(java.lang.Object)
	 */
	public Color getBackgroundColour(Object entity) {
		if (entity instanceof TaskGraph) {
			return ColorConstants.orange;
		}
		if (entity instanceof Subgraph) {
			return ColorConstants.lightGreen;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#getForegroundColour(java.lang.Object)
	 */
	public Color getForegroundColour(Object entity) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#getTooltip(java.lang.Object)
	 */
	public IFigure getTooltip(Object entity) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IEntityStyleProvider#fisheyeNode(java.lang.Object)
	 */
	public boolean fisheyeNode(Object entity) {
		return false;
	}
	
}
