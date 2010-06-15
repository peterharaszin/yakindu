/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.simulation.statemachine.tools;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import statemachine.Statechart;

/**
 * This class contains static methods which provide
 * common functionality.
 * 
 * @author Markus M�hlbrandt
 */
public class StatemachineTools {
	
	/**
	 * Loads and returns the {@link Statechart} from the given <code>fileURI</code>.
	 * 
	 * @param fileURI	defines the absolute path of the statechart file
	 * 
	 * @return	The <code>Statechart</code> instance which was created by the given
	 * 			<code>fileURI</code>.
	 */
	public static Statechart getStatemachineModel(URI fileURI){
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
		Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		// Register the package -- only needed for stand-alone!
		//StatemachinePackage statemachinePackage = StatemachinePackage.eINSTANCE;

		// Get the URI of the model file.
		//URI fileURI = URI.createURI("/Heizregler/heatcontrol.statemachine");//URI.createFileURI(new File("/Heizregler/heatcontrol.statemachine").getAbsolutePath());
		
		// Demand load the resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);
		EList<EObject> list = resource.getContents();
		if (list!=null)
			if (list.get(0) instanceof Statechart)
				return (Statechart) list.get(0);
		return null;
	}
}
