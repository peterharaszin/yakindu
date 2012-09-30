/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.IExpressionVisitor;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.RelationalExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RelationalExpressionImpl extends BinaryExpressionImpl implements RelationalExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationalExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.RELATIONAL_EXPRESSION;
	}

	public <R, C> R accept(C context, IExpressionVisitor<R, C> visitor) {
		return visitor.visit(context, this);
	}

} //RelationalExpressionImpl
