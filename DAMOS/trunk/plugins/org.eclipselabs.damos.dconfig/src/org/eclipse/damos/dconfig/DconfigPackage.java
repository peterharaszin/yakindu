/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dconfig;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.damos.dconfig.DconfigFactory
 * @model kind="package"
 * @generated
 */
public interface DconfigPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dconfig";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/damos/2011/Dconfig";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dconfig";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DconfigPackage eINSTANCE = org.eclipse.damos.dconfig.impl.DconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ConfigurationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.PropertyContainerImpl <em>Property Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.PropertyContainerImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyContainer()
	 * @generated
	 */
	int PROPERTY_CONTAINER = 3;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER__PROPERTIES = 0;

	/**
	 * The number of structural features of the '<em>Property Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PACKAGE_NAME = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__NAME = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_CONFIGURATION = PROPERTY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Import Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__IMPORT_DECLARATIONS = PROPERTY_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Root System Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ROOT_SYSTEM_CONFIGURATION = PROPERTY_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ConfigurationDefinitionImpl <em>Configuration Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ConfigurationDefinitionImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getConfigurationDefinition()
	 * @generated
	 */
	int CONFIGURATION_DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DEFINITION__PACKAGE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DEFINITION__MEMBERS = 1;

	/**
	 * The number of structural features of the '<em>Configuration Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DEFINITION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ConfigurationDefinitionMemberImpl <em>Configuration Definition Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ConfigurationDefinitionMemberImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getConfigurationDefinitionMember()
	 * @generated
	 */
	int CONFIGURATION_DEFINITION_MEMBER = 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DEFINITION_MEMBER__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DEFINITION_MEMBER__NAME = 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DEFINITION_MEMBER__QUALIFIED_NAME = 2;

	/**
	 * The number of structural features of the '<em>Configuration Definition Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_DEFINITION_MEMBER_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.PropertyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.DeclaredPropertyImpl <em>Declared Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.DeclaredPropertyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getDeclaredProperty()
	 * @generated
	 */
	int DECLARED_PROPERTY = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SimplePropertyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSimpleProperty()
	 * @generated
	 */
	int SIMPLE_PROPERTY = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.PropertyDeclarationImpl <em>Property Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.PropertyDeclarationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclaration()
	 * @generated
	 */
	int PROPERTY_DECLARATION = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SimplePropertyDeclarationImpl <em>Simple Property Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SimplePropertyDeclarationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSimplePropertyDeclaration()
	 * @generated
	 */
	int SIMPLE_PROPERTY_DECLARATION = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyImpl <em>Selection Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionProperty()
	 * @generated
	 */
	int SELECTION_PROPERTY = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyBodyImpl <em>Selection Property Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyBodyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyBody()
	 * @generated
	 */
	int SELECTION_PROPERTY_BODY = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyDeclarationImpl <em>Selection Property Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyDeclarationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyDeclaration()
	 * @generated
	 */
	int SELECTION_PROPERTY_DECLARATION = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.PropertyDeclarationContainerImpl <em>Property Declaration Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.PropertyDeclarationContainerImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclarationContainer()
	 * @generated
	 */
	int PROPERTY_DECLARATION_CONTAINER = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl <em>Selection Property Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyOption()
	 * @generated
	 */
	int SELECTION_PROPERTY_OPTION = 11;

	/**
	 * The feature id for the '<em><b>Propagate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__PROPAGATE = 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Propagate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_PROPERTY__PROPAGATE = PROPERTY__PROPAGATE;

	/**
	 * The number of structural features of the '<em>Declared Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARED_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Propagate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY__PROPAGATE = DECLARED_PROPERTY__PROPAGATE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY__VALUE = DECLARED_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY__DECLARATION = DECLARED_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_FEATURE_COUNT = DECLARED_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION__OWNER = CONFIGURATION_DEFINITION_MEMBER__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION__NAME = CONFIGURATION_DEFINITION_MEMBER__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION__QUALIFIED_NAME = CONFIGURATION_DEFINITION_MEMBER__QUALIFIED_NAME;

	/**
	 * The number of structural features of the '<em>Property Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION_FEATURE_COUNT = CONFIGURATION_DEFINITION_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_DECLARATION__OWNER = PROPERTY_DECLARATION__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_DECLARATION__NAME = PROPERTY_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_DECLARATION__QUALIFIED_NAME = PROPERTY_DECLARATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_DECLARATION__TYPE_SPECIFIER = PROPERTY_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_DECLARATION__DEFAULT_VALUE = PROPERTY_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Property Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_DECLARATION_FEATURE_COUNT = PROPERTY_DECLARATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Propagate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY__PROPAGATE = DECLARED_PROPERTY__PROPAGATE;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY__DECLARATION = DECLARED_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY__INDEX = DECLARED_PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY__SELECTION = DECLARED_PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY__BODY = DECLARED_PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Selection Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_FEATURE_COUNT = DECLARED_PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_BODY__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_BODY__OWNER = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_BODY__BINDINGS = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Selection Property Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_DECLARATION__OWNER = PROPERTY_DECLARATION__OWNER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_DECLARATION__NAME = PROPERTY_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_DECLARATION__QUALIFIED_NAME = PROPERTY_DECLARATION__QUALIFIED_NAME;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_DECLARATION__COUNT = PROPERTY_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Selection Property Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_DECLARATION_FEATURE_COUNT = PROPERTY_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Property Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS = 0;

	/**
	 * The number of structural features of the '<em>Property Declaration Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Property Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__PROPERTY_DECLARATIONS = PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__OWNER = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__NAME = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__QUALIFIED_NAME = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__TARGET = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Resource Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Selection Property Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION_FEATURE_COUNT = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ComponentPathImpl <em>Component Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ComponentPathImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentPath()
	 * @generated
	 */
	int COMPONENT_PATH = 14;

	/**
	 * The feature id for the '<em><b>References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PATH__REFERENCES = 0;

	/**
	 * The number of structural features of the '<em>Component Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_PATH_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ComponentReferenceImpl <em>Component Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ComponentReferenceImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentReference()
	 * @generated
	 */
	int COMPONENT_REFERENCE = 15;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_REFERENCE__COMPONENT = 0;

	/**
	 * The number of structural features of the '<em>Component Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.BindingImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 16;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__BODY = 2;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.BindingResourceReferenceImpl <em>Binding Resource Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.BindingResourceReferenceImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBindingResourceReference()
	 * @generated
	 */
	int BINDING_RESOURCE_REFERENCE = 17;

	/**
	 * The feature id for the '<em><b>Resource Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_RESOURCE_REFERENCE__SUBSCRIPT = 1;

	/**
	 * The number of structural features of the '<em>Binding Resource Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_RESOURCE_REFERENCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.BindingResourceSubscriptImpl <em>Binding Resource Subscript</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.BindingResourceSubscriptImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBindingResourceSubscript()
	 * @generated
	 */
	int BINDING_RESOURCE_SUBSCRIPT = 18;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_RESOURCE_SUBSCRIPT__INDEX = 0;

	/**
	 * The number of structural features of the '<em>Binding Resource Subscript</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_RESOURCE_SUBSCRIPT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.BindingBodyImpl <em>Binding Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.BindingBodyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBindingBody()
	 * @generated
	 */
	int BINDING_BODY = 19;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_BODY__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_BODY__OWNER = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Binding Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ResourceDeclarationImpl <em>Resource Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ResourceDeclarationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getResourceDeclaration()
	 * @generated
	 */
	int RESOURCE_DECLARATION = 20;

	/**
	 * The feature id for the '<em><b>Property Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DECLARATION__PROPERTY_DECLARATIONS = PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DECLARATION__NAME = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DECLARATION__COUNT = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_DECLARATION_FEATURE_COUNT = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ComputationPropertyImpl <em>Computation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ComputationPropertyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComputationProperty()
	 * @generated
	 */
	int COMPUTATION_PROPERTY = 21;

	/**
	 * The feature id for the '<em><b>Propagate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_PROPERTY__PROPAGATE = PROPERTY__PROPAGATE;

	/**
	 * The feature id for the '<em><b>Computation Model</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_PROPERTY__COMPUTATION_MODEL = PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Computation Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_PROPERTY_FEATURE_COUNT = PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SystemConfigurationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSystemConfiguration()
	 * @generated
	 */
	int SYSTEM_CONFIGURATION = 22;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION__BODY = 0;

	/**
	 * The number of structural features of the '<em>System Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SystemConfigurationBodyImpl <em>System Configuration Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SystemConfigurationBodyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSystemConfigurationBody()
	 * @generated
	 */
	int SYSTEM_CONFIGURATION_BODY = 23;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__OWNER = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Component Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fragment Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS = PROPERTY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Subsystem Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS = PROPERTY_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>System Configuration Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.RootSystemConfigurationImpl <em>Root System Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.RootSystemConfigurationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getRootSystemConfiguration()
	 * @generated
	 */
	int ROOT_SYSTEM_CONFIGURATION = 24;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_SYSTEM_CONFIGURATION__BODY = SYSTEM_CONFIGURATION__BODY;

	/**
	 * The feature id for the '<em><b>Context Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT = SYSTEM_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Root System Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_SYSTEM_CONFIGURATION_FEATURE_COUNT = SYSTEM_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.SubsystemConfigurationImpl <em>Subsystem Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.SubsystemConfigurationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSubsystemConfiguration()
	 * @generated
	 */
	int SUBSYSTEM_CONFIGURATION = 25;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_CONFIGURATION__BODY = SYSTEM_CONFIGURATION__BODY;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_CONFIGURATION__PARENT = SYSTEM_CONFIGURATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subsystem</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_CONFIGURATION__SUBSYSTEM = SYSTEM_CONFIGURATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Subsystem Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUBSYSTEM_CONFIGURATION_FEATURE_COUNT = SYSTEM_CONFIGURATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.FragmentConfigurationImpl <em>Fragment Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.FragmentConfigurationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfiguration()
	 * @generated
	 */
	int FRAGMENT_CONFIGURATION = 26;

	/**
	 * The feature id for the '<em><b>Start Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION__START_FRAGMENT = 0;

	/**
	 * The feature id for the '<em><b>End Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION__END_FRAGMENT = 1;

	/**
	 * The feature id for the '<em><b>Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION__RANGE = 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION__BODY = 3;

	/**
	 * The number of structural features of the '<em>Fragment Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION_FEATURE_COUNT = 4;


	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.FragmentConfigurationBodyImpl <em>Fragment Configuration Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.FragmentConfigurationBodyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfigurationBody()
	 * @generated
	 */
	int FRAGMENT_CONFIGURATION_BODY = 27;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION_BODY__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION_BODY__OWNER = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fragment Configuration Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FRAGMENT_CONFIGURATION_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ComponentConfigurationImpl <em>Component Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ComponentConfigurationImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentConfiguration()
	 * @generated
	 */
	int COMPONENT_CONFIGURATION = 28;

	/**
	 * The feature id for the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONFIGURATION__COMPONENT = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONFIGURATION__BODY = 1;

	/**
	 * The number of structural features of the '<em>Component Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.damos.dconfig.impl.ComponentConfigurationBodyImpl <em>Component Configuration Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.impl.ComponentConfigurationBodyImpl
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentConfigurationBody()
	 * @generated
	 */
	int COMPONENT_CONFIGURATION_BODY = 29;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONFIGURATION_BODY__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONFIGURATION_BODY__OWNER = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Component Configuration Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_CONFIGURATION_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '<em>Property Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dconfig.util.PropertyPath
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyPath()
	 * @generated
	 */
	int PROPERTY_PATH = 30;

	/**
	 * The meta object id for the '<em>System Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.dml.util.SystemPath
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSystemPath()
	 * @generated
	 */
	int SYSTEM_PATH = 31;

	/**
	 * The meta object id for the '<em>Numbered List</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.damos.common.util.NumberedList
	 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getNumberedList()
	 * @generated
	 */
	int NUMBERED_LIST = 32;

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.Configuration#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.eclipse.damos.dconfig.Configuration#getPackageName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.damos.dconfig.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.Configuration#getBaseConfiguration <em>Base Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.Configuration#getBaseConfiguration()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_BaseConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.Configuration#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.eclipse.damos.dconfig.Configuration#getImportDeclarations()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ImportDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.Configuration#getRootSystemConfiguration <em>Root System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root System Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.Configuration#getRootSystemConfiguration()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_RootSystemConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ConfigurationDefinition <em>Configuration Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Definition</em>'.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinition
	 * @generated
	 */
	EClass getConfigurationDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.ConfigurationDefinition#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinition#getPackageName()
	 * @see #getConfigurationDefinition()
	 * @generated
	 */
	EAttribute getConfigurationDefinition_PackageName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.ConfigurationDefinition#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinition#getMembers()
	 * @see #getConfigurationDefinition()
	 * @generated
	 */
	EReference getConfigurationDefinition_Members();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ConfigurationDefinitionMember <em>Configuration Definition Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Definition Member</em>'.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinitionMember
	 * @generated
	 */
	EClass getConfigurationDefinitionMember();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.damos.dconfig.ConfigurationDefinitionMember#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinitionMember#getOwner()
	 * @see #getConfigurationDefinitionMember()
	 * @generated
	 */
	EReference getConfigurationDefinitionMember_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.ConfigurationDefinitionMember#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinitionMember#getName()
	 * @see #getConfigurationDefinitionMember()
	 * @generated
	 */
	EAttribute getConfigurationDefinitionMember_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.ConfigurationDefinitionMember#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinitionMember#getQualifiedName()
	 * @see #getConfigurationDefinitionMember()
	 * @generated
	 */
	EAttribute getConfigurationDefinitionMember_QualifiedName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.PropertyContainer <em>Property Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Container</em>'.
	 * @see org.eclipse.damos.dconfig.PropertyContainer
	 * @generated
	 */
	EClass getPropertyContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.PropertyContainer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipse.damos.dconfig.PropertyContainer#getProperties()
	 * @see #getPropertyContainer()
	 * @generated
	 */
	EReference getPropertyContainer_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.damos.dconfig.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.Property#isPropagate <em>Propagate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagate</em>'.
	 * @see org.eclipse.damos.dconfig.Property#isPropagate()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Propagate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.DeclaredProperty <em>Declared Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declared Property</em>'.
	 * @see org.eclipse.damos.dconfig.DeclaredProperty
	 * @generated
	 */
	EClass getDeclaredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SimpleProperty <em>Simple Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Property</em>'.
	 * @see org.eclipse.damos.dconfig.SimpleProperty
	 * @generated
	 */
	EClass getSimpleProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.SimpleProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.damos.dconfig.SimpleProperty#getValue()
	 * @see #getSimpleProperty()
	 * @generated
	 */
	EReference getSimpleProperty_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.SimpleProperty#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipse.damos.dconfig.SimpleProperty#getDeclaration()
	 * @see #getSimpleProperty()
	 * @generated
	 */
	EReference getSimpleProperty_Declaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.PropertyDeclaration <em>Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Declaration</em>'.
	 * @see org.eclipse.damos.dconfig.PropertyDeclaration
	 * @generated
	 */
	EClass getPropertyDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.PropertyDeclarationContainer <em>Property Declaration Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Declaration Container</em>'.
	 * @see org.eclipse.damos.dconfig.PropertyDeclarationContainer
	 * @generated
	 */
	EClass getPropertyDeclarationContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.PropertyDeclarationContainer#getPropertyDeclarations <em>Property Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Declarations</em>'.
	 * @see org.eclipse.damos.dconfig.PropertyDeclarationContainer#getPropertyDeclarations()
	 * @see #getPropertyDeclarationContainer()
	 * @generated
	 */
	EReference getPropertyDeclarationContainer_PropertyDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ComponentPath <em>Component Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Path</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentPath
	 * @generated
	 */
	EClass getComponentPath();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.ComponentPath#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>References</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentPath#getReferences()
	 * @see #getComponentPath()
	 * @generated
	 */
	EReference getComponentPath_References();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ComponentReference <em>Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Reference</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentReference
	 * @generated
	 */
	EClass getComponentReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.ComponentReference#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentReference#getComponent()
	 * @see #getComponentReference()
	 * @generated
	 */
	EReference getComponentReference_Component();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see org.eclipse.damos.dconfig.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.Binding#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.damos.dconfig.Binding#getTarget()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.Binding#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.damos.dconfig.Binding#getSource()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Source();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.Binding#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.damos.dconfig.Binding#getBody()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.BindingResourceReference <em>Binding Resource Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Resource Reference</em>'.
	 * @see org.eclipse.damos.dconfig.BindingResourceReference
	 * @generated
	 */
	EClass getBindingResourceReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.BindingResourceReference#getResourceDeclaration <em>Resource Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Declaration</em>'.
	 * @see org.eclipse.damos.dconfig.BindingResourceReference#getResourceDeclaration()
	 * @see #getBindingResourceReference()
	 * @generated
	 */
	EReference getBindingResourceReference_ResourceDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.BindingResourceReference#getSubscript <em>Subscript</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subscript</em>'.
	 * @see org.eclipse.damos.dconfig.BindingResourceReference#getSubscript()
	 * @see #getBindingResourceReference()
	 * @generated
	 */
	EReference getBindingResourceReference_Subscript();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.BindingResourceSubscript <em>Binding Resource Subscript</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Resource Subscript</em>'.
	 * @see org.eclipse.damos.dconfig.BindingResourceSubscript
	 * @generated
	 */
	EClass getBindingResourceSubscript();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.BindingResourceSubscript#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.damos.dconfig.BindingResourceSubscript#getIndex()
	 * @see #getBindingResourceSubscript()
	 * @generated
	 */
	EAttribute getBindingResourceSubscript_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.BindingBody <em>Binding Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding Body</em>'.
	 * @see org.eclipse.damos.dconfig.BindingBody
	 * @generated
	 */
	EClass getBindingBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.damos.dconfig.BindingBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.damos.dconfig.BindingBody#getOwner()
	 * @see #getBindingBody()
	 * @generated
	 */
	EReference getBindingBody_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SimplePropertyDeclaration <em>Simple Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Property Declaration</em>'.
	 * @see org.eclipse.damos.dconfig.SimplePropertyDeclaration
	 * @generated
	 */
	EClass getSimplePropertyDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.SimplePropertyDeclaration#getTypeSpecifier <em>Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Specifier</em>'.
	 * @see org.eclipse.damos.dconfig.SimplePropertyDeclaration#getTypeSpecifier()
	 * @see #getSimplePropertyDeclaration()
	 * @generated
	 */
	EReference getSimplePropertyDeclaration_TypeSpecifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.SimplePropertyDeclaration#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipse.damos.dconfig.SimplePropertyDeclaration#getDefaultValue()
	 * @see #getSimplePropertyDeclaration()
	 * @generated
	 */
	EReference getSimplePropertyDeclaration_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SelectionProperty <em>Selection Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionProperty
	 * @generated
	 */
	EClass getSelectionProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.SelectionProperty#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionProperty#getDeclaration()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EReference getSelectionProperty_Declaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.SelectionProperty#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionProperty#getIndex()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EAttribute getSelectionProperty_Index();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.SelectionProperty#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selection</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionProperty#getSelection()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EReference getSelectionProperty_Selection();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.SelectionProperty#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionProperty#getBody()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EReference getSelectionProperty_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SelectionPropertyBody <em>Selection Property Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property Body</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyBody
	 * @generated
	 */
	EClass getSelectionPropertyBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.damos.dconfig.SelectionPropertyBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyBody#getOwner()
	 * @see #getSelectionPropertyBody()
	 * @generated
	 */
	EReference getSelectionPropertyBody_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.SelectionPropertyBody#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bindings</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyBody#getBindings()
	 * @see #getSelectionPropertyBody()
	 * @generated
	 */
	EReference getSelectionPropertyBody_Bindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SelectionPropertyDeclaration <em>Selection Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property Declaration</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyDeclaration
	 * @generated
	 */
	EClass getSelectionPropertyDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.SelectionPropertyDeclaration#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyDeclaration#getCount()
	 * @see #getSelectionPropertyDeclaration()
	 * @generated
	 */
	EAttribute getSelectionPropertyDeclaration_Count();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SelectionPropertyOption <em>Selection Property Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property Option</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyOption
	 * @generated
	 */
	EClass getSelectionPropertyOption();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.SelectionPropertyOption#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyOption#getTarget()
	 * @see #getSelectionPropertyOption()
	 * @generated
	 */
	EReference getSelectionPropertyOption_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.SelectionPropertyOption#getResourceDeclarations <em>Resource Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Declarations</em>'.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyOption#getResourceDeclarations()
	 * @see #getSelectionPropertyOption()
	 * @generated
	 */
	EReference getSelectionPropertyOption_ResourceDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ResourceDeclaration <em>Resource Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Declaration</em>'.
	 * @see org.eclipse.damos.dconfig.ResourceDeclaration
	 * @generated
	 */
	EClass getResourceDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.ResourceDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.damos.dconfig.ResourceDeclaration#getName()
	 * @see #getResourceDeclaration()
	 * @generated
	 */
	EAttribute getResourceDeclaration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.ResourceDeclaration#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.damos.dconfig.ResourceDeclaration#getCount()
	 * @see #getResourceDeclaration()
	 * @generated
	 */
	EAttribute getResourceDeclaration_Count();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ComputationProperty <em>Computation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Property</em>'.
	 * @see org.eclipse.damos.dconfig.ComputationProperty
	 * @generated
	 */
	EClass getComputationProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.ComputationProperty#getComputationModel <em>Computation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Computation Model</em>'.
	 * @see org.eclipse.damos.dconfig.ComputationProperty#getComputationModel()
	 * @see #getComputationProperty()
	 * @generated
	 */
	EReference getComputationProperty_ComputationModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SystemConfiguration <em>System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.SystemConfiguration
	 * @generated
	 */
	EClass getSystemConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.SystemConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.damos.dconfig.SystemConfiguration#getBody()
	 * @see #getSystemConfiguration()
	 * @generated
	 */
	EReference getSystemConfiguration_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SystemConfigurationBody <em>System Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Configuration Body</em>'.
	 * @see org.eclipse.damos.dconfig.SystemConfigurationBody
	 * @generated
	 */
	EClass getSystemConfigurationBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.damos.dconfig.SystemConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.damos.dconfig.SystemConfigurationBody#getOwner()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.SystemConfigurationBody#getComponentConfigurations <em>Component Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Configurations</em>'.
	 * @see org.eclipse.damos.dconfig.SystemConfigurationBody#getComponentConfigurations()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_ComponentConfigurations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.SystemConfigurationBody#getFragmentConfigurations <em>Fragment Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragment Configurations</em>'.
	 * @see org.eclipse.damos.dconfig.SystemConfigurationBody#getFragmentConfigurations()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_FragmentConfigurations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.damos.dconfig.SystemConfigurationBody#getSubsystemConfigurations <em>Subsystem Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subsystem Configurations</em>'.
	 * @see org.eclipse.damos.dconfig.SystemConfigurationBody#getSubsystemConfigurations()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_SubsystemConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.RootSystemConfiguration <em>Root System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root System Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.RootSystemConfiguration
	 * @generated
	 */
	EClass getRootSystemConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.RootSystemConfiguration#getContextFragment <em>Context Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Fragment</em>'.
	 * @see org.eclipse.damos.dconfig.RootSystemConfiguration#getContextFragment()
	 * @see #getRootSystemConfiguration()
	 * @generated
	 */
	EReference getRootSystemConfiguration_ContextFragment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.SubsystemConfiguration <em>Subsystem Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.SubsystemConfiguration
	 * @generated
	 */
	EClass getSubsystemConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.SubsystemConfiguration#getSubsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subsystem</em>'.
	 * @see org.eclipse.damos.dconfig.SubsystemConfiguration#getSubsystem()
	 * @see #getSubsystemConfiguration()
	 * @generated
	 */
	EReference getSubsystemConfiguration_Subsystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.SubsystemConfiguration#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.damos.dconfig.SubsystemConfiguration#getParent()
	 * @see #getSubsystemConfiguration()
	 * @generated
	 */
	EReference getSubsystemConfiguration_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.FragmentConfiguration <em>Fragment Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.FragmentConfiguration
	 * @generated
	 */
	EClass getFragmentConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.FragmentConfiguration#getStartFragment <em>Start Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Fragment</em>'.
	 * @see org.eclipse.damos.dconfig.FragmentConfiguration#getStartFragment()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EReference getFragmentConfiguration_StartFragment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.FragmentConfiguration#getEndFragment <em>End Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Fragment</em>'.
	 * @see org.eclipse.damos.dconfig.FragmentConfiguration#getEndFragment()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EReference getFragmentConfiguration_EndFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.damos.dconfig.FragmentConfiguration#isRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see org.eclipse.damos.dconfig.FragmentConfiguration#isRange()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EAttribute getFragmentConfiguration_Range();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.FragmentConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.damos.dconfig.FragmentConfiguration#getBody()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EReference getFragmentConfiguration_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.FragmentConfigurationBody <em>Fragment Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Configuration Body</em>'.
	 * @see org.eclipse.damos.dconfig.FragmentConfigurationBody
	 * @generated
	 */
	EClass getFragmentConfigurationBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.damos.dconfig.FragmentConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.damos.dconfig.FragmentConfigurationBody#getOwner()
	 * @see #getFragmentConfigurationBody()
	 * @generated
	 */
	EReference getFragmentConfigurationBody_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ComponentConfiguration <em>Component Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Configuration</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentConfiguration
	 * @generated
	 */
	EClass getComponentConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.damos.dconfig.ComponentConfiguration#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentConfiguration#getComponent()
	 * @see #getComponentConfiguration()
	 * @generated
	 */
	EReference getComponentConfiguration_Component();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.damos.dconfig.ComponentConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentConfiguration#getBody()
	 * @see #getComponentConfiguration()
	 * @generated
	 */
	EReference getComponentConfiguration_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.damos.dconfig.ComponentConfigurationBody <em>Component Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Configuration Body</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentConfigurationBody
	 * @generated
	 */
	EClass getComponentConfigurationBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.damos.dconfig.ComponentConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.damos.dconfig.ComponentConfigurationBody#getOwner()
	 * @see #getComponentConfigurationBody()
	 * @generated
	 */
	EReference getComponentConfigurationBody_Owner();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.damos.dconfig.util.PropertyPath <em>Property Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Property Path</em>'.
	 * @see org.eclipse.damos.dconfig.util.PropertyPath
	 * @model instanceClass="org.eclipse.damos.dconfig.util.PropertyPath"
	 * @generated
	 */
	EDataType getPropertyPath();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.damos.dml.util.SystemPath <em>System Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>System Path</em>'.
	 * @see org.eclipse.damos.dml.util.SystemPath
	 * @model instanceClass="org.eclipse.damos.dml.util.SystemPath"
	 * @generated
	 */
	EDataType getSystemPath();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.damos.common.util.NumberedList <em>Numbered List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Numbered List</em>'.
	 * @see org.eclipse.damos.common.util.NumberedList
	 * @model instanceClass="org.eclipse.damos.common.util.NumberedList" typeParameters="V"
	 * @generated
	 */
	EDataType getNumberedList();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DconfigFactory getDconfigFactory();

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
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ConfigurationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__PACKAGE_NAME = eINSTANCE.getConfiguration_PackageName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__NAME = eINSTANCE.getConfiguration_Name();

		/**
		 * The meta object literal for the '<em><b>Base Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__BASE_CONFIGURATION = eINSTANCE.getConfiguration_BaseConfiguration();

		/**
		 * The meta object literal for the '<em><b>Import Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__IMPORT_DECLARATIONS = eINSTANCE.getConfiguration_ImportDeclarations();

		/**
		 * The meta object literal for the '<em><b>Root System Configuration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__ROOT_SYSTEM_CONFIGURATION = eINSTANCE.getConfiguration_RootSystemConfiguration();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ConfigurationDefinitionImpl <em>Configuration Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ConfigurationDefinitionImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getConfigurationDefinition()
		 * @generated
		 */
		EClass CONFIGURATION_DEFINITION = eINSTANCE.getConfigurationDefinition();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_DEFINITION__PACKAGE_NAME = eINSTANCE.getConfigurationDefinition_PackageName();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_DEFINITION__MEMBERS = eINSTANCE.getConfigurationDefinition_Members();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ConfigurationDefinitionMemberImpl <em>Configuration Definition Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ConfigurationDefinitionMemberImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getConfigurationDefinitionMember()
		 * @generated
		 */
		EClass CONFIGURATION_DEFINITION_MEMBER = eINSTANCE.getConfigurationDefinitionMember();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_DEFINITION_MEMBER__OWNER = eINSTANCE.getConfigurationDefinitionMember_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_DEFINITION_MEMBER__NAME = eINSTANCE.getConfigurationDefinitionMember_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION_DEFINITION_MEMBER__QUALIFIED_NAME = eINSTANCE.getConfigurationDefinitionMember_QualifiedName();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.PropertyContainerImpl <em>Property Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.PropertyContainerImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyContainer()
		 * @generated
		 */
		EClass PROPERTY_CONTAINER = eINSTANCE.getPropertyContainer();

		/**
		 * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CONTAINER__PROPERTIES = eINSTANCE.getPropertyContainer_Properties();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.PropertyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Propagate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__PROPAGATE = eINSTANCE.getProperty_Propagate();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.DeclaredPropertyImpl <em>Declared Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.DeclaredPropertyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getDeclaredProperty()
		 * @generated
		 */
		EClass DECLARED_PROPERTY = eINSTANCE.getDeclaredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SimplePropertyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSimpleProperty()
		 * @generated
		 */
		EClass SIMPLE_PROPERTY = eINSTANCE.getSimpleProperty();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PROPERTY__VALUE = eINSTANCE.getSimpleProperty_Value();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PROPERTY__DECLARATION = eINSTANCE.getSimpleProperty_Declaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.PropertyDeclarationImpl <em>Property Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.PropertyDeclarationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclaration()
		 * @generated
		 */
		EClass PROPERTY_DECLARATION = eINSTANCE.getPropertyDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.PropertyDeclarationContainerImpl <em>Property Declaration Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.PropertyDeclarationContainerImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclarationContainer()
		 * @generated
		 */
		EClass PROPERTY_DECLARATION_CONTAINER = eINSTANCE.getPropertyDeclarationContainer();

		/**
		 * The meta object literal for the '<em><b>Property Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DECLARATION_CONTAINER__PROPERTY_DECLARATIONS = eINSTANCE.getPropertyDeclarationContainer_PropertyDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ComponentPathImpl <em>Component Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ComponentPathImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentPath()
		 * @generated
		 */
		EClass COMPONENT_PATH = eINSTANCE.getComponentPath();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_PATH__REFERENCES = eINSTANCE.getComponentPath_References();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ComponentReferenceImpl <em>Component Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ComponentReferenceImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentReference()
		 * @generated
		 */
		EClass COMPONENT_REFERENCE = eINSTANCE.getComponentReference();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_REFERENCE__COMPONENT = eINSTANCE.getComponentReference_Component();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.BindingImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__TARGET = eINSTANCE.getBinding_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__SOURCE = eINSTANCE.getBinding_Source();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__BODY = eINSTANCE.getBinding_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.BindingResourceReferenceImpl <em>Binding Resource Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.BindingResourceReferenceImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBindingResourceReference()
		 * @generated
		 */
		EClass BINDING_RESOURCE_REFERENCE = eINSTANCE.getBindingResourceReference();

		/**
		 * The meta object literal for the '<em><b>Resource Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_RESOURCE_REFERENCE__RESOURCE_DECLARATION = eINSTANCE.getBindingResourceReference_ResourceDeclaration();

		/**
		 * The meta object literal for the '<em><b>Subscript</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_RESOURCE_REFERENCE__SUBSCRIPT = eINSTANCE.getBindingResourceReference_Subscript();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.BindingResourceSubscriptImpl <em>Binding Resource Subscript</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.BindingResourceSubscriptImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBindingResourceSubscript()
		 * @generated
		 */
		EClass BINDING_RESOURCE_SUBSCRIPT = eINSTANCE.getBindingResourceSubscript();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINDING_RESOURCE_SUBSCRIPT__INDEX = eINSTANCE.getBindingResourceSubscript_Index();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.BindingBodyImpl <em>Binding Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.BindingBodyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getBindingBody()
		 * @generated
		 */
		EClass BINDING_BODY = eINSTANCE.getBindingBody();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING_BODY__OWNER = eINSTANCE.getBindingBody_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SimplePropertyDeclarationImpl <em>Simple Property Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SimplePropertyDeclarationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSimplePropertyDeclaration()
		 * @generated
		 */
		EClass SIMPLE_PROPERTY_DECLARATION = eINSTANCE.getSimplePropertyDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type Specifier</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PROPERTY_DECLARATION__TYPE_SPECIFIER = eINSTANCE.getSimplePropertyDeclaration_TypeSpecifier();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PROPERTY_DECLARATION__DEFAULT_VALUE = eINSTANCE.getSimplePropertyDeclaration_DefaultValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyImpl <em>Selection Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionProperty()
		 * @generated
		 */
		EClass SELECTION_PROPERTY = eINSTANCE.getSelectionProperty();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY__DECLARATION = eINSTANCE.getSelectionProperty_Declaration();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION_PROPERTY__INDEX = eINSTANCE.getSelectionProperty_Index();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY__SELECTION = eINSTANCE.getSelectionProperty_Selection();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY__BODY = eINSTANCE.getSelectionProperty_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyBodyImpl <em>Selection Property Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyBodyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyBody()
		 * @generated
		 */
		EClass SELECTION_PROPERTY_BODY = eINSTANCE.getSelectionPropertyBody();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY_BODY__OWNER = eINSTANCE.getSelectionPropertyBody_Owner();

		/**
		 * The meta object literal for the '<em><b>Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY_BODY__BINDINGS = eINSTANCE.getSelectionPropertyBody_Bindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyDeclarationImpl <em>Selection Property Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyDeclarationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyDeclaration()
		 * @generated
		 */
		EClass SELECTION_PROPERTY_DECLARATION = eINSTANCE.getSelectionPropertyDeclaration();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION_PROPERTY_DECLARATION__COUNT = eINSTANCE.getSelectionPropertyDeclaration_Count();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl <em>Selection Property Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SelectionPropertyOptionImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyOption()
		 * @generated
		 */
		EClass SELECTION_PROPERTY_OPTION = eINSTANCE.getSelectionPropertyOption();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY_OPTION__TARGET = eINSTANCE.getSelectionPropertyOption_Target();

		/**
		 * The meta object literal for the '<em><b>Resource Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS = eINSTANCE.getSelectionPropertyOption_ResourceDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ResourceDeclarationImpl <em>Resource Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ResourceDeclarationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getResourceDeclaration()
		 * @generated
		 */
		EClass RESOURCE_DECLARATION = eINSTANCE.getResourceDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_DECLARATION__NAME = eINSTANCE.getResourceDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_DECLARATION__COUNT = eINSTANCE.getResourceDeclaration_Count();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ComputationPropertyImpl <em>Computation Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ComputationPropertyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComputationProperty()
		 * @generated
		 */
		EClass COMPUTATION_PROPERTY = eINSTANCE.getComputationProperty();

		/**
		 * The meta object literal for the '<em><b>Computation Model</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_PROPERTY__COMPUTATION_MODEL = eINSTANCE.getComputationProperty_ComputationModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SystemConfigurationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSystemConfiguration()
		 * @generated
		 */
		EClass SYSTEM_CONFIGURATION = eINSTANCE.getSystemConfiguration();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION__BODY = eINSTANCE.getSystemConfiguration_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SystemConfigurationBodyImpl <em>System Configuration Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SystemConfigurationBodyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSystemConfigurationBody()
		 * @generated
		 */
		EClass SYSTEM_CONFIGURATION_BODY = eINSTANCE.getSystemConfigurationBody();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION_BODY__OWNER = eINSTANCE.getSystemConfigurationBody_Owner();

		/**
		 * The meta object literal for the '<em><b>Component Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS = eINSTANCE.getSystemConfigurationBody_ComponentConfigurations();

		/**
		 * The meta object literal for the '<em><b>Fragment Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS = eINSTANCE.getSystemConfigurationBody_FragmentConfigurations();

		/**
		 * The meta object literal for the '<em><b>Subsystem Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS = eINSTANCE.getSystemConfigurationBody_SubsystemConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.RootSystemConfigurationImpl <em>Root System Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.RootSystemConfigurationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getRootSystemConfiguration()
		 * @generated
		 */
		EClass ROOT_SYSTEM_CONFIGURATION = eINSTANCE.getRootSystemConfiguration();

		/**
		 * The meta object literal for the '<em><b>Context Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_SYSTEM_CONFIGURATION__CONTEXT_FRAGMENT = eINSTANCE.getRootSystemConfiguration_ContextFragment();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.SubsystemConfigurationImpl <em>Subsystem Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.SubsystemConfigurationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSubsystemConfiguration()
		 * @generated
		 */
		EClass SUBSYSTEM_CONFIGURATION = eINSTANCE.getSubsystemConfiguration();

		/**
		 * The meta object literal for the '<em><b>Subsystem</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_CONFIGURATION__SUBSYSTEM = eINSTANCE.getSubsystemConfiguration_Subsystem();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SUBSYSTEM_CONFIGURATION__PARENT = eINSTANCE.getSubsystemConfiguration_Parent();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.FragmentConfigurationImpl <em>Fragment Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.FragmentConfigurationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfiguration()
		 * @generated
		 */
		EClass FRAGMENT_CONFIGURATION = eINSTANCE.getFragmentConfiguration();

		/**
		 * The meta object literal for the '<em><b>Start Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_CONFIGURATION__START_FRAGMENT = eINSTANCE.getFragmentConfiguration_StartFragment();

		/**
		 * The meta object literal for the '<em><b>End Fragment</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_CONFIGURATION__END_FRAGMENT = eINSTANCE.getFragmentConfiguration_EndFragment();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FRAGMENT_CONFIGURATION__RANGE = eINSTANCE.getFragmentConfiguration_Range();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_CONFIGURATION__BODY = eINSTANCE.getFragmentConfiguration_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.FragmentConfigurationBodyImpl <em>Fragment Configuration Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.FragmentConfigurationBodyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfigurationBody()
		 * @generated
		 */
		EClass FRAGMENT_CONFIGURATION_BODY = eINSTANCE.getFragmentConfigurationBody();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FRAGMENT_CONFIGURATION_BODY__OWNER = eINSTANCE.getFragmentConfigurationBody_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ComponentConfigurationImpl <em>Component Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ComponentConfigurationImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentConfiguration()
		 * @generated
		 */
		EClass COMPONENT_CONFIGURATION = eINSTANCE.getComponentConfiguration();

		/**
		 * The meta object literal for the '<em><b>Component</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_CONFIGURATION__COMPONENT = eINSTANCE.getComponentConfiguration_Component();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_CONFIGURATION__BODY = eINSTANCE.getComponentConfiguration_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.damos.dconfig.impl.ComponentConfigurationBodyImpl <em>Component Configuration Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.impl.ComponentConfigurationBodyImpl
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getComponentConfigurationBody()
		 * @generated
		 */
		EClass COMPONENT_CONFIGURATION_BODY = eINSTANCE.getComponentConfigurationBody();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT_CONFIGURATION_BODY__OWNER = eINSTANCE.getComponentConfigurationBody_Owner();

		/**
		 * The meta object literal for the '<em>Property Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dconfig.util.PropertyPath
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getPropertyPath()
		 * @generated
		 */
		EDataType PROPERTY_PATH = eINSTANCE.getPropertyPath();

		/**
		 * The meta object literal for the '<em>System Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.dml.util.SystemPath
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getSystemPath()
		 * @generated
		 */
		EDataType SYSTEM_PATH = eINSTANCE.getSystemPath();

		/**
		 * The meta object literal for the '<em>Numbered List</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.damos.common.util.NumberedList
		 * @see org.eclipse.damos.dconfig.impl.DconfigPackageImpl#getNumberedList()
		 * @generated
		 */
		EDataType NUMBERED_LIST = eINSTANCE.getNumberedList();

	}

} //DconfigPackage
