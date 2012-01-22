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
	String eNS_URI = "http://www.eclipselabs.org/damos/2011/DMLText";

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.RootImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 0;

	/**
	 * The feature id for the '<em><b>Block Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__BLOCK_TYPES = 0;

	/**
	 * The feature id for the '<em><b>System Interfaces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__SYSTEM_INTERFACES = 1;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptBlockTypeImpl <em>Mscript Block Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.MscriptBlockTypeImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptBlockType()
	 * @generated
	 */
	int MSCRIPT_BLOCK_TYPE = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__EANNOTATIONS = DMLPackage.BLOCK_TYPE__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__QUALIFIED_NAME = DMLPackage.BLOCK_TYPE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__NAME = DMLPackage.BLOCK_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__PACKAGE_NAME = DMLPackage.BLOCK_TYPE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Belonging Categories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__BELONGING_CATEGORIES = DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__PARAMETERS = DMLPackage.BLOCK_TYPE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Input Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__INPUT_DEFINITIONS = DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Output Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__OUTPUT_DEFINITIONS = DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS;

	/**
	 * The feature id for the '<em><b>Timing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__TIMING = DMLPackage.BLOCK_TYPE__TIMING;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS = DMLPackage.BLOCK_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE__DECLARATIONS = DMLPackage.BLOCK_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mscript Block Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_BLOCK_TYPE_FEATURE_COUNT = DMLPackage.BLOCK_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptSystemInterfaceImpl <em>Mscript System Interface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.MscriptSystemInterfaceImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptSystemInterface()
	 * @generated
	 */
	int MSCRIPT_SYSTEM_INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_SYSTEM_INTERFACE__QUALIFIED_NAME = DMLPackage.SYSTEM_INTERFACE__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_SYSTEM_INTERFACE__NAME = DMLPackage.SYSTEM_INTERFACE__NAME;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_SYSTEM_INTERFACE__PACKAGE_NAME = DMLPackage.SYSTEM_INTERFACE__PACKAGE_NAME;

	/**
	 * The feature id for the '<em><b>Inlets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_SYSTEM_INTERFACE__INLETS = DMLPackage.SYSTEM_INTERFACE__INLETS;

	/**
	 * The feature id for the '<em><b>Outlets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_SYSTEM_INTERFACE__OUTLETS = DMLPackage.SYSTEM_INTERFACE__OUTLETS;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_SYSTEM_INTERFACE__IMPORT_DECLARATIONS = DMLPackage.SYSTEM_INTERFACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mscript System Interface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MSCRIPT_SYSTEM_INTERFACE_FEATURE_COUNT = DMLPackage.SYSTEM_INTERFACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl <em>Mscript Data Type Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.MscriptDataTypeSpecificationImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptDataTypeSpecification()
	 * @generated
	 */
	int MSCRIPT_DATA_TYPE_SPECIFICATION = 3;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptValueSpecificationImpl <em>Mscript Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dmltext.impl.MscriptValueSpecificationImpl
	 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptValueSpecification()
	 * @generated
	 */
	int MSCRIPT_VALUE_SPECIFICATION = 4;

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
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dmltext.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipselabs.damos.dmltext.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dmltext.Root#getBlockTypes <em>Block Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Block Types</em>'.
	 * @see org.eclipselabs.damos.dmltext.Root#getBlockTypes()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_BlockTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dmltext.Root#getSystemInterfaces <em>System Interfaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>System Interfaces</em>'.
	 * @see org.eclipselabs.damos.dmltext.Root#getSystemInterfaces()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_SystemInterfaces();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dmltext.MscriptBlockType <em>Mscript Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mscript Block Type</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptBlockType
	 * @generated
	 */
	EClass getMscriptBlockType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dmltext.MscriptBlockType#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptBlockType#getImportDeclarations()
	 * @see #getMscriptBlockType()
	 * @generated
	 */
	EReference getMscriptBlockType_ImportDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dmltext.MscriptBlockType#getDeclarations <em>Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declarations</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptBlockType#getDeclarations()
	 * @see #getMscriptBlockType()
	 * @generated
	 */
	EReference getMscriptBlockType_Declarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dmltext.MscriptSystemInterface <em>Mscript System Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mscript System Interface</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptSystemInterface
	 * @generated
	 */
	EClass getMscriptSystemInterface();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dmltext.MscriptSystemInterface#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.eclipselabs.damos.dmltext.MscriptSystemInterface#getImportDeclarations()
	 * @see #getMscriptSystemInterface()
	 * @generated
	 */
	EReference getMscriptSystemInterface_ImportDeclarations();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dmltext.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dmltext.impl.RootImpl
		 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Block Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__BLOCK_TYPES = eINSTANCE.getRoot_BlockTypes();

		/**
		 * The meta object literal for the '<em><b>System Interfaces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__SYSTEM_INTERFACES = eINSTANCE.getRoot_SystemInterfaces();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptBlockTypeImpl <em>Mscript Block Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dmltext.impl.MscriptBlockTypeImpl
		 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptBlockType()
		 * @generated
		 */
		EClass MSCRIPT_BLOCK_TYPE = eINSTANCE.getMscriptBlockType();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS = eINSTANCE.getMscriptBlockType_ImportDeclarations();

		/**
		 * The meta object literal for the '<em><b>Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSCRIPT_BLOCK_TYPE__DECLARATIONS = eINSTANCE.getMscriptBlockType_Declarations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dmltext.impl.MscriptSystemInterfaceImpl <em>Mscript System Interface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dmltext.impl.MscriptSystemInterfaceImpl
		 * @see org.eclipselabs.damos.dmltext.impl.DMLTextPackageImpl#getMscriptSystemInterface()
		 * @generated
		 */
		EClass MSCRIPT_SYSTEM_INTERFACE = eINSTANCE.getMscriptSystemInterface();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MSCRIPT_SYSTEM_INTERFACE__IMPORT_DECLARATIONS = eINSTANCE.getMscriptSystemInterface_ImportDeclarations();

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
