/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.RealType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.internal.operations.RealTypeOperations;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Real Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RealTypeImpl extends NumericTypeImpl implements RealType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.REAL_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipse.damos.mscript.typesystem.OperatorKind, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	public Type evaluate(OperatorKind operator, Type other) {
		return RealTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipse.damos.mscript.typesystem.OperatorKind, int)
	 */
	@Override
	public Type evaluate(OperatorKind operator, int n) {
		return RealTypeOperations.evaluate(this, operator, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(Type other) {
		return RealTypeOperations.isAssignableFrom(this, other);
	}

} //RealTypeSpecifierImpl
