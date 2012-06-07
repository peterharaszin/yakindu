/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.execution.ExecutionPackage
 * @generated
 */
public interface ExecutionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionFactory eINSTANCE = org.eclipselabs.damos.execution.impl.ExecutionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flow</em>'.
	 * @generated
	 */
	ExecutionFlow createExecutionFlow();

	/**
	 * Returns a new object of class '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Graph</em>'.
	 * @generated
	 */
	Graph createGraph();

	/**
	 * Returns a new object of class '<em>Component Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Node</em>'.
	 * @generated
	 */
	ComponentNode createComponentNode();

	/**
	 * Returns a new object of class '<em>Latch Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Latch Node</em>'.
	 * @generated
	 */
	LatchNode createLatchNode();

	/**
	 * Returns a new object of class '<em>Compound Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound Node</em>'.
	 * @generated
	 */
	CompoundNode createCompoundNode();

	/**
	 * Returns a new object of class '<em>Action Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Node</em>'.
	 * @generated
	 */
	ActionNode createActionNode();

	/**
	 * Returns a new object of class '<em>Subsystem Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem Node</em>'.
	 * @generated
	 */
	SubsystemNode createSubsystemNode();

	/**
	 * Returns a new object of class '<em>Task Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Graph</em>'.
	 * @generated
	 */
	TaskGraph createTaskGraph();

	/**
	 * Returns a new object of class '<em>Task Input Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Input Node</em>'.
	 * @generated
	 */
	TaskInputNode createTaskInputNode();

	/**
	 * Returns a new object of class '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Edge</em>'.
	 * @generated
	 */
	Edge createEdge();

	/**
	 * Returns a new object of class '<em>Data Flow</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Flow</em>'.
	 * @generated
	 */
	DataFlow createDataFlow();

	/**
	 * Returns a new object of class '<em>Data Flow Source End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Flow Source End</em>'.
	 * @generated
	 */
	DataFlowSourceEnd createDataFlowSourceEnd();

	/**
	 * Returns a new object of class '<em>Data Flow Target End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Flow Target End</em>'.
	 * @generated
	 */
	DataFlowTargetEnd createDataFlowTargetEnd();

	/**
	 * Returns a new object of class '<em>Port Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Info</em>'.
	 * @generated
	 */
	PortInfo createPortInfo();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExecutionPackage getExecutionPackage();

} //ExecutionFactory
