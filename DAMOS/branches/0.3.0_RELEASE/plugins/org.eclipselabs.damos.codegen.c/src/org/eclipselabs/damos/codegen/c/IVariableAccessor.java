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

package org.eclipselabs.damos.codegen.c;

import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;

/**
 * @author Andreas Unger
 *
 */
public interface IVariableAccessor {

	String getContextVariable(boolean pointer);
	
	String getInputVariable(InputPort inputPort, boolean pointer);
	
	String getOutputVariable(OutputPort outputPort, boolean pointer);

	String getMessageKindVariable(boolean pointer);
	
}
