/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.IExpressionVisitor;
import org.eclipselabs.damos.mscript.LogicalOrExpression;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LogicalOrExpressionImpl extends BinaryExpressionImpl implements LogicalOrExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalOrExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.LOGICAL_OR_EXPRESSION;
	}

	public <R, C> R accept(C context, IExpressionVisitor<R, C> visitor) {
		return visitor.visit(context, this);
	}

} //LogicalOrExpressionImpl
