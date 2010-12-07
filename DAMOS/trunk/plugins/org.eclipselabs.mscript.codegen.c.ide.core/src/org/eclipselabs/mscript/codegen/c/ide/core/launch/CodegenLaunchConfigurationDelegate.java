package org.eclipselabs.mscript.codegen.c.ide.core.launch;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipselabs.mscript.codegen.c.CompoundCGenerator;
import org.eclipselabs.mscript.codegen.c.ide.core.CodegenCIDECorePlugin;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.interpreter.DataTypeSpecifierEvaluator;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.value.ValueFactory;
import org.eclipselabs.mscript.language.parser.antlr.MscriptParser;
import org.eclipselabs.mscript.language.util.LanguageUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;

public class CodegenLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.mscript.codegen.c.ide.core.codegen";
	
	public static final String ATTRIBUTE__FILE_PATH = "filePath";
	public static final String ATTRIBUTE__FUNCTION_NAME = "function";
	public static final String ATTRIBUTE__TEMPLATE_PARAMETER_DATA_TYPES = "templateParameterDataTypes";
	public static final String ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES = "inputParameterDataTypes";
	public static final String ATTRIBUTE__TARGET_FOLDER_PATH = "targetFolderPath";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String filePathString = configuration.getAttribute(ATTRIBUTE__FILE_PATH, "");
		if (filePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "No Mscript file specified"));
		}

		String functionName = configuration.getAttribute(ATTRIBUTE__FUNCTION_NAME, "");
		if (functionName.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "No function specified"));
		}

		String templateParameterDataTypesString = configuration.getAttribute(ATTRIBUTE__TEMPLATE_PARAMETER_DATA_TYPES, "");
		
		String inputParameterDataTypesString = configuration.getAttribute(ATTRIBUTE__INPUT_PARAMETER_DATA_TYPES, "");

		String targetFolderPathString = configuration.getAttribute(ATTRIBUTE__TARGET_FOLDER_PATH, "");
		if (targetFolderPathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "No output file specified"));
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePathString));
		if (!file.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Mscript file '" + file.getName() + "' does not exist"));
		}
		
		IFolder targetFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(new Path(targetFolderPathString));

		IInterpreterContext context = new InterpreterContext(new ValueFactory());
		
		ILFunctionDefinition ilFunctionDefinition = createILFunctionDefinition(context, file, functionName, templateParameterDataTypesString, inputParameterDataTypesString, monitor);
		
		generateFile(monitor, functionName, targetFolder, ilFunctionDefinition);
	}

	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}

	private ILFunctionDefinition createILFunctionDefinition(IInterpreterContext interpreterContext, IFile file, String functionName, String templateParameterDataTypesString, String inputParameterDataTypesString, IProgressMonitor monitor) throws CoreException {
		IParseResult parseResult = CodegenCIDECorePlugin.getDefault().getMscriptParser().parse(new InputStreamReader(file.getContents()));
		if (!parseResult.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Parse errors"));
		}
			
		if (!(parseResult.getRootASTElement() instanceof Module)) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Invalid parse result"));
		}

		Module module = (Module) parseResult.getRootASTElement();
		FunctionDefinition functionDefinition = LanguageUtil.getFunctionDefinition(module, functionName);
		if (functionDefinition == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Function '" + functionName + "' not found"));
		}

		List<DataType> templateParameterDataTypes = getDataTypes(interpreterContext, templateParameterDataTypesString);
		if (templateParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Invalid template parameter data type specifiers"));
		}
		
		if (templateParameterDataTypes.size() != functionDefinition.getTemplateParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Number of template parameter data types does not correspond to the number of template parameter in function definition"));
		}
		
		IFunctionDescriptorConstructorResult functionDescriptorConstructorResult = new FunctionDescriptorConstructor().construct(functionDefinition);
		if (!functionDescriptorConstructorResult.getStatus().isOK()) {
			throw new CoreException(functionDescriptorConstructorResult.getStatus());
		}
		
		List<DataType> inputParameterDataTypes = getDataTypes(interpreterContext, inputParameterDataTypesString);
		if (inputParameterDataTypes == null) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Invalid input parameter data type specifiers"));
		}

		if (inputParameterDataTypes.size() != functionDefinition.getInputParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCIDECorePlugin.PLUGIN_ID, "Number of input parameter data types does not correspond to the number of input parameter in function definition"));
		}

		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer().transform(functionDescriptorConstructorResult.getFunctionDescriptor(), templateParameterDataTypes, inputParameterDataTypes);
		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			throw new CoreException(functionDefinitionTransformerResult.getStatus());
		}

		return functionDefinitionTransformerResult.getILFunctionDefinition();
	}
	
	private List<DataType> getDataTypes(IInterpreterContext interpreterContext, String dataTypesString) throws CoreException {
		List<DataType> dataTypes = new ArrayList<DataType>();
		
		String[] dataTypeStrings = dataTypesString.split(",");
		if (dataTypeStrings[0].length() == 0) {
			dataTypeStrings = new String[0];
		}

		MscriptParser parser = CodegenCIDECorePlugin.getDefault().getMscriptParser();
		
		for (String dataTypeString : dataTypeStrings) {
			IParseResult parseResult = parser.parse(parser.getGrammarAccess().getDataTypeSpecifierRule().getName(), new StringReader(dataTypeString));
			if (!parseResult.getParseErrors().isEmpty()) {
				return null;
			}
			DataTypeSpecifier dataTypeSpecifier = (DataTypeSpecifier) parseResult.getRootASTElement();
			DataType dataType = new DataTypeSpecifierEvaluator(interpreterContext).doSwitch(dataTypeSpecifier);
			if (dataType instanceof InvalidDataType) {
				return null;
			}
			
			dataTypes.add(dataType);
		}
		
		return dataTypes;
	}

	/**
	 * @param monitor
	 * @param functionName
	 * @param targetFolder
	 * @param ilFunctionDefinition
	 * @throws CoreException
	 */
	private void generateFile(IProgressMonitor monitor, String functionName, IFolder targetFolder, ILFunctionDefinition ilFunctionDefinition) throws CoreException {
		IFile targetFile = targetFolder.getFile(functionName + ".c");
		if (targetFile.exists()) {
			targetFile.delete(true, monitor);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(new CompoundCGenerator().doSwitch(ilFunctionDefinition.getInitializationCompound()));
		for (Compound compound : ilFunctionDefinition.getComputationCompounds()) {
			sb.append(new CompoundCGenerator().doSwitch(compound));
		}
		
		targetFile.create(new StringInputStream(sb.toString()), true, monitor);
	}
	
}
