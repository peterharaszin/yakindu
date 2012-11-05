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
package org.eclipse.damos.diagram.dmlnotation.impl;

import org.eclipse.damos.diagram.dmlnotation.DMLNotationFactory;
import org.eclipse.damos.diagram.dmlnotation.DMLNotationPackage;
import org.eclipse.damos.diagram.dmlnotation.FlippableBounds;
import org.eclipse.damos.diagram.dmlnotation.RotatableBounds;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DMLNotationFactoryImpl extends EFactoryImpl implements DMLNotationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DMLNotationFactory init() {
		try {
			DMLNotationFactory theDMLNotationFactory = (DMLNotationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipse.org/damos/2011/DMLNotation"); 
			if (theDMLNotationFactory != null) {
				return theDMLNotationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DMLNotationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLNotationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DMLNotationPackage.FLIPPABLE_BOUNDS: return createFlippableBounds();
			case DMLNotationPackage.ROTATABLE_BOUNDS: return createRotatableBounds();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlippableBounds createFlippableBounds() {
		FlippableBoundsImpl flippableBounds = new FlippableBoundsImpl();
		return flippableBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RotatableBounds createRotatableBounds() {
		RotatableBoundsImpl rotatableBounds = new RotatableBoundsImpl();
		return rotatableBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLNotationPackage getDMLNotationPackage() {
		return (DMLNotationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DMLNotationPackage getPackage() {
		return DMLNotationPackage.eINSTANCE;
	}

} //DMLNotationFactoryImpl
