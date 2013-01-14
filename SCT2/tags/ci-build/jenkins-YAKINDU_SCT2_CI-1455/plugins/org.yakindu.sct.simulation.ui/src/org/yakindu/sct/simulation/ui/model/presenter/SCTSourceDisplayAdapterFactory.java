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
package org.yakindu.sct.simulation.ui.model.presenter;

import org.eclipse.core.runtime.IAdapterFactory;

/**
 * Returns a singleton instance of the {@link SCTSourceDisplay}
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTSourceDisplayAdapterFactory implements IAdapterFactory {

	private static SCTSourceDisplay display = new SCTSourceDisplay();

	public Object getAdapter(Object adaptableObject,
			@SuppressWarnings("rawtypes") Class adapterType) {
		return display;
	}

	public Class<?>[] getAdapterList() {
		return new Class[] { SCTSourceDisplay.class };
	}

}
