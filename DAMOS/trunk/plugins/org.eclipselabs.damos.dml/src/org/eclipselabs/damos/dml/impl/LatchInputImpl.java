/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.LatchInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Latch Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class LatchInputImpl extends InputImpl implements LatchInput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LatchInputImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InputImpl#isDirectFeedthrough()
	 */
	@Override
	public boolean isDirectFeedthrough() {
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.LATCH_INPUT;
	}

} //LatchInputImpl
