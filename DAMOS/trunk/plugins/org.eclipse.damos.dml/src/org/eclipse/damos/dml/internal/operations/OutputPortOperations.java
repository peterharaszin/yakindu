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
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.BasicInternalEList;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Output Port</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.OutputPort#getOutgoingConnections() <em>Get Outgoing Connections</em>}</li>
 *   <li>{@link org.eclipse.damos.dml.OutputPort#getOutgoingConnections(org.eclipse.damos.dml.Fragment) <em>Get Outgoing Connections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputPortOperations extends PortOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OutputPortOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<Connection> getOutgoingConnections(OutputPort outputPort) {
		return getConnections(outputPort, DMLPackage.eINSTANCE.getConnection_Source());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<Connection> getOutgoingConnections(OutputPort outputPort, Fragment context) {
		EList<Connection> connections = new BasicInternalEList<Connection>(Connection.class);

		do {
			for (Connection connection : context.getConnections()) {
				if (connection.getSource() == outputPort) {
					connections.add(connection);
				}
			}
			context = context.getParent();
		} while (context != null);
		
		return connections;
	}

} // OutputPortOperations