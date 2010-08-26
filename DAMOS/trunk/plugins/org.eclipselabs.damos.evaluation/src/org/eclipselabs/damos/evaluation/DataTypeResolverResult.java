/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.evaluation;

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignature;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolverResult {

	private Map<Component, IComponentSignature> signatures = new HashMap<Component, IComponentSignature>();

	public Map<Component, IComponentSignature> getSignatures() {
		return signatures;
	}
	
}
