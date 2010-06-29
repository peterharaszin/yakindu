/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Descriptor Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getParameterDescriptorContainer()
 * @model abstract="true"
 * @generated
 */
public interface ParameterDescriptorContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage#getParameterDescriptorContainer_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterDescriptor> getParameters();

} // ParameterDescriptorContainer
