/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.BlockType#getFamilyId <em>Family Id</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.BlockType#getInputDefinitions <em>Input Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.BlockType#getOutputDefinitions <em>Output Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.BlockType#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.BlockType#getTiming <em>Timing</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockType()
 * @model
 * @generated
 */
public interface BlockType extends EModelElement, QualifiedElement, CategorizedElement, ParameterableElement {
	/**
	 * Returns the value of the '<em><b>Family Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Family Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Family Id</em>' attribute.
	 * @see #setFamilyId(String)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockType_FamilyId()
	 * @model
	 * @generated
	 */
	String getFamilyId();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.BlockType#getFamilyId <em>Family Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Family Id</em>' attribute.
	 * @see #getFamilyId()
	 * @generated
	 */
	void setFamilyId(String value);

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
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference.
	 * @see #isSetBehavior()
	 * @see #unsetBehavior()
	 * @see #setBehavior(BehaviorSpecification)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockType_Behavior()
	 * @model containment="true" unsettable="true" ordered="false"
	 * @generated
	 */
	BehaviorSpecification getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.BlockType#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' containment reference.
	 * @see #isSetBehavior()
	 * @see #unsetBehavior()
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(BehaviorSpecification value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.dml.BlockType#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBehavior()
	 * @see #getBehavior()
	 * @see #setBehavior(BehaviorSpecification)
	 * @generated
	 */
	void unsetBehavior();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.dml.BlockType#getBehavior <em>Behavior</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Behavior</em>' containment reference is set.
	 * @see #unsetBehavior()
	 * @see #getBehavior()
	 * @see #setBehavior(BehaviorSpecification)
	 * @generated
	 */
	boolean isSetBehavior();

	/**
	 * Returns the value of the '<em><b>Timing</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.damos.dml.TimingKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sample Time Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timing</em>' attribute.
	 * @see org.eclipselabs.damos.dml.TimingKind
	 * @see #setTiming(TimingKind)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockType_Timing()
	 * @model required="true"
	 * @generated
	 */
	TimingKind getTiming();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.BlockType#getTiming <em>Timing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timing</em>' attribute.
	 * @see org.eclipselabs.damos.dml.TimingKind
	 * @see #getTiming()
	 * @generated
	 */
	void setTiming(TimingKind value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	Block newInstance(String name);

} // BlockType
