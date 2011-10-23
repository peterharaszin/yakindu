/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.il.transform;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.MultiplicativeExpression;
import org.eclipselabs.damos.mscript.MultiplicativeOperator;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.ParenthesizedExpression;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.il.Compound;
import org.eclipselabs.damos.mscript.il.VariableReference;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class ArrayOperationDecomposer extends ILSwitch<Boolean> implements IArrayOperationDecomposer {

	private IStaticEvaluationContext context;
	
	private ArrayExpressionTransformer arrayExpressionTransformer = new ArrayExpressionTransformer();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IArrayOperationDecomposer#decompose(org.eclipselabs.mscript.language.il.Compound)
	 */
	public void decompose(IStaticEvaluationContext context, Compound compound) {
		this.context = context;
		doSwitch(compound);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Boolean defaultCase(EObject object) {
		if (object instanceof Expression) {
			arrayExpressionTransformer.doSwitch(object);
		} else {
			for (EObject child : object.eContents()) {
				doSwitch(child);
			}
		}
		return true;
	}
	
	private DataType getDataType(Expression expression) {
		return context.getValue(expression).getDataType();
	}
	
	private void setDataType(Expression expression, DataType dataType) {
		context.setValue(expression, new AnyValue(new ComputationContext(), dataType));
	}

	private class ArrayExpressionTransformer extends MscriptSwitch<Boolean> {
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public Boolean caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			// TODO: Implement better support for vector multiplication expressions
			if (multiplicativeExpression.getOperator() == MultiplicativeOperator.MULTIPLY) {
				Expression leftOperand = multiplicativeExpression.getLeftOperand();
				Expression rightOperand = multiplicativeExpression.getRightOperand();
				if (leftOperand instanceof VariableReference && rightOperand instanceof VariableReference) {
					DataType leftDataType = getDataType(leftOperand);
					DataType rightDataType = getDataType(rightOperand);
					if (leftDataType instanceof TensorType && rightDataType instanceof TensorType) {
						TensorType leftTensorType = (TensorType) leftDataType;
						TensorType rightTensorType = (TensorType) rightDataType;
						if (leftTensorType.isVector() && rightTensorType.isVector()) {
							Expression transformedExpression = createVectorMultiplicationExpression((VariableReference) leftOperand, (VariableReference) rightOperand);
							EcoreUtil.replace(multiplicativeExpression, transformedExpression);
						}
					}
				}
			}
			return super.caseMultiplicativeExpression(multiplicativeExpression);
		}
		
		private Expression createVectorMultiplicationExpression(VariableReference leftOperand, VariableReference rightOperand) {			
			ParenthesizedExpression parenthesizedExpression = MscriptFactory.eINSTANCE.createParenthesizedExpression();

			TensorType leftTensorType = (TensorType) getDataType(leftOperand);
			TensorType rightTensorType = (TensorType) getDataType(rightOperand);
			
			DataType resultDataType = leftTensorType.getElementType().evaluate(OperatorKind.MULTIPLY, rightTensorType.getElementType());

			Expression rootExpression = null;
			for (int i = 0; i < TypeUtil.getArraySize(leftTensorType); ++i) {
				MultiplicativeExpression multiplicativeExpression = MscriptFactory.eINSTANCE.createMultiplicativeExpression();
				setDataType(multiplicativeExpression, EcoreUtil.copy(resultDataType));
				
				VariableReference leftVariableReference = EcoreUtil.copy(leftOperand);
				setDataType(leftVariableReference, EcoreUtil.copy(leftTensorType.getElementType()));
				IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setUnit(TypeUtil.createUnit());
				integerLiteral.setValue(i);
				IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeUtil.createUnit());
				setDataType(integerLiteral, integerType);
				leftVariableReference.getArrayIndices().add(integerLiteral);
				
				VariableReference rightVariableReference = EcoreUtil.copy(rightOperand);
				setDataType(rightVariableReference, EcoreUtil.copy(rightTensorType.getElementType()));
				integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setUnit(TypeUtil.createUnit());
				integerLiteral.setValue(i);
				integerType = MscriptFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeUtil.createUnit());
				setDataType(integerLiteral, integerType);
				rightVariableReference.getArrayIndices().add(integerLiteral);

				multiplicativeExpression.setOperator(MultiplicativeOperator.MULTIPLY);
				multiplicativeExpression.setLeftOperand(leftVariableReference);
				multiplicativeExpression.setRightOperand(rightVariableReference);
				
				if (rootExpression == null) {
					rootExpression = multiplicativeExpression;
				} else {
					AdditiveExpression additiveExpression = MscriptFactory.eINSTANCE.createAdditiveExpression();
					additiveExpression.setLeftOperand(rootExpression);
					additiveExpression.setRightOperand(multiplicativeExpression);
					setDataType(additiveExpression, EcoreUtil.copy(resultDataType));
					rootExpression = additiveExpression;
				}
			}
			
			parenthesizedExpression.getExpressions().add(rootExpression);

			setDataType(rootExpression, EcoreUtil.copy(resultDataType));
			setDataType(parenthesizedExpression, EcoreUtil.copy(resultDataType));
			
			return parenthesizedExpression;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			for (EObject child : object.eContents()) {
				doSwitch(child);
			}
			return true;
		}
		
	}
	
}
