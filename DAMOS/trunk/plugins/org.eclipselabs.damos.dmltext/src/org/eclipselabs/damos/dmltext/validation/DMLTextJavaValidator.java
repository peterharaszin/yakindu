package org.eclipselabs.damos.dmltext.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.xtext.validation.Check;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification;
import org.eclipselabs.damos.mscript.Definition;
import org.eclipselabs.damos.mscript.FunctionDefinition;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.TemplateParameterDeclaration;
 

public class DMLTextJavaValidator extends AbstractDMLTextJavaValidator {

	private static final Set<String> GLOBAL_TEMPLATE_PARAMETERS = new HashSet<String>();
	
	static {
		GLOBAL_TEMPLATE_PARAMETERS.add("Ts");
		GLOBAL_TEMPLATE_PARAMETERS.add("fs");
	}
	
	/**
	 * 
	 */
	private static final String MAIN_FUNCTION_NAME = "main";

	@Check
	public void checkMainFunction(MscriptBehaviorSpecification behaviorSpecification) {
		for (Definition definition : behaviorSpecification.getModule().getDefinitions()) {
			if (definition instanceof FunctionDefinition) {
				FunctionDefinition functionDefinition = (FunctionDefinition) definition;
				if (MAIN_FUNCTION_NAME.equals(functionDefinition.getName())) {
					return;
				}
			}
		}
		error("No main function declared", null);
	}

	@Check
	public void checkMainFunctionParameters(FunctionDefinition functionDefinition) {
		if (!MAIN_FUNCTION_NAME.equals(functionDefinition.getName())) {
			return;
		}
		
		BlockType blockType = DMLUtil.getOwner(functionDefinition, BlockType.class);
		if (blockType == null) {
			return;
		}
		
		int inputParameterCount = computeInoutputParameterCount(blockType.getInputDefinitions());
		if (inputParameterCount != functionDefinition.getInputParameterDeclarations().size()) {
			error("Expecting " + inputParameterCount + " input parameter" + (inputParameterCount > 1 ? "s" : ""), MscriptPackage.eINSTANCE.getDefinition_Name());
		}

		int outputParameterCount = computeInoutputParameterCount(blockType.getOutputDefinitions());
		if (outputParameterCount != functionDefinition.getOutputParameterDeclarations().size()) {
			error("Expecting " + outputParameterCount + " output parameter" + (outputParameterCount > 1 ? "s" : ""), MscriptPackage.eINSTANCE.getDefinition_Name());
		}
		
		Map<String, Parameter> blockTypeParameters = getBlockTypeParameters(blockType);
		Set<String> templateParameterNames = new HashSet<String>();
		for (TemplateParameterDeclaration templateParameterDeclaration : functionDefinition.getTemplateParameterDeclarations()) {
			String name = templateParameterDeclaration.getName();
			if (!blockTypeParameters.containsKey(name) && !GLOBAL_TEMPLATE_PARAMETERS.contains(name)) {
				error("No block type parameter found for template parameter " + name, templateParameterDeclaration, null, -1);
			}
			templateParameterNames.add(name);
		}
		
		for (Entry<String, Parameter> entry : blockTypeParameters.entrySet()) {
			if (!templateParameterNames.contains(entry.getKey())) {
				warning("Unused parameter " + entry.getKey(), entry.getValue(), DMLPackage.eINSTANCE.getParameter_Name(), -1);
			}
		}
	}

	protected Map<String, Parameter> getBlockTypeParameters(BlockType blockType) {
		Map<String, Parameter> parameters = new HashMap<String, Parameter>();
		for (Parameter parameter : blockType.getParameters()) {
			parameters.put(parameter.getName(), parameter);
		}
		for (InputDefinition inputDefinition : blockType.getInputDefinitions()) {
			for (Parameter parameter : inputDefinition.getParameters()) {
				parameters.put(parameter.getName(), parameter);
			}
		}
		for (OutputDefinition outputDefinition : blockType.getOutputDefinitions()) {
			for (Parameter parameter : outputDefinition.getParameters()) {
				parameters.put(parameter.getName(), parameter);
			}
		}
		return parameters;
	}

	protected int computeInoutputParameterCount(List<? extends InoutputDefinition> inoutputDefinitions) {
		int count = 0;
		boolean hasSockets = false;
		for (InoutputDefinition inoutputDefinition : inoutputDefinitions) {
			if (inoutputDefinition.isSocket()) {
				hasSockets = true;
			}
			++count;
		}
		if (hasSockets) {
			++count;
		}
		return count;
	}
	
}
