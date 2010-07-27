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
/**
 * 
 */
package com.yakindu.simulation.engine.statechart.test.testclasses.engine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.HashSet;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import com.yakindu.simulation.engine.statechart.engine.SCSupportVerifier;
import com.yakindu.simulation.engine.statechart.engine.utilities.exceptions.UnableToParseStatechart;
import com.yakindu.simulation.engine.statechart.test.Utilities;

import statemachine.Statechart;
import statemachine.StatemachinePackage;

/**
 * Defines test cases for the class <code>SCSupportVerifier</code>.
 * 
 * @author Philipp Richter
 */
public class Test_SCSupportVerifier {
	
	/** Defines the file of the current statechart file. */
	private File statechartFile = null;
	
	/**
	 * Allows to read a given statechart file.
	 * 
	 * @param path	defines the path of the statechart file
	 * 
	 * @return	The instantiated statechart.
	 */
	private Statechart setUp(String path) {
		
		// Reading of the statechart file
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().
		put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		ResourceSet resourceSet = new ResourceSetImpl();
		// The file extension is: "statemachine"
		resourceSet.getPackageRegistry().
		put("statemachine", StatemachinePackage.eINSTANCE);
		URI fileURI = URI.createURI("file:///" + path); 
		
		Resource resource = resourceSet.getResource(fileURI,true);
		return (Statechart) resource.getContents().get(0);
	}


	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSupportVerifier#SCSupportVerifier()}.
	 */
	@Test
	public void testStatechartSupportVerifier() {
		// not needed
	}
	
	/**
	 * Test method for {@link com.yakindu.simulation.engine.statechart.engine.SCSupportVerifier#checkSupport(statemachine.Statechart)}.
	 */
	@Test
	public void testCheckSupport() throws UnableToParseStatechart {
		
		SCSupportVerifier verifier = new SCSupportVerifier();
		HashSet<String> result = null;
		
		// --- Exceptional case ---

		// Statechart is null
		try {
			result = verifier.checkSupport(null);
			fail("The verifier has not detected that the statechart is \"null\"!");
		} catch (UnableToParseStatechart e) {}
		
		// Statechart has no name or the name is ""
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutName.statemachine"));
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not detected that the statechart has no name (=null) or more than one support messages were generated!", 1, result.size());
		
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutNameEmpty.statemachine"));
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not detected that the statechart has no name (=\"\") or more than one support messages were generated!", 1, result.size());
				
		// Statechart has no uuid or the uuid is ""
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutUUID.statemachine"));
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not detected that the statechart has no uuid (=null) or more than one support messages were generated!", 1, result.size());
		
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/initialization/WithoutUUIDEmpty.statemachine"));
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not detected that the statechart has no uuid (=\"\") or more than one support messages were generated!", 1, result.size());
		
		// Not supported Elements
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/verifier/NotSupported.statemachine"));		
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not found the expected number of unsupported elements!", 5, result.size());
		
		// Transition has no source state and another has no target state
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/verifier/NoSourceState.statemachine"));		
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not found the expected number of unsupported elements!", 2, result.size());
		
		// Source/Target state has no name
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/verifier/SourceStateHasNoName.statemachine"));		
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not found the expected number of unsupported elements!", 3, result.size());
		
		// Empty diagram
		statechartFile = new File(Utilities.getFile(getClass(), "com/yakindu/simulation/engine/statechart/test/resources/verifier/EmptyDiagram.statemachine"));		
		result = verifier.checkSupport(setUp(statechartFile.getAbsolutePath()));
		System.out.println(result + "\n\n");
		assertEquals("The verifier has not detected that the state diagram has no region!", 1, result.size());
	}
}