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

package org.eclipse.damos.dml.resource;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

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
	 * This class is used to make models backwards-compatible.
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
		 * @see org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl#getType(org.eclipse.emf.ecore.EFactory, java.lang.String)
		 */
		@Override
		public EClassifier getType(EFactory eFactory, String typeName) {
			if ("MscriptValueSpecification".equals(typeName)) {
				typeName = "DscriptValueSpecification";
			} else if ("MscriptDataTypeSpecification".equals(typeName)) {
				typeName = "DscriptDataTypeSpecification";
			} else if ("MscriptBlockType".equals(typeName)) {
				typeName = "DscriptBlockType";
			} else if ("MscriptSystemInterface".equals(typeName)) {
				typeName = "DscriptSystemInterface";
			}
			return super.getType(eFactory, typeName);
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
		
		/* (non-Javadoc)
		 * @see org.eclipse.emf.ecore.xmi.impl.XMLHelperImpl#createFromString(org.eclipse.emf.ecore.EFactory, org.eclipse.emf.ecore.EDataType, java.lang.String)
		 */
		@Override
		protected Object createFromString(EFactory eFactory, EDataType eDataType, String value) {
			if ("org.eclipselabs.damos.library.common.MultiShapeBlock.ShapeStyle".equals(value)) {
				value = "damos.blocks.MultiShapeBlock.ShapeStyle";
			} else if ("org.eclipselabs.damos.library.math.Sum.InputPortsStyle".equals(value)) {
				value = "damos.blocks.Sum.InputPortsStyle";
			}
			return super.createFromString(eFactory, eDataType, value);
		}
		
	}
	
}
