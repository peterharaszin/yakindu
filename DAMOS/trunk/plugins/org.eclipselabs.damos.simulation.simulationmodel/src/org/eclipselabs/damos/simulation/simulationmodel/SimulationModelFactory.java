/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage
 * @generated
 */
public interface SimulationModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimulationModelFactory eINSTANCE = org.eclipselabs.damos.simulation.simulationmodel.impl.SimulationModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simulation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simulation Model</em>'.
	 * @generated
	 */
	SimulationModel createSimulationModel();

	/**
	 * Returns a new object of class '<em>Solver Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solver Type</em>'.
	 * @generated
	 */
	SolverType createSolverType();

	/**
	 * Returns a new object of class '<em>Solver Configuration Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solver Configuration Definition</em>'.
	 * @generated
	 */
	SolverConfigurationDefinition createSolverConfigurationDefinition();

	/**
	 * Returns a new object of class '<em>Solver Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solver Parameter</em>'.
	 * @generated
	 */
	SolverParameter createSolverParameter();

	/**
	 * Returns a new object of class '<em>Solver Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solver Configuration</em>'.
	 * @generated
	 */
	SolverConfiguration createSolverConfiguration();

	/**
	 * Returns a new object of class '<em>Solver Argument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Solver Argument</em>'.
	 * @generated
	 */
	SolverArgument createSolverArgument();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimulationModelPackage getSimulationModelPackage();

} //SimulationModelFactory
