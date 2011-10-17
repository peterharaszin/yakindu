/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.SystemInterface;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.Root#getBlockTypes <em>Block Types</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dmltext.Root#getSystemInterfaces <em>System Interfaces</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getRoot()
 * @model abstract="true"
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Block Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.BlockType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Block Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Block Types</em>' containment reference list.
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getRoot_BlockTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<BlockType> getBlockTypes();

	/**
	 * Returns the value of the '<em><b>System Interfaces</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dml.SystemInterface}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System Interfaces</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System Interfaces</em>' containment reference list.
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getRoot_SystemInterfaces()
	 * @model containment="true"
	 * @generated
	 */
	EList<SystemInterface> getSystemInterfaces();

} // Root
