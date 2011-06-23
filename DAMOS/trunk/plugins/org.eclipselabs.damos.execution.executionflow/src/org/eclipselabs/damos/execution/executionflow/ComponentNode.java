/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionflow;

import org.eclipselabs.damos.dml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.ComponentNode#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executionflow.ComponentNode#getSampleTime <em>Sample Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getComponentNode()
 * @model
 * @generated
 */
public interface ComponentNode extends Node {
	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(Component)
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getComponentNode_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionflow.ComponentNode#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(Component value);

	/**
	 * Returns the value of the '<em><b>Sample Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sample Time</em>' attribute.
	 * @see #setSampleTime(double)
	 * @see org.eclipselabs.damos.execution.executionflow.ExecutionFlowPackage#getComponentNode_SampleTime()
	 * @model required="true"
	 * @generated
	 */
	double getSampleTime();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.executionflow.ComponentNode#getSampleTime <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Time</em>' attribute.
	 * @see #getSampleTime()
	 * @generated
	 */
	void setSampleTime(double value);

} // ComponentNode
