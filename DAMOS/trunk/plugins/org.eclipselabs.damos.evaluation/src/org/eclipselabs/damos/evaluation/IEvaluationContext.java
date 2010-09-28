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

import org.eclipse.core.runtime.CoreException;
import org.eclipselabs.mscript.language.ast.SymbolReference;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 * 
 * @noextend
 * @noimplement
 */
public interface IEvaluationContext {

	DataType getSymbolDataType(SymbolReference symbolReference) throws CoreException;
	
}
