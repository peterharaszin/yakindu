/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.util;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.AsynchronousTimingConstraint;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInoutput;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.BlockPort;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.CategorizedElement;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.ChoiceInput;
import org.eclipselabs.damos.dml.ChoiceInputPort;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.CompoundConnector;
import org.eclipselabs.damos.dml.CompoundInputConnector;
import org.eclipselabs.damos.dml.CompoundMember;
import org.eclipselabs.damos.dml.CompoundOutputConnector;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.ContinuousTimingConstraint;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.DirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.INamedElement;
import org.eclipselabs.damos.dml.ITextualElement;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inoutput;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.InportInput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.JoinInput;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.LatchInput;
import org.eclipselabs.damos.dml.LiteralValueSpecification;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.MemoryInitialCondition;
import org.eclipselabs.damos.dml.MemoryInput;
import org.eclipselabs.damos.dml.MemoryOutput;
import org.eclipselabs.damos.dml.Model;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.OutportOutput;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterPredefinedValue;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.PrimitiveTypeSpecification;
import org.eclipselabs.damos.dml.QualifiedElement;
import org.eclipselabs.damos.dml.SignalSpecification;
import org.eclipselabs.damos.dml.StringValueSpecification;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInoutput;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.TimingConstraint;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.dml.WhileLoopCondition;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dml.DMLPackage
 * @generated
 */
public class DMLSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DMLPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLSwitch() {
		if (modelPackage == null) {
			modelPackage = DMLPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DMLPackage.FRAGMENT: {
				Fragment fragment = (Fragment)theEObject;
				T result = caseFragment(fragment);
				if (result == null) result = caseEModelElement(fragment);
				if (result == null) result = caseQualifiedElement(fragment);
				if (result == null) result = caseINamedElement(fragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseFragmentElement(component);
				if (result == null) result = caseCompoundMember(component);
				if (result == null) result = caseINamedElement(component);
				if (result == null) result = caseEModelElement(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.TIMING_CONSTRAINT: {
				TimingConstraint timingConstraint = (TimingConstraint)theEObject;
				T result = caseTimingConstraint(timingConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CONTINUOUS_TIMING_CONSTRAINT: {
				ContinuousTimingConstraint continuousTimingConstraint = (ContinuousTimingConstraint)theEObject;
				T result = caseContinuousTimingConstraint(continuousTimingConstraint);
				if (result == null) result = caseTimingConstraint(continuousTimingConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT: {
				SynchronousTimingConstraint synchronousTimingConstraint = (SynchronousTimingConstraint)theEObject;
				T result = caseSynchronousTimingConstraint(synchronousTimingConstraint);
				if (result == null) result = caseTimingConstraint(synchronousTimingConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.ASYNCHRONOUS_TIMING_CONSTRAINT: {
				AsynchronousTimingConstraint asynchronousTimingConstraint = (AsynchronousTimingConstraint)theEObject;
				T result = caseAsynchronousTimingConstraint(asynchronousTimingConstraint);
				if (result == null) result = caseTimingConstraint(asynchronousTimingConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.FRAGMENT_ELEMENT: {
				FragmentElement fragmentElement = (FragmentElement)theEObject;
				T result = caseFragmentElement(fragmentElement);
				if (result == null) result = caseEModelElement(fragmentElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = caseFragmentElement(connection);
				if (result == null) result = caseEModelElement(connection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CONNECTOR: {
				Connector connector = (Connector)theEObject;
				T result = caseConnector(connector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPUT_CONNECTOR: {
				InputConnector inputConnector = (InputConnector)theEObject;
				T result = caseInputConnector(inputConnector);
				if (result == null) result = caseConnector(inputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPUT_CONNECTOR: {
				OutputConnector outputConnector = (OutputConnector)theEObject;
				T result = caseOutputConnector(outputConnector);
				if (result == null) result = caseConnector(outputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INOUTPUT: {
				Inoutput inoutput = (Inoutput)theEObject;
				T result = caseInoutput(inoutput);
				if (result == null) result = caseINamedElement(inoutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPUT: {
				Input input = (Input)theEObject;
				T result = caseInput(input);
				if (result == null) result = caseInoutput(input);
				if (result == null) result = caseINamedElement(input);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = caseInoutput(output);
				if (result == null) result = caseINamedElement(output);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseConnector(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPUT_PORT: {
				InputPort inputPort = (InputPort)theEObject;
				T result = caseInputPort(inputPort);
				if (result == null) result = casePort(inputPort);
				if (result == null) result = caseInputConnector(inputPort);
				if (result == null) result = caseConnector(inputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPUT_PORT: {
				OutputPort outputPort = (OutputPort)theEObject;
				T result = caseOutputPort(outputPort);
				if (result == null) result = casePort(outputPort);
				if (result == null) result = caseOutputConnector(outputPort);
				if (result == null) result = caseConnector(outputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SIGNAL_SPECIFICATION: {
				SignalSpecification signalSpecification = (SignalSpecification)theEObject;
				T result = caseSignalSpecification(signalSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_INOUTPUT: {
				BlockInoutput blockInoutput = (BlockInoutput)theEObject;
				T result = caseBlockInoutput(blockInoutput);
				if (result == null) result = caseInoutput(blockInoutput);
				if (result == null) result = caseINamedElement(blockInoutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_INPUT: {
				BlockInput blockInput = (BlockInput)theEObject;
				T result = caseBlockInput(blockInput);
				if (result == null) result = caseInput(blockInput);
				if (result == null) result = caseBlockInoutput(blockInput);
				if (result == null) result = caseInoutput(blockInput);
				if (result == null) result = caseINamedElement(blockInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_OUTPUT: {
				BlockOutput blockOutput = (BlockOutput)theEObject;
				T result = caseBlockOutput(blockOutput);
				if (result == null) result = caseOutput(blockOutput);
				if (result == null) result = caseBlockInoutput(blockOutput);
				if (result == null) result = caseInoutput(blockOutput);
				if (result == null) result = caseINamedElement(blockOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INOUTPUT_DEFINITION: {
				InoutputDefinition inoutputDefinition = (InoutputDefinition)theEObject;
				T result = caseInoutputDefinition(inoutputDefinition);
				if (result == null) result = caseParameterableElement(inoutputDefinition);
				if (result == null) result = caseINamedElement(inoutputDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPUT_DEFINITION: {
				InputDefinition inputDefinition = (InputDefinition)theEObject;
				T result = caseInputDefinition(inputDefinition);
				if (result == null) result = caseInoutputDefinition(inputDefinition);
				if (result == null) result = caseParameterableElement(inputDefinition);
				if (result == null) result = caseINamedElement(inputDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPUT_DEFINITION: {
				OutputDefinition outputDefinition = (OutputDefinition)theEObject;
				T result = caseOutputDefinition(outputDefinition);
				if (result == null) result = caseInoutputDefinition(outputDefinition);
				if (result == null) result = caseParameterableElement(outputDefinition);
				if (result == null) result = caseINamedElement(outputDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.PARAMETERABLE_ELEMENT: {
				ParameterableElement parameterableElement = (ParameterableElement)theEObject;
				T result = caseParameterableElement(parameterableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseINamedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.PARAMETER_PREDEFINED_VALUE: {
				ParameterPredefinedValue parameterPredefinedValue = (ParameterPredefinedValue)theEObject;
				T result = caseParameterPredefinedValue(parameterPredefinedValue);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.VALUE_SPECIFICATION: {
				ValueSpecification valueSpecification = (ValueSpecification)theEObject;
				T result = caseValueSpecification(valueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.LITERAL_VALUE_SPECIFICATION: {
				LiteralValueSpecification literalValueSpecification = (LiteralValueSpecification)theEObject;
				T result = caseLiteralValueSpecification(literalValueSpecification);
				if (result == null) result = caseValueSpecification(literalValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.STRING_VALUE_SPECIFICATION: {
				StringValueSpecification stringValueSpecification = (StringValueSpecification)theEObject;
				T result = caseStringValueSpecification(stringValueSpecification);
				if (result == null) result = caseLiteralValueSpecification(stringValueSpecification);
				if (result == null) result = caseValueSpecification(stringValueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.DATA_TYPE_SPECIFICATION: {
				DataTypeSpecification dataTypeSpecification = (DataTypeSpecification)theEObject;
				T result = caseDataTypeSpecification(dataTypeSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.PRIMITIVE_TYPE_SPECIFICATION: {
				PrimitiveTypeSpecification primitiveTypeSpecification = (PrimitiveTypeSpecification)theEObject;
				T result = casePrimitiveTypeSpecification(primitiveTypeSpecification);
				if (result == null) result = caseDataTypeSpecification(primitiveTypeSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY: {
				DirectFeedthroughPolicy directFeedthroughPolicy = (DirectFeedthroughPolicy)theEObject;
				T result = caseDirectFeedthroughPolicy(directFeedthroughPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.PARAMETERIZED_ELEMENT: {
				ParameterizedElement parameterizedElement = (ParameterizedElement)theEObject;
				T result = caseParameterizedElement(parameterizedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.ARGUMENT: {
				Argument argument = (Argument)theEObject;
				T result = caseArgument(argument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_TYPE: {
				BlockType blockType = (BlockType)theEObject;
				T result = caseBlockType(blockType);
				if (result == null) result = caseEModelElement(blockType);
				if (result == null) result = caseQualifiedElement(blockType);
				if (result == null) result = caseCategorizedElement(blockType);
				if (result == null) result = caseParameterableElement(blockType);
				if (result == null) result = caseINamedElement(blockType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.QUALIFIED_ELEMENT: {
				QualifiedElement qualifiedElement = (QualifiedElement)theEObject;
				T result = caseQualifiedElement(qualifiedElement);
				if (result == null) result = caseINamedElement(qualifiedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CATEGORIZED_ELEMENT: {
				CategorizedElement categorizedElement = (CategorizedElement)theEObject;
				T result = caseCategorizedElement(categorizedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CATEGORY: {
				Category category = (Category)theEObject;
				T result = caseCategory(category);
				if (result == null) result = caseQualifiedElement(category);
				if (result == null) result = caseCategorizedElement(category);
				if (result == null) result = caseParameterableElement(category);
				if (result == null) result = caseINamedElement(category);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseComponent(block);
				if (result == null) result = caseParameterizedElement(block);
				if (result == null) result = caseFragmentElement(block);
				if (result == null) result = caseCompoundMember(block);
				if (result == null) result = caseINamedElement(block);
				if (result == null) result = caseEModelElement(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = caseSystem(model);
				if (result == null) result = caseFragment(model);
				if (result == null) result = caseEModelElement(model);
				if (result == null) result = caseQualifiedElement(model);
				if (result == null) result = caseINamedElement(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SYSTEM: {
				org.eclipselabs.damos.dml.System system = (org.eclipselabs.damos.dml.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = caseFragment(system);
				if (result == null) result = caseEModelElement(system);
				if (result == null) result = caseQualifiedElement(system);
				if (result == null) result = caseINamedElement(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_PORT: {
				BlockPort blockPort = (BlockPort)theEObject;
				T result = caseBlockPort(blockPort);
				if (result == null) result = caseParameterizedElement(blockPort);
				if (result == null) result = casePort(blockPort);
				if (result == null) result = caseConnector(blockPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_INPUT_PORT: {
				BlockInputPort blockInputPort = (BlockInputPort)theEObject;
				T result = caseBlockInputPort(blockInputPort);
				if (result == null) result = caseBlockPort(blockInputPort);
				if (result == null) result = caseInputPort(blockInputPort);
				if (result == null) result = caseParameterizedElement(blockInputPort);
				if (result == null) result = casePort(blockInputPort);
				if (result == null) result = caseInputConnector(blockInputPort);
				if (result == null) result = caseConnector(blockInputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_OUTPUT_PORT: {
				BlockOutputPort blockOutputPort = (BlockOutputPort)theEObject;
				T result = caseBlockOutputPort(blockOutputPort);
				if (result == null) result = caseOutputPort(blockOutputPort);
				if (result == null) result = caseBlockPort(blockOutputPort);
				if (result == null) result = casePort(blockOutputPort);
				if (result == null) result = caseOutputConnector(blockOutputPort);
				if (result == null) result = caseParameterizedElement(blockOutputPort);
				if (result == null) result = caseConnector(blockOutputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM: {
				Subsystem subsystem = (Subsystem)theEObject;
				T result = caseSubsystem(subsystem);
				if (result == null) result = caseComponent(subsystem);
				if (result == null) result = caseFragmentElement(subsystem);
				if (result == null) result = caseCompoundMember(subsystem);
				if (result == null) result = caseINamedElement(subsystem);
				if (result == null) result = caseEModelElement(subsystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SYSTEM_INTERFACE: {
				SystemInterface systemInterface = (SystemInterface)theEObject;
				T result = caseSystemInterface(systemInterface);
				if (result == null) result = caseQualifiedElement(systemInterface);
				if (result == null) result = caseINamedElement(systemInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INLET: {
				Inlet inlet = (Inlet)theEObject;
				T result = caseInlet(inlet);
				if (result == null) result = caseInoutlet(inlet);
				if (result == null) result = caseINamedElement(inlet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INOUTLET: {
				Inoutlet inoutlet = (Inoutlet)theEObject;
				T result = caseInoutlet(inoutlet);
				if (result == null) result = caseINamedElement(inoutlet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTLET: {
				Outlet outlet = (Outlet)theEObject;
				T result = caseOutlet(outlet);
				if (result == null) result = caseInoutlet(outlet);
				if (result == null) result = caseINamedElement(outlet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_REALIZATION: {
				SubsystemRealization subsystemRealization = (SubsystemRealization)theEObject;
				T result = caseSubsystemRealization(subsystemRealization);
				if (result == null) result = caseFragmentElement(subsystemRealization);
				if (result == null) result = caseEModelElement(subsystemRealization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPORT: {
				Inport inport = (Inport)theEObject;
				T result = caseInport(inport);
				if (result == null) result = caseInoutport(inport);
				if (result == null) result = caseComponent(inport);
				if (result == null) result = caseFragmentElement(inport);
				if (result == null) result = caseCompoundMember(inport);
				if (result == null) result = caseINamedElement(inport);
				if (result == null) result = caseEModelElement(inport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPORT_INPUT: {
				InportInput inportInput = (InportInput)theEObject;
				T result = caseInportInput(inportInput);
				if (result == null) result = caseInput(inportInput);
				if (result == null) result = caseInoutput(inportInput);
				if (result == null) result = caseINamedElement(inportInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INOUTPORT: {
				Inoutport inoutport = (Inoutport)theEObject;
				T result = caseInoutport(inoutport);
				if (result == null) result = caseComponent(inoutport);
				if (result == null) result = caseFragmentElement(inoutport);
				if (result == null) result = caseCompoundMember(inoutport);
				if (result == null) result = caseINamedElement(inoutport);
				if (result == null) result = caseEModelElement(inoutport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPORT: {
				Outport outport = (Outport)theEObject;
				T result = caseOutport(outport);
				if (result == null) result = caseInoutport(outport);
				if (result == null) result = caseComponent(outport);
				if (result == null) result = caseFragmentElement(outport);
				if (result == null) result = caseCompoundMember(outport);
				if (result == null) result = caseINamedElement(outport);
				if (result == null) result = caseEModelElement(outport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPORT_OUTPUT: {
				OutportOutput outportOutput = (OutportOutput)theEObject;
				T result = caseOutportOutput(outportOutput);
				if (result == null) result = caseOutput(outportOutput);
				if (result == null) result = caseInoutput(outportOutput);
				if (result == null) result = caseINamedElement(outportOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_INOUTPUT: {
				SubsystemInoutput subsystemInoutput = (SubsystemInoutput)theEObject;
				T result = caseSubsystemInoutput(subsystemInoutput);
				if (result == null) result = caseInoutput(subsystemInoutput);
				if (result == null) result = caseINamedElement(subsystemInoutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_INPUT: {
				SubsystemInput subsystemInput = (SubsystemInput)theEObject;
				T result = caseSubsystemInput(subsystemInput);
				if (result == null) result = caseInput(subsystemInput);
				if (result == null) result = caseSubsystemInoutput(subsystemInput);
				if (result == null) result = caseInoutput(subsystemInput);
				if (result == null) result = caseINamedElement(subsystemInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_OUTPUT: {
				SubsystemOutput subsystemOutput = (SubsystemOutput)theEObject;
				T result = caseSubsystemOutput(subsystemOutput);
				if (result == null) result = caseOutput(subsystemOutput);
				if (result == null) result = caseSubsystemInoutput(subsystemOutput);
				if (result == null) result = caseInoutput(subsystemOutput);
				if (result == null) result = caseINamedElement(subsystemOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY: {
				BooleanDirectFeedthroughPolicy booleanDirectFeedthroughPolicy = (BooleanDirectFeedthroughPolicy)theEObject;
				T result = caseBooleanDirectFeedthroughPolicy(booleanDirectFeedthroughPolicy);
				if (result == null) result = caseDirectFeedthroughPolicy(booleanDirectFeedthroughPolicy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.LATCH: {
				Latch latch = (Latch)theEObject;
				T result = caseLatch(latch);
				if (result == null) result = caseComponent(latch);
				if (result == null) result = caseFragmentElement(latch);
				if (result == null) result = caseCompoundMember(latch);
				if (result == null) result = caseINamedElement(latch);
				if (result == null) result = caseEModelElement(latch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.LATCH_INPUT: {
				LatchInput latchInput = (LatchInput)theEObject;
				T result = caseLatchInput(latchInput);
				if (result == null) result = caseInput(latchInput);
				if (result == null) result = caseInoutput(latchInput);
				if (result == null) result = caseINamedElement(latchInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPOUND: {
				Compound compound = (Compound)theEObject;
				T result = caseCompound(compound);
				if (result == null) result = caseFragmentElement(compound);
				if (result == null) result = caseCompoundMember(compound);
				if (result == null) result = caseEModelElement(compound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPOUND_MEMBER: {
				CompoundMember compoundMember = (CompoundMember)theEObject;
				T result = caseCompoundMember(compoundMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPOUND_CONNECTOR: {
				CompoundConnector compoundConnector = (CompoundConnector)theEObject;
				T result = caseCompoundConnector(compoundConnector);
				if (result == null) result = caseConnector(compoundConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPOUND_INPUT_CONNECTOR: {
				CompoundInputConnector compoundInputConnector = (CompoundInputConnector)theEObject;
				T result = caseCompoundInputConnector(compoundInputConnector);
				if (result == null) result = caseCompoundConnector(compoundInputConnector);
				if (result == null) result = caseInputConnector(compoundInputConnector);
				if (result == null) result = caseConnector(compoundInputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPOUND_OUTPUT_CONNECTOR: {
				CompoundOutputConnector compoundOutputConnector = (CompoundOutputConnector)theEObject;
				T result = caseCompoundOutputConnector(compoundOutputConnector);
				if (result == null) result = caseCompoundConnector(compoundOutputConnector);
				if (result == null) result = caseOutputConnector(compoundOutputConnector);
				if (result == null) result = caseConnector(compoundOutputConnector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CHOICE: {
				Choice choice = (Choice)theEObject;
				T result = caseChoice(choice);
				if (result == null) result = caseComponent(choice);
				if (result == null) result = caseFragmentElement(choice);
				if (result == null) result = caseCompoundMember(choice);
				if (result == null) result = caseINamedElement(choice);
				if (result == null) result = caseEModelElement(choice);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CHOICE_INPUT: {
				ChoiceInput choiceInput = (ChoiceInput)theEObject;
				T result = caseChoiceInput(choiceInput);
				if (result == null) result = caseInput(choiceInput);
				if (result == null) result = caseInoutput(choiceInput);
				if (result == null) result = caseINamedElement(choiceInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CHOICE_INPUT_PORT: {
				ChoiceInputPort choiceInputPort = (ChoiceInputPort)theEObject;
				T result = caseChoiceInputPort(choiceInputPort);
				if (result == null) result = caseInputPort(choiceInputPort);
				if (result == null) result = caseINamedElement(choiceInputPort);
				if (result == null) result = casePort(choiceInputPort);
				if (result == null) result = caseInputConnector(choiceInputPort);
				if (result == null) result = caseConnector(choiceInputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.ACTION: {
				Action action = (Action)theEObject;
				T result = caseAction(action);
				if (result == null) result = caseCompound(action);
				if (result == null) result = caseFragmentElement(action);
				if (result == null) result = caseCompoundMember(action);
				if (result == null) result = caseEModelElement(action);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.ACTION_LINK: {
				ActionLink actionLink = (ActionLink)theEObject;
				T result = caseActionLink(actionLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.JOIN: {
				Join join = (Join)theEObject;
				T result = caseJoin(join);
				if (result == null) result = caseComponent(join);
				if (result == null) result = caseFragmentElement(join);
				if (result == null) result = caseCompoundMember(join);
				if (result == null) result = caseINamedElement(join);
				if (result == null) result = caseEModelElement(join);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.JOIN_INPUT: {
				JoinInput joinInput = (JoinInput)theEObject;
				T result = caseJoinInput(joinInput);
				if (result == null) result = caseInput(joinInput);
				if (result == null) result = caseInoutput(joinInput);
				if (result == null) result = caseINamedElement(joinInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.WHILE_LOOP: {
				WhileLoop whileLoop = (WhileLoop)theEObject;
				T result = caseWhileLoop(whileLoop);
				if (result == null) result = caseAction(whileLoop);
				if (result == null) result = caseCompound(whileLoop);
				if (result == null) result = caseFragmentElement(whileLoop);
				if (result == null) result = caseCompoundMember(whileLoop);
				if (result == null) result = caseEModelElement(whileLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.WHILE_LOOP_CONDITION: {
				WhileLoopCondition whileLoopCondition = (WhileLoopCondition)theEObject;
				T result = caseWhileLoopCondition(whileLoopCondition);
				if (result == null) result = caseCompoundInputConnector(whileLoopCondition);
				if (result == null) result = caseCompoundConnector(whileLoopCondition);
				if (result == null) result = caseInputConnector(whileLoopCondition);
				if (result == null) result = caseConnector(whileLoopCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.MEMORY: {
				Memory memory = (Memory)theEObject;
				T result = caseMemory(memory);
				if (result == null) result = caseComponent(memory);
				if (result == null) result = caseFragmentElement(memory);
				if (result == null) result = caseCompoundMember(memory);
				if (result == null) result = caseINamedElement(memory);
				if (result == null) result = caseEModelElement(memory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.MEMORY_INITIAL_CONDITION: {
				MemoryInitialCondition memoryInitialCondition = (MemoryInitialCondition)theEObject;
				T result = caseMemoryInitialCondition(memoryInitialCondition);
				if (result == null) result = caseInput(memoryInitialCondition);
				if (result == null) result = caseInoutput(memoryInitialCondition);
				if (result == null) result = caseINamedElement(memoryInitialCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.MEMORY_INPUT: {
				MemoryInput memoryInput = (MemoryInput)theEObject;
				T result = caseMemoryInput(memoryInput);
				if (result == null) result = caseInput(memoryInput);
				if (result == null) result = caseInoutput(memoryInput);
				if (result == null) result = caseINamedElement(memoryInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.MEMORY_OUTPUT: {
				MemoryOutput memoryOutput = (MemoryOutput)theEObject;
				T result = caseMemoryOutput(memoryOutput);
				if (result == null) result = caseOutput(memoryOutput);
				if (result == null) result = caseInoutput(memoryOutput);
				if (result == null) result = caseINamedElement(memoryOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INAMED_ELEMENT: {
				INamedElement iNamedElement = (INamedElement)theEObject;
				T result = caseINamedElement(iNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.ITEXTUAL_ELEMENT: {
				ITextualElement iTextualElement = (ITextualElement)theEObject;
				T result = caseITextualElement(iTextualElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragment(Fragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Timing Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimingConstraint(TimingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continuous Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continuous Timing Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinuousTimingConstraint(ContinuousTimingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synchronous Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synchronous Timing Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSynchronousTimingConstraint(SynchronousTimingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Asynchronous Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Asynchronous Timing Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsynchronousTimingConstraint(AsynchronousTimingConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentElement(FragmentElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputPort(InputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnector(Connector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputConnector(InputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputConnector(OutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputPort(OutputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutput(Output object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signal Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signal Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignalSpecification(SignalSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inoutput</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inoutput</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInoutput(Inoutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInput(Input object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockInput(BlockInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Inoutput</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Inoutput</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockInoutput(BlockInoutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputDefinition(InputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inoutput Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inoutput Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInoutputDefinition(InoutputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputDefinition(OutputDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedElement(ParameterizedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Argument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArgument(Argument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeSpecification(DataTypeSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveTypeSpecification(PrimitiveTypeSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterableElement(ParameterableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Predefined Value</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Predefined Value</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterPredefinedValue(ParameterPredefinedValue object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueSpecification(ValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralValueSpecification(LiteralValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValueSpecification(StringValueSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Direct Feedthrough Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Direct Feedthrough Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDirectFeedthroughPolicy(DirectFeedthroughPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockOutput(BlockOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockType(BlockType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Qualified Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Qualified Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQualifiedElement(QualifiedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Categorized Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Categorized Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategorizedElement(CategorizedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCategory(Category object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModel(Model object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(org.eclipselabs.damos.dml.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockPort(BlockPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockInputPort(BlockInputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Output Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockOutputPort(BlockOutputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystem(Subsystem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Interface</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Interface</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemInterface(SystemInterface object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inlet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inlet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInlet(Inlet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inoutlet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inoutlet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInoutlet(Inoutlet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outlet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outlet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutlet(Outlet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInport(Inport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inport Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inport Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInportInput(InportInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inoutport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inoutport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInoutport(Inoutport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outport</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outport</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutport(Outport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Outport Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Outport Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutportOutput(OutportOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem Inoutput</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem Inoutput</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystemInoutput(SubsystemInoutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystemInput(SubsystemInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystemOutput(SubsystemOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem Realization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem Realization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystemRealization(SubsystemRealization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Direct Feedthrough Policy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Direct Feedthrough Policy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanDirectFeedthroughPolicy(BooleanDirectFeedthroughPolicy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Latch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Latch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLatch(Latch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Latch Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Latch Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLatchInput(LatchInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompound(Compound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundMember(CompoundMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundConnector(CompoundConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Input Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Input Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundInputConnector(CompoundInputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound Output Connector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound Output Connector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompoundOutputConnector(CompoundOutputConnector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoice(Choice object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceInput(ChoiceInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Choice Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Choice Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseChoiceInputPort(ChoiceInputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActionLink(ActionLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoin(Join object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Join Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Join Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJoinInput(JoinInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileLoop(WhileLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Loop Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Loop Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileLoopCondition(WhileLoopCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemory(Memory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Initial Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Initial Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryInitialCondition(MemoryInitialCondition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryInput(MemoryInput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Memory Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Memory Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemoryOutput(MemoryOutput object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>INamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseINamedElement(INamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ITextual Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ITextual Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseITextualElement(ITextualElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DMLSwitch
