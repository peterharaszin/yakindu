/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.impl.BlockTypeImpl;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.MscriptBlockType;
import org.eclipselabs.damos.mscript.ImportDeclaration;
import org.eclipselabs.damos.mscript.MscriptPackage;
import org.eclipselabs.damos.mscript.PackageFragment;
import org.eclipselabs.damos.mscript.TopLevelContainer;
import org.eclipselabs.damos.mscript.TopLevelDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mscript Block Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dmltext.impl.MscriptBlockTypeImpl#getDeclarations <em>Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dmltext.impl.MscriptBlockTypeImpl#getImportDeclarations <em>Import Declarations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MscriptBlockTypeImpl extends BlockTypeImpl implements MscriptBlockType {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MscriptBlockTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLTextPackage.Literals.MSCRIPT_BLOCK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ImportDeclaration> getImportDeclarations() {
		if (importDeclarations == null) {
			importDeclarations = new EObjectContainmentEList<ImportDeclaration>(ImportDeclaration.class, this, DMLTextPackage.MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS);
		}
		return importDeclarations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TopLevelDeclaration> getDeclarations() {
		if (declarations == null) {
			declarations = new EObjectContainmentEList<TopLevelDeclaration>(TopLevelDeclaration.class, this, DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS);
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
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS:
				return ((InternalEList<?>)getDeclarations()).basicRemove(otherEnd, msgs);
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				return ((InternalEList<?>)getImportDeclarations()).basicRemove(otherEnd, msgs);
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
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS:
				return getDeclarations();
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				return getImportDeclarations();
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
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS:
				getDeclarations().clear();
				getDeclarations().addAll((Collection<? extends TopLevelDeclaration>)newValue);
				return;
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				getImportDeclarations().clear();
				getImportDeclarations().addAll((Collection<? extends ImportDeclaration>)newValue);
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
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS:
				getDeclarations().clear();
				return;
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				getImportDeclarations().clear();
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
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS:
				return declarations != null && !declarations.isEmpty();
			case DMLTextPackage.MSCRIPT_BLOCK_TYPE__IMPORT_DECLARATIONS:
				return importDeclarations != null && !importDeclarations.isEmpty();
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
				case DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS: return MscriptPackage.TOP_LEVEL_CONTAINER__DECLARATIONS;
				default: return -1;
			}
		}
		if (baseClass == PackageFragment.class) {
			switch (derivedFeatureID) {
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
				case MscriptPackage.TOP_LEVEL_CONTAINER__DECLARATIONS: return DMLTextPackage.MSCRIPT_BLOCK_TYPE__DECLARATIONS;
				default: return -1;
			}
		}
		if (baseClass == PackageFragment.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //MscriptBlockTypeImpl
