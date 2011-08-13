/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.executionflow.internal.operations;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipselabs.damos.execution.executionflow.Graph;
import org.eclipselabs.damos.execution.executionflow.Node;

/**
 * @author Andreas Unger
 *
 */
public class GraphOperations {

	private static final Iterator<Node> EMPTY_NODE_ITERATOR = new Iterator<Node>() {

		public boolean hasNext() {
			return false;
		}

		public Node next() {
			throw new NoSuchElementException();
		}

		public void remove() {
		}
		
	};

	public static TreeIterator<Node> getAllNodes(Graph graph) {
		return new AbstractTreeIterator<Node>(graph, false) {

			private static final long serialVersionUID = 1L;
			
			@Override
			protected Iterator<? extends Node> getChildren(Object object) {
				if (object instanceof Graph) {
					return ((Graph) object).getNodes().iterator();
				}
				return EMPTY_NODE_ITERATOR;
			}
			
		};
	}

}
