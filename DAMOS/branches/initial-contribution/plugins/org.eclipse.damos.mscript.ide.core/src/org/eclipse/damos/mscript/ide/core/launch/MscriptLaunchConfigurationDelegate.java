/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript.ide.core.launch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.ide.core.IDECorePlugin;
import org.eclipse.damos.mscript.ide.core.internal.launch.util.ParseUtil;
import org.eclipse.damos.mscript.interpreter.ComputationContext;
import org.eclipse.damos.mscript.interpreter.FunctionObject;
import org.eclipse.damos.mscript.interpreter.IFunctionObject;
import org.eclipse.damos.mscript.interpreter.IInterpreterContext;
import org.eclipse.damos.mscript.interpreter.IVariable;
import org.eclipse.damos.mscript.interpreter.InterpreterContext;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.xtext.util.StringInputStream;

public class MscriptLaunchConfigurationDelegate extends AbstractMscriptLaunchConfigurationDelegate {

	public static final String LAUNCH_CONFIGURATION_TYPE = "org.eclipse.damos.mscript.ide.core.mscriptApplication";

	public static final String ATTRIBUTE__INPUT_FILE_PATH = "inputFilePath";
	public static final String ATTRIBUTE__OUTPUT_FILE_PATH = "outputFilePath";

	private IFile inputFile;
	private IFile outputFile;

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.ide.core.launch.AbstractMscriptLaunchConfigurationDelegate#preLaunchCheck(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		
		String inputFilePathString = configuration.getAttribute(ATTRIBUTE__INPUT_FILE_PATH, "");
		if (inputFilePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No input file specified"));
		}

		String outputFilePathString = configuration.getAttribute(ATTRIBUTE__OUTPUT_FILE_PATH, "");
		if (outputFilePathString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "No output file specified"));
		}

		inputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(inputFilePathString));
		if (!inputFile.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Input file '"
					+ inputFile.getName() + "' does not exist"));
		}

		outputFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(outputFilePathString));

		prepareOutputFile(outputFile, monitor);

		return super.preLaunchCheck(configuration, mode, monitor);
	}

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		IInterpreterContext context = new InterpreterContext(getStaticEvaluationResult(), new ComputationContext(getComputationModel()), null);

		IFunctionObject functionObject = FunctionObject.create(context, getFunctionInstance());

		for (IVariable variable : functionObject.getVariables()) {
			context.addVariable(variable);
		}

		new MscriptProcess(launch, "Mscript Application").run(context, functionObject, inputFile, outputFile);
	}

	@Override
	protected List<Type> computeInputParameterDataTypes(ILaunchConfiguration configuration, String mode,
			IProgressMonitor monitor) throws CoreException {
		int n = getFunctionDefinition().getNonConstantInputParameterDeclarations().size();
		Type[] dataTypes = new Type[n];
		
		IInterpreterContext interpreterContext = new InterpreterContext(getStaticEvaluationResult(), new ComputationContext(getComputationModel()), null);
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputFile.getContents()));
			while (!monitor.isCanceled() && reader.ready()) {
				List<IValue> values = ParseUtil.parseValues(interpreterContext, reader.readLine());
				if (values == null) {
					throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Invalid values in '"
							+ inputFile.getName() + "'"));
				}
				if (values.size() != n) {
					throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID,
							"Number of columns in input file '" + inputFile.getName()
									+ "' does not correspond to number of input parameters"));
				}
				
				int i = 0;
				for (IValue value : values) {
					if (dataTypes[i] == null) {
						dataTypes[i] = value.getDataType();
					} else {
						dataTypes[i] = TypeUtil.getLeftHandDataType(dataTypes[i], value.getDataType());
						if (dataTypes[i] == null) {
							throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Incompatible values in '"
									+ inputFile.getName() + "'"));
						}
					}
					++i;
				}
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, IDECorePlugin.PLUGIN_ID, "Reading input file '"
					+ inputFile.getName() + "' failed", e));
		}
		
		return Arrays.asList(dataTypes);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.debug.core.model.LaunchConfigurationDelegate#buildForLaunch
	 * (org.eclipse.debug.core.ILaunchConfiguration, java.lang.String,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		return false;
	}

}
