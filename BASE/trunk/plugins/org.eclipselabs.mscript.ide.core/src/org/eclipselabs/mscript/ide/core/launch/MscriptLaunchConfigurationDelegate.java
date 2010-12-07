package org.eclipselabs.mscript.ide.core.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipselabs.mscript.ide.core.IDECorePlugin;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.functionmodel.util.FunctionDescriptorConstructor;
import org.eclipselabs.mscript.language.functionmodel.util.IFunctionDescriptorConstructorResult;
import org.eclipselabs.mscript.language.il.ILFunctionDefinition;
import org.eclipselabs.mscript.language.il.transform.FunctionDefinitionTransformer;
import org.eclipselabs.mscript.language.il.transform.IFunctionDefinitionTransformerResult;
import org.eclipselabs.mscript.language.interpreter.Functor;
import org.eclipselabs.mscript.language.interpreter.IFunctor;
import org.eclipselabs.mscript.language.interpreter.IInterpreterContext;
import org.eclipselabs.mscript.language.interpreter.IVariable;
import org.eclipselabs.mscript.language.interpreter.InterpreterContext;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.ValueFactory;
import org.eclipselabs.mscript.language.util.LanguageUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class MscriptLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.mscript.ide.core.mscriptApplication";
	
	public static final String ATTRIBUTE__FILE_PATH = "filePath";
	public static final String ATTRIBUTE__FUNCTION_NAME = "function";
	public static final String ATTRIBUTE__TEMPLATE_ARGUMENTS = "templateArguments";
	public static final String ATTRIBUTE__INPUT_FILE_PATH = "inputFilePath";
	public static final String ATTRIBUTE__OUTPUT_FILE_PATH = "outputFilePath";
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor) throws CoreException {
		String filePathString = configuration.getAttribute(ATTRIBUTE__FILE_PATH, "");
		if (filePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No Mscript file specified"));
		}

		String functionName = configuration.getAttribute(ATTRIBUTE__FUNCTION_NAME, "");
		if (functionName.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No function specified"));
		}

		String templateArguments = configuration.getAttribute(ATTRIBUTE__TEMPLATE_ARGUMENTS, "");
		
		String inputFilePathString = configuration.getAttribute(ATTRIBUTE__INPUT_FILE_PATH, "");
		if (inputFilePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No input file specified"));
		}

		String outputFilePathString = configuration.getAttribute(ATTRIBUTE__OUTPUT_FILE_PATH, "");
		if (outputFilePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No output file specified"));
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePathString));
		if (!file.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Mscript file '" + file.getName() + "' does not exist"));
		}
		
		IFile inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(inputFilePathString));
		if (!inputFile.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Input file '" + inputFile.getName() + "' does not exist"));
		}

		IFile outputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(outputFilePathString));

		
		IInterpreterContext context = new InterpreterContext(new ValueFactory());
		
		IFunctor functor = createFunctor(context, file, functionName, templateArguments, inputFile, outputFile, monitor);
		checkInputFile(functor.getFunctionDefinition(), inputFile, monitor);
		prepareOutputFile(outputFile, monitor);

		new MscriptProcess(launch, "Mscript Application").run(context, functor, inputFile, outputFile);
	}
	
	protected void checkInputFile(ILFunctionDefinition functionDefinition, IFile inputFile, IProgressMonitor monitor) throws CoreException {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile.getContents()));
			int n = functionDefinition.getInputVariableDeclarations().size();
			while (!monitor.isCanceled() && reader.ready()) {
				String[] values = reader.readLine().split(",", 0);
				if (values.length != n) {
					throw new CoreException(new Status(
							IStatus.ERROR,
							IDECorePlugin.PLUGIN_ID,
							"Number of columns in input file '" + inputFile.getName() + "' does not correspond to number of input parameters"));
				}
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Reading input file '" + inputFile.getName() + "' failed", e));
		} catch (NumberFormatException e) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Input file '" + inputFile.getName() + "' contains invalid numeric values"));
		}
	}
	
	protected void prepareOutputFile(IFile outputFile, IProgressMonitor monitor) throws CoreException {
		if (outputFile.exists() && outputFile.isReadOnly()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Output file is read-only"));
		}
		if (outputFile.exists()) {
			outputFile.setContents(new StringInputStream(""), false, false, new NullProgressMonitor());
		} else {
			outputFile.create(new StringInputStream(""), false, new NullProgressMonitor());
		}
	}
	
	protected IFunctor createFunctor(IInterpreterContext interpreterContext, IFile file, String functionName, String templateArgumentString, IFile inputFile, IFile outputFile, IProgressMonitor monitor) throws CoreException {
		IParseResult parseResult = IDECorePlugin.getDefault().getMscriptParser().parse(new InputStreamReader(file.getContents()));
		if (!parseResult.getParseErrors().isEmpty()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Parse errors"));
		}
			
		if (!(parseResult.getRootASTElement() instanceof Module)) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid parse result"));
		}

		Module module = (Module) parseResult.getRootASTElement();
		FunctionDefinition functionDefinition = LanguageUtil.getFunctionDefinition(module, functionName);
		if (functionDefinition == null) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Function '" + functionName + "' not found"));
		}

		List<IValue> templateArguments = new ArrayList<IValue>();
		String[] args = templateArgumentString.split(",");
		if (args[0].length() == 0) {
			args = new String[0];
		}
		if (args.length != functionDefinition.getTemplateParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Number of template arguments does not correspond to number of template parameters in function definition"));
		}
		for (String arg : args) {
			try {
				double value = Double.parseDouble(arg);
				RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
				realType.setUnit(TypeSystemUtil.createUnit());
				templateArguments.add(interpreterContext.getValueFactory().createRealValue(realType, value));
			} catch (NumberFormatException e) {
				throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Template arguments contain invalid numeric values"));
			}
		}
		
		IFunctionDescriptorConstructorResult functionDescriptorConstructorResult = new FunctionDescriptorConstructor().construct(functionDefinition);
		if (!functionDescriptorConstructorResult.getStatus().isOK()) {
			throw new CoreException(functionDescriptorConstructorResult.getStatus());
		}
		
		List<DataType> templateParameterDataTypes = new ArrayList<DataType>();
		for (IValue value : templateArguments) {
			templateParameterDataTypes.add(value.getDataType());
		}
		
		List<DataType> inputParameterDataTypes = new ArrayList<DataType>();
		for (ParameterDeclaration parameterDeclaration : functionDefinition.getInputParameterDeclarations()) {
			RealType realType = TypeSystemFactory.eINSTANCE.createRealType();
			realType.setUnit(TypeSystemUtil.createUnit());
			inputParameterDataTypes.add(realType);
			parameterDeclaration.getName();
		}
		
		IFunctionDefinitionTransformerResult functionDefinitionTransformerResult = new FunctionDefinitionTransformer().transform(functionDescriptorConstructorResult.getFunctionDescriptor(), templateParameterDataTypes, inputParameterDataTypes);
		if (!functionDefinitionTransformerResult.getStatus().isOK()) {
			throw new CoreException(functionDefinitionTransformerResult.getStatus());
		}

		IFunctor functor = Functor.create(functionDefinitionTransformerResult.getILFunctionDefinition(), templateArguments);
		
		for (IVariable variable : functor.getVariables()) {
			interpreterContext.getScope().add(variable);
		}
		
		return functor;
	}
	
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		return false;
	}
	
}
