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
package org.eclipse.damos.dml;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Choice#getActionLinks <em>Action Links</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.damos.dml.DMLPackage#getChoice()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ValidActionLinkConditions'"
 * @generated
 */
public interface Choice extends Component {
	/**
	 * Returns the value of the '<em><b>Action Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.damos.dml.ActionLink}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.damos.dml.ActionLink#getChoice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Links</em>' containment reference list.
	 * @see org.eclipse.damos.dml.DMLPackage#getChoice_ActionLinks()
	 * @see org.eclipse.damos.dml.ActionLink#getChoice
	 * @model opposite="choice" containment="true" lower="2"
	 * @generated
	 */
	EList<ActionLink> getActionLinks();

} // Choice
