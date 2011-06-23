/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adaptive Step Size Solver Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMinimumStepSize <em>Minimum Step Size</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMaximumStepSize <em>Maximum Step Size</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getInitialStepSize <em>Initial Step Size</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getAbsoluteTolerance <em>Absolute Tolerance</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getRelativeTolerance <em>Relative Tolerance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getAdaptiveStepSizeSolverConfiguration()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidMinimumStepSize ValidMaximumStepSize ValidInitialStepSize ValidAbsoluteTolerance ValidRelativeTolerance'"
 * @generated
 */
public interface AdaptiveStepSizeSolverConfiguration extends SolverConfiguration {
	/**
	 * Returns the value of the '<em><b>Minimum Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum Step Size</em>' attribute.
	 * @see #setMinimumStepSize(double)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getAdaptiveStepSizeSolverConfiguration_MinimumStepSize()
	 * @model required="true"
	 * @generated
	 */
	double getMinimumStepSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMinimumStepSize <em>Minimum Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Step Size</em>' attribute.
	 * @see #getMinimumStepSize()
	 * @generated
	 */
	void setMinimumStepSize(double value);

	/**
	 * Returns the value of the '<em><b>Maximum Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maximum Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maximum Step Size</em>' attribute.
	 * @see #isSetMaximumStepSize()
	 * @see #unsetMaximumStepSize()
	 * @see #setMaximumStepSize(double)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getAdaptiveStepSizeSolverConfiguration_MaximumStepSize()
	 * @model unsettable="true"
	 * @generated
	 */
	double getMaximumStepSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMaximumStepSize <em>Maximum Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Step Size</em>' attribute.
	 * @see #isSetMaximumStepSize()
	 * @see #unsetMaximumStepSize()
	 * @see #getMaximumStepSize()
	 * @generated
	 */
	void setMaximumStepSize(double value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMaximumStepSize <em>Maximum Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMaximumStepSize()
	 * @see #getMaximumStepSize()
	 * @see #setMaximumStepSize(double)
	 * @generated
	 */
	void unsetMaximumStepSize();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getMaximumStepSize <em>Maximum Step Size</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Maximum Step Size</em>' attribute is set.
	 * @see #unsetMaximumStepSize()
	 * @see #getMaximumStepSize()
	 * @see #setMaximumStepSize(double)
	 * @generated
	 */
	boolean isSetMaximumStepSize();

	/**
	 * Returns the value of the '<em><b>Initial Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Step Size</em>' attribute.
	 * @see #isSetInitialStepSize()
	 * @see #unsetInitialStepSize()
	 * @see #setInitialStepSize(double)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getAdaptiveStepSizeSolverConfiguration_InitialStepSize()
	 * @model unsettable="true"
	 * @generated
	 */
	double getInitialStepSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getInitialStepSize <em>Initial Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Step Size</em>' attribute.
	 * @see #isSetInitialStepSize()
	 * @see #unsetInitialStepSize()
	 * @see #getInitialStepSize()
	 * @generated
	 */
	void setInitialStepSize(double value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getInitialStepSize <em>Initial Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInitialStepSize()
	 * @see #getInitialStepSize()
	 * @see #setInitialStepSize(double)
	 * @generated
	 */
	void unsetInitialStepSize();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getInitialStepSize <em>Initial Step Size</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Initial Step Size</em>' attribute is set.
	 * @see #unsetInitialStepSize()
	 * @see #getInitialStepSize()
	 * @see #setInitialStepSize(double)
	 * @generated
	 */
	boolean isSetInitialStepSize();

	/**
	 * Returns the value of the '<em><b>Absolute Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Absolute Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Absolute Tolerance</em>' attribute.
	 * @see #setAbsoluteTolerance(double)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getAdaptiveStepSizeSolverConfiguration_AbsoluteTolerance()
	 * @model required="true"
	 * @generated
	 */
	double getAbsoluteTolerance();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getAbsoluteTolerance <em>Absolute Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Absolute Tolerance</em>' attribute.
	 * @see #getAbsoluteTolerance()
	 * @generated
	 */
	void setAbsoluteTolerance(double value);

	/**
	 * Returns the value of the '<em><b>Relative Tolerance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relative Tolerance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relative Tolerance</em>' attribute.
	 * @see #setRelativeTolerance(double)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getAdaptiveStepSizeSolverConfiguration_RelativeTolerance()
	 * @model required="true"
	 * @generated
	 */
	double getRelativeTolerance();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.AdaptiveStepSizeSolverConfiguration#getRelativeTolerance <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relative Tolerance</em>' attribute.
	 * @see #getRelativeTolerance()
	 * @generated
	 */
	void setRelativeTolerance(double value);

} // AdaptiveStepSizeSolverConfiguration
