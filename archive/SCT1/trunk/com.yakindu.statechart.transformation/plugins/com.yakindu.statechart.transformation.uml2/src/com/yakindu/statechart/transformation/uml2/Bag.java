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
package com.yakindu.statechart.transformation.uml2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dschmidt
 * 
 */
public class Bag {

	public final static Map<Object, Object> map = new HashMap<Object, Object>();

	public final static Object get(Object obj)
	{
		return map.get(obj);
	}

	public final static Object put(Object key, Object value)
	{
		return map.put(key, value);
	}

	public final static void clear() {
		map.clear();
	}

}
