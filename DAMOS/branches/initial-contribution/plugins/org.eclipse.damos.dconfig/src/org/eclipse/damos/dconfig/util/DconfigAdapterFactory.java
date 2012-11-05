/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dconfig.util;

import org.eclipse.damos.dconfig.Binding;
import org.eclipse.damos.dconfig.BindingBody;
import org.eclipse.damos.dconfig.BindingResourceReference;
import org.eclipse.damos.dconfig.BindingResourceSubscript;
import org.eclipse.damos.dconfig.ComponentConfiguration;
import org.eclipse.damos.dconfig.ComponentConfigurationBody;
import org.eclipse.damos.dconfig.ComponentPath;
import org.eclipse.damos.dconfig.ComponentReference;
import org.eclipse.damos.dconfig.ComputationProperty;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.dconfig.ConfigurationDefinition;
import org.eclipse.damos.dconfig.ConfigurationDefinitionMember;
import org.eclipse.damos.dconfig.DconfigPackage;
import org.eclipse.damos.dconfig.DeclaredProperty;
import org.eclipse.damos.dconfig.FragmentConfiguration;
import org.eclipse.damos.dconfig.FragmentConfigurationBody;
import org.eclipse.damos.dconfig.Property;
import org.eclipse.damos.dconfig.PropertyContainer;
import org.eclipse.damos.dconfig.PropertyDeclaration;
import org.eclipse.damos.dconfig.PropertyDeclarationContainer;
import org.eclipse.damos.dconfig.ResourceDeclaration;
import org.eclipse.damos.dconfig.RootSystemConfiguration;
import org.eclipse.damos.dconfig.SelectionProperty;
import org.eclipse.damos.dconfig.SelectionPropertyBody;
import org.eclipse.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipse.damos.dconfig.SelectionPropertyOption;
import org.eclipse.damos.dconfig.SimpleProperty;
import org.eclipse.damos.dconfig.SimplePropertyDeclaration;
import org.eclipse.damos.dconfig.SubsystemConfiguration;
import org.eclipse.damos.dconfig.SystemConfiguration;
import org.eclipse.damos.dconfig.SystemConfigurationBody;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.damos.dconfig.DconfigPackage
 * @generated
 */
public class DconfigAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DconfigPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DconfigAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DconfigPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DconfigSwitch<Adapter> modelSwitch =
		new DconfigSwitch<Adapter>() {
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseConfigurationDefinition(ConfigurationDefinition object) {
				return createConfigurationDefinitionAdapter();
			}
			@Override
			public Adapter caseConfigurationDefinitionMember(ConfigurationDefinitionMember object) {
				return createConfigurationDefinitionMemberAdapter();
			}
			@Override
			public Adapter casePropertyContainer(PropertyContainer object) {
				return createPropertyContainerAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseDeclaredProperty(DeclaredProperty object) {
				return createDeclaredPropertyAdapter();
			}
			@Override
			public Adapter caseSimpleProperty(SimpleProperty object) {
				return createSimplePropertyAdapter();
			}
			@Override
			public Adapter caseSimplePropertyDeclaration(SimplePropertyDeclaration object) {
				return createSimplePropertyDeclarationAdapter();
			}
			@Override
			public Adapter caseSelectionProperty(SelectionProperty object) {
				return createSelectionPropertyAdapter();
			}
			@Override
			public Adapter caseSelectionPropertyBody(SelectionPropertyBody object) {
				return createSelectionPropertyBodyAdapter();
			}
			@Override
			public Adapter caseSelectionPropertyDeclaration(SelectionPropertyDeclaration object) {
				return createSelectionPropertyDeclarationAdapter();
			}
			@Override
			public Adapter caseSelectionPropertyOption(SelectionPropertyOption object) {
				return createSelectionPropertyOptionAdapter();
			}
			@Override
			public Adapter casePropertyDeclaration(PropertyDeclaration object) {
				return createPropertyDeclarationAdapter();
			}
			@Override
			public Adapter casePropertyDeclarationContainer(PropertyDeclarationContainer object) {
				return createPropertyDeclarationContainerAdapter();
			}
			@Override
			public Adapter caseComponentPath(ComponentPath object) {
				return createComponentPathAdapter();
			}
			@Override
			public Adapter caseComponentReference(ComponentReference object) {
				return createComponentReferenceAdapter();
			}
			@Override
			public Adapter caseBinding(Binding object) {
				return createBindingAdapter();
			}
			@Override
			public Adapter caseBindingResourceReference(BindingResourceReference object) {
				return createBindingResourceReferenceAdapter();
			}
			@Override
			public Adapter caseBindingResourceSubscript(BindingResourceSubscript object) {
				return createBindingResourceSubscriptAdapter();
			}
			@Override
			public Adapter caseBindingBody(BindingBody object) {
				return createBindingBodyAdapter();
			}
			@Override
			public Adapter caseResourceDeclaration(ResourceDeclaration object) {
				return createResourceDeclarationAdapter();
			}
			@Override
			public Adapter caseComputationProperty(ComputationProperty object) {
				return createComputationPropertyAdapter();
			}
			@Override
			public Adapter caseSystemConfiguration(SystemConfiguration object) {
				return createSystemConfigurationAdapter();
			}
			@Override
			public Adapter caseSystemConfigurationBody(SystemConfigurationBody object) {
				return createSystemConfigurationBodyAdapter();
			}
			@Override
			public Adapter caseRootSystemConfiguration(RootSystemConfiguration object) {
				return createRootSystemConfigurationAdapter();
			}
			@Override
			public Adapter caseSubsystemConfiguration(SubsystemConfiguration object) {
				return createSubsystemConfigurationAdapter();
			}
			@Override
			public Adapter caseFragmentConfiguration(FragmentConfiguration object) {
				return createFragmentConfigurationAdapter();
			}
			@Override
			public Adapter caseFragmentConfigurationBody(FragmentConfigurationBody object) {
				return createFragmentConfigurationBodyAdapter();
			}
			@Override
			public Adapter caseComponentConfiguration(ComponentConfiguration object) {
				return createComponentConfigurationAdapter();
			}
			@Override
			public Adapter caseComponentConfigurationBody(ComponentConfigurationBody object) {
				return createComponentConfigurationBodyAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ConfigurationDefinition <em>Configuration Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinition
	 * @generated
	 */
	public Adapter createConfigurationDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ConfigurationDefinitionMember <em>Configuration Definition Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ConfigurationDefinitionMember
	 * @generated
	 */
	public Adapter createConfigurationDefinitionMemberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.PropertyContainer <em>Property Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.PropertyContainer
	 * @generated
	 */
	public Adapter createPropertyContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.DeclaredProperty <em>Declared Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.DeclaredProperty
	 * @generated
	 */
	public Adapter createDeclaredPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SimpleProperty <em>Simple Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SimpleProperty
	 * @generated
	 */
	public Adapter createSimplePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.PropertyDeclaration <em>Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.PropertyDeclaration
	 * @generated
	 */
	public Adapter createPropertyDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.PropertyDeclarationContainer <em>Property Declaration Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.PropertyDeclarationContainer
	 * @generated
	 */
	public Adapter createPropertyDeclarationContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ComponentPath <em>Component Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ComponentPath
	 * @generated
	 */
	public Adapter createComponentPathAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ComponentReference <em>Component Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ComponentReference
	 * @generated
	 */
	public Adapter createComponentReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.Binding
	 * @generated
	 */
	public Adapter createBindingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.BindingResourceReference <em>Binding Resource Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.BindingResourceReference
	 * @generated
	 */
	public Adapter createBindingResourceReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.BindingResourceSubscript <em>Binding Resource Subscript</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.BindingResourceSubscript
	 * @generated
	 */
	public Adapter createBindingResourceSubscriptAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.BindingBody <em>Binding Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.BindingBody
	 * @generated
	 */
	public Adapter createBindingBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SimplePropertyDeclaration <em>Simple Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SimplePropertyDeclaration
	 * @generated
	 */
	public Adapter createSimplePropertyDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SelectionProperty <em>Selection Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SelectionProperty
	 * @generated
	 */
	public Adapter createSelectionPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SelectionPropertyBody <em>Selection Property Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyBody
	 * @generated
	 */
	public Adapter createSelectionPropertyBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SelectionPropertyDeclaration <em>Selection Property Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyDeclaration
	 * @generated
	 */
	public Adapter createSelectionPropertyDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SelectionPropertyOption <em>Selection Property Option</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SelectionPropertyOption
	 * @generated
	 */
	public Adapter createSelectionPropertyOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ResourceDeclaration <em>Resource Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ResourceDeclaration
	 * @generated
	 */
	public Adapter createResourceDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ComputationProperty <em>Computation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ComputationProperty
	 * @generated
	 */
	public Adapter createComputationPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SystemConfiguration <em>System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SystemConfiguration
	 * @generated
	 */
	public Adapter createSystemConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SystemConfigurationBody <em>System Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SystemConfigurationBody
	 * @generated
	 */
	public Adapter createSystemConfigurationBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.RootSystemConfiguration <em>Root System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.RootSystemConfiguration
	 * @generated
	 */
	public Adapter createRootSystemConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.SubsystemConfiguration <em>Subsystem Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.SubsystemConfiguration
	 * @generated
	 */
	public Adapter createSubsystemConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.FragmentConfiguration <em>Fragment Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.FragmentConfiguration
	 * @generated
	 */
	public Adapter createFragmentConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.FragmentConfigurationBody <em>Fragment Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.FragmentConfigurationBody
	 * @generated
	 */
	public Adapter createFragmentConfigurationBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ComponentConfiguration <em>Component Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ComponentConfiguration
	 * @generated
	 */
	public Adapter createComponentConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.damos.dconfig.ComponentConfigurationBody <em>Component Configuration Body</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.damos.dconfig.ComponentConfigurationBody
	 * @generated
	 */
	public Adapter createComponentConfigurationBodyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DconfigAdapterFactory
