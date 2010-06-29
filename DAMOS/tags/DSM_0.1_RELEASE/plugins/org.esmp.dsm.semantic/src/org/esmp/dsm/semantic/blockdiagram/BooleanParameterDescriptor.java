/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Parameter Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor#getDefaultBooleanValue <em>Default Boolean Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBooleanParameterDescriptor()
 * @model
 * @generated
 */
public interface BooleanParameterDescriptor extends ParameterDescriptor {
	/**
	 * Returns the value of the '<em><b>Default Boolean Value</b></em>' attribute.
	 * The default value is <code>"False"</code>.
	 * The literals are from the enumeration {@link org.esmp.dsm.semantic.blockdiagram.BooleanValue}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Boolean Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Boolean Value</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BooleanValue
	 * @see #setDefaultBooleanValue(BooleanValue)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBooleanParameterDescriptor_DefaultBooleanValue()
	 * @model default="False" required="true" ordered="false"
	 * @generated
	 */
	BooleanValue getDefaultBooleanValue();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor#getDefaultBooleanValue <em>Default Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Boolean Value</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BooleanValue
	 * @see #getDefaultBooleanValue()
	 * @generated
	 */
	void setDefaultBooleanValue(BooleanValue value);

} // BooleanParameterDescriptor
