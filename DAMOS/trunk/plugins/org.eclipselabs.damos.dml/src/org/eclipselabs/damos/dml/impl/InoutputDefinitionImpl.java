/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.InoutputDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Inoutput Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl#getMinimumPortCount <em>Minimum Port Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl#getMaximumPortCount <em>Maximum Port Count</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl#isManyPorts <em>Many Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.impl.InoutputDefinitionImpl#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class InoutputDefinitionImpl extends ParameterableElementImpl implements InoutputDefinition {
	/**
	 * The default value of the '{@link #getMinimumPortCount() <em>Minimum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumPortCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MINIMUM_PORT_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMinimumPortCount() <em>Minimum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinimumPortCount()
	 * @generated
	 * @ordered
	 */
	protected int minimumPortCount = MINIMUM_PORT_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaximumPortCount() <em>Maximum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumPortCount()
	 * @generated
	 * @ordered
	 */
	protected static final int MAXIMUM_PORT_COUNT_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getMaximumPortCount() <em>Maximum Port Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaximumPortCount()
	 * @generated
	 * @ordered
	 */
	protected int maximumPortCount = MAXIMUM_PORT_COUNT_EDEFAULT;

	/**
	 * The default value of the '{@link #isManyPorts() <em>Many Ports</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isManyPorts()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANY_PORTS_EDEFAULT = false;

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
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataTypeSpecification dataType;

	/**
	 * This is true if the Data Type containment reference has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean dataTypeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InoutputDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DMLPackage.Literals.INOUTPUT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMinimumPortCount() {
		return minimumPortCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMinimumPortCount(int newMinimumPortCount) {
		int oldMinimumPortCount = minimumPortCount;
		minimumPortCount = newMinimumPortCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT, oldMinimumPortCount, minimumPortCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaximumPortCount() {
		return maximumPortCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaximumPortCount(int newMaximumPortCount) {
		int oldMaximumPortCount = maximumPortCount;
		maximumPortCount = newMaximumPortCount;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT, oldMaximumPortCount, maximumPortCount));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isManyPorts() {
		 int maximumPortCount = getMaximumPortCount();
         return maximumPortCount > 1 || maximumPortCount == -1;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.INOUTPUT_DEFINITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeSpecification getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataType(DataTypeSpecification newDataType, NotificationChain msgs) {
		DataTypeSpecification oldDataType = dataType;
		dataType = newDataType;
		boolean oldDataTypeESet = dataTypeESet;
		dataTypeESet = true;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE, oldDataType, newDataType, !oldDataTypeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataTypeSpecification newDataType) {
		if (newDataType != dataType) {
			NotificationChain msgs = null;
			if (dataType != null)
				msgs = ((InternalEObject)dataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE, null, msgs);
			if (newDataType != null)
				msgs = ((InternalEObject)newDataType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE, null, msgs);
			msgs = basicSetDataType(newDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldDataTypeESet = dataTypeESet;
			dataTypeESet = true;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET, DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE, newDataType, newDataType, !oldDataTypeESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicUnsetDataType(NotificationChain msgs) {
		DataTypeSpecification oldDataType = dataType;
		dataType = null;
		boolean oldDataTypeESet = dataTypeESet;
		dataTypeESet = false;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.UNSET, DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE, oldDataType, null, oldDataTypeESet);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetDataType() {
		if (dataType != null) {
			NotificationChain msgs = null;
			msgs = ((InternalEObject)dataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE, null, msgs);
			msgs = basicUnsetDataType(msgs);
			if (msgs != null) msgs.dispatch();
		}
		else {
			boolean oldDataTypeESet = dataTypeESet;
			dataTypeESet = false;
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.UNSET, DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE, null, null, oldDataTypeESet));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetDataType() {
		return dataTypeESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE:
				return basicUnsetDataType(msgs);
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
			case DMLPackage.INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT:
				return getMinimumPortCount();
			case DMLPackage.INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT:
				return getMaximumPortCount();
			case DMLPackage.INOUTPUT_DEFINITION__MANY_PORTS:
				return isManyPorts();
			case DMLPackage.INOUTPUT_DEFINITION__NAME:
				return getName();
			case DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE:
				return getDataType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DMLPackage.INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT:
				setMinimumPortCount((Integer)newValue);
				return;
			case DMLPackage.INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT:
				setMaximumPortCount((Integer)newValue);
				return;
			case DMLPackage.INOUTPUT_DEFINITION__NAME:
				setName((String)newValue);
				return;
			case DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE:
				setDataType((DataTypeSpecification)newValue);
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
			case DMLPackage.INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT:
				setMinimumPortCount(MINIMUM_PORT_COUNT_EDEFAULT);
				return;
			case DMLPackage.INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT:
				setMaximumPortCount(MAXIMUM_PORT_COUNT_EDEFAULT);
				return;
			case DMLPackage.INOUTPUT_DEFINITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE:
				unsetDataType();
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
			case DMLPackage.INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT:
				return minimumPortCount != MINIMUM_PORT_COUNT_EDEFAULT;
			case DMLPackage.INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT:
				return maximumPortCount != MAXIMUM_PORT_COUNT_EDEFAULT;
			case DMLPackage.INOUTPUT_DEFINITION__MANY_PORTS:
				return isManyPorts() != MANY_PORTS_EDEFAULT;
			case DMLPackage.INOUTPUT_DEFINITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DMLPackage.INOUTPUT_DEFINITION__DATA_TYPE:
				return isSetDataType();
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
		result.append(" (minimumPortCount: ");
		result.append(minimumPortCount);
		result.append(", maximumPortCount: ");
		result.append(maximumPortCount);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //InoutputDefinitionImpl
