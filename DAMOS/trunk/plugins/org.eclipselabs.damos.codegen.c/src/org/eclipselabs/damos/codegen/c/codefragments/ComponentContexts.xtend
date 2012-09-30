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

import java.util.ArrayList
import java.util.Collection
import java.util.Collections
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipselabs.damos.codegen.c.IGeneratorContext
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment
import org.eclipselabs.damos.mscript.codegen.c.Include
import org.eclipselabs.damos.mscript.codegen.c.codefragments.AbstractContextStructPart

import static org.eclipselabs.damos.codegen.c.codefragments.ComponentContexts.*

import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class ComponentContexts extends AbstractContextStructPart {

	val Collection<Include> forwardDeclarationIncludes
	val Collection<ICodeFragment> declarationCodeFragments
	val CharSequence content
	
	private new(Collection<Include> forwardDeclarationIncludes, Collection<ICodeFragment> declarationCodeFragments, CharSequence content) {
		this.forwardDeclarationIncludes = forwardDeclarationIncludes
		this.declarationCodeFragments = declarationCodeFragments
		this.content = content
	}
	
	def static void initialize(IGeneratorContext context, IProgressMonitor monitor) {
		val nodes = context.executionFlow.allNodes
				.filter(typeof(ComponentNode))
				.filter(n | n.componentGenerator.contributesContextCode)
				
		if (nodes.empty) {
			return
		}
			
		val forwardDeclarationIncludes = new ArrayList<Include>();
		for (node : nodes) {
			val includes = node.componentGenerator.contextCodeIncludes
			if (includes != null) {
				forwardDeclarationIncludes.addAll(includes)
			}
		}
		
		val content = '''
			«FOR node : nodes»
				«getContextTypeName(context, node)» «context.configuration.getPrefix(node)»«node.component.name»;
			«ENDFOR»
		'''
		
		var Collection<ICodeFragment> declarationCodeFragments = Collections::emptyList

		val declarationNodes = nodes.filter(n | n.componentGenerator.contextTypeName == null)
		if (!declarationNodes.empty) {
			val declarationContent = '''
				«FOR node : declarationNodes SEPARATOR "\n"»
					«node.componentGenerator.generateContextCode(getContextTypeName(context, node), monitor)»
				«ENDFOR»
			'''
			val declarationCodeFragment = new ComponentContextDeclarations(declarationContent)
			context.addCodeFragment(declarationCodeFragment, new NullProgressMonitor())
			declarationCodeFragments = Collections::<ICodeFragment>singleton(declarationCodeFragment)
		}
		
		val contextStruct = context.addCodeFragment(new org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct(context.configuration.singleton), new NullProgressMonitor())
		contextStruct.addPart(new ComponentContexts(forwardDeclarationIncludes, declarationCodeFragments, content))
	}

	override Collection<Include> getForwardDeclarationIncludes() {
		return forwardDeclarationIncludes
	}
	
	override getDeclarationCodeFragments() {
		declarationCodeFragments
	}
	
	override generate() {
		content
	}

	def private static CharSequence getContextTypeName(IGeneratorContext context, ComponentNode node) {
		var typeName = node.componentGenerator.contextTypeName
		if (typeName == null) {
			typeName = context.configuration.getPrefix(node) + node.component.name + "_Context"
		}
		return typeName
	}
	
}
