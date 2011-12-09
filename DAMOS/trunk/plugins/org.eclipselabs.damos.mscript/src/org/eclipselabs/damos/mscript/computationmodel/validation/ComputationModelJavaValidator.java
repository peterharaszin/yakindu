package org.eclipselabs.damos.mscript.computationmodel.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointOperation;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
 

public class ComputationModelJavaValidator extends AbstractComputationModelJavaValidator {

//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital", MyDslPackage.Literals.GREETING__NAME);
//		}
//	}

	@Check
	public void checkFloatingPointFormat(FloatingPointFormat floatingPointFormat) {
		switch (floatingPointFormat.getKind()) {
		case BINARY32:
		case BINARY64:
			break;
		default:
			error("Floating point format must be binary32 or binary64", ComputationModelPackage.eINSTANCE.getFloatingPointFormat_Kind(), -1);
			break;
		}
	}

	@Check
	public void checkFixedPointFormat(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getIntegerLength() <= 0) {
			error("Integer length must be >= 1", ComputationModelPackage.eINSTANCE.getFixedPointFormat_IntegerLength(), -1);
		} else {
			switch (fixedPointFormat.getWordSize()) {
			case 8:
			case 16:
			case 32:
			case 64:
				break;
			default:
				error("Word size must be 8, 16, 32, or 64 bit", ComputationModelPackage.eINSTANCE.getNumberFormat_Name());
				break;
			}

			for (FixedPointOperation operation : fixedPointFormat.getOperations()) {
				if (operation.getIntermediateWordSize() < fixedPointFormat.getWordSize()) {
					error("Intermediate word size must be >= " + fixedPointFormat.getWordSize(), operation, ComputationModelPackage.eINSTANCE.getFixedPointOperation_IntermediateWordSize(), -1);
				} else {
					switch (operation.getIntermediateWordSize()) {
					case 8:
					case 16:
					case 32:
					case 64:
						break;
					default:
						error("Intermediate word size must be 8, 16, 32, or 64 bit", operation, ComputationModelPackage.eINSTANCE.getFixedPointOperation_IntermediateWordSize(), -1);
						break;
					}
				}
			}
		}
	}

}
