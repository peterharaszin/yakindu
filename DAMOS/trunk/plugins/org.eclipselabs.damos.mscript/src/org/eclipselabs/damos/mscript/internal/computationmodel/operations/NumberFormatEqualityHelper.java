/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.internal.computationmodel.operations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage;

/**
 * @author Andreas Unger
 *
 */
class NumberFormatEqualityHelper extends EqualityHelper {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected boolean haveEqualFeature(EObject eObject1, EObject eObject2, EStructuralFeature feature) {
		if (feature == ComputationModelPackage.eINSTANCE.getNumberFormat_Name()) {
			return true;
		}
		return super.haveEqualFeature(eObject1, eObject2, feature);
	}
	
}
