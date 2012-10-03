/**
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.UnionType;
import org.eclipse.damos.mscript.internal.operations.UnionTypeOperations;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Union Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class UnionTypeImpl extends CompositeTypeImpl implements UnionType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.UNION_TYPE;
	}
	
	@Override
	public boolean isAssignableFrom(Type other) {
		return UnionTypeOperations.isAssignableFrom(this, other);
	}

} //UnionTypeImpl
