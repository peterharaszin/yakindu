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

package org.eclipselabs.damos.dconfig.internal.operations;

import org.eclipselabs.damos.dconfig.ConfigurationDefinition;
import org.eclipselabs.damos.dconfig.ConfigurationDefinitionMember;

/**
 * @author Andreas Unger
 *
 */
public class ConfigurationDefinitionMemberOperations {

	public static String getQualifiedName(ConfigurationDefinitionMember member) {
		ConfigurationDefinition owner = member.getOwner();
		if (owner != null && owner.getPackageName() != null) {
			String packageName = owner.getPackageName().trim();
			if (packageName.length() > 0) {
				return packageName + "." + member.getName();
			}
		}
		return member.getName();
	}

}
