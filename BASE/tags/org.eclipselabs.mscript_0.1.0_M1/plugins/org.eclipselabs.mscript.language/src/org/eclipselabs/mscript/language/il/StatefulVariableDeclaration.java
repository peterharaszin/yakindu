/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stateful Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.StatefulVariableDeclaration#getCircularBufferSize <em>Circular Buffer Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.il.ILPackage#getStatefulVariableDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface StatefulVariableDeclaration extends VariableDeclaration {
	/**
	 * Returns the value of the '<em><b>Circular Buffer Size</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Circular Buffer Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Circular Buffer Size</em>' attribute.
	 * @see #setCircularBufferSize(int)
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getStatefulVariableDeclaration_CircularBufferSize()
	 * @model default="1"
	 * @generated
	 */
	int getCircularBufferSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.StatefulVariableDeclaration#getCircularBufferSize <em>Circular Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Circular Buffer Size</em>' attribute.
	 * @see #getCircularBufferSize()
	 * @generated
	 */
	void setCircularBufferSize(int value);

} // StatefulVariableDeclaration
