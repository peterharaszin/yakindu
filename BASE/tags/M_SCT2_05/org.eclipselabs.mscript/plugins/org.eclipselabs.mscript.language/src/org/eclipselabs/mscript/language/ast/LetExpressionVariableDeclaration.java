/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Expression Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getParts <em>Parts</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getAssignedExpression <em>Assigned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getLetExpressionVariableDeclaration()
 * @model
 * @generated
 */
public interface LetExpressionVariableDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getLetExpressionVariableDeclaration_Parts()
	 * @model containment="true"
	 * @generated
	 */
	EList<LetExpressionVariableDeclarationPart> getParts();

	/**
	 * Returns the value of the '<em><b>Assigned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #setAssignedExpression(Expression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getLetExpressionVariableDeclaration_AssignedExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getAssignedExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getAssignedExpression <em>Assigned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #getAssignedExpression()
	 * @generated
	 */
	void setAssignedExpression(Expression value);

} // LetExpressionVariableDeclaration
