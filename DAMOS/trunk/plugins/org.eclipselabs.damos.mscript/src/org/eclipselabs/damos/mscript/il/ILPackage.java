/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.il;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.damos.mscript.MscriptPackage;

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
 * @see org.eclipselabs.damos.mscript.il.ILFactory
 * @model kind="package"
 * @generated
 */
public interface ILPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "il";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/damos/mscript/2011/IL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "il";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ILPackage eINSTANCE = org.eclipselabs.damos.mscript.il.impl.ILPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl <em>Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getILFunctionDefinition()
	 * @generated
	 */
	int IL_FUNCTION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Function Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__FUNCTION_DEFINITION = 0;

	/**
	 * The feature id for the '<em><b>Stateful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__STATEFUL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__NAME = 2;

	/**
	 * The feature id for the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND = 3;

	/**
	 * The feature id for the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS = 4;

	/**
	 * The number of structural features of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IL_FUNCTION_DEFINITION_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getComputationCompound()
	 * @generated
	 */
	int COMPUTATION_COMPOUND = 1;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__STATEMENTS = MscriptPackage.COMPOUND__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Inputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__INPUTS = MscriptPackage.COMPOUND_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Outputs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND__OUTPUTS = MscriptPackage.COMPOUND_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Computation Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_COMPOUND_FEATURE_COUNT = MscriptPackage.COMPOUND_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl <em>Invalid Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl
	 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInvalidExpression()
	 * @generated
	 */
	int INVALID_EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Invalid Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVALID_EXPRESSION_FEATURE_COUNT = MscriptPackage.EXPRESSION_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Definition</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition
	 * @generated
	 */
	EClass getILFunctionDefinition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getFunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function Definition</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getFunctionDefinition()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_FunctionDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#isStateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stateful</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#isStateful()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EAttribute getILFunctionDefinition_Stateful();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getName()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EAttribute getILFunctionDefinition_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInitializationCompound <em>Initialization Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initialization Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getInitializationCompound()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_InitializationCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getComputationCompounds <em>Computation Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Computation Compounds</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ILFunctionDefinition#getComputationCompounds()
	 * @see #getILFunctionDefinition()
	 * @generated
	 */
	EReference getILFunctionDefinition_ComputationCompounds();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.ComputationCompound <em>Computation Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation Compound</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ComputationCompound
	 * @generated
	 */
	EClass getComputationCompound();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.il.ComputationCompound#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Inputs</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ComputationCompound#getInputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Inputs();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipselabs.damos.mscript.il.ComputationCompound#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outputs</em>'.
	 * @see org.eclipselabs.damos.mscript.il.ComputationCompound#getOutputs()
	 * @see #getComputationCompound()
	 * @generated
	 */
	EReference getComputationCompound_Outputs();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.damos.mscript.il.InvalidExpression <em>Invalid Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invalid Expression</em>'.
	 * @see org.eclipselabs.damos.mscript.il.InvalidExpression
	 * @generated
	 */
	EClass getInvalidExpression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ILFactory getILFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl <em>Function Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.ILFunctionDefinitionImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getILFunctionDefinition()
		 * @generated
		 */
		EClass IL_FUNCTION_DEFINITION = eINSTANCE.getILFunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Function Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__FUNCTION_DEFINITION = eINSTANCE.getILFunctionDefinition_FunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Stateful</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IL_FUNCTION_DEFINITION__STATEFUL = eINSTANCE.getILFunctionDefinition_Stateful();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IL_FUNCTION_DEFINITION__NAME = eINSTANCE.getILFunctionDefinition_Name();

		/**
		 * The meta object literal for the '<em><b>Initialization Compound</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__INITIALIZATION_COMPOUND = eINSTANCE.getILFunctionDefinition_InitializationCompound();

		/**
		 * The meta object literal for the '<em><b>Computation Compounds</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IL_FUNCTION_DEFINITION__COMPUTATION_COMPOUNDS = eINSTANCE.getILFunctionDefinition_ComputationCompounds();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl <em>Computation Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.ComputationCompoundImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getComputationCompound()
		 * @generated
		 */
		EClass COMPUTATION_COMPOUND = eINSTANCE.getComputationCompound();

		/**
		 * The meta object literal for the '<em><b>Inputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__INPUTS = eINSTANCE.getComputationCompound_Inputs();

		/**
		 * The meta object literal for the '<em><b>Outputs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTATION_COMPOUND__OUTPUTS = eINSTANCE.getComputationCompound_Outputs();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl <em>Invalid Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.damos.mscript.il.impl.InvalidExpressionImpl
		 * @see org.eclipselabs.damos.mscript.il.impl.ILPackageImpl#getInvalidExpression()
		 * @generated
		 */
		EClass INVALID_EXPRESSION = eINSTANCE.getInvalidExpression();

	}

} //ILPackage
