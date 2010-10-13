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

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.evaluation.internal.BlockEvaluationContext;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractBlockSignaturePolicy implements IComponentSignaturePolicy {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IComponentSignaturePolicy#evaluateSignature(org.eclipselabs.damos.evaluation.IEvaluationContext, org.eclipselabs.damos.dml.Component, java.util.Map)
	 */
	public final IComponentSignatureEvaluationResult evaluateSignature(Component component, Map<InputPort, DataType> incomingDataTypes) {
		if (!(component instanceof Block)) {
			throw new IllegalArgumentException();
		}
		return evaluateSignature(new BlockEvaluationContext((Block) component), (Block) component, incomingDataTypes);
	}

	public abstract IComponentSignatureEvaluationResult evaluateSignature(IEvaluationContext context, Block block, Map<InputPort, DataType> incomingDataTypes);

}
