/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subsystem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Subsystem#getProvidedInterface <em>Provided Interface</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dml.DMLPackage#getSubsystem()
 * @model
 * @generated
 */
public interface Subsystem extends Component {

	/**
	 * Returns the value of the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Interfaces</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Interface</em>' reference.
	 * @see #setProvidedInterface(SystemInterface)
	 * @see org.eclipselabs.damos.dml.DMLPackage#getSubsystem_ProvidedInterface()
	 * @model required="true"
	 * @generated
	 */
	SystemInterface getProvidedInterface();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dml.Subsystem#getProvidedInterface <em>Provided Interface</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Interface</em>' reference.
	 * @see #getProvidedInterface()
	 * @generated
	 */
	void setProvidedInterface(SystemInterface value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<SubsystemRealization> getRealizations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" contextRequired="true" contextOrdered="false"
	 * @generated
	 */
	SubsystemRealization getRealization(Fragment context);
} // Subsystem
