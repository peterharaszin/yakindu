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
package org.yakindu.sct.simulation.core.debugmodel;

import org.eclipse.core.runtime.PlatformObject;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 *
 */
public class SCTDebugElement extends PlatformObject {

	private String resourceString;

	public SCTDebugElement(String resourceString) {
		this.resourceString = resourceString;
	}

	public String getResourceString() {
		return resourceString;
	}


}
