/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InportInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inport Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InportInputImpl extends InputImpl implements InportInput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InportInputImpl() {
		super();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl#isTestPoint()
	 */
	@Override
	public boolean isTestPoint() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.INPORT_INPUT;
	}

} //InportInputImpl
