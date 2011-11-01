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
import org.eclipselabs.damos.mscript.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simulation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getTopLevelFragment <em>Top Level Fragment</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSimulationTime <em>Simulation Time</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSolverConfiguration <em>Solver Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidSimulationTime'"
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
	 * @model
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
	 * @model
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
	 * Returns the value of the '<em><b>Simulation Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simulation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simulation Time</em>' containment reference.
	 * @see #setSimulationTime(Expression)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel_SimulationTime()
	 * @model containment="true"
	 * @generated
	 */
	Expression getSimulationTime();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSimulationTime <em>Simulation Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simulation Time</em>' containment reference.
	 * @see #getSimulationTime()
	 * @generated
	 */
	void setSimulationTime(Expression value);

	/**
	 * Returns the value of the '<em><b>Solver Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Solver Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Solver Configuration</em>' containment reference.
	 * @see #setSolverConfiguration(SolverConfiguration)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel_SolverConfiguration()
	 * @model containment="true"
	 * @generated
	 */
	SolverConfiguration getSolverConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getSolverConfiguration <em>Solver Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Solver Configuration</em>' containment reference.
	 * @see #getSolverConfiguration()
	 * @generated
	 */
	void setSolverConfiguration(SolverConfiguration value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see #setQualifiedName(String)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSimulationModel_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SimulationModel#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

} // SimulationModel
