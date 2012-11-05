/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.codegen.c.internal;

import org.eclipse.damos.codegen.c.IComponentGenerator;
import org.eclipse.emf.common.notify.impl.AdapterImpl;

/**
 * @author Andreas Unger
 *
 */
public class ComponentGeneratorAdapter extends AdapterImpl {

	private IComponentGenerator generator;
	
	/**
	 * 
	 */
	public ComponentGeneratorAdapter(IComponentGenerator generator) {
		this.generator = generator;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ComponentGeneratorAdapter.class;
	}
	
	/**
	 * @return the generator
	 */
	public IComponentGenerator getGenerator() {
		return generator;
	}
	
	/**
	 * @param generator the generator to set
	 */
	public void setGenerator(IComponentGenerator generator) {
		this.generator = generator;
	}
	
}
