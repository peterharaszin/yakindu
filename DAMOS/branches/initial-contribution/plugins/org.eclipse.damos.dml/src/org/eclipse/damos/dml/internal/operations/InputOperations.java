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
package org.eclipse.damos.dml.internal.operations;

import org.eclipse.damos.dml.Input;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Input</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipse.damos.dml.Input#isDirectFeedthrough() <em>Is Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isDirectFeedthrough(Input input) {
		return !input.getComponent().isSink();
	}

} // InputOperations