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

package org.eclipselabs.damos.mscript.il.transform;

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
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.EquationDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.EquationPart;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.VariableDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.VariableKind;
import org.eclipselabs.damos.mscript.functionmodel.VariableStep;
import org.eclipselabs.damos.mscript.il.Compound;
import org.eclipselabs.damos.mscript.il.ComputationCompound;
import org.eclipselabs.damos.mscript.il.ILFactory;
import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;
import org.eclipselabs.damos.mscript.il.InputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration;
import org.eclipselabs.damos.mscript.il.OutputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.TemplateVariableDeclaration;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.internal.functionmodel.util.FunctionModelUtil;
import org.eclipselabs.damos.mscript.internal.il.util.EquationCompoundHelper;
import org.eclipselabs.damos.mscript.internal.util.StatusUtil;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
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
	public IFunctionDefinitionTransformerResult transform(IStaticEvaluationContext staticEvaluationContext, FunctionDescriptor functionDescriptor, String functionName, List<IValue> templateArguments, List<DataType> inputParameterDataTypes) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Function definition transformation", null);

		ILFunctionDefinition ilFunctionDefinition = ILFactory.eINSTANCE.createILFunctionDefinition();
		ilFunctionDefinition.setStateful(functionDescriptor.getDefinition().getKind() == FunctionKind.STATEFUL);
		ilFunctionDefinition.setName(functionName != null ? functionName : functionDescriptor.getDefinition().getName());
		
		Map<VariableDescriptor, VariableDeclaration> variableDeclarations = new HashMap<VariableDescriptor, VariableDeclaration>();
		
		initializeVariableDeclarations(staticEvaluationContext, ilFunctionDefinition, functionDescriptor, templateArguments, inputParameterDataTypes, variableDeclarations);

		Collection<List<EquationDescriptor>> equationCompounds = new EquationCompoundHelper().getEquationCompounds(functionDescriptor);
		
		IFunctionDefinitionTransformerContext context = new FunctionDefinitionTransformerContext(staticEvaluationContext, ilFunctionDefinition);
		StatusUtil.merge(status, constructInitializationCompound(context, equationCompounds, variableDeclarations));
		StatusUtil.merge(status, constructComputationCompounds(context, equationCompounds, variableDeclarations));
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new FunctionDefinitionTransformerResult(ilFunctionDefinition, status);
		}
		
		if (status.getSeverity() > IStatus.WARNING) {
			return new FunctionDefinitionTransformerResult(ilFunctionDefinition, status);
		}

		return new FunctionDefinitionTransformerResult(ilFunctionDefinition);
	}
	
	private void initializeVariableDeclarations(IStaticEvaluationContext staticEvaluationContext, ILFunctionDefinition ilFunctionDefinition, FunctionDescriptor functionDescriptor, List<IValue> templateArguments, List<DataType> inputParameterDataTypes, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		Iterator<IValue> templateArgumentIterator = templateArguments.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getTemplateParameterDeclarations()) {
			TemplateVariableDeclaration templateVariableDeclaration = ILFactory.eINSTANCE.createTemplateVariableDeclaration();
			templateVariableDeclaration.setName(parameterDeclaration.getName());
			if (templateArgumentIterator.hasNext()) {
				IValue value = templateArgumentIterator.next();
				staticEvaluationContext.setValue(templateVariableDeclaration, value);
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				variableDeclarations.put(variableDescriptor, templateVariableDeclaration);
			}
			ilFunctionDefinition.getTemplateVariableDeclarations().add(templateVariableDeclaration);
		}

		Iterator<DataType> inputParameterDataTypesIterator = inputParameterDataTypes.iterator();
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getInputParameterDeclarations()) {
			InputVariableDeclaration inputVariableDeclaration = ILFactory.eINSTANCE.createInputVariableDeclaration();
			inputVariableDeclaration.setName(parameterDeclaration.getName());
			if (inputParameterDataTypesIterator.hasNext()) {
				DataType dataType = EcoreUtil.copy(inputParameterDataTypesIterator.next());
				IValue value = new AnyValue(staticEvaluationContext.getComputationContext(), dataType);
				staticEvaluationContext.setValue(inputVariableDeclaration, value);
			}
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				inputVariableDeclaration.setCircularBufferSize(getInoutputCircularBufferSize(variableDescriptor));
				variableDeclarations.put(variableDescriptor, inputVariableDeclaration);
			}
			ilFunctionDefinition.getInputVariableDeclarations().add(inputVariableDeclaration);
		}
		
		for (ParameterDeclaration parameterDeclaration : functionDescriptor.getDefinition().getOutputParameterDeclarations()) {
			OutputVariableDeclaration outputVariableDeclaration = ILFactory.eINSTANCE.createOutputVariableDeclaration();
			outputVariableDeclaration.setName(parameterDeclaration.getName());
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(parameterDeclaration.getName());
			if (variableDescriptor != null) {
				outputVariableDeclaration.setCircularBufferSize(getInoutputCircularBufferSize(variableDescriptor));
				IValue value = staticEvaluationContext.getValue(parameterDeclaration);
				if (value != null) {
					staticEvaluationContext.setValue(outputVariableDeclaration, value);
				}
				variableDeclarations.put(variableDescriptor, outputVariableDeclaration);
			}
			ilFunctionDefinition.getOutputVariableDeclarations().add(outputVariableDeclaration);
		}

		for (StateVariableDeclaration stateVariableDeclaration : functionDescriptor.getDefinition().getStateVariableDeclarations()) {
			InstanceVariableDeclaration instanceVariableDeclaration = ILFactory.eINSTANCE.createInstanceVariableDeclaration();
			instanceVariableDeclaration.setName(stateVariableDeclaration.getName());
			VariableDescriptor variableDescriptor = functionDescriptor.getVariableDescriptor(stateVariableDeclaration.getName());
			if (variableDescriptor != null) {
				instanceVariableDeclaration.setCircularBufferSize(variableDescriptor.getMaximumStep().getIndex() - variableDescriptor.getMinimumStep().getIndex() + 1);
				IValue value = staticEvaluationContext.getValue(stateVariableDeclaration);
				if (value != null) {
					staticEvaluationContext.setValue(instanceVariableDeclaration, value);
				}
				variableDeclarations.put(variableDescriptor, instanceVariableDeclaration);
			}
			ilFunctionDefinition.getInstanceVariableDeclarations().add(instanceVariableDeclaration);
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
		
		Compound compound = ILFactory.eINSTANCE.createCompound();
		for (Iterator<List<EquationDescriptor>> it = equationCompounds.iterator(); it.hasNext();) {
			List<EquationDescriptor> equationDescriptors = it.next();
			boolean processed = false;
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null && lhsVariableStep.isInitial()) {
					context.enterScope();
					context.setCompound(compound);

					IExpressionTransformer transformer = new ExpressionTransformer(context);
					ExpressionTarget target = new ExpressionTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target)));
					
					context.leaveScope();

					processed = true;
				}
			}
			if (processed) {
				it.remove();
			}
		}
		context.getFunctionDefinition().setInitializationCompound(compound);
		
		return status.isOK() ? Status.OK_STATUS : status;
	}
	
	private IStatus constructComputationCompounds(IFunctionDefinitionTransformerContext context, Collection<List<EquationDescriptor>> equationCompounds, Map<VariableDescriptor, VariableDeclaration> variableDeclarations) {
		MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Computation compound construction", null);

		for (List<EquationDescriptor> equationDescriptors : equationCompounds) {
			ComputationCompound compound = ILFactory.eINSTANCE.createComputationCompound();
			Set<InputVariableDeclaration> inputs = new HashSet<InputVariableDeclaration>();
			for (EquationDescriptor equationDescriptor : equationDescriptors) {
				VariableStep lhsVariableStep = FunctionModelUtil.getFirstLeftHandSideVariableStep(equationDescriptor);
				if (lhsVariableStep != null) {
					context.enterScope();
					context.setCompound(compound);
					
					IExpressionTransformer transformer = new ExpressionTransformer(context);
					ExpressionTarget target = new ExpressionTarget(variableDeclarations.get(lhsVariableStep.getDescriptor()), lhsVariableStep.getIndex());
					StatusUtil.merge(status, transformer.transform(equationDescriptor.getRightHandSide().getExpression(), Collections.singletonList(target)));

					context.leaveScope();

					for (EquationPart equationPart : equationDescriptor.getRightHandSide().getParts()) {
						VariableStep rhsVariableStep = equationPart.getVariableStep();
						if (rhsVariableStep.getDescriptor().getKind() == VariableKind.INPUT_PARAMETER
								&& rhsVariableStep.getIndex() == 0) {
							inputs.add((InputVariableDeclaration) variableDeclarations.get(rhsVariableStep.getDescriptor()));
						}
					}

					if (lhsVariableStep.getDescriptor().getKind() == VariableKind.OUTPUT_PARAMETER
							&& lhsVariableStep.getIndex() == 0) {
						compound.getOutputs().add((OutputVariableDeclaration) variableDeclarations.get(lhsVariableStep.getDescriptor()));
					}
				}
			}
			for (InputVariableDeclaration input : inputs) {
				compound.getInputs().add(input);
			}
			context.getFunctionDefinition().getComputationCompounds().add(compound);
		}

		return status.isOK() ? Status.OK_STATUS : status;
	}
	
}
