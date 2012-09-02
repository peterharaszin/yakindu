/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.computation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.computation.ComputationPackage
 * @generated
 */
public interface ComputationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ComputationFactory eINSTANCE = org.eclipselabs.damos.mscript.computation.impl.ComputationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Floating Point Format</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Floating Point Format</em>'.
	 * @generated
	 */
	FloatingPointFormat createFloatingPointFormat();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ComputationPackage getComputationPackage();

	/**
	 * Returns a new object of class '<em>Fixed Point Format</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Point Format</em>'.
	 * @generated
	 */
	FixedPointFormat createFixedPointFormat();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	ComputationModel createComputationModel();

	/**
	 * Returns a new object of class '<em>Number Format Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Number Format Mapping</em>'.
	 * @generated
	 */
	NumberFormatMapping createNumberFormatMapping();

} //ComputationModelFactory
