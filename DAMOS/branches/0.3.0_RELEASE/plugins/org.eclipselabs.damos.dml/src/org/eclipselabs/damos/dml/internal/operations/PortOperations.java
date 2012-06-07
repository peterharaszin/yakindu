/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.internal.util.CrossReferencerUtil;
import org.eclipselabs.damos.dml.util.DMLUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Port</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Port#getIndex() <em>Get Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Port#getComponent() <em>Get Component</em>}</li>
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

	protected static EList<Connection> getConnections(EObject eObject, EReference reference) {
		EList<Connection> connections = new UniqueEList.FastCompare<Connection>();
		for (EStructuralFeature.Setting nonNavigableInverseReference : CrossReferencerUtil.getNonNavigableInverseReferences(eObject)) {
			if ((reference == null && (
					nonNavigableInverseReference.getEStructuralFeature() == DMLPackage.eINSTANCE.getConnection_Source() ||
					nonNavigableInverseReference.getEStructuralFeature() == DMLPackage.eINSTANCE.getConnection_Target()))
					|| nonNavigableInverseReference.getEStructuralFeature() == reference) {
				EObject referenceEObject = nonNavigableInverseReference.getEObject();
				if (referenceEObject instanceof Connection && referenceEObject.eContainer() != null) {
					connections.add((Connection) referenceEObject);
				}
			}
		}
		return connections;
	}
	
} // PortOperations