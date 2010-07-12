/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.damos.dml.Argument;
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

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.dml.DMLPackage
 * @generated
 */
public class DMLAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DMLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DMLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DMLPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DMLSwitch<Adapter> modelSwitch =
		new DMLSwitch<Adapter>() {
			@Override
			public Adapter caseFragment(Fragment object) {
				return createFragmentAdapter();
			}
			@Override
			public Adapter caseComponent(Component object) {
				return createComponentAdapter();
			}
			@Override
			public Adapter caseFragmentElement(FragmentElement object) {
				return createFragmentElementAdapter();
			}
			@Override
			public Adapter caseInput(Input object) {
				return createInputAdapter();
			}
			@Override
			public Adapter caseInoutput(Inoutput object) {
				return createInoutputAdapter();
			}
			@Override
			public Adapter caseInputPort(InputPort object) {
				return createInputPortAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseConnection(Connection object) {
				return createConnectionAdapter();
			}
			@Override
			public Adapter caseOutputPort(OutputPort object) {
				return createOutputPortAdapter();
			}
			@Override
			public Adapter caseOutput(Output object) {
				return createOutputAdapter();
			}
			@Override
			public Adapter caseSignalSpecification(SignalSpecification object) {
				return createSignalSpecificationAdapter();
			}
			@Override
			public Adapter caseBlockInput(BlockInput object) {
				return createBlockInputAdapter();
			}
			@Override
			public Adapter caseBlockInoutput(BlockInoutput object) {
				return createBlockInoutputAdapter();
			}
			@Override
			public Adapter caseInputDefinition(InputDefinition object) {
				return createInputDefinitionAdapter();
			}
			@Override
			public Adapter caseInoutputDefinition(InoutputDefinition object) {
				return createInoutputDefinitionAdapter();
			}
			@Override
			public Adapter caseParameterableElement(ParameterableElement object) {
				return createParameterableElementAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object) {
				return createParameterAdapter();
			}
			@Override
			public Adapter caseValueSpecification(ValueSpecification object) {
				return createValueSpecificationAdapter();
			}
			@Override
			public Adapter caseDataTypeSpecification(DataTypeSpecification object) {
				return createDataTypeSpecificationAdapter();
			}
			@Override
			public Adapter caseDirectFeedthroughPolicy(DirectFeedthroughPolicy object) {
				return createDirectFeedthroughPolicyAdapter();
			}
			@Override
			public Adapter caseBlockOutput(BlockOutput object) {
				return createBlockOutputAdapter();
			}
			@Override
			public Adapter caseOutputDefinition(OutputDefinition object) {
				return createOutputDefinitionAdapter();
			}
			@Override
			public Adapter caseParameterizedElement(ParameterizedElement object) {
				return createParameterizedElementAdapter();
			}
			@Override
			public Adapter caseArgument(Argument object) {
				return createArgumentAdapter();
			}
			@Override
			public Adapter caseExpressionParameter(ExpressionParameter object) {
				return createExpressionParameterAdapter();
			}
			@Override
			public Adapter caseExpressionSpecification(ExpressionSpecification object) {
				return createExpressionSpecificationAdapter();
			}
			@Override
			public Adapter casePredefinedExpressionEntry(PredefinedExpressionEntry object) {
				return createPredefinedExpressionEntryAdapter();
			}
			@Override
			public Adapter caseBlockType(BlockType object) {
				return createBlockTypeAdapter();
			}
			@Override
			public Adapter caseQualifiedElement(QualifiedElement object) {
				return createQualifiedElementAdapter();
			}
			@Override
			public Adapter caseCategorizedElement(CategorizedElement object) {
				return createCategorizedElementAdapter();
			}
			@Override
			public Adapter caseCategory(Category object) {
				return createCategoryAdapter();
			}
			@Override
			public Adapter caseBlock(Block object) {
				return createBlockAdapter();
			}
			@Override
			public Adapter caseModel(Model object) {
				return createModelAdapter();
			}
			@Override
			public Adapter caseSystem(org.eclipselabs.damos.dml.System object) {
				return createSystemAdapter();
			}
			@Override
			public Adapter caseBlockPort(BlockPort object) {
				return createBlockPortAdapter();
			}
			@Override
			public Adapter caseBlockInputPort(BlockInputPort object) {
				return createBlockInputPortAdapter();
			}
			@Override
			public Adapter caseBlockOutputPort(BlockOutputPort object) {
				return createBlockOutputPortAdapter();
			}
			@Override
			public Adapter caseSubsystem(Subsystem object) {
				return createSubsystemAdapter();
			}
			@Override
			public Adapter caseSystemInterface(SystemInterface object) {
				return createSystemInterfaceAdapter();
			}
			@Override
			public Adapter caseInlet(Inlet object) {
				return createInletAdapter();
			}
			@Override
			public Adapter caseInoutlet(Inoutlet object) {
				return createInoutletAdapter();
			}
			@Override
			public Adapter caseOutlet(Outlet object) {
				return createOutletAdapter();
			}
			@Override
			public Adapter caseSubsystemRealization(SubsystemRealization object) {
				return createSubsystemRealizationAdapter();
			}
			@Override
			public Adapter caseInport(Inport object) {
				return createInportAdapter();
			}
			@Override
			public Adapter caseInoutport(Inoutport object) {
				return createInoutportAdapter();
			}
			@Override
			public Adapter caseOutport(Outport object) {
				return createOutportAdapter();
			}
			@Override
			public Adapter caseSubsystemInoutput(SubsystemInoutput object) {
				return createSubsystemInoutputAdapter();
			}
			@Override
			public Adapter caseSubsystemInput(SubsystemInput object) {
				return createSubsystemInputAdapter();
			}
			@Override
			public Adapter caseSubsystemOutput(SubsystemOutput object) {
				return createSubsystemOutputAdapter();
			}
			@Override
			public Adapter caseBooleanDirectFeedthroughPolicy(BooleanDirectFeedthroughPolicy object) {
				return createBooleanDirectFeedthroughPolicyAdapter();
			}
			@Override
			public Adapter caseOpaqueDataTypeSpecification(OpaqueDataTypeSpecification object) {
				return createOpaqueDataTypeSpecificationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Fragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Fragment
	 * @generated
	 */
	public Adapter createFragmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Component
	 * @generated
	 */
	public Adapter createComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.FragmentElement <em>Fragment Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.FragmentElement
	 * @generated
	 */
	public Adapter createFragmentElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.InputPort
	 * @generated
	 */
	public Adapter createInputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.OutputPort
	 * @generated
	 */
	public Adapter createOutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Output
	 * @generated
	 */
	public Adapter createOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.SignalSpecification <em>Signal Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.SignalSpecification
	 * @generated
	 */
	public Adapter createSignalSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Inoutput <em>Inoutput</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Inoutput
	 * @generated
	 */
	public Adapter createInoutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Input
	 * @generated
	 */
	public Adapter createInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BlockInput <em>Block Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BlockInput
	 * @generated
	 */
	public Adapter createBlockInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BlockInoutput <em>Block Inoutput</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BlockInoutput
	 * @generated
	 */
	public Adapter createBlockInoutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.InputDefinition <em>Input Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.InputDefinition
	 * @generated
	 */
	public Adapter createInputDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.InoutputDefinition <em>Inoutput Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.InoutputDefinition
	 * @generated
	 */
	public Adapter createInoutputDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.OutputDefinition <em>Output Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.OutputDefinition
	 * @generated
	 */
	public Adapter createOutputDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.ParameterizedElement <em>Parameterized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.ParameterizedElement
	 * @generated
	 */
	public Adapter createParameterizedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Argument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Argument
	 * @generated
	 */
	public Adapter createArgumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.ExpressionParameter <em>Expression Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.ExpressionParameter
	 * @generated
	 */
	public Adapter createExpressionParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.ExpressionSpecification <em>Expression Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.ExpressionSpecification
	 * @generated
	 */
	public Adapter createExpressionSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.PredefinedExpressionEntry <em>Predefined Expression Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.PredefinedExpressionEntry
	 * @generated
	 */
	public Adapter createPredefinedExpressionEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.DataTypeSpecification <em>Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.DataTypeSpecification
	 * @generated
	 */
	public Adapter createDataTypeSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.ParameterableElement <em>Parameterable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.ParameterableElement
	 * @generated
	 */
	public Adapter createParameterableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.ValueSpecification <em>Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.ValueSpecification
	 * @generated
	 */
	public Adapter createValueSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.DirectFeedthroughPolicy <em>Direct Feedthrough Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.DirectFeedthroughPolicy
	 * @generated
	 */
	public Adapter createDirectFeedthroughPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BlockOutput <em>Block Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BlockOutput
	 * @generated
	 */
	public Adapter createBlockOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BlockType
	 * @generated
	 */
	public Adapter createBlockTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.QualifiedElement <em>Qualified Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.QualifiedElement
	 * @generated
	 */
	public Adapter createQualifiedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.CategorizedElement <em>Categorized Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.CategorizedElement
	 * @generated
	 */
	public Adapter createCategorizedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Category <em>Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Category
	 * @generated
	 */
	public Adapter createCategoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Model
	 * @generated
	 */
	public Adapter createModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.System
	 * @generated
	 */
	public Adapter createSystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Block
	 * @generated
	 */
	public Adapter createBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BlockPort <em>Block Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BlockPort
	 * @generated
	 */
	public Adapter createBlockPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BlockInputPort <em>Block Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BlockInputPort
	 * @generated
	 */
	public Adapter createBlockInputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BlockOutputPort <em>Block Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BlockOutputPort
	 * @generated
	 */
	public Adapter createBlockOutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Subsystem <em>Subsystem</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Subsystem
	 * @generated
	 */
	public Adapter createSubsystemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.SystemInterface <em>System Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.SystemInterface
	 * @generated
	 */
	public Adapter createSystemInterfaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Inlet <em>Inlet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Inlet
	 * @generated
	 */
	public Adapter createInletAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Inoutlet <em>Inoutlet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Inoutlet
	 * @generated
	 */
	public Adapter createInoutletAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Outlet <em>Outlet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Outlet
	 * @generated
	 */
	public Adapter createOutletAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Inport <em>Inport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Inport
	 * @generated
	 */
	public Adapter createInportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Inoutport <em>Inoutport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Inoutport
	 * @generated
	 */
	public Adapter createInoutportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.Outport <em>Outport</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.Outport
	 * @generated
	 */
	public Adapter createOutportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.SubsystemInoutput <em>Subsystem Inoutput</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.SubsystemInoutput
	 * @generated
	 */
	public Adapter createSubsystemInoutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.SubsystemInput <em>Subsystem Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.SubsystemInput
	 * @generated
	 */
	public Adapter createSubsystemInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.SubsystemOutput <em>Subsystem Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.SubsystemOutput
	 * @generated
	 */
	public Adapter createSubsystemOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.SubsystemRealization <em>Subsystem Realization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.SubsystemRealization
	 * @generated
	 */
	public Adapter createSubsystemRealizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy <em>Boolean Direct Feedthrough Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.BooleanDirectFeedthroughPolicy
	 * @generated
	 */
	public Adapter createBooleanDirectFeedthroughPolicyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipselabs.damos.dml.OpaqueDataTypeSpecification <em>Opaque Data Type Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipselabs.damos.dml.OpaqueDataTypeSpecification
	 * @generated
	 */
	public Adapter createOpaqueDataTypeSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DMLAdapterFactory
