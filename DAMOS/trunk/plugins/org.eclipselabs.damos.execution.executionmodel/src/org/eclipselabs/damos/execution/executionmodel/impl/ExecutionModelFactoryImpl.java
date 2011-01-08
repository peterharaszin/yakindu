/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.execution.executionmodel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModel;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelFactory;
import org.eclipselabs.damos.execution.executionmodel.ExecutionModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExecutionModelFactoryImpl extends EFactoryImpl implements ExecutionModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExecutionModelFactory init() {
		try {
			ExecutionModelFactory theExecutionModelFactory = (ExecutionModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/ExecutionModel/1.0.0"); 
			if (theExecutionModelFactory != null) {
				return theExecutionModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExecutionModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModelFactoryImpl() {
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
			case ExecutionModelPackage.EXECUTION_MODEL: return createExecutionModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModel createExecutionModel() {
		ExecutionModelImpl executionModel = new ExecutionModelImpl();
		return executionModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionModelPackage getExecutionModelPackage() {
		return (ExecutionModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExecutionModelPackage getPackage() {
		return ExecutionModelPackage.eINSTANCE;
	}

} //ExecutionModelFactoryImpl
