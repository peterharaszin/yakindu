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

package org.eclipselabs.damos.mscript.codegen.c;

import org.eclipselabs.damos.mscript.computationmodel.ComputationModelFactory;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.PredefinedFixedPointFormatKind;

/**
 * @author Andreas Unger
 *
 */
public class NumericExpressionInfo {

	private final NumberFormat numberFormat;
	private final IWriter writer;
	
	/**
	 * 
	 */
	private NumericExpressionInfo(NumberFormat numberFormat, IWriter writer) {
		this.numberFormat = numberFormat;
		this.writer = writer;
	}
	
	/**
	 * @return the numberFormat
	 */
	public NumberFormat getNumberFormat() {
		return numberFormat;
	}
	
	/**
	 * @return the writer
	 */
	public IWriter getWriter() {
		return writer;
	}
	
	public static NumericExpressionInfo create(NumberFormat numberFormat, IWriter writer) {
		return new NumericExpressionInfo(numberFormat, writer);
	}
	
	public static NumericExpressionInfo create(PredefinedFixedPointFormatKind predefinedFixedPointFormatKind, IWriter writer) {
		FixedPointFormat fixedPointFormat = ComputationModelFactory.eINSTANCE.createFixedPointFormat();
		fixedPointFormat.setPredefinedKind(predefinedFixedPointFormatKind);
		return new NumericExpressionInfo(fixedPointFormat, writer);
	}

}
