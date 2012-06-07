/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.SubsystemInoutput;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subsystem Inoutput</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class SubsystemInoutputImpl extends InoutputImpl implements SubsystemInoutput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemInoutputImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.SUBSYSTEM_INOUTPUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Inoutlet getInoutlet() {
		throw new UnsupportedOperationException();
	}

} //SubsystemInoutputImpl
