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

import org.eclipse.emf.ecore.EObject;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionValueEvaluator extends ExpressionEvaluator<IValue> {

	/**
	 * @param context
	 * @param strategy
	 */
	public ExpressionValueEvaluator(IEvaluationContext context) {
		super(context, new ExpressionValueEvaluatorStrategy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.scripting.mscript.util.MscriptSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public IValue defaultCase(EObject object) {
		return InvalidValue.SINGLETON;
	}

}
