package org.eclipselabs.damos.mscript.internal.computationmodel.operations;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.IntegerType;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelFactory;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormatKind;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping;
import org.eclipselabs.damos.mscript.computationmodel.PredefinedFixedPointFormatKind;

public class ComputationModelOperations {
	
	private static FixedPointFormat defaultIntegerNumberFormat;
	private static FloatingPointFormat defaultRealNumberFormat;

	public static NumberFormatMapping getNumberFormatMapping(ComputationModel computationModel, DataType dataType) {
		NumberFormatMapping foundMapping = null;
		DataType foundDataType = null;
		for (NumberFormatMapping mapping : computationModel.getNumberFormatMappings()) {
			DataType mappingDataType = mapping.getTypeSpecifier().getType();
			if (mappingDataType.isAssignableFrom(dataType)) {
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

	public static NumberFormat getNumberFormat(ComputationModel computationModel, DataType dataType) {
		NumberFormatMapping mapping = getNumberFormatMapping(computationModel, dataType);
		if (mapping == null) {
			if (dataType instanceof IntegerType) {
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
			defaultIntegerNumberFormat = ComputationModelFactory.eINSTANCE.createFixedPointFormat();
			defaultIntegerNumberFormat.setPredefinedKind(PredefinedFixedPointFormatKind.INT64);
		}
		return defaultIntegerNumberFormat;
	}
	
	/**
	 * @return
	 */
	private static NumberFormat getDefaultRealNumberFormat() {
		if (defaultRealNumberFormat == null) {
			defaultRealNumberFormat = ComputationModelFactory.eINSTANCE.createFloatingPointFormat();
			defaultRealNumberFormat.setKind(FloatingPointFormatKind.BINARY64);
		}
		return defaultRealNumberFormat;
	}

}
