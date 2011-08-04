/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OutportOutput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outport Output</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class OutportOutputImpl extends OutputImpl implements OutportOutput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutportOutputImpl() {
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
		return DMLPackage.Literals.OUTPORT_OUTPUT;
	}

} //OutportOutputImpl
