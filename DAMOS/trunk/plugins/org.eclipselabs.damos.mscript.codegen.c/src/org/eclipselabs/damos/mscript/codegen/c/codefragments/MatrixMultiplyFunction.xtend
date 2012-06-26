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
class MatrixMultiplyFunction extends AbstractCodeFragment {
	
	val IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator()

	val ComputationModel computationModel
	
	val MachineArrayType leftMatrixType
	val MachineArrayType rightMatrixType
	val MachineArrayType resultType

	CharSequence leftMatrixElementTypeText
	CharSequence rightMatrixElementTypeText
	CharSequence resultTypeText
	
	String name
	
	String functionBody
	
	@Inject
	new(@Assisted ComputationModel computationModel, @Assisted MachineArrayType leftMatrixType, @Assisted MachineArrayType rightMatrixType, @Assisted MachineArrayType resultType) {
		this.computationModel = computationModel
		
		this.leftMatrixType = leftMatrixType
		this.rightMatrixType = rightMatrixType
		this.resultType = resultType
	}
	
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ArrayTypeDeclaration])
		
		val codeFragmentCollector = context.codeFragmentCollector

		leftMatrixElementTypeText = leftMatrixType.elementType.generateDataType(computationModel, codeFragmentCollector, this)
		rightMatrixElementTypeText = rightMatrixType.elementType.generateDataType(computationModel, codeFragmentCollector, this)
		resultTypeText = resultType.generateDataType(computationModel, codeFragmentCollector, this)
		
		name = context.globalNameProvider.newGlobalName("multiply");
		
		val leftOperand = new TextualNumericExpressionOperand("leftMatrix[i][j]", leftMatrixType.numericElementType.numberFormat);
		val rightOperand = new TextualNumericExpressionOperand("rightMatrix[j][k]", rightMatrixType.numericElementType.numberFormat);
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultType.numericElementType.numberFormat, leftOperand, rightOperand)

		functionBody = '''
			{
				«resultTypeText» result = { 0 };
				int k, i, j;
				for (k = 0; k < «rightMatrixType.columnSize»; ++k) {
					for (i = 0; i < «leftMatrixType.rowSize»; ++i) {
						for (j = 0; j < «leftMatrixType.columnSize»; ++j) {
							result.data[i][k] += «multiplyExpression»;
						}
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
		«IF internal»static «ENDIF»«resultTypeText» «name»(«leftMatrixElementTypeText» leftMatrix[«leftMatrixType.rowSize»][«leftMatrixType.columnSize»], «rightMatrixElementTypeText» rightMatrix[«rightMatrixType.rowSize»][«rightMatrixType.columnSize»])'''

	override int hashCode() {
		return ^class.hashCode.bitwiseXor(leftMatrixType.hashCode).bitwiseXor(rightMatrixType.hashCode).bitwiseXor(resultType.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof MatrixMultiplyFunction) {
			val other = obj as MatrixMultiplyFunction
			return other.leftMatrixType == leftMatrixType
					&& other.rightMatrixType == rightMatrixType
					&& other.resultType == resultType
		}
		return false;
	}
	
}
