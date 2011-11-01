/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelFactory;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SolverArgument;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition;
import org.eclipselabs.damos.simulation.simulationmodel.SolverParameter;
import org.eclipselabs.damos.simulation.simulationmodel.SolverType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimulationModelFactoryImpl extends EFactoryImpl implements SimulationModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SimulationModelFactory init() {
		try {
			SimulationModelFactory theSimulationModelFactory = (SimulationModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/2011/SimulationModel"); 
			if (theSimulationModelFactory != null) {
				return theSimulationModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SimulationModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SimulationModelPackage.SIMULATION_MODEL: return createSimulationModel();
			case SimulationModelPackage.SOLVER_TYPE: return createSolverType();
			case SimulationModelPackage.SOLVER_CONFIGURATION_DEFINITION: return createSolverConfigurationDefinition();
			case SimulationModelPackage.SOLVER_PARAMETER: return createSolverParameter();
			case SimulationModelPackage.SOLVER_CONFIGURATION: return createSolverConfiguration();
			case SimulationModelPackage.SOLVER_ARGUMENT: return createSolverArgument();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModel createSimulationModel() {
		SimulationModelImpl simulationModel = new SimulationModelImpl();
		return simulationModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverType createSolverType() {
		SolverTypeImpl solverType = new SolverTypeImpl();
		return solverType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverConfigurationDefinition createSolverConfigurationDefinition() {
		SolverConfigurationDefinitionImpl solverConfigurationDefinition = new SolverConfigurationDefinitionImpl();
		return solverConfigurationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverParameter createSolverParameter() {
		SolverParameterImpl solverParameter = new SolverParameterImpl();
		return solverParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverConfiguration createSolverConfiguration() {
		SolverConfigurationImpl solverConfiguration = new SolverConfigurationImpl();
		return solverConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverArgument createSolverArgument() {
		SolverArgumentImpl solverArgument = new SolverArgumentImpl();
		return solverArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModelPackage getSimulationModelPackage() {
		return (SimulationModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SimulationModelPackage getPackage() {
		return SimulationModelPackage.eINSTANCE;
	}

} //SimulationModelFactoryImpl
