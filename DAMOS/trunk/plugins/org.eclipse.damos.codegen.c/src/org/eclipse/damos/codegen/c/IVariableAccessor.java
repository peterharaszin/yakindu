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

import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.OutputPort;

/**
 * @author Andreas Unger
 *
 */
public interface IVariableAccessor {

	CharSequence generateContextVariableReference(boolean pointer);
	
	CharSequence generateInputVariableReference(InputPort inputPort, boolean pointer);
	
	CharSequence generateOutputVariableReference(OutputPort outputPort, boolean pointer);

	CharSequence generateMessageKindVariableReference(boolean pointer);
	
}
