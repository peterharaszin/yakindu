/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.mscript.interpreter;

import org.eclipse.damos.mscript.ArrayElementAccess;
import org.eclipse.damos.mscript.ArraySubscript;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.Assignment;
import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.ForStatement;
import org.eclipse.damos.mscript.IfStatement;
import org.eclipse.damos.mscript.LocalVariableDeclaration;
import org.eclipse.damos.mscript.ReturnStatement;
import org.eclipse.damos.mscript.Statement;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.interpreter.value.IArrayValue;
import org.eclipse.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.interpreter.value.UninitializedValue;
import org.eclipse.damos.mscript.interpreter.value.Values;
import org.eclipse.damos.mscript.util.MscriptSwitch;
import org.eclipse.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class CompoundStatementInterpreter implements ICompoundStatementInterpreter {

	public IValue execute(IInterpreterContext context, CompoundStatement compoundStatement) {
		return new CompoundInterpreterSwitch(context).evaluate(compoundStatement);
	}
	
	private class CompoundInterpreterSwitch extends MscriptSwitch<Boolean> {
		
		private final IInterpreterContext context;
		
		private final IExpressionEvaluator expressionEvaluator = new ExpressionEvaluator();
		
		private IValue returnValue;
		
		/**
		 * 
		 */
		public CompoundInterpreterSwitch(IInterpreterContext context) {
			this.context = context;
		}
		
		public IValue evaluate(CompoundStatement compoundStatement) {
			doSwitch(compoundStatement);
			return returnValue;
		}

		@Override
		public Boolean caseAssignment(Assignment assignment) {
			ExpressionEvaluationContext expressionEvaluationContext = new ExpressionEvaluationContext(context);
			if (assignment.getTarget() instanceof FeatureReference) {
				FeatureReference variableReference = (FeatureReference) assignment.getTarget();

				if (!(variableReference.getFeature() instanceof VariableDeclaration)) {
					throw new IllegalArgumentException();
				}
				VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
				
				IValue value = expressionEvaluator.evaluate(expressionEvaluationContext, assignment.getAssignedExpression());
				IVariable variable = context.getVariable(variableDeclaration);
				variable.setValue(context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getStepIndex(variableReference), value);
			} else if (assignment.getTarget() instanceof ArrayElementAccess) {
				ArrayElementAccess arrayElementAccess = (ArrayElementAccess) assignment.getTarget();
				if (arrayElementAccess.getArray() instanceof FeatureReference) {
					FeatureReference variableReference = (FeatureReference) arrayElementAccess.getArray();
					if (!(variableReference.getFeature() instanceof VariableDeclaration)) {
						throw new IllegalArgumentException();
					}
					VariableDeclaration variableDeclaration = (VariableDeclaration) variableReference.getFeature();
					
					IValue value = expressionEvaluator.evaluate(expressionEvaluationContext, assignment.getAssignedExpression());
					IVariable variable = context.getVariable(variableDeclaration);
					IValue variableValue = variable.getValue(context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getStepIndex(variableReference));
					IArrayValue arrayValue;
					if (variableValue instanceof IArrayValue) {
						arrayValue = (IArrayValue) variableValue;
					} else if (variableValue instanceof UninitializedValue) {
						arrayValue = Values.newArrayValue(context.getComputationContext(), (ArrayType) context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getValue(variableDeclaration).getDataType());
						variable.setValue(context.getStaticEvaluationResult().getFunctionInfo(context.getFunctionCallPath()).getStepIndex(variableReference), arrayValue);
					} else {
						throw new IllegalArgumentException();
					}
					int[] indices = new int[arrayValue.getDataType().getDimensionality()];
					int i = 0;
					for (ArraySubscript subscript : arrayElementAccess.getSubscripts()) {
						IValue index = expressionEvaluator.evaluate(expressionEvaluationContext, subscript.getExpression());
						if (index instanceof ISimpleNumericValue) {
							indices[i] = (int) ((ISimpleNumericValue) index).longValue();
						}
						++i;
					}
					((IArrayValue) arrayValue).set(indices, value);
				} else {
					// TODO: Support member variable access
					throw new IllegalArgumentException();
				}
			} else {
				// TODO: Support member variable access
				throw new IllegalArgumentException();
			}
			return true;
		}
		
		@Override
		public Boolean caseReturnStatement(ReturnStatement returnStatement) {
			returnValue = expressionEvaluator.evaluate(new ExpressionEvaluationContext(context), returnStatement.getExpression());
			return false;
		}
	
		@Override
		public Boolean caseCompoundStatement(CompoundStatement compoundStatement) {
			context.enterVariableScope();
			try {
				for (Statement statement : compoundStatement.getStatements()) {
					if (!doSwitch(statement)) {
						return false;
					}
				}
			} finally {
				context.leaveVariableScope();
			}
			return true;
		}
		
		@Override
		public Boolean caseForStatement(ForStatement forStatement) {
			IValue value = expressionEvaluator.evaluate(new ExpressionEvaluationContext(context), forStatement.getCollectionExpression());
	
			if (!(value.getDataType() instanceof ArrayType)) {
				throw new RuntimeException("Collection type must be array type");
			}
			
			ArrayType arrayType = (ArrayType) value.getDataType();
			if (arrayType.getDimensionality() != 1) {
				throw new RuntimeException("Array dimensionality must be 1");
			}
			
			if (!(value instanceof IArrayValue)) {
				throw new RuntimeException("Value must be array value");
			}
			
			IArrayValue arrayValue = (IArrayValue) value;
			
			int size = TypeUtil.getArraySize(arrayType);
			
			VariableDeclaration iterationVariableDeclaration = forStatement.getIterationVariable();
			for (int i = 0; i < size; ++i) {
				context.enterVariableScope();
				try {
					IVariable variable = new Variable(context, iterationVariableDeclaration);
					variable.setValue(0, arrayValue.get(i));
					context.addVariable(variable);
					if (!doSwitch(forStatement.getBody())) {
						return false;
					}
				} finally {
					context.leaveVariableScope();
				}
			}
	
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.damos.mscript.language.imperativemodel.util.FunctionModelSwitch#caseLocalVariableDeclaration(org.eclipse.damos.mscript.language.imperativemodel.LocalVariableDeclaration)
		 */
		@Override
		public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
			IValue value;
			if (localVariableDeclaration.getInitializer() != null) {
				value = expressionEvaluator.evaluate(new ExpressionEvaluationContext(context), localVariableDeclaration.getInitializer());
			} else {
				value = new UninitializedValue(context.getComputationContext());
			}
			IVariable variable = new Variable(context, localVariableDeclaration);
			variable.setValue(0, value);
			context.addVariable(variable);
			return true;
		}

		@Override
		public Boolean caseIfStatement(IfStatement ifStatement) {
			IValue conditionValue = expressionEvaluator.evaluate(new ExpressionEvaluationContext(context), ifStatement.getCondition());
			if (conditionValue instanceof IBooleanValue) {
				IBooleanValue booleanConditionValue = (IBooleanValue) conditionValue;
				if (booleanConditionValue.booleanValue()) {
					return doSwitch(ifStatement.getThenStatement());
				}
			} else {
				throw new RuntimeException("Condition expression must be boolean");
			}
			return doSwitch(ifStatement.getElseStatement());
		}
		
	}
	
}
