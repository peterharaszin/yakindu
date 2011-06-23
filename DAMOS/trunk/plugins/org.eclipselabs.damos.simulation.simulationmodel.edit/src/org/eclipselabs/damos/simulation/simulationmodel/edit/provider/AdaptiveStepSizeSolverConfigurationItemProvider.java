/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.edit.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;

/**
 * This is the item provider adapter for a {@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AdaptiveStepSizeSolverConfigurationItemProvider
	extends SolverConfigurationItemProvider
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
	public AdaptiveStepSizeSolverConfigurationItemProvider(AdapterFactory adapterFactory) {
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

			addMinimumStepSizePropertyDescriptor(object);
			addMaximumStepSizePropertyDescriptor(object);
			addInitialStepSizePropertyDescriptor(object);
			addAbsoluteTolerancePropertyDescriptor(object);
			addRelativeTolerancePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Minimum Step Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMinimumStepSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AdaptiveStepSizeSolverConfiguration_minimumStepSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AdaptiveStepSizeSolverConfiguration_minimumStepSize_feature", "_UI_AdaptiveStepSizeSolverConfiguration_type"),
				 SimulationModelPackage.Literals.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Maximum Step Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMaximumStepSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AdaptiveStepSizeSolverConfiguration_maximumStepSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AdaptiveStepSizeSolverConfiguration_maximumStepSize_feature", "_UI_AdaptiveStepSizeSolverConfiguration_type"),
				 SimulationModelPackage.Literals.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Step Size feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialStepSizePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AdaptiveStepSizeSolverConfiguration_initialStepSize_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AdaptiveStepSizeSolverConfiguration_initialStepSize_feature", "_UI_AdaptiveStepSizeSolverConfiguration_type"),
				 SimulationModelPackage.Literals.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Absolute Tolerance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAbsoluteTolerancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AdaptiveStepSizeSolverConfiguration_absoluteTolerance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AdaptiveStepSizeSolverConfiguration_absoluteTolerance_feature", "_UI_AdaptiveStepSizeSolverConfiguration_type"),
				 SimulationModelPackage.Literals.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Relative Tolerance feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRelativeTolerancePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_AdaptiveStepSizeSolverConfiguration_relativeTolerance_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_AdaptiveStepSizeSolverConfiguration_relativeTolerance_feature", "_UI_AdaptiveStepSizeSolverConfiguration_type"),
				 SimulationModelPackage.Literals.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.REAL_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns AdaptiveStepSizeSolverConfiguration.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AdaptiveStepSizeSolverConfiguration"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		AdaptiveStepSizeSolverConfiguration adaptiveStepSizeSolverConfiguration = (AdaptiveStepSizeSolverConfiguration)object;
		return getString("_UI_AdaptiveStepSizeSolverConfiguration_type") + " " + adaptiveStepSizeSolverConfiguration.getMinimumStepSize();
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

		switch (notification.getFeatureID(AdaptiveStepSizeSolverConfiguration.class)) {
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MINIMUM_STEP_SIZE:
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__MAXIMUM_STEP_SIZE:
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__INITIAL_STEP_SIZE:
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__ABSOLUTE_TOLERANCE:
			case SimulationModelPackage.ADAPTIVE_STEP_SIZE_SOLVER_CONFIGURATION__RELATIVE_TOLERANCE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
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
	}

}
