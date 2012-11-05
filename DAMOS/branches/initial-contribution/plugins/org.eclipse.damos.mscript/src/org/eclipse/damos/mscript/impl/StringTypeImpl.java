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
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.StringType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.internal.operations.StringTypeOperations;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StringTypeImpl extends PrimitiveTypeImpl implements StringType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.STRING_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.impl.DataTypeImpl#evaluate(org.eclipse.damos.mscript.OperatorKind, org.eclipse.damos.mscript.DataType)
	 */
	@Override
	public Type evaluate(OperatorKind operator, Type other) {
		return StringTypeOperations.evaluate(this, operator, other);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(Type other) {
		return StringTypeOperations.isAssignableFrom(this, other);
	}
	
} //StringTypeSpecifierImpl
