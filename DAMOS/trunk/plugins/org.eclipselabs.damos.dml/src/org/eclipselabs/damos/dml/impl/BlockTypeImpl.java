/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.CategorizedElement;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.internal.operations.BlockTypeOperations;
import org.eclipselabs.damos.dml.internal.operations.CategorizedElementOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getBelongingCategories <em>Belonging Categories</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getInputDefinitions <em>Input Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getOutputDefinitions <em>Output Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockTypeImpl extends QualifiedElementImpl implements BlockType {
	/**
	 * The cached value of the '{@link #getBelongingCategories() <em>Belonging Categories</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBelongingCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> belongingCategories;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getInputDefinitions() <em>Input Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<InputDefinition> inputDefinitions;

	/**
	 * The cached value of the '{@link #getOutputDefinitions() <em>Output Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<OutputDefinition> outputDefinitions;

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
		return DMLPackage.Literals.BLOCK_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Category> getBelongingCategories() {
		if (belongingCategories == null) {
			belongingCategories = new EObjectResolvingEList<Category>(Category.class, this, DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES);
		}
		return belongingCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, DMLPackage.BLOCK_TYPE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InputDefinition> getInputDefinitions() {
		if (inputDefinitions == null) {
			inputDefinitions = new EObjectContainmentEList<InputDefinition>(InputDefinition.class, this, DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS);
		}
		return inputDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<OutputDefinition> getOutputDefinitions() {
		if (outputDefinitions == null) {
			outputDefinitions = new EObjectContainmentEList<OutputDefinition>(OutputDefinition.class, this, DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS);
		}
		return outputDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean belongsTo(String categoryName) {
		return CategorizedElementOperations.belongsTo(this, categoryName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block newInstance(String name) {
		return BlockTypeOperations.newInstance(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				return ((InternalEList<?>)getInputDefinitions()).basicRemove(otherEnd, msgs);
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				return ((InternalEList<?>)getOutputDefinitions()).basicRemove(otherEnd, msgs);
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
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				return getBelongingCategories();
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				return getParameters();
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				return getInputDefinitions();
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				return getOutputDefinitions();
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
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				getBelongingCategories().clear();
				getBelongingCategories().addAll((Collection<? extends Category>)newValue);
				return;
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				getInputDefinitions().clear();
				getInputDefinitions().addAll((Collection<? extends InputDefinition>)newValue);
				return;
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				getOutputDefinitions().clear();
				getOutputDefinitions().addAll((Collection<? extends OutputDefinition>)newValue);
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
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				getBelongingCategories().clear();
				return;
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				getParameters().clear();
				return;
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				getInputDefinitions().clear();
				return;
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				getOutputDefinitions().clear();
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
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				return belongingCategories != null && !belongingCategories.isEmpty();
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				return inputDefinitions != null && !inputDefinitions.isEmpty();
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				return outputDefinitions != null && !outputDefinitions.isEmpty();
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
		if (baseClass == CategorizedElement.class) {
			switch (derivedFeatureID) {
				case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES: return DMLPackage.CATEGORIZED_ELEMENT__BELONGING_CATEGORIES;
				default: return -1;
			}
		}
		if (baseClass == ParameterableElement.class) {
			switch (derivedFeatureID) {
				case DMLPackage.BLOCK_TYPE__PARAMETERS: return DMLPackage.PARAMETERABLE_ELEMENT__PARAMETERS;
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
		if (baseClass == CategorizedElement.class) {
			switch (baseFeatureID) {
				case DMLPackage.CATEGORIZED_ELEMENT__BELONGING_CATEGORIES: return DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES;
				default: return -1;
			}
		}
		if (baseClass == ParameterableElement.class) {
			switch (baseFeatureID) {
				case DMLPackage.PARAMETERABLE_ELEMENT__PARAMETERS: return DMLPackage.BLOCK_TYPE__PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //BlockTypeImpl
