/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getConfigurationDefinition <em>Configuration Definition</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverParameter()
 * @model
 * @generated
 */
public interface SolverParameter extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration Definition</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Definition</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Definition</em>' container reference.
	 * @see #setConfigurationDefinition(SolverConfigurationDefinition)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverParameter_ConfigurationDefinition()
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition#getParameters
	 * @model opposite="parameters" required="true" transient="false"
	 * @generated
	 */
	SolverConfigurationDefinition getConfigurationDefinition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getConfigurationDefinition <em>Configuration Definition</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Definition</em>' container reference.
	 * @see #getConfigurationDefinition()
	 * @generated
	 */
	void setConfigurationDefinition(SolverConfigurationDefinition value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverParameter_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SolverParameter
