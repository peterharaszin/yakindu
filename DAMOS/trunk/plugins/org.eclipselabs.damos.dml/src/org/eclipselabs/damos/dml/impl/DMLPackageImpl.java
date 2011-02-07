/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.BehaviorSpecification;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInoutput;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.BlockPort;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.CategorizedElement;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.DataTypeSpecification;
import org.eclipselabs.damos.dml.DirectFeedthroughPolicy;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Inlet;
import org.eclipselabs.damos.dml.Inoutlet;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Inoutput;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.Inport;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Model;
import org.eclipselabs.damos.dml.OpaqueBehaviorSpecification;
import org.eclipselabs.damos.dml.OpaqueDataTypeSpecification;
import org.eclipselabs.damos.dml.Outlet;
import org.eclipselabs.damos.dml.Outport;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Parameter;
import org.eclipselabs.damos.dml.ParameterableElement;
import org.eclipselabs.damos.dml.ParameterizedElement;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.PredefinedExpressionEntry;
import org.eclipselabs.damos.dml.QualifiedElement;
import org.eclipselabs.damos.dml.SignalSpecification;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemInoutput;
import org.eclipselabs.damos.dml.SubsystemInput;
import org.eclipselabs.damos.dml.SubsystemOutput;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.ValueSpecification;
import org.eclipselabs.damos.dml.util.DMLValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DMLPackageImpl extends EPackageImpl implements DMLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inoutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockInoutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inoutputDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputDefinitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterizedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass argumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predefinedExpressionEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass directFeedthroughPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categorizedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass behaviorSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockInputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockOutputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemInterfaceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inletEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inoutletEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outletEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inoutportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemInoutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass subsystemRealizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanDirectFeedthroughPolicyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueDataTypeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass opaqueBehaviorSpecificationEClass = null;

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
	 * @see org.eclipselabs.damos.dml.DMLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DMLPackageImpl() {
		super(eNS_URI, DMLFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link DMLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DMLPackage init() {
		if (isInited) return (DMLPackage)EPackage.Registry.INSTANCE.getEPackage(DMLPackage.eNS_URI);

		// Obtain or create and register package
		DMLPackageImpl theDMLPackage = (DMLPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DMLPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DMLPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDMLPackage.createPackageContents();

		// Initialize created meta-data
		theDMLPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDMLPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return DMLValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDMLPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DMLPackage.eNS_URI, theDMLPackage);
		return theDMLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragment() {
		return fragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragment_Components() {
		return (EReference)fragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragment_FragmentElements() {
		return (EReference)fragmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragment_Connections() {
		return (EReference)fragmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragment_Parent() {
		return (EReference)fragmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFragment_Name() {
		return (EAttribute)fragmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Inputs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Outputs() {
		return (EReference)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Name() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragmentElement() {
		return fragmentElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragmentElement_OwningFragment() {
		return (EReference)fragmentElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputPort() {
		return inputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputPort_Input() {
		return (EReference)inputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnection() {
		return connectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_SourcePort() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_TargetPort() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputPort() {
		return outputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPort_Output() {
		return (EReference)outputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutputPort_Signal() {
		return (EReference)outputPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutput() {
		return outputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_Component() {
		return (EReference)outputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOutput_Ports() {
		return (EReference)outputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignalSpecification() {
		return signalSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInoutput() {
		return inoutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInput() {
		return inputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInput_Ports() {
		return (EReference)inputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInput_Component() {
		return (EReference)inputEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockInput() {
		return blockInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockInput_Definition() {
		return (EReference)blockInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockInoutput() {
		return blockInoutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputDefinition() {
		return inputDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInputDefinition_DirectFeedthroughPolicy() {
		return (EReference)inputDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInoutputDefinition() {
		return inoutputDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInoutputDefinition_MinimumPortCount() {
		return (EAttribute)inoutputDefinitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInoutputDefinition_MaximumPortCount() {
		return (EAttribute)inoutputDefinitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInoutputDefinition_DefaultPortCount() {
		return (EAttribute)inoutputDefinitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInoutputDefinition_ManyPorts() {
		return (EAttribute)inoutputDefinitionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInoutputDefinition_Name() {
		return (EAttribute)inoutputDefinitionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInoutputDefinition_DataType() {
		return (EReference)inoutputDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputDefinition() {
		return outputDefinitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterizedElement() {
		return parameterizedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterizedElement_Arguments() {
		return (EReference)parameterizedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArgument() {
		return argumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgument_Value() {
		return (EReference)argumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArgument_Parameter() {
		return (EReference)argumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionParameter() {
		return expressionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionParameter_DefaultExpression() {
		return (EReference)expressionParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionParameter_PredefinedExpressions() {
		return (EReference)expressionParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionParameter_DataType() {
		return (EReference)expressionParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionSpecification() {
		return expressionSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExpressionSpecification_Expression() {
		return (EAttribute)expressionSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredefinedExpressionEntry() {
		return predefinedExpressionEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPredefinedExpressionEntry_Alias() {
		return (EAttribute)predefinedExpressionEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredefinedExpressionEntry_Expression() {
		return (EReference)predefinedExpressionEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeSpecification() {
		return dataTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterableElement() {
		return parameterableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterableElement_Parameters() {
		return (EReference)parameterableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Name() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getValueSpecification() {
		return valueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDirectFeedthroughPolicy() {
		return directFeedthroughPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDirectFeedthroughPolicy_InputDefinition() {
		return (EReference)directFeedthroughPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockOutput() {
		return blockOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockOutput_Definition() {
		return (EReference)blockOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockType() {
		return blockTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockType_InputDefinitions() {
		return (EReference)blockTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockType_OutputDefinitions() {
		return (EReference)blockTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockType_Behavior() {
		return (EReference)blockTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedElement() {
		return qualifiedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedElement_QualifiedName() {
		return (EAttribute)qualifiedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedElement_Name() {
		return (EAttribute)qualifiedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getQualifiedElement_Qualifier() {
		return (EAttribute)qualifiedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategorizedElement() {
		return categorizedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCategorizedElement_BelongingCategories() {
		return (EReference)categorizedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBehaviorSpecification() {
		return behaviorSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlock() {
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_Type() {
		return (EReference)blockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockPort() {
		return blockPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockInputPort() {
		return blockInputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockOutputPort() {
		return blockOutputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystem() {
		return subsystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystem_ProvidedInterface() {
		return (EReference)subsystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemInterface() {
		return systemInterfaceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemInterface_Inlets() {
		return (EReference)systemInterfaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemInterface_Outlets() {
		return (EReference)systemInterfaceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSystemInterface_Name() {
		return (EAttribute)systemInterfaceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInlet() {
		return inletEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInoutlet() {
		return inoutletEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInoutlet_DataType() {
		return (EReference)inoutletEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInoutlet_Name() {
		return (EAttribute)inoutletEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutlet() {
		return outletEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInport() {
		return inportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInoutport() {
		return inoutportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInoutport_DataType() {
		return (EReference)inoutportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutport() {
		return outportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystemInoutput() {
		return subsystemInoutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystemInput() {
		return subsystemInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystemInput_Inlet() {
		return (EReference)subsystemInputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystemOutput() {
		return subsystemOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystemOutput_Outlet() {
		return (EReference)subsystemOutputEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSubsystemRealization() {
		return subsystemRealizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystemRealization_RealizedSubsystem() {
		return (EReference)subsystemRealizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSubsystemRealization_RealizingFragment() {
		return (EReference)subsystemRealizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanDirectFeedthroughPolicy() {
		return booleanDirectFeedthroughPolicyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanDirectFeedthroughPolicy_DirectFeedthrough() {
		return (EAttribute)booleanDirectFeedthroughPolicyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueDataTypeSpecification() {
		return opaqueDataTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpaqueDataTypeSpecification_DataType() {
		return (EAttribute)opaqueDataTypeSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpaqueBehaviorSpecification() {
		return opaqueBehaviorSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpaqueBehaviorSpecification_Behavior() {
		return (EAttribute)opaqueBehaviorSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLFactory getDMLFactory() {
		return (DMLFactory)getEFactoryInstance();
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
		fragmentEClass = createEClass(FRAGMENT);
		createEReference(fragmentEClass, FRAGMENT__COMPONENTS);
		createEReference(fragmentEClass, FRAGMENT__FRAGMENT_ELEMENTS);
		createEReference(fragmentEClass, FRAGMENT__CONNECTIONS);
		createEReference(fragmentEClass, FRAGMENT__PARENT);
		createEAttribute(fragmentEClass, FRAGMENT__NAME);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__INPUTS);
		createEReference(componentEClass, COMPONENT__OUTPUTS);
		createEAttribute(componentEClass, COMPONENT__NAME);

		fragmentElementEClass = createEClass(FRAGMENT_ELEMENT);
		createEReference(fragmentElementEClass, FRAGMENT_ELEMENT__OWNING_FRAGMENT);

		inputEClass = createEClass(INPUT);
		createEReference(inputEClass, INPUT__PORTS);
		createEReference(inputEClass, INPUT__COMPONENT);

		inoutputEClass = createEClass(INOUTPUT);

		inputPortEClass = createEClass(INPUT_PORT);
		createEReference(inputPortEClass, INPUT_PORT__INPUT);

		portEClass = createEClass(PORT);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__SOURCE_PORT);
		createEReference(connectionEClass, CONNECTION__TARGET_PORT);

		outputPortEClass = createEClass(OUTPUT_PORT);
		createEReference(outputPortEClass, OUTPUT_PORT__OUTPUT);
		createEReference(outputPortEClass, OUTPUT_PORT__SIGNAL);

		outputEClass = createEClass(OUTPUT);
		createEReference(outputEClass, OUTPUT__COMPONENT);
		createEReference(outputEClass, OUTPUT__PORTS);

		signalSpecificationEClass = createEClass(SIGNAL_SPECIFICATION);

		blockInputEClass = createEClass(BLOCK_INPUT);
		createEReference(blockInputEClass, BLOCK_INPUT__DEFINITION);

		blockInoutputEClass = createEClass(BLOCK_INOUTPUT);

		inputDefinitionEClass = createEClass(INPUT_DEFINITION);
		createEReference(inputDefinitionEClass, INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY);

		inoutputDefinitionEClass = createEClass(INOUTPUT_DEFINITION);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__DEFAULT_PORT_COUNT);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__MANY_PORTS);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__NAME);
		createEReference(inoutputDefinitionEClass, INOUTPUT_DEFINITION__DATA_TYPE);

		parameterableElementEClass = createEClass(PARAMETERABLE_ELEMENT);
		createEReference(parameterableElementEClass, PARAMETERABLE_ELEMENT__PARAMETERS);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);

		valueSpecificationEClass = createEClass(VALUE_SPECIFICATION);

		dataTypeSpecificationEClass = createEClass(DATA_TYPE_SPECIFICATION);

		directFeedthroughPolicyEClass = createEClass(DIRECT_FEEDTHROUGH_POLICY);
		createEReference(directFeedthroughPolicyEClass, DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION);

		blockOutputEClass = createEClass(BLOCK_OUTPUT);
		createEReference(blockOutputEClass, BLOCK_OUTPUT__DEFINITION);

		outputDefinitionEClass = createEClass(OUTPUT_DEFINITION);

		parameterizedElementEClass = createEClass(PARAMETERIZED_ELEMENT);
		createEReference(parameterizedElementEClass, PARAMETERIZED_ELEMENT__ARGUMENTS);

		argumentEClass = createEClass(ARGUMENT);
		createEReference(argumentEClass, ARGUMENT__VALUE);
		createEReference(argumentEClass, ARGUMENT__PARAMETER);

		expressionParameterEClass = createEClass(EXPRESSION_PARAMETER);
		createEReference(expressionParameterEClass, EXPRESSION_PARAMETER__DEFAULT_EXPRESSION);
		createEReference(expressionParameterEClass, EXPRESSION_PARAMETER__PREDEFINED_EXPRESSIONS);
		createEReference(expressionParameterEClass, EXPRESSION_PARAMETER__DATA_TYPE);

		expressionSpecificationEClass = createEClass(EXPRESSION_SPECIFICATION);
		createEAttribute(expressionSpecificationEClass, EXPRESSION_SPECIFICATION__EXPRESSION);

		predefinedExpressionEntryEClass = createEClass(PREDEFINED_EXPRESSION_ENTRY);
		createEAttribute(predefinedExpressionEntryEClass, PREDEFINED_EXPRESSION_ENTRY__ALIAS);
		createEReference(predefinedExpressionEntryEClass, PREDEFINED_EXPRESSION_ENTRY__EXPRESSION);

		blockTypeEClass = createEClass(BLOCK_TYPE);
		createEReference(blockTypeEClass, BLOCK_TYPE__INPUT_DEFINITIONS);
		createEReference(blockTypeEClass, BLOCK_TYPE__OUTPUT_DEFINITIONS);
		createEReference(blockTypeEClass, BLOCK_TYPE__BEHAVIOR);

		qualifiedElementEClass = createEClass(QUALIFIED_ELEMENT);
		createEAttribute(qualifiedElementEClass, QUALIFIED_ELEMENT__QUALIFIED_NAME);
		createEAttribute(qualifiedElementEClass, QUALIFIED_ELEMENT__NAME);
		createEAttribute(qualifiedElementEClass, QUALIFIED_ELEMENT__QUALIFIER);

		categorizedElementEClass = createEClass(CATEGORIZED_ELEMENT);
		createEReference(categorizedElementEClass, CATEGORIZED_ELEMENT__BELONGING_CATEGORIES);

		categoryEClass = createEClass(CATEGORY);

		behaviorSpecificationEClass = createEClass(BEHAVIOR_SPECIFICATION);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__TYPE);

		modelEClass = createEClass(MODEL);

		systemEClass = createEClass(SYSTEM);

		blockPortEClass = createEClass(BLOCK_PORT);

		blockInputPortEClass = createEClass(BLOCK_INPUT_PORT);

		blockOutputPortEClass = createEClass(BLOCK_OUTPUT_PORT);

		subsystemEClass = createEClass(SUBSYSTEM);
		createEReference(subsystemEClass, SUBSYSTEM__PROVIDED_INTERFACE);

		systemInterfaceEClass = createEClass(SYSTEM_INTERFACE);
		createEReference(systemInterfaceEClass, SYSTEM_INTERFACE__INLETS);
		createEReference(systemInterfaceEClass, SYSTEM_INTERFACE__OUTLETS);
		createEAttribute(systemInterfaceEClass, SYSTEM_INTERFACE__NAME);

		inletEClass = createEClass(INLET);

		inoutletEClass = createEClass(INOUTLET);
		createEReference(inoutletEClass, INOUTLET__DATA_TYPE);
		createEAttribute(inoutletEClass, INOUTLET__NAME);

		outletEClass = createEClass(OUTLET);

		subsystemRealizationEClass = createEClass(SUBSYSTEM_REALIZATION);
		createEReference(subsystemRealizationEClass, SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM);
		createEReference(subsystemRealizationEClass, SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT);

		inportEClass = createEClass(INPORT);

		inoutportEClass = createEClass(INOUTPORT);
		createEReference(inoutportEClass, INOUTPORT__DATA_TYPE);

		outportEClass = createEClass(OUTPORT);

		subsystemInoutputEClass = createEClass(SUBSYSTEM_INOUTPUT);

		subsystemInputEClass = createEClass(SUBSYSTEM_INPUT);
		createEReference(subsystemInputEClass, SUBSYSTEM_INPUT__INLET);

		subsystemOutputEClass = createEClass(SUBSYSTEM_OUTPUT);
		createEReference(subsystemOutputEClass, SUBSYSTEM_OUTPUT__OUTLET);

		booleanDirectFeedthroughPolicyEClass = createEClass(BOOLEAN_DIRECT_FEEDTHROUGH_POLICY);
		createEAttribute(booleanDirectFeedthroughPolicyEClass, BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH);

		opaqueDataTypeSpecificationEClass = createEClass(OPAQUE_DATA_TYPE_SPECIFICATION);
		createEAttribute(opaqueDataTypeSpecificationEClass, OPAQUE_DATA_TYPE_SPECIFICATION__DATA_TYPE);

		opaqueBehaviorSpecificationEClass = createEClass(OPAQUE_BEHAVIOR_SPECIFICATION);
		createEAttribute(opaqueBehaviorSpecificationEClass, OPAQUE_BEHAVIOR_SPECIFICATION__BEHAVIOR);
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
		componentEClass.getESuperTypes().add(this.getFragmentElement());
		inputEClass.getESuperTypes().add(this.getInoutput());
		inputPortEClass.getESuperTypes().add(this.getPort());
		connectionEClass.getESuperTypes().add(this.getFragmentElement());
		outputPortEClass.getESuperTypes().add(this.getPort());
		outputEClass.getESuperTypes().add(this.getInoutput());
		blockInputEClass.getESuperTypes().add(this.getInput());
		blockInputEClass.getESuperTypes().add(this.getBlockInoutput());
		blockInoutputEClass.getESuperTypes().add(this.getInoutput());
		inputDefinitionEClass.getESuperTypes().add(this.getInoutputDefinition());
		inoutputDefinitionEClass.getESuperTypes().add(this.getParameterableElement());
		blockOutputEClass.getESuperTypes().add(this.getOutput());
		blockOutputEClass.getESuperTypes().add(this.getBlockInoutput());
		outputDefinitionEClass.getESuperTypes().add(this.getInoutputDefinition());
		expressionParameterEClass.getESuperTypes().add(this.getParameter());
		expressionSpecificationEClass.getESuperTypes().add(this.getValueSpecification());
		blockTypeEClass.getESuperTypes().add(this.getQualifiedElement());
		blockTypeEClass.getESuperTypes().add(this.getCategorizedElement());
		blockTypeEClass.getESuperTypes().add(this.getParameterableElement());
		categoryEClass.getESuperTypes().add(this.getQualifiedElement());
		categoryEClass.getESuperTypes().add(this.getCategorizedElement());
		categoryEClass.getESuperTypes().add(this.getParameterableElement());
		blockEClass.getESuperTypes().add(this.getComponent());
		blockEClass.getESuperTypes().add(this.getParameterizedElement());
		modelEClass.getESuperTypes().add(this.getSystem());
		systemEClass.getESuperTypes().add(this.getFragment());
		blockPortEClass.getESuperTypes().add(this.getParameterizedElement());
		blockPortEClass.getESuperTypes().add(this.getPort());
		blockInputPortEClass.getESuperTypes().add(this.getBlockPort());
		blockInputPortEClass.getESuperTypes().add(this.getInputPort());
		blockOutputPortEClass.getESuperTypes().add(this.getOutputPort());
		blockOutputPortEClass.getESuperTypes().add(this.getBlockPort());
		subsystemEClass.getESuperTypes().add(this.getComponent());
		inletEClass.getESuperTypes().add(this.getInoutlet());
		outletEClass.getESuperTypes().add(this.getInoutlet());
		subsystemRealizationEClass.getESuperTypes().add(this.getFragmentElement());
		inportEClass.getESuperTypes().add(this.getInoutport());
		inoutportEClass.getESuperTypes().add(this.getComponent());
		outportEClass.getESuperTypes().add(this.getInoutport());
		subsystemInoutputEClass.getESuperTypes().add(this.getInoutput());
		subsystemInputEClass.getESuperTypes().add(this.getInput());
		subsystemInputEClass.getESuperTypes().add(this.getSubsystemInoutput());
		subsystemOutputEClass.getESuperTypes().add(this.getOutput());
		subsystemOutputEClass.getESuperTypes().add(this.getSubsystemInoutput());
		booleanDirectFeedthroughPolicyEClass.getESuperTypes().add(this.getDirectFeedthroughPolicy());
		opaqueDataTypeSpecificationEClass.getESuperTypes().add(this.getDataTypeSpecification());
		opaqueBehaviorSpecificationEClass.getESuperTypes().add(this.getBehaviorSpecification());

		// Initialize classes and features; add operations and parameters
		initEClass(fragmentEClass, Fragment.class, "Fragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragment_Components(), this.getComponent(), null, "components", null, 0, -1, Fragment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getFragment_FragmentElements(), this.getFragmentElement(), this.getFragmentElement_OwningFragment(), "fragmentElements", null, 0, -1, Fragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFragment_Connections(), this.getConnection(), null, "connections", null, 0, -1, Fragment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getFragment_Parent(), this.getFragment(), null, "parent", null, 0, 1, Fragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFragment_Name(), ecorePackage.getEString(), "name", null, 1, 1, Fragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(fragmentEClass, this.getFragment(), "getChildren", 0, -1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(fragmentEClass, this.getComponent(), "getAllComponents", 0, -1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(fragmentEClass, this.getConnection(), "getAllConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_Inputs(), this.getInput(), this.getInput_Component(), "inputs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Outputs(), this.getOutput(), this.getOutput_Component(), "outputs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Name(), ecorePackage.getEString(), "name", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(componentEClass, this.getInputPort(), "getInputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getOutputPort(), "getOutputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getInputPort(), "getFirstInputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(componentEClass, this.getOutputPort(), "getFirstOutputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(componentEClass, this.getInputPort(), "getPrimaryInputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getOutputPort(), "getPrimaryOutputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, ecorePackage.getEBoolean(), "isSource", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(componentEClass, ecorePackage.getEBoolean(), "isSink", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(fragmentElementEClass, FragmentElement.class, "FragmentElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentElement_OwningFragment(), this.getFragment(), this.getFragment_FragmentElements(), "owningFragment", null, 1, 1, FragmentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputEClass, Input.class, "Input", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInput_Ports(), this.getInputPort(), this.getInputPort_Input(), "ports", null, 0, -1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInput_Component(), this.getComponent(), this.getComponent_Inputs(), "component", null, 1, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(inputEClass, ecorePackage.getEBoolean(), "isDirectFeedthrough", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(inoutputEClass, Inoutput.class, "Inoutput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputPortEClass, InputPort.class, "InputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputPort_Input(), this.getInput(), this.getInput_Ports(), "input", null, 1, 1, InputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(inputPortEClass, this.getConnection(), "getIncomingConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);

		EOperation op = addEOperation(inputPortEClass, this.getConnection(), "getIncomingConnection", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(portEClass, ecorePackage.getEInt(), "getIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(portEClass, this.getComponent(), "getComponent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_SourcePort(), this.getOutputPort(), null, "sourcePort", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnection_TargetPort(), this.getInputPort(), null, "targetPort", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputPortEClass, OutputPort.class, "OutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputPort_Output(), this.getOutput(), this.getOutput_Ports(), "output", null, 1, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutputPort_Signal(), this.getSignalSpecification(), null, "signal", null, 0, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(outputPortEClass, this.getConnection(), "getOutgoingConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(outputPortEClass, this.getConnection(), "getOutgoingConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutput_Component(), this.getComponent(), this.getComponent_Outputs(), "component", null, 1, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutput_Ports(), this.getOutputPort(), this.getOutputPort_Output(), "ports", null, 0, -1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(signalSpecificationEClass, SignalSpecification.class, "SignalSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockInputEClass, BlockInput.class, "BlockInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockInput_Definition(), this.getInputDefinition(), null, "definition", null, 1, 1, BlockInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockInoutputEClass, BlockInoutput.class, "BlockInoutput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inputDefinitionEClass, InputDefinition.class, "InputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputDefinition_DirectFeedthroughPolicy(), this.getDirectFeedthroughPolicy(), this.getDirectFeedthroughPolicy_InputDefinition(), "directFeedthroughPolicy", null, 1, 1, InputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inoutputDefinitionEClass, InoutputDefinition.class, "InoutputDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInoutputDefinition_MinimumPortCount(), ecorePackage.getEInt(), "minimumPortCount", "1", 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_MaximumPortCount(), ecorePackage.getEInt(), "maximumPortCount", "1", 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_DefaultPortCount(), ecorePackage.getEInt(), "defaultPortCount", "-1", 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_ManyPorts(), ecorePackage.getEBoolean(), "manyPorts", null, 1, 1, InoutputDefinition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInoutputDefinition_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 0, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterableElementEClass, ParameterableElement.class, "ParameterableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterableElement_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, ParameterableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(parameterableElementEClass, this.getParameter(), "getParameter", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(parameterEClass, this.getValueSpecification(), "getDefaultValue", 0, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(valueSpecificationEClass, ValueSpecification.class, "ValueSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(valueSpecificationEClass, ecorePackage.getEString(), "stringValue", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(dataTypeSpecificationEClass, DataTypeSpecification.class, "DataTypeSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(directFeedthroughPolicyEClass, DirectFeedthroughPolicy.class, "DirectFeedthroughPolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectFeedthroughPolicy_InputDefinition(), this.getInputDefinition(), this.getInputDefinition_DirectFeedthroughPolicy(), "inputDefinition", null, 1, 1, DirectFeedthroughPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(directFeedthroughPolicyEClass, ecorePackage.getEBoolean(), "computeDirectFeedthrough", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(blockOutputEClass, BlockOutput.class, "BlockOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockOutput_Definition(), this.getOutputDefinition(), null, "definition", null, 1, 1, BlockOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputDefinitionEClass, OutputDefinition.class, "OutputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterizedElementEClass, ParameterizedElement.class, "ParameterizedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterizedElement_Arguments(), this.getArgument(), null, "arguments", null, 0, -1, ParameterizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(parameterizedElementEClass, this.getArgument(), "getArgument", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameterName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(parameterizedElementEClass, ecorePackage.getEString(), "getArgumentStringValue", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameterName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(argumentEClass, Argument.class, "Argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArgument_Value(), this.getValueSpecification(), null, "value", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getArgument_Parameter(), this.getParameter(), null, "parameter", null, 1, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(expressionParameterEClass, ExpressionParameter.class, "ExpressionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionParameter_DefaultExpression(), this.getExpressionSpecification(), null, "defaultExpression", null, 0, 1, ExpressionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExpressionParameter_PredefinedExpressions(), this.getPredefinedExpressionEntry(), null, "predefinedExpressions", null, 0, -1, ExpressionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpressionParameter_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 0, 1, ExpressionParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(expressionParameterEClass, this.getPredefinedExpressionEntry(), "getPredefinedExpression", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "expression", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(expressionParameterEClass, this.getPredefinedExpressionEntry(), "getPredefinedExpressionByAlias", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "alias", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(expressionSpecificationEClass, ExpressionSpecification.class, "ExpressionSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExpressionSpecification_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, ExpressionSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(predefinedExpressionEntryEClass, PredefinedExpressionEntry.class, "PredefinedExpressionEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPredefinedExpressionEntry_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, PredefinedExpressionEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPredefinedExpressionEntry_Expression(), this.getExpressionSpecification(), null, "expression", null, 1, 1, PredefinedExpressionEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockTypeEClass, BlockType.class, "BlockType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockType_InputDefinitions(), this.getInputDefinition(), null, "inputDefinitions", null, 0, -1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockType_OutputDefinitions(), this.getOutputDefinition(), null, "outputDefinitions", null, 0, -1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockType_Behavior(), this.getBehaviorSpecification(), null, "behavior", null, 0, 1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(blockTypeEClass, this.getBlock(), "newInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(qualifiedElementEClass, QualifiedElement.class, "QualifiedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualifiedElement_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 1, 1, QualifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQualifiedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, QualifiedElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQualifiedElement_Qualifier(), ecorePackage.getEString(), "qualifier", null, 1, 1, QualifiedElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(categorizedElementEClass, CategorizedElement.class, "CategorizedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategorizedElement_BelongingCategories(), this.getCategory(), null, "belongingCategories", null, 0, -1, CategorizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(categorizedElementEClass, ecorePackage.getEBoolean(), "belongsTo", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "categoryName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(behaviorSpecificationEClass, BehaviorSpecification.class, "BehaviorSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_Type(), this.getBlockType(), null, "type", null, 1, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(blockEClass, this.getBlockInput(), "getInput", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(blockEClass, this.getBlockOutput(), "getOutput", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(systemEClass, org.eclipselabs.damos.dml.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockPortEClass, BlockPort.class, "BlockPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockInputPortEClass, BlockInputPort.class, "BlockInputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockOutputPortEClass, BlockOutputPort.class, "BlockOutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subsystemEClass, Subsystem.class, "Subsystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystem_ProvidedInterface(), this.getSystemInterface(), null, "providedInterface", null, 1, 1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(subsystemEClass, this.getSubsystemRealization(), "getRealizations", 0, -1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(subsystemEClass, this.getSubsystemRealization(), "getRealization", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(systemInterfaceEClass, SystemInterface.class, "SystemInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemInterface_Inlets(), this.getInlet(), null, "inlets", null, 0, -1, SystemInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemInterface_Outlets(), this.getOutlet(), null, "outlets", null, 0, -1, SystemInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSystemInterface_Name(), ecorePackage.getEString(), "name", null, 1, 1, SystemInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inletEClass, Inlet.class, "Inlet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inoutletEClass, Inoutlet.class, "Inoutlet", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInoutlet_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 1, 1, Inoutlet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutlet_Name(), ecorePackage.getEString(), "name", null, 1, 1, Inoutlet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outletEClass, Outlet.class, "Outlet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subsystemRealizationEClass, SubsystemRealization.class, "SubsystemRealization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemRealization_RealizedSubsystem(), this.getSubsystem(), null, "realizedSubsystem", null, 1, 1, SubsystemRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSubsystemRealization_RealizingFragment(), this.getFragment(), null, "realizingFragment", null, 1, 1, SubsystemRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inportEClass, Inport.class, "Inport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inoutportEClass, Inoutport.class, "Inoutport", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInoutport_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 1, 1, Inoutport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outportEClass, Outport.class, "Outport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subsystemInoutputEClass, SubsystemInoutput.class, "SubsystemInoutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subsystemInputEClass, SubsystemInput.class, "SubsystemInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemInput_Inlet(), this.getInlet(), null, "inlet", null, 1, 1, SubsystemInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subsystemOutputEClass, SubsystemOutput.class, "SubsystemOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemOutput_Outlet(), this.getOutlet(), null, "outlet", null, 1, 1, SubsystemOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(booleanDirectFeedthroughPolicyEClass, BooleanDirectFeedthroughPolicy.class, "BooleanDirectFeedthroughPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanDirectFeedthroughPolicy_DirectFeedthrough(), ecorePackage.getEBoolean(), "directFeedthrough", "true", 1, 1, BooleanDirectFeedthroughPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(opaqueDataTypeSpecificationEClass, OpaqueDataTypeSpecification.class, "OpaqueDataTypeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpaqueDataTypeSpecification_DataType(), ecorePackage.getEString(), "dataType", null, 1, 1, OpaqueDataTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(opaqueBehaviorSpecificationEClass, OpaqueBehaviorSpecification.class, "OpaqueBehaviorSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpaqueBehaviorSpecification_Behavior(), ecorePackage.getEString(), "behavior", null, 1, 1, OpaqueBehaviorSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (fragmentEClass, 
		   source, 
		   new String[] {
			 "constraints", "WellFormedName UniqueComponentNames"
		   });		
		addAnnotation
		  (componentEClass, 
		   source, 
		   new String[] {
			 "constraints", "WellFormedName"
		   });
	}

} //DMLPackageImpl
