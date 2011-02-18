/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.OutputPort;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Output Port</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.OutputPort#getOutgoingConnections() <em>Get Outgoing Connections</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.OutputPort#getOutgoingConnections(org.eclipselabs.damos.dml.Fragment) <em>Get Outgoing Connections</em>}</li>
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