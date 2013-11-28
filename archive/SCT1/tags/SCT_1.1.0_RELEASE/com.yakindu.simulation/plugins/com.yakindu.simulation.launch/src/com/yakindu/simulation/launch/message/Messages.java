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
package com.yakindu.simulation.launch.message;

import org.eclipse.osgi.util.NLS;

public final class Messages {

	private Messages() {
		// Do not instantiate
	}

	static {
		NLS.initializeMessages(
				"com.yakindu.simulation.launch.message.messages",
				Messages.class);
	}

	public static String DEBUG_CONTROLLER_NAME;
	public static String MAIN_INSTANCE;
}
