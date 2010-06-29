/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Input#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Input#getBlock <em>Block</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Input#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInput()
 * @model
 * @generated
 */
public interface Input extends EObject {
	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.InputPort}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.InputPort#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInput_Ports()
	 * @see org.esmp.dsm.semantic.blockdiagram.InputPort#getInput
	 * @model opposite="input" containment="true" required="true"
	 * @generated
	 */
	EList<InputPort> getPorts();

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference.
	 * @see #setSpecification(InputSpecification)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInput_Specification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InputSpecification getSpecification();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Input#getSpecification <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(InputSpecification value);

	/**
	 * Returns the value of the '<em><b>Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Block#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' container reference.
	 * @see #setBlock(Block)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getInput_Block()
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getInputs
	 * @model opposite="inputs" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Input#getBlock <em>Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' container reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

} // Input
