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
	 * Returns a new object of class '<em>Dscript Input Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dscript Input Definition</em>'.
	 * @generated
	 */
	DscriptInputDefinition createDscriptInputDefinition();

	/**
	 * Returns a new object of class '<em>Dscript Output Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dscript Output Definition</em>'.
	 * @generated
	 */
	DscriptOutputDefinition createDscriptOutputDefinition();

	/**
	 * Returns a new object of class '<em>Dscript Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dscript Parameter</em>'.
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
