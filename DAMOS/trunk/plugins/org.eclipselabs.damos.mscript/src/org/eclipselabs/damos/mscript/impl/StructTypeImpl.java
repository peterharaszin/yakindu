/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.CompositeTypeMember;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.StructType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.internal.operations.StructTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class StructTypeImpl extends CompositeTypeImpl implements StructType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.STRUCT_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public CompositeTypeMember getMember(String name) {
		return StructTypeOperations.getMember(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getMemberIndex(String name) {
		return StructTypeOperations.getMemberIndex(this, name);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#evaluate(org.eclipselabs.damos.mscript.OperatorKind, org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public Type evaluate(OperatorKind operator, Type other) {
		return StructTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#evaluate(org.eclipselabs.damos.mscript.OperatorKind, int)
	 */
	@Override
	public Type evaluate(OperatorKind operator, int n) {
		return StructTypeOperations.evaluate(this, operator, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#isAssignableFrom(org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public boolean isAssignableFrom(Type other) {
		return StructTypeOperations.isAssignableFrom(this, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.impl.DataTypeImpl#isEquivalentTo(org.eclipselabs.damos.mscript.DataType)
	 */
	@Override
	public boolean isEquivalentTo(Type other) {
		return StructTypeOperations.isEquivalentTo(this, other);
	}

} //StructTypeImpl
