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

import java.util.ArrayList;
import java.util.List;

import org.eclipselabs.damos.common.util.PrintAppendable;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.damos.mscript.il.ComputationCompound;
import org.eclipselabs.damos.mscript.il.ILFunctionDefinition;
import org.eclipselabs.damos.mscript.il.InputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.InstanceVariableDeclaration;
import org.eclipselabs.damos.mscript.il.OutputVariableDeclaration;
import org.eclipselabs.damos.mscript.il.StatefulVariableDeclaration;
import org.eclipselabs.damos.mscript.il.util.ILUtil;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGenerator {
	
	private final ICompoundGenerator compoundGenerator = new CompoundGenerator();
	
	private ILFunctionDefinition functionDefinition;
	
	private IMscriptGeneratorContext context;
	
	private PrintAppendable out;
	
	/**
	 * 
	 */
	public MscriptGenerator(ILFunctionDefinition functionDefinition, IMscriptGeneratorContext context) {
		this.functionDefinition = functionDefinition;
		this.context = context;
		out = new PrintAppendable(context.getAppendable());
	}
	
	public void generateHeaderCode() {
		out.printf("#ifndef %s_H_\n", functionDefinition.getName().toUpperCase());
		out.printf("#define %s_H_\n", functionDefinition.getName().toUpperCase());
		out.println();
		generateHeaderIncludes();
		out.println();
		out.println("#ifdef __cplusplus");
		out.println("extern \"C\" {");
		out.println("#endif /* __cplusplus */");
		out.println();
		
		if (functionDefinition.isStateful()) {
			generateContextStructure();
		}

		out.println();
		generateFunctionPrototypes();
		out.println();

		out.println("#ifdef __cplusplus");
		out.println("}");
		out.println("#endif /* __cplusplus */");
		out.println();
		out.printf("#endif /* %s_H_ */\n", functionDefinition.getName().toUpperCase());
	}
	
	public void generateHeaderIncludes() {
		out.println("#include <stdint.h>");
	}
	
	public void generateContextStructure() {
		out.printf("typedef struct {\n");
		for (InputVariableDeclaration inputVariableDeclaration : functionDefinition.getInputVariableDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputVariableDeclaration.getVariableDeclaration()) > 1) {
				writeContextStructureMember(inputVariableDeclaration);
			}
		}
		for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(outputVariableDeclaration.getVariableDeclaration()) > 1) {
				writeContextStructureMember(outputVariableDeclaration);
			}
		}
		for (InstanceVariableDeclaration instanceVariableDeclaration : functionDefinition.getInstanceVariableDeclarations()) {
			writeContextStructureMember(instanceVariableDeclaration);
		}
		out.printf("} %s_Context;\n", functionDefinition.getName());
	}
	
	private void writeContextStructureMember(StatefulVariableDeclaration variableDeclaration) {
		String name = variableDeclaration.getVariableDeclaration().getName();
		DataType dataType = getDataType(variableDeclaration.getVariableDeclaration());
		if (context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration.getVariableDeclaration()) > 1) {
			int bufferSize = context.getStaticEvaluationContext().getCircularBufferSize(variableDeclaration.getVariableDeclaration());
			out.printf("%s[%d];\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), dataType, name, false),
					bufferSize);
			out.printf("%s %s_index;\n", MscriptGeneratorUtil.getIndexCDataType(context.getComputationModel(), 2 * bufferSize), name);
		} else {
			out.printf("%s;\n",
					MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), dataType, name, false));
		}
	}
	
	public void generateFunctionPrototypes() {
		if (functionDefinition.isStateful()) {
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

	public void generateImplementationCode() {
		generateImplementationIncludes();
		out.println();
		generateFunctionImplementations();
	}
	
	public void generateImplementationIncludes() {
		out.println("#include <math.h>");
		out.println("#include <string.h>");
		out.printf("#include \"%s.h\"\n", functionDefinition.getName());
	}
	
	public void generateFunctionImplementations() {
		if (functionDefinition.isStateful()) {
			generateInitializeFunctionImplementation();

			out.println();

			generateComputeOutputsImplementation();

			out.println();

			generateUpdateFunctionImplementation();
		} else {
			generateStatelessFunctionHeader();
			out.println(" {");
			for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
				compoundGenerator.generate(context, compound);
			}
			out.println("}");
		}
	}

	/**
	 * 
	 */
	private void generateInitializeFunctionHeader() {
		out.printf("void %s_initialize(%s_Context *context)", functionDefinition.getName(), functionDefinition.getName());
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateInitializeFunctionImplementation() {
		generateInitializeFunctionHeader();
		out.println(" {");
		generateInitializeIndexStatements(functionDefinition.getInputVariableDeclarations());
		generateInitializeIndexStatements(functionDefinition.getOutputVariableDeclarations());
		generateInitializeIndexStatements(functionDefinition.getInstanceVariableDeclarations());
		compoundGenerator.generate(context, functionDefinition.getInitializationCompound());
		out.println("}");
	}

	private void generateInitializeIndexStatements(List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(statefulVariableDeclaration.getVariableDeclaration()) > 1) {
				out.printf("context->%s_index = 0;\n", statefulVariableDeclaration.getVariableDeclaration().getName());
			}
		}
	}

	/**
	 * 
	 */
	private void generateComputeOutputsFunctionHeader() {
		out.printf("void %s(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (InputParameterDeclaration inputParameterDeclaration : ILUtil.getDirectFeedthroughInputs(functionDefinition)) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(inputParameterDeclaration), inputParameterDeclaration.getName(), false));
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(outputVariableDeclaration.getVariableDeclaration()), outputVariableDeclaration.getVariableDeclaration().getName(), true));
		}
		out.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateComputeOutputsImplementation() {
		generateComputeOutputsFunctionHeader();
		out.println(" {");
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, compound);
			}
		}
		
		for (InputParameterDeclaration inputParameterDeclaration : ILUtil.getDirectFeedthroughInputs(functionDefinition)) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				generateUpdateInputContextStatement(inputParameterDeclaration);
			}
		}
		
		for (OutputVariableDeclaration outputVariableDeclaration : functionDefinition.getOutputVariableDeclarations()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(outputVariableDeclaration.getVariableDeclaration()) > 1) {
				String name = outputVariableDeclaration.getVariableDeclaration().getName();
				out.printf("context->%s[context->%s_index] = *%s;\n", name, name, name);
			}
		}
		out.println("}");
	}

	/**
	 * 
	 */
	private void generateUpdateFunctionHeader() {
		out.printf("void %s_update(%s_Context *context", functionDefinition.getName(), functionDefinition.getName());
		for (InputParameterDeclaration inputParameterDeclaration : getUpdateCodeInputs()) {
			out.printf(", %s", MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(inputParameterDeclaration), inputParameterDeclaration.getName(), false));
		}
		out.print(")");
	}

	/**
	 * @param variableAccessStrategy
	 */
	private void generateUpdateFunctionImplementation() {
		generateUpdateFunctionHeader();
		out.println(" {");
		for (ComputationCompound compound : functionDefinition.getComputationCompounds()) {
			if (compound.getOutputs().isEmpty()) {
				compoundGenerator.generate(context, compound);
			}
		}
		for (InputParameterDeclaration inputParameterDeclaration : getUpdateCodeInputs()) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(inputParameterDeclaration) > 1) {
				generateUpdateInputContextStatement(inputParameterDeclaration);
			}
		}
		generateUpdateIndexStatements(functionDefinition.getInputVariableDeclarations());
		generateUpdateIndexStatements(functionDefinition.getOutputVariableDeclarations());
		generateUpdateIndexStatements(functionDefinition.getInstanceVariableDeclarations());
		out.println("}");
	}
	
	private List<InputParameterDeclaration> getUpdateCodeInputs() {
		List<InputParameterDeclaration> inputs = new ArrayList<InputParameterDeclaration>(functionDefinition.getFunctionDefinition().getInputParameterDeclarations());
		inputs.removeAll(ILUtil.getDirectFeedthroughInputs(functionDefinition));
		return inputs;
	}

	private void generateUpdateInputContextStatement(InputParameterDeclaration inputParameterDeclaration) {
		String name = inputParameterDeclaration.getName();
		out.printf("context->%s[context->%s_index] = %s;\n", name, name, name);
	}

	/**
	 * 
	 */
	private void generateUpdateIndexStatements(List<? extends StatefulVariableDeclaration> statefulVariableDeclarations) {
		for (StatefulVariableDeclaration statefulVariableDeclaration : statefulVariableDeclarations) {
			if (context.getStaticEvaluationContext().getCircularBufferSize(statefulVariableDeclaration.getVariableDeclaration()) > 1) {
				String name = statefulVariableDeclaration.getVariableDeclaration().getName();
				out.printf("context->%s_index = (context->%s_index + 1) %% %d;\n", name, name, context.getStaticEvaluationContext().getCircularBufferSize(statefulVariableDeclaration.getVariableDeclaration()));
			}
		}
	}

	/**
	 * 
	 */
	private void generateStatelessFunctionHeader() {
		out.printf("void %s(", functionDefinition.getName(), functionDefinition.getName());
		boolean first = true;
		for (InputVariableDeclaration inputVariableDeclaration: functionDefinition.getInputVariableDeclarations()) {
			if (first) {
				first = false;
			} else {
				out.print(", ");
			}
			out.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(inputVariableDeclaration.getVariableDeclaration()), inputVariableDeclaration.getVariableDeclaration().getName(), false));
		}
		for (OutputVariableDeclaration outputVariableDeclaration: functionDefinition.getOutputVariableDeclarations()) {
			if (first) {
				first = false;
			} else {
				out.print(", ");
			}
			out.print(MscriptGeneratorUtil.getCVariableDeclaration(context.getComputationModel(), getDataType(outputVariableDeclaration.getVariableDeclaration()), outputVariableDeclaration.getVariableDeclaration().getName(), true));
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
