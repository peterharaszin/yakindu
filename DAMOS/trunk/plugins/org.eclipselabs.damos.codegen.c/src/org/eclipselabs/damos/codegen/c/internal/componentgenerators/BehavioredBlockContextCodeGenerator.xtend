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

package org.eclipselabs.damos.codegen.c.internal.componentgenerators

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.VariableDeclaration
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.VariableDeclarationGenerator

/**
 * @author Andreas Unger
 *
 */
class BehavioredBlockContextCodeGenerator {
	
	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator()
	val VariableDeclarationGenerator variableDeclarationGenerator = new VariableDeclarationGenerator(new DataTypeGenerator())

	def generateContextCode(IBehavioredBlockGeneratorContext context, CharSequence typeName, IProgressMonitor monitor) '''
		typedef struct {
			«FOR d : context.functionInstance.functionDeclaration.inputParameterDeclarations»
				«IF hasContext(context, d)»
					«generateContextStructureMember(context, monitor, d)»
				«ENDIF»
			«ENDFOR»
			«FOR d : context.functionInstance.functionDeclaration.outputParameterDeclarations»
				«IF hasContext(context, d)»
					«generateContextStructureMember(context, monitor, d)»
				«ENDIF»
			«ENDFOR»
			«FOR d : context.functionInstance.functionDeclaration.stateVariableDeclarations»
				«generateContextStructureMember(context, monitor, d)»
			«ENDFOR»
		} «typeName»;
	'''
	
	def private generateContextStructureMember(IBehavioredBlockGeneratorContext context, IProgressMonitor monitor, VariableDeclaration variableDeclaration) {
		val name = variableDeclaration.name
		val dataType = context.staticEvaluationResult.getValue(variableDeclaration).dataType
		val cVariableDeclaration = variableDeclarationGenerator.generateVariableDeclaration(context.mscriptGeneratorConfiguration, context.getContext.codeFragmentCollector, dataType, name, false, null)
		if (hasContext(context, variableDeclaration)) {
			val bufferSize = context.staticEvaluationResult.getCircularBufferSize(variableDeclaration)
			val indexCDataType = dataTypeGenerator.generateIndexDataType(context.mscriptGeneratorConfiguration.computationModel, 2 * bufferSize)
			return '''
				«cVariableDeclaration»[«bufferSize»];
				«indexCDataType» «name»_index;
			''';
		}
		return '''«cVariableDeclaration»;'''
	}

	def private boolean hasContext(IBehavioredBlockGeneratorContext context, VariableDeclaration variableDeclaration) {
		return context.staticEvaluationResult.getCircularBufferSize(variableDeclaration) > 1
	}

}
