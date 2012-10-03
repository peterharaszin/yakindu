/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.BooleanDirectFeedthroughPolicy;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Boolean Direct Feedthrough Policy</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.BooleanDirectFeedthroughPolicy#computeDirectFeedthrough() <em>Compute Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BooleanDirectFeedthroughPolicyOperations extends DirectFeedthroughPolicyOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanDirectFeedthroughPolicyOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean computeDirectFeedthrough(BooleanDirectFeedthroughPolicy booleanDirectFeedthroughPolicy) {
		return booleanDirectFeedthroughPolicy.isDirectFeedthrough();
	}

} // BooleanDirectFeedthroughPolicyOperations