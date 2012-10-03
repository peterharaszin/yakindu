/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dscript;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.damos.dscript.DscriptPackage
 * @generated
 */
public interface DscriptFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DscriptFactory eINSTANCE = org.eclipse.damos.dscript.impl.DscriptFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Type</em>'.
	 * @generated
	 */
	DscriptBlockType createDscriptBlockType();

	/**
	 * Returns a new object of class '<em>Input Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Definition</em>'.
	 * @generated
	 */
	DscriptInputDefinition createDscriptInputDefinition();

	/**
	 * Returns a new object of class '<em>Output Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Definition</em>'.
	 * @generated
	 */
	DscriptOutputDefinition createDscriptOutputDefinition();

	/**
	 * Returns a new object of class '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter</em>'.
	 * @generated
	 */
	DscriptParameter createDscriptParameter();

	/**
	 * Returns a new object of class '<em>Behavior Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Behavior Declaration</em>'.
	 * @generated
	 */
	BehaviorDeclaration createBehaviorDeclaration();

	/**
	 * Returns a new object of class '<em>Input Message Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Message Parameter Declaration</em>'.
	 * @generated
	 */
	InputMessageParameterDeclaration createInputMessageParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Output Message Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Message Parameter Declaration</em>'.
	 * @generated
	 */
	OutputMessageParameterDeclaration createOutputMessageParameterDeclaration();

	/**
	 * Returns a new object of class '<em>System Interface</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Interface</em>'.
	 * @generated
	 */
	DscriptSystemInterface createDscriptSystemInterface();

	/**
	 * Returns a new object of class '<em>Data Type Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Specification</em>'.
	 * @generated
	 */
	DscriptDataTypeSpecification createDscriptDataTypeSpecification();

	/**
	 * Returns a new object of class '<em>Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Specification</em>'.
	 * @generated
	 */
	DscriptValueSpecification createDscriptValueSpecification();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DscriptPackage getDscriptPackage();

} //DscriptFactory
