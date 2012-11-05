/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.IExpressionVisitor;
import org.eclipse.damos.mscript.ImpliesExpression;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implies Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ImpliesExpressionImpl extends BinaryExpressionImpl implements ImpliesExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImpliesExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.IMPLIES_EXPRESSION;
	}

	public <R, P> R accept(P p, IExpressionVisitor<R, P> visitor) {
		return visitor.visit(p, this);
	}

} //ImpliesExpressionImpl
