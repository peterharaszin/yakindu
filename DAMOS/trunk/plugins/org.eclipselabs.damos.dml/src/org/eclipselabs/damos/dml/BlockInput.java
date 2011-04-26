/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Input</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.BlockInput#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockInput()
 * @model
 * @generated
 */
public interface BlockInput extends Input, BlockInoutput {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(InputDefinition)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockInput_Definition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InputDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.BlockInput#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(InputDefinition value);
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.Input#createPort()
	 */
	public BlockInputPort createPort();

} // BlockInput
