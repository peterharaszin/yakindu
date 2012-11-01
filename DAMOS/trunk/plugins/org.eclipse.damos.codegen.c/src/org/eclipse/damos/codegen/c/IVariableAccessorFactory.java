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
package org.eclipse.damos.codegen.c;

import org.eclipse.damos.codegen.c.IVariableAccessorFactory.Default;
import org.eclipse.damos.dconfig.Configuration;
import org.eclipse.damos.execution.ComponentNode;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Andreas Unger
 *
 */
@ImplementedBy(Default.class)
public interface IVariableAccessorFactory {

	IVariableAccessor create(Configuration configuration, ComponentNode node);
	
	class Default implements IVariableAccessorFactory {

		@Inject
		private Injector injector;
		
		@Override
		public IVariableAccessor create(Configuration configuration, ComponentNode node) {
			IVariableAccessor variableAccessor = new VariableAccessor(configuration, node);
			injector.injectMembers(variableAccessor);
			return variableAccessor;
		}
		
	}
	
}
