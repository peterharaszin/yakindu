/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutput <em>Output</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutgoingConnections <em>Outgoing Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getOutputPort()
 * @model
 * @generated
 */
public interface OutputPort extends Port {
	/**
	 * Returns the value of the '<em><b>Output</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Output#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output</em>' container reference.
	 * @see #setOutput(Output)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getOutputPort_Output()
	 * @see org.esmp.dsm.semantic.blockdiagram.Output#getPorts
	 * @model opposite="ports" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Output getOutput();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.OutputPort#getOutput <em>Output</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' container reference.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(Output value);

	/**
	 * Returns the value of the '<em><b>Outgoing Connections</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.Connection}.
	 * It is bidirectional and its opposite is '{@link org.esmp.dsm.semantic.blockdiagram.Connection#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Connections</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Connections</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getOutputPort_OutgoingConnections()
	 * @see org.esmp.dsm.semantic.blockdiagram.Connection#getSourcePort
	 * @model opposite="sourcePort" ordered="false"
	 * @generated
	 */
	EList<Connection> getOutgoingConnections();

} // OutputPort
