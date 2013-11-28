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
package com.yakindu.statechart.transformation.uml2.tests;

import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.TestSuite;

import org.eclipse.emf.mwe.core.resources.ResourceLoaderDefaultImpl;
import org.eclipse.emf.mwe.core.resources.ResourceLoaderFactory;

public class AllCoreTests extends TestSuite{
	public static junit.framework.Test suite() {
		// Workaround for not found file.
		// see http://www.openarchitectureware.org/forum/viewtopic.php?showtopic=8711
		ResourceLoaderFactory.setCurrentThreadResourceLoader(new ResourceLoaderDefaultImpl(){
			@Override
			protected java.net.URL loadFromContextClassLoader(String path) {
				URL resource = super.loadFromContextClassLoader(path);
				
				// Workaround
				// see http://www.openarchitectureware.org/forum/viewtopic.php?showtopic=8711
				  if (resource == null && "metamodels/UML.metamodel.uml".equals(path)) {
				    try {
				      resource = new URL("platform:/plugin/org.eclipse.uml2.uml.resources/metamodels/UML.metamodel.uml");
				    } catch (MalformedURLException e1) {
				    	e1.printStackTrace();
				    	throw new RuntimeException("URL should be valid", e1);
				    }
				  }
				return resource;
			}

		});
		TestSuite suite = new TestSuite(AllCoreTests.class.getName());
		suite.addTestSuite(TestExtendCoreTest.class);
		return suite;
	}

}
