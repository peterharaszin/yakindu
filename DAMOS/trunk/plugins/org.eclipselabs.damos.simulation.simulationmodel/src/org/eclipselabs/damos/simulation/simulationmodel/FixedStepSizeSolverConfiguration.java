/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Step Size Solver Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.FixedStepSizeSolverConfiguration#getStepSize <em>Step Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getFixedStepSizeSolverConfiguration()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidStepSize'"
 * @generated
 */
public interface FixedStepSizeSolverConfiguration extends SolverConfiguration {
	/**
	 * Returns the value of the '<em><b>Step Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Size</em>' attribute.
	 * @see #setStepSize(double)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getFixedStepSizeSolverConfiguration_StepSize()
	 * @model required="true"
	 * @generated
	 */
	double getStepSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.FixedStepSizeSolverConfiguration#getStepSize <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Size</em>' attribute.
	 * @see #getStepSize()
	 * @generated
	 */
	void setStepSize(double value);

} // FixedStepSizeSolverConfiguration
