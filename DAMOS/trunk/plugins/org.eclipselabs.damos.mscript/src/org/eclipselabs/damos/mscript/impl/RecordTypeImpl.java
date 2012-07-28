/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.RecordType;
import org.eclipselabs.damos.mscript.Type;
import org.eclipselabs.damos.mscript.internal.operations.RecordTypeOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Struct Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RecordTypeImpl extends CompositeTypeImpl implements RecordType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecordTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MscriptPackage.Literals.RECORD_TYPE;
	}

	@Override
	public boolean isAssignableFrom(Type other) {
		return RecordTypeOperations.isAssignableFrom(this, other);
	}
	
} //RecordTypeImpl
