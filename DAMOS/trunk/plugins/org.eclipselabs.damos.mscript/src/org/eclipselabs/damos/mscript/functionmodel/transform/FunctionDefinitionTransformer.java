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
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.functionmodel.FunctionModelFactory;
import org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.VariableKind;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;
import org.eclipselabs.damos.mscript.functionmodel.util.EquationCompoundHelper;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.functionmodel.util.InternalFunctionModelUtil;
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
	 * @see org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformer#transform(org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor, java.lang.String, java.util.List, java.util.List)
	 */
	public IFunctionDefinitionTransformerResult transform(IStaticEvaluationResult staticEvaluationResult, FunctionDescriptor functionDescriptor, List<IValue> staticArguments, List<DataType> inputParameterDataTypes) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Function definition transformation", null);

		FunctionInstance functionInstance = FunctionModelFactory.eINSTANCE.createFunctionInstance();
		functionInstance.setFunctionDeclaration(functionDescriptor.getDeclaration());
		
		Map<VariableDescriptor, VariableDeclaration> variableDeclarations = new HashMap<VariableDescriptor, VariableDeclaration>();
		
		initializeVariableDeclarations(staticEvaluationResult, functionInstance, functionDescriptor, staticArguments, inputParameterDataTypes, variableDeclarations);

		Collection<List<EquationDescriptor>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(functionDescriptor);
		
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
	
	private void initializeVariableDeclarations(IStaticEvaluationResult staticEvaluationResult, FunctionInstance functionInstance, FunctionDescriptor functionDescriptor, List<IValue> staticArguments, List<DataType> inputParameterDataTypes, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		Iterator<IValue> staticArgumentIterator = staticArguments.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDeclaration().getStaticParameterDeclarations()) {
			if (staticArgumentIterator.hasNext()) {
				IValue value = staticArgumentIterator.next();
				staticEvaluationResult.setValue(parameterDeclaration, value);
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				variableDeclarations.put(variableDescriptor, parameterDeclaration);
			}
		}

		Iterator<DataType> inputParameterDataTypesIterator = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDeclaration().getInputParameterDeclarations()) {
			if (inputParameterDataTypesIterator.hasNext()) {
				DataType dataType = EcoreUtil.copy(inputParameterDataTypesIterator.next());
				IValue value = new AnyValue(staticEvaluationResult.getComputationContext(), dataType);
				staticEvaluationResult.setValue(parameterDeclaration, value);
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				int circularBufferSize = getInoutputCircularBufferSize(variableDescriptor);
				staticEvaluationResult.setCircularBufferSize(parameterDeclaration, circularBufferSize);
				variableDeclarations.put(variableDescriptor, parameterDeclaration);
			}
		}
		
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDeclaration().getOutputParameterDeclarations()) {
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				int circularBufferSize = getInoutputCircularBufferSize(variableDescriptor);
				staticEvaluationResult.setCircularBufferSize(parameterDeclaration, circularBufferSize);
				IValue value = staticEvaluationResult.getValue(parameterDeclaration);
				if (value != null) {
					staticEvaluationResult.setValue(parameterDeclaration, value);
				}
				variableDeclarations.put(variableDescriptor, parameterDeclaration);
			}
		}

		for (StateVariableDeclaration stateVariableDeclaration : functionDescriptor.getDeclaration().getStateVariableDeclarations()) {
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(stateVariableDeclaration.getName());
			if (variableDescriptor != null) {
				int circularBufferSize = variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1;
				staticEvaluationResult.setCircularBufferSize(stateVariableDeclaration, circularBufferSize);
				IValue value = staticEvaluationResult.getValue(stateVariableDeclaration);
				if (value != null) {
					staticEvaluationResult.setValue(stateVariableDeclaration, value);
				}
				variableDeclarations.put(variableDescriptor, stateVariableDeclaration);
			}
		}
	}
	
	private int getInoutputCircularBufferSize(VariableDescriptor variableDescriptor) {
		int minimumStepIndex = variableDescriptor.getMinimumStep().getIndex();
		if (minimumStepIndex > 0) {
			minimumStepIndex = 0;
		}
		int maximumStepIndex = variableDescriptor.getMaximumStep().getIndex();
		if (maximumStepIndex < 0) {
			maximumStepIndex = 0;
		}
		return maximumStepIndex - minimumStepIndex + 1;
	}
	
	private IStatus constructInitializationCompound(IFunctionDefinitionTransformerContext context, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Initialization compound construction", null);
		
		Compound compound = MscriptFactory.eINSTANCE.createCompound();
		for (Iterator<List<EquationDescriptor>> it = equationCompounds.iterator(); it.hasNext();) {
			List<EquationDescriptor> equationDescriptors = it.next();
			boolean processed = false;
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = InternalFunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					context.enterScope();
					context.setCompound(compound);

					IExpressionTransformer transformer = new ExpressionTransformer(context);
					VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target)));
					
					context.leaveScope();

					processed = true;
				}
			}
			if (processed) {
				it.remove();
			}
		}
		context.getFunctionInstance().setInitializationCompound(compound);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	private IStatus constructComputationCompounds(IFunctionDefinitionTransformerContext context, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Computation compound construction", null);

		for (List<EquationDescriptor> equationDescriptors : equationCompounds) {
			ComputationCompound compound = FunctionModelFactory.eINSTANCE.createComputationCompound();
			Set<InputParameterDeclaration> inputs = new HashSet<InputParameterDeclaration>();
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = InternalFunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null) {
					context.enterScope();
					context.setCompound(compound);
					
					IExpressionTransformer transformer = new ExpressionTransformer(context);
					VariableExpressionTarget target = new VariableExpressionTarget(context, variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target)));

					context.leaveScope();

					for (EquationPart equationPart : equationDescriptor.getRightHandSide().getParts()) {
						VariableStep rhsVariableStep = equationPart.getVariableStep();
						if (rhsVariableStep.getDescriptor().getKind() == VariableKind.INPUT_PARAMETER
								&& rhsVariableStep.getIndex() == 0) {
							inputs.add((InputParameterDeclaration) variableDeclarations.get(rhsVariableStep.getDescriptor()));
						}
					}

					if (lhsVariableStep.getDescriptor().getKind() == VariableKind.OUTPUT_PARAMETER
							&& lhsVariableStep.getIndex() == 0) {
						compound.getOutputs().add((OutputParameterDeclaration) variableDeclarations.get(lhsVariableStep.getDescriptor()));
					}
					
					if (lhsVariableStep.isDerivative()) {
						compound.getDerivatives().add(variableDeclarations.get(lhsVariableStep.getDescriptor()));
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
