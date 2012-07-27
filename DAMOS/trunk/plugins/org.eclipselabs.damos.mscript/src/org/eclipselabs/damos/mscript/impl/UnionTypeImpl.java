/**
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.UnionType;
import org.eclipselabs.damos.mscript.internal.operations.UnionTypeOperations;

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
