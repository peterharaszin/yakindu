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
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.damos.codegen.c.IGeneratorContext
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration
import org.eclipse.damos.codegen.c.internal.util.InternalGeneratorUtil
import org.eclipse.damos.execution.ComponentNode
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator

import static extension org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions.*
import static extension org.eclipse.damos.codegen.c.util.GeneratorNodeExtensions.*

/**
 * @author Andreas Unger
 *
 */
class InputStruct extends PrimaryCodeFragment {

	@Inject
	VariableDeclarationGenerator variableDeclarationGenerator

	CharSequence content;
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		val prefix = context.configuration.prefix;
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
		return variableDeclarationGenerator.generateVariableDeclaration(new MscriptGeneratorConfiguration(context.configuration.getComputationModel(node), context.configuration), context, dataType, node.component.name.toFirstLower(), false, this)
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) {
		content;
	}

}
