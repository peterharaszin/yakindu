/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dconfig;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Selection Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dconfig.SelectionProperty#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.SelectionProperty#getIndex <em>Index</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.SelectionProperty#getSelection <em>Selection</em>}</li>
 *   <li>{@link org.eclipse.damos.dconfig.SelectionProperty#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionProperty()
 * @model
 * @generated
 */
public interface SelectionProperty extends DeclaredProperty {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(SelectionPropertyDeclaration)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionProperty_Declaration()
	 * @model
	 * @generated
	 */
	SelectionPropertyDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.SelectionProperty#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(SelectionPropertyDeclaration value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionProperty_Index()
	 * @model default="-1"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.SelectionProperty#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

	/**
	 * Returns the value of the '<em><b>Selection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selection</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selection</em>' reference.
	 * @see #setSelection(SelectionPropertyOption)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionProperty_Selection()
	 * @model
	 * @generated
	 */
	SelectionPropertyOption getSelection();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.SelectionProperty#getSelection <em>Selection</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selection</em>' reference.
	 * @see #getSelection()
	 * @generated
	 */
	void setSelection(SelectionPropertyOption value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dconfig.SelectionPropertyBody#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(SelectionPropertyBody)
	 * @see org.eclipse.damos.dconfig.DconfigPackage#getSelectionProperty_Body()
	 * @see org.eclipse.damos.dconfig.SelectionPropertyBody#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	SelectionPropertyBody getBody();

	/**
	 * Sets the value of the '{@link org.eclipse.damos.dconfig.SelectionProperty#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(SelectionPropertyBody value);

} // SelectionProperty
