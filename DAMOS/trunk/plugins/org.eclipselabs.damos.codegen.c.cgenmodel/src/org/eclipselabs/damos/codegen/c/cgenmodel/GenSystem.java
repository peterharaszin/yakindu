/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getGenSubsystems <em>Gen Subsystems</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getPrefix <em>Prefix</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenSystem()
 * @model abstract="true"
 * @generated
 */
public interface GenSystem extends EObject {
	/**
	 * Returns the value of the '<em><b>Gen Subsystems</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gen Subsystems</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gen Subsystems</em>' containment reference list.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenSystem_GenSubsystems()
	 * @model containment="true"
	 * @generated
	 */
	EList<GenSubsystem> getGenSubsystems();

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prefix</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenSystem_Prefix()
	 * @model
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

} // GenSystem
