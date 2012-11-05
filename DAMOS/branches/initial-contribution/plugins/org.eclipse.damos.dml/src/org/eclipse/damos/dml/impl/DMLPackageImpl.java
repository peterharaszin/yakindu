/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.dml.impl;

import org.eclipse.damos.dml.Action;
import org.eclipse.damos.dml.ActionLink;
import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.AsynchronousTimingConstraint;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInoutput;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockInputPort;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.BlockOutputPort;
import org.eclipse.damos.dml.BlockPort;
import org.eclipse.damos.dml.BlockType;
import org.eclipse.damos.dml.BooleanDirectFeedthroughPolicy;
import org.eclipse.damos.dml.CategorizedElement;
import org.eclipse.damos.dml.Category;
import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.ChoiceInput;
import org.eclipse.damos.dml.ChoiceInputPort;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Compound;
import org.eclipse.damos.dml.CompoundConnector;
import org.eclipse.damos.dml.CompoundInputConnector;
import org.eclipse.damos.dml.CompoundMember;
import org.eclipse.damos.dml.CompoundOutputConnector;
import org.eclipse.damos.dml.Connection;
import org.eclipse.damos.dml.Connector;
import org.eclipse.damos.dml.ContinuousTimingConstraint;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.DataTypeSpecification;
import org.eclipse.damos.dml.DirectFeedthroughPolicy;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.INamedElement;
import org.eclipse.damos.dml.ITextualElement;
import org.eclipse.damos.dml.Inlet;
import org.eclipse.damos.dml.Inoutlet;
import org.eclipse.damos.dml.Inoutport;
import org.eclipse.damos.dml.Inoutput;
import org.eclipse.damos.dml.InoutputDefinition;
import org.eclipse.damos.dml.Inport;
import org.eclipse.damos.dml.InportInput;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputConnector;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.JoinInput;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.LatchInput;
import org.eclipse.damos.dml.LiteralValueSpecification;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.MemoryInitialCondition;
import org.eclipse.damos.dml.MemoryInput;
import org.eclipse.damos.dml.MemoryOutput;
import org.eclipse.damos.dml.Model;
import org.eclipse.damos.dml.Outlet;
import org.eclipse.damos.dml.Outport;
import org.eclipse.damos.dml.OutportOutput;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputConnector;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.damos.dml.Parameter;
import org.eclipse.damos.dml.ParameterPredefinedValue;
import org.eclipse.damos.dml.ParameterVisibilityKind;
import org.eclipse.damos.dml.ParameterableElement;
import org.eclipse.damos.dml.ParameterizedElement;
import org.eclipse.damos.dml.Port;
import org.eclipse.damos.dml.PrimitiveTypeKind;
import org.eclipse.damos.dml.PrimitiveTypeSpecification;
import org.eclipse.damos.dml.QualifiedElement;
import org.eclipse.damos.dml.SignalSpecification;
import org.eclipse.damos.dml.StringValueSpecification;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemInoutput;
import org.eclipse.damos.dml.SubsystemInput;
import org.eclipse.damos.dml.SubsystemOutput;
import org.eclipse.damos.dml.SubsystemRealization;
import org.eclipse.damos.dml.SynchronousTimingConstraint;
import org.eclipse.damos.dml.SystemInterface;
import org.eclipse.damos.dml.TimingConstraint;
import org.eclipse.damos.dml.TimingKind;
import org.eclipse.damos.dml.ValueSpecification;
import org.eclipse.damos.dml.WhileLoop;
import org.eclipse.damos.dml.WhileLoopCondition;
import org.eclipse.damos.dml.util.DMLValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

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
	private EClass timingConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass continuousTimingConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass synchronousTimingConstraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass asynchronousTimingConstraintEClass = null;

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
	private EClass connectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputConnectorEClass = null;

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
	private EClass dataTypeSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeSpecificationEClass = null;

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
	private EClass parameterPredefinedValueEClass = null;

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
	private EClass literalValueSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringValueSpecificationEClass = null;

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
	private EClass inportInputEClass = null;

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
	private EClass outportOutputEClass = null;

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
	private EClass latchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass latchInputEClass = null;

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
	private EClass compoundMemberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundInputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compoundOutputConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass choiceInputPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joinEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass joinInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileLoopConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryInitialConditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryInputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memoryOutputEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTextualElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum timingKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum parameterVisibilityKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveTypeKindEEnum = null;

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
	 * @see org.eclipse.damos.dml.DMLPackage#eNS_URI
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

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

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
	public EReference getComponent_TimingConstraint() {
		return (EReference)componentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimingConstraint() {
		return timingConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContinuousTimingConstraint() {
		return continuousTimingConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSynchronousTimingConstraint() {
		return synchronousTimingConstraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSynchronousTimingConstraint_SampleInterval() {
		return (EReference)synchronousTimingConstraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAsynchronousTimingConstraint() {
		return asynchronousTimingConstraintEClass;
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
	public EReference getConnection_Source() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnection_Target() {
		return (EReference)connectionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnector() {
		return connectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputConnector() {
		return inputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputConnector() {
		return outputConnectorEClass;
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
	public EAttribute getInoutputDefinition_TestPoint() {
		return (EAttribute)inoutputDefinitionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInoutputDefinition_Socket() {
		return (EAttribute)inoutputDefinitionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInoutputDefinition_DataType() {
		return (EReference)inoutputDefinitionEClass.getEStructuralFeatures().get(7);
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
	public EClass getDataTypeSpecification() {
		return dataTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeSpecification() {
		return primitiveTypeSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveTypeSpecification_Kind() {
		return (EAttribute)primitiveTypeSpecificationEClass.getEStructuralFeatures().get(0);
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
	public EReference getParameter_DataType() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Visibility() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_OwnedDefaultValue() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_PredefinedValues() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterPredefinedValue() {
		return parameterPredefinedValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterPredefinedValue_Alias() {
		return (EAttribute)parameterPredefinedValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterPredefinedValue_Value() {
		return (EReference)parameterPredefinedValueEClass.getEStructuralFeatures().get(1);
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
	public EClass getLiteralValueSpecification() {
		return literalValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringValueSpecification() {
		return stringValueSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringValueSpecification_Value() {
		return (EAttribute)stringValueSpecificationEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getBlockType_Timing() {
		return (EAttribute)blockTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlockType_Boundary() {
		return (EAttribute)blockTypeEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getQualifiedElement_PackageName() {
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
	public EReference getSubsystem_Interface() {
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
	public EClass getInportInput() {
		return inportInputEClass;
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
	public EClass getOutportOutput() {
		return outportOutputEClass;
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
	public EClass getLatch() {
		return latchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLatch_InitialValue() {
		return (EReference)latchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLatchInput() {
		return latchInputEClass;
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
	public EReference getCompound_Members() {
		return (EReference)compoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundMember() {
		return compoundMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundMember_OwningCompound() {
		return (EReference)compoundMemberEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundConnector() {
		return compoundConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompoundConnector_Compound() {
		return (EReference)compoundConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundInputConnector() {
		return compoundInputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompoundOutputConnector() {
		return compoundOutputConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoice() {
		return choiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getChoice_ActionLinks() {
		return (EReference)choiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceInput() {
		return choiceInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChoiceInputPort() {
		return choiceInputPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getChoiceInputPort_Name() {
		return (EAttribute)choiceInputPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAction_Link() {
		return (EReference)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionLink() {
		return actionLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionLink_Choice() {
		return (EReference)actionLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionLink_Action() {
		return (EReference)actionLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionLink_Condition() {
		return (EReference)actionLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoin() {
		return joinEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getJoinInput() {
		return joinInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileLoop() {
		return whileLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWhileLoop_Condition() {
		return (EReference)whileLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileLoopCondition() {
		return whileLoopConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemory() {
		return memoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryInitialCondition() {
		return memoryInitialConditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryInput() {
		return memoryInputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemoryOutput() {
		return memoryOutputEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getINamedElement() {
		return iNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITextualElement() {
		return iTextualElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTimingKind() {
		return timingKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getParameterVisibilityKind() {
		return parameterVisibilityKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitiveTypeKind() {
		return primitiveTypeKindEEnum;
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

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__INPUTS);
		createEReference(componentEClass, COMPONENT__OUTPUTS);
		createEAttribute(componentEClass, COMPONENT__NAME);
		createEReference(componentEClass, COMPONENT__TIMING_CONSTRAINT);

		timingConstraintEClass = createEClass(TIMING_CONSTRAINT);

		continuousTimingConstraintEClass = createEClass(CONTINUOUS_TIMING_CONSTRAINT);

		synchronousTimingConstraintEClass = createEClass(SYNCHRONOUS_TIMING_CONSTRAINT);
		createEReference(synchronousTimingConstraintEClass, SYNCHRONOUS_TIMING_CONSTRAINT__SAMPLE_INTERVAL);

		asynchronousTimingConstraintEClass = createEClass(ASYNCHRONOUS_TIMING_CONSTRAINT);

		fragmentElementEClass = createEClass(FRAGMENT_ELEMENT);
		createEReference(fragmentElementEClass, FRAGMENT_ELEMENT__OWNING_FRAGMENT);

		connectionEClass = createEClass(CONNECTION);
		createEReference(connectionEClass, CONNECTION__SOURCE);
		createEReference(connectionEClass, CONNECTION__TARGET);

		connectorEClass = createEClass(CONNECTOR);

		inputConnectorEClass = createEClass(INPUT_CONNECTOR);

		outputConnectorEClass = createEClass(OUTPUT_CONNECTOR);

		inoutputEClass = createEClass(INOUTPUT);

		inputEClass = createEClass(INPUT);
		createEReference(inputEClass, INPUT__PORTS);
		createEReference(inputEClass, INPUT__COMPONENT);

		outputEClass = createEClass(OUTPUT);
		createEReference(outputEClass, OUTPUT__COMPONENT);
		createEReference(outputEClass, OUTPUT__PORTS);

		portEClass = createEClass(PORT);

		inputPortEClass = createEClass(INPUT_PORT);
		createEReference(inputPortEClass, INPUT_PORT__INPUT);

		outputPortEClass = createEClass(OUTPUT_PORT);
		createEReference(outputPortEClass, OUTPUT_PORT__OUTPUT);
		createEReference(outputPortEClass, OUTPUT_PORT__SIGNAL);

		signalSpecificationEClass = createEClass(SIGNAL_SPECIFICATION);

		blockInoutputEClass = createEClass(BLOCK_INOUTPUT);

		blockInputEClass = createEClass(BLOCK_INPUT);
		createEReference(blockInputEClass, BLOCK_INPUT__DEFINITION);

		blockOutputEClass = createEClass(BLOCK_OUTPUT);
		createEReference(blockOutputEClass, BLOCK_OUTPUT__DEFINITION);

		inoutputDefinitionEClass = createEClass(INOUTPUT_DEFINITION);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__MINIMUM_PORT_COUNT);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__MAXIMUM_PORT_COUNT);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__DEFAULT_PORT_COUNT);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__MANY_PORTS);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__NAME);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__TEST_POINT);
		createEAttribute(inoutputDefinitionEClass, INOUTPUT_DEFINITION__SOCKET);
		createEReference(inoutputDefinitionEClass, INOUTPUT_DEFINITION__DATA_TYPE);

		inputDefinitionEClass = createEClass(INPUT_DEFINITION);
		createEReference(inputDefinitionEClass, INPUT_DEFINITION__DIRECT_FEEDTHROUGH_POLICY);

		outputDefinitionEClass = createEClass(OUTPUT_DEFINITION);

		parameterableElementEClass = createEClass(PARAMETERABLE_ELEMENT);
		createEReference(parameterableElementEClass, PARAMETERABLE_ELEMENT__PARAMETERS);

		parameterEClass = createEClass(PARAMETER);
		createEAttribute(parameterEClass, PARAMETER__NAME);
		createEReference(parameterEClass, PARAMETER__DATA_TYPE);
		createEAttribute(parameterEClass, PARAMETER__VISIBILITY);
		createEReference(parameterEClass, PARAMETER__OWNED_DEFAULT_VALUE);
		createEReference(parameterEClass, PARAMETER__PREDEFINED_VALUES);

		parameterPredefinedValueEClass = createEClass(PARAMETER_PREDEFINED_VALUE);
		createEAttribute(parameterPredefinedValueEClass, PARAMETER_PREDEFINED_VALUE__ALIAS);
		createEReference(parameterPredefinedValueEClass, PARAMETER_PREDEFINED_VALUE__VALUE);

		valueSpecificationEClass = createEClass(VALUE_SPECIFICATION);

		literalValueSpecificationEClass = createEClass(LITERAL_VALUE_SPECIFICATION);

		stringValueSpecificationEClass = createEClass(STRING_VALUE_SPECIFICATION);
		createEAttribute(stringValueSpecificationEClass, STRING_VALUE_SPECIFICATION__VALUE);

		dataTypeSpecificationEClass = createEClass(DATA_TYPE_SPECIFICATION);

		primitiveTypeSpecificationEClass = createEClass(PRIMITIVE_TYPE_SPECIFICATION);
		createEAttribute(primitiveTypeSpecificationEClass, PRIMITIVE_TYPE_SPECIFICATION__KIND);

		directFeedthroughPolicyEClass = createEClass(DIRECT_FEEDTHROUGH_POLICY);
		createEReference(directFeedthroughPolicyEClass, DIRECT_FEEDTHROUGH_POLICY__INPUT_DEFINITION);

		parameterizedElementEClass = createEClass(PARAMETERIZED_ELEMENT);
		createEReference(parameterizedElementEClass, PARAMETERIZED_ELEMENT__ARGUMENTS);

		argumentEClass = createEClass(ARGUMENT);
		createEReference(argumentEClass, ARGUMENT__VALUE);
		createEReference(argumentEClass, ARGUMENT__PARAMETER);

		blockTypeEClass = createEClass(BLOCK_TYPE);
		createEReference(blockTypeEClass, BLOCK_TYPE__INPUT_DEFINITIONS);
		createEReference(blockTypeEClass, BLOCK_TYPE__OUTPUT_DEFINITIONS);
		createEAttribute(blockTypeEClass, BLOCK_TYPE__TIMING);
		createEAttribute(blockTypeEClass, BLOCK_TYPE__BOUNDARY);

		qualifiedElementEClass = createEClass(QUALIFIED_ELEMENT);
		createEAttribute(qualifiedElementEClass, QUALIFIED_ELEMENT__QUALIFIED_NAME);
		createEAttribute(qualifiedElementEClass, QUALIFIED_ELEMENT__NAME);
		createEAttribute(qualifiedElementEClass, QUALIFIED_ELEMENT__PACKAGE_NAME);

		categorizedElementEClass = createEClass(CATEGORIZED_ELEMENT);
		createEReference(categorizedElementEClass, CATEGORIZED_ELEMENT__BELONGING_CATEGORIES);

		categoryEClass = createEClass(CATEGORY);

		blockEClass = createEClass(BLOCK);
		createEReference(blockEClass, BLOCK__TYPE);

		modelEClass = createEClass(MODEL);

		systemEClass = createEClass(SYSTEM);

		blockPortEClass = createEClass(BLOCK_PORT);

		blockInputPortEClass = createEClass(BLOCK_INPUT_PORT);

		blockOutputPortEClass = createEClass(BLOCK_OUTPUT_PORT);

		subsystemEClass = createEClass(SUBSYSTEM);
		createEReference(subsystemEClass, SUBSYSTEM__INTERFACE);

		systemInterfaceEClass = createEClass(SYSTEM_INTERFACE);
		createEReference(systemInterfaceEClass, SYSTEM_INTERFACE__INLETS);
		createEReference(systemInterfaceEClass, SYSTEM_INTERFACE__OUTLETS);

		inletEClass = createEClass(INLET);

		inoutletEClass = createEClass(INOUTLET);
		createEReference(inoutletEClass, INOUTLET__DATA_TYPE);
		createEAttribute(inoutletEClass, INOUTLET__NAME);

		outletEClass = createEClass(OUTLET);

		subsystemRealizationEClass = createEClass(SUBSYSTEM_REALIZATION);
		createEReference(subsystemRealizationEClass, SUBSYSTEM_REALIZATION__REALIZED_SUBSYSTEM);
		createEReference(subsystemRealizationEClass, SUBSYSTEM_REALIZATION__REALIZING_FRAGMENT);

		inportEClass = createEClass(INPORT);

		inportInputEClass = createEClass(INPORT_INPUT);

		inoutportEClass = createEClass(INOUTPORT);
		createEReference(inoutportEClass, INOUTPORT__DATA_TYPE);

		outportEClass = createEClass(OUTPORT);

		outportOutputEClass = createEClass(OUTPORT_OUTPUT);

		subsystemInoutputEClass = createEClass(SUBSYSTEM_INOUTPUT);

		subsystemInputEClass = createEClass(SUBSYSTEM_INPUT);
		createEReference(subsystemInputEClass, SUBSYSTEM_INPUT__INLET);

		subsystemOutputEClass = createEClass(SUBSYSTEM_OUTPUT);
		createEReference(subsystemOutputEClass, SUBSYSTEM_OUTPUT__OUTLET);

		booleanDirectFeedthroughPolicyEClass = createEClass(BOOLEAN_DIRECT_FEEDTHROUGH_POLICY);
		createEAttribute(booleanDirectFeedthroughPolicyEClass, BOOLEAN_DIRECT_FEEDTHROUGH_POLICY__DIRECT_FEEDTHROUGH);

		latchEClass = createEClass(LATCH);
		createEReference(latchEClass, LATCH__INITIAL_VALUE);

		latchInputEClass = createEClass(LATCH_INPUT);

		compoundEClass = createEClass(COMPOUND);
		createEReference(compoundEClass, COMPOUND__MEMBERS);

		compoundMemberEClass = createEClass(COMPOUND_MEMBER);
		createEReference(compoundMemberEClass, COMPOUND_MEMBER__OWNING_COMPOUND);

		compoundConnectorEClass = createEClass(COMPOUND_CONNECTOR);
		createEReference(compoundConnectorEClass, COMPOUND_CONNECTOR__COMPOUND);

		compoundInputConnectorEClass = createEClass(COMPOUND_INPUT_CONNECTOR);

		compoundOutputConnectorEClass = createEClass(COMPOUND_OUTPUT_CONNECTOR);

		choiceEClass = createEClass(CHOICE);
		createEReference(choiceEClass, CHOICE__ACTION_LINKS);

		choiceInputEClass = createEClass(CHOICE_INPUT);

		choiceInputPortEClass = createEClass(CHOICE_INPUT_PORT);
		createEAttribute(choiceInputPortEClass, CHOICE_INPUT_PORT__NAME);

		actionEClass = createEClass(ACTION);
		createEReference(actionEClass, ACTION__LINK);

		actionLinkEClass = createEClass(ACTION_LINK);
		createEReference(actionLinkEClass, ACTION_LINK__CHOICE);
		createEReference(actionLinkEClass, ACTION_LINK__ACTION);
		createEReference(actionLinkEClass, ACTION_LINK__CONDITION);

		joinEClass = createEClass(JOIN);

		joinInputEClass = createEClass(JOIN_INPUT);

		whileLoopEClass = createEClass(WHILE_LOOP);
		createEReference(whileLoopEClass, WHILE_LOOP__CONDITION);

		whileLoopConditionEClass = createEClass(WHILE_LOOP_CONDITION);

		memoryEClass = createEClass(MEMORY);

		memoryInitialConditionEClass = createEClass(MEMORY_INITIAL_CONDITION);

		memoryInputEClass = createEClass(MEMORY_INPUT);

		memoryOutputEClass = createEClass(MEMORY_OUTPUT);

		iNamedElementEClass = createEClass(INAMED_ELEMENT);

		iTextualElementEClass = createEClass(ITEXTUAL_ELEMENT);

		// Create enums
		parameterVisibilityKindEEnum = createEEnum(PARAMETER_VISIBILITY_KIND);
		primitiveTypeKindEEnum = createEEnum(PRIMITIVE_TYPE_KIND);
		timingKindEEnum = createEEnum(TIMING_KIND);
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

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		fragmentEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		fragmentEClass.getESuperTypes().add(this.getQualifiedElement());
		componentEClass.getESuperTypes().add(this.getFragmentElement());
		componentEClass.getESuperTypes().add(this.getCompoundMember());
		componentEClass.getESuperTypes().add(this.getINamedElement());
		continuousTimingConstraintEClass.getESuperTypes().add(this.getTimingConstraint());
		synchronousTimingConstraintEClass.getESuperTypes().add(this.getTimingConstraint());
		asynchronousTimingConstraintEClass.getESuperTypes().add(this.getTimingConstraint());
		fragmentElementEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		connectionEClass.getESuperTypes().add(this.getFragmentElement());
		inputConnectorEClass.getESuperTypes().add(this.getConnector());
		outputConnectorEClass.getESuperTypes().add(this.getConnector());
		inoutputEClass.getESuperTypes().add(this.getINamedElement());
		inputEClass.getESuperTypes().add(this.getInoutput());
		outputEClass.getESuperTypes().add(this.getInoutput());
		portEClass.getESuperTypes().add(this.getConnector());
		inputPortEClass.getESuperTypes().add(this.getPort());
		inputPortEClass.getESuperTypes().add(this.getInputConnector());
		outputPortEClass.getESuperTypes().add(this.getPort());
		outputPortEClass.getESuperTypes().add(this.getOutputConnector());
		blockInoutputEClass.getESuperTypes().add(this.getInoutput());
		blockInputEClass.getESuperTypes().add(this.getInput());
		blockInputEClass.getESuperTypes().add(this.getBlockInoutput());
		blockOutputEClass.getESuperTypes().add(this.getOutput());
		blockOutputEClass.getESuperTypes().add(this.getBlockInoutput());
		inoutputDefinitionEClass.getESuperTypes().add(this.getParameterableElement());
		inoutputDefinitionEClass.getESuperTypes().add(this.getINamedElement());
		inputDefinitionEClass.getESuperTypes().add(this.getInoutputDefinition());
		outputDefinitionEClass.getESuperTypes().add(this.getInoutputDefinition());
		parameterEClass.getESuperTypes().add(this.getINamedElement());
		literalValueSpecificationEClass.getESuperTypes().add(this.getValueSpecification());
		stringValueSpecificationEClass.getESuperTypes().add(this.getLiteralValueSpecification());
		primitiveTypeSpecificationEClass.getESuperTypes().add(this.getDataTypeSpecification());
		blockTypeEClass.getESuperTypes().add(theEcorePackage.getEModelElement());
		blockTypeEClass.getESuperTypes().add(this.getQualifiedElement());
		blockTypeEClass.getESuperTypes().add(this.getCategorizedElement());
		blockTypeEClass.getESuperTypes().add(this.getParameterableElement());
		qualifiedElementEClass.getESuperTypes().add(this.getINamedElement());
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
		systemInterfaceEClass.getESuperTypes().add(this.getQualifiedElement());
		inletEClass.getESuperTypes().add(this.getInoutlet());
		inoutletEClass.getESuperTypes().add(this.getINamedElement());
		outletEClass.getESuperTypes().add(this.getInoutlet());
		subsystemRealizationEClass.getESuperTypes().add(this.getFragmentElement());
		inportEClass.getESuperTypes().add(this.getInoutport());
		inportInputEClass.getESuperTypes().add(this.getInput());
		inoutportEClass.getESuperTypes().add(this.getComponent());
		outportEClass.getESuperTypes().add(this.getInoutport());
		outportOutputEClass.getESuperTypes().add(this.getOutput());
		subsystemInoutputEClass.getESuperTypes().add(this.getInoutput());
		subsystemInputEClass.getESuperTypes().add(this.getInput());
		subsystemInputEClass.getESuperTypes().add(this.getSubsystemInoutput());
		subsystemOutputEClass.getESuperTypes().add(this.getOutput());
		subsystemOutputEClass.getESuperTypes().add(this.getSubsystemInoutput());
		booleanDirectFeedthroughPolicyEClass.getESuperTypes().add(this.getDirectFeedthroughPolicy());
		latchEClass.getESuperTypes().add(this.getComponent());
		latchInputEClass.getESuperTypes().add(this.getInput());
		compoundEClass.getESuperTypes().add(this.getFragmentElement());
		compoundEClass.getESuperTypes().add(this.getCompoundMember());
		compoundConnectorEClass.getESuperTypes().add(this.getConnector());
		compoundInputConnectorEClass.getESuperTypes().add(this.getCompoundConnector());
		compoundInputConnectorEClass.getESuperTypes().add(this.getInputConnector());
		compoundOutputConnectorEClass.getESuperTypes().add(this.getCompoundConnector());
		compoundOutputConnectorEClass.getESuperTypes().add(this.getOutputConnector());
		choiceEClass.getESuperTypes().add(this.getComponent());
		choiceInputEClass.getESuperTypes().add(this.getInput());
		choiceInputPortEClass.getESuperTypes().add(this.getInputPort());
		choiceInputPortEClass.getESuperTypes().add(this.getINamedElement());
		actionEClass.getESuperTypes().add(this.getCompound());
		joinEClass.getESuperTypes().add(this.getComponent());
		joinInputEClass.getESuperTypes().add(this.getInput());
		whileLoopEClass.getESuperTypes().add(this.getAction());
		whileLoopConditionEClass.getESuperTypes().add(this.getCompoundInputConnector());
		memoryEClass.getESuperTypes().add(this.getComponent());
		memoryInitialConditionEClass.getESuperTypes().add(this.getInput());
		memoryInputEClass.getESuperTypes().add(this.getInput());
		memoryOutputEClass.getESuperTypes().add(this.getOutput());

		// Initialize classes and features; add operations and parameters
		initEClass(fragmentEClass, Fragment.class, "Fragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragment_Components(), this.getComponent(), null, "components", null, 0, -1, Fragment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getFragment_FragmentElements(), this.getFragmentElement(), this.getFragmentElement_OwningFragment(), "fragmentElements", null, 0, -1, Fragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getFragment_Connections(), this.getConnection(), null, "connections", null, 0, -1, Fragment.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getFragment_Parent(), this.getFragment(), null, "parent", null, 0, 1, Fragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(fragmentEClass, this.getFragment(), "getChildren", 0, -1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(fragmentEClass, this.getFragmentElement(), "getAllFragmentElements", 0, -1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(fragmentEClass, this.getComponent(), "getAllComponents", 0, -1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(fragmentEClass, this.getConnection(), "getAllConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_Inputs(), this.getInput(), this.getInput_Component(), "inputs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_Outputs(), this.getOutput(), this.getOutput_Component(), "outputs", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Name(), ecorePackage.getEString(), "name", null, 1, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponent_TimingConstraint(), this.getTimingConstraint(), null, "timingConstraint", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(componentEClass, this.getInput(), "getInput", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(componentEClass, this.getOutput(), "getOutput", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(componentEClass, this.getInputPort(), "getInputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getOutputPort(), "getOutputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getInputPort(), "getFirstInputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(componentEClass, this.getInputPort(), "getFirstInputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "inputName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getOutputPort(), "getFirstOutputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(componentEClass, this.getOutputPort(), "getFirstOutputPort", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "outputName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getInputPort(), "getPrimaryInputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getOutputPort(), "getPrimaryOutputPorts", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getInput(), "getInputSockets", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, this.getOutput(), "getOutputSockets", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, ecorePackage.getEBoolean(), "isSource", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(componentEClass, ecorePackage.getEBoolean(), "isSink", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(componentEClass, ecorePackage.getEBoolean(), "isTimingConstraintApplicable", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theEcorePackage.getEClass(), "eClass", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(componentEClass, ecorePackage.getEBoolean(), "isBoundary", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(timingConstraintEClass, TimingConstraint.class, "TimingConstraint", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(continuousTimingConstraintEClass, ContinuousTimingConstraint.class, "ContinuousTimingConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(synchronousTimingConstraintEClass, SynchronousTimingConstraint.class, "SynchronousTimingConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSynchronousTimingConstraint_SampleInterval(), this.getValueSpecification(), null, "sampleInterval", null, 1, 1, SynchronousTimingConstraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(asynchronousTimingConstraintEClass, AsynchronousTimingConstraint.class, "AsynchronousTimingConstraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(fragmentElementEClass, FragmentElement.class, "FragmentElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragmentElement_OwningFragment(), this.getFragment(), this.getFragment_FragmentElements(), "owningFragment", null, 0, 1, FragmentElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(fragmentElementEClass, this.getFragment(), "getEnclosingFragment", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(connectionEClass, Connection.class, "Connection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnection_Source(), this.getOutputConnector(), null, "source", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnection_Target(), this.getInputConnector(), null, "target", null, 1, 1, Connection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(connectorEClass, Connector.class, "Connector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(connectorEClass, this.getConnection(), "getConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(connectorEClass, this.getConnection(), "getConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(connectorEClass, this.getConnection(), "getFirstConnection", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(inputConnectorEClass, InputConnector.class, "InputConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outputConnectorEClass, OutputConnector.class, "OutputConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inoutputEClass, Inoutput.class, "Inoutput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(inoutputEClass, ecorePackage.getEString(), "getName", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(inoutputEClass, ecorePackage.getEBoolean(), "canAddPort", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(inoutputEClass, ecorePackage.getEBoolean(), "canRemovePort", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(inoutputEClass, this.getPort(), "createPort", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(inoutputEClass, ecorePackage.getEBoolean(), "isTestPoint", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(inoutputEClass, ecorePackage.getEBoolean(), "isSocket", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inputEClass, Input.class, "Input", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInput_Ports(), this.getInputPort(), this.getInputPort_Input(), "ports", null, 0, -1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInput_Component(), this.getComponent(), this.getComponent_Inputs(), "component", null, 1, 1, Input.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(inputEClass, ecorePackage.getEBoolean(), "isDirectFeedthrough", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(outputEClass, Output.class, "Output", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutput_Component(), this.getComponent(), this.getComponent_Outputs(), "component", null, 1, 1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutput_Ports(), this.getOutputPort(), this.getOutputPort_Output(), "ports", null, 0, -1, Output.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(portEClass, ecorePackage.getEInt(), "getIndex", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(portEClass, this.getComponent(), "getComponent", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(portEClass, this.getInoutput(), "getInoutput", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(inputPortEClass, InputPort.class, "InputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputPort_Input(), this.getInput(), this.getInput_Ports(), "input", null, 1, 1, InputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(inputPortEClass, this.getConnection(), "getIncomingConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(inputPortEClass, this.getConnection(), "getIncomingConnection", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(outputPortEClass, OutputPort.class, "OutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOutputPort_Output(), this.getOutput(), this.getOutput_Ports(), "output", null, 1, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOutputPort_Signal(), this.getSignalSpecification(), null, "signal", null, 0, 1, OutputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(outputPortEClass, this.getConnection(), "getOutgoingConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(outputPortEClass, this.getConnection(), "getOutgoingConnections", 0, -1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(signalSpecificationEClass, SignalSpecification.class, "SignalSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockInoutputEClass, BlockInoutput.class, "BlockInoutput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(blockInoutputEClass, this.getInoutputDefinition(), "getDefinition", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(blockInputEClass, BlockInput.class, "BlockInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockInput_Definition(), this.getInputDefinition(), null, "definition", null, 1, 1, BlockInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockOutputEClass, BlockOutput.class, "BlockOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockOutput_Definition(), this.getOutputDefinition(), null, "definition", null, 1, 1, BlockOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inoutputDefinitionEClass, InoutputDefinition.class, "InoutputDefinition", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInoutputDefinition_MinimumPortCount(), ecorePackage.getEInt(), "minimumPortCount", "1", 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_MaximumPortCount(), ecorePackage.getEInt(), "maximumPortCount", "1", 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_DefaultPortCount(), ecorePackage.getEInt(), "defaultPortCount", "-1", 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_ManyPorts(), ecorePackage.getEBoolean(), "manyPorts", null, 1, 1, InoutputDefinition.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_Name(), ecorePackage.getEString(), "name", null, 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutputDefinition_TestPoint(), ecorePackage.getEBoolean(), "testPoint", null, 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInoutputDefinition_Socket(), ecorePackage.getEBoolean(), "socket", null, 1, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInoutputDefinition_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 0, 1, InoutputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inputDefinitionEClass, InputDefinition.class, "InputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInputDefinition_DirectFeedthroughPolicy(), this.getDirectFeedthroughPolicy(), this.getDirectFeedthroughPolicy_InputDefinition(), "directFeedthroughPolicy", null, 0, 1, InputDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outputDefinitionEClass, OutputDefinition.class, "OutputDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterableElementEClass, ParameterableElement.class, "ParameterableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterableElement_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, ParameterableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(parameterableElementEClass, this.getParameter(), "getParameter", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameter_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Visibility(), this.getParameterVisibilityKind(), "visibility", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_OwnedDefaultValue(), this.getValueSpecification(), null, "ownedDefaultValue", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_PredefinedValues(), this.getParameterPredefinedValue(), null, "predefinedValues", null, 0, -1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(parameterEClass, this.getValueSpecification(), "getDefaultValue", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(parameterEClass, this.getParameterPredefinedValue(), "getPredefinedValue", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "stringValue", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(parameterEClass, this.getParameterPredefinedValue(), "getPredefinedValueByAlias", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "alias", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(parameterPredefinedValueEClass, ParameterPredefinedValue.class, "ParameterPredefinedValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getParameterPredefinedValue_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, ParameterPredefinedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterPredefinedValue_Value(), this.getValueSpecification(), null, "value", null, 1, 1, ParameterPredefinedValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valueSpecificationEClass, ValueSpecification.class, "ValueSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(valueSpecificationEClass, ecorePackage.getEString(), "stringValue", 1, 1, IS_UNIQUE, !IS_ORDERED);

		addEOperation(valueSpecificationEClass, this.getValueSpecification(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(literalValueSpecificationEClass, LiteralValueSpecification.class, "LiteralValueSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringValueSpecificationEClass, StringValueSpecification.class, "StringValueSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringValueSpecification_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringValueSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeSpecificationEClass, DataTypeSpecification.class, "DataTypeSpecification", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(dataTypeSpecificationEClass, this.getDataTypeSpecification(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(primitiveTypeSpecificationEClass, PrimitiveTypeSpecification.class, "PrimitiveTypeSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveTypeSpecification_Kind(), this.getPrimitiveTypeKind(), "kind", null, 0, 1, PrimitiveTypeSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(directFeedthroughPolicyEClass, DirectFeedthroughPolicy.class, "DirectFeedthroughPolicy", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectFeedthroughPolicy_InputDefinition(), this.getInputDefinition(), this.getInputDefinition_DirectFeedthroughPolicy(), "inputDefinition", null, 1, 1, DirectFeedthroughPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		addEOperation(directFeedthroughPolicyEClass, ecorePackage.getEBoolean(), "computeDirectFeedthrough", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(parameterizedElementEClass, ParameterizedElement.class, "ParameterizedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterizedElement_Arguments(), this.getArgument(), null, "arguments", null, 0, -1, ParameterizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(parameterizedElementEClass, this.getArgument(), "getArgument", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getParameter(), "parameter", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(parameterizedElementEClass, this.getArgument(), "getArgument", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameterName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(parameterizedElementEClass, ecorePackage.getEString(), "getArgumentStringValue", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "parameterName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(argumentEClass, Argument.class, "Argument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArgument_Value(), this.getValueSpecification(), null, "value", null, 0, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getArgument_Parameter(), this.getParameter(), null, "parameter", null, 1, 1, Argument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(blockTypeEClass, BlockType.class, "BlockType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockType_InputDefinitions(), this.getInputDefinition(), null, "inputDefinitions", null, 0, -1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlockType_OutputDefinitions(), this.getOutputDefinition(), null, "outputDefinitions", null, 0, -1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockType_Timing(), this.getTimingKind(), "timing", null, 1, 1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlockType_Boundary(), ecorePackage.getEBoolean(), "boundary", null, 0, 1, BlockType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(blockTypeEClass, this.getBlock(), "newInstance", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(qualifiedElementEClass, QualifiedElement.class, "QualifiedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getQualifiedElement_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 1, 1, QualifiedElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQualifiedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, QualifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getQualifiedElement_PackageName(), ecorePackage.getEString(), "packageName", null, 0, 1, QualifiedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(categorizedElementEClass, CategorizedElement.class, "CategorizedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategorizedElement_BelongingCategories(), this.getCategory(), null, "belongingCategories", null, 0, -1, CategorizedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(categorizedElementEClass, ecorePackage.getEBoolean(), "belongsTo", 1, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "categoryName", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlock_Type(), this.getBlockType(), null, "type", null, 1, 1, Block.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(blockEClass, this.getBlockInput(), "getInput", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInputDefinition(), "definition", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(blockEClass, this.getBlockOutput(), "getOutput", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getOutputDefinition(), "definition", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(systemEClass, org.eclipse.damos.dml.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockPortEClass, BlockPort.class, "BlockPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockInputPortEClass, BlockInputPort.class, "BlockInputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockOutputPortEClass, BlockOutputPort.class, "BlockOutputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subsystemEClass, Subsystem.class, "Subsystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystem_Interface(), this.getSystemInterface(), null, "interface", null, 1, 1, Subsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(subsystemEClass, this.getSubsystemRealization(), "getRealizations", 0, -1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(subsystemEClass, this.getSubsystemRealization(), "getRealization", 0, 1, IS_UNIQUE, !IS_ORDERED);
		addEParameter(op, this.getFragment(), "context", 1, 1, IS_UNIQUE, !IS_ORDERED);

		initEClass(systemInterfaceEClass, SystemInterface.class, "SystemInterface", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemInterface_Inlets(), this.getInlet(), null, "inlets", null, 0, -1, SystemInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystemInterface_Outlets(), this.getOutlet(), null, "outlets", null, 0, -1, SystemInterface.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inletEClass, Inlet.class, "Inlet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inoutletEClass, Inoutlet.class, "Inoutlet", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInoutlet_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 1, 1, Inoutlet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInoutlet_Name(), ecorePackage.getEString(), "name", null, 1, 1, Inoutlet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outletEClass, Outlet.class, "Outlet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subsystemRealizationEClass, SubsystemRealization.class, "SubsystemRealization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemRealization_RealizedSubsystem(), this.getSubsystem(), null, "realizedSubsystem", null, 1, 1, SubsystemRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSubsystemRealization_RealizingFragment(), this.getFragment(), null, "realizingFragment", null, 1, 1, SubsystemRealization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(inportEClass, Inport.class, "Inport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inportInputEClass, InportInput.class, "InportInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(inoutportEClass, Inoutport.class, "Inoutport", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInoutport_DataType(), this.getDataTypeSpecification(), null, "dataType", null, 1, 1, Inoutport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(outportEClass, Outport.class, "Outport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(outportOutputEClass, OutportOutput.class, "OutportOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(subsystemInoutputEClass, SubsystemInoutput.class, "SubsystemInoutput", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(subsystemInoutputEClass, this.getInoutlet(), "getInoutlet", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(subsystemInputEClass, SubsystemInput.class, "SubsystemInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemInput_Inlet(), this.getInlet(), null, "inlet", null, 1, 1, SubsystemInput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(subsystemOutputEClass, SubsystemOutput.class, "SubsystemOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSubsystemOutput_Outlet(), this.getOutlet(), null, "outlet", null, 1, 1, SubsystemOutput.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(booleanDirectFeedthroughPolicyEClass, BooleanDirectFeedthroughPolicy.class, "BooleanDirectFeedthroughPolicy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanDirectFeedthroughPolicy_DirectFeedthrough(), ecorePackage.getEBoolean(), "directFeedthrough", null, 1, 1, BooleanDirectFeedthroughPolicy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(latchEClass, Latch.class, "Latch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLatch_InitialValue(), this.getValueSpecification(), null, "initialValue", null, 1, 1, Latch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(latchInputEClass, LatchInput.class, "LatchInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundEClass, Compound.class, "Compound", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompound_Members(), this.getCompoundMember(), null, "members", null, 0, -1, Compound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundMemberEClass, CompoundMember.class, "CompoundMember", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundMember_OwningCompound(), this.getCompound(), null, "owningCompound", null, 0, 1, CompoundMember.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(compoundConnectorEClass, CompoundConnector.class, "CompoundConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompoundConnector_Compound(), this.getCompound(), null, "compound", null, 1, 1, CompoundConnector.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compoundInputConnectorEClass, CompoundInputConnector.class, "CompoundInputConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compoundOutputConnectorEClass, CompoundOutputConnector.class, "CompoundOutputConnector", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(choiceEClass, Choice.class, "Choice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChoice_ActionLinks(), this.getActionLink(), this.getActionLink_Choice(), "actionLinks", null, 2, -1, Choice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(choiceInputEClass, ChoiceInput.class, "ChoiceInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(choiceInputPortEClass, ChoiceInputPort.class, "ChoiceInputPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getChoiceInputPort_Name(), ecorePackage.getEString(), "name", null, 0, 1, ChoiceInputPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAction_Link(), this.getActionLink(), this.getActionLink_Action(), "link", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionLinkEClass, ActionLink.class, "ActionLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionLink_Choice(), this.getChoice(), this.getChoice_ActionLinks(), "choice", null, 1, 1, ActionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionLink_Action(), this.getAction(), this.getAction_Link(), "action", null, 1, 1, ActionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getActionLink_Condition(), this.getValueSpecification(), null, "condition", null, 0, 1, ActionLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(joinEClass, Join.class, "Join", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(joinInputEClass, JoinInput.class, "JoinInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(whileLoopEClass, WhileLoop.class, "WhileLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWhileLoop_Condition(), this.getWhileLoopCondition(), null, "condition", null, 0, 1, WhileLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileLoopConditionEClass, WhileLoopCondition.class, "WhileLoopCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryEClass, Memory.class, "Memory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryInitialConditionEClass, MemoryInitialCondition.class, "MemoryInitialCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryInputEClass, MemoryInput.class, "MemoryInput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memoryOutputEClass, MemoryOutput.class, "MemoryOutput", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iNamedElementEClass, INamedElement.class, "INamedElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(iNamedElementEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iTextualElementEClass, ITextualElement.class, "ITextualElement", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(iTextualElementEClass, ecorePackage.getEString(), "getText", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iTextualElementEClass, null, "setText", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(parameterVisibilityKindEEnum, ParameterVisibilityKind.class, "ParameterVisibilityKind");
		addEEnumLiteral(parameterVisibilityKindEEnum, ParameterVisibilityKind.PUBLIC);
		addEEnumLiteral(parameterVisibilityKindEEnum, ParameterVisibilityKind.PRIVATE);

		initEEnum(primitiveTypeKindEEnum, PrimitiveTypeKind.class, "PrimitiveTypeKind");
		addEEnumLiteral(primitiveTypeKindEEnum, PrimitiveTypeKind.STRING);

		initEEnum(timingKindEEnum, TimingKind.class, "TimingKind");
		addEEnumLiteral(timingKindEEnum, TimingKind.ANY);
		addEEnumLiteral(timingKindEEnum, TimingKind.CONTINUOUS);
		addEEnumLiteral(timingKindEEnum, TimingKind.SYNCHRONOUS);
		addEEnumLiteral(timingKindEEnum, TimingKind.ASYNCHRONOUS);
		addEEnumLiteral(timingKindEEnum, TimingKind.DISCRETE);

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
		addAnnotation
		  (connectionEClass, 
		   source, 
		   new String[] {
			 "constraints", "ValidCompoundConnection"
		   });		
		addAnnotation
		  (blockEClass, 
		   source, 
		   new String[] {
			 "constraints", "ValidInputDefinitionReferences ValidOutputDefinitionReferences ValidParameterReferences"
		   });		
		addAnnotation
		  (subsystemEClass, 
		   source, 
		   new String[] {
			 "constraints", "ValidInletReferences ValidOutletReferences"
		   });		
		addAnnotation
		  (subsystemRealizationEClass, 
		   source, 
		   new String[] {
			 "constraints", "MatchingFragment"
		   });		
		addAnnotation
		  (inoutportEClass, 
		   source, 
		   new String[] {
			 "constraints", "OwnedByFragment"
		   });		
		addAnnotation
		  (choiceEClass, 
		   source, 
		   new String[] {
			 "constraints", "ValidActionLinkConditions"
		   });		
		addAnnotation
		  (actionLinkEClass, 
		   source, 
		   new String[] {
			 "constraints", "ChoiceAndActionHaveSameOwner"
		   });		
		addAnnotation
		  (joinEClass, 
		   source, 
		   new String[] {
			 "constraints", "ValidActions ValidChoice"
		   });		
		addAnnotation
		  (whileLoopEClass, 
		   source, 
		   new String[] {
			 "constraints", "ConditionSourceInWhileLoop"
		   });		
		addAnnotation
		  (memoryEClass, 
		   source, 
		   new String[] {
			 "constraints", "OwnedByCompound InitialConditionSourceOnEnclosingElement"
		   });
	}

} //DMLPackageImpl
