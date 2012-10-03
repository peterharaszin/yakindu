package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.emf.ecore.EClass;

/**
 * @author Andreas Unger
 *
 */
public class BlockOperations extends ComponentOperations {
	
	public static BlockInput getInput(Block block, InputDefinition definition) {
		for (Input input : block.getInputs()) {
			if (input instanceof BlockInput) {
				BlockInput blockInput = (BlockInput) input;
				if (blockInput.getDefinition() == definition) {
					return blockInput;
				}
			}
		}
		return null;
	}
	
	public static BlockOutput getOutput(Block block, OutputDefinition definition) {
		for (Output output : block.getOutputs()) {
			if (output instanceof BlockOutput) {
				BlockOutput blockOutput = (BlockOutput) output;
				if (blockOutput.getDefinition() == definition) {
					return blockOutput;
				}
			}
		}
		return null;
	}

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