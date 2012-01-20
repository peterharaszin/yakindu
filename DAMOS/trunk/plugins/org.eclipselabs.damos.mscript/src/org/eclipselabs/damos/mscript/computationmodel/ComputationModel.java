/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.computationmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.mscript.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getQualifiedName <em>Qualified Name</em>}</li>
 *   <li>{@link org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getNumberFormatMappings <em>Number Format Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage#getComputationModel()
 * @model
 * @generated
 */
public interface ComputationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Number Format Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.mscript.computationmodel.NumberFormatMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Format Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Format Mappings</em>' containment reference list.
	 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage#getComputationModel_NumberFormatMappings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<NumberFormatMapping> getNumberFormatMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" dataTypeRequired="true" dataTypeOrdered="false"
	 * @generated
	 */
	NumberFormatMapping getNumberFormatMapping(DataType dataType);

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
	 * @see org.eclipselabs.damos.mscript.computationmodel.ComputationModelPackage#getComputationModel_QualifiedName()
	 * @model
	 * @generated
	 */
	String getQualifiedName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.mscript.computationmodel.ComputationModel#getQualifiedName <em>Qualified Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Name</em>' attribute.
	 * @see #getQualifiedName()
	 * @generated
	 */
	void setQualifiedName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" dataTypeRequired="true" dataTypeOrdered="false"
	 * @generated
	 */
	NumberFormat getNumberFormat(DataType dataType);

} // ComputationModel
