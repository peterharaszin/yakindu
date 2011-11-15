/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.features;

import org.yakindu.sct.generator.core.features.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CPPDefaultFeatureValueProvider extends
		AbstractDefaultFeatureValueProvider {

	public boolean isProviderFor(FeatureTypeLibrary library) {
		return CPPFeatureConstants.LIBRARY_NAME.equals(library.getName());
	}

	@Override
	protected void setDefaultValue(FeatureParameterValue parameterValue,
			Statechart statechart) {
		//TODO: Implement my default properties
	}

}
