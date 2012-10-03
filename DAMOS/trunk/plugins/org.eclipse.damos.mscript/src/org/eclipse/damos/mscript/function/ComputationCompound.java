/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.function;

import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.InputParameterDeclaration;
import org.eclipse.damos.mscript.OutputParameterDeclaration;
import org.eclipse.damos.mscript.VariableDeclaration;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Compound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.function.ComputationCompound#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.ComputationCompound#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.function.ComputationCompound#getDerivatives <em>Derivatives</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.function.FunctionPackage#getComputationCompound()
 * @model
 * @generated
 */
public interface ComputationCompound extends CompoundStatement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.InputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getComputationCompound_Inputs()
	 * @model
	 * @generated
	 */
	EList<InputParameterDeclaration> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.OutputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getComputationCompound_Outputs()
	 * @model
	 * @generated
	 */
	EList<OutputParameterDeclaration> getOutputs();

	/**
	 * Returns the value of the '<em><b>Derivatives</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivatives</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivatives</em>' reference list.
	 * @see org.eclipse.damos.mscript.function.FunctionPackage#getComputationCompound_Derivatives()
	 * @model
	 * @generated
	 */
	EList<VariableDeclaration> getDerivatives();

} // ComputationCompound
