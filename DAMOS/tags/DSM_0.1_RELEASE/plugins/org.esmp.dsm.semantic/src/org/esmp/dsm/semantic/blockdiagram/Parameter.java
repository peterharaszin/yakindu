/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Parameter#getValue <em>Value</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.Parameter#getDescriptor <em>Descriptor</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getParameter_Value()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Parameter#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptor</em>' reference.
	 * @see #setDescriptor(ParameterDescriptor)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getParameter_Descriptor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ParameterDescriptor getDescriptor();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.Parameter#getDescriptor <em>Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Descriptor</em>' reference.
	 * @see #getDescriptor()
	 * @generated
	 */
	void setDescriptor(ParameterDescriptor value);
} // Parameter
