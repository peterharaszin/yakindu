/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.model;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.views.properties.IPropertySource;

import statemachine.Event;
import statemachine.Variable;

/**
 * @author m.muehlbrandt, B.Schwertfeger
 *         <p>
 *         Graphisches Modellelement des TreeViewers des DataExplorer-Fensters.
 *         Repr�sentiert die Eintr�ge innerhalb der dort angezeigten Liste.
 *         Jedes TreeObject welches eine Variabel oder Event des Hauptmodells
 *         darstellt, hat eine Referenz auf das entsprechende Model.
 * 
 *         TreeObjects werden in TreeParents gespeichert.
 * 
 * 		   TreeObjects can be edited by the properties view.
 */
public class TreeObject implements Adapter, IAdaptable {

	private String name;
	private String baseName;
	private EObject object = null;
	private TreeParent parent;
	private IPropertySource propertySource;

	static {
		final Class[] supportedTypes = new Class[] { IPropertySource.class };
		Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {

			public Object getAdapter(Object adaptableObject, Class adapterType) {
				if (adaptableObject instanceof TreeObject) {
					return ((TreeObject) adaptableObject)
							.getAdapter(adapterType);
				}

				return null;
			}

			public Class[] getAdapterList() {
				return supportedTypes;
			}
		}, TreeObject.class);
	}

	public TreeObject(String name) {
		this.name = name;
	}

	public String getBaseName() {
		return baseName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setParent(TreeParent parent) {
		this.parent = parent;
	}

	public TreeParent getParent() {
		return parent;
	}

	public String toString() {
		return getName();
	}

	public Object getAdapter(Class adapter) {
		if (adapter == IPropertySource.class) {
			if (object instanceof Variable) {
				if (propertySource == null) {
					propertySource = new VariablePropertySource(
							(Variable) object);
				}
				return propertySource;
			}
			if (object instanceof Event) {
				if (propertySource == null) {
					propertySource = new EventPropertySource((Event) object);
				}
				return propertySource;
			}
		}
		return null;
	}

	public EObject getObject() {
		return object;
	}

	public void setObject(EObject object) {
		this.object = object;
		object.eAdapters().add(this);
		if (object instanceof Variable)
			baseName = ((Variable) object).getName();
		else if (object instanceof Event)
			baseName = ((Event) object).getName();
	}

	public Notifier getTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isAdapterForType(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void notifyChanged(Notification notification) {
		switch (notification.getEventType()) {
		case Notification.SET: {
			if (notification.getNotifier() instanceof Variable) {
				Variable variable = (Variable) object;
				name = variable.getName() + " ("
						+ variable.getIoType().getLiteral() + ", "
						+ variable.getDataType().getLiteral() + ", "
						+ variable.getPort() + ")";
			} else if (notification.getNotifier() instanceof Event) {
				Event event = (Event) object;
				name = event.getName() + " (" + event.getIoType().getLiteral()
						+ ", " + event.getTrigger().getLiteral() + ", "
						+ event.getPort() + ")";
			}
		}
		}
	}

	public void setTarget(Notifier arg0) {
		// TODO Auto-generated method stub

	}
}
