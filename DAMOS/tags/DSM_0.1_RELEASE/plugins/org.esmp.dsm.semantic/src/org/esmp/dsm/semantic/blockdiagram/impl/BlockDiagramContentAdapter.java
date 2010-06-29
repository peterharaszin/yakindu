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

package org.esmp.dsm.semantic.blockdiagram.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;

/**
 * @author Andreas Unger
 *
 */
class BlockDiagramContentAdapter extends EContentAdapter {

	private static final int NONE = 0;
	private static final int FORWARD = 1;
	private static final int BACKWARD = 2;
	
	private BlockDiagram blockDiagram;

	/**
	 * 
	 */
	public BlockDiagramContentAdapter(BlockDiagram blockDiagram) {
		this.blockDiagram = blockDiagram;
	}
	
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object feature = notification.getFeature();
		if (feature == BlockDiagramPackage.eINSTANCE.getInputPort_IncomingConnection() || feature == BlockDiagramPackage.eINSTANCE.getOutputPort_OutgoingConnections()) {
			refreshVirtualElements();
		}
	}

	/**
	 * 
	 */
	private void refreshVirtualElements() {
		Set<Block> virtualBlocks = new HashSet<Block>();
		for (Block block : blockDiagram.getBlocks()) {
			propagateVirtual(block, NONE, virtualBlocks);
		}
		for (Block block : blockDiagram.getBlocks()) {
			if (block.getType().isVirtual()) {
				if (!block.isVirtual()) {
					block.setVirtual(true);
				}
			} else {
				if (block.isVirtual() && !virtualBlocks.contains(block)) {
					block.setVirtual(false);
				}
			}
		}
		for (Connection connection : blockDiagram.getConnections()) {
			OutputPort sourcePort = connection.getSourcePort();
			InputPort targetPort = connection.getTargetPort();
			if (sourcePort != null && targetPort != null) {
				boolean virtual = sourcePort.getBlock().isVirtual() || targetPort.getBlock().isVirtual();
				if (connection.isVirtual() != virtual) {
					connection.setVirtual(virtual);
				}
			}
		}
	}
	
	private void propagateVirtual(Block block, int direction, Set<Block> virtualBlocks) {
		for (Input input : block.getInputs()) {
			if (direction == BACKWARD || input.getSpecification().isVirtual()) {
				for (InputPort inputPort : input.getPorts()) {
					Connection connection = inputPort.getIncomingConnection();
					if (connection != null) {
						OutputPort sourcePort = connection.getSourcePort();
						if (sourcePort != null) {
							Block sourceBlock = sourcePort.getBlock();
							if (!hasVirtualIO(sourceBlock)) {
								if (virtualBlocks.add(sourceBlock) && !sourceBlock.isVirtual()) {
									sourceBlock.setVirtual(true);
								}
								propagateVirtual(sourceBlock, BACKWARD, virtualBlocks);
							}
						}
					}
				}
			}
		}
		for (Output output : block.getOutputs()) {
			if (direction == FORWARD || output.getSpecification().isVirtual()) {
				for (OutputPort outputPort : output.getPorts()) {
					for (Connection connection : outputPort.getOutgoingConnections()) {
						InputPort targetPort = connection.getTargetPort();
						if (targetPort != null) {
							Block targetBlock = targetPort.getBlock();
							if (!hasVirtualIO(targetBlock)) {
								if (virtualBlocks.add(targetBlock) && !targetBlock.isVirtual()) {
									targetBlock.setVirtual(true);
								}
								propagateVirtual(targetBlock, FORWARD, virtualBlocks);
							}
						}
					}
				}
			}
		}
	}
	
	private boolean hasVirtualIO(Block block) {
		for (Input input : block.getInputs()) {
			if (input.getSpecification().isVirtual()) {
				return true;
			}
		}
		for (Output output : block.getOutputs()) {
			if (output.getSpecification().isVirtual()) {
				return true;
			}
		}
		return false;
	}
	
}
