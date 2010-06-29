/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.semantic.blockdiagram.BlockCategory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.BlockType;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#getUri <em>Uri</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#getUriAsString <em>Uri As String</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.BlockTypeImpl#isStructural <em>Structural</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockTypeImpl extends NamedElementImpl implements BlockType {
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
	 * The cached value of the '{@link #getInputs() <em>Inputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<InputSpecification> inputs;

	/**
	 * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputSpecification> outputs;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<BlockCategory> categories;

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
	 * The default value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VIRTUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVirtual() <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVirtual()
	 * @generated
	 * @ordered
	 */
	protected boolean virtual = VIRTUAL_EDEFAULT;

	/**
	 * The default value of the '{@link #isStructural() <em>Structural</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStructural()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STRUCTURAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStructural() <em>Structural</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStructural()
	 * @generated
	 * @ordered
	 */
	protected boolean structural = STRUCTURAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.BLOCK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDescriptor> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterDescriptor>(ParameterDescriptor.class, this, BlockDiagramPackage.BLOCK_TYPE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BlockCategory> getCategories() {
		if (categories == null) {
			categories = new EObjectResolvingEList<BlockCategory>(BlockCategory.class, this, BlockDiagramPackage.BLOCK_TYPE__CATEGORIES);
		}
		return categories;
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
	 * @generated
	 */
	public boolean isVirtual() {
		return virtual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVirtual(boolean newVirtual) {
		boolean oldVirtual = virtual;
		virtual = newVirtual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.BLOCK_TYPE__VIRTUAL, oldVirtual, virtual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStructural() {
		return structural;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStructural(boolean newStructural) {
		boolean oldStructural = structural;
		structural = newStructural;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.BLOCK_TYPE__STRUCTURAL, oldStructural, structural));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean belongsTo(URI categoryURI) {
		for (BlockCategory category : getCategories()) {
			if (categoryURI.equals(category.getUri()) || category.belongsTo(categoryURI)) {
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
	public EList<InputSpecification> getInputs() {
		if (inputs == null) {
			inputs = new EObjectContainmentEList<InputSpecification>(InputSpecification.class, this, BlockDiagramPackage.BLOCK_TYPE__INPUTS);
		}
		return inputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputSpecification> getOutputs() {
		if (outputs == null) {
			outputs = new EObjectContainmentEList<OutputSpecification>(OutputSpecification.class, this, BlockDiagramPackage.BLOCK_TYPE__OUTPUTS);
		}
		return outputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.BLOCK_TYPE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK_TYPE__INPUTS:
				return ((InternalEList<?>)getInputs()).basicRemove(otherEnd, msgs);
			case BlockDiagramPackage.BLOCK_TYPE__OUTPUTS:
				return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
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
			case BlockDiagramPackage.BLOCK_TYPE__PARAMETERS:
				return getParameters();
			case BlockDiagramPackage.BLOCK_TYPE__INPUTS:
				return getInputs();
			case BlockDiagramPackage.BLOCK_TYPE__OUTPUTS:
				return getOutputs();
			case BlockDiagramPackage.BLOCK_TYPE__CATEGORIES:
				return getCategories();
			case BlockDiagramPackage.BLOCK_TYPE__URI:
				return getUri();
			case BlockDiagramPackage.BLOCK_TYPE__URI_AS_STRING:
				return getUriAsString();
			case BlockDiagramPackage.BLOCK_TYPE__VIRTUAL:
				return isVirtual();
			case BlockDiagramPackage.BLOCK_TYPE__STRUCTURAL:
				return isStructural();
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
			case BlockDiagramPackage.BLOCK_TYPE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterDescriptor>)newValue);
				return;
			case BlockDiagramPackage.BLOCK_TYPE__INPUTS:
				getInputs().clear();
				getInputs().addAll((Collection<? extends InputSpecification>)newValue);
				return;
			case BlockDiagramPackage.BLOCK_TYPE__OUTPUTS:
				getOutputs().clear();
				getOutputs().addAll((Collection<? extends OutputSpecification>)newValue);
				return;
			case BlockDiagramPackage.BLOCK_TYPE__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends BlockCategory>)newValue);
				return;
			case BlockDiagramPackage.BLOCK_TYPE__VIRTUAL:
				setVirtual((Boolean)newValue);
				return;
			case BlockDiagramPackage.BLOCK_TYPE__STRUCTURAL:
				setStructural((Boolean)newValue);
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
			case BlockDiagramPackage.BLOCK_TYPE__PARAMETERS:
				getParameters().clear();
				return;
			case BlockDiagramPackage.BLOCK_TYPE__INPUTS:
				getInputs().clear();
				return;
			case BlockDiagramPackage.BLOCK_TYPE__OUTPUTS:
				getOutputs().clear();
				return;
			case BlockDiagramPackage.BLOCK_TYPE__CATEGORIES:
				getCategories().clear();
				return;
			case BlockDiagramPackage.BLOCK_TYPE__VIRTUAL:
				setVirtual(VIRTUAL_EDEFAULT);
				return;
			case BlockDiagramPackage.BLOCK_TYPE__STRUCTURAL:
				setStructural(STRUCTURAL_EDEFAULT);
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
			case BlockDiagramPackage.BLOCK_TYPE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case BlockDiagramPackage.BLOCK_TYPE__INPUTS:
				return inputs != null && !inputs.isEmpty();
			case BlockDiagramPackage.BLOCK_TYPE__OUTPUTS:
				return outputs != null && !outputs.isEmpty();
			case BlockDiagramPackage.BLOCK_TYPE__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case BlockDiagramPackage.BLOCK_TYPE__URI:
				return URI_EDEFAULT == null ? getUri() != null : !URI_EDEFAULT.equals(getUri());
			case BlockDiagramPackage.BLOCK_TYPE__URI_AS_STRING:
				return URI_AS_STRING_EDEFAULT == null ? getUriAsString() != null : !URI_AS_STRING_EDEFAULT.equals(getUriAsString());
			case BlockDiagramPackage.BLOCK_TYPE__VIRTUAL:
				return virtual != VIRTUAL_EDEFAULT;
			case BlockDiagramPackage.BLOCK_TYPE__STRUCTURAL:
				return structural != STRUCTURAL_EDEFAULT;
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
				case BlockDiagramPackage.BLOCK_TYPE__PARAMETERS: return BlockDiagramPackage.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS;
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
				case BlockDiagramPackage.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS: return BlockDiagramPackage.BLOCK_TYPE__PARAMETERS;
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
		result.append(" (virtual: ");
		result.append(virtual);
		result.append(", structural: ");
		result.append(structural);
		result.append(')');
		return result.toString();
	}

} //BlockTypeImpl
