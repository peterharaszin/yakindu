/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.codegen.c.internal.componentgenerators;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipselabs.damos.codegen.c.AbstractBlockGenerator;
import org.eclipselabs.damos.codegen.c.CodegenCPlugin;
import org.eclipselabs.damos.codegen.c.MscriptGeneratorConfiguration;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.util.DscriptBlockHelper;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ComputeFunction;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.ContextStruct;
import org.eclipselabs.damos.mscript.codegen.c.codefragments.FunctionContext;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.function.ComputationCompound;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.function.transform.FunctionDefinitionTransformer;
import org.eclipselabs.damos.mscript.function.transform.IFunctionDefinitionTransformer;
import org.eclipselabs.damos.mscript.function.util.FunctionModelUtil;
import org.eclipselabs.damos.mscript.interpreter.FunctionCallPath;
import org.eclipselabs.damos.mscript.interpreter.FunctionSignature;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionInfo;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DscriptBlockGenerator extends AbstractBlockGenerator {

	private final DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();
	
	private final IFunctionDefinitionTransformer functionDefinitionTransformer = new FunctionDefinitionTransformer();

	private final IStatementGenerator statementGenerator;

	private StaticFunctionInfo topLevelFunctionInfo;
	private FunctionInstance functionInstance;
	
	private IStaticEvaluationResult staticEvaluationResult;
	
	private IVariableAccessStrategy cachedVariableAccessStrategy;
	
	@Inject
	public DscriptBlockGenerator(IStatementGenerator statementGenerator) {
		this.statementGenerator = statementGenerator;
	}
	
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
			getContext().getCodeFragmentCollector().addCodeFragment(
					new ComputeFunction(new MscriptGeneratorContext(new MscriptGeneratorConfiguration(
							getComputationModel(), getConfiguration()), functionInfo, getContext()
							.getCodeFragmentCollector())), new NullProgressMonitor());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesContextCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return isStateful();
	}

	@Override
	public CharSequence generateContextCode(CharSequence typeName, IProgressMonitor monitor) {
		ContextStruct contextStruct = getContext().getCodeFragmentCollector().addCodeFragment(new ContextStruct(true), new NullProgressMonitor());
		final ContextStruct newContextStruct = getContext().getCodeFragmentCollector().addCodeFragment(new ContextStruct(topLevelFunctionInfo, typeName.toString(), true), new NullProgressMonitor());
		contextStruct.addDependency(ICodeFragment.FORWARD_DECLARATION_DEPENDS_ON, new ICodeFragment.IDependencyRule() {
			
			public boolean applies(ICodeFragment other) {
				return other == newContextStruct;
			}
			
		});
		
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		FunctionContext functionContext = new FunctionContext(mscriptGeneratorContext);
		newContextStruct.addPart(functionContext);
		return "";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesInitializationCode()
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

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		sb.append(statementGenerator.generate(mscriptGeneratorContext, functionInstance.getInitializationCompound()));

		final ContextStruct newContextStruct = getContext().getCodeFragmentCollector().addCodeFragment(new ContextStruct(topLevelFunctionInfo, true), new NullProgressMonitor());
		for (CharSequence s : newContextStruct.getInitializeCalls()) {
			sb.append(s);
		}

		return sb;
	}
	
	private void writeInitializeIndexStatements(PrintAppendable out, List<? extends VariableDeclaration> variableDeclarations) {
		String contextVariable = getVariableAccessor().generateContextVariableReference(false);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (staticEvaluationResult.getCircularBufferSize(variableDeclaration) > 1) {
				out.printf("%s.%s_index = 0;\n", contextVariable, variableDeclaration.getName());
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesComputeOutputsCode()
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

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());

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

		String contextVariable = getVariableAccessor().generateContextVariableReference(false);
		for (OutputParameterDeclaration outputParameterDeclaration : functionInstance.getDeclaration().getOutputParameterDeclarations()) {
			if (staticEvaluationResult.getCircularBufferSize(outputParameterDeclaration) > 1) {
				String name = outputParameterDeclaration.getName();
				out.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.getOutputParameterAccessString(getComponent(), getComponentSignature(), getVariableAccessor(), (OutputParameterDeclaration) outputParameterDeclaration));
			}
		}
		return sb;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesUpdateCode()
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

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		
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
		
		final ContextStruct newContextStruct = getContext().getCodeFragmentCollector().addCodeFragment(new ContextStruct(topLevelFunctionInfo, true), new NullProgressMonitor());
		for (CharSequence s : newContextStruct.getUpdateCalls()) {
			sb.append(s);
		}
		
		return sb;
	}
	
	private void writeUpdateIndexStatements(PrintAppendable out, List<? extends VariableDeclaration> variableDeclarations) {
		String contextVariable = getVariableAccessor().generateContextVariableReference(false);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (staticEvaluationResult.getCircularBufferSize(variableDeclaration) > 1) {
				String name = variableDeclaration.getName();
				out.printf("%s.%s_index = (%s.%s_index + 1) %% %d;\n", contextVariable, name, contextVariable, name, staticEvaluationResult.getCircularBufferSize(variableDeclaration));
			}
		}
	}
	
	private CharSequence writeInputVariables() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		Iterator<Input> inputIterator = getComponent().getInputs().iterator();
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(new MscriptGeneratorConfiguration(getComputationModel(), getConfiguration()), staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY), getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		
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
				out.print(dataTypeGenerator.generateDataType(mscriptGeneratorContext.getConfiguration(), variableName, getContext().getCodeFragmentCollector(), arrayType, null));
				out.print(" = { ");
				boolean first = true;
				for (InputPort inputPort : blockInput.getPorts()) {
					if (first) {
						first = false;
					} else {
						out.print(", ");
					}
					sb.append(MscriptGeneratorUtil.cast(mscriptGeneratorContext.getConfiguration().getComputationModel(), getVariableAccessor().generateInputVariableReference(inputPort, false), getComponentSignature().getInputDataType(inputPort), arrayType.getElementType()));
				}
				out.println(" };");
			} else {
				InputPort inputPort = blockInput.getPorts().get(0);
				Type inputDataType = getComponentSignature().getInputDataType(inputPort);
				Type targetDataType = staticEvaluationResult.getValue(inputVariableDeclaration).getDataType();
				if (!inputDataType.isEquivalentTo(targetDataType)) {
					String variableName = StringExtensions.toFirstLower(getComponent().getName()) + "_" + blockInput.getDefinition().getName();
					out.print(dataTypeGenerator.generateDataType(mscriptGeneratorContext.getConfiguration(), variableName, getContext().getCodeFragmentCollector(), targetDataType, null));
					out.print(" = ");
					sb.append(MscriptGeneratorUtil.cast(mscriptGeneratorContext.getConfiguration().getComputationModel(), getVariableAccessor().generateInputVariableReference(inputPort, false), inputDataType, targetDataType));
					out.println(";");
				}
			}
		}
		return sb;
	}

	private void writeUpdateInputContextStatement(PrintAppendable out, InputParameterDeclaration inputParameterDeclaration) {
		String contextVariable = getVariableAccessor().generateContextVariableReference(false);
		String name = inputParameterDeclaration.getName();
		out.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.getInputParameterAccessString(staticEvaluationResult, getComponent(), getComponentSignature(), getVariableAccessor(), inputParameterDeclaration));
	}
	
	/**
	 * @return
	 */
	private IVariableAccessStrategy getVariableAccessStrategy() {
		if (cachedVariableAccessStrategy == null) {
			cachedVariableAccessStrategy = new VariableAccessStrategy(getContext(), getComputationModel(), staticEvaluationResult);
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
