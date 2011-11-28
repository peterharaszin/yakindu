/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.il;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.il.ILPackage
 * @generated
 */
public interface ILFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ILFactory eINSTANCE = org.eclipselabs.damos.mscript.il.impl.ILFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Definition</em>'.
	 * @generated
	 */
	ILFunctionDefinition createILFunctionDefinition();

	/**
	 * Returns a new object of class '<em>Computation Compound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation Compound</em>'.
	 * @generated
	 */
	ComputationCompound createComputationCompound();

	/**
	 * Returns a new object of class '<em>Variable Declaration Info</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Declaration Info</em>'.
	 * @generated
	 */
	VariableDeclarationInfo createVariableDeclarationInfo();

	/**
	 * Returns a new object of class '<em>Template Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Variable Declaration</em>'.
	 * @generated
	 */
	TemplateVariableDeclaration createTemplateVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Input Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Variable Declaration</em>'.
	 * @generated
	 */
	InputVariableDeclaration createInputVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Output Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Variable Declaration</em>'.
	 * @generated
	 */
	OutputVariableDeclaration createOutputVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Instance Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Variable Declaration</em>'.
	 * @generated
	 */
	InstanceVariableDeclaration createInstanceVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Invalid Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Expression</em>'.
	 * @generated
	 */
	InvalidExpression createInvalidExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ILPackage getILPackage();

} //ILFactory
