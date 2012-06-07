/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Join;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JoinImpl extends ComponentImpl implements Join {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.JOIN;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.ComponentImpl#isTimingConstraintApplicable(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isTimingConstraintApplicable(EClass eClass) {
		return eClass == DMLPackage.eINSTANCE.getSynchronousTimingConstraint()
				|| eClass == DMLPackage.eINSTANCE.getAsynchronousTimingConstraint();
	}

} //JoinImpl
