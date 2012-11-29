/**
 */
package org.kieler.syncharts.model.synccharts;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.kieler.syncharts.model.synccharts.SyncchartsPackage
 * @generated
 */
public interface SyncchartsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SyncchartsFactory eINSTANCE = org.kieler.syncharts.model.synccharts.impl.SyncchartsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sync Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sync Transition</em>'.
	 * @generated
	 */
	SyncTransition createSyncTransition();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SyncchartsPackage getSyncchartsPackage();

} //SyncchartsFactory
