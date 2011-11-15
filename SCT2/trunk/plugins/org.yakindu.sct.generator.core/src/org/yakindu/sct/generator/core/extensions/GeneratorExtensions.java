/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.extensions;

import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.yakindu.sct.generator.core.ISCTGenerator;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author holger willebrandt - Initial contribution and API
 */
public class GeneratorExtensions {

	private static final String EXTENSION_POINT_ID = "org.yakindu.sct.generator.core.generator";
	private static final String ATTRIBUTE_CLASS = "class";
	private static final String ATTRIBUTE_ID = "id";
	private static final String ATTRIBUTE_NAME = "name";
	@SuppressWarnings("unused")
	private static final String ATTRIBUTE_ICON = "icon";

	private static Iterable<GeneratorDescriptor> generatorDescriptors;

	public static class GeneratorDescriptor {
		private final IConfigurationElement configElement;

		GeneratorDescriptor(IConfigurationElement configElement) {
			this.configElement = configElement;
		}

		public ISCTGenerator createGenerator() {
			try {
				return (ISCTGenerator) configElement
						.createExecutableExtension(ATTRIBUTE_CLASS);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			return null;
		}

		public String getId() {
			return configElement.getAttribute(ATTRIBUTE_ID);
		}

		public String getName() {
			return configElement.getAttribute(ATTRIBUTE_NAME);
		}

		public Image getImage() {
			return null;
			// TODO
			// String iconPath = configElement.getAttribute(ATTRIBUTE_ICON);
			// ImageDescriptor descriptor = ImageDescriptor.createFromFile(
			// getClass(), iconPath);
			// return descriptor.createImage();
		}
	}

	public static Iterable<GeneratorDescriptor> getGeneratorDescriptors() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						EXTENSION_POINT_ID);
		if (generatorDescriptors == null) {
			generatorDescriptors = transform(
					newArrayList(configurationElements),
					new CreateGeneratorDescriptor());
		}
		return generatorDescriptors;
	}

	public static GeneratorDescriptor getGeneratorDescriptorForId(
			final String generatorId) {
		return Iterables.find(getGeneratorDescriptors(),
				new Predicate<GeneratorDescriptor>() {
					public boolean apply(GeneratorDescriptor input) {
						return input.getId().equals(generatorId);
					}
				});
	}

	private static final class CreateGeneratorDescriptor implements
			Function<IConfigurationElement, GeneratorDescriptor> {

		public GeneratorDescriptor apply(IConfigurationElement from) {
			return new GeneratorDescriptor(from);
		}
	}

}
