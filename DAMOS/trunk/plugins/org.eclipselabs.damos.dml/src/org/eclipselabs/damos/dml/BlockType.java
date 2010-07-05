/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.BlockType#getInputDefinitions <em>Input Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.BlockType#getOutputDefinitions <em>Output Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockType()
 * @model
 * @generated
 */
public interface BlockType extends QualifiedElement, CategorizedElement, ParameterableElement {
	/**
	 * Returns the value of the '<em><b>Input Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.InputDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Definitions</em>' containment reference list.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockType_InputDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputDefinition> getInputDefinitions();

	/**
	 * Returns the value of the '<em><b>Output Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.OutputDefinition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Definitions</em>' containment reference list.
	 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockType_OutputDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputDefinition> getOutputDefinitions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	Block newInstance(String name);

} // BlockType
