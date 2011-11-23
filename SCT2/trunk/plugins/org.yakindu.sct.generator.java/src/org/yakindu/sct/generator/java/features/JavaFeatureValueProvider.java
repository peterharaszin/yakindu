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
package org.yakindu.sct.generator.java.features;

import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.BASE_PACKAGE;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.IMPLEMENTATION_SUFFIX;
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.LIBRARY_NAME;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class JavaFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	private static final String PACKAGE_NAME_REGEX = "([a-zA-Z_][a-zA-Z0-9_]*\\.)+[a-zA-Z_][a-zA-Z0-9_]*";
	private static final String SUFFIX_REGEX = "[a-zA-Z0-9_]*";

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			Statechart statechart) {
		if (parameterValue.getParameter().getName().equals(BASE_PACKAGE)) {
			parameterValue.setValue("org.yakindu.sct." + statechart.getName());
		} else if (parameterValue.getParameter().getName()
				.equals(IMPLEMENTATION_SUFFIX)) {
			parameterValue.setValue("impl");
		}
	}

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return library.getName().equals(LIBRARY_NAME);
	}

	public IStatus validateParameterValue(FeatureParameterValue value) {
		String name = value.getParameter().getName();
		if (BASE_PACKAGE.equals(name)
				&& !value.getStringValue().matches(PACKAGE_NAME_REGEX)) {
				return error("Invalid package name");
		}
		if (IMPLEMENTATION_SUFFIX.equals(name)
				&& !value.getStringValue().matches(SUFFIX_REGEX)) {
			return error("Invalid value");
		}
		return Status.OK_STATUS;
	}

}
