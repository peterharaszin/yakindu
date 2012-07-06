/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.damos.mscript.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.MscriptPackage
 * @generated
 */
public class MscriptSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MscriptPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MscriptSwitch() {
		if (modelPackage == null) {
			modelPackage = MscriptPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case MscriptPackage.MODULE: {
				Module module = (Module)theEObject;
				T result = caseModule(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.IMPORT_DECLARATION: {
				ImportDeclaration importDeclaration = (ImportDeclaration)theEObject;
				T result = caseImportDeclaration(importDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.DECLARATION: {
				Declaration declaration = (Declaration)theEObject;
				T result = caseDeclaration(declaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.DATA_TYPE_DECLARATION: {
				DataTypeDeclaration dataTypeDeclaration = (DataTypeDeclaration)theEObject;
				T result = caseDataTypeDeclaration(dataTypeDeclaration);
				if (result == null) result = caseDeclaration(dataTypeDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ENUMERATION_DECLARATION: {
				EnumerationDeclaration enumerationDeclaration = (EnumerationDeclaration)theEObject;
				T result = caseEnumerationDeclaration(enumerationDeclaration);
				if (result == null) result = caseDeclaration(enumerationDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ENUMERATION_LITERAL_DECLARATION: {
				EnumerationLiteralDeclaration enumerationLiteralDeclaration = (EnumerationLiteralDeclaration)theEObject;
				T result = caseEnumerationLiteralDeclaration(enumerationLiteralDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STRUCT_DECLARATION: {
				StructDeclaration structDeclaration = (StructDeclaration)theEObject;
				T result = caseStructDeclaration(structDeclaration);
				if (result == null) result = caseDataTypeDeclaration(structDeclaration);
				if (result == null) result = caseStructType(structDeclaration);
				if (result == null) result = caseDeclaration(structDeclaration);
				if (result == null) result = caseDataType(structDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.FUNCTION_DECLARATION: {
				FunctionDeclaration functionDeclaration = (FunctionDeclaration)theEObject;
				T result = caseFunctionDeclaration(functionDeclaration);
				if (result == null) result = caseDeclaration(functionDeclaration);
				if (result == null) result = caseCallableElement(functionDeclaration);
				if (result == null) result = caseEvaluable(functionDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.CHECK: {
				Check check = (Check)theEObject;
				T result = caseCheck(check);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.EVALUABLE: {
				Evaluable evaluable = (Evaluable)theEObject;
				T result = caseEvaluable(evaluable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.CALLABLE_ELEMENT: {
				CallableElement callableElement = (CallableElement)theEObject;
				T result = caseCallableElement(callableElement);
				if (result == null) result = caseEvaluable(callableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseCallableElement(variableDeclaration);
				if (result == null) result = caseEvaluable(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.PARAMETER_DECLARATION: {
				ParameterDeclaration parameterDeclaration = (ParameterDeclaration)theEObject;
				T result = caseParameterDeclaration(parameterDeclaration);
				if (result == null) result = caseVariableDeclaration(parameterDeclaration);
				if (result == null) result = caseCallableElement(parameterDeclaration);
				if (result == null) result = caseEvaluable(parameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STATIC_PARAMETER_DECLARATION: {
				StaticParameterDeclaration staticParameterDeclaration = (StaticParameterDeclaration)theEObject;
				T result = caseStaticParameterDeclaration(staticParameterDeclaration);
				if (result == null) result = caseParameterDeclaration(staticParameterDeclaration);
				if (result == null) result = caseVariableDeclaration(staticParameterDeclaration);
				if (result == null) result = caseCallableElement(staticParameterDeclaration);
				if (result == null) result = caseEvaluable(staticParameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.INPUT_PARAMETER_DECLARATION: {
				InputParameterDeclaration inputParameterDeclaration = (InputParameterDeclaration)theEObject;
				T result = caseInputParameterDeclaration(inputParameterDeclaration);
				if (result == null) result = caseParameterDeclaration(inputParameterDeclaration);
				if (result == null) result = caseVariableDeclaration(inputParameterDeclaration);
				if (result == null) result = caseCallableElement(inputParameterDeclaration);
				if (result == null) result = caseEvaluable(inputParameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.OUTPUT_PARAMETER_DECLARATION: {
				OutputParameterDeclaration outputParameterDeclaration = (OutputParameterDeclaration)theEObject;
				T result = caseOutputParameterDeclaration(outputParameterDeclaration);
				if (result == null) result = caseParameterDeclaration(outputParameterDeclaration);
				if (result == null) result = caseVariableDeclaration(outputParameterDeclaration);
				if (result == null) result = caseCallableElement(outputParameterDeclaration);
				if (result == null) result = caseEvaluable(outputParameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ASSERTION: {
				Assertion assertion = (Assertion)theEObject;
				T result = caseAssertion(assertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STATE_VARIABLE_DECLARATION: {
				StateVariableDeclaration stateVariableDeclaration = (StateVariableDeclaration)theEObject;
				T result = caseStateVariableDeclaration(stateVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(stateVariableDeclaration);
				if (result == null) result = caseCallableElement(stateVariableDeclaration);
				if (result == null) result = caseEvaluable(stateVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.CONSTANT_DECLARATION: {
				ConstantDeclaration constantDeclaration = (ConstantDeclaration)theEObject;
				T result = caseConstantDeclaration(constantDeclaration);
				if (result == null) result = caseVariableDeclaration(constantDeclaration);
				if (result == null) result = caseCallableElement(constantDeclaration);
				if (result == null) result = caseEvaluable(constantDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION: {
				FunctionAliasDeclaration functionAliasDeclaration = (FunctionAliasDeclaration)theEObject;
				T result = caseFunctionAliasDeclaration(functionAliasDeclaration);
				if (result == null) result = caseCallableElement(functionAliasDeclaration);
				if (result == null) result = caseEvaluable(functionAliasDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.EQUATION: {
				Equation equation = (Equation)theEObject;
				T result = caseEquation(equation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.DATA_TYPE_SPECIFIER: {
				DataTypeSpecifier dataTypeSpecifier = (DataTypeSpecifier)theEObject;
				T result = caseDataTypeSpecifier(dataTypeSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ANONYMOUS_TYPE_SPECIFIER: {
				AnonymousTypeSpecifier anonymousTypeSpecifier = (AnonymousTypeSpecifier)theEObject;
				T result = caseAnonymousTypeSpecifier(anonymousTypeSpecifier);
				if (result == null) result = caseDataTypeSpecifier(anonymousTypeSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.DECLARED_TYPE_SPECIFIER: {
				DeclaredTypeSpecifier declaredTypeSpecifier = (DeclaredTypeSpecifier)theEObject;
				T result = caseDeclaredTypeSpecifier(declaredTypeSpecifier);
				if (result == null) result = caseDataTypeSpecifier(declaredTypeSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.LET_EXPRESSION: {
				LetExpression letExpression = (LetExpression)theEObject;
				T result = caseLetExpression(letExpression);
				if (result == null) result = caseExpression(letExpression);
				if (result == null) result = caseEvaluable(letExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT: {
				LetExpressionAssignment letExpressionAssignment = (LetExpressionAssignment)theEObject;
				T result = caseLetExpressionAssignment(letExpressionAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.LET_EXPRESSION_VARIABLE_DECLARATION: {
				LetExpressionVariableDeclaration letExpressionVariableDeclaration = (LetExpressionVariableDeclaration)theEObject;
				T result = caseLetExpressionVariableDeclaration(letExpressionVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(letExpressionVariableDeclaration);
				if (result == null) result = caseCallableElement(letExpressionVariableDeclaration);
				if (result == null) result = caseEvaluable(letExpressionVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.IF_EXPRESSION: {
				IfExpression ifExpression = (IfExpression)theEObject;
				T result = caseIfExpression(ifExpression);
				if (result == null) result = caseExpression(ifExpression);
				if (result == null) result = caseEvaluable(ifExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.SWITCH_EXPRESSION: {
				SwitchExpression switchExpression = (SwitchExpression)theEObject;
				T result = caseSwitchExpression(switchExpression);
				if (result == null) result = caseExpression(switchExpression);
				if (result == null) result = caseEvaluable(switchExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.SWITCH_CASE: {
				SwitchCase switchCase = (SwitchCase)theEObject;
				T result = caseSwitchCase(switchCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ARRAY_ELEMENT_ACCESS: {
				ArrayElementAccess arrayElementAccess = (ArrayElementAccess)theEObject;
				T result = caseArrayElementAccess(arrayElementAccess);
				if (result == null) result = caseExpression(arrayElementAccess);
				if (result == null) result = caseEvaluable(arrayElementAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ARRAY_SUBSCRIPT: {
				ArraySubscript arraySubscript = (ArraySubscript)theEObject;
				T result = caseArraySubscript(arraySubscript);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ITERATION_CALL: {
				IterationCall iterationCall = (IterationCall)theEObject;
				T result = caseIterationCall(iterationCall);
				if (result == null) result = caseExpression(iterationCall);
				if (result == null) result = caseEvaluable(iterationCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ITERATION_VARIABLE_DECLARATION: {
				IterationVariableDeclaration iterationVariableDeclaration = (IterationVariableDeclaration)theEObject;
				T result = caseIterationVariableDeclaration(iterationVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(iterationVariableDeclaration);
				if (result == null) result = caseCallableElement(iterationVariableDeclaration);
				if (result == null) result = caseEvaluable(iterationVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ITERATION_ACCUMULATOR: {
				IterationAccumulator iterationAccumulator = (IterationAccumulator)theEObject;
				T result = caseIterationAccumulator(iterationAccumulator);
				if (result == null) result = caseVariableDeclaration(iterationAccumulator);
				if (result == null) result = caseCallableElement(iterationAccumulator);
				if (result == null) result = caseEvaluable(iterationAccumulator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR: {
				ArrayConstructionOperator arrayConstructionOperator = (ArrayConstructionOperator)theEObject;
				T result = caseArrayConstructionOperator(arrayConstructionOperator);
				if (result == null) result = caseExpression(arrayConstructionOperator);
				if (result == null) result = caseEvaluable(arrayConstructionOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE: {
				ArrayConstructionIterationClause arrayConstructionIterationClause = (ArrayConstructionIterationClause)theEObject;
				T result = caseArrayConstructionIterationClause(arrayConstructionIterationClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ARRAY_CONCATENATION_OPERATOR: {
				ArrayConcatenationOperator arrayConcatenationOperator = (ArrayConcatenationOperator)theEObject;
				T result = caseArrayConcatenationOperator(arrayConcatenationOperator);
				if (result == null) result = caseExpression(arrayConcatenationOperator);
				if (result == null) result = caseEvaluable(arrayConcatenationOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.EXPRESSION_LIST: {
				ExpressionList expressionList = (ExpressionList)theEObject;
				T result = caseExpressionList(expressionList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STRUCT_CONSTRUCTION_OPERATOR: {
				StructConstructionOperator structConstructionOperator = (StructConstructionOperator)theEObject;
				T result = caseStructConstructionOperator(structConstructionOperator);
				if (result == null) result = caseExpression(structConstructionOperator);
				if (result == null) result = caseEvaluable(structConstructionOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STRUCT_CONSTRUCTION_MEMBER: {
				StructConstructionMember structConstructionMember = (StructConstructionMember)theEObject;
				T result = caseStructConstructionMember(structConstructionMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNIT_CONSTRUCTION_OPERATOR: {
				UnitConstructionOperator unitConstructionOperator = (UnitConstructionOperator)theEObject;
				T result = caseUnitConstructionOperator(unitConstructionOperator);
				if (result == null) result = caseExpression(unitConstructionOperator);
				if (result == null) result = caseEvaluable(unitConstructionOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.PARENTHESIZED_EXPRESSION: {
				ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression)theEObject;
				T result = caseParenthesizedExpression(parenthesizedExpression);
				if (result == null) result = caseExpression(parenthesizedExpression);
				if (result == null) result = caseEvaluable(parenthesizedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.END_EXPRESSION: {
				EndExpression endExpression = (EndExpression)theEObject;
				T result = caseEndExpression(endExpression);
				if (result == null) result = caseExpression(endExpression);
				if (result == null) result = caseEvaluable(endExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.RANGE_EXPRESSION: {
				RangeExpression rangeExpression = (RangeExpression)theEObject;
				T result = caseRangeExpression(rangeExpression);
				if (result == null) result = caseExpression(rangeExpression);
				if (result == null) result = caseEvaluable(rangeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.IMPLIES_EXPRESSION: {
				ImpliesExpression impliesExpression = (ImpliesExpression)theEObject;
				T result = caseImpliesExpression(impliesExpression);
				if (result == null) result = caseExpression(impliesExpression);
				if (result == null) result = caseEvaluable(impliesExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.LOGICAL_OR_EXPRESSION: {
				LogicalOrExpression logicalOrExpression = (LogicalOrExpression)theEObject;
				T result = caseLogicalOrExpression(logicalOrExpression);
				if (result == null) result = caseExpression(logicalOrExpression);
				if (result == null) result = caseEvaluable(logicalOrExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.LOGICAL_AND_EXPRESSION: {
				LogicalAndExpression logicalAndExpression = (LogicalAndExpression)theEObject;
				T result = caseLogicalAndExpression(logicalAndExpression);
				if (result == null) result = caseExpression(logicalAndExpression);
				if (result == null) result = caseEvaluable(logicalAndExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.EQUALITY_EXPRESSION: {
				EqualityExpression equalityExpression = (EqualityExpression)theEObject;
				T result = caseEqualityExpression(equalityExpression);
				if (result == null) result = caseExpression(equalityExpression);
				if (result == null) result = caseEvaluable(equalityExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.RELATIONAL_EXPRESSION: {
				RelationalExpression relationalExpression = (RelationalExpression)theEObject;
				T result = caseRelationalExpression(relationalExpression);
				if (result == null) result = caseExpression(relationalExpression);
				if (result == null) result = caseEvaluable(relationalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.TYPE_TEST_EXPRESSION: {
				TypeTestExpression typeTestExpression = (TypeTestExpression)theEObject;
				T result = caseTypeTestExpression(typeTestExpression);
				if (result == null) result = caseExpression(typeTestExpression);
				if (result == null) result = caseEvaluable(typeTestExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ADDITIVE_EXPRESSION: {
				AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
				T result = caseAdditiveExpression(additiveExpression);
				if (result == null) result = caseExpression(additiveExpression);
				if (result == null) result = caseEvaluable(additiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.MULTIPLICATIVE_EXPRESSION: {
				MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
				T result = caseMultiplicativeExpression(multiplicativeExpression);
				if (result == null) result = caseExpression(multiplicativeExpression);
				if (result == null) result = caseEvaluable(multiplicativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.POWER_EXPRESSION: {
				PowerExpression powerExpression = (PowerExpression)theEObject;
				T result = casePowerExpression(powerExpression);
				if (result == null) result = caseExpression(powerExpression);
				if (result == null) result = caseEvaluable(powerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = caseEvaluable(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.POSTFIX_EXPRESSION: {
				PostfixExpression postfixExpression = (PostfixExpression)theEObject;
				T result = casePostfixExpression(postfixExpression);
				if (result == null) result = caseExpression(postfixExpression);
				if (result == null) result = caseEvaluable(postfixExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.FEATURE_CALL: {
				FeatureCall featureCall = (FeatureCall)theEObject;
				T result = caseFeatureCall(featureCall);
				if (result == null) result = caseExpression(featureCall);
				if (result == null) result = caseEvaluable(featureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.VARIABLE_REFERENCE: {
				VariableReference variableReference = (VariableReference)theEObject;
				T result = caseVariableReference(variableReference);
				if (result == null) result = caseFeatureCall(variableReference);
				if (result == null) result = caseExpression(variableReference);
				if (result == null) result = caseEvaluable(variableReference);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STEP_EXPRESSION: {
				StepExpression stepExpression = (StepExpression)theEObject;
				T result = caseStepExpression(stepExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.RANGE_STEP_EXPRESSION: {
				RangeStepExpression rangeStepExpression = (RangeStepExpression)theEObject;
				T result = caseRangeStepExpression(rangeStepExpression);
				if (result == null) result = caseStepExpression(rangeStepExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ADDITIVE_STEP_EXPRESSION: {
				AdditiveStepExpression additiveStepExpression = (AdditiveStepExpression)theEObject;
				T result = caseAdditiveStepExpression(additiveStepExpression);
				if (result == null) result = caseStepExpression(additiveStepExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.NEGATE_STEP_EXPRESSION: {
				NegateStepExpression negateStepExpression = (NegateStepExpression)theEObject;
				T result = caseNegateStepExpression(negateStepExpression);
				if (result == null) result = caseStepExpression(negateStepExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.PRIMITIVE_STEP_EXPRESSION: {
				PrimitiveStepExpression primitiveStepExpression = (PrimitiveStepExpression)theEObject;
				T result = casePrimitiveStepExpression(primitiveStepExpression);
				if (result == null) result = caseStepExpression(primitiveStepExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STEP_LITERAL: {
				StepLiteral stepLiteral = (StepLiteral)theEObject;
				T result = caseStepLiteral(stepLiteral);
				if (result == null) result = casePrimitiveStepExpression(stepLiteral);
				if (result == null) result = caseStepExpression(stepLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STEP_N: {
				StepN stepN = (StepN)theEObject;
				T result = caseStepN(stepN);
				if (result == null) result = casePrimitiveStepExpression(stepN);
				if (result == null) result = caseStepExpression(stepN);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.FUNCTION_CALL: {
				FunctionCall functionCall = (FunctionCall)theEObject;
				T result = caseFunctionCall(functionCall);
				if (result == null) result = caseFeatureCall(functionCall);
				if (result == null) result = caseExpression(functionCall);
				if (result == null) result = caseEvaluable(functionCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.MEMBER_VARIABLE_ACCESS: {
				MemberVariableAccess memberVariableAccess = (MemberVariableAccess)theEObject;
				T result = caseMemberVariableAccess(memberVariableAccess);
				if (result == null) result = caseExpression(memberVariableAccess);
				if (result == null) result = caseEvaluable(memberVariableAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ALGORITHM_EXPRESSION: {
				AlgorithmExpression algorithmExpression = (AlgorithmExpression)theEObject;
				T result = caseAlgorithmExpression(algorithmExpression);
				if (result == null) result = caseExpression(algorithmExpression);
				if (result == null) result = caseEvaluable(algorithmExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.INVALID_EXPRESSION: {
				InvalidExpression invalidExpression = (InvalidExpression)theEObject;
				T result = caseInvalidExpression(invalidExpression);
				if (result == null) result = caseExpression(invalidExpression);
				if (result == null) result = caseEvaluable(invalidExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.COMPOUND: {
				Compound compound = (Compound)theEObject;
				T result = caseCompound(compound);
				if (result == null) result = caseStatement(compound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ASSIGNMENT: {
				Assignment assignment = (Assignment)theEObject;
				T result = caseAssignment(assignment);
				if (result == null) result = caseStatement(assignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.LOCAL_VARIABLE_DECLARATION: {
				LocalVariableDeclaration localVariableDeclaration = (LocalVariableDeclaration)theEObject;
				T result = caseLocalVariableDeclaration(localVariableDeclaration);
				if (result == null) result = caseStatement(localVariableDeclaration);
				if (result == null) result = caseVariableDeclaration(localVariableDeclaration);
				if (result == null) result = caseCallableElement(localVariableDeclaration);
				if (result == null) result = caseEvaluable(localVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.WHILE_STATEMENT: {
				WhileStatement whileStatement = (WhileStatement)theEObject;
				T result = caseWhileStatement(whileStatement);
				if (result == null) result = caseStatement(whileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.DO_WHILE_STATEMENT: {
				DoWhileStatement doWhileStatement = (DoWhileStatement)theEObject;
				T result = caseDoWhileStatement(doWhileStatement);
				if (result == null) result = caseStatement(doWhileStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.CONTINUE_STATEMENT: {
				ContinueStatement continueStatement = (ContinueStatement)theEObject;
				T result = caseContinueStatement(continueStatement);
				if (result == null) result = caseStatement(continueStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.BREAK_STATEMENT: {
				BreakStatement breakStatement = (BreakStatement)theEObject;
				T result = caseBreakStatement(breakStatement);
				if (result == null) result = caseStatement(breakStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.RETURN_STATEMENT: {
				ReturnStatement returnStatement = (ReturnStatement)theEObject;
				T result = caseReturnStatement(returnStatement);
				if (result == null) result = caseStatement(returnStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.BUILTIN_DECLARATION: {
				BuiltinDeclaration builtinDeclaration = (BuiltinDeclaration)theEObject;
				T result = caseBuiltinDeclaration(builtinDeclaration);
				if (result == null) result = caseDeclaration(builtinDeclaration);
				if (result == null) result = caseCallableElement(builtinDeclaration);
				if (result == null) result = caseEvaluable(builtinDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.BUILTIN_FUNCTION_DECLARATION: {
				BuiltinFunctionDeclaration builtinFunctionDeclaration = (BuiltinFunctionDeclaration)theEObject;
				T result = caseBuiltinFunctionDeclaration(builtinFunctionDeclaration);
				if (result == null) result = caseBuiltinDeclaration(builtinFunctionDeclaration);
				if (result == null) result = caseDeclaration(builtinFunctionDeclaration);
				if (result == null) result = caseCallableElement(builtinFunctionDeclaration);
				if (result == null) result = caseEvaluable(builtinFunctionDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.BUILTIN_VARIABLE_DECLARATION: {
				BuiltinVariableDeclaration builtinVariableDeclaration = (BuiltinVariableDeclaration)theEObject;
				T result = caseBuiltinVariableDeclaration(builtinVariableDeclaration);
				if (result == null) result = caseBuiltinDeclaration(builtinVariableDeclaration);
				if (result == null) result = caseDeclaration(builtinVariableDeclaration);
				if (result == null) result = caseCallableElement(builtinVariableDeclaration);
				if (result == null) result = caseEvaluable(builtinVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.INVALID_DATA_TYPE: {
				InvalidDataType invalidDataType = (InvalidDataType)theEObject;
				T result = caseInvalidDataType(invalidDataType);
				if (result == null) result = caseDataType(invalidDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ANY_DATA_TYPE: {
				AnyDataType anyDataType = (AnyDataType)theEObject;
				T result = caseAnyDataType(anyDataType);
				if (result == null) result = caseDataType(anyDataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNIT_TYPE: {
				UnitType unitType = (UnitType)theEObject;
				T result = caseUnitType(unitType);
				if (result == null) result = caseDataType(unitType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.PRIMITIVE_TYPE: {
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseDataType(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.NUMERIC_TYPE: {
				NumericType numericType = (NumericType)theEObject;
				T result = caseNumericType(numericType);
				if (result == null) result = casePrimitiveType(numericType);
				if (result == null) result = caseDataType(numericType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.REAL_TYPE: {
				RealType realType = (RealType)theEObject;
				T result = caseRealType(realType);
				if (result == null) result = caseNumericType(realType);
				if (result == null) result = casePrimitiveType(realType);
				if (result == null) result = caseDataType(realType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType)theEObject;
				T result = caseIntegerType(integerType);
				if (result == null) result = caseNumericType(integerType);
				if (result == null) result = casePrimitiveType(integerType);
				if (result == null) result = caseDataType(integerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.COMPLEX_TYPE: {
				ComplexType complexType = (ComplexType)theEObject;
				T result = caseComplexType(complexType);
				if (result == null) result = caseNumericType(complexType);
				if (result == null) result = casePrimitiveType(complexType);
				if (result == null) result = caseDataType(complexType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.GAUSSIAN_TYPE: {
				GaussianType gaussianType = (GaussianType)theEObject;
				T result = caseGaussianType(gaussianType);
				if (result == null) result = caseNumericType(gaussianType);
				if (result == null) result = casePrimitiveType(gaussianType);
				if (result == null) result = caseDataType(gaussianType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType)theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null) result = casePrimitiveType(booleanType);
				if (result == null) result = caseDataType(booleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = casePrimitiveType(stringType);
				if (result == null) result = caseDataType(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ARRAY_TYPE: {
				ArrayType arrayType = (ArrayType)theEObject;
				T result = caseArrayType(arrayType);
				if (result == null) result = caseDataType(arrayType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.ARRAY_DIMENSION: {
				ArrayDimension arrayDimension = (ArrayDimension)theEObject;
				T result = caseArrayDimension(arrayDimension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STRUCT_TYPE: {
				StructType structType = (StructType)theEObject;
				T result = caseStructType(structType);
				if (result == null) result = caseDataType(structType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STRUCT_MEMBER: {
				StructMember structMember = (StructMember)theEObject;
				T result = caseStructMember(structMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = caseEvaluable(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNIT: {
				Unit unit = (Unit)theEObject;
				T result = caseUnit(unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNIT_PRODUCT: {
				UnitProduct unitProduct = (UnitProduct)theEObject;
				T result = caseUnitProduct(unitProduct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNIT_NUMERATOR: {
				UnitNumerator unitNumerator = (UnitNumerator)theEObject;
				T result = caseUnitNumerator(unitNumerator);
				if (result == null) result = caseUnitProduct(unitNumerator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNIT_DENOMINATOR: {
				UnitDenominator unitDenominator = (UnitDenominator)theEObject;
				T result = caseUnitDenominator(unitDenominator);
				if (result == null) result = caseUnitProduct(unitDenominator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.UNIT_FACTOR: {
				UnitFactor unitFactor = (UnitFactor)theEObject;
				T result = caseUnitFactor(unitFactor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.LITERAL: {
				Literal literal = (Literal)theEObject;
				T result = caseLiteral(literal);
				if (result == null) result = caseExpression(literal);
				if (result == null) result = caseEvaluable(literal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.NUMERIC_LITERAL: {
				NumericLiteral numericLiteral = (NumericLiteral)theEObject;
				T result = caseNumericLiteral(numericLiteral);
				if (result == null) result = caseLiteral(numericLiteral);
				if (result == null) result = caseExpression(numericLiteral);
				if (result == null) result = caseEvaluable(numericLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.REAL_LITERAL: {
				RealLiteral realLiteral = (RealLiteral)theEObject;
				T result = caseRealLiteral(realLiteral);
				if (result == null) result = caseNumericLiteral(realLiteral);
				if (result == null) result = caseLiteral(realLiteral);
				if (result == null) result = caseExpression(realLiteral);
				if (result == null) result = caseEvaluable(realLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.INTEGER_LITERAL: {
				IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
				T result = caseIntegerLiteral(integerLiteral);
				if (result == null) result = caseNumericLiteral(integerLiteral);
				if (result == null) result = caseLiteral(integerLiteral);
				if (result == null) result = caseExpression(integerLiteral);
				if (result == null) result = caseEvaluable(integerLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseLiteral(booleanLiteral);
				if (result == null) result = caseExpression(booleanLiteral);
				if (result == null) result = caseEvaluable(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseLiteral(stringLiteral);
				if (result == null) result = caseExpression(stringLiteral);
				if (result == null) result = caseEvaluable(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.TEMPLATE_EXPRESSION: {
				TemplateExpression templateExpression = (TemplateExpression)theEObject;
				T result = caseTemplateExpression(templateExpression);
				if (result == null) result = caseExpression(templateExpression);
				if (result == null) result = caseEvaluable(templateExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.TEMPLATE_SEGMENT: {
				TemplateSegment templateSegment = (TemplateSegment)theEObject;
				T result = caseTemplateSegment(templateSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.CONSTANT_TEMPLATE_SEGMENT: {
				ConstantTemplateSegment constantTemplateSegment = (ConstantTemplateSegment)theEObject;
				T result = caseConstantTemplateSegment(constantTemplateSegment);
				if (result == null) result = caseTemplateSegment(constantTemplateSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MscriptPackage.EXPRESSION_TEMPLATE_SEGMENT: {
				ExpressionTemplateSegment expressionTemplateSegment = (ExpressionTemplateSegment)theEObject;
				T result = caseExpressionTemplateSegment(expressionTemplateSegment);
				if (result == null) result = caseTemplateSegment(expressionTemplateSegment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Module</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModule(Module object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportDeclaration(ImportDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeDeclaration(DataTypeDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationDeclaration(EnumerationDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteralDeclaration(EnumerationLiteralDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructDeclaration(StructDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDeclaration(FunctionDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheck(Check object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluable(Evaluable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Callable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Callable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallableElement(CallableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDeclaration(ParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticParameterDeclaration(StaticParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputParameterDeclaration(InputParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Parameter Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputParameterDeclaration(OutputParameterDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assertion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssertion(Assertion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateVariableDeclaration(StateVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantDeclaration(ConstantDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Alias Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Alias Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionAliasDeclaration(FunctionAliasDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEquation(Equation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeSpecifier(DataTypeSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anonymous Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anonymous Type Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnonymousTypeSpecifier(AnonymousTypeSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declared Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declared Type Specifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaredTypeSpecifier(DeclaredTypeSpecifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExpression(LetExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Expression Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Expression Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExpressionAssignment(LetExpressionAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Expression Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Expression Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExpressionVariableDeclaration(LetExpressionVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfExpression(IfExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchExpression(SwitchExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchCase(SwitchCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Element Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Element Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayElementAccess(ArrayElementAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Subscript</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Subscript</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArraySubscript(ArraySubscript object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterationCall(IterationCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterationVariableDeclaration(IterationVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iteration Accumulator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration Accumulator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterationAccumulator(IterationAccumulator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Construction Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayConstructionOperator(ArrayConstructionOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Construction Iteration Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Construction Iteration Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayConstructionIterationClause(ArrayConstructionIterationClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Concatenation Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Concatenation Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayConcatenationOperator(ArrayConcatenationOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionList(ExpressionList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Construction Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructConstructionOperator(StructConstructionOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Construction Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Construction Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructConstructionMember(StructConstructionMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Construction Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitConstructionOperator(UnitConstructionOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parenthesized Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParenthesizedExpression(ParenthesizedExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndExpression(EndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeExpression(RangeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Implies Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Implies Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImpliesExpression(ImpliesExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalOrExpression(LogicalOrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Logical And Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLogicalAndExpression(LogicalAndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equality Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualityExpression(EqualityExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExpression(RelationalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Test Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeTestExpression(TypeTestExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExpression(AdditiveExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExpression(MultiplicativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Power Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Power Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePowerExpression(PowerExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postfix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postfix Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostfixExpression(PostfixExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCall(FeatureCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableReference(VariableReference object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepExpression(StepExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Range Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Range Step Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRangeStepExpression(RangeStepExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Step Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveStepExpression(AdditiveStepExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Negate Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Negate Step Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNegateStepExpression(NegateStepExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Step Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveStepExpression(PrimitiveStepExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepLiteral(StepLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Step N</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Step N</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepN(StepN object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionCall(FunctionCall object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member Variable Access</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemberVariableAccess(MemberVariableAccess object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Algorithm Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Algorithm Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlgorithmExpression(AlgorithmExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidExpression(InvalidExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompound(Compound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignment(Assignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariableDeclaration(LocalVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileStatement(WhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Do While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Do While Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoWhileStatement(DoWhileStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continue Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinueStatement(ContinueStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Break Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBreakStatement(BreakStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReturnStatement(ReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinDeclaration(BuiltinDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Function Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinFunctionDeclaration(BuiltinFunctionDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinVariableDeclaration(BuiltinVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invalid Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invalid Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvalidDataType(InvalidDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Any Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Any Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnyDataType(AnyDataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitType(UnitType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericType(NumericType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealType(RealType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexType(ComplexType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Gaussian Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Gaussian Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGaussianType(GaussianType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayType(ArrayType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Array Dimension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArrayDimension(ArrayDimension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructType(StructType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Struct Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Struct Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructMember(StructMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnit(Unit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitProduct(UnitProduct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Numerator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Numerator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitNumerator(UnitNumerator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Denominator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Denominator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitDenominator(UnitDenominator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit Factor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit Factor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnitFactor(UnitFactor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteral(Literal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericLiteral(NumericLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealLiteral(RealLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateExpression(TemplateExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Template Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Template Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTemplateSegment(TemplateSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Template Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Template Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantTemplateSegment(ConstantTemplateSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Template Segment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Template Segment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionTemplateSegment(ExpressionTemplateSegment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MscriptSwitch
