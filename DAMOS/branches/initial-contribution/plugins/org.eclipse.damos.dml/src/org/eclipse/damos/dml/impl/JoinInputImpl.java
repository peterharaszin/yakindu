/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.JoinInput;
import org.eclipse.emf.ecore.EClass;

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
	 * @see org.eclipse.damos.dml.impl.InoutputImpl#canAddPort()
	 */
	@Override
	public boolean canAddPort() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.impl.InoutputImpl#canRemovePort()
	 */
	@Override
	public boolean canRemovePort() {
		return getPorts().size() > 2;
	}

} //JoinInputImpl
