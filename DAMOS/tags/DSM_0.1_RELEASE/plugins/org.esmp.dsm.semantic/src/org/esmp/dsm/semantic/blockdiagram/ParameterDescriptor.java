/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getParameterDescriptor()
 * @model abstract="true"
 * @generated
 */
public interface ParameterDescriptor extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getParameterDescriptor_DefaultValue()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getDefaultValue();

} // ParameterDescriptor
