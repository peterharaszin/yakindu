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

package org.eclipselabs.damos.mscript.parser.antlr;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.UnitDeclaration;
import org.eclipselabs.damos.mscript.UnitPrefix;
import org.eclipselabs.damos.mscript.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class MscriptEcoreElementFactory extends DefaultEcoreElementFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.parser.DefaultEcoreElementFactory#create(org.eclipse.emf.ecore.EClassifier)
	 */
	@Override
	public EObject create(EClassifier classifier) {
		EObject element = super.create(classifier);
		if (element instanceof UnitDeclaration) {
			UnitDeclaration unitDeclaration = (UnitDeclaration) element;
			for (UnitPrefix prefix : UnitPrefix.values()) {
				UnitSymbol unitSymbol = MscriptFactory.eINSTANCE.createUnitSymbol();
				unitSymbol.setPrefix(prefix);
				unitDeclaration.getSymbols().add(unitSymbol);
			}
		}
		return element;
	}
	
}
