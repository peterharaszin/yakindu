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

package org.eclipselabs.damos.mscript.codegen.c.codefragments.factories;

import org.eclipselabs.damos.mscript.ArrayType;
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.codegen.c.ICodeFragment;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;

import com.google.inject.assistedinject.Assisted;

/**
 * @author Andreas Unger
 *
 */
public interface IScalarMultiplyFunctionFactory {

	ICodeFragment create(ComputationModel computationModel, @Assisted("scalarType") DataType scalarType, @Assisted("elementType") DataType elementType, ArrayType resultType);
	
}
