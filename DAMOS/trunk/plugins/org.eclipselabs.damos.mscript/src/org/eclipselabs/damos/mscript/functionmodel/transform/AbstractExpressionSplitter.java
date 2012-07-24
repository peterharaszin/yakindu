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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExpressionSplitter implements IExpressionTransformStrategy {

	protected VariableReference createVariableReference(ITransformerContext context, Expression operand, String name, IExpressionTransformer transformer) {
		IValue operandValue = context.getStaticEvaluationResult().getValue(operand);
	
		LocalVariableDeclaration variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), name));
		context.getStaticEvaluationResult().setValue(variableDeclaration, operandValue);
		context.getCompound().getStatements().add(variableDeclaration);
		
		VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclaration);
		transformer.transform(operand, target.asList());
		
		return target.createVariableReference(operandValue.getDataType());
	}

	protected Type getDataType(ITransformerContext context, Expression expression) {
		return context.getStaticEvaluationResult().getValue(expression).getDataType();
	}

}