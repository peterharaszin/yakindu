/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.common.util.NumberedList;
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.dconfig.BindingBody;
import org.eclipselabs.damos.dconfig.BindingResourceReference;
import org.eclipselabs.damos.dconfig.BindingResourceSubscript;
import org.eclipselabs.damos.dconfig.ComponentConfiguration;
import org.eclipselabs.damos.dconfig.ComponentConfigurationBody;
import org.eclipselabs.damos.dconfig.ComponentPath;
import org.eclipselabs.damos.dconfig.ComponentReference;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.ConfigurationDefinition;
import org.eclipselabs.damos.dconfig.ConfigurationDefinitionMember;
import org.eclipselabs.damos.dconfig.DconfigFactory;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.DeclaredProperty;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.FragmentConfigurationBody;
import org.eclipselabs.damos.dconfig.Property;
import org.eclipselabs.damos.dconfig.PropertyContainer;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.PropertyDeclarationContainer;
import org.eclipselabs.damos.dconfig.ResourceDeclaration;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.SelectionProperty;
import org.eclipselabs.damos.dconfig.SelectionPropertyBody;
import org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;
import org.eclipselabs.damos.dconfig.SimpleProperty;
import org.eclipselabs.damos.dconfig.SimplePropertyDeclaration;
import org.eclipselabs.damos.dconfig.SubsystemConfiguration;
import org.eclipselabs.damos.dconfig.SystemConfiguration;
import org.eclipselabs.damos.dconfig.SystemConfigurationBody;
import org.eclipselabs.damos.dconfig.util.PropertyPath;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DconfigPackageImpl extends EPackageImpl implements DconfigPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationDefinitionMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declaredPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplePropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDeclarationContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingResourceReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingResourceSubscriptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bindingBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplePropertyDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionPropertyBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionPropertyDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectionPropertyOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemConfigurationBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootSystemConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentConfigurationBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentConfigurationBodyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertyPathEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType systemPathEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType numberedListEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DconfigPackageImpl() {
		super(eNS_URI, DconfigFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DconfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DconfigPackage init() {
		if (isInited) return (DconfigPackage)EPackage.Registry.INSTANCE.getEPackage(DconfigPackage.eNS_URI);

		// Obtain or create and register package
		DconfigPackageImpl theDconfigPackage = (DconfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DconfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DconfigPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ComputationModelPackage.eINSTANCE.eClass();
		DMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDconfigPackage.createPackageContents();

		// Initialize created meta-data
		theDconfigPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDconfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DconfigPackage.eNS_URI, theDconfigPackage);
		return theDconfigPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_PackageName() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Name() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_BaseConfiguration() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_ImportDeclarations() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_RootSystemConfiguration() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationDefinition() {
		return configurationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationDefinition_PackageName() {
		return (EAttribute)configurationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationDefinition_Members() {
		return (EReference)configurationDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationDefinitionMember() {
		return configurationDefinitionMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationDefinitionMember_Owner() {
		return (EReference)configurationDefinitionMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationDefinitionMember_Name() {
		return (EAttribute)configurationDefinitionMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfigurationDefinitionMember_QualifiedName() {
		return (EAttribute)configurationDefinitionMemberEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyContainer() {
		return propertyContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContainer_Properties() {
		return (EReference)propertyContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProperty_Propagate() {
		return (EAttribute)propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaredProperty() {
		return declaredPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleProperty() {
		return simplePropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleProperty_Value() {
		return (EReference)simplePropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleProperty_Declaration() {
		return (EReference)simplePropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyDeclaration() {
		return propertyDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyDeclarationContainer() {
		return propertyDeclarationContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyDeclarationContainer_PropertyDeclarations() {
		return (EReference)propertyDeclarationContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentPath() {
		return componentPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentPath_References() {
		return (EReference)componentPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentReference() {
		return componentReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentReference_Component() {
		return (EReference)componentReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinding() {
		return bindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_Target() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_Source() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinding_Body() {
		return (EReference)bindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingResourceReference() {
		return bindingResourceReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingResourceReference_ResourceDeclaration() {
		return (EReference)bindingResourceReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingResourceReference_Subscript() {
		return (EReference)bindingResourceReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingResourceSubscript() {
		return bindingResourceSubscriptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBindingResourceSubscript_Index() {
		return (EAttribute)bindingResourceSubscriptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBindingBody() {
		return bindingBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBindingBody_Owner() {
		return (EReference)bindingBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimplePropertyDeclaration() {
		return simplePropertyDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimplePropertyDeclaration_TypeSpecifier() {
		return (EReference)simplePropertyDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimplePropertyDeclaration_DefaultValue() {
		return (EReference)simplePropertyDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionProperty() {
		return selectionPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionProperty_Declaration() {
		return (EReference)selectionPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectionProperty_Index() {
		return (EAttribute)selectionPropertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionProperty_Selection() {
		return (EReference)selectionPropertyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionProperty_Body() {
		return (EReference)selectionPropertyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionPropertyBody() {
		return selectionPropertyBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionPropertyBody_Owner() {
		return (EReference)selectionPropertyBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionPropertyBody_Bindings() {
		return (EReference)selectionPropertyBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionPropertyDeclaration() {
		return selectionPropertyDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectionPropertyDeclaration_Count() {
		return (EAttribute)selectionPropertyDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectionPropertyOption() {
		return selectionPropertyOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionPropertyOption_Target() {
		return (EReference)selectionPropertyOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectionPropertyOption_ResourceDeclarations() {
		return (EReference)selectionPropertyOptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceDeclaration() {
		return resourceDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDeclaration_Name() {
		return (EAttribute)resourceDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResourceDeclaration_Count() {
		return (EAttribute)resourceDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputationProperty() {
		return computationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComputationProperty_ComputationModel() {
		return (EReference)computationPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemConfiguration() {
		return systemConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemConfiguration_Body() {
		return (EReference)systemConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemConfigurationBody() {
		return systemConfigurationBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemConfigurationBody_Owner() {
		return (EReference)systemConfigurationBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemConfigurationBody_ComponentConfigurations() {
		return (EReference)systemConfigurationBodyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemConfigurationBody_FragmentConfigurations() {
		return (EReference)systemConfigurationBodyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemConfigurationBody_SubsystemConfigurations() {
		return (EReference)systemConfigurationBodyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootSystemConfiguration() {
		return rootSystemConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootSystemConfiguration_ContextFragment() {
		return (EReference)rootSystemConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystemConfiguration() {
		return subsystemConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystemConfiguration_Subsystem() {
		return (EReference)subsystemConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystemConfiguration_Parent() {
		return (EReference)subsystemConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragmentConfiguration() {
		return fragmentConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentConfiguration_StartFragment() {
		return (EReference)fragmentConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentConfiguration_EndFragment() {
		return (EReference)fragmentConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFragmentConfiguration_Range() {
		return (EAttribute)fragmentConfigurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentConfiguration_Body() {
		return (EReference)fragmentConfigurationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragmentConfigurationBody() {
		return fragmentConfigurationBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentConfigurationBody_Owner() {
		return (EReference)fragmentConfigurationBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentConfiguration() {
		return componentConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentConfiguration_Component() {
		return (EReference)componentConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentConfiguration_Body() {
		return (EReference)componentConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentConfigurationBody() {
		return componentConfigurationBodyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentConfigurationBody_Owner() {
		return (EReference)componentConfigurationBodyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPropertyPath() {
		return propertyPathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSystemPath() {
		return systemPathEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNumberedList() {
		return numberedListEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DconfigFactory getDconfigFactory() {
		return (DconfigFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		configurationEClass = createEClass(CONFIGURATION);
		createEAttribute(configurationEClass, CONFIGURATION__PACKAGE_NAME);
		createEAttribute(configurationEClass, CONFIGURATION__NAME);
		createEReference(configurationEClass, CONFIGURATION__BASE_CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__IMPORT_DECLARATIONS);
		createEReference(configurationEClass, CONFIGURATION__ROOT_SYSTEM_CONFIGURATION);

		configurationDefinitionEClass = createEClass(CONFIGURATION_DEFINITION);
		createEAttribute(configurationDefinitionEClass, CONFIGURATION_DEFINITION__PACKAGE_NAME);
		createEReference(configurationDefinitionEClass, CONFIGURATION_DEFINITION__MEMBERS);

		configurationDefinitionMemberEClass = createEClass(CONFIGURATION_DEFINITION_MEMBER);
		createEReference(configurationDefinitionMemberEClass, CONFIGURATION_DEFINITION_MEMBER__OWNER);
		createEAttribute(configurationDefinitionMemberEClass, CONFIGURATION_DEFINITION_MEMBER__NAME);
		createEAttribute(configurationDefinitionMemberEClass, CONFIGURATION_DEFINITION_MEMBER__QUALIFIED_NAME);

		propertyContainerEClass = createEClass(PROPERTY_CONTAINER);
		createEReference(propertyContainerEClass, PROPERTY_CONTAINER__PROPERTIES);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__PROPAGATE);

		declaredPropertyEClass = createEClass(DECLARED_PROPERTY);

		simplePropertyEClass = createEClass(SIMPLE_PROPERTY);
		createEReference(simplePropertyEClass, SIMPLE_PROPERTY__VALUE);
		createEReference(simplePropertyEClass, SIMPLE_PROPERTY__DECLARATION);

		simplePropertyDeclarationEClass = createEClass(SIMPLE_PROPERTY_DECLARATION);
		createEReference(simplePropertyDeclarationEClass, SIMPLE_PROPERTY_DECLARATION__TYPE_SPECIFIER);
		createEReference(simplePropertyDeclarationEClass, SIMPLE_PROPERTY_DECLARATION__DEFAULT_VALUE);

		selectionPropertyEClass = createEClass(SELECTION_PROPERTY);
		createEReference(selectionPropertyEClass, SELECTION_PROPERTY__DECLARATION);
		createEAttribute(selectionPropertyEClass, SELECTION_PROPERTY__INDEX);
		createEReference(selectionPropertyEClass, SELECTION_PROPERTY__SELECTION);
		createEReference(selectionPropertyEClass, SELECTION_PROPERTY__BODY);

		selectionPropertyBodyEClass = createEClass(SELECTION_PROPERTY_BODY);
		createEReference(selectionPropertyBodyEClass, SELECTION_PROPERTY_BODY__OWNER);
		createEReference(selectionPropertyBodyEClass, SELECTION_PROPERTY_BODY__BINDINGS);

		selectionPropertyDeclarationEClass = createEClass(SELECTION_PROPERTY_DECLARATION);
		createEAttribute(selectionPropertyDeclarationEClass, SELECTION_PROPERTY_DECLARATION__COUNT);

		selectionPropertyOptionEClass = createEClass(SELECTION_PROPERTY_OPTION);
		createEReference(selectionPropertyOptionEClass, SELECTION_PROPERTY_OPTION__TARGET);
		createEReference(selectionPropertyOptionEClass, SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS);

		propertyDeclarationEClass = createEClass(PROPERTY_DECLARATION);

		propertyDeclarationContainerEClass = createEClass(PROPERTY_DECLARATION_CONTAINER);
		createEReference(propertyDeclarationContainerEClass, PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS);

		componentPathEClass = createEClass(COMPONENT_PATH);
		createEReference(componentPathEClass, COMPONENT_PATH__REFERENCES);

		componentReferenceEClass = createEClass(COMPONENT_REFERENCE);
		createEReference(componentReferenceEClass, COMPONENT_REFERENCE__COMPONENT);

		bindingEClass = createEClass(BINDING);
		createEReference(bindingEClass, BINDING__TARGET);
		createEReference(bindingEClass, BINDING__SOURCE);
		createEReference(bindingEClass, BINDING__BODY);

		bindingResourceReferenceEClass = createEClass(BINDING_RESOURCE_REFERENCE);
		createEReference(bindingResourceReferenceEClass, BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION);
		createEReference(bindingResourceReferenceEClass, BINDING_RESOURCE_REFERENCE__SUBSCRIPT);

		bindingResourceSubscriptEClass = createEClass(BINDING_RESOURCE_SUBSCRIPT);
		createEAttribute(bindingResourceSubscriptEClass, BINDING_RESOURCE_SUBSCRIPT__INDEX);

		bindingBodyEClass = createEClass(BINDING_BODY);
		createEReference(bindingBodyEClass, BINDING_BODY__OWNER);

		resourceDeclarationEClass = createEClass(RESOURCE_DECLARATION);
		createEAttribute(resourceDeclarationEClass, RESOURCE_DECLARATION__NAME);
		createEAttribute(resourceDeclarationEClass, RESOURCE_DECLARATION__COUNT);

		computationPropertyEClass = createEClass(COMPUTATION_PROPERTY);
		createEReference(computationPropertyEClass, COMPUTATION_PROPERTY__COMPUTATION_MODEL);

		systemConfigurationEClass = createEClass(SYSTEM_CONFIGURATION);
		createEReference(systemConfigurationEClass, SYSTEM_CONFIGURATION__BODY);

		systemConfigurationBodyEClass = createEClass(SYSTEM_CONFIGURATION_BODY);
		createEReference(systemConfigurationBodyEClass, SYSTEM_CONFIGURATION_BODY__OWNER);
		createEReference(systemConfigurationBodyEClass, SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS);
		createEReference(systemConfigurationBodyEClass, SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS);
		createEReference(systemConfigurationBodyEClass, SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS);

		rootSystemConfigurationEClass = createEClass(ROOT_SYSTEM_CONFIGURATION);
		createEReference(rootSystemConfigurationEClass, ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT);

		subsystemConfigurationEClass = createEClass(SUBSYSTEM_CONFIGURATION);
		createEReference(subsystemConfigurationEClass, SUBSYSTEM_CONFIGURATION__PARENT);
		createEReference(subsystemConfigurationEClass, SUBSYSTEM_CONFIGURATION__SUBSYSTEM);

		fragmentConfigurationEClass = createEClass(FRAGMENT_CONFIGURATION);
		createEReference(fragmentConfigurationEClass, FRAGMENT_CONFIGURATION__START_FRAGMENT);
		createEReference(fragmentConfigurationEClass, FRAGMENT_CONFIGURATION__END_FRAGMENT);
		createEAttribute(fragmentConfigurationEClass, FRAGMENT_CONFIGURATION__RANGE);
		createEReference(fragmentConfigurationEClass, FRAGMENT_CONFIGURATION__BODY);

		fragmentConfigurationBodyEClass = createEClass(FRAGMENT_CONFIGURATION_BODY);
		createEReference(fragmentConfigurationBodyEClass, FRAGMENT_CONFIGURATION_BODY__OWNER);

		componentConfigurationEClass = createEClass(COMPONENT_CONFIGURATION);
		createEReference(componentConfigurationEClass, COMPONENT_CONFIGURATION__COMPONENT);
		createEReference(componentConfigurationEClass, COMPONENT_CONFIGURATION__BODY);

		componentConfigurationBodyEClass = createEClass(COMPONENT_CONFIGURATION_BODY);
		createEReference(componentConfigurationBodyEClass, COMPONENT_CONFIGURATION_BODY__OWNER);

		// Create data types
		propertyPathEDataType = createEDataType(PROPERTY_PATH);
		systemPathEDataType = createEDataType(SYSTEM_PATH);
		numberedListEDataType = createEDataType(NUMBERED_LIST);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MscriptPackage theMscriptPackage = (MscriptPackage)EPackage.Registry.INSTANCE.getEPackage(MscriptPackage.eNS_URI);
		DMLPackage theDMLPackage = (DMLPackage)EPackage.Registry.INSTANCE.getEPackage(DMLPackage.eNS_URI);
		ComputationModelPackage theComputationModelPackage = (ComputationModelPackage)EPackage.Registry.INSTANCE.getEPackage(ComputationModelPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(numberedListEDataType, "V");

		// Set bounds for type parameters

		// Add supertypes to classes
		configurationEClass.getESuperTypes().add(this.getPropertyContainer());
		configurationEClass.getESuperTypes().add(theMscriptPackage.getIPackageMember());
		declaredPropertyEClass.getESuperTypes().add(this.getProperty());
		simplePropertyEClass.getESuperTypes().add(this.getDeclaredProperty());
		simplePropertyDeclarationEClass.getESuperTypes().add(this.getPropertyDeclaration());
		selectionPropertyEClass.getESuperTypes().add(this.getDeclaredProperty());
		selectionPropertyBodyEClass.getESuperTypes().add(this.getPropertyContainer());
		selectionPropertyDeclarationEClass.getESuperTypes().add(this.getPropertyDeclaration());
		selectionPropertyOptionEClass.getESuperTypes().add(this.getPropertyDeclarationContainer());
		selectionPropertyOptionEClass.getESuperTypes().add(this.getConfigurationDefinitionMember());
		propertyDeclarationEClass.getESuperTypes().add(this.getConfigurationDefinitionMember());
		bindingBodyEClass.getESuperTypes().add(this.getPropertyContainer());
		resourceDeclarationEClass.getESuperTypes().add(this.getPropertyDeclarationContainer());
		computationPropertyEClass.getESuperTypes().add(this.getProperty());
		systemConfigurationBodyEClass.getESuperTypes().add(this.getPropertyContainer());
		rootSystemConfigurationEClass.getESuperTypes().add(this.getSystemConfiguration());
		subsystemConfigurationEClass.getESuperTypes().add(this.getSystemConfiguration());
		fragmentConfigurationBodyEClass.getESuperTypes().add(this.getPropertyContainer());
		componentConfigurationBodyEClass.getESuperTypes().add(this.getPropertyContainer());

		// Initialize classes and features; add operations and parameters
		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfiguration_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Name(), ecorePackage.getEString(), "name", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_BaseConfiguration(), this.getConfiguration(), null, "baseConfiguration", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_ImportDeclarations(), theMscriptPackage.getImportDeclaration(), null, "importDeclarations", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfiguration_RootSystemConfiguration(), this.getRootSystemConfiguration(), null, "rootSystemConfiguration", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(configurationEClass, theDMLPackage.getFragment(), "getContextFragment", 0, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = addEOperation(configurationEClass, theMscriptPackage.getExpression(), "getPropertyValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyPath(), "propertyPath", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(configurationEClass, theMscriptPackage.getExpression(), "getPropertyValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemPath(), "systemPath", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyPath(), "propertyPath", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(configurationEClass, ecorePackage.getEString(), "getPropertySelectionName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyPath(), "propertyPath", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(configurationEClass, ecorePackage.getEString(), "getPropertySelectionName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemPath(), "systemPath", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyPath(), "propertyPath", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(configurationEClass, null, "getPropertySelectionNames", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyPath(), "propertyPath", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(this.getNumberedList());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(configurationEClass, null, "getPropertySelectionNames", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemPath(), "systemPath", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyPath(), "propertyPath", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getNumberedList());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(configurationEClass, this.getBinding(), "getBinding", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getPropertyPath(), "propertyPath", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemPath(), "sourcePath", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(configurationEClass, theComputationModelPackage.getComputationModel(), "getComputationModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSystemPath(), "systemPath", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(configurationDefinitionEClass, ConfigurationDefinition.class, "ConfigurationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfigurationDefinition_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, ConfigurationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConfigurationDefinition_Members(), this.getConfigurationDefinitionMember(), this.getConfigurationDefinitionMember_Owner(), "members", null, 0, -1, ConfigurationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationDefinitionMemberEClass, ConfigurationDefinitionMember.class, "ConfigurationDefinitionMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurationDefinitionMember_Owner(), this.getConfigurationDefinition(), this.getConfigurationDefinition_Members(), "owner", null, 0, 1, ConfigurationDefinitionMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationDefinitionMember_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConfigurationDefinitionMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfigurationDefinitionMember_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, ConfigurationDefinitionMember.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(propertyContainerEClass, PropertyContainer.class, "PropertyContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyContainer_Properties(), this.getProperty(), null, "properties", null, 0, -1, PropertyContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyEClass, Property.class, "Property", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Propagate(), ecorePackage.getEBoolean(), "propagate", null, 0, 1, Property.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(propertyEClass, ecorePackage.getEString(), "getId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(declaredPropertyEClass, DeclaredProperty.class, "DeclaredProperty", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(declaredPropertyEClass, this.getPropertyDeclaration(), "getDeclaration", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simplePropertyEClass, SimpleProperty.class, "SimpleProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleProperty_Value(), theMscriptPackage.getExpression(), null, "value", null, 0, 1, SimpleProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimpleProperty_Declaration(), this.getSimplePropertyDeclaration(), null, "declaration", null, 0, 1, SimpleProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simplePropertyDeclarationEClass, SimplePropertyDeclaration.class, "SimplePropertyDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimplePropertyDeclaration_TypeSpecifier(), theMscriptPackage.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, SimplePropertyDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSimplePropertyDeclaration_DefaultValue(), theMscriptPackage.getExpression(), null, "defaultValue", null, 0, 1, SimplePropertyDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionPropertyEClass, SelectionProperty.class, "SelectionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionProperty_Declaration(), this.getSelectionPropertyDeclaration(), null, "declaration", null, 0, 1, SelectionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectionProperty_Index(), ecorePackage.getEInt(), "index", "-1", 0, 1, SelectionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectionProperty_Selection(), this.getSelectionPropertyOption(), null, "selection", null, 0, 1, SelectionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectionProperty_Body(), this.getSelectionPropertyBody(), this.getSelectionPropertyBody_Owner(), "body", null, 0, 1, SelectionProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionPropertyBodyEClass, SelectionPropertyBody.class, "SelectionPropertyBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionPropertyBody_Owner(), this.getSelectionProperty(), this.getSelectionProperty_Body(), "owner", null, 0, 1, SelectionPropertyBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectionPropertyBody_Bindings(), this.getBinding(), null, "bindings", null, 0, -1, SelectionPropertyBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionPropertyDeclarationEClass, SelectionPropertyDeclaration.class, "SelectionPropertyDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSelectionPropertyDeclaration_Count(), ecorePackage.getEInt(), "count", "1", 0, 1, SelectionPropertyDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectionPropertyOptionEClass, SelectionPropertyOption.class, "SelectionPropertyOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectionPropertyOption_Target(), this.getSelectionPropertyDeclaration(), null, "target", null, 0, 1, SelectionPropertyOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectionPropertyOption_ResourceDeclarations(), this.getResourceDeclaration(), null, "resourceDeclarations", null, 0, -1, SelectionPropertyOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyDeclarationEClass, PropertyDeclaration.class, "PropertyDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyDeclarationContainerEClass, PropertyDeclarationContainer.class, "PropertyDeclarationContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyDeclarationContainer_PropertyDeclarations(), this.getPropertyDeclaration(), null, "propertyDeclarations", null, 0, -1, PropertyDeclarationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentPathEClass, ComponentPath.class, "ComponentPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentPath_References(), this.getComponentReference(), null, "references", null, 0, -1, ComponentPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(componentPathEClass, theDMLPackage.getComponent(), "getComponent", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(componentReferenceEClass, ComponentReference.class, "ComponentReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentReference_Component(), theDMLPackage.getComponent(), null, "component", null, 0, 1, ComponentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingEClass, Binding.class, "Binding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinding_Target(), this.getBindingResourceReference(), null, "target", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinding_Source(), this.getComponentPath(), null, "source", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinding_Body(), this.getBindingBody(), this.getBindingBody_Owner(), "body", null, 0, 1, Binding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingResourceReferenceEClass, BindingResourceReference.class, "BindingResourceReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingResourceReference_ResourceDeclaration(), this.getResourceDeclaration(), null, "resourceDeclaration", null, 0, 1, BindingResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBindingResourceReference_Subscript(), this.getBindingResourceSubscript(), null, "subscript", null, 0, 1, BindingResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingResourceSubscriptEClass, BindingResourceSubscript.class, "BindingResourceSubscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBindingResourceSubscript_Index(), ecorePackage.getEInt(), "index", null, 0, 1, BindingResourceSubscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bindingBodyEClass, BindingBody.class, "BindingBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBindingBody_Owner(), this.getBinding(), this.getBinding_Body(), "owner", null, 0, 1, BindingBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceDeclarationEClass, ResourceDeclaration.class, "ResourceDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, ResourceDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceDeclaration_Count(), ecorePackage.getEInt(), "count", "1", 0, 1, ResourceDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(computationPropertyEClass, ComputationProperty.class, "ComputationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComputationProperty_ComputationModel(), theComputationModelPackage.getComputationModel(), null, "computationModel", null, 0, 1, ComputationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemConfigurationEClass, SystemConfiguration.class, "SystemConfiguration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemConfiguration_Body(), this.getSystemConfigurationBody(), this.getSystemConfigurationBody_Owner(), "body", null, 0, 1, SystemConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemConfigurationBodyEClass, SystemConfigurationBody.class, "SystemConfigurationBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemConfigurationBody_Owner(), this.getSystemConfiguration(), this.getSystemConfiguration_Body(), "owner", null, 0, 1, SystemConfigurationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemConfigurationBody_ComponentConfigurations(), this.getComponentConfiguration(), null, "componentConfigurations", null, 0, -1, SystemConfigurationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemConfigurationBody_FragmentConfigurations(), this.getFragmentConfiguration(), null, "fragmentConfigurations", null, 0, -1, SystemConfigurationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemConfigurationBody_SubsystemConfigurations(), this.getSubsystemConfiguration(), null, "subsystemConfigurations", null, 0, -1, SystemConfigurationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rootSystemConfigurationEClass, RootSystemConfiguration.class, "RootSystemConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootSystemConfiguration_ContextFragment(), theDMLPackage.getFragment(), null, "contextFragment", null, 0, 1, RootSystemConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(subsystemConfigurationEClass, SubsystemConfiguration.class, "SubsystemConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemConfiguration_Parent(), this.getSystemConfiguration(), null, "parent", null, 0, 1, SubsystemConfiguration.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSubsystemConfiguration_Subsystem(), theDMLPackage.getSubsystem(), null, "subsystem", null, 0, 1, SubsystemConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fragmentConfigurationEClass, FragmentConfiguration.class, "FragmentConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentConfiguration_StartFragment(), theDMLPackage.getFragment(), null, "startFragment", null, 0, 1, FragmentConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentConfiguration_EndFragment(), theDMLPackage.getFragment(), null, "endFragment", null, 0, 1, FragmentConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFragmentConfiguration_Range(), ecorePackage.getEBoolean(), "range", null, 0, 1, FragmentConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFragmentConfiguration_Body(), this.getFragmentConfigurationBody(), this.getFragmentConfigurationBody_Owner(), "body", null, 0, 1, FragmentConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fragmentConfigurationBodyEClass, FragmentConfigurationBody.class, "FragmentConfigurationBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentConfigurationBody_Owner(), this.getFragmentConfiguration(), this.getFragmentConfiguration_Body(), "owner", null, 0, 1, FragmentConfigurationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentConfigurationEClass, ComponentConfiguration.class, "ComponentConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentConfiguration_Component(), theDMLPackage.getComponent(), null, "component", null, 0, 1, ComponentConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentConfiguration_Body(), this.getComponentConfigurationBody(), this.getComponentConfigurationBody_Owner(), "body", null, 0, 1, ComponentConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentConfigurationBodyEClass, ComponentConfigurationBody.class, "ComponentConfigurationBody", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentConfigurationBody_Owner(), this.getComponentConfiguration(), this.getComponentConfiguration_Body(), "owner", null, 0, 1, ComponentConfigurationBody.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(propertyPathEDataType, PropertyPath.class, "PropertyPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(systemPathEDataType, SystemPath.class, "SystemPath", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(numberedListEDataType, NumberedList.class, "NumberedList", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DconfigPackageImpl
