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

package org.eclipselabs.damos.dconfig.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipselabs.damos.dconfig.Configuration;
import org.eclipselabs.damos.dconfig.PropertyDeclaration;
import org.eclipselabs.damos.dconfig.SelectionPropertyOption;

/**
 * @author Andreas Unger
 *
 */
public class DconfigQualifiedNameProvider extends DefaultDeclarativeQualifiedNameProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.naming.IQualifiedNameProvider#getFullyQualifiedName(org.eclipse.emf.ecore.EObject)
	 */
	public QualifiedName getFullyQualifiedName(EObject obj) {
		if (obj instanceof PropertyDeclaration) {
			PropertyDeclaration propertyDeclaration = (PropertyDeclaration) obj;
			
			String name = propertyDeclaration.getName();
			if (name == null) {
				return null;
			}
			
			String qualifiedGroupName = propertyDeclaration.getGroup().getQualifiedName();
			if (qualifiedGroupName == null) {
				return null;
			}
			
			return getConverter().toQualifiedName(qualifiedGroupName).append(name);
		}
		if (obj instanceof SelectionPropertyOption) {
			String qualifiedName = ((SelectionPropertyOption) obj).getQualifiedName();
			if (qualifiedName == null) {
				return null;
			}
			return getConverter().toQualifiedName(qualifiedName);
		}
		if (obj instanceof Configuration) {
			Configuration configuration = (Configuration) obj;
			String packageName = configuration.getPackageName();
			if (packageName == null) {
				return null;
			}
			return getConverter().toQualifiedName(packageName).append(configuration.getName());
		}
		return super.getFullyQualifiedName(obj);
	}

}
