/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.mscript.MscriptPackage
 * @generated
 */
public interface MscriptFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MscriptFactory eINSTANCE = org.eclipselabs.damos.mscript.impl.MscriptFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	Module createModule();

	/**
	 * Returns a new object of class '<em>Import Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Declaration</em>'.
	 * @generated
	 */
	ImportDeclaration createImportDeclaration();

	/**
	 * Returns a new object of class '<em>Data Type Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Declaration</em>'.
	 * @generated
	 */
	DataTypeDeclaration createDataTypeDeclaration();

	/**
	 * Returns a new object of class '<em>Enumeration Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Declaration</em>'.
	 * @generated
	 */
	EnumerationDeclaration createEnumerationDeclaration();

	/**
	 * Returns a new object of class '<em>Enumeration Literal Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal Declaration</em>'.
	 * @generated
	 */
	EnumerationLiteralDeclaration createEnumerationLiteralDeclaration();

	/**
	 * Returns a new object of class '<em>Struct Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Struct Declaration</em>'.
	 * @generated
	 */
	StructDeclaration createStructDeclaration();

	/**
	 * Returns a new object of class '<em>Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Declaration</em>'.
	 * @generated
	 */
	FunctionDeclaration createFunctionDeclaration();

	/**
	 * Returns a new object of class '<em>Check</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check</em>'.
	 * @generated
	 */
	Check createCheck();

	/**
	 * Returns a new object of class '<em>Static Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Static Parameter Declaration</em>'.
	 * @generated
	 */
	StaticParameterDeclaration createStaticParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Input Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Parameter Declaration</em>'.
	 * @generated
	 */
	InputParameterDeclaration createInputParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Output Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Parameter Declaration</em>'.
	 * @generated
	 */
	OutputParameterDeclaration createOutputParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assertion</em>'.
	 * @generated
	 */
	Assertion createAssertion();

	/**
	 * Returns a new object of class '<em>State Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Variable Declaration</em>'.
	 * @generated
	 */
	StateVariableDeclaration createStateVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Constant Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Declaration</em>'.
	 * @generated
	 */
	ConstantDeclaration createConstantDeclaration();

	/**
	 * Returns a new object of class '<em>Function Alias Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Alias Declaration</em>'.
	 * @generated
	 */
	FunctionAliasDeclaration createFunctionAliasDeclaration();

	/**
	 * Returns a new object of class '<em>Equation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation</em>'.
	 * @generated
	 */
	Equation createEquation();

	/**
	 * Returns a new object of class '<em>Anonymous Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Anonymous Type Specifier</em>'.
	 * @generated
	 */
	AnonymousTypeSpecifier createAnonymousTypeSpecifier();

	/**
	 * Returns a new object of class '<em>Declared Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Declared Type Specifier</em>'.
	 * @generated
	 */
	DeclaredTypeSpecifier createDeclaredTypeSpecifier();

	/**
	 * Returns a new object of class '<em>Let Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression</em>'.
	 * @generated
	 */
	LetExpression createLetExpression();

	/**
	 * Returns a new object of class '<em>Let Expression Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression Assignment</em>'.
	 * @generated
	 */
	LetExpressionAssignment createLetExpressionAssignment();

	/**
	 * Returns a new object of class '<em>Let Expression Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression Variable Declaration</em>'.
	 * @generated
	 */
	LetExpressionVariableDeclaration createLetExpressionVariableDeclaration();

	/**
	 * Returns a new object of class '<em>If Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Expression</em>'.
	 * @generated
	 */
	IfExpression createIfExpression();

	/**
	 * Returns a new object of class '<em>Switch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Expression</em>'.
	 * @generated
	 */
	SwitchExpression createSwitchExpression();

	/**
	 * Returns a new object of class '<em>Switch Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case</em>'.
	 * @generated
	 */
	SwitchCase createSwitchCase();

	/**
	 * Returns a new object of class '<em>Array Element Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Element Access</em>'.
	 * @generated
	 */
	ArrayElementAccess createArrayElementAccess();

	/**
	 * Returns a new object of class '<em>Array Subscript</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Subscript</em>'.
	 * @generated
	 */
	ArraySubscript createArraySubscript();

	/**
	 * Returns a new object of class '<em>Iteration Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Call</em>'.
	 * @generated
	 */
	IterationCall createIterationCall();

	/**
	 * Returns a new object of class '<em>Iteration Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Variable Declaration</em>'.
	 * @generated
	 */
	IterationVariableDeclaration createIterationVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Iteration Accumulator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Accumulator</em>'.
	 * @generated
	 */
	IterationAccumulator createIterationAccumulator();

	/**
	 * Returns a new object of class '<em>Array Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Construction Operator</em>'.
	 * @generated
	 */
	ArrayConstructionOperator createArrayConstructionOperator();

	/**
	 * Returns a new object of class '<em>Array Construction Iteration Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Construction Iteration Clause</em>'.
	 * @generated
	 */
	ArrayConstructionIterationClause createArrayConstructionIterationClause();

	/**
	 * Returns a new object of class '<em>Array Concatenation Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Concatenation Operator</em>'.
	 * @generated
	 */
	ArrayConcatenationOperator createArrayConcatenationOperator();

	/**
	 * Returns a new object of class '<em>Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression List</em>'.
	 * @generated
	 */
	ExpressionList createExpressionList();

	/**
	 * Returns a new object of class '<em>Struct Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Struct Construction Operator</em>'.
	 * @generated
	 */
	StructConstructionOperator createStructConstructionOperator();

	/**
	 * Returns a new object of class '<em>Struct Construction Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Struct Construction Member</em>'.
	 * @generated
	 */
	StructConstructionMember createStructConstructionMember();

	/**
	 * Returns a new object of class '<em>Unit Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Construction Operator</em>'.
	 * @generated
	 */
	UnitConstructionOperator createUnitConstructionOperator();

	/**
	 * Returns a new object of class '<em>Parenthesized Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parenthesized Expression</em>'.
	 * @generated
	 */
	ParenthesizedExpression createParenthesizedExpression();

	/**
	 * Returns a new object of class '<em>End Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Expression</em>'.
	 * @generated
	 */
	EndExpression createEndExpression();

	/**
	 * Returns a new object of class '<em>Range Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Expression</em>'.
	 * @generated
	 */
	RangeExpression createRangeExpression();

	/**
	 * Returns a new object of class '<em>Implies Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implies Expression</em>'.
	 * @generated
	 */
	ImpliesExpression createImpliesExpression();

	/**
	 * Returns a new object of class '<em>Logical Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Or Expression</em>'.
	 * @generated
	 */
	LogicalOrExpression createLogicalOrExpression();

	/**
	 * Returns a new object of class '<em>Logical And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical And Expression</em>'.
	 * @generated
	 */
	LogicalAndExpression createLogicalAndExpression();

	/**
	 * Returns a new object of class '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Expression</em>'.
	 * @generated
	 */
	EqualityExpression createEqualityExpression();

	/**
	 * Returns a new object of class '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Expression</em>'.
	 * @generated
	 */
	RelationalExpression createRelationalExpression();

	/**
	 * Returns a new object of class '<em>Type Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Test Expression</em>'.
	 * @generated
	 */
	TypeTestExpression createTypeTestExpression();

	/**
	 * Returns a new object of class '<em>Additive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Expression</em>'.
	 * @generated
	 */
	AdditiveExpression createAdditiveExpression();

	/**
	 * Returns a new object of class '<em>Multiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicative Expression</em>'.
	 * @generated
	 */
	MultiplicativeExpression createMultiplicativeExpression();

	/**
	 * Returns a new object of class '<em>Power Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Expression</em>'.
	 * @generated
	 */
	PowerExpression createPowerExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Postfix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postfix Expression</em>'.
	 * @generated
	 */
	PostfixExpression createPostfixExpression();

	/**
	 * Returns a new object of class '<em>Variable Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Reference</em>'.
	 * @generated
	 */
	VariableReference createVariableReference();

	/**
	 * Returns a new object of class '<em>Range Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Step Expression</em>'.
	 * @generated
	 */
	RangeStepExpression createRangeStepExpression();

	/**
	 * Returns a new object of class '<em>Additive Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Step Expression</em>'.
	 * @generated
	 */
	AdditiveStepExpression createAdditiveStepExpression();

	/**
	 * Returns a new object of class '<em>Negate Step Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Negate Step Expression</em>'.
	 * @generated
	 */
	NegateStepExpression createNegateStepExpression();

	/**
	 * Returns a new object of class '<em>Step Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step Literal</em>'.
	 * @generated
	 */
	StepLiteral createStepLiteral();

	/**
	 * Returns a new object of class '<em>Step N</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Step N</em>'.
	 * @generated
	 */
	StepN createStepN();

	/**
	 * Returns a new object of class '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Call</em>'.
	 * @generated
	 */
	FunctionCall createFunctionCall();

	/**
	 * Returns a new object of class '<em>Member Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member Variable Access</em>'.
	 * @generated
	 */
	MemberVariableAccess createMemberVariableAccess();

	/**
	 * Returns a new object of class '<em>Algorithm Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Algorithm Expression</em>'.
	 * @generated
	 */
	AlgorithmExpression createAlgorithmExpression();

	/**
	 * Returns a new object of class '<em>Invalid Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Expression</em>'.
	 * @generated
	 */
	InvalidExpression createInvalidExpression();

	/**
	 * Returns a new object of class '<em>Compound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Compound</em>'.
	 * @generated
	 */
	Compound createCompound();

	/**
	 * Returns a new object of class '<em>Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment</em>'.
	 * @generated
	 */
	Assignment createAssignment();

	/**
	 * Returns a new object of class '<em>Local Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Variable Declaration</em>'.
	 * @generated
	 */
	LocalVariableDeclaration createLocalVariableDeclaration();

	/**
	 * Returns a new object of class '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Statement</em>'.
	 * @generated
	 */
	IfStatement createIfStatement();

	/**
	 * Returns a new object of class '<em>While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Statement</em>'.
	 * @generated
	 */
	WhileStatement createWhileStatement();

	/**
	 * Returns a new object of class '<em>Do While Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Do While Statement</em>'.
	 * @generated
	 */
	DoWhileStatement createDoWhileStatement();

	/**
	 * Returns a new object of class '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Statement</em>'.
	 * @generated
	 */
	ForStatement createForStatement();

	/**
	 * Returns a new object of class '<em>Continue Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continue Statement</em>'.
	 * @generated
	 */
	ContinueStatement createContinueStatement();

	/**
	 * Returns a new object of class '<em>Break Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Break Statement</em>'.
	 * @generated
	 */
	BreakStatement createBreakStatement();

	/**
	 * Returns a new object of class '<em>Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Return Statement</em>'.
	 * @generated
	 */
	ReturnStatement createReturnStatement();

	/**
	 * Returns a new object of class '<em>Builtin Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Declaration</em>'.
	 * @generated
	 */
	BuiltinDeclaration createBuiltinDeclaration();

	/**
	 * Returns a new object of class '<em>Builtin Function Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Function Declaration</em>'.
	 * @generated
	 */
	BuiltinFunctionDeclaration createBuiltinFunctionDeclaration();

	/**
	 * Returns a new object of class '<em>Builtin Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Variable Declaration</em>'.
	 * @generated
	 */
	BuiltinVariableDeclaration createBuiltinVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Invalid Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invalid Data Type</em>'.
	 * @generated
	 */
	InvalidDataType createInvalidDataType();

	/**
	 * Returns a new object of class '<em>Any Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Any Data Type</em>'.
	 * @generated
	 */
	AnyDataType createAnyDataType();

	/**
	 * Returns a new object of class '<em>Unit Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Type</em>'.
	 * @generated
	 */
	UnitType createUnitType();

	/**
	 * Returns a new object of class '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Type</em>'.
	 * @generated
	 */
	PrimitiveType createPrimitiveType();

	/**
	 * Returns a new object of class '<em>Numeric Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Type</em>'.
	 * @generated
	 */
	NumericType createNumericType();

	/**
	 * Returns a new object of class '<em>Real Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Type</em>'.
	 * @generated
	 */
	RealType createRealType();

	/**
	 * Returns a new object of class '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Type</em>'.
	 * @generated
	 */
	IntegerType createIntegerType();

	/**
	 * Returns a new object of class '<em>Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Type</em>'.
	 * @generated
	 */
	ComplexType createComplexType();

	/**
	 * Returns a new object of class '<em>Gaussian Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Gaussian Type</em>'.
	 * @generated
	 */
	GaussianType createGaussianType();

	/**
	 * Returns a new object of class '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Type</em>'.
	 * @generated
	 */
	BooleanType createBooleanType();

	/**
	 * Returns a new object of class '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Type</em>'.
	 * @generated
	 */
	StringType createStringType();

	/**
	 * Returns a new object of class '<em>Array Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Type</em>'.
	 * @generated
	 */
	ArrayType createArrayType();

	/**
	 * Returns a new object of class '<em>Array Dimension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Dimension</em>'.
	 * @generated
	 */
	ArrayDimension createArrayDimension();

	/**
	 * Returns a new object of class '<em>Struct Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Struct Type</em>'.
	 * @generated
	 */
	StructType createStructType();

	/**
	 * Returns a new object of class '<em>Struct Member</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Struct Member</em>'.
	 * @generated
	 */
	StructMember createStructMember();

	/**
	 * Returns a new object of class '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression</em>'.
	 * @generated
	 */
	Expression createExpression();

	/**
	 * Returns a new object of class '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit</em>'.
	 * @generated
	 */
	Unit createUnit();

	/**
	 * Returns a new object of class '<em>Unit Numerator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Numerator</em>'.
	 * @generated
	 */
	UnitNumerator createUnitNumerator();

	/**
	 * Returns a new object of class '<em>Unit Denominator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Denominator</em>'.
	 * @generated
	 */
	UnitDenominator createUnitDenominator();

	/**
	 * Returns a new object of class '<em>Unit Factor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Factor</em>'.
	 * @generated
	 */
	UnitFactor createUnitFactor();

	/**
	 * Returns a new object of class '<em>Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Literal</em>'.
	 * @generated
	 */
	Literal createLiteral();

	/**
	 * Returns a new object of class '<em>Numeric Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Numeric Literal</em>'.
	 * @generated
	 */
	NumericLiteral createNumericLiteral();

	/**
	 * Returns a new object of class '<em>Real Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Real Literal</em>'.
	 * @generated
	 */
	RealLiteral createRealLiteral();

	/**
	 * Returns a new object of class '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal</em>'.
	 * @generated
	 */
	IntegerLiteral createIntegerLiteral();

	/**
	 * Returns a new object of class '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal</em>'.
	 * @generated
	 */
	BooleanLiteral createBooleanLiteral();

	/**
	 * Returns a new object of class '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal</em>'.
	 * @generated
	 */
	StringLiteral createStringLiteral();

	/**
	 * Returns a new object of class '<em>Template Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template Expression</em>'.
	 * @generated
	 */
	TemplateExpression createTemplateExpression();

	/**
	 * Returns a new object of class '<em>Constant Template Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Constant Template Segment</em>'.
	 * @generated
	 */
	ConstantTemplateSegment createConstantTemplateSegment();

	/**
	 * Returns a new object of class '<em>Expression Template Segment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Template Segment</em>'.
	 * @generated
	 */
	ExpressionTemplateSegment createExpressionTemplateSegment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MscriptPackage getMscriptPackage();

} //MscriptFactory
