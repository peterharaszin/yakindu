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

package org.eclipselabs.damos.simulation.ide.core.util;

import java.io.StringReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigFactory;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SelectionPropertyBody;
import org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SimplePropertyDeclaration;
import org.eclipselabs.damos.dconfig.util.PropertyEnumerationHelper;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.StaticExpressionEvaluator;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.InvalidValue;
import org.eclipselabs.damos.mscript.parser.antlr.MscriptParser;
import org.eclipselabs.damos.simulation.ide.core.SimulationIDECorePlugin;
import org.eclipselabs.damos.simulation.ide.core.internal.launch.SimulationLaunchConfigurationDelegate;

/**
 * @author Andreas Unger
 *
 */
public class LaunchConfigurationUtil {

	/**
	 * 
	 */
	private static final String PROPERTY__SIMULATION_TIME = "damos.simulation.simulationTime";
	
	public static void initializeLaunchConfiguration(ILaunchConfigurationWorkingCopy launchConfiguration, Fragment contextFragment) {
		launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__OVERRIDE_CONFIGURATION, true);
		if (contextFragment != null) {
			launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__FRAGMENT, EcoreUtil.getURI(contextFragment).toString());
		}
		launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, SimulationLaunchConfigurationDelegate.DEFAULT_SIMULATION_TIME);
		launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER, SimulationLaunchConfigurationDelegate.DEFAULT_SOLVER_ID);
		Map<String, String> solverConfiguration = new HashMap<String, String>();
		solverConfiguration.put("minimumStepSize", "1e-10(s)");
		solverConfiguration.put("absoluteTolerance", "1e-10");
		solverConfiguration.put("relativeTolerance", "1e-10");
		launchConfiguration.setAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER_CONFIGURATION, solverConfiguration);
	}

	public static Configuration createConfiguration(ILaunchConfiguration launchConfiguration, PropertyEnumerationHelper helper) throws CoreException {
		Configuration baseConfiguration = null;
		
		String baseConfigurationPath = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__BASE_CONFIGURATION_PATH, "").trim();
		if (baseConfigurationPath.length() > 0) {
			URI uri = URI.createPlatformResourceURI(baseConfigurationPath, true);
			try {
				Resource baseConfigurationResource = helper.getResourceSet().getResource(uri, true);
				baseConfiguration = (Configuration) EcoreUtil.getObjectByType(baseConfigurationResource.getContents(), DconfigPackage.eINSTANCE.getConfiguration());
			} catch (RuntimeException e) {
				// baseConfiguration will be null, thus throwing an exception later on
			}
			if (baseConfiguration == null) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid base configuration specified"));
			}
		}
		
		boolean overrideConfiguration = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__OVERRIDE_CONFIGURATION, true);
		if (!overrideConfiguration) {
			if (baseConfiguration == null) {
				throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "No simulation configuration specified"));
			}
			return baseConfiguration;
		}

		Configuration configuration = DconfigFactory.eINSTANCE.createConfiguration();
		configuration.setPackageName("__temp");
		configuration.setName("__temp");
		configuration.setBaseConfiguration(baseConfiguration);
		
		boolean realTimeSimulation = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__REAL_TIME_SIMULATION, false);
		if (realTimeSimulation) {
			createSimpleProperty(helper, configuration, PROPERTY__SIMULATION_TIME);
		} else {
			String simulationTime = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SIMULATION_TIME, "10(s)");
			if (simulationTime.trim().length() > 0) {
				SimpleProperty property = createSimpleProperty(helper, configuration, PROPERTY__SIMULATION_TIME);
				if (property != null) {
					setSimplePropertyValue(property, simulationTime);
				}
			}
		}
		
		String solverId = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER, "").trim();
		if (solverId.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "No simulation solver specified"));
		}
		
		PropertyDeclaration propertyDeclaration = helper.getPropertyDeclaration("damos.simulation.solver");
		if (propertyDeclaration == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Solver property not found"));
		}
		
		if (!(propertyDeclaration instanceof SelectionPropertyDeclaration)) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid solver property"));
		}
		
		SelectionPropertyDeclaration solverPropertyDeclaration = (SelectionPropertyDeclaration) propertyDeclaration;
		SelectionProperty solverProperty = DconfigFactory.eINSTANCE.createSelectionProperty();
		solverProperty.setDeclaration(solverPropertyDeclaration);

		SelectionPropertyOption solverPropertyOption = helper.getSelectionPropertyOption("damos.simulation.solver", solverId);
		if (solverPropertyOption == null) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid solver " + solverId));
		}
		
		solverProperty.setSelection(solverPropertyOption);
		
		Map<?, ?> solverConfiguration = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__SOLVER_CONFIGURATION, Collections.emptyMap());
		
		SelectionPropertyBody body = DconfigFactory.eINSTANCE.createSelectionPropertyBody();
		solverProperty.setBody(body);
		for (PropertyDeclaration optionPropertyDeclaration : solverPropertyOption.getPropertyDeclarations()) {
			if (optionPropertyDeclaration instanceof SimplePropertyDeclaration) {
				SimplePropertyDeclaration simplePropertyDeclaration = (SimplePropertyDeclaration) optionPropertyDeclaration;
				Object value = solverConfiguration.get(simplePropertyDeclaration.getName());
				if (value instanceof String) {
					SimpleProperty property = DconfigFactory.eINSTANCE.createSimpleProperty();
					property.setDeclaration(simplePropertyDeclaration);
					setSimplePropertyValue(property, value.toString());
					body.getProperties().add(property);
				}
			}
		}
		configuration.getProperties().add(solverProperty);
		
		String fragmentURIString = launchConfiguration.getAttribute(SimulationLaunchConfigurationDelegate.ATTRIBUTE__FRAGMENT, "").trim();
		if (fragmentURIString.length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "No fragment specified"));
		}

		EObject eObject = null;
		try {
			eObject = helper.getResourceSet().getEObject(URI.createURI(fragmentURIString), true);
		} catch (RuntimeException e) {
			// eObject will be null, thus throwing an exception later on
		}
		if (!(eObject instanceof Fragment)) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid fragment specified"));
		}
		
		RootSystemConfiguration rootSystemConfiguration = DconfigFactory.eINSTANCE.createRootSystemConfiguration();
		rootSystemConfiguration.setContextFragment((Fragment) eObject);
		configuration.setRootSystemConfiguration(rootSystemConfiguration);
		
		return configuration;
	}

	private static void setSimplePropertyValue(SimpleProperty property, String valueString) throws CoreException {
		MscriptParser parser = SimulationIDECorePlugin.getDefault().getMscriptParser();

		IParseResult result = parser.parse(parser.getGrammarAccess().getExpressionRule(), new StringReader(valueString));
		if (result.hasSyntaxErrors()) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Syntax error in " + NameUtil.formatName(property.getDeclaration().getName()) + " expression"));
		}
		
		Expression expression = (Expression) result.getRootASTElement();
		IStaticEvaluationContext context = new StaticEvaluationContext();
		IStatus status = new StaticExpressionEvaluator().evaluate(context, expression);
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid " + NameUtil.formatName(property.getDeclaration().getName()) + " expression"));
		}
		IValue value = context.getValue(expression);
		if (value instanceof InvalidValue) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid " + NameUtil.formatName(property.getDeclaration().getName()) + " expression"));
		}
		
		DataTypeSpecifier typeSpecifier = property.getDeclaration().getTypeSpecifier();
		if (typeSpecifier != null && typeSpecifier.getType() != null && !typeSpecifier.getType().isAssignableFrom(value.getDataType())) {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid " + NameUtil.formatName(property.getDeclaration().getName()) + " data type"));
		}
		
		property.setValue(expression);
	}

	private static SimpleProperty createSimpleProperty(PropertyEnumerationHelper helper, Configuration configuration, String qualifiedName) throws CoreException {
		SimpleProperty property = null;
		PropertyDeclaration propertyDeclaration = helper.getPropertyDeclaration(qualifiedName);
		if (propertyDeclaration instanceof SimplePropertyDeclaration) {
			SimplePropertyDeclaration simplePropertyDeclaration = (SimplePropertyDeclaration) propertyDeclaration;
			property = DconfigFactory.eINSTANCE.createSimpleProperty();
			property.setDeclaration(simplePropertyDeclaration);
			configuration.getProperties().add(property);
		} else {
			throw new CoreException(new Status(IStatus.ERROR, SimulationIDECorePlugin.PLUGIN_ID, "Invalid property " + qualifiedName));
		}
		return property;
	}

}
