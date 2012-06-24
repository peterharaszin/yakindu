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
import org.eclipselabs.damos.mscript.ArrayType
import org.eclipselabs.damos.mscript.DataType
import org.eclipselabs.damos.mscript.OperatorKind
import org.eclipselabs.damos.mscript.codegen.c.AbstractCodeFragment
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragmentContext
import org.eclipselabs.damos.mscript.codegen.c.IMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.InlineMultiplicativeExpressionGenerator
import org.eclipselabs.damos.mscript.codegen.c.NumericExpressionInfo
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat

import static org.eclipselabs.damos.mscript.codegen.c.ICodeFragment.*

/**
 * @author Andreas Unger
 *
 */
class ScalarVectorMultiplyFunction extends AbstractCodeFragment {
	
	val DataTypeGenerator dataTypeGenerator = new DataTypeGenerator()
	val IMultiplicativeExpressionGenerator multiplicativeExpressionGenerator = new InlineMultiplicativeExpressionGenerator()

	val ComputationModel computationModel
	val DataType scalarType
	val DataType elementType
	val ArrayType resultType
	
	CharSequence scalarTypeText
	CharSequence elementTypeText
	CharSequence resultTypeText
	
	NumberFormat scalarNumberFormat
	NumberFormat elementNumberFormat
	NumberFormat resultElementNumberFormat
	
	String name
	
	String functionBody
	
	@Inject
	new(@Assisted ComputationModel computationModel, @Assisted("scalarType") DataType scalarType, @Assisted("elementType") DataType elementType, @Assisted ArrayType resultType) {
		this.computationModel = computationModel
		this.scalarType = scalarType
		this.elementType = elementType
		this.resultType = resultType

		scalarNumberFormat = computationModel.getNumberFormat(scalarType)
		elementNumberFormat = computationModel.getNumberFormat(elementType)
		resultElementNumberFormat = computationModel.getNumberFormat(resultType.elementType)
	}
	
	def String getName() {
		return name
	}
	
	override void initialize(ICodeFragmentContext context, IProgressMonitor monitor) {
		addDependency(FORWARD_DECLARATION_DEPENDS_ON, [it instanceof ArrayTypeDeclaration])
		
		val codeFragmentCollector = context.codeFragmentCollector

		scalarTypeText = dataTypeGenerator.generateDataType(computationModel, codeFragmentCollector, scalarType, this)
		elementTypeText = dataTypeGenerator.generateDataType(computationModel, codeFragmentCollector, elementType, this)
		resultTypeText = dataTypeGenerator.generateDataType(computationModel, codeFragmentCollector, resultType, this)
		
		name = context.globalNameProvider.newGlobalName("multiply");
		
		val leftOperand = NumericExpressionInfo::create(scalarNumberFormat, "scalar");
		val rightOperand = NumericExpressionInfo::create(elementNumberFormat, "vector[i]");
		val multiplyExpression = multiplicativeExpressionGenerator.generate(codeFragmentCollector, OperatorKind::MULTIPLY, resultElementNumberFormat, leftOperand, rightOperand)

		functionBody = '''
			{
				«resultTypeText» result;
				int i;
				for (i = 0; i < size; ++i) {
					result.data[i] = «multiplyExpression»;
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
		«IF internal»static «ENDIF»«resultTypeText» «name»(«scalarTypeText» scalar, const «elementTypeText» vector[], int size)'''

	override int hashCode() {
		return ^class.hashCode.bitwiseXor(scalarNumberFormat.^class.hashCode).bitwiseXor(elementNumberFormat.^class.hashCode).bitwiseXor(resultElementNumberFormat.^class.hashCode)
	}
	
	override boolean equals(Object obj) {
		if (obj instanceof ScalarVectorMultiplyFunction) {
			val other = obj as ScalarVectorMultiplyFunction
			return other.scalarNumberFormat.isEquivalentTo(scalarNumberFormat) && other.elementNumberFormat.isEquivalentTo(elementNumberFormat) && other.resultElementNumberFormat.isEquivalentTo(resultElementNumberFormat)
		}
		return false;
	}
	
}
