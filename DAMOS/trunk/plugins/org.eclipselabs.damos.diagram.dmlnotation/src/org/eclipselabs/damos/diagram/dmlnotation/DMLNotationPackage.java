/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.diagram.dmlnotation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.runtime.notation.NotationPackage;

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
 * @see org.eclipselabs.damos.diagram.dmlnotation.DMLNotationFactory
 * @model kind="package"
 * @generated
 */
public interface DMLNotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dmlnotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/2011/DMLNotation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dmlnotation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DMLNotationPackage eINSTANCE = org.eclipselabs.damos.diagram.dmlnotation.impl.DMLNotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.diagram.dmlnotation.impl.FlippableBoundsImpl <em>Flippable Bounds</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.FlippableBoundsImpl
	 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.DMLNotationPackageImpl#getFlippableBounds()
	 * @generated
	 */
	int FLIPPABLE_BOUNDS = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLIPPABLE_BOUNDS__X = NotationPackage.BOUNDS__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLIPPABLE_BOUNDS__Y = NotationPackage.BOUNDS__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLIPPABLE_BOUNDS__WIDTH = NotationPackage.BOUNDS__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLIPPABLE_BOUNDS__HEIGHT = NotationPackage.BOUNDS__HEIGHT;

	/**
	 * The feature id for the '<em><b>Flipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLIPPABLE_BOUNDS__FLIPPED = NotationPackage.BOUNDS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Flippable Bounds</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLIPPABLE_BOUNDS_FEATURE_COUNT = NotationPackage.BOUNDS_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.diagram.dmlnotation.impl.RotatableBoundsImpl <em>Rotatable Bounds</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.RotatableBoundsImpl
	 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.DMLNotationPackageImpl#getRotatableBounds()
	 * @generated
	 */
	int ROTATABLE_BOUNDS = 1;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATABLE_BOUNDS__X = FLIPPABLE_BOUNDS__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATABLE_BOUNDS__Y = FLIPPABLE_BOUNDS__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATABLE_BOUNDS__WIDTH = FLIPPABLE_BOUNDS__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATABLE_BOUNDS__HEIGHT = FLIPPABLE_BOUNDS__HEIGHT;

	/**
	 * The feature id for the '<em><b>Flipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATABLE_BOUNDS__FLIPPED = FLIPPABLE_BOUNDS__FLIPPED;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATABLE_BOUNDS__ROTATION = FLIPPABLE_BOUNDS_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rotatable Bounds</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROTATABLE_BOUNDS_FEATURE_COUNT = FLIPPABLE_BOUNDS_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.diagram.dmlnotation.FlippableBounds <em>Flippable Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flippable Bounds</em>'.
	 * @see org.eclipselabs.damos.diagram.dmlnotation.FlippableBounds
	 * @generated
	 */
	EClass getFlippableBounds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.diagram.dmlnotation.FlippableBounds#isFlipped <em>Flipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flipped</em>'.
	 * @see org.eclipselabs.damos.diagram.dmlnotation.FlippableBounds#isFlipped()
	 * @see #getFlippableBounds()
	 * @generated
	 */
	EAttribute getFlippableBounds_Flipped();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.diagram.dmlnotation.RotatableBounds <em>Rotatable Bounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rotatable Bounds</em>'.
	 * @see org.eclipselabs.damos.diagram.dmlnotation.RotatableBounds
	 * @generated
	 */
	EClass getRotatableBounds();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.diagram.dmlnotation.RotatableBounds#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see org.eclipselabs.damos.diagram.dmlnotation.RotatableBounds#getRotation()
	 * @see #getRotatableBounds()
	 * @generated
	 */
	EAttribute getRotatableBounds_Rotation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DMLNotationFactory getDMLNotationFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.diagram.dmlnotation.impl.FlippableBoundsImpl <em>Flippable Bounds</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.FlippableBoundsImpl
		 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.DMLNotationPackageImpl#getFlippableBounds()
		 * @generated
		 */
		EClass FLIPPABLE_BOUNDS = eINSTANCE.getFlippableBounds();

		/**
		 * The meta object literal for the '<em><b>Flipped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLIPPABLE_BOUNDS__FLIPPED = eINSTANCE.getFlippableBounds_Flipped();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.diagram.dmlnotation.impl.RotatableBoundsImpl <em>Rotatable Bounds</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.RotatableBoundsImpl
		 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.DMLNotationPackageImpl#getRotatableBounds()
		 * @generated
		 */
		EClass ROTATABLE_BOUNDS = eINSTANCE.getRotatableBounds();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROTATABLE_BOUNDS__ROTATION = eINSTANCE.getRotatableBounds_Rotation();

	}

} //DMLNotationPackage
