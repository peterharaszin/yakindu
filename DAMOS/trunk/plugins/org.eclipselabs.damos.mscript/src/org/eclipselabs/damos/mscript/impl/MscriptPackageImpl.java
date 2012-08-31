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
	private EClass importDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationDeclarationEClass = null;

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
	private EClass functionDeclarationEClass = null;

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
	private EClass checkArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeCheckArgumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionCheckArgumentEClass = null;

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
	private EClass equationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anonymousTypeSpecifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declaredTypeSpecifierEClass = null;

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
	private EClass iterationVariableDeclarationEClass = null;

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
	private EClass recordConstructionOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordConstructionMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unionConstructionOperatorEClass = null;

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
	private EClass unitConversionExpressionEClass = null;

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
	private EClass binaryExpressionEClass = null;

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
	private EClass featureReferenceEClass = null;

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
	private EClass lambdaExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lambdaExpressionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inspectExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inspectWhenClauseEClass = null;

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
	private EClass invalidExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundStatementEClass = null;

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
	private EClass builtinDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass builtinFunctionDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invalidTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anyTypeEClass = null;

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
	private EClass unitTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionTypeEClass = null;

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
	private EClass anonymousArrayTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declaredArrayTypeEClass = null;

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
	private EClass compositeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeTypeMemberListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeTypeMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recordTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unionTypeEClass = null;

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
	private EClass unitFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitDenominatorFactorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unitSymbolEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass baseUnitDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedUnitDeclarationEClass = null;

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
	private EClass templateExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantTemplateSegmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionTemplateSegmentEClass = null;

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
	private EEnum operatorKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unitPrefixEEnum = null;

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
	public EAttribute getModule_PackageName() {
		return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModule_ImportDeclarations() {
		return (EReference)moduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportDeclaration() {
		return importDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportDeclaration_ImportedNamespace() {
		return (EAttribute)importDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelDeclaration() {
		return topLevelDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelContainer() {
		return topLevelContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelContainer_Declarations() {
		return (EReference)topLevelContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeDeclaration() {
		return typeDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypeDeclaration_Name() {
		return (EAttribute)typeDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeDeclaration_TypeSpecifier() {
		return (EReference)typeDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationDeclaration() {
		return enumerationDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationDeclaration_Name() {
		return (EAttribute)enumerationDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationDeclaration_LiteralDeclarations() {
		return (EReference)enumerationDeclarationEClass.getEStructuralFeatures().get(1);
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
	public EClass getFunctionDeclaration() {
		return functionDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionDeclaration_Name() {
		return (EAttribute)functionDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunctionDeclaration_Kind() {
		return (EAttribute)functionDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_InputParameterDeclarations() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_OutputParameterDeclarations() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_Checks() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_Assertions() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_StateVariableDeclarations() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_ConstantDeclarations() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionDeclaration_Equations() {
		return (EReference)functionDeclarationEClass.getEStructuralFeatures().get(8);
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
	public EReference getCheck_InputArguments() {
		return (EReference)checkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheck_OutputTypeSpecifiers() {
		return (EReference)checkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckArgument() {
		return checkArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeCheckArgument() {
		return typeCheckArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeCheckArgument_TypeSpecifier() {
		return (EReference)typeCheckArgumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionCheckArgument() {
		return expressionCheckArgumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionCheckArgument_Expression() {
		return (EReference)expressionCheckArgumentEClass.getEStructuralFeatures().get(0);
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
	public EClass getInputParameterDeclaration() {
		return inputParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInputParameterDeclaration_Constant() {
		return (EAttribute)inputParameterDeclarationEClass.getEStructuralFeatures().get(0);
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
	public EReference getConstantDeclaration_Initializer() {
		return (EReference)constantDeclarationEClass.getEStructuralFeatures().get(0);
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
	public EClass getTypeSpecifier() {
		return typeSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnonymousTypeSpecifier() {
		return anonymousTypeSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnonymousTypeSpecifier_Type() {
		return (EReference)anonymousTypeSpecifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaredTypeSpecifier() {
		return declaredTypeSpecifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclaredTypeSpecifier_TypeDeclaration() {
		return (EReference)declaredTypeSpecifierEClass.getEStructuralFeatures().get(0);
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
	public EReference getSwitchCase_Owner() {
		return (EReference)switchCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCase_CaseExpression() {
		return (EReference)switchCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchCase_ResultExpression() {
		return (EReference)switchCaseEClass.getEStructuralFeatures().get(2);
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
	public EClass getIterationVariableDeclaration() {
		return iterationVariableDeclarationEClass;
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
	public EClass getRecordConstructionOperator() {
		return recordConstructionOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecordConstructionOperator_Label() {
		return (EAttribute)recordConstructionOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordConstructionOperator_Members() {
		return (EReference)recordConstructionOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordConstructionMember() {
		return recordConstructionMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRecordConstructionMember_Name() {
		return (EAttribute)recordConstructionMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRecordConstructionMember_Value() {
		return (EReference)recordConstructionMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnionConstructionOperator() {
		return unionConstructionOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnionConstructionOperator_Member() {
		return (EReference)unionConstructionOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnionConstructionOperator_Value() {
		return (EReference)unionConstructionOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnionConstructionOperator_TypeSpecifier() {
		return (EReference)unionConstructionOperatorEClass.getEStructuralFeatures().get(2);
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
	public EClass getUnitConversionExpression() {
		return unitConversionExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitConversionExpression_Operand() {
		return (EReference)unitConversionExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitConversionExpression_Unit() {
		return (EReference)unitConversionExpressionEClass.getEStructuralFeatures().get(1);
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
	public EClass getBinaryExpression() {
		return binaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_LeftOperand() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryExpression_Operator() {
		return (EAttribute)binaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryExpression_RightOperand() {
		return (EReference)binaryExpressionEClass.getEStructuralFeatures().get(2);
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
	public EClass getLogicalOrExpression() {
		return logicalOrExpressionEClass;
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
	public EClass getEqualityExpression() {
		return equalityExpressionEClass;
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
	public EClass getMultiplicativeExpression() {
		return multiplicativeExpressionEClass;
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
	public EClass getFeatureReference() {
		return featureReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureReference_Feature() {
		return (EReference)featureReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeatureReference_StepExpression() {
		return (EReference)featureReferenceEClass.getEStructuralFeatures().get(1);
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
		return (EReference)functionCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunctionCall_Target() {
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
	public EAttribute getMemberVariableAccess_MemberVariable() {
		return (EAttribute)memberVariableAccessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLambdaExpression() {
		return lambdaExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLambdaExpression_Parameters() {
		return (EReference)lambdaExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLambdaExpression_Expression() {
		return (EReference)lambdaExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLambdaExpressionParameter() {
		return lambdaExpressionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInspectExpression() {
		return inspectExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspectExpression_UnionExpression() {
		return (EReference)inspectExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspectExpression_WhenClauses() {
		return (EReference)inspectExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInspectWhenClause() {
		return inspectWhenClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspectWhenClause_Owner() {
		return (EReference)inspectWhenClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInspectWhenClause_Expression() {
		return (EReference)inspectWhenClauseEClass.getEStructuralFeatures().get(1);
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
	public EClass getInvalidExpression() {
		return invalidExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundStatement() {
		return compoundStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundStatement_Statements() {
		return (EReference)compoundStatementEClass.getEStructuralFeatures().get(0);
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
	public EReference getForStatement_Body() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
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
	public EClass getBuiltinDeclaration() {
		return builtinDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBuiltinFunctionDeclaration() {
		return builtinFunctionDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBuiltinFunctionDeclaration_Name() {
		return (EAttribute)builtinFunctionDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvalidType() {
		return invalidTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnyType() {
		return anyTypeEClass;
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
	public EClass getUnitType() {
		return unitTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionType() {
		return functionTypeEClass;
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
	public EReference getArrayType_Dimensions() {
		return (EReference)arrayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_Dimensionality() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_Dimensional() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_Multidimensional() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_Numeric() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_NumericVector() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getArrayType_NumericMatrix() {
		return (EAttribute)arrayTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnonymousArrayType() {
		return anonymousArrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnonymousArrayType_ElementType() {
		return (EReference)anonymousArrayTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaredArrayType() {
		return declaredArrayTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeclaredArrayType_ElementTypeDeclaration() {
		return (EReference)declaredArrayTypeEClass.getEStructuralFeatures().get(0);
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
	public EClass getCompositeType() {
		return compositeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeType_Label() {
		return (EAttribute)compositeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeType_AnyLabel() {
		return (EAttribute)compositeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeType_MemberLists() {
		return (EReference)compositeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeTypeMemberList() {
		return compositeTypeMemberListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeTypeMemberList_TypeSpecifier() {
		return (EReference)compositeTypeMemberListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeTypeMemberList_Members() {
		return (EReference)compositeTypeMemberListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeTypeMember() {
		return compositeTypeMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeTypeMember_Owner() {
		return (EReference)compositeTypeMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompositeTypeMember_Name() {
		return (EAttribute)compositeTypeMemberEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecordType() {
		return recordTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnionType() {
		return unionTypeEClass;
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
	public EAttribute getUnit_Scale() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnit_Any() {
		return (EAttribute)unitEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnit_Factors() {
		return (EReference)unitEClass.getEStructuralFeatures().get(2);
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
	public EReference getUnitFactor_Symbol() {
		return (EReference)unitFactorEClass.getEStructuralFeatures().get(0);
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
	public EClass getUnitDenominatorFactor() {
		return unitDenominatorFactorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitDeclaration() {
		return unitDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitDeclaration_Name() {
		return (EAttribute)unitDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitDeclaration_Symbols() {
		return (EReference)unitDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnitSymbol() {
		return unitSymbolEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnitSymbol_Owner() {
		return (EReference)unitSymbolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitSymbol_Prefix() {
		return (EAttribute)unitSymbolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitSymbol_Name() {
		return (EAttribute)unitSymbolEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnitSymbol_Scale() {
		return (EAttribute)unitSymbolEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseUnitDeclaration() {
		return baseUnitDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedUnitDeclaration() {
		return derivedUnitDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedUnitDeclaration_Definition() {
		return (EReference)derivedUnitDeclarationEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getStringLiteral_Text() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateExpression() {
		return templateExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateExpression_Segments() {
		return (EReference)templateExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateSegment() {
		return templateSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantTemplateSegment() {
		return constantTemplateSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstantTemplateSegment_Text() {
		return (EAttribute)constantTemplateSegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstantTemplateSegment_NormalizedText() {
		return (EAttribute)constantTemplateSegmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionTemplateSegment() {
		return expressionTemplateSegmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionTemplateSegment_Expression() {
		return (EReference)expressionTemplateSegmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionTemplateSegment_Indentation() {
		return (EAttribute)expressionTemplateSegmentEClass.getEStructuralFeatures().get(1);
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
	public EEnum getOperatorKind() {
		return operatorKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnitPrefix() {
		return unitPrefixEEnum;
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
		createEAttribute(moduleEClass, MODULE__PACKAGE_NAME);
		createEReference(moduleEClass, MODULE__IMPORT_DECLARATIONS);

		importDeclarationEClass = createEClass(IMPORT_DECLARATION);
		createEAttribute(importDeclarationEClass, IMPORT_DECLARATION__IMPORTED_NAMESPACE);

		topLevelDeclarationEClass = createEClass(TOP_LEVEL_DECLARATION);

		topLevelContainerEClass = createEClass(TOP_LEVEL_CONTAINER);
		createEReference(topLevelContainerEClass, TOP_LEVEL_CONTAINER__DECLARATIONS);

		typeDeclarationEClass = createEClass(TYPE_DECLARATION);
		createEAttribute(typeDeclarationEClass, TYPE_DECLARATION__NAME);
		createEReference(typeDeclarationEClass, TYPE_DECLARATION__TYPE_SPECIFIER);

		enumerationDeclarationEClass = createEClass(ENUMERATION_DECLARATION);
		createEAttribute(enumerationDeclarationEClass, ENUMERATION_DECLARATION__NAME);
		createEReference(enumerationDeclarationEClass, ENUMERATION_DECLARATION__LITERAL_DECLARATIONS);

		enumerationLiteralDeclarationEClass = createEClass(ENUMERATION_LITERAL_DECLARATION);
		createEAttribute(enumerationLiteralDeclarationEClass, ENUMERATION_LITERAL_DECLARATION__NAME);

		functionDeclarationEClass = createEClass(FUNCTION_DECLARATION);
		createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__NAME);
		createEAttribute(functionDeclarationEClass, FUNCTION_DECLARATION__KIND);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__INPUT_PARAMETER_DECLARATIONS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__OUTPUT_PARAMETER_DECLARATIONS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__CHECKS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__ASSERTIONS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__STATE_VARIABLE_DECLARATIONS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__CONSTANT_DECLARATIONS);
		createEReference(functionDeclarationEClass, FUNCTION_DECLARATION__EQUATIONS);

		checkEClass = createEClass(CHECK);
		createEReference(checkEClass, CHECK__FUNCTION);
		createEReference(checkEClass, CHECK__INPUT_ARGUMENTS);
		createEReference(checkEClass, CHECK__OUTPUT_TYPE_SPECIFIERS);

		checkArgumentEClass = createEClass(CHECK_ARGUMENT);

		typeCheckArgumentEClass = createEClass(TYPE_CHECK_ARGUMENT);
		createEReference(typeCheckArgumentEClass, TYPE_CHECK_ARGUMENT__TYPE_SPECIFIER);

		expressionCheckArgumentEClass = createEClass(EXPRESSION_CHECK_ARGUMENT);
		createEReference(expressionCheckArgumentEClass, EXPRESSION_CHECK_ARGUMENT__EXPRESSION);

		evaluableEClass = createEClass(EVALUABLE);

		callableElementEClass = createEClass(CALLABLE_ELEMENT);

		variableDeclarationEClass = createEClass(VARIABLE_DECLARATION);
		createEAttribute(variableDeclarationEClass, VARIABLE_DECLARATION__NAME);

		parameterDeclarationEClass = createEClass(PARAMETER_DECLARATION);

		inputParameterDeclarationEClass = createEClass(INPUT_PARAMETER_DECLARATION);
		createEAttribute(inputParameterDeclarationEClass, INPUT_PARAMETER_DECLARATION__CONSTANT);

		outputParameterDeclarationEClass = createEClass(OUTPUT_PARAMETER_DECLARATION);

		assertionEClass = createEClass(ASSERTION);
		createEAttribute(assertionEClass, ASSERTION__STATIC);
		createEReference(assertionEClass, ASSERTION__CONDITION);
		createEAttribute(assertionEClass, ASSERTION__STATUS_KIND);
		createEReference(assertionEClass, ASSERTION__MESSAGE);

		stateVariableDeclarationEClass = createEClass(STATE_VARIABLE_DECLARATION);

		constantDeclarationEClass = createEClass(CONSTANT_DECLARATION);
		createEReference(constantDeclarationEClass, CONSTANT_DECLARATION__INITIALIZER);

		equationEClass = createEClass(EQUATION);
		createEAttribute(equationEClass, EQUATION__INITIAL);
		createEReference(equationEClass, EQUATION__LEFT_HAND_SIDE);
		createEReference(equationEClass, EQUATION__RIGHT_HAND_SIDE);

		typeSpecifierEClass = createEClass(TYPE_SPECIFIER);

		anonymousTypeSpecifierEClass = createEClass(ANONYMOUS_TYPE_SPECIFIER);
		createEReference(anonymousTypeSpecifierEClass, ANONYMOUS_TYPE_SPECIFIER__TYPE);

		declaredTypeSpecifierEClass = createEClass(DECLARED_TYPE_SPECIFIER);
		createEReference(declaredTypeSpecifierEClass, DECLARED_TYPE_SPECIFIER__TYPE_DECLARATION);

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
		createEReference(switchCaseEClass, SWITCH_CASE__OWNER);
		createEReference(switchCaseEClass, SWITCH_CASE__CASE_EXPRESSION);
		createEReference(switchCaseEClass, SWITCH_CASE__RESULT_EXPRESSION);

		arrayElementAccessEClass = createEClass(ARRAY_ELEMENT_ACCESS);
		createEReference(arrayElementAccessEClass, ARRAY_ELEMENT_ACCESS__ARRAY);
		createEReference(arrayElementAccessEClass, ARRAY_ELEMENT_ACCESS__SUBSCRIPTS);

		arraySubscriptEClass = createEClass(ARRAY_SUBSCRIPT);
		createEAttribute(arraySubscriptEClass, ARRAY_SUBSCRIPT__SLICE);
		createEReference(arraySubscriptEClass, ARRAY_SUBSCRIPT__EXPRESSION);

		arrayConstructionOperatorEClass = createEClass(ARRAY_CONSTRUCTION_OPERATOR);
		createEReference(arrayConstructionOperatorEClass, ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS);

		arrayConcatenationOperatorEClass = createEClass(ARRAY_CONCATENATION_OPERATOR);
		createEReference(arrayConcatenationOperatorEClass, ARRAY_CONCATENATION_OPERATOR__ROWS);

		expressionListEClass = createEClass(EXPRESSION_LIST);
		createEReference(expressionListEClass, EXPRESSION_LIST__EXPRESSIONS);

		recordConstructionOperatorEClass = createEClass(RECORD_CONSTRUCTION_OPERATOR);
		createEAttribute(recordConstructionOperatorEClass, RECORD_CONSTRUCTION_OPERATOR__LABEL);
		createEReference(recordConstructionOperatorEClass, RECORD_CONSTRUCTION_OPERATOR__MEMBERS);

		recordConstructionMemberEClass = createEClass(RECORD_CONSTRUCTION_MEMBER);
		createEAttribute(recordConstructionMemberEClass, RECORD_CONSTRUCTION_MEMBER__NAME);
		createEReference(recordConstructionMemberEClass, RECORD_CONSTRUCTION_MEMBER__VALUE);

		unionConstructionOperatorEClass = createEClass(UNION_CONSTRUCTION_OPERATOR);
		createEReference(unionConstructionOperatorEClass, UNION_CONSTRUCTION_OPERATOR__MEMBER);
		createEReference(unionConstructionOperatorEClass, UNION_CONSTRUCTION_OPERATOR__VALUE);
		createEReference(unionConstructionOperatorEClass, UNION_CONSTRUCTION_OPERATOR__TYPE_SPECIFIER);

		unitConstructionOperatorEClass = createEClass(UNIT_CONSTRUCTION_OPERATOR);
		createEReference(unitConstructionOperatorEClass, UNIT_CONSTRUCTION_OPERATOR__UNIT);

		unitConversionExpressionEClass = createEClass(UNIT_CONVERSION_EXPRESSION);
		createEReference(unitConversionExpressionEClass, UNIT_CONVERSION_EXPRESSION__OPERAND);
		createEReference(unitConversionExpressionEClass, UNIT_CONVERSION_EXPRESSION__UNIT);

		parenthesizedExpressionEClass = createEClass(PARENTHESIZED_EXPRESSION);
		createEReference(parenthesizedExpressionEClass, PARENTHESIZED_EXPRESSION__EXPRESSIONS);

		endExpressionEClass = createEClass(END_EXPRESSION);

		rangeExpressionEClass = createEClass(RANGE_EXPRESSION);
		createEReference(rangeExpressionEClass, RANGE_EXPRESSION__OPERANDS);

		binaryExpressionEClass = createEClass(BINARY_EXPRESSION);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__LEFT_OPERAND);
		createEAttribute(binaryExpressionEClass, BINARY_EXPRESSION__OPERATOR);
		createEReference(binaryExpressionEClass, BINARY_EXPRESSION__RIGHT_OPERAND);

		impliesExpressionEClass = createEClass(IMPLIES_EXPRESSION);

		logicalOrExpressionEClass = createEClass(LOGICAL_OR_EXPRESSION);

		logicalAndExpressionEClass = createEClass(LOGICAL_AND_EXPRESSION);

		equalityExpressionEClass = createEClass(EQUALITY_EXPRESSION);

		relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);

		typeTestExpressionEClass = createEClass(TYPE_TEST_EXPRESSION);
		createEReference(typeTestExpressionEClass, TYPE_TEST_EXPRESSION__EXPRESSION);
		createEReference(typeTestExpressionEClass, TYPE_TEST_EXPRESSION__TYPE_SPECIFIER);

		additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);

		multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);

		powerExpressionEClass = createEClass(POWER_EXPRESSION);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATOR);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__OPERAND);

		featureReferenceEClass = createEClass(FEATURE_REFERENCE);
		createEReference(featureReferenceEClass, FEATURE_REFERENCE__FEATURE);
		createEReference(featureReferenceEClass, FEATURE_REFERENCE__STEP_EXPRESSION);

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
		createEReference(functionCallEClass, FUNCTION_CALL__TARGET);
		createEReference(functionCallEClass, FUNCTION_CALL__ARGUMENTS);

		memberVariableAccessEClass = createEClass(MEMBER_VARIABLE_ACCESS);
		createEReference(memberVariableAccessEClass, MEMBER_VARIABLE_ACCESS__TARGET);
		createEAttribute(memberVariableAccessEClass, MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE);

		lambdaExpressionEClass = createEClass(LAMBDA_EXPRESSION);
		createEReference(lambdaExpressionEClass, LAMBDA_EXPRESSION__PARAMETERS);
		createEReference(lambdaExpressionEClass, LAMBDA_EXPRESSION__EXPRESSION);

		lambdaExpressionParameterEClass = createEClass(LAMBDA_EXPRESSION_PARAMETER);

		inspectExpressionEClass = createEClass(INSPECT_EXPRESSION);
		createEReference(inspectExpressionEClass, INSPECT_EXPRESSION__UNION_EXPRESSION);
		createEReference(inspectExpressionEClass, INSPECT_EXPRESSION__WHEN_CLAUSES);

		inspectWhenClauseEClass = createEClass(INSPECT_WHEN_CLAUSE);
		createEReference(inspectWhenClauseEClass, INSPECT_WHEN_CLAUSE__OWNER);
		createEReference(inspectWhenClauseEClass, INSPECT_WHEN_CLAUSE__EXPRESSION);

		algorithmExpressionEClass = createEClass(ALGORITHM_EXPRESSION);
		createEReference(algorithmExpressionEClass, ALGORITHM_EXPRESSION__BODY);

		invalidExpressionEClass = createEClass(INVALID_EXPRESSION);

		compoundStatementEClass = createEClass(COMPOUND_STATEMENT);
		createEReference(compoundStatementEClass, COMPOUND_STATEMENT__STATEMENTS);

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
		createEReference(forStatementEClass, FOR_STATEMENT__BODY);

		iterationVariableDeclarationEClass = createEClass(ITERATION_VARIABLE_DECLARATION);

		continueStatementEClass = createEClass(CONTINUE_STATEMENT);

		breakStatementEClass = createEClass(BREAK_STATEMENT);

		returnStatementEClass = createEClass(RETURN_STATEMENT);
		createEReference(returnStatementEClass, RETURN_STATEMENT__EXPRESSION);

		builtinDeclarationEClass = createEClass(BUILTIN_DECLARATION);

		builtinFunctionDeclarationEClass = createEClass(BUILTIN_FUNCTION_DECLARATION);
		createEAttribute(builtinFunctionDeclarationEClass, BUILTIN_FUNCTION_DECLARATION__NAME);

		typeEClass = createEClass(TYPE);

		invalidTypeEClass = createEClass(INVALID_TYPE);

		anyTypeEClass = createEClass(ANY_TYPE);

		dataTypeEClass = createEClass(DATA_TYPE);

		unitTypeEClass = createEClass(UNIT_TYPE);

		functionTypeEClass = createEClass(FUNCTION_TYPE);

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
		createEReference(arrayTypeEClass, ARRAY_TYPE__DIMENSIONS);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__DIMENSIONALITY);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__DIMENSIONAL);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__MULTIDIMENSIONAL);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__NUMERIC);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__NUMERIC_VECTOR);
		createEAttribute(arrayTypeEClass, ARRAY_TYPE__NUMERIC_MATRIX);

		anonymousArrayTypeEClass = createEClass(ANONYMOUS_ARRAY_TYPE);
		createEReference(anonymousArrayTypeEClass, ANONYMOUS_ARRAY_TYPE__ELEMENT_TYPE);

		declaredArrayTypeEClass = createEClass(DECLARED_ARRAY_TYPE);
		createEReference(declaredArrayTypeEClass, DECLARED_ARRAY_TYPE__ELEMENT_TYPE_DECLARATION);

		arrayDimensionEClass = createEClass(ARRAY_DIMENSION);
		createEReference(arrayDimensionEClass, ARRAY_DIMENSION__SIZE);

		compositeTypeEClass = createEClass(COMPOSITE_TYPE);
		createEAttribute(compositeTypeEClass, COMPOSITE_TYPE__LABEL);
		createEAttribute(compositeTypeEClass, COMPOSITE_TYPE__ANY_LABEL);
		createEReference(compositeTypeEClass, COMPOSITE_TYPE__MEMBER_LISTS);

		compositeTypeMemberListEClass = createEClass(COMPOSITE_TYPE_MEMBER_LIST);
		createEReference(compositeTypeMemberListEClass, COMPOSITE_TYPE_MEMBER_LIST__TYPE_SPECIFIER);
		createEReference(compositeTypeMemberListEClass, COMPOSITE_TYPE_MEMBER_LIST__MEMBERS);

		compositeTypeMemberEClass = createEClass(COMPOSITE_TYPE_MEMBER);
		createEReference(compositeTypeMemberEClass, COMPOSITE_TYPE_MEMBER__OWNER);
		createEAttribute(compositeTypeMemberEClass, COMPOSITE_TYPE_MEMBER__NAME);

		recordTypeEClass = createEClass(RECORD_TYPE);

		unionTypeEClass = createEClass(UNION_TYPE);

		expressionEClass = createEClass(EXPRESSION);

		unitEClass = createEClass(UNIT);
		createEAttribute(unitEClass, UNIT__SCALE);
		createEAttribute(unitEClass, UNIT__ANY);
		createEReference(unitEClass, UNIT__FACTORS);

		unitFactorEClass = createEClass(UNIT_FACTOR);
		createEReference(unitFactorEClass, UNIT_FACTOR__SYMBOL);
		createEAttribute(unitFactorEClass, UNIT_FACTOR__EXPONENT);

		unitDenominatorFactorEClass = createEClass(UNIT_DENOMINATOR_FACTOR);

		unitDeclarationEClass = createEClass(UNIT_DECLARATION);
		createEAttribute(unitDeclarationEClass, UNIT_DECLARATION__NAME);
		createEReference(unitDeclarationEClass, UNIT_DECLARATION__SYMBOLS);

		unitSymbolEClass = createEClass(UNIT_SYMBOL);
		createEReference(unitSymbolEClass, UNIT_SYMBOL__OWNER);
		createEAttribute(unitSymbolEClass, UNIT_SYMBOL__PREFIX);
		createEAttribute(unitSymbolEClass, UNIT_SYMBOL__NAME);
		createEAttribute(unitSymbolEClass, UNIT_SYMBOL__SCALE);

		baseUnitDeclarationEClass = createEClass(BASE_UNIT_DECLARATION);

		derivedUnitDeclarationEClass = createEClass(DERIVED_UNIT_DECLARATION);
		createEReference(derivedUnitDeclarationEClass, DERIVED_UNIT_DECLARATION__DEFINITION);

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
		createEAttribute(stringLiteralEClass, STRING_LITERAL__TEXT);

		templateExpressionEClass = createEClass(TEMPLATE_EXPRESSION);
		createEReference(templateExpressionEClass, TEMPLATE_EXPRESSION__SEGMENTS);

		templateSegmentEClass = createEClass(TEMPLATE_SEGMENT);

		constantTemplateSegmentEClass = createEClass(CONSTANT_TEMPLATE_SEGMENT);
		createEAttribute(constantTemplateSegmentEClass, CONSTANT_TEMPLATE_SEGMENT__TEXT);
		createEAttribute(constantTemplateSegmentEClass, CONSTANT_TEMPLATE_SEGMENT__NORMALIZED_TEXT);

		expressionTemplateSegmentEClass = createEClass(EXPRESSION_TEMPLATE_SEGMENT);
		createEReference(expressionTemplateSegmentEClass, EXPRESSION_TEMPLATE_SEGMENT__EXPRESSION);
		createEAttribute(expressionTemplateSegmentEClass, EXPRESSION_TEMPLATE_SEGMENT__INDENTATION);

		// Create enums
		functionKindEEnum = createEEnum(FUNCTION_KIND);
		assertionStatusKindEEnum = createEEnum(ASSERTION_STATUS_KIND);
		operatorKindEEnum = createEEnum(OPERATOR_KIND);
		unitPrefixEEnum = createEEnum(UNIT_PREFIX);

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
		moduleEClass.getESuperTypes().add(this.getTopLevelContainer());
		typeDeclarationEClass.getESuperTypes().add(this.getTopLevelDeclaration());
		enumerationDeclarationEClass.getESuperTypes().add(this.getTopLevelDeclaration());
		functionDeclarationEClass.getESuperTypes().add(this.getTopLevelDeclaration());
		functionDeclarationEClass.getESuperTypes().add(this.getCallableElement());
		typeCheckArgumentEClass.getESuperTypes().add(this.getCheckArgument());
		expressionCheckArgumentEClass.getESuperTypes().add(this.getCheckArgument());
		callableElementEClass.getESuperTypes().add(this.getEvaluable());
		variableDeclarationEClass.getESuperTypes().add(this.getCallableElement());
		parameterDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		inputParameterDeclarationEClass.getESuperTypes().add(this.getParameterDeclaration());
		outputParameterDeclarationEClass.getESuperTypes().add(this.getParameterDeclaration());
		stateVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		constantDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		constantDeclarationEClass.getESuperTypes().add(this.getTopLevelDeclaration());
		anonymousTypeSpecifierEClass.getESuperTypes().add(this.getTypeSpecifier());
		declaredTypeSpecifierEClass.getESuperTypes().add(this.getTypeSpecifier());
		letExpressionEClass.getESuperTypes().add(this.getExpression());
		letExpressionVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		ifExpressionEClass.getESuperTypes().add(this.getExpression());
		switchExpressionEClass.getESuperTypes().add(this.getExpression());
		arrayElementAccessEClass.getESuperTypes().add(this.getExpression());
		arrayConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
		arrayConcatenationOperatorEClass.getESuperTypes().add(this.getExpression());
		recordConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
		unionConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
		unitConstructionOperatorEClass.getESuperTypes().add(this.getExpression());
		unitConversionExpressionEClass.getESuperTypes().add(this.getExpression());
		parenthesizedExpressionEClass.getESuperTypes().add(this.getExpression());
		endExpressionEClass.getESuperTypes().add(this.getExpression());
		rangeExpressionEClass.getESuperTypes().add(this.getExpression());
		binaryExpressionEClass.getESuperTypes().add(this.getExpression());
		impliesExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		logicalOrExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		logicalAndExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		equalityExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		relationalExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		typeTestExpressionEClass.getESuperTypes().add(this.getExpression());
		additiveExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		multiplicativeExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		powerExpressionEClass.getESuperTypes().add(this.getBinaryExpression());
		unaryExpressionEClass.getESuperTypes().add(this.getExpression());
		featureReferenceEClass.getESuperTypes().add(this.getExpression());
		rangeStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		additiveStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		negateStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		primitiveStepExpressionEClass.getESuperTypes().add(this.getStepExpression());
		stepLiteralEClass.getESuperTypes().add(this.getPrimitiveStepExpression());
		stepNEClass.getESuperTypes().add(this.getPrimitiveStepExpression());
		functionCallEClass.getESuperTypes().add(this.getExpression());
		memberVariableAccessEClass.getESuperTypes().add(this.getExpression());
		lambdaExpressionEClass.getESuperTypes().add(this.getExpression());
		lambdaExpressionParameterEClass.getESuperTypes().add(this.getVariableDeclaration());
		inspectExpressionEClass.getESuperTypes().add(this.getExpression());
		inspectWhenClauseEClass.getESuperTypes().add(this.getVariableDeclaration());
		algorithmExpressionEClass.getESuperTypes().add(this.getExpression());
		invalidExpressionEClass.getESuperTypes().add(this.getExpression());
		compoundStatementEClass.getESuperTypes().add(this.getStatement());
		assignmentEClass.getESuperTypes().add(this.getStatement());
		localVariableDeclarationEClass.getESuperTypes().add(this.getStatement());
		localVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		ifStatementEClass.getESuperTypes().add(this.getStatement());
		whileStatementEClass.getESuperTypes().add(this.getStatement());
		doWhileStatementEClass.getESuperTypes().add(this.getStatement());
		forStatementEClass.getESuperTypes().add(this.getStatement());
		iterationVariableDeclarationEClass.getESuperTypes().add(this.getVariableDeclaration());
		continueStatementEClass.getESuperTypes().add(this.getStatement());
		breakStatementEClass.getESuperTypes().add(this.getStatement());
		returnStatementEClass.getESuperTypes().add(this.getStatement());
		builtinDeclarationEClass.getESuperTypes().add(this.getTopLevelDeclaration());
		builtinDeclarationEClass.getESuperTypes().add(this.getCallableElement());
		builtinFunctionDeclarationEClass.getESuperTypes().add(this.getBuiltinDeclaration());
		invalidTypeEClass.getESuperTypes().add(this.getType());
		anyTypeEClass.getESuperTypes().add(this.getType());
		dataTypeEClass.getESuperTypes().add(this.getType());
		unitTypeEClass.getESuperTypes().add(this.getType());
		functionTypeEClass.getESuperTypes().add(this.getType());
		primitiveTypeEClass.getESuperTypes().add(this.getDataType());
		numericTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		realTypeEClass.getESuperTypes().add(this.getNumericType());
		integerTypeEClass.getESuperTypes().add(this.getNumericType());
		complexTypeEClass.getESuperTypes().add(this.getNumericType());
		gaussianTypeEClass.getESuperTypes().add(this.getNumericType());
		booleanTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		stringTypeEClass.getESuperTypes().add(this.getPrimitiveType());
		arrayTypeEClass.getESuperTypes().add(this.getDataType());
		anonymousArrayTypeEClass.getESuperTypes().add(this.getArrayType());
		declaredArrayTypeEClass.getESuperTypes().add(this.getArrayType());
		compositeTypeEClass.getESuperTypes().add(this.getDataType());
		recordTypeEClass.getESuperTypes().add(this.getCompositeType());
		unionTypeEClass.getESuperTypes().add(this.getCompositeType());
		expressionEClass.getESuperTypes().add(this.getEvaluable());
		unitDenominatorFactorEClass.getESuperTypes().add(this.getUnitFactor());
		unitDeclarationEClass.getESuperTypes().add(this.getTopLevelDeclaration());
		baseUnitDeclarationEClass.getESuperTypes().add(this.getUnitDeclaration());
		derivedUnitDeclarationEClass.getESuperTypes().add(this.getUnitDeclaration());
		literalEClass.getESuperTypes().add(this.getExpression());
		numericLiteralEClass.getESuperTypes().add(this.getLiteral());
		realLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		integerLiteralEClass.getESuperTypes().add(this.getNumericLiteral());
		booleanLiteralEClass.getESuperTypes().add(this.getLiteral());
		stringLiteralEClass.getESuperTypes().add(this.getLiteral());
		templateExpressionEClass.getESuperTypes().add(this.getExpression());
		constantTemplateSegmentEClass.getESuperTypes().add(this.getTemplateSegment());
		expressionTemplateSegmentEClass.getESuperTypes().add(this.getTemplateSegment());

		// Initialize classes and features; add operations and parameters
		initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModule_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModule_ImportDeclarations(), this.getImportDeclaration(), null, "importDeclarations", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importDeclarationEClass, ImportDeclaration.class, "ImportDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportDeclaration_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, ImportDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(topLevelDeclarationEClass, TopLevelDeclaration.class, "TopLevelDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(topLevelDeclarationEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(topLevelContainerEClass, TopLevelContainer.class, "TopLevelContainer", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelContainer_Declarations(), this.getTopLevelDeclaration(), null, "declarations", null, 0, -1, TopLevelContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeDeclarationEClass, TypeDeclaration.class, "TypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeDeclaration_TypeSpecifier(), this.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, TypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationDeclarationEClass, EnumerationDeclaration.class, "EnumerationDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumerationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumerationDeclaration_LiteralDeclarations(), this.getEnumerationLiteralDeclaration(), null, "literalDeclarations", null, 0, -1, EnumerationDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationLiteralDeclarationEClass, EnumerationLiteralDeclaration.class, "EnumerationLiteralDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumerationLiteralDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, EnumerationLiteralDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionDeclarationEClass, FunctionDeclaration.class, "FunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunctionDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFunctionDeclaration_Kind(), this.getFunctionKind(), "kind", null, 0, 1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDeclaration_InputParameterDeclarations(), this.getInputParameterDeclaration(), null, "inputParameterDeclarations", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDeclaration_OutputParameterDeclarations(), this.getOutputParameterDeclaration(), null, "outputParameterDeclarations", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDeclaration_Checks(), this.getCheck(), this.getCheck_Function(), "checks", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDeclaration_Assertions(), this.getAssertion(), null, "assertions", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDeclaration_StateVariableDeclarations(), this.getStateVariableDeclaration(), null, "stateVariableDeclarations", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDeclaration_ConstantDeclarations(), this.getConstantDeclaration(), null, "constantDeclarations", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionDeclaration_Equations(), this.getEquation(), null, "equations", null, 0, -1, FunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(functionDeclarationEClass, this.getInputParameterDeclaration(), "getConstantInputParameterDeclarations", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(functionDeclarationEClass, this.getInputParameterDeclaration(), "getNonConstantInputParameterDeclarations", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(checkEClass, Check.class, "Check", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheck_Function(), this.getFunctionDeclaration(), this.getFunctionDeclaration_Checks(), "function", null, 1, 1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheck_InputArguments(), this.getCheckArgument(), null, "inputArguments", null, 0, -1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCheck_OutputTypeSpecifiers(), this.getTypeSpecifier(), null, "outputTypeSpecifiers", null, 0, -1, Check.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(checkEClass, this.getExpression(), "getExpressionArguments", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(checkEClass, this.getTypeSpecifier(), "getInputTypeSpecifiers", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(checkArgumentEClass, CheckArgument.class, "CheckArgument", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeCheckArgumentEClass, TypeCheckArgument.class, "TypeCheckArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeCheckArgument_TypeSpecifier(), this.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, TypeCheckArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionCheckArgumentEClass, ExpressionCheckArgument.class, "ExpressionCheckArgument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionCheckArgument_Expression(), this.getExpression(), null, "expression", null, 0, 1, ExpressionCheckArgument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(evaluableEClass, Evaluable.class, "Evaluable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callableElementEClass, CallableElement.class, "CallableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(callableElementEClass, ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(callableElementEClass, ecorePackage.getEString(), "getQualifiedName", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(variableDeclarationEClass, VariableDeclaration.class, "VariableDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterDeclarationEClass, ParameterDeclaration.class, "ParameterDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputParameterDeclarationEClass, InputParameterDeclaration.class, "InputParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInputParameterDeclaration_Constant(), ecorePackage.getEBoolean(), "constant", null, 0, 1, InputParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputParameterDeclarationEClass, OutputParameterDeclaration.class, "OutputParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assertionEClass, Assertion.class, "Assertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssertion_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertion_Condition(), this.getExpression(), null, "condition", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssertion_StatusKind(), this.getAssertionStatusKind(), "statusKind", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssertion_Message(), this.getExpression(), null, "message", null, 0, 1, Assertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateVariableDeclarationEClass, StateVariableDeclaration.class, "StateVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantDeclarationEClass, ConstantDeclaration.class, "ConstantDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstantDeclaration_Initializer(), this.getExpression(), null, "initializer", null, 0, 1, ConstantDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(equationEClass, Equation.class, "Equation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEquation_Initial(), ecorePackage.getEBoolean(), "initial", null, 0, 1, Equation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquation_LeftHandSide(), this.getExpression(), null, "leftHandSide", null, 0, 1, Equation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEquation_RightHandSide(), this.getExpression(), null, "rightHandSide", null, 0, 1, Equation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeSpecifierEClass, TypeSpecifier.class, "TypeSpecifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(typeSpecifierEClass, this.getType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(anonymousTypeSpecifierEClass, AnonymousTypeSpecifier.class, "AnonymousTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnonymousTypeSpecifier_Type(), this.getType(), null, "type", null, 0, 1, AnonymousTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declaredTypeSpecifierEClass, DeclaredTypeSpecifier.class, "DeclaredTypeSpecifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclaredTypeSpecifier_TypeDeclaration(), this.getTypeDeclaration(), null, "typeDeclaration", null, 0, 1, DeclaredTypeSpecifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEReference(getSwitchExpression_Cases(), this.getSwitchCase(), this.getSwitchCase_Owner(), "cases", null, 0, -1, SwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchExpression_DefaultExpression(), this.getExpression(), null, "defaultExpression", null, 0, 1, SwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchCaseEClass, SwitchCase.class, "SwitchCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchCase_Owner(), this.getSwitchExpression(), this.getSwitchExpression_Cases(), "owner", null, 0, 1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchCase_CaseExpression(), this.getExpression(), null, "caseExpression", null, 0, 1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchCase_ResultExpression(), this.getExpression(), null, "resultExpression", null, 0, 1, SwitchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayElementAccessEClass, ArrayElementAccess.class, "ArrayElementAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayElementAccess_Array(), this.getExpression(), null, "array", null, 0, 1, ArrayElementAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArrayElementAccess_Subscripts(), this.getArraySubscript(), null, "subscripts", null, 0, -1, ArrayElementAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arraySubscriptEClass, ArraySubscript.class, "ArraySubscript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getArraySubscript_Slice(), ecorePackage.getEBoolean(), "slice", null, 0, 1, ArraySubscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArraySubscript_Expression(), this.getExpression(), null, "expression", null, 0, 1, ArraySubscript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayConstructionOperatorEClass, ArrayConstructionOperator.class, "ArrayConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayConstructionOperator_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ArrayConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayConcatenationOperatorEClass, ArrayConcatenationOperator.class, "ArrayConcatenationOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayConcatenationOperator_Rows(), this.getExpressionList(), null, "rows", null, 0, -1, ArrayConcatenationOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionListEClass, ExpressionList.class, "ExpressionList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionList_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ExpressionList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recordConstructionOperatorEClass, RecordConstructionOperator.class, "RecordConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecordConstructionOperator_Label(), ecorePackage.getEString(), "label", null, 0, 1, RecordConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecordConstructionOperator_Members(), this.getRecordConstructionMember(), null, "members", null, 0, -1, RecordConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(recordConstructionMemberEClass, RecordConstructionMember.class, "RecordConstructionMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecordConstructionMember_Name(), ecorePackage.getEString(), "name", null, 0, 1, RecordConstructionMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRecordConstructionMember_Value(), this.getExpression(), null, "value", null, 0, 1, RecordConstructionMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unionConstructionOperatorEClass, UnionConstructionOperator.class, "UnionConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnionConstructionOperator_Member(), this.getCompositeTypeMember(), null, "member", null, 0, 1, UnionConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnionConstructionOperator_Value(), this.getExpression(), null, "value", null, 0, 1, UnionConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnionConstructionOperator_TypeSpecifier(), this.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, UnionConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitConstructionOperatorEClass, UnitConstructionOperator.class, "UnitConstructionOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitConstructionOperator_Unit(), this.getUnit(), null, "unit", null, 0, 1, UnitConstructionOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitConversionExpressionEClass, UnitConversionExpression.class, "UnitConversionExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitConversionExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, UnitConversionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitConversionExpression_Unit(), this.getUnit(), null, "unit", null, 0, 1, UnitConversionExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parenthesizedExpressionEClass, ParenthesizedExpression.class, "ParenthesizedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParenthesizedExpression_Expressions(), this.getExpression(), null, "expressions", null, 0, -1, ParenthesizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endExpressionEClass, EndExpression.class, "EndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rangeExpressionEClass, RangeExpression.class, "RangeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRangeExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, RangeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(binaryExpressionEClass, BinaryExpression.class, "BinaryExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBinaryExpression_Operator(), this.getOperatorKind(), "operator", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBinaryExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, BinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(impliesExpressionEClass, ImpliesExpression.class, "ImpliesExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicalOrExpressionEClass, LogicalOrExpression.class, "LogicalOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(logicalAndExpressionEClass, LogicalAndExpression.class, "LogicalAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalityExpressionEClass, EqualityExpression.class, "EqualityExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeTestExpressionEClass, TypeTestExpression.class, "TypeTestExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeTestExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, TypeTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeTestExpression_TypeSpecifier(), this.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, TypeTestExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(powerExpressionEClass, PowerExpression.class, "PowerExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnaryExpression_Operator(), this.getOperatorKind(), "operator", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureReferenceEClass, FeatureReference.class, "FeatureReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatureReference_Feature(), this.getCallableElement(), null, "feature", null, 0, 1, FeatureReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeatureReference_StepExpression(), this.getStepExpression(), null, "stepExpression", null, 0, 1, FeatureReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(featureReferenceEClass, ecorePackage.getEBoolean(), "isInitial", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(stepExpressionEClass, StepExpression.class, "StepExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rangeStepExpressionEClass, RangeStepExpression.class, "RangeStepExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRangeStepExpression_Start(), this.getStepExpression(), null, "start", null, 0, 1, RangeStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRangeStepExpression_End(), this.getStepExpression(), null, "end", null, 0, 1, RangeStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additiveStepExpressionEClass, AdditiveStepExpression.class, "AdditiveStepExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAdditiveStepExpression_Operator(), this.getOperatorKind(), "operator", null, 0, 1, AdditiveStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdditiveStepExpression_LeftOperand(), this.getStepExpression(), null, "leftOperand", null, 0, 1, AdditiveStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAdditiveStepExpression_RightOperand(), this.getStepExpression(), null, "rightOperand", null, 0, 1, AdditiveStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(negateStepExpressionEClass, NegateStepExpression.class, "NegateStepExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNegateStepExpression_Operand(), this.getStepExpression(), null, "operand", null, 0, 1, NegateStepExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveStepExpressionEClass, PrimitiveStepExpression.class, "PrimitiveStepExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stepLiteralEClass, StepLiteral.class, "StepLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStepLiteral_Value(), ecorePackage.getEInt(), "value", null, 0, 1, StepLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stepNEClass, StepN.class, "StepN", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionCallEClass, FunctionCall.class, "FunctionCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunctionCall_Target(), this.getExpression(), null, "target", null, 0, 1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunctionCall_Arguments(), this.getExpression(), null, "arguments", null, 0, -1, FunctionCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(functionCallEClass, this.getCallableElement(), "getFeature", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(memberVariableAccessEClass, MemberVariableAccess.class, "MemberVariableAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMemberVariableAccess_Target(), this.getExpression(), null, "target", null, 0, 1, MemberVariableAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMemberVariableAccess_MemberVariable(), ecorePackage.getEString(), "memberVariable", null, 0, 1, MemberVariableAccess.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lambdaExpressionEClass, LambdaExpression.class, "LambdaExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLambdaExpression_Parameters(), this.getLambdaExpressionParameter(), null, "parameters", null, 0, -1, LambdaExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLambdaExpression_Expression(), this.getExpression(), null, "expression", null, 0, 1, LambdaExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lambdaExpressionParameterEClass, LambdaExpressionParameter.class, "LambdaExpressionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inspectExpressionEClass, InspectExpression.class, "InspectExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInspectExpression_UnionExpression(), this.getExpression(), null, "unionExpression", null, 0, 1, InspectExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInspectExpression_WhenClauses(), this.getInspectWhenClause(), this.getInspectWhenClause_Owner(), "whenClauses", null, 0, -1, InspectExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inspectWhenClauseEClass, InspectWhenClause.class, "InspectWhenClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInspectWhenClause_Owner(), this.getInspectExpression(), this.getInspectExpression_WhenClauses(), "owner", null, 0, 1, InspectWhenClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInspectWhenClause_Expression(), this.getExpression(), null, "expression", null, 0, 1, InspectWhenClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(algorithmExpressionEClass, AlgorithmExpression.class, "AlgorithmExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlgorithmExpression_Body(), this.getCompoundStatement(), null, "body", null, 0, 1, AlgorithmExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invalidExpressionEClass, InvalidExpression.class, "InvalidExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundStatementEClass, CompoundStatement.class, "CompoundStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundStatement_Statements(), this.getStatement(), null, "statements", null, 0, -1, CompoundStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(compoundStatementEClass, this.getLocalVariableDeclaration(), "getLocalVariableDeclarations", 0, -1, IS_UNIQUE, IS_ORDERED);

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
		initEReference(getForStatement_Body(), this.getStatement(), null, "body", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iterationVariableDeclarationEClass, IterationVariableDeclaration.class, "IterationVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continueStatementEClass, ContinueStatement.class, "ContinueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReturnStatement_Expression(), this.getExpression(), null, "expression", null, 0, 1, ReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(builtinDeclarationEClass, BuiltinDeclaration.class, "BuiltinDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(builtinFunctionDeclarationEClass, BuiltinFunctionDeclaration.class, "BuiltinFunctionDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBuiltinFunctionDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, BuiltinFunctionDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(typeEClass, this.getType(), "evaluate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorKind(), "operator", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "other", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(typeEClass, this.getType(), "evaluate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOperatorKind(), "operator", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "n", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(typeEClass, ecorePackage.getEBoolean(), "isAssignableFrom", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(typeEClass, ecorePackage.getEBoolean(), "isEquivalentTo", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "other", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(invalidTypeEClass, InvalidType.class, "InvalidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(anyTypeEClass, AnyType.class, "AnyType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unitTypeEClass, UnitType.class, "UnitType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionTypeEClass, FunctionType.class, "FunctionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericTypeEClass, NumericType.class, "NumericType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNumericType_Unit(), this.getUnit(), null, "unit", null, 1, 1, NumericType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(realTypeEClass, RealType.class, "RealType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexTypeEClass, ComplexType.class, "ComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(gaussianTypeEClass, GaussianType.class, "GaussianType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(arrayTypeEClass, ArrayType.class, "ArrayType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayType_Dimensions(), this.getArrayDimension(), null, "dimensions", null, 0, -1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_Dimensionality(), ecorePackage.getEInt(), "dimensionality", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_Dimensional(), ecorePackage.getEBoolean(), "dimensional", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_Multidimensional(), ecorePackage.getEBoolean(), "multidimensional", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_Numeric(), ecorePackage.getEBoolean(), "numeric", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_NumericVector(), ecorePackage.getEBoolean(), "numericVector", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getArrayType_NumericMatrix(), ecorePackage.getEBoolean(), "numericMatrix", null, 1, 1, ArrayType.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(arrayTypeEClass, this.getType(), "getElementType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(anonymousArrayTypeEClass, AnonymousArrayType.class, "AnonymousArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnonymousArrayType_ElementType(), this.getType(), null, "elementType", null, 0, 1, AnonymousArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declaredArrayTypeEClass, DeclaredArrayType.class, "DeclaredArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeclaredArrayType_ElementTypeDeclaration(), this.getTypeDeclaration(), null, "elementTypeDeclaration", null, 0, 1, DeclaredArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arrayDimensionEClass, ArrayDimension.class, "ArrayDimension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArrayDimension_Size(), this.getExpression(), null, "size", null, 0, 1, ArrayDimension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeTypeEClass, CompositeType.class, "CompositeType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompositeType_Label(), ecorePackage.getEString(), "label", null, 0, 1, CompositeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeType_AnyLabel(), ecorePackage.getEBoolean(), "anyLabel", null, 0, 1, CompositeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeType_MemberLists(), this.getCompositeTypeMemberList(), null, "memberLists", null, 0, -1, CompositeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(compositeTypeEClass, this.getCompositeTypeMember(), "getMembers", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(compositeTypeEClass, this.getCompositeTypeMember(), "getMember", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(compositeTypeEClass, ecorePackage.getEInt(), "getMemberIndex", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(compositeTypeMemberListEClass, CompositeTypeMemberList.class, "CompositeTypeMemberList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeTypeMemberList_TypeSpecifier(), this.getTypeSpecifier(), null, "typeSpecifier", null, 0, 1, CompositeTypeMemberList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCompositeTypeMemberList_Members(), this.getCompositeTypeMember(), this.getCompositeTypeMember_Owner(), "members", null, 0, -1, CompositeTypeMemberList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeTypeMemberEClass, CompositeTypeMember.class, "CompositeTypeMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeTypeMember_Owner(), this.getCompositeTypeMemberList(), this.getCompositeTypeMemberList_Members(), "owner", null, 0, 1, CompositeTypeMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCompositeTypeMember_Name(), ecorePackage.getEString(), "name", null, 0, 1, CompositeTypeMember.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(compositeTypeMemberEClass, this.getType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(recordTypeEClass, RecordType.class, "RecordType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unionTypeEClass, UnionType.class, "UnionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unitEClass, Unit.class, "Unit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnit_Scale(), ecorePackage.getEInt(), "scale", null, 1, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnit_Any(), ecorePackage.getEBoolean(), "any", null, 1, 1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnit_Factors(), this.getUnitFactor(), null, "factors", null, 0, -1, Unit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(unitEClass, this.getUnitFactor(), "getFactor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "symbolName", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(unitEClass, this.getUnitFactor(), "getFactor", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUnitSymbol(), "symbol", 1, 1, IS_UNIQUE, IS_ORDERED);

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

		initEClass(unitFactorEClass, UnitFactor.class, "UnitFactor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitFactor_Symbol(), this.getUnitSymbol(), null, "symbol", null, 0, 1, UnitFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitFactor_Exponent(), ecorePackage.getEInt(), "exponent", "1", 0, 1, UnitFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unitDenominatorFactorEClass, UnitDenominatorFactor.class, "UnitDenominatorFactor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unitDeclarationEClass, UnitDeclaration.class, "UnitDeclaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnitDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, UnitDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUnitDeclaration_Symbols(), this.getUnitSymbol(), this.getUnitSymbol_Owner(), "symbols", null, 0, -1, UnitDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(unitDeclarationEClass, this.getUnitSymbol(), "getSymbol", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getUnitPrefix(), "prefix", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(unitSymbolEClass, UnitSymbol.class, "UnitSymbol", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnitSymbol_Owner(), this.getUnitDeclaration(), this.getUnitDeclaration_Symbols(), "owner", null, 0, 1, UnitSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitSymbol_Prefix(), this.getUnitPrefix(), "prefix", null, 0, 1, UnitSymbol.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitSymbol_Name(), ecorePackage.getEString(), "name", null, 0, 1, UnitSymbol.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnitSymbol_Scale(), ecorePackage.getEInt(), "scale", null, 0, 1, UnitSymbol.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(baseUnitDeclarationEClass, BaseUnitDeclaration.class, "BaseUnitDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(derivedUnitDeclarationEClass, DerivedUnitDeclaration.class, "DerivedUnitDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDerivedUnitDeclaration_Definition(), this.getUnit(), null, "definition", null, 0, 1, DerivedUnitDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEAttribute(getStringLiteral_Text(), ecorePackage.getEString(), "text", null, 0, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(templateExpressionEClass, TemplateExpression.class, "TemplateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateExpression_Segments(), this.getTemplateSegment(), null, "segments", null, 0, -1, TemplateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(templateExpressionEClass, null, "normalizeSegments", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(templateSegmentEClass, TemplateSegment.class, "TemplateSegment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantTemplateSegmentEClass, ConstantTemplateSegment.class, "ConstantTemplateSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstantTemplateSegment_Text(), ecorePackage.getEString(), "text", null, 0, 1, ConstantTemplateSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstantTemplateSegment_NormalizedText(), ecorePackage.getEString(), "normalizedText", null, 0, 1, ConstantTemplateSegment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionTemplateSegmentEClass, ExpressionTemplateSegment.class, "ExpressionTemplateSegment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionTemplateSegment_Expression(), this.getExpression(), null, "expression", null, 0, 1, ExpressionTemplateSegment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExpressionTemplateSegment_Indentation(), ecorePackage.getEString(), "indentation", null, 0, 1, ExpressionTemplateSegment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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

		initEEnum(operatorKindEEnum, OperatorKind.class, "OperatorKind");
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ADD);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.SUBTRACT);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_ADD);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_SUBTRACT);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.MULTIPLY);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.DIVIDE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.MODULO);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_MULTIPLY);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_DIVIDE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_MODULO);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.NEGATE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.POWER);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ELEMENT_WISE_POWER);
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
		addEEnumLiteral(operatorKindEEnum, OperatorKind.DERIVATIVE);
		addEEnumLiteral(operatorKindEEnum, OperatorKind.ROOT);

		initEEnum(unitPrefixEEnum, UnitPrefix.class, "UnitPrefix");
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.NONE);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.DECA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.HECTO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.KILO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.MEGA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.GIGA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.TERA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.PETA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.EXA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.ZETTA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.YOTTA);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.DECI);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.CENTI);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.MILLI);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.MICRO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.NANO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.PICO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.FEMTO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.ATTO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.ZEPTO);
		addEEnumLiteral(unitPrefixEEnum, UnitPrefix.YOCTO);

		// Initialize data types
		initEDataType(realDataEDataType, RealData.class, "RealData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerDataEDataType, IntegerData.class, "IntegerData", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //MscriptPackageImpl
