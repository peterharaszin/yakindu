/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.OperatorKind;
import org.eclipselabs.damos.mscript.UnitType;
import org.eclipselabs.damos.mscript.internal.operations.UnitTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UnitTypeImpl extends DataTypeImpl implements UnitType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.UNIT_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	public DataType evaluate(OperatorKind operator, DataType other) {
		return UnitTypeOperations.evaluate(this, operator, other);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, int)
	 */
	@Override
	public DataType evaluate(OperatorKind operator, int n) {
		return UnitTypeOperations.evaluate(this, operator, n);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(DataType other) {
		return UnitTypeOperations.isAssignableFrom(this, other);
	}

} //UnitTypeImpl
