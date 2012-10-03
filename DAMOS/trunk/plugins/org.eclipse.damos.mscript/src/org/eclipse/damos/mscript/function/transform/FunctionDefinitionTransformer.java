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

package org.eclipse.damos.mscript.function.transform;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.ParameterDeclaration;
import org.eclipse.damos.mscript.StateVariableDeclaration;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.function.ComputationCompound;
import org.eclipse.damos.mscript.function.EquationDescription;
import org.eclipse.damos.mscript.function.EquationPart;
import org.eclipse.damos.mscript.function.FunctionDescription;
import org.eclipse.damos.mscript.function.FunctionFactory;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.function.VariableDescription;
import org.eclipse.damos.mscript.function.VariableKind;
import org.eclipse.damos.mscript.function.VariableStep;
import org.eclipse.damos.mscript.function.util.EquationCompoundHelper;
import org.eclipse.damos.mscript.internal.function.util.InternalFunctionModelUtil;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformer implements IFunctionDefinitionTransformer {
	
	public FunctionInstance transform(IStaticEvaluationResult staticEvaluationResult, StaticFunctionInfo functionInfo) {
		FunctionInstance functionInstance = functionInfo.getFunctionInstance();
		if (functionInstance != null) {
			return functionInstance;
		}
		
		FunctionDescription functionDescription = functionInfo.getFunctionDescription();
		
		functionInstance = FunctionFactory.eINSTANCE.createFunctionInstance();
		functionInstance.setDeclaration(functionDescription.getDeclaration());
		
		Map<VariableDescription, VariableDeclaration> variableDeclarations = new HashMap<VariableDescription, VariableDeclaration>();
		
		IFunctionDefinitionTransformerContext context = new FunctionDefinitionTransformerContext(staticEvaluationResult, functionInfo, functionInstance);
		initializeVariableDeclarations(context, functionDescription, variableDeclarations);

		Collection<List<EquationDescription>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(functionDescription);
		
		constructInitializationCompound(context, equationCompounds, variableDeclarations);
		constructComputationCompounds(context, equationCompounds, variableDeclarations);
		
		functionInfo.setFunctionInstance(functionInstance);

		return functionInstance;
	}
	
	private void initializeVariableDeclarations(IFunctionDefinitionTransformerContext context, FunctionDescription functionDescription, Map<VariableDescription, VariableDeclaration> variableDeclarations) {
		for (InputParameterDeclaration parameterDeclaration : functionDescription.getDeclaration().getInputParameterDeclarations()) {
			VariableDescription variableDescription = functionDescription.getVariableDescription(parameterDeclaration.getName());
			if (variableDescription != null) {
				if (!parameterDeclaration.isConstant()) {
					int circularBufferSize = getInoutputCircularBufferSize(variableDescription);
					context.getFunctionInfo().setCircularBufferSize(parameterDeclaration, circularBufferSize);
				}
				variableDeclarations.put(variableDescription, parameterDeclaration);
			}
		}
		
		for (ParameterDeclaration parameterDeclaration : functionDescription.getDeclaration().getOutputParameterDeclarations()) {
			VariableDescription variableDescription = functionDescription.getVariableDescription(parameterDeclaration.getName());
			if (variableDescription != null) {
				int circularBufferSize = getInoutputCircularBufferSize(variableDescription);
				context.getFunctionInfo().setCircularBufferSize(parameterDeclaration, circularBufferSize);
				variableDeclarations.put(variableDescription, parameterDeclaration);
			}
		}

		for (StateVariableDeclaration stateVariableDeclaration : functionDescription.getDeclaration().getStateVariableDeclarations()) {
			VariableDescription variableDescription = functionDescription.getVariableDescription(stateVariableDeclaration.getName());
			if (variableDescription != null) {
				int circularBufferSize = variableDescription.getMaximumStep().getIndex() - variableDescription.getMinimumStep().getIndex() + 1;
				context.getFunctionInfo().setCircularBufferSize(stateVariableDeclaration, circularBufferSize);
				variableDeclarations.put(variableDescription, stateVariableDeclaration);
			}
		}
	}
	
	private int getInoutputCircularBufferSize(VariableDescription variableDescription) {
		int minimumStepIndex = variableDescription.getMinimumStep().getIndex();
		if (minimumStepIndex > 0) {
			minimumStepIndex = 0;
		}
		int maximumStepIndex = variableDescription.getMaximumStep().getIndex();
		if (maximumStepIndex < 0) {
			maximumStepIndex = 0;
		}
		return maximumStepIndex - minimumStepIndex + 1;
	}
	
	private void constructInitializationCompound(IFunctionDefinitionTransformerContext context, Collection<List<EquationDescription>> equationCompounds, Map<VariableDescription, VariableDeclaration> variableDeclarations) {
		CompoundStatement compoundStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		for (Iterator<List<EquationDescription>> it = equationCompounds.iterator(); it.hasNext();) {
			List<EquationDescription> equationDescriptions = it.next();
			boolean processed = false;
			for (EquationDescription equationDescription : equationDescriptions) {
				VariableStep lhsVariableStep = InternalFunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescription);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					context.enterScope();
					context.setCompound(compoundStatement);

					IExpressionTransformer transformer = new ExpressionTransformer();
					VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclarations.get(lhsVariableStep.getVariableDescription()), lhsVariableStep.getIndex());
					transformer.transform(context, equationDescription.getRightHandSide().getExpression(), Collections.singletonList(target));
					
					context.leaveScope();

					processed = true;
				}
			}
			if (processed) {
				it.remove();
			}
		}
		context.getFunctionInstance().setInitializationCompound(compoundStatement);
	}
	
	private void constructComputationCompounds(IFunctionDefinitionTransformerContext context, Collection<List<EquationDescription>> equationCompounds, Map<VariableDescription, VariableDeclaration> variableDeclarations) {
		for (List<EquationDescription> equationDescriptions : equationCompounds) {
			ComputationCompound compound = FunctionFactory.eINSTANCE.createComputationCompound();
			Set<InputParameterDeclaration> inputs = new HashSet<InputParameterDeclaration>();
			for (EquationDescription equationDescription : equationDescriptions) {
				VariableStep lhsVariableStep = InternalFunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescription);
				if (lhsVariableStep != null) {
					context.enterScope();
					context.setCompound(compound);
					
					IExpressionTransformer transformer = new ExpressionTransformer();
					VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclarations.get(lhsVariableStep.getVariableDescription()), lhsVariableStep.getIndex());
					transformer.transform(context, equationDescription.getRightHandSide().getExpression(), Collections.singletonList(target));

					context.leaveScope();

					for (EquationPart equationPart : equationDescription.getRightHandSide().getParts()) {
						VariableStep rhsVariableStep = equationPart.getVariableStep();
						if (rhsVariableStep.getVariableDescription().getKind() == VariableKind.INPUT_PARAMETER
								&& rhsVariableStep.getIndex() == 0) {
							inputs.add((InputParameterDeclaration) variableDeclarations.get(rhsVariableStep.getVariableDescription()));
						}
					}

					if (lhsVariableStep.getVariableDescription().getKind() == VariableKind.OUTPUT_PARAMETER
							&& lhsVariableStep.getIndex() == 0) {
						compound.getOutputs().add((OutputParameterDeclaration) variableDeclarations.get(lhsVariableStep.getVariableDescription()));
					}
					
					if (lhsVariableStep.isDerivative()) {
						compound.getDerivatives().add(variableDeclarations.get(lhsVariableStep.getVariableDescription()));
					}
				}
			}
			for (InputParameterDeclaration input : inputs) {
				compound.getInputs().add(input);
			}
			context.getFunctionInstance().getComputationCompounds().add(compound);
		}
	}
	
}
