/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Parameter Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor#getDefaultValue <em>Default Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getExpressionParameterDescriptor()
 * @model
 * @generated
 */
public interface ExpressionParameterDescriptor extends ParameterDescriptor {
	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <p>
	 * This feature redefines the following features:
	 * <ul>
	 *   <li>'{@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor#getDefaultValue() <em>Default Value</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getExpressionParameterDescriptor_DefaultValue()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

} // ExpressionParameterDescriptor
