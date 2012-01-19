/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.ResourceDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection Property Option</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyOptionImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyOptionImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.SelectionPropertyOptionImpl#getResourceDeclarations <em>Resource Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SelectionPropertyOptionImpl extends PropertyDeclarationContainerImpl implements SelectionPropertyOption {
	/**
	 * The default value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected SelectionPropertyDeclaration target;

	/**
	 * The cached value of the '{@link #getResourceDeclarations() <em>Resource Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceDeclaration> resourceDeclarations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SelectionPropertyOptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.SELECTION_PROPERTY_OPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedName() {
		return qualifiedName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedName(String newQualifiedName) {
		String oldQualifiedName = qualifiedName;
		qualifiedName = newQualifiedName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME, oldQualifiedName, qualifiedName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPropertyDeclaration getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (SelectionPropertyDeclaration)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectionPropertyDeclaration basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(SelectionPropertyDeclaration newTarget) {
		SelectionPropertyDeclaration oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ResourceDeclaration> getResourceDeclarations() {
		if (resourceDeclarations == null) {
			resourceDeclarations = new EObjectContainmentEList<ResourceDeclaration>(ResourceDeclaration.class, this, DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS);
		}
		return resourceDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				return ((InternalEList<?>)getResourceDeclarations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME:
				return getQualifiedName();
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				return getResourceDeclarations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				setTarget((SelectionPropertyDeclaration)newValue);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				getResourceDeclarations().clear();
				getResourceDeclarations().addAll((Collection<? extends ResourceDeclaration>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				setTarget((SelectionPropertyDeclaration)null);
				return;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				getResourceDeclarations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DconfigPackage.SELECTION_PROPERTY_OPTION__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? qualifiedName != null : !QUALIFIED_NAME_EDEFAULT.equals(qualifiedName);
			case DconfigPackage.SELECTION_PROPERTY_OPTION__TARGET:
				return target != null;
			case DconfigPackage.SELECTION_PROPERTY_OPTION__RESOURCE_DECLARATIONS:
				return resourceDeclarations != null && !resourceDeclarations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (qualifiedName: ");
		result.append(qualifiedName);
		result.append(')');
		return result.toString();
	}

} //SelectionPropertyOptionImpl
