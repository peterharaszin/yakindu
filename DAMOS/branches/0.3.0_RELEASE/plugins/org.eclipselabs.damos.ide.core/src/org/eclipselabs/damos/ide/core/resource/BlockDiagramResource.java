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

package org.eclipselabs.damos.ide.core.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipselabs.damos.dml.resource.DMLResource;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.dmltext.parser.antlr.MscriptDataTypeSpecificationParser;
import org.eclipselabs.damos.dmltext.parser.antlr.MscriptValueSpecificationParser;
import org.eclipselabs.damos.dmltext.util.DMLTextUtil;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramResource extends GMFResource {

	@Inject
	private MscriptValueSpecificationParser valueSpecificationParser;
	
	@Inject
	private MscriptDataTypeSpecificationParser dataTypeSpecificationParser;

	/**
	 * @param uri
	 */
	public BlockDiagramResource(URI uri) {
		super(uri);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl#doLoad(java.io.InputStream, java.util.Map)
	 */
	@Override
	public void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		super.doLoad(inputStream, options);
		for (Entry<EObject, AnyType> entry : getEObjectToExtensionMap().entrySet()) {
			String text = extractText(entry.getValue());
			if (text != null) {
				buildEObjectFromText(entry.getKey(), text);
			}
		}
	}
	
	private void buildEObjectFromText(EObject eObject, String text) {
		if (eObject instanceof MscriptValueSpecification) {
			IParseResult result = valueSpecificationParser.parse(new StringReader((text.toString())));
			if (!result.hasSyntaxErrors()) {
				EcoreUtil.replace(eObject, result.getRootASTElement());
			}
		} else if (eObject instanceof MscriptDataTypeSpecification) {
			IParseResult result = dataTypeSpecificationParser.parse(new StringReader((text.toString())));
			if (!result.hasSyntaxErrors()) {
				EcoreUtil.replace(eObject, result.getRootASTElement());
			}
		}
	}
	
	private String extractText(AnyType anyType) {
		AnyType value = getMixedEntry(anyType, "Extension");
		if (value != null && DMLTextPackage.eNS_URI.equals(getAttributeValue(value, "extender"))) {
			value = getMixedEntry(value, "text");
			for (FeatureMap.Entry entry : value.getMixed()) {
				if ("text".equals(entry.getEStructuralFeature().getName())) {
					return entry.getValue().toString();
				}
			}
		}
		return null;
	}
	
	private AnyType getMixedEntry(AnyType anyType, String name) {
		for (FeatureMap.Entry entry : anyType.getMixed()) {
			if (name.equals(entry.getEStructuralFeature().getName()) && entry.getValue() instanceof AnyType) {
				return (AnyType) entry.getValue();
			}
		}
		return null;
	}

	private Object getAttributeValue(AnyType anyType, String name) {
		for (FeatureMap.Entry attributeEntry : anyType.getAnyAttribute()) {
			if (name.equals(attributeEntry.getEStructuralFeature().getName())) {
				return attributeEntry.getValue();
			}
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl#createXMLHelper()
	 */
	@Override
	protected XMLHelper createXMLHelper() {
		return new DMLResource.XMIHelper(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.core.resources.GMFResource#createXMLSave()
	 */
	@Override
	protected XMLSave createXMLSave() {
		return new XMISaveImpl(createXMLHelper()) {
			
			/* (non-Javadoc)
			 * @see org.eclipse.emf.ecore.xmi.impl.XMLSaveImpl#saveFeatures(org.eclipse.emf.ecore.EObject, boolean)
			 */
			@Override
			protected boolean saveFeatures(EObject o, boolean attributesOnly) {
				String text = DMLTextUtil.getText(o);
				if (text != null) {
					doc.startElement("xmi:Extension");
					doc.addAttribute("extender", DMLTextPackage.eNS_URI);
					doc.startElement("text");
					doc.endContentElement(escape.convertText(text));
					doc.endElement();
					endSaveFeatures(o, 0, null);
					return true;
				}
				return super.saveFeatures(o, attributesOnly);
			}
			
		};
	}

}
