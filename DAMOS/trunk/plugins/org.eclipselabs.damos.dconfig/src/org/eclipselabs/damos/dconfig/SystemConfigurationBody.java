/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Configuration Body</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getBindings <em>Bindings</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getComponentConfigurations <em>Component Configurations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getFragmentConfigurations <em>Fragment Configurations</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getSubsystemConfigurations <em>Subsystem Configurations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSystemConfigurationBody()
 * @model
 * @generated
 */
public interface SystemConfigurationBody extends PropertyContainer {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dconfig.SystemConfiguration#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(SystemConfiguration)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSystemConfigurationBody_Owner()
	 * @see org.eclipselabs.damos.dconfig.SystemConfiguration#getBody
	 * @model opposite="body" transient="false"
	 * @generated
	 */
	SystemConfiguration getOwner();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.SystemConfigurationBody#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(SystemConfiguration value);

	/**
	 * Returns the value of the '<em><b>Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.Binding}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bindings</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSystemConfigurationBody_Bindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<Binding> getBindings();

	/**
	 * Returns the value of the '<em><b>Component Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.ComponentConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component Configurations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSystemConfigurationBody_ComponentConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComponentConfiguration> getComponentConfigurations();

	/**
	 * Returns the value of the '<em><b>Fragment Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.FragmentConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment Configurations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSystemConfigurationBody_FragmentConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<FragmentConfiguration> getFragmentConfigurations();

	/**
	 * Returns the value of the '<em><b>Subsystem Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.dconfig.SubsystemConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subsystem Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subsystem Configurations</em>' containment reference list.
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getSystemConfigurationBody_SubsystemConfigurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<SubsystemConfiguration> getSubsystemConfigurations();

} // SystemConfigurationBody
