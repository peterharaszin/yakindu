/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.semantic.blockdiagram.BlockCategory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Category</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl#getParents <em>Parents</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockCategoryImpl#getUriAsString <em>Uri As String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockCategoryImpl extends NamedElementImpl implements BlockCategory {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterDescriptor> parameters;

	/**
	 * The cached value of the '{@link #getParents() <em>Parents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParents()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockCategory> parents;

	/**
	 * The default value of the '{@link #getUri() <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUri()
	 * @generated
	 * @ordered
	 */
	protected static final URI URI_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getUriAsString() <em>Uri As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUriAsString()
	 * @generated
	 * @ordered
	 */
	protected static final String URI_AS_STRING_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockCategoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.BLOCK_CATEGORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDescriptor> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterDescriptor>(ParameterDescriptor.class, this, BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockCategory> getParents() {
		if (parents == null) {
			parents = new EObjectResolvingEList<BlockCategory>(BlockCategory.class, this, BlockDiagramPackage.BLOCK_CATEGORY__PARENTS);
		}
		return parents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public URI getUri() {
		return eResource().getURI();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUriAsString() {
		return getUri().toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean belongsTo(URI categoryURI) {
		for (BlockCategory parent : getParents()) {
			if (categoryURI.equals(parent.getUri()) || parent.belongsTo(categoryURI)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean belongsTo(String categoryURI) {
		return belongsTo(URI.createURI(categoryURI));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS:
				return getParameters();
			case BlockDiagramPackage.BLOCK_CATEGORY__PARENTS:
				return getParents();
			case BlockDiagramPackage.BLOCK_CATEGORY__URI:
				return getUri();
			case BlockDiagramPackage.BLOCK_CATEGORY__URI_AS_STRING:
				return getUriAsString();
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
			case BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterDescriptor>)newValue);
				return;
			case BlockDiagramPackage.BLOCK_CATEGORY__PARENTS:
				getParents().clear();
				getParents().addAll((Collection<? extends BlockCategory>)newValue);
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
			case BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS:
				getParameters().clear();
				return;
			case BlockDiagramPackage.BLOCK_CATEGORY__PARENTS:
				getParents().clear();
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
			case BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case BlockDiagramPackage.BLOCK_CATEGORY__PARENTS:
				return parents != null && !parents.isEmpty();
			case BlockDiagramPackage.BLOCK_CATEGORY__URI:
				return URI_EDEFAULT == null ? getUri() != null : !URI_EDEFAULT.equals(getUri());
			case BlockDiagramPackage.BLOCK_CATEGORY__URI_AS_STRING:
				return URI_AS_STRING_EDEFAULT == null ? getUriAsString() != null : !URI_AS_STRING_EDEFAULT.equals(getUriAsString());
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
		if (baseClass == ParameterDescriptorContainer.class) {
			switch (derivedFeatureID) {
				case BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS: return BlockDiagramPackage.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS;
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
		if (baseClass == ParameterDescriptorContainer.class) {
			switch (baseFeatureID) {
				case BlockDiagramPackage.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS: return BlockDiagramPackage.BLOCK_CATEGORY__PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //BlockCategoryImpl
