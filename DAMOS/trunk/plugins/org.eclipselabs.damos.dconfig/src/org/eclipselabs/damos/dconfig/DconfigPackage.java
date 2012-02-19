/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

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
 * @see org.eclipselabs.damos.dconfig.DconfigFactory
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
	String eNS_URI = "http://www.eclipselabs.org/damos/2011/Dconfig";

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
	DconfigPackage eINSTANCE = org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.ConfigurationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyContainerImpl <em>Property Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.PropertyContainerImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyContainer()
	 * @generated
	 */
	int PROPERTY_CONTAINER = 1;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.PropertyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.DeclaredPropertyImpl <em>Declared Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.DeclaredPropertyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getDeclaredProperty()
	 * @generated
	 */
	int DECLARED_PROPERTY = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SimplePropertyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSimpleProperty()
	 * @generated
	 */
	int SIMPLE_PROPERTY = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyDeclarationImpl <em>Property Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.PropertyDeclarationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclaration()
	 * @generated
	 */
	int PROPERTY_DECLARATION = 10;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SimplePropertyDeclarationImpl <em>Simple Property Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SimplePropertyDeclarationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSimplePropertyDeclaration()
	 * @generated
	 */
	int SIMPLE_PROPERTY_DECLARATION = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyImpl <em>Selection Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionProperty()
	 * @generated
	 */
	int SELECTION_PROPERTY = 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyBodyImpl <em>Selection Property Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyBodyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyBody()
	 * @generated
	 */
	int SELECTION_PROPERTY_BODY = 7;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyDeclarationImpl <em>Selection Property Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyDeclarationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyDeclaration()
	 * @generated
	 */
	int SELECTION_PROPERTY_DECLARATION = 8;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyDeclarationContainerImpl <em>Property Declaration Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.PropertyDeclarationContainerImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclarationContainer()
	 * @generated
	 */
	int PROPERTY_DECLARATION_CONTAINER = 11;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyGroupImpl <em>Property Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.PropertyGroupImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyGroup()
	 * @generated
	 */
	int PROPERTY_GROUP = 12;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyOptionImpl <em>Selection Property Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyOptionImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyOption()
	 * @generated
	 */
	int SELECTION_PROPERTY_OPTION = 9;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION__QUALIFIED_NAME = 1;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION__GROUP = 2;

	/**
	 * The number of structural features of the '<em>Property Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DECLARATION_FEATURE_COUNT = 3;

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
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PROPERTY_DECLARATION__GROUP = PROPERTY_DECLARATION__GROUP;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY__NAME = DECLARED_PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY__DECLARATION = DECLARED_PROPERTY_FEATURE_COUNT + 1;

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
	 * The number of structural features of the '<em>Selection Property Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_DECLARATION__GROUP = PROPERTY_DECLARATION__GROUP;

	/**
	 * The number of structural features of the '<em>Selection Property Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_DECLARATION_FEATURE_COUNT = PROPERTY_DECLARATION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__QUALIFIED_NAME = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__TARGET = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Resource Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Selection Property Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELECTION_PROPERTY_OPTION_FEATURE_COUNT = PROPERTY_DECLARATION_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GROUP__QUALIFIED_NAME = 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GROUP__MEMBERS = 1;

	/**
	 * The number of structural features of the '<em>Property Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_GROUP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.MappingImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 13;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TARGET_PATH = 1;

	/**
	 * The feature id for the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SUBSCRIPT = 2;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__BODY = 3;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.MappingTargetPathImpl <em>Mapping Target Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.MappingTargetPathImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingTargetPath()
	 * @generated
	 */
	int MAPPING_TARGET_PATH = 14;

	/**
	 * The feature id for the '<em><b>Property References</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TARGET_PATH__PROPERTY_REFERENCES = 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TARGET_PATH__RESOURCE = 1;

	/**
	 * The number of structural features of the '<em>Mapping Target Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_TARGET_PATH_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.MappingPropertyReferenceImpl <em>Mapping Property Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.MappingPropertyReferenceImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingPropertyReference()
	 * @generated
	 */
	int MAPPING_PROPERTY_REFERENCE = 15;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROPERTY_REFERENCE__PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Mapping Property Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PROPERTY_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.MappingBodyImpl <em>Mapping Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.MappingBodyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingBody()
	 * @generated
	 */
	int MAPPING_BODY = 16;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__PROPERTIES = PROPERTY_CONTAINER__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY__OWNER = PROPERTY_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.MappingSubscriptImpl <em>Mapping Subscript</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.MappingSubscriptImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingSubscript()
	 * @generated
	 */
	int MAPPING_SUBSCRIPT = 17;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SUBSCRIPT__INDEX = 0;

	/**
	 * The number of structural features of the '<em>Mapping Subscript</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SUBSCRIPT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.ResourceDeclarationImpl <em>Resource Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.ResourceDeclarationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getResourceDeclaration()
	 * @generated
	 */
	int RESOURCE_DECLARATION = 18;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.ComputationPropertyImpl <em>Computation Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.ComputationPropertyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getComputationProperty()
	 * @generated
	 */
	int COMPUTATION_PROPERTY = 19;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SystemConfigurationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSystemConfiguration()
	 * @generated
	 */
	int SYSTEM_CONFIGURATION = 20;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl <em>System Configuration Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSystemConfigurationBody()
	 * @generated
	 */
	int SYSTEM_CONFIGURATION_BODY = 21;

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
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__MAPPINGS = PROPERTY_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Component Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__COMPONENT_CONFIGURATIONS = PROPERTY_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fragment Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__FRAGMENT_CONFIGURATIONS = PROPERTY_CONTAINER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Subsystem Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY__SUBSYSTEM_CONFIGURATIONS = PROPERTY_CONTAINER_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>System Configuration Body</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_BODY_FEATURE_COUNT = PROPERTY_CONTAINER_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.RootSystemConfigurationImpl <em>Root System Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.RootSystemConfigurationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getRootSystemConfiguration()
	 * @generated
	 */
	int ROOT_SYSTEM_CONFIGURATION = 22;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.SubsystemConfigurationImpl <em>Subsystem Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.SubsystemConfigurationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSubsystemConfiguration()
	 * @generated
	 */
	int SUBSYSTEM_CONFIGURATION = 23;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl <em>Fragment Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfiguration()
	 * @generated
	 */
	int FRAGMENT_CONFIGURATION = 24;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationBodyImpl <em>Fragment Configuration Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.FragmentConfigurationBodyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfigurationBody()
	 * @generated
	 */
	int FRAGMENT_CONFIGURATION_BODY = 25;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.ComponentConfigurationImpl <em>Component Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.ComponentConfigurationImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getComponentConfiguration()
	 * @generated
	 */
	int COMPONENT_CONFIGURATION = 26;

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
	 * The meta object id for the '{@link org.eclipselabs.damos.dconfig.impl.ComponentConfigurationBodyImpl <em>Component Configuration Body</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dconfig.impl.ComponentConfigurationBodyImpl
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getComponentConfigurationBody()
	 * @generated
	 */
	int COMPONENT_CONFIGURATION_BODY = 27;

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
	 * The meta object id for the '<em>System Path</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.dml.util.SystemPath
	 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSystemPath()
	 * @generated
	 */
	int SYSTEM_PATH = 28;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.Configuration#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.Configuration#getPackageName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.Configuration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.Configuration#getName()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.Configuration#getBaseConfiguration <em>Base Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.Configuration#getBaseConfiguration()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_BaseConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.Configuration#getImportDeclarations <em>Import Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Declarations</em>'.
	 * @see org.eclipselabs.damos.dconfig.Configuration#getImportDeclarations()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ImportDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.Configuration#getRootSystemConfiguration <em>Root System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root System Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.Configuration#getRootSystemConfiguration()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_RootSystemConfiguration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.PropertyContainer <em>Property Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Container</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyContainer
	 * @generated
	 */
	EClass getPropertyContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.PropertyContainer#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Properties</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyContainer#getProperties()
	 * @see #getPropertyContainer()
	 * @generated
	 */
	EReference getPropertyContainer_Properties();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipselabs.damos.dconfig.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.Property#isPropagate <em>Propagate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Propagate</em>'.
	 * @see org.eclipselabs.damos.dconfig.Property#isPropagate()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Propagate();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.DeclaredProperty <em>Declared Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declared Property</em>'.
	 * @see org.eclipselabs.damos.dconfig.DeclaredProperty
	 * @generated
	 */
	EClass getDeclaredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SimpleProperty <em>Simple Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Property</em>'.
	 * @see org.eclipselabs.damos.dconfig.SimpleProperty
	 * @generated
	 */
	EClass getSimpleProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.SimpleProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipselabs.damos.dconfig.SimpleProperty#getValue()
	 * @see #getSimpleProperty()
	 * @generated
	 */
	EReference getSimpleProperty_Value();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.SimpleProperty#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipselabs.damos.dconfig.SimpleProperty#getDeclaration()
	 * @see #getSimpleProperty()
	 * @generated
	 */
	EReference getSimpleProperty_Declaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.PropertyDeclaration <em>Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Declaration</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyDeclaration
	 * @generated
	 */
	EClass getPropertyDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.PropertyDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyDeclaration#getName()
	 * @see #getPropertyDeclaration()
	 * @generated
	 */
	EAttribute getPropertyDeclaration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.PropertyDeclaration#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyDeclaration#getQualifiedName()
	 * @see #getPropertyDeclaration()
	 * @generated
	 */
	EAttribute getPropertyDeclaration_QualifiedName();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dconfig.PropertyDeclaration#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Group</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyDeclaration#getGroup()
	 * @see #getPropertyDeclaration()
	 * @generated
	 */
	EReference getPropertyDeclaration_Group();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.PropertyDeclarationContainer <em>Property Declaration Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Declaration Container</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyDeclarationContainer
	 * @generated
	 */
	EClass getPropertyDeclarationContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.PropertyDeclarationContainer#getPropertyDeclarations <em>Property Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Declarations</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyDeclarationContainer#getPropertyDeclarations()
	 * @see #getPropertyDeclarationContainer()
	 * @generated
	 */
	EReference getPropertyDeclarationContainer_PropertyDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.PropertyGroup <em>Property Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Group</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyGroup
	 * @generated
	 */
	EClass getPropertyGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.PropertyGroup#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyGroup#getQualifiedName()
	 * @see #getPropertyGroup()
	 * @generated
	 */
	EAttribute getPropertyGroup_QualifiedName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.PropertyGroup#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see org.eclipselabs.damos.dconfig.PropertyGroup#getMembers()
	 * @see #getPropertyGroup()
	 * @generated
	 */
	EReference getPropertyGroup_Members();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SimplePropertyDeclaration <em>Simple Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Property Declaration</em>'.
	 * @see org.eclipselabs.damos.dconfig.SimplePropertyDeclaration
	 * @generated
	 */
	EClass getSimplePropertyDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.SimplePropertyDeclaration#getTypeSpecifier <em>Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Specifier</em>'.
	 * @see org.eclipselabs.damos.dconfig.SimplePropertyDeclaration#getTypeSpecifier()
	 * @see #getSimplePropertyDeclaration()
	 * @generated
	 */
	EReference getSimplePropertyDeclaration_TypeSpecifier();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.SimplePropertyDeclaration#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Value</em>'.
	 * @see org.eclipselabs.damos.dconfig.SimplePropertyDeclaration#getDefaultValue()
	 * @see #getSimplePropertyDeclaration()
	 * @generated
	 */
	EReference getSimplePropertyDeclaration_DefaultValue();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SelectionProperty <em>Selection Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionProperty
	 * @generated
	 */
	EClass getSelectionProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.SelectionProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionProperty#getName()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EAttribute getSelectionProperty_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.SelectionProperty#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionProperty#getDeclaration()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EReference getSelectionProperty_Declaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.SelectionProperty#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selection</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionProperty#getSelection()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EReference getSelectionProperty_Selection();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.SelectionProperty#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionProperty#getBody()
	 * @see #getSelectionProperty()
	 * @generated
	 */
	EReference getSelectionProperty_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SelectionPropertyBody <em>Selection Property Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionPropertyBody
	 * @generated
	 */
	EClass getSelectionPropertyBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dconfig.SelectionPropertyBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionPropertyBody#getOwner()
	 * @see #getSelectionPropertyBody()
	 * @generated
	 */
	EReference getSelectionPropertyBody_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration <em>Selection Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property Declaration</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration
	 * @generated
	 */
	EClass getSelectionPropertyDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption <em>Selection Property Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Selection Property Option</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionPropertyOption
	 * @generated
	 */
	EClass getSelectionPropertyOption();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getQualifiedName <em>Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionPropertyOption#getQualifiedName()
	 * @see #getSelectionPropertyOption()
	 * @generated
	 */
	EAttribute getSelectionPropertyOption_QualifiedName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionPropertyOption#getTarget()
	 * @see #getSelectionPropertyOption()
	 * @generated
	 */
	EReference getSelectionPropertyOption_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.SelectionPropertyOption#getResourceDeclarations <em>Resource Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Declarations</em>'.
	 * @see org.eclipselabs.damos.dconfig.SelectionPropertyOption#getResourceDeclarations()
	 * @see #getSelectionPropertyOption()
	 * @generated
	 */
	EReference getSelectionPropertyOption_ResourceDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipselabs.damos.dconfig.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.Mapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipselabs.damos.dconfig.Mapping#getSource()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Source();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.Mapping#getTargetPath <em>Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Path</em>'.
	 * @see org.eclipselabs.damos.dconfig.Mapping#getTargetPath()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_TargetPath();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.Mapping#getSubscript <em>Subscript</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Subscript</em>'.
	 * @see org.eclipselabs.damos.dconfig.Mapping#getSubscript()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Subscript();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.Mapping#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.Mapping#getBody()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.MappingTargetPath <em>Mapping Target Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Target Path</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingTargetPath
	 * @generated
	 */
	EClass getMappingTargetPath();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.MappingTargetPath#getPropertyReferences <em>Property References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property References</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingTargetPath#getPropertyReferences()
	 * @see #getMappingTargetPath()
	 * @generated
	 */
	EReference getMappingTargetPath_PropertyReferences();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.MappingTargetPath#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingTargetPath#getResource()
	 * @see #getMappingTargetPath()
	 * @generated
	 */
	EReference getMappingTargetPath_Resource();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.MappingPropertyReference <em>Mapping Property Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Property Reference</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingPropertyReference
	 * @generated
	 */
	EClass getMappingPropertyReference();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.MappingPropertyReference#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingPropertyReference#getProperty()
	 * @see #getMappingPropertyReference()
	 * @generated
	 */
	EReference getMappingPropertyReference_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.MappingBody <em>Mapping Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingBody
	 * @generated
	 */
	EClass getMappingBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dconfig.MappingBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingBody#getOwner()
	 * @see #getMappingBody()
	 * @generated
	 */
	EReference getMappingBody_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.MappingSubscript <em>Mapping Subscript</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Subscript</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingSubscript
	 * @generated
	 */
	EClass getMappingSubscript();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.MappingSubscript#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see org.eclipselabs.damos.dconfig.MappingSubscript#getIndex()
	 * @see #getMappingSubscript()
	 * @generated
	 */
	EAttribute getMappingSubscript_Index();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.ResourceDeclaration <em>Resource Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Declaration</em>'.
	 * @see org.eclipselabs.damos.dconfig.ResourceDeclaration
	 * @generated
	 */
	EClass getResourceDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.ResourceDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.dconfig.ResourceDeclaration#getName()
	 * @see #getResourceDeclaration()
	 * @generated
	 */
	EAttribute getResourceDeclaration_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.ResourceDeclaration#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipselabs.damos.dconfig.ResourceDeclaration#getCount()
	 * @see #getResourceDeclaration()
	 * @generated
	 */
	EAttribute getResourceDeclaration_Count();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.ComputationProperty <em>Computation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Property</em>'.
	 * @see org.eclipselabs.damos.dconfig.ComputationProperty
	 * @generated
	 */
	EClass getComputationProperty();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.ComputationProperty#getComputationModel <em>Computation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Computation Model</em>'.
	 * @see org.eclipselabs.damos.dconfig.ComputationProperty#getComputationModel()
	 * @see #getComputationProperty()
	 * @generated
	 */
	EReference getComputationProperty_ComputationModel();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SystemConfiguration <em>System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfiguration
	 * @generated
	 */
	EClass getSystemConfiguration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.SystemConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfiguration#getBody()
	 * @see #getSystemConfiguration()
	 * @generated
	 */
	EReference getSystemConfiguration_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody <em>System Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Configuration Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfigurationBody
	 * @generated
	 */
	EClass getSystemConfigurationBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfigurationBody#getOwner()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_Owner();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfigurationBody#getMappings()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_Mappings();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getComponentConfigurations <em>Component Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Component Configurations</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfigurationBody#getComponentConfigurations()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_ComponentConfigurations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getFragmentConfigurations <em>Fragment Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fragment Configurations</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfigurationBody#getFragmentConfigurations()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_FragmentConfigurations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getSubsystemConfigurations <em>Subsystem Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subsystem Configurations</em>'.
	 * @see org.eclipselabs.damos.dconfig.SystemConfigurationBody#getSubsystemConfigurations()
	 * @see #getSystemConfigurationBody()
	 * @generated
	 */
	EReference getSystemConfigurationBody_SubsystemConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.RootSystemConfiguration <em>Root System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root System Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.RootSystemConfiguration
	 * @generated
	 */
	EClass getRootSystemConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.RootSystemConfiguration#getContextFragment <em>Context Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Context Fragment</em>'.
	 * @see org.eclipselabs.damos.dconfig.RootSystemConfiguration#getContextFragment()
	 * @see #getRootSystemConfiguration()
	 * @generated
	 */
	EReference getRootSystemConfiguration_ContextFragment();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.SubsystemConfiguration <em>Subsystem Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Subsystem Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.SubsystemConfiguration
	 * @generated
	 */
	EClass getSubsystemConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.SubsystemConfiguration#getSubsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Subsystem</em>'.
	 * @see org.eclipselabs.damos.dconfig.SubsystemConfiguration#getSubsystem()
	 * @see #getSubsystemConfiguration()
	 * @generated
	 */
	EReference getSubsystemConfiguration_Subsystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.SubsystemConfiguration#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipselabs.damos.dconfig.SubsystemConfiguration#getParent()
	 * @see #getSubsystemConfiguration()
	 * @generated
	 */
	EReference getSubsystemConfiguration_Parent();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.FragmentConfiguration <em>Fragment Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.FragmentConfiguration
	 * @generated
	 */
	EClass getFragmentConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.FragmentConfiguration#getStartFragment <em>Start Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start Fragment</em>'.
	 * @see org.eclipselabs.damos.dconfig.FragmentConfiguration#getStartFragment()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EReference getFragmentConfiguration_StartFragment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.FragmentConfiguration#getEndFragment <em>End Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End Fragment</em>'.
	 * @see org.eclipselabs.damos.dconfig.FragmentConfiguration#getEndFragment()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EReference getFragmentConfiguration_EndFragment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.dconfig.FragmentConfiguration#isRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range</em>'.
	 * @see org.eclipselabs.damos.dconfig.FragmentConfiguration#isRange()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EAttribute getFragmentConfiguration_Range();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.FragmentConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.FragmentConfiguration#getBody()
	 * @see #getFragmentConfiguration()
	 * @generated
	 */
	EReference getFragmentConfiguration_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.FragmentConfigurationBody <em>Fragment Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fragment Configuration Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.FragmentConfigurationBody
	 * @generated
	 */
	EClass getFragmentConfigurationBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dconfig.FragmentConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipselabs.damos.dconfig.FragmentConfigurationBody#getOwner()
	 * @see #getFragmentConfigurationBody()
	 * @generated
	 */
	EReference getFragmentConfigurationBody_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.ComponentConfiguration <em>Component Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Configuration</em>'.
	 * @see org.eclipselabs.damos.dconfig.ComponentConfiguration
	 * @generated
	 */
	EClass getComponentConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.dconfig.ComponentConfiguration#getComponent <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Component</em>'.
	 * @see org.eclipselabs.damos.dconfig.ComponentConfiguration#getComponent()
	 * @see #getComponentConfiguration()
	 * @generated
	 */
	EReference getComponentConfiguration_Component();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.dconfig.ComponentConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.ComponentConfiguration#getBody()
	 * @see #getComponentConfiguration()
	 * @generated
	 */
	EReference getComponentConfiguration_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.dconfig.ComponentConfigurationBody <em>Component Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component Configuration Body</em>'.
	 * @see org.eclipselabs.damos.dconfig.ComponentConfigurationBody
	 * @generated
	 */
	EClass getComponentConfigurationBody();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.damos.dconfig.ComponentConfigurationBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipselabs.damos.dconfig.ComponentConfigurationBody#getOwner()
	 * @see #getComponentConfigurationBody()
	 * @generated
	 */
	EReference getComponentConfigurationBody_Owner();

	/**
	 * Returns the meta object for data type '{@link org.eclipselabs.damos.dml.util.SystemPath <em>System Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>System Path</em>'.
	 * @see org.eclipselabs.damos.dml.util.SystemPath
	 * @model instanceClass="org.eclipselabs.damos.dml.util.SystemPath"
	 * @generated
	 */
	EDataType getSystemPath();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.ConfigurationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getConfiguration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyContainerImpl <em>Property Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.PropertyContainerImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyContainer()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.PropertyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getProperty()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.DeclaredPropertyImpl <em>Declared Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.DeclaredPropertyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getDeclaredProperty()
		 * @generated
		 */
		EClass DECLARED_PROPERTY = eINSTANCE.getDeclaredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SimplePropertyImpl <em>Simple Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SimplePropertyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSimpleProperty()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyDeclarationImpl <em>Property Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.PropertyDeclarationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclaration()
		 * @generated
		 */
		EClass PROPERTY_DECLARATION = eINSTANCE.getPropertyDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DECLARATION__NAME = eINSTANCE.getPropertyDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DECLARATION__QUALIFIED_NAME = eINSTANCE.getPropertyDeclaration_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DECLARATION__GROUP = eINSTANCE.getPropertyDeclaration_Group();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyDeclarationContainerImpl <em>Property Declaration Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.PropertyDeclarationContainerImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyDeclarationContainer()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.PropertyGroupImpl <em>Property Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.PropertyGroupImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getPropertyGroup()
		 * @generated
		 */
		EClass PROPERTY_GROUP = eINSTANCE.getPropertyGroup();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_GROUP__QUALIFIED_NAME = eINSTANCE.getPropertyGroup_QualifiedName();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_GROUP__MEMBERS = eINSTANCE.getPropertyGroup_Members();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SimplePropertyDeclarationImpl <em>Simple Property Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SimplePropertyDeclarationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSimplePropertyDeclaration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyImpl <em>Selection Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionProperty()
		 * @generated
		 */
		EClass SELECTION_PROPERTY = eINSTANCE.getSelectionProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION_PROPERTY__NAME = eINSTANCE.getSelectionProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELECTION_PROPERTY__DECLARATION = eINSTANCE.getSelectionProperty_Declaration();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyBodyImpl <em>Selection Property Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyBodyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyBody()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyDeclarationImpl <em>Selection Property Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyDeclarationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyDeclaration()
		 * @generated
		 */
		EClass SELECTION_PROPERTY_DECLARATION = eINSTANCE.getSelectionPropertyDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyOptionImpl <em>Selection Property Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SelectionPropertyOptionImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSelectionPropertyOption()
		 * @generated
		 */
		EClass SELECTION_PROPERTY_OPTION = eINSTANCE.getSelectionPropertyOption();

		/**
		 * The meta object literal for the '<em><b>Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELECTION_PROPERTY_OPTION__QUALIFIED_NAME = eINSTANCE.getSelectionPropertyOption_QualifiedName();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.MappingImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SOURCE = eINSTANCE.getMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target Path</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__TARGET_PATH = eINSTANCE.getMapping_TargetPath();

		/**
		 * The meta object literal for the '<em><b>Subscript</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SUBSCRIPT = eINSTANCE.getMapping_Subscript();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__BODY = eINSTANCE.getMapping_Body();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.MappingTargetPathImpl <em>Mapping Target Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.MappingTargetPathImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingTargetPath()
		 * @generated
		 */
		EClass MAPPING_TARGET_PATH = eINSTANCE.getMappingTargetPath();

		/**
		 * The meta object literal for the '<em><b>Property References</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TARGET_PATH__PROPERTY_REFERENCES = eINSTANCE.getMappingTargetPath_PropertyReferences();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_TARGET_PATH__RESOURCE = eINSTANCE.getMappingTargetPath_Resource();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.MappingPropertyReferenceImpl <em>Mapping Property Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.MappingPropertyReferenceImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingPropertyReference()
		 * @generated
		 */
		EClass MAPPING_PROPERTY_REFERENCE = eINSTANCE.getMappingPropertyReference();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PROPERTY_REFERENCE__PROPERTY = eINSTANCE.getMappingPropertyReference_Property();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.MappingBodyImpl <em>Mapping Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.MappingBodyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingBody()
		 * @generated
		 */
		EClass MAPPING_BODY = eINSTANCE.getMappingBody();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_BODY__OWNER = eINSTANCE.getMappingBody_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.MappingSubscriptImpl <em>Mapping Subscript</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.MappingSubscriptImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getMappingSubscript()
		 * @generated
		 */
		EClass MAPPING_SUBSCRIPT = eINSTANCE.getMappingSubscript();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_SUBSCRIPT__INDEX = eINSTANCE.getMappingSubscript_Index();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.ResourceDeclarationImpl <em>Resource Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.ResourceDeclarationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getResourceDeclaration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.ComputationPropertyImpl <em>Computation Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.ComputationPropertyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getComputationProperty()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SystemConfigurationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSystemConfiguration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl <em>System Configuration Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SystemConfigurationBodyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSystemConfigurationBody()
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
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION_BODY__MAPPINGS = eINSTANCE.getSystemConfigurationBody_Mappings();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.RootSystemConfigurationImpl <em>Root System Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.RootSystemConfigurationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getRootSystemConfiguration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.SubsystemConfigurationImpl <em>Subsystem Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.SubsystemConfigurationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSubsystemConfiguration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl <em>Fragment Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.FragmentConfigurationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfiguration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.FragmentConfigurationBodyImpl <em>Fragment Configuration Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.FragmentConfigurationBodyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getFragmentConfigurationBody()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.ComponentConfigurationImpl <em>Component Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.ComponentConfigurationImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getComponentConfiguration()
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
		 * The meta object literal for the '{@link org.eclipselabs.damos.dconfig.impl.ComponentConfigurationBodyImpl <em>Component Configuration Body</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dconfig.impl.ComponentConfigurationBodyImpl
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getComponentConfigurationBody()
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
		 * The meta object literal for the '<em>System Path</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.dml.util.SystemPath
		 * @see org.eclipselabs.damos.dconfig.impl.DconfigPackageImpl#getSystemPath()
		 * @generated
		 */
		EDataType SYSTEM_PATH = eINSTANCE.getSystemPath();

	}

} //DconfigPackage
