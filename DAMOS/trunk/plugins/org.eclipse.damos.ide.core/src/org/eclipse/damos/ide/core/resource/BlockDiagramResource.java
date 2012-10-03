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

package org.eclipse.damos.ide.core.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.resource.DMLResource;
import org.eclipse.damos.dscript.DscriptDataTypeSpecification;
import org.eclipse.damos.dscript.DscriptPackage;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.damos.dscript.parser.antlr.DataTypeSpecificationParser;
import org.eclipse.damos.dscript.parser.antlr.ValueSpecificationParser;
import org.eclipse.damos.dscript.util.DscriptUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.ExceptionDiagnostic;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Triple;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Andreas Unger
 *
 */
public class BlockDiagramResource extends GMFResource {

	@Inject
	private ValueSpecificationParser valueSpecificationParser;
	
	@Inject
	private DataTypeSpecificationParser dataTypeSpecificationParser;

	@Inject
	private LazyURIEncoder encoder;

	@Inject
	private ILinker linker;
	
	@Inject
	private ILinkingService linkingService;

	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;

	private LinkedHashSet<Triple<EObject, EReference, INode>> resolving = Sets.newLinkedHashSet();

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
		for (Fragment fragment : EcoreUtil.<Fragment>getObjectsByType(getContents(), DMLPackage.eINSTANCE.getFragment())) {
			linker.linkModel(fragment, new ListBasedDiagnosticConsumer());
		}
	}
	
	private void buildEObjectFromText(EObject eObject, String text) {
		if (eObject instanceof DscriptValueSpecification) {
			IParseResult result = valueSpecificationParser.parse(new StringReader((text.toString())));
			if (!result.hasSyntaxErrors()) {
				EcoreUtil.replace(eObject, result.getRootASTElement());
			}
		} else if (eObject instanceof DscriptDataTypeSpecification) {
			IParseResult result = dataTypeSpecificationParser.parse(new StringReader((text.toString())));
			if (!result.hasSyntaxErrors()) {
				EcoreUtil.replace(eObject, result.getRootASTElement());
			}
		}
	}
	
	private String extractText(AnyType anyType) {
		AnyType value = getMixedEntry(anyType, "Extension");
		if (isDamosExtender(value)) {
			value = getMixedEntry(value, "text");
			for (FeatureMap.Entry entry : value.getMixed()) {
				if ("text".equals(entry.getEStructuralFeature().getName())) {
					return entry.getValue().toString();
				}
			}
		}
		return null;
	}
	
	private boolean isDamosExtender(AnyType value) {
		if (value != null) {
			Object attributeValue = getAttributeValue(value, "extender");
			if (attributeValue != null) {
				String a = attributeValue.toString();
				return a.equals(DscriptPackage.eNS_URI)
						/* Backwards-compatibility: */
						|| a.equals("http://www.eclipselabs.org/damos/2011/Dscript")
						|| a.equals("http://www.eclipselabs.org/damos/2011/DMLText");
			}
		}
		return false;
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
				String text = DscriptUtil.getText(o);
				if (text != null) {
					doc.startElement("xmi:Extension");
					doc.addAttribute("extender", DscriptPackage.eNS_URI);
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
	
	@Override
	public synchronized EObject getEObject(String uriFragment) {
		try {
			if (encoder.isCrossLinkFragment(this, uriFragment)) {
				Triple<EObject, EReference, INode> triple = encoder.decode(this, uriFragment);
				try {
					if (!resolving.add(triple)) {
//						return handleCyclicResolution(triple);
					}
					Set<String> unresolveableProxies = cache.get("UNRESOLVEABLE_PROXIES", this,
							new Provider<Set<String>>() {

								public Set<String> get() {
									return Sets.newHashSet();
								}

							});
					if (unresolveableProxies.contains(uriFragment)) {
						return null;
					}
					EReference reference = triple.getSecond();
					List<EObject> linkedObjects = linkingService.getLinkedObjects(triple.getFirst(), reference,
							triple.getThird());

					if (linkedObjects.isEmpty()) {
						if (isUnresolveableProxyCacheable(triple)) {
							unresolveableProxies.add(uriFragment);
						}
//						createAndAddDiagnostic(triple);
						return null;
					}
					if (linkedObjects.size() > 1) {
						throw new IllegalStateException("linkingService returned more than one object for fragment "
								+ uriFragment);
					}
					EObject result = linkedObjects.get(0);
					if (!EcoreUtil2.isAssignableFrom(reference.getEReferenceType(), result.eClass())) {
//						log.error("An element of type " + result.getClass().getName()
//								+ " is not assignable to the reference " + reference.getEContainingClass().getName()
//								+ "." + reference.getName());
						if (isUnresolveableProxyCacheable(triple)) {
							unresolveableProxies.add(uriFragment);
						}
//						createAndAddDiagnostic(triple);
						return null;
					}

					// remove previously added error markers, since everything
					// should be fine now
					unresolveableProxies.remove(uriFragment);
//					removeDiagnostic(triple);
					return result;
				} catch (IllegalNodeException ex) {
//					createAndAddDiagnostic(triple, ex);
				} finally {
					resolving.remove(triple);
				}
			}
		} catch (RuntimeException e) {
			getErrors().add(new ExceptionDiagnostic(e));
//			log.error("resolution of uriFragment '" + uriFragment + "' failed.", e);
			// wrapped because the javaDoc of this method states that
			// WrappedExceptions are thrown
			// logged because EcoreUtil.resolve will ignore any exceptions.
			throw new WrappedException(e);
		}
		return super.getEObject(uriFragment);
	}

	protected boolean isUnresolveableProxyCacheable(Triple<EObject, EReference, INode> triple) {
		return true;
	}

}
