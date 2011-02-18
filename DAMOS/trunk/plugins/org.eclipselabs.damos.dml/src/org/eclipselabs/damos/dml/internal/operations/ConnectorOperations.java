/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.internal.operations;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.internal.util.CrossReferencerUtil;

public class ConnectorOperations {

	public static EList<Connection> getConnections(Connector connector) {
		EList<Connection> connections = new UniqueEList.FastCompare<Connection>();
		Collection<Setting> references = CrossReferencerUtil.getNonNavigableInverseReferences(connector);
		for (EStructuralFeature.Setting reference : references) {
			EStructuralFeature feature = reference.getEStructuralFeature();
			if (feature == DMLPackage.eINSTANCE.getConnection_Source()
					|| feature == DMLPackage.eINSTANCE.getConnection_Target()) {
				EObject referenceEObject = reference.getEObject();
				if (referenceEObject instanceof Connection && referenceEObject.eContainer() != null) {
					connections.add((Connection) referenceEObject);
				}
			}
		}
		return connections;
	}
	
	public static EList<Connection> getConnections(Connector connector, Fragment context) {
		EList<Connection> connections = new BasicInternalEList<Connection>(Connection.class);

		do {
			for (Connection connection : context.getConnections()) {
				if (connection.getSource() == connector || connection.getTarget() == connector) {
					connections.add(connection);
				}
			}
			context = context.getParent();
		} while (context != null);
		
		return connections;
	}

	public static Connection getFirstConnection(Connector connector, Fragment context) {
		do {
			for (Connection connection : context.getConnections()) {
				if (connection.getSource() == connector || connection.getTarget() == connector) {
					return connection;
				}
			}
			context = context.getParent();
		} while (context != null);

		return null;
	}

} // PortOperations