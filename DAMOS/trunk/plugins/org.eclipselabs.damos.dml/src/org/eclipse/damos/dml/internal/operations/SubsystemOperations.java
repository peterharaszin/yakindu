/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemRealization;
import org.eclipse.damos.dml.internal.util.CrossReferencerUtil;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Subsystem</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Subsystem#getRealizations() <em>Get Realizations</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Subsystem#getRealization(org.eclipse.damos.dml.Fragment) <em>Get Realization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubsystemOperations extends ComponentOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubsystemOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<SubsystemRealization> getRealizations(Subsystem subsystem) {
		return CrossReferencerUtil.getNonNavigableInverseReferences(
				subsystem,
				SubsystemRealization.class,
				DMLPackage.Literals.SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  SubsystemRealization getRealization(Subsystem subsystem, Fragment context) {
		do {
			for (FragmentElement element : context.getFragmentElements()) {
				if (element instanceof SubsystemRealization) {
					SubsystemRealization realization = (SubsystemRealization) element;
					if (realization.getRealizedSubsystem() == subsystem) {
						return realization;
					}
				}
			}
			context = context.getParent();
		} while (context != null);
		
		return null;
	}

} // SubsystemOperations