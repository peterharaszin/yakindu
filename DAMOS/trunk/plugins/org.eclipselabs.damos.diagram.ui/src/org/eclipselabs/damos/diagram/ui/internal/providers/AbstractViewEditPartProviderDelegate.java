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

package org.eclipselabs.damos.diagram.ui.internal.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;

/**
 * @author Andreas Unger
 *
 */
abstract class AbstractViewEditPartProviderDelegate {

	private static final String TAG_INPUT = "input";
	private static final String TAG_OUTPUT = "output";
	private static final String TAG_CONTENT = "content";

	private static final String ATT_BLOCK_TYPE = "blockType";
	private static final String ATT_CLASS = "class";
	private static final String ATT_NAME = "name";
	private static final String ATT_HINT = "hint";
	
	private Map<String, BlockTypeMapping> mappings;
	
	public Class<?> getClazz(String qualifiedName) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(qualifiedName);
		if (mapping != null) {
			return mapping.getClazz();
		}
		return null;
	}
	
	public Class<?> getInputClass(String qualifiedName, String inputName) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(qualifiedName);
		if (mapping != null) {
			return mapping.getInputClass(inputName);
		}
		return null;
	}

	public Class<?> getOutputClass(String qualifiedName, String outputName) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(qualifiedName);
		if (mapping != null) {
			return mapping.getOutputClass(outputName);
		}
		return null;
	}

	public Class<?> getContentClass(String qualifiedName, String contentHint) {
		if (mappings == null) {
			loadMappings();
		}
		BlockTypeMapping mapping = mappings.get(qualifiedName);
		if (mapping != null) {
			return mapping.getContentClass(contentHint);
		}
		return null;
	}
	
	protected abstract String getExtensionPointName();
	protected abstract String getTag();
	
	private void loadMappings() {
		mappings = new HashMap<String, BlockTypeMapping>();
		
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(
				DiagramUIPlugin.PLUGIN_ID, getExtensionPointName());

		for (IExtension extension : extensionPoint.getExtensions()) {
			for (IConfigurationElement configurationElement : extension.getConfigurationElements()) {
				if (getTag().equals(configurationElement.getName())) {
					try {
						loadNotationElement(configurationElement);
					} catch (Exception e) {
						DiagramUIPlugin.getDefault().getLog().log(
								new Status(IStatus.ERROR, DiagramUIPlugin.PLUGIN_ID,
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
		String qualifiedName = getRequiredAttribute(notationElement, ATT_BLOCK_TYPE);
		String className = getRequiredAttribute(notationElement, ATT_CLASS);
		
		BlockTypeMapping blockTypeMapping = new BlockTypeMapping(qualifiedName, notationElement, className);
		
		for (IConfigurationElement child : notationElement.getChildren()) {
			if (TAG_INPUT.equals(child.getName())) {
				String name = getRequiredAttribute(child, ATT_NAME);
				String inputClassName = getRequiredAttribute(child, ATT_CLASS);
				blockTypeMapping.addInputMapping(name, new Mapping(qualifiedName, child, inputClassName));
			} else if (TAG_OUTPUT.equals(child.getName())) {
				String name = getRequiredAttribute(child, ATT_NAME);
				String outputClassName = getRequiredAttribute(child, ATT_CLASS);
				blockTypeMapping.addOutputMapping(name, new Mapping(qualifiedName, child, outputClassName));
			} else if (TAG_CONTENT.equals(child.getName())) {
				String hint = getRequiredAttribute(child, ATT_HINT);
				String contentClassName = getRequiredAttribute(child, ATT_CLASS);
				blockTypeMapping.addContentMapping(hint, new Mapping(qualifiedName, child, contentClassName));
			}
		}
		
		mappings.put(qualifiedName, blockTypeMapping);
	}
	
	private String getRequiredAttribute(IConfigurationElement configurationElement, String name) {
		String value = configurationElement.getAttribute(name);
		if (value == null) {
			throw new IllegalArgumentException("Missing '" + name + "' attribute");
		}
		return value;
	}

	private static class Mapping {
		
		private String qualifiedName;
		private IConfigurationElement configurationElement;
		private String className;
		private Class<?> clazz;
		
		/**
		 * 
		 */
		public Mapping(String qualifiedName, IConfigurationElement configurationElement, String className) {
			this.qualifiedName = qualifiedName;
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
				DiagramUIPlugin.getDefault().getLog().log(
						new Status(IStatus.ERROR, DiagramUIPlugin.PLUGIN_ID,
								"Failed to load class '"
								+ className
								+ "' in plug-in '"
								+ configurationElement.getDeclaringExtension().getNamespaceIdentifier()
								+ "' in extension of '"
								+ configurationElement.getDeclaringExtension().getExtensionPointUniqueIdentifier()
								+ "' block type '"
								+ qualifiedName
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
		public BlockTypeMapping(String qualifiedName, IConfigurationElement configurationElement, String className) {
			super(qualifiedName, configurationElement, className);
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
