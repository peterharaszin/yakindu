/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext;

import org.eclipselabs.damos.dml.BehaviorSpecification;
import org.eclipselabs.mscript.language.ast.Module;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mscript Behavior Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification#getModule <em>Module</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptBehaviorSpecification()
 * @model
 * @generated
 */
public interface MscriptBehaviorSpecification extends BehaviorSpecification {
	/**
	 * Returns the value of the '<em><b>Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' containment reference.
	 * @see #setModule(Module)
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptBehaviorSpecification_Module()
	 * @model containment="true"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification#getModule <em>Module</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' containment reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

} // MscriptBehaviorSpecification
