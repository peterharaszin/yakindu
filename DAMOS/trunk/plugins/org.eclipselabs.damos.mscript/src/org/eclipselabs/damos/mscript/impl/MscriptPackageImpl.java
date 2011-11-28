/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.mscript.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.mscript.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MscriptPackageImpl extends EPackageImpl implements MscriptPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedefDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structMemberDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputParameterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputParameterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assertionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionObjectDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letExpressionAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass letExpressionVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayElementAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arraySubscriptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iterationAccumulatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayConstructionOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayConstructionIterationClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayConcatenationOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitConstructionOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parenthesizedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass impliesExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalOrExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass logicalAndExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalityExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeTestExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additiveExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass powerExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postfixExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeStepExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additiveStepExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass negateStepExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveStepExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stepNEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberVariableAccessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass algorithmExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doWhileStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continueStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass breakStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass returnStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builtinDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builtinFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builtinVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anyDataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass gaussianTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tensorTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arrayDimensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitProductEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitNumeratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitDenominatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass literalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass realLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum functionKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum assertionStatusKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum equalityOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum additiveOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplicativeOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum powerOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum postfixOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatorKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType realDataEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType integerDataEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipselabs.damos.mscript.MscriptPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MscriptPackageImpl() {
		super(eNS_URI, MscriptFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MscriptPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MscriptPackage init() {
		if (isInited) return (MscriptPackage)EPackage.Registry.INSTANCE.getEPackage(MscriptPackage.eNS_URI);

		// Obtain or create and register package
		MscriptPackageImpl theMscriptPackage = (MscriptPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MscriptPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MscriptPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMscriptPackage.createPackageContents();

		// Initialize created meta-data
		theMscriptPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMscriptPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MscriptPackage.eNS_URI, theMscriptPackage);
		return theMscriptPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModule() {
		return moduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_Definitions() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinition() {
		return definitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinition_Name() {
		return (EAttribute)definitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeDefinition() {
		return dataTypeDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationDefinition() {
		return enumerationDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationDefinition_LiteralDeclarations() {
		return (EReference)enumerationDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteralDeclaration() {
		return enumerationLiteralDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationLiteralDeclaration_Name() {
		return (EAttribute)enumerationLiteralDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedefDeclaration() {
		return typedefDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedefDeclaration_TypeSpecifier() {
		return (EReference)typedefDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructDefinition() {
		return structDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructDefinition_MemberDeclarations() {
		return (EReference)structDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructMemberDeclaration() {
		return structMemberDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructMemberDeclaration_Name() {
		return (EAttribute)structMemberDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructMemberDeclaration_TypeSpecifier() {
		return (EReference)structMemberDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionDefinition() {
		return functionDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionDefinition_Kind() {
		return (EAttribute)functionDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_TemplateParameterDeclarations() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_InputParameterDeclarations() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_OutputParameterDeclarations() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_Checks() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_Assertions() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_FunctionObjectDeclarations() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_StateVariableDeclarations() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_ConstantDeclarations() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDefinition_Equations() {
		return (EReference)functionDefinitionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheck() {
		return checkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheck_Function() {
		return (EReference)checkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheck_TemplateArguments() {
		return (EReference)checkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheck_InputParameterTypes() {
		return (EReference)checkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheck_OutputParameterTypes() {
		return (EReference)checkEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluable() {
		return evaluableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallableElement() {
		return callableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclaration() {
		return variableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableDeclaration_Name() {
		return (EAttribute)variableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDeclaration() {
		return parameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterDeclaration() {
		return templateParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputParameterDeclaration() {
		return inputParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputParameterDeclaration() {
		return outputParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssertion() {
		return assertionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertion_Static() {
		return (EAttribute)assertionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertion_Condition() {
		return (EReference)assertionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssertion_StatusKind() {
		return (EAttribute)assertionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssertion_Message() {
		return (EReference)assertionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateVariableDeclaration() {
		return stateVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantDeclaration() {
		return constantDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstantDeclaration_Name() {
		return (EAttribute)constantDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstantDeclaration_Initializer() {
		return (EReference)constantDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionObjectDeclaration() {
		return functionObjectDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionObjectDeclaration_Name() {
		return (EAttribute)functionObjectDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionObjectDeclaration_FunctionName() {
		return (EReference)functionObjectDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionObjectDeclaration_TemplateArguments() {
		return (EReference)functionObjectDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEquation() {
		return equationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEquation_Initial() {
		return (EAttribute)equationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquation_LeftHandSide() {
		return (EReference)equationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEquation_RightHandSide() {
		return (EReference)equationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeSpecifier() {
		return dataTypeSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeSpecifier_Type() {
		return (EReference)dataTypeSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeSpecifier_DefinedType() {
		return (EReference)dataTypeSpecifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLetExpression() {
		return letExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpression_Assignments() {
		return (EReference)letExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpression_Target() {
		return (EReference)letExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLetExpressionAssignment() {
		return letExpressionAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpressionAssignment_Variables() {
		return (EReference)letExpressionAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLetExpressionAssignment_AssignedExpression() {
		return (EReference)letExpressionAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLetExpressionVariableDeclaration() {
		return letExpressionVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfExpression() {
		return ifExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIfExpression_Static() {
		return (EAttribute)ifExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpression_Condition() {
		return (EReference)ifExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpression_ThenExpression() {
		return (EReference)ifExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfExpression_ElseExpression() {
		return (EReference)ifExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchExpression() {
		return switchExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSwitchExpression_Static() {
		return (EAttribute)switchExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExpression_ControlExpression() {
		return (EReference)switchExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExpression_Cases() {
		return (EReference)switchExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchExpression_DefaultExpression() {
		return (EReference)switchExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchCase() {
		return switchCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCase_CaseExpression() {
		return (EReference)switchCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCase_ResultExpression() {
		return (EReference)switchCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayElementAccess() {
		return arrayElementAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayElementAccess_Array() {
		return (EReference)arrayElementAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayElementAccess_Subscripts() {
		return (EReference)arrayElementAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArraySubscript() {
		return arraySubscriptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArraySubscript_Slice() {
		return (EAttribute)arraySubscriptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArraySubscript_Expression() {
		return (EReference)arraySubscriptEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterationCall() {
		return iterationCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationCall_Target() {
		return (EReference)iterationCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIterationCall_Identifier() {
		return (EAttribute)iterationCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationCall_IterationVariables() {
		return (EReference)iterationCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationCall_Accumulator() {
		return (EReference)iterationCallEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationCall_BreakCondition() {
		return (EReference)iterationCallEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationCall_Expression() {
		return (EReference)iterationCallEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterationVariableDeclaration() {
		return iterationVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIterationAccumulator() {
		return iterationAccumulatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIterationAccumulator_Initializer() {
		return (EReference)iterationAccumulatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayConstructionOperator() {
		return arrayConstructionOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayConstructionOperator_Expressions() {
		return (EReference)arrayConstructionOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayConstructionOperator_IterationClauses() {
		return (EReference)arrayConstructionOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayConstructionIterationClause() {
		return arrayConstructionIterationClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayConstructionIterationClause_VariableName() {
		return (EAttribute)arrayConstructionIterationClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayConstructionIterationClause_CollectionExpression() {
		return (EReference)arrayConstructionIterationClauseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayConcatenationOperator() {
		return arrayConcatenationOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayConcatenationOperator_Rows() {
		return (EReference)arrayConcatenationOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionList() {
		return expressionListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionList_Expressions() {
		return (EReference)expressionListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitConstructionOperator() {
		return unitConstructionOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitConstructionOperator_Unit() {
		return (EReference)unitConstructionOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParenthesizedExpression() {
		return parenthesizedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParenthesizedExpression_Expressions() {
		return (EReference)parenthesizedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndExpression() {
		return endExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeExpression() {
		return rangeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeExpression_Operands() {
		return (EReference)rangeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImpliesExpression() {
		return impliesExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpliesExpression_LeftOperand() {
		return (EReference)impliesExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImpliesExpression_RightOperand() {
		return (EReference)impliesExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalOrExpression() {
		return logicalOrExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalOrExpression_LeftOperand() {
		return (EReference)logicalOrExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalOrExpression_RightOperand() {
		return (EReference)logicalOrExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLogicalAndExpression() {
		return logicalAndExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalAndExpression_LeftOperand() {
		return (EReference)logicalAndExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLogicalAndExpression_RightOperand() {
		return (EReference)logicalAndExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualityExpression() {
		return equalityExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEqualityExpression_LeftOperand() {
		return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEqualityExpression_Operator() {
		return (EAttribute)equalityExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEqualityExpression_RightOperand() {
		return (EReference)equalityExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalExpression() {
		return relationalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpression_LeftOperand() {
		return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationalExpression_Operator() {
		return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpression_RightOperand() {
		return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeTestExpression() {
		return typeTestExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeTestExpression_Expression() {
		return (EReference)typeTestExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeTestExpression_TypeSpecifier() {
		return (EReference)typeTestExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditiveExpression() {
		return additiveExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdditiveExpression_Operator() {
		return (EAttribute)additiveExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditiveExpression_LeftOperand() {
		return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditiveExpression_RightOperand() {
		return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicativeExpression() {
		return multiplicativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicativeExpression_Operator() {
		return (EAttribute)multiplicativeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicativeExpression_LeftOperand() {
		return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicativeExpression_RightOperand() {
		return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPowerExpression() {
		return powerExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerExpression_Operand() {
		return (EReference)powerExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPowerExpression_Operator() {
		return (EAttribute)powerExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPowerExpression_Exponent() {
		return (EReference)powerExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnaryExpression_Operator() {
		return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryExpression_Operand() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostfixExpression() {
		return postfixExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPostfixExpression_Operand() {
		return (EReference)postfixExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPostfixExpression_Operator() {
		return (EAttribute)postfixExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureCall() {
		return featureCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureCall_Feature() {
		return (EReference)featureCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableAccess() {
		return variableAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableAccess_StepExpression() {
		return (EReference)variableAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStepExpression() {
		return stepExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRangeStepExpression() {
		return rangeStepExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeStepExpression_Start() {
		return (EReference)rangeStepExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRangeStepExpression_End() {
		return (EReference)rangeStepExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditiveStepExpression() {
		return additiveStepExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdditiveStepExpression_Operator() {
		return (EAttribute)additiveStepExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditiveStepExpression_LeftOperand() {
		return (EReference)additiveStepExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditiveStepExpression_RightOperand() {
		return (EReference)additiveStepExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNegateStepExpression() {
		return negateStepExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNegateStepExpression_Operand() {
		return (EReference)negateStepExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveStepExpression() {
		return primitiveStepExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStepLiteral() {
		return stepLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStepLiteral_Value() {
		return (EAttribute)stepLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStepN() {
		return stepNEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionCall() {
		return functionCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionCall_Arguments() {
		return (EReference)functionCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemberVariableAccess() {
		return memberVariableAccessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemberVariableAccess_Target() {
		return (EReference)memberVariableAccessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMemberVariableAccess_MemberVariable() {
		return (EReference)memberVariableAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlgorithmExpression() {
		return algorithmExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlgorithmExpression_Body() {
		return (EReference)algorithmExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompound() {
		return compoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompound_Statements() {
		return (EReference)compoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssignment() {
		return assignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_Target() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssignment_AssignedExpression() {
		return (EReference)assignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalVariableDeclaration() {
		return localVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLocalVariableDeclaration_Initializer() {
		return (EReference)localVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfStatement() {
		return ifStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_Condition() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_ThenStatement() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfStatement_ElseStatement() {
		return (EReference)ifStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileStatement() {
		return whileStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileStatement_Condition() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileStatement_Body() {
		return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoWhileStatement() {
		return doWhileStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDoWhileStatement_Condition() {
		return (EReference)doWhileStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDoWhileStatement_Body() {
		return (EReference)doWhileStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForStatement() {
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_IterationVariable() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_CollectionExpression() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Condition() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Body() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinueStatement() {
		return continueStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBreakStatement() {
		return breakStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReturnStatement() {
		return returnStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReturnStatement_Expression() {
		return (EReference)returnStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuiltinDefinition() {
		return builtinDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuiltinFunction() {
		return builtinFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuiltinVariable() {
		return builtinVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidDataType() {
		return invalidDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnyDataType() {
		return anyDataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitType() {
		return unitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericType() {
		return numericTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericType_Unit() {
		return (EReference)numericTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealType() {
		return realTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerType() {
		return integerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexType() {
		return complexTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGaussianType() {
		return gaussianTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanType() {
		return booleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayType() {
		return arrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayType_ElementType() {
		return (EReference)arrayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayType_DefinedElementType() {
		return (EReference)arrayTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayType_Dimensions() {
		return (EReference)arrayTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_Dimensionality() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_Dimensional() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_Multidimensional() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTensorType() {
		return tensorTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTensorType_Vector() {
		return (EAttribute)tensorTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTensorType_Matrix() {
		return (EAttribute)tensorTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArrayDimension() {
		return arrayDimensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArrayDimension_Size() {
		return (EReference)arrayDimensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnit() {
		return unitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_Numerator() {
		return (EReference)unitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_Denominator() {
		return (EReference)unitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Scale() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Wildcard() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitProduct() {
		return unitProductEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitProduct_Factors() {
		return (EReference)unitProductEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitNumerator() {
		return unitNumeratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitDenominator() {
		return unitDenominatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitFactor() {
		return unitFactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitFactor_Symbol() {
		return (EAttribute)unitFactorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitFactor_Exponent() {
		return (EAttribute)unitFactorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiteral() {
		return literalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericLiteral() {
		return numericLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNumericLiteral_Unit() {
		return (EReference)numericLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRealLiteral() {
		return realLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRealLiteral_Data() {
		return (EAttribute)realLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRealLiteral_Value() {
		return (EAttribute)realLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Data() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteral_True() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteral_Value() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFunctionKind() {
		return functionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAssertionStatusKind() {
		return assertionStatusKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEqualityOperator() {
		return equalityOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationalOperator() {
		return relationalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAdditiveOperator() {
		return additiveOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiplicativeOperator() {
		return multiplicativeOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPowerOperator() {
		return powerOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryOperator() {
		return unaryOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPostfixOperator() {
		return postfixOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperatorKind() {
		return operatorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRealData() {
		return realDataEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIntegerData() {
		return integerDataEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MscriptFactory getMscriptFactory() {
		return (MscriptFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		moduleEClass = createEClass(MODULE);
		createEReference(moduleEClass, MODULE__DEFINITIONS);

		definitionEClass = createEClass(DEFINITION);
		createEAttribute(definitionEClass, DEFINITION__NAME);

		dataTypeDefinitionEClass = createEClass(DATA_TYPE_DEFINITION);

		enumerationDefinitionEClass = createEClass(ENUMERATION_DEFINITION);
		createEReference(enumerationDefinitionEClass, ENUMERATION_DEFINITION__LITERAL_DECLARATIONS);

		enumerationLiteralDeclarationEClass = createEClass(ENUMERATION_LITERAL_DECLARATION);
		createEAttribute(enumerationLiteralDeclarationEClass, ENUMERATION_LITERAL_DECLARATION__NAME);

		typedefDeclarationEClass = createEClass(TYPEDEF_DECLARATION);
		createEReference(typedefDeclarationEClass, TYPEDEF_DECLARATION__TYPE_SPECIFIER);

		structDefinitionEClass = createEClass(STRUCT_DEFINITION);
		createEReference(structDefinitionEClass, STRUCT_DEFINITION__MEMBER_DECLARATIONS);

		structMemberDeclarationEClass = createEClass(STRUCT_MEMBER_DECLARATION);
		createEAttribute(structMemberDeclarationEClass, STRUCT_MEMBER_DECLARATION__NAME);
		createEReference(structMemberDeclarationEClass, STRUCT_MEMBER_DECLARATION__TYPE_SPECIFIER);

		functionDefinitionEClass = createEClass(FUNCTION_DEFINITION);
		createEAttribute(functionDefinitionEClass, FUNCTION_DEFINITION__KIND);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__CHECKS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__ASSERTIONS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__CONSTANT_DECLARATIONS);
		createEReference(functionDefinitionEClass, FUNCTION_DEFINITION__EQUATIONS);

		checkEClass = createEClass(CHECK);
		createEReference(checkEClass, CHECK__FUNCTION);
		createEReference(checkEClass, CHECK__TEMPLATE_ARGUMENTS);
		createEReference(checkEClass, CHECK__INPUT_PARAMETER_TYPES);
		createEReference(checkEClass, CHECK__OUTPUT_PARAMETER_TYPES);

		evaluableEClass = createEClass(EVALUABLE);

		callableElementEClass = createEClass(CALLABLE_ELEMENT);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__NAME);

		parameterDeclarationEClass = createEClass(PARAMETER_DECLARATION);

		templateParameterDeclarationEClass = createEClass(TEMPLATE_PARAMETER_DECLARATION);

		inputParameterDeclarationEClass = createEClass(INPUT_PARAMETER_DECLARATION);

		outputParameterDeclarationEClass = createEClass(OUTPUT_PARAMETER_DECLARATION);

		assertionEClass = createEClass(ASSERTION);
		createEAttribute(assertionEClass, ASSERTION__STATIC);
		createEReference(assertionEClass, ASSERTION__CONDITION);
		createEAttribute(assertionEClass, ASSERTION__STATUS_KIND);
		createEReference(assertionEClass, ASSERTION__MESSAGE);

		stateVariableDeclarationEClass = createEClass(STATE_VARIABLE_DECLARATION);

		constantDeclarationEClass = createEClass(CONSTANT_DECLARATION);
		createEAttribute(constantDeclarationEClass, CONSTANT_DECLARATION__NAME);
		createEReference(constantDeclarationEClass, CONSTANT_DECLARATION__INITIALIZER);

		functionObjectDeclarationEClass = createEClass(FUNCTION_OBJECT_DECLARATION);
		createEAttribute(functionObjectDeclarationEClass, FUNCTION_OBJECT_DECLARATION__NAME);
		createEReference(functionObjectDeclarationEClass, FUNCTION_OBJECT_DECLARATION__FUNCTION_NAME);
		createEReference(functionObjectDeclarationEClass, FUNCTION_OBJECT_DECLARATION__TEMPLATE_ARGUMENTS);

		equationEClass = createEClass(EQUATION);
		createEAttribute(equationEClass, EQUATION__INITIAL);
		createEReference(equationEClass, EQUATION__LEFT_HAND_SIDE);
		createEReference(equationEClass, EQUATION__RIGHT_HAND_SIDE);

		dataTypeSpecifierEClass = createEClass(DATA_TYPE_SPECIFIER);
		createEReference(dataTypeSpecifierEClass, DATA_TYPE_SPECIFIER__TYPE);
		createEReference(dataTypeSpecifierEClass, DATA_TYPE_SPECIFIER__DEFINED_TYPE);

		letExpressionEClass = createEClass(LET_EXPRESSION);
		createEReference(letExpressionEClass, LET_EXPRESSION__ASSIGNMENTS);
		createEReference(letExpressionEClass, LET_EXPRESSION__TARGET);

		letExpressionAssignmentEClass = createEClass(LET_EXPRESSION_ASSIGNMENT);
		createEReference(letExpressionAssignmentEClass, LET_EXPRESSION_ASSIGNMENT__VARIABLES);
		createEReference(letExpressionAssignmentEClass, LET_EXPRESSION_ASSIGNMENT__ASSIGNED_EXPRESSION);

		letExpressionVariableDeclarationEClass = createEClass(LET_EXPRESSION_VARIABLE_DECLARATION);

		ifExpressionEClass = createEClass(IF_EXPRESSION);
		createEAttribute(ifExpressionEClass, IF_EXPRESSION__STATIC);
		createEReference(ifExpressionEClass, IF_EXPRESSION__CONDITION);
		createEReference(ifExpressionEClass, IF_EXPRESSION__THEN_EXPRESSION);
		createEReference(ifExpressionEClass, IF_EXPRESSION__ELSE_EXPRESSION);

		switchExpressionEClass = createEClass(SWITCH_EXPRESSION);
		createEAttribute(switchExpressionEClass, SWITCH_EXPRESSION__STATIC);
		createEReference(switchExpressionEClass, SWITCH_EXPRESSION__CONTROL_EXPRESSION);
		createEReference(switchExpressionEClass, SWITCH_EXPRESSION__CASES);
		createEReference(switchExpressionEClass, SWITCH_EXPRESSION__DEFAULT_EXPRESSION);

		switchCaseEClass = createEClass(SWITCH_CASE);
		createEReference(switchCaseEClass, SWITCH_CASE__CASE_EXPRESSION);
		createEReference(switchCaseEClass, SWITCH_CASE__RESULT_EXPRESSION);

		arrayElementAccessEClass = createEClass(ARRAY_ELEMENT_ACCESS);
		createEReference(arrayElementAccessEClass, ARRAY_ELEMENT_ACCESS__ARRAY);
		createEReference(arrayElementAccessEClass, ARRAY_ELEMENT_ACCESS__SUBSCRIPTS);

		arraySubscriptEClass = createEClass(ARRAY_SUBSCRIPT);
		createEAttribute(arraySubscriptEClass, ARRAY_SUBSCRIPT__SLICE);
		createEReference(arraySubscriptEClass, ARRAY_SUBSCRIPT__EXPRESSION);

		iterationCallEClass = createEClass(ITERATION_CALL);
		createEReference(iterationCallEClass, ITERATION_CALL__TARGET);
		createEAttribute(iterationCallEClass, ITERATION_CALL__IDENTIFIER);
		createEReference(iterationCallEClass, ITERATION_CALL__ITERATION_VARIABLES);
		createEReference(iterationCallEClass, ITERATION_CALL__ACCUMULATOR);
		createEReference(iterationCallEClass, ITERATION_CALL__BREAK_CONDITION);
		createEReference(iterationCallEClass, ITERATION_CALL__EXPRESSION);

		iterationVariableDeclarationEClass = createEClass(ITERATION_VARIABLE_DECLARATION);

		iterationAccumulatorEClass = createEClass(ITERATION_ACCUMULATOR);
		createEReference(iterationAccumulatorEClass, ITERATION_ACCUMULATOR__INITIALIZER);

		arrayConstructionOperatorEClass = createEClass(ARRAY_CONSTRUCTION_OPERATOR);
		createEReference(arrayConstructionOperatorEClass, ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS);
		createEReference(arrayConstructionOperatorEClass, ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES);

		arrayConstructionIterationClauseEClass = createEClass(ARRAY_CONSTRUCTION_ITERATION_CLAUSE);
		createEAttribute(arrayConstructionIterationClauseEClass, ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME);
		createEReference(arrayConstructionIterationClauseEClass, ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION);

		arrayConcatenationOperatorEClass = createEClass(ARRAY_CONCATENATION_OPERATOR);
		createEReference(arrayConcatenationOperatorEClass, ARRAY_CONCATENATION_OPERATOR__ROWS);

		expressionListEClass = createEClass(EXPRESSION_LIST);
		createEReference(expressionListEClass, EXPRESSION_LIST__EXPRESSIONS);

		unitConstructionOperatorEClass = createEClass(UNIT_CONSTRUCTION_OPERATOR);
		createEReference(unitConstructionOperatorEClass, UNIT_CONSTRUCTION_OPERATOR__UNIT);

		parenthesizedExpressionEClass = createEClass(PARENTHESIZED_EXPRESSION);
		createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__EXPRESSIONS);

		endExpressionEClass = createEClass(END_EXPRESSION);

		rangeExpressionEClass = createEClass(RANGE_EXPRESSION);
		createEReference(rangeExpressionEClass, RANGE_EXPRESSION__OPERANDS);

		impliesExpressionEClass = createEClass(IMPLIES_EXPRESSION);
		createEReference(impliesExpressionEClass, IMPLIES_EXPRESSION__LEFT_OPERAND);
		createEReference(impliesExpressionEClass, IMPLIES_EXPRESSION__RIGHT_OPERAND);

		logicalOrExpressionEClass = createEClass(LOGICAL_OR_EXPRESSION);
		createEReference(logicalOrExpressionEClass, LOGICAL_OR_EXPRESSION__LEFT_OPERAND);
		createEReference(logicalOrExpressionEClass, LOGICAL_OR_EXPRESSION__RIGHT_OPERAND);

		logicalAndExpressionEClass = createEClass(LOGICAL_AND_EXPRESSION);
		createEReference(logicalAndExpressionEClass, LOGICAL_AND_EXPRESSION__LEFT_OPERAND);
		createEReference(logicalAndExpressionEClass, LOGICAL_AND_EXPRESSION__RIGHT_OPERAND);

		equalityExpressionEClass = createEClass(EQUALITY_EXPRESSION);
		createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__LEFT_OPERAND);
		createEAttribute(equalityExpressionEClass, EQUALITY_EXPRESSION__OPERATOR);
		createEReference(equalityExpressionEClass, EQUALITY_EXPRESSION__RIGHT_OPERAND);

		relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
		createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__LEFT_OPERAND);
		createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERATOR);
		createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__RIGHT_OPERAND);

		typeTestExpressionEClass = createEClass(TYPE_TEST_EXPRESSION);
		createEReference(typeTestExpressionEClass, TYPE_TEST_EXPRESSION__EXPRESSION);
		createEReference(typeTestExpressionEClass, TYPE_TEST_EXPRESSION__TYPE_SPECIFIER);

		additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);
		createEAttribute(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERATOR);
		createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__LEFT_OPERAND);
		createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__RIGHT_OPERAND);

		multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);
		createEAttribute(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERATOR);
		createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__LEFT_OPERAND);
		createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__RIGHT_OPERAND);

		powerExpressionEClass = createEClass(POWER_EXPRESSION);
		createEReference(powerExpressionEClass, POWER_EXPRESSION__OPERAND);
		createEAttribute(powerExpressionEClass, POWER_EXPRESSION__OPERATOR);
		createEReference(powerExpressionEClass, POWER_EXPRESSION__EXPONENT);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATOR);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OPERAND);

		postfixExpressionEClass = createEClass(POSTFIX_EXPRESSION);
		createEReference(postfixExpressionEClass, POSTFIX_EXPRESSION__OPERAND);
		createEAttribute(postfixExpressionEClass, POSTFIX_EXPRESSION__OPERATOR);

		featureCallEClass = createEClass(FEATURE_CALL);
		createEReference(featureCallEClass, FEATURE_CALL__FEATURE);

		variableAccessEClass = createEClass(VARIABLE_ACCESS);
		createEReference(variableAccessEClass, VARIABLE_ACCESS__STEP_EXPRESSION);

		stepExpressionEClass = createEClass(STEP_EXPRESSION);

		rangeStepExpressionEClass = createEClass(RANGE_STEP_EXPRESSION);
		createEReference(rangeStepExpressionEClass, RANGE_STEP_EXPRESSION__START);
		createEReference(rangeStepExpressionEClass, RANGE_STEP_EXPRESSION__END);

		additiveStepExpressionEClass = createEClass(ADDITIVE_STEP_EXPRESSION);
		createEAttribute(additiveStepExpressionEClass, ADDITIVE_STEP_EXPRESSION__OPERATOR);
		createEReference(additiveStepExpressionEClass, ADDITIVE_STEP_EXPRESSION__LEFT_OPERAND);
		createEReference(additiveStepExpressionEClass, ADDITIVE_STEP_EXPRESSION__RIGHT_OPERAND);

		negateStepExpressionEClass = createEClass(NEGATE_STEP_EXPRESSION);
		createEReference(negateStepExpressionEClass, NEGATE_STEP_EXPRESSION__OPERAND);

		primitiveStepExpressionEClass = createEClass(PRIMITIVE_STEP_EXPRESSION);

		stepLiteralEClass = createEClass(STEP_LITERAL);
		createEAttribute(stepLiteralEClass, STEP_LITERAL__VALUE);

		stepNEClass = createEClass(STEP_N);

		functionCallEClass = createEClass(FUNCTION_CALL);
		createEReference(functionCallEClass, FUNCTION_CALL__ARGUMENTS);

		memberVariableAccessEClass = createEClass(MEMBER_VARIABLE_ACCESS);
		createEReference(memberVariableAccessEClass, MEMBER_VARIABLE_ACCESS__TARGET);
		createEReference(memberVariableAccessEClass, MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE);

		algorithmExpressionEClass = createEClass(ALGORITHM_EXPRESSION);
		createEReference(algorithmExpressionEClass, ALGORITHM_EXPRESSION__BODY);

		compoundEClass = createEClass(COMPOUND);
		createEReference(compoundEClass, COMPOUND__STATEMENTS);

		statementEClass = createEClass(STATEMENT);

		assignmentEClass = createEClass(ASSIGNMENT);
		createEReference(assignmentEClass, ASSIGNMENT__TARGET);
		createEReference(assignmentEClass, ASSIGNMENT__ASSIGNED_EXPRESSION);

		localVariableDeclarationEClass = createEClass(LOCAL_VARIABLE_DECLARATION);
		createEReference(localVariableDeclarationEClass, LOCAL_VARIABLE_DECLARATION__INITIALIZER);

		ifStatementEClass = createEClass(IF_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__CONDITION);
		createEReference(ifStatementEClass, IF_STATEMENT__THEN_STATEMENT);
		createEReference(ifStatementEClass, IF_STATEMENT__ELSE_STATEMENT);

		whileStatementEClass = createEClass(WHILE_STATEMENT);
		createEReference(whileStatementEClass, WHILE_STATEMENT__CONDITION);
		createEReference(whileStatementEClass, WHILE_STATEMENT__BODY);

		doWhileStatementEClass = createEClass(DO_WHILE_STATEMENT);
		createEReference(doWhileStatementEClass, DO_WHILE_STATEMENT__CONDITION);
		createEReference(doWhileStatementEClass, DO_WHILE_STATEMENT__BODY);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__ITERATION_VARIABLE);
		createEReference(forStatementEClass, FOR_STATEMENT__COLLECTION_EXPRESSION);
		createEReference(forStatementEClass, FOR_STATEMENT__CONDITION);
		createEReference(forStatementEClass, FOR_STATEMENT__BODY);

		continueStatementEClass = createEClass(CONTINUE_STATEMENT);

		breakStatementEClass = createEClass(BREAK_STATEMENT);

		returnStatementEClass = createEClass(RETURN_STATEMENT);
		createEReference(returnStatementEClass, RETURN_STATEMENT__EXPRESSION);

		builtinDefinitionEClass = createEClass(BUILTIN_DEFINITION);

		builtinFunctionEClass = createEClass(BUILTIN_FUNCTION);

		builtinVariableEClass = createEClass(BUILTIN_VARIABLE);

		dataTypeEClass = createEClass(DATA_TYPE);

		invalidDataTypeEClass = createEClass(INVALID_DATA_TYPE);

		anyDataTypeEClass = createEClass(ANY_DATA_TYPE);

		unitTypeEClass = createEClass(UNIT_TYPE);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		numericTypeEClass = createEClass(NUMERIC_TYPE);
		createEReference(numericTypeEClass, NUMERIC_TYPE__UNIT);

		realTypeEClass = createEClass(REAL_TYPE);

		integerTypeEClass = createEClass(INTEGER_TYPE);

		complexTypeEClass = createEClass(COMPLEX_TYPE);

		gaussianTypeEClass = createEClass(GAUSSIAN_TYPE);

		booleanTypeEClass = createEClass(BOOLEAN_TYPE);

		stringTypeEClass = createEClass(STRING_TYPE);

		arrayTypeEClass = createEClass(ARRAY_TYPE);
		createEReference(arrayTypeEClass, ARRAY_TYPE__ELEMENT_TYPE);
		createEReference(arrayTypeEClass, ARRAY_TYPE__DEFINED_ELEMENT_TYPE);
		createEReference(arrayTypeEClass, ARRAY_TYPE__DIMENSIONS);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__DIMENSIONALITY);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__DIMENSIONAL);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__MULTIDIMENSIONAL);

		tensorTypeEClass = createEClass(TENSOR_TYPE);
		createEAttribute(tensorTypeEClass, TENSOR_TYPE__VECTOR);
		createEAttribute(tensorTypeEClass, TENSOR_TYPE__MATRIX);

		arrayDimensionEClass = createEClass(ARRAY_DIMENSION);
		createEReference(arrayDimensionEClass, ARRAY_DIMENSION__SIZE);

		expressionEClass = createEClass(EXPRESSION);

		unitEClass = createEClass(UNIT);
		createEReference(unitEClass, UNIT__NUMERATOR);
		createEReference(unitEClass, UNIT__DENOMINATOR);
		createEAttribute(unitEClass, UNIT__SCALE);
		createEAttribute(unitEClass, UNIT__WILDCARD);

		unitProductEClass = createEClass(UNIT_PRODUCT);
		createEReference(unitProductEClass, UNIT_PRODUCT__FACTORS);

		unitNumeratorEClass = createEClass(UNIT_NUMERATOR);

		unitDenominatorEClass = createEClass(UNIT_DENOMINATOR);

		unitFactorEClass = createEClass(UNIT_FACTOR);
		createEAttribute(unitFactorEClass, UNIT_FACTOR__SYMBOL);
		createEAttribute(unitFactorEClass, UNIT_FACTOR__EXPONENT);

		literalEClass = createEClass(LITERAL);

		numericLiteralEClass = createEClass(NUMERIC_LITERAL);
		createEReference(numericLiteralEClass, NUMERIC_LITERAL__UNIT);

		realLiteralEClass = createEClass(REAL_LITERAL);
		createEAttribute(realLiteralEClass, REAL_LITERAL__DATA);
		createEAttribute(realLiteralEClass, REAL_LITERAL__VALUE);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__DATA);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__TRUE);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

		// Create enums
		functionKindEEnum = createEEnum(FUNCTION_KIND);
		assertionStatusKindEEnum = createEEnum(ASSERTION_STATUS_KIND);
		equalityOperatorEEnum = createEEnum(EQUALITY_OPERATOR);
		relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
		additiveOperatorEEnum = createEEnum(ADDITIVE_OPERATOR);
		multiplicativeOperatorEEnum = createEEnum(MULTIPLICATIVE_OPERATOR);
		powerOperatorEEnum = createEEnum(POWER_OPERATOR);
		unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
		postfixOperatorEEnum = createEEnum(POSTFIX_OPERATOR);
		operatorKindEEnum = createEEnum(OPERATOR_KIND);

		// Create data types
		realDataEDataType = createEDataType(REAL_DATA);
		integerDataEDataType = createEDataType(INTEGER_DATA);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		dataTypeDefinitionEClass.getESuperTypes().add(this.getDefinition());
		enumerationDefinitionEClass.getESuperTypes().add(this.getDataTypeDefinition());
		typedefDeclarationEClass.getESuperTypes().add(this.getDataTypeDefinition());
		structDefinitionEClass.getESuperTypes().add(this.getDataTypeDefinition());
		functionDefinitionEClass.getESuperTypes().add(this.getDefinition());
		functionDefinitionEClass.getESuperTypes().add(this.getCallableElement());
		callableElementEClass.getESuperTypes().add(this.getEvaluable());
		variableDeclarationEClass.getESuperTypes().add(this.getCallableElement());
		parameterDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		templateParameterDeclarationEClass.getESuperTypes().add(this.getParameterDeclaration());
		inputParameterDeclarationEClass.getESuperTypes().add(this.getParameterDeclaration());
		outputParameterDeclarationEClass.getESuperTypes().add(this.getParameterDeclaration());
		stateVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		constantDeclarationEClass.getESuperTypes().add(this.getCallableElement());
		functionObjectDeclarationEClass.getESuperTypes().add(this.getCallableElement());
		letExpressionEClass.getESuperTypes().add(this.getExpression());
		letExpressionVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		ifExpressionEClass.getESuperTypes().add(this.getExpression());
		switchExpressionEClass.getESuperTypes().add(this.getExpression());
		arrayElementAccessEClass.getESuperTypes().add(this.getExpression());
		iterationCallEClass.getESuperTypes().add(this.getExpression());
		iterationVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		iterationAccumulatorEClass.getESuperTypes().add(this.getVariableDeclaration());
		arrayConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
		arrayConcatenationOperatorEClass.getESuperTypes().add(this.getExpression());
		unitConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
		parenthesizedExpressionEClass.getESuperTypes().add(this.getExpression());
		endExpressionEClass.getESuperTypes().add(this.getExpression());
		rangeExpressionEClass.getESuperTypes().add(this.getExpression());
		impliesExpressionEClass.getESuperTypes().add(this.getExpression());
		logicalOrExpressionEClass.getESuperTypes().add(this.getExpression());
		logicalAndExpressionEClass.getESuperTypes().add(this.getExpression());
		equalityExpressionEClass.getESuperTypes().add(this.getExpression());
		relationalExpressionEClass.getESuperTypes().add(this.getExpression());
		typeTestExpressionEClass.getESuperTypes().add(this.getExpression());
		additiveExpressionEClass.getESuperTypes().add(this.getExpression());
		multiplicativeExpressionEClass.getESuperTypes().add(this.getExpression());
		powerExpressionEClass.getESuperTypes().add(this.getExpression());
		unaryExpressionEClass.getESuperTypes().add(this.getExpression());
		postfixExpressionEClass.getESuperTypes().add(this.getExpression());
		featureCallEClass.getESuperTypes().add(this.getExpression());
		variableAccessEClass.getESuperTypes().add(this.getFeatureCall());
		rangeStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		additiveStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		negateStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		primitiveStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		stepLiteralEClass.getESuperTypes().add(this.getPrimitiveStepExpression());
		stepNEClass.getESuperTypes().add(this.getPrimitiveStepExpression());
		functionCallEClass.getESuperTypes().add(this.getFeatureCall());
		memberVariableAccessEClass.getESuperTypes().add(this.getExpression());
		algorithmExpressionEClass.getESuperTypes().add(this.getExpression());
		compoundEClass.getESuperTypes().add(this.getStatement());
		assignmentEClass.getESuperTypes().add(this.getStatement());
		localVariableDeclarationEClass.getESuperTypes().add(this.getStatement());
		localVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		ifStatementEClass.getESuperTypes().add(this.getStatement());
		whileStatementEClass.getESuperTypes().add(this.getStatement());
		doWhileStatementEClass.getESuperTypes().add(this.getStatement());
		forStatementEClass.getESuperTypes().add(this.getStatement());
		continueStatementEClass.getESuperTypes().add(this.getStatement());
		breakStatementEClass.getESuperTypes().add(this.getStatement());
		returnStatementEClass.getESuperTypes().add(this.getStatement());
		builtinDefinitionEClass.getESuperTypes().add(this.getDefinition());
		builtinDefinitionEClass.getESuperTypes().add(this.getCallableElement());
		builtinFunctionEClass.getESuperTypes().add(this.getBuiltinDefinition());
		builtinVariableEClass.getESuperTypes().add(this.getBuiltinDefinition());
		invalidDataTypeEClass.getESuperTypes().add(this.getDataType());
		anyDataTypeEClass.getESuperTypes().add(this.getDataType());
		unitTypeEClass.getESuperTypes().add(this.getDataType());
		primitiveTypeEClass.getESuperTypes().add(this.getDataType());
		numericTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		realTypeEClass.getESuperTypes().add(this.getNumericType());
		integerTypeEClass.getESuperTypes().add(this.getNumericType());
		complexTypeEClass.getESuperTypes().add(this.getNumericType());
		gaussianTypeEClass.getESuperTypes().add(this.getNumericType());
		booleanTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		stringTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		arrayTypeEClass.getESuperTypes().add(this.getDataType());
		tensorTypeEClass.getESuperTypes().add(this.getArrayType());
		expressionEClass.getESuperTypes().add(this.getEvaluable());
		unitNumeratorEClass.getESuperTypes().add(this.getUnitProduct());
		unitDenominatorEClass.getESuperTypes().add(this.getUnitProduct());
		literalEClass.getESuperTypes().add(this.getExpression());
		numericLiteralEClass.getESuperTypes().add(this.getLiteral());
		realLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		integerLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
		stringLiteralEClass.getESuperTypes().add(this.getLiteral());

		// Initialize classes and features; add operations and parameters
		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModule_Definitions(), this.getDefinition(), null, "definitions", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definitionEClass, Definition.class, "Definition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Definition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeDefinitionEClass, DataTypeDefinition.class, "DataTypeDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumerationDefinitionEClass, EnumerationDefinition.class, "EnumerationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationDefinition_LiteralDeclarations(), this.getEnumerationLiteralDeclaration(), null, "literalDeclarations", null, 0, -1, EnumerationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationLiteralDeclarationEClass, EnumerationLiteralDeclaration.class, "EnumerationLiteralDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationLiteralDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumerationLiteralDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedefDeclarationEClass, TypedefDeclaration.class, "TypedefDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedefDeclaration_TypeSpecifier(), this.getDataTypeSpecifier(), null, "typeSpecifier", null, 0, 1, TypedefDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structDefinitionEClass, StructDefinition.class, "StructDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructDefinition_MemberDeclarations(), this.getStructMemberDeclaration(), null, "memberDeclarations", null, 0, -1, StructDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structMemberDeclarationEClass, StructMemberDeclaration.class, "StructMemberDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStructMemberDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, StructMemberDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStructMemberDeclaration_TypeSpecifier(), this.getDataTypeSpecifier(), null, "typeSpecifier", null, 0, 1, StructMemberDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionDefinitionEClass, FunctionDefinition.class, "FunctionDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionDefinition_Kind(), this.getFunctionKind(), "kind", null, 0, 1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_TemplateParameterDeclarations(), this.getTemplateParameterDeclaration(), null, "templateParameterDeclarations", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_InputParameterDeclarations(), this.getInputParameterDeclaration(), null, "inputParameterDeclarations", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_OutputParameterDeclarations(), this.getOutputParameterDeclaration(), null, "outputParameterDeclarations", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_Checks(), this.getCheck(), this.getCheck_Function(), "checks", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_Assertions(), this.getAssertion(), null, "assertions", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_FunctionObjectDeclarations(), this.getFunctionObjectDeclaration(), null, "functionObjectDeclarations", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_StateVariableDeclarations(), this.getStateVariableDeclaration(), null, "stateVariableDeclarations", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_ConstantDeclarations(), this.getConstantDeclaration(), null, "constantDeclarations", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDefinition_Equations(), this.getEquation(), null, "equations", null, 0, -1, FunctionDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkEClass, Check.class, "Check", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheck_Function(), this.getFunctionDefinition(), this.getFunctionDefinition_Checks(), "function", null, 1, 1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheck_TemplateArguments(), this.getExpression(), null, "templateArguments", null, 0, -1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheck_InputParameterTypes(), this.getDataTypeSpecifier(), null, "inputParameterTypes", null, 0, -1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheck_OutputParameterTypes(), this.getDataTypeSpecifier(), null, "outputParameterTypes", null, 0, -1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evaluableEClass, Evaluable.class, "Evaluable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callableElementEClass, CallableElement.class, "CallableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(callableElementEClass, ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(callableElementEClass, ecorePackage.getEString(), "getQualifiedName", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterDeclarationEClass, ParameterDeclaration.class, "ParameterDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(templateParameterDeclarationEClass, TemplateParameterDeclaration.class, "TemplateParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputParameterDeclarationEClass, InputParameterDeclaration.class, "InputParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputParameterDeclarationEClass, OutputParameterDeclaration.class, "OutputParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assertionEClass, Assertion.class, "Assertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertion_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertion_Condition(), this.getExpression(), null, "condition", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertion_StatusKind(), this.getAssertionStatusKind(), "statusKind", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertion_Message(), this.getExpression(), null, "message", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateVariableDeclarationEClass, StateVariableDeclaration.class, "StateVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantDeclarationEClass, ConstantDeclaration.class, "ConstantDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstantDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConstantDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstantDeclaration_Initializer(), this.getExpression(), null, "initializer", null, 0, 1, ConstantDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionObjectDeclarationEClass, FunctionObjectDeclaration.class, "FunctionObjectDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionObjectDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, FunctionObjectDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionObjectDeclaration_FunctionName(), this.getFunctionDefinition(), null, "functionName", null, 0, 1, FunctionObjectDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionObjectDeclaration_TemplateArguments(), this.getExpression(), null, "templateArguments", null, 0, -1, FunctionObjectDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equationEClass, Equation.class, "Equation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquation_Initial(), ecorePackage.getEBoolean(), "initial", null, 0, 1, Equation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquation_LeftHandSide(), this.getExpression(), null, "leftHandSide", null, 0, 1, Equation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquation_RightHandSide(), this.getExpression(), null, "rightHandSide", null, 0, 1, Equation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeSpecifierEClass, DataTypeSpecifier.class, "DataTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataTypeSpecifier_Type(), this.getDataType(), null, "type", null, 0, 1, DataTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataTypeSpecifier_DefinedType(), this.getDataType(), null, "definedType", null, 0, 1, DataTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(letExpressionEClass, LetExpression.class, "LetExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLetExpression_Assignments(), this.getLetExpressionAssignment(), null, "assignments", null, 0, -1, LetExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLetExpression_Target(), this.getExpression(), null, "target", null, 0, 1, LetExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(letExpressionAssignmentEClass, LetExpressionAssignment.class, "LetExpressionAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLetExpressionAssignment_Variables(), this.getLetExpressionVariableDeclaration(), null, "variables", null, 0, -1, LetExpressionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLetExpressionAssignment_AssignedExpression(), this.getExpression(), null, "assignedExpression", null, 0, 1, LetExpressionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(letExpressionVariableDeclarationEClass, LetExpressionVariableDeclaration.class, "LetExpressionVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ifExpressionEClass, IfExpression.class, "IfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIfExpression_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, IfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExpression_Condition(), this.getExpression(), null, "condition", null, 0, 1, IfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExpression_ThenExpression(), this.getExpression(), null, "thenExpression", null, 0, 1, IfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfExpression_ElseExpression(), this.getExpression(), null, "elseExpression", null, 0, 1, IfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchExpressionEClass, SwitchExpression.class, "SwitchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSwitchExpression_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, SwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchExpression_ControlExpression(), this.getExpression(), null, "controlExpression", null, 0, 1, SwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchExpression_Cases(), this.getSwitchCase(), null, "cases", null, 0, -1, SwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchExpression_DefaultExpression(), this.getExpression(), null, "defaultExpression", null, 0, 1, SwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchCaseEClass, SwitchCase.class, "SwitchCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchCase_CaseExpression(), this.getExpression(), null, "caseExpression", null, 0, 1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchCase_ResultExpression(), this.getExpression(), null, "resultExpression", null, 0, 1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayElementAccessEClass, ArrayElementAccess.class, "ArrayElementAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayElementAccess_Array(), this.getExpression(), null, "array", null, 0, 1, ArrayElementAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayElementAccess_Subscripts(), this.getArraySubscript(), null, "subscripts", null, 0, -1, ArrayElementAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arraySubscriptEClass, ArraySubscript.class, "ArraySubscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArraySubscript_Slice(), ecorePackage.getEBoolean(), "slice", null, 0, 1, ArraySubscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArraySubscript_Expression(), this.getExpression(), null, "expression", null, 0, 1, ArraySubscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterationCallEClass, IterationCall.class, "IterationCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIterationCall_Target(), this.getExpression(), null, "target", null, 0, 1, IterationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIterationCall_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, IterationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterationCall_IterationVariables(), this.getIterationVariableDeclaration(), null, "iterationVariables", null, 0, -1, IterationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterationCall_Accumulator(), this.getIterationAccumulator(), null, "accumulator", null, 0, 1, IterationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterationCall_BreakCondition(), this.getExpression(), null, "breakCondition", null, 0, 1, IterationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIterationCall_Expression(), this.getExpression(), null, "expression", null, 0, 1, IterationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterationVariableDeclarationEClass, IterationVariableDeclaration.class, "IterationVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iterationAccumulatorEClass, IterationAccumulator.class, "IterationAccumulator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIterationAccumulator_Initializer(), this.getExpression(), null, "initializer", null, 0, 1, IterationAccumulator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayConstructionOperatorEClass, ArrayConstructionOperator.class, "ArrayConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayConstructionOperator_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ArrayConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayConstructionOperator_IterationClauses(), this.getArrayConstructionIterationClause(), null, "iterationClauses", null, 0, -1, ArrayConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayConstructionIterationClauseEClass, ArrayConstructionIterationClause.class, "ArrayConstructionIterationClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArrayConstructionIterationClause_VariableName(), ecorePackage.getEString(), "variableName", null, 0, 1, ArrayConstructionIterationClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayConstructionIterationClause_CollectionExpression(), this.getExpression(), null, "collectionExpression", null, 0, 1, ArrayConstructionIterationClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayConcatenationOperatorEClass, ArrayConcatenationOperator.class, "ArrayConcatenationOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayConcatenationOperator_Rows(), this.getExpressionList(), null, "rows", null, 0, -1, ArrayConcatenationOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionListEClass, ExpressionList.class, "ExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionList_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ExpressionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitConstructionOperatorEClass, UnitConstructionOperator.class, "UnitConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitConstructionOperator_Unit(), this.getUnit(), null, "unit", null, 0, 1, UnitConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parenthesizedExpressionEClass, ParenthesizedExpression.class, "ParenthesizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParenthesizedExpression_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endExpressionEClass, EndExpression.class, "EndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rangeExpressionEClass, RangeExpression.class, "RangeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRangeExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, RangeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impliesExpressionEClass, ImpliesExpression.class, "ImpliesExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImpliesExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, ImpliesExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImpliesExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, ImpliesExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logicalOrExpressionEClass, LogicalOrExpression.class, "LogicalOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogicalOrExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, LogicalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogicalOrExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, LogicalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(logicalAndExpressionEClass, LogicalAndExpression.class, "LogicalAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLogicalAndExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, LogicalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLogicalAndExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, LogicalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equalityExpressionEClass, EqualityExpression.class, "EqualityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEqualityExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEqualityExpression_Operator(), this.getEqualityOperator(), "operator", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEqualityExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, EqualityExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationalExpression_Operator(), this.getRelationalOperator(), "operator", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationalExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeTestExpressionEClass, TypeTestExpression.class, "TypeTestExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeTestExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, TypeTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeTestExpression_TypeSpecifier(), this.getDataTypeSpecifier(), null, "typeSpecifier", null, 0, 1, TypeTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdditiveExpression_Operator(), this.getAdditiveOperator(), "operator", null, 0, 1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdditiveExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdditiveExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMultiplicativeExpression_Operator(), this.getMultiplicativeOperator(), "operator", null, 0, 1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicativeExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiplicativeExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(powerExpressionEClass, PowerExpression.class, "PowerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPowerExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPowerExpression_Operator(), this.getPowerOperator(), "operator", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPowerExpression_Exponent(), this.getExpression(), null, "exponent", null, 0, 1, PowerExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryExpression_Operator(), this.getUnaryOperator(), "operator", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(postfixExpressionEClass, PostfixExpression.class, "PostfixExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPostfixExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPostfixExpression_Operator(), this.getPostfixOperator(), "operator", null, 0, 1, PostfixExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureCallEClass, FeatureCall.class, "FeatureCall", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureCall_Feature(), this.getCallableElement(), null, "feature", null, 0, 1, FeatureCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableAccessEClass, VariableAccess.class, "VariableAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableAccess_StepExpression(), this.getStepExpression(), null, "stepExpression", null, 0, 1, VariableAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(variableAccessEClass, ecorePackage.getEBoolean(), "isInitial", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stepExpressionEClass, StepExpression.class, "StepExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rangeStepExpressionEClass, RangeStepExpression.class, "RangeStepExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRangeStepExpression_Start(), this.getStepExpression(), null, "start", null, 0, 1, RangeStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeStepExpression_End(), this.getStepExpression(), null, "end", null, 0, 1, RangeStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additiveStepExpressionEClass, AdditiveStepExpression.class, "AdditiveStepExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdditiveStepExpression_Operator(), this.getAdditiveOperator(), "operator", null, 0, 1, AdditiveStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdditiveStepExpression_LeftOperand(), this.getStepExpression(), null, "leftOperand", null, 0, 1, AdditiveStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdditiveStepExpression_RightOperand(), this.getStepExpression(), null, "rightOperand", null, 0, 1, AdditiveStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(negateStepExpressionEClass, NegateStepExpression.class, "NegateStepExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNegateStepExpression_Operand(), this.getStepExpression(), null, "operand", null, 0, 1, NegateStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveStepExpressionEClass, PrimitiveStepExpression.class, "PrimitiveStepExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stepLiteralEClass, StepLiteral.class, "StepLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStepLiteral_Value(), ecorePackage.getEInt(), "value", null, 0, 1, StepLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stepNEClass, StepN.class, "StepN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionCall_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(memberVariableAccessEClass, MemberVariableAccess.class, "MemberVariableAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemberVariableAccess_Target(), this.getExpression(), null, "target", null, 0, 1, MemberVariableAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMemberVariableAccess_MemberVariable(), this.getCallableElement(), null, "memberVariable", null, 0, 1, MemberVariableAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(algorithmExpressionEClass, AlgorithmExpression.class, "AlgorithmExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlgorithmExpression_Body(), this.getCompound(), null, "body", null, 0, 1, AlgorithmExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundEClass, Compound.class, "Compound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompound_Statements(), this.getStatement(), null, "statements", null, 0, -1, Compound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(compoundEClass, this.getLocalVariableDeclaration(), "getLocalVariableDeclarations", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssignment_Target(), this.getExpression(), null, "target", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssignment_AssignedExpression(), this.getExpression(), null, "assignedExpression", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(localVariableDeclarationEClass, LocalVariableDeclaration.class, "LocalVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLocalVariableDeclaration_Initializer(), this.getExpression(), null, "initializer", null, 0, 1, LocalVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifStatementEClass, IfStatement.class, "IfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_ThenStatement(), this.getStatement(), null, "thenStatement", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIfStatement_ElseStatement(), this.getStatement(), null, "elseStatement", null, 0, 1, IfStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWhileStatement_Body(), this.getStatement(), null, "body", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doWhileStatementEClass, DoWhileStatement.class, "DoWhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDoWhileStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, DoWhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoWhileStatement_Body(), this.getStatement(), null, "body", null, 0, 1, DoWhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStatement_IterationVariable(), this.getIterationVariableDeclaration(), null, "iterationVariable", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_CollectionExpression(), this.getExpression(), null, "collectionExpression", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Condition(), this.getExpression(), null, "condition", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Body(), this.getStatement(), null, "body", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(continueStatementEClass, ContinueStatement.class, "ContinueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builtinDefinitionEClass, BuiltinDefinition.class, "BuiltinDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(builtinFunctionEClass, BuiltinFunction.class, "BuiltinFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(builtinVariableEClass, BuiltinVariable.class, "BuiltinVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(dataTypeEClass, this.getDataType(), "evaluate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorKind(), "operator", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataType(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dataTypeEClass, this.getDataType(), "evaluate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorKind(), "operator", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "n", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dataTypeEClass, ecorePackage.getEBoolean(), "isAssignableFrom", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataType(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dataTypeEClass, ecorePackage.getEBoolean(), "isEquivalentTo", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataType(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(invalidDataTypeEClass, InvalidDataType.class, "InvalidDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(anyDataTypeEClass, AnyDataType.class, "AnyDataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unitTypeEClass, UnitType.class, "UnitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericTypeEClass, NumericType.class, "NumericType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumericType_Unit(), this.getUnit(), null, "unit", null, 1, 1, NumericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realTypeEClass, RealType.class, "RealType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexTypeEClass, ComplexType.class, "ComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gaussianTypeEClass, GaussianType.class, "GaussianType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(arrayTypeEClass, ArrayType.class, "ArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayType_ElementType(), this.getDataType(), null, "elementType", null, 0, 1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayType_DefinedElementType(), this.getDataType(), null, "definedElementType", null, 0, 1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayType_Dimensions(), this.getArrayDimension(), null, "dimensions", null, 0, -1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_Dimensionality(), ecorePackage.getEInt(), "dimensionality", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_Dimensional(), ecorePackage.getEBoolean(), "dimensional", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_Multidimensional(), ecorePackage.getEBoolean(), "multidimensional", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(tensorTypeEClass, TensorType.class, "TensorType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTensorType_Vector(), ecorePackage.getEBoolean(), "vector", null, 1, 1, TensorType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getTensorType_Matrix(), ecorePackage.getEBoolean(), "matrix", null, 1, 1, TensorType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(arrayDimensionEClass, ArrayDimension.class, "ArrayDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayDimension_Size(), this.getExpression(), null, "size", null, 0, 1, ArrayDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnit_Numerator(), this.getUnitNumerator(), null, "numerator", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnit_Denominator(), this.getUnitDenominator(), null, "denominator", null, 0, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnit_Scale(), ecorePackage.getEInt(), "scale", null, 1, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnit_Wildcard(), ecorePackage.getEBoolean(), "wildcard", null, 1, 1, Unit.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(unitEClass, this.getUnit(), "getNormalized", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(unitEClass, this.getUnit(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorKind(), "operator", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUnit(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(unitEClass, this.getUnit(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorKind(), "operator", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "n", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(unitEClass, ecorePackage.getEBoolean(), "isEquivalentTo", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUnit(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "ignoreScale", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unitProductEClass, UnitProduct.class, "UnitProduct", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitProduct_Factors(), this.getUnitFactor(), null, "factors", null, 0, -1, UnitProduct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(unitProductEClass, this.getUnitFactor(), "getFactor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "symbol", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unitNumeratorEClass, UnitNumerator.class, "UnitNumerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unitDenominatorEClass, UnitDenominator.class, "UnitDenominator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unitFactorEClass, UnitFactor.class, "UnitFactor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitFactor_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, UnitFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitFactor_Exponent(), ecorePackage.getEInt(), "exponent", "1", 0, 1, UnitFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericLiteralEClass, NumericLiteral.class, "NumericLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumericLiteral_Unit(), this.getUnit(), null, "unit", null, 1, 1, NumericLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(numericLiteralEClass, ecorePackage.getEBoolean(), "isComplex", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(realLiteralEClass, RealLiteral.class, "RealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRealLiteral_Data(), this.getRealData(), "data", "0.0", 0, 1, RealLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRealLiteral_Value(), ecorePackage.getEDouble(), "value", null, 0, 1, RealLiteral.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Data(), this.getIntegerData(), "data", "0", 0, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerLiteral_Value(), ecorePackage.getELong(), "value", null, 0, 1, IntegerLiteral.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_True(), ecorePackage.getEBoolean(), "true", null, 0, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(functionKindEEnum, FunctionKind.class, "FunctionKind");
		addEEnumLiteral(functionKindEEnum, FunctionKind.STATELESS);
		addEEnumLiteral(functionKindEEnum, FunctionKind.STATEFUL);
		addEEnumLiteral(functionKindEEnum, FunctionKind.CONTINUOUS);

		initEEnum(assertionStatusKindEEnum, AssertionStatusKind.class, "AssertionStatusKind");
		addEEnumLiteral(assertionStatusKindEEnum, AssertionStatusKind.INFO);
		addEEnumLiteral(assertionStatusKindEEnum, AssertionStatusKind.WARNING);
		addEEnumLiteral(assertionStatusKindEEnum, AssertionStatusKind.ERROR);
		addEEnumLiteral(assertionStatusKindEEnum, AssertionStatusKind.FATAL);

		initEEnum(equalityOperatorEEnum, EqualityOperator.class, "EqualityOperator");
		addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.EQUAL_TO);
		addEEnumLiteral(equalityOperatorEEnum, EqualityOperator.NOT_EQUAL_TO);

		initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_THAN_OR_EQUAL_TO);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_THAN_OR_EQUAL_TO);

		initEEnum(additiveOperatorEEnum, AdditiveOperator.class, "AdditiveOperator");
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.ADD);
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.SUBTRACT);

		initEEnum(multiplicativeOperatorEEnum, MultiplicativeOperator.class, "MultiplicativeOperator");
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MULTIPLY);
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.DIVIDE);
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.ELEMENT_WISE_MULTIPLY);
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.ELEMENT_WISE_DIVIDE);

		initEEnum(powerOperatorEEnum, PowerOperator.class, "PowerOperator");
		addEEnumLiteral(powerOperatorEEnum, PowerOperator.POWER);
		addEEnumLiteral(powerOperatorEEnum, PowerOperator.ELEMENT_WISE_POWER);

		initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NEGATE);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.LOGICAL_NOT);

		initEEnum(postfixOperatorEEnum, PostfixOperator.class, "PostfixOperator");
		addEEnumLiteral(postfixOperatorEEnum, PostfixOperator.DERIVATIVE);

		initEEnum(operatorKindEEnum, OperatorKind.class, "OperatorKind");
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ADD);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.SUBTRACT);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.MULTIPLY);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.DIVIDE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_MULTIPLY);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_DIVIDE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_POWER);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.NEGATE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.POWER);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ROOT);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.TRANSPOSE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.LOGICAL_AND);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.LOGICAL_OR);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.LOGICAL_NOT);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.IMPLIES);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.LESS_THAN);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.LESS_THAN_OR_EQUAL_TO);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.GREATER_THAN);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.GREATER_THAN_OR_EQUAL_TO);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.EQUAL_TO);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.NOT_EQUAL_TO);

		// Initialize data types
		initEDataType(realDataEDataType, RealData.class, "RealData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerDataEDataType, IntegerData.class, "IntegerData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MscriptPackageImpl
