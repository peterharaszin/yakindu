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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.IOSpecification;
import org.esmp.dsm.semantic.blockdiagram.IOType;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IO Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl#getMinimumPortCount <em>Minimum Port Count</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl#getMaximumPortCount <em>Maximum Port Count</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl#isManyPorts <em>Many Ports</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.impl.IOSpecificationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IOSpecificationImpl extends NamedElementImpl implements IOSpecification {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final IOType TYPE_EDEFAULT = IOType.SCALAR;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IOType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IOSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BlockDiagramPackage.Literals.IO_SPECIFICATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterDescriptor> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterDescriptor>(ParameterDescriptor.class, this, BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS);
		}
		return parameters;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.IO_SPECIFICATION__MINIMUM_PORT_COUNT, oldMinimumPortCount, minimumPortCount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.IO_SPECIFICATION__MAXIMUM_PORT_COUNT, oldMaximumPortCount, maximumPortCount));
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
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.IO_SPECIFICATION__VIRTUAL, oldVirtual, virtual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IOType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(IOType newType) {
		IOType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlockDiagramPackage.IO_SPECIFICATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS:
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
			case BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS:
				return getParameters();
			case BlockDiagramPackage.IO_SPECIFICATION__MINIMUM_PORT_COUNT:
				return getMinimumPortCount();
			case BlockDiagramPackage.IO_SPECIFICATION__MAXIMUM_PORT_COUNT:
				return getMaximumPortCount();
			case BlockDiagramPackage.IO_SPECIFICATION__MANY_PORTS:
				return isManyPorts();
			case BlockDiagramPackage.IO_SPECIFICATION__VIRTUAL:
				return isVirtual();
			case BlockDiagramPackage.IO_SPECIFICATION__TYPE:
				return getType();
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
			case BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterDescriptor>)newValue);
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__MINIMUM_PORT_COUNT:
				setMinimumPortCount((Integer)newValue);
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__MAXIMUM_PORT_COUNT:
				setMaximumPortCount((Integer)newValue);
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__VIRTUAL:
				setVirtual((Boolean)newValue);
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__TYPE:
				setType((IOType)newValue);
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
			case BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS:
				getParameters().clear();
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__MINIMUM_PORT_COUNT:
				setMinimumPortCount(MINIMUM_PORT_COUNT_EDEFAULT);
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__MAXIMUM_PORT_COUNT:
				setMaximumPortCount(MAXIMUM_PORT_COUNT_EDEFAULT);
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__VIRTUAL:
				setVirtual(VIRTUAL_EDEFAULT);
				return;
			case BlockDiagramPackage.IO_SPECIFICATION__TYPE:
				setType(TYPE_EDEFAULT);
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
			case BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case BlockDiagramPackage.IO_SPECIFICATION__MINIMUM_PORT_COUNT:
				return minimumPortCount != MINIMUM_PORT_COUNT_EDEFAULT;
			case BlockDiagramPackage.IO_SPECIFICATION__MAXIMUM_PORT_COUNT:
				return maximumPortCount != MAXIMUM_PORT_COUNT_EDEFAULT;
			case BlockDiagramPackage.IO_SPECIFICATION__MANY_PORTS:
				return isManyPorts() != MANY_PORTS_EDEFAULT;
			case BlockDiagramPackage.IO_SPECIFICATION__VIRTUAL:
				return virtual != VIRTUAL_EDEFAULT;
			case BlockDiagramPackage.IO_SPECIFICATION__TYPE:
				return type != TYPE_EDEFAULT;
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
				case BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS: return BlockDiagramPackage.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS;
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
				case BlockDiagramPackage.PARAMETER_DESCRIPTOR_CONTAINER__PARAMETERS: return BlockDiagramPackage.IO_SPECIFICATION__PARAMETERS;
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
		result.append(" (minimumPortCount: ");
		result.append(minimumPortCount);
		result.append(", maximumPortCount: ");
		result.append(maximumPortCount);
		result.append(", virtual: ");
		result.append(virtual);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //IOSpecificationImpl
