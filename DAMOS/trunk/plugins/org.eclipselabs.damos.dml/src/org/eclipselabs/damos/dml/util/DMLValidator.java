/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
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
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.DMLPlugin;
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
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Model;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
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
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dml.DMLPackage
 * @generated
 */
public class DMLValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DMLValidator INSTANCE = new DMLValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipselabs.damos.dml";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return DMLPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case DMLPackage.FRAGMENT:
				return validateFragment((Fragment)value, diagnostics, context);
			case DMLPackage.COMPONENT:
				return validateComponent((Component)value, diagnostics, context);
			case DMLPackage.FRAGMENT_ELEMENT:
				return validateFragmentElement((FragmentElement)value, diagnostics, context);
			case DMLPackage.INPUT:
				return validateInput((Input)value, diagnostics, context);
			case DMLPackage.INOUTPUT:
				return validateInoutput((Inoutput)value, diagnostics, context);
			case DMLPackage.INPUT_PORT:
				return validateInputPort((InputPort)value, diagnostics, context);
			case DMLPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case DMLPackage.CONNECTION:
				return validateConnection((Connection)value, diagnostics, context);
			case DMLPackage.OUTPUT_PORT:
				return validateOutputPort((OutputPort)value, diagnostics, context);
			case DMLPackage.OUTPUT:
				return validateOutput((Output)value, diagnostics, context);
			case DMLPackage.SIGNAL_SPECIFICATION:
				return validateSignalSpecification((SignalSpecification)value, diagnostics, context);
			case DMLPackage.BLOCK_INPUT:
				return validateBlockInput((BlockInput)value, diagnostics, context);
			case DMLPackage.BLOCK_INOUTPUT:
				return validateBlockInoutput((BlockInoutput)value, diagnostics, context);
			case DMLPackage.INPUT_DEFINITION:
				return validateInputDefinition((InputDefinition)value, diagnostics, context);
			case DMLPackage.INOUTPUT_DEFINITION:
				return validateInoutputDefinition((InoutputDefinition)value, diagnostics, context);
			case DMLPackage.PARAMETERABLE_ELEMENT:
				return validateParameterableElement((ParameterableElement)value, diagnostics, context);
			case DMLPackage.PARAMETER:
				return validateParameter((Parameter)value, diagnostics, context);
			case DMLPackage.VALUE_SPECIFICATION:
				return validateValueSpecification((ValueSpecification)value, diagnostics, context);
			case DMLPackage.DATA_TYPE_SPECIFICATION:
				return validateDataTypeSpecification((DataTypeSpecification)value, diagnostics, context);
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY:
				return validateDirectFeedthroughPolicy((DirectFeedthroughPolicy)value, diagnostics, context);
			case DMLPackage.BLOCK_OUTPUT:
				return validateBlockOutput((BlockOutput)value, diagnostics, context);
			case DMLPackage.OUTPUT_DEFINITION:
				return validateOutputDefinition((OutputDefinition)value, diagnostics, context);
			case DMLPackage.PARAMETERIZED_ELEMENT:
				return validateParameterizedElement((ParameterizedElement)value, diagnostics, context);
			case DMLPackage.ARGUMENT:
				return validateArgument((Argument)value, diagnostics, context);
			case DMLPackage.EXPRESSION_PARAMETER:
				return validateExpressionParameter((ExpressionParameter)value, diagnostics, context);
			case DMLPackage.EXPRESSION_SPECIFICATION:
				return validateExpressionSpecification((ExpressionSpecification)value, diagnostics, context);
			case DMLPackage.PREDEFINED_EXPRESSION_ENTRY:
				return validatePredefinedExpressionEntry((PredefinedExpressionEntry)value, diagnostics, context);
			case DMLPackage.BLOCK_TYPE:
				return validateBlockType((BlockType)value, diagnostics, context);
			case DMLPackage.QUALIFIED_ELEMENT:
				return validateQualifiedElement((QualifiedElement)value, diagnostics, context);
			case DMLPackage.CATEGORIZED_ELEMENT:
				return validateCategorizedElement((CategorizedElement)value, diagnostics, context);
			case DMLPackage.CATEGORY:
				return validateCategory((Category)value, diagnostics, context);
			case DMLPackage.BEHAVIOR_SPECIFICATION:
				return validateBehaviorSpecification((BehaviorSpecification)value, diagnostics, context);
			case DMLPackage.BLOCK:
				return validateBlock((Block)value, diagnostics, context);
			case DMLPackage.MODEL:
				return validateModel((Model)value, diagnostics, context);
			case DMLPackage.SYSTEM:
				return validateSystem((org.eclipselabs.damos.dml.System)value, diagnostics, context);
			case DMLPackage.BLOCK_PORT:
				return validateBlockPort((BlockPort)value, diagnostics, context);
			case DMLPackage.BLOCK_INPUT_PORT:
				return validateBlockInputPort((BlockInputPort)value, diagnostics, context);
			case DMLPackage.BLOCK_OUTPUT_PORT:
				return validateBlockOutputPort((BlockOutputPort)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM:
				return validateSubsystem((Subsystem)value, diagnostics, context);
			case DMLPackage.SYSTEM_INTERFACE:
				return validateSystemInterface((SystemInterface)value, diagnostics, context);
			case DMLPackage.INLET:
				return validateInlet((Inlet)value, diagnostics, context);
			case DMLPackage.INOUTLET:
				return validateInoutlet((Inoutlet)value, diagnostics, context);
			case DMLPackage.OUTLET:
				return validateOutlet((Outlet)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM_REALIZATION:
				return validateSubsystemRealization((SubsystemRealization)value, diagnostics, context);
			case DMLPackage.INPORT:
				return validateInport((Inport)value, diagnostics, context);
			case DMLPackage.INOUTPORT:
				return validateInoutport((Inoutport)value, diagnostics, context);
			case DMLPackage.OUTPORT:
				return validateOutport((Outport)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM_INOUTPUT:
				return validateSubsystemInoutput((SubsystemInoutput)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM_INPUT:
				return validateSubsystemInput((SubsystemInput)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM_OUTPUT:
				return validateSubsystemOutput((SubsystemOutput)value, diagnostics, context);
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY:
				return validateBooleanDirectFeedthroughPolicy((BooleanDirectFeedthroughPolicy)value, diagnostics, context);
			case DMLPackage.OPAQUE_DATA_TYPE_SPECIFICATION:
				return validateOpaqueDataTypeSpecification((OpaqueDataTypeSpecification)value, diagnostics, context);
			case DMLPackage.OPAQUE_BEHAVIOR_SPECIFICATION:
				return validateOpaqueBehaviorSpecification((OpaqueBehaviorSpecification)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFragment(Fragment fragment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(fragment, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validateFragment_UniqueComponentNames(fragment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the UniqueComponentNames constraint of '<em>Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFragment_UniqueComponentNames(Fragment fragment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Map<String, Component> names = new HashMap<String, Component>();
		Set<Component> invalidComponents = new HashSet<Component>();
		
		for (Component component : fragment.getAllComponents()) {
			String name = component.getName();
			if (name != null) {
				Component existingComponent = names.put(name, component);
				if (existingComponent != null) {
					invalidComponents.add(component);
					invalidComponents.add(existingComponent);
				}
			}
		}

		if (diagnostics != null) {
			for (Component invalidComponent : invalidComponents) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Duplicate component name '" + invalidComponent.getName() + "'",
						new Object[] { invalidComponent }));
			}
		}
		
		return invalidComponents.isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateComponent(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(component, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFragmentElement(FragmentElement fragmentElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(fragmentElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInput(Input input, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(input, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInoutput(Inoutput inoutput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inoutput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputPort(InputPort inputPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inputPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePort(Port port, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(port, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConnection(Connection connection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connection, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputPort(OutputPort outputPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(outputPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutput(Output output, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(output, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSignalSpecification(SignalSpecification signalSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(signalSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockInput(BlockInput blockInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(blockInput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockInoutput(BlockInoutput blockInoutput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(blockInoutput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputDefinition(InputDefinition inputDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inputDefinition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInoutputDefinition(InoutputDefinition inoutputDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inoutputDefinition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterableElement(ParameterableElement parameterableElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterableElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameter(Parameter parameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueSpecification(ValueSpecification valueSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataTypeSpecification(DataTypeSpecification dataTypeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataTypeSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDirectFeedthroughPolicy(DirectFeedthroughPolicy directFeedthroughPolicy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(directFeedthroughPolicy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockOutput(BlockOutput blockOutput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(blockOutput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputDefinition(OutputDefinition outputDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(outputDefinition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterizedElement(ParameterizedElement parameterizedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterizedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateArgument(Argument argument, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(argument, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionParameter(ExpressionParameter expressionParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExpressionSpecification(ExpressionSpecification expressionSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePredefinedExpressionEntry(PredefinedExpressionEntry predefinedExpressionEntry, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(predefinedExpressionEntry, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockType(BlockType blockType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(blockType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateQualifiedElement(QualifiedElement qualifiedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(qualifiedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCategorizedElement(CategorizedElement categorizedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(categorizedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCategory(Category category, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(category, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBehaviorSpecification(BehaviorSpecification behaviorSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(behaviorSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlock(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(block, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateModel(Model model, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(model, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(model, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(model, diagnostics, context);
		if (result || diagnostics != null) result &= validateFragment_UniqueComponentNames(model, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystem(org.eclipselabs.damos.dml.System system, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(system, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(system, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(system, diagnostics, context);
		if (result || diagnostics != null) result &= validateFragment_UniqueComponentNames(system, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockPort(BlockPort blockPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(blockPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockInputPort(BlockInputPort blockInputPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(blockInputPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBlockOutputPort(BlockOutputPort blockOutputPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(blockOutputPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsystem(Subsystem subsystem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subsystem, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSystemInterface(SystemInterface systemInterface, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(systemInterface, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInlet(Inlet inlet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inlet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInoutlet(Inoutlet inoutlet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inoutlet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutlet(Outlet outlet, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(outlet, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsystemRealization(SubsystemRealization subsystemRealization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subsystemRealization, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInport(Inport inport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inport, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInoutport(Inoutport inoutport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inoutport, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutport(Outport outport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(outport, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsystemInoutput(SubsystemInoutput subsystemInoutput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subsystemInoutput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsystemInput(SubsystemInput subsystemInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subsystemInput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSubsystemOutput(SubsystemOutput subsystemOutput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(subsystemOutput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateBooleanDirectFeedthroughPolicy(BooleanDirectFeedthroughPolicy booleanDirectFeedthroughPolicy, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(booleanDirectFeedthroughPolicy, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueDataTypeSpecification(OpaqueDataTypeSpecification opaqueDataTypeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(opaqueDataTypeSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueBehaviorSpecification(OpaqueBehaviorSpecification opaqueBehaviorSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(opaqueBehaviorSpecification, diagnostics, context);
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return DMLPlugin.INSTANCE;
	}

} //DMLValidator
