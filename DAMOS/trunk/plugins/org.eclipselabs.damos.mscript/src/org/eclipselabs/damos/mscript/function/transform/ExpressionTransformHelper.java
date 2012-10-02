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

package org.eclipselabs.damos.mscript.function.transform;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

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
