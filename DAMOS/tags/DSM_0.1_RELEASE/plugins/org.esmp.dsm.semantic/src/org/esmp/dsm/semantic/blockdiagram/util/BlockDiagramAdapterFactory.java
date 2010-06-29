/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockCategory;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage;
import org.esmp.dsm.semantic.blockdiagram.BlockType;
import org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.Connection;
import org.esmp.dsm.semantic.blockdiagram.Enumeration;
import org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral;
import org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.IOSpecification;
import org.esmp.dsm.semantic.blockdiagram.Input;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.InputSpecification;
import org.esmp.dsm.semantic.blockdiagram.NamedElement;
import org.esmp.dsm.semantic.blockdiagram.Output;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputSpecification;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor;
import org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer;
import org.esmp.dsm.semantic.blockdiagram.ParameterableElement;
import org.esmp.dsm.semantic.blockdiagram.Port;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage
 * @generated
 */
public class BlockDiagramAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BlockDiagramPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BlockDiagramPackage.eINSTANCE;
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
	protected BlockDiagramSwitch<Adapter> modelSwitch =
		new BlockDiagramSwitch<Adapter>() {
			@Override
			public Adapter caseBlockDiagram(BlockDiagram object) {
				return createBlockDiagramAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseBlock(Block object) {
				return createBlockAdapter();
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
			public Adapter caseParameterDescriptor(ParameterDescriptor object) {
				return createParameterDescriptorAdapter();
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
			public Adapter caseOutputSpecification(OutputSpecification object) {
				return createOutputSpecificationAdapter();
			}
			@Override
			public Adapter caseIOSpecification(IOSpecification object) {
				return createIOSpecificationAdapter();
			}
			@Override
			public Adapter caseParameterDescriptorContainer(ParameterDescriptorContainer object) {
				return createParameterDescriptorContainerAdapter();
			}
			@Override
			public Adapter caseInput(Input object) {
				return createInputAdapter();
			}
			@Override
			public Adapter caseInputSpecification(InputSpecification object) {
				return createInputSpecificationAdapter();
			}
			@Override
			public Adapter caseBlockType(BlockType object) {
				return createBlockTypeAdapter();
			}
			@Override
			public Adapter caseBlockCategory(BlockCategory object) {
				return createBlockCategoryAdapter();
			}
			@Override
			public Adapter caseExpressionParameterDescriptor(ExpressionParameterDescriptor object) {
				return createExpressionParameterDescriptorAdapter();
			}
			@Override
			public Adapter caseBooleanParameterDescriptor(BooleanParameterDescriptor object) {
				return createBooleanParameterDescriptorAdapter();
			}
			@Override
			public Adapter caseEnumerationParameterDescriptor(EnumerationParameterDescriptor object) {
				return createEnumerationParameterDescriptorAdapter();
			}
			@Override
			public Adapter caseEnumeration(Enumeration object) {
				return createEnumerationAdapter();
			}
			@Override
			public Adapter caseEnumerationLiteral(EnumerationLiteral object) {
				return createEnumerationLiteralAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.BlockDiagram <em>Block Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagram
	 * @generated
	 */
	public Adapter createBlockDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.Block
	 * @generated
	 */
	public Adapter createBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.ParameterableElement <em>Parameterable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterableElement
	 * @generated
	 */
	public Adapter createParameterableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.Connection
	 * @generated
	 */
	public Adapter createConnectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.InputPort <em>Input Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputPort
	 * @generated
	 */
	public Adapter createInputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.OutputPort <em>Output Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputPort
	 * @generated
	 */
	public Adapter createOutputPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.Input <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.Input
	 * @generated
	 */
	public Adapter createInputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.Output <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.Output
	 * @generated
	 */
	public Adapter createOutputAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.OutputSpecification <em>Output Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.OutputSpecification
	 * @generated
	 */
	public Adapter createOutputSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.IOSpecification <em>IO Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.IOSpecification
	 * @generated
	 */
	public Adapter createIOSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer <em>Parameter Descriptor Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterDescriptorContainer
	 * @generated
	 */
	public Adapter createParameterDescriptorContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.BlockType <em>Block Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockType
	 * @generated
	 */
	public Adapter createBlockTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor <em>Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.ParameterDescriptor
	 * @generated
	 */
	public Adapter createParameterDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.InputSpecification <em>Input Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.InputSpecification
	 * @generated
	 */
	public Adapter createInputSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor <em>Expression Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.ExpressionParameterDescriptor
	 * @generated
	 */
	public Adapter createExpressionParameterDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor <em>Enumeration Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationParameterDescriptor
	 * @generated
	 */
	public Adapter createEnumerationParameterDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.Enumeration <em>Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.Enumeration
	 * @generated
	 */
	public Adapter createEnumerationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor <em>Boolean Parameter Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.BooleanParameterDescriptor
	 * @generated
	 */
	public Adapter createBooleanParameterDescriptorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral <em>Enumeration Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.EnumerationLiteral
	 * @generated
	 */
	public Adapter createEnumerationLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.esmp.dsm.semantic.blockdiagram.BlockCategory <em>Block Category</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.esmp.dsm.semantic.blockdiagram.BlockCategory
	 * @generated
	 */
	public Adapter createBlockCategoryAdapter() {
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

} //BlockDiagramAdapterFactory
