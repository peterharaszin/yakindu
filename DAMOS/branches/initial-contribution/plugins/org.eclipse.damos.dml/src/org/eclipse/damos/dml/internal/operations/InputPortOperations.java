/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Input Port</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.InputPort#getIncomingConnections() <em>Get Incoming Connections</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.InputPort#getIncomingConnection(org.eclipse.damos.dml.Fragment) <em>Get Incoming Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputPortOperations extends PortOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputPortOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<Connection> getIncomingConnections(InputPort inputPort) {
		return getConnections(inputPort, DMLPackage.eINSTANCE.getConnection_Target());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Connection getIncomingConnection(InputPort inputPort, Fragment context) {
		do {
			for (Connection connection : context.getConnections()) {
				if (connection.getTarget() == inputPort) {
					return connection;
				}
			}
			context = context.getParent();
		} while (context != null);

		return null;
	}

} // InputPortOperations