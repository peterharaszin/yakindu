/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator;
import org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause;
import org.eclipselabs.mscript.language.ast.ArrayConstructionOperator;
import org.eclipselabs.mscript.language.ast.ArrayElementAccess;
import org.eclipselabs.mscript.language.ast.ArraySubscript;
import org.eclipselabs.mscript.language.ast.Assertion;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.BuiltinDefinition;
import org.eclipselabs.mscript.language.ast.BuiltinFunction;
import org.eclipselabs.mscript.language.ast.BuiltinVariable;
import org.eclipselabs.mscript.language.ast.CallableElement;
import org.eclipselabs.mscript.language.ast.DataTypeDefinition;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.Definition;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.EnumerationDefinition;
import org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.Equation;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.FeatureCall;
import org.eclipselabs.mscript.language.ast.FeatureCallPart;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration;
import org.eclipselabs.mscript.language.ast.IfExpression;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IterationAccumulator;
import org.eclipselabs.mscript.language.ast.IterationCall;
import org.eclipselabs.mscript.language.ast.IterationVariable;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.NameComponent;
import org.eclipselabs.mscript.language.ast.OperationArgumentList;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.PostfixExpression;
import org.eclipselabs.mscript.language.ast.PowerExpression;
import org.eclipselabs.mscript.language.ast.RangeExpression;
import org.eclipselabs.mscript.language.ast.RecordDefinition;
import org.eclipselabs.mscript.language.ast.RecordFieldDeclaration;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.ast.SwitchCase;
import org.eclipselabs.mscript.language.ast.SwitchExpression;
import org.eclipselabs.mscript.language.ast.TypeAliasDefinition;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.typesystem.Expression;

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
 * @see org.eclipselabs.mscript.language.ast.AstPackage
 * @generated
 */
public class AstSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AstPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstSwitch() {
		if (modelPackage == null) {
			modelPackage = AstPackage.eINSTANCE;
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
			case AstPackage.MODULE: {
				Module module = (Module)theEObject;
				T result = caseModule(module);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.DEFINITION: {
				Definition definition = (Definition)theEObject;
				T result = caseDefinition(definition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.DATA_TYPE_DEFINITION: {
				DataTypeDefinition dataTypeDefinition = (DataTypeDefinition)theEObject;
				T result = caseDataTypeDefinition(dataTypeDefinition);
				if (result == null) result = caseDefinition(dataTypeDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ENUMERATION_DEFINITION: {
				EnumerationDefinition enumerationDefinition = (EnumerationDefinition)theEObject;
				T result = caseEnumerationDefinition(enumerationDefinition);
				if (result == null) result = caseDataTypeDefinition(enumerationDefinition);
				if (result == null) result = caseDefinition(enumerationDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ENUMERATION_LITERAL_DECLARATION: {
				EnumerationLiteralDeclaration enumerationLiteralDeclaration = (EnumerationLiteralDeclaration)theEObject;
				T result = caseEnumerationLiteralDeclaration(enumerationLiteralDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.TYPE_ALIAS_DEFINITION: {
				TypeAliasDefinition typeAliasDefinition = (TypeAliasDefinition)theEObject;
				T result = caseTypeAliasDefinition(typeAliasDefinition);
				if (result == null) result = caseDataTypeDefinition(typeAliasDefinition);
				if (result == null) result = caseDefinition(typeAliasDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.RECORD_DEFINITION: {
				RecordDefinition recordDefinition = (RecordDefinition)theEObject;
				T result = caseRecordDefinition(recordDefinition);
				if (result == null) result = caseDataTypeDefinition(recordDefinition);
				if (result == null) result = caseDefinition(recordDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.RECORD_FIELD_DECLARATION: {
				RecordFieldDeclaration recordFieldDeclaration = (RecordFieldDeclaration)theEObject;
				T result = caseRecordFieldDeclaration(recordFieldDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FUNCTION_DEFINITION: {
				FunctionDefinition functionDefinition = (FunctionDefinition)theEObject;
				T result = caseFunctionDefinition(functionDefinition);
				if (result == null) result = caseDefinition(functionDefinition);
				if (result == null) result = caseCallableElement(functionDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.CALLABLE_ELEMENT: {
				CallableElement callableElement = (CallableElement)theEObject;
				T result = caseCallableElement(callableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.PARAMETER_DECLARATION: {
				ParameterDeclaration parameterDeclaration = (ParameterDeclaration)theEObject;
				T result = caseParameterDeclaration(parameterDeclaration);
				if (result == null) result = caseCallableElement(parameterDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ASSERTION: {
				Assertion assertion = (Assertion)theEObject;
				T result = caseAssertion(assertion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.STATE_VARIABLE_DECLARATION: {
				StateVariableDeclaration stateVariableDeclaration = (StateVariableDeclaration)theEObject;
				T result = caseStateVariableDeclaration(stateVariableDeclaration);
				if (result == null) result = caseCallableElement(stateVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FUNCTION_OBJECT_DECLARATION: {
				FunctionObjectDeclaration functionObjectDeclaration = (FunctionObjectDeclaration)theEObject;
				T result = caseFunctionObjectDeclaration(functionObjectDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EQUATION: {
				Equation equation = (Equation)theEObject;
				T result = caseEquation(equation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.DATA_TYPE_SPECIFIER: {
				DataTypeSpecifier dataTypeSpecifier = (DataTypeSpecifier)theEObject;
				T result = caseDataTypeSpecifier(dataTypeSpecifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LET_EXPRESSION: {
				LetExpression letExpression = (LetExpression)theEObject;
				T result = caseLetExpression(letExpression);
				if (result == null) result = caseExpression(letExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION: {
				LetExpressionVariableDeclaration letExpressionVariableDeclaration = (LetExpressionVariableDeclaration)theEObject;
				T result = caseLetExpressionVariableDeclaration(letExpressionVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION_PART: {
				LetExpressionVariableDeclarationPart letExpressionVariableDeclarationPart = (LetExpressionVariableDeclarationPart)theEObject;
				T result = caseLetExpressionVariableDeclarationPart(letExpressionVariableDeclarationPart);
				if (result == null) result = caseCallableElement(letExpressionVariableDeclarationPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.IF_EXPRESSION: {
				IfExpression ifExpression = (IfExpression)theEObject;
				T result = caseIfExpression(ifExpression);
				if (result == null) result = caseExpression(ifExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.SWITCH_EXPRESSION: {
				SwitchExpression switchExpression = (SwitchExpression)theEObject;
				T result = caseSwitchExpression(switchExpression);
				if (result == null) result = caseExpression(switchExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.SWITCH_CASE: {
				SwitchCase switchCase = (SwitchCase)theEObject;
				T result = caseSwitchCase(switchCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ADDITIVE_EXPRESSION_PART: {
				AdditiveExpressionPart additiveExpressionPart = (AdditiveExpressionPart)theEObject;
				T result = caseAdditiveExpressionPart(additiveExpressionPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.MULTIPLICATIVE_EXPRESSION_PART: {
				MultiplicativeExpressionPart multiplicativeExpressionPart = (MultiplicativeExpressionPart)theEObject;
				T result = caseMultiplicativeExpressionPart(multiplicativeExpressionPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FEATURE_CALL_PART: {
				FeatureCallPart featureCallPart = (FeatureCallPart)theEObject;
				T result = caseFeatureCallPart(featureCallPart);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.NAME_COMPONENT: {
				NameComponent nameComponent = (NameComponent)theEObject;
				T result = caseNameComponent(nameComponent);
				if (result == null) result = caseFeatureCallPart(nameComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_ELEMENT_ACCESS: {
				ArrayElementAccess arrayElementAccess = (ArrayElementAccess)theEObject;
				T result = caseArrayElementAccess(arrayElementAccess);
				if (result == null) result = caseFeatureCallPart(arrayElementAccess);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_SUBSCRIPT: {
				ArraySubscript arraySubscript = (ArraySubscript)theEObject;
				T result = caseArraySubscript(arraySubscript);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.OPERATION_ARGUMENT_LIST: {
				OperationArgumentList operationArgumentList = (OperationArgumentList)theEObject;
				T result = caseOperationArgumentList(operationArgumentList);
				if (result == null) result = caseFeatureCallPart(operationArgumentList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ITERATION_CALL: {
				IterationCall iterationCall = (IterationCall)theEObject;
				T result = caseIterationCall(iterationCall);
				if (result == null) result = caseFeatureCallPart(iterationCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ITERATION_VARIABLE: {
				IterationVariable iterationVariable = (IterationVariable)theEObject;
				T result = caseIterationVariable(iterationVariable);
				if (result == null) result = caseCallableElement(iterationVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ITERATION_ACCUMULATOR: {
				IterationAccumulator iterationAccumulator = (IterationAccumulator)theEObject;
				T result = caseIterationAccumulator(iterationAccumulator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_CONSTRUCTION_OPERATOR: {
				ArrayConstructionOperator arrayConstructionOperator = (ArrayConstructionOperator)theEObject;
				T result = caseArrayConstructionOperator(arrayConstructionOperator);
				if (result == null) result = caseExpression(arrayConstructionOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE: {
				ArrayConstructionIterationClause arrayConstructionIterationClause = (ArrayConstructionIterationClause)theEObject;
				T result = caseArrayConstructionIterationClause(arrayConstructionIterationClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ARRAY_CONCATENATION_OPERATOR: {
				ArrayConcatenationOperator arrayConcatenationOperator = (ArrayConcatenationOperator)theEObject;
				T result = caseArrayConcatenationOperator(arrayConcatenationOperator);
				if (result == null) result = caseExpression(arrayConcatenationOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EXPRESSION_LIST: {
				ExpressionList expressionList = (ExpressionList)theEObject;
				T result = caseExpressionList(expressionList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.UNIT_CONSTRUCTION_OPERATOR: {
				UnitConstructionOperator unitConstructionOperator = (UnitConstructionOperator)theEObject;
				T result = caseUnitConstructionOperator(unitConstructionOperator);
				if (result == null) result = caseExpression(unitConstructionOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.PARENTHESIZED_EXPRESSION: {
				ParenthesizedExpression parenthesizedExpression = (ParenthesizedExpression)theEObject;
				T result = caseParenthesizedExpression(parenthesizedExpression);
				if (result == null) result = caseExpression(parenthesizedExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BEGIN_EXPRESSION: {
				BeginExpression beginExpression = (BeginExpression)theEObject;
				T result = caseBeginExpression(beginExpression);
				if (result == null) result = caseExpression(beginExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.END_EXPRESSION: {
				EndExpression endExpression = (EndExpression)theEObject;
				T result = caseEndExpression(endExpression);
				if (result == null) result = caseExpression(endExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.RANGE_EXPRESSION: {
				RangeExpression rangeExpression = (RangeExpression)theEObject;
				T result = caseRangeExpression(rangeExpression);
				if (result == null) result = caseExpression(rangeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.IMPLIES_EXPRESSION: {
				ImpliesExpression impliesExpression = (ImpliesExpression)theEObject;
				T result = caseImpliesExpression(impliesExpression);
				if (result == null) result = caseExpression(impliesExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LOGICAL_OR_EXPRESSION: {
				LogicalOrExpression logicalOrExpression = (LogicalOrExpression)theEObject;
				T result = caseLogicalOrExpression(logicalOrExpression);
				if (result == null) result = caseExpression(logicalOrExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.LOGICAL_AND_EXPRESSION: {
				LogicalAndExpression logicalAndExpression = (LogicalAndExpression)theEObject;
				T result = caseLogicalAndExpression(logicalAndExpression);
				if (result == null) result = caseExpression(logicalAndExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.EQUALITY_EXPRESSION: {
				EqualityExpression equalityExpression = (EqualityExpression)theEObject;
				T result = caseEqualityExpression(equalityExpression);
				if (result == null) result = caseExpression(equalityExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.RELATIONAL_EXPRESSION: {
				RelationalExpression relationalExpression = (RelationalExpression)theEObject;
				T result = caseRelationalExpression(relationalExpression);
				if (result == null) result = caseExpression(relationalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.TYPE_TEST_EXPRESSION: {
				TypeTestExpression typeTestExpression = (TypeTestExpression)theEObject;
				T result = caseTypeTestExpression(typeTestExpression);
				if (result == null) result = caseExpression(typeTestExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.ADDITIVE_EXPRESSION: {
				AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
				T result = caseAdditiveExpression(additiveExpression);
				if (result == null) result = caseExpression(additiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.MULTIPLICATIVE_EXPRESSION: {
				MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
				T result = caseMultiplicativeExpression(multiplicativeExpression);
				if (result == null) result = caseExpression(multiplicativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.POWER_EXPRESSION: {
				PowerExpression powerExpression = (PowerExpression)theEObject;
				T result = casePowerExpression(powerExpression);
				if (result == null) result = caseExpression(powerExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.POSTFIX_EXPRESSION: {
				PostfixExpression postfixExpression = (PostfixExpression)theEObject;
				T result = casePostfixExpression(postfixExpression);
				if (result == null) result = caseExpression(postfixExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.FEATURE_CALL: {
				FeatureCall featureCall = (FeatureCall)theEObject;
				T result = caseFeatureCall(featureCall);
				if (result == null) result = caseExpression(featureCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BUILTIN_DEFINITION: {
				BuiltinDefinition builtinDefinition = (BuiltinDefinition)theEObject;
				T result = caseBuiltinDefinition(builtinDefinition);
				if (result == null) result = caseDefinition(builtinDefinition);
				if (result == null) result = caseCallableElement(builtinDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BUILTIN_FUNCTION: {
				BuiltinFunction builtinFunction = (BuiltinFunction)theEObject;
				T result = caseBuiltinFunction(builtinFunction);
				if (result == null) result = caseBuiltinDefinition(builtinFunction);
				if (result == null) result = caseDefinition(builtinFunction);
				if (result == null) result = caseCallableElement(builtinFunction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AstPackage.BUILTIN_VARIABLE: {
				BuiltinVariable builtinVariable = (BuiltinVariable)theEObject;
				T result = caseBuiltinVariable(builtinVariable);
				if (result == null) result = caseBuiltinDefinition(builtinVariable);
				if (result == null) result = caseDefinition(builtinVariable);
				if (result == null) result = caseCallableElement(builtinVariable);
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
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinition(Definition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeDefinition(DataTypeDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationDefinition(EnumerationDefinition object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Type Alias Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Alias Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeAliasDefinition(TypeAliasDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordDefinition(RecordDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record Field Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecordFieldDeclaration(RecordFieldDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionDefinition(FunctionDefinition object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Function Object Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function Object Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunctionObjectDeclaration(FunctionObjectDeclaration object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Let Expression Variable Declaration Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Expression Variable Declaration Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExpressionVariableDeclarationPart(LetExpressionVariableDeclarationPart object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Additive Expression Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Expression Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExpressionPart(AdditiveExpressionPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExpressionPart(MultiplicativeExpressionPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Call Part</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Call Part</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeatureCallPart(FeatureCallPart object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameComponent(NameComponent object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Operation Argument List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Argument List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationArgumentList(OperationArgumentList object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Iteration Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iteration Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIterationVariable(IterationVariable object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Begin Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Begin Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBeginExpression(BeginExpression object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinDefinition(BuiltinDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinFunction(BuiltinFunction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinVariable(BuiltinVariable object) {
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

} //AstSwitch
