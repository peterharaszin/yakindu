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

package org.eclipselabs.damos.dscript.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipselabs.damos.dscript.BehaviorDeclaration;
import org.eclipselabs.damos.dscript.services.DscriptGrammarAccess;
import org.eclipselabs.damos.mscript.validation.MscriptDiagnosticConverter;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DscriptDiagnosticConverter extends MscriptDiagnosticConverter {

	private final DscriptGrammarAccess grammarAccess;
	
	/**
	 * 
	 */
	@Inject
	public DscriptDiagnosticConverter(DscriptGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.validation.DiagnosticConverterImpl#getLocationData(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature, int)
	 */
	@Override
	protected IssueLocation getLocationData(EObject obj, EStructuralFeature structuralFeature, int index) {
		if (obj instanceof BehaviorDeclaration) {
			IssueLocation location = super.getLocationData(obj, null, -1);
			location.length = grammarAccess.getBehaviorDeclarationAccess().getBehaviorKeyword_1().getValue().length();
			return location;
		}
		return super.getLocationData(obj, structuralFeature, index);
	}
	
}
