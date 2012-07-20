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

package org.eclipselabs.damos.codegen.c.internal.componentgenerators

import java.util.TreeMap
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.AbstractComponentGenerator
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil
import org.eclipselabs.damos.dml.Action
import org.eclipselabs.damos.dml.InputPort
import org.eclipselabs.damos.dml.util.DMLUtil
import org.eclipselabs.damos.execution.ActionNode
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.execution.CompoundNode
import org.eclipselabs.damos.execution.Graph
import org.eclipselabs.damos.execution.Node
import org.eclipselabs.damos.codegen.c.internal.VariableAccessor

/**
 * @author Andreas Unger
 *
 */
class JoinGenerator extends AbstractComponentGenerator {

	override boolean contributesComputeOutputsCode() {
		return true
	}
	
	override CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		val variableNameMap = new TreeMap<Integer, String>()
		var choiceNode = null as ComponentNode
		for (InputPort inputPort : component.inputPorts) {
			val targetEnd = node.getIncomingDataFlow(inputPort)
			val sourceEnd = targetEnd.sourceEnd
			val enclosingCompoundNode = findEnclosingActionNodeWithActionLink(sourceEnd.node)
			if (enclosingCompoundNode instanceof ActionNode) {
				val actionNode = enclosingCompoundNode as ActionNode
				val action = actionNode.compound as Action
				if (actionNode.choiceNode != null) {
					val incomingVariableName = GeneratorUtil::getIncomingVariableName(configuration, node, inputPort)
					variableNameMap.put(DMLUtil::indexOf(action.link), incomingVariableName)
					choiceNode = actionNode.choiceNode
				}
			}
		}
		
		val choiceVariableName = CompoundGeneratorUtil::getChoiceVariableName(configuration, choiceNode)
		val outputVariableName = new VariableAccessor(configuration, node).generateOutputVariableReference(component.firstOutputPort, false)

		'''
			switch («choiceVariableName») {
			«FOR entry : variableNameMap.entrySet»
				case «entry.key»:
					«outputVariableName» = «entry.value»;
					break;
			«ENDFOR»
			}
		'''
	}
	
	def private CompoundNode findEnclosingActionNodeWithActionLink(Node startNode) {
		var node = startNode
		var Graph graph
		while (true) {
			graph = node.graph
			if (graph instanceof CompoundNode) {
				val compoundNode = graph as CompoundNode
				if (compoundNode.compound instanceof Action) {
					val action = compoundNode.compound as Action
					if (action.link != null) {
						return compoundNode
					}
				}
			}
			if (graph instanceof Node) {
				node = graph as Node
			} else {
				return null
			}
		}
	}

}
