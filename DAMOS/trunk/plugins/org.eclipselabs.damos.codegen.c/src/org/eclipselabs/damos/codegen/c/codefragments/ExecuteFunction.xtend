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

package org.eclipselabs.damos.codegen.c.codefragments

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.IGeneratorContext
import org.eclipselabs.damos.codegen.c.IGraphGenerator
import org.eclipselabs.damos.mscript.codegen.c.Include

import static org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil.*
import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*
import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*

/**
 * @author Andreas Unger
 *
 */
class ExecuteFunction extends PrimaryCodeFragment {
	
	val IGraphGenerator graphGenerator
	
	val Collection<Include> implementationIncludes = new ArrayList<Include>()
	
	CharSequence functionSignature
	CharSequence functionBody

	@Inject
	new(IGraphGenerator graphGenerator) {
		this.graphGenerator = graphGenerator
		implementationIncludes.add(new Include("math.h"))
	}
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof InputStruct || it instanceof OutputStruct])
		addDependency(IMPLEMENTATION_DEPENDS_ON, [it instanceof ContextVariable])
		
		val graph = context.executionFlow.graph
		implementationIncludes.addAll(graphGenerator.getImplementationIncludes(context, graph))
		
		functionSignature = generateFunctionSignature(context)
		
		functionBody = '''
			{
				«graphGenerator.generateOutputVariableDeclarations(context, graph, monitor)»

				«graphGenerator.generateGraph(context, graph, monitor)»
			}
		'''
	}

	override Collection<Include> getForwardDeclarationIncludes() {
		return Collections::singleton(new Include("stdint.h"))
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature»;
	'''

	override boolean contributesImplementation() {
		return true
	}

	override Collection<Include> getImplementationIncludes() {
		return implementationIncludes
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature» «functionBody»
	'''

	def private CharSequence generateFunctionSignature(IGeneratorContext context) {
		val prefix = context.configuration.prefix
		
		val hasContext = !context.configuration.singleton
		val hasInput = !getInportNodes(context).isEmpty()
		val hasOutput = !getOutportNodes(context).isEmpty()
		
		val parameters = if (hasInput || hasOutput) {
			val inputParameter = if (hasInput) {
				'''const «prefix»Input *input«IF hasOutput», «ENDIF»'''
			}
			val outputParameter = if (hasOutput) {
				'''«prefix»Output *output'''
			}
			'''«IF hasContext»«prefix»Context *context, «ENDIF»«inputParameter»«outputParameter»'''
		} else if (hasContext) {
			'''«prefix»Context *context'''
		} else {
			"void"
		}
		return '''void «prefix»execute(«parameters»)'''
	}
	
}
