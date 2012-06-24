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

package org.eclipselabs.damos.mscript.codegen.c.codefragments

import com.google.inject.Inject
import com.google.inject.assistedinject.Assisted
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineStructType
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel
import java.util.HashSet

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class StructConstructionFunction extends AbstractCodeFragment {

	static val String PREFERRED_VARIABLE_NAME = "s"
	
	val ComputationModel computationModel
	val MachineStructType structType
	
	String typeName
	String name
	
	CharSequence functionSignature
	
	@Inject
	new(@Assisted ComputationModel computationModel, @Assisted MachineStructType structType) {
		this.computationModel = computationModel
		this.structType = structType
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof StructTypeDeclaration])

		val codeFragmentCollector = context.codeFragmentCollector
		val structTypeDeclaration = codeFragmentCollector.addCodeFragment(new StructTypeDeclaration(computationModel, structType), monitor);

		typeName = structTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName("newStruct")
		functionSignature = generateFunctionSignature(codeFragmentCollector)
	}

	override boolean contributesInternalForwardDeclaration() {
		return false
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature»;
	'''
	
	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) {
		var v = variableName
		
		'''
			«IF internal»static «ENDIF»«functionSignature» {
				«typeName» «v»;
				«FOR member : structType.members»
					«v».«member.name» = «member.name»;
				«ENDFOR»
				return «v»;
			}
		'''
	}
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) '''
		«typeName» «name»(«FOR member : structType.members SEPARATOR ", "»«member.type.generateDataType(computationModel, codeFragmentCollector, this)» «member.name»«ENDFOR»)'''
	
	def private String getVariableName() {
		val names = new HashSet<String>(structType.members.map([it.name]))
		var name = PREFERRED_VARIABLE_NAME
		var i = 2
		while (names.contains(name)) {
			name = PREFERRED_VARIABLE_NAME + i
			i = i + 1
		}
		return name
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(structType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof StructConstructionFunction) {
			val other = obj as StructConstructionFunction
			return other.structType == structType
		}
		return false
	}

}
