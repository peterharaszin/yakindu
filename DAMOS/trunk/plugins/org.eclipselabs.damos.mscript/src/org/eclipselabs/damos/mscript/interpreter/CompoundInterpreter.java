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

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.ForStatement;
import org.eclipselabs.damos.mscript.IfStatement;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.Statement;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.il.util.ILSwitch;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.IBooleanValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.UninitializedValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.TypeUtil;

/**
 * @author Andreas Unger
 *
 */
public class CompoundInterpreter implements ICompoundInterpreter {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.ICompoundInterpreter#execute(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.il.Compound)
	 */
	public void execute(IInterpreterContext context, Compound compound) {
		new CompoundInterpreterSwitch(context).doSwitch(compound);
	}
	
	private static class CompoundInterpreterSwitch extends ILSwitch<Boolean> {
		
		private IInterpreterContext context;
		
		private IExpressionValueEvaluator expressionValueEvaluator = new ExpressionValueEvaluator();
		
		private AstCompoundInterpreterSwitch astCompoundInterpreterSwitch = new AstCompoundInterpreterSwitch();

		/**
		 * 
		 */
		public CompoundInterpreterSwitch(IInterpreterContext context) {
			this.context = context;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			return astCompoundInterpreterSwitch.doSwitch(object);
		}
		
		private class AstCompoundInterpreterSwitch extends MscriptSwitch<Boolean> {
			
			@Override
			public Boolean caseAssignment(Assignment assignment) {
				if (!(assignment.getTarget() instanceof VariableAccess)) {
					throw new IllegalArgumentException();
				}
				VariableAccess variableAccess = (VariableAccess) assignment.getTarget();

				if (!(variableAccess.getFeature() instanceof VariableDeclaration)) {
					throw new IllegalArgumentException();
				}
				VariableDeclaration variableDeclaration = (VariableDeclaration) variableAccess.getFeature();
				
				IValue value = expressionValueEvaluator.evaluate(context, assignment.getAssignedExpression());
				IVariable variable = context.getVariable(variableDeclaration);
				variable.setValue(context.getStaticEvaluationContext().getStepIndex(variableAccess), value);
				return true;
			}
		

			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseCompound(org.eclipselabs.mscript.language.imperativemodel.Compound)
			 */
			@Override
			public Boolean caseCompound(Compound compound) {
				context.enterScope();
				for (Statement statement : compound.getStatements()) {
					CompoundInterpreterSwitch.this.doSwitch(statement);
				}
				context.leaveScope();
				return true;
			}
			
			@Override
			public Boolean caseForStatement(ForStatement forStatement) {
				IValue value = expressionValueEvaluator.evaluate(context, forStatement.getCollectionExpression());
		
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
					context.enterScope();
					IVariable variable = new Variable(context, iterationVariableDeclaration);
					variable.setValue(0, arrayValue.get(i));
					context.addVariable(variable);
					CompoundInterpreterSwitch.this.doSwitch(forStatement.getBody());
					context.leaveScope();
				}
		
				return true;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration)
			 */
			@Override
			public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
				IValue value;
				if (localVariableDeclaration.getInitializer() != null) {
					value = expressionValueEvaluator.evaluate(context, localVariableDeclaration.getInitializer());
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
				IValue conditionValue = expressionValueEvaluator.evaluate(context, ifStatement.getCondition());
				if (conditionValue instanceof IBooleanValue) {
					IBooleanValue booleanConditionValue = (IBooleanValue) conditionValue;
					if (booleanConditionValue.booleanValue()) {
						return CompoundInterpreterSwitch.this.doSwitch(ifStatement.getThenStatement());
					}
				} else {
					throw new RuntimeException("Condition expression must be boolean");
				}
				return CompoundInterpreterSwitch.this.doSwitch(ifStatement.getElseStatement());
			}
			
		}

	}
	
}
