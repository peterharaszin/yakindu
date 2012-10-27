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
/**
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.UnitDenominatorFactor;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Denominator Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UnitDenominatorFactorImpl extends UnitFactorImpl implements UnitDenominatorFactor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	protected UnitDenominatorFactorImpl() {
		super();
		// Set default exponent to -1 instead of 1
		exponent = -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.UNIT_DENOMINATOR_FACTOR;
	}

} //UnitDenominatorFactorImpl
