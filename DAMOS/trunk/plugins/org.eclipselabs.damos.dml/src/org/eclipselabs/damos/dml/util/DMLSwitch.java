/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.BehaviorSpecification;
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
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.CompoundConnector;
import org.eclipselabs.damos.dml.CompoundInputConnector;
import org.eclipselabs.damos.dml.CompoundMember;
import org.eclipselabs.damos.dml.CompoundOutputConnector;
import org.eclipselabs.damos.dml.ConditionalCompound;
import org.eclipselabs.damos.dml.ConditionalCompoundCondition;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.DirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inoutput;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.Model;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;
import org.eclipselabs.damos.dml.QualifiedElement;
import org.eclipselabs.damos.dml.SignalSpecification;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInoutput;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.ValueSpecification;

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
public class DMLSwitch<T> {
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
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DMLPackage.FRAGMENT: {
				Fragment fragment = (Fragment)theEObject;
				T result = caseFragment(fragment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = caseFragmentElement(component);
				if (result == null) result = caseCompoundMember(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.FRAGMENT_ELEMENT: {
				FragmentElement fragmentElement = (FragmentElement)theEObject;
				T result = caseFragmentElement(fragmentElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = caseFragmentElement(connection);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPUT: {
				Input input = (Input)theEObject;
				T result = caseInput(input);
				if (result == null) result = caseInoutput(input);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = caseInoutput(output);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_INPUT: {
				BlockInput blockInput = (BlockInput)theEObject;
				T result = caseBlockInput(blockInput);
				if (result == null) result = caseInput(blockInput);
				if (result == null) result = caseBlockInoutput(blockInput);
				if (result == null) result = caseInoutput(blockInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_OUTPUT: {
				BlockOutput blockOutput = (BlockOutput)theEObject;
				T result = caseBlockOutput(blockOutput);
				if (result == null) result = caseOutput(blockOutput);
				if (result == null) result = caseBlockInoutput(blockOutput);
				if (result == null) result = caseInoutput(blockOutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INOUTPUT_DEFINITION: {
				InoutputDefinition inoutputDefinition = (InoutputDefinition)theEObject;
				T result = caseInoutputDefinition(inoutputDefinition);
				if (result == null) result = caseParameterableElement(inoutputDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INPUT_DEFINITION: {
				InputDefinition inputDefinition = (InputDefinition)theEObject;
				T result = caseInputDefinition(inputDefinition);
				if (result == null) result = caseInoutputDefinition(inputDefinition);
				if (result == null) result = caseParameterableElement(inputDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTPUT_DEFINITION: {
				OutputDefinition outputDefinition = (OutputDefinition)theEObject;
				T result = caseOutputDefinition(outputDefinition);
				if (result == null) result = caseInoutputDefinition(outputDefinition);
				if (result == null) result = caseParameterableElement(outputDefinition);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.VALUE_SPECIFICATION: {
				ValueSpecification valueSpecification = (ValueSpecification)theEObject;
				T result = caseValueSpecification(valueSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.DATA_TYPE_SPECIFICATION: {
				DataTypeSpecification dataTypeSpecification = (DataTypeSpecification)theEObject;
				T result = caseDataTypeSpecification(dataTypeSpecification);
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
			case DMLPackage.EXPRESSION_PARAMETER: {
				ExpressionParameter expressionParameter = (ExpressionParameter)theEObject;
				T result = caseExpressionParameter(expressionParameter);
				if (result == null) result = caseParameter(expressionParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.EXPRESSION_SPECIFICATION: {
				ExpressionSpecification expressionSpecification = (ExpressionSpecification)theEObject;
				T result = caseExpressionSpecification(expressionSpecification);
				if (result == null) result = caseValueSpecification(expressionSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.PREDEFINED_EXPRESSION_ENTRY: {
				PredefinedExpressionEntry predefinedExpressionEntry = (PredefinedExpressionEntry)theEObject;
				T result = casePredefinedExpressionEntry(predefinedExpressionEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BLOCK_TYPE: {
				BlockType blockType = (BlockType)theEObject;
				T result = caseBlockType(blockType);
				if (result == null) result = caseQualifiedElement(blockType);
				if (result == null) result = caseCategorizedElement(blockType);
				if (result == null) result = caseParameterableElement(blockType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.QUALIFIED_ELEMENT: {
				QualifiedElement qualifiedElement = (QualifiedElement)theEObject;
				T result = caseQualifiedElement(qualifiedElement);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.BEHAVIOR_SPECIFICATION: {
				BehaviorSpecification behaviorSpecification = (BehaviorSpecification)theEObject;
				T result = caseBehaviorSpecification(behaviorSpecification);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.MODEL: {
				Model model = (Model)theEObject;
				T result = caseModel(model);
				if (result == null) result = caseSystem(model);
				if (result == null) result = caseFragment(model);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SYSTEM: {
				org.eclipselabs.damos.dml.System system = (org.eclipselabs.damos.dml.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = caseFragment(system);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SYSTEM_INTERFACE: {
				SystemInterface systemInterface = (SystemInterface)theEObject;
				T result = caseSystemInterface(systemInterface);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INLET: {
				Inlet inlet = (Inlet)theEObject;
				T result = caseInlet(inlet);
				if (result == null) result = caseInoutlet(inlet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INOUTLET: {
				Inoutlet inoutlet = (Inoutlet)theEObject;
				T result = caseInoutlet(inoutlet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OUTLET: {
				Outlet outlet = (Outlet)theEObject;
				T result = caseOutlet(outlet);
				if (result == null) result = caseInoutlet(outlet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_REALIZATION: {
				SubsystemRealization subsystemRealization = (SubsystemRealization)theEObject;
				T result = caseSubsystemRealization(subsystemRealization);
				if (result == null) result = caseFragmentElement(subsystemRealization);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.INOUTPORT: {
				Inoutport inoutport = (Inoutport)theEObject;
				T result = caseInoutport(inoutport);
				if (result == null) result = caseComponent(inoutport);
				if (result == null) result = caseFragmentElement(inoutport);
				if (result == null) result = caseCompoundMember(inoutport);
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
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_INOUTPUT: {
				SubsystemInoutput subsystemInoutput = (SubsystemInoutput)theEObject;
				T result = caseSubsystemInoutput(subsystemInoutput);
				if (result == null) result = caseInoutput(subsystemInoutput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_INPUT: {
				SubsystemInput subsystemInput = (SubsystemInput)theEObject;
				T result = caseSubsystemInput(subsystemInput);
				if (result == null) result = caseInput(subsystemInput);
				if (result == null) result = caseSubsystemInoutput(subsystemInput);
				if (result == null) result = caseInoutput(subsystemInput);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.SUBSYSTEM_OUTPUT: {
				SubsystemOutput subsystemOutput = (SubsystemOutput)theEObject;
				T result = caseSubsystemOutput(subsystemOutput);
				if (result == null) result = caseOutput(subsystemOutput);
				if (result == null) result = caseSubsystemInoutput(subsystemOutput);
				if (result == null) result = caseInoutput(subsystemOutput);
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
			case DMLPackage.OPAQUE_DATA_TYPE_SPECIFICATION: {
				OpaqueDataTypeSpecification opaqueDataTypeSpecification = (OpaqueDataTypeSpecification)theEObject;
				T result = caseOpaqueDataTypeSpecification(opaqueDataTypeSpecification);
				if (result == null) result = caseDataTypeSpecification(opaqueDataTypeSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.OPAQUE_BEHAVIOR_SPECIFICATION: {
				OpaqueBehaviorSpecification opaqueBehaviorSpecification = (OpaqueBehaviorSpecification)theEObject;
				T result = caseOpaqueBehaviorSpecification(opaqueBehaviorSpecification);
				if (result == null) result = caseBehaviorSpecification(opaqueBehaviorSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.COMPOUND: {
				Compound compound = (Compound)theEObject;
				T result = caseCompound(compound);
				if (result == null) result = caseFragmentElement(compound);
				if (result == null) result = caseCompoundMember(compound);
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
			case DMLPackage.CONDITIONAL_COMPOUND: {
				ConditionalCompound conditionalCompound = (ConditionalCompound)theEObject;
				T result = caseConditionalCompound(conditionalCompound);
				if (result == null) result = caseCompound(conditionalCompound);
				if (result == null) result = caseFragmentElement(conditionalCompound);
				if (result == null) result = caseCompoundMember(conditionalCompound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.CONDITIONAL_COMPOUND_CONDITION: {
				ConditionalCompoundCondition conditionalCompoundCondition = (ConditionalCompoundCondition)theEObject;
				T result = caseConditionalCompoundCondition(conditionalCompoundCondition);
				if (result == null) result = caseCompoundInputConnector(conditionalCompoundCondition);
				if (result == null) result = caseCompoundConnector(conditionalCompoundCondition);
				if (result == null) result = caseInputConnector(conditionalCompoundCondition);
				if (result == null) result = caseConnector(conditionalCompoundCondition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DMLPackage.JOIN: {
				Join join = (Join)theEObject;
				T result = caseJoin(join);
				if (result == null) result = caseComponent(join);
				if (result == null) result = caseFragmentElement(join);
				if (result == null) result = caseCompoundMember(join);
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
	 * Returns the result of interpreting the object as an instance of '<em>Expression Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionParameter(ExpressionParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionSpecification(ExpressionSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predefined Expression Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predefined Expression Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredefinedExpressionEntry(PredefinedExpressionEntry object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Behavior Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Behavior Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBehaviorSpecification(BehaviorSpecification object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Data Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Data Type Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueDataTypeSpecification(OpaqueDataTypeSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Opaque Behavior Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Opaque Behavior Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpaqueBehaviorSpecification(OpaqueBehaviorSpecification object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Compound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Compound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalCompound(ConditionalCompound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Conditional Compound Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Conditional Compound Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionalCompoundCondition(ConditionalCompoundCondition object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //DMLSwitch
