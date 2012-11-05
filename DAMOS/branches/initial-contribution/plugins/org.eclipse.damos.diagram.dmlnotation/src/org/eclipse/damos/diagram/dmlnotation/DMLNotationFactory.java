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
package org.eclipse.damos.diagram.dmlnotation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage
 * @generated
 */
public interface DMLNotationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DMLNotationFactory eINSTANCE = org.eclipse.damos.diagram.dmlnotation.impl.DMLNotationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Flippable Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Flippable Bounds</em>'.
	 * @generated
	 */
	FlippableBounds createFlippableBounds();

	/**
	 * Returns a new object of class '<em>Rotatable Bounds</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rotatable Bounds</em>'.
	 * @generated
	 */
	RotatableBounds createRotatableBounds();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DMLNotationPackage getDMLNotationPackage();

} //DMLNotationFactory
