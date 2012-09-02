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

package org.eclipselabs.damos.dscript.parser.antlr;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dscript.BehaviorDeclaration;
import org.eclipselabs.damos.dscript.DscriptFactory;
import org.eclipselabs.damos.mscript.parser.antlr.MscriptEcoreElementFactory;

/**
 * @author Andreas Unger
 *
 */
public class DscriptEcoreElementFactory extends MscriptEcoreElementFactory {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.parser.antlr.MscriptEcoreElementFactory#create(org.eclipse.emf.ecore.EClassifier)
	 */
	@Override
	public EObject create(EClassifier classifier) {
		EObject element = super.create(classifier);
		if (element instanceof BehaviorDeclaration) {
			BehaviorDeclaration behaviorDeclaration = (BehaviorDeclaration) element;
			behaviorDeclaration.getAllImplicitInputParameterDeclarations().add(DscriptFactory.eINSTANCE.createInputMessageParameterDeclaration());
			behaviorDeclaration.getAllImplicitOutputParameterDeclarations().add(DscriptFactory.eINSTANCE.createOutputMessageParameterDeclaration());
		}
		return element;
	}

}
