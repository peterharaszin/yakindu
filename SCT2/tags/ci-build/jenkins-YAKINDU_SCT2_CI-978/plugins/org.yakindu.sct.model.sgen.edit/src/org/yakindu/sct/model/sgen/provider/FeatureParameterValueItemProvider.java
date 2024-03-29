/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * This is the item provider adapter for a
 * {@link org.yakindu.sct.model.sgen.FeatureParameterValue} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@SuppressWarnings("restriction")
public class FeatureParameterValueItemProvider extends ItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FeatureParameterValueItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addParameterPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Parameter feature. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addParameterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory)
						.getRootAdapterFactory(),
				getResourceLocator(),
				getString("_UI_FeatureParameterValue_parameter_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_FeatureParameterValue_parameter_feature",
						"_UI_FeatureParameterValue_type"),
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__PARAMETER, true,
				false, true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to
	 * deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand},
	 * {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in
	 * {@link #createCommand}. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper
		// feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns FeatureParameterValue.gif. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(
				object,
				getResourceLocator().getImage(
						"full/obj16/FeatureParameterValue"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		FeatureParameterValue value = ((FeatureParameterValue) object);
		return value.getParameter().getName() + "parameter";
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to
	 * update any cached children and by creating a viewer notification, which
	 * it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(FeatureParameterValue.class)) {
		case SGenPackage.FEATURE_PARAMETER_VALUE__EXPRESSION:
			fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXIfExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXSwitchExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXBlockExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXVariableDeclaration()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXMemberFeatureCall()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXFeatureCall()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXConstructorCall()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXBooleanLiteral()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXNullLiteral()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXIntLiteral()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXStringLiteral()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXClosure()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXCastedExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXBinaryOperation()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXUnaryOperation()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXForLoopExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXDoWhileExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXWhileExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXTypeLiteral()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXInstanceOfExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXThrowExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXTryCatchFinallyExpression()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXAssignment()));

		newChildDescriptors.add(createChildParameter(
				SGenPackage.Literals.FEATURE_PARAMETER_VALUE__EXPRESSION,
				XbaseFactory.eINSTANCE.createXReturnExpression()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SgenEditPlugin.INSTANCE;
	}

}
