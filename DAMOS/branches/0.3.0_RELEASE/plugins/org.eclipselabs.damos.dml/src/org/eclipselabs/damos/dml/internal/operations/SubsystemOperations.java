/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.internal.util.CrossReferencerUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Subsystem</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Subsystem#getRealizations() <em>Get Realizations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Subsystem#getRealization(org.eclipselabs.damos.dml.Fragment) <em>Get Realization</em>}</li>
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