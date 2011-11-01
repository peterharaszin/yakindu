/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel;

import org.eclipselabs.damos.dml.Fragment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Top Level System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem#getFragment <em>Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenTopLevelSystem()
 * @model
 * @generated
 */
public interface GenTopLevelSystem extends GenSystem {
	/**
	 * Returns the value of the '<em><b>Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment</em>' reference.
	 * @see #setFragment(Fragment)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getGenTopLevelSystem_Fragment()
	 * @model
	 * @generated
	 */
	Fragment getFragment();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem#getFragment <em>Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment</em>' reference.
	 * @see #getFragment()
	 * @generated
	 */
	void setFragment(Fragment value);

} // GenTopLevelSystem
