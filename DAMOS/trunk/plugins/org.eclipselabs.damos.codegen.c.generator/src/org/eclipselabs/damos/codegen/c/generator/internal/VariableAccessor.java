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

package org.eclipselabs.damos.codegen.c.generator.internal;

import org.apache.commons.lang.StringUtils;
import org.eclipselabs.damos.codegen.c.cgenmodel.GenModel;
import org.eclipselabs.damos.codegen.c.generator.IVariableAccessor;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.execution.executiongraph.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.executiongraph.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.executiongraph.Node;

/**
 * @author Andreas Unger
 *
 */
public class VariableAccessor implements IVariableAccessor {

	private GenModel genModel;
	private Node node;
	
	/**
	 * 
	 */
	public VariableAccessor(GenModel genModel, Node node) {
		this.node = node;
		this.genModel = genModel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IVariableAccessor#getContextVariable(boolean)
	 */
	public String getContextVariable(boolean pointer) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("(&");
		}
		String prefix = genModel.getGenTopLevelSystem().getPrefix();
		if (prefix != null) {
			sb.append(prefix);
		}
		sb.append("context.");
		sb.append(InternalGeneratorUtil.getPrefix(genModel, node) + node.getComponent().getName());
		if (pointer) {
			sb.append(")");
		}
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IVariableAccessor#getInputVariable(boolean)
	 */
	public String getInputVariable(InputPort inputPort, boolean pointer) {
		DataFlowTargetEnd targetEnd = node.getIncomingDataFlow(inputPort);
		DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
		OutputPort sourcePort = sourceEnd.getPort();
		return getOutputVariable(sourcePort, pointer, sourceEnd.getNode());
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IVariableAccessor#getOutputVariable(boolean)
	 */
	public String getOutputVariable(OutputPort outputPort, boolean pointer) {
		return getOutputVariable(outputPort, pointer, node);
	}
	
	private String getOutputVariable(OutputPort outputPort, boolean pointer, Node node) {
		StringBuilder sb = new StringBuilder();
		if (pointer) {
			sb.append("(&");
		}
		if (outputPort.getComponent() instanceof Inport) {
			sb.append("input->");
			sb.append(StringUtils.uncapitalize(outputPort.getComponent().getName()));
		} else {
			BlockOutput output = (BlockOutput) outputPort.getOutput();
			sb.append(InternalGeneratorUtil.getPrefix(genModel, node) + outputPort.getComponent().getName());
			sb.append("_");
			sb.append(output.getDefinition().getName());
			if (output.getDefinition().isManyPorts()) {
				sb.append(outputPort.getIndex());
			}
		}
		if (pointer) {
			sb.append(")");
		}
		return sb.toString();
	}

}
