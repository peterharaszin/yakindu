/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.AdditiveExpression;
import org.eclipselabs.damos.mscript.IExpressionVisitor;
import org.eclipselabs.damos.mscript.MscriptPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AdditiveExpressionImpl extends BinaryExpressionImpl implements AdditiveExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdditiveExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.ADDITIVE_EXPRESSION;
	}

	public <R, C> R accept(C context, IExpressionVisitor<R, C> visitor) {
		return visitor.visit(context, this);
	}

} //AdditiveExpressionImpl
