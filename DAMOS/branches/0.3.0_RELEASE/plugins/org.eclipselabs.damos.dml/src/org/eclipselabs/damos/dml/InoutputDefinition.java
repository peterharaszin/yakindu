/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inoutput Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getMinimumPortCount <em>Minimum Port Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getMaximumPortCount <em>Maximum Port Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getDefaultPortCount <em>Default Port Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#isManyPorts <em>Many Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#isTestPoint <em>Test Point</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#isSocket <em>Socket</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.InoutputDefinition#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition()
 * @model abstract="true"
 * @generated
 */
public interface InoutputDefinition extends ParameterableElement, INamedElement {
	/**
	 * Returns the value of the '<em><b>Minimum Port Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Port Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Port Count</em>' attribute.
	 * @see #setMinimumPortCount(int)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_MinimumPortCount()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMinimumPortCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getMinimumPortCount <em>Minimum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Port Count</em>' attribute.
	 * @see #getMinimumPortCount()
	 * @generated
	 */
	void setMinimumPortCount(int value);

	/**
	 * Returns the value of the '<em><b>Maximum Port Count</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Port Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Port Count</em>' attribute.
	 * @see #setMaximumPortCount(int)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_MaximumPortCount()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMaximumPortCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getMaximumPortCount <em>Maximum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Port Count</em>' attribute.
	 * @see #getMaximumPortCount()
	 * @generated
	 */
	void setMaximumPortCount(int value);

	/**
	 * Returns the value of the '<em><b>Default Port Count</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Port Count</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Port Count</em>' attribute.
	 * @see #setDefaultPortCount(int)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_DefaultPortCount()
	 * @model default="-1" required="true" ordered="false"
	 * @generated
	 */
	int getDefaultPortCount();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getDefaultPortCount <em>Default Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Port Count</em>' attribute.
	 * @see #getDefaultPortCount()
	 * @generated
	 */
	void setDefaultPortCount(int value);

	/**
	 * Returns the value of the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Ports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Ports</em>' attribute.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_ManyPorts()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isManyPorts();

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
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Test Point</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Point</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Point</em>' attribute.
	 * @see #setTestPoint(boolean)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_TestPoint()
	 * @model required="true"
	 * @generated
	 */
	boolean isTestPoint();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#isTestPoint <em>Test Point</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Test Point</em>' attribute.
	 * @see #isTestPoint()
	 * @generated
	 */
	void setTestPoint(boolean value);

	/**
	 * Returns the value of the '<em><b>Socket</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Socket</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Socket</em>' attribute.
	 * @see #setSocket(boolean)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_Socket()
	 * @model required="true"
	 * @generated
	 */
	boolean isSocket();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#isSocket <em>Socket</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Socket</em>' attribute.
	 * @see #isSocket()
	 * @generated
	 */
	void setSocket(boolean value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' containment reference.
	 * @see #isSetDataType()
	 * @see #unsetDataType()
	 * @see #setDataType(DataTypeSpecification)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getInoutputDefinition_DataType()
	 * @model containment="true" unsettable="true" ordered="false"
	 * @generated
	 */
	DataTypeSpecification getDataType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getDataType <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' containment reference.
	 * @see #isSetDataType()
	 * @see #unsetDataType()
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataTypeSpecification value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getDataType <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetDataType()
	 * @see #getDataType()
	 * @see #setDataType(DataTypeSpecification)
	 * @generated
	 */
	void unsetDataType();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.dml.InoutputDefinition#getDataType <em>Data Type</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Data Type</em>' containment reference is set.
	 * @see #unsetDataType()
	 * @see #getDataType()
	 * @see #setDataType(DataTypeSpecification)
	 * @generated
	 */
	boolean isSetDataType();

} // InoutputDefinition
