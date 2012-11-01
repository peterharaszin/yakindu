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
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.codegen.c.IGeneratorContext
import org.eclipse.damos.codegen.c.ITaskGenerator
import org.eclipse.damos.execution.ComponentNode
import org.eclipse.damos.mscript.codegen.c.FunctionGenerator
import org.eclipse.damos.mscript.codegen.c.Include
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator

import static org.eclipse.damos.mscript.codegen.c.ICodeFragment.*

import static extension org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class InitializeFunction extends PrimaryCodeFragment {

	@Inject
	VariableDeclarationGenerator variableDeclarationGenerator
	
	@Inject
	FunctionGenerator functionGenerator

	@Inject	
	ITaskGenerator taskGenerator
	
	val Collection<Include> implementationIncludes = new ArrayList<Include>()
	
	CharSequence prefix
	CharSequence parameters
	CharSequence functionBody

	new() {
		implementationIncludes.add(new Include("math.h"))
	}
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(IMPLEMENTATION_DEPENDS_ON, [it instanceof ContextVariable])

		val nodes = context.executionFlow.allNodes
				.filter(typeof(ComponentNode))
				.filter(n | n.componentGenerator.contributesInitializationCode)

		for (node : nodes) {
			val includes = node.componentGenerator.initializationCodeIncludes
			if (includes != null) {
				implementationIncludes.addAll(includes)
			}
		}
		
		prefix = context.configuration.prefix
		parameters = generateParameters(context)

		functionBody = '''
			{
				«taskGenerator.generateInitializeTasks(context, monitor)»
				«FOR node : nodes SEPARATOR "\n"»
					/* «node.component.name» */
					{
						«node.componentGenerator.generateInitializationCode(monitor)»
					}
				«ENDFOR»
			}
		'''
	}
	
	def protected CharSequence generateParameters(IGeneratorContext context) {
		if (!context.configuration.singleton) {
			variableDeclarationGenerator.generateVariableDeclaration(prefix + "Context", "context", false, true)
		}
	}
	
	def protected CharSequence generateFunctionSignature(boolean internal) {
		functionGenerator.generateFunctionSignature("void", prefix + "initialize", parameters, internal)
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

}
