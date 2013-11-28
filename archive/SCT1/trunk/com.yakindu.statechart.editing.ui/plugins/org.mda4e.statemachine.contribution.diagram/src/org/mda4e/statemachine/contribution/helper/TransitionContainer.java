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
package org.mda4e.statemachine.contribution.helper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

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

import statemachine.Node;
import statemachine.Transition;

public class TransitionContainer implements Transition {
	
	private List<Transition> transitions;
	private Integer priority;

	public TransitionContainer(List<Transition> transitions)
	{		
		if(transitions == null || transitions.size() == 0)
		{
			throw new IllegalArgumentException("List should not be null and need at least contain one element");
		}
		for(Transition t : transitions)
		{
			if(priority == null)
			{
				priority = t.getPriority();
			} else if(priority != t.getPriority())
			{
				throw new IllegalArgumentException("Transitions must have all the same priority");
			}
		}
		this.transitions = transitions;
	}
	
	public TransitionContainer(Transition transition)
	{
		if(transition == null)
		{
			throw new NullPointerException();
		}
		transitions = new ArrayList<Transition>(1);
		transitions.add(transition);
		priority = transition.getPriority();
	}
	
	public void addTransition(Transition transition)
	{
		if(priority != transition.getPriority())
		{
			throw new IllegalArgumentException("Transitions must have all the same priority");
		}
		transitions.add(transition);
	}
	
	public void removeTransition(Transition transition)
	{
		transitions.remove(transition);
	}
	
	public List<Transition> getTransitions()
	{
		return transitions;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
		{
			return true;
		}
		
		if(obj == null)
		{
			return false;
		}
		
		if(obj instanceof Transition)
		{
			for(Transition t : transitions)
			{
				if(t.equals(obj))
				{
					return true;
				}
			}
		}
		
		return false;
	}

	public String getExpression() {
		throw new RuntimeException("Should never be called!");
	}

	public int getId() {
		throw new RuntimeException("Should never be called!");
	}

	public int getPriority() {
		return priority;
	}

	public Node getSourceNode() {
		throw new RuntimeException("Should never be called!");
	}

	public Node getTargetNode() {
		throw new RuntimeException("Should never be called!");
	}

	public void setExpression(String value) {
		throw new RuntimeException("Should never be called!");
	}

	public void setId(int value) {
		throw new RuntimeException("Should never be called!");		
	}

	public void setPriority(int value) {
		for(Transition t : transitions)
		{
			t.setPriority(value);
		}
		priority = value;
	}

	public void setSourceNode(Node value) {
		throw new RuntimeException("Should never be called!");
	}

	public void setTargetNode(Node value) {
		throw new RuntimeException("Should never be called!");
	}

	public TreeIterator<EObject> eAllContents() {
		throw new RuntimeException("Should never be called!");
	}

	public EClass eClass() {
		throw new RuntimeException("Should never be called!");
	}

	public EObject eContainer() {
		throw new RuntimeException("Should never be called!");
	}

	public EStructuralFeature eContainingFeature() {
		throw new RuntimeException("Should never be called!");
	}

	public EReference eContainmentFeature() {
		throw new RuntimeException("Should never be called!");
	}

	public EList<EObject> eContents() {
		throw new RuntimeException("Should never be called!");
	}

	public EList<EObject> eCrossReferences() {
		throw new RuntimeException("Should never be called!");
	}

	public Object eGet(EStructuralFeature feature) {
		throw new RuntimeException("Should never be called!");
	}

	public Object eGet(EStructuralFeature feature, boolean resolve) {
		throw new RuntimeException("Should never be called!");
	}

	public boolean eIsProxy() {
		throw new RuntimeException("Should never be called!");
	}

	public boolean eIsSet(EStructuralFeature feature) {
		throw new RuntimeException("Should never be called!");
	}

	public Resource eResource() {
		throw new RuntimeException("Should never be called!");
	}

	public void eSet(EStructuralFeature feature, Object newValue) {
		throw new RuntimeException("Should never be called!");		
	}

	public void eUnset(EStructuralFeature feature) {
		throw new RuntimeException("Should never be called!");
	}

	public EList<Adapter> eAdapters() {
		throw new RuntimeException("Should never be called!");
	}

	public boolean eDeliver() {
		throw new RuntimeException("Should never be called!");
	}

	public void eNotify(Notification notification) {
		throw new RuntimeException("Should never be called!");		
	}

	public void eSetDeliver(boolean deliver) {
		throw new RuntimeException("Should never be called!");
	}

	public Object eInvoke(EOperation arg0, EList<?> arg1)
			throws InvocationTargetException {
		throw new RuntimeException("Should never be called!");
	}

	
}
