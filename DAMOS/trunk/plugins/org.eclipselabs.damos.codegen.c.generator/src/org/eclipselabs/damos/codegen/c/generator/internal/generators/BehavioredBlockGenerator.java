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

package org.eclipselabs.damos.codegen.c.generator.internal.generators;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.codegen.c.generator.AbstractBlockGenerator;
import org.eclipselabs.damos.codegen.c.generator.CodegenCGeneratorPlugin;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.core.util.BehavioredBlockHelper;
import org.eclipselabs.mscript.codegen.c.CompoundGenerator;
import org.eclipselabs.mscript.codegen.c.ICompoundGenerator;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.codegen.c.util.NameNormalizer;
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.Values;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;
import org.eclipselabs.mscript.language.il.InstanceVariableDeclaration;
import org.eclipselabs.mscript.language.il.OutputVariableDeclaration;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;
import org.eclipselabs.mscript.language.il.transform.ArrayOperationDecomposer;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IArrayOperationDecomposer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class BehavioredBlockGenerator extends AbstractBlockGenerator {

	private final ICompoundGenerator compoundGenerator = new CompoundGenerator();

	private ILFunctionDefinition ilFunctionDefinition;
	
	private IStaticEvaluationContext staticEvaluationContext;
	
	private IVariableAccessStrategy cachedVariableAccessStrategy;
	
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		MultiStatus status = new MultiStatus(CodegenCGeneratorPlugin.PLUGIN_ID, 0, "Generator initialization", null);

		Block block = getComponent();

		Helper helper = new Helper(block);
		
		FunctionDefinition functionDefinition = helper.createFunctionDefinition();
		
		List<IValue> templateArguments = helper.getTemplateArguments(functionDefinition, status);
		List<DataType> inputParameterDataTypes = helper.getInputParameterDataTypes(functionDefinition, getComponentSignature(), status);

		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
		
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, "Missing input data types"));
		}
		
		staticEvaluationContext = helper.createStaticEvaluationContext(functionDefinition, templateArguments, inputParameterDataTypes);
		FunctionDescriptor functionDescriptor = staticEvaluationContext.getFunctionDescriptor(functionDefinition);

		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer()
				.transform(staticEvaluationContext, functionDescriptor, null, templateArguments, inputParameterDataTypes);

		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			status.add(functionDefinitionTransformerResult.getStatus());
			throw new CoreException(status);
		}
		
		ilFunctionDefinition = functionDefinitionTransformerResult.getILFunctionDefinition();
		
		new NameNormalizer().normalize(ilFunctionDefinition);

		IArrayOperationDecomposer arrayOperationDecomposer = new ArrayOperationDecomposer();
		arrayOperationDecomposer.decompose(staticEvaluationContext, ilFunctionDefinition.getInitializationCompound());
		for (Compound compound : ilFunctionDefinition.getComputationCompounds()) {
			arrayOperationDecomposer.decompose(staticEvaluationContext, compound);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#contributesContextCode()
	 */
	@Override
	public boolean contributesContextStructCode() {
		return ilFunctionDefinition.isStateful();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateContextCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeContextStructCode(Writer writer, String typeName, IProgressMonitor monitor) {
		PrintWriter printWriter = new PrintWriter(writer);
		printWriter.println("typedef struct {");
		for (InputVariableDeclaration inputVariableDeclaration: ilFunctionDefinition.getInputVariableDeclarations()) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(printWriter, monitor, inputVariableDeclaration);
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration: ilFunctionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(printWriter, monitor, outputVariableDeclaration);
			}
		}
		for (InstanceVariableDeclaration instanceVariableDeclaration: ilFunctionDefinition.getInstanceVariableDeclarations()) {
			writeContextStructureMember(printWriter, monitor, instanceVariableDeclaration);
		}
		String prefix = getGenModel().getGenTopLevelSystem().getPrefix();
		if (prefix == null) {
			prefix = "";
		}
		printWriter.printf("} %s;\n\n", typeName);
	}

	private void writeContextStructureMember(PrintWriter writer, IProgressMonitor monitor, StatefulVariableDeclaration variableDeclaration) {
		String name = variableDeclaration.getName();
		DataType dataType = variableDeclaration.getDataType();
		if (variableDeclaration.getCircularBufferSize() > 1) {
			int bufferSize = variableDeclaration.getCircularBufferSize();
			writer.printf("%s[%d];\n",
					MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(), dataType, name, false),
					bufferSize);
			writer.printf("%s %s_index;\n", MscriptGeneratorUtil.getIndexCDataType(getComputationModel(), 2 * bufferSize), name);
		} else {
			writer.printf("%s;\n",
					MscriptGeneratorUtil.getCVariableDeclaration(getComputationModel(), dataType, name, false));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesInitializationCode()
	 */
	@Override
	public boolean contributesInitializationCode() {
		return ilFunctionDefinition.isStateful();
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateInitializationCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeInitializationCode(Writer writer, IProgressMonitor monitor) {
		PrintWriter printWriter = new PrintWriter(writer);
		writeInitializeIndexStatements(printWriter, ilFunctionDefinition.getInputVariableDeclarations());
		writeInitializeIndexStatements(printWriter, ilFunctionDefinition.getOutputVariableDeclarations());
		writeInitializeIndexStatements(printWriter, ilFunctionDefinition.getInstanceVariableDeclarations());

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(writer, getComputationModel(), staticEvaluationContext, getVariableAccessStrategy());
		compoundGenerator.generate(mscriptGeneratorContext, ilFunctionDefinition.getInitializationCompound());
	}
	
	private void writeInitializeIndexStatements(PrintWriter writer, List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
				writer.printf("%s.%s_index = 0;\n", contextVariable, statefulVariableDeclaration.getName());
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesComputeOutputsCode()
	 */
	@Override
	public boolean contributesComputeOutputsCode() {
		for (ComputationCompound compound : ilFunctionDefinition.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateComputeOutputsCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeComputeOutputsCode(Writer writer, IProgressMonitor monitor) {
		PrintWriter printWriter = new PrintWriter(writer);
		writeInputVariables(printWriter);
		
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(writer, getComputationModel(), staticEvaluationContext, getVariableAccessStrategy());
		
		for (ComputationCompound compound : ilFunctionDefinition.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(mscriptGeneratorContext, compound);
			}
		}
		
		for (InputVariableDeclaration inputVariableDeclaration : ILUtil.getDirectFeedthroughInputs(ilFunctionDefinition)) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				writeUpdateInputContextStatement(printWriter, inputVariableDeclaration);
			}
		}

		String contextVariable = getVariableAccessor().getContextVariable(false);
		for (OutputVariableDeclaration outputVariableDeclaration : ilFunctionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				String name = outputVariableDeclaration.getName();
				printWriter.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.getOutputVariableAccessString(getComponent(), getComponentSignature(), getVariableAccessor(), outputVariableDeclaration));
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesUpdateCode()
	 */
	@Override
	public boolean contributesUpdateCode() {
		return ilFunctionDefinition.isStateful();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateUpdateCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void writeUpdateCode(Writer writer, IProgressMonitor monitor) {
		PrintWriter printWriter = new PrintWriter(writer);
		writeInputVariables(printWriter);

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(writer, getComputationModel(), staticEvaluationContext, getVariableAccessStrategy());
		for (ComputationCompound compound : ilFunctionDefinition.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(mscriptGeneratorContext, compound);
			}
		}
		
		List<InputVariableDeclaration> computeOutputsCodeInputs = ILUtil.getDirectFeedthroughInputs(ilFunctionDefinition);
		for (InputVariableDeclaration inputVariableDeclaration : ilFunctionDefinition.getInputVariableDeclarations()) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1 && !computeOutputsCodeInputs.contains(inputVariableDeclaration)) {
				writeUpdateInputContextStatement(printWriter, inputVariableDeclaration);
			}
		}
		
		writeUpdateIndexStatements(printWriter, ilFunctionDefinition.getInputVariableDeclarations());
		writeUpdateIndexStatements(printWriter, ilFunctionDefinition.getOutputVariableDeclarations());
		writeUpdateIndexStatements(printWriter, ilFunctionDefinition.getInstanceVariableDeclarations());
	}
	
	private void writeUpdateIndexStatements(PrintWriter writer, List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
				String name = statefulVariableDeclaration.getName();
				writer.printf("%s.%s_index = (%s.%s_index + 1) %% %d;\n", contextVariable, name, contextVariable, name, statefulVariableDeclaration.getCircularBufferSize());
			}
		}
	}
	
	private void writeInputVariables(PrintWriter writer) {
		Iterator<Input> inputIterator = getComponent().getInputs().iterator();
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(writer, getComputationModel(), staticEvaluationContext, getVariableAccessStrategy());
		for (InputVariableDeclaration inputVariableDeclaration : ilFunctionDefinition.getInputVariableDeclarations()) {
			BlockInput blockInput = (BlockInput) inputIterator.next();
			if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
				ArrayType arrayType = (ArrayType) inputVariableDeclaration.getDataType();
				writer.printf("%s %s_%s[%d] = { ", MscriptGeneratorUtil.getCDataType(getComputationModel(), arrayType.getElementType()), InternalGeneratorUtil.uncapitalize(getComponent().getName()), blockInput.getDefinition().getName(), blockInput.getPorts().size());
				boolean first = true;
				for (InputPort inputPort : blockInput.getPorts()) {
					if (first) {
						first = false;
					} else {
						writer.print(", ");
					}
					MscriptGeneratorUtil.cast(mscriptGeneratorContext, getVariableAccessor().getInputVariable(inputPort, false), getComponentSignature().getInputDataType(inputPort), arrayType.getElementType());
				}
				writer.println(" };");
			} else {
				InputPort inputPort = blockInput.getPorts().get(0);
				DataType inputDataType = getComponentSignature().getInputDataType(inputPort);
				DataType targetDataType = inputVariableDeclaration.getDataType();
				if (!inputDataType.isEquivalentTo(targetDataType)) {
					writer.printf("%s %s_%s = ", MscriptGeneratorUtil.getCDataType(getComputationModel(), targetDataType), InternalGeneratorUtil.uncapitalize(getComponent().getName()), blockInput.getDefinition().getName());
					MscriptGeneratorUtil.cast(mscriptGeneratorContext, getVariableAccessor().getInputVariable(inputPort, false), inputDataType, targetDataType);
					writer.println(";");
				}
			}
		}
	}

	private void writeUpdateInputContextStatement(PrintWriter writer, InputVariableDeclaration inputVariableDeclaration) {
		String contextVariable = getVariableAccessor().getContextVariable(false);
		String name = inputVariableDeclaration.getName();
		writer.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.getInputVariableAccessString(getComponent(), getComponentSignature(), getVariableAccessor(), inputVariableDeclaration));
	}
	
	/**
	 * @return
	 */
	private IVariableAccessStrategy getVariableAccessStrategy() {
		if (cachedVariableAccessStrategy == null) {
			cachedVariableAccessStrategy = new VariableAccessStrategy(getComponent(), getComponentSignature(), getVariableAccessor());
		}
		return cachedVariableAccessStrategy;
	}

	private class Helper extends BehavioredBlockHelper {
		
		/**
		 * @param block
		 */
		public Helper(Block block) {
			super(block);
		}

		@Override
		protected IValue getGlobalTemplateArgument(String name) throws CoreException {
			if (SAMPLE_TIME_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleTime = getNode().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
				return Values.valueOf(new ComputationContext(), realType, sampleTime);
			}
			if (SAMPLE_RATE_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleRate = 1 / getNode().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeSystemUtil.createUnit(UnitSymbol.SECOND);
				herzUnit.getNumerator().getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return Values.valueOf(new ComputationContext(), realType, sampleRate);
			}
			return super.getGlobalTemplateArgument(name);
		}
		
	}

}
