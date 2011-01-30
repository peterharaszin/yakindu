/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.diagram.dmlnotation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.diagram.dmlnotation.ComponentLayoutConstraint;
import org.eclipselabs.damos.diagram.dmlnotation.DMLNotationFactory;
import org.eclipselabs.damos.diagram.dmlnotation.DMLNotationPackage;

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
			DMLNotationFactory theDMLNotationFactory = (DMLNotationFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/DMLNotation/1.0.0"); 
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
			case DMLNotationPackage.COMPONENT_LAYOUT_CONSTRAINT: return createComponentLayoutConstraint();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentLayoutConstraint createComponentLayoutConstraint() {
		ComponentLayoutConstraintImpl componentLayoutConstraint = new ComponentLayoutConstraintImpl();
		return componentLayoutConstraint;
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
