/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel.util;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModel;
import org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage;
import org.eclipselabs.damos.simulation.simulationmodel.SolverArgument;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration;
import org.eclipselabs.damos.simulation.simulationmodel.SolverConfigurationDefinition;
import org.eclipselabs.damos.simulation.simulationmodel.SolverParameter;
import org.eclipselabs.damos.simulation.simulationmodel.SolverType;
import org.eclipselabs.damos.simulation.simulationmodel.internal.SimulationModelPlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage
 * @generated
 */
public class SimulationModelValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final SimulationModelValidator INSTANCE = new SimulationModelValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.eclipselabs.damos.simulation.simulationmodel";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimulationModelValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return SimulationModelPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case SimulationModelPackage.SIMULATION_MODEL:
				return validateSimulationModel((SimulationModel)value, diagnostics, context);
			case SimulationModelPackage.SOLVER_TYPE:
				return validateSolverType((SolverType)value, diagnostics, context);
			case SimulationModelPackage.SOLVER_CONFIGURATION_DEFINITION:
				return validateSolverConfigurationDefinition((SolverConfigurationDefinition)value, diagnostics, context);
			case SimulationModelPackage.SOLVER_PARAMETER:
				return validateSolverParameter((SolverParameter)value, diagnostics, context);
			case SimulationModelPackage.SOLVER_CONFIGURATION:
				return validateSolverConfiguration((SolverConfiguration)value, diagnostics, context);
			case SimulationModelPackage.SOLVER_ARGUMENT:
				return validateSolverArgument((SolverArgument)value, diagnostics, context);
			default:
				return true;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.ecore.util.EObjectValidator#validate_EveryProxyResolves(org.eclipse.emf.ecore.EObject, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	@Override
	public boolean validate_EveryProxyResolves(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSimulationModel(SimulationModel simulationModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(simulationModel, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(simulationModel, diagnostics, context);
		if (result || diagnostics != null) result &= validateSimulationModel_ValidSimulationTime(simulationModel, diagnostics, context);
		return result;
	}
	
	/**
	 * Validates the ValidSimulationTime constraint of '<em>Simulation Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean validateSimulationModel_ValidSimulationTime(SimulationModel simulationModel, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		if (!simulationModel.isSetSimulationTime()) {
//			return true;
//		}
//		
//		double simulationTime = SimulationModelUtil.getSimulationTime(simulationModel);
//
//		if (Double.isNaN(simulationTime)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Simulation time must not be NaN",
//						new Object[] { simulationModel }));
//			}
//			return false;
//		}
//
//		if (Double.isInfinite(simulationTime)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Simulation time must not be infinite",
//						new Object[] { simulationModel }));
//			}
//			return false;
//		}
//
//		if (simulationTime <= 0) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Simulation time must be greater than zero",
//						new Object[] { simulationModel }));
//			}
//			return false;
//		}
//		
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSolverType(SolverType solverType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(solverType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSolverConfigurationDefinition(SolverConfigurationDefinition solverConfigurationDefinition, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(solverConfigurationDefinition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSolverParameter(SolverParameter solverParameter, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(solverParameter, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSolverConfiguration(SolverConfiguration solverConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(solverConfiguration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSolverArgument(SolverArgument solverArgument, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(solverArgument, diagnostics, context);
	}

//	/**
//	 * Validates the ValidStepSize constraint of '<em>Fixed Step Size Solver Configuration</em>'.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public boolean validateFixedStepSizeSolverConfiguration_ValidStepSize(FixedStepSizeSolverConfiguration fixedStepSizeSolverConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		double stepSize = fixedStepSizeSolverConfiguration.getStepSize();
//
//		if (Double.isNaN(stepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Step size must not be NaN",
//						new Object[] { fixedStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (Double.isInfinite(stepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Step size must not be infinite",
//						new Object[] { fixedStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (stepSize <= 0) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Step size must be greater than zero",
//						new Object[] { fixedStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//		
//		return true;
//	}
//
//	/**
//	 * Validates the ValidMinimumStepSize constraint of '<em>Adaptive Step Size Solver Configuration</em>'.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public boolean validateAdaptiveStepSizeSolverConfiguration_ValidMinimumStepSize(AdaptiveStepSizeSolverConfiguration adaptiveStepSizeSolverConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		double minimumStepSize = adaptiveStepSizeSolverConfiguration.getMinimumStepSize();
//
//		if (Double.isNaN(minimumStepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Minimum step size must not be NaN",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (Double.isInfinite(minimumStepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Minimum step size must not be infinite",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (minimumStepSize <= 0) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Minimum step size must be greater than zero",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//		
//		return true;
//	}
//
//	/**
//	 * Validates the ValidMaximumStepSize constraint of '<em>Adaptive Step Size Solver Configuration</em>'.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public boolean validateAdaptiveStepSizeSolverConfiguration_ValidMaximumStepSize(AdaptiveStepSizeSolverConfiguration adaptiveStepSizeSolverConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		if (!adaptiveStepSizeSolverConfiguration.isSetMaximumStepSize()) {
//			return true;
//		}
//		
//		double maximumStepSize = adaptiveStepSizeSolverConfiguration.getMaximumStepSize();
//
//		if (Double.isNaN(maximumStepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Maximum step size must not be NaN",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (Double.isInfinite(maximumStepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Maximum step size must not be infinite",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (maximumStepSize <= 0) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Maximum step size must be greater than zero",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//		
//		if (validateAdaptiveStepSizeSolverConfiguration_ValidMinimumStepSize(adaptiveStepSizeSolverConfiguration, null,
//				context) && maximumStepSize < adaptiveStepSizeSolverConfiguration.getMinimumStepSize()) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Maximum step size must be greater than or equal to minimum step size",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//		
//		return true;
//	}
//
//	/**
//	 * Validates the ValidInitialStepSize constraint of '<em>Adaptive Step Size Solver Configuration</em>'.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public boolean validateAdaptiveStepSizeSolverConfiguration_ValidInitialStepSize(AdaptiveStepSizeSolverConfiguration adaptiveStepSizeSolverConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		if (!adaptiveStepSizeSolverConfiguration.isSetInitialStepSize()) {
//			return true;
//		}
//		
//		double initialStepSize = adaptiveStepSizeSolverConfiguration.getInitialStepSize();
//
//		if (Double.isNaN(initialStepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Initial step size must not be NaN",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (Double.isInfinite(initialStepSize)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Initial step size must not be infinite",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (initialStepSize <= 0) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Initial step size must be greater than zero",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//		
//		if (validateAdaptiveStepSizeSolverConfiguration_ValidMinimumStepSize(adaptiveStepSizeSolverConfiguration, null,
//				context) && initialStepSize < adaptiveStepSizeSolverConfiguration.getMinimumStepSize()) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Initial step size must be greater than or equal to minimum step size",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (validateAdaptiveStepSizeSolverConfiguration_ValidMaximumStepSize(adaptiveStepSizeSolverConfiguration, null,
//				context) && initialStepSize > adaptiveStepSizeSolverConfiguration.getMaximumStepSize()) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Initial step size must be less than or equal to minimum step size",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		return true;
//	}
//
//	/**
//	 * Validates the ValidAbsoluteTolerance constraint of '<em>Adaptive Step Size Solver Configuration</em>'.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public boolean validateAdaptiveStepSizeSolverConfiguration_ValidAbsoluteTolerance(AdaptiveStepSizeSolverConfiguration adaptiveStepSizeSolverConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		double absoluteTolerance = adaptiveStepSizeSolverConfiguration.getAbsoluteTolerance();
//
//		if (Double.isNaN(absoluteTolerance)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Absolute tolerance must not be NaN",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (Double.isInfinite(absoluteTolerance)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Absolute tolerance must not be infinite",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (absoluteTolerance <= 0) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Absolute tolerance be greater than zero",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//		
//		return true;
//	}
//
//	/**
//	 * Validates the ValidRelativeTolerance constraint of '<em>Adaptive Step Size Solver Configuration</em>'.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @generated NOT
//	 */
//	public boolean validateAdaptiveStepSizeSolverConfiguration_ValidRelativeTolerance(AdaptiveStepSizeSolverConfiguration adaptiveStepSizeSolverConfiguration, DiagnosticChain diagnostics, Map<Object, Object> context) {
//		double relativeTolerance = adaptiveStepSizeSolverConfiguration.getRelativeTolerance();
//
//		if (Double.isNaN(relativeTolerance)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Relative tolerance must not be NaN",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (Double.isInfinite(relativeTolerance)) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Relative tolerance must not be infinite",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//
//		if (relativeTolerance <= 0) {
//			if (diagnostics != null) {
//				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
//						DIAGNOSTIC_SOURCE,
//						0,
//						"Relative tolerance be greater than zero",
//						new Object[] { adaptiveStepSizeSolverConfiguration }));
//			}
//			return false;
//		}
//		
//		return true;
//	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return SimulationModelPlugin.INSTANCE;
	}

} //SimulationModelValidator
