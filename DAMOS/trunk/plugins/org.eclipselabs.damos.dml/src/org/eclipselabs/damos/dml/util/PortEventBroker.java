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
	
	private final WeakReference<PortEventBroker> instanceReference = new WeakReference<PortEventBroker>(this);
	
	private Map<Port, ListenerDescriptorList> listenerMap = new WeakHashMap<Port, ListenerDescriptorList>();
	
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
		addPortListener(port, listener, -1);
	}
	
	public static void addPortListener(Port port, IPortListener listener, int eventTypeMask) {
		PortEventBroker broker = (PortEventBroker) EcoreUtil.getAdapter(port.eAdapters(), PortEventBroker.class);
		if (broker == null) {
			broker = new PortEventBroker();
			DMLUtil.getRootNotifier(port).eAdapters().add(broker);
		}
		broker.doAddPortListener(port, listener, eventTypeMask);
	}
	
	private void doAddPortListener(Port port, IPortListener listener, int eventTypeMask) {
		boolean added = false;
		ListenerDescriptorList listenerDescriptors = listenerMap.get(port);
		if (listenerDescriptors == null) {
			listenerDescriptors = new ListenerDescriptorList();
			listenerDescriptors.add(listener, eventTypeMask);
			listenerMap.put(port, listenerDescriptors);
			added = true;
		} else if (!listenerDescriptors.contains(listener)) {
			listenerDescriptors.add(listener, eventTypeMask);
			added = true;
		}
		if (added) {
			synchronized (instanceMap) {
				List<WeakReference<PortEventBroker>> brokers = instanceMap.get(listener);
				if (brokers == null) {
					brokers = new ArrayList<WeakReference<PortEventBroker>>();
					instanceMap.put(listener, brokers);
				}
				brokers.add(instanceReference);
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
		ListenerDescriptorList listenerDescriptors = listenerMap.get(port);
		if (listenerDescriptors != null) {
			boolean removed = false;
			if (listenerDescriptors.getSingletonListener() == listener) {
				listenerMap.remove(port);
				removed = true;
			} else {
				removed = listenerDescriptors.remove(listener);
			}
			if (removed) {
				synchronized (instanceMap) {
					List<WeakReference<PortEventBroker>> brokers = instanceMap.get(listener);
					if (brokers != null) {
						if (brokers.size() == 1 && brokers.get(0) == instanceReference) {
							instanceMap.remove(listener);
						} else {
							brokers.remove(instanceReference);
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
			for (WeakReference<PortEventBroker> brokerReference : brokers) {
				PortEventBroker broker = brokerReference.get();
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
		for (Iterator<ListenerDescriptorList> it = listenerMap.values().iterator(); it.hasNext();) {
			ListenerDescriptorList listenerDescriptors = it.next();
			if (listenerDescriptors.getSingletonListener() == listener) {
				it.remove();
			} else {
				listenerDescriptors.removeAny(listener);
				if (listenerDescriptors.isEmpty()) {
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
		List<ListenerDescriptor> listenerDescriptors = listenerMap.get(port);
		if (listenerDescriptors != null) {
			for (ListenerDescriptor l : listenerDescriptors) {
				if ((event.getEventType() & l.eventTypeMask) != 0) {
					l.listener.handlePortEvent(event);
				}
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
	
	private class ListenerDescriptorList extends ArrayList<ListenerDescriptor> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public IPortListener getSingletonListener() {
			return size() == 1 ? get(0).listener : null;
		}
		
		public boolean add(IPortListener listener, int eventTypeMask) {
			return add(new ListenerDescriptor(listener, eventTypeMask));
		}
		
		public boolean contains(IPortListener listener) {
			for (ListenerDescriptor listenerDescriptor : this) {
				if (listenerDescriptor.listener == listener) {
					return true;
				}
			}
			return false;
		}

		public boolean remove(IPortListener listener) {
			for (Iterator<ListenerDescriptor> it = iterator(); it.hasNext();) {
				if (it.next().listener == listener) {
					it.remove();
					return true;
				}
			}
			return false;
		}
		
		public void removeAny(IPortListener listener) {
			for (Iterator<ListenerDescriptor> it = iterator(); it.hasNext();) {
				if (it.next().listener == listener) {
					it.remove();
				}
			}
		}

	}
	
	private class ListenerDescriptor {
		
		public IPortListener listener;
		public int eventTypeMask;
		
		/**
		 * 
		 */
		public ListenerDescriptor(IPortListener listener, int eventTypeMask) {
			this.listener = listener;
			this.eventTypeMask = eventTypeMask;
		}
		
	}

}
