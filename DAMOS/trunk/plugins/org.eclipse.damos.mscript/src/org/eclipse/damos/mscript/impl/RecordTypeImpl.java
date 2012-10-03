/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.impl;

import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.RecordType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.internal.operations.RecordTypeOperations;
import org.eclipse.emf.ecore.EClass;

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
