/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dconfig;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Component;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dconfig.Mapping#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Mapping#getTargetPath <em>Target Path</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Mapping#getSubscript <em>Subscript</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dconfig.Mapping#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMapping()
 * @model
 * @generated
 */
public interface Mapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Component)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMapping_Source()
	 * @model
	 * @generated
	 */
	Component getSource();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Mapping#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Component value);

	/**
	 * Returns the value of the '<em><b>Target Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Path</em>' containment reference.
	 * @see #setTargetPath(MappingTargetPath)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMapping_TargetPath()
	 * @model containment="true"
	 * @generated
	 */
	MappingTargetPath getTargetPath();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Mapping#getTargetPath <em>Target Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Path</em>' containment reference.
	 * @see #getTargetPath()
	 * @generated
	 */
	void setTargetPath(MappingTargetPath value);

	/**
	 * Returns the value of the '<em><b>Subscript</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subscript</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subscript</em>' containment reference.
	 * @see #isSetSubscript()
	 * @see #unsetSubscript()
	 * @see #setSubscript(MappingSubscript)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMapping_Subscript()
	 * @model containment="true" unsettable="true"
	 * @generated
	 */
	MappingSubscript getSubscript();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Mapping#getSubscript <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subscript</em>' containment reference.
	 * @see #isSetSubscript()
	 * @see #unsetSubscript()
	 * @see #getSubscript()
	 * @generated
	 */
	void setSubscript(MappingSubscript value);

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.dconfig.Mapping#getSubscript <em>Subscript</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetSubscript()
	 * @see #getSubscript()
	 * @see #setSubscript(MappingSubscript)
	 * @generated
	 */
	void unsetSubscript();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.dconfig.Mapping#getSubscript <em>Subscript</em>}' containment reference is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Subscript</em>' containment reference is set.
	 * @see #unsetSubscript()
	 * @see #getSubscript()
	 * @see #setSubscript(MappingSubscript)
	 * @generated
	 */
	boolean isSetSubscript();

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.dconfig.MappingBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(MappingBody)
	 * @see org.eclipselabs.damos.dconfig.DconfigPackage#getMapping_Body()
	 * @see org.eclipselabs.damos.dconfig.MappingBody#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	MappingBody getBody();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.dconfig.Mapping#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(MappingBody value);

} // Mapping
