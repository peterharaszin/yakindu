/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.BlockInoutput;
import org.eclipse.damos.dml.BlockPort;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.InoutputDefinition;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Inoutput</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class BlockInoutputImpl extends InoutputImpl implements BlockInoutput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockInoutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.BLOCK_INOUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public InoutputDefinition getDefinition() {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.impl.InoutputImpl#createPort()
	 */
	@Override
	public BlockPort createPort() {
		throw new UnsupportedOperationException();
	}

} //BlockInoutputImpl
