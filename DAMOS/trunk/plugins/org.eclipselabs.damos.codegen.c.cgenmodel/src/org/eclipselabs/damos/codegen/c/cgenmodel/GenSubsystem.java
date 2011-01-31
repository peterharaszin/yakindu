/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel;

import org.eclipselabs.damos.dml.Subsystem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Subsystem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getSubsystem <em>Subsystem</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenSubsystem()
 * @model
 * @generated
 */
public interface GenSubsystem extends GenSystem {
	/**
	 * Returns the value of the '<em><b>Subsystem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystem</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystem</em>' reference.
	 * @see #setSubsystem(Subsystem)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenSubsystem_Subsystem()
	 * @model required="true"
	 * @generated
	 */
	Subsystem getSubsystem();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getSubsystem <em>Subsystem</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subsystem</em>' reference.
	 * @see #getSubsystem()
	 * @generated
	 */
	void setSubsystem(Subsystem value);

} // GenSubsystem
