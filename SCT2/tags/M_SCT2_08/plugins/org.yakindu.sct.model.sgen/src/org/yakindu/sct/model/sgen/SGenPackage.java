/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.yakindu.sct.model.sgen.SGenFactory
 * @model kind="package"
 * @generated
 */
public interface SGenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sgen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/statechart/SGen";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sgen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SGenPackage eINSTANCE = org.yakindu.sct.model.sgen.impl.SGenPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl <em>Generator Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.GeneratorModelImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorModel()
	 * @generated
	 */
	int GENERATOR_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL__ENTRIES = 0;

	/**
	 * The feature id for the '<em><b>Generator Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL__GENERATOR_ID = 1;

	/**
	 * The number of structural features of the '<em>Generator Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl <em>Generator Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorConfiguration()
	 * @generated
	 */
	int GENERATOR_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_CONFIGURATION__CONFIGURATIONS = 0;

	/**
	 * The number of structural features of the '<em>Generator Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeImpl <em>Feature Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureType()
	 * @generated
	 */
	int FEATURE_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__NAME = SGraphPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE__PARAMETERS = SGraphPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_FEATURE_COUNT = SGraphPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterImpl <em>Feature Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameter()
	 * @generated
	 */
	int FEATURE_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__NAME = SGraphPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Feature Type</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER__FEATURE_TYPE = SGraphPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_FEATURE_COUNT = SGraphPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureConfiguration()
	 * @generated
	 */
	int FEATURE_CONFIGURATION = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Parameter Values</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION__PARAMETER_VALUES = 1;

	/**
	 * The number of structural features of the '<em>Feature Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl <em>Generator Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorEntry()
	 * @generated
	 */
	int GENERATOR_ENTRY = 5;

	/**
	 * The feature id for the '<em><b>Statechart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_ENTRY__STATECHART = 0;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_ENTRY__FEATURES = 1;

	/**
	 * The number of structural features of the '<em>Generator Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERATOR_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl <em>Feature Parameter Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameterValue()
	 * @generated
	 */
	int FEATURE_PARAMETER_VALUE = 6;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_VALUE__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_VALUE__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Feature Parameter Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PARAMETER_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl <em>Feature Type Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl
	 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureTypeLibrary()
	 * @generated
	 */
	int FEATURE_TYPE_LIBRARY = 7;

	/**
	 * The feature id for the '<em><b>Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_LIBRARY__TYPES = 0;

	/**
	 * The number of structural features of the '<em>Feature Type Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_TYPE_LIBRARY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.GeneratorModel <em>Generator Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Model</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel
	 * @generated
	 */
	EClass getGeneratorModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.GeneratorModel#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel#getEntries()
	 * @see #getGeneratorModel()
	 * @generated
	 */
	EReference getGeneratorModel_Entries();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.GeneratorModel#getGeneratorId <em>Generator Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Generator Id</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorModel#getGeneratorId()
	 * @see #getGeneratorModel()
	 * @generated
	 */
	EAttribute getGeneratorModel_GeneratorId();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.GeneratorConfiguration <em>Generator Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Configuration</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorConfiguration
	 * @generated
	 */
	EClass getGeneratorConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.GeneratorConfiguration#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorConfiguration#getConfigurations()
	 * @see #getGeneratorConfiguration()
	 * @generated
	 */
	EReference getGeneratorConfiguration_Configurations();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Type</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureType
	 * @generated
	 */
	EClass getFeatureType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.FeatureType#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureType#getParameters()
	 * @see #getFeatureType()
	 * @generated
	 */
	EReference getFeatureType_Parameters();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureParameter <em>Feature Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Parameter</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameter
	 * @generated
	 */
	EClass getFeatureParameter();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType <em>Feature Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Feature Type</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameter#getFeatureType()
	 * @see #getFeatureParameter()
	 * @generated
	 */
	EReference getFeatureParameter_FeatureType();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureConfiguration <em>Feature Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Configuration</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureConfiguration
	 * @generated
	 */
	EClass getFeatureConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgen.FeatureConfiguration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureConfiguration#getType()
	 * @see #getFeatureConfiguration()
	 * @generated
	 */
	EReference getFeatureConfiguration_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.FeatureConfiguration#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Values</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureConfiguration#getParameterValues()
	 * @see #getFeatureConfiguration()
	 * @generated
	 */
	EReference getFeatureConfiguration_ParameterValues();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.GeneratorEntry <em>Generator Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generator Entry</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorEntry
	 * @generated
	 */
	EClass getGeneratorEntry();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getStatechart <em>Statechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Statechart</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorEntry#getStatechart()
	 * @see #getGeneratorEntry()
	 * @generated
	 */
	EReference getGeneratorEntry_Statechart();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.GeneratorEntry#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.yakindu.sct.model.sgen.GeneratorEntry#getFeatures()
	 * @see #getGeneratorEntry()
	 * @generated
	 */
	EReference getGeneratorEntry_Features();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureParameterValue <em>Feature Parameter Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Parameter Value</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameterValue
	 * @generated
	 */
	EClass getFeatureParameterValue();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameterValue#getParameter()
	 * @see #getFeatureParameterValue()
	 * @generated
	 */
	EReference getFeatureParameterValue_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureParameterValue#getValue()
	 * @see #getFeatureParameterValue()
	 * @generated
	 */
	EAttribute getFeatureParameterValue_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.sgen.FeatureTypeLibrary <em>Feature Type Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Type Library</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureTypeLibrary
	 * @generated
	 */
	EClass getFeatureTypeLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.sgen.FeatureTypeLibrary#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Types</em>'.
	 * @see org.yakindu.sct.model.sgen.FeatureTypeLibrary#getTypes()
	 * @see #getFeatureTypeLibrary()
	 * @generated
	 */
	EReference getFeatureTypeLibrary_Types();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SGenFactory getSGenFactory();

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
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl <em>Generator Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.GeneratorModelImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorModel()
		 * @generated
		 */
		EClass GENERATOR_MODEL = eINSTANCE.getGeneratorModel();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_MODEL__ENTRIES = eINSTANCE.getGeneratorModel_Entries();

		/**
		 * The meta object literal for the '<em><b>Generator Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERATOR_MODEL__GENERATOR_ID = eINSTANCE.getGeneratorModel_GeneratorId();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl <em>Generator Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.GeneratorConfigurationImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorConfiguration()
		 * @generated
		 */
		EClass GENERATOR_CONFIGURATION = eINSTANCE.getGeneratorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_CONFIGURATION__CONFIGURATIONS = eINSTANCE.getGeneratorConfiguration_Configurations();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeImpl <em>Feature Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureType()
		 * @generated
		 */
		EClass FEATURE_TYPE = eINSTANCE.getFeatureType();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TYPE__PARAMETERS = eINSTANCE.getFeatureType_Parameters();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterImpl <em>Feature Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameter()
		 * @generated
		 */
		EClass FEATURE_PARAMETER = eINSTANCE.getFeatureParameter();

		/**
		 * The meta object literal for the '<em><b>Feature Type</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PARAMETER__FEATURE_TYPE = eINSTANCE.getFeatureParameter_FeatureType();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl <em>Feature Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureConfiguration()
		 * @generated
		 */
		EClass FEATURE_CONFIGURATION = eINSTANCE.getFeatureConfiguration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIGURATION__TYPE = eINSTANCE.getFeatureConfiguration_Type();

		/**
		 * The meta object literal for the '<em><b>Parameter Values</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CONFIGURATION__PARAMETER_VALUES = eINSTANCE.getFeatureConfiguration_ParameterValues();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl <em>Generator Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getGeneratorEntry()
		 * @generated
		 */
		EClass GENERATOR_ENTRY = eINSTANCE.getGeneratorEntry();

		/**
		 * The meta object literal for the '<em><b>Statechart</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_ENTRY__STATECHART = eINSTANCE.getGeneratorEntry_Statechart();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERATOR_ENTRY__FEATURES = eINSTANCE.getGeneratorEntry_Features();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl <em>Feature Parameter Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureParameterValueImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureParameterValue()
		 * @generated
		 */
		EClass FEATURE_PARAMETER_VALUE = eINSTANCE.getFeatureParameterValue();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PARAMETER_VALUE__PARAMETER = eINSTANCE.getFeatureParameterValue_Parameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_PARAMETER_VALUE__VALUE = eINSTANCE.getFeatureParameterValue_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl <em>Feature Type Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.sgen.impl.FeatureTypeLibraryImpl
		 * @see org.yakindu.sct.model.sgen.impl.SGenPackageImpl#getFeatureTypeLibrary()
		 * @generated
		 */
		EClass FEATURE_TYPE_LIBRARY = eINSTANCE.getFeatureTypeLibrary();

		/**
		 * The meta object literal for the '<em><b>Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_TYPE_LIBRARY__TYPES = eINSTANCE.getFeatureTypeLibrary_Types();

	}

} //SGenPackage
