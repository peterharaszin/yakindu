package org.eclipselabs.damos.dml.internal.operations;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.DMLPackage;

/**
 * @author Andreas Unger
 *
 */
public class BlockOperations extends ComponentOperations {
	
	public static boolean isTimingConstraintApplicable(Block block, EClass eClass) {
		switch (block.getType().getTiming()) {
		case ANY:
			return eClass == DMLPackage.eINSTANCE.getContinuousTimingConstraint()
					|| eClass == DMLPackage.eINSTANCE.getSynchronousTimingConstraint()
					|| eClass == DMLPackage.eINSTANCE.getAsynchronousTimingConstraint();
		case CONTINUOUS:
			return eClass == DMLPackage.eINSTANCE.getContinuousTimingConstraint();
		case SYNCHRONOUS:
			return eClass == DMLPackage.eINSTANCE.getSynchronousTimingConstraint();
		case ASYNCHRONOUS:
			return eClass == DMLPackage.eINSTANCE.getAsynchronousTimingConstraint();
		case DISCRETE:
			return eClass == DMLPackage.eINSTANCE.getSynchronousTimingConstraint()
					|| eClass == DMLPackage.eINSTANCE.getAsynchronousTimingConstraint();
		}
		return false;
	}

}