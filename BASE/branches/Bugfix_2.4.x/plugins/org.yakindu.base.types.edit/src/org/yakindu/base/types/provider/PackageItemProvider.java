/**
 */
package org.yakindu.base.types.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.yakindu.base.base.provider.NamedElementItemProvider;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.TypesPackage;

/**
 * This is the item provider adapter for a {@link org.yakindu.base.types.Package} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PackageItemProvider
	extends NamedElementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageItemProvider(AdapterFactory adapterFactory) {
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

		}
		return itemPropertyDescriptors;
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
			childrenFeatures.add(TypesPackage.Literals.PACKAGE__MEMBER);
			childrenFeatures.add(TypesPackage.Literals.PACKAGE__DOMAIN);
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
	 * This returns Package.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Package"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((org.yakindu.base.types.Package)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Package_type") :
			getString("_UI_Package_type") + " " + label;
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

		switch (notification.getFeatureID(org.yakindu.base.types.Package.class)) {
			case TypesPackage.PACKAGE__MEMBER:
			case TypesPackage.PACKAGE__DOMAIN:
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
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createPackageMember()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createPrimitiveType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createEnumerationType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createParameterizedType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createComplexType()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createTypeParameter()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__MEMBER,
				 TypesFactory.eINSTANCE.createTypeAlias()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.PACKAGE__DOMAIN,
				 TypesFactory.eINSTANCE.createDomain()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return TypesEditPlugin.INSTANCE;
	}

}
