/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage
 * @generated
 */
public interface FunctionModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FunctionModelFactory eINSTANCE = org.eclipselabs.damos.mscript.functionmodel.impl.FunctionModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Function Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Description</em>'.
	 * @generated
	 */
	FunctionDescription createFunctionDescription();

	/**
	 * Returns a new object of class '<em>Equation Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation Description</em>'.
	 * @generated
	 */
	EquationDescription createEquationDescription();

	/**
	 * Returns a new object of class '<em>Equation Side</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation Side</em>'.
	 * @generated
	 */
	EquationSide createEquationSide();

	/**
	 * Returns a new object of class '<em>Equation Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation Part</em>'.
	 * @generated
	 */
	EquationPart createEquationPart();

	/**
	 * Returns a new object of class '<em>Variable Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Description</em>'.
	 * @generated
	 */
	VariableDescription createVariableDescription();

	/**
	 * Returns a new object of class '<em>Variable Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Step</em>'.
	 * @generated
	 */
	VariableStep createVariableStep();

	/**
	 * Returns a new object of class '<em>Function Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Instance</em>'.
	 * @generated
	 */
	FunctionInstance createFunctionInstance();

	/**
	 * Returns a new object of class '<em>Computation Compound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation Compound</em>'.
	 * @generated
	 */
	ComputationCompound createComputationCompound();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FunctionModelPackage getFunctionModelPackage();

} //FunctionModelFactory
