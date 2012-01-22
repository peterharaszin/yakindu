/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage
 * @generated
 */
public interface DMLTextFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DMLTextFactory eINSTANCE = org.eclipselabs.damos.dmltext.impl.DMLTextFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Mscript Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mscript Block Type</em>'.
	 * @generated
	 */
	MscriptBlockType createMscriptBlockType();

	/**
	 * Returns a new object of class '<em>Mscript System Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mscript System Interface</em>'.
	 * @generated
	 */
	MscriptSystemInterface createMscriptSystemInterface();

	/**
	 * Returns a new object of class '<em>Mscript Data Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mscript Data Type Specification</em>'.
	 * @generated
	 */
	MscriptDataTypeSpecification createMscriptDataTypeSpecification();

	/**
	 * Returns a new object of class '<em>Mscript Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mscript Value Specification</em>'.
	 * @generated
	 */
	MscriptValueSpecification createMscriptValueSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DMLTextPackage getDMLTextPackage();

} //DMLTextFactory
