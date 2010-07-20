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
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;

/**
 * @author Andreas Unger
 *
 */
public class PortEventBroker extends EContentAdapter {

	private static final Map<IPortListener, List<WeakReference<PortEventBroker>>> instanceMap = new HashMap<IPortListener, List<WeakReference<PortEventBroker>>>();
	
	private final WeakReference<PortEventBroker> instance = new WeakReference<PortEventBroker>(this);
	
	private Map<Port, List<IPortListener>> listenerMap = new WeakHashMap<Port, List<IPortListener>>();
	
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
					fireConnectionEvent(oldPort, new PortEvent(notifier, PortEvent.CONNECTION_DISCONNECTED));
				}
				Port newPort = (Port) notification.getNewValue();
				if (newPort != null) {
					fireConnectionEvent(newPort, new PortEvent(notifier, PortEvent.CONNECTION_CONNECTED));
				}
			}
		} else if (notifier instanceof Fragment) {
			if (notification.getFeature() == DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS) {
				switch (notification.getEventType()) {
				case Notification.ADD:
					if (notification.getNewValue() instanceof Connection) {
						fireConnectionEvent((Connection) notification.getNewValue(), PortEvent.CONNECTION_CONNECTED);
					}
				case Notification.ADD_MANY:
					if (notification.getNewValue() instanceof List<?>) {
						fireConnectionEvent((List<?>) notification.getNewValue(), PortEvent.CONNECTION_CONNECTED);
					}
				case Notification.REMOVE:
					if (notification.getOldValue() instanceof Connection) {
						fireConnectionEvent((Connection) notification.getOldValue(), PortEvent.CONNECTION_DISCONNECTED);
					}
				case Notification.REMOVE_MANY:
					if (notification.getOldValue() instanceof List<?>) {
						fireConnectionEvent((List<?>) notification.getOldValue(), PortEvent.CONNECTION_DISCONNECTED);
					}
				}
			}
		} else if (notifier instanceof OutputPort) {
			if (notification.getFeature() == DMLPackage.Literals.OUTPUT_PORT__SIGNAL) {
				List<Connection> outgoingConnections = ((OutputPort) notifier).getOutgoingConnections();
				if (!outgoingConnections.isEmpty()) {
					PortEvent event = new PortEvent(notifier, PortEvent.SIGNAL_CHANGED);
					for (Connection connection : outgoingConnections) {
						fireConnectionEvent(connection.getTargetPort(), event);
					}
				}
			}
		}
	}
	
	public static void addPortListener(Port port, IPortListener listener) {
		PortEventBroker broker = (PortEventBroker) EcoreUtil.getAdapter(port.eAdapters(), PortEventBroker.class);
		if (broker == null) {
			broker = new PortEventBroker();
			DMLUtil.getRootNotifier(port).eAdapters().add(broker);
		}
		broker.doAddPortListener(port, listener);
	}
	
	private void doAddPortListener(Port port, IPortListener listener) {
		boolean added = false;
		List<IPortListener> listeners = listenerMap.get(port);
		if (listeners == null) {
			listeners = new ArrayList<IPortListener>();
			listeners.add(listener);
			listenerMap.put(port, listeners);
			added = true;
		} else if (!listeners.contains(listener)) {
			listeners.add(listener);
			added = true;
		}
		if (added) {
			synchronized (instanceMap) {
				List<WeakReference<PortEventBroker>> brokers = instanceMap.get(listener);
				if (brokers == null) {
					brokers = new ArrayList<WeakReference<PortEventBroker>>();
					instanceMap.put(listener, brokers);
				}
				brokers.add(instance);
			}
		}
	}
	
	public static void removePortListener(Port port, IPortListener listener) {
		PortEventBroker broker = (PortEventBroker) EcoreUtil.getAdapter(port.eAdapters(), PortEventBroker.class);
		if (broker != null) {
			broker.doRemovePortListener(port, listener);
		}
	}

	private void doRemovePortListener(Port port, IPortListener listener) {
		List<IPortListener> listeners = listenerMap.get(port);
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
					List<WeakReference<PortEventBroker>> brokers = instanceMap.get(listener);
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
	
	public static void removePortListener(IPortListener listener) {
		List<WeakReference<PortEventBroker>> brokers;
		synchronized (instanceMap) {
			brokers = instanceMap.remove(listener);
		}
		if (brokers != null) {
			for (WeakReference<PortEventBroker> weakBroker : brokers) {
				PortEventBroker broker = weakBroker.get();
				if (broker != null) {
					broker.doRemovePortListener(listener);
				}
			}
		}
	}

	/**
	 * @param listener
	 * @param broker
	 */
	private void doRemovePortListener(IPortListener listener) {
		for (Iterator<List<IPortListener>> it = listenerMap.values().iterator(); it.hasNext();) {
			List<IPortListener> listeners = it.next();
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
		PortEvent event = new PortEvent(connection, eventType);
		fireConnectionEvent(connection.getSourcePort(), event);
		fireConnectionEvent(connection.getTargetPort(), event);
	}

	private void fireConnectionEvent(Port port, PortEvent event) {
		List<IPortListener> listeners = listenerMap.get(port);
		if (listeners != null) {
			for (IPortListener l : listeners) {
				l.handlePortEvent(event);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == PortEventBroker.class;
	}

}
