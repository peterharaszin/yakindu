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
import org.eclipselabs.damos.common.util.NumberedList;
import org.eclipselabs.damos.dconfig.Binding;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.DconfigPackage;
import org.eclipselabs.damos.dconfig.RootSystemConfiguration;
import org.eclipselabs.damos.dconfig.internal.operations.ConfigurationOperations;
import org.eclipselabs.damos.dconfig.util.PropertyPath;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.util.SystemPath;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.ImportDeclaration;
import org.eclipselabs.damos.mscript.computation.ComputationModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.ConfigurationImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.ConfigurationImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.ConfigurationImpl#getBaseConfiguration <em>Base Configuration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.ConfigurationImpl#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.impl.ConfigurationImpl#getRootSystemConfiguration <em>Root System Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConfigurationImpl extends PropertyContainerImpl implements Configuration {
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
	 * The cached value of the '{@link #getBaseConfiguration() <em>Base Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseConfiguration()
	 * @generated
	 * @ordered
	 */
	protected Configuration baseConfiguration;

	/**
	 * The cached value of the '{@link #getImportDeclarations() <em>Import Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportDeclaration> importDeclarations;

	/**
	 * The cached value of the '{@link #getRootSystemConfiguration() <em>Root System Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootSystemConfiguration()
	 * @generated
	 * @ordered
	 */
	protected RootSystemConfiguration rootSystemConfiguration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DconfigPackage.Literals.CONFIGURATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.CONFIGURATION__PACKAGE_NAME, oldPackageName, packageName));
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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.CONFIGURATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration getBaseConfiguration() {
		if (baseConfiguration != null && baseConfiguration.eIsProxy()) {
			InternalEObject oldBaseConfiguration = (InternalEObject)baseConfiguration;
			baseConfiguration = (Configuration)eResolveProxy(oldBaseConfiguration);
			if (baseConfiguration != oldBaseConfiguration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DconfigPackage.CONFIGURATION__BASE_CONFIGURATION, oldBaseConfiguration, baseConfiguration));
			}
		}
		return baseConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration basicGetBaseConfiguration() {
		return baseConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBaseConfiguration(Configuration newBaseConfiguration) {
		Configuration oldBaseConfiguration = baseConfiguration;
		baseConfiguration = newBaseConfiguration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.CONFIGURATION__BASE_CONFIGURATION, oldBaseConfiguration, baseConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportDeclaration> getImportDeclarations() {
		if (importDeclarations == null) {
			importDeclarations = new EObjectContainmentEList<ImportDeclaration>(ImportDeclaration.class, this, DconfigPackage.CONFIGURATION__IMPORT_DECLARATIONS);
		}
		return importDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RootSystemConfiguration getRootSystemConfiguration() {
		return rootSystemConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRootSystemConfiguration(RootSystemConfiguration newRootSystemConfiguration, NotificationChain msgs) {
		RootSystemConfiguration oldRootSystemConfiguration = rootSystemConfiguration;
		rootSystemConfiguration = newRootSystemConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION, oldRootSystemConfiguration, newRootSystemConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRootSystemConfiguration(RootSystemConfiguration newRootSystemConfiguration) {
		if (newRootSystemConfiguration != rootSystemConfiguration) {
			NotificationChain msgs = null;
			if (rootSystemConfiguration != null)
				msgs = ((InternalEObject)rootSystemConfiguration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION, null, msgs);
			if (newRootSystemConfiguration != null)
				msgs = ((InternalEObject)newRootSystemConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION, null, msgs);
			msgs = basicSetRootSystemConfiguration(newRootSystemConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION, newRootSystemConfiguration, newRootSystemConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Fragment getContextFragment() {
		return ConfigurationOperations.getContextFragment(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Expression getPropertyValue(PropertyPath propertyPath) {
		return ConfigurationOperations.getPropertyValue(this, propertyPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Expression getPropertyValue(SystemPath systemPath, PropertyPath propertyPath) {
		return ConfigurationOperations.getPropertyValue(this, systemPath, propertyPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPropertySelectionName(PropertyPath propertyPath) {
		return ConfigurationOperations.getPropertySelectionName(this, propertyPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getPropertySelectionName(SystemPath systemPath, PropertyPath propertyPath) {
		return ConfigurationOperations.getPropertySelectionName(this, systemPath, propertyPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NumberedList<String> getPropertySelectionNames(PropertyPath propertyPath) {
		return ConfigurationOperations.getPropertySelectionNames(this, propertyPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public NumberedList<String> getPropertySelectionNames(SystemPath systemPath, PropertyPath propertyPath) {
		return ConfigurationOperations.getPropertySelectionNames(this, systemPath, propertyPath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Binding getBinding(PropertyPath propertyPath, SystemPath sourcePath) {
		return ConfigurationOperations.getBinding(this, propertyPath, sourcePath);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ComputationModel getComputationModel(SystemPath path) {
		return ConfigurationOperations.getComputationModel(this, path);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DconfigPackage.CONFIGURATION__IMPORT_DECLARATIONS:
				return ((InternalEList<?>)getImportDeclarations()).basicRemove(otherEnd, msgs);
			case DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION:
				return basicSetRootSystemConfiguration(null, msgs);
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
			case DconfigPackage.CONFIGURATION__PACKAGE_NAME:
				return getPackageName();
			case DconfigPackage.CONFIGURATION__NAME:
				return getName();
			case DconfigPackage.CONFIGURATION__BASE_CONFIGURATION:
				if (resolve) return getBaseConfiguration();
				return basicGetBaseConfiguration();
			case DconfigPackage.CONFIGURATION__IMPORT_DECLARATIONS:
				return getImportDeclarations();
			case DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION:
				return getRootSystemConfiguration();
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
			case DconfigPackage.CONFIGURATION__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case DconfigPackage.CONFIGURATION__NAME:
				setName((String)newValue);
				return;
			case DconfigPackage.CONFIGURATION__BASE_CONFIGURATION:
				setBaseConfiguration((Configuration)newValue);
				return;
			case DconfigPackage.CONFIGURATION__IMPORT_DECLARATIONS:
				getImportDeclarations().clear();
				getImportDeclarations().addAll((Collection<? extends ImportDeclaration>)newValue);
				return;
			case DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION:
				setRootSystemConfiguration((RootSystemConfiguration)newValue);
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
			case DconfigPackage.CONFIGURATION__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case DconfigPackage.CONFIGURATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DconfigPackage.CONFIGURATION__BASE_CONFIGURATION:
				setBaseConfiguration((Configuration)null);
				return;
			case DconfigPackage.CONFIGURATION__IMPORT_DECLARATIONS:
				getImportDeclarations().clear();
				return;
			case DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION:
				setRootSystemConfiguration((RootSystemConfiguration)null);
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
			case DconfigPackage.CONFIGURATION__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case DconfigPackage.CONFIGURATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DconfigPackage.CONFIGURATION__BASE_CONFIGURATION:
				return baseConfiguration != null;
			case DconfigPackage.CONFIGURATION__IMPORT_DECLARATIONS:
				return importDeclarations != null && !importDeclarations.isEmpty();
			case DconfigPackage.CONFIGURATION__ROOT_SYSTEM_CONFIGURATION:
				return rootSystemConfiguration != null;
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
		result.append(" (packageName: ");
		result.append(packageName);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
