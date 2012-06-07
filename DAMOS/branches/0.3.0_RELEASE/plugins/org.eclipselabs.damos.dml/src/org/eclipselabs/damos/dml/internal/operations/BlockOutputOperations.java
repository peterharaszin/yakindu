/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.internal.util.ConfigureUtil;


/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Block Output</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.BlockOutput#getDataTypePolicy() <em>Get Data Type Policy</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BlockOutputOperations extends InoutputOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockOutputOperations() {
		super();
	}
	
	public static BlockOutputPort createPort(BlockOutput blockOutput) {
		OutputDefinition definition = blockOutput.getDefinition();
		BlockOutputPort port = DMLFactory.eINSTANCE.createBlockOutputPort();
    	ConfigureUtil.configureParameters(port, definition);
    	blockOutput.getPorts().add(port);
		return port;
	}

} // BlockOutputOperations