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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.codegen.c.generator.AbstractBlockGenerator;
import org.eclipselabs.damos.codegen.c.generator.CodegenCGeneratorPlugin;
import org.eclipselabs.damos.codegen.c.generator.IVariableAccessor;
import org.eclipselabs.damos.codegen.c.generator.internal.util.InternalGeneratorUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.execution.engine.util.BehavioredBlockHelper;
import org.eclipselabs.mscript.codegen.c.CompoundGenerator;
import org.eclipselabs.mscript.codegen.c.ICompoundGenerator;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.MscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.codegen.c.util.NameNormalizer;
import org.eclipselabs.mscript.computation.engine.ComputationContext;
import org.eclipselabs.mscript.computation.engine.value.IValue;
import org.eclipselabs.mscript.computation.engine.value.ValueConstructor;
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

	private ILFunctionDefinition functionDefinition;
	
	@Override
	public void initialize() throws CoreException {
		MultiStatus status = new MultiStatus(CodegenCGeneratorPlugin.PLUGIN_ID, 0, "Generator initialization failed", null);

		Block block = getComponent();

		Helper helper = new Helper(block);
		
		FunctionDescriptor functionDescriptor = helper.constructFunctionDescriptor();
		
		List<IValue> templateArguments = helper.getTemplateArguments(functionDescriptor.getDefinition(), status);
		List<DataType> inputParameterDataTypes = helper.getInputParameterDataTypes(functionDescriptor.getDefinition(), getSignature(), status);

		if (!status.isOK()) {
			throw new CoreException(status);
		}
		
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCGeneratorPlugin.PLUGIN_ID, "Missing input data types"));
		}
		
		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer()
				.transform(functionDescriptor, null, templateArguments, inputParameterDataTypes);

		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			status.add(functionDefinitionTransformerResult.getStatus());
			throw new CoreException(status);
		}
		
		functionDefinition = functionDefinitionTransformerResult.getILFunctionDefinition();
		
		new NameNormalizer().normalize(functionDefinition);

		IArrayOperationDecomposer arrayOperationDecomposer = new ArrayOperationDecomposer();
		arrayOperationDecomposer.decompose(functionDefinition.getInitializationCompound());
		for (Compound compound : functionDefinition.getComputationCompounds()) {
			arrayOperationDecomposer.decompose(compound);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#contributesContextCode()
	 */
	@Override
	public boolean contributesContextCode() {
		return functionDefinition.isStateful();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateContextCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void generateContextCode(Writer writer, String typeName, IProgressMonitor monitor) throws CoreException {
		PrintWriter printWriter = new PrintWriter(writer);
		printWriter.println("typedef struct {");
		for (InputVariableDeclaration inputVariableDeclaration: functionDefinition.getInputVariableDeclarations()) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(printWriter, monitor, inputVariableDeclaration);
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				writeContextStructureMember(printWriter, monitor, outputVariableDeclaration);
			}
		}
		for (InstanceVariableDeclaration instanceVariableDeclaration: functionDefinition.getInstanceVariableDeclarations()) {
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
		DataType dataType = variableDeclaration.getType();
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
		return functionDefinition.isStateful();
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateInitializationCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void generateInitializationCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
		PrintWriter printWriter = new PrintWriter(writer);
		generateInitializeIndexStatements(printWriter, variableAccessor, functionDefinition.getInputVariableDeclarations());
		generateInitializeIndexStatements(printWriter, variableAccessor, functionDefinition.getOutputVariableDeclarations());
		generateInitializeIndexStatements(printWriter, variableAccessor, functionDefinition.getInstanceVariableDeclarations());

		IVariableAccessStrategy variableAccessStrategy = new VariableAccessStrategy(getComponent(), getSignature(), variableAccessor);
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), writer);
		compoundGenerator.generate(mscriptGeneratorContext, variableAccessStrategy, functionDefinition.getInitializationCompound());
	}
	
	private void generateInitializeIndexStatements(PrintWriter writer, IVariableAccessor variableAccessor, List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		String contextVariable = variableAccessor.getContextVariable(false);
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
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
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
	public void generateComputeOutputsCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
		PrintWriter printWriter = new PrintWriter(writer);
		IVariableAccessStrategy variableAccessStrategy = new VariableAccessStrategy(getComponent(), getSignature(), variableAccessor);
		
		generateInputVariables(printWriter, variableAccessor);
		
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), writer);
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(mscriptGeneratorContext, variableAccessStrategy, compound);
			}
		}
		String contextVariable = variableAccessor.getContextVariable(false);
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			if (inputVariableDeclaration.getCircularBufferSize() > 1) {
				String name = inputVariableDeclaration.getName();
				printWriter.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.getInputVariableAccessString(getComponent(), getSignature(), variableAccessor, inputVariableDeclaration));
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
			if (outputVariableDeclaration.getCircularBufferSize() > 1) {
				String name = outputVariableDeclaration.getName();
				printWriter.printf("%s.%s[%s.%s_index] = %s;\n", contextVariable, name, contextVariable, name, VariableAccessStrategy.getOutputVariableAccessString(getComponent(), getSignature(), variableAccessor, outputVariableDeclaration));
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.IComponentGenerator#contributesUpdateCode()
	 */
	@Override
	public boolean contributesUpdateCode() {
		return functionDefinition.isStateful();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.generator.AbstractComponentGenerator#generateUpdateCode(java.io.Writer, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void generateUpdateCode(Writer writer, IVariableAccessor variableAccessor, IProgressMonitor monitor) throws CoreException {
		PrintWriter printWriter = new PrintWriter(writer);
		IVariableAccessStrategy variableAccessStrategy = new VariableAccessStrategy(getComponent(), getSignature(), variableAccessor);
		
		generateInputVariables(printWriter, variableAccessor);

		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), writer);
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(mscriptGeneratorContext, variableAccessStrategy, compound);
			}
		}
		generateUpdateIndexStatements(printWriter, variableAccessor, functionDefinition.getInputVariableDeclarations());
		generateUpdateIndexStatements(printWriter, variableAccessor, functionDefinition.getOutputVariableDeclarations());
		generateUpdateIndexStatements(printWriter, variableAccessor, functionDefinition.getInstanceVariableDeclarations());
	}
	
	private void generateUpdateIndexStatements(PrintWriter writer, IVariableAccessor variableAccessor, List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		String contextVariable = variableAccessor.getContextVariable(false);
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (statefulVariableDeclaration.getCircularBufferSize() > 1) {
				String name = statefulVariableDeclaration.getName();
				writer.printf("%s.%s_index = (%s.%s_index + 1) %% %d;\n", contextVariable, name, contextVariable, name, statefulVariableDeclaration.getCircularBufferSize());
			}
		}
	}
	
	private void generateInputVariables(PrintWriter writer, IVariableAccessor variableAccessor) {
		Iterator<Input> inputIterator = getComponent().getInputs().iterator();
		IMscriptGeneratorContext mscriptGeneratorContext = new MscriptGeneratorContext(getComputationModel(), writer);
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			BlockInput blockInput = (BlockInput) inputIterator.next();
			if (blockInput.getDefinition().isManyPorts() || blockInput.getDefinition().getMinimumPortCount() == 0) {
				ArrayType arrayType = (ArrayType) inputVariableDeclaration.getType();
				writer.printf("%s %s_%s[%d] = { ", MscriptGeneratorUtil.getCDataType(getComputationModel(), arrayType.getElementType()), InternalGeneratorUtil.uncapitalize(getComponent().getName()), blockInput.getDefinition().getName(), blockInput.getPorts().size());
				boolean first = true;
				for (InputPort inputPort : blockInput.getPorts()) {
					if (first) {
						first = false;
					} else {
						writer.print(", ");
					}
					MscriptGeneratorUtil.cast(mscriptGeneratorContext, variableAccessor.getInputVariable(inputPort, false), getSignature().getInputDataType(inputPort), arrayType.getElementType());
				}
				writer.println(" };");
			} else {
				InputPort inputPort = blockInput.getPorts().get(0);
				DataType inputDataType = getSignature().getInputDataType(inputPort);
				DataType targetDataType = inputVariableDeclaration.getType();
				if (!EcoreUtil.equals(inputDataType, targetDataType)) {
					writer.printf("%s %s_%s = ", MscriptGeneratorUtil.getCDataType(getComputationModel(), targetDataType), InternalGeneratorUtil.uncapitalize(getComponent().getName()), blockInput.getDefinition().getName());
					MscriptGeneratorUtil.cast(mscriptGeneratorContext, variableAccessor.getInputVariable(inputPort, false), inputDataType, targetDataType);
					writer.println(";");
				}
			}
		}
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
				double sampleTime = getExecutionModel().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeSystemUtil.createUnit(UnitSymbol.SECOND));
				return new ValueConstructor().construct(new ComputationContext(), realType, sampleTime);
			}
			if (SAMPLE_RATE_TEMPLATE_PARAMETER_NAME.equals(name)) {
				double sampleRate = 1 / getExecutionModel().getSampleTime();
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				Unit herzUnit = TypeSystemUtil.createUnit();
				herzUnit.getFactor(UnitSymbol.SECOND).setExponent(-1);
				realType.setUnit(herzUnit);
				return new ValueConstructor().construct(new ComputationContext(), realType, sampleRate);
			}
			return super.getGlobalTemplateArgument(name);
		}
		
	}

}
