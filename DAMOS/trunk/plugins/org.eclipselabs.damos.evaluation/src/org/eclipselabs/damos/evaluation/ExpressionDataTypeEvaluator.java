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
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public class ExpressionDataTypeEvaluator extends ExpressionEvaluator<DataType> {

	/**
	 * @param context
	 */
	public ExpressionDataTypeEvaluator(IEvaluationContext context) {
		super(context, new ExpressionDataTypeEvaluatorStrategy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public DataType defaultCase(EObject object) {
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

}
