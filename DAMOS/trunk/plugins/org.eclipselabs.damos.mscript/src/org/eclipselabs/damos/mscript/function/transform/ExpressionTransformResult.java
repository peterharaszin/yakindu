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

package org.eclipselabs.damos.mscript.function.transform;

import java.util.List;

/**
 * @author  Andreas Unger
 */
public class ExpressionTransformResult {

	private ITransformerContext context;
	private IExpressionTransformer transformer;
	private List<? extends IExpressionTarget> targets;

	/**
	 * 
	 */
	public ExpressionTransformResult(ITransformerContext context, IExpressionTransformer transformer,
			List<? extends IExpressionTarget> targets) {
		this.context = context;
		this.transformer = transformer;
		this.targets = targets;
	}

	/**
	 * @return the context
	 */
	public ITransformerContext getContext() {
		return context;
	}

	/**
	 * @return the transformer
	 */
	public IExpressionTransformer getTransformer() {
		return transformer;
	}

	/**
	 * @return the targets
	 */
	public List<? extends IExpressionTarget> getTargets() {
		return targets;
	}
	
}