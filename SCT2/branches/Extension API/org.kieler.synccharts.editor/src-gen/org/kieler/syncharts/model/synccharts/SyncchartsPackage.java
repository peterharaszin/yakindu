/**
 */
package org.kieler.syncharts.model.synccharts;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.kieler.syncharts.model.synccharts.SyncchartsFactory
 * @model kind="package"
 * @generated
 */
public interface SyncchartsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "synccharts";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://kieler.org/synccharts";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "synccharts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SyncchartsPackage eINSTANCE = org.kieler.syncharts.model.synccharts.impl.SyncchartsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.kieler.syncharts.model.synccharts.impl.SyncTransitionImpl <em>Sync Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kieler.syncharts.model.synccharts.impl.SyncTransitionImpl
	 * @see org.kieler.syncharts.model.synccharts.impl.SyncchartsPackageImpl#getSyncTransition()
	 * @generated
	 */
	int SYNC_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION__SPECIFICATION = SGraphPackage.TRANSITION__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION__TRIGGER = SGraphPackage.TRANSITION__TRIGGER;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION__EFFECT = SGraphPackage.TRANSITION__EFFECT;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION__TARGET = SGraphPackage.TRANSITION__TARGET;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION__SOURCE = SGraphPackage.TRANSITION__SOURCE;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION__PRIORITY = SGraphPackage.TRANSITION__PRIORITY;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION__TYPE = SGraphPackage.TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sync Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNC_TRANSITION_FEATURE_COUNT = SGraphPackage.TRANSITION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.kieler.syncharts.model.synccharts.TransitionType <em>Transition Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.kieler.syncharts.model.synccharts.TransitionType
	 * @see org.kieler.syncharts.model.synccharts.impl.SyncchartsPackageImpl#getTransitionType()
	 * @generated
	 */
	int TRANSITION_TYPE = 1;


	/**
	 * Returns the meta object for class '{@link org.kieler.syncharts.model.synccharts.SyncTransition <em>Sync Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sync Transition</em>'.
	 * @see org.kieler.syncharts.model.synccharts.SyncTransition
	 * @generated
	 */
	EClass getSyncTransition();

	/**
	 * Returns the meta object for the attribute '{@link org.kieler.syncharts.model.synccharts.SyncTransition#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.kieler.syncharts.model.synccharts.SyncTransition#getType()
	 * @see #getSyncTransition()
	 * @generated
	 */
	EAttribute getSyncTransition_Type();

	/**
	 * Returns the meta object for enum '{@link org.kieler.syncharts.model.synccharts.TransitionType <em>Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Transition Type</em>'.
	 * @see org.kieler.syncharts.model.synccharts.TransitionType
	 * @generated
	 */
	EEnum getTransitionType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SyncchartsFactory getSyncchartsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.kieler.syncharts.model.synccharts.impl.SyncTransitionImpl <em>Sync Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kieler.syncharts.model.synccharts.impl.SyncTransitionImpl
		 * @see org.kieler.syncharts.model.synccharts.impl.SyncchartsPackageImpl#getSyncTransition()
		 * @generated
		 */
		EClass SYNC_TRANSITION = eINSTANCE.getSyncTransition();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYNC_TRANSITION__TYPE = eINSTANCE.getSyncTransition_Type();
		/**
		 * The meta object literal for the '{@link org.kieler.syncharts.model.synccharts.TransitionType <em>Transition Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.kieler.syncharts.model.synccharts.TransitionType
		 * @see org.kieler.syncharts.model.synccharts.impl.SyncchartsPackageImpl#getTransitionType()
		 * @generated
		 */
		EEnum TRANSITION_TYPE = eINSTANCE.getTransitionType();

	}

} //SyncchartsPackage
