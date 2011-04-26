/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.internal.util.ConfigureUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Block Input</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.BlockInput#isDirectFeedthrough() <em>Is Direct Feedthrough</em>}</li>
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