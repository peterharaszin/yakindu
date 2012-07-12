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

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipselabs.damos.mscript.OperatorKind
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.TextualNumericExpressionOperand
import org.eclipselabs.damos.mscript.codegen.c.datatype.MachineArrayType
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class VectorMatrixMultiplyFunction extends AbstractCodeFragment {
	
	val IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator()

	val ComputationModel computationModel
	
	val MachineArrayType vectorType
	val MachineArrayType matrixType
	val MachineArrayType resultType

	CharSequence vectorElementTypeText
	CharSequence matrixElementTypeText
	CharSequence resultTypeText
	
	String name
	
	String functionBody
	
	new(ComputationModel computationModel, MachineArrayType vectorType, MachineArrayType matrixType, MachineArrayType resultType) {
		this.computationModel = computationModel
		
		this.vectorType = vectorType
		this.matrixType = matrixType
		this.resultType = resultType
	}
	
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ArrayTypeDeclaration])
		
		val codeFragmentCollector = context.codeFragmentCollector

		vectorElementTypeText = vectorType.elementType.generateDataType(codeFragmentCollector, this)
		matrixElementTypeText = matrixType.elementType.generateDataType(codeFragmentCollector, this)
		resultTypeText = resultType.generateDataType(codeFragmentCollector, this)
		
		name = context.globalNameProvider.newGlobalName("multiply");
		
		val leftOperand = new TextualNumericExpressionOperand("matrix[j][i]", matrixType.numericElementType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand("vector[j]", vectorType.numericElementType.numberFormat);
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultType.numericElementType.numberFormat, leftOperand, rightOperand)

		functionBody = '''
			{
				«resultTypeText» result = { 0 };
				int i, j;
				for (i = 0; i < «matrixType.columnSize»; ++i) {
					for (j = 0; j < «matrixType.rowSize»; ++j) {
						result.data[i] += «multiplyExpression»;
					}
				}
				return result;
			}
		'''
	}
	
	override CharSequence generateForwardDeclaration(boolean internal) '''
		«generateFunctionSignature(internal)»;
	'''

	override boolean contributesImplementation() {
		return true
	}
	
	override CharSequence generateImplementation(boolean internal) '''
		«generateFunctionSignature(internal)» «functionBody»
	'''
	
	def private CharSequence generateFunctionSignature(boolean internal) '''
		«IF internal»static «ENDIF»«resultTypeText» «name»(«vectorElementTypeText» vector[«vectorType.size»], «matrixElementTypeText» matrix[«matrixType.rowSize»][«matrixType.columnSize»])'''

	override int hashCode() {
		return ^class.hashCode.bitwiseXor(matrixType.hashCode).bitwiseXor(vectorType.hashCode).bitwiseXor(resultType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof VectorMatrixMultiplyFunction) {
			val other = obj as VectorMatrixMultiplyFunction
			return other.matrixType == matrixType
					&& other.vectorType == vectorType
					&& other.resultType == resultType
		}
		return false
	}
	
}
