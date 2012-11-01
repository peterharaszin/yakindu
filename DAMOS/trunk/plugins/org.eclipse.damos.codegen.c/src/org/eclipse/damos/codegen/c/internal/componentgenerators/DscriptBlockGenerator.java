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

package org.eclipse.damos.codegen.c.internal.componentgenerators;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.codegen.c.AbstractBlockGenerator;
import org.eclipse.damos.codegen.c.CodegenCPlugin;
import org.eclipse.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipse.damos.codegen.c.util.GeneratorConfigurationExtensions;
import org.eclipse.damos.common.util.PrintAppendable;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.execution.util.DscriptBlockHelper;
import org.eclipse.damos.mscript.ArrayType;
import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipse.damos.mscript.codegen.c.IDefaultVariableAccessStrategyFactory;
import org.eclipse.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.IStatementGenerator;
import org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipse.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipse.damos.mscript.codegen.c.VariableDeclarationGenerator;
import org.eclipse.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipse.damos.mscript.codegen.c.codefragments.DeclaredContextStructMember;
import org.eclipse.damos.mscript.codegen.c.codefragments.IContextStructMember;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IComputeFunctionFactory;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IContextStructFactory;
import org.eclipse.damos.mscript.codegen.c.codefragments.factories.IFunctionContextFactory;
import org.eclipse.damos.mscript.codegen.c.util.CastHelper;
import org.eclipse.damos.mscript.function.ComputationCompound;
import org.eclipse.damos.mscript.function.FunctionInstance;
import org.eclipse.damos.mscript.function.transform.FunctionDefinitionTransformer;
import org.eclipse.damos.mscript.function.transform.IFunctionDefinitionTransformer;
import org.eclipse.damos.mscript.function.util.FunctionModelUtil;
import org.eclipse.damos.mscript.interpreter.FunctionCallPath;
import org.eclipse.damos.mscript.interpreter.FunctionSignature;
import org.eclipse.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipse.damos.mscript.interpreter.StaticFunctionInfo;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DscriptBlockGenerator extends AbstractBlockGenerator {

	@Inject
	private CastHelper castHelper;
	
	@Inject
	private IComputeFunctionFactory computeFunctionFactory;

	@Inject
	private DataTypeGenerator dataTypeGenerator;
	
	@Inject
	private IStatementGenerator statementGenerator;
	
	@Inject
	private IFunctionContextFactory functionContextFactory;
	
	@Inject
	private IVariableAccessStrategyFactory variableAccessStrategyFactory;

	@Inject
	private IDefaultVariableAccessStrategyFactory defaultVariableAccessStrategyFactory;
	
	@Inject
	private IContextStructFactory contextStructFactory;
	
	@Inject
	private VariableDeclarationGenerator variableDeclarationGenerator;

	private final IFunctionDefinitionTransformer functionDefinitionTransformer = new FunctionDefinitionTransformer();

	private StaticFunctionInfo topLevelFunctionInfo;
	private FunctionInstance functionInstance;
	
	private IStaticEvaluationResult staticEvaluationResult;
	
	private IVariableAccessStrategy cachedVariableAccessStrategy;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		MultiStatus status = new MultiStatus(CodegenCPlugin.PLUGIN_ID, 0, "Generator initialization", null);

		Block block = getComponent();

		DscriptBlockHelper helper = new DscriptBlockHelper(block);
		
		FunctionDeclaration functionDeclaration = helper.getBehavior();
		
		FunctionSignature functionSignature = helper.getFunctionSignature(functionDeclaration, getComponentSignature(), status);

		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		if (functionSignature == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Missing input data types"));
		}
		
		staticEvaluationResult = new StaticEvaluationResult();
		helper.evaluateFunctionDeclaration(staticEvaluationResult, functionDeclaration, functionSignature);
		if (!staticEvaluationResult.getStatus().isOK()) {
			status.add(staticEvaluationResult.getStatus());
		}
		if (staticEvaluationResult.getStatus().getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}

		topLevelFunctionInfo = staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY);
		functionInstance = new FunctionDefinitionTransformer().transform(staticEvaluationResult, topLevelFunctionInfo);
		
		for (StaticFunctionInfo functionInfo : staticEvaluationResult.getFunctionInfos()) {
			if (functionInfo == topLevelFunctionInfo) {
				continue;
			}
			functionDefinitionTransformer.transform(staticEvaluationResult, functionInfo);
		}

		for (StaticFunctionInfo functionInfo : staticEvaluationResult.getFunctionInfos()) {
			if (functionInfo == topLevelFunctionInfo) {
				continue;
			}
			MscriptGeneratorConfiguration configuration = new MscriptGeneratorConfiguration(getComputationModel(),
					getConfiguration());
			IVariableAccessStrategy variableAccessStrategy = defaultVariableAccessStrategyFactory.create(configuration,
					functionInfo, getNode().getSampleInterval());
			MscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(configuration, functionInfo,
					getNode().getSampleInterval(), variableAccessStrategy, getContext().getCodeFragmentCollector());
			getContext().getCodeFragmentCollector().addCodeFragment(
					computeFunctionFactory.create(mscriptGeneratorContext), new NullProgressMonitor());
		}
	}
	
	@Override
	public void addContextStructMembers(ContextStruct contextStruct, IProgressMonitor monitor) {
		if (!isStateful()) {
			return;
		}
		
		String prefix = GeneratorConfigurationExtensions.getPrefix(getConfiguration());
		String typeName = prefix + getNode().getComponent().getName() + "_Context";
		ContextStruct contextStructDeclaration = getContext().getCodeFragmentCollector().addCodeFragment(
				(ContextStruct) contextStructFactory.create(topLevelFunctionInfo, typeName, true), new NullProgressMonitor());
		
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getNode().getSampleInterval(), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		IContextStructMember functionContext = functionContextFactory.create(mscriptGeneratorContext);
		contextStructDeclaration.addMember(functionContext);
		contextStruct.addMember(new DeclaredContextStructMember(prefix + getNode().getComponent().getName(), typeName, contextStructDeclaration));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return isStateful();
	}
		
	@Override
	public CharSequence generateInitializationCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		writeInitializeIndexStatements(out, functionInstance.getDeclaration().getNonConstantInputParameterDeclarations());
		writeInitializeIndexStatements(out, functionInstance.getDeclaration().getOutputParameterDeclarations());
		writeInitializeIndexStatements(out, functionInstance.getDeclaration().getStateVariableDeclarations());

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getNode().getSampleInterval(), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		sb.append(statementGenerator.generate(mscriptGeneratorContext, functionInstance.getInitializationCompound()));

		final ContextStruct newContextStruct = getContext().getCodeFragmentCollector().addCodeFragment((ContextStruct) contextStructFactory.create(topLevelFunctionInfo, null, true), new NullProgressMonitor());
		for (CharSequence s : newContextStruct.getInitializeCalls()) {
			sb.append(s);
		}

		return sb;
	}
	
	private void writeInitializeIndexStatements(PrintAppendable out, List<? extends VariableDeclaration> variableDeclarations) {
		CharSequence contextVariable = getVariableAccessor().generateContextVariableReference(false);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (staticEvaluationResult.getCircularBufferSize(variableDeclaration) > 1) {
				out.printf("%s.%s_index = 0;\n", contextVariable, variableDeclaration.getName());
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public CharSequence generateComputeOutputsCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.print(writeInputVariables());

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getNode().getSampleInterval(), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());

		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				sb.append(statementGenerator.generate(mscriptGeneratorContext, compound));
			}
		}
		
		for (InputParameterDeclaration inputParameterDeclaration : FunctionModelUtil.getDirectFeedthroughInputs(functionInstance)) {
			if (staticEvaluationResult.getCircularBufferSize(inputParameterDeclaration) > 1) {
				writeUpdateInputContextStatement(out, inputParameterDeclaration);
			}
		}

		CharSequence contextVariable = getVariableAccessor().generateContextVariableReference(false);
		for (OutputParameterDeclaration outputParameterDeclaration : functionInstance.getDeclaration().getOutputParameterDeclarations()) {
			if (staticEvaluationResult.getCircularBufferSize(outputParameterDeclaration) > 1) {
				String name = outputParameterDeclaration.getName();
				out.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.generateOutputParameterAccess(getComponent(), getComponentSignature(), getVariableAccessor(), (OutputParameterDeclaration) outputParameterDeclaration));
			}
		}
		return sb;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.codegen.c.IComponentGenerator#contributesUpdateCode()
	 */
	@Override
	public boolean contributesUpdateCode() {
		return isStateful();
	}
	
	@Override
	public CharSequence generateUpdateCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.print(writeInputVariables());

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getNode().getSampleInterval(), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				sb.append(statementGenerator.generate(mscriptGeneratorContext, compound));
			}
		}
		
		List<InputParameterDeclaration> computeOutputsCodeInputs = FunctionModelUtil.getDirectFeedthroughInputs(functionInstance);
		for (InputParameterDeclaration inputVariableDeclaration : functionInstance.getDeclaration().getNonConstantInputParameterDeclarations()) {
			if (staticEvaluationResult.getCircularBufferSize(inputVariableDeclaration) > 1 && !computeOutputsCodeInputs.contains(inputVariableDeclaration)) {
				writeUpdateInputContextStatement(out, inputVariableDeclaration);
			}
		}
		
		writeUpdateIndexStatements(out, functionInstance.getDeclaration().getNonConstantInputParameterDeclarations());
		writeUpdateIndexStatements(out, functionInstance.getDeclaration().getOutputParameterDeclarations());
		writeUpdateIndexStatements(out, functionInstance.getDeclaration().getStateVariableDeclarations());
		
		final ContextStruct newContextStruct = getContext().getCodeFragmentCollector().addCodeFragment((ContextStruct) contextStructFactory.create(topLevelFunctionInfo, null, true), new NullProgressMonitor());
		for (CharSequence s : newContextStruct.getUpdateCalls()) {
			sb.append(s);
		}
		
		return sb;
	}
	
	private void writeUpdateIndexStatements(PrintAppendable out, List<? extends VariableDeclaration> variableDeclarations) {
		CharSequence contextVariable = getVariableAccessor().generateContextVariableReference(false);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (staticEvaluationResult.getCircularBufferSize(variableDeclaration) > 1) {
				String name = variableDeclaration.getName();
				out.printf("%s.%s_index = (%s.%s_index + 1) %% %d;\n", contextVariable, name, contextVariable, name, staticEvaluationResult.getCircularBufferSize(variableDeclaration));
			}
		}
	}
	
	private CharSequence writeInputVariables() {
		StringBuilder sb = new StringBuilder();
		Iterator<Input> inputIterator = getComponent().getInputs().iterator();
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getNode().getSampleInterval(), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		
		boolean skip = !getComponent().getInputSockets().isEmpty();
		
		for (InputParameterDeclaration inputVariableDeclaration : functionInstance.getDeclaration().getNonConstantInputParameterDeclarations()) {
			if (skip) {
				skip = false;
				continue;
			}
			
			BlockInput blockInput = (BlockInput) inputIterator.next();
			if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
				ArrayType arrayType = (ArrayType) staticEvaluationResult.getValue(inputVariableDeclaration).getDataType();
				String variableName = StringExtensions.toFirstLower(getComponent().getName()) + "_" + blockInput.getDefinition().getName();
				sb.append(variableDeclarationGenerator.generateVariableDeclaration(mscriptGeneratorContext.getConfiguration(), getContext().getCodeFragmentCollector(), arrayType, variableName, false, null));
				sb.append(";\n");
				int index = 0;
				for (InputPort inputPort : blockInput.getPorts()) {
					sb.append(variableName);
					sb.append("[");
					sb.append(index);
					sb.append("] = ");
					sb.append(castHelper.cast(mscriptGeneratorContext.getConfiguration().getComputationModel(), getVariableAccessor().generateInputVariableReference(inputPort, false), getComponentSignature().getInputDataType(inputPort), arrayType.getElementType()));
					sb.append(";\n");
					++index;
				}
			} else {
				InputPort inputPort = blockInput.getPorts().get(0);
				Type inputDataType = getComponentSignature().getInputDataType(inputPort);
				Type targetDataType = staticEvaluationResult.getValue(inputVariableDeclaration).getDataType();
				if (!inputDataType.isEquivalentTo(targetDataType)) {
					String variableName = StringExtensions.toFirstLower(getComponent().getName()) + "_" + blockInput.getDefinition().getName();
					sb.append(dataTypeGenerator.generateDataType(mscriptGeneratorContext.getConfiguration(), variableName, getContext().getCodeFragmentCollector(), targetDataType, null));
					sb.append(" = ");
					sb.append(castHelper.cast(mscriptGeneratorContext.getConfiguration().getComputationModel(), getVariableAccessor().generateInputVariableReference(inputPort, false), inputDataType, targetDataType));
					sb.append(";\n");
				}
			}
		}
		return sb;
	}

	private void writeUpdateInputContextStatement(PrintAppendable out, InputParameterDeclaration inputParameterDeclaration) {
		CharSequence contextVariable = getVariableAccessor().generateContextVariableReference(false);
		String name = inputParameterDeclaration.getName();
		out.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.generateInputParameterAccess(staticEvaluationResult, getComponent(), getComponentSignature(), getVariableAccessor(), inputParameterDeclaration));
	}
	
	/**
	 * @return
	 */
	private IVariableAccessStrategy getVariableAccessStrategy() {
		if (cachedVariableAccessStrategy == null) {
			cachedVariableAccessStrategy = variableAccessStrategyFactory.create(getContext(), getComputationModel(), staticEvaluationResult);
		}
		return cachedVariableAccessStrategy;
	}

	/**
	 * @return
	 */
	private boolean isStateful() {
		for (StaticFunctionInfo functionInfo : staticEvaluationResult.getFunctionInfos()) {
			if (functionInfo.getFunctionDescription().isStateful()) {
				return true;
			}
		}
		return false;
	}

}
