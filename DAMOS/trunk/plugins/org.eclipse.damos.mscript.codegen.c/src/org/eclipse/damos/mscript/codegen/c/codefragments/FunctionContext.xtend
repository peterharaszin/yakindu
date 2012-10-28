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

package org.eclipse.damos.mscript.codegen.c.codefragments

import com.google.inject.Inject
import org.eclipse.damos.mscript.VariableDeclaration
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator

/**
 * @author Andreas Unger
 *
 */
class FunctionContext extends AbstractContextStructMember {

	@Inject
	DataTypeGenerator dataTypeGenerator
	
	@Inject
	VariableDeclarationGenerator variableDeclarationGenerator

	val IMscriptGeneratorContext generatorContext
	
	/**
	 * 
	 */
	new(IMscriptGeneratorContext generatorContext) {
		this.generatorContext = generatorContext
	}
	
	override CharSequence generate() '''
		«FOR d : generatorContext.functionInfo.functionInstance.declaration.nonConstantInputParameterDeclarations»
			«IF hasContext(d)»
				«generateContextStructureMember(d)»
			«ENDIF»
		«ENDFOR»
		«FOR d : generatorContext.functionInfo.functionInstance.declaration.outputParameterDeclarations»
			«IF hasContext(d)»
				«generateContextStructureMember(d)»
			«ENDIF»
		«ENDFOR»
		«FOR d : generatorContext.functionInfo.functionInstance.declaration.stateVariableDeclarations»
			«generateContextStructureMember(d)»
		«ENDFOR»
	'''
	
	def private generateContextStructureMember(VariableDeclaration variableDeclaration) {
		val name = variableDeclaration.name
		val dataType = generatorContext.functionInfo.getValue(variableDeclaration).dataType
		val cVariableDeclaration = variableDeclarationGenerator.generateVariableDeclaration(generatorContext.configuration, generatorContext.codeFragmentCollector, dataType, name, false, null)
		if (hasContext(variableDeclaration)) {
			val bufferSize = generatorContext.functionInfo.getCircularBufferSize(variableDeclaration)
			val indexCDataType = dataTypeGenerator.generateIndexDataType(generatorContext.configuration.computationModel, 2 * bufferSize)
			return '''
				«cVariableDeclaration»[«bufferSize»];
				«indexCDataType» «name»_index;
			''';
		}
		return '''«cVariableDeclaration»;'''
	}

	def private boolean hasContext(VariableDeclaration variableDeclaration) {
		return generatorContext.functionInfo.getCircularBufferSize(variableDeclaration) > 1
	}

}
