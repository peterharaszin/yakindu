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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Port;

/**
 * @author Andreas Unger
 *
 */
public class ConnectionEventBroker extends EContentAdapter {

	private static final Map<IConnectionListener, List<WeakReference<ConnectionEventBroker>>> instanceMap = new HashMap<IConnectionListener, List<WeakReference<ConnectionEventBroker>>>();
	
	private final WeakReference<ConnectionEventBroker> instance = new WeakReference<ConnectionEventBroker>(this);
	
	private Map<Port, List<IConnectionListener>> listenerMap = new WeakHashMap<Port, List<IConnectionListener>>();
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EContentAdapter#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		Object notifier = notification.getNotifier();
		if (notifier instanceof Connection) {
			Object feature = notification.getFeature();
			if (feature == DMLPackage.Literals.CONNECTION__SOURCE_PORT || feature == DMLPackage.Literals.CONNECTION__TARGET_PORT) {
				Port oldPort = (Port) notification.getOldValue();
				if (oldPort != null) {
					fireConnectionEvent(oldPort, new ConnectionEvent(notifier, ConnectionEvent.DISCONNECTED));
				}
				Port newPort = (Port) notification.getNewValue();
				if (newPort != null) {
					fireConnectionEvent(newPort, new ConnectionEvent(notifier, ConnectionEvent.CONNECTED));
				}
			}
		} else if (notifier instanceof Fragment) {
			if (notification.getFeature() == DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS) {
				switch (notification.getEventType()) {
				case Notification.ADD:
					if (notification.getNewValue() instanceof Connection) {
						fireConnectionEvent((Connection) notification.getNewValue(), ConnectionEvent.CONNECTED);
					}
				case Notification.ADD_MANY:
					if (notification.getNewValue() instanceof List<?>) {
						fireConnectionEvent((List<?>) notification.getNewValue(), ConnectionEvent.CONNECTED);
					}
				case Notification.REMOVE:
					if (notification.getOldValue() instanceof Connection) {
						fireConnectionEvent((Connection) notification.getOldValue(), ConnectionEvent.DISCONNECTED);
					}
				case Notification.REMOVE_MANY:
					if (notification.getOldValue() instanceof List<?>) {
						fireConnectionEvent((List<?>) notification.getOldValue(), ConnectionEvent.DISCONNECTED);
					}
				}
			}
		}
	}
	
	public static void addConnectionListener(Port port, IConnectionListener listener) {
		ConnectionEventBroker broker = (ConnectionEventBroker) EcoreUtil.getAdapter(port.eAdapters(), ConnectionEventBroker.class);
		if (broker == null) {
			broker = new ConnectionEventBroker();
			DMLUtil.getRootNotifier(port).eAdapters().add(broker);
		}
		broker.doAddConnectionListener(port, listener);
	}
	
	private void doAddConnectionListener(Port port, IConnectionListener listener) {
		boolean added = false;
		List<IConnectionListener> listeners = listenerMap.get(port);
		if (listeners == null) {
			listeners = new ArrayList<IConnectionListener>();
			listeners.add(listener);
			listenerMap.put(port, listeners);
			added = true;
		} else if (!listeners.contains(listener)) {
			listeners.add(listener);
			added = true;
		}
		if (added) {
			synchronized (instanceMap) {
				List<WeakReference<ConnectionEventBroker>> brokers = instanceMap.get(listener);
				if (brokers == null) {
					brokers = new ArrayList<WeakReference<ConnectionEventBroker>>();
					instanceMap.put(listener, brokers);
				}
				brokers.add(instance);
			}
		}
	}
	
	public static void removeConnectionChangeListener(Port port, IConnectionListener listener) {
		ConnectionEventBroker broker = (ConnectionEventBroker) EcoreUtil.getAdapter(port.eAdapters(), ConnectionEventBroker.class);
		if (broker != null) {
			broker.doRemoveConnectionListener(port, listener);
		}
	}

	private void doRemoveConnectionListener(Port port, IConnectionListener listener) {
		List<IConnectionListener> listeners = listenerMap.get(port);
		if (listeners != null) {
			boolean removed = false;
			if (listeners.size() == 1 && listeners.get(0) == listener) {
				listenerMap.remove(port);
				removed = true;
			} else {
				removed = listeners.remove(listener);
			}
			if (removed) {
				synchronized (instanceMap) {
					List<WeakReference<ConnectionEventBroker>> brokers = instanceMap.get(listener);
					if (brokers != null) {
						if (brokers.size() == 1 && brokers.get(0) == instance) {
							instanceMap.remove(listener);
						} else {
							brokers.remove(instance);
						}
					}
				}
			}
		}
	}
	
	public static void removeConnectionListener(IConnectionListener listener) {
		List<WeakReference<ConnectionEventBroker>> brokers;
		synchronized (instanceMap) {
			brokers = instanceMap.remove(listener);
		}
		if (brokers != null) {
			for (WeakReference<ConnectionEventBroker> weakBroker : brokers) {
				ConnectionEventBroker broker = weakBroker.get();
				if (broker != null) {
					broker.doRemoveConnectionListener(listener);
				}
			}
		}
	}

	/**
	 * @param listener
	 * @param broker
	 */
	private void doRemoveConnectionListener(IConnectionListener listener) {
		for (Iterator<List<IConnectionListener>> it = listenerMap.values().iterator(); it.hasNext();) {
			List<IConnectionListener> listeners = it.next();
			if (listeners.size() == 1 && listeners.get(0) == listener) {
				it.remove();
			} else {
				listeners.removeAll(Collections.singleton(listener));
				if (listeners.isEmpty()) {
					it.remove();
				}
			}
		}
	}

	private void fireConnectionEvent(List<?> sources, int eventType) {
		for (Object source : sources) {
			if (source instanceof Connection) {
				fireConnectionEvent((Connection) source, eventType);
			}
		}
	}

	private void fireConnectionEvent(Connection connection, int eventType) {
		ConnectionEvent event = new ConnectionEvent(connection, eventType);
		fireConnectionEvent(connection.getSourcePort(), event);
		fireConnectionEvent(connection.getTargetPort(), event);
	}

	private void fireConnectionEvent(Port port, ConnectionEvent event) {
		List<IConnectionListener> listeners = listenerMap.get(port);
		if (listeners != null) {
			for (IConnectionListener l : listeners) {
				l.connectionChanged(event);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ConnectionEventBroker.class;
	}

}
