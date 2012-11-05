/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript.validation;

import org.eclipse.damos.mscript.MscriptPackage;
import org.eclipse.damos.mscript.StandardFunctionDeclaration;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.validation.DiagnosticConverterImpl;

/**
 * @author Andreas Unger
 *
 */
public class MscriptDiagnosticConverter extends DiagnosticConverterImpl {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.validation.DiagnosticConverterImpl#getLocationData(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, int)
	 */
	@Override
	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
		if (obj instanceof StandardFunctionDeclaration && structuralFeature == null) {
			return super.getLocationData(obj, MscriptPackage.eINSTANCE.getStandardFunctionDeclaration_Name(), index);
		}
		return super.getLocationData(obj, structuralFeature, index);
	}
	
}
