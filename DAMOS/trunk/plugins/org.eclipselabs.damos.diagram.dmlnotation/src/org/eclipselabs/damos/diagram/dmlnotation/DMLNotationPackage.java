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
	String eNS_URI = "http://www.eclipselabs.org/damos/DMLNotation/1.0.0";

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
	 * The meta object id for the '{@link org.eclipselabs.damos.diagram.dmlnotation.impl.ComponentLayoutConstraintImpl <em>Component Layout Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.ComponentLayoutConstraintImpl
	 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.DMLNotationPackageImpl#getComponentLayoutConstraint()
	 * @generated
	 */
	int COMPONENT_LAYOUT_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_LAYOUT_CONSTRAINT__X = NotationPackage.BOUNDS__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_LAYOUT_CONSTRAINT__Y = NotationPackage.BOUNDS__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_LAYOUT_CONSTRAINT__WIDTH = NotationPackage.BOUNDS__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_LAYOUT_CONSTRAINT__HEIGHT = NotationPackage.BOUNDS__HEIGHT;

	/**
	 * The feature id for the '<em><b>Flipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_LAYOUT_CONSTRAINT__FLIPPED = NotationPackage.BOUNDS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_LAYOUT_CONSTRAINT__ROTATION = NotationPackage.BOUNDS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Component Layout Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_LAYOUT_CONSTRAINT_FEATURE_COUNT = NotationPackage.BOUNDS_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint <em>Component Layout Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Layout Constraint</em>'.
	 * @see org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint
	 * @generated
	 */
	EClass getComponentLayoutConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#isFlipped <em>Flipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flipped</em>'.
	 * @see org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#isFlipped()
	 * @see #getComponentLayoutConstraint()
	 * @generated
	 */
	EAttribute getComponentLayoutConstraint_Flipped();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint#getRotation()
	 * @see #getComponentLayoutConstraint()
	 * @generated
	 */
	EAttribute getComponentLayoutConstraint_Rotation();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.diagram.dmlnotation.impl.ComponentLayoutConstraintImpl <em>Component Layout Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.ComponentLayoutConstraintImpl
		 * @see org.eclipselabs.damos.diagram.dmlnotation.impl.DMLNotationPackageImpl#getComponentLayoutConstraint()
		 * @generated
		 */
		EClass COMPONENT_LAYOUT_CONSTRAINT = eINSTANCE.getComponentLayoutConstraint();

		/**
		 * The meta object literal for the '<em><b>Flipped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_LAYOUT_CONSTRAINT__FLIPPED = eINSTANCE.getComponentLayoutConstraint_Flipped();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT_LAYOUT_CONSTRAINT__ROTATION = eINSTANCE.getComponentLayoutConstraint_Rotation();

	}

} //DMLNotationPackage
