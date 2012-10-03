/**
 */
package org.eclipse.damos.mscript;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>When Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.mscript.InspectExpression#getUnionExpression <em>Union Expression</em>}</li>
 *   <li>{@link org.eclipse.damos.mscript.InspectExpression#getWhenClauses <em>When Clauses</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.mscript.MscriptPackage#getInspectExpression()
 * @model
 * @generated
 */
public interface InspectExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Union Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Union Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Union Expression</em>' containment reference.
	 * @see #setUnionExpression(Expression)
	 * @see org.eclipse.damos.mscript.MscriptPackage#getInspectExpression_UnionExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getUnionExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.mscript.InspectExpression#getUnionExpression <em>Union Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Union Expression</em>' containment reference.
	 * @see #getUnionExpression()
	 * @generated
	 */
	void setUnionExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>When Clauses</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.mscript.InspectWhenClause}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.mscript.InspectWhenClause#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Clauses</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When Clauses</em>' containment reference list.
	 * @see org.eclipse.damos.mscript.MscriptPackage#getInspectExpression_WhenClauses()
	 * @see org.eclipse.damos.mscript.InspectWhenClause#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<InspectWhenClause> getWhenClauses();

} // WhenExpression
