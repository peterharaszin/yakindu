/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.AnyType;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.internal.operations.AnyTypeOperations;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Any Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AnyTypeImpl extends TypeImpl implements AnyType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnyTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.ANY_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipse.damos.mscript.typesystem.OperatorKind, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	public Type evaluate(OperatorKind operator, Type other) {
		return AnyTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipse.damos.mscript.typesystem.OperatorKind, int)
	 */
	@Override
	public Type evaluate(OperatorKind operator, int n) {
		return AnyTypeOperations.evaluate(this, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(Type other) {
		return AnyTypeOperations.isAssignableFrom(this, other);
	}

} //AnyDataTypeImpl
