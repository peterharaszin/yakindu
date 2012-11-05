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

package org.eclipse.damos.execution.internal.operations;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.damos.execution.ExecutionFlow;
import org.eclipse.damos.execution.Graph;
import org.eclipse.damos.execution.Node;
import org.eclipse.damos.execution.TaskGraph;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.TreeIterator;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionFlowOperations {

	static final Iterator<Node> EMPTY_NODE_ITERATOR = new Iterator<Node>() {

		public boolean hasNext() {
			return false;
		}

		public Node next() {
			throw new NoSuchElementException();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	};

	public static TreeIterator<Node> getAllNodesIterator(ExecutionFlow executionFlow) {
		return new AbstractTreeIterator<Node>(executionFlow, false) {
			
			private static final long serialVersionUID = 1L;

			@Override
			protected Iterator<? extends Node> getChildren(Object object) {
				if (object instanceof ExecutionFlow) {
					return new ExecutionFlowNodeIterator((ExecutionFlow) object);
				}
				if (object instanceof Graph) {
					return ((Graph) object).getNodes().iterator();
				}
				return EMPTY_NODE_ITERATOR;
			}
			
		};
	}
	
	public static Iterable<Node> getAllNodes(final ExecutionFlow executionFlow) {
		return new Iterable<Node>() {
			
			public Iterator<Node> iterator() {
				return executionFlow.getAllNodesIterator();
			}
			
		};
	}

	private static class ExecutionFlowNodeIterator implements Iterator<Node> {

		private Iterator<Node> taskGraphNodeIterator;
		private Iterator<Node> nodeIterator;
		
		/**
		 * 
		 */
		public ExecutionFlowNodeIterator(ExecutionFlow executionFlow) {
			taskGraphNodeIterator = new TaskGraphNodeIterator(executionFlow.getTaskGraphs().iterator());
			nodeIterator = executionFlow.getGraph().getNodes().iterator();
		}
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return taskGraphNodeIterator.hasNext() || nodeIterator.hasNext();
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		public Node next() {
			return taskGraphNodeIterator.hasNext() ? taskGraphNodeIterator.next() : nodeIterator.next();
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	private static class TaskGraphNodeIterator implements Iterator<Node> {

		private Iterator<TaskGraph> taskGraphIterator;
		private Iterator<Node> currentNodeIterator;
		
		/**
		 * 
		 */
		public TaskGraphNodeIterator(Iterator<TaskGraph> taskGraphIterator) {
			this.taskGraphIterator = taskGraphIterator;
			if (taskGraphIterator.hasNext()) {
				currentNodeIterator = taskGraphIterator.next().getNodes().iterator();
			}
		}
		
		/* (non-Javadoc)
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			if (currentNodeIterator == null) {
				return false;
			}
			if (currentNodeIterator.hasNext()) {
				return true;
			}
			if (!taskGraphIterator.hasNext()) {
				return false;
			}
			currentNodeIterator = taskGraphIterator.next().getNodes().iterator();
			return currentNodeIterator.hasNext();
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#next()
		 */
		public Node next() {
			if (currentNodeIterator == null) {
				throw new NoSuchElementException();
			}
			if (currentNodeIterator.hasNext()) {
				return currentNodeIterator.next();
			}
			currentNodeIterator = taskGraphIterator.next().getNodes().iterator();
			return currentNodeIterator.next();
		}

		/* (non-Javadoc)
		 * @see java.util.Iterator#remove()
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
