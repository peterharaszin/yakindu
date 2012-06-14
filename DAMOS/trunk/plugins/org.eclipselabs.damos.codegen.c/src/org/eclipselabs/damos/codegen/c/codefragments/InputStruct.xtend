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
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.IGeneratorContext
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator

import static extension org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipselabs.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class InputStruct extends PrimaryCodeFragment {

	val VariableDeclarationGenerator variableDeclarationGenerator = new VariableDeclarationGenerator(new DataTypeGenerator())

	CharSequence content;
	
	@Inject
	new() {
		
	}
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		val prefix = org::eclipselabs::damos::codegen::c::util::GeneratorConfigurationExtensions::getPrefix(context.getConfiguration());
		content = '''
			typedef struct {
				«FOR node : InternalGeneratorUtil::getInportNodes(context)»
					«getVariableDeclaration(context, node)»;
				«ENDFOR»
			} «prefix»Input;
		'''
	}

	/**
	 * @param context
	 * @param node
	 * @return
	 */
	def private getVariableDeclaration(IGeneratorContext context, ComponentNode node) {
		val generator = node.componentGenerator
		val signature = generator.context.componentSignature
		val outputPort = node.component.firstOutputPort
		val dataType = signature.getOutputDataType(outputPort)
		return variableDeclarationGenerator.generateVariableDeclaration(context.configuration.getComputationModel(node), context, dataType, node.component.name.toFirstLower(), false, this)
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) {
		content;
	}

}
