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

package org.eclipselabs.damos.diagram.core.internal.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateRelationshipCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class CreateConnectionCommand extends CreateRelationshipCommand {
	
	public CreateConnectionCommand(CreateRelationshipRequest request) {
		super(request);
		setElementToEdit(request.getContainer());
	}

	protected EObject doDefaultElementCreation() {
		Connection connection = (Connection) EMFCoreUtil.create(
				getElementToEdit(), getContainmentFeature(), getElementType().getEClass());

		connection.setSource(getOutputConnector());
		connection.setTarget(getInputConnector());

		return connection;
	}
	
	public boolean canExecute() {
		if (getElementToEdit() instanceof Fragment) {
			if (getInputConnector() == null || getOutputConnector() == null) {
				return false;
			}
			if (canConnect()) {
				return super.canExecute();
			}
		}
		return false;
	}
	
	private boolean canConnect() {
		return DMLUtil.canConnectOutgoingConnection(getOutputConnector())
				&& DMLUtil.canConnectIncomingConnection(getInputConnector(), getFragment());
	}
	
	private Fragment getFragment() {
		return (Fragment) getElementToEdit();
	}
	
	private InputConnector getInputConnector() {
		EObject target = getTarget();
		if (target instanceof InputConnector) {
			return (InputConnector) target;
		}
		return null;
	}

	private OutputConnector getOutputConnector() {
		EObject source = getSource();
		if (source instanceof OutputConnector) {
			return (OutputConnector) source;
		}
		return null;
	}

}
