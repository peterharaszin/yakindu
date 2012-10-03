/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.execution.impl;

import java.util.Collection;

import org.eclipse.damos.execution.DataFlow;
import org.eclipse.damos.execution.DataFlowSourceEnd;
import org.eclipse.damos.execution.DataFlowTargetEnd;
import org.eclipse.damos.execution.ExecutionPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.damos.execution.impl.DataFlowImpl#getTargetEnds <em>Target Ends</em>}</li>
 *   <li>{@link org.eclipse.damos.execution.impl.DataFlowImpl#getSourceEnd <em>Source End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataFlowImpl extends EObjectImpl implements DataFlow {
	/**
	 * The cached value of the '{@link #getTargetEnds() <em>Target Ends</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEnds()
	 * @generated
	 * @ordered
	 */
	protected EList<DataFlowTargetEnd> targetEnds;
	/**
	 * The cached value of the '{@link #getSourceEnd() <em>Source End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceEnd()
	 * @generated
	 * @ordered
	 */
	protected DataFlowSourceEnd sourceEnd;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionPackage.Literals.DATA_FLOW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataFlowSourceEnd getSourceEnd() {
		return sourceEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourceEnd(DataFlowSourceEnd newSourceEnd, NotificationChain msgs) {
		DataFlowSourceEnd oldSourceEnd = sourceEnd;
		sourceEnd = newSourceEnd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW__SOURCE_END, oldSourceEnd, newSourceEnd);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceEnd(DataFlowSourceEnd newSourceEnd) {
		if (newSourceEnd != sourceEnd) {
			NotificationChain msgs = null;
			if (sourceEnd != null)
				msgs = ((InternalEObject)sourceEnd).eInverseRemove(this, ExecutionPackage.DATA_FLOW_SOURCE_END__DATA_FLOW, DataFlowSourceEnd.class, msgs);
			if (newSourceEnd != null)
				msgs = ((InternalEObject)newSourceEnd).eInverseAdd(this, ExecutionPackage.DATA_FLOW_SOURCE_END__DATA_FLOW, DataFlowSourceEnd.class, msgs);
			msgs = basicSetSourceEnd(newSourceEnd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionPackage.DATA_FLOW__SOURCE_END, newSourceEnd, newSourceEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionPackage.DATA_FLOW__TARGET_ENDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTargetEnds()).basicAdd(otherEnd, msgs);
			case ExecutionPackage.DATA_FLOW__SOURCE_END:
				if (sourceEnd != null)
					msgs = ((InternalEObject)sourceEnd).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExecutionPackage.DATA_FLOW__SOURCE_END, null, msgs);
				return basicSetSourceEnd((DataFlowSourceEnd)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataFlowTargetEnd> getTargetEnds() {
		if (targetEnds == null) {
			targetEnds = new EObjectContainmentWithInverseEList<DataFlowTargetEnd>(DataFlowTargetEnd.class, this, ExecutionPackage.DATA_FLOW__TARGET_ENDS, ExecutionPackage.DATA_FLOW_TARGET_END__DATA_FLOW);
		}
		return targetEnds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionPackage.DATA_FLOW__TARGET_ENDS:
				return ((InternalEList<?>)getTargetEnds()).basicRemove(otherEnd, msgs);
			case ExecutionPackage.DATA_FLOW__SOURCE_END:
				return basicSetSourceEnd(null, msgs);
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
			case ExecutionPackage.DATA_FLOW__TARGET_ENDS:
				return getTargetEnds();
			case ExecutionPackage.DATA_FLOW__SOURCE_END:
				return getSourceEnd();
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
			case ExecutionPackage.DATA_FLOW__TARGET_ENDS:
				getTargetEnds().clear();
				getTargetEnds().addAll((Collection<? extends DataFlowTargetEnd>)newValue);
				return;
			case ExecutionPackage.DATA_FLOW__SOURCE_END:
				setSourceEnd((DataFlowSourceEnd)newValue);
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
			case ExecutionPackage.DATA_FLOW__TARGET_ENDS:
				getTargetEnds().clear();
				return;
			case ExecutionPackage.DATA_FLOW__SOURCE_END:
				setSourceEnd((DataFlowSourceEnd)null);
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
			case ExecutionPackage.DATA_FLOW__TARGET_ENDS:
				return targetEnds != null && !targetEnds.isEmpty();
			case ExecutionPackage.DATA_FLOW__SOURCE_END:
				return sourceEnd != null;
		}
		return super.eIsSet(featureID);
	}

} //DataFlowImpl
