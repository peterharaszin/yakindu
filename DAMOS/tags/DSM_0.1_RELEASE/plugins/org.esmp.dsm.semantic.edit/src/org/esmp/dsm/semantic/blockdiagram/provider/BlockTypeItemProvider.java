/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.provider;


import java.util.Collection;
import java.util.List;

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
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramFactory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.BlockType;

/**
 * This is the item provider adapter for a {@link org.esmp.dsm.semantic.blockdiagram.BlockType} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BlockTypeItemProvider
	extends NamedElementItemProvider
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
	public BlockTypeItemProvider(AdapterFactory adapterFactory) {
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

			addCategoriesPropertyDescriptor(object);
			addUriPropertyDescriptor(object);
			addUriAsStringPropertyDescriptor(object);
			addVirtualPropertyDescriptor(object);
			addStructuralPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Categories feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCategoriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BlockType_categories_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BlockType_categories_feature", "_UI_BlockType_type"),
				 BlockDiagramPackage.Literals.BLOCK_TYPE__CATEGORIES,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uri feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BlockType_uri_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BlockType_uri_feature", "_UI_BlockType_type"),
				 BlockDiagramPackage.Literals.BLOCK_TYPE__URI,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Uri As String feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUriAsStringPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BlockType_uriAsString_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BlockType_uriAsString_feature", "_UI_BlockType_type"),
				 BlockDiagramPackage.Literals.BLOCK_TYPE__URI_AS_STRING,
				 false,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Virtual feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVirtualPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BlockType_virtual_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BlockType_virtual_feature", "_UI_BlockType_type"),
				 BlockDiagramPackage.Literals.BLOCK_TYPE__VIRTUAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Structural feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStructuralPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_BlockType_structural_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_BlockType_structural_feature", "_UI_BlockType_type"),
				 BlockDiagramPackage.Literals.BLOCK_TYPE__STRUCTURAL,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(BlockDiagramPackage.Literals.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS);
			childrenFeatures.add(BlockDiagramPackage.Literals.BLOCK_TYPE__INPUTS);
			childrenFeatures.add(BlockDiagramPackage.Literals.BLOCK_TYPE__OUTPUTS);
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
	 * This returns BlockType.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/BlockType"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((BlockType)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_BlockType_type") :
			getString("_UI_BlockType_type") + " " + label;
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

		switch (notification.getFeatureID(BlockType.class)) {
			case BlockDiagramPackage.BLOCK_TYPE__URI:
			case BlockDiagramPackage.BLOCK_TYPE__URI_AS_STRING:
			case BlockDiagramPackage.BLOCK_TYPE__VIRTUAL:
			case BlockDiagramPackage.BLOCK_TYPE__STRUCTURAL:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case BlockDiagramPackage.BLOCK_TYPE__PARAMETERS:
			case BlockDiagramPackage.BLOCK_TYPE__INPUTS:
			case BlockDiagramPackage.BLOCK_TYPE__OUTPUTS:
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
				(BlockDiagramPackage.Literals.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS,
				 BlockDiagramFactory.eINSTANCE.createExpressionParameterDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(BlockDiagramPackage.Literals.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS,
				 BlockDiagramFactory.eINSTANCE.createBooleanParameterDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(BlockDiagramPackage.Literals.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS,
				 BlockDiagramFactory.eINSTANCE.createEnumerationParameterDescriptor()));

		newChildDescriptors.add
			(createChildParameter
				(BlockDiagramPackage.Literals.BLOCK_TYPE__INPUTS,
				 BlockDiagramFactory.eINSTANCE.createInputSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(BlockDiagramPackage.Literals.BLOCK_TYPE__OUTPUTS,
				 BlockDiagramFactory.eINSTANCE.createOutputSpecification()));
	}

}
