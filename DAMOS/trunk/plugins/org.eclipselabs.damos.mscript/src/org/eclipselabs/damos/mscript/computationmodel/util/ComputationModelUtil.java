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

package org.eclipselabs.damos.mscript.computationmodel.util;

import org.eclipselabs.damos.mscript.DataTypeSpecifier;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelFactory;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperationKind;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping;

/**
 * @author Andreas Unger
 *
 */
public class ComputationModelUtil {

	public static ComputationModel constructDefaultComputationModel() {
		ComputationModel computationModel = ComputationModelFactory.eINSTANCE.createComputationModel();
		
		FloatingPointFormat floatingPointFormat = ComputationModelFactory.eINSTANCE.createFloatingPointFormat();
		floatingPointFormat.setKind(FloatingPointFormatKind.BINARY64);
		computationModel.getNumberFormats().add(floatingPointFormat);
		
		FixedPointFormat fixedPointFormat = ComputationModelFactory.eINSTANCE.createFixedPointFormat();
		fixedPointFormat.setIntegerLength(63);
		computationModel.getNumberFormats().add(fixedPointFormat);
		
		NumberFormatMapping mapping = ComputationModelFactory.eINSTANCE.createNumberFormatMapping();
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(MscriptFactory.eINSTANCE.createUnit());
		DataTypeSpecifier typeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		typeSpecifier.setDefinedType(realType);
		mapping.setTypeSpecifier(typeSpecifier);
		mapping.setNumberFormat(floatingPointFormat);
		computationModel.getNumberFormatMappings().add(mapping);

		mapping = ComputationModelFactory.eINSTANCE.createNumberFormatMapping();
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(MscriptFactory.eINSTANCE.createUnit());
		typeSpecifier = MscriptFactory.eINSTANCE.createDataTypeSpecifier();
		typeSpecifier.setDefinedType(integerType);
		mapping.setTypeSpecifier(typeSpecifier);
		mapping.setNumberFormat(fixedPointFormat);
		computationModel.getNumberFormatMappings().add(mapping);

		return computationModel;
	}
	
	public static FixedPointOperation getFixedPointOperation(FixedPointFormat fixedPointFormat, FixedPointOperationKind kind) {
		FixedPointOperation operation = fixedPointFormat.getOperation(kind);
		if (operation == null) {
			operation = ComputationModelFactory.eINSTANCE.createFixedPointOperation();
			operation.setKind(kind);
			operation.setIntermediateWordSize(fixedPointFormat.getWordSize());
			operation.setSaturate(false);
		}
		return operation;
	}
	
	public static NumberFormat getWidestNumberFormat(NumberFormat numberFormat1, NumberFormat numberFormat2) {
		if (numberFormat1 instanceof FloatingPointFormat && numberFormat2 instanceof FloatingPointFormat) {
			int rank1 = getFloatingPointFormatRank((FloatingPointFormat) numberFormat1);
			int rank2 = getFloatingPointFormatRank((FloatingPointFormat) numberFormat2);
			return rank1 > rank2 ? numberFormat1 : numberFormat2;
		}
		if (numberFormat1 instanceof FixedPointFormat && numberFormat2 instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat1 = (FixedPointFormat) numberFormat1;
			FixedPointFormat fixedPointFormat2 = (FixedPointFormat) numberFormat2;
			if (fixedPointFormat1.getIntegerLength() == fixedPointFormat2.getIntegerLength()) {
				return fixedPointFormat1.getFractionLength() > fixedPointFormat2.getFractionLength() ? fixedPointFormat1 : fixedPointFormat2;
			}
			return fixedPointFormat1.getIntegerLength() > fixedPointFormat2.getIntegerLength() ? fixedPointFormat1 : fixedPointFormat2;
		}
		return numberFormat1 instanceof FloatingPointFormat ? numberFormat1 : numberFormat2;
	}
	
	private static int getFloatingPointFormatRank(FloatingPointFormat floatingPointFormat) {
		switch (floatingPointFormat.getKind()) {
		case BINARY16:
			return 0;
		case BINARY32:
			return 1;
		case BINARY64:
			return 3;
		case BINARY128:
			return 5;
		case DECIMAL32:
			return 2;
		case DECIMAL64:
			return 4;
		case DECIMAL128:
			return 6;
		}
		throw new IllegalArgumentException();
	}
	
}
