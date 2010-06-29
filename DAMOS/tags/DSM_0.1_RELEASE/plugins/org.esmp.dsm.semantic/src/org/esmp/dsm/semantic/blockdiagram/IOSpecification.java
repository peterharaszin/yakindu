/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IO Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMinimumPortCount <em>Minimum Port Count</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMaximumPortCount <em>Maximum Port Count</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#isManyPorts <em>Many Ports</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getIOSpecification()
 * @model abstract="true"
 * @generated
 */
public interface IOSpecification extends NamedElement, ParameterDescriptorContainer {
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
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getIOSpecification_MinimumPortCount()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMinimumPortCount();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMinimumPortCount <em>Minimum Port Count</em>}' attribute.
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
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getIOSpecification_MaximumPortCount()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getMaximumPortCount();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getMaximumPortCount <em>Maximum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Port Count</em>' attribute.
	 * @see #getMaximumPortCount()
	 * @generated
	 */
	void setMaximumPortCount(int value);

	/**
	 * Returns the value of the '<em><b>Many Ports</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Many Ports</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Many Ports</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getIOSpecification_ManyPorts()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isManyPorts();

	/**
	 * Returns the value of the '<em><b>Virtual</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual</em>' attribute.
	 * @see #setVirtual(boolean)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getIOSpecification_Virtual()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isVirtual();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#isVirtual <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual</em>' attribute.
	 * @see #isVirtual()
	 * @generated
	 */
	void setVirtual(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Scalar"</code>.
	 * The literals are from the enumeration {@link org.esmp.dsm.semantic.blockdiagram.IOType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOType
	 * @see #setType(IOType)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getIOSpecification_Type()
	 * @model default="Scalar" required="true" ordered="false"
	 * @generated
	 */
	IOType getType();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOType
	 * @see #getType()
	 * @generated
	 */
	void setType(IOType value);

} // IOSpecification
