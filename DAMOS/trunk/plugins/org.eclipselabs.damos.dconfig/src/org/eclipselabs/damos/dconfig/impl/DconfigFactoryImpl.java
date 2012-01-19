/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.dconfig.ComponentConfiguration;
import org.eclipselabs.damos.dconfig.ComponentConfigurationBody;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigFactory;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.FragmentConfigurationBody;
import org.eclipselabs.damos.dconfig.ImportDeclaration;
import org.eclipselabs.damos.dconfig.Mapping;
import org.eclipselabs.damos.dconfig.MappingBody;
import org.eclipselabs.damos.dconfig.MappingSubscript;
import org.eclipselabs.damos.dconfig.PropertyGroup;
import org.eclipselabs.damos.dconfig.ResourceDeclaration;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.RunnerDeclaration;
import org.eclipselabs.damos.dconfig.RunnerSpecifier;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SelectionPropertyBody;
import org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SimplePropertyDeclaration;
import org.eclipselabs.damos.dconfig.SubsystemConfiguration;
import org.eclipselabs.damos.dconfig.SystemConfigurationBody;
import org.eclipselabs.damos.dml.util.SystemPath;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DconfigFactoryImpl extends EFactoryImpl implements DconfigFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DconfigFactory init() {
		try {
			DconfigFactory theDconfigFactory = (DconfigFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/2011/Dconfig"); 
			if (theDconfigFactory != null) {
				return theDconfigFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DconfigFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DconfigFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DconfigPackage.CONFIGURATION: return createConfiguration();
			case DconfigPackage.IMPORT_DECLARATION: return createImportDeclaration();
			case DconfigPackage.RUNNER_SPECIFIER: return createRunnerSpecifier();
			case DconfigPackage.RUNNER_DECLARATION: return createRunnerDeclaration();
			case DconfigPackage.SIMPLE_PROPERTY: return createSimpleProperty();
			case DconfigPackage.SIMPLE_PROPERTY_DECLARATION: return createSimplePropertyDeclaration();
			case DconfigPackage.SELECTION_PROPERTY: return createSelectionProperty();
			case DconfigPackage.SELECTION_PROPERTY_BODY: return createSelectionPropertyBody();
			case DconfigPackage.SELECTION_PROPERTY_DECLARATION: return createSelectionPropertyDeclaration();
			case DconfigPackage.SELECTION_PROPERTY_OPTION: return createSelectionPropertyOption();
			case DconfigPackage.PROPERTY_GROUP: return createPropertyGroup();
			case DconfigPackage.MAPPING: return createMapping();
			case DconfigPackage.MAPPING_BODY: return createMappingBody();
			case DconfigPackage.MAPPING_SUBSCRIPT: return createMappingSubscript();
			case DconfigPackage.RESOURCE_DECLARATION: return createResourceDeclaration();
			case DconfigPackage.COMPUTATION_PROPERTY: return createComputationProperty();
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY: return createSystemConfigurationBody();
			case DconfigPackage.ROOT_SYSTEM_CONFIGURATION: return createRootSystemConfiguration();
			case DconfigPackage.SUBSYSTEM_CONFIGURATION: return createSubsystemConfiguration();
			case DconfigPackage.FRAGMENT_CONFIGURATION: return createFragmentConfiguration();
			case DconfigPackage.FRAGMENT_CONFIGURATION_BODY: return createFragmentConfigurationBody();
			case DconfigPackage.COMPONENT_CONFIGURATION: return createComponentConfiguration();
			case DconfigPackage.COMPONENT_CONFIGURATION_BODY: return createComponentConfigurationBody();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DconfigPackage.SYSTEM_PATH:
				return createSystemPathFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DconfigPackage.SYSTEM_PATH:
				return convertSystemPathToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportDeclaration createImportDeclaration() {
		ImportDeclarationImpl importDeclaration = new ImportDeclarationImpl();
		return importDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunnerSpecifier createRunnerSpecifier() {
		RunnerSpecifierImpl runnerSpecifier = new RunnerSpecifierImpl();
		return runnerSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunnerDeclaration createRunnerDeclaration() {
		RunnerDeclarationImpl runnerDeclaration = new RunnerDeclarationImpl();
		return runnerDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleProperty createSimpleProperty() {
		SimplePropertyImpl simpleProperty = new SimplePropertyImpl();
		return simpleProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplePropertyDeclaration createSimplePropertyDeclaration() {
		SimplePropertyDeclarationImpl simplePropertyDeclaration = new SimplePropertyDeclarationImpl();
		return simplePropertyDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionProperty createSelectionProperty() {
		SelectionPropertyImpl selectionProperty = new SelectionPropertyImpl();
		return selectionProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPropertyBody createSelectionPropertyBody() {
		SelectionPropertyBodyImpl selectionPropertyBody = new SelectionPropertyBodyImpl();
		return selectionPropertyBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPropertyDeclaration createSelectionPropertyDeclaration() {
		SelectionPropertyDeclarationImpl selectionPropertyDeclaration = new SelectionPropertyDeclarationImpl();
		return selectionPropertyDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPropertyOption createSelectionPropertyOption() {
		SelectionPropertyOptionImpl selectionPropertyOption = new SelectionPropertyOptionImpl();
		return selectionPropertyOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyGroup createPropertyGroup() {
		PropertyGroupImpl propertyGroup = new PropertyGroupImpl();
		return propertyGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingBody createMappingBody() {
		MappingBodyImpl mappingBody = new MappingBodyImpl();
		return mappingBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingSubscript createMappingSubscript() {
		MappingSubscriptImpl mappingSubscript = new MappingSubscriptImpl();
		return mappingSubscript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDeclaration createResourceDeclaration() {
		ResourceDeclarationImpl resourceDeclaration = new ResourceDeclarationImpl();
		return resourceDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputationProperty createComputationProperty() {
		ComputationPropertyImpl computationProperty = new ComputationPropertyImpl();
		return computationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemConfigurationBody createSystemConfigurationBody() {
		SystemConfigurationBodyImpl systemConfigurationBody = new SystemConfigurationBodyImpl();
		return systemConfigurationBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootSystemConfiguration createRootSystemConfiguration() {
		RootSystemConfigurationImpl rootSystemConfiguration = new RootSystemConfigurationImpl();
		return rootSystemConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SubsystemConfiguration createSubsystemConfiguration() {
		SubsystemConfigurationImpl subsystemConfiguration = new SubsystemConfigurationImpl();
		return subsystemConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FragmentConfiguration createFragmentConfiguration() {
		FragmentConfigurationImpl fragmentConfiguration = new FragmentConfigurationImpl();
		return fragmentConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FragmentConfigurationBody createFragmentConfigurationBody() {
		FragmentConfigurationBodyImpl fragmentConfigurationBody = new FragmentConfigurationBodyImpl();
		return fragmentConfigurationBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentConfiguration createComponentConfiguration() {
		ComponentConfigurationImpl componentConfiguration = new ComponentConfigurationImpl();
		return componentConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentConfigurationBody createComponentConfigurationBody() {
		ComponentConfigurationBodyImpl componentConfigurationBody = new ComponentConfigurationBodyImpl();
		return componentConfigurationBody;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemPath createSystemPathFromString(EDataType eDataType, String initialValue) {
		return (SystemPath)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSystemPathToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DconfigPackage getDconfigPackage() {
		return (DconfigPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DconfigPackage getPackage() {
		return DconfigPackage.eINSTANCE;
	}

} //DconfigFactoryImpl
