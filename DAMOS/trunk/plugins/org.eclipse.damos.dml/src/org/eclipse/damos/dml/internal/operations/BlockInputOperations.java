/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockInputPort;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.DirectFeedthroughPolicy;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.internal.util.ConfigureUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Block Input</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.BlockInput#isDirectFeedthrough() <em>Is Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockInputOperations extends InputOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockInputOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isDirectFeedthrough(BlockInput blockInput) {
		DirectFeedthroughPolicy directFeedthroughPolicy = blockInput.getDefinition().getDirectFeedthroughPolicy();
		return directFeedthroughPolicy != null ? directFeedthroughPolicy.computeDirectFeedthrough() : true;
	}
	
	public static BlockInputPort createPort(BlockInput blockInput) {
		InputDefinition definition = blockInput.getDefinition();
		BlockInputPort port = DMLFactory.eINSTANCE.createBlockInputPort();
    	ConfigureUtil.configureParameters(port, definition);
    	blockInput.getPorts().add(port);
		return port;
	}

} // BlockInputOperations