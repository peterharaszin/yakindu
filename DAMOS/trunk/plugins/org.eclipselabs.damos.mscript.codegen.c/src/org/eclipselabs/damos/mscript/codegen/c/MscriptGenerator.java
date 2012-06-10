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
	
	private final ICompoundStatementGenerator compoundStatementGenerator = new CompoundStatementGenerator();
	
	private FunctionInstance functionInstance;
	
	private IMscriptGeneratorContext context;
	
	private String functionName;
	
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
	}
	
	public CharSequence generateHeaderCode() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("#ifndef %s_H_\n", functionName.toUpperCase());
		out.printf("#define %s_H_\n", functionName.toUpperCase());
		out.println();
		out.print(generateHeaderIncludes());
		out.println();
		out.println("#ifdef __cplusplus");
		out.println("extern \"C\" {");
		out.println("#endif /* __cplusplus */");
		out.println();
		
		if (functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL) {
			out.print(generateContextStructure());
		}

		out.println();
		out.print(generateFunctionPrototypes());
		out.println();

		out.println("#ifdef __cplusplus");
		out.println("}");
		out.println("#endif /* __cplusplus */");
		out.println();
		out.printf("#endif /* %s_H_ */\n", functionName.toUpperCase());
		
		return sb;
	}
	
	public CharSequence generateHeaderIncludes() {
		return "#include <stdint.h>";
	}
	
	public CharSequence generateContextStructure() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("typedef struct {\n");
		for (InputParameterDeclaration inputParameterDeclaration : functionInstance.getFunctionDeclaration().getInputParameterDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				out.print(generateContextStructureMember(inputParameterDeclaration));
			}
		}
		for (OutputParameterDeclaration outputParameterDeclaration : functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(outputParameterDeclaration) > 1) {
				out.print(generateContextStructureMember(outputParameterDeclaration));
			}
		}
		for (StateVariableDeclaration stateVariableDeclaration : functionInstance.getFunctionDeclaration().getStateVariableDeclarations()) {
			out.print(generateContextStructureMember(stateVariableDeclaration));
		}
		out.printf("} %s_Context;\n", functionName);
		return sb;
	}
	
	private CharSequence generateContextStructureMember(VariableDeclaration variableDeclaration) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
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
		return sb;
	}
	
	public CharSequence generateFunctionPrototypes() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL) {
			out.print(generateInitializeFunctionHeader());
			out.println(";");
			out.print(generateComputeOutputsFunctionHeader());
			out.println(";");
			out.print(generateUpdateFunctionHeader());
			out.println(";");
		} else {
			out.print(generateStatelessFunctionHeader());
			out.println(";");
		}
		return sb;
	}

	public CharSequence generateImplementationCode() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.print(generateImplementationIncludes());
		out.println();
		out.print(generateFunctionImplementations());
		return sb;
	}
	
	public CharSequence generateImplementationIncludes() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.println("#include <math.h>");
		out.println("#include <string.h>");
		out.printf("#include \"%s.h\"\n", functionName);
		return sb;
	}
	
	public CharSequence generateFunctionImplementations() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		if (functionInstance.getFunctionDeclaration().getKind() == FunctionKind.STATEFUL) {
			out.print(generateInitializeFunctionImplementation());

			out.println();

			out.print(generateComputeOutputsImplementation());

			out.println();

			out.print(generateUpdateFunctionImplementation());
		} else {
			out.print(generateStatelessFunctionHeader());
			out.println(" {");
			for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
				out.print(compoundStatementGenerator.generate(context, compound));
			}
			out.println("}");
		}
		return sb;
	}

	/**
	 * 
	 */
	private CharSequence generateInitializeFunctionHeader() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("void %s_initialize(%s_Context *context)", functionName, functionName);
		return sb;
	}

	/**
	 * @param variableAccessStrategy
	 * @throws IOException 
	 */
	private CharSequence generateInitializeFunctionImplementation() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.print(generateInitializeFunctionHeader());
		out.println(" {");
		out.print(generateInitializeIndexStatements(functionInstance.getFunctionDeclaration().getInputParameterDeclarations()));
		out.print(generateInitializeIndexStatements(functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()));
		out.print(generateInitializeIndexStatements(functionInstance.getFunctionDeclaration().getStateVariableDeclarations()));
		out.print(compoundStatementGenerator.generate(context, functionInstance.getInitializationCompound()));
		out.println("}");
		return sb;
	}

	private CharSequence generateInitializeIndexStatements(List<? extends VariableDeclaration> variableDeclarations) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration) > 1) {
				out.printf("context->%s_index = 0;\n", variableDeclaration.getName());
			}
		}
		return sb;
	}

	/**
	 * 
	 */
	private CharSequence generateComputeOutputsFunctionHeader() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("void %s(%s_Context *context", functionName, functionName);
		for (InputParameterDeclaration inputParameterDeclaration : FunctionModelUtil.getDirectFeedthroughInputs(functionInstance)) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(inputParameterDeclaration), inputParameterDeclaration.getName(), false, null));
		}
		for (OutputParameterDeclaration outputParameterDeclaration: functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(outputParameterDeclaration), outputParameterDeclaration.getName(), true, null));
		}
		out.print(")");
		return sb;
	}

	/**
	 * @param variableAccessStrategy
	 * @throws IOException 
	 */
	private CharSequence generateComputeOutputsImplementation() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.print(generateComputeOutputsFunctionHeader());
		out.println(" {");
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				out.print(compoundStatementGenerator.generate(context, compound));
			}
		}
		
		for (InputParameterDeclaration inputParameterDeclaration : FunctionModelUtil.getDirectFeedthroughInputs(functionInstance)) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				out.print(generateUpdateInputContextStatement(inputParameterDeclaration));
			}
		}
		
		for (OutputParameterDeclaration outputVariableDeclaration : functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(outputVariableDeclaration) > 1) {
				String name = outputVariableDeclaration.getName();
				out.printf("context->%s[context->%s_index] = *%s;\n", name, name, name);
			}
		}
		out.println("}");
		return sb;
	}

	/**
	 * 
	 */
	private CharSequence generateUpdateFunctionHeader() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.printf("void %s_update(%s_Context *context", functionName, functionName);
		for (InputParameterDeclaration inputParameterDeclaration : getUpdateCodeInputs()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context, getDataType(inputParameterDeclaration), inputParameterDeclaration.getName(), false, null));
		}
		out.print(")");
		return sb;
	}

	/**
	 * @param variableAccessStrategy
	 * @throws IOException 
	 */
	private CharSequence generateUpdateFunctionImplementation() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		out.print(generateUpdateFunctionHeader());
		out.println(" {");
		for (ComputationCompound compound : functionInstance.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundStatementGenerator.generate(context, compound);
			}
		}
		for (InputParameterDeclaration inputParameterDeclaration : getUpdateCodeInputs()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				out.print(generateUpdateInputContextStatement(inputParameterDeclaration));
			}
		}
		out.print(generateUpdateIndexStatements(functionInstance.getFunctionDeclaration().getInputParameterDeclarations()));
		out.print(generateUpdateIndexStatements(functionInstance.getFunctionDeclaration().getOutputParameterDeclarations()));
		out.print(generateUpdateIndexStatements(functionInstance.getFunctionDeclaration().getStateVariableDeclarations()));
		out.println("}");
		return sb;
	}
	
	private List<InputParameterDeclaration> getUpdateCodeInputs() {
		List<InputParameterDeclaration> inputs = new ArrayList<InputParameterDeclaration>(functionInstance.getFunctionDeclaration().getInputParameterDeclarations());
		inputs.removeAll(FunctionModelUtil.getDirectFeedthroughInputs(functionInstance));
		return inputs;
	}

	private CharSequence generateUpdateInputContextStatement(InputParameterDeclaration inputParameterDeclaration) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		String name = inputParameterDeclaration.getName();
		out.printf("context->%s[context->%s_index] = %s;\n", name, name, name);
		return sb;
	}

	/**
	 * 
	 */
	private CharSequence generateUpdateIndexStatements(List<? extends VariableDeclaration> variableDeclarations) {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
		for (VariableDeclaration variableDeclaration : variableDeclarations) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration) > 1) {
				String name = variableDeclaration.getName();
				out.printf("context->%s_index = (context->%s_index + 1) %% %d;\n", name, name, context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration));
			}
		}
		return sb;
	}

	/**
	 * 
	 */
	private CharSequence generateStatelessFunctionHeader() {
		StringBuilder sb = new StringBuilder();
		PrintAppendable out = new PrintAppendable(sb);
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
		return sb;
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
