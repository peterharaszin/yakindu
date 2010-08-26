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

package org.eclipselabs.damos.evaluation.componentsignature;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public interface IComponentSignaturePolicy {

	IComponentSignature evaluateSignature(IEvaluationContext context, Component component, Map<InputPort, DataType> incomingDataTypes, DiagnosticChain diagnostics);
	
}
