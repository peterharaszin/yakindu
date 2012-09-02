/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.mscript.ImportDeclaration;
import org.eclipselabs.damos.mscript.TopLevelContainer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mscript Block Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptBlockType#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dmltext.MscriptBlockType#getBehavior <em>Behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptBlockType()
 * @model
 * @generated
 */
public interface MscriptBlockType extends BlockType, TopLevelContainer {
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
	 * Returns the value of the '<em><b>Behavior</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dmltext.BehaviorDeclaration#getBlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Behavior</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Behavior</em>' containment reference.
	 * @see #setBehavior(BehaviorDeclaration)
	 * @see org.eclipselabs.damos.dmltext.DMLTextPackage#getMscriptBlockType_Behavior()
	 * @see org.eclipselabs.damos.dmltext.BehaviorDeclaration#getBlockType
	 * @model opposite="blockType" containment="true"
	 * @generated
	 */
	BehaviorDeclaration getBehavior();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dmltext.MscriptBlockType#getBehavior <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior</em>' containment reference.
	 * @see #getBehavior()
	 * @generated
	 */
	void setBehavior(BehaviorDeclaration value);

} // MscriptBlockType
