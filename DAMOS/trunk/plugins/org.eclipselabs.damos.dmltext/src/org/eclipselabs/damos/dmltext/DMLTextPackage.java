/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.damos.dml.DMLPackage;

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
 * @see org.eclipselabs.damos.dmltext.DMLTextFactory
 * @model kind="package"
 * @generated
 */
public interface DMLTextPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dmltext";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/DMLText/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dmltext";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DMLTextPackage eINSTANCE = org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl <em>Mscript Data Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptDataTypeSpecification()
	 * @generated
	 */
	int MSCRIPT_DATA_TYPE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_DATA_TYPE_SPECIFICATION__TYPE = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mscript Data Type Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_DATA_TYPE_SPECIFICATION_FEATURE_COUNT = DMLPackage.DATA_TYPE_SPECIFICATION_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptBehaviorSpecificationImpl <em>Mscript Behavior Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.MscriptBehaviorSpecificationImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptBehaviorSpecification()
	 * @generated
	 */
	int MSCRIPT_BEHAVIOR_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Module</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BEHAVIOR_SPECIFICATION__MODULE = DMLPackage.BEHAVIOR_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mscript Behavior Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BEHAVIOR_SPECIFICATION_FEATURE_COUNT = DMLPackage.BEHAVIOR_SPECIFICATION_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptValueSpecificationImpl <em>Mscript Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.MscriptValueSpecificationImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptValueSpecification()
	 * @generated
	 */
	int MSCRIPT_VALUE_SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_VALUE_SPECIFICATION__EXPRESSION = DMLPackage.VALUE_SPECIFICATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mscript Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_VALUE_SPECIFICATION_FEATURE_COUNT = DMLPackage.VALUE_SPECIFICATION_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification <em>Mscript Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mscript Data Type Specification</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification
	 * @generated
	 */
	EClass getMscriptDataTypeSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getSpecifier <em>Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Specifier</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getSpecifier()
	 * @see #getMscriptDataTypeSpecification()
	 * @generated
	 */
	EReference getMscriptDataTypeSpecification_Specifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification#getType()
	 * @see #getMscriptDataTypeSpecification()
	 * @generated
	 */
	EReference getMscriptDataTypeSpecification_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification <em>Mscript Behavior Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mscript Behavior Specification</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification
	 * @generated
	 */
	EClass getMscriptBehaviorSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification#getModule <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Module</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification#getModule()
	 * @see #getMscriptBehaviorSpecification()
	 * @generated
	 */
	EReference getMscriptBehaviorSpecification_Module();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dmltext.MscriptValueSpecification <em>Mscript Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mscript Value Specification</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptValueSpecification
	 * @generated
	 */
	EClass getMscriptValueSpecification();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dmltext.MscriptValueSpecification#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptValueSpecification#getExpression()
	 * @see #getMscriptValueSpecification()
	 * @generated
	 */
	EReference getMscriptValueSpecification_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DMLTextFactory getDMLTextFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl <em>Mscript Data Type Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl
		 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptDataTypeSpecification()
		 * @generated
		 */
		EClass MSCRIPT_DATA_TYPE_SPECIFICATION = eINSTANCE.getMscriptDataTypeSpecification();

		/**
		 * The meta object literal for the '<em><b>Specifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSCRIPT_DATA_TYPE_SPECIFICATION__SPECIFIER = eINSTANCE.getMscriptDataTypeSpecification_Specifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSCRIPT_DATA_TYPE_SPECIFICATION__TYPE = eINSTANCE.getMscriptDataTypeSpecification_Type();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptBehaviorSpecificationImpl <em>Mscript Behavior Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dmltext.impl.MscriptBehaviorSpecificationImpl
		 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptBehaviorSpecification()
		 * @generated
		 */
		EClass MSCRIPT_BEHAVIOR_SPECIFICATION = eINSTANCE.getMscriptBehaviorSpecification();

		/**
		 * The meta object literal for the '<em><b>Module</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSCRIPT_BEHAVIOR_SPECIFICATION__MODULE = eINSTANCE.getMscriptBehaviorSpecification_Module();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptValueSpecificationImpl <em>Mscript Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dmltext.impl.MscriptValueSpecificationImpl
		 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptValueSpecification()
		 * @generated
		 */
		EClass MSCRIPT_VALUE_SPECIFICATION = eINSTANCE.getMscriptValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSCRIPT_VALUE_SPECIFICATION__EXPRESSION = eINSTANCE.getMscriptValueSpecification_Expression();

	}

} //DMLTextPackage
