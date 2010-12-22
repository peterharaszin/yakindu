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

package org.eclipselabs.damos.evaluation.internal.providers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipselabs.mscript.computation.core.value.AbstractValueDecorator;
import org.eclipselabs.mscript.computation.core.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class InoutputValueDecorator extends AbstractValueDecorator {

	private Map<String, IValue> properties = new HashMap<String, IValue>();

	/**
	 * @param decoratedValue
	 */
	public InoutputValueDecorator(IValue decoratedValue) {
		super(decoratedValue);
	}
	
	public void addProperty(String name, IValue value) {
		properties.put(name, value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValueDecorator#getProperty(java.lang.String, java.util.List)
	 */
	@Override
	public IValue getProperty(String name, List<IValue> arguments) {
		if (arguments != null) {
			return null;
		}
		return properties.get(name);
	}
	
}
