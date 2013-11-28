/**
 * Copyright (c) 2009 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.engine.statechart.test;

import java.io.File;

/**
 * Allows to define the absolute path of a specific resource with the given relative file path.
 */
public final class Utilities {
	
	/**
	 * Defines the absolute path of a given relative file path
	 * 
	 * @param clazz		defines the class which is the source of the call
	 * @param filename	defines the relative path of the sought absolute path
	 * 
	 * @return The absolute path of the given relative path.
	 */
	public static String getFile(final Class<?> clazz, final String filename){
		
//		assert (clazz != null);
//		ClassLoader loader  = clazz.getClassLoader();
//		assert (loader != null);
//		URL resource = loader.getResource(filename);
//		assert (resource != null);
//		String statechrtPart = new File(resource.getFile()).getAbsoluteFile().toString();

		/**
		 * HACK: Really bad hack for work with OSGi classloaders and default java
		 * class loaders. Should be changed when simulation engine and System doesn't work
		 * with absolute paths anymore.
		 */
		
		java.security.ProtectionDomain pd = clazz.getProtectionDomain();
		if ( pd == null ) return null;
		java.security.CodeSource cs = pd.getCodeSource();
		if ( cs == null ) return null;
		java.net.URL url = cs.getLocation();
		if ( url == null ) return null;
		java.io.File f = new File( url.getFile() );
		if (f == null) return null;
		String path = f.getAbsolutePath();
		return path+"/"+filename;
	}
}
