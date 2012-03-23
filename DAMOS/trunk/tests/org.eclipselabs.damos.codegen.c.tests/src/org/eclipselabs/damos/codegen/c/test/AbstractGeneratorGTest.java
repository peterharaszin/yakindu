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

package org.eclipselabs.damos.codegen.c.test;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipselabs.damos.codegen.IGenerator;
import org.eclipselabs.damos.codegen.c.CodegenCModule;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigFactory;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SelectionPropertyBody;
import org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SimplePropertyDeclaration;
import org.eclipselabs.damos.dconfig.SystemConfigurationBody;
import org.eclipselabs.damos.dconfig.util.PropertyEnumerationHelper;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.ChoiceInput;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.JoinInput;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.LatchInput;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.MemoryInitialCondition;
import org.eclipselabs.damos.dml.MemoryOutput;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.dml.System;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.dml.WhileLoopCondition;
import org.eclipselabs.damos.dml.registry.BlockTypeRegistry;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipselabs.damos.dmltext.DMLTextFactory;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.util.DMLTextUtil;
import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.StringLiteral;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelFactory;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping;
import org.eclipselabs.damos.mscript.util.TypeUtil;

import com.google.inject.Guice;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractGeneratorGTest extends AbstractGTest {

	protected static final String CONSTANT = "damos.library.base.sources.Constant";
	protected static final String GAIN = "damos.library.base.math.Gain";
	protected static final String SUM = "damos.library.base.math.Sum";
	protected static final String AND = "damos.library.base.logic.And";
	protected static final String INVERTER = "damos.library.base.logic.Inverter";
	protected static final String COMPARE = "damos.library.base.logic.Compare";
	protected static final String COUNTER = "damos.library.base.discrete.Counter";
	protected static final String DISCRETE_INTEGRATOR = "damos.library.base.discrete.DiscreteIntegrator";
	
	protected ResourceSet resourceSet;
	protected Configuration configuration;
	protected System system;
	
	@Override
	protected void getSourceFiles(Collection<String> files) {
		super.getSourceFiles(files);
		files.add(getFileName(getTestProgram()) + ".c");
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

	protected Outport createOutport(String name, MscriptDataTypeSpecification dataTypeSpecification) {
		Outport outport = DMLFactory.eINSTANCE.createOutport();
		Input input = DMLFactory.eINSTANCE.createInput();
		input.getPorts().add(DMLFactory.eINSTANCE.createInputPort());
		outport.getInputs().add(input);
		outport.setName(name);
		outport.setDataType(dataTypeSpecification);
		system.getComponents().add(outport);
		return outport;
	}

	protected Inport createInport(String name, MscriptDataTypeSpecification dataTypeSpecification) {
		return createInport(name, dataTypeSpecification, -1);
	}
	
	protected Inport createInport(String name, MscriptDataTypeSpecification dataTypeSpecification, int sampleTime) {
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
		timingConstraint.setSampleTime(DMLTextUtil.createValueSpecification(sampleTime));
		component.setTimingConstraint(timingConstraint);
	}

	protected MscriptDataTypeSpecification createRealTypeSpecification() {
		MscriptDataTypeSpecification dataTypeSpecification = DMLTextFactory.eINSTANCE.createMscriptDataTypeSpecification();
		DataTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		dataTypeSpecifier.setDefinedType(TypeUtil.createRealType());
		dataTypeSpecification.setSpecifier(dataTypeSpecifier);
		DMLTextUtil.setText(dataTypeSpecification, "real");
		return dataTypeSpecification;
	}

	protected MscriptDataTypeSpecification createIntegerTypeSpecification() {
		MscriptDataTypeSpecification dataTypeSpecification = DMLTextFactory.eINSTANCE.createMscriptDataTypeSpecification();
		DataTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		dataTypeSpecifier.setDefinedType(TypeUtil.createIntegerType());
		dataTypeSpecification.setSpecifier(dataTypeSpecifier);
		DMLTextUtil.setText(dataTypeSpecification, "int");
		return dataTypeSpecification;
	}

	protected MscriptDataTypeSpecification createBooleanTypeSpecification() {
		MscriptDataTypeSpecification dataTypeSpecification = DMLTextFactory.eINSTANCE.createMscriptDataTypeSpecification();
		DataTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		dataTypeSpecifier.setDefinedType(MscriptFactory.eINSTANCE.createBooleanType());
		dataTypeSpecification.setSpecifier(dataTypeSpecifier);
		DMLTextUtil.setText(dataTypeSpecification, "boolean");
		return dataTypeSpecification;
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
		actionLink.setCondition(DMLTextUtil.createValueSpecification(condition));
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
		
		latch.setInitialValue(DMLTextUtil.createValueSpecification(initialValue));
		system.getComponents().add(latch);
		return latch;
	}

	protected void setArgument(Block block, String parameterName, long value) {
		block.getArgument(parameterName).setValue(DMLTextUtil.createValueSpecification(value));
	}

	protected void setArgument(Block block, String parameterName, double value) {
		block.getArgument(parameterName).setValue(DMLTextUtil.createValueSpecification(value));
	}

	protected void generate() {
		try {
			IGenerator generator = Guice.createInjector(new CodegenCModule()).getInstance(IGenerator.class);
			generator.generate(configuration, new NullProgressMonitor());
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	protected void createConfiguration() {
		createSystem();

		configuration = DconfigFactory.eINSTANCE.createConfiguration();
		Resource configurationResource = resourceSet.createResource(URI.createPlatformResourceURI(getFileName(getTestProgram()) + "dconfig.xmi", true));
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
		
		SelectionProperty generatorSelection = createSelectionProperty("damos.codegen.generator", "damos.codegen.c.DefaultGenerator");
		
		SimpleProperty projectProperty = DconfigFactory.eINSTANCE.createSimpleProperty();
		for (PropertyDeclaration declaration : generatorSelection.getSelection().getPropertyDeclarations()) {
			if (declaration instanceof SimplePropertyDeclaration) {
				SimplePropertyDeclaration simplePropertyDeclaration = (SimplePropertyDeclaration) declaration;
				if ("projectName".equals(simplePropertyDeclaration.getName())) {
					projectProperty.setDeclaration(simplePropertyDeclaration);
					break;
				}
			}
		}
		StringLiteral stringLiteral = MscriptFactory.eINSTANCE.createStringLiteral();
		stringLiteral.setValue(getTargetPath().toString());
		projectProperty.setValue(stringLiteral);
		
		generatorSelection.getBody().getProperties().add(projectProperty);
		configuration.getProperties().add(generatorSelection);
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

	/**
	 * @return
	 */
	private void createSystem() {
		String testProgramFileName = getFileName(getTestProgram());
		resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createPlatformResourceURI(testProgramFileName + ".blockdiagram", true));
		system = DMLFactory.eINSTANCE.createSystem();
		system.setQualifiedName(testProgramFileName);
		resource.getContents().add(system);
	}
	
	protected ComputationModel createSystemComputationModel() {
		return null;
	}
	
	protected void generateAndCompile() {
		generate();
		compile();
	}
	
	protected ComputationModel createSystemComputationModel(int integerLength, int fractionLength) {
		ComputationModel computationModel = ComputationModelFactory.eINSTANCE.createComputationModel();
		
		NumberFormatMapping realTypeMapping = ComputationModelFactory.eINSTANCE.createNumberFormatMapping();
		DataTypeSpecifier dataTypeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		dataTypeSpecifier.setDefinedType(TypeUtil.createRealType(MscriptFactory.eINSTANCE.createUnit()));
		realTypeMapping.setTypeSpecifier(dataTypeSpecifier);
		
		FixedPointFormat fixedPointFormat = ComputationModelFactory.eINSTANCE.createFixedPointFormat();
		fixedPointFormat.setIntegerLength(integerLength);
		fixedPointFormat.setFractionLength(fractionLength);
		realTypeMapping.setNumberFormat(fixedPointFormat);
		
		computationModel.getNumberFormatMappings().add(realTypeMapping);
		
		return computationModel;
	}

}
