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

package org.eclipse.damos.execution.datatype;

import java.util.Map;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.mscript.Type;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement This interface is <em>not</em> intended to be implemented by
 * clients. Clients should extend {@link AbstractComponentSignaturePolicy}.
 */
public interface IComponentSignaturePolicy {

	IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, Type> incomingDataTypes);
	
}
