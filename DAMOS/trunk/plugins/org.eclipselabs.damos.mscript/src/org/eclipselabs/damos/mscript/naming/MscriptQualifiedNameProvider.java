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

package org.eclipselabs.damos.mscript.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipselabs.damos.mscript.Module;
import org.eclipselabs.damos.mscript.ParameterDeclaration;
import org.eclipselabs.damos.mscript.TopLevelDeclaration;
import org.eclipselabs.damos.mscript.UnitSymbol;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class MscriptQualifiedNameProvider extends IQualifiedNameProvider.AbstractImpl {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.naming.IQualifiedNameProvider#getFullyQualifiedName(org.eclipse.emf.ecore.EObject)
	 */
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof TopLevelDeclaration) {
			TopLevelDeclaration topLevelDeclaration = (TopLevelDeclaration) obj;

			if (topLevelDeclaration.getName() != null) {
				QualifiedName packageName = getPackageName(topLevelDeclaration);
				return packageName.append(topLevelDeclaration.getName());
			}
		} else if (obj instanceof UnitSymbol) {
			UnitSymbol unitSymbol = (UnitSymbol) obj;
			if (unitSymbol.getOwner() != null) {
				QualifiedName packageName = getPackageName(unitSymbol.getOwner());
				return packageName.append(unitSymbol.getName());
			}
		} else if (obj instanceof ParameterDeclaration) {
			return QualifiedName.create(((ParameterDeclaration) obj).getName());
		}
		return null;
	}

	/**
	 * @param topLevelDeclaration
	 * @return
	 */
	protected QualifiedName getPackageName(TopLevelDeclaration topLevelDeclaration) {
		if (topLevelDeclaration.eContainer() instanceof Module) {
			return qualifiedNameConverter.toQualifiedName(((Module) topLevelDeclaration.eContainer()).getPackageName()); 
		}
		return QualifiedName.EMPTY;
	}

}
