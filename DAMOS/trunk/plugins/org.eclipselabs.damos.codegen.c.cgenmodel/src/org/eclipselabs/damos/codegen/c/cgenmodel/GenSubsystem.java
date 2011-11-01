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
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getEnclosingGenSystem <em>Enclosing Gen System</em>}</li>
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
	 * Returns the value of the '<em><b>Enclosing Gen System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getGenSubsystems <em>Gen Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enclosing Gen System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enclosing Gen System</em>' container reference.
	 * @see #setEnclosingGenSystem(GenSystem)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenSubsystem_EnclosingGenSystem()
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getGenSubsystems
	 * @model opposite="genSubsystems" transient="false"
	 * @generated
	 */
	GenSystem getEnclosingGenSystem();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getEnclosingGenSystem <em>Enclosing Gen System</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enclosing Gen System</em>' container reference.
	 * @see #getEnclosingGenSystem()
	 * @generated
	 */
	void setEnclosingGenSystem(GenSystem value);

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
	 * @model
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
