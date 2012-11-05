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
package org.eclipse.damos.dscript.impl;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.impl.ParameterImpl;
import org.eclipse.damos.dscript.DscriptBlockType;
import org.eclipse.damos.dscript.DscriptPackage;
import org.eclipse.damos.dscript.DscriptParameter;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dscript Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DscriptParameterImpl extends ParameterImpl implements DscriptParameter {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DscriptParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.DSCRIPT_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isConstant() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.InputParameterDeclaration#getDefaultExpression()
	 */
	public Expression getDefaultExpression() {
		if (eContainer() instanceof DscriptBlockType && getDefaultValue() instanceof DscriptValueSpecification) {
			return ((DscriptValueSpecification) getDefaultValue()).getExpression();
		}
		return null;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return getName();
	}
	
	public EStructuralFeature getNameFeature() {
		return DMLPackage.eINSTANCE.getParameter_Name();
	}

} //DscriptParameterImpl
