/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.InvalidDataType;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.internal.operations.InvalidDataTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invalid Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class InvalidDataTypeImpl extends DataTypeImpl implements InvalidDataType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InvalidDataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.INVALID_DATA_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.typesystem.impl.DataTypeImpl#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	public boolean isAssignableFrom(DataType other) {
		return InvalidDataTypeOperations.isAssignableFrom(this, other);
	}

} //InvalidDataTypeImpl
