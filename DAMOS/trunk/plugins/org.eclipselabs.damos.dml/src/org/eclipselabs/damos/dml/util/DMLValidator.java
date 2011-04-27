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
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
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
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.ChoiceInput;
import org.eclipselabs.damos.dml.ChoiceInputPort;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Compound;
import org.eclipselabs.damos.dml.CompoundConnector;
import org.eclipselabs.damos.dml.CompoundInputConnector;
import org.eclipselabs.damos.dml.CompoundMember;
import org.eclipselabs.damos.dml.CompoundOutputConnector;
import org.eclipselabs.damos.dml.ConditionSpecification;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Connector;
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
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.JoinInput;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.MemoryInitialCondition;
import org.eclipselabs.damos.dml.MemoryInput;
import org.eclipselabs.damos.dml.MemoryOutput;
import org.eclipselabs.damos.dml.Model;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.dml.OpaqueConditionSpecification;
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
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.dml.WhileLoopCondition;

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

	private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z]\\w*");
	
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
			case DMLPackage.CONNECTION:
				return validateConnection((Connection)value, diagnostics, context);
			case DMLPackage.CONNECTOR:
				return validateConnector((Connector)value, diagnostics, context);
			case DMLPackage.INPUT_CONNECTOR:
				return validateInputConnector((InputConnector)value, diagnostics, context);
			case DMLPackage.OUTPUT_CONNECTOR:
				return validateOutputConnector((OutputConnector)value, diagnostics, context);
			case DMLPackage.INOUTPUT:
				return validateInoutput((Inoutput)value, diagnostics, context);
			case DMLPackage.INPUT:
				return validateInput((Input)value, diagnostics, context);
			case DMLPackage.OUTPUT:
				return validateOutput((Output)value, diagnostics, context);
			case DMLPackage.PORT:
				return validatePort((Port)value, diagnostics, context);
			case DMLPackage.INPUT_PORT:
				return validateInputPort((InputPort)value, diagnostics, context);
			case DMLPackage.OUTPUT_PORT:
				return validateOutputPort((OutputPort)value, diagnostics, context);
			case DMLPackage.SIGNAL_SPECIFICATION:
				return validateSignalSpecification((SignalSpecification)value, diagnostics, context);
			case DMLPackage.BLOCK_INOUTPUT:
				return validateBlockInoutput((BlockInoutput)value, diagnostics, context);
			case DMLPackage.BLOCK_INPUT:
				return validateBlockInput((BlockInput)value, diagnostics, context);
			case DMLPackage.BLOCK_OUTPUT:
				return validateBlockOutput((BlockOutput)value, diagnostics, context);
			case DMLPackage.INOUTPUT_DEFINITION:
				return validateInoutputDefinition((InoutputDefinition)value, diagnostics, context);
			case DMLPackage.INPUT_DEFINITION:
				return validateInputDefinition((InputDefinition)value, diagnostics, context);
			case DMLPackage.OUTPUT_DEFINITION:
				return validateOutputDefinition((OutputDefinition)value, diagnostics, context);
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
			case DMLPackage.COMPOUND:
				return validateCompound((Compound)value, diagnostics, context);
			case DMLPackage.COMPOUND_MEMBER:
				return validateCompoundMember((CompoundMember)value, diagnostics, context);
			case DMLPackage.COMPOUND_CONNECTOR:
				return validateCompoundConnector((CompoundConnector)value, diagnostics, context);
			case DMLPackage.COMPOUND_INPUT_CONNECTOR:
				return validateCompoundInputConnector((CompoundInputConnector)value, diagnostics, context);
			case DMLPackage.COMPOUND_OUTPUT_CONNECTOR:
				return validateCompoundOutputConnector((CompoundOutputConnector)value, diagnostics, context);
			case DMLPackage.CHOICE:
				return validateChoice((Choice)value, diagnostics, context);
			case DMLPackage.CHOICE_INPUT:
				return validateChoiceInput((ChoiceInput)value, diagnostics, context);
			case DMLPackage.CHOICE_INPUT_PORT:
				return validateChoiceInputPort((ChoiceInputPort)value, diagnostics, context);
			case DMLPackage.ACTION:
				return validateAction((Action)value, diagnostics, context);
			case DMLPackage.ACTION_LINK:
				return validateActionLink((ActionLink)value, diagnostics, context);
			case DMLPackage.CONDITION_SPECIFICATION:
				return validateConditionSpecification((ConditionSpecification)value, diagnostics, context);
			case DMLPackage.OPAQUE_CONDITION_SPECIFICATION:
				return validateOpaqueConditionSpecification((OpaqueConditionSpecification)value, diagnostics, context);
			case DMLPackage.JOIN:
				return validateJoin((Join)value, diagnostics, context);
			case DMLPackage.JOIN_INPUT:
				return validateJoinInput((JoinInput)value, diagnostics, context);
			case DMLPackage.WHILE_LOOP:
				return validateWhileLoop((WhileLoop)value, diagnostics, context);
			case DMLPackage.WHILE_LOOP_CONDITION:
				return validateWhileLoopCondition((WhileLoopCondition)value, diagnostics, context);
			case DMLPackage.MEMORY:
				return validateMemory((Memory)value, diagnostics, context);
			case DMLPackage.MEMORY_INITIAL_CONDITION:
				return validateMemoryInitialCondition((MemoryInitialCondition)value, diagnostics, context);
			case DMLPackage.MEMORY_INPUT:
				return validateMemoryInput((MemoryInput)value, diagnostics, context);
			case DMLPackage.MEMORY_OUTPUT:
				return validateMemoryOutput((MemoryOutput)value, diagnostics, context);
			default:
				return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EObjectValidator#validate_MultiplicityConforms(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	@Override
	protected boolean validate_MultiplicityConforms(EObject eObject, EStructuralFeature eStructuralFeature,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (eStructuralFeature == DMLPackage.eINSTANCE.getChoice_ActionLinks() && eObject instanceof Choice) {
			Choice choice = (Choice) eObject;
			if (choice.getActionLinks().size() < 2) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
							DIAGNOSTIC_SOURCE,
							0,
							"Choice component must have at least two action links",
							new Object[] { choice }));
				}
				return false;
			}
			return true;
		}
		return super.validate_MultiplicityConforms(eObject, eStructuralFeature, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateFragment_WellFormedName(fragment, diagnostics, context);
		if (result || diagnostics != null) result &= validateFragment_UniqueComponentNames(fragment, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateFragment_WellFormedName(Fragment fragment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String name = fragment.getName();
		if (name == null || name.trim().length() == 0) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Missing fragment name",
						new Object[] { fragment }));
			}
			return false;
		}
		if (!isValidIdentifier(name)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Invalid fragment name '" + name + "'",
						new Object[] { fragment }));
			}
			return false;
		}
		return true;
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
			if (validateComponent_WellFormedName(component, null, context)) {
				String name = component.getName();
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
		if (!validate_NoCircularContainment(component, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(component, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(component, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(component, diagnostics, context);
		return result;
	}

	/**
	 * Validates the WellFormedName constraint of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateComponent_WellFormedName(Component component, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String name = component.getName();
		if (name == null || name.trim().length() == 0) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Missing component name",
						new Object[] { component }));
			}
			return false;
		}
		if (!isValidIdentifier(name)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Invalid component name '" + name + "'",
						new Object[] { component }));
			}
			return false;
		}
		return true;
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
	public boolean validateConnector(Connector connector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(connector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInputConnector(InputConnector inputConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inputConnector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutputConnector(OutputConnector outputConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(outputConnector, diagnostics, context);
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
		if (!validate_NoCircularContainment(block, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(block, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(block, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(block, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateFragment_WellFormedName(model, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateFragment_WellFormedName(system, diagnostics, context);
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
		if (!validate_NoCircularContainment(subsystem, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(subsystem, diagnostics, context);
		return result;
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
		if (!validate_NoCircularContainment(subsystemRealization, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(subsystemRealization, diagnostics, context);
		if (result || diagnostics != null) result &= validateSubsystemRealization_MatchingFragment(subsystemRealization, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MatchingFragment constraint of '<em>Subsystem Realization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateSubsystemRealization_MatchingFragment(SubsystemRealization subsystemRealization, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		
		Fragment owningFragment = subsystemRealization.getOwningFragment();
		if (owningFragment == null || owningFragment.getName() == null) {
			return result;
		}

		Subsystem realizedSubsystem = subsystemRealization.getRealizedSubsystem();
		if (!isResolved(realizedSubsystem) || realizedSubsystem.getName() == null) {
			return result;
		}
		
		SystemInterface providedInterface = realizedSubsystem.getProvidedInterface();
		if (!isResolved(providedInterface)) {
			return result;
		}
		
		Fragment realizingFragment = subsystemRealization.getRealizingFragment();
		if (!isResolved(realizingFragment)) {
			return result;
		}
		
		Map<String, Inport> inports = DMLUtil.getComponentMap(realizingFragment, Inport.class);
		
		for (Inlet inlet : providedInterface.getInlets()) {
			if (inlet.getName() == null || inlet.getDataType() == null) {
				return result;
			}

			Inport inport = inports.remove(inlet.getName());
			if (inport != null) {
				if (inport.getDataType() == null) {
					return result;
				}
				if (!EcoreUtil.equals(inport.getDataType(), inlet.getDataType())) {
					if (diagnostics != null) {
						diagnostics
								.add(new BasicDiagnostic(
										Diagnostic.ERROR,
										DIAGNOSTIC_SOURCE,
										0,
										"Subsystem realization on fragment '"
												+ owningFragment.getName()
												+ "' for subsystem '"
												+ realizedSubsystem.getName()
												+ "' specifies realizing fragment with an incompatible inport data type for inlet '"
												+ inlet.getName() + "'", new Object[] { subsystemRealization }));
					}
					result = false;
				}
			} else {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
							"Subsystem realization on fragment '" + owningFragment.getName() + "' for subsystem '"
									+ realizedSubsystem.getName()
									+ "' specifies realizing fragment that does not have an inport for inlet '"
									+ inlet.getName() + "'", new Object[] { subsystemRealization }));
				}
				result = false;
			}
		}
		
		for (Inport inport : inports.values()) {
			if (inport.getName() == null) {
				return result;
			}
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
						"Subsystem realization on fragment '" + owningFragment.getName() + "' for subsystem '"
								+ realizedSubsystem.getName()
								+ "' specifies realizing fragment that contains an inport '" + inport.getName()
								+ "', which has no corresponding inlet", new Object[] { subsystemRealization }));
			}
			result = false;
		}
		
		Map<String, Outport> outports = DMLUtil.getComponentMap(subsystemRealization.getRealizingFragment(), Outport.class);
		
		for (Outlet outlet : providedInterface.getOutlets()) {
			if (outlet.getName() == null || outlet.getDataType() == null) {
				return result;
			}

			Outport outport = outports.remove(outlet.getName());
			if (outport != null) {
				if (outport.getDataType() == null) {
					return result;
				}
				if (!EcoreUtil.equals(outport.getDataType(), outlet.getDataType())) {
					if (diagnostics != null) {
						diagnostics
								.add(new BasicDiagnostic(
										Diagnostic.ERROR,
										DIAGNOSTIC_SOURCE,
										0,
										"Subsystem realization on fragment '"
												+ owningFragment.getName()
												+ "' for subsystem '"
												+ realizedSubsystem.getName()
												+ "' specifies realizing fragment with an incompatible outport data type for outlet '"
												+ outlet.getName() + "'", new Object[] { subsystemRealization }));
					}
					result = false;
				}
			} else {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
							"Subsystem realization on fragment '" + owningFragment.getName() + "' for subsystem '"
									+ realizedSubsystem.getName()
									+ "' specifies realizing fragment that does not have an outport for outlet '"
									+ outlet.getName() + "'", new Object[] { subsystemRealization }));
				}
				result = false;
			}
		}

		for (Outport outport : outports.values()) {
			if (outport.getName() == null) {
				return result;
			}
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
						"Subsystem realization on fragment '" + owningFragment.getName() + "' for subsystem '"
								+ realizedSubsystem.getName()
								+ "' specifies realizing fragment that contains an outport '" + outport.getName()
								+ "', which has no corresponding outlet", new Object[] { subsystemRealization }));
			}
			result = false;
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInport(Inport inport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(inport, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(inport, diagnostics, context);
		if (result || diagnostics != null) result &= validateInoutport_OwnedByFragment(inport, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInoutport(Inoutport inoutport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(inoutport, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(inoutport, diagnostics, context);
		if (result || diagnostics != null) result &= validateInoutport_OwnedByFragment(inoutport, diagnostics, context);
		return result;
	}

	/**
	 * Validates the OwnedByFragment constraint of '<em>Inoutport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateInoutport_OwnedByFragment(Inoutport inoutport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (inoutport.getOwningFragment() == null) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Inports and outports must be located on a fragment directly.",
						new Object[] { inoutport }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOutport(Outport outport, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(outport, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(outport, diagnostics, context);
		if (result || diagnostics != null) result &= validateInoutport_OwnedByFragment(outport, diagnostics, context);
		return result;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompound(Compound compound, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compound, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompoundMember(CompoundMember compoundMember, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compoundMember, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompoundConnector(CompoundConnector compoundConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compoundConnector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompoundInputConnector(CompoundInputConnector compoundInputConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compoundInputConnector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompoundOutputConnector(CompoundOutputConnector compoundOutputConnector, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compoundOutputConnector, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChoice(Choice choice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(choice, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validateChoice_ValidActionLinkConditions(choice, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidActionLinkConditions constraint of '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateChoice_ValidActionLinkConditions(Choice choice, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;
		
		int defaultCount = 0;
		int trueCount = 0;
		int falseCount = 0;
		
		EList<ActionLink> actionLinks = choice.getActionLinks();
		
		Map<String, ActionLink> conditions = new HashMap<String, ActionLink>();
		Set<ActionLink> duplicateActionLinks = new HashSet<ActionLink>();

		for (ActionLink actionLink : actionLinks) {
			if (actionLink.getCondition() != null) {
				String condition = actionLink.getCondition().stringCondition();

				ActionLink existingActionLink = conditions.put(condition, actionLink);
				if (existingActionLink != null) {
					duplicateActionLinks.add(actionLink);
					duplicateActionLinks.add(existingActionLink);
				}
				
				if ("true".equals(condition)) {
					++trueCount;
				} else if ("false".equals(condition)) {
					++falseCount;
				}
			} else {
				++defaultCount;
			}
		}
		
		if (defaultCount > 1) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Choice component must not have more than one default action link",
						new Object[] { choice }));
			}
			result = false;
		}

		if (!duplicateActionLinks.isEmpty()) {
			if (diagnostics != null) {
				for (ActionLink actionLink : duplicateActionLinks) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
							DIAGNOSTIC_SOURCE,
							0,
							"Duplicate action link condition",
							new Object[] { actionLink }));
				}
			}
			result = false;
		}

		if (trueCount == 1 && falseCount == 1 && actionLinks.size() > 2) {
			if (diagnostics != null) {
				for (ActionLink actionLink : actionLinks) {
					if (actionLink.getCondition() != null) {
						String condition = actionLink.getCondition().stringCondition();
						if (!("true".equals(condition) || "false".equals(condition))) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
									DIAGNOSTIC_SOURCE,
									0,
									"Action link will never be used",
									new Object[] { actionLink }));
						}
					} else {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
								DIAGNOSTIC_SOURCE,
								0,
								"Default action link will never be used",
								new Object[] { actionLink }));
					}
				}
			}
			result = false;
		}
		
		if ((trueCount == 0 || falseCount == 0) && defaultCount == 0) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Choice component must have default action link",
						new Object[] { choice }));
			}
			result = false;
		}

		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChoiceInput(ChoiceInput choiceInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(choiceInput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChoiceInputPort(ChoiceInputPort choiceInputPort, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(choiceInputPort, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAction(Action action, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(action, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateActionLink(ActionLink actionLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(actionLink, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(actionLink, diagnostics, context);
		if (result || diagnostics != null) result &= validateActionLink_ChoiceAndActionHaveSameOwner(actionLink, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ChoiceAndActionHaveSameOwner constraint of '<em>Action Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateActionLink_ChoiceAndActionHaveSameOwner(ActionLink actionLink, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (actionLink.getChoice().getEnclosingFragment() != actionLink.getAction().getEnclosingFragment()) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Choice and action must be located on the same fragment",
						new Object[] { actionLink }));
			}
			return false;
		}
		if (actionLink.getChoice().getOwningCompound() != actionLink.getAction().getOwningCompound()) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Choice and action must be located in the same compound",
						new Object[] { actionLink }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConditionSpecification(ConditionSpecification conditionSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(conditionSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateOpaqueConditionSpecification(OpaqueConditionSpecification opaqueConditionSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(opaqueConditionSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJoin(Join join, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(join, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(join, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(join, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(join, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(join, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(join, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(join, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(join, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(join, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(join, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateJoinInput(JoinInput joinInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(joinInput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileLoop(WhileLoop whileLoop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(whileLoop, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWhileLoopCondition(WhileLoopCondition whileLoopCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(whileLoopCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemory(Memory memory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(memory, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemory_OwnedByCompound(memory, diagnostics, context);
		if (result || diagnostics != null) result &= validateMemory_InitialConditionSourceOnEnclosingElement(memory, diagnostics, context);
		return result;
	}

	/**
	 * Validates the OwnedByCompound constraint of '<em>Memory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateMemory_OwnedByCompound(Memory memory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!(memory.getOwningCompound() instanceof WhileLoop)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Memory components can only be used in while loops",
						new Object[] { memory }));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the InitialConditionSourceOnEnclosingElement constraint of '<em>Memory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateMemory_InitialConditionSourceOnEnclosingElement(Memory memory, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (validateMemory_OwnedByCompound(memory, null, context)) {
			Fragment contextFragment = (Fragment) context.get(Fragment.class);
			if (contextFragment != null) {
				Connection connection = memory.getFirstInputPort().getFirstConnection(contextFragment);
				if (connection != null) {
					FragmentElement sourceOwner = DMLUtil.getOwner(connection.getSource(), FragmentElement.class);
					if (sourceOwner != null
							&& sourceOwner.getOwningFragment() == null
							&& (sourceOwner.eContainer() == memory.getOwningCompound()
									|| !EcoreUtil.isAncestor(sourceOwner.eContainer(), memory.getOwningCompound()))) {
						if (diagnostics != null) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
									DIAGNOSTIC_SOURCE,
									0,
									"Initial condition sources of memory components must be either located directly on a fragment or on an enclosing compound",
									new Object[] { memory }));
						}
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryInitialCondition(MemoryInitialCondition memoryInitialCondition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memoryInitialCondition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryInput(MemoryInput memoryInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memoryInput, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMemoryOutput(MemoryOutput memoryOutput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(memoryOutput, diagnostics, context);
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
	
	private boolean isResolved(EObject eObject) {
		return eObject != null && !eObject.eIsProxy();
	}
	
	private boolean isValidIdentifier(String identifier) {
		return IDENTIFIER_PATTERN.matcher(identifier).matches() && !identifier.contains("__");
	}

} //DMLValidator
