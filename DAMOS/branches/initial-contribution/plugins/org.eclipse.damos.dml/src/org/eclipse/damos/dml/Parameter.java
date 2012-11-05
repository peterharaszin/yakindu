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
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Parameter#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Parameter#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Parameter#getOwnedDefaultValue <em>Owned Default Value</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Parameter#getPredefinedValues <em>Predefined Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends INamedElement {

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.damos.dml.DMLPackage#getParameter_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Parameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' containment reference.
	 * @see #setDataType(DataTypeSpecification)
	 * @see org.eclipse.damos.dml.DMLPackage#getParameter_DataType()
	 * @model containment="true"
	 * @generated
	 */
	DataTypeSpecification getDataType();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Parameter#getDataType <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' containment reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataTypeSpecification value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.damos.dml.ParameterVisibilityKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.damos.dml.ParameterVisibilityKind
	 * @see #setVisibility(ParameterVisibilityKind)
	 * @see org.eclipse.damos.dml.DMLPackage#getParameter_Visibility()
	 * @model
	 * @generated
	 */
	ParameterVisibilityKind getVisibility();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Parameter#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.eclipse.damos.dml.ParameterVisibilityKind
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(ParameterVisibilityKind value);

	/**
	 * Returns the value of the '<em><b>Owned Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Default Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Default Value</em>' containment reference.
	 * @see #setOwnedDefaultValue(ValueSpecification)
	 * @see org.eclipse.damos.dml.DMLPackage#getParameter_OwnedDefaultValue()
	 * @model containment="true"
	 * @generated
	 */
	ValueSpecification getOwnedDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Parameter#getOwnedDefaultValue <em>Owned Default Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Default Value</em>' containment reference.
	 * @see #getOwnedDefaultValue()
	 * @generated
	 */
	void setOwnedDefaultValue(ValueSpecification value);

	/**
	 * Returns the value of the '<em><b>Predefined Values</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.ParameterPredefinedValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predefined Values</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predefined Values</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getParameter_PredefinedValues()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterPredefinedValue> getPredefinedValues();

	/**
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	ValueSpecification getDefaultValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" stringValueRequired="true" stringValueOrdered="false"
	 * @generated
	 */
	ParameterPredefinedValue getPredefinedValue(String stringValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" aliasRequired="true" aliasOrdered="false"
	 * @generated
	 */
	ParameterPredefinedValue getPredefinedValueByAlias(String alias);
} // Parameter
