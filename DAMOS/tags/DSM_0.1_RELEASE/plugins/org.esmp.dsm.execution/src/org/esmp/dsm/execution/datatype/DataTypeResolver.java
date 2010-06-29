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

package org.esmp.dsm.execution.datatype;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.esmp.dsm.execution.datatype.util.DataTypeUtil;
import org.esmp.dsm.execution.datatype.util.OutputDataTypeSpecifierCategoryConstants;
import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.expressions.BooleanDataType;
import org.esmp.dsm.expressions.DataType;
import org.esmp.dsm.expressions.util.ExpressionsUtil;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.IOType;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolver {

	public void resolve(ExecutionGraph graph, DataType defaultDataType) throws InvalidDataTypeException {
		new Context(graph, defaultDataType).execute();
	}

	private static class Context {
		
		private ExecutionGraph graph;
		private DataType defaultDataType;
		
		/**
		 * 
		 */
		public Context(ExecutionGraph graph, DataType defaultDataType) {
			this.graph = graph;
			this.defaultDataType = defaultDataType;
		}
		
		public void execute() throws InvalidDataTypeException {
			List<ExecutionNode> backlog = new LinkedList<ExecutionNode>(graph.getNodes());

			URI uri = URI.createURI(OutputDataTypeSpecifierCategoryConstants.URI);
			
			for (Iterator<ExecutionNode> it = backlog.iterator(); it.hasNext();) {
				Block block = it.next().getBlock();
				if (isPureLogicBlock(block)) {
					adaptBlockDataType(block, new BooleanDataType());
					it.remove();
				} else if (block.getType().belongsTo(uri)) {
					DataType dataType = ExpressionsUtil.parseDataTypeExpression(block.getParameterValue(OutputDataTypeSpecifierCategoryConstants.PARAMETER__OUTPUT_DATA_TYPE));
					if (dataType != null) {
						adaptBlockDataType(block, dataType);
						it.remove();
					}
				}
			}
			
			setBlockDataTypeToInputDataType(backlog, false);
			setBlockDataTypeToInputDataType(backlog, true);
			setBlockDataTypeToTargetInputDataType(backlog);

			for (ExecutionNode node : backlog) {
				adaptBlockDataType(node.getBlock(), defaultDataType);
			}
			
			List<Block> invalidBlocks = new ArrayList<Block>();
			
			for (ExecutionNode node : graph.getNodes()) {
				if (!validateDataTypes(node.getBlock())) {
					invalidBlocks.add(node.getBlock());
				}
			}

			if (!invalidBlocks.isEmpty()) {
				throw new InvalidDataTypeException(invalidBlocks);
			}
		}
		
		private boolean isPureLogicBlock(Block block) {
			List<OutputPort> outputPorts = block.getOutputPorts();
			if (outputPorts.isEmpty()) {
				return false;
			}
			for (OutputPort outputPort : outputPorts) {
				if (outputPort.getOutput().getSpecification().getType() != IOType.LOGIC) {
					return false;
				}
			}
			return true;
		}
		
		private void setBlockDataTypeToInputDataType(List<ExecutionNode> backlog, boolean considerBooleanDataType) {
			boolean changed;
			do {
				changed = false;
				for (Iterator<ExecutionNode> it = backlog.iterator(); it.hasNext();) {
					Block block = it.next().getBlock();
					DataType dataType = getInputDataType(block, considerBooleanDataType);
					if (dataType != null) {
						adaptBlockDataType(block, dataType);
						it.remove();
						changed = true;
					}
				}
			} while (changed);
		}
				
		private void setBlockDataTypeToTargetInputDataType(List<ExecutionNode> backlog) {
			boolean changed;
			do {
				changed = false;
				for (Iterator<ExecutionNode> it = backlog.iterator(); it.hasNext();) {
					Block block = it.next().getBlock();
					DataType dataType = getTargetInputDataType(block); 
					if (dataType != null) {
						adaptBlockDataType(block, dataType);
						it.remove();
						changed = true;
					}
				}
			} while (changed);
		}
		
		private DataType getTargetInputDataType(Block block) {
			DataType targetBlockDataType = null;
			for (OutputPort outputPort : block.getOutputPorts()) {
				for (Connection outgoingConnection : outputPort.getOutgoingConnections()) {
					Block targetBlock = outgoingConnection.getTargetPort().getBlock(); 
					DataType dataType = getInputDataType(targetBlock, false);
					if (dataType == null) {
						dataType = getInputDataType(targetBlock, true);
					}
					if (dataType != null) {
						if (targetBlockDataType != null && !dataType.equals(targetBlockDataType)) {
							return null;
						}
						targetBlockDataType = dataType;
					}
				}
			}
			return targetBlockDataType;
		}
		
		private DataType getInputDataType(Block block, boolean considerBooleanDataType) {
			for (InputPort inputPort : block.getInputPorts()) {
				DataType dataType = DataTypeUtil.getDataType(inputPort);
				if (dataType != null && (considerBooleanDataType || !(dataType instanceof BooleanDataType))) {
					return dataType;
				}
			}
			return null;
		}
		
		private boolean validateDataTypes(Block block) {
			for (InputPort inputPort : block.getInputPorts()) {
				if (inputPort.getInput().getSpecification().getType() == IOType.SCALAR) {
					if (DataTypeUtil.getDataType(inputPort) instanceof BooleanDataType) {
						return false;
					}
				} else if (inputPort.getInput().getSpecification().getType() == IOType.LOGIC) {
					if (!(DataTypeUtil.getDataType(inputPort) instanceof BooleanDataType)) {
						return false;
					}
				}
			}
			
			for (OutputPort outputPort : block.getOutputPorts()) {
				if (outputPort.getOutput().getSpecification().getType() == IOType.SCALAR) {
					if (DataTypeUtil.getDataType(block) instanceof BooleanDataType) {
						return false;
					}
				} else if (outputPort.getOutput().getSpecification().getType() == IOType.LOGIC) {
					if (!(DataTypeUtil.getDataType(block) instanceof BooleanDataType)) {
						return false;
					}
				}
			}
			
			DataType dataType = null;
			for (InputPort inputPort : block.getInputPorts()) {
				if (inputPort.getInput().getSpecification().getType() != IOType.LOGIC && inputPort.getIncomingConnection() != null) {
					DataType t = DataTypeUtil.getDataType(inputPort);
					if (t == null) {
						return false;
					}
					if (dataType == null) {
						dataType = t;
					} else if (!dataType.equals(t)) {
						return false;
					}
				}
			}
			
			return true;
		}
		
		private void adaptBlockDataType(Block block, DataType dataType) {
			block.eAdapters().add(new DataTypeAdapter(dataType));
			for (OutputPort outputPort : block.getOutputPorts()) {
				for (Connection outgoingConnection : outputPort.getOutgoingConnections()) {
					outgoingConnection.getTargetPort().eAdapters().add(new DataTypeAdapter(dataType));
				}
			}
		}

	}
	
}
