/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.execution.test;

import java.io.StringReader;
import java.util.Arrays;

import org.eclipse.damos.dconfig.ComputationProperty;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dconfig.DconfigFactory;
import org.eclipse.damos.dconfig.PropertyDeclaration;
import org.eclipse.damos.dconfig.RootSystemConfiguration;
import org.eclipse.damos.dconfig.SelectionProperty;
import org.eclipse.damos.dconfig.SelectionPropertyBody;
import org.eclipse.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipse.damos.dconfig.SelectionPropertyOption;
import org.eclipse.damos.dconfig.SimpleProperty;
import org.eclipse.damos.dconfig.SimplePropertyDeclaration;
import org.eclipse.damos.dconfig.SystemConfigurationBody;
import org.eclipse.damos.dconfig.util.PropertyEnumerationHelper;
import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.ChoiceInput;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.Inport;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.JoinInput;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.LatchInput;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.MemoryInitialCondition;
import org.eclipse.damos.dml.MemoryOutput;
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.SynchronousTimingConstraint;
import org.eclipse.damos.dml.System;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.dml.WhileLoopCondition;
import org.eclipse.damos.dml.registry.BlockTypeRegistry;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.damos.dscript.DscriptDataTypeSpecification;
import org.eclipse.damos.dscript.DscriptFactory;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.dscript.util.DscriptUtil;
import org.eclipse.damos.execution.ExecutionTestsPlugin;
import org.eclipse.damos.mscript.AnonymousTypeSpecifier;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.MscriptRuntimeModule;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.TypeSpecifier;
import org.eclipse.damos.mscript.computation.ComputationFactory;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormatMapping;
import org.eclipse.damos.mscript.services.MscriptGrammarAccess;
import org.eclipse.damos.mscript.util.TypeUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExecutionTest {

	protected static final String CONSTANT = "damos.blocks.Constant";
	protected static final String GAIN = "damos.blocks.Gain";
	protected static final String SUM = "damos.blocks.Sum";
	protected static final String AND = "damos.blocks.And";
	protected static final String INVERTER = "damos.blocks.Inverter";
	protected static final String COMPARE = "damos.blocks.Compare";
	protected static final String COUNTER = "damos.blocks.Counter";
	protected static final String DISCRETE_INTEGRATOR = "damos.blocks.DiscreteIntegrator";
	
	@Inject
	private IParser parser;
	
	@Inject
	private MscriptGrammarAccess grammarAccess;

	protected ResourceSet resourceSet;
	protected Configuration configuration;
	protected System system;
	
	@Before
	public void setUp() {
		setUpInjector();
		createConfiguration();
	}
	
	protected void setUpInjector() {
		Injector injector = Guice.createInjector(new MscriptRuntimeModule());
		injector.injectMembers(this);
	}

	protected void connect(Component source, Component target) {
		connect(source, 0, target, 0);
	}

	protected void connect(Component source, int sourcePortIndex, Component target) {
		connect(source, sourcePortIndex, target, 0);
	}
	
	protected void connect(Component source, Component target, int targetPortIndex) {
		connect(source, 0, target, targetPortIndex);
	}

	protected void connect(Component source, int sourcePortIndex, Component target, int targetPortIndex) {
		Connection connection = DMLFactory.eINSTANCE.createConnection();
		system.getConnections().add(connection);
		connection.setSource(source.getOutputPorts().get(sourcePortIndex));
		connection.setTarget(target.getInputPorts().get(targetPortIndex));
	}

	protected void connect(Component source, InputConnector target) {
		connect(source, 0, target);
	}
	
	protected void connect(Component source, int sourcePortIndex, InputConnector target) {
		Connection connection = DMLFactory.eINSTANCE.createConnection();
		system.getConnections().add(connection);
		connection.setSource(source.getOutputPorts().get(sourcePortIndex));
		connection.setTarget(target);
	}

	protected Outport createOutport(String name, DscriptDataTypeSpecification dataTypeSpecification) {
		Outport outport = DMLFactory.eINSTANCE.createOutport();
		Input input = DMLFactory.eINSTANCE.createInput();
		input.getPorts().add(DMLFactory.eINSTANCE.createInputPort());
		outport.getInputs().add(input);
		outport.setName(name);
		outport.setDataType(dataTypeSpecification);
		system.getComponents().add(outport);
		return outport;
	}

	protected Inport createInport(String name, DscriptDataTypeSpecification dataTypeSpecification) {
		return createInport(name, dataTypeSpecification, -1);
	}
	
	protected Inport createInport(String name, DscriptDataTypeSpecification dataTypeSpecification, int sampleTime) {
		Inport inport = DMLFactory.eINSTANCE.createInport();
		Output output = DMLFactory.eINSTANCE.createOutput();
		output.getPorts().add(DMLFactory.eINSTANCE.createOutputPort());
		inport.getOutputs().add(output);
		inport.setName(name);
		inport.setDataType(dataTypeSpecification);
		if (sampleTime != -1) {
			setSynchronousTimingConstraint(inport, sampleTime);
		}
		system.getComponents().add(inport);
		return inport;
	}
	
	protected void setSynchronousTimingConstraint(Component component, double sampleTime) {
		SynchronousTimingConstraint timingConstraint = DMLFactory.eINSTANCE.createSynchronousTimingConstraint();
		timingConstraint.setSampleTime(DscriptUtil.createValueSpecification(sampleTime));
		component.setTimingConstraint(timingConstraint);
	}
	
	protected DscriptDataTypeSpecification createDataTypeSpecification(String dataType) {
		DscriptDataTypeSpecification dataTypeSpecification = DscriptFactory.eINSTANCE.createDscriptDataTypeSpecification();
		dataTypeSpecification.setTypeSpecifier(parseDataTypeSpecifier(dataType));
		return dataTypeSpecification;
	}

	protected DscriptDataTypeSpecification createRealTypeSpecification() {
		DscriptDataTypeSpecification dataTypeSpecification = DscriptFactory.eINSTANCE.createDscriptDataTypeSpecification();
		AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
		dataTypeSpecifier.setType(TypeUtil.createRealType());
		dataTypeSpecification.setTypeSpecifier(dataTypeSpecifier);
		DscriptUtil.setText(dataTypeSpecification, "real");
		return dataTypeSpecification;
	}

	protected DscriptDataTypeSpecification createIntegerTypeSpecification() {
		DscriptDataTypeSpecification dataTypeSpecification = DscriptFactory.eINSTANCE.createDscriptDataTypeSpecification();
		AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
		dataTypeSpecifier.setType(TypeUtil.createIntegerType());
		dataTypeSpecification.setTypeSpecifier(dataTypeSpecifier);
		DscriptUtil.setText(dataTypeSpecification, "int");
		return dataTypeSpecification;
	}

	protected DscriptDataTypeSpecification createBooleanTypeSpecification() {
		DscriptDataTypeSpecification dataTypeSpecification = DscriptFactory.eINSTANCE.createDscriptDataTypeSpecification();
		AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
		dataTypeSpecifier.setType(MscriptFactory.eINSTANCE.createBooleanType());
		dataTypeSpecification.setTypeSpecifier(dataTypeSpecifier);
		DscriptUtil.setText(dataTypeSpecification, "boolean");
		return dataTypeSpecification;
	}

	protected DscriptDataTypeSpecification createArrayTypeSpecification(Type elementType, int... sizes) {
		DscriptDataTypeSpecification dataTypeSpecification = DscriptFactory.eINSTANCE.createDscriptDataTypeSpecification();
		AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
		dataTypeSpecifier.setType(TypeUtil.createArrayType(elementType, sizes));
		dataTypeSpecification.setTypeSpecifier(dataTypeSpecifier);
		return dataTypeSpecification;
	}

	protected Block createTestBlock(String blockTypeName, String name) {
		BlockType blockType = loadBlockType(blockTypeName, ExecutionTestsPlugin.PLUGIN_ID);
		Block block = blockType.newInstance(name);
		system.getComponents().add(block);
		return block;
	}

	protected Block createTestBlock(String blockTypeName, String pluginId, String name) {
		BlockType blockType = loadBlockType(blockTypeName, pluginId);
		Block block = blockType.newInstance(name);
		system.getComponents().add(block);
		return block;
	}

	protected Block createBlock(String blockTypeQualifiedName, String name) {
		IBlockTypeDescriptor blockTypeDescriptor = BlockTypeRegistry.getInstance().getBlockType(blockTypeQualifiedName);
		BlockType blockType = (BlockType) resourceSet.getEObject(blockTypeDescriptor.getURI(), true);
		Block block = blockType.newInstance(name);
		system.getComponents().add(block);
		return block;
	}
	
	protected WhileLoop createWhileLoop(Component... members) {
		WhileLoop whileLoop = DMLFactory.eINSTANCE.createWhileLoop();
		WhileLoopCondition condition = DMLFactory.eINSTANCE.createWhileLoopCondition();
		whileLoop.setCondition(condition);
		whileLoop.getMembers().addAll(Arrays.asList(members));
		system.getFragmentElements().add(whileLoop);
		return whileLoop;
	}
	
	protected Action createAction(Component... members) {
		Action action = DMLFactory.eINSTANCE.createAction();
		action.getMembers().addAll(Arrays.asList(members));
		system.getFragmentElements().add(action);
		return action;
	}
	
	protected Choice createChoice(String name) {
		Choice choice = DMLFactory.eINSTANCE.createChoice();
		choice.setName(name);
		ChoiceInput input = DMLFactory.eINSTANCE.createChoiceInput();
		input.getPorts().add(DMLFactory.eINSTANCE.createChoiceInputPort());
		choice.getInputs().add(input);
		system.getComponents().add(choice);
		return choice;
	}
	
	protected ActionLink createActionLink(Choice choice, Action action, boolean condition) {
		ActionLink actionLink = DMLFactory.eINSTANCE.createActionLink();
		actionLink.setChoice(choice);
		actionLink.setAction(action);
		actionLink.setCondition(DscriptUtil.createValueSpecification(condition));
		return actionLink;
	}
	
	protected Join createJoin(String name, int inputPortCount) {
		Join join = DMLFactory.eINSTANCE.createJoin();
		join.setName(name);
		JoinInput input = DMLFactory.eINSTANCE.createJoinInput();
		join.getInputs().add(input);
		for (int i = 0; i < inputPortCount; ++i) {
			input.createPort();
		}
		Output output = DMLFactory.eINSTANCE.createOutput();
		output.getPorts().add(DMLFactory.eINSTANCE.createOutputPort());
		join.getOutputs().add(output);
		system.getComponents().add(join);
		return join;
	}

	protected Memory createMemory(String name) {
		Memory memory = DMLFactory.eINSTANCE.createMemory();
		memory.setName(name);
		
		MemoryInitialCondition initialCondition = DMLFactory.eINSTANCE.createMemoryInitialCondition();
		initialCondition.createPort();
		memory.getInputs().add(initialCondition);
		
		Input input = DMLFactory.eINSTANCE.createMemoryInput();
		input.getPorts().add(DMLFactory.eINSTANCE.createInputPort());
		memory.getInputs().add(input);

		MemoryOutput output = DMLFactory.eINSTANCE.createMemoryOutput();
		output.createPort();
		memory.getOutputs().add(output);
		system.getComponents().add(memory);
		return memory;
	}
	
	protected Latch createLatch(String name, long initialValue) {
		Latch latch = DMLFactory.eINSTANCE.createLatch();
		latch.setName(name);
		
		LatchInput input = DMLFactory.eINSTANCE.createLatchInput();
		input.createPort();
		latch.getInputs().add(input);
		
		Output output = DMLFactory.eINSTANCE.createOutput();
		output.createPort();
		latch.getOutputs().add(output);
		
		latch.setInitialValue(DscriptUtil.createValueSpecification(initialValue));
		system.getComponents().add(latch);
		return latch;
	}

	protected void setArgument(Block block, String parameterName, long value) {
		block.getArgument(parameterName).setValue(DscriptUtil.createValueSpecification(value));
	}

	protected void setArgument(Block block, String parameterName, double value) {
		block.getArgument(parameterName).setValue(DscriptUtil.createValueSpecification(value));
	}

	protected void setArgument(Block block, String parameterName, boolean value) {
		block.getArgument(parameterName).setValue(DscriptUtil.createValueSpecification(value));
	}

	protected void setArgument(Block block, String parameterName, String expressionString) {
		DscriptValueSpecification valueSpecification = DscriptFactory.eINSTANCE.createDscriptValueSpecification();
		valueSpecification.setExpression(parseExpression(expressionString));
		DscriptUtil.setText(valueSpecification, expressionString);
		block.getArgument(parameterName).setValue(valueSpecification);
	}

	protected void createConfiguration() {
		createSystem();

		configuration = DconfigFactory.eINSTANCE.createConfiguration();
		Resource configurationResource = resourceSet.createResource(URI.createPlatformResourceURI(getTestPath() + ".dconfig.xmi", true));
		configurationResource.getContents().add(configuration);
		configuration.setName("GenerateTestModel");
		RootSystemConfiguration rootSystemConfiguration = DconfigFactory.eINSTANCE.createRootSystemConfiguration();
		rootSystemConfiguration.setContextFragment(system);
		
		SystemConfigurationBody body = DconfigFactory.eINSTANCE.createSystemConfigurationBody();
		rootSystemConfiguration.setBody(body);

		ComputationModel computationModel = createSystemComputationModel();
		if (computationModel != null) {
			ComputationProperty computationProperty = DconfigFactory.eINSTANCE.createComputationProperty();
			computationProperty.setComputationModel(computationModel);
			body.getProperties().add(computationProperty);
		}
		
		configuration.setRootSystemConfiguration(rootSystemConfiguration);
	}

	protected SimpleProperty createSimpleProperty(String propertyId, String expressionString) {
		SimpleProperty property = DconfigFactory.eINSTANCE.createSimpleProperty();
		PropertyEnumerationHelper helper = new PropertyEnumerationHelper(resourceSet, propertyId);
		SimplePropertyDeclaration propertyDeclaration = (SimplePropertyDeclaration) helper.getPropertyDeclaration(propertyId);
		property.setDeclaration(propertyDeclaration);
		property.setValue(parseExpression(expressionString));
		return property;
	}

	protected SelectionProperty createSelectionProperty(String propertyId, String optionName) {
		SelectionProperty property = DconfigFactory.eINSTANCE.createSelectionProperty();
		PropertyEnumerationHelper helper = new PropertyEnumerationHelper(resourceSet, propertyId);
		SelectionPropertyDeclaration propertyDeclaration = (SelectionPropertyDeclaration) helper.getPropertyDeclaration(propertyId);
		property.setDeclaration(propertyDeclaration);
		SelectionPropertyOption option = helper.getSelectionPropertyOption(propertyId, optionName);
		property.setSelection(option);
		SelectionPropertyBody body = DconfigFactory.eINSTANCE.createSelectionPropertyBody();
		property.setBody(body);
		return property;
	}

	protected SimpleProperty createSimpleProperty(SelectionProperty generatorSelection, String propertyId, Expression value) {
		SimpleProperty projectProperty = DconfigFactory.eINSTANCE.createSimpleProperty();
		for (PropertyDeclaration declaration : generatorSelection.getSelection().getPropertyDeclarations()) {
			if (declaration instanceof SimplePropertyDeclaration) {
				SimplePropertyDeclaration simplePropertyDeclaration = (SimplePropertyDeclaration) declaration;
				if (propertyId.equals(simplePropertyDeclaration.getName())) {
					projectProperty.setDeclaration(simplePropertyDeclaration);
					break;
				}
			}
		}
		projectProperty.setValue(value);
		return projectProperty;
	}

	protected SimpleProperty createSimpleProperty(SelectionProperty generatorSelection, String propertyId, String valueExpressionString) {
		return createSimpleProperty(generatorSelection, propertyId, parseExpression(valueExpressionString));
	}

	private void createSystem() {
		resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(getTestPath() + ".blockdiagram", true));
		system = DMLFactory.eINSTANCE.createSystem();
		system.setQualifiedName(getTestQualifiedName());
		resource.getContents().add(system);
	}
	
	protected String getTestQualifiedName() {
		return getClass().getSimpleName();
	}
	
	protected String getTestPath() {
		return getTestQualifiedName();
	}
	
	protected ComputationModel createSystemComputationModel() {
		return null;
	}
	
	protected ComputationModel createSystemComputationModel(int integerLength, int fractionLength) {
		ComputationModel computationModel = ComputationFactory.eINSTANCE.createComputationModel();
		
		NumberFormatMapping realTypeMapping = ComputationFactory.eINSTANCE.createNumberFormatMapping();
		AnonymousTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
		dataTypeSpecifier.setType(TypeUtil.createRealType(MscriptFactory.eINSTANCE.createUnit()));
		realTypeMapping.setTypeSpecifier(dataTypeSpecifier);
		
		FixedPointFormat fixedPointFormat = ComputationFactory.eINSTANCE.createFixedPointFormat();
		fixedPointFormat.setIntegerLength(integerLength);
		fixedPointFormat.setFractionLength(fractionLength);
		realTypeMapping.setNumberFormat(fixedPointFormat);
		
		computationModel.getNumberFormatMappings().add(realTypeMapping);
		
		return computationModel;
	}
	
	protected BlockType loadBlockType(String name, String pluginId) {
		String pathName = "/" + pluginId + "/blocktypes/" + name + ".blocktype";
		return (BlockType) resourceSet.getEObject(URI.createPlatformPluginURI(pathName, true).appendFragment("/"), true);
	}

	protected Expression parseExpression(String expressionString) {
		IParseResult result = parser.parse(grammarAccess.getExpressionRule(), new StringReader(expressionString));
		if (result.hasSyntaxErrors()) {
			throw new RuntimeException("Syntax errors in '" + expressionString + "'");
		}
		return (Expression) result.getRootASTElement();
	}

	protected TypeSpecifier parseDataTypeSpecifier(String dataTypeString) {
		IParseResult result = parser.parse(grammarAccess.getTypeSpecifierRule(), new StringReader(dataTypeString));
		if (result.hasSyntaxErrors()) {
			throw new RuntimeException("Syntax errors in '" + dataTypeString + "'");
		}
		return (TypeSpecifier) result.getRootASTElement();
	}

}
