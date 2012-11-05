/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.util;

import java.util.List;

import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.Connector;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.internal.util.AbstractEventBroker;
import org.eclipse.emf.common.notify.Notification;

/**
 * @author Andreas Unger
 *
 */
public final class ConnectionEventBroker extends AbstractEventBroker<IConnectionListener> {

	public static void addListener(Connector connector, IConnectionListener listener) {
		addListener(connector, listener, ConnectionEventBroker.class);
	}
	
	public static void removeListener(Connector connector, IConnectionListener listener) {
		removeListener(connector, listener, ConnectionEventBroker.class);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.dml.internal.util.AbstractEventBroker#handleNotification(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotification(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Connection) {
			Object feature = notification.getFeature();
			if (feature == DMLPackage.eINSTANCE.getConnection_Source() || feature == DMLPackage.eINSTANCE.getConnection_Target()) {
				Connector oldConnector = (Connector) notification.getOldValue();
				if (oldConnector != null) {
					fireEvent(oldConnector, new ConnectionEvent(notifier, ConnectionEvent.DISCONNECTED));
				}
				Connector newConnector = (Connector) notification.getNewValue();
				if (newConnector != null) {
					fireEvent(newConnector, new ConnectionEvent(notifier, ConnectionEvent.CONNECTED));
				}
			}
		} else if (notifier instanceof Fragment) {
			if (notification.getFeature() == DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS) {
				switch (notification.getEventType()) {
				case Notification.ADD:
					if (notification.getNewValue() instanceof Connection) {
						fireEvent((Connection) notification.getNewValue(), ConnectionEvent.CONNECTED);
					}
				case Notification.ADD_MANY:
					if (notification.getNewValue() instanceof List<?>) {
						fireEvent((List<?>) notification.getNewValue(), ConnectionEvent.CONNECTED);
					}
				case Notification.REMOVE:
					if (notification.getOldValue() instanceof Connection) {
						fireEvent((Connection) notification.getOldValue(), ConnectionEvent.DISCONNECTED);
					}
				case Notification.REMOVE_MANY:
					if (notification.getOldValue() instanceof List<?>) {
						fireEvent((List<?>) notification.getOldValue(), ConnectionEvent.DISCONNECTED);
					}
				}
			}
		}
	}

	private void fireEvent(List<?> sources, int eventType) {
		for (Object source : sources) {
			if (source instanceof Connection) {
				fireEvent((Connection) source, eventType);
			}
		}
	}

	private void fireEvent(Connection connection, int eventType) {
		ConnectionEvent event = new ConnectionEvent(connection, eventType);
		fireEvent(connection.getSource(), event);
		fireEvent(connection.getTarget(), event);
	}

	private void fireEvent(Connector connector, ConnectionEvent event) {
		List<IConnectionListener> listenerDescriptors = listenerMap.get(connector);
		if (listenerDescriptors != null) {
			for (IConnectionListener l : listenerDescriptors) {
				l.connectionChanged(event);
			}
		}
	}
	
}
