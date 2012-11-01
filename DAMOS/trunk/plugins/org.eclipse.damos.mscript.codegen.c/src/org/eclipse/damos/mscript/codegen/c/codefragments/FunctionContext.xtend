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
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext
import org.eclipse.damos.mscript.codegen.c.PrimitiveTypeGenerator
import org.eclipse.damos.mscript.codegen.c.datatype.MachineDataTypeFactory

/**
 * @author Andreas Unger
 *
 */
class FunctionContext extends AbstractContextStructMember {

	@Inject
	PrimitiveTypeGenerator primitiveTypeGenerator
	
	@Inject
	MachineDataTypeFactory machineDataTypeFactory

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
	
	def private CharSequence generateContextStructureMember(VariableDeclaration variableDeclaration) {
		val variableName = variableDeclaration.name
		val dataType = generatorContext.functionInfo.getValue(variableDeclaration).dataType
		val typeName = machineDataTypeFactory.create(generatorContext.configuration, dataType).generateDataType(null, generatorContext.codeFragmentCollector, null)
		if (hasContext(variableDeclaration)) {
			val bufferSize = generatorContext.functionInfo.getCircularBufferSize(variableDeclaration)
			val indexCDataType = primitiveTypeGenerator.generateIndexType(2 * bufferSize)
			return '''
				«generateBufferVariableDeclaration(typeName, variableName, bufferSize)»
				«indexCDataType» «variableName»_index;
			''';
		}
		return '''«typeName» «variableName»;'''
	}
	
	def protected CharSequence generateBufferVariableDeclaration(CharSequence typeName, CharSequence variableName, int bufferSize) '''
		«typeName» «variableName»[«bufferSize»];
	'''

	def private boolean hasContext(VariableDeclaration variableDeclaration) {
		return generatorContext.functionInfo.getCircularBufferSize(variableDeclaration) > 1
	}

}
