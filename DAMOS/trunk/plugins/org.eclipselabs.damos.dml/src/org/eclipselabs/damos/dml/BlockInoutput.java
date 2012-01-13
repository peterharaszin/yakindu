/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Inoutput</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getBlockInoutput()
 * @model abstract="true"
 * @generated
 */
public interface BlockInoutput extends Inoutput {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	InoutputDefinition getDefinition();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.Inoutput#createPort()
	 */
	BlockPort createPort();
	
} // BlockInoutput
