/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.execution.engine;

import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public class ComponentExecutionInfo implements IComponentExecutionInfo {

	private Component component;
	private IComponentSignature componentSignature;
	
	/**
	 * 
	 */
	public ComponentExecutionInfo(Component component, IComponentSignature componentSignature) {
		this.component = component;
		this.componentSignature = componentSignature;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.execution.engine.IComponentExecutionInfo#getComponent()
	 */
	public Component getComponent() {
		return component;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.execution.engine.IComponentExecutionInfo#getComponentSignature()
	 */
	public IComponentSignature getComponentSignature() {
		return componentSignature;
	}

}
