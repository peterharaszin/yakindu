/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.test.models;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.sct.domain.default_.modules.DefaultSequencerModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TestModelInjectorProvider implements IInjectorProvider {

	public Injector getInjector() {
		return Guice.createInjector(new DefaultSequencerModule());
	}

}
