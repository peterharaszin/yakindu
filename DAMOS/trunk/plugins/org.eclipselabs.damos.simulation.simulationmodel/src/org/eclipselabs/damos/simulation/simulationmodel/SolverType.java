/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.simulation.simulationmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solver Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverType#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.simulation.simulationmodel.SolverType#getConfigurationDefinition <em>Configuration Definition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverType()
 * @model
 * @generated
 */
public interface SolverType extends EObject {
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
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverType_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverType#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * Returns the value of the '<em><b>Configuration Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configuration Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configuration Definition</em>' reference.
	 * @see #setConfigurationDefinition(SolverConfigurationDefinition)
	 * @see org.eclipselabs.damos.simulation.simulationmodel.SimulationModelPackage#getSolverType_ConfigurationDefinition()
	 * @model
	 * @generated
	 */
	SolverConfigurationDefinition getConfigurationDefinition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.simulation.simulationmodel.SolverType#getConfigurationDefinition <em>Configuration Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Configuration Definition</em>' reference.
	 * @see #getConfigurationDefinition()
	 * @generated
	 */
	void setConfigurationDefinition(SolverConfigurationDefinition value);

} // SolverType
