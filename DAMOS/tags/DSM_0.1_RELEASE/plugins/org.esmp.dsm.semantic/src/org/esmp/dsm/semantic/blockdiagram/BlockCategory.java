/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory#getParents <em>Parents</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory#getUri <em>Uri</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory#getUriAsString <em>Uri As String</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockCategory()
 * @model
 * @generated
 */
public interface BlockCategory extends NamedElement, ParameterDescriptorContainer {
	/**
	 * Returns the value of the '<em><b>Parents</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.BlockCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parents</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockCategory_Parents()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BlockCategory> getParents();

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockCategory_Uri()
	 * @model dataType="org.esmp.dsm.semantic.blockdiagram.URI" required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	URI getUri();

	/**
	 * Returns the value of the '<em><b>Uri As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri As String</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri As String</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockCategory_UriAsString()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getUriAsString();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" categoryURIDataType="org.esmp.dsm.semantic.blockdiagram.URI" categoryURIRequired="true" categoryURIOrdered="false"
	 * @generated
	 */
	boolean belongsTo(URI categoryURI);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" categoryURIRequired="true" categoryURIOrdered="false"
	 * @generated
	 */
	boolean belongsTo(String categoryURI);

} // BlockCategory
