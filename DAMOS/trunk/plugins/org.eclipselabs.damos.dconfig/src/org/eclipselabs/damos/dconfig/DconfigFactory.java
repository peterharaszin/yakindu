/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dconfig.DconfigPackage
 * @generated
 */
public interface DconfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DconfigFactory eINSTANCE = org.eclipselabs.damos.dconfig.impl.DconfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Simple Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Property</em>'.
	 * @generated
	 */
	SimpleProperty createSimpleProperty();

	/**
	 * Returns a new object of class '<em>Simple Property Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Property Declaration</em>'.
	 * @generated
	 */
	SimplePropertyDeclaration createSimplePropertyDeclaration();

	/**
	 * Returns a new object of class '<em>Selection Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Property</em>'.
	 * @generated
	 */
	SelectionProperty createSelectionProperty();

	/**
	 * Returns a new object of class '<em>Selection Property Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Property Body</em>'.
	 * @generated
	 */
	SelectionPropertyBody createSelectionPropertyBody();

	/**
	 * Returns a new object of class '<em>Selection Property Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Property Declaration</em>'.
	 * @generated
	 */
	SelectionPropertyDeclaration createSelectionPropertyDeclaration();

	/**
	 * Returns a new object of class '<em>Selection Property Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Selection Property Option</em>'.
	 * @generated
	 */
	SelectionPropertyOption createSelectionPropertyOption();

	/**
	 * Returns a new object of class '<em>Property Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Property Group</em>'.
	 * @generated
	 */
	PropertyGroup createPropertyGroup();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Mapping Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Body</em>'.
	 * @generated
	 */
	MappingBody createMappingBody();

	/**
	 * Returns a new object of class '<em>Mapping Subscript</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Subscript</em>'.
	 * @generated
	 */
	MappingSubscript createMappingSubscript();

	/**
	 * Returns a new object of class '<em>Resource Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Declaration</em>'.
	 * @generated
	 */
	ResourceDeclaration createResourceDeclaration();

	/**
	 * Returns a new object of class '<em>Computation Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation Property</em>'.
	 * @generated
	 */
	ComputationProperty createComputationProperty();

	/**
	 * Returns a new object of class '<em>System Configuration Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Configuration Body</em>'.
	 * @generated
	 */
	SystemConfigurationBody createSystemConfigurationBody();

	/**
	 * Returns a new object of class '<em>Root System Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root System Configuration</em>'.
	 * @generated
	 */
	RootSystemConfiguration createRootSystemConfiguration();

	/**
	 * Returns a new object of class '<em>Subsystem Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Subsystem Configuration</em>'.
	 * @generated
	 */
	SubsystemConfiguration createSubsystemConfiguration();

	/**
	 * Returns a new object of class '<em>Fragment Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Configuration</em>'.
	 * @generated
	 */
	FragmentConfiguration createFragmentConfiguration();

	/**
	 * Returns a new object of class '<em>Fragment Configuration Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fragment Configuration Body</em>'.
	 * @generated
	 */
	FragmentConfigurationBody createFragmentConfigurationBody();

	/**
	 * Returns a new object of class '<em>Component Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Configuration</em>'.
	 * @generated
	 */
	ComponentConfiguration createComponentConfiguration();

	/**
	 * Returns a new object of class '<em>Component Configuration Body</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Configuration Body</em>'.
	 * @generated
	 */
	ComponentConfigurationBody createComponentConfigurationBody();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DconfigPackage getDconfigPackage();

} //DconfigFactory
