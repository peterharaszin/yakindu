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

package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.internal.util.CrossReferencerUtil;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FragmentOperations {

	public static  EList<Fragment> getChildren(Fragment fragment) {
		EList<Fragment> fragments = new UniqueEList.FastCompare<Fragment>();
		for (EStructuralFeature.Setting nonNavigableInverseReference : CrossReferencerUtil.getNonNavigableInverseReferences(fragment)) {
			if (nonNavigableInverseReference.getEStructuralFeature() == DMLPackage.Literals.FRAGMENT__PARENT) {
				EObject referenceEObject = nonNavigableInverseReference.getEObject();
				if (referenceEObject instanceof Fragment) {
					fragments.add((Fragment) referenceEObject);
				}
			}
		}
		return fragments;
	}

	public static  EList<FragmentElement> getAllFragmentElements(Fragment fragment) {
		EList<FragmentElement> fragmentElements = new BasicEList<FragmentElement>(fragment.getFragmentElements());
		while (fragment.getParent() != null) {
			fragment = fragment.getParent();
			fragmentElements.addAll(fragment.getFragmentElements());
		}
		return fragmentElements;
	}

	public static  EList<Component> getAllComponents(Fragment fragment) {
		EList<Component> components = new BasicEList<Component>(fragment.getComponents());
		while (fragment.getParent() != null) {
			fragment = fragment.getParent();
			components.addAll(fragment.getComponents());
		}
		return components;
	}

	public static  EList<Connection> getAllConnections(Fragment fragment) {
		EList<Connection> connections = new BasicEList<Connection>(fragment.getConnections());
		while (fragment.getParent() != null) {
			fragment = fragment.getParent();
			connections.addAll(fragment.getConnections());
		}
		return connections;
	}

}
