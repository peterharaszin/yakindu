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

package org.eclipselabs.damos.diagram.core.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramResource extends GMFResource {

	/**
	 * @param uri
	 */
	public BlockDiagramResource(URI uri) {
		super(uri);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl#createXMLHelper()
	 */
	@Override
	protected XMLHelper createXMLHelper() {
		return new XMIHelperImpl(this) {
			
			/* (non-Javadoc)
			 * @see org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl#getFeature(org.eclipse.emf.ecore.EClass, java.lang.String, java.lang.String)
			 */
			@Override
			public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name) {
				if (eClass == DMLPackage.eINSTANCE.getConnection()) {
					if ("sourcePort".equals(name)) {
						name = "source";
					} else if ("targetPort".equals(name)) {
						name = "target";
					}
				}
				return super.getFeature(eClass, namespaceURI, name);
			}
			
		};
	}

}
