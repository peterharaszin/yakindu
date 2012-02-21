/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.CategorizedElement;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.INamedElement;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.QualifiedElement;
import org.eclipselabs.damos.dml.TimingKind;
import org.eclipselabs.damos.dml.internal.operations.BlockTypeOperations;
import org.eclipselabs.damos.dml.internal.operations.CategorizedElementOperations;
import org.eclipselabs.damos.dml.internal.operations.ParameterableElementOperations;
import org.eclipselabs.damos.dml.internal.operations.QualifiedElementOperations;
import org.eclipselabs.damos.dml.internal.util.URIUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getBelongingCategories <em>Belonging Categories</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getInputDefinitions <em>Input Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getOutputDefinitions <em>Output Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getTiming <em>Timing</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#isBoundary <em>Boundary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockTypeImpl extends EModelElementImpl implements BlockType {
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
	 * The default value of the '{@link #getTiming() <em>Timing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiming()
	 * @generated
	 * @ordered
	 */
	protected static final TimingKind TIMING_EDEFAULT = TimingKind.ANY;

	/**
	 * The cached value of the '{@link #getTiming() <em>Timing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTiming()
	 * @generated
	 * @ordered
	 */
	protected TimingKind timing = TIMING_EDEFAULT;

	/**
	 * The default value of the '{@link #isBoundary() <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoundary()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOUNDARY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBoundary() <em>Boundary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBoundary()
	 * @generated
	 * @ordered
	 */
	protected boolean boundary = BOUNDARY_EDEFAULT;

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
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_TYPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_TYPE__PACKAGE_NAME, oldPackageName, packageName));
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
	public TimingKind getTiming() {
		return timing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTiming(TimingKind newTiming) {
		TimingKind oldTiming = timing;
		timing = newTiming == null ? TIMING_EDEFAULT : newTiming;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_TYPE__TIMING, oldTiming, timing));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBoundary() {
		return boundary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBoundary(boolean newBoundary) {
		boolean oldBoundary = boundary;
		boundary = newBoundary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_TYPE__BOUNDARY, oldBoundary, boundary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean belongsTo(String categoryName) {
		return CategorizedElementOperations.belongsTo(this, categoryName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Parameter getParameter(String name) {
		return ParameterableElementOperations.getParameter(this, name);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
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
			case DMLPackage.BLOCK_TYPE__QUALIFIED_NAME:
				return getQualifiedName();
			case DMLPackage.BLOCK_TYPE__NAME:
				return getName();
			case DMLPackage.BLOCK_TYPE__PACKAGE_NAME:
				return getPackageName();
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				return getBelongingCategories();
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				return getParameters();
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				return getInputDefinitions();
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				return getOutputDefinitions();
			case DMLPackage.BLOCK_TYPE__TIMING:
				return getTiming();
			case DMLPackage.BLOCK_TYPE__BOUNDARY:
				return isBoundary();
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
			case DMLPackage.BLOCK_TYPE__QUALIFIED_NAME:
				setQualifiedName((String)newValue);
				return;
			case DMLPackage.BLOCK_TYPE__NAME:
				setName((String)newValue);
				return;
			case DMLPackage.BLOCK_TYPE__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
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
			case DMLPackage.BLOCK_TYPE__TIMING:
				setTiming((TimingKind)newValue);
				return;
			case DMLPackage.BLOCK_TYPE__BOUNDARY:
				setBoundary((Boolean)newValue);
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
			case DMLPackage.BLOCK_TYPE__QUALIFIED_NAME:
				setQualifiedName(QUALIFIED_NAME_EDEFAULT);
				return;
			case DMLPackage.BLOCK_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DMLPackage.BLOCK_TYPE__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
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
			case DMLPackage.BLOCK_TYPE__TIMING:
				setTiming(TIMING_EDEFAULT);
				return;
			case DMLPackage.BLOCK_TYPE__BOUNDARY:
				setBoundary(BOUNDARY_EDEFAULT);
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
			case DMLPackage.BLOCK_TYPE__QUALIFIED_NAME:
				return QUALIFIED_NAME_EDEFAULT == null ? getQualifiedName() != null : !QUALIFIED_NAME_EDEFAULT.equals(getQualifiedName());
			case DMLPackage.BLOCK_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DMLPackage.BLOCK_TYPE__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				return belongingCategories != null && !belongingCategories.isEmpty();
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				return inputDefinitions != null && !inputDefinitions.isEmpty();
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				return outputDefinitions != null && !outputDefinitions.isEmpty();
			case DMLPackage.BLOCK_TYPE__TIMING:
				return timing != TIMING_EDEFAULT;
			case DMLPackage.BLOCK_TYPE__BOUNDARY:
				return boundary != BOUNDARY_EDEFAULT;
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
				case DMLPackage.BLOCK_TYPE__QUALIFIED_NAME: return DMLPackage.QUALIFIED_ELEMENT__QUALIFIED_NAME;
				case DMLPackage.BLOCK_TYPE__NAME: return DMLPackage.QUALIFIED_ELEMENT__NAME;
				case DMLPackage.BLOCK_TYPE__PACKAGE_NAME: return DMLPackage.QUALIFIED_ELEMENT__PACKAGE_NAME;
				default: return -1;
			}
		}
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
		if (baseClass == INamedElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == QualifiedElement.class) {
			switch (baseFeatureID) {
				case DMLPackage.QUALIFIED_ELEMENT__QUALIFIED_NAME: return DMLPackage.BLOCK_TYPE__QUALIFIED_NAME;
				case DMLPackage.QUALIFIED_ELEMENT__NAME: return DMLPackage.BLOCK_TYPE__NAME;
				case DMLPackage.QUALIFIED_ELEMENT__PACKAGE_NAME: return DMLPackage.BLOCK_TYPE__PACKAGE_NAME;
				default: return -1;
			}
		}
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
		result.append(", timing: ");
		result.append(timing);
		result.append(", boundary: ");
		result.append(boundary);
		result.append(')');
		return result.toString();
	}

	@Override
	public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
		EObject eObject = URIUtil.eObjectForURIFragmentSegment(this, uriFragmentSegment);
		return eObject != null ? eObject : super.eObjectForURIFragmentSegment(uriFragmentSegment);
	}
	
	@Override
	public String eURIFragmentSegment(EStructuralFeature eStructuralFeature, EObject eObject) {
		String fragmentSegment = URIUtil.eURIFragmentSegment(eStructuralFeature, eObject);
		return fragmentSegment != null ? fragmentSegment : super.eURIFragmentSegment(eStructuralFeature, eObject);
	}

} //BlockTypeImpl
