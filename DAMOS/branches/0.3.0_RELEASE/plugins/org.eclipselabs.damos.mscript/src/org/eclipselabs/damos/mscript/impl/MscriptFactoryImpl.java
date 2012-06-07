/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.damos.mscript.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MscriptFactoryImpl extends EFactoryImpl implements MscriptFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MscriptFactory init() {
		try {
			MscriptFactory theMscriptFactory = (MscriptFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/damos/mscript/2011/Mscript"); 
			if (theMscriptFactory != null) {
				return theMscriptFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MscriptFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MscriptFactoryImpl() {
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
			case MscriptPackage.MODULE: return createModule();
			case MscriptPackage.IMPORT_DECLARATION: return createImportDeclaration();
			case MscriptPackage.DATA_TYPE_DECLARATION: return createDataTypeDeclaration();
			case MscriptPackage.ENUMERATION_DECLARATION: return createEnumerationDeclaration();
			case MscriptPackage.ENUMERATION_LITERAL_DECLARATION: return createEnumerationLiteralDeclaration();
			case MscriptPackage.STRUCT_DECLARATION: return createStructDeclaration();
			case MscriptPackage.FUNCTION_DECLARATION: return createFunctionDeclaration();
			case MscriptPackage.CHECK: return createCheck();
			case MscriptPackage.TEMPLATE_PARAMETER_DECLARATION: return createTemplateParameterDeclaration();
			case MscriptPackage.INPUT_PARAMETER_DECLARATION: return createInputParameterDeclaration();
			case MscriptPackage.OUTPUT_PARAMETER_DECLARATION: return createOutputParameterDeclaration();
			case MscriptPackage.ASSERTION: return createAssertion();
			case MscriptPackage.STATE_VARIABLE_DECLARATION: return createStateVariableDeclaration();
			case MscriptPackage.CONSTANT_DECLARATION: return createConstantDeclaration();
			case MscriptPackage.FUNCTION_ALIAS_DECLARATION: return createFunctionAliasDeclaration();
			case MscriptPackage.EQUATION: return createEquation();
			case MscriptPackage.ANONYMOUS_TYPE_SPECIFIER: return createAnonymousTypeSpecifier();
			case MscriptPackage.DECLARED_TYPE_SPECIFIER: return createDeclaredTypeSpecifier();
			case MscriptPackage.LET_EXPRESSION: return createLetExpression();
			case MscriptPackage.LET_EXPRESSION_ASSIGNMENT: return createLetExpressionAssignment();
			case MscriptPackage.LET_EXPRESSION_VARIABLE_DECLARATION: return createLetExpressionVariableDeclaration();
			case MscriptPackage.IF_EXPRESSION: return createIfExpression();
			case MscriptPackage.SWITCH_EXPRESSION: return createSwitchExpression();
			case MscriptPackage.SWITCH_CASE: return createSwitchCase();
			case MscriptPackage.ARRAY_ELEMENT_ACCESS: return createArrayElementAccess();
			case MscriptPackage.ARRAY_SUBSCRIPT: return createArraySubscript();
			case MscriptPackage.ITERATION_CALL: return createIterationCall();
			case MscriptPackage.ITERATION_VARIABLE_DECLARATION: return createIterationVariableDeclaration();
			case MscriptPackage.ITERATION_ACCUMULATOR: return createIterationAccumulator();
			case MscriptPackage.ARRAY_CONSTRUCTION_OPERATOR: return createArrayConstructionOperator();
			case MscriptPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE: return createArrayConstructionIterationClause();
			case MscriptPackage.ARRAY_CONCATENATION_OPERATOR: return createArrayConcatenationOperator();
			case MscriptPackage.EXPRESSION_LIST: return createExpressionList();
			case MscriptPackage.STRUCT_CONSTRUCTION_OPERATOR: return createStructConstructionOperator();
			case MscriptPackage.STRUCT_CONSTRUCTION_MEMBER: return createStructConstructionMember();
			case MscriptPackage.UNIT_CONSTRUCTION_OPERATOR: return createUnitConstructionOperator();
			case MscriptPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
			case MscriptPackage.END_EXPRESSION: return createEndExpression();
			case MscriptPackage.RANGE_EXPRESSION: return createRangeExpression();
			case MscriptPackage.IMPLIES_EXPRESSION: return createImpliesExpression();
			case MscriptPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
			case MscriptPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
			case MscriptPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
			case MscriptPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
			case MscriptPackage.TYPE_TEST_EXPRESSION: return createTypeTestExpression();
			case MscriptPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
			case MscriptPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
			case MscriptPackage.POWER_EXPRESSION: return createPowerExpression();
			case MscriptPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case MscriptPackage.POSTFIX_EXPRESSION: return createPostfixExpression();
			case MscriptPackage.VARIABLE_REFERENCE: return createVariableReference();
			case MscriptPackage.RANGE_STEP_EXPRESSION: return createRangeStepExpression();
			case MscriptPackage.ADDITIVE_STEP_EXPRESSION: return createAdditiveStepExpression();
			case MscriptPackage.NEGATE_STEP_EXPRESSION: return createNegateStepExpression();
			case MscriptPackage.STEP_LITERAL: return createStepLiteral();
			case MscriptPackage.STEP_N: return createStepN();
			case MscriptPackage.FUNCTION_CALL: return createFunctionCall();
			case MscriptPackage.MEMBER_VARIABLE_ACCESS: return createMemberVariableAccess();
			case MscriptPackage.ALGORITHM_EXPRESSION: return createAlgorithmExpression();
			case MscriptPackage.INVALID_EXPRESSION: return createInvalidExpression();
			case MscriptPackage.COMPOUND: return createCompound();
			case MscriptPackage.ASSIGNMENT: return createAssignment();
			case MscriptPackage.LOCAL_VARIABLE_DECLARATION: return createLocalVariableDeclaration();
			case MscriptPackage.IF_STATEMENT: return createIfStatement();
			case MscriptPackage.WHILE_STATEMENT: return createWhileStatement();
			case MscriptPackage.DO_WHILE_STATEMENT: return createDoWhileStatement();
			case MscriptPackage.FOR_STATEMENT: return createForStatement();
			case MscriptPackage.CONTINUE_STATEMENT: return createContinueStatement();
			case MscriptPackage.BREAK_STATEMENT: return createBreakStatement();
			case MscriptPackage.RETURN_STATEMENT: return createReturnStatement();
			case MscriptPackage.BUILTIN_DECLARATION: return createBuiltinDeclaration();
			case MscriptPackage.BUILTIN_FUNCTION_DECLARATION: return createBuiltinFunctionDeclaration();
			case MscriptPackage.BUILTIN_VARIABLE_DECLARATION: return createBuiltinVariableDeclaration();
			case MscriptPackage.INVALID_DATA_TYPE: return createInvalidDataType();
			case MscriptPackage.ANY_DATA_TYPE: return createAnyDataType();
			case MscriptPackage.UNIT_TYPE: return createUnitType();
			case MscriptPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case MscriptPackage.NUMERIC_TYPE: return createNumericType();
			case MscriptPackage.REAL_TYPE: return createRealType();
			case MscriptPackage.INTEGER_TYPE: return createIntegerType();
			case MscriptPackage.COMPLEX_TYPE: return createComplexType();
			case MscriptPackage.GAUSSIAN_TYPE: return createGaussianType();
			case MscriptPackage.BOOLEAN_TYPE: return createBooleanType();
			case MscriptPackage.STRING_TYPE: return createStringType();
			case MscriptPackage.ARRAY_TYPE: return createArrayType();
			case MscriptPackage.ARRAY_DIMENSION: return createArrayDimension();
			case MscriptPackage.STRUCT_TYPE: return createStructType();
			case MscriptPackage.STRUCT_MEMBER: return createStructMember();
			case MscriptPackage.EXPRESSION: return createExpression();
			case MscriptPackage.UNIT: return createUnit();
			case MscriptPackage.UNIT_NUMERATOR: return createUnitNumerator();
			case MscriptPackage.UNIT_DENOMINATOR: return createUnitDenominator();
			case MscriptPackage.UNIT_FACTOR: return createUnitFactor();
			case MscriptPackage.LITERAL: return createLiteral();
			case MscriptPackage.NUMERIC_LITERAL: return createNumericLiteral();
			case MscriptPackage.REAL_LITERAL: return createRealLiteral();
			case MscriptPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case MscriptPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case MscriptPackage.STRING_LITERAL: return createStringLiteral();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MscriptPackage.FUNCTION_KIND:
				return createFunctionKindFromString(eDataType, initialValue);
			case MscriptPackage.ASSERTION_STATUS_KIND:
				return createAssertionStatusKindFromString(eDataType, initialValue);
			case MscriptPackage.EQUALITY_OPERATOR:
				return createEqualityOperatorFromString(eDataType, initialValue);
			case MscriptPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case MscriptPackage.ADDITIVE_OPERATOR:
				return createAdditiveOperatorFromString(eDataType, initialValue);
			case MscriptPackage.MULTIPLICATIVE_OPERATOR:
				return createMultiplicativeOperatorFromString(eDataType, initialValue);
			case MscriptPackage.POWER_OPERATOR:
				return createPowerOperatorFromString(eDataType, initialValue);
			case MscriptPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			case MscriptPackage.POSTFIX_OPERATOR:
				return createPostfixOperatorFromString(eDataType, initialValue);
			case MscriptPackage.OPERATOR_KIND:
				return createOperatorKindFromString(eDataType, initialValue);
			case MscriptPackage.REAL_DATA:
				return createRealDataFromString(eDataType, initialValue);
			case MscriptPackage.INTEGER_DATA:
				return createIntegerDataFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MscriptPackage.FUNCTION_KIND:
				return convertFunctionKindToString(eDataType, instanceValue);
			case MscriptPackage.ASSERTION_STATUS_KIND:
				return convertAssertionStatusKindToString(eDataType, instanceValue);
			case MscriptPackage.EQUALITY_OPERATOR:
				return convertEqualityOperatorToString(eDataType, instanceValue);
			case MscriptPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case MscriptPackage.ADDITIVE_OPERATOR:
				return convertAdditiveOperatorToString(eDataType, instanceValue);
			case MscriptPackage.MULTIPLICATIVE_OPERATOR:
				return convertMultiplicativeOperatorToString(eDataType, instanceValue);
			case MscriptPackage.POWER_OPERATOR:
				return convertPowerOperatorToString(eDataType, instanceValue);
			case MscriptPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			case MscriptPackage.POSTFIX_OPERATOR:
				return convertPostfixOperatorToString(eDataType, instanceValue);
			case MscriptPackage.OPERATOR_KIND:
				return convertOperatorKindToString(eDataType, instanceValue);
			case MscriptPackage.REAL_DATA:
				return convertRealDataToString(eDataType, instanceValue);
			case MscriptPackage.INTEGER_DATA:
				return convertIntegerDataToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImportDeclaration createImportDeclaration() {
		ImportDeclarationImpl importDeclaration = new ImportDeclarationImpl();
		return importDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeDeclaration createDataTypeDeclaration() {
		DataTypeDeclarationImpl dataTypeDeclaration = new DataTypeDeclarationImpl();
		return dataTypeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationDeclaration createEnumerationDeclaration() {
		EnumerationDeclarationImpl enumerationDeclaration = new EnumerationDeclarationImpl();
		return enumerationDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralDeclaration createEnumerationLiteralDeclaration() {
		EnumerationLiteralDeclarationImpl enumerationLiteralDeclaration = new EnumerationLiteralDeclarationImpl();
		return enumerationLiteralDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructDeclaration createStructDeclaration() {
		StructDeclarationImpl structDeclaration = new StructDeclarationImpl();
		return structDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDeclaration createFunctionDeclaration() {
		FunctionDeclarationImpl functionDeclaration = new FunctionDeclarationImpl();
		return functionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Check createCheck() {
		CheckImpl check = new CheckImpl();
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateParameterDeclaration createTemplateParameterDeclaration() {
		TemplateParameterDeclarationImpl templateParameterDeclaration = new TemplateParameterDeclarationImpl();
		return templateParameterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputParameterDeclaration createInputParameterDeclaration() {
		InputParameterDeclarationImpl inputParameterDeclaration = new InputParameterDeclarationImpl();
		return inputParameterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputParameterDeclaration createOutputParameterDeclaration() {
		OutputParameterDeclarationImpl outputParameterDeclaration = new OutputParameterDeclarationImpl();
		return outputParameterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assertion createAssertion() {
		AssertionImpl assertion = new AssertionImpl();
		return assertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariableDeclaration createStateVariableDeclaration() {
		StateVariableDeclarationImpl stateVariableDeclaration = new StateVariableDeclarationImpl();
		return stateVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantDeclaration createConstantDeclaration() {
		ConstantDeclarationImpl constantDeclaration = new ConstantDeclarationImpl();
		return constantDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionAliasDeclaration createFunctionAliasDeclaration() {
		FunctionAliasDeclarationImpl functionAliasDeclaration = new FunctionAliasDeclarationImpl();
		return functionAliasDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equation createEquation() {
		EquationImpl equation = new EquationImpl();
		return equation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnonymousTypeSpecifier createAnonymousTypeSpecifier() {
		AnonymousTypeSpecifierImpl anonymousTypeSpecifier = new AnonymousTypeSpecifierImpl();
		return anonymousTypeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclaredTypeSpecifier createDeclaredTypeSpecifier() {
		DeclaredTypeSpecifierImpl declaredTypeSpecifier = new DeclaredTypeSpecifierImpl();
		return declaredTypeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpression createLetExpression() {
		LetExpressionImpl letExpression = new LetExpressionImpl();
		return letExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpressionAssignment createLetExpressionAssignment() {
		LetExpressionAssignmentImpl letExpressionAssignment = new LetExpressionAssignmentImpl();
		return letExpressionAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpressionVariableDeclaration createLetExpressionVariableDeclaration() {
		LetExpressionVariableDeclarationImpl letExpressionVariableDeclaration = new LetExpressionVariableDeclarationImpl();
		return letExpressionVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpression createIfExpression() {
		IfExpressionImpl ifExpression = new IfExpressionImpl();
		return ifExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchExpression createSwitchExpression() {
		SwitchExpressionImpl switchExpression = new SwitchExpressionImpl();
		return switchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCase createSwitchCase() {
		SwitchCaseImpl switchCase = new SwitchCaseImpl();
		return switchCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayElementAccess createArrayElementAccess() {
		ArrayElementAccessImpl arrayElementAccess = new ArrayElementAccessImpl();
		return arrayElementAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArraySubscript createArraySubscript() {
		ArraySubscriptImpl arraySubscript = new ArraySubscriptImpl();
		return arraySubscript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationCall createIterationCall() {
		IterationCallImpl iterationCall = new IterationCallImpl();
		return iterationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationVariableDeclaration createIterationVariableDeclaration() {
		IterationVariableDeclarationImpl iterationVariableDeclaration = new IterationVariableDeclarationImpl();
		return iterationVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationAccumulator createIterationAccumulator() {
		IterationAccumulatorImpl iterationAccumulator = new IterationAccumulatorImpl();
		return iterationAccumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayConstructionOperator createArrayConstructionOperator() {
		ArrayConstructionOperatorImpl arrayConstructionOperator = new ArrayConstructionOperatorImpl();
		return arrayConstructionOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayConstructionIterationClause createArrayConstructionIterationClause() {
		ArrayConstructionIterationClauseImpl arrayConstructionIterationClause = new ArrayConstructionIterationClauseImpl();
		return arrayConstructionIterationClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayConcatenationOperator createArrayConcatenationOperator() {
		ArrayConcatenationOperatorImpl arrayConcatenationOperator = new ArrayConcatenationOperatorImpl();
		return arrayConcatenationOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionList createExpressionList() {
		ExpressionListImpl expressionList = new ExpressionListImpl();
		return expressionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructConstructionOperator createStructConstructionOperator() {
		StructConstructionOperatorImpl structConstructionOperator = new StructConstructionOperatorImpl();
		return structConstructionOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructConstructionMember createStructConstructionMember() {
		StructConstructionMemberImpl structConstructionMember = new StructConstructionMemberImpl();
		return structConstructionMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitConstructionOperator createUnitConstructionOperator() {
		UnitConstructionOperatorImpl unitConstructionOperator = new UnitConstructionOperatorImpl();
		return unitConstructionOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParenthesizedExpression createParenthesizedExpression() {
		ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
		return parenthesizedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndExpression createEndExpression() {
		EndExpressionImpl endExpression = new EndExpressionImpl();
		return endExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeExpression createRangeExpression() {
		RangeExpressionImpl rangeExpression = new RangeExpressionImpl();
		return rangeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpliesExpression createImpliesExpression() {
		ImpliesExpressionImpl impliesExpression = new ImpliesExpressionImpl();
		return impliesExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOrExpression createLogicalOrExpression() {
		LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
		return logicalOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalAndExpression createLogicalAndExpression() {
		LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
		return logicalAndExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityExpression createEqualityExpression() {
		EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
		return equalityExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpression createRelationalExpression() {
		RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
		return relationalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeTestExpression createTypeTestExpression() {
		TypeTestExpressionImpl typeTestExpression = new TypeTestExpressionImpl();
		return typeTestExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveExpression createAdditiveExpression() {
		AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
		return additiveExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeExpression createMultiplicativeExpression() {
		MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
		return multiplicativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerExpression createPowerExpression() {
		PowerExpressionImpl powerExpression = new PowerExpressionImpl();
		return powerExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpression createPostfixExpression() {
		PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
		return postfixExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableReference createVariableReference() {
		VariableReferenceImpl variableReference = new VariableReferenceImpl();
		return variableReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeStepExpression createRangeStepExpression() {
		RangeStepExpressionImpl rangeStepExpression = new RangeStepExpressionImpl();
		return rangeStepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveStepExpression createAdditiveStepExpression() {
		AdditiveStepExpressionImpl additiveStepExpression = new AdditiveStepExpressionImpl();
		return additiveStepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegateStepExpression createNegateStepExpression() {
		NegateStepExpressionImpl negateStepExpression = new NegateStepExpressionImpl();
		return negateStepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepLiteral createStepLiteral() {
		StepLiteralImpl stepLiteral = new StepLiteralImpl();
		return stepLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepN createStepN() {
		StepNImpl stepN = new StepNImpl();
		return stepN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCall createFunctionCall() {
		FunctionCallImpl functionCall = new FunctionCallImpl();
		return functionCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberVariableAccess createMemberVariableAccess() {
		MemberVariableAccessImpl memberVariableAccess = new MemberVariableAccessImpl();
		return memberVariableAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlgorithmExpression createAlgorithmExpression() {
		AlgorithmExpressionImpl algorithmExpression = new AlgorithmExpressionImpl();
		return algorithmExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidExpression createInvalidExpression() {
		InvalidExpressionImpl invalidExpression = new InvalidExpressionImpl();
		return invalidExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Compound createCompound() {
		CompoundImpl compound = new CompoundImpl();
		return compound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariableDeclaration createLocalVariableDeclaration() {
		LocalVariableDeclarationImpl localVariableDeclaration = new LocalVariableDeclarationImpl();
		return localVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileStatement createWhileStatement() {
		WhileStatementImpl whileStatement = new WhileStatementImpl();
		return whileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoWhileStatement createDoWhileStatement() {
		DoWhileStatementImpl doWhileStatement = new DoWhileStatementImpl();
		return doWhileStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinueStatement createContinueStatement() {
		ContinueStatementImpl continueStatement = new ContinueStatementImpl();
		return continueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BreakStatement createBreakStatement() {
		BreakStatementImpl breakStatement = new BreakStatementImpl();
		return breakStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReturnStatement createReturnStatement() {
		ReturnStatementImpl returnStatement = new ReturnStatementImpl();
		return returnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinDeclaration createBuiltinDeclaration() {
		BuiltinDeclarationImpl builtinDeclaration = new BuiltinDeclarationImpl();
		return builtinDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinFunctionDeclaration createBuiltinFunctionDeclaration() {
		BuiltinFunctionDeclarationImpl builtinFunctionDeclaration = new BuiltinFunctionDeclarationImpl();
		return builtinFunctionDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinVariableDeclaration createBuiltinVariableDeclaration() {
		BuiltinVariableDeclarationImpl builtinVariableDeclaration = new BuiltinVariableDeclarationImpl();
		return builtinVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvalidDataType createInvalidDataType() {
		InvalidDataTypeImpl invalidDataType = new InvalidDataTypeImpl();
		return invalidDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnyDataType createAnyDataType() {
		AnyDataTypeImpl anyDataType = new AnyDataTypeImpl();
		return anyDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitType createUnitType() {
		UnitTypeImpl unitType = new UnitTypeImpl();
		return unitType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType() {
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericType createNumericType() {
		NumericTypeImpl numericType = new NumericTypeImpl();
		return numericType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealType createRealType() {
		RealTypeImpl realType = new RealTypeImpl();
		return realType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType createIntegerType() {
		IntegerTypeImpl integerType = new IntegerTypeImpl();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexType createComplexType() {
		ComplexTypeImpl complexType = new ComplexTypeImpl();
		return complexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GaussianType createGaussianType() {
		GaussianTypeImpl gaussianType = new GaussianTypeImpl();
		return gaussianType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayType createArrayType() {
		ArrayTypeImpl arrayType = new ArrayTypeImpl();
		return arrayType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayDimension createArrayDimension() {
		ArrayDimensionImpl arrayDimension = new ArrayDimensionImpl();
		return arrayDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructType createStructType() {
		StructTypeImpl structType = new StructTypeImpl();
		return structType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StructMember createStructMember() {
		StructMemberImpl structMember = new StructMemberImpl();
		return structMember;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createUnit() {
		UnitImpl unit = new UnitImpl();
		return unit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitNumerator createUnitNumerator() {
		UnitNumeratorImpl unitNumerator = new UnitNumeratorImpl();
		return unitNumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitDenominator createUnitDenominator() {
		UnitDenominatorImpl unitDenominator = new UnitDenominatorImpl();
		return unitDenominator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitFactor createUnitFactor() {
		UnitFactorImpl unitFactor = new UnitFactorImpl();
		return unitFactor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Literal createLiteral() {
		LiteralImpl literal = new LiteralImpl();
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumericLiteral createNumericLiteral() {
		NumericLiteralImpl numericLiteral = new NumericLiteralImpl();
		return numericLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealLiteral createRealLiteral() {
		RealLiteralImpl realLiteral = new RealLiteralImpl();
		return realLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionKind createFunctionKindFromString(EDataType eDataType, String initialValue) {
		FunctionKind result = FunctionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFunctionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertionStatusKind createAssertionStatusKindFromString(EDataType eDataType, String initialValue) {
		AssertionStatusKind result = AssertionStatusKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssertionStatusKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue) {
		EqualityOperator result = EqualityOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue) {
		RelationalOperator result = RelationalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue) {
		AdditiveOperator result = AdditiveOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue) {
		MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerOperator createPowerOperatorFromString(EDataType eDataType, String initialValue) {
		PowerOperator result = PowerOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryOperator result = UnaryOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixOperator createPostfixOperatorFromString(EDataType eDataType, String initialValue) {
		PostfixOperator result = PostfixOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPostfixOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorKind createOperatorKindFromString(EDataType eDataType, String initialValue) {
		OperatorKind result = OperatorKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealData createRealDataFromString(EDataType eDataType, String initialValue) {
		return (RealData)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRealDataToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerData createIntegerDataFromString(EDataType eDataType, String initialValue) {
		return (IntegerData)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegerDataToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MscriptPackage getMscriptPackage() {
		return (MscriptPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MscriptPackage getPackage() {
		return MscriptPackage.eINSTANCE;
	}

} //MscriptFactoryImpl
