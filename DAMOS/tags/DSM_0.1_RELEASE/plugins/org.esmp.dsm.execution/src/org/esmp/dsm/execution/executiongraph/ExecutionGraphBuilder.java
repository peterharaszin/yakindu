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

package org.esmp.dsm.execution.executiongraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.InputPort;

/**
 * @author Andreas Unger
 *
 */
public class ExecutionGraphBuilder {

	public ExecutionGraph build(BlockDiagram blockDiagram) throws ExecutionGraphDeadlockException {
		return new Context(blockDiagram).execute();
	}

	private static class Context {

		private BlockDiagram blockDiagram;
		
		private ExecutionGraph graph;
		private List<Block> backlog;
		private Map<Block, ExecutionNode> nodes = new HashMap<Block, ExecutionNode>();
		
		public Context(BlockDiagram blockDiagram) {
			this.blockDiagram = blockDiagram;
		}
	
		public ExecutionGraph execute() throws ExecutionGraphDeadlockException {
			graph = ExecutionGraphFactory.eINSTANCE.createExecutionGraph();
			graph.setBlockDiagram(blockDiagram);
			
			backlog = new LinkedList<Block>(blockDiagram.getBlocks());

			boolean changed;
			do {
				changed = false;
				for (Iterator<Block> it = backlog.iterator(); it.hasNext();) {
					Block block = it.next();
					List<Block> drivingBlocks = getDrivingBlocks(block);
					if (drivingBlocks.isEmpty()) {
						addDrivingBlockToExecutionGraph(block);
						it.remove();
						changed = true;
					} else if (drivingBlocksInExecutionGraph(drivingBlocks)) {
						addDrivenBlockToExecutionGraph(block, drivingBlocks);
						it.remove();
						changed = true;
					}
				}
			} while (changed);

			if (!backlog.isEmpty()) {
				throw new ExecutionGraphDeadlockException(backlog);
			}
			
			return graph;
		}
		
		private List<Block> getDrivingBlocks(Block block) {
			List<Block> drivingBlocks = new ArrayList<Block>();
			for (InputPort inputPort : block.getInputPorts()) {
				if (inputPort.isDirectFeedthrough()) {
					if (inputPort.getIncomingConnection() != null) {
						drivingBlocks.add(inputPort.getIncomingConnection().getSourcePort().getBlock());
					}
				}
			}
			return drivingBlocks;
		}
		
		private boolean drivingBlocksInExecutionGraph(List<Block> drivingBlocks) {
			for (Block drivingBlock : drivingBlocks) {
				if (nodes.get(drivingBlock) == null) {
					return false;
				}
			}
			return true;
		}
	
		private void addDrivingBlockToExecutionGraph(Block block) throws ExecutionGraphDeadlockException {
			ExecutionNode node = ExecutionGraphFactory.eINSTANCE.createExecutionNode();
			node.setBlock(block);
			graph.getNodes().add(node);
			graph.getInitialNodes().add(node);
			nodes.put(block, node);
		}
		
		private void addDrivenBlockToExecutionGraph(Block block, List<Block> drivingBlocks) throws ExecutionGraphDeadlockException {
			ExecutionNode node = ExecutionGraphFactory.eINSTANCE.createExecutionNode();
			node.setBlock(block);
			graph.getNodes().add(node);
	
			for (Block drivingBlock : drivingBlocks) {
				ExecutionEdge edge = ExecutionGraphFactory.eINSTANCE.createExecutionEdge();
				graph.getEdges().add(edge);
				edge.setSource(nodes.get(drivingBlock));
				edge.setTarget(node);
			}
			
			nodes.put(block, node);
		}
		
	}
	
}
