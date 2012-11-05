/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Inport;
import org.eclipse.emf.ecore.EClass;

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
	 * @see org.eclipse.damos.dml.impl.ComponentImpl#isTimingConstraintApplicable(org.eclipse.emf.ecore.EClass)
	 */
	@Override
	public boolean isTimingConstraintApplicable(EClass eClass) {
		return eClass == DMLPackage.eINSTANCE.getContinuousTimingConstraint()
				|| eClass == DMLPackage.eINSTANCE.getSynchronousTimingConstraint()
				|| eClass == DMLPackage.eINSTANCE.getAsynchronousTimingConstraint();
	}
	
} //InportImpl
