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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.FeatureReference;
import org.eclipselabs.damos.mscript.Type;


/**
 * @author Andreas Unger
 *
 */
public interface IExpressionTarget {

	void assignExpression(Expression expression);
	
	FeatureReference createVariableReference(Type targetDataType);
	
	VariableExpressionTarget toVariableExpressionTarget(Type targetDataType);
	
}
