/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.BooleanType;
import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.OperatorKind;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.internal.operations.BooleanTypeOperations;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class BooleanTypeImpl extends PrimitiveTypeImpl implements BooleanType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.BOOLEAN_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipse.damos.mscript.typesystem.OperatorKind, org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	public Type evaluate(OperatorKind operator, Type other) {
		return BooleanTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipse.damos.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(Type other) {
		return BooleanTypeOperations.isAssignableFrom(this, other);
	}

} //BooleanTypeSpecifierImpl
