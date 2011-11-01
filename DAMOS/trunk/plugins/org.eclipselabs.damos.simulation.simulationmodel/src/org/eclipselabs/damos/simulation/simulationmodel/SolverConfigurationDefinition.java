/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver Configuration Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverConfigurationDefinition()
 * @model
 * @generated
 */
public interface SolverConfigurationDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getConfigurationDefinition <em>Configuration Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverConfigurationDefinition_Parameters()
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverParameter#getConfigurationDefinition
	 * @model opposite="configurationDefinition" containment="true"
	 * @generated
	 */
	EList<SolverParameter> getParameters();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	SolverParameter getParameter(String name);

} // SolverConfigurationDefinition
