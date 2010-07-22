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
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.internal.util.AbstractEventBroker;

/**
 * @author Andreas Unger
 *
 */
public final class SignalEventBroker extends AbstractEventBroker<ISignalListener> {

	private static Map<ISignalListener, List<WeakReference<AbstractEventBroker<ISignalListener>>>> instanceMap = new HashMap<ISignalListener, List<WeakReference<AbstractEventBroker<ISignalListener>>>>();
	
	public static void addListener(Connection connection, ISignalListener listener) {
		addListener(connection, listener, instanceMap, SignalEventBroker.class);
	}
	
	public static void addListener(InputPort inputPort, ISignalListener listener) {
		addListener(inputPort, listener, instanceMap, SignalEventBroker.class);
	}

	public static void removeListener(Connection connection, ISignalListener listener) {
		removeListener(connection, listener, instanceMap, SignalEventBroker.class);
	}

	public static void removeListener(InputPort inputPort, ISignalListener listener) {
		removeListener(inputPort, listener, instanceMap, SignalEventBroker.class);
	}

	public static void removeListener(ISignalListener listener) {
		removeListener(listener, instanceMap);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.internal.util.AbstractEventBroker#handleNotification(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	protected void handleNotification(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof OutputPort && notification.getFeature() == DMLPackage.Literals.OUTPUT_PORT__SIGNAL) {
			List<Connection> outgoingConnections = ((OutputPort) notifier).getOutgoingConnections();
			if (!outgoingConnections.isEmpty()) {
				SignalEvent event = new SignalEvent(notifier);
				for (Connection connection : outgoingConnections) {
					fireEvent(connection, event);
					fireEvent(connection.getTargetPort(), event);
				}
			}
		}
	}

	private void fireEvent(EObject eObject, SignalEvent event) {
		List<ISignalListener> listeners = listenerMap.get(eObject);
		if (listeners != null) {
			for (ISignalListener l : listeners) {
				l.signalChanged(event);
			}
		}
	}

}
