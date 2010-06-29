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
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Output#getSpecification <em>Specification</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Output#getBlock <em>Block</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Output#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends EObject {
	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.OutputPort}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getOutput_Ports()
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutput
	 * @model opposite="output" containment="true" required="true"
	 * @generated
	 */
	EList<OutputPort> getPorts();

	/**
	 * Returns the value of the '<em><b>Block</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Block#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block</em>' container reference.
	 * @see #setBlock(Block)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getOutput_Block()
	 * @see org.esmp.dsm.semantic.blockdiagram.Block#getOutputs
	 * @model opposite="outputs" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Block getBlock();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Output#getBlock <em>Block</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Block</em>' container reference.
	 * @see #getBlock()
	 * @generated
	 */
	void setBlock(Block value);

	/**
	 * Returns the value of the '<em><b>Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specification</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specification</em>' reference.
	 * @see #setSpecification(OutputSpecification)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getOutput_Specification()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputSpecification getSpecification();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Output#getSpecification <em>Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Specification</em>' reference.
	 * @see #getSpecification()
	 * @generated
	 */
	void setSpecification(OutputSpecification value);

} // Output
