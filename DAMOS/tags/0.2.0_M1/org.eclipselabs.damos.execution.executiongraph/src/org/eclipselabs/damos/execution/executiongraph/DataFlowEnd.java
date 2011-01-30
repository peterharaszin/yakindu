/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executiongraph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.DataFlowEnd#getInoutputIndex <em>Inoutput Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.executiongraph.DataFlowEnd#getPortIndex <em>Port Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getDataFlowEnd()
 * @model abstract="true"
 * @generated
 */
public interface DataFlowEnd extends EObject {

	/**
	 * Returns the value of the '<em><b>Inoutput Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inoutput Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inoutput Index</em>' attribute.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getDataFlowEnd_InoutputIndex()
	 * @model required="true" changeable="false" ordered="false"
	 * @generated
	 */
	int getInoutputIndex();

	/**
	 * Returns the value of the '<em><b>Port Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Index</em>' attribute.
	 * @see org.eclipselabs.damos.execution.executiongraph.ExecutionGraphPackage#getDataFlowEnd_PortIndex()
	 * @model required="true" changeable="false" ordered="false"
	 * @generated
	 */
	int getPortIndex();

} // DataFlowEnd
