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

package org.eclipselabs.damos.dml.internal.util;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Andreas Unger
 *
 */
public class CrossReferencerUtil {

	public static Collection<EStructuralFeature.Setting> getNonNavigableInverseReferences(EObject eObject) {
		Notifier context = getContext(eObject);
		ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(context);
		if (adapter == null) {
			adapter = new ECrossReferenceAdapter();
			context.eAdapters().add(adapter);
		}
		return adapter.getNonNavigableInverseReferences(eObject, true);
	}

	public static <T extends EObject> EList<T> getNonNavigableInverseReferences(EObject eObject, Class<? extends T> clazz, EReference reference) {
		EList<T> references = new UniqueEList.FastCompare<T>();
		for (EStructuralFeature.Setting nonNavigableInverseReference : getNonNavigableInverseReferences(eObject)) {
			if (nonNavigableInverseReference.getEStructuralFeature() == reference) {
				EObject referenceEObject = nonNavigableInverseReference.getEObject();
				if (clazz.isInstance(referenceEObject)) {
					references.add(clazz.cast(referenceEObject));
				}
			}
		}
		return references;
	}
	
	private static Notifier getContext(EObject eObject) {
		EObject root = EcoreUtil.getRootContainer(eObject);
		Resource resource = root.eResource();
		if (resource != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			return resourceSet != null ? resourceSet : resource;
		}
		return root;
	}

}
