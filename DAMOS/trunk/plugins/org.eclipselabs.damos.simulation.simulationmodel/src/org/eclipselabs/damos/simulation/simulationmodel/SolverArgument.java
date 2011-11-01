/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver Argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverArgument()
 * @model
 * @generated
 */
public interface SolverArgument extends EObject {
	/**
	 * Returns the value of the '<em><b>Configuration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration</em>' container reference.
	 * @see #setConfiguration(SolverConfiguration)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverArgument_Configuration()
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getArguments
	 * @model opposite="arguments" required="true" transient="false"
	 * @generated
	 */
	SolverConfiguration getConfiguration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getConfiguration <em>Configuration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration</em>' container reference.
	 * @see #getConfiguration()
	 * @generated
	 */
	void setConfiguration(SolverConfiguration value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(SolverParameter)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverArgument_Parameter()
	 * @model required="true"
	 * @generated
	 */
	SolverParameter getParameter();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(SolverParameter value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverArgument_Value()
	 * @model containment="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // SolverArgument
