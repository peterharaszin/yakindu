/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StringType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.internal.operations.StringTypeOperations;

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
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#evaluate(org.eclipselabs.damos.mscript.OperatorKind, org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public Type evaluate(OperatorKind operator, Type other) {
		return StringTypeOperations.evaluate(this, operator, other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(Type other) {
		return StringTypeOperations.isAssignableFrom(this, other);
	}
	
} //StringTypeSpecifierImpl
