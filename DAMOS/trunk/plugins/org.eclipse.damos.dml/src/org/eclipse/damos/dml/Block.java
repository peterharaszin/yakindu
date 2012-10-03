/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Block#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getBlock()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidInputDefinitionReferences ValidOutputDefinitionReferences ValidParameterReferences'"
 * @generated
 */
public interface Block extends Component, ParameterizedElement {
	
	BlockInput getInput(String name);
	
	BlockOutput getOutput(String name);
	
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(BlockType)
	 * @see org.eclipse.damos.dml.DMLPackage#getBlock_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	BlockType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dml.Block#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(BlockType value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model definitionRequired="true"
	 * @generated
	 */
	BlockInput getInput(InputDefinition definition);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model definitionRequired="true"
	 * @generated
	 */
	BlockOutput getOutput(OutputDefinition definition);

} // Block
