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
import org.eclipselabs.damos.mscript.Declaration;
import org.eclipselabs.damos.mscript.IPackageMember;
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
		if (obj instanceof Declaration) {
			Declaration declaration = (Declaration) obj;

			QualifiedName packageName = getPackageName(declaration);
			if (packageName != null) {
				return packageName.append(declaration.getName());
			}
		} else if (obj instanceof UnitSymbol) {
			UnitSymbol unitSymbol = (UnitSymbol) obj;
			QualifiedName packageName = getPackageName(unitSymbol.getOwner());
			if (packageName != null) {
				return packageName.append(unitSymbol.getName());
			}
		}
		return null;
	}

	/**
	 * @param declaration
	 * @return
	 */
	private QualifiedName getPackageName(Declaration declaration) {
		if (declaration.getName() == null) {
			return null;
		}
		QualifiedName packageName;
		if (declaration.eContainer() instanceof IPackageMember) {
			packageName = qualifiedNameConverter.toQualifiedName(((IPackageMember) declaration.eContainer()).getPackageName()); 
		} else {
			packageName = QualifiedName.EMPTY;
		}
		return packageName;
	}

}
