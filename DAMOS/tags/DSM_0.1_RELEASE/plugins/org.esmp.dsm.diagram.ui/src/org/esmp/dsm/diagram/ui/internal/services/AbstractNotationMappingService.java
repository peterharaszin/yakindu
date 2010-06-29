/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.diagram.ui.internal.services;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.esmp.dsm.diagram.ui.DSMDiagramUIPlugin;

/**
 * @author Andreas Unger
 *
 */
abstract class AbstractNotationMappingService {

	private static final String INPUT_ELEMENT = "input";
	private static final String OUTPUT_ELEMENT = "output";
	private static final String CONTENT_ELEMENT = "content";

	private static final String BLOCK_TYPE_URI_ATTRIBUTE = "blockTypeURI";
	private static final String CLASS_NAME_ATTRIBUTE = "class";
	private static final String NAME_ATTRIBUTE = "name";
	private static final String HINT_ATTRIBUTE = "hint";
	
	private Map<URI, BlockTypeMapping> mappings;
	
	public Class<?> getClazz(URI blockTypeURI) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(blockTypeURI);
		if (mapping != null) {
			return mapping.getClazz();
		}
		return null;
	}
	
	public Class<?> getInputClass(URI blockTypeURI, String inputName) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(blockTypeURI);
		if (mapping != null) {
			return mapping.getInputClass(inputName);
		}
		return null;
	}

	public Class<?> getOutputClass(URI blockTypeURI, String outputName) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(blockTypeURI);
		if (mapping != null) {
			return mapping.getOutputClass(outputName);
		}
		return null;
	}

	public Class<?> getContentClass(URI blockTypeURI, String contentHint) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(blockTypeURI);
		if (mapping != null) {
			return mapping.getContentClass(contentHint);
		}
		return null;
	}
	
	protected abstract String getExtensionPointName();
	protected abstract String getNotationName();
	
	private void loadMappings() {
		mappings = new HashMap<URI, BlockTypeMapping>();
		
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				DSMDiagramUIPlugin.PLUGIN_ID, getExtensionPointName());

		for (IExtension extension : extensionPoint.getExtensions()) {
			for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
				if (getNotationName().equals(configurationElement.getName())) {
					try {
						loadNotationElement(configurationElement);
					} catch (Exception e) {
						DSMDiagramUIPlugin.getDefault().getLog().log(
								new Status(IStatus.ERROR, DSMDiagramUIPlugin.PLUGIN_ID,
										"Failed to load block type in plug-in '"
										+ extension.getContributor().getName()
										+ "' in extension of '"
										+ extensionPoint.getUniqueIdentifier()
										+ "'", e));
					}
				}
			}
		}
	}
	
	private void loadNotationElement(IConfigurationElement notationElement) {
		String uriString = getRequiredAttribute(notationElement, BLOCK_TYPE_URI_ATTRIBUTE);
		String className = getRequiredAttribute(notationElement, CLASS_NAME_ATTRIBUTE);
		
		URI uri;
		try {
			uri = URI.createURI(uriString);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid block type URI specified: " + uriString, e);
		}
		
		BlockTypeMapping blockTypeMapping = new BlockTypeMapping(uri, notationElement, className);
		
		for (IConfigurationElement child : notationElement.getChildren()) {
			if (INPUT_ELEMENT.equals(child.getName())) {
				String name = getRequiredAttribute(child, NAME_ATTRIBUTE);
				String inputClassName = getRequiredAttribute(child, CLASS_NAME_ATTRIBUTE);
				blockTypeMapping.addInputMapping(name, new Mapping(uri, child, inputClassName));
			} else if (OUTPUT_ELEMENT.equals(child.getName())) {
				String name = getRequiredAttribute(child, NAME_ATTRIBUTE);
				String outputClassName = getRequiredAttribute(child, CLASS_NAME_ATTRIBUTE);
				blockTypeMapping.addOutputMapping(name, new Mapping(uri, child, outputClassName));
			} else if (CONTENT_ELEMENT.equals(child.getName())) {
				String hint = getRequiredAttribute(child, HINT_ATTRIBUTE);
				String contentClassName = getRequiredAttribute(child, CLASS_NAME_ATTRIBUTE);
				blockTypeMapping.addContentMapping(hint, new Mapping(uri, child, contentClassName));
			}
		}
		
		mappings.put(uri, blockTypeMapping);
	}
	
	private String getRequiredAttribute(IConfigurationElement configurationElement, String name) {
		String value = configurationElement.getAttribute(name);
		if (value == null) {
			throw new IllegalArgumentException("Missing '" + name + "' attribute");
		}
		return value;
	}

	private static class Mapping {
		
		private URI blockTypeURI;
		private IConfigurationElement configurationElement;
		private String className;
		private Class<?> clazz;
		
		/**
		 * 
		 */
		public Mapping(URI blockTypeURI, IConfigurationElement configurationElement, String className) {
			this.blockTypeURI = blockTypeURI;
			this.configurationElement = configurationElement;
			this.className = className;
		}
		
		public Class<?> getClazz() {
			if (clazz == null) {
				loadClass();
			}
			return clazz;
		}
		
		private void loadClass() {
			if (className == null) {
				return;
			}
			try {
				String nsid = configurationElement.getDeclaringExtension().getNamespaceIdentifier();
				clazz = Platform.getBundle(nsid).loadClass(className);
			} catch (ClassNotFoundException e) {
				DSMDiagramUIPlugin.getDefault().getLog().log(
						new Status(IStatus.ERROR, DSMDiagramUIPlugin.PLUGIN_ID,
								"Failed to load class '"
								+ className
								+ "' in plug-in '"
								+ configurationElement.getDeclaringExtension().getNamespaceIdentifier()
								+ "' in extension of '"
								+ configurationElement.getDeclaringExtension().getExtensionPointUniqueIdentifier()
								+ "' block type URI '"
								+ blockTypeURI
								+ "'", e));
			}
		}
		
	}
	
	private static class BlockTypeMapping extends Mapping {

		private Map<String, Mapping> inputMappings;
		private Map<String, Mapping> outputMappings;
		private Map<String, Mapping> contentMappings;
		
		/**
		 * 
		 */
		public BlockTypeMapping(URI blockTypeURI, IConfigurationElement configurationElement, String className) {
			super(blockTypeURI, configurationElement, className);
		}
		
		public void addInputMapping(String name, Mapping mapping) {
			if (inputMappings == null) {
				inputMappings = new HashMap<String, Mapping>();
			}
			inputMappings.put(name, mapping);
		}
		
		public void addOutputMapping(String name, Mapping mapping) {
			if (outputMappings == null) {
				outputMappings = new HashMap<String, Mapping>();
			}
			outputMappings.put(name, mapping);
		}

		public void addContentMapping(String hint, Mapping mapping) {
			if (contentMappings == null) {
				contentMappings = new HashMap<String, Mapping>();
			}
			contentMappings.put(hint, mapping);
		}

		public Class<?> getInputClass(String inputName) {
			if (inputMappings != null) {
				Mapping mapping = inputMappings.get(inputName);
				if (mapping != null) {
					return mapping.getClazz();
				}
			}
			return null;
		}

		public Class<?> getOutputClass(String outputName) {
			if (outputMappings != null) {
				Mapping mapping = outputMappings.get(outputName);
				if (mapping != null) {
					return mapping.getClazz();
				}
			}
			return null;
		}

		public Class<?> getContentClass(String contentHint) {
			if (contentMappings != null) {
				Mapping mapping = contentMappings.get(contentHint);
				if (mapping != null) {
					return mapping.getClazz();
				}
			}
			return null;
		}
		
	}
	
}
