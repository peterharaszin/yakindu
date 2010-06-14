/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.simulation.perspective.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	/** Defines the bundle name of the messages file. */
	private static final String BUNDLE_NAME = "com.yakindu.simulation.perspective.messages.message";
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
	
	public static String toggleMenu;
}
