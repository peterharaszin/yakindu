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

package org.eclipse.damos.dml.internal.util;

import org.eclipse.damos.dml.INamedElement;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * @author Andreas Unger
 * 
 */
public class URIUtil {

	/**
	 * 
	 */
	private static final char PREFIX = '~';

	public static EObject eObjectForURIFragmentSegment(EObject eObject, String uriFragmentSegment) {
		if (uriFragmentSegment.length() > 2 && uriFragmentSegment.charAt(0) == PREFIX) {
			int dotIndex = uriFragmentSegment.lastIndexOf('.', uriFragmentSegment.length() - 2);
			if (dotIndex >= 0) {
				EList<?> elements = (EList<?>) eObject.eGet(
						eStructuralFeature(eObject, uriFragmentSegment.substring(1, dotIndex)), false);
				String name = uriFragmentSegment.substring(dotIndex + 1);
				for (Object element : elements) {
					if (element instanceof INamedElement) {
						INamedElement namedElement = (INamedElement) element;
						if (name.equals(namedElement.getName())) {
							return namedElement;
						}
					}
				}
			}
		}

		return null;
	}

	private static EStructuralFeature eStructuralFeature(EObject eObject, String name) {
		EStructuralFeature eStructuralFeature = eObject.eClass().getEStructuralFeature(name);
		if (eStructuralFeature == null) {
			throw new IllegalArgumentException("The feature '" + name + "' is not a valid feature");
		}
		return eStructuralFeature;
	}

	public static String eURIFragmentSegment(EStructuralFeature eStructuralFeature, EObject eObject) {
		if (eObject instanceof INamedElement) {
			INamedElement namedElement = (INamedElement) eObject;
			return PREFIX + eStructuralFeature.getName() + "." + namedElement.getName();
		}
		return null;
	}

}
