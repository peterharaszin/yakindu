/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.mscript.internal.computation.operations;

import org.eclipse.damos.mscript.IntegerType;
import org.eclipse.damos.mscript.Type;
import org.eclipse.damos.mscript.computation.ComputationFactory;
import org.eclipse.damos.mscript.computation.ComputationModel;
import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormat;
import org.eclipse.damos.mscript.computation.FloatingPointFormatKind;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.computation.NumberFormatMapping;
import org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind;

public class ComputationModelOperations {
	
	private static FixedPointFormat defaultIntegerNumberFormat;
	private static FloatingPointFormat defaultRealNumberFormat;

	public static NumberFormatMapping getNumberFormatMapping(ComputationModel computationModel, Type type) {
		NumberFormatMapping foundMapping = null;
		Type foundDataType = null;
		for (NumberFormatMapping mapping : computationModel.getNumberFormatMappings()) {
			Type mappingDataType = mapping.getTypeSpecifier().getType();
			if (mappingDataType.isAssignableFrom(type)) {
				if (foundDataType != null) {
					if (foundDataType.isAssignableFrom(mappingDataType)) {
						foundMapping = mapping;
						foundDataType = mappingDataType;
					}
				} else {
					foundMapping = mapping;
					foundDataType = mappingDataType;
				}
			}
		}
		return foundMapping;
	}

	public static NumberFormat getNumberFormat(ComputationModel computationModel, Type type) {
		NumberFormatMapping mapping = getNumberFormatMapping(computationModel, type);
		if (mapping == null) {
			if (type instanceof IntegerType) {
				return getDefaultIntegerNumberFormat();
			}
			return getDefaultRealNumberFormat();
		}
		return mapping.getNumberFormat();
	}

	/**
	 * @return
	 */
	private static NumberFormat getDefaultIntegerNumberFormat() {
		if (defaultIntegerNumberFormat == null) {
			defaultIntegerNumberFormat = ComputationFactory.eINSTANCE.createFixedPointFormat();
			defaultIntegerNumberFormat.setPredefinedKind(PredefinedFixedPointFormatKind.INT64);
		}
		return defaultIntegerNumberFormat;
	}
	
	/**
	 * @return
	 */
	private static NumberFormat getDefaultRealNumberFormat() {
		if (defaultRealNumberFormat == null) {
			defaultRealNumberFormat = ComputationFactory.eINSTANCE.createFloatingPointFormat();
			defaultRealNumberFormat.setKind(FloatingPointFormatKind.BINARY64);
		}
		return defaultRealNumberFormat;
	}

}
