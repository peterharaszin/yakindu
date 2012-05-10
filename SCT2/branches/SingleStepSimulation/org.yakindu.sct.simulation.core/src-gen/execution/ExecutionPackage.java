/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *   committers of YAKINDU - initial API and implementation
 *  
 */
package execution;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see execution.ExecutionFactory
 * @model kind="package"
 * @generated
 */
public interface ExecutionPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2012 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\n  committers of YAKINDU - initial API and implementation\r\n ";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "execution";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/sct/statechart/Execution";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "execution";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExecutionPackage eINSTANCE = execution.impl.ExecutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link execution.impl.ExecutionContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see execution.impl.ExecutionContextImpl
	 * @see execution.impl.ExecutionPackageImpl#getExecutionContext()
	 * @generated
	 */
	int EXECUTION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Raised Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__RAISED_EVENTS = 0;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT__SCOPES = 1;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_CONTEXT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link execution.impl.ExecutionVariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see execution.impl.ExecutionVariableImpl
	 * @see execution.impl.ExecutionPackageImpl#getExecutionVariable()
	 * @generated
	 */
	int EXECUTION_VARIABLE = 1;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_VARIABLE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link execution.impl.ExecutionEventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see execution.impl.ExecutionEventImpl
	 * @see execution.impl.ExecutionPackageImpl#getExecutionEvent()
	 * @generated
	 */
	int EXECUTION_EVENT = 2;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_EVENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link execution.impl.ExecutionScopeImpl <em>Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see execution.impl.ExecutionScopeImpl
	 * @see execution.impl.ExecutionPackageImpl#getExecutionScope()
	 * @generated
	 */
	int EXECUTION_SCOPE = 3;

	/**
	 * The feature id for the '<em><b>Declared Events</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__DECLARED_EVENTS = 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE__VARIABLES = 1;

	/**
	 * The number of structural features of the '<em>Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_SCOPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link execution.impl.ExecutionFeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see execution.impl.ExecutionFeatureImpl
	 * @see execution.impl.ExecutionPackageImpl#getExecutionFeature()
	 * @generated
	 */
	int EXECUTION_FEATURE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_FEATURE_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link execution.ExecutionContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see execution.ExecutionContext
	 * @generated
	 */
	EClass getExecutionContext();

	/**
	 * Returns the meta object for the reference list '{@link execution.ExecutionContext#getRaisedEvents <em>Raised Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Raised Events</em>'.
	 * @see execution.ExecutionContext#getRaisedEvents()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_RaisedEvents();

	/**
	 * Returns the meta object for the containment reference list '{@link execution.ExecutionContext#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scopes</em>'.
	 * @see execution.ExecutionContext#getScopes()
	 * @see #getExecutionContext()
	 * @generated
	 */
	EReference getExecutionContext_Scopes();

	/**
	 * Returns the meta object for class '{@link execution.ExecutionVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see execution.ExecutionVariable
	 * @generated
	 */
	EClass getExecutionVariable();

	/**
	 * Returns the meta object for class '{@link execution.ExecutionEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see execution.ExecutionEvent
	 * @generated
	 */
	EClass getExecutionEvent();

	/**
	 * Returns the meta object for class '{@link execution.ExecutionScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scope</em>'.
	 * @see execution.ExecutionScope
	 * @generated
	 */
	EClass getExecutionScope();

	/**
	 * Returns the meta object for the containment reference list '{@link execution.ExecutionScope#getDeclaredEvents <em>Declared Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Declared Events</em>'.
	 * @see execution.ExecutionScope#getDeclaredEvents()
	 * @see #getExecutionScope()
	 * @generated
	 */
	EReference getExecutionScope_DeclaredEvents();

	/**
	 * Returns the meta object for the reference '{@link execution.ExecutionScope#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variables</em>'.
	 * @see execution.ExecutionScope#getVariables()
	 * @see #getExecutionScope()
	 * @generated
	 */
	EReference getExecutionScope_Variables();

	/**
	 * Returns the meta object for class '{@link execution.ExecutionFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see execution.ExecutionFeature
	 * @generated
	 */
	EClass getExecutionFeature();

	/**
	 * Returns the meta object for the attribute '{@link execution.ExecutionFeature#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see execution.ExecutionFeature#getName()
	 * @see #getExecutionFeature()
	 * @generated
	 */
	EAttribute getExecutionFeature_Name();

	/**
	 * Returns the meta object for the attribute '{@link execution.ExecutionFeature#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see execution.ExecutionFeature#getType()
	 * @see #getExecutionFeature()
	 * @generated
	 */
	EAttribute getExecutionFeature_Type();

	/**
	 * Returns the meta object for the attribute '{@link execution.ExecutionFeature#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see execution.ExecutionFeature#getValue()
	 * @see #getExecutionFeature()
	 * @generated
	 */
	EAttribute getExecutionFeature_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExecutionFactory getExecutionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link execution.impl.ExecutionContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see execution.impl.ExecutionContextImpl
		 * @see execution.impl.ExecutionPackageImpl#getExecutionContext()
		 * @generated
		 */
		EClass EXECUTION_CONTEXT = eINSTANCE.getExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Raised Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONTEXT__RAISED_EVENTS = eINSTANCE.getExecutionContext_RaisedEvents();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_CONTEXT__SCOPES = eINSTANCE.getExecutionContext_Scopes();

		/**
		 * The meta object literal for the '{@link execution.impl.ExecutionVariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see execution.impl.ExecutionVariableImpl
		 * @see execution.impl.ExecutionPackageImpl#getExecutionVariable()
		 * @generated
		 */
		EClass EXECUTION_VARIABLE = eINSTANCE.getExecutionVariable();

		/**
		 * The meta object literal for the '{@link execution.impl.ExecutionEventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see execution.impl.ExecutionEventImpl
		 * @see execution.impl.ExecutionPackageImpl#getExecutionEvent()
		 * @generated
		 */
		EClass EXECUTION_EVENT = eINSTANCE.getExecutionEvent();

		/**
		 * The meta object literal for the '{@link execution.impl.ExecutionScopeImpl <em>Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see execution.impl.ExecutionScopeImpl
		 * @see execution.impl.ExecutionPackageImpl#getExecutionScope()
		 * @generated
		 */
		EClass EXECUTION_SCOPE = eINSTANCE.getExecutionScope();

		/**
		 * The meta object literal for the '<em><b>Declared Events</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SCOPE__DECLARED_EVENTS = eINSTANCE.getExecutionScope_DeclaredEvents();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_SCOPE__VARIABLES = eINSTANCE.getExecutionScope_Variables();

		/**
		 * The meta object literal for the '{@link execution.impl.ExecutionFeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see execution.impl.ExecutionFeatureImpl
		 * @see execution.impl.ExecutionPackageImpl#getExecutionFeature()
		 * @generated
		 */
		EClass EXECUTION_FEATURE = eINSTANCE.getExecutionFeature();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_FEATURE__NAME = eINSTANCE.getExecutionFeature_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_FEATURE__TYPE = eINSTANCE.getExecutionFeature_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXECUTION_FEATURE__VALUE = eINSTANCE.getExecutionFeature_Value();

	}

} //ExecutionPackage
