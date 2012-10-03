/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.IExpressionVisitor;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.PowerExpression;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class PowerExpressionImpl extends BinaryExpressionImpl implements PowerExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.POWER_EXPRESSION;
	}

	public <R, P> R accept(P p, IExpressionVisitor<R, P> visitor) {
		return visitor.visit(p, this);
	}

} //PowerExpressionImpl
