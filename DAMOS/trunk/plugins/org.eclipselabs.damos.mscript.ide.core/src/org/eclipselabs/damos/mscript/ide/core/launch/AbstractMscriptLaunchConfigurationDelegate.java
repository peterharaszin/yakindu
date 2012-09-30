package org.eclipselabs.damos.mscript.ide.core.launch;

import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.mscript.FunctionDeclaration;
import org.eclipselabs.damos.mscript.InvalidType;
import org.eclipselabs.damos.mscript.Module;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.TypeSpecifier;
import org.eclipselabs.damos.mscript.computation.ComputationModel;
import org.eclipselabs.damos.mscript.computation.util.ComputationModelUtil;
import org.eclipselabs.damos.mscript.function.FunctionInstance;
import org.eclipselabs.damos.mscript.function.transform.FunctionDefinitionTransformer;
import org.eclipselabs.damos.mscript.ide.core.IDECorePlugin;
import org.eclipselabs.damos.mscript.ide.core.internal.launch.util.ParseUtil;
import org.eclipselabs.damos.mscript.interpreter.ComputationContext;
import org.eclipselabs.damos.mscript.interpreter.FunctionCallPath;
import org.eclipselabs.damos.mscript.interpreter.IInterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.InterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.StaticFunctionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.parser.antlr.MscriptParser;
import org.eclipselabs.damos.mscript.util.MscriptUtil;

public abstract class AbstractMscriptLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipselabs.mscript.codegen.c.ide.core.codegen";
	
	public static final String ATTRIBUTE__FILE_PATH = "filePath";
	public static final String ATTRIBUTE__FUNCTION_NAME = "functionName";
	public static final String ATTRIBUTE__STATIC_ARGUMENTS = "staticArguments";
	public static final String ATTRIBUTE__COMPUTATION_MODEL = "computationModel";
	
	private IStaticEvaluationResult staticEvaluationResult;

	private ComputationModel computationModel;
	
	private FunctionDeclaration functionDeclaration;
	
	private FunctionInstance functionInstance;
	
	private List<IValue> staticArguments;
	
	private List<Type> inputParameterDataTypes;
	
	/**
	 * @return the staticEvaluationResult
	 */
	public IStaticEvaluationResult getStaticEvaluationResult() {
		return staticEvaluationResult;
	}
	
	/**
	 * @return the computationModel
	 */
	public ComputationModel getComputationModel() {
		return computationModel;
	}
	
	/**
	 * @return the functionDefinition
	 */
	public FunctionDeclaration getFunctionDefinition() {
		return functionDeclaration;
	}
	
	/**
	 * @return the functionInstance
	 */
	public FunctionInstance getFunctionInstance() {
		return functionInstance;
	}
	
	/**
	 * @return the staticArguments
	 */
	public List<IValue> getStaticArguments() {
		return staticArguments;
	}
	
	/**
	 * @return the inputParameterDataTypes
	 */
	public List<Type> getInputParameterDataTypes() {
		return inputParameterDataTypes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.debug.core.model.LaunchConfigurationDelegate#preLaunchCheck(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		
		String filePathString = configuration.getAttribute(ATTRIBUTE__FILE_PATH, "");
		if (filePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No Mscript file specified"));
		}

		String functionName = configuration.getAttribute(ATTRIBUTE__FUNCTION_NAME, "");
		if (functionName.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No function specified"));
		}

		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePathString));
		if (!file.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Mscript file '" + file.getName() + "' does not exist"));
		}

		functionDeclaration = createFunctionDefinition(file, functionName);
		
		String computationModelString = configuration.getAttribute(ATTRIBUTE__COMPUTATION_MODEL, "");
		if (computationModelString.length() == 0) {
			computationModel = ComputationModelUtil.constructDefaultComputationModel();
		} else {
			computationModel = createComputationModel(computationModelString);
		}
		
		String staticArgumentsString = configuration.getAttribute(ATTRIBUTE__STATIC_ARGUMENTS, "");

		staticArguments = computeStaticArguments(createStaticArgumentsInterpreterContext(), functionDeclaration, staticArgumentsString);

		inputParameterDataTypes = computeInputParameterDataTypes(configuration, mode, monitor);

		functionInstance = createFunctionInstance(functionDeclaration, monitor);

		return super.preLaunchCheck(configuration, mode, monitor);
	}
	
	protected abstract List<Type> computeInputParameterDataTypes(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException;
	
	protected IInterpreterContext createStaticArgumentsInterpreterContext() {
		return new InterpreterContext(getStaticEvaluationResult(), new ComputationContext(), null);
	}

	protected String getTargetFunctionName() throws CoreException {
		return null;
	}

	protected List<Type> getDataTypes(IInterpreterContext interpreterContext, String dataTypesString) throws CoreException {
		List<Type> types = new ArrayList<Type>();
		
		String[] dataTypeStrings = dataTypesString.split(",");
		if (dataTypeStrings[0].length() == 0) {
			dataTypeStrings = new String[0];
		}
	
		MscriptParser parser = IDECorePlugin.getDefault().getMscriptParser();
		
		for (String dataTypeString : dataTypeStrings) {
			IParseResult parseResult = parser.parse(parser.getGrammarAccess().getTypeSpecifierRule(), new StringReader(dataTypeString));
			if (parseResult.hasSyntaxErrors()) {
				return null;
			}
			TypeSpecifier typeSpecifier = (TypeSpecifier) parseResult.getRootASTElement();
			Type type = EcoreUtil.copy(typeSpecifier.getType());
			if (type instanceof InvalidType) {
				return null;
			}
			
			types.add(type);
		}
		
		return types;
	}

	private ComputationModel createComputationModel(String computationModelString) throws CoreException {
		try {
			URI uri = URI.createPlatformResourceURI(computationModelString, true);
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource resource = resourceSet.getResource(uri, true);
			return (ComputationModel) resource.getContents().get(0);
		} catch (RuntimeException e) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Loading computation model failed", e));
		}
	}

	private FunctionDeclaration createFunctionDefinition(IFile file, String functionName) throws CoreException {
		IParseResult parseResult = IDECorePlugin.getDefault().getMscriptParser().parse(new InputStreamReader(file.getContents()));
		if (parseResult.hasSyntaxErrors()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Parse errors"));
		}
			
		if (!(parseResult.getRootASTElement() instanceof Module)) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid parse result"));
		}

		Module module = (Module) parseResult.getRootASTElement();
		FunctionDeclaration functionDeclaration = MscriptUtil.getFunctionDeclaration(module, functionName);
		if (functionDeclaration == null) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Function '" + functionName + "' not found"));
		}
		return functionDeclaration;
	}

	private FunctionInstance createFunctionInstance(FunctionDeclaration functionDeclaration, IProgressMonitor monitor) throws CoreException {
		staticEvaluationResult = new StaticEvaluationResult();
		new StaticFunctionEvaluator().evaluate(new StaticEvaluationContext(staticEvaluationResult), functionDeclaration);
		if (staticEvaluationResult.getStatus().getSeverity() > IStatus.WARNING) {
			throw new CoreException(staticEvaluationResult.getStatus());
		}
		
		return new FunctionDefinitionTransformer().transform(staticEvaluationResult, staticEvaluationResult.getFunctionInfo(FunctionCallPath.EMPTY));
	}
	
	private List<IValue> computeStaticArguments(IInterpreterContext interpreterContext, FunctionDeclaration functionDeclaration, String staticArgumentsString) throws CoreException {
		List<IValue> staticArguments = ParseUtil.parseValues(interpreterContext, staticArgumentsString);
		if (staticArguments == null) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid template arguments specified"));
		}
		
		if (staticArguments.size() != functionDeclaration.getConstantInputParameterDeclarations().size()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Number of template parameter data types does not correspond to the number of template parameter in function definition"));
		}
		
		return staticArguments;
	}

}
