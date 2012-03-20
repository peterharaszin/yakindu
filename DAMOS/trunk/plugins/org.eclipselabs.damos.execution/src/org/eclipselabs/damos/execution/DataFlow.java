/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Flow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.execution.DataFlow#getTargetEnds <em>Target Ends</em>}</li>
 *   <li>{@link org.eclipselabs.damos.execution.DataFlow#getSourceEnd <em>Source End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.execution.ExecutionPackage#getDataFlow()
 * @model
 * @generated
 */
public interface DataFlow extends EObject {
	/**
	 * Returns the value of the '<em><b>Source End</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.DataFlowSourceEnd#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source End</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source End</em>' containment reference.
	 * @see #setSourceEnd(DataFlowSourceEnd)
	 * @see org.eclipselabs.damos.execution.ExecutionPackage#getDataFlow_SourceEnd()
	 * @see org.eclipselabs.damos.execution.DataFlowSourceEnd#getDataFlow
	 * @model opposite="dataFlow" containment="true" required="true" ordered="false"
	 * @generated
	 */
	DataFlowSourceEnd getSourceEnd();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.execution.DataFlow#getSourceEnd <em>Source End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source End</em>' containment reference.
	 * @see #getSourceEnd()
	 * @generated
	 */
	void setSourceEnd(DataFlowSourceEnd value);

	/**
	 * Returns the value of the '<em><b>Target Ends</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.execution.DataFlowTargetEnd}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.execution.DataFlowTargetEnd#getDataFlow <em>Data Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Ends</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Ends</em>' containment reference list.
	 * @see org.eclipselabs.damos.execution.ExecutionPackage#getDataFlow_TargetEnds()
	 * @see org.eclipselabs.damos.execution.DataFlowTargetEnd#getDataFlow
	 * @model opposite="dataFlow" containment="true" required="true"
	 * @generated
	 */
	EList<DataFlowTargetEnd> getTargetEnds();

} // DataFlow
