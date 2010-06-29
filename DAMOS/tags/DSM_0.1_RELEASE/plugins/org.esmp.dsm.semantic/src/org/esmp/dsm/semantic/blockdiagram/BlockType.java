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
 * A representation of the model object '<em><b>Block Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getCategories <em>Categories</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getUri <em>Uri</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockType#getUriAsString <em>Uri As String</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockType#isVirtual <em>Virtual</em>}</li>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.BlockType#isStructural <em>Structural</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType()
 * @model
 * @generated
 */
public interface BlockType extends NamedElement, ParameterDescriptorContainer {
	/**
	 * Returns the value of the '<em><b>Categories</b></em>' reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.BlockCategory}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Categories</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Categories</em>' reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType_Categories()
	 * @model ordered="false"
	 * @generated
	 */
	EList<BlockCategory> getCategories();

	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType_Uri()
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
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType_UriAsString()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	String getUriAsString();

	/**
	 * Returns the value of the '<em><b>Virtual</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Virtual</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Virtual</em>' attribute.
	 * @see #setVirtual(boolean)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType_Virtual()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isVirtual();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#isVirtual <em>Virtual</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Virtual</em>' attribute.
	 * @see #isVirtual()
	 * @generated
	 */
	void setVirtual(boolean value);

	/**
	 * Returns the value of the '<em><b>Structural</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Structural</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Structural</em>' attribute.
	 * @see #setStructural(boolean)
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType_Structural()
	 * @model default="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isStructural();

	/**
	 * Sets the value of the '{@link org.esmp.dsm.semantic.blockdiagram.BlockType#isStructural <em>Structural</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Structural</em>' attribute.
	 * @see #isStructural()
	 * @generated
	 */
	void setStructural(boolean value);

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

	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.InputSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType_Inputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputSpecification> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.OutputSpecification}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getBlockType_Outputs()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputSpecification> getOutputs();

} // BlockType
