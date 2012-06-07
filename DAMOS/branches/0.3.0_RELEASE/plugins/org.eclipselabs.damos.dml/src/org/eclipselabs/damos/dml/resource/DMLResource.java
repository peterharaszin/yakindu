/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.dml.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class DMLResource extends XMIResourceImpl {

	/**
	 * 
	 */
	public DMLResource() {
		super();
	}
	
	public DMLResource(URI uri) {
		super(uri);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#useUUIDs()
	 */
	@Override
	protected boolean useUUIDs() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl#createXMLHelper()
	 */
	@Override
	protected XMLHelper createXMLHelper() {
		return new XMIHelper(this);
	}

	/**
	 * <em>Note: This class is not public API, it may be removed in the feature.</em>
	 * 
	 * @author Andreas Unger
	 * 
	 * @noextend
	 * @noimplement
	 */
	public static final class XMIHelper extends XMIHelperImpl {

		/**
		 * @param resource
		 */
		public XMIHelper(XMLResource resource) {
			super(resource);
		}
	
		/* (non-Javadoc)
		 * @see org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl#getFeature(org.eclipse.emf.ecore.EClass, java.lang.String, java.lang.String)
		 */
		@Override
		public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name) {
			if (DMLPackage.eINSTANCE.getConnection().isSuperTypeOf(eClass)) {
				if ("sourcePort".equals(name)) {
					name = "source";
				} else if ("targetPort".equals(name)) {
					name = "target";
				}
			} else if (DMLPackage.eINSTANCE.getSubsystem().isSuperTypeOf(eClass)) {
				if ("providedInterface".equals(name)) {
					name = "interface";
				}
			}
			return super.getFeature(eClass, namespaceURI, name);
		}
		
	}
	
}
