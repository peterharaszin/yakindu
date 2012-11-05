/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.BlockOutputPort;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.internal.util.ConfigureUtil;


/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Block Output</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.BlockOutput#getDataTypePolicy() <em>Get Data Type Policy</em>}</li>
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