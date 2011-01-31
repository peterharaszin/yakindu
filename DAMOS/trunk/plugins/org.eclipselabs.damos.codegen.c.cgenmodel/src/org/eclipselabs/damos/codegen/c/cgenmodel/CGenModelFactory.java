/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage
 * @generated
 */
public interface CGenModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CGenModelFactory eINSTANCE = org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Model</em>'.
	 * @generated
	 */
	GenModel createGenModel();

	/**
	 * Returns a new object of class '<em>Gen Top Level System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Top Level System</em>'.
	 * @generated
	 */
	GenTopLevelSystem createGenTopLevelSystem();

	/**
	 * Returns a new object of class '<em>Gen Subsystem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gen Subsystem</em>'.
	 * @generated
	 */
	GenSubsystem createGenSubsystem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CGenModelPackage getCGenModelPackage();

} //CGenModelFactory
