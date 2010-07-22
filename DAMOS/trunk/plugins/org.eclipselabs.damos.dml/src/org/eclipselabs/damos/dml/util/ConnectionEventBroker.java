/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.util;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.internal.util.AbstractEventBroker;

/**
 * @author Andreas Unger
 *
 */
public final class ConnectionEventBroker extends AbstractEventBroker<IConnectionListener> {

	private static Map<IConnectionListener, List<WeakReference<AbstractEventBroker<IConnectionListener>>>> instanceMap = new HashMap<IConnectionListener, List<WeakReference<AbstractEventBroker<IConnectionListener>>>>();
	
	public static void addListener(Port port, IConnectionListener listener) {
		addListener(port, listener, instanceMap, ConnectionEventBroker.class);
	}
	
	public static void removeListener(Port port, IConnectionListener listener) {
		removeListener(port, listener, instanceMap, ConnectionEventBroker.class);
	}

	public static void removeListener(IConnectionListener listener) {
		removeListener(listener, instanceMap);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.internal.util.AbstractEventBroker#handleNotification(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotification(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Connection) {
			Object feature = notification.getFeature();
			if (feature == DMLPackage.Literals.CONNECTION__SOURCE_PORT || feature == DMLPackage.Literals.CONNECTION__TARGET_PORT) {
				Port oldPort = (Port) notification.getOldValue();
				if (oldPort != null) {
					fireEvent(oldPort, new ConnectionEvent(notifier, ConnectionEvent.DISCONNECTED));
				}
				Port newPort = (Port) notification.getNewValue();
				if (newPort != null) {
					fireEvent(newPort, new ConnectionEvent(notifier, ConnectionEvent.CONNECTED));
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
		fireEvent(connection.getSourcePort(), event);
		fireEvent(connection.getTargetPort(), event);
	}

	private void fireEvent(Port port, ConnectionEvent event) {
		List<IConnectionListener> listenerDescriptors = listenerMap.get(port);
		if (listenerDescriptors != null) {
			for (IConnectionListener l : listenerDescriptors) {
				l.connectionChanged(event);
			}
		}
	}
	
}
