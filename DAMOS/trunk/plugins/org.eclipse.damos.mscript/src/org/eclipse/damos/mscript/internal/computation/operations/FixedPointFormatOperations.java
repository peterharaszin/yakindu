/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.mscript.internal.computation.operations;

import org.eclipse.damos.mscript.computation.FixedPointFormat;
import org.eclipse.damos.mscript.computation.NumberFormat;
import org.eclipse.damos.mscript.computation.PredefinedFixedPointFormatKind;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class FixedPointFormatOperations {

	public static PredefinedFixedPointFormatKind getPredefinedKind(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getSlope() == 1.0 && fixedPointFormat.getBias() == 0.0) {
			if (fixedPointFormat.getFractionLength() == 0) {
				if (fixedPointFormat.isUnsigned()) {
					switch (fixedPointFormat.getIntegerLength()) {
					case 8:
						return PredefinedFixedPointFormatKind.UINT8;
					case 16:
						return PredefinedFixedPointFormatKind.UINT16;
					case 32:
						return PredefinedFixedPointFormatKind.UINT32;
					case 64:
						return PredefinedFixedPointFormatKind.UINT64;
					case 128:
						return PredefinedFixedPointFormatKind.UINT128;
					}
				} else {
					switch (fixedPointFormat.getIntegerLength()) {
					case 8:
						return PredefinedFixedPointFormatKind.INT8;
					case 16:
						return PredefinedFixedPointFormatKind.INT16;
					case 32:
						return PredefinedFixedPointFormatKind.INT32;
					case 64:
						return PredefinedFixedPointFormatKind.INT64;
					case 128:
						return PredefinedFixedPointFormatKind.INT128;
					}
				}
			} else if (fixedPointFormat.getFractionLength() == 1 && !fixedPointFormat.isUnsigned()) {
				switch (fixedPointFormat.getIntegerLength()) {
				case 8:
					return PredefinedFixedPointFormatKind.FRACT8;
				case 16:
					return PredefinedFixedPointFormatKind.FRACT16;
				case 32:
					return PredefinedFixedPointFormatKind.FRACT32;
				case 64:
					return PredefinedFixedPointFormatKind.FRACT64;
				case 128:
					return PredefinedFixedPointFormatKind.FRACT128;
				}
			}
		}
		return PredefinedFixedPointFormatKind.NONE;
	}

	public static void setPredefinedKind(FixedPointFormat fixedPointFormat, PredefinedFixedPointFormatKind newPredefinedKind) {
		switch (newPredefinedKind) {
		case INT8:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(8);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case INT16:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(16);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case INT32:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(32);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case INT64:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(64);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case INT128:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(128);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;	
		case UINT8:
			fixedPointFormat.setUnsigned(true);
			fixedPointFormat.setIntegerLength(8);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case UINT16:
			fixedPointFormat.setUnsigned(true);
			fixedPointFormat.setIntegerLength(16);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case UINT32:
			fixedPointFormat.setUnsigned(true);
			fixedPointFormat.setIntegerLength(32);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case UINT64:
			fixedPointFormat.setUnsigned(true);
			fixedPointFormat.setIntegerLength(64);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case UINT128:
			fixedPointFormat.setUnsigned(true);
			fixedPointFormat.setIntegerLength(128);
			fixedPointFormat.setFractionLength(0);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;	
		case FRACT8:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(1);
			fixedPointFormat.setFractionLength(7);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case FRACT16:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(1);
			fixedPointFormat.setFractionLength(15);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case FRACT32:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(1);
			fixedPointFormat.setFractionLength(31);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case FRACT64:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(1);
			fixedPointFormat.setFractionLength(63);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		case FRACT128:
			fixedPointFormat.setUnsigned(false);
			fixedPointFormat.setIntegerLength(1);
			fixedPointFormat.setFractionLength(127);
			fixedPointFormat.setBias(0);
			fixedPointFormat.setSlope(1);
			break;
		default:
			// Do nothing
			break;	
		}
	}

	public static boolean isEquivalentTo(FixedPointFormat fixedPointFormat, NumberFormat other) {
		return EcoreUtil.equals(fixedPointFormat, other);
	}

}
