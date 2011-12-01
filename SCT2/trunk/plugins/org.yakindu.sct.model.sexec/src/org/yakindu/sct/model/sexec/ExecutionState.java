/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#isLeaf <em>Leaf</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getExitAction <em>Exit Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getEnterSequence <em>Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getExitSequence <em>Exit Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getStateVector <em>State Vector</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState()
 * @model
 * @generated
 */
public interface ExecutionState extends ExecutionNode {
	/**
	 * Returns the value of the '<em><b>Entry Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Action</em>' containment reference.
	 * @see #setEntryAction(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_EntryAction()
	 * @model containment="true"
	 * @generated
	 */
	Step getEntryAction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getEntryAction <em>Entry Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Action</em>' containment reference.
	 * @see #getEntryAction()
	 * @generated
	 */
	void setEntryAction(Step value);

	/**
	 * Returns the value of the '<em><b>Exit Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Action</em>' containment reference.
	 * @see #setExitAction(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_ExitAction()
	 * @model containment="true"
	 * @generated
	 */
	Step getExitAction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getExitAction <em>Exit Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Action</em>' containment reference.
	 * @see #getExitAction()
	 * @generated
	 */
	void setExitAction(Step value);

	/**
	 * Returns the value of the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enter Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enter Sequence</em>' containment reference.
	 * @see #setEnterSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_EnterSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getEnterSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getEnterSequence <em>Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enter Sequence</em>' containment reference.
	 * @see #getEnterSequence()
	 * @generated
	 */
	void setEnterSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Exit Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Sequence</em>' containment reference.
	 * @see #setExitSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_ExitSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getExitSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getExitSequence <em>Exit Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Sequence</em>' containment reference.
	 * @see #getExitSequence()
	 * @generated
	 */
	void setExitSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Vector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Vector</em>' containment reference.
	 * @see #setStateVector(StateVector)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_StateVector()
	 * @model containment="true"
	 * @generated
	 */
	StateVector getStateVector();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getStateVector <em>State Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Vector</em>' containment reference.
	 * @see #getStateVector()
	 * @generated
	 */
	void setStateVector(StateVector value);

	/**
	 * Returns the value of the '<em><b>Leaf</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf</em>' attribute.
	 * @see #setLeaf(boolean)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_Leaf()
	 * @model default="false"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#isLeaf <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leaf</em>' attribute.
	 * @see #isLeaf()
	 * @generated
	 */
	void setLeaf(boolean value);

} // ExecutionState
