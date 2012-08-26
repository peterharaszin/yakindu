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

package org.eclipselabs.damos.mscript.computation.util;

import org.eclipselabs.damos.mscript.AnonymousTypeSpecifier;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.computation.ComputationFactory;
import org.eclipselabs.damos.mscript.computation.ComputationModel;
import org.eclipselabs.damos.mscript.computation.FixedPointFormat;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computation.FloatingPointFormatKind;
import org.eclipselabs.damos.mscript.computation.NumberFormat;
import org.eclipselabs.damos.mscript.computation.NumberFormatMapping;
import org.eclipselabs.damos.mscript.computation.PredefinedFixedPointFormatKind;

/**
 * @author Andreas Unger
 *
 */
public class ComputationModelUtil {

	public static ComputationModel constructDefaultComputationModel() {
		ComputationModel computationModel = ComputationFactory.eINSTANCE.createComputationModel();
		
		FloatingPointFormat floatingPointFormat = ComputationFactory.eINSTANCE.createFloatingPointFormat();
		floatingPointFormat.setKind(FloatingPointFormatKind.BINARY64);
		
		FixedPointFormat fixedPointFormat = ComputationFactory.eINSTANCE.createFixedPointFormat();
		fixedPointFormat.setIntegerLength(64);
		
		NumberFormatMapping mapping = ComputationFactory.eINSTANCE.createNumberFormatMapping();
		RealType realType = MscriptFactory.eINSTANCE.createRealType();
		realType.setUnit(MscriptFactory.eINSTANCE.createUnit());
		AnonymousTypeSpecifier typeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
		typeSpecifier.setType(realType);
		mapping.setTypeSpecifier(typeSpecifier);
		mapping.setNumberFormat(floatingPointFormat);
		computationModel.getNumberFormatMappings().add(mapping);

		mapping = ComputationFactory.eINSTANCE.createNumberFormatMapping();
		IntegerType integerType = MscriptFactory.eINSTANCE.createIntegerType();
		integerType.setUnit(MscriptFactory.eINSTANCE.createUnit());
		typeSpecifier = MscriptFactory.eINSTANCE.createAnonymousTypeSpecifier();
		typeSpecifier.setType(integerType);
		mapping.setTypeSpecifier(typeSpecifier);
		mapping.setNumberFormat(fixedPointFormat);
		computationModel.getNumberFormatMappings().add(mapping);

		return computationModel;
	}
	
	public static FixedPointFormat createFixedPointFormat(PredefinedFixedPointFormatKind predefinedFixedPointFormatKind) {
		FixedPointFormat fixedPointFormat = ComputationFactory.eINSTANCE.createFixedPointFormat();
		fixedPointFormat.setPredefinedKind(predefinedFixedPointFormatKind);
		return fixedPointFormat;
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
