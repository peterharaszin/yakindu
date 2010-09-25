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

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.mscript.language.ast.SymbolReference;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class ComponentEvaluationContext implements IEvaluationContext {

	private Component component;
	
	/**
	 * 
	 */
	public ComponentEvaluationContext(Component component) {
		this.component = component;
	}
	
	/**
	 * @return the component
	 */
	public Component getComponent() {
		return component;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IEvaluationContext#getSymbolDataType(org.eclipselabs.mscript.language.ast.SymbolReference)
	 */
	public DataType getSymbolDataType(SymbolReference symbolReference) {
		return null;
	}

}
