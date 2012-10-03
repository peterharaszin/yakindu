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

package org.eclipse.damos.mscript.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.damos.mscript.AdditiveStepExpression;
import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.LambdaExpression;
import org.eclipse.damos.mscript.Module;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.StepLiteral;
import org.eclipse.damos.mscript.TopLevelDeclaration;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.emf.ecore.EObject;

/**
 * @author Andreas Unger
 *
 */
public class MscriptUtil {

	private static final Set<String> RESERVED_WORDS = new HashSet<String>();

	{
		// keywords
		RESERVED_WORDS.add("auto");
		RESERVED_WORDS.add("break");
		RESERVED_WORDS.add("case");
		RESERVED_WORDS.add("char");
		RESERVED_WORDS.add("const");
		RESERVED_WORDS.add("continue");
		RESERVED_WORDS.add("default");
		RESERVED_WORDS.add("do");
		RESERVED_WORDS.add("double");
		RESERVED_WORDS.add("else");
		RESERVED_WORDS.add("enum");
		RESERVED_WORDS.add("extern");
		RESERVED_WORDS.add("float");
		RESERVED_WORDS.add("for");
		RESERVED_WORDS.add("goto");
		RESERVED_WORDS.add("if");
		RESERVED_WORDS.add("int");
		RESERVED_WORDS.add("long");
		RESERVED_WORDS.add("register");
		RESERVED_WORDS.add("return");
		RESERVED_WORDS.add("short");
		RESERVED_WORDS.add("signed");
		RESERVED_WORDS.add("sizeof");
		RESERVED_WORDS.add("static");
		RESERVED_WORDS.add("struct");
		RESERVED_WORDS.add("switch");
		RESERVED_WORDS.add("typedef");
		RESERVED_WORDS.add("union");
		RESERVED_WORDS.add("unsigned");
		RESERVED_WORDS.add("void");
		RESERVED_WORDS.add("volatile");
		RESERVED_WORDS.add("while");
		
		// standard typedefs
		RESERVED_WORDS.add("int8_t");
		RESERVED_WORDS.add("int16_t");
		RESERVED_WORDS.add("int32_t");
		RESERVED_WORDS.add("int64_t");
		RESERVED_WORDS.add("uint8_t");
		RESERVED_WORDS.add("uint16_t");
		RESERVED_WORDS.add("uint32_t");
		RESERVED_WORDS.add("uint64_t");
		RESERVED_WORDS.add("bool");
		
		// Mscript reserved
		RESERVED_WORDS.add("context");
		RESERVED_WORDS.add("input");
		RESERVED_WORDS.add("output");
	}
	
	public static int getMandatoryInputParameterCount(FunctionDeclaration functionDeclaration) {
		int i = 0;
		for (InputParameterDeclaration parameterDeclaration : functionDeclaration.getInputParameterDeclarations()) {
			if (parameterDeclaration.isConstant() && parameterDeclaration.getDefaultExpression() != null) {
				break;
			}
			++i;
		}
		return i;
	}

	public static FunctionDeclaration getFunctionDeclaration(Module module, String qualifiedName) {
		return getFunctionDeclaration(module.getDeclarations(), qualifiedName);
	}
	
	public static FunctionDeclaration getFunctionDeclaration(Collection<TopLevelDeclaration> topLevelDeclarations, String qualifiedName) {
		for (TopLevelDeclaration topLevelDeclaration : topLevelDeclarations) {
			if (topLevelDeclaration instanceof FunctionDeclaration) {
				FunctionDeclaration functionDeclaration = (FunctionDeclaration) topLevelDeclaration;
				if (qualifiedName.equals(functionDeclaration.getName())) {
					return functionDeclaration;
				}
			}
		}
		return null;
	}

	public static FeatureReference createVariableReference(StaticFunctionInfo functionInfo, VariableDeclaration variableDeclaration, int stepIndex, boolean initial) {
		FeatureReference variableReference = MscriptFactory.eINSTANCE.createFeatureReference();
		variableReference.setFeature(variableDeclaration);
		if (initial) {
			StepLiteral stepLiteral = MscriptFactory.eINSTANCE.createStepLiteral();
			stepLiteral.setValue(stepIndex);
			variableReference.setStepExpression(stepLiteral);
		} else {
			AdditiveStepExpression stepExpression = MscriptFactory.eINSTANCE.createAdditiveStepExpression();
			stepExpression.setLeftOperand(MscriptFactory.eINSTANCE.createStepN());
			if (stepIndex < 0) {
				stepExpression.setOperator(OperatorKind.SUBTRACT);
			} else {
				stepExpression.setOperator(OperatorKind.ADD);
			}
			StepLiteral stepLiteral = MscriptFactory.eINSTANCE.createStepLiteral();
			stepLiteral.setValue(Math.abs(stepIndex));
			stepExpression.setRightOperand(stepLiteral);
			variableReference.setStepExpression(stepLiteral);
		}
		functionInfo.setStepIndex(variableReference, stepIndex);
		return variableReference;
	}
	
	public static String findAvailableLocalVariableName(EObject context, String preferredName) {
		String name = preferredName;
		int i = 2;
		while (!isLocalVariableNameAvailable(context, name)) {
			name = preferredName + i++;
		}
		return name;
	}
	
	private static boolean isLocalVariableNameAvailable(EObject context, String name) {
		if (RESERVED_WORDS.contains(name)) {
			return false;
		}
		
		EObject container = context;
		while (container != null) {
			if (container instanceof CompoundStatement) {
				for (VariableDeclaration variable : ((CompoundStatement) container).getLocalVariableDeclarations()) {
					if (name.equals(variable.getName())) {
						return false;
					}
				}
			} else if (container instanceof LambdaExpression) {
				for (VariableDeclaration variable : ((LambdaExpression) container).getParameters()) {
					if (name.equals(variable.getName())) {
						return false;
					}
				}
			}
			container = container.eContainer();
		}
		
		return true;
	}
	
	public static boolean isVariableReference(Expression expression) {
		if (expression instanceof FeatureReference) {
			return ((FeatureReference) expression).getFeature() instanceof VariableDeclaration;
		}
		return false;
	}
	
}
