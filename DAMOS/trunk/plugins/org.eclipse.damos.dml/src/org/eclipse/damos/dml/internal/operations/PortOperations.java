/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Port;
import org.eclipse.damos.dml.internal.util.CrossReferencerUtil;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Port</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Port#getIndex() <em>Get Index</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.Port#getComponent() <em>Get Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  int getIndex(Port port) {
		return DMLUtil.indexOf(port);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Component getComponent(Port port) {
		EObject container = port.eContainer();
		while (!(container instanceof Component) && container != null) {
			container = container.eContainer();
		}
		return (Component) container;
	}

	protected static EList<Connection> getConnections(Port port, EReference reference) {
		EList<Connection> connections = new UniqueEList.FastCompare<Connection>();
		for (EStructuralFeature.Setting inverseReference : CrossReferencerUtil.getInverseReferences(port)) {
			if ((reference == null && (
					inverseReference.getEStructuralFeature() == DMLPackage.eINSTANCE.getConnection_Source() ||
					inverseReference.getEStructuralFeature() == DMLPackage.eINSTANCE.getConnection_Target()))
					|| inverseReference.getEStructuralFeature() == reference) {
				EObject referenceEObject = inverseReference.getEObject();
				if (referenceEObject instanceof Connection && referenceEObject.eContainer() != null) {
					Connection connection = (Connection) referenceEObject;
					if (connection.getSource() == port || connection.getTarget() == port) {
						connections.add(connection);
					}
				}
			}
		}
		return connections;
	}
	
} // PortOperations