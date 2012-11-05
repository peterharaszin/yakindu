/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/

package org.eclipse.damos.execution.internal.operations;

import java.util.Iterator;

import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;

/**
 * @author Andreas Unger
 *
 */
public class GraphOperations {

	public static TreeIterator<Node> getAllNodesIterator(Graph graph) {
		return new AbstractTreeIterator<Node>(graph, false) {

			private static final long serialVersionUID = 1L;
			
			@Override
			protected Iterator<? extends Node> getChildren(Object object) {
				if (object instanceof Graph) {
					return ((Graph) object).getNodes().iterator();
				}
				return ExecutionFlowOperations.EMPTY_NODE_ITERATOR;
			}
			
		};
	}

	public static Iterable<Node> getAllNodes(final Graph graph) {
		return new Iterable<Node>() {
			
			public Iterator<Node> iterator() {
				return graph.getAllNodesIterator();
			}
			
		};
	}

}
