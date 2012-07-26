/**
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.CompositeType#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.CompositeType#isAnyLabel <em>Any Label</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.CompositeType#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCompositeType()
 * @model abstract="true"
 * @generated
 */
public interface CompositeType extends DataType {
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
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCompositeType_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.CompositeType#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Any Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Any Label</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Any Label</em>' attribute.
	 * @see #setAnyLabel(boolean)
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCompositeType_AnyLabel()
	 * @model
	 * @generated
	 */
	boolean isAnyLabel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.CompositeType#isAnyLabel <em>Any Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Any Label</em>' attribute.
	 * @see #isAnyLabel()
	 * @generated
	 */
	void setAnyLabel(boolean value);

	/**
	 * Returns the value of the '<em><b>Members</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.CompositeTypeMember}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#getCompositeType_Members()
	 * @model containment="true"
	 * @generated
	 */
	EList<CompositeTypeMember> getMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	CompositeTypeMember getMember(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	int getMemberIndex(String name);

} // CompositeType
