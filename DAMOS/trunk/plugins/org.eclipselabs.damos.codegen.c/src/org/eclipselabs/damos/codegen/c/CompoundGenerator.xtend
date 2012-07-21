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

package org.eclipselabs.damos.codegen.c

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.internal.util.CompoundGeneratorUtil
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil
import org.eclipselabs.damos.dml.Action
import org.eclipselabs.damos.dml.Choice
import org.eclipselabs.damos.dml.Memory
import org.eclipselabs.damos.dml.WhileLoop
import org.eclipselabs.damos.execution.ActionNode
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.execution.CompoundNode
import org.eclipselabs.damos.execution.Graph
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator

import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class CompoundGenerator implements ICompoundGenerator {

	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();

	val IGraphGenerator graphGenerator
	
	@Inject
	new(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator
	}

	override boolean contributesChoiceVariableDeclarations(IGeneratorContext context, Graph graph) {
		graph.allNodes.filter(typeof(ComponentNode)).exists(n | n.component instanceof Choice)
	}

	override CharSequence generateChoiceVariableDeclarations(IGeneratorContext context, Graph graph, IProgressMonitor monitor) '''
		«FOR node : graph.allNodes.filter(typeof(ComponentNode)).filter(n | n.component instanceof Choice)»
			uint_fast8_t «CompoundGeneratorUtil::getChoiceVariableName(context.configuration, node)»;
		«ENDFOR»
	'''

	override CharSequence generateCompoundCode(IGeneratorContext context, CompoundNode compoundNode, IProgressMonitor monitor) {
		if (!(compoundNode instanceof ActionNode)) {
			return ""
		}
		
		val actionNode = compoundNode as ActionNode
		val action = actionNode.compound as Action

		val whileLoop = if (action instanceof WhileLoop) {
			action as WhileLoop
		}
		
		val choice = if (actionNode.choiceNode != null) {
			actionNode.choiceNode.component as Choice
		}

		val prefix = context.configuration.getPrefix(compoundNode)

		'''
			«IF choice != null»			
				if («prefix»«choice.name»_result == «getActionIndex(choice, action)») {
			«ELSE»
				{
			«ENDIF»
				«FOR node : compoundNode.nodes.filter(typeof(ComponentNode)).filter(n | n.component instanceof Memory)»
					«generateMemoryVariableDeclaration(context, node)»
				«ENDFOR»
				«IF whileLoop != null»
					do {
						«graphGenerator.generateGraph(context, compoundNode, monitor)»
					} while («GeneratorUtil::getIncomingVariableName(context.configuration, actionNode, whileLoop.condition) ?: "0"»);
				«ELSE»
					«graphGenerator.generateGraph(context, compoundNode, monitor)»
				«ENDIF»
			}
		'''
	}
	
	def private generateMemoryVariableDeclaration(IGeneratorContext context, ComponentNode node) {
		val generator = node.componentGenerator
		val computationModel = context.configuration.getComputationModel(node)
		val outputDataType = generator.context.componentSignature.getOutputDataType(node.component.firstOutputPort)
		val variableName = CompoundGeneratorUtil::getMemoryPreviousValueVariableName(context.configuration, node)
		val dataType = dataTypeGenerator.generateDataType(new MscriptGeneratorConfiguration(computationModel, context.configuration), variableName, generator.context.codeFragmentCollector, outputDataType, null)
		val initializer = GeneratorUtil::getIncomingVariableName(context.configuration, node, node.component.firstInputPort)
		
		'''«dataType» = «initializer»;'''
	}
	
	def private int getActionIndex(Choice choice, Action action) {
		var index = 0
		for (actionLink : choice.actionLinks) {
			if (actionLink.action == action) {
				return index
			}
			index = index + 1
		}
		return index
	}

}
