/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSimulationTime <em>Simulation Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel()
 * @model
 * @generated
 */
public interface SimulationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Execution Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Model</em>' reference.
	 * @see #setExecutionModel(ExecutionModel)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel_ExecutionModel()
	 * @model required="true"
	 * @generated
	 */
	ExecutionModel getExecutionModel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getExecutionModel <em>Execution Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Model</em>' reference.
	 * @see #getExecutionModel()
	 * @generated
	 */
	void setExecutionModel(ExecutionModel value);

	/**
	 * Returns the value of the '<em><b>Top Level Fragment</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Top Level Fragment</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Top Level Fragment</em>' reference.
	 * @see #setTopLevelFragment(Fragment)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel_TopLevelFragment()
	 * @model required="true"
	 * @generated
	 */
	Fragment getTopLevelFragment();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getTopLevelFragment <em>Top Level Fragment</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Top Level Fragment</em>' reference.
	 * @see #getTopLevelFragment()
	 * @generated
	 */
	void setTopLevelFragment(Fragment value);

	/**
	 * Returns the value of the '<em><b>Simulation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simulation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Time</em>' attribute.
	 * @see #setSimulationTime(double)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel_SimulationTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getSimulationTime();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSimulationTime <em>Simulation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Time</em>' attribute.
	 * @see #getSimulationTime()
	 * @generated
	 */
	void setSimulationTime(double value);

} // SimulationModel
