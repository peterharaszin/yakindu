/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.Output;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Block</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Block#getInput(java.lang.String) <em>Get Input</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Block#getOutput(java.lang.String) <em>Get Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockOperations extends ComponentOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  BlockInput getInput(Block block, String name) {
		for (Input input : block.getInputs()) {
			if (input instanceof BlockInput) {
				BlockInput blockInput = (BlockInput) input;
				if (name.equals(blockInput.getDefinition().getName())) {
					return (BlockInput) input;
				}
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  BlockOutput getOutput(Block block, String name) {
		for (Output output : block.getOutputs()) {
			if (output instanceof BlockOutput) {
				BlockOutput blockOutput = (BlockOutput) output;
				if (name.equals(blockOutput.getDefinition().getName())) {
					return (BlockOutput) output;
				}
			}
		}
		return null;
	}

} // BlockOperations