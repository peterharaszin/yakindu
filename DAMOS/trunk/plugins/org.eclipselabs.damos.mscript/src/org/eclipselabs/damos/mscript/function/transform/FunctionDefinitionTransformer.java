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

package org.eclipselabs.damos.mscript.function.transform;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.function.ComputationCompound;
import org.eclipselabs.damos.mscript.function.EquationDescription;
import org.eclipselabs.damos.mscript.function.EquationPart;
import org.eclipselabs.damos.mscript.function.FunctionDescription;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.function.FunctionModelFactory;
import org.eclipselabs.damos.mscript.function.VariableDescription;
import org.eclipselabs.damos.mscript.function.VariableKind;
import org.eclipselabs.damos.mscript.function.VariableStep;
import org.eclipselabs.damos.mscript.function.util.EquationCompoundHelper;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.function.util.InternalFunctionModelUtil;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.value.AnyValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class FunctionDefinitionTransformer implements IFunctionDefinitionTransformer {
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformer#transform(org.eclipselabs.mscript.language.function.FunctionDescriptor, java.lang.String, java.util.List, java.util.List)
	 */
	public IFunctionDefinitionTransformerResult transform(IStaticEvaluationResult staticEvaluationResult, FunctionDescription functionDescription, List<IValue> staticArguments, List<Type> inputParameterDataTypes) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Function definition transformation", null);

		FunctionInstance functionInstance = FunctionModelFactory.eINSTANCE.createFunctionInstance();
		functionInstance.setDeclaration(functionDescription.getDeclaration());
		
		Map<VariableDescription, VariableDeclaration> variableDeclarations = new HashMap<VariableDescription, VariableDeclaration>();
		
		initializeVariableDeclarations(staticEvaluationResult, functionInstance, functionDescription, staticArguments, inputParameterDataTypes, variableDeclarations);

		Collection<List<EquationDescription>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(functionDescription);
		
		IFunctionDefinitionTransformerContext context = new FunctionDefinitionTransformerContext(staticEvaluationResult, functionInstance);
		StatusUtil.merge(status, constructInitializationCompound(context, equationCompounds, variableDeclarations));
		StatusUtil.merge(status, constructComputationCompounds(context, equationCompounds, variableDeclarations));
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new FunctionDefinitionTransformerResult(functionInstance, status);
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new FunctionDefinitionTransformerResult(functionInstance, status);
		}

		return new FunctionDefinitionTransformerResult(functionInstance);
	}
	
	private void initializeVariableDeclarations(IStaticEvaluationResult staticEvaluationResult, FunctionInstance functionInstance, FunctionDescription functionDescription, List<IValue> staticArguments, List<Type> inputParameterDataTypes, Map<VariableDescription, VariableDeclaration> variableDeclarations) {
		Iterator<IValue> staticArgumentIterator = staticArguments.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescription.getDeclaration().getStaticParameterDeclarations()) {
			if (staticArgumentIterator.hasNext()) {
				IValue value = staticArgumentIterator.next();
				staticEvaluationResult.setValue(parameterDeclaration, value);
			}
			VariableDescription variableDescription = functionDescription.getVariableDescription(parameterDeclaration.getName());
			if (variableDescription != null) {
				variableDeclarations.put(variableDescription, parameterDeclaration);
			}
		}

		Iterator<Type> inputParameterDataTypesIterator = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescription.getDeclaration().getInputParameterDeclarations()) {
			if (inputParameterDataTypesIterator.hasNext()) {
				Type type = EcoreUtil.copy(inputParameterDataTypesIterator.next());
				IValue value = new AnyValue(staticEvaluationResult.getComputationContext(), type);
				staticEvaluationResult.setValue(parameterDeclaration, value);
			}
			VariableDescription variableDescription = functionDescription.getVariableDescription(parameterDeclaration.getName());
			if (variableDescription != null) {
				int circularBufferSize = getInoutputCircularBufferSize(variableDescription);
				staticEvaluationResult.setCircularBufferSize(parameterDeclaration, circularBufferSize);
				variableDeclarations.put(variableDescription, parameterDeclaration);
			}
		}
		
		for (ParameterDeclaration parameterDeclaration : functionDescription.getDeclaration().getOutputParameterDeclarations()) {
			VariableDescription variableDescription = functionDescription.getVariableDescription(parameterDeclaration.getName());
			if (variableDescription != null) {
				int circularBufferSize = getInoutputCircularBufferSize(variableDescription);
				staticEvaluationResult.setCircularBufferSize(parameterDeclaration, circularBufferSize);
				IValue value = staticEvaluationResult.getValue(parameterDeclaration);
				if (value != null) {
					staticEvaluationResult.setValue(parameterDeclaration, value);
				}
				variableDeclarations.put(variableDescription, parameterDeclaration);
			}
		}

		for (StateVariableDeclaration stateVariableDeclaration : functionDescription.getDeclaration().getStateVariableDeclarations()) {
			VariableDescription variableDescription = functionDescription.getVariableDescription(stateVariableDeclaration.getName());
			if (variableDescription != null) {
				int circularBufferSize = variableDescription.getMaximumStep().getIndex() - variableDescription.getMinimumStep().getIndex() + 1;
				staticEvaluationResult.setCircularBufferSize(stateVariableDeclaration, circularBufferSize);
				IValue value = staticEvaluationResult.getValue(stateVariableDeclaration);
				if (value != null) {
					staticEvaluationResult.setValue(stateVariableDeclaration, value);
				}
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
	
	private IStatus constructInitializationCompound(IFunctionDefinitionTransformerContext context, Collection<List<EquationDescription>> equationCompounds, Map<VariableDescription, VariableDeclaration> variableDeclarations) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Initialization compound construction", null);
		
		CompoundStatement compoundStatement = MscriptFactory.eINSTANCE.createCompoundStatement();
		for (Iterator<List<EquationDescription>> it = equationCompounds.iterator(); it.hasNext();) {
			List<EquationDescription> equationDescriptions = it.next();
			boolean processed = false;
			for (EquationDescription equationDescription : equationDescriptions) {
				VariableStep lhsVariableStep = InternalFunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescription);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					context.enterScope();
					context.setCompound(compoundStatement);

					IExpressionTransformer transformer = new ExpressionTransformer(context);
					VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclarations.get(lhsVariableStep.getVariableDescription()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescription.getRightHandSide().getExpression(), Collections.singletonList(target)));
					
					context.leaveScope();

					processed = true;
				}
			}
			if (processed) {
				it.remove();
			}
		}
		context.getFunctionInstance().setInitializationCompound(compoundStatement);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	private IStatus constructComputationCompounds(IFunctionDefinitionTransformerContext context, Collection<List<EquationDescription>> equationCompounds, Map<VariableDescription, VariableDeclaration> variableDeclarations) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Computation compound construction", null);

		for (List<EquationDescription> equationDescriptions : equationCompounds) {
			ComputationCompound compound = FunctionModelFactory.eINSTANCE.createComputationCompound();
			Set<InputParameterDeclaration> inputs = new HashSet<InputParameterDeclaration>();
			for (EquationDescription equationDescription : equationDescriptions) {
				VariableStep lhsVariableStep = InternalFunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescription);
				if (lhsVariableStep != null) {
					context.enterScope();
					context.setCompound(compound);
					
					IExpressionTransformer transformer = new ExpressionTransformer(context);
					VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclarations.get(lhsVariableStep.getVariableDescription()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescription.getRightHandSide().getExpression(), Collections.singletonList(target)));

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

		return status.isOK() ? Status.OK_STATUS : status;
	}
	
}
