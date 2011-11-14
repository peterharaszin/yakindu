/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.dml.Action;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.AsynchronousTimingConstraint;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.ChoiceInput;
import org.eclipselabs.damos.dml.ChoiceInputPort;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.ContinuousTimingConstraint;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.InportInput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.JoinInput;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.LatchInput;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.MemoryInitialCondition;
import org.eclipselabs.damos.dml.MemoryInput;
import org.eclipselabs.damos.dml.MemoryOutput;
import org.eclipselabs.damos.dml.Model;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.OutportOutput;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterPredefinedValue;
import org.eclipselabs.damos.dml.ParameterVisibilityKind;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SynchronousTimingConstraint;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.TimingKind;
import org.eclipselabs.damos.dml.WhileLoop;
import org.eclipselabs.damos.dml.WhileLoopCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DMLFactoryImpl extends EFactoryImpl implements DMLFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DMLFactory init() {
		try {
			DMLFactory theDMLFactory = (DMLFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/2011/DML"); 
			if (theDMLFactory != null) {
				return theDMLFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DMLFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DMLPackage.FRAGMENT: return createFragment();
			case DMLPackage.CONTINUOUS_TIMING_CONSTRAINT: return createContinuousTimingConstraint();
			case DMLPackage.SYNCHRONOUS_TIMING_CONSTRAINT: return createSynchronousTimingConstraint();
			case DMLPackage.ASYNCHRONOUS_TIMING_CONSTRAINT: return createAsynchronousTimingConstraint();
			case DMLPackage.CONNECTION: return createConnection();
			case DMLPackage.INPUT: return createInput();
			case DMLPackage.OUTPUT: return createOutput();
			case DMLPackage.INPUT_PORT: return createInputPort();
			case DMLPackage.OUTPUT_PORT: return createOutputPort();
			case DMLPackage.BLOCK_INPUT: return createBlockInput();
			case DMLPackage.BLOCK_OUTPUT: return createBlockOutput();
			case DMLPackage.INPUT_DEFINITION: return createInputDefinition();
			case DMLPackage.OUTPUT_DEFINITION: return createOutputDefinition();
			case DMLPackage.PARAMETER: return createParameter();
			case DMLPackage.PARAMETER_PREDEFINED_VALUE: return createParameterPredefinedValue();
			case DMLPackage.ARGUMENT: return createArgument();
			case DMLPackage.BLOCK_TYPE: return createBlockType();
			case DMLPackage.CATEGORY: return createCategory();
			case DMLPackage.BLOCK: return createBlock();
			case DMLPackage.MODEL: return createModel();
			case DMLPackage.SYSTEM: return createSystem();
			case DMLPackage.BLOCK_INPUT_PORT: return createBlockInputPort();
			case DMLPackage.BLOCK_OUTPUT_PORT: return createBlockOutputPort();
			case DMLPackage.SUBSYSTEM: return createSubsystem();
			case DMLPackage.SYSTEM_INTERFACE: return createSystemInterface();
			case DMLPackage.INLET: return createInlet();
			case DMLPackage.OUTLET: return createOutlet();
			case DMLPackage.SUBSYSTEM_REALIZATION: return createSubsystemRealization();
			case DMLPackage.INPORT: return createInport();
			case DMLPackage.INPORT_INPUT: return createInportInput();
			case DMLPackage.OUTPORT: return createOutport();
			case DMLPackage.OUTPORT_OUTPUT: return createOutportOutput();
			case DMLPackage.SUBSYSTEM_INPUT: return createSubsystemInput();
			case DMLPackage.SUBSYSTEM_OUTPUT: return createSubsystemOutput();
			case DMLPackage.BOOLEAN_DIRECT_FEEDTHROUGH_POLICY: return createBooleanDirectFeedthroughPolicy();
			case DMLPackage.OPAQUE_DATA_TYPE_SPECIFICATION: return createOpaqueDataTypeSpecification();
			case DMLPackage.OPAQUE_BEHAVIOR_SPECIFICATION: return createOpaqueBehaviorSpecification();
			case DMLPackage.LATCH: return createLatch();
			case DMLPackage.LATCH_INPUT: return createLatchInput();
			case DMLPackage.CHOICE: return createChoice();
			case DMLPackage.CHOICE_INPUT: return createChoiceInput();
			case DMLPackage.CHOICE_INPUT_PORT: return createChoiceInputPort();
			case DMLPackage.ACTION: return createAction();
			case DMLPackage.ACTION_LINK: return createActionLink();
			case DMLPackage.JOIN: return createJoin();
			case DMLPackage.JOIN_INPUT: return createJoinInput();
			case DMLPackage.WHILE_LOOP: return createWhileLoop();
			case DMLPackage.WHILE_LOOP_CONDITION: return createWhileLoopCondition();
			case DMLPackage.MEMORY: return createMemory();
			case DMLPackage.MEMORY_INITIAL_CONDITION: return createMemoryInitialCondition();
			case DMLPackage.MEMORY_INPUT: return createMemoryInput();
			case DMLPackage.MEMORY_OUTPUT: return createMemoryOutput();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DMLPackage.PARAMETER_VISIBILITY_KIND:
				return createParameterVisibilityKindFromString(eDataType, initialValue);
			case DMLPackage.TIMING_KIND:
				return createTimingKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DMLPackage.PARAMETER_VISIBILITY_KIND:
				return convertParameterVisibilityKindToString(eDataType, instanceValue);
			case DMLPackage.TIMING_KIND:
				return convertTimingKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment createFragment() {
		FragmentImpl fragment = new FragmentImpl();
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinuousTimingConstraint createContinuousTimingConstraint() {
		ContinuousTimingConstraintImpl continuousTimingConstraint = new ContinuousTimingConstraintImpl();
		return continuousTimingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SynchronousTimingConstraint createSynchronousTimingConstraint() {
		SynchronousTimingConstraintImpl synchronousTimingConstraint = new SynchronousTimingConstraintImpl();
		return synchronousTimingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsynchronousTimingConstraint createAsynchronousTimingConstraint() {
		AsynchronousTimingConstraintImpl asynchronousTimingConstraint = new AsynchronousTimingConstraintImpl();
		return asynchronousTimingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputPort createInputPort() {
		InputPortImpl inputPort = new InputPortImpl();
		return inputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connection createConnection() {
		ConnectionImpl connection = new ConnectionImpl();
		return connection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputPort createOutputPort() {
		OutputPortImpl outputPort = new OutputPortImpl();
		return outputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Output createOutput() {
		OutputImpl output = new OutputImpl();
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockInput createBlockInput() {
		BlockInputImpl blockInput = new BlockInputImpl();
		return blockInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Input createInput() {
		InputImpl input = new InputImpl();
		return input;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputDefinition createInputDefinition() {
		InputDefinitionImpl inputDefinition = new InputDefinitionImpl();
		return inputDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockOutput createBlockOutput() {
		BlockOutputImpl blockOutput = new BlockOutputImpl();
		return blockOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputDefinition createOutputDefinition() {
		OutputDefinitionImpl outputDefinition = new OutputDefinitionImpl();
		return outputDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterPredefinedValue createParameterPredefinedValue() {
		ParameterPredefinedValueImpl parameterPredefinedValue = new ParameterPredefinedValueImpl();
		return parameterPredefinedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Argument createArgument() {
		ArgumentImpl argument = new ArgumentImpl();
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockType createBlockType() {
		BlockTypeImpl blockType = new BlockTypeImpl();
		return blockType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Category createCategory() {
		CategoryImpl category = new CategoryImpl();
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Model createModel() {
		ModelImpl model = new ModelImpl();
		return model;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipselabs.damos.dml.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockInputPort createBlockInputPort() {
		BlockInputPortImpl blockInputPort = new BlockInputPortImpl();
		return blockInputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockOutputPort createBlockOutputPort() {
		BlockOutputPortImpl blockOutputPort = new BlockOutputPortImpl();
		return blockOutputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Subsystem createSubsystem() {
		SubsystemImpl subsystem = new SubsystemImpl();
		return subsystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemInterface createSystemInterface() {
		SystemInterfaceImpl systemInterface = new SystemInterfaceImpl();
		return systemInterface;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inlet createInlet() {
		InletImpl inlet = new InletImpl();
		return inlet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outlet createOutlet() {
		OutletImpl outlet = new OutletImpl();
		return outlet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inport createInport() {
		InportImpl inport = new InportImpl();
		return inport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InportInput createInportInput() {
		InportInputImpl inportInput = new InportInputImpl();
		return inportInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Outport createOutport() {
		OutportImpl outport = new OutportImpl();
		return outport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutportOutput createOutportOutput() {
		OutportOutputImpl outportOutput = new OutportOutputImpl();
		return outportOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsystemInput createSubsystemInput() {
		SubsystemInputImpl subsystemInput = new SubsystemInputImpl();
		return subsystemInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsystemOutput createSubsystemOutput() {
		SubsystemOutputImpl subsystemOutput = new SubsystemOutputImpl();
		return subsystemOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsystemRealization createSubsystemRealization() {
		SubsystemRealizationImpl subsystemRealization = new SubsystemRealizationImpl();
		return subsystemRealization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanDirectFeedthroughPolicy createBooleanDirectFeedthroughPolicy() {
		BooleanDirectFeedthroughPolicyImpl booleanDirectFeedthroughPolicy = new BooleanDirectFeedthroughPolicyImpl();
		return booleanDirectFeedthroughPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueDataTypeSpecification createOpaqueDataTypeSpecification() {
		OpaqueDataTypeSpecificationImpl opaqueDataTypeSpecification = new OpaqueDataTypeSpecificationImpl();
		return opaqueDataTypeSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpaqueBehaviorSpecification createOpaqueBehaviorSpecification() {
		OpaqueBehaviorSpecificationImpl opaqueBehaviorSpecification = new OpaqueBehaviorSpecificationImpl();
		return opaqueBehaviorSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Latch createLatch() {
		LatchImpl latch = new LatchImpl();
		return latch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LatchInput createLatchInput() {
		LatchInputImpl latchInput = new LatchInputImpl();
		return latchInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceInput createChoiceInput() {
		ChoiceInputImpl choiceInput = new ChoiceInputImpl();
		return choiceInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ChoiceInputPort createChoiceInputPort() {
		ChoiceInputPortImpl choiceInputPort = new ChoiceInputPortImpl();
		return choiceInputPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action createAction() {
		ActionImpl action = new ActionImpl();
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActionLink createActionLink() {
		ActionLinkImpl actionLink = new ActionLinkImpl();
		return actionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Join createJoin() {
		JoinImpl join = new JoinImpl();
		return join;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JoinInput createJoinInput() {
		JoinInputImpl joinInput = new JoinInputImpl();
		return joinInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileLoop createWhileLoop() {
		WhileLoopImpl whileLoop = new WhileLoopImpl();
		return whileLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileLoopCondition createWhileLoopCondition() {
		WhileLoopConditionImpl whileLoopCondition = new WhileLoopConditionImpl();
		return whileLoopCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Memory createMemory() {
		MemoryImpl memory = new MemoryImpl();
		return memory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryInitialCondition createMemoryInitialCondition() {
		MemoryInitialConditionImpl memoryInitialCondition = new MemoryInitialConditionImpl();
		return memoryInitialCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryInput createMemoryInput() {
		MemoryInputImpl memoryInput = new MemoryInputImpl();
		return memoryInput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemoryOutput createMemoryOutput() {
		MemoryOutputImpl memoryOutput = new MemoryOutputImpl();
		return memoryOutput;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimingKind createTimingKindFromString(EDataType eDataType, String initialValue) {
		TimingKind result = TimingKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTimingKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterVisibilityKind createParameterVisibilityKindFromString(EDataType eDataType, String initialValue) {
		ParameterVisibilityKind result = ParameterVisibilityKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertParameterVisibilityKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLPackage getDMLPackage() {
		return (DMLPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DMLPackage getPackage() {
		return DMLPackage.eINSTANCE;
	}

} //DMLFactoryImpl
