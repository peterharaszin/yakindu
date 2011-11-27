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

package org.eclipselabs.damos.mscript.util;

import org.eclipselabs.damos.mscript.AdditiveOperator;
import org.eclipselabs.damos.mscript.AdditiveStepExpression;
import org.eclipselabs.damos.mscript.Definition;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.Module;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.StepLiteral;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class MscriptUtil {

	public static FunctionDefinition getFunctionDefinition(Module module, String qualifiedName) {
		for (Definition definition : module.getDefinitions()) {
			if (definition instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) definition;
				if (qualifiedName.equals(functionDefinition.getName())) {
					return functionDefinition;
				}
			}
		}
		return null;
	}
	
	public static VariableAccess createVariableAccess(IStaticEvaluationContext context, VariableDeclaration variableDeclaration, int stepIndex, boolean initial) {
		VariableAccess variableAccess = MscriptFactory.eINSTANCE.createVariableAccess();
		variableAccess.setFeature(variableDeclaration);
		if (initial) {
			StepLiteral stepLiteral = MscriptFactory.eINSTANCE.createStepLiteral();
			stepLiteral.setValue(stepIndex);
			variableAccess.setStepExpression(stepLiteral);
		} else {
			AdditiveStepExpression stepExpression = MscriptFactory.eINSTANCE.createAdditiveStepExpression();
			stepExpression.setLeftOperand(MscriptFactory.eINSTANCE.createStepN());
			if (stepIndex < 0) {
				stepExpression.setOperator(AdditiveOperator.SUBTRACT);
			} else {
				stepExpression.setOperator(AdditiveOperator.ADD);
			}
			StepLiteral stepLiteral = MscriptFactory.eINSTANCE.createStepLiteral();
			stepLiteral.setValue(Math.abs(stepIndex));
			stepExpression.setRightOperand(stepLiteral);
			variableAccess.setStepExpression(stepLiteral);
		}
		context.setStepIndex(variableAccess, stepIndex);
		return variableAccess;
	}
		
}
