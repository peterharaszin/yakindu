/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.transformation.uml2;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.Mapping;
import org.eclipse.xtend.typesystem.uml2.Setup;

public class YakinduSetup extends Setup {

	@Override
	public void setStandardUML2Setup(boolean b) {
		super.setStandardUML2Setup(b);
		String p = "Yakindu.profile.uml";
		URI uri = EcoreUtil2.getURI(p);
		if (uri != null && !uri.toString().equals(p)) {
			String path = uri.toString();
			final int mmIndex = path.lastIndexOf("/Yakindu.profile.uml");
			if (mmIndex < 0)
				throw new IllegalStateException("'Yakindu.profile.uml' not found in classpath.");
				
			path = path.substring(0, mmIndex);
			path = addJarProtocolIfNecessary(path);
			addUriMap(new Mapping("pathmap://YAKINDU_UML_PROFILES/", path + "/"));
		} else {
			throw new IllegalStateException("Missing required plugin 'org.eclipse.uml2.uml.resources' in classpath.");
		}
	}
	/**
	 * Fixes a resource path of a Jar file, if necessary.
	 * 
	 * @param path
	 *            A resource path
	 * @return If the path ends with '.jar', but has no protocol prefix 'jar:',
	 *         the prefix is prepended. Otherwise path is returned unchanged.
	 */
	private String addJarProtocolIfNecessary(String path) {
		if (path.indexOf(".jar!") != -1) {
			if (!path.startsWith("jar:"))
				path = "jar:" + path;
		}
		return path;
	}
}
