/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution;

import org.eclipse.damos.dml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.ComponentNode#getComponent <em>Component</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.ComponentNode#getSampleTime <em>Sample Time</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.ComponentNode#getAsynchronousZone <em>Asynchronous Zone</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.execution.ExecutionPackage#getComponentNode()
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
	 * @see org.eclipse.damos.execution.ExecutionPackage#getComponentNode_Component()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Component getComponent();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.ComponentNode#getComponent <em>Component</em>}' reference.
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
	 * @see org.eclipse.damos.execution.ExecutionPackage#getComponentNode_SampleTime()
	 * @model required="true"
	 * @generated
	 */
	double getSampleTime();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.ComponentNode#getSampleTime <em>Sample Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sample Time</em>' attribute.
	 * @see #getSampleTime()
	 * @generated
	 */
	void setSampleTime(double value);

	/**
	 * Returns the value of the '<em><b>Asynchronous Zone</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asynchronous Zone</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asynchronous Zone</em>' attribute.
	 * @see #setAsynchronousZone(int)
	 * @see org.eclipse.damos.execution.ExecutionPackage#getComponentNode_AsynchronousZone()
	 * @model default="-1"
	 * @generated
	 */
	int getAsynchronousZone();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.execution.ComponentNode#getAsynchronousZone <em>Asynchronous Zone</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asynchronous Zone</em>' attribute.
	 * @see #getAsynchronousZone()
	 * @generated
	 */
	void setAsynchronousZone(int value);

} // ComponentNode
