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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.damos.dml.BehaviorSpecification;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getBelongingCategories <em>Belonging Categories</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getInputDefinitions <em>Input Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getOutputDefinitions <em>Output Definitions</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getBehavior <em>Behavior</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.BlockTypeImpl#getTiming <em>Timing</em>}</li>
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
	 * The cached value of the '{@link #getQualifiedName() <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedName = QUALIFIED_NAME_EDEFAULT;

	/**
	 * This is true if the Qualified Name attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean qualifiedNameESet;

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
	 * The default value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIER_EDEFAULT = null;

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
	 * The cached value of the '{@link #getBehavior() <em>Behavior</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehavior()
	 * @generated
	 * @ordered
	 */
	protected BehaviorSpecification behavior;

	/**
	 * This is true if the Behavior containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean behaviorESet;

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
		boolean oldQualifiedNameESet = qualifiedNameESet;
		qualifiedNameESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_TYPE__QUALIFIED_NAME, oldQualifiedName, qualifiedName, !oldQualifiedNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetQualifiedName() {
		String oldQualifiedName = qualifiedName;
		boolean oldQualifiedNameESet = qualifiedNameESet;
		qualifiedName = QUALIFIED_NAME_EDEFAULT;
		qualifiedNameESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, DMLPackage.BLOCK_TYPE__QUALIFIED_NAME, oldQualifiedName, QUALIFIED_NAME_EDEFAULT, oldQualifiedNameESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetQualifiedName() {
		return qualifiedNameESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getName() {
		return QualifiedElementOperations.getName(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getQualifier() {
		return QualifiedElementOperations.getQualifier(this);
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
	public BehaviorSpecification getBehavior() {
		return behavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBehavior(BehaviorSpecification newBehavior, NotificationChain msgs) {
		BehaviorSpecification oldBehavior = behavior;
		behavior = newBehavior;
		boolean oldBehaviorESet = behaviorESet;
		behaviorESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_TYPE__BEHAVIOR, oldBehavior, newBehavior, !oldBehaviorESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehavior(BehaviorSpecification newBehavior) {
		if (newBehavior != behavior) {
			NotificationChain msgs = null;
			if (behavior != null)
				msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.BLOCK_TYPE__BEHAVIOR, null, msgs);
			if (newBehavior != null)
				msgs = ((InternalEObject)newBehavior).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.BLOCK_TYPE__BEHAVIOR, null, msgs);
			msgs = basicSetBehavior(newBehavior, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldBehaviorESet = behaviorESet;
			behaviorESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.BLOCK_TYPE__BEHAVIOR, newBehavior, newBehavior, !oldBehaviorESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetBehavior(NotificationChain msgs) {
		BehaviorSpecification oldBehavior = behavior;
		behavior = null;
		boolean oldBehaviorESet = behaviorESet;
		behaviorESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, DMLPackage.BLOCK_TYPE__BEHAVIOR, oldBehavior, null, oldBehaviorESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetBehavior() {
		if (behavior != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)behavior).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.BLOCK_TYPE__BEHAVIOR, null, msgs);
			msgs = basicUnsetBehavior(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldBehaviorESet = behaviorESet;
			behaviorESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, DMLPackage.BLOCK_TYPE__BEHAVIOR, null, null, oldBehaviorESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetBehavior() {
		return behaviorESet;
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
			case DMLPackage.BLOCK_TYPE__BEHAVIOR:
				return basicUnsetBehavior(msgs);
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
			case DMLPackage.BLOCK_TYPE__QUALIFIER:
				return getQualifier();
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				return getBelongingCategories();
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				return getParameters();
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				return getInputDefinitions();
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				return getOutputDefinitions();
			case DMLPackage.BLOCK_TYPE__BEHAVIOR:
				return getBehavior();
			case DMLPackage.BLOCK_TYPE__TIMING:
				return getTiming();
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
			case DMLPackage.BLOCK_TYPE__BEHAVIOR:
				setBehavior((BehaviorSpecification)newValue);
				return;
			case DMLPackage.BLOCK_TYPE__TIMING:
				setTiming((TimingKind)newValue);
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
				unsetQualifiedName();
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
			case DMLPackage.BLOCK_TYPE__BEHAVIOR:
				unsetBehavior();
				return;
			case DMLPackage.BLOCK_TYPE__TIMING:
				setTiming(TIMING_EDEFAULT);
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
				return isSetQualifiedName();
			case DMLPackage.BLOCK_TYPE__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case DMLPackage.BLOCK_TYPE__QUALIFIER:
				return QUALIFIER_EDEFAULT == null ? getQualifier() != null : !QUALIFIER_EDEFAULT.equals(getQualifier());
			case DMLPackage.BLOCK_TYPE__BELONGING_CATEGORIES:
				return belongingCategories != null && !belongingCategories.isEmpty();
			case DMLPackage.BLOCK_TYPE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case DMLPackage.BLOCK_TYPE__INPUT_DEFINITIONS:
				return inputDefinitions != null && !inputDefinitions.isEmpty();
			case DMLPackage.BLOCK_TYPE__OUTPUT_DEFINITIONS:
				return outputDefinitions != null && !outputDefinitions.isEmpty();
			case DMLPackage.BLOCK_TYPE__BEHAVIOR:
				return isSetBehavior();
			case DMLPackage.BLOCK_TYPE__TIMING:
				return timing != TIMING_EDEFAULT;
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
				case DMLPackage.BLOCK_TYPE__QUALIFIER: return DMLPackage.QUALIFIED_ELEMENT__QUALIFIER;
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
				case DMLPackage.QUALIFIED_ELEMENT__QUALIFIER: return DMLPackage.BLOCK_TYPE__QUALIFIER;
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
		result.append(" (qualifiedName: ");
		if (qualifiedNameESet) result.append(qualifiedName); else result.append("<unset>");
		result.append(", timing: ");
		result.append(timing);
		result.append(')');
		return result.toString();
	}

} //BlockTypeImpl
