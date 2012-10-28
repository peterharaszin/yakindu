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

package org.eclipse.damos.codegen.c

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.codegen.c.internal.util.CompoundGeneratorUtil
import org.eclipse.damos.dml.Action
import org.eclipse.damos.dml.Choice
import org.eclipse.damos.dml.Memory
import org.eclipse.damos.dml.WhileLoop
import org.eclipse.damos.execution.ActionNode
import org.eclipse.damos.execution.ComponentNode
import org.eclipse.damos.execution.CompoundNode
import org.eclipse.damos.execution.Graph
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipse.damos.codegen.c.util.GeneratorHelper

import static extension org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class CompoundGenerator implements ICompoundGenerator {

	@Inject
	IGraphGenerator graphGenerator
	
	@Inject
	DataTypeGenerator dataTypeGenerator

	@Inject
	GeneratorHelper generatorHelper

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
					} while («generatorHelper.getIncomingVariableName(context.configuration, actionNode, whileLoop.condition) ?: "0"»);
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
		val initializer = generatorHelper.getIncomingVariableName(context.configuration, node, node.component.firstInputPort)
		
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
