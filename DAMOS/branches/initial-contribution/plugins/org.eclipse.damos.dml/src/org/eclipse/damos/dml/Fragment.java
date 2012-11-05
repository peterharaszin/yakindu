/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Fragment#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Fragment#getFragmentElements <em>Fragment Elements</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Fragment#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Fragment#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getFragment()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedName UniqueComponentNames'"
 * @generated
 */
public interface Fragment extends EModelElement, QualifiedElement {
	/**
	 * Returns the value of the '<em><b>Components</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.Component}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Components</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getFragment_Components()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Fragment Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.FragmentElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.FragmentElement#getOwningFragment <em>Owning Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment Elements</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getFragment_FragmentElements()
	 * @see org.eclipse.damos.dml.FragmentElement#getOwningFragment
	 * @model opposite="owningFragment" containment="true" ordered="false"
	 * @generated
	 */
	EList<FragmentElement> getFragmentElements();

	/**
	 * Returns the value of the '<em><b>Connections</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.Connection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connections</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connections</em>' reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getFragment_Connections()
	 * @model transient="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(Fragment)
	 * @see org.eclipse.damos.dml.DMLPackage#getFragment_Parent()
	 * @model ordered="false"
	 * @generated
	 */
	Fragment getParent();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Fragment#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Fragment value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Fragment> getChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<FragmentElement> getAllFragmentElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Component> getAllComponents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Connection> getAllConnections();

} // Fragment
