/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dml.DMLPackage
 * @generated
 */
public interface DMLFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DMLFactory eINSTANCE = org.eclipselabs.damos.dml.impl.DMLFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment</em>'.
	 * @generated
	 */
	Fragment createFragment();

	/**
	 * Returns a new object of class '<em>Continuous Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continuous Timing Constraint</em>'.
	 * @generated
	 */
	ContinuousTimingConstraint createContinuousTimingConstraint();

	/**
	 * Returns a new object of class '<em>Synchronous Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Synchronous Timing Constraint</em>'.
	 * @generated
	 */
	SynchronousTimingConstraint createSynchronousTimingConstraint();

	/**
	 * Returns a new object of class '<em>Asynchronous Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Asynchronous Timing Constraint</em>'.
	 * @generated
	 */
	AsynchronousTimingConstraint createAsynchronousTimingConstraint();

	/**
	 * Returns a new object of class '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Port</em>'.
	 * @generated
	 */
	InputPort createInputPort();

	/**
	 * Returns a new object of class '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connection</em>'.
	 * @generated
	 */
	Connection createConnection();

	/**
	 * Returns a new object of class '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Port</em>'.
	 * @generated
	 */
	OutputPort createOutputPort();

	/**
	 * Returns a new object of class '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output</em>'.
	 * @generated
	 */
	Output createOutput();

	/**
	 * Returns a new object of class '<em>Block Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Input</em>'.
	 * @generated
	 */
	BlockInput createBlockInput();

	/**
	 * Returns a new object of class '<em>Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input</em>'.
	 * @generated
	 */
	Input createInput();

	/**
	 * Returns a new object of class '<em>Input Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Definition</em>'.
	 * @generated
	 */
	InputDefinition createInputDefinition();

	/**
	 * Returns a new object of class '<em>Block Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Output</em>'.
	 * @generated
	 */
	BlockOutput createBlockOutput();

	/**
	 * Returns a new object of class '<em>Output Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Definition</em>'.
	 * @generated
	 */
	OutputDefinition createOutputDefinition();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	Parameter createParameter();

	/**
	 * Returns a new object of class '<em>Parameter Predefined Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Predefined Value</em>'.
	 * @generated
	 */
	ParameterPredefinedValue createParameterPredefinedValue();

	/**
	 * Returns a new object of class '<em>String Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Value Specification</em>'.
	 * @generated
	 */
	StringValueSpecification createStringValueSpecification();

	/**
	 * Returns a new object of class '<em>Primitive Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type Specification</em>'.
	 * @generated
	 */
	PrimitiveTypeSpecification createPrimitiveTypeSpecification();

	/**
	 * Returns a new object of class '<em>Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Argument</em>'.
	 * @generated
	 */
	Argument createArgument();

	/**
	 * Returns a new object of class '<em>Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Type</em>'.
	 * @generated
	 */
	BlockType createBlockType();

	/**
	 * Returns a new object of class '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Category</em>'.
	 * @generated
	 */
	Category createCategory();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	Model createModel();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block</em>'.
	 * @generated
	 */
	Block createBlock();

	/**
	 * Returns a new object of class '<em>Block Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Input Port</em>'.
	 * @generated
	 */
	BlockInputPort createBlockInputPort();

	/**
	 * Returns a new object of class '<em>Block Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Output Port</em>'.
	 * @generated
	 */
	BlockOutputPort createBlockOutputPort();

	/**
	 * Returns a new object of class '<em>Subsystem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem</em>'.
	 * @generated
	 */
	Subsystem createSubsystem();

	/**
	 * Returns a new object of class '<em>System Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Interface</em>'.
	 * @generated
	 */
	SystemInterface createSystemInterface();

	/**
	 * Returns a new object of class '<em>Inlet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inlet</em>'.
	 * @generated
	 */
	Inlet createInlet();

	/**
	 * Returns a new object of class '<em>Outlet</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outlet</em>'.
	 * @generated
	 */
	Outlet createOutlet();

	/**
	 * Returns a new object of class '<em>Inport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inport</em>'.
	 * @generated
	 */
	Inport createInport();

	/**
	 * Returns a new object of class '<em>Inport Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Inport Input</em>'.
	 * @generated
	 */
	InportInput createInportInput();

	/**
	 * Returns a new object of class '<em>Outport</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outport</em>'.
	 * @generated
	 */
	Outport createOutport();

	/**
	 * Returns a new object of class '<em>Outport Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outport Output</em>'.
	 * @generated
	 */
	OutportOutput createOutportOutput();

	/**
	 * Returns a new object of class '<em>Subsystem Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem Input</em>'.
	 * @generated
	 */
	SubsystemInput createSubsystemInput();

	/**
	 * Returns a new object of class '<em>Subsystem Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem Output</em>'.
	 * @generated
	 */
	SubsystemOutput createSubsystemOutput();

	/**
	 * Returns a new object of class '<em>Subsystem Realization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem Realization</em>'.
	 * @generated
	 */
	SubsystemRealization createSubsystemRealization();

	/**
	 * Returns a new object of class '<em>Boolean Direct Feedthrough Policy</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Direct Feedthrough Policy</em>'.
	 * @generated
	 */
	BooleanDirectFeedthroughPolicy createBooleanDirectFeedthroughPolicy();

	/**
	 * Returns a new object of class '<em>Latch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Latch</em>'.
	 * @generated
	 */
	Latch createLatch();

	/**
	 * Returns a new object of class '<em>Latch Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Latch Input</em>'.
	 * @generated
	 */
	LatchInput createLatchInput();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>Choice Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Input</em>'.
	 * @generated
	 */
	ChoiceInput createChoiceInput();

	/**
	 * Returns a new object of class '<em>Choice Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice Input Port</em>'.
	 * @generated
	 */
	ChoiceInputPort createChoiceInputPort();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	Action createAction();

	/**
	 * Returns a new object of class '<em>Action Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Link</em>'.
	 * @generated
	 */
	ActionLink createActionLink();

	/**
	 * Returns a new object of class '<em>Join</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Join</em>'.
	 * @generated
	 */
	Join createJoin();

	/**
	 * Returns a new object of class '<em>Join Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Join Input</em>'.
	 * @generated
	 */
	JoinInput createJoinInput();

	/**
	 * Returns a new object of class '<em>While Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Loop</em>'.
	 * @generated
	 */
	WhileLoop createWhileLoop();

	/**
	 * Returns a new object of class '<em>While Loop Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Loop Condition</em>'.
	 * @generated
	 */
	WhileLoopCondition createWhileLoopCondition();

	/**
	 * Returns a new object of class '<em>Memory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory</em>'.
	 * @generated
	 */
	Memory createMemory();

	/**
	 * Returns a new object of class '<em>Memory Initial Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Initial Condition</em>'.
	 * @generated
	 */
	MemoryInitialCondition createMemoryInitialCondition();

	/**
	 * Returns a new object of class '<em>Memory Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Input</em>'.
	 * @generated
	 */
	MemoryInput createMemoryInput();

	/**
	 * Returns a new object of class '<em>Memory Output</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Memory Output</em>'.
	 * @generated
	 */
	MemoryOutput createMemoryOutput();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DMLPackage getDMLPackage();

} //DMLFactory
