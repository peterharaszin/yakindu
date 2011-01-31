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
	 * The meta object id for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl <em>Gen Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenModel()
	 * @generated
	 */
	int GEN_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Gen Top Level System</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__GEN_TOP_LEVEL_SYSTEM = 0;

	/**
	 * The feature id for the '<em><b>Execution Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__EXECUTION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Source Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__SOURCE_DIRECTORY = 2;

	/**
	 * The feature id for the '<em><b>Header Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__HEADER_DIRECTORY = 3;

	/**
	 * The feature id for the '<em><b>Main Source File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__MAIN_SOURCE_FILE = 4;

	/**
	 * The feature id for the '<em><b>Main Header File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__MAIN_HEADER_FILE = 5;

	/**
	 * The feature id for the '<em><b>Singleton</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL__SINGLETON = 6;

	/**
	 * The number of structural features of the '<em>Gen Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_MODEL_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSystemImpl <em>Gen System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSystemImpl
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenSystem()
	 * @generated
	 */
	int GEN_SYSTEM = 1;

	/**
	 * The feature id for the '<em><b>Gen Subsystems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SYSTEM__GEN_SUBSYSTEMS = 0;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SYSTEM__PREFIX = 1;

	/**
	 * The number of structural features of the '<em>Gen System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SYSTEM_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenTopLevelSystemImpl <em>Gen Top Level System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenTopLevelSystemImpl
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenTopLevelSystem()
	 * @generated
	 */
	int GEN_TOP_LEVEL_SYSTEM = 2;

	/**
	 * The feature id for the '<em><b>Gen Subsystems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_TOP_LEVEL_SYSTEM__GEN_SUBSYSTEMS = GEN_SYSTEM__GEN_SUBSYSTEMS;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_TOP_LEVEL_SYSTEM__PREFIX = GEN_SYSTEM__PREFIX;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_TOP_LEVEL_SYSTEM__FRAGMENT = GEN_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Gen Top Level System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_TOP_LEVEL_SYSTEM_FEATURE_COUNT = GEN_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSubsystemImpl <em>Gen Subsystem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSubsystemImpl
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenSubsystem()
	 * @generated
	 */
	int GEN_SUBSYSTEM = 3;

	/**
	 * The feature id for the '<em><b>Gen Subsystems</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SUBSYSTEM__GEN_SUBSYSTEMS = GEN_SYSTEM__GEN_SUBSYSTEMS;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SUBSYSTEM__PREFIX = GEN_SYSTEM__PREFIX;

	/**
	 * The feature id for the '<em><b>Enclosing Gen System</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM = GEN_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subsystem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SUBSYSTEM__SUBSYSTEM = GEN_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Gen Subsystem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GEN_SUBSYSTEM_FEATURE_COUNT = GEN_SYSTEM_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel <em>Gen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Model</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel
	 * @generated
	 */
	EClass getGenModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getGenTopLevelSystem <em>Gen Top Level System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Gen Top Level System</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getGenTopLevelSystem()
	 * @see #getGenModel()
	 * @generated
	 */
	EReference getGenModel_GenTopLevelSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getExecutionModel <em>Execution Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Model</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getExecutionModel()
	 * @see #getGenModel()
	 * @generated
	 */
	EReference getGenModel_ExecutionModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getSourceDirectory <em>Source Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Directory</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getSourceDirectory()
	 * @see #getGenModel()
	 * @generated
	 */
	EAttribute getGenModel_SourceDirectory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getHeaderDirectory <em>Header Directory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Header Directory</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getHeaderDirectory()
	 * @see #getGenModel()
	 * @generated
	 */
	EAttribute getGenModel_HeaderDirectory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainSourceFile <em>Main Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Source File</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainSourceFile()
	 * @see #getGenModel()
	 * @generated
	 */
	EAttribute getGenModel_MainSourceFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainHeaderFile <em>Main Header File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Main Header File</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#getMainHeaderFile()
	 * @see #getGenModel()
	 * @generated
	 */
	EAttribute getGenModel_MainHeaderFile();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#isSingleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Singleton</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenModel#isSingleton()
	 * @see #getGenModel()
	 * @generated
	 */
	EAttribute getGenModel_Singleton();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem <em>Gen System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen System</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem
	 * @generated
	 */
	EClass getGenSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getGenSubsystems <em>Gen Subsystems</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gen Subsystems</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getGenSubsystems()
	 * @see #getGenSystem()
	 * @generated
	 */
	EReference getGenSystem_GenSubsystems();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenSystem#getPrefix()
	 * @see #getGenSystem()
	 * @generated
	 */
	EAttribute getGenSystem_Prefix();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem <em>Gen Top Level System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Top Level System</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem
	 * @generated
	 */
	EClass getGenTopLevelSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem#getFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fragment</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenTopLevelSystem#getFragment()
	 * @see #getGenTopLevelSystem()
	 * @generated
	 */
	EReference getGenTopLevelSystem_Fragment();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem <em>Gen Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gen Subsystem</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem
	 * @generated
	 */
	EClass getGenSubsystem();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getEnclosingGenSystem <em>Enclosing Gen System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Enclosing Gen System</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getEnclosingGenSystem()
	 * @see #getGenSubsystem()
	 * @generated
	 */
	EReference getGenSubsystem_EnclosingGenSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getSubsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subsystem</em>'.
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.GenSubsystem#getSubsystem()
	 * @see #getGenSubsystem()
	 * @generated
	 */
	EReference getGenSubsystem_Subsystem();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl <em>Gen Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenModelImpl
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenModel()
		 * @generated
		 */
		EClass GEN_MODEL = eINSTANCE.getGenModel();

		/**
		 * The meta object literal for the '<em><b>Gen Top Level System</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MODEL__GEN_TOP_LEVEL_SYSTEM = eINSTANCE.getGenModel_GenTopLevelSystem();

		/**
		 * The meta object literal for the '<em><b>Execution Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_MODEL__EXECUTION_MODEL = eINSTANCE.getGenModel_ExecutionModel();

		/**
		 * The meta object literal for the '<em><b>Source Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MODEL__SOURCE_DIRECTORY = eINSTANCE.getGenModel_SourceDirectory();

		/**
		 * The meta object literal for the '<em><b>Header Directory</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MODEL__HEADER_DIRECTORY = eINSTANCE.getGenModel_HeaderDirectory();

		/**
		 * The meta object literal for the '<em><b>Main Source File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MODEL__MAIN_SOURCE_FILE = eINSTANCE.getGenModel_MainSourceFile();

		/**
		 * The meta object literal for the '<em><b>Main Header File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MODEL__MAIN_HEADER_FILE = eINSTANCE.getGenModel_MainHeaderFile();

		/**
		 * The meta object literal for the '<em><b>Singleton</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_MODEL__SINGLETON = eINSTANCE.getGenModel_Singleton();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSystemImpl <em>Gen System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSystemImpl
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenSystem()
		 * @generated
		 */
		EClass GEN_SYSTEM = eINSTANCE.getGenSystem();

		/**
		 * The meta object literal for the '<em><b>Gen Subsystems</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_SYSTEM__GEN_SUBSYSTEMS = eINSTANCE.getGenSystem_GenSubsystems();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GEN_SYSTEM__PREFIX = eINSTANCE.getGenSystem_Prefix();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenTopLevelSystemImpl <em>Gen Top Level System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenTopLevelSystemImpl
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenTopLevelSystem()
		 * @generated
		 */
		EClass GEN_TOP_LEVEL_SYSTEM = eINSTANCE.getGenTopLevelSystem();

		/**
		 * The meta object literal for the '<em><b>Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_TOP_LEVEL_SYSTEM__FRAGMENT = eINSTANCE.getGenTopLevelSystem_Fragment();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSubsystemImpl <em>Gen Subsystem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.GenSubsystemImpl
		 * @see org.eclipselabs.damos.codegen.c.cgenmodel.impl.CGenModelPackageImpl#getGenSubsystem()
		 * @generated
		 */
		EClass GEN_SUBSYSTEM = eINSTANCE.getGenSubsystem();

		/**
		 * The meta object literal for the '<em><b>Enclosing Gen System</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_SUBSYSTEM__ENCLOSING_GEN_SYSTEM = eINSTANCE.getGenSubsystem_EnclosingGenSystem();

		/**
		 * The meta object literal for the '<em><b>Subsystem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GEN_SUBSYSTEM__SUBSYSTEM = eINSTANCE.getGenSubsystem_Subsystem();

	}

} //CGenModelPackage
