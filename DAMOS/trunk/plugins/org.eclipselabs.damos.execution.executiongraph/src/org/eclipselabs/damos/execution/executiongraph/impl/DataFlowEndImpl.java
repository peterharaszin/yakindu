/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.execution.executiongraph.DataFlowEnd;
import org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Flow End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowEndImpl#getInoutputIndex <em>Inoutput Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.impl.DataFlowEndImpl#getPortIndex <em>Port Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DataFlowEndImpl extends EObjectImpl implements DataFlowEnd {
	/**
	 * The default value of the '{@link #getInoutputIndex() <em>Inoutput Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoutputIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INOUTPUT_INDEX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getInoutputIndex() <em>Inoutput Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInoutputIndex()
	 * @generated
	 * @ordered
	 */
	protected int inoutputIndex = INOUTPUT_INDEX_EDEFAULT;
	/**
	 * The default value of the '{@link #getPortIndex() <em>Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int PORT_INDEX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getPortIndex() <em>Port Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortIndex()
	 * @generated
	 * @ordered
	 */
	protected int portIndex = PORT_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataFlowEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExecutionGraphPackage.Literals.DATA_FLOW_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInoutputIndex() {
		return inoutputIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getPortIndex() {
		return portIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionGraphPackage.DATA_FLOW_END__INOUTPUT_INDEX:
				return getInoutputIndex();
			case ExecutionGraphPackage.DATA_FLOW_END__PORT_INDEX:
				return getPortIndex();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExecutionGraphPackage.DATA_FLOW_END__INOUTPUT_INDEX:
				return inoutputIndex != INOUTPUT_INDEX_EDEFAULT;
			case ExecutionGraphPackage.DATA_FLOW_END__PORT_INDEX:
				return portIndex != PORT_INDEX_EDEFAULT;
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
		result.append(" (inoutputIndex: ");
		result.append(inoutputIndex);
		result.append(", portIndex: ");
		result.append(portIndex);
		result.append(')');
		return result.toString();
	}

} //DataFlowEndImpl
