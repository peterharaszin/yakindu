/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipselabs.damos.mscript.MscriptPackage#getExpression()
 * @model abstract="true"
 * @generated
 */
public interface Expression extends Evaluable {
	
	<R, P> R accept(P p, IExpressionVisitor<R, P> visitor);
	
} // Expression
