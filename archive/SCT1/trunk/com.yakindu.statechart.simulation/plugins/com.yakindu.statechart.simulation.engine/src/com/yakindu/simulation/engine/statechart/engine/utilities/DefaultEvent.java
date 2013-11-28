/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
/**
 * 
 */
package com.yakindu.simulation.engine.statechart.engine.utilities;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import statemachine.Event;
import statemachine.IOTypes;
import statemachine.TriggerTypes;

/**
 * Default implementation of {@link Event}.
 * 
 * @author Philipp Richter
 */
public class DefaultEvent implements Event {

	/** Defines the name of the event. */
	private String name;
	/** Defines the io type of this event. */
	private IOTypes ioType;
	/** Defines the trigger of this event. */
	private TriggerTypes trigger;
	/** Defines the port of this event. */
	private int port;

	/**
	 * Creates an instance of this class.
	 * 
	 * @param name defines the name of the new event
	 */
	public DefaultEvent(String name) {

		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.Event#getTrigger()
	 */
	public TriggerTypes getTrigger() {

		return trigger;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.Event#setTrigger(statemachine.TriggerTypes)
	 */
	public void setTrigger(TriggerTypes value) {

		this.trigger = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.DataElement#getIoType()
	 */
	public IOTypes getIoType() {

		return ioType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.DataElement#getName()
	 */
	public String getName() {

		return name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.DataElement#getPort()
	 */
	public int getPort() {

		return port;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.DataElement#setIoType(statemachine.IOTypes)
	 */
	public void setIoType(IOTypes value) {

		this.ioType = value;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.DataElement#setName(java.lang.String)
	 */
	public void setName(String value) {

		this.name = value;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see statemachine.DataElement#setPort(int)
	 */
	public void setPort(int value) {

		this.port = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eAllContents()
	 */
	public TreeIterator<EObject> eAllContents() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eClass()
	 */
	public EClass eClass() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eContainer()
	 */
	public EObject eContainer() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eContainingFeature()
	 */
	public EStructuralFeature eContainingFeature() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eContainmentFeature()
	 */
	public EReference eContainmentFeature() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eContents()
	 */
	public EList<EObject> eContents() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eCrossReferences()
	 */
	public EList<EObject> eCrossReferences() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature
	 * )
	 */
	public Object eGet(EStructuralFeature feature) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.EObject#eGet(org.eclipse.emf.ecore.EStructuralFeature
	 * , boolean)
	 */
	public Object eGet(EStructuralFeature feature, boolean resolve) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eIsProxy()
	 */
	public boolean eIsProxy() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.EObject#eIsSet(org.eclipse.emf.ecore.EStructuralFeature
	 * )
	 */
	public boolean eIsSet(EStructuralFeature feature) {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.ecore.EObject#eResource()
	 */
	public Resource eResource() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.EObject#eSet(org.eclipse.emf.ecore.EStructuralFeature
	 * , java.lang.Object)
	 */
	public void eSet(EStructuralFeature feature, Object newValue) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.ecore.EObject#eUnset(org.eclipse.emf.ecore.EStructuralFeature
	 * )
	 */
	public void eUnset(EStructuralFeature feature) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.notify.Notifier#eAdapters()
	 */
	public EList<Adapter> eAdapters() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.notify.Notifier#eDeliver()
	 */
	public boolean eDeliver() {

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.emf.common.notify.Notifier#eNotify(org.eclipse.emf.common
	 * .notify.Notification)
	 */
	public void eNotify(Notification notification) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.notify.Notifier#eSetDeliver(boolean)
	 */
	public void eSetDeliver(boolean deliver) {

	}

	public Object eInvoke(EOperation arg0, EList<?> arg1)
			throws InvocationTargetException {
		
		return null;
	}

}
