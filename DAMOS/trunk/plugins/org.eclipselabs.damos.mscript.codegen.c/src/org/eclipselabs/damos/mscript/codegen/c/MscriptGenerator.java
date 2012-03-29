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

package org.eclipselabs.damos.mscript.codegen.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.FunctionKind;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.StateVariableDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.functionmodel.FunctionInstance;
import org.eclipselabs.damos.mscript.functionmodel.util.FunctionModelUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGenerator {
	
	private final ICompoundGenerator compoundGenerator = new CompoundGenerator();
	
	private FunctionInstance functionInstance;
	
	private IMscriptGeneratorContext context;
	
	private String functionName;
	private PrintAppendable out;
	
	/**
	 * 
	 */
	public MscriptGenerator(FunctionInstance functionInstance, IMscriptGeneratorContext context, String functionName) {
		this.functionInstance = functionInstance;
		this.context = context;
		this.functionName = functionName;
		if (this.functionName == null) {
			this.functionName = functionInstance.getFunctionDeclaration().getName();
		}
		out = new PrintAppendable(context.getAppendable());
	}
	
	public void generateHeaderCode() {
		out.printf("#ifndef %s_H_\n", functionName.toUpperCase());
		out.printf("#define %s_H_\n", functionName.toUpperCase());
		out.println();
		generateHeaderIncludes();
		out.println();
		out.println("#ifdef __cplusplus");
		out.println("extern \"C\" {");
		out.println("#endif /* __cplusplus */");
		out.println();
		
		if (functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL) {
			generateContextStructure();
		}

		out.println();
		generateFunctionPrototypes();
		out.println();

		out.println("#ifdef __cplusplus");
		out.println("}");
		out.println("#endif /* __cplusplus */");
		out.println();
		out.printf("#endif /* %s_H_ */\n", functionName.toUpperCase());
	}
	
	public void generateHeaderIncludes() {
		out.println("#include <stdint.h>");
	}
	
	public void generateContextStructure() {
		out.printf("typedef struct {\n");
		for (InputParameterDeclaration inputParameterDeclaration : functionInstance.getFunctionDeclaration().getInputParameterDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				writeContextStructureMember(inputParameterDeclaration);
			}
		}
		for (OutputParameterDeclaration outputParameterDeclaration : functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(outputParameterDeclaration) > 1) {
				writeContextStructureMember(outputParameterDeclaration);
			}
		}
		for (StateVariableDeclaration stateVariableDeclaration : functionInstance.getFunctionDeclaration().getStateVariableDeclarations()) {
			writeContextStructureMember(stateVariableDeclaration);
		}
		out.printf("} %s_Context;\n", functionName);
	}
	
	private void writeContextStructureMember(VariableDeclaration variableDeclaration) {
		String name = variableDeclaration.getName();
		DataType dataType = getDataType(variableDeclaration);
		int circularBufferSize = context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration);
		if (circularBufferSize > 1) {
			int bufferSize = circularBufferSize;
			out.printf("%s[%d];\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context, dataType, name, false, null),
					bufferSize);
			out.printf("%s %s_index;\n", MscriptGeneratorUtil.getIndexCDataType(context.getComputationModel(), 2 * bufferSize), name);
		} else {
			out.printf("%s;\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context, dataType, name, false, null));
		}
	}
	
	public void generateFunctionPrototypes() {
		if (functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL) {
			generateInitializeFunctionHeader();
			out.println(";");
			generateComputeOutputsFunctionHeader();
			out.println(";");
			generateUpdateFunctionHeader();
			out.println(";");
		} else {
			generateStatelessFunctionHeader();
			out.println(";");
		}
	}

	public void generateImplementationCode() throws IOException {
		generateImplementationIncludes();
		out.println();
		generateFunctionImplementations();
	}
	
	public void generateImplementationIncludes() {
		out.println("#include <math.h>");
		out.println("#include <string.h>");
		out.printf("#include \"%s.h\"\n", functionName);
	}
	
	public void generateFunctionImplementations() throws IOException {
		if (functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL) {
			generateInitializeFunctionImplementation();

			out.println();

			generateComputeOutputsImplementation();

			out.println();

			generateUpdateFunctionImplementation();
		} else {
			generateStatelessFunctionHeader();
			out.println(" {");
			for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
				compoundGenerator.generate(context, compound);
			}
			out.println("}");
		}
	}

	/**
	 * 
	 */
	private void generateInitializeFunctionHeader() {
		out.printf("void %s_initialize(%s_Context *context)", functionName, functionName);
	}

	/**
	 * @param variableAccessStrategy
	 * @throws IOException 
	 */
	private void generateInitializeFunctionImplementation() throws IOException {
		generateInitializeFunctionHeader();
		out.println(" {");
		generateInitializeIndexStatements(functionInstance.getFunctionDeclaration().getInputParameterDeclarations());
		generateInitializeIndexStatements(functionInstance.getFunctionDeclaration().getOutputParameterDeclarations());
		generateInitializeIndexStatements(functionInstance.getFunctionDeclaration().getStateVariableDeclarations());
		compoundGenerator.generate(context, functionInstance.getInitializationCompound());
		out.println("}");
	}

	private void generateInitializeIndexStatements(List<? extends VariableDeclaration> variableDeclarations) {
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration) > 1) {
				out.printf("context->%s_index = 0;\n", variableDeclaration.getName());
			}
		}
	}

	/**
	 * 
	 */
	private void generateComputeOutputsFunctionHeader() {
		out.printf("void %s(%s_Context *context", functionName, functionName);
		for (InputParameterDeclaration inputParameterDeclaration : FunctionModelUtil.getDirectFeedthroughInputs(functionInstance)) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(inputParameterDeclaration), inputParameterDeclaration.getName(), false, null));
		}
		for (OutputParameterDeclaration outputParameterDeclaration: functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(outputParameterDeclaration), outputParameterDeclaration.getName(), true, null));
		}
		out.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 * @throws IOException 
	 */
	private void generateComputeOutputsImplementation() throws IOException {
		generateComputeOutputsFunctionHeader();
		out.println(" {");
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, compound);
			}
		}
		
		for (InputParameterDeclaration inputParameterDeclaration : FunctionModelUtil.getDirectFeedthroughInputs(functionInstance)) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				generateUpdateInputContextStatement(inputParameterDeclaration);
			}
		}
		
		for (OutputParameterDeclaration outputVariableDeclaration : functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(outputVariableDeclaration) > 1) {
				String name = outputVariableDeclaration.getName();
				out.printf("context->%s[context->%s_index] = *%s;\n", name, name, name);
			}
		}
		out.println("}");
	}

	/**
	 * 
	 */
	private void generateUpdateFunctionHeader() {
		out.printf("void %s_update(%s_Context *context", functionName, functionName);
		for (InputParameterDeclaration inputParameterDeclaration : getUpdateCodeInputs()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(inputParameterDeclaration), inputParameterDeclaration.getName(), false, null));
		}
		out.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 * @throws IOException 
	 */
	private void generateUpdateFunctionImplementation() throws IOException {
		generateUpdateFunctionHeader();
		out.println(" {");
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, compound);
			}
		}
		for (InputParameterDeclaration inputParameterDeclaration : getUpdateCodeInputs()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				generateUpdateInputContextStatement(inputParameterDeclaration);
			}
		}
		generateUpdateIndexStatements(functionInstance.getFunctionDeclaration().getInputParameterDeclarations());
		generateUpdateIndexStatements(functionInstance.getFunctionDeclaration().getOutputParameterDeclarations());
		generateUpdateIndexStatements(functionInstance.getFunctionDeclaration().getStateVariableDeclarations());
		out.println("}");
	}
	
	private List<InputParameterDeclaration> getUpdateCodeInputs() {
		List<InputParameterDeclaration> inputs = new ArrayList<InputParameterDeclaration>(functionInstance.getFunctionDeclaration().getInputParameterDeclarations());
		inputs.removeAll(FunctionModelUtil.getDirectFeedthroughInputs(functionInstance));
		return inputs;
	}

	private void generateUpdateInputContextStatement(InputParameterDeclaration inputParameterDeclaration) {
		String name = inputParameterDeclaration.getName();
		out.printf("context->%s[context->%s_index] = %s;\n", name, name, name);
	}

	/**
	 * 
	 */
	private void generateUpdateIndexStatements(List<? extends VariableDeclaration> variableDeclarations) {
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration) > 1) {
				String name = variableDeclaration.getName();
				out.printf("context->%s_index = (context->%s_index + 1) %% %d;\n", name, name, context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration));
			}
		}
	}

	/**
	 * 
	 */
	private void generateStatelessFunctionHeader() {
		out.printf("void %s(", functionName, functionName);
		boolean first = true;
		for (InputParameterDeclaration inputParameterDeclaration: functionInstance.getFunctionDeclaration().getInputParameterDeclarations()) {
			if (first) {
				first = false;
			} else {
				out.print(", ");
			}
			out.print(MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(inputParameterDeclaration), inputParameterDeclaration.getName(), false, null));
		}
		for (OutputParameterDeclaration outputParameterDeclaration: functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			if (first) {
				first = false;
			} else {
				out.print(", ");
			}
			out.print(MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(outputParameterDeclaration), outputParameterDeclaration.getName(), true, null));
		}
		out.print(")");
	}

	/**
	 * @param evaluable
	 * @return
	 */
	private DataType getDataType(Evaluable evaluable) {
		IValue value = context.getStaticEvaluationContext().getValue(evaluable);
		return value != null ? value.getDataType() : null;
	}

}
