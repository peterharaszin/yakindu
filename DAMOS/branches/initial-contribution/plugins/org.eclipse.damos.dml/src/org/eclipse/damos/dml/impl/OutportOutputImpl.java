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
import org.eclipse.damos.dml.OutportOutput;
import org.eclipse.emf.ecore.EClass;

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
	 * @see org.eclipse.damos.dml.impl.InoutputImpl#isTestPoint()
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
