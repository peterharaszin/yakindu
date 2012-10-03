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

package org.eclipse.damos.mscript.parser.antlr;

import org.eclipse.damos.mscript.FunctionDeclaration;
import org.eclipse.damos.mscript.ImplicitVariableDeclaration;
import org.eclipse.damos.mscript.MscriptFactory;
import org.eclipse.damos.mscript.UnitDeclaration;
import org.eclipse.damos.mscript.UnitPrefix;
import org.eclipse.damos.mscript.UnitSymbol;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.DefaultEcoreElementFactory;

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
		} else if (element instanceof FunctionDeclaration) {
			FunctionDeclaration functionDeclaration = (FunctionDeclaration) element;
			addImplicitVariableDeclarations(functionDeclaration);
		}
		return element;
	}

	/**
	 * @param functionDeclaration
	 */
	protected void addImplicitVariableDeclarations(FunctionDeclaration functionDeclaration) {
		addImplicitVariableDeclaration(functionDeclaration, "Ts");
		addImplicitVariableDeclaration(functionDeclaration, "fs");
		addImplicitVariableDeclaration(functionDeclaration, "t");
	}

	/**
	 * @param functionDeclaration
	 */
	protected void addImplicitVariableDeclaration(FunctionDeclaration functionDeclaration, String name) {
		ImplicitVariableDeclaration variableDeclaration = MscriptFactory.eINSTANCE.createImplicitVariableDeclaration();
		variableDeclaration.setName(name);
		functionDeclaration.getAllImplicitVariableDeclarations().add(variableDeclaration);
	}
	
}
