/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Compound Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.CompoundConnector#getCompound <em>Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getCompoundConnector()
 * @model abstract="true"
 * @generated
 */
public interface CompoundConnector extends Connector {
	/**
	 * Returns the value of the '<em><b>Compound</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Compound</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Compound</em>' reference.
	 * @see org.eclipse.damos.dml.DMLPackage#getCompoundConnector_Compound()
	 * @model required="true" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	Compound getCompound();

} // CompoundConnector
