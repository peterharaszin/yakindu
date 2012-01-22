/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.mscript.Declaration;
import org.eclipselabs.damos.mscript.ImportDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mscript Block Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptBlockType#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptBlockType#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptBlockType()
 * @model
 * @generated
 */
public interface MscriptBlockType extends BlockType {
	/**
	 * Returns the value of the '<em><b>Import Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.ImportDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptBlockType_ImportDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportDeclaration> getImportDeclarations();

	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.Declaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptBlockType_Declarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Declaration> getDeclarations();

} // MscriptBlockType
