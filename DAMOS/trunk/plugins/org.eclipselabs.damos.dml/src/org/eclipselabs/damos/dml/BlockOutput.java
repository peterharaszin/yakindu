/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.BlockOutput#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockOutput()
 * @model
 * @generated
 */
public interface BlockOutput extends Output, BlockInoutput {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(OutputDefinition)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockOutput_Definition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OutputDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.BlockOutput#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(OutputDefinition value);
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.Output#createPort()
	 */
	public BlockOutputPort createPort();

} // BlockOutput
