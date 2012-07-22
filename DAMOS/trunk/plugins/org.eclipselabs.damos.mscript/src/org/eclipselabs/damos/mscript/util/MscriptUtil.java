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

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.AdditiveStepExpression;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.Declaration;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.Module;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StepLiteral;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.VariableReference;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;

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

	public static FunctionDeclaration getFunctionDefinition(Module module, String qualifiedName) {
		return getFunctionDefinition(module.getDeclarations(), qualifiedName);
	}
	
	public static FunctionDeclaration getFunctionDefinition(Collection<Declaration> declarations, String qualifiedName) {
		for (Declaration declaration : declarations) {
			if (declaration instanceof FunctionDeclaration) {
				FunctionDeclaration functionDeclaration = (FunctionDeclaration) declaration;
				if (qualifiedName.equals(functionDeclaration.getName())) {
					return functionDeclaration;
				}
			}
		}
		return null;
	}

	public static VariableReference createVariableReference(IStaticEvaluationResult staticEvaluationResult, VariableDeclaration variableDeclaration, int stepIndex, boolean initial) {
		VariableReference variableReference = MscriptFactory.eINSTANCE.createVariableReference();
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
		staticEvaluationResult.setStepIndex(variableReference, stepIndex);
		return variableReference;
	}
	
	public static String findAvailableLocalVariableName(CompoundStatement compoundStatement, String preferredName) {
		String name = preferredName;
		int i = 2;
		while (!isLocalVariableNameAvailable(compoundStatement, name)) {
			name = preferredName + i++;
		}
		return name;
	}
	
	private static boolean isLocalVariableNameAvailable(CompoundStatement compoundStatement, String name) {
		if (RESERVED_WORDS.contains(name)) {
			return false;
		}
		
		EObject container = compoundStatement;
		while (container != null) {
			if (container instanceof CompoundStatement) {
				for (LocalVariableDeclaration localVariableDeclaration : ((CompoundStatement) container).getLocalVariableDeclarations()) {
					if (name.equals(localVariableDeclaration.getName())) {
						return false;
					}
				}
			}
			container = container.eContainer();
		}
		
		return true;
	}
	
}
