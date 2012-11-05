/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dscript;

import org.eclipse.damos.dml.SystemInterface;
import org.eclipse.damos.mscript.ImportDeclaration;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mscript System Interface</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dscript.DscriptSystemInterface#getImportDeclarations <em>Import Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dscript.DscriptPackage#getDscriptSystemInterface()
 * @model
 * @generated
 */
public interface DscriptSystemInterface extends SystemInterface {
	/**
	 * Returns the value of the '<em><b>Import Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.ImportDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Declarations</em>' containment reference list.
	 * @see org.eclipse.damos.dscript.DscriptPackage#getDscriptSystemInterface_ImportDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportDeclaration> getImportDeclarations();

} // MscriptSystemInterface
