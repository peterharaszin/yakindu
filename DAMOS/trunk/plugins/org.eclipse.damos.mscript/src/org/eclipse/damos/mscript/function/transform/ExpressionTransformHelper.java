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

package org.eclipse.damos.mscript.function.transform;

import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.LocalVariableDeclaration;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.MscriptUtil;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionTransformHelper {

	public FeatureReference transformToVariableReference(ITransformerContext context, Expression expression, String name, IExpressionTransformer transformer) {
		if (expression instanceof FeatureReference) {
			FeatureReference newVariableReference = EcoreUtil.copy((FeatureReference) expression);
			context.getFunctionInfo().setValue(newVariableReference, context.getFunctionInfo().getValue(expression));
			return newVariableReference;
		}
		
		IValue operandValue = context.getFunctionInfo().getValue(expression);
		
		LocalVariableDeclaration variableDeclaration = MscriptFactory.eINSTANCE.createLocalVariableDeclaration();
		variableDeclaration.setName(MscriptUtil.findAvailableLocalVariableName(context.getCompound(), name));
		context.getFunctionInfo().setValue(variableDeclaration, operandValue);
		context.getCompound().getStatements().add(variableDeclaration);
		
		VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclaration);
		transformer.transform(context, expression, target.asList());
		
		return target.createVariableReference(operandValue.getDataType());
	}

}
