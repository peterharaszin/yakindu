/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelFactory
 * @model kind="package"
 * @generated
 */
public interface CGenModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cgenmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/CGenModel/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "cgenmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CGenModelPackage eINSTANCE = org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelImpl <em>CGen Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelImpl
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getCGenModel()
	 * @generated
	 */
	int CGEN_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Execution Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGEN_MODEL__EXECUTION_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Top Level Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGEN_MODEL__TOP_LEVEL_FRAGMENT = 1;

	/**
	 * The feature id for the '<em><b>Target Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGEN_MODEL__TARGET_FOLDER = 2;

	/**
	 * The number of structural features of the '<em>CGen Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CGEN_MODEL_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel <em>CGen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CGen Model</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel
	 * @generated
	 */
	EClass getCGenModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getExecutionModel <em>Execution Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Model</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getExecutionModel()
	 * @see #getCGenModel()
	 * @generated
	 */
	EReference getCGenModel_ExecutionModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getTopLevelFragment <em>Top Level Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Top Level Fragment</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getTopLevelFragment()
	 * @see #getCGenModel()
	 * @generated
	 */
	EReference getCGenModel_TopLevelFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getTargetFolder <em>Target Folder</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Folder</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getTargetFolder()
	 * @see #getCGenModel()
	 * @generated
	 */
	EAttribute getCGenModel_TargetFolder();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CGenModelFactory getCGenModelFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelImpl <em>CGen Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelImpl
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getCGenModel()
		 * @generated
		 */
		EClass CGEN_MODEL = eINSTANCE.getCGenModel();

		/**
		 * The meta object literal for the '<em><b>Execution Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CGEN_MODEL__EXECUTION_MODEL = eINSTANCE.getCGenModel_ExecutionModel();

		/**
		 * The meta object literal for the '<em><b>Top Level Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CGEN_MODEL__TOP_LEVEL_FRAGMENT = eINSTANCE.getCGenModel_TopLevelFragment();

		/**
		 * The meta object literal for the '<em><b>Target Folder</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CGEN_MODEL__TARGET_FOLDER = eINSTANCE.getCGenModel_TargetFolder();

	}

} //CGenModelPackage
