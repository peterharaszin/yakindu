/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage
 * @generated
 */
public interface ExecutionModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionModelFactory eINSTANCE = org.eclipselabs.damos.execution.executionmodel.impl.ExecutionModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Execution Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Model</em>'.
	 * @generated
	 */
	ExecutionModel createExecutionModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExecutionModelPackage getExecutionModelPackage();

} //ExecutionModelFactory
