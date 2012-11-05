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
package org.eclipse.damos.mscript.computation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Format</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.damos.mscript.computation.ComputationPackage#getNumberFormat()
 * @model abstract="true"
 * @generated
 */
public interface NumberFormat extends EObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isEquivalentTo(NumberFormat other);
} // NumberFormat
