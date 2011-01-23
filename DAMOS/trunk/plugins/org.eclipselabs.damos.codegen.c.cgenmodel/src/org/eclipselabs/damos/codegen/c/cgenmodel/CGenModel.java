/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.codegen.c.cgenmodel;

import org.eclipse.emf.ecore.EObject;

import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CGen Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getExecutionModel <em>Execution Model</em>}</li>
 *   <li>{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getTargetFolder <em>Target Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getCGenModel()
 * @model
 * @generated
 */
public interface CGenModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Execution Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Model</em>' reference.
	 * @see #setExecutionModel(ExecutionModel)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getCGenModel_ExecutionModel()
	 * @model
	 * @generated
	 */
	ExecutionModel getExecutionModel();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getExecutionModel <em>Execution Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Model</em>' reference.
	 * @see #getExecutionModel()
	 * @generated
	 */
	void setExecutionModel(ExecutionModel value);

	/**
	 * Returns the value of the '<em><b>Target Folder</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Folder</em>' attribute.
	 * @see #setTargetFolder(String)
	 * @see org.eclipselabs.damos.codegen.c.cgenmodel.CGenModelPackage#getCGenModel_TargetFolder()
	 * @model
	 * @generated
	 */
	String getTargetFolder();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.codegen.c.cgenmodel.CGenModel#getTargetFolder <em>Target Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Folder</em>' attribute.
	 * @see #getTargetFolder()
	 * @generated
	 */
	void setTargetFolder(String value);

} // CGenModel
