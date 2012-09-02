/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dscript.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.impl.BlockTypeImpl;
import org.eclipselabs.damos.dscript.BehaviorDeclaration;
import org.eclipselabs.damos.dscript.DscriptPackage;
import org.eclipselabs.damos.dscript.DscriptBlockType;
import org.eclipselabs.damos.mscript.ImportDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.TopLevelContainer;
import org.eclipselabs.damos.mscript.TopLevelDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mscript Block Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dscript.impl.DscriptBlockTypeImpl#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dscript.impl.DscriptBlockTypeImpl#getImportDeclarations <em>Import Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dscript.impl.DscriptBlockTypeImpl#getBehavior <em>Behavior</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DscriptBlockTypeImpl extends BlockTypeImpl implements DscriptBlockType {
	/**
	 * The cached value of the '{@link #getDeclarations() <em>Declarations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclarations()
	 * @generated
	 * @ordered
	 */
	protected EList<TopLevelDeclaration> declarations;

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
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected BehaviorDeclaration behavior;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DscriptBlockTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DscriptPackage.Literals.DSCRIPT_BLOCK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportDeclaration> getImportDeclarations() {
		if (importDeclarations == null) {
			importDeclarations = new EObjectContainmentEList<ImportDeclaration>(ImportDeclaration.class, this, DscriptPackage.DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS);
		}
		return importDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehaviorDeclaration getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehavior(BehaviorDeclaration newBehavior, NotificationChain msgs) {
		BehaviorDeclaration oldBehavior = behavior;
		behavior = newBehavior;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR, oldBehavior, newBehavior);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(BehaviorDeclaration newBehavior) {
		if (newBehavior != behavior) {
			NotificationChain msgs = null;
			if (behavior != null)
				msgs = ((InternalEObject)behavior).eInverseRemove(this, DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE, BehaviorDeclaration.class, msgs);
			if (newBehavior != null)
				msgs = ((InternalEObject)newBehavior).eInverseAdd(this, DscriptPackage.BEHAVIOR_DECLARATION__BLOCK_TYPE, BehaviorDeclaration.class, msgs);
			msgs = basicSetBehavior(newBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR, newBehavior, newBehavior));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR:
				if (behavior != null)
					msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR, null, msgs);
				return basicSetBehavior((BehaviorDeclaration)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TopLevelDeclaration> getDeclarations() {
		if (declarations == null) {
			declarations = new EObjectContainmentEList<TopLevelDeclaration>(TopLevelDeclaration.class, this, DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS);
		}
		return declarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS:
				return ((InternalEList<?>)getDeclarations()).basicRemove(otherEnd, msgs);
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				return ((InternalEList<?>)getImportDeclarations()).basicRemove(otherEnd, msgs);
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR:
				return basicSetBehavior(null, msgs);
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
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS:
				return getDeclarations();
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				return getImportDeclarations();
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR:
				return getBehavior();
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
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS:
				getDeclarations().clear();
				getDeclarations().addAll((Collection<? extends TopLevelDeclaration>)newValue);
				return;
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				getImportDeclarations().clear();
				getImportDeclarations().addAll((Collection<? extends ImportDeclaration>)newValue);
				return;
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR:
				setBehavior((BehaviorDeclaration)newValue);
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
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS:
				getDeclarations().clear();
				return;
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				getImportDeclarations().clear();
				return;
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR:
				setBehavior((BehaviorDeclaration)null);
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
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS:
				return declarations != null && !declarations.isEmpty();
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				return importDeclarations != null && !importDeclarations.isEmpty();
			case DscriptPackage.DSCRIPT_BLOCK_TYPE__BEHAVIOR:
				return behavior != null;
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
		if (baseClass == TopLevelContainer.class) {
			switch (derivedFeatureID) {
				case DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS: return MscriptPackage.TOP_LEVEL_CONTAINER__DECLARATIONS;
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
		if (baseClass == TopLevelContainer.class) {
			switch (baseFeatureID) {
				case MscriptPackage.TOP_LEVEL_CONTAINER__DECLARATIONS: return DscriptPackage.DSCRIPT_BLOCK_TYPE__DECLARATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //MscriptBlockTypeImpl
