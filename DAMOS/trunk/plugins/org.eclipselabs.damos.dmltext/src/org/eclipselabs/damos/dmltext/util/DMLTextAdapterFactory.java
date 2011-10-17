/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dmltext.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.BehaviorSpecification;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dmltext.DMLTextPackage;
import org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;
import org.eclipselabs.damos.dmltext.Root;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dmltext.DMLTextPackage
 * @generated
 */
public class DMLTextAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DMLTextPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLTextAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DMLTextPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DMLTextSwitch<Adapter> modelSwitch =
		new DMLTextSwitch<Adapter>() {
			@Override
			public Adapter caseRoot(Root object) {
				return createRootAdapter();
			}
			@Override
			public Adapter caseMscriptDataTypeSpecification(MscriptDataTypeSpecification object) {
				return createMscriptDataTypeSpecificationAdapter();
			}
			@Override
			public Adapter caseMscriptBehaviorSpecification(MscriptBehaviorSpecification object) {
				return createMscriptBehaviorSpecificationAdapter();
			}
			@Override
			public Adapter caseMscriptValueSpecification(MscriptValueSpecification object) {
				return createMscriptValueSpecificationAdapter();
			}
			@Override
			public Adapter caseDataTypeSpecification(DataTypeSpecification object) {
				return createDataTypeSpecificationAdapter();
			}
			@Override
			public Adapter caseBehaviorSpecification(BehaviorSpecification object) {
				return createBehaviorSpecificationAdapter();
			}
			@Override
			public Adapter caseValueSpecification(ValueSpecification object) {
				return createValueSpecificationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dmltext.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dmltext.Root
	 * @generated
	 */
	public Adapter createRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification <em>Mscript Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification
	 * @generated
	 */
	public Adapter createMscriptDataTypeSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification <em>Mscript Behavior Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dmltext.MscriptBehaviorSpecification
	 * @generated
	 */
	public Adapter createMscriptBehaviorSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dmltext.MscriptValueSpecification <em>Mscript Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dmltext.MscriptValueSpecification
	 * @generated
	 */
	public Adapter createMscriptValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.DataTypeSpecification <em>Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.DataTypeSpecification
	 * @generated
	 */
	public Adapter createDataTypeSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BehaviorSpecification <em>Behavior Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BehaviorSpecification
	 * @generated
	 */
	public Adapter createBehaviorSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.ValueSpecification
	 * @generated
	 */
	public Adapter createValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DMLTextAdapterFactory
