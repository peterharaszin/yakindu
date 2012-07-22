/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.functionmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.InputParameterDeclaration;
import org.eclipselabs.damos.mscript.OutputParameterDeclaration;
import org.eclipselabs.damos.mscript.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Compound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.functionmodel.ComputationCompound#getDerivatives <em>Derivatives</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getComputationCompound()
 * @model
 * @generated
 */
public interface ComputationCompound extends CompoundStatement {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.InputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getComputationCompound_Inputs()
	 * @model
	 * @generated
	 */
	EList<InputParameterDeclaration> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.OutputParameterDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getComputationCompound_Outputs()
	 * @model
	 * @generated
	 */
	EList<OutputParameterDeclaration> getOutputs();

	/**
	 * Returns the value of the '<em><b>Derivatives</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivatives</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivatives</em>' reference list.
	 * @see org.eclipselabs.damos.mscript.functionmodel.FunctionModelPackage#getComputationCompound_Derivatives()
	 * @model
	 * @generated
	 */
	EList<VariableDeclaration> getDerivatives();

} // ComputationCompound
