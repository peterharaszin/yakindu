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
import java.util.ArrayList
import java.util.Collection
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.util.GeneratorUtil
import org.eclipselabs.damos.dml.Inoutport
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.execution.CompoundNode
import org.eclipselabs.damos.execution.Graph
import org.eclipselabs.damos.execution.Node
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.Include

import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class GraphGenerator implements IGraphGenerator {

	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();

	val ICompoundGenerator compoundGenerator
	val ITaskGenerator taskGenerator
	
	@Inject
	new(ICompoundGenerator compoundGenerator, ITaskGenerator taskGenerator) {
		this.compoundGenerator = compoundGenerator
		this.taskGenerator = taskGenerator
	}
	
	override Collection<Include> getImplementationIncludes(IGeneratorContext context, Graph graph) {
		val allIncludes = new ArrayList<Include>()
		
		val nodes = graph.getAllNodes()
				.filter(typeof(ComponentNode))
				.filter(n | !(n.component instanceof Inoutport))
		
		for (node : nodes) {
			val generator = node.componentGenerator
			if (generator.contributesComputeOutputsCode) {
				val includes = generator.getComputeOutputsCodeIncludes
				if (includes != null) {
					allIncludes.addAll(includes)
				}
			}
			if (generator.contributesUpdateCode) {
				val includes = generator.getUpdateCodeIncludes
				if (includes != null) {
					allIncludes.addAll(includes)
				}
			}
		}
		
		return allIncludes;
	}
	
	override CharSequence generateGraph(IGeneratorContext context, Graph graph, IProgressMonitor monitor) {
		val computeOutputsNodes = graph.nodes
				.filter(n | contributesComputeOutputsCode(context, n))
		
		val updateNodes = graph.nodes
				.filter(typeof(ComponentNode))
				.filter(n | n.componentGenerator.contributesUpdateCode)
				
		'''
			«IF compoundGenerator.contributesChoiceVariableDeclarations(context, graph)»
				«compoundGenerator.generateChoiceVariableDeclarations(context, graph, monitor)»
				
			«ENDIF»
			«IF !computeOutputsNodes.empty»
				/*
				 * Compute outputs
				 */
				
			«ENDIF»
			«FOR node : computeOutputsNodes SEPARATOR "\n"»
				«generateComputeOutputsCode(context, node, monitor)»
			«ENDFOR»
			«IF !computeOutputsNodes.empty && !updateNodes.empty»
			
			«ENDIF»
			«IF !updateNodes.empty»
				/*
				 * Update states
				 */
				
			«ENDIF»
			«FOR node : updateNodes SEPARATOR "\n"»
				/* «node.component.name» */
				{
					«node.componentGenerator.generateUpdateCode(monitor)»
				}
			«ENDFOR»
		'''
	}
	
	def private contributesComputeOutputsCode(IGeneratorContext context, Node node) {
		if (node instanceof CompoundNode) {
			return true
		}
		if (node instanceof ComponentNode) {
			val componentNode = node as ComponentNode
			return componentNode.componentGenerator.contributesComputeOutputsCode
					|| taskGenerator.contributesLatchUpdate(context, componentNode)
					|| taskGenerator.contributesMessageQueueSend(context, componentNode)
		}
		return false
	}

	def private dispatch generateComputeOutputsCode(IGeneratorContext context, CompoundNode node, IProgressMonitor monitor) {
		compoundGenerator.generateCompoundCode(context, node, monitor)
	}
	
	def private dispatch generateComputeOutputsCode(IGeneratorContext context, ComponentNode node, IProgressMonitor monitor) {
		val generator = node.componentGenerator
		'''
			«IF generator.contributesComputeOutputsCode»
				/* «node.component.name» */
				{
					«generator.generateComputeOutputsCode(monitor)»
				}
			«ENDIF»
			«taskGenerator.generateLatchUpdate(context, node, monitor)»
			«taskGenerator.generateMessageQueueSend(context, node, monitor)»
		'''
	}

	override CharSequence generateOutputVariableDeclarations(IGeneratorContext context, Graph graph, IProgressMonitor monitor) {
		val nodes = graph.getAllNodes()
				.filter(typeof(ComponentNode))
				.filter(n | !(n.component instanceof Inoutport))
		'''		
			«FOR node : nodes»
				«val generator = node.componentGenerator»
				«FOR outputPort : node.component.outputs.filter(o | !o.testPoint).map(o | o.ports).flatten()»
					«val computationModel = context.configuration.getComputationModel(node)»
					«val outputDataType = generator.context.componentSignature.getOutputDataType(outputPort)»
					«val cDataType = dataTypeGenerator.generateDataType(computationModel, context, outputDataType, null)»
					«cDataType» «GeneratorUtil::getOutputVariableName(context.configuration, node, outputPort)»;
				«ENDFOR»
			«ENDFOR»
		'''
	}

}
