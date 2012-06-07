/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.JoinInput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join Input</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JoinInputImpl extends InputImpl implements JoinInput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoinInputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.JOIN_INPUT;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl#canAddPort()
	 */
	@Override
	public boolean canAddPort() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.impl.InoutputImpl#canRemovePort()
	 */
	@Override
	public boolean canRemovePort() {
		return getPorts().size() > 2;
	}

} //JoinInputImpl
