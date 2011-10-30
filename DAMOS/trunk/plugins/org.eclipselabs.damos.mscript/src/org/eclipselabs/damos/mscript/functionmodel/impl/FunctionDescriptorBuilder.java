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

package org.eclipselabs.damos.mscript.functionmodel.impl;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.CallableElement;
import org.eclipselabs.damos.mscript.Equation;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.TemplateParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableAccess;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.EquationSide;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelFactory;
import org.eclipselabs.damos.mscript.functionmodel.IFunctionDescriptorBuilder;
import org.eclipselabs.damos.mscript.functionmodel.IFunctionDescriptorBuilderResult;
import org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.VariableKind;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.util.MscriptSwitch;
import org.eclipselabs.damos.mscript.util.SyntaxStatus;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDescriptorBuilder implements IFunctionDescriptorBuilder {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.functionmodel.construct.IFunctionDescriptorConstructor#construct(org.eclipselabs.mscript.language.ast.FunctionDefinition)
	 */
	public IFunctionDescriptorBuilderResult build(IStaticEvaluationContext context, FunctionDefinition functionDefinition) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Function descriptor construction", null);

		FunctionDescriptor functionDescriptor = FunctionModelFactory.eINSTANCE.createFunctionDescriptor();
		functionDescriptor.setDefinition(functionDefinition);

		for (Equation equation : functionDefinition.getEquations()) {
			EquationDescriptor equationDescriptor = FunctionModelFactory.eINSTANCE.createEquationDescriptor();
			equationDescriptor.setFunctionDescriptor(functionDescriptor);
			equationDescriptor.setEquation(equation);
			
			Expression lhsExpression = equation.getLeftHandSide();
			EquationSide lhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			lhs.setDescriptor(equationDescriptor);
			lhs.setExpression(lhsExpression);
			StatusUtil.merge(status, new EquationSideInitializer(context, lhs).initialize());
			
			Expression rhsExpression = equation.getRightHandSide();
			EquationSide rhs = FunctionModelFactory.eINSTANCE.createEquationSide();
			rhs.setDescriptor(equationDescriptor);
			rhs.setExpression(rhsExpression);
			StatusUtil.merge(status, new EquationSideInitializer(context, rhs).initialize());
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new FunctionDescriptorBuilderResult(functionDescriptor, status);
		}
		
		return new FunctionDescriptorBuilderResult(functionDescriptor);
	}
			
	private static class EquationSideInitializer extends MscriptSwitch<Boolean> {
		
		private IStaticEvaluationContext context;
		private EquationSide equationSide;
		private MultiStatus status;
		
		/**
		 * 
		 */
		public EquationSideInitializer(IStaticEvaluationContext context, EquationSide equationSide) {
			this.context = context;
			this.equationSide = equationSide;
		}
		
		public IStatus initialize() {
			status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "", null);
			doSwitch(equationSide.getExpression());
			return status;
		}
		
		@Override
		public Boolean caseVariableAccess(VariableAccess variableAccess) {
			String name = variableAccess.getFeature().getName();
			
			FunctionDescriptor functionDescriptor = equationSide.getDescriptor().getFunctionDescriptor();
			VariableKind variableKind = getVariableKind(variableAccess.getFeature());
			
			checkFeatureCall(variableAccess, variableKind);
			
			if (variableKind != VariableKind.UNKNOWN) {
				int stepIndex = 0;
				boolean initial = false;
				
				if (variableKind == VariableKind.INPUT_PARAMETER
						|| variableKind == VariableKind.OUTPUT_PARAMETER
						|| variableKind == VariableKind.STATE_VARIABLE) {
					stepIndex = context.getStepIndex(variableAccess);
					initial = variableAccess.isInitial();
				}
				
				if (!initial) {
					Equation equation = (Equation) equationSide.getExpression().eContainer();
					if (equation.getLeftHandSide() == equationSide.getExpression() && equation.isInitial()) {
						initial = true;
					}
				}

				EquationPart part = FunctionModelFactory.eINSTANCE.createEquationPart();
				part.setSide(equationSide);
				part.setVariableAccess(variableAccess);
				VariableDescriptor variableDescriptor = getVariableDescriptor(functionDescriptor, name, variableKind);
				
				VariableStep variableStep = variableDescriptor.getStep(stepIndex, initial, false);
				if (variableStep == null) {
					variableStep = FunctionModelFactory.eINSTANCE.createVariableStep();
					variableStep.setDescriptor(variableDescriptor);
					variableStep.setIndex(stepIndex);
					variableStep.setInitial(initial);
				}
				part.setVariableStep(variableStep);
			}
			return true;
		}
		
		/**
		 * @param featureCall
		 * @param variableKind
		 */
		private void checkFeatureCall(VariableAccess variableAccess, VariableKind variableKind) {
			String message = null;
			switch (variableKind) {
			case INPUT_PARAMETER:
			case OUTPUT_PARAMETER:
			case STATE_VARIABLE:
				if (variableAccess.getStepExpression() != null) {
					switch (equationSide.getDescriptor().getFunctionDescriptor().getDefinition().getKind()) {
					case STATELESS:
						message = "Variable references of stateless functions must not specify step expressions";
						break;
					case CONTINUOUS:
						message = "Variable references of continuous functions must not specify step expressions";
						break;
					}
				}
				break;
			}
			
			if (message != null) {
				status.add(new SyntaxStatus(IStatus.ERROR, MscriptPlugin.PLUGIN_ID, 0, message, variableAccess));
			}
		}

		/**
		 * @param functionDescriptor
		 * @param name
		 * @param variableKind
		 * @return
		 */
		private VariableDescriptor getVariableDescriptor(FunctionDescriptor functionDescriptor, String name,
				VariableKind variableKind) {
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(name);
			if (variableDescriptor == null) {
				variableDescriptor = FunctionModelFactory.eINSTANCE.createVariableDescriptor();
				variableDescriptor.setFunctionDescriptor(functionDescriptor);
				variableDescriptor.setName(name);
				variableDescriptor.setKind(variableKind);
			}
			return variableDescriptor;
		}

		private VariableKind getVariableKind(CallableElement feature) {
			if (feature instanceof TemplateParameterDeclaration) {
				return VariableKind.TEMPLATE_PARAMETER;
			}
			if (feature instanceof InputParameterDeclaration) {
				return VariableKind.INPUT_PARAMETER;
			}
			if (feature instanceof OutputParameterDeclaration) {
				return VariableKind.OUTPUT_PARAMETER;
			}
			if (feature instanceof StateVariableDeclaration) {
				return VariableKind.STATE_VARIABLE;
			}
			return VariableKind.UNKNOWN;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.MscriptSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			for (EObject content : object.eContents()) {
				doSwitch(content);
			}
			return true;
		}

	}

}
