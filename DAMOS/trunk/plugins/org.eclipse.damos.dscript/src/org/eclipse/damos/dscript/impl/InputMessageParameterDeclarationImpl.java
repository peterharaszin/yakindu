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

import org.eclipse.damos.dscript.DscriptPackage;
import org.eclipse.damos.dscript.InputMessageParameterDeclaration;
import org.eclipse.damos.mscript.Expression;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Message Parameter Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InputMessageParameterDeclarationImpl extends ImplicitInputParameterDeclarationImpl implements InputMessageParameterDeclaration {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputMessageParameterDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.INPUT_MESSAGE_PARAMETER_DECLARATION;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.CallableElementImpl#getName()
	 */
	@Override
	public String getName() {
		return "inputMessage";
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.InputParameterDeclarationImpl#isConstant()
	 */
	@Override
	public boolean isConstant() {
		return false;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.InputParameterDeclarationImpl#getDefaultExpression()
	 */
	@Override
	public Expression getDefaultExpression() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.CallableElement#getNameFeature()
	 */
	public EStructuralFeature getNameFeature() {
		return null;
	}

} //InputMessageParameterDeclarationImpl
