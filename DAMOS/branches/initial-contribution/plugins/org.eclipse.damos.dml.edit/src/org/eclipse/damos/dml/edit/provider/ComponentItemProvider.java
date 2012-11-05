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
package org.eclipse.damos.dml.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.damos.dml.Component} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentItemProvider
	extends FragmentElementItemProvider
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addOwningCompoundPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Owning Compound feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwningCompoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CompoundMember_owningCompound_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CompoundMember_owningCompound_feature", "_UI_CompoundMember_type"),
				 DMLPackage.Literals.COMPOUND_MEMBER__OWNING_COMPOUND,
				 false,
				 false,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Component_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Component_name_feature", "_UI_Component_type"),
				 DMLPackage.Literals.COMPONENT__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(DMLPackage.Literals.COMPONENT__INPUTS);
			childrenFeatures.add(DMLPackage.Literals.COMPONENT__OUTPUTS);
			childrenFeatures.add(DMLPackage.Literals.COMPONENT__TIMING_CONSTRAINT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Component)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Component_type") :
			getString("_UI_Component_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Component.class)) {
			case DMLPackage.COMPONENT__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DMLPackage.COMPONENT__INPUTS:
			case DMLPackage.COMPONENT__OUTPUTS:
			case DMLPackage.COMPONENT__TIMING_CONSTRAINT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createBlockInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createInportInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createSubsystemInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createLatchInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createChoiceInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createJoinInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createMemoryInitialCondition()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__INPUTS,
				 DMLFactory.eINSTANCE.createMemoryInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__OUTPUTS,
				 DMLFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__OUTPUTS,
				 DMLFactory.eINSTANCE.createBlockOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__OUTPUTS,
				 DMLFactory.eINSTANCE.createOutportOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__OUTPUTS,
				 DMLFactory.eINSTANCE.createSubsystemOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__OUTPUTS,
				 DMLFactory.eINSTANCE.createMemoryOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__TIMING_CONSTRAINT,
				 DMLFactory.eINSTANCE.createContinuousTimingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__TIMING_CONSTRAINT,
				 DMLFactory.eINSTANCE.createSynchronousTimingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.COMPONENT__TIMING_CONSTRAINT,
				 DMLFactory.eINSTANCE.createAsynchronousTimingConstraint()));
	}

}
