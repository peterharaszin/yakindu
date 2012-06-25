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
import java.util.ArrayList
import java.util.Collections
import java.util.List
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentCollector
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*
import static org.eclipselabs.damos.mscript.codegen.c.codefragments.ArrayConstructionFunction.*

/**
 * @author Andreas Unger
 *
 */
class ArrayConstructionFunction extends AbstractCodeFragment {

	val MachineArrayType arrayType
	val ComputationModel computationModel
	
	String typeName
	String name
	
	CharSequence functionSignature
	
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
		val preferredName = switch (arrayType.dimensionality) {
		case 1:
			"newVector"
		case 2:
			"newMatrix"
		default:
			"newArray"
		}

		typeName = arrayTypeDeclaration.name
		name = context.globalNameProvider.newGlobalName(preferredName)
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
			«typeName» «variableName»;
			«generateArrayElementAssignments(0, Collections::emptyList)»
			return «variableName»;
		}
	'''
	
	def private CharSequence generateFunctionSignature(ICodeFragmentCollector codeFragmentCollector) {
		val dataType = arrayType.elementType.generateDataType(computationModel, codeFragmentCollector, this)
		
		'''«typeName» «name»(«generateFunctionParameters(dataType, 0, Collections::emptyList)»)'''
	}
	
	def private CharSequence generateFunctionParameters(CharSequence dataType, int dimension, List<Integer> previousIndices) {
		val indices = 0 .. arrayType.getDimensionSize(dimension) - 1
		if (dimension == arrayType.dimensionality - 1) {
			'''«FOR i : indices SEPARATOR ", "»«dataType» e«concat(previousIndices, i).join("_")»«ENDFOR»'''
		} else {
			'''«FOR i : indices SEPARATOR ", "»«generateFunctionParameters(dataType, dimension + 1, concat(previousIndices, i))»«ENDFOR»'''
		}
	}
	
	def private CharSequence generateArrayElementAssignments(int dimension, List<Integer> previousIndices) {
		val indices = 0 .. arrayType.getDimensionSize(dimension) - 1
		'''
			«IF dimension == arrayType.dimensionality - 1»
				«FOR i : indices»
					«variableName».data«FOR j : concat(previousIndices, i)»[«j»]«ENDFOR» = e«concat(previousIndices, i).join("_")»;
				«ENDFOR»
			«ELSE»
				«FOR i : indices»
					«generateArrayElementAssignments(dimension + 1, concat(previousIndices, i))»
				«ENDFOR»
			«ENDIF»
		'''
	}
	
	def private CharSequence getVariableName() {
		switch (arrayType.dimensionality) {
		case 1:
			"v"
		case 2:
			"m"
		default:
			"a"
		}
	}
	
	def private static <T> List<T> concat(List<? extends T> collection, T element) {
		val result = new ArrayList<T>(collection.size + 1)
		result += collection
		result += element
		return result
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
