/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getArguments <em>Arguments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverConfiguration()
 * @model
 * @generated
 */
public interface SolverConfiguration extends EObject {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(SolverType)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverConfiguration_Type()
	 * @model
	 * @generated
	 */
	SolverType getType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverConfiguration#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(SolverType value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverConfiguration_Arguments()
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SolverArgument#getConfiguration
	 * @model opposite="configuration" containment="true"
	 * @generated
	 */
	EList<SolverArgument> getArguments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	SolverArgument getArgument(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	Expression getArgumentValue(String name);
} // SolverConfiguration
