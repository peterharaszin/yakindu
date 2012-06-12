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
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipselabs.damos.codegen.c.AbstractBlockGenerator;
import org.eclipselabs.damos.codegen.c.CodegenCPlugin;
import org.eclipselabs.damos.codegen.c.IComponentGeneratorContext;
import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.util.BehavioredBlockHelper;
import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.Unit;
import org.eclipselabs.damos.mscript.UnitSymbol;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.DataTypeGenerator;
import org.eclipselabs.damos.mscript.codegen.c.ICompoundStatementGenerator;
import org.eclipselabs.damos.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.damos.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.codegen.c.util.NameNormalizer;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.FunctionDescriptor;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.functionmodel.transform.ArrayOperationDecomposer;
import org.eclipselabs.damos.mscript.functionmodel.transform.FunctionDefinitionTransformer;
import org.eclipselabs.damos.mscript.functionmodel.transform.IArrayOperationDecomposer;
import org.eclipselabs.damos.mscript.functionmodel.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.damos.mscript.functionmodel.util.FunctionModelUtil;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.util.TypeUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockGenerator extends AbstractBlockGenerator {

	private final DataTypeGenerator dataTypeGenerator = new DataTypeGenerator();

	private final ICompoundStatementGenerator compoundStatementGenerator;

	private FunctionInstance functionInstance;
	
	private IStaticEvaluationContext staticEvaluationContext;
	
	private IVariableAccessStrategy cachedVariableAccessStrategy;
	
	@Inject
	public BehavioredBlockGenerator(ICompoundStatementGenerator compoundStatementGenerator) {
		this.compoundStatementGenerator = compoundStatementGenerator;
	}
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		MultiStatus status = new MultiStatus(CodegenCPlugin.PLUGIN_ID, 0, "Generator initialization", null);

		Block block = getComponent();

		staticEvaluationContext = new StaticEvaluationContext();
		Helper helper = new Helper(staticEvaluationContext, block);
		
		FunctionDeclaration functionDeclaration = helper.createFunctionDefinition();
		
		List<IValue> templateArguments = helper.getTemplateArguments(functionDeclaration, status);
		List<DataType> inputParameterDataTypes = helper.getInputParameterDataTypes(functionDeclaration, getComponentSignature(), status);

		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Missing input data types"));
		}
		
		helper.evaluateFunctionDefinition(functionDeclaration, templateArguments, inputParameterDataTypes);
		FunctionDescriptor functionDescriptor = staticEvaluationContext.getFunctionDescriptor(functionDeclaration);

		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer()
				.transform(staticEvaluationContext, functionDescriptor, templateArguments, inputParameterDataTypes);

		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			status.add(functionDefinitionTransformerResult.getStatus());
			throw new CoreException(status);
		}
		
		functionInstance = functionDefinitionTransformerResult.getFunctionInstance();
		
		new NameNormalizer().normalize(functionInstance);

		IArrayOperationDecomposer arrayOperationDecomposer = new ArrayOperationDecomposer();
		arrayOperationDecomposer.decompose(staticEvaluationContext, functionInstance.getInitializationCompound());
		for (Compound compound : functionInstance.getComputationCompounds()) {
			arrayOperationDecomposer.decompose(staticEvaluationContext, compound);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.AbstractComponentGenerator#contributesContextCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL;
	}
	
	@Override
	public CharSequence generateContextCode(CharSequence typeName, IProgressMonitor monitor) {
		return new BehavioredBlockContextCodeGenerator().generateContextCode(new BehavioredBlockGeneratorContext(), typeName, monitor);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.IComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL;
	}
		
	@Override
	public CharSequence generateInitializationCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		writeInitializeIndexStatements(out, functionInstance.getFunctionDeclaration().getInputParameterDeclarations());
		writeInitializeIndexStatements(out, functionInstance.getFunctionDeclaration().getOutputParameterDeclarations());
		writeInitializeIndexStatements(out, functionInstance.getFunctionDeclaration().getStateVariableDeclarations());

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), staticEvaluationContext, getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		sb.append(compoundStatementGenerator.generate(mscriptGeneratorContext, functionInstance.getInitializationCompound()));
		return sb;
	}
	
	private void writeInitializeIndexStatements(PrintAppendable out, List<? extends VariableDeclaration> variableDeclarations) {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (staticEvaluationContext.getCircularBufferSize(variableDeclaration) > 1) {
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

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), staticEvaluationContext, getVariableAccessStrategy(), getContext().getCodeFragmentCollector());

		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				sb.append(compoundStatementGenerator.generate(mscriptGeneratorContext, compound));
			}
		}
		
		for (InputParameterDeclaration inputParameterDeclaration : FunctionModelUtil.getDirectFeedthroughInputs(functionInstance)) {
			if (staticEvaluationContext.getCircularBufferSize(inputParameterDeclaration) > 1) {
				writeUpdateInputContextStatement(out, inputParameterDeclaration);
			}
		}

		String contextVariable = getVariableAccessor().getContextVariable(false);
		for (OutputParameterDeclaration outputParameterDeclaration : functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			if (staticEvaluationContext.getCircularBufferSize(outputParameterDeclaration) > 1) {
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
		return functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL;
	}
	
	@Override
	public CharSequence generateUpdateCode(IProgressMonitor monitor) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.print(writeInputVariables());

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), staticEvaluationContext, getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				sb.append(compoundStatementGenerator.generate(mscriptGeneratorContext, compound));
			}
		}
		
		List<InputParameterDeclaration> computeOutputsCodeInputs = FunctionModelUtil.getDirectFeedthroughInputs(functionInstance);
		for (InputParameterDeclaration inputVariableDeclaration : functionInstance.getFunctionDeclaration().getInputParameterDeclarations()) {
			if (staticEvaluationContext.getCircularBufferSize(inputVariableDeclaration) > 1 && !computeOutputsCodeInputs.contains(inputVariableDeclaration)) {
				writeUpdateInputContextStatement(out, inputVariableDeclaration);
			}
		}
		
		writeUpdateIndexStatements(out, functionInstance.getFunctionDeclaration().getInputParameterDeclarations());
		writeUpdateIndexStatements(out, functionInstance.getFunctionDeclaration().getOutputParameterDeclarations());
		writeUpdateIndexStatements(out, functionInstance.getFunctionDeclaration().getStateVariableDeclarations());
		
		return sb;
	}
	
	private void writeUpdateIndexStatements(PrintAppendable out, List<? extends VariableDeclaration> variableDeclarations) {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (staticEvaluationContext.getCircularBufferSize(variableDeclaration) > 1) {
				String name = variableDeclaration.getName();
				out.printf("%s.%s_index = (%s.%s_index + 1) %% %d;\n", contextVariable, name, contextVariable, name, staticEvaluationContext.getCircularBufferSize(variableDeclaration));
			}
		}
	}
	
	private CharSequence writeInputVariables() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		Iterator<Input> inputIterator = getComponent().getInputs().iterator();
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), staticEvaluationContext, getVariableAccessStrategy(), getContext().getCodeFragmentCollector());
		
		boolean skip = !getComponent().getInputSockets().isEmpty();
		
		for (InputParameterDeclaration inputVariableDeclaration : functionInstance.getFunctionDeclaration().getInputParameterDeclarations()) {
			if (skip) {
				skip = false;
				continue;
			}
			
			BlockInput blockInput = (BlockInput) inputIterator.next();
			if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
				ArrayType arrayType = (ArrayType) staticEvaluationContext.getValue(inputVariableDeclaration).getDataType();
				out.printf("%s %s_%s = { { ", dataTypeGenerator.generateDataType(getComputationModel(), getContext().getCodeFragmentCollector(), arrayType, null), StringExtensions.toFirstLower(getComponent().getName()), blockInput.getDefinition().getName(), blockInput.getPorts().size());
				boolean first = true;
				for (InputPort inputPort : blockInput.getPorts()) {
					if (first) {
						first = false;
					} else {
						out.print(", ");
					}
					sb.append(MscriptGeneratorUtil.cast(mscriptGeneratorContext.getComputationModel(), getVariableAccessor().getInputVariable(inputPort, false), getComponentSignature().getInputDataType(inputPort), arrayType.getElementType()));
				}
				out.println(" } };");
			} else {
				InputPort inputPort = blockInput.getPorts().get(0);
				DataType inputDataType = getComponentSignature().getInputDataType(inputPort);
				DataType targetDataType = staticEvaluationContext.getValue(inputVariableDeclaration).getDataType();
				if (!inputDataType.isEquivalentTo(targetDataType)) {
					out.printf("%s %s_%s = ", dataTypeGenerator.generateDataType(getComputationModel(), getContext().getCodeFragmentCollector(), targetDataType, null), StringExtensions.toFirstLower(getComponent().getName()), blockInput.getDefinition().getName());
					sb.append(MscriptGeneratorUtil.cast(mscriptGeneratorContext.getComputationModel(), getVariableAccessor().getInputVariable(inputPort, false), inputDataType, targetDataType));
					out.println(";");
				}
			}
		}
		return sb;
	}

	private void writeUpdateInputContextStatement(PrintAppendable out, InputParameterDeclaration inputParameterDeclaration) {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		String name = inputParameterDeclaration.getName();
		out.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.getInputParameterAccessString(staticEvaluationContext, getComponent(), getComponentSignature(), getVariableAccessor(), inputParameterDeclaration));
	}
	
	/**
	 * @return
	 */
	private IVariableAccessStrategy getVariableAccessStrategy() {
		if (cachedVariableAccessStrategy == null) {
			cachedVariableAccessStrategy = new VariableAccessStrategy(staticEvaluationContext, getComponent(), getComponentSignature(), getVariableAccessor());
		}
		return cachedVariableAccessStrategy;
	}

	private class Helper extends BehavioredBlockHelper {
		
		/**
		 * @param block
		 */
		public Helper(IStaticEvaluationContext staticEvaluationContext, Block block) {
			super(staticEvaluationContext, block);
		}

		@Override
		protected IValue getGlobalTemplateArgumentValue(String name) throws CoreException {
			if (SAMPLE_TIME_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleTime = getNode().getSampleTime();
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeUtil.createUnit(UnitSymbol.SECOND));
				return Values.valueOf(new ComputationContext(), realType, sampleTime);
			}
			if (SAMPLE_RATE_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleRate = 1 / getNode().getSampleTime();
				RealType realType = MscriptFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeUtil.createUnit(UnitSymbol.SECOND);
				herzUnit.getNumerator().getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return Values.valueOf(new ComputationContext(), realType, sampleRate);
			}
			return super.getGlobalTemplateArgumentValue(name);
		}
		
	}
	
	private class BehavioredBlockGeneratorContext implements IBehavioredBlockGeneratorContext {

		public IComponentGeneratorContext getComponentGeneratorContext() {
			return getContext();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.codegen.c.internal.generators.IBehavioredBlockGeneratorContext#getStaticEvaluationContext()
		 */
		public IStaticEvaluationContext getStaticEvaluationContext() {
			return staticEvaluationContext;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.codegen.c.internal.generators.IBehavioredBlockGeneratorContext#getComputationModel()
		 */
		public ComputationModel getComputationModel() {
			return BehavioredBlockGenerator.this.getComputationModel();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.codegen.c.internal.generators.IBehavioredBlockGeneratorContext#getFunctionInstance()
		 */
		public FunctionInstance getFunctionInstance() {
			return functionInstance;
		}
		
	}

}
