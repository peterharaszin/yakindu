/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.damos.dconfig.*;
import org.eclipselabs.damos.dconfig.ComponentConfiguration;
import org.eclipselabs.damos.dconfig.ComponentConfigurationBody;
import org.eclipselabs.damos.dconfig.ComputationProperty;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.DeclaredProperty;
import org.eclipselabs.damos.dconfig.FragmentConfiguration;
import org.eclipselabs.damos.dconfig.FragmentConfigurationBody;
import org.eclipselabs.damos.dconfig.Mapping;
import org.eclipselabs.damos.dconfig.MappingBody;
import org.eclipselabs.damos.dconfig.MappingSubscript;
import org.eclipselabs.damos.dconfig.Property;
import org.eclipselabs.damos.dconfig.PropertyContainer;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.PropertyDeclarationContainer;
import org.eclipselabs.damos.dconfig.PropertyGroup;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dconfig.DconfigPackage
 * @generated
 */
public class DconfigSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DconfigPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DconfigSwitch() {
		if (modelPackage == null) {
			modelPackage = DconfigPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DconfigPackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = casePropertyContainer(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.PROPERTY_CONTAINER: {
				PropertyContainer propertyContainer = (PropertyContainer)theEObject;
				T result = casePropertyContainer(propertyContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.PROPERTY: {
				Property property = (Property)theEObject;
				T result = caseProperty(property);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.DECLARED_PROPERTY: {
				DeclaredProperty declaredProperty = (DeclaredProperty)theEObject;
				T result = caseDeclaredProperty(declaredProperty);
				if (result == null) result = caseProperty(declaredProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SIMPLE_PROPERTY: {
				SimpleProperty simpleProperty = (SimpleProperty)theEObject;
				T result = caseSimpleProperty(simpleProperty);
				if (result == null) result = caseDeclaredProperty(simpleProperty);
				if (result == null) result = caseProperty(simpleProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SIMPLE_PROPERTY_DECLARATION: {
				SimplePropertyDeclaration simplePropertyDeclaration = (SimplePropertyDeclaration)theEObject;
				T result = caseSimplePropertyDeclaration(simplePropertyDeclaration);
				if (result == null) result = casePropertyDeclaration(simplePropertyDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SELECTION_PROPERTY: {
				SelectionProperty selectionProperty = (SelectionProperty)theEObject;
				T result = caseSelectionProperty(selectionProperty);
				if (result == null) result = caseDeclaredProperty(selectionProperty);
				if (result == null) result = caseProperty(selectionProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SELECTION_PROPERTY_BODY: {
				SelectionPropertyBody selectionPropertyBody = (SelectionPropertyBody)theEObject;
				T result = caseSelectionPropertyBody(selectionPropertyBody);
				if (result == null) result = casePropertyContainer(selectionPropertyBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SELECTION_PROPERTY_DECLARATION: {
				SelectionPropertyDeclaration selectionPropertyDeclaration = (SelectionPropertyDeclaration)theEObject;
				T result = caseSelectionPropertyDeclaration(selectionPropertyDeclaration);
				if (result == null) result = casePropertyDeclaration(selectionPropertyDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SELECTION_PROPERTY_OPTION: {
				SelectionPropertyOption selectionPropertyOption = (SelectionPropertyOption)theEObject;
				T result = caseSelectionPropertyOption(selectionPropertyOption);
				if (result == null) result = casePropertyDeclarationContainer(selectionPropertyOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.PROPERTY_DECLARATION: {
				PropertyDeclaration propertyDeclaration = (PropertyDeclaration)theEObject;
				T result = casePropertyDeclaration(propertyDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.PROPERTY_DECLARATION_CONTAINER: {
				PropertyDeclarationContainer propertyDeclarationContainer = (PropertyDeclarationContainer)theEObject;
				T result = casePropertyDeclarationContainer(propertyDeclarationContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.PROPERTY_GROUP: {
				PropertyGroup propertyGroup = (PropertyGroup)theEObject;
				T result = casePropertyGroup(propertyGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.MAPPING: {
				Mapping mapping = (Mapping)theEObject;
				T result = caseMapping(mapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.MAPPING_TARGET_PATH: {
				MappingTargetPath mappingTargetPath = (MappingTargetPath)theEObject;
				T result = caseMappingTargetPath(mappingTargetPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.MAPPING_PROPERTY_REFERENCE: {
				MappingPropertyReference mappingPropertyReference = (MappingPropertyReference)theEObject;
				T result = caseMappingPropertyReference(mappingPropertyReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.MAPPING_BODY: {
				MappingBody mappingBody = (MappingBody)theEObject;
				T result = caseMappingBody(mappingBody);
				if (result == null) result = casePropertyContainer(mappingBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.MAPPING_SUBSCRIPT: {
				MappingSubscript mappingSubscript = (MappingSubscript)theEObject;
				T result = caseMappingSubscript(mappingSubscript);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.RESOURCE_DECLARATION: {
				ResourceDeclaration resourceDeclaration = (ResourceDeclaration)theEObject;
				T result = caseResourceDeclaration(resourceDeclaration);
				if (result == null) result = casePropertyDeclarationContainer(resourceDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.COMPUTATION_PROPERTY: {
				ComputationProperty computationProperty = (ComputationProperty)theEObject;
				T result = caseComputationProperty(computationProperty);
				if (result == null) result = caseProperty(computationProperty);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SYSTEM_CONFIGURATION: {
				SystemConfiguration systemConfiguration = (SystemConfiguration)theEObject;
				T result = caseSystemConfiguration(systemConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SYSTEM_CONFIGURATION_BODY: {
				SystemConfigurationBody systemConfigurationBody = (SystemConfigurationBody)theEObject;
				T result = caseSystemConfigurationBody(systemConfigurationBody);
				if (result == null) result = casePropertyContainer(systemConfigurationBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.ROOT_SYSTEM_CONFIGURATION: {
				RootSystemConfiguration rootSystemConfiguration = (RootSystemConfiguration)theEObject;
				T result = caseRootSystemConfiguration(rootSystemConfiguration);
				if (result == null) result = caseSystemConfiguration(rootSystemConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.SUBSYSTEM_CONFIGURATION: {
				SubsystemConfiguration subsystemConfiguration = (SubsystemConfiguration)theEObject;
				T result = caseSubsystemConfiguration(subsystemConfiguration);
				if (result == null) result = caseSystemConfiguration(subsystemConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.FRAGMENT_CONFIGURATION: {
				FragmentConfiguration fragmentConfiguration = (FragmentConfiguration)theEObject;
				T result = caseFragmentConfiguration(fragmentConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.FRAGMENT_CONFIGURATION_BODY: {
				FragmentConfigurationBody fragmentConfigurationBody = (FragmentConfigurationBody)theEObject;
				T result = caseFragmentConfigurationBody(fragmentConfigurationBody);
				if (result == null) result = casePropertyContainer(fragmentConfigurationBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.COMPONENT_CONFIGURATION: {
				ComponentConfiguration componentConfiguration = (ComponentConfiguration)theEObject;
				T result = caseComponentConfiguration(componentConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DconfigPackage.COMPONENT_CONFIGURATION_BODY: {
				ComponentConfigurationBody componentConfigurationBody = (ComponentConfigurationBody)theEObject;
				T result = caseComponentConfigurationBody(componentConfigurationBody);
				if (result == null) result = casePropertyContainer(componentConfigurationBody);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyContainer(PropertyContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declared Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declared Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaredProperty(DeclaredProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleProperty(SimpleProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyDeclaration(PropertyDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Declaration Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Declaration Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyDeclarationContainer(PropertyDeclarationContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyGroup(PropertyGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Property Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Property Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimplePropertyDeclaration(SimplePropertyDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionProperty(SelectionProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Property Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Property Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionPropertyBody(SelectionPropertyBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Property Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Property Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionPropertyDeclaration(SelectionPropertyDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Selection Property Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Selection Property Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectionPropertyOption(SelectionPropertyOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapping(Mapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Target Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Target Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingTargetPath(MappingTargetPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Property Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Property Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingPropertyReference(MappingPropertyReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingBody(MappingBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Subscript</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Subscript</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingSubscript(MappingSubscript object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceDeclaration(ResourceDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computation Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computation Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputationProperty(ComputationProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemConfiguration(SystemConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System Configuration Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System Configuration Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystemConfigurationBody(SystemConfigurationBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root System Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root System Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRootSystemConfiguration(RootSystemConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Subsystem Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Subsystem Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSubsystemConfiguration(SubsystemConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentConfiguration(FragmentConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment Configuration Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment Configuration Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFragmentConfigurationBody(FragmentConfigurationBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentConfiguration(ComponentConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component Configuration Body</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component Configuration Body</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponentConfigurationBody(ComponentConfigurationBody object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DconfigSwitch
