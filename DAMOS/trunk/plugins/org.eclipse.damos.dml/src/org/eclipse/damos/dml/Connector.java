/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connector</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.damos.dml.DMLPackage#getConnector()
 * @model abstract="true"
 * @generated
 */
public interface Connector extends EObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Connection> getConnections();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" contextRequired="true" contextOrdered="false"
	 * @generated
	 */
	EList<Connection> getConnections(Fragment context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" contextRequired="true" contextOrdered="false"
	 * @generated
	 */
	Connection getFirstConnection(Fragment context);
} // Connector
