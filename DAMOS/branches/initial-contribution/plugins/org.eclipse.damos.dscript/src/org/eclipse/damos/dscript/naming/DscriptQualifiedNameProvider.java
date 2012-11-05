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

package org.eclipse.damos.dscript.naming;

import org.eclipse.damos.dml.INamedElement;
import org.eclipse.damos.dml.Inoutlet;
import org.eclipse.damos.dml.InoutputDefinition;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.QualifiedElement;
import org.eclipse.damos.mscript.naming.MscriptQualifiedNameProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class DscriptQualifiedNameProvider extends MscriptQualifiedNameProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.naming.MscriptQualifiedNameProvider#getFullyQualifiedName(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof QualifiedElement) {
			String qualifiedName = ((QualifiedElement) obj).getQualifiedName();
			if (qualifiedName == null) {
				return null;
			}
			return qualifiedNameConverter.toQualifiedName(qualifiedName);
		}
		if (obj instanceof InoutputDefinition || obj instanceof Parameter || obj instanceof Inoutlet) {
			return getFullyQualifiedName((INamedElement) obj);
		}
		return super.getFullyQualifiedName(obj);
	}

	private QualifiedName getFullyQualifiedName(INamedElement element) {
		if (element.getName() == null) {
			return null;
		}
		EObject eContainer = element.eContainer();
		if (eContainer == null) {
			return null;
		}
		QualifiedName fullyQualifiedName = getFullyQualifiedName(eContainer);
		if (fullyQualifiedName == null) {
			return null;
		}
		return fullyQualifiedName.append(element.getName());
	}
	
}
