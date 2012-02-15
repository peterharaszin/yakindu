/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.yakindu.base.types.TypesPackage;

import org.yakindu.sct.model.sgraph.SGraphPackage;

import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression;
import org.yakindu.sct.model.stext.stext.AdditiveOperator;
import org.yakindu.sct.model.stext.stext.AlwaysEvent;
import org.yakindu.sct.model.stext.stext.Assignment;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression;
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression;
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression;
import org.yakindu.sct.model.stext.stext.BoolLiteral;
import org.yakindu.sct.model.stext.stext.BuiltinEventSpec;
import org.yakindu.sct.model.stext.stext.ConditionalExpression;
import org.yakindu.sct.model.stext.stext.DefRoot;
import org.yakindu.sct.model.stext.stext.DefaultEvent;
import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.Entrypoint;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.EventDerivation;
import org.yakindu.sct.model.stext.stext.EventRaising;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.ExitPointSpec;
import org.yakindu.sct.model.stext.stext.Exitpoint;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.HexLiteral;
import org.yakindu.sct.model.stext.stext.IntLiteral;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.Literal;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.LogicalAndExpression;
import org.yakindu.sct.model.stext.stext.LogicalNotExpression;
import org.yakindu.sct.model.stext.stext.LogicalOrExpression;
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression;
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator;
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression;
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression;
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression;
import org.yakindu.sct.model.stext.stext.OnCycleEvent;
import org.yakindu.sct.model.stext.stext.Operation;
import org.yakindu.sct.model.stext.stext.OperationCall;
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionProperties;
import org.yakindu.sct.model.stext.stext.ReactionProperty;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.RealLiteral;
import org.yakindu.sct.model.stext.stext.RegularEventSpec;
import org.yakindu.sct.model.stext.stext.RelationalOperator;
import org.yakindu.sct.model.stext.stext.Root;
import org.yakindu.sct.model.stext.stext.ShiftExpression;
import org.yakindu.sct.model.stext.stext.ShiftOperator;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StateRoot;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.StatechartRoot;
import org.yakindu.sct.model.stext.stext.StatechartScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TimeEventSpec;
import org.yakindu.sct.model.stext.stext.TimeEventType;
import org.yakindu.sct.model.stext.stext.TimeUnit;
import org.yakindu.sct.model.stext.stext.TransitionReaction;
import org.yakindu.sct.model.stext.stext.TransitionRoot;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;
import org.yakindu.sct.model.stext.stext.UnaryOperator;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class StextPackageImpl extends EPackageImpl implements StextPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statechartRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statechartSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statechartScopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass interfaceScopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass internalScopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventDerivationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localReactionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionReactionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reactionPropertiesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reactionPropertyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryPointSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exitPointSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass regularEventSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeEventSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass builtinEventSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entryEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exitEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass onCycleEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass alwaysEventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defaultEventEClass = null;

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
  private EClass eventRaisingEClass = null;

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
  private EClass elementReferenceExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventValueReferenceExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass activeStateReferenceExpressionEClass = null;

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
  private EClass boolLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass intLiteralEClass = null;

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
  private EClass hexLiteralEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simpleScopeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass entrypointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exitpointEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reactionTriggerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reactionEffectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExpressionEClass = null;

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
  private EClass logicalNotExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseXorExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseOrExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bitwiseAndExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass logicalRelationExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass shiftExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalAddSubtractExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalMultiplyDivideExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numericalUnaryExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveValueExpressionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum directionEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum timeEventTypeEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum assignmentOperatorEEnum = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum shiftOperatorEEnum = null;

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
  private EEnum unaryOperatorEEnum = null;

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
  private EEnum timeUnitEEnum = null;

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
   * @see org.yakindu.sct.model.stext.stext.StextPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private StextPackageImpl()
  {
    super(eNS_URI, StextFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link StextPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static StextPackage init()
  {
    if (isInited) return (StextPackage)EPackage.Registry.INSTANCE.getEPackage(StextPackage.eNS_URI);

    // Obtain or create and register package
    StextPackageImpl theStextPackage = (StextPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof StextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new StextPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    TypesPackage.eINSTANCE.eClass();
    SGraphPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theStextPackage.createPackageContents();

    // Initialize created meta-data
    theStextPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theStextPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(StextPackage.eNS_URI, theStextPackage);
    return theStextPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRoot()
  {
    return rootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRoot_Roots()
  {
    return (EReference)rootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefRoot()
  {
    return defRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatechartRoot()
  {
    return statechartRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatechartRoot_Def()
  {
    return (EReference)statechartRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateRoot()
  {
    return stateRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateRoot_Def()
  {
    return (EReference)stateRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionRoot()
  {
    return transitionRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionRoot_Def()
  {
    return (EReference)transitionRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatechartSpecification()
  {
    return statechartSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStatechartSpecification_Namespace()
  {
    return (EAttribute)statechartSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatechartSpecification_DefinitionScopes()
  {
    return (EReference)statechartSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStateSpecification()
  {
    return stateSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStateSpecification_Scope()
  {
    return (EReference)stateSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionSpecification()
  {
    return transitionSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionSpecification_Reaction()
  {
    return (EReference)transitionSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatechartScope()
  {
    return statechartScopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInterfaceScope()
  {
    return interfaceScopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInternalScope()
  {
    return internalScopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventDefinition()
  {
    return eventDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEventDefinition_Direction()
  {
    return (EAttribute)eventDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDefinition_Derivation()
  {
    return (EReference)eventDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventDerivation()
  {
    return eventDerivationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDerivation_Condition()
  {
    return (EReference)eventDerivationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventDerivation_Value()
  {
    return (EReference)eventDerivationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalReaction()
  {
    return localReactionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalReaction_Properties()
  {
    return (EReference)localReactionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransitionReaction()
  {
    return transitionReactionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransitionReaction_Properties()
  {
    return (EReference)transitionReactionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReactionProperties()
  {
    return reactionPropertiesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReactionProperties_Properties()
  {
    return (EReference)reactionPropertiesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReactionProperty()
  {
    return reactionPropertyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntryPointSpec()
  {
    return entryPointSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEntryPointSpec_Entrypoint()
  {
    return (EReference)entryPointSpecEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExitPointSpec()
  {
    return exitPointSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExitPointSpec_Exitpoint()
  {
    return (EReference)exitPointSpecEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventSpec()
  {
    return eventSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRegularEventSpec()
  {
    return regularEventSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRegularEventSpec_Event()
  {
    return (EReference)regularEventSpecEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeEventSpec()
  {
    return timeEventSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeEventSpec_Type()
  {
    return (EAttribute)timeEventSpecEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeEventSpec_Value()
  {
    return (EAttribute)timeEventSpecEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeEventSpec_Unit()
  {
    return (EAttribute)timeEventSpecEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBuiltinEventSpec()
  {
    return builtinEventSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntryEvent()
  {
    return entryEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExitEvent()
  {
    return exitEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOnCycleEvent()
  {
    return onCycleEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAlwaysEvent()
  {
    return alwaysEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefaultEvent()
  {
    return defaultEventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignment()
  {
    return assignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_VarRef()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAssignment_Operator()
  {
    return (EAttribute)assignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignment_Expression()
  {
    return (EReference)assignmentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventRaising()
  {
    return eventRaisingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventRaising_Event()
  {
    return (EReference)eventRaisingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventRaising_Value()
  {
    return (EReference)eventRaisingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpression()
  {
    return expressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElementReferenceExpression()
  {
    return elementReferenceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElementReferenceExpression_Value()
  {
    return (EReference)elementReferenceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEventValueReferenceExpression()
  {
    return eventValueReferenceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEventValueReferenceExpression_Value()
  {
    return (EReference)eventValueReferenceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActiveStateReferenceExpression()
  {
    return activeStateReferenceExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActiveStateReferenceExpression_Value()
  {
    return (EReference)activeStateReferenceExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLiteral()
  {
    return literalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolLiteral()
  {
    return boolLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBoolLiteral_Value()
  {
    return (EAttribute)boolLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntLiteral()
  {
    return intLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntLiteral_Value()
  {
    return (EAttribute)intLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRealLiteral()
  {
    return realLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRealLiteral_Value()
  {
    return (EAttribute)realLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHexLiteral()
  {
    return hexLiteralEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getHexLiteral_Value()
  {
    return (EAttribute)hexLiteralEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimpleScope()
  {
    return simpleScopeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDefinition()
  {
    return variableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDefinition_Readonly()
  {
    return (EAttribute)variableDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDefinition_External()
  {
    return (EAttribute)variableDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDefinition_Type()
  {
    return (EReference)variableDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDefinition_InitialValue()
  {
    return (EReference)variableDefinitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperation()
  {
    return operationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_ParamTypes()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperation_Type()
  {
    return (EReference)operationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEntrypoint()
  {
    return entrypointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExitpoint()
  {
    return exitpointEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReactionTrigger()
  {
    return reactionTriggerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReactionTrigger_Triggers()
  {
    return (EReference)reactionTriggerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReactionTrigger_GuardExpression()
  {
    return (EReference)reactionTriggerEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReactionEffect()
  {
    return reactionEffectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReactionEffect_Actions()
  {
    return (EReference)reactionEffectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpression()
  {
    return conditionalExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_Condition()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_TrueCase()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpression_FalseCase()
  {
    return (EReference)conditionalExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalOrExpression()
  {
    return logicalOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalOrExpression_LeftOperand()
  {
    return (EReference)logicalOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalOrExpression_RightOperand()
  {
    return (EReference)logicalOrExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalAndExpression()
  {
    return logicalAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalAndExpression_LeftOperand()
  {
    return (EReference)logicalAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalAndExpression_RightOperand()
  {
    return (EReference)logicalAndExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalNotExpression()
  {
    return logicalNotExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalNotExpression_Operand()
  {
    return (EReference)logicalNotExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseXorExpression()
  {
    return bitwiseXorExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseXorExpression_LeftOperand()
  {
    return (EReference)bitwiseXorExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseXorExpression_RightOperand()
  {
    return (EReference)bitwiseXorExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseOrExpression()
  {
    return bitwiseOrExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseOrExpression_LeftOperand()
  {
    return (EReference)bitwiseOrExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseOrExpression_RightOperand()
  {
    return (EReference)bitwiseOrExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBitwiseAndExpression()
  {
    return bitwiseAndExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseAndExpression_LeftOperand()
  {
    return (EReference)bitwiseAndExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBitwiseAndExpression_RightOperand()
  {
    return (EReference)bitwiseAndExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLogicalRelationExpression()
  {
    return logicalRelationExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalRelationExpression_LeftOperand()
  {
    return (EReference)logicalRelationExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLogicalRelationExpression_Operator()
  {
    return (EAttribute)logicalRelationExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLogicalRelationExpression_RightOperand()
  {
    return (EReference)logicalRelationExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getShiftExpression()
  {
    return shiftExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_LeftOperand()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getShiftExpression_Operator()
  {
    return (EAttribute)shiftExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getShiftExpression_RightOperand()
  {
    return (EReference)shiftExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalAddSubtractExpression()
  {
    return numericalAddSubtractExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalAddSubtractExpression_LeftOperand()
  {
    return (EReference)numericalAddSubtractExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericalAddSubtractExpression_Operator()
  {
    return (EAttribute)numericalAddSubtractExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalAddSubtractExpression_RightOperand()
  {
    return (EReference)numericalAddSubtractExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalMultiplyDivideExpression()
  {
    return numericalMultiplyDivideExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalMultiplyDivideExpression_LeftOperand()
  {
    return (EReference)numericalMultiplyDivideExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericalMultiplyDivideExpression_Operator()
  {
    return (EAttribute)numericalMultiplyDivideExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalMultiplyDivideExpression_RightOperand()
  {
    return (EReference)numericalMultiplyDivideExpressionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumericalUnaryExpression()
  {
    return numericalUnaryExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNumericalUnaryExpression_Operator()
  {
    return (EAttribute)numericalUnaryExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumericalUnaryExpression_Operand()
  {
    return (EReference)numericalUnaryExpressionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitiveValueExpression()
  {
    return primitiveValueExpressionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrimitiveValueExpression_Value()
  {
    return (EReference)primitiveValueExpressionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationCall()
  {
    return operationCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationCall_Operation()
  {
    return (EReference)operationCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationCall_Args()
  {
    return (EReference)operationCallEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getDirection()
  {
    return directionEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTimeEventType()
  {
    return timeEventTypeEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAssignmentOperator()
  {
    return assignmentOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getShiftOperator()
  {
    return shiftOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getAdditiveOperator()
  {
    return additiveOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getMultiplicativeOperator()
  {
    return multiplicativeOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getUnaryOperator()
  {
    return unaryOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getRelationalOperator()
  {
    return relationalOperatorEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getTimeUnit()
  {
    return timeUnitEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StextFactory getStextFactory()
  {
    return (StextFactory)getEFactoryInstance();
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
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    rootEClass = createEClass(ROOT);
    createEReference(rootEClass, ROOT__ROOTS);

    defRootEClass = createEClass(DEF_ROOT);

    statechartRootEClass = createEClass(STATECHART_ROOT);
    createEReference(statechartRootEClass, STATECHART_ROOT__DEF);

    stateRootEClass = createEClass(STATE_ROOT);
    createEReference(stateRootEClass, STATE_ROOT__DEF);

    transitionRootEClass = createEClass(TRANSITION_ROOT);
    createEReference(transitionRootEClass, TRANSITION_ROOT__DEF);

    statechartSpecificationEClass = createEClass(STATECHART_SPECIFICATION);
    createEAttribute(statechartSpecificationEClass, STATECHART_SPECIFICATION__NAMESPACE);
    createEReference(statechartSpecificationEClass, STATECHART_SPECIFICATION__DEFINITION_SCOPES);

    stateSpecificationEClass = createEClass(STATE_SPECIFICATION);
    createEReference(stateSpecificationEClass, STATE_SPECIFICATION__SCOPE);

    transitionSpecificationEClass = createEClass(TRANSITION_SPECIFICATION);
    createEReference(transitionSpecificationEClass, TRANSITION_SPECIFICATION__REACTION);

    statechartScopeEClass = createEClass(STATECHART_SCOPE);

    interfaceScopeEClass = createEClass(INTERFACE_SCOPE);

    internalScopeEClass = createEClass(INTERNAL_SCOPE);

    eventDefinitionEClass = createEClass(EVENT_DEFINITION);
    createEAttribute(eventDefinitionEClass, EVENT_DEFINITION__DIRECTION);
    createEReference(eventDefinitionEClass, EVENT_DEFINITION__DERIVATION);

    eventDerivationEClass = createEClass(EVENT_DERIVATION);
    createEReference(eventDerivationEClass, EVENT_DERIVATION__CONDITION);
    createEReference(eventDerivationEClass, EVENT_DERIVATION__VALUE);

    localReactionEClass = createEClass(LOCAL_REACTION);
    createEReference(localReactionEClass, LOCAL_REACTION__PROPERTIES);

    transitionReactionEClass = createEClass(TRANSITION_REACTION);
    createEReference(transitionReactionEClass, TRANSITION_REACTION__PROPERTIES);

    reactionPropertiesEClass = createEClass(REACTION_PROPERTIES);
    createEReference(reactionPropertiesEClass, REACTION_PROPERTIES__PROPERTIES);

    reactionPropertyEClass = createEClass(REACTION_PROPERTY);

    entryPointSpecEClass = createEClass(ENTRY_POINT_SPEC);
    createEReference(entryPointSpecEClass, ENTRY_POINT_SPEC__ENTRYPOINT);

    exitPointSpecEClass = createEClass(EXIT_POINT_SPEC);
    createEReference(exitPointSpecEClass, EXIT_POINT_SPEC__EXITPOINT);

    eventSpecEClass = createEClass(EVENT_SPEC);

    regularEventSpecEClass = createEClass(REGULAR_EVENT_SPEC);
    createEReference(regularEventSpecEClass, REGULAR_EVENT_SPEC__EVENT);

    timeEventSpecEClass = createEClass(TIME_EVENT_SPEC);
    createEAttribute(timeEventSpecEClass, TIME_EVENT_SPEC__TYPE);
    createEAttribute(timeEventSpecEClass, TIME_EVENT_SPEC__VALUE);
    createEAttribute(timeEventSpecEClass, TIME_EVENT_SPEC__UNIT);

    builtinEventSpecEClass = createEClass(BUILTIN_EVENT_SPEC);

    entryEventEClass = createEClass(ENTRY_EVENT);

    exitEventEClass = createEClass(EXIT_EVENT);

    onCycleEventEClass = createEClass(ON_CYCLE_EVENT);

    alwaysEventEClass = createEClass(ALWAYS_EVENT);

    defaultEventEClass = createEClass(DEFAULT_EVENT);

    assignmentEClass = createEClass(ASSIGNMENT);
    createEReference(assignmentEClass, ASSIGNMENT__VAR_REF);
    createEAttribute(assignmentEClass, ASSIGNMENT__OPERATOR);
    createEReference(assignmentEClass, ASSIGNMENT__EXPRESSION);

    eventRaisingEClass = createEClass(EVENT_RAISING);
    createEReference(eventRaisingEClass, EVENT_RAISING__EVENT);
    createEReference(eventRaisingEClass, EVENT_RAISING__VALUE);

    expressionEClass = createEClass(EXPRESSION);

    elementReferenceExpressionEClass = createEClass(ELEMENT_REFERENCE_EXPRESSION);
    createEReference(elementReferenceExpressionEClass, ELEMENT_REFERENCE_EXPRESSION__VALUE);

    eventValueReferenceExpressionEClass = createEClass(EVENT_VALUE_REFERENCE_EXPRESSION);
    createEReference(eventValueReferenceExpressionEClass, EVENT_VALUE_REFERENCE_EXPRESSION__VALUE);

    activeStateReferenceExpressionEClass = createEClass(ACTIVE_STATE_REFERENCE_EXPRESSION);
    createEReference(activeStateReferenceExpressionEClass, ACTIVE_STATE_REFERENCE_EXPRESSION__VALUE);

    literalEClass = createEClass(LITERAL);

    boolLiteralEClass = createEClass(BOOL_LITERAL);
    createEAttribute(boolLiteralEClass, BOOL_LITERAL__VALUE);

    intLiteralEClass = createEClass(INT_LITERAL);
    createEAttribute(intLiteralEClass, INT_LITERAL__VALUE);

    realLiteralEClass = createEClass(REAL_LITERAL);
    createEAttribute(realLiteralEClass, REAL_LITERAL__VALUE);

    hexLiteralEClass = createEClass(HEX_LITERAL);
    createEAttribute(hexLiteralEClass, HEX_LITERAL__VALUE);

    simpleScopeEClass = createEClass(SIMPLE_SCOPE);

    variableDefinitionEClass = createEClass(VARIABLE_DEFINITION);
    createEAttribute(variableDefinitionEClass, VARIABLE_DEFINITION__READONLY);
    createEAttribute(variableDefinitionEClass, VARIABLE_DEFINITION__EXTERNAL);
    createEReference(variableDefinitionEClass, VARIABLE_DEFINITION__TYPE);
    createEReference(variableDefinitionEClass, VARIABLE_DEFINITION__INITIAL_VALUE);

    operationEClass = createEClass(OPERATION);
    createEReference(operationEClass, OPERATION__PARAM_TYPES);
    createEReference(operationEClass, OPERATION__TYPE);

    entrypointEClass = createEClass(ENTRYPOINT);

    exitpointEClass = createEClass(EXITPOINT);

    reactionTriggerEClass = createEClass(REACTION_TRIGGER);
    createEReference(reactionTriggerEClass, REACTION_TRIGGER__TRIGGERS);
    createEReference(reactionTriggerEClass, REACTION_TRIGGER__GUARD_EXPRESSION);

    reactionEffectEClass = createEClass(REACTION_EFFECT);
    createEReference(reactionEffectEClass, REACTION_EFFECT__ACTIONS);

    conditionalExpressionEClass = createEClass(CONDITIONAL_EXPRESSION);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__CONDITION);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__TRUE_CASE);
    createEReference(conditionalExpressionEClass, CONDITIONAL_EXPRESSION__FALSE_CASE);

    logicalOrExpressionEClass = createEClass(LOGICAL_OR_EXPRESSION);
    createEReference(logicalOrExpressionEClass, LOGICAL_OR_EXPRESSION__LEFT_OPERAND);
    createEReference(logicalOrExpressionEClass, LOGICAL_OR_EXPRESSION__RIGHT_OPERAND);

    logicalAndExpressionEClass = createEClass(LOGICAL_AND_EXPRESSION);
    createEReference(logicalAndExpressionEClass, LOGICAL_AND_EXPRESSION__LEFT_OPERAND);
    createEReference(logicalAndExpressionEClass, LOGICAL_AND_EXPRESSION__RIGHT_OPERAND);

    logicalNotExpressionEClass = createEClass(LOGICAL_NOT_EXPRESSION);
    createEReference(logicalNotExpressionEClass, LOGICAL_NOT_EXPRESSION__OPERAND);

    bitwiseXorExpressionEClass = createEClass(BITWISE_XOR_EXPRESSION);
    createEReference(bitwiseXorExpressionEClass, BITWISE_XOR_EXPRESSION__LEFT_OPERAND);
    createEReference(bitwiseXorExpressionEClass, BITWISE_XOR_EXPRESSION__RIGHT_OPERAND);

    bitwiseOrExpressionEClass = createEClass(BITWISE_OR_EXPRESSION);
    createEReference(bitwiseOrExpressionEClass, BITWISE_OR_EXPRESSION__LEFT_OPERAND);
    createEReference(bitwiseOrExpressionEClass, BITWISE_OR_EXPRESSION__RIGHT_OPERAND);

    bitwiseAndExpressionEClass = createEClass(BITWISE_AND_EXPRESSION);
    createEReference(bitwiseAndExpressionEClass, BITWISE_AND_EXPRESSION__LEFT_OPERAND);
    createEReference(bitwiseAndExpressionEClass, BITWISE_AND_EXPRESSION__RIGHT_OPERAND);

    logicalRelationExpressionEClass = createEClass(LOGICAL_RELATION_EXPRESSION);
    createEReference(logicalRelationExpressionEClass, LOGICAL_RELATION_EXPRESSION__LEFT_OPERAND);
    createEAttribute(logicalRelationExpressionEClass, LOGICAL_RELATION_EXPRESSION__OPERATOR);
    createEReference(logicalRelationExpressionEClass, LOGICAL_RELATION_EXPRESSION__RIGHT_OPERAND);

    shiftExpressionEClass = createEClass(SHIFT_EXPRESSION);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__LEFT_OPERAND);
    createEAttribute(shiftExpressionEClass, SHIFT_EXPRESSION__OPERATOR);
    createEReference(shiftExpressionEClass, SHIFT_EXPRESSION__RIGHT_OPERAND);

    numericalAddSubtractExpressionEClass = createEClass(NUMERICAL_ADD_SUBTRACT_EXPRESSION);
    createEReference(numericalAddSubtractExpressionEClass, NUMERICAL_ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND);
    createEAttribute(numericalAddSubtractExpressionEClass, NUMERICAL_ADD_SUBTRACT_EXPRESSION__OPERATOR);
    createEReference(numericalAddSubtractExpressionEClass, NUMERICAL_ADD_SUBTRACT_EXPRESSION__RIGHT_OPERAND);

    numericalMultiplyDivideExpressionEClass = createEClass(NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION);
    createEReference(numericalMultiplyDivideExpressionEClass, NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND);
    createEAttribute(numericalMultiplyDivideExpressionEClass, NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR);
    createEReference(numericalMultiplyDivideExpressionEClass, NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND);

    numericalUnaryExpressionEClass = createEClass(NUMERICAL_UNARY_EXPRESSION);
    createEAttribute(numericalUnaryExpressionEClass, NUMERICAL_UNARY_EXPRESSION__OPERATOR);
    createEReference(numericalUnaryExpressionEClass, NUMERICAL_UNARY_EXPRESSION__OPERAND);

    primitiveValueExpressionEClass = createEClass(PRIMITIVE_VALUE_EXPRESSION);
    createEReference(primitiveValueExpressionEClass, PRIMITIVE_VALUE_EXPRESSION__VALUE);

    operationCallEClass = createEClass(OPERATION_CALL);
    createEReference(operationCallEClass, OPERATION_CALL__OPERATION);
    createEReference(operationCallEClass, OPERATION_CALL__ARGS);

    // Create enums
    directionEEnum = createEEnum(DIRECTION);
    timeEventTypeEEnum = createEEnum(TIME_EVENT_TYPE);
    assignmentOperatorEEnum = createEEnum(ASSIGNMENT_OPERATOR);
    shiftOperatorEEnum = createEEnum(SHIFT_OPERATOR);
    additiveOperatorEEnum = createEEnum(ADDITIVE_OPERATOR);
    multiplicativeOperatorEEnum = createEEnum(MULTIPLICATIVE_OPERATOR);
    unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
    relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
    timeUnitEEnum = createEEnum(TIME_UNIT);
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
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    SGraphPackage theSGraphPackage = (SGraphPackage)EPackage.Registry.INSTANCE.getEPackage(SGraphPackage.eNS_URI);
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    statechartRootEClass.getESuperTypes().add(this.getDefRoot());
    stateRootEClass.getESuperTypes().add(this.getDefRoot());
    transitionRootEClass.getESuperTypes().add(this.getDefRoot());
    statechartScopeEClass.getESuperTypes().add(theSGraphPackage.getScope());
    statechartScopeEClass.getESuperTypes().add(theTypesPackage.getType());
    interfaceScopeEClass.getESuperTypes().add(this.getStatechartScope());
    internalScopeEClass.getESuperTypes().add(this.getStatechartScope());
    eventDefinitionEClass.getESuperTypes().add(theSGraphPackage.getDeclaration());
    eventDefinitionEClass.getESuperTypes().add(theSGraphPackage.getEvent());
    eventDefinitionEClass.getESuperTypes().add(theTypesPackage.getEvent());
    localReactionEClass.getESuperTypes().add(theSGraphPackage.getDeclaration());
    localReactionEClass.getESuperTypes().add(theSGraphPackage.getReaction());
    transitionReactionEClass.getESuperTypes().add(theSGraphPackage.getReaction());
    entryPointSpecEClass.getESuperTypes().add(this.getReactionProperty());
    exitPointSpecEClass.getESuperTypes().add(this.getReactionProperty());
    regularEventSpecEClass.getESuperTypes().add(this.getEventSpec());
    timeEventSpecEClass.getESuperTypes().add(this.getEventSpec());
    builtinEventSpecEClass.getESuperTypes().add(this.getEventSpec());
    entryEventEClass.getESuperTypes().add(this.getBuiltinEventSpec());
    exitEventEClass.getESuperTypes().add(this.getBuiltinEventSpec());
    onCycleEventEClass.getESuperTypes().add(this.getBuiltinEventSpec());
    alwaysEventEClass.getESuperTypes().add(this.getBuiltinEventSpec());
    defaultEventEClass.getESuperTypes().add(this.getBuiltinEventSpec());
    assignmentEClass.getESuperTypes().add(theSGraphPackage.getStatement());
    eventRaisingEClass.getESuperTypes().add(theSGraphPackage.getStatement());
    expressionEClass.getESuperTypes().add(theSGraphPackage.getStatement());
    elementReferenceExpressionEClass.getESuperTypes().add(this.getExpression());
    eventValueReferenceExpressionEClass.getESuperTypes().add(this.getExpression());
    activeStateReferenceExpressionEClass.getESuperTypes().add(this.getExpression());
    boolLiteralEClass.getESuperTypes().add(this.getLiteral());
    intLiteralEClass.getESuperTypes().add(this.getLiteral());
    realLiteralEClass.getESuperTypes().add(this.getLiteral());
    hexLiteralEClass.getESuperTypes().add(this.getLiteral());
    simpleScopeEClass.getESuperTypes().add(theSGraphPackage.getScope());
    variableDefinitionEClass.getESuperTypes().add(theSGraphPackage.getVariable());
    operationEClass.getESuperTypes().add(theSGraphPackage.getDeclaration());
    entrypointEClass.getESuperTypes().add(theSGraphPackage.getDeclaration());
    exitpointEClass.getESuperTypes().add(theSGraphPackage.getDeclaration());
    reactionTriggerEClass.getESuperTypes().add(theSGraphPackage.getTrigger());
    reactionEffectEClass.getESuperTypes().add(theSGraphPackage.getEffect());
    conditionalExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalOrExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalAndExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalNotExpressionEClass.getESuperTypes().add(this.getExpression());
    bitwiseXorExpressionEClass.getESuperTypes().add(this.getExpression());
    bitwiseOrExpressionEClass.getESuperTypes().add(this.getExpression());
    bitwiseAndExpressionEClass.getESuperTypes().add(this.getExpression());
    logicalRelationExpressionEClass.getESuperTypes().add(this.getExpression());
    shiftExpressionEClass.getESuperTypes().add(this.getExpression());
    numericalAddSubtractExpressionEClass.getESuperTypes().add(this.getExpression());
    numericalMultiplyDivideExpressionEClass.getESuperTypes().add(this.getExpression());
    numericalUnaryExpressionEClass.getESuperTypes().add(this.getExpression());
    primitiveValueExpressionEClass.getESuperTypes().add(this.getExpression());
    operationCallEClass.getESuperTypes().add(this.getExpression());

    // Initialize classes and features; add operations and parameters
    initEClass(rootEClass, Root.class, "Root", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRoot_Roots(), this.getDefRoot(), null, "roots", null, 0, -1, Root.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defRootEClass, DefRoot.class, "DefRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(statechartRootEClass, StatechartRoot.class, "StatechartRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatechartRoot_Def(), this.getStatechartSpecification(), null, "def", null, 0, 1, StatechartRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateRootEClass, StateRoot.class, "StateRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateRoot_Def(), this.getStateSpecification(), null, "def", null, 0, 1, StateRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionRootEClass, TransitionRoot.class, "TransitionRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionRoot_Def(), this.getTransitionSpecification(), null, "def", null, 0, 1, TransitionRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statechartSpecificationEClass, StatechartSpecification.class, "StatechartSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStatechartSpecification_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, StatechartSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStatechartSpecification_DefinitionScopes(), this.getStatechartScope(), null, "definitionScopes", null, 0, -1, StatechartSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateSpecificationEClass, StateSpecification.class, "StateSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStateSpecification_Scope(), theSGraphPackage.getScope(), null, "scope", null, 0, 1, StateSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionSpecificationEClass, TransitionSpecification.class, "TransitionSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionSpecification_Reaction(), this.getTransitionReaction(), null, "reaction", null, 0, 1, TransitionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statechartScopeEClass, StatechartScope.class, "StatechartScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(interfaceScopeEClass, InterfaceScope.class, "InterfaceScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(internalScopeEClass, InternalScope.class, "InternalScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(eventDefinitionEClass, EventDefinition.class, "EventDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEventDefinition_Direction(), this.getDirection(), "direction", null, 0, 1, EventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventDefinition_Derivation(), this.getEventDerivation(), null, "derivation", null, 0, 1, EventDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventDerivationEClass, EventDerivation.class, "EventDerivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventDerivation_Condition(), this.getExpression(), null, "condition", null, 0, 1, EventDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventDerivation_Value(), this.getExpression(), null, "value", null, 0, 1, EventDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(localReactionEClass, LocalReaction.class, "LocalReaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLocalReaction_Properties(), this.getReactionProperties(), null, "properties", null, 0, 1, LocalReaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionReactionEClass, TransitionReaction.class, "TransitionReaction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransitionReaction_Properties(), this.getReactionProperties(), null, "properties", null, 0, 1, TransitionReaction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reactionPropertiesEClass, ReactionProperties.class, "ReactionProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReactionProperties_Properties(), this.getReactionProperty(), null, "properties", null, 0, -1, ReactionProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reactionPropertyEClass, ReactionProperty.class, "ReactionProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(entryPointSpecEClass, EntryPointSpec.class, "EntryPointSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEntryPointSpec_Entrypoint(), this.getEntrypoint(), null, "entrypoint", null, 0, 1, EntryPointSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exitPointSpecEClass, ExitPointSpec.class, "ExitPointSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExitPointSpec_Exitpoint(), this.getExitpoint(), null, "exitpoint", null, 0, 1, ExitPointSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventSpecEClass, EventSpec.class, "EventSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(regularEventSpecEClass, RegularEventSpec.class, "RegularEventSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRegularEventSpec_Event(), theSGraphPackage.getEvent(), null, "event", null, 0, 1, RegularEventSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeEventSpecEClass, TimeEventSpec.class, "TimeEventSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeEventSpec_Type(), this.getTimeEventType(), "type", null, 0, 1, TimeEventSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeEventSpec_Value(), ecorePackage.getEInt(), "value", null, 0, 1, TimeEventSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeEventSpec_Unit(), this.getTimeUnit(), "unit", null, 0, 1, TimeEventSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(builtinEventSpecEClass, BuiltinEventSpec.class, "BuiltinEventSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(entryEventEClass, EntryEvent.class, "EntryEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exitEventEClass, ExitEvent.class, "ExitEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(onCycleEventEClass, OnCycleEvent.class, "OnCycleEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(alwaysEventEClass, AlwaysEvent.class, "AlwaysEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(defaultEventEClass, DefaultEvent.class, "DefaultEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(assignmentEClass, Assignment.class, "Assignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignment_VarRef(), theSGraphPackage.getVariable(), null, "varRef", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAssignment_Operator(), this.getAssignmentOperator(), "operator", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignment_Expression(), this.getExpression(), null, "expression", null, 0, 1, Assignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventRaisingEClass, EventRaising.class, "EventRaising", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventRaising_Event(), theSGraphPackage.getEvent(), null, "event", null, 0, 1, EventRaising.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getEventRaising_Value(), this.getExpression(), null, "value", null, 0, 1, EventRaising.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(elementReferenceExpressionEClass, ElementReferenceExpression.class, "ElementReferenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElementReferenceExpression_Value(), theSGraphPackage.getDeclaration(), null, "value", null, 0, 1, ElementReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(eventValueReferenceExpressionEClass, EventValueReferenceExpression.class, "EventValueReferenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEventValueReferenceExpression_Value(), theSGraphPackage.getEvent(), null, "value", null, 0, 1, EventValueReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(activeStateReferenceExpressionEClass, ActiveStateReferenceExpression.class, "ActiveStateReferenceExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActiveStateReferenceExpression_Value(), theSGraphPackage.getRegularState(), null, "value", null, 0, 1, ActiveStateReferenceExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(literalEClass, Literal.class, "Literal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(boolLiteralEClass, BoolLiteral.class, "BoolLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBoolLiteral_Value(), ecorePackage.getEBoolean(), "value", null, 0, 1, BoolLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(intLiteralEClass, IntLiteral.class, "IntLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntLiteral_Value(), ecorePackage.getEInt(), "value", null, 0, 1, IntLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(realLiteralEClass, RealLiteral.class, "RealLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRealLiteral_Value(), ecorePackage.getEFloat(), "value", null, 0, 1, RealLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(hexLiteralEClass, HexLiteral.class, "HexLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getHexLiteral_Value(), ecorePackage.getEInt(), "value", null, 0, 1, HexLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(simpleScopeEClass, SimpleScope.class, "SimpleScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableDefinitionEClass, VariableDefinition.class, "VariableDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableDefinition_Readonly(), ecorePackage.getEBoolean(), "readonly", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariableDefinition_External(), ecorePackage.getEBoolean(), "external", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDefinition_Type(), theTypesPackage.getType(), null, "type", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDefinition_InitialValue(), this.getExpression(), null, "initialValue", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperation_ParamTypes(), theTypesPackage.getType(), null, "paramTypes", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperation_Type(), theTypesPackage.getType(), null, "type", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(entrypointEClass, Entrypoint.class, "Entrypoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(exitpointEClass, Exitpoint.class, "Exitpoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(reactionTriggerEClass, ReactionTrigger.class, "ReactionTrigger", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReactionTrigger_Triggers(), this.getEventSpec(), null, "triggers", null, 0, -1, ReactionTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReactionTrigger_GuardExpression(), this.getExpression(), null, "guardExpression", null, 0, 1, ReactionTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reactionEffectEClass, ReactionEffect.class, "ReactionEffect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReactionEffect_Actions(), theSGraphPackage.getStatement(), null, "actions", null, 0, -1, ReactionEffect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalExpressionEClass, ConditionalExpression.class, "ConditionalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpression_Condition(), this.getExpression(), null, "condition", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_TrueCase(), this.getExpression(), null, "trueCase", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpression_FalseCase(), this.getExpression(), null, "falseCase", null, 0, 1, ConditionalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalOrExpressionEClass, LogicalOrExpression.class, "LogicalOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalOrExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, LogicalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLogicalOrExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, LogicalOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalAndExpressionEClass, LogicalAndExpression.class, "LogicalAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalAndExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, LogicalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLogicalAndExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, LogicalAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalNotExpressionEClass, LogicalNotExpression.class, "LogicalNotExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalNotExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, LogicalNotExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseXorExpressionEClass, BitwiseXorExpression.class, "BitwiseXorExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseXorExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, BitwiseXorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseXorExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, BitwiseXorExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseOrExpressionEClass, BitwiseOrExpression.class, "BitwiseOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseOrExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, BitwiseOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseOrExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, BitwiseOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bitwiseAndExpressionEClass, BitwiseAndExpression.class, "BitwiseAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBitwiseAndExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, BitwiseAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBitwiseAndExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, BitwiseAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(logicalRelationExpressionEClass, LogicalRelationExpression.class, "LogicalRelationExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLogicalRelationExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, LogicalRelationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLogicalRelationExpression_Operator(), this.getRelationalOperator(), "operator", null, 0, 1, LogicalRelationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLogicalRelationExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, LogicalRelationExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(shiftExpressionEClass, ShiftExpression.class, "ShiftExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getShiftExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getShiftExpression_Operator(), this.getShiftOperator(), "operator", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getShiftExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, ShiftExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericalAddSubtractExpressionEClass, NumericalAddSubtractExpression.class, "NumericalAddSubtractExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNumericalAddSubtractExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, NumericalAddSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNumericalAddSubtractExpression_Operator(), this.getAdditiveOperator(), "operator", null, 0, 1, NumericalAddSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNumericalAddSubtractExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, NumericalAddSubtractExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericalMultiplyDivideExpressionEClass, NumericalMultiplyDivideExpression.class, "NumericalMultiplyDivideExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNumericalMultiplyDivideExpression_LeftOperand(), this.getExpression(), null, "leftOperand", null, 0, 1, NumericalMultiplyDivideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNumericalMultiplyDivideExpression_Operator(), this.getMultiplicativeOperator(), "operator", null, 0, 1, NumericalMultiplyDivideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNumericalMultiplyDivideExpression_RightOperand(), this.getExpression(), null, "rightOperand", null, 0, 1, NumericalMultiplyDivideExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(numericalUnaryExpressionEClass, NumericalUnaryExpression.class, "NumericalUnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNumericalUnaryExpression_Operator(), this.getUnaryOperator(), "operator", null, 0, 1, NumericalUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNumericalUnaryExpression_Operand(), this.getExpression(), null, "operand", null, 0, 1, NumericalUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primitiveValueExpressionEClass, PrimitiveValueExpression.class, "PrimitiveValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrimitiveValueExpression_Value(), this.getLiteral(), null, "value", null, 0, 1, PrimitiveValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationCallEClass, OperationCall.class, "OperationCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationCall_Operation(), this.getOperation(), null, "operation", null, 0, 1, OperationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationCall_Args(), this.getExpression(), null, "args", null, 0, -1, OperationCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(directionEEnum, Direction.class, "Direction");
    addEEnumLiteral(directionEEnum, Direction.LOCAL);
    addEEnumLiteral(directionEEnum, Direction.IN);
    addEEnumLiteral(directionEEnum, Direction.OUT);

    initEEnum(timeEventTypeEEnum, TimeEventType.class, "TimeEventType");
    addEEnumLiteral(timeEventTypeEEnum, TimeEventType.AFTER);
    addEEnumLiteral(timeEventTypeEEnum, TimeEventType.EVERY);

    initEEnum(assignmentOperatorEEnum, AssignmentOperator.class, "AssignmentOperator");
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MULT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.DIV_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.MOD_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.ADD_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.SUB_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.LEFT_SHIFT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.RIGHT_SHIFT_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.AND_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.XOR_ASSIGN);
    addEEnumLiteral(assignmentOperatorEEnum, AssignmentOperator.OR_ASSIGN);

    initEEnum(shiftOperatorEEnum, ShiftOperator.class, "ShiftOperator");
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.LEFT);
    addEEnumLiteral(shiftOperatorEEnum, ShiftOperator.RIGHT);

    initEEnum(additiveOperatorEEnum, AdditiveOperator.class, "AdditiveOperator");
    addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.PLUS);
    addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.MINUS);

    initEEnum(multiplicativeOperatorEEnum, MultiplicativeOperator.class, "MultiplicativeOperator");
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MUL);
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.DIV);
    addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MOD);

    initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.POSITIVE);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NEGATIVE);
    addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.COMPLEMENT);

    initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.SMALLER);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.SMALLER_EQUAL);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_EQUAL);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUALS);
    addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.NOT_EQUALS);

    initEEnum(timeUnitEEnum, TimeUnit.class, "TimeUnit");
    addEEnumLiteral(timeUnitEEnum, TimeUnit.SECOND);
    addEEnumLiteral(timeUnitEEnum, TimeUnit.MILLISECOND);
    addEEnumLiteral(timeUnitEEnum, TimeUnit.MICROSEND);
    addEEnumLiteral(timeUnitEEnum, TimeUnit.NANOSECOND);

    // Create resource
    createResource(eNS_URI);
  }

} //StextPackageImpl
