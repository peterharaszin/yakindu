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

package org.eclipse.damos.codegen.c.codefragments

import com.google.inject.Inject
import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.codegen.c.IGeneratorContext
import org.eclipse.damos.codegen.c.IGraphGenerator
import org.eclipse.damos.mscript.codegen.c.FunctionGenerator
import org.eclipse.damos.mscript.codegen.c.Include
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator

import static org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil.*
import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*

import static extension org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions.*

/**
 * @author Andreas Unger
 *
 */
class ExecuteFunction extends PrimaryCodeFragment {
	
	@Inject
	VariableDeclarationGenerator variableDeclarationGenerator
	
	@Inject
	FunctionGenerator functionGenerator

	@Inject
	IGraphGenerator graphGenerator
	
	val Collection<Include> implementationIncludes = new ArrayList<Include>()
	
	CharSequence prefix
	CharSequence parameters
	CharSequence functionBody

	new() {
		implementationIncludes.add(new Include("math.h"))
		implementationIncludes.add(new Include("string.h"))
	}
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof InputStruct || it instanceof OutputStruct])
		addDependency(IMPLEMENTATION_DEPENDS_ON, [it instanceof ContextVariable])
		
		val graph = context.executionFlow.graph
		implementationIncludes.addAll(graphGenerator.getImplementationIncludes(context, graph))
		
		prefix = context.configuration.prefix
		parameters = generateParameters(context)
		
		functionBody = '''
			{
				«IF graphGenerator.contributesOutputVariableDeclarations(context, graph)»
					«graphGenerator.generateOutputVariableDeclarations(context, graph, monitor)»

				«ENDIF»
				«graphGenerator.generateGraph(context, graph, monitor)»
			}
		'''
	}

	override Collection<Include> getForwardDeclarationIncludes() {
		return Collections::singleton(new Include("stdint.h"))
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		«generateFunctionSignature(internal)»;
	'''

	override boolean contributesImplementation() {
		return true
	}

	override Collection<Include> getImplementationIncludes() {
		return implementationIncludes
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«generateFunctionSignature(internal)» «functionBody»
	'''

	def protected CharSequence generateFunctionSignature(boolean internal) {
		functionGenerator.generateFunctionSignature("void", prefix + "execute", parameters, internal)
	}

	def protected CharSequence generateParameters(IGeneratorContext context) {
		val hasContext = !context.configuration.singleton
		val hasInput = !getInportNodes(context).isEmpty()
		val hasOutput = !getOutportNodes(context).isEmpty()
		if (hasInput || hasOutput) {
			val inputParameter = if (hasInput) {
				'''«variableDeclarationGenerator.generateVariableDeclaration(prefix + "Input", "input", true, true)»«IF hasOutput», «ENDIF»'''
			}
			val outputParameter = if (hasOutput) {
				variableDeclarationGenerator.generateVariableDeclaration(prefix + "Output", "output", false, true)
			}
			'''«IF hasContext»«generateContextParameter()», «ENDIF»«inputParameter»«outputParameter»'''
		} else if (hasContext) {
			generateContextParameter()
		}
	}
	
	def protected CharSequence generateContextParameter() {
		variableDeclarationGenerator.generateVariableDeclaration(prefix + "Context", "context", false, true)
	}
	
}
