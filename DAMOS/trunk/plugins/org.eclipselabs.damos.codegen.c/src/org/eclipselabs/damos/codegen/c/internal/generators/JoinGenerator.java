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

package org.eclipselabs.damos.codegen.c.internal.generators;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator;
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil;
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.execution.ActionNode;
import org.eclipselabs.damos.execution.ComponentNode;
import org.eclipselabs.damos.execution.CompoundNode;
import org.eclipselabs.damos.execution.DataFlowSourceEnd;
import org.eclipselabs.damos.execution.DataFlowTargetEnd;
import org.eclipselabs.damos.execution.Graph;
import org.eclipselabs.damos.execution.Node;

/**
 * @author Andreas Unger
 *
 */
public class JoinGenerator extends AbstractComponentGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#writeComputeOutputsCode(java.lang.Appendable, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Appendable appendable, IProgressMonitor monitor) throws IOException {
		PrintAppendable out = new PrintAppendable(appendable);
		
		Map<Integer, String> variableNameMap = new TreeMap<Integer, String>();
		ComponentNode choiceNode = null;
		for (InputPort inputPort : getComponent().getInputPorts()) {
			DataFlowTargetEnd targetEnd = getNode().getIncomingDataFlow(inputPort);
			DataFlowSourceEnd sourceEnd = targetEnd.getDataFlow().getSourceEnd();
			CompoundNode enclosingCompoundNode = findEnclosingActionNodeWithActionLink(sourceEnd.getNode());
			if (enclosingCompoundNode instanceof ActionNode) {
				ActionNode actionNode = (ActionNode) enclosingCompoundNode;
				Action action = (Action) actionNode.getCompound();
				if (actionNode.getChoiceNode() != null) {
					variableNameMap.put(DMLUtil.indexOf(action.getLink()), InternalGeneratorUtil.getIncomingVariableName(getConfiguration(), getNode(), inputPort));
					choiceNode = actionNode.getChoiceNode();
				}
			}
		}
		out.printf("switch (%s) {\n", CompoundGeneratorUtil.getChoiceVariableName(getConfiguration(), choiceNode));
		for (Entry<Integer, String> entry : variableNameMap.entrySet()) {
			out.printf("case %d:\n", entry.getKey());
			out.printf("%s = %s;\n", InternalGeneratorUtil.getOutputVariableName(getConfiguration(), getNode(), getComponent().getFirstOutputPort()), entry.getValue());
			out.println("break;");
		}
		out.println("}");
	}
	
	private CompoundNode findEnclosingActionNodeWithActionLink(Node node) {
		Graph graph;
		for (;;) {
			graph = node.getGraph();
			if (graph instanceof CompoundNode) {
				CompoundNode compoundNode = (CompoundNode) graph;
				if (compoundNode.getCompound() instanceof Action) {
					Action action = (Action) compoundNode.getCompound();
					if (action.getLink() != null) {
						return compoundNode;
					}
				}
			}
			if (graph instanceof Node) {
				node = (Node) graph;
			} else {
				break;
			}
		}
		return null;
	}

}
