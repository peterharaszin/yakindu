/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.eclipselabs.damos.dml.DMLPlugin;
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
import org.eclipselabs.damos.dml.ParameterVisibilityKind;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.PrimitiveTypeKind;
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
import org.eclipselabs.damos.dml.TimingKind;
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

	public static final int FRAGMENT__WELL_FORMED_PACKAGE_NAME = GENERATED_DIAGNOSTIC_CODE_COUNT + 100;
	public static final int FRAGMENT__WELL_FORMED_NAME = GENERATED_DIAGNOSTIC_CODE_COUNT + 101;

	public static final int COMPONENT__WELL_FORMED_NAME = GENERATED_DIAGNOSTIC_CODE_COUNT + 200;
	public static final int COMPONENT__UNIQUE_COMPONENT_NAME = GENERATED_DIAGNOSTIC_CODE_COUNT + 201;
	
	public static final int BLOCK__VALID_BLOCK_TYPE_REFERENCE = GENERATED_DIAGNOSTIC_CODE_COUNT + 300;
	public static final int BLOCK__VALID_INPUT_DEFINITION_REFERENCES = GENERATED_DIAGNOSTIC_CODE_COUNT + 301;
	public static final int BLOCK__VALID_OUTPUT_DEFINITION_REFERENCES = GENERATED_DIAGNOSTIC_CODE_COUNT + 302;
	public static final int BLOCK__VALID_PARAMETER_REFERENCES = GENERATED_DIAGNOSTIC_CODE_COUNT + 303;
	
	public static final int SUBSYSTEM__VALID_INTERFACE_REFERENCE = GENERATED_DIAGNOSTIC_CODE_COUNT + 400;
	public static final int SUBSYSTEM__VALID_INLET_REFERENCES = GENERATED_DIAGNOSTIC_CODE_COUNT + 401;
	public static final int SUBSYSTEM__VALID_OUTLET_REFERENCES = GENERATED_DIAGNOSTIC_CODE_COUNT + 402;

	public static final int SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE = GENERATED_DIAGNOSTIC_CODE_COUNT + 500;
	
	public static final int INOUTPORT__HAS_DATA_TYPE = GENERATED_DIAGNOSTIC_CODE_COUNT + 600;
	
	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT + 10000;

	private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z]\\w*");
	private static final Pattern PACKAGE_NAME_PATTERN = Pattern.compile("\\A([a-zA-Z]\\w*)(\\.[a-zA-Z]\\w*)*\\z");
	
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
			case DMLPackage.TIMING_CONSTRAINT:
				return validateTimingConstraint((TimingConstraint)value, diagnostics, context);
			case DMLPackage.CONTINUOUS_TIMING_CONSTRAINT:
				return validateContinuousTimingConstraint((ContinuousTimingConstraint)value, diagnostics, context);
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT:
				return validateSynchronousTimingConstraint((SynchronousTimingConstraint)value, diagnostics, context);
			case DMLPackage.ASYNCHRONOUS_TIMING_CONSTRAINT:
				return validateAsynchronousTimingConstraint((AsynchronousTimingConstraint)value, diagnostics, context);
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
			case DMLPackage.PARAMETER_PREDEFINED_VALUE:
				return validateParameterPredefinedValue((ParameterPredefinedValue)value, diagnostics, context);
			case DMLPackage.VALUE_SPECIFICATION:
				return validateValueSpecification((ValueSpecification)value, diagnostics, context);
			case DMLPackage.LITERAL_VALUE_SPECIFICATION:
				return validateLiteralValueSpecification((LiteralValueSpecification)value, diagnostics, context);
			case DMLPackage.STRING_VALUE_SPECIFICATION:
				return validateStringValueSpecification((StringValueSpecification)value, diagnostics, context);
			case DMLPackage.DATA_TYPE_SPECIFICATION:
				return validateDataTypeSpecification((DataTypeSpecification)value, diagnostics, context);
			case DMLPackage.PRIMITIVE_TYPE_SPECIFICATION:
				return validatePrimitiveTypeSpecification((PrimitiveTypeSpecification)value, diagnostics, context);
			case DMLPackage.DIRECT_FEEDTHROUGH_POLICY:
				return validateDirectFeedthroughPolicy((DirectFeedthroughPolicy)value, diagnostics, context);
			case DMLPackage.PARAMETERIZED_ELEMENT:
				return validateParameterizedElement((ParameterizedElement)value, diagnostics, context);
			case DMLPackage.ARGUMENT:
				return validateArgument((Argument)value, diagnostics, context);
			case DMLPackage.BLOCK_TYPE:
				return validateBlockType((BlockType)value, diagnostics, context);
			case DMLPackage.QUALIFIED_ELEMENT:
				return validateQualifiedElement((QualifiedElement)value, diagnostics, context);
			case DMLPackage.CATEGORIZED_ELEMENT:
				return validateCategorizedElement((CategorizedElement)value, diagnostics, context);
			case DMLPackage.CATEGORY:
				return validateCategory((Category)value, diagnostics, context);
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
			case DMLPackage.INPORT_INPUT:
				return validateInportInput((InportInput)value, diagnostics, context);
			case DMLPackage.INOUTPORT:
				return validateInoutport((Inoutport)value, diagnostics, context);
			case DMLPackage.OUTPORT:
				return validateOutport((Outport)value, diagnostics, context);
			case DMLPackage.OUTPORT_OUTPUT:
				return validateOutportOutput((OutportOutput)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM_INOUTPUT:
				return validateSubsystemInoutput((SubsystemInoutput)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM_INPUT:
				return validateSubsystemInput((SubsystemInput)value, diagnostics, context);
			case DMLPackage.SUBSYSTEM_OUTPUT:
				return validateSubsystemOutput((SubsystemOutput)value, diagnostics, context);
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY:
				return validateBooleanDirectFeedthroughPolicy((BooleanDirectFeedthroughPolicy)value, diagnostics, context);
			case DMLPackage.LATCH:
				return validateLatch((Latch)value, diagnostics, context);
			case DMLPackage.LATCH_INPUT:
				return validateLatchInput((LatchInput)value, diagnostics, context);
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
			case DMLPackage.INAMED_ELEMENT:
				return validateINamedElement((INamedElement)value, diagnostics, context);
			case DMLPackage.ITEXTUAL_ELEMENT:
				return validateITextualElement((ITextualElement)value, diagnostics, context);
			case DMLPackage.PARAMETER_VISIBILITY_KIND:
				return validateParameterVisibilityKind((ParameterVisibilityKind)value, diagnostics, context);
			case DMLPackage.PRIMITIVE_TYPE_KIND:
				return validatePrimitiveTypeKind((PrimitiveTypeKind)value, diagnostics, context);
			case DMLPackage.TIMING_KIND:
				return validateTimingKind((TimingKind)value, diagnostics, context);
			default:
				return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EObjectValidator#validate_EveryProxyResolves(org.eclipse.emf.ecore.EObject, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	@Override
	public boolean validate_EveryProxyResolves(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (eObject instanceof Block) {
			Block block = (Block) eObject;
			if (!DMLUtil.isResolved(block.getType())) {
				if (diagnostics != null) {
					String path = "";
					if (block.getType() != null) {
						URI uri = EcoreUtil.getURI(block.getType());
						if (uri != null && uri.isPlatformResource()) {
							path = " defined in " + uri.toPlatformString(true);
						}
					}
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
							DIAGNOSTIC_SOURCE,
							BLOCK__VALID_BLOCK_TYPE_REFERENCE,
							String.format("The block type of %s%s could not be resolved", block.getName(), path),
							new Object[] { block }));
				}
				return false;
			}
		} else if (eObject instanceof BlockInoutput) {
			return true;
		} else if (eObject instanceof Argument) {
			return true;
		} else if (eObject instanceof SubsystemRealization) {
			SubsystemRealization subsystemRealization = (SubsystemRealization) eObject;
			if (!DMLUtil.isResolved(subsystemRealization.getRealizingFragment())) {
				if (diagnostics != null) {
					String path = "";
					if (subsystemRealization.getRealizingFragment() != null) {
						URI uri = EcoreUtil.getURI(subsystemRealization.getRealizingFragment());
						if (uri != null && uri.isPlatformResource()) {
							path = " defined in " + uri.toPlatformString(true);
						}
					}
					String message = String.format("Realizing fragment%s could not be resolved for subsystem %s", path,
							subsystemRealization.getRealizedSubsystem().getName());
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, SUBSYSTEM_REALIZATION__VALID_REALIZING_FRAGMENT_REFERENCE, message,
							new Object[] { subsystemRealization }));
				}
				return false;
			}
		} else if (eObject instanceof Subsystem) {
			Subsystem subsystem = (Subsystem) eObject;
				if (!DMLUtil.isResolved(subsystem.getInterface())) {
					if (diagnostics != null) {
						String path = "";
						if (subsystem.getInterface() != null) {
							URI uri = EcoreUtil.getURI(subsystem.getInterface());
							if (uri != null && uri.isPlatformResource()) {
								path = " defined in " + uri.toPlatformString(true);
							}
						}
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
								DIAGNOSTIC_SOURCE,
								SUBSYSTEM__VALID_INTERFACE_REFERENCE,
								String.format("The system interface of %s%s could not be resolved", subsystem.getName(), path),
								new Object[] { subsystem }));
					}
					return false;
				}
		} else if (eObject instanceof SubsystemInoutput) {
			return true;
		} else {
			return super.validate_EveryProxyResolves(eObject, diagnostics, context);
		}
		return true;
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
		} else if (eStructuralFeature == DMLPackage.eINSTANCE.getInoutport_DataType() && eObject instanceof Inoutport) {
			Inoutport inoutport = (Inoutport) eObject;
			if (inoutport.getDataType() == null) {
				if (diagnostics != null) {
					String message;
					if (inoutport.getName() != null) {
						message = "No data type specified for " + inoutport.getName();
					} else {
						message = "No data type specified";
					}
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
							DIAGNOSTIC_SOURCE,
							INOUTPORT__HAS_DATA_TYPE,
							message,
							new Object[] { inoutport }));
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
		String packageName = fragment.getPackageName();
		String name = fragment.getName();

		boolean result = true;

		if (name == null || name.trim().length() == 0) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						FRAGMENT__WELL_FORMED_NAME,
						"Missing fragment name",
						new Object[] { fragment }));
			}
			result = false;
		}
		
		if (result && !isValidIdentifier(name)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						FRAGMENT__WELL_FORMED_NAME,
						"Invalid fragment name '" + name + "'",
						new Object[] { fragment }));
			}
			result = false;
		}
		
		if (packageName != null && !isValidPackageName(packageName)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						FRAGMENT__WELL_FORMED_PACKAGE_NAME,
						"Invalid fragment package name '" + packageName + "'",
						new Object[] { fragment }));
			}
			result = false;
		}

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
		
		for (FragmentElement element : fragment.getAllFragmentElements()) {
			validateFragment_UniqueComponentNames(element, names, invalidComponents, context);
		}

		if (diagnostics != null) {
			for (Component invalidComponent : invalidComponents) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						COMPONENT__UNIQUE_COMPONENT_NAME,
						"Duplicate component name '" + invalidComponent.getName() + "'",
						new Object[] { invalidComponent }));
			}
		}
		
		return invalidComponents.isEmpty();
	}

	private void validateFragment_UniqueComponentNames(EObject eObject, Map<String, Component> names, Set<Component> invalidComponents, Map<Object, Object> context) {
		if (eObject instanceof Component) {
			Component component = (Component) eObject;
			if (validateComponent_WellFormedName(component, null, context)) {
				String name = component.getName();
				Component existingComponent = names.put(name, component);
				if (existingComponent != null) {
					invalidComponents.add(component);
					invalidComponents.add(existingComponent);
				}
			}
		} else if (eObject instanceof Compound) {
			Compound compound = (Compound) eObject;
			validateFragment_UniqueComponentNames(compound, names, invalidComponents, context);
		}
	}

	private void validateFragment_UniqueComponentNames(Compound compound, Map<String, Component> names, Set<Component> invalidComponents, Map<Object, Object> context) {
		for (CompoundMember member : compound.getMembers()) {
			validateFragment_UniqueComponentNames(member, names, invalidComponents, context);
		}
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
						COMPONENT__WELL_FORMED_NAME,
						"Missing component name",
						new Object[] { component }));
			}
			return false;
		}
		if (!isValidIdentifier(name)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						COMPONENT__WELL_FORMED_NAME,
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
	public boolean validateTimingConstraint(TimingConstraint timingConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(timingConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateContinuousTimingConstraint(ContinuousTimingConstraint continuousTimingConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(continuousTimingConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSynchronousTimingConstraint(SynchronousTimingConstraint synchronousTimingConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(synchronousTimingConstraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAsynchronousTimingConstraint(AsynchronousTimingConstraint asynchronousTimingConstraint, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(asynchronousTimingConstraint, diagnostics, context);
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
		if (!validate_NoCircularContainment(connection, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(connection, diagnostics, context);
		if (result || diagnostics != null) result &= validateConnection_ValidCompoundConnection(connection, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidCompoundConnection constraint of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateConnection_ValidCompoundConnection(Connection connection, DiagnosticChain diagnostics, Map<Object, Object> context) {
		CompoundMember source = DMLUtil.getOwner(connection.getSource(), CompoundMember.class);
		if (source != null && source.getOwningCompound() instanceof Action && !(connection.getTarget() instanceof CompoundConnector)) {
			Action action = (Action) source.getOwningCompound();
			if (action.getLink() != null) {
				FragmentElement target = DMLUtil.getOwner(connection.getTarget(), FragmentElement.class);
				if ((target.getOwningFragment() != null || !EcoreUtil.isAncestor(action, target)) && !(target instanceof Join)) {
					if (diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
								DIAGNOSTIC_SOURCE,
								0,
								"Connection target must be Join",
								new Object[] { connection }));
					}
					return false;
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
	public boolean validateParameterPredefinedValue(ParameterPredefinedValue parameterPredefinedValue, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(parameterPredefinedValue, diagnostics, context);
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
	public boolean validateLiteralValueSpecification(LiteralValueSpecification literalValueSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(literalValueSpecification, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStringValueSpecification(StringValueSpecification stringValueSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(stringValueSpecification, diagnostics, context);
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
	public boolean validatePrimitiveTypeSpecification(PrimitiveTypeSpecification primitiveTypeSpecification, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(primitiveTypeSpecification, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateBlock_ValidInputDefinitionReferences(block, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlock_ValidOutputDefinitionReferences(block, diagnostics, context);
		if (result || diagnostics != null) result &= validateBlock_ValidParameterReferences(block, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidInputDefinitionReferences constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateBlock_ValidInputDefinitionReferences(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		BlockType blockType = block.getType();
		if (!DMLUtil.isResolved(blockType)) {
			return true;
		}
		
		List<String> undefinedDefinitions = new ArrayList<String>();
		Set<InputDefinition> missingDefinitions = new LinkedHashSet<InputDefinition>();
		for (InputDefinition definition : blockType.getInputDefinitions()) {
			missingDefinitions.add(definition);
		}
		
		for (Input input : block.getInputs()) {
			if (input instanceof BlockInput) {
				InputDefinition definition = ((BlockInput) input).getDefinition();
				if (DMLUtil.isResolved(definition)) {
					missingDefinitions.remove(definition);
				} else {
					undefinedDefinitions.add(extractElementName(definition));
				}
			}
		}
		
		if (!undefinedDefinitions.isEmpty() || !missingDefinitions.isEmpty()) {
			if (diagnostics != null) {
				StringBuilder sb = new StringBuilder();
	
				if (!undefinedDefinitions.isEmpty()) {
					sb.append("Undefined input");
					if (undefinedDefinitions.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (String definition : undefinedDefinitions) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(definition);
					}
				}
				
				if (!missingDefinitions.isEmpty()) {
					if (undefinedDefinitions.isEmpty()) {
						sb.append("Missing input");
					} else {
						sb.append(" and missing input");
					}
					if (missingDefinitions.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (InputDefinition definition : missingDefinitions) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(definition.getName());
					}
				}
	
				if (block.getName() != null) {
					sb.append(" on block ");
					sb.append(block.getName());
				}
				
				diagnostics.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						BLOCK__VALID_INPUT_DEFINITION_REFERENCES,
						sb.toString(), new Object[] { block }));
			}
			return false;
		}

		if (diagnostics != null) {
			for (int i = 0; i < block.getInputs().size(); ++i) {
				Input input = block.getInputs().get(i);
				if (input instanceof BlockInput) {
					BlockInput blockInput = (BlockInput) input;
					if (blockInput.getDefinition() != blockType.getInputDefinitions().get(i)) {
						StringBuilder sb = new StringBuilder();
						sb.append("Block input order");
						if (block.getName() != null) {
							sb.append(" of ");
							sb.append(block.getName());
						}
						sb.append(" does not correspond to input definition order of the block type");
						diagnostics.add(new BasicDiagnostic(
								Diagnostic.WARNING,
								DIAGNOSTIC_SOURCE,
								BLOCK__VALID_INPUT_DEFINITION_REFERENCES,
								sb.toString(), new Object[] { block }));
						break;
					}
				}
			}
		}
		
		return true;
	}

	/**
	 * Validates the ValidOutputDefinitionReferences constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateBlock_ValidOutputDefinitionReferences(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		BlockType blockType = block.getType();
		if (!DMLUtil.isResolved(blockType)) {
			return true;
		}
		
		List<String> undefinedDefinitions = new ArrayList<String>();
		Set<OutputDefinition> missingDefinitions = new LinkedHashSet<OutputDefinition>();
		for (OutputDefinition definition : blockType.getOutputDefinitions()) {
			missingDefinitions.add(definition);
		}
		
		for (Output output : block.getOutputs()) {
			if (output instanceof BlockOutput) {
				OutputDefinition definition = ((BlockOutput) output).getDefinition();
				if (DMLUtil.isResolved(definition)) {
					missingDefinitions.remove(definition);
				} else {
					undefinedDefinitions.add(extractElementName(definition));
				}
			}
		}
		
		if (!undefinedDefinitions.isEmpty() || !missingDefinitions.isEmpty()) {
			if (diagnostics != null) {
				StringBuilder sb = new StringBuilder();
	
				if (!undefinedDefinitions.isEmpty()) {
					sb.append("Undefined output");
					if (undefinedDefinitions.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (String definition : undefinedDefinitions) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(definition);
					}
				}
				
				if (!missingDefinitions.isEmpty()) {
					if (undefinedDefinitions.isEmpty()) {
						sb.append("Missing output");
					} else {
						sb.append(" and missing output");
					}
					if (missingDefinitions.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (OutputDefinition definition : missingDefinitions) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(definition.getName());
					}
				}
	
				if (block.getName() != null) {
					sb.append(" on block ");
					sb.append(block.getName());
				}
				
				diagnostics.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						BLOCK__VALID_OUTPUT_DEFINITION_REFERENCES,
						sb.toString(), new Object[] { block }));
			}
			return false;
		}
		
		if (diagnostics != null) {
			for (int i = 0; i < block.getOutputs().size(); ++i) {
				Output output = block.getOutputs().get(i);
				if (output instanceof BlockOutput) {
					BlockOutput blockOutput = (BlockOutput) output;
					if (blockOutput.getDefinition() != blockType.getOutputDefinitions().get(i)) {
						StringBuilder sb = new StringBuilder();
						sb.append("Block output order");
						if (block.getName() != null) {
							sb.append(" of ");
							sb.append(block.getName());
						}
						sb.append(" does not correspond to output definition order of the block type");
						diagnostics.add(new BasicDiagnostic(
								Diagnostic.WARNING,
								DIAGNOSTIC_SOURCE,
								BLOCK__VALID_OUTPUT_DEFINITION_REFERENCES,
								sb.toString(), new Object[] { block }));
						break;
					}
				}
			}
		}

		return true;
	}

	/**
	 * Validates the ValidParameterReferences constraint of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateBlock_ValidParameterReferences(Block block, DiagnosticChain diagnostics, Map<Object, Object> context) {
		BlockType blockType = block.getType();
		if (!DMLUtil.isResolved(blockType)) {
			return true;
		}
		
		List<String> undefinedParameters = new ArrayList<String>();
		Set<Parameter> missingParameters = new LinkedHashSet<Parameter>();
		for (Parameter parameter : blockType.getParameters()) {
			missingParameters.add(parameter);
		}
		
		for (Argument argument : block.getArguments()) {
			Parameter parameter = argument.getParameter();
			if (DMLUtil.isResolved(parameter)) {
				missingParameters.remove(parameter);
			} else {
				undefinedParameters.add(extractElementName(parameter));
			}
		}
		
		if (!undefinedParameters.isEmpty() || !missingParameters.isEmpty() && diagnostics != null) {
			StringBuilder sb = new StringBuilder();

			if (!undefinedParameters.isEmpty()) {
				sb.append("Undefined parameter");
				if (undefinedParameters.size() > 1) {
					sb.append("s");
				}
				sb.append(" ");
				boolean first = true;
				for (String parameter : undefinedParameters) {
					if (first) {
						first = false;
					} else {
						sb.append(", ");
					}
					sb.append(parameter);
				}
			}
			
			if (!missingParameters.isEmpty()) {
				if (undefinedParameters.isEmpty()) {
					sb.append("Missing parameter");
				} else {
					sb.append(" and missing parameter");
				}
				if (missingParameters.size() > 1) {
					sb.append("s");
				}
				sb.append(" ");
				boolean first = true;
				for (Parameter parameter : missingParameters) {
					if (first) {
						first = false;
					} else {
						sb.append(", ");
					}
					sb.append(parameter.getName());
				}
			}

			sb.append(" on block ");
			sb.append(block.getName());
			
			diagnostics.add(new BasicDiagnostic(
					!undefinedParameters.isEmpty() ? Diagnostic.ERROR : Diagnostic.WARNING,
					DIAGNOSTIC_SOURCE,
					BLOCK__VALID_PARAMETER_REFERENCES,
					sb.toString(), new Object[] { block }));
		}
		
		return undefinedParameters.isEmpty();
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
		if (result || diagnostics != null) result &= validateSubsystem_ValidInletReferences(subsystem, diagnostics, context);
		if (result || diagnostics != null) result &= validateSubsystem_ValidOutletReferences(subsystem, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidInletReferences constraint of '<em>Subsystem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateSubsystem_ValidInletReferences(Subsystem subsystem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		SystemInterface interface_ = subsystem.getInterface();
		if (!DMLUtil.isResolved(interface_)) {
			return true;
		}
		
		List<String> undefinedInlets = new ArrayList<String>();
		Set<Inlet> missingInlets = new LinkedHashSet<Inlet>();
		for (Inlet inlet : interface_.getInlets()) {
			missingInlets.add(inlet);
		}
		
		for (Input input : subsystem.getInputs()) {
			if (input instanceof SubsystemInput) {
				Inlet inlet = ((SubsystemInput) input).getInlet();
				if (DMLUtil.isResolved(inlet)) {
					missingInlets.remove(inlet);
				} else {
					undefinedInlets.add(extractElementName(inlet));
				}
			}
		}
		
		if (!undefinedInlets.isEmpty() || !missingInlets.isEmpty()) {
			if (diagnostics != null) {
				StringBuilder sb = new StringBuilder();
	
				if (!undefinedInlets.isEmpty()) {
					sb.append("Undefined inlet");
					if (undefinedInlets.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (String inlet : undefinedInlets) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(inlet);
					}
				}
				
				if (!missingInlets.isEmpty()) {
					if (undefinedInlets.isEmpty()) {
						sb.append("Missing inlet");
					} else {
						sb.append(" and missing inlet");
					}
					if (missingInlets.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (Inlet inlet : missingInlets) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(inlet.getName());
					}
				}
	
				if (subsystem.getName() != null) {
					sb.append(" on subsystem ");
					sb.append(subsystem.getName());
				}
				
				diagnostics.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						SUBSYSTEM__VALID_INLET_REFERENCES,
						sb.toString(), new Object[] { subsystem }));
			}
			return false;
		}
		
		if (diagnostics != null) {
			for (int i = 0; i < subsystem.getInputs().size(); ++i) {
				Input input = subsystem.getInputs().get(i);
				if (input instanceof SubsystemInput) {
					SubsystemInput subsystemInput = (SubsystemInput) input;
					if (subsystemInput.getInlet() != interface_.getInlets().get(i)) {
						StringBuilder sb = new StringBuilder();
						sb.append("Subsystem input order");
						if (subsystem.getName() != null) {
							sb.append(" of ");
							sb.append(subsystem.getName());
						}
						sb.append(" does not correspond to inlet order of the interface");
						diagnostics.add(new BasicDiagnostic(
								Diagnostic.WARNING,
								DIAGNOSTIC_SOURCE,
								SUBSYSTEM__VALID_INLET_REFERENCES,
								sb.toString(), new Object[] { subsystem }));
						break;
					}
				}
			}
		}

		return true;
	}

	/**
	 * Validates the ValidOutletReferences constraint of '<em>Subsystem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateSubsystem_ValidOutletReferences(Subsystem subsystem, DiagnosticChain diagnostics, Map<Object, Object> context) {
		SystemInterface interface_ = subsystem.getInterface();
		if (!DMLUtil.isResolved(interface_)) {
			return true;
		}
		
		List<String> undefinedOutlets = new ArrayList<String>();
		Set<Outlet> missingOutlets = new LinkedHashSet<Outlet>();
		for (Outlet outlet : interface_.getOutlets()) {
			missingOutlets.add(outlet);
		}
		
		for (Output output : subsystem.getOutputs()) {
			if (output instanceof SubsystemOutput) {
				Outlet outlet = ((SubsystemOutput) output).getOutlet();
				if (DMLUtil.isResolved(outlet)) {
					missingOutlets.remove(outlet);
				} else {
					undefinedOutlets.add(extractElementName(outlet));
				}
			}
		}
		
		if (!undefinedOutlets.isEmpty() || !missingOutlets.isEmpty()) {
			if (diagnostics != null) {
				StringBuilder sb = new StringBuilder();
	
				if (!undefinedOutlets.isEmpty()) {
					sb.append("Undefined outlet");
					if (undefinedOutlets.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (String outlet : undefinedOutlets) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(outlet);
					}
				}
				
				if (!missingOutlets.isEmpty()) {
					if (undefinedOutlets.isEmpty()) {
						sb.append("Missing outlet");
					} else {
						sb.append(" and missing outlet");
					}
					if (missingOutlets.size() > 1) {
						sb.append("s");
					}
					sb.append(" ");
					boolean first = true;
					for (Outlet outlet : missingOutlets) {
						if (first) {
							first = false;
						} else {
							sb.append(", ");
						}
						sb.append(outlet.getName());
					}
				}
	
				sb.append(" on subsystem ");
				sb.append(subsystem.getName());
				
				diagnostics.add(new BasicDiagnostic(
						Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						SUBSYSTEM__VALID_OUTLET_REFERENCES,
						sb.toString(), new Object[] { subsystem }));
			}
			return false;
		}
		
		if (diagnostics != null) {
			for (int i = 0; i < subsystem.getOutputs().size(); ++i) {
				Output output = subsystem.getOutputs().get(i);
				if (output instanceof SubsystemOutput) {
					SubsystemOutput subsystemOutput = (SubsystemOutput) output;
					if (subsystemOutput.getOutlet() != interface_.getOutlets().get(i)) {
						StringBuilder sb = new StringBuilder();
						sb.append("Subsystem output order");
						if (subsystem.getName() != null) {
							sb.append(" of ");
							sb.append(subsystem.getName());
						}
						sb.append(" does not correspond to outlet order of the interface");
						diagnostics.add(new BasicDiagnostic(
								Diagnostic.WARNING,
								DIAGNOSTIC_SOURCE,
								SUBSYSTEM__VALID_OUTLET_REFERENCES,
								sb.toString(), new Object[] { subsystem }));
						break;
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
		if (!DMLUtil.isResolved(realizedSubsystem) || realizedSubsystem.getName() == null) {
			return result;
		}
		
		SystemInterface interface_ = realizedSubsystem.getInterface();
		if (!DMLUtil.isResolved(interface_)) {
			return result;
		}
		
		Fragment realizingFragment = subsystemRealization.getRealizingFragment();
		if (!DMLUtil.isResolved(realizingFragment)) {
			return result;
		}
		
		Map<String, Inport> inports = DMLUtil.getComponentMap(realizingFragment, Inport.class);
		
		for (Inlet inlet : interface_.getInlets()) {
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
												+ "' specifies realizing fragment with an incompatible Inport data type for Inlet '"
												+ inlet.getName() + "'", new Object[] { subsystemRealization }));
					}
					result = false;
				}
			} else {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, DIAGNOSTIC_SOURCE, 0,
							"Subsystem realization on fragment '" + owningFragment.getName() + "' for subsystem '"
									+ realizedSubsystem.getName()
									+ "' specifies realizing fragment that does not have an Inport for Inlet '"
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
		
		for (Outlet outlet : interface_.getOutlets()) {
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
	public boolean validateInportInput(InportInput inportInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(inportInput, diagnostics, context);
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
						"Inports and Outports must be located on a fragment directly",
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
	public boolean validateOutportOutput(OutportOutput outportOutput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(outportOutput, diagnostics, context);
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
	public boolean validateLatch(Latch latch, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(latch, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(latch, diagnostics, context);
		if (result || diagnostics != null) result &= validateComponent_WellFormedName(latch, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateLatchInput(LatchInput latchInput, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(latchInput, diagnostics, context);
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
				String condition = actionLink.getCondition().stringValue();

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
						"Choice must not have more than one default action link",
						new Object[] { choice }));
			}
			result = false;
		}

		if (!duplicateActionLinks.isEmpty()) {
			if (diagnostics != null) {
				for (ActionLink actionLink : duplicateActionLinks) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING,
							DIAGNOSTIC_SOURCE,
							0,
							"Duplicate action link condition",
							new Object[] { actionLink }));
				}
			}
		}

		if (trueCount == 1 && falseCount == 1 && actionLinks.size() > 2) {
			if (diagnostics != null) {
				for (ActionLink actionLink : actionLinks) {
					if (actionLink.getCondition() != null) {
						String condition = actionLink.getCondition().stringValue();
						if (!("true".equals(condition) || "false".equals(condition))) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING,
									DIAGNOSTIC_SOURCE,
									0,
									"Pointless action link",
									new Object[] { actionLink }));
						}
					} else {
						diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING,
								DIAGNOSTIC_SOURCE,
								0,
								"Default action link will never be used",
								new Object[] { actionLink }));
					}
				}
			}
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
						"Choice and Action must be located on the same fragment",
						new Object[] { actionLink }));
			}
			return false;
		}
		if (actionLink.getChoice().getOwningCompound() != actionLink.getAction().getOwningCompound()) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE,
						0,
						"Choice and Action must be enclosed by the same compound",
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
		if (result || diagnostics != null) result &= validateJoin_ValidActions(join, diagnostics, context);
		if (result || diagnostics != null) result &= validateJoin_ValidChoice(join, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ValidActions constraint of '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateJoin_ValidActions(Join join, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = true;

		Fragment contextFragment = (Fragment) context.get(Fragment.class);
		if (contextFragment != null) {
			Set<Action> actions = new HashSet<Action>();
			boolean duplicateActions = false;
			for (InputPort inputPort : join.getInputPorts()) {
				Connection connection = inputPort.getFirstConnection(contextFragment);
				if (connection != null) {
					Action action = findEnclosingActionWithLink(connection.getSource());
					if (action != null) {
						if (!actions.add(action)) {
							duplicateActions = true;
						}
						if (action.getLink() == null) {
							if (diagnostics != null) {
								diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
										DIAGNOSTIC_SOURCE,
										0,
										formatStringWithOwnerName("Enclosing Action of Join source%s has no Action link", connection.getSource()),
										new Object[] { join }));
							}
							result = false;
						}
					} else {
						if (diagnostics != null) {
							diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
									DIAGNOSTIC_SOURCE,
									0,
									formatStringWithOwnerName("Join source%s must be enclosed by an Action", connection.getSource()),
									new Object[] { join }));
						}
						result = false;
					}
				}
			}
			if (duplicateActions) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
							DIAGNOSTIC_SOURCE,
							0,
							"Duplicate source Actions",
							new Object[] { join }));
				}
				result = false;
			}
		}
		
		return result;
	}

	/**
	 * Validates the ValidChoice constraint of '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateJoin_ValidChoice(Join join, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (validateJoin_ValidActions(join, null, context)) {
			Fragment contextFragment = (Fragment) context.get(Fragment.class);
			if (contextFragment != null) {
				Choice choice = null;
				Set<Action> actions = new HashSet<Action>();
				for (InputPort inputPort : join.getInputPorts()) {
					Connection connection = inputPort.getFirstConnection(contextFragment);
					if (connection != null) {
						Action action = findEnclosingActionWithLink(connection.getSource());
						if (choice == null) {
							choice = action.getLink().getChoice();
							for (ActionLink actionLink : choice.getActionLinks()) {
								if (actionLink.getAction() != action) {
									actions.add(actionLink.getAction());
								}
							}
						} else {
							if (action.getLink().getChoice() != choice) {
								if (diagnostics != null) {
									diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
											DIAGNOSTIC_SOURCE,
											0,
											"Enclosing Action of Join sources must be linked to the same Choice",
											new Object[] { join }));
								}
								return false;
							}
							actions.remove(action);
						}
					}
				}
				if (!actions.isEmpty()) {
					if (diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
								DIAGNOSTIC_SOURCE,
								0,
								"Missing Join inputs from Actions of Choice '" + choice.getName() + "'",
								new Object[] { join }));
					}
					return false;
				}
			}
		}
		return true;
	}
	
	private Action findEnclosingActionWithLink(EObject element) {
		Action action;
		do {
			action = DMLUtil.getOwner(element, Action.class);
			if (action != null) {
				if (action.getLink() != null) {
					return action;
				}
				element = action.getOwningCompound();
				if (element == null) {
					return action;
				}
			}
		} while (action != null);
		return action;
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
		if (!validate_NoCircularContainment(whileLoop, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(whileLoop, diagnostics, context);
		if (result || diagnostics != null) result &= validateWhileLoop_ConditionSourceInWhileLoop(whileLoop, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ConditionSourceInWhileLoop constraint of '<em>While Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateWhileLoop_ConditionSourceInWhileLoop(WhileLoop whileLoop, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Fragment contextFragment = (Fragment) context.get(Fragment.class);
		WhileLoopCondition condition = whileLoop.getCondition();
		if (contextFragment != null && condition != null) {
			Connection connection = condition.getFirstConnection(contextFragment);
			if (connection != null) {
				CompoundMember compoundMember = DMLUtil.getOwner(connection.getSource(), CompoundMember.class);
				if (!EcoreUtil.isAncestor(whileLoop, compoundMember)) {
					if (diagnostics != null) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING,
								DIAGNOSTIC_SOURCE,
								0,
								formatStringWithOwnerName("Condition source%s is not enclosed by the while loop", connection.getSource()),
								new Object[] { whileLoop }));
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
									"Initial condition sources of Memory components must be either located directly on a fragment or on the enclosing compound of the Memory component",
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateINamedElement(INamedElement iNamedElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iNamedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateITextualElement(ITextualElement iTextualElement, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(iTextualElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTimingKind(TimingKind timingKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParameterVisibilityKind(ParameterVisibilityKind parameterVisibilityKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveTypeKind(PrimitiveTypeKind primitiveTypeKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
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
		
	private boolean isValidIdentifier(String identifier) {
		return IDENTIFIER_PATTERN.matcher(identifier).matches() && !identifier.contains("__");
	}

	private boolean isValidPackageName(String packageName) {
		return PACKAGE_NAME_PATTERN.matcher(packageName).matches() && !packageName.contains("__");
	}

	private String getOwnerName(EObject eObject) {
		INamedElement namedElement = DMLUtil.getOwner(eObject, INamedElement.class);
		if (namedElement != null) {
			return namedElement.getName();
		}
		return null;
	}
	
	private String extractElementName(EObject eObject) {
		if (eObject == null) {
			return "UNNAMED";
		}
		return DMLUtil.extractElementName(EcoreUtil.getURI(eObject));
	}

	private String formatStringWithOwnerName(String s, EObject eObject) {
		String ownerName = getOwnerName(eObject);
		if (ownerName != null) {
			ownerName = " '" + ownerName + "'";
		} else {
			ownerName = "";
		}
		return String.format(s, ownerName);
	}

} //DMLValidator
