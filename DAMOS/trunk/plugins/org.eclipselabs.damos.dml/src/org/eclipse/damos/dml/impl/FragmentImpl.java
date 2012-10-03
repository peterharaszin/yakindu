/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.impl;

import java.util.Collection;

import org.eclipse.damos.common.ecore.util.DerivedSubsetEObjectEList;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.INamedElement;
import org.eclipse.damos.dml.QualifiedElement;
import org.eclipse.damos.dml.internal.operations.FragmentOperations;
import org.eclipse.damos.dml.internal.operations.QualifiedElementOperations;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fragment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentImpl#getFragmentElements <em>Fragment Elements</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.impl.FragmentImpl#getParent <em>Parent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FragmentImpl extends EModelElementImpl implements Fragment {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFragmentElements() <em>Fragment Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragmentElements()
	 * @generated
	 * @ordered
	 */
	protected EList<FragmentElement> fragmentElements;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected Fragment parent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FragmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifiedName() {
		return QualifiedElementOperations.getQualifiedName(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setQualifiedName(String newQualifiedName) {
		QualifiedElementOperations.setQualifiedName(this, newQualifiedName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FragmentElement> getFragmentElements() {
		if (fragmentElements == null) {
			fragmentElements = new EObjectContainmentWithInverseEList<FragmentElement>(FragmentElement.class, this, DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS, DMLPackage.FRAGMENT_ELEMENT__OWNING_FRAGMENT);
		}
		return fragmentElements;
	}

	private EList<Component> components;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Component> getComponents() {
		if (components == null) {
			components = new DerivedSubsetEObjectEList<Component>(Component.class, this, DMLPackage.FRAGMENT__COMPONENTS, COMPONENTS_ESUPERSETS);
		}
		return components;
	}

	protected static final int[] COMPONENTS_ESUPERSETS = new int[] {DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS};

	private EList<Connection> connections;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Connection> getConnections() {
		if (connections == null) {
			connections = new DerivedSubsetEObjectEList<Connection>(Connection.class, this, DMLPackage.FRAGMENT__CONNECTIONS, CONNECTIONS_ESUPERSETS);
		}
		return connections;
	}

	protected static final int[] CONNECTIONS_ESUPERSETS = new int[] {DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment getParent() {
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (Fragment)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DMLPackage.FRAGMENT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Fragment basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Fragment newParent) {
		Fragment oldParent = parent;
		parent = newParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.FRAGMENT__PARENT, oldParent, parent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.FRAGMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.FRAGMENT__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Fragment> getChildren() {
		return FragmentOperations.getChildren(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<FragmentElement> getAllFragmentElements() {
		return FragmentOperations.getAllFragmentElements(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Component> getAllComponents() {
		return FragmentOperations.getAllComponents(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<Connection> getAllConnections() {
		return FragmentOperations.getAllConnections(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFragmentElements()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS:
				return ((InternalEList<?>)getFragmentElements()).basicRemove(otherEnd, msgs);
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
			case DMLPackage.FRAGMENT__QUALIFIED_NAME:
				return getQualifiedName();
			case DMLPackage.FRAGMENT__NAME:
				return getName();
			case DMLPackage.FRAGMENT__PACKAGE_NAME:
				return getPackageName();
			case DMLPackage.FRAGMENT__COMPONENTS:
				return getComponents();
			case DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS:
				return getFragmentElements();
			case DMLPackage.FRAGMENT__CONNECTIONS:
				return getConnections();
			case DMLPackage.FRAGMENT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
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
			case DMLPackage.FRAGMENT__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case DMLPackage.FRAGMENT__NAME:
				setName((String)newValue);
				return;
			case DMLPackage.FRAGMENT__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case DMLPackage.FRAGMENT__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS:
				getFragmentElements().clear();
				getFragmentElements().addAll((Collection<? extends FragmentElement>)newValue);
				return;
			case DMLPackage.FRAGMENT__CONNECTIONS:
				getConnections().clear();
				getConnections().addAll((Collection<? extends Connection>)newValue);
				return;
			case DMLPackage.FRAGMENT__PARENT:
				setParent((Fragment)newValue);
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
			case DMLPackage.FRAGMENT__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case DMLPackage.FRAGMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DMLPackage.FRAGMENT__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case DMLPackage.FRAGMENT__COMPONENTS:
				getComponents().clear();
				return;
			case DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS:
				getFragmentElements().clear();
				return;
			case DMLPackage.FRAGMENT__CONNECTIONS:
				getConnections().clear();
				return;
			case DMLPackage.FRAGMENT__PARENT:
				setParent((Fragment)null);
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
			case DMLPackage.FRAGMENT__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case DMLPackage.FRAGMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DMLPackage.FRAGMENT__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case DMLPackage.FRAGMENT__COMPONENTS:
				return !getComponents().isEmpty();
			case DMLPackage.FRAGMENT__FRAGMENT_ELEMENTS:
				return fragmentElements != null && !fragmentElements.isEmpty();
			case DMLPackage.FRAGMENT__CONNECTIONS:
				return !getConnections().isEmpty();
			case DMLPackage.FRAGMENT__PARENT:
				return parent != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == INamedElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == QualifiedElement.class) {
			switch (derivedFeatureID) {
				case DMLPackage.FRAGMENT__QUALIFIED_NAME: return DMLPackage.QUALIFIED_ELEMENT__QUALIFIED_NAME;
				case DMLPackage.FRAGMENT__NAME: return DMLPackage.QUALIFIED_ELEMENT__NAME;
				case DMLPackage.FRAGMENT__PACKAGE_NAME: return DMLPackage.QUALIFIED_ELEMENT__PACKAGE_NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == INamedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == QualifiedElement.class) {
			switch (baseFeatureID) {
				case DMLPackage.QUALIFIED_ELEMENT__QUALIFIED_NAME: return DMLPackage.FRAGMENT__QUALIFIED_NAME;
				case DMLPackage.QUALIFIED_ELEMENT__NAME: return DMLPackage.FRAGMENT__NAME;
				case DMLPackage.QUALIFIED_ELEMENT__PACKAGE_NAME: return DMLPackage.FRAGMENT__PACKAGE_NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", packageName: ");
		result.append(packageName);
		result.append(')');
		return result.toString();
	}

} //FragmentImpl
