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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subsystem Inoutput</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.damos.dml.DMLPackage#getSubsystemInoutput()
 * @model abstract="true"
 * @generated
 */
public interface SubsystemInoutput extends Inoutput {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Inoutlet getInoutlet();

} // SubsystemInoutput
