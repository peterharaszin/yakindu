/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.execution.executiongraph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.esmp.dsm.execution.executiongraph.ExecutionGraphPackage
 * @generated
 */
public interface ExecutionGraphFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionGraphFactory eINSTANCE = org.esmp.dsm.execution.executiongraph.impl.ExecutionGraphFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Execution Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Graph</em>'.
	 * @generated
	 */
	ExecutionGraph createExecutionGraph();

	/**
	 * Returns a new object of class '<em>Execution Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Node</em>'.
	 * @generated
	 */
	ExecutionNode createExecutionNode();

	/**
	 * Returns a new object of class '<em>Execution Edge</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Edge</em>'.
	 * @generated
	 */
	ExecutionEdge createExecutionEdge();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExecutionGraphPackage getExecutionGraphPackage();

} //ExecutionGraphFactory
