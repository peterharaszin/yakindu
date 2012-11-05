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

package org.eclipse.damos.mscript.function.transform;

import java.util.Collections;
import java.util.List;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExpressionTarget implements IExpressionTarget {

	public List<IExpressionTarget> asList() {
		return Collections.<IExpressionTarget>singletonList(this);
	}

}