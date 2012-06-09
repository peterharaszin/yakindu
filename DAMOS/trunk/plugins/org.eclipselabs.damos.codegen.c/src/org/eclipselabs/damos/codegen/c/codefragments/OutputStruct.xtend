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

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.codegen.c.internal.util.InternalGeneratorUtil
import org.eclipselabs.damos.codegen.c.util.GeneratorConfigurationUtil
import org.eclipselabs.damos.execution.ComponentNode
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil
import org.eclipselabs.damos.codegen.c.IGeneratorContext

/**
 * @author Andreas Unger
 *
 */
class OutputStruct extends PrimaryCodeFragment {

	CharSequence content;
	
	override void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
		val prefix = GeneratorConfigurationUtil::getPrefix(context.getConfiguration());
		content = '''
			typedef struct {
				«FOR node : InternalGeneratorUtil::getOutportNodes(context)»
					«getCVariableDeclaration(context, node)»;
				«ENDFOR»
			} «prefix»Output;
		'''
	}

	/**
	 * @param context
	 * @param node
	 * @return
	 */
	def private getCVariableDeclaration(IGeneratorContext context, ComponentNode node) {
		val generator = InternalGeneratorUtil::getComponentGenerator(node);
		val signature = generator.getContext().getComponentSignature();
		val inputPort = node.getComponent().getFirstInputPort();
		val dataType = signature.getInputDataType(inputPort);
		return MscriptGeneratorUtil::getCVariableDeclaration(GeneratorConfigurationUtil::getComputationModel(context.getConfiguration(), node), context, dataType, InternalGeneratorUtil::uncapitalize(node.getComponent().getName()), false, this);
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) {
		content;
	}

}
