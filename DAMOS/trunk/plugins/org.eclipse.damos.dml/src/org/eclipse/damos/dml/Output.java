/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Output#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Output#getPorts <em>Ports</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends Inoutput {
	/**
	 * Returns the value of the '<em><b>Component</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.Component#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' container reference.
	 * @see #setComponent(Component)
	 * @see org.eclipse.damos.dml.DMLPackage#getOutput_Component()
	 * @see org.eclipse.damos.dml.Component#getOutputs
	 * @model opposite="outputs" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Output#getComponent <em>Component</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' container reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.OutputPort}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.OutputPort#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getOutput_Ports()
	 * @see org.eclipse.damos.dml.OutputPort#getOutput
	 * @model opposite="output" containment="true"
	 * @generated
	 */
	EList<OutputPort> getPorts();
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.Inoutput#createPort()
	 */
	public OutputPort createPort();

} // Output
