/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.edit.provider;


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
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;

/**
 * This is the item provider adapter for a {@link org.eclipselabs.damos.dml.OpaqueBehaviorSpecification} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OpaqueBehaviorSpecificationItemProvider
	extends BehaviorSpecificationItemProvider
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
	public OpaqueBehaviorSpecificationItemProvider(AdapterFactory adapterFactory) {
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

			addBehaviorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Behavior feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBehaviorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_OpaqueBehaviorSpecification_behavior_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_OpaqueBehaviorSpecification_behavior_feature", "_UI_OpaqueBehaviorSpecification_type"),
				 DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__BEHAVIOR,
				 true,
				 true,
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
			childrenFeatures.add(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL);
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
	 * This returns OpaqueBehaviorSpecification.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/OpaqueBehaviorSpecification"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = crop(((OpaqueBehaviorSpecification)object).getBehavior());
		return label == null || label.length() == 0 ?
			getString("_UI_OpaqueBehaviorSpecification_type") :
			getString("_UI_OpaqueBehaviorSpecification_type") + " " + label;
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

		switch (notification.getFeatureID(OpaqueBehaviorSpecification.class)) {
			case DMLPackage.OPAQUE_BEHAVIOR_SPECIFICATION__BEHAVIOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case DMLPackage.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL:
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
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createFragment()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createContinuousTimingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createSynchronousTimingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createAsynchronousTimingConstraint()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOpaqueSampleTimeSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createConnection()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createInputPort()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOutputPort()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createBlockInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createBlockOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createInputDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOutputDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createArgument()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createExpressionParameter()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createExpressionSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createPredefinedExpressionEntry()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createBlockType()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createCategory()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createBlock()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createSystem()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createModel()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createBlockInputPort()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createBlockOutputPort()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createSubsystem()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createSystemInterface()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createInlet()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOutlet()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createSubsystemRealization()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createInport()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOutport()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createSubsystemInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createSubsystemOutput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createBooleanDirectFeedthroughPolicy()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOpaqueDataTypeSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOpaqueBehaviorSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createLatch()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createChoice()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createChoiceInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createChoiceInputPort()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createAction()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createActionLink()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createOpaqueConditionSpecification()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createJoin()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createJoinInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createWhileLoop()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createWhileLoopCondition()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createMemory()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createMemoryInitialCondition()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createMemoryInput()));

		newChildDescriptors.add
			(createChildParameter
				(DMLPackage.Literals.OPAQUE_BEHAVIOR_SPECIFICATION__MODEL,
				 DMLFactory.eINSTANCE.createMemoryOutput()));
	}

}
