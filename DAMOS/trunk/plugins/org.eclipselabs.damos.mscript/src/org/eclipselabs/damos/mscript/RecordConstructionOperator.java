/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct Construction Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.RecordConstructionOperator#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.RecordConstructionOperator#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getRecordConstructionOperator()
 * @model
 * @generated
 */
public interface RecordConstructionOperator extends Expression {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getRecordConstructionOperator_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.RecordConstructionOperator#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.RecordConstructionMember}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getRecordConstructionOperator_Members()
	 * @model containment="true"
	 * @generated
	 */
	EList<RecordConstructionMember> getMembers();

} // RecordConstructionOperator
