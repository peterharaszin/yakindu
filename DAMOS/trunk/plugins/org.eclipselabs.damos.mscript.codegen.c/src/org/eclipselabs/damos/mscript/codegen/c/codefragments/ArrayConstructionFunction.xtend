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
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class ArrayConstructionFunction extends AbstractCodeFragment {

	val MachineArrayType arrayType
	val ComputationModel computationModel
	
	String typeName
	String name
	
	String functionSignature
	
	@Inject
	new(@Assisted ComputationModel computationModel, @Assisted MachineArrayType arrayType) {
		this.computationModel = computationModel
		this.arrayType = arrayType
	}
	
	/**
	 * @return the name
	 */
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ArrayTypeDeclaration])

		val codeFragmentCollector = context.codeFragmentCollector
		val arrayTypeDeclaration = codeFragmentCollector.addCodeFragment(new ArrayTypeDeclaration(computationModel, arrayType), monitor)

		typeName = arrayTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName("newArray")
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
	
	override CharSequence generateImplementation(boolean internal) '''
		«IF internal»static «ENDIF»«functionSignature» {
			«typeName» a;
			«FOR i : 0 .. arrayType.getDimension(0) - 1»
				a.data[«i»] = e«i»;
			«ENDFOR»
			return a;
		}
	'''
	
	def private String generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		val indices = 0 .. arrayType.getDimension(0) - 1
		val dataType = arrayType.elementType.generateDataType(computationModel, codeFragmentCollector, this)
		
		'''«typeName» «name»(«FOR i : indices SEPARATOR ", "»«dataType» e«i»«ENDFOR»)'''
	}
	
	override int hashCode() {
		return ^class.hashCode.bitwiseXor(arrayType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof ArrayConstructionFunction) {
			val other = obj as ArrayConstructionFunction
			return other == arrayType
		}
		return false
	}

}
