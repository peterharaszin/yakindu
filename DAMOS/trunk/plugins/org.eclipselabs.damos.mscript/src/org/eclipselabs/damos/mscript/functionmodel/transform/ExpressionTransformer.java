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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.Assignment;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.IntegerLiteral;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.Literal;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.RealLiteral;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformer extends MscriptSwitch<Expression> implements IExpressionTransformer {

	private final IExpressionTransformStrategyProvider expressionTransformStrategyProvider = new DefaultExpressionTransformStrategyProvider();
	
	private ITransformerContext context;

	private MultiStatus status;

	/**
	 * 
	 */
	public ExpressionTransformer(ITransformerContext context) {
		this.context = context;
		status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression transformation", null);
	}
	
	public IStatus transform(Expression expression, List<? extends IExpressionTarget> targets) {
		Expression result = transformNext(expression);
		IExpressionTarget target = targets.get(0);

		Assignment assignment = MscriptFactory.eINSTANCE.createAssignment();
		assignment.setAssignedExpression(result);
		assignment.setTarget(MscriptUtil.createVariableReference(context.getStaticEvaluationResult(), target.getVariableDeclaration(), target.getStepIndex(), false));
		context.getCompound().getStatements().add(assignment);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	public Expression transformNext(Expression expression) {
		Expression newExpression = null;
		for (IExpressionTransformStrategy transformStrategy : expressionTransformStrategyProvider.getExpressionTransformStrategies()) {
			if (transformStrategy.canHandle(expression)) {
				newExpression = transformStrategy.transform(context, this, expression);
				if (newExpression != null) {
					break;
				}
			}
		}
		IValue value = context.getStaticEvaluationResult().getValue(expression);
		if (value != null) {
			if (!(expression instanceof Literal)) {
				newExpression = condenseExpression(value, newExpression);
			}
			context.getStaticEvaluationResult().setValue(newExpression, value);
		}
		return newExpression;
	}

	protected Expression condenseExpression(IValue value, Expression expression) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			NumericType dataType = numericValue.getDataType();
			if (dataType instanceof RealType) {
				RealLiteral realLiteral = MscriptFactory.eINSTANCE.createRealLiteral();
				realLiteral.setValue(numericValue.doubleValue());
				realLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = realLiteral;
			} else if (dataType instanceof IntegerType) {
				IntegerLiteral integerLiteral = MscriptFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setValue(numericValue.longValue());
				integerLiteral.setUnit(EcoreUtil.copy(dataType.getUnit()));
				expression = integerLiteral;
			}
		}
		return expression;
	}
	
}
