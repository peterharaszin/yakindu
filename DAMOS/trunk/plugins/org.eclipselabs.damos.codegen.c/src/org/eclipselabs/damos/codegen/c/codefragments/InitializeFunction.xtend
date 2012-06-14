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
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.mscript.codegen.c.Include

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class InitializeFunction extends PrimaryCodeFragment {
	
	val ITaskGenerator taskGenerator
	
	val Collection<Include> implementationIncludes = new ArrayList<Include>()
	
	CharSequence functionSignature
	CharSequence functionBody

	@Inject
	new(ITaskGenerator taskGenerator) {
		this.taskGenerator = taskGenerator
		implementationIncludes.add(new Include("math.h"))
	}
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		addDependency(IMPLEMENTATION_DEPENDS_ON, [other | other instanceof ContextVariable])

		val nodes = context.executionFlow.allNodes
				.filter(typeof(ComponentNode))
				.filter(n | n.componentGenerator.contributesInitializationCode)

		for (node : nodes) {
			val includes = node.componentGenerator.initializationCodeIncludes
			if (includes != null) {
				implementationIncludes.addAll(includes)
			}
		}
		
		functionSignature = '''void «context.configuration.prefix»initialize(void)'''

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

}
