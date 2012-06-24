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
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.IGeneratorContext
import org.eclipselabs.damos.codegen.c.ITaskGenerator
import org.eclipselabs.damos.codegen.c.codefragments.factories.ITaskMessageStructFactory
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.mscript.codegen.c.Include

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class ContextStruct extends PrimaryCodeFragment {

	val ITaskGenerator taskGenerator
	
	val ITaskMessageStructFactory taskMessageStructFactory
	
	val Collection<Include> forwardDeclarationIncludes = new ArrayList<Include>()
	
	var CharSequence content
	
	@Inject
	new(ITaskGenerator taskGenerator, ITaskMessageStructFactory taskMessageStructFactory) {
		this.taskGenerator = taskGenerator
		this.taskMessageStructFactory = taskMessageStructFactory
	}
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof TaskMessageStruct])
		
		if (!context.executionFlow.taskGraphs.empty) {
			context.addCodeFragment(taskMessageStructFactory.create(), monitor)
		}
	
		val prefix = context.configuration.prefix;
		val nodes = context.executionFlow.allNodes
				.filter(typeof(ComponentNode))
				.filter(n | n.componentGenerator.contributesContextCode)
				
		for (node : nodes) {
			val includes = node.componentGenerator.contextCodeIncludes
			if (includes != null) {
				forwardDeclarationIncludes.addAll(includes)
			}
		}
		
		content = '''
			«FOR node : nodes.filter(n | n.componentGenerator.contextTypeName == null) SEPARATOR "\n" AFTER "\n"»
				«node.componentGenerator.generateContextCode(getContextTypeName(context, node), monitor)»
			«ENDFOR»
			typedef struct {
				«taskGenerator.generateTaskContexts(context, monitor)»
				«FOR node : nodes»
					«getContextTypeName(context, node)» «context.configuration.getPrefix(node)»«node.component.name»;
				«ENDFOR»
			} «prefix»Context;
		'''
	}
	
	override Collection<Include> getForwardDeclarationIncludes() {
		return forwardDeclarationIncludes
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) {
		return content
	}

	def private CharSequence getContextTypeName(IGeneratorContext context, ComponentNode node) {
		var typeName = node.componentGenerator.contextTypeName
		if (typeName == null) {
			typeName = context.configuration.getPrefix(node) + node.component.name + "_Context"
		}
		return typeName
	}
	
}
