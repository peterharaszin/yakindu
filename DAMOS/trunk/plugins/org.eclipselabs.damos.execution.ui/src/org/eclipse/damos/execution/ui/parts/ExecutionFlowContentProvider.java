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

package org.eclipse.damos.execution.ui.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.damos.execution.Edge;
import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionFlowContentProvider implements IGraphEntityContentProvider {

	private static final Object[] EMPTY = new Object[0];
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IGraphEntityContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ExecutionFlow) {
			ExecutionFlow executionFlow = (ExecutionFlow) inputElement;
			List<Object> elements = new ArrayList<Object>();
			elements.addAll(executionFlow.getTaskGraphs());
			elements.addAll(executionFlow.getGraph().getNodes());
			return elements.toArray();
		}
		if (inputElement instanceof Graph) {
			return ((Graph) inputElement).getNodes().toArray();
		}
		return EMPTY;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.zest.core.viewers.IGraphEntityContentProvider#getConnectedTo(java.lang.Object)
	 */
	public Object[] getConnectedTo(Object entity) {
		if (entity instanceof Node) {
			Node node = (Node) entity;
			EList<Edge> outgoingEdges = node.getOutgoingEdges();
			Object[] outgoingNodes = new Object[outgoingEdges.size()];
			for (int i = 0; i < outgoingNodes.length; ++i) {
				outgoingNodes[i] = outgoingEdges.get(i).getTarget();
			}
			return outgoingNodes;
		}
		return EMPTY;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
	}

}
