/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.notation.blockdiagramnotation;

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
 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockDiagramNotationFactory
 * @model kind="package"
 * @generated
 */
public interface BlockDiagramNotationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "blockdiagramnotation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.esmp.org/dsm/BlockDiagramNotation/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "blockdiagramnotation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	BlockDiagramNotationPackage eINSTANCE = org.esmp.dsm.notation.blockdiagramnotation.impl.BlockDiagramNotationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.esmp.dsm.notation.blockdiagramnotation.impl.BlockLayoutConstraintImpl <em>Block Layout Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.esmp.dsm.notation.blockdiagramnotation.impl.BlockLayoutConstraintImpl
	 * @see org.esmp.dsm.notation.blockdiagramnotation.impl.BlockDiagramNotationPackageImpl#getBlockLayoutConstraint()
	 * @generated
	 */
	int BLOCK_LAYOUT_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_LAYOUT_CONSTRAINT__X = NotationPackage.BOUNDS__X;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_LAYOUT_CONSTRAINT__Y = NotationPackage.BOUNDS__Y;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_LAYOUT_CONSTRAINT__WIDTH = NotationPackage.BOUNDS__WIDTH;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_LAYOUT_CONSTRAINT__HEIGHT = NotationPackage.BOUNDS__HEIGHT;

	/**
	 * The feature id for the '<em><b>Flipped</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_LAYOUT_CONSTRAINT__FLIPPED = NotationPackage.BOUNDS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_LAYOUT_CONSTRAINT__ROTATION = NotationPackage.BOUNDS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Block Layout Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_LAYOUT_CONSTRAINT_FEATURE_COUNT = NotationPackage.BOUNDS_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint <em>Block Layout Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Layout Constraint</em>'.
	 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint
	 * @generated
	 */
	EClass getBlockLayoutConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#isFlipped <em>Flipped</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Flipped</em>'.
	 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#isFlipped()
	 * @see #getBlockLayoutConstraint()
	 * @generated
	 */
	EAttribute getBlockLayoutConstraint_Flipped();

	/**
	 * Returns the meta object for the attribute '{@link org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see org.esmp.dsm.notation.blockdiagramnotation.BlockLayoutConstraint#getRotation()
	 * @see #getBlockLayoutConstraint()
	 * @generated
	 */
	EAttribute getBlockLayoutConstraint_Rotation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BlockDiagramNotationFactory getBlockDiagramNotationFactory();

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
		 * The meta object literal for the '{@link org.esmp.dsm.notation.blockdiagramnotation.impl.BlockLayoutConstraintImpl <em>Block Layout Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.esmp.dsm.notation.blockdiagramnotation.impl.BlockLayoutConstraintImpl
		 * @see org.esmp.dsm.notation.blockdiagramnotation.impl.BlockDiagramNotationPackageImpl#getBlockLayoutConstraint()
		 * @generated
		 */
		EClass BLOCK_LAYOUT_CONSTRAINT = eINSTANCE.getBlockLayoutConstraint();

		/**
		 * The meta object literal for the '<em><b>Flipped</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_LAYOUT_CONSTRAINT__FLIPPED = eINSTANCE.getBlockLayoutConstraint_Flipped();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLOCK_LAYOUT_CONSTRAINT__ROTATION = eINSTANCE.getBlockLayoutConstraint_Rotation();

	}

} //BlockDiagramNotationPackage
