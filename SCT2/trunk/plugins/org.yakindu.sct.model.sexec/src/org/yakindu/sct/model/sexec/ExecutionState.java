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
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getSimpleName <em>Simple Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#isLeaf <em>Leaf</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getCycle <em>Cycle</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getReactions <em>Reactions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getExitAction <em>Exit Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState()
 * @model
 * @generated
 */
public interface ExecutionState extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Simple Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Name</em>' attribute.
	 * @see #setSimpleName(String)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_SimpleName()
	 * @model
	 * @generated
	 */
	String getSimpleName();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getSimpleName <em>Simple Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Name</em>' attribute.
	 * @see #getSimpleName()
	 * @generated
	 */
	void setSimpleName(String value);

	/**
	 * Returns the value of the '<em><b>Cycle</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cycle</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cycle</em>' containment reference.
	 * @see #setCycle(Cycle)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_Cycle()
	 * @model containment="true"
	 * @generated
	 */
	Cycle getCycle();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getCycle <em>Cycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cycle</em>' containment reference.
	 * @see #getCycle()
	 * @generated
	 */
	void setCycle(Cycle value);

	/**
	 * Returns the value of the '<em><b>Reactions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sexec.Reaction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reactions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reactions</em>' containment reference list.
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_Reactions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Reaction> getReactions();

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
