/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Inport;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inport</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InportImpl extends InoutportImpl implements Inport {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.INPORT;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.ComponentImpl#isTimingConstraintApplicable(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isTimingConstraintApplicable(EClass eClass) {
		return eClass == DMLPackage.eINSTANCE.getContinuousTimingConstraint()
				|| eClass == DMLPackage.eINSTANCE.getSynchronousTimingConstraint()
				|| eClass == DMLPackage.eINSTANCE.getAsynchronousTimingConstraint();
	}
	
} //InportImpl
