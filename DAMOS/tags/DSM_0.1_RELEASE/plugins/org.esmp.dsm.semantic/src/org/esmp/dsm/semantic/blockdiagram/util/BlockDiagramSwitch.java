/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.esmp.dsm.semantic.blockdiagram.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.esmp.dsm.semantic.blockdiagram.BlockDiagramPackage
 * @generated
 */
public class BlockDiagramSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BlockDiagramPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockDiagramSwitch() {
		if (modelPackage == null) {
			modelPackage = BlockDiagramPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case BlockDiagramPackage.BLOCK_DIAGRAM: {
				BlockDiagram blockDiagram = (BlockDiagram)theEObject;
				T result = caseBlockDiagram(blockDiagram);
				if (result == null) result = caseNamedElement(blockDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.BLOCK: {
				Block block = (Block)theEObject;
				T result = caseBlock(block);
				if (result == null) result = caseNamedElement(block);
				if (result == null) result = caseParameterableElement(block);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.PARAMETERABLE_ELEMENT: {
				ParameterableElement parameterableElement = (ParameterableElement)theEObject;
				T result = caseParameterableElement(parameterableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseNamedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.PARAMETER_DESCRIPTOR: {
				ParameterDescriptor parameterDescriptor = (ParameterDescriptor)theEObject;
				T result = caseParameterDescriptor(parameterDescriptor);
				if (result == null) result = caseNamedElement(parameterDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.INPUT_PORT: {
				InputPort inputPort = (InputPort)theEObject;
				T result = caseInputPort(inputPort);
				if (result == null) result = casePort(inputPort);
				if (result == null) result = caseParameterableElement(inputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseParameterableElement(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.CONNECTION: {
				Connection connection = (Connection)theEObject;
				T result = caseConnection(connection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.OUTPUT_PORT: {
				OutputPort outputPort = (OutputPort)theEObject;
				T result = caseOutputPort(outputPort);
				if (result == null) result = casePort(outputPort);
				if (result == null) result = caseParameterableElement(outputPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.OUTPUT: {
				Output output = (Output)theEObject;
				T result = caseOutput(output);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.OUTPUT_SPECIFICATION: {
				OutputSpecification outputSpecification = (OutputSpecification)theEObject;
				T result = caseOutputSpecification(outputSpecification);
				if (result == null) result = caseIOSpecification(outputSpecification);
				if (result == null) result = caseNamedElement(outputSpecification);
				if (result == null) result = caseParameterDescriptorContainer(outputSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.IO_SPECIFICATION: {
				IOSpecification ioSpecification = (IOSpecification)theEObject;
				T result = caseIOSpecification(ioSpecification);
				if (result == null) result = caseNamedElement(ioSpecification);
				if (result == null) result = caseParameterDescriptorContainer(ioSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.PARAMETER_DESCRIPTOR_CONTAINER: {
				ParameterDescriptorContainer parameterDescriptorContainer = (ParameterDescriptorContainer)theEObject;
				T result = caseParameterDescriptorContainer(parameterDescriptorContainer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.INPUT: {
				Input input = (Input)theEObject;
				T result = caseInput(input);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.INPUT_SPECIFICATION: {
				InputSpecification inputSpecification = (InputSpecification)theEObject;
				T result = caseInputSpecification(inputSpecification);
				if (result == null) result = caseIOSpecification(inputSpecification);
				if (result == null) result = caseNamedElement(inputSpecification);
				if (result == null) result = caseParameterDescriptorContainer(inputSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.BLOCK_TYPE: {
				BlockType blockType = (BlockType)theEObject;
				T result = caseBlockType(blockType);
				if (result == null) result = caseNamedElement(blockType);
				if (result == null) result = caseParameterDescriptorContainer(blockType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.BLOCK_CATEGORY: {
				BlockCategory blockCategory = (BlockCategory)theEObject;
				T result = caseBlockCategory(blockCategory);
				if (result == null) result = caseNamedElement(blockCategory);
				if (result == null) result = caseParameterDescriptorContainer(blockCategory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.EXPRESSION_PARAMETER_DESCRIPTOR: {
				ExpressionParameterDescriptor expressionParameterDescriptor = (ExpressionParameterDescriptor)theEObject;
				T result = caseExpressionParameterDescriptor(expressionParameterDescriptor);
				if (result == null) result = caseParameterDescriptor(expressionParameterDescriptor);
				if (result == null) result = caseNamedElement(expressionParameterDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.BOOLEAN_PARAMETER_DESCRIPTOR: {
				BooleanParameterDescriptor booleanParameterDescriptor = (BooleanParameterDescriptor)theEObject;
				T result = caseBooleanParameterDescriptor(booleanParameterDescriptor);
				if (result == null) result = caseParameterDescriptor(booleanParameterDescriptor);
				if (result == null) result = caseNamedElement(booleanParameterDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.ENUMERATION_PARAMETER_DESCRIPTOR: {
				EnumerationParameterDescriptor enumerationParameterDescriptor = (EnumerationParameterDescriptor)theEObject;
				T result = caseEnumerationParameterDescriptor(enumerationParameterDescriptor);
				if (result == null) result = caseParameterDescriptor(enumerationParameterDescriptor);
				if (result == null) result = caseNamedElement(enumerationParameterDescriptor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.ENUMERATION: {
				Enumeration enumeration = (Enumeration)theEObject;
				T result = caseEnumeration(enumeration);
				if (result == null) result = caseNamedElement(enumeration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case BlockDiagramPackage.ENUMERATION_LITERAL: {
				EnumerationLiteral enumerationLiteral = (EnumerationLiteral)theEObject;
				T result = caseEnumerationLiteral(enumerationLiteral);
				if (result == null) result = caseNamedElement(enumerationLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockDiagram(BlockDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterableElement(ParameterableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Connection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConnection(Connection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputPort(InputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputPort(OutputPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInput(Input object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutput(Output object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputSpecification(OutputSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IO Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IO Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIOSpecification(IOSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Descriptor Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Descriptor Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDescriptorContainer(ParameterDescriptorContainer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockType(BlockType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDescriptor(ParameterDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Input Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Input Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInputSpecification(InputSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Parameter Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Parameter Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionParameterDescriptor(ExpressionParameterDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Parameter Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Parameter Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationParameterDescriptor(EnumerationParameterDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeration(Enumeration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Parameter Descriptor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Parameter Descriptor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanParameterDescriptor(BooleanParameterDescriptor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationLiteral(EnumerationLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Category</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockCategory(BlockCategory object) {
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
	public T defaultCase(EObject object) {
		return null;
	}

} //BlockDiagramSwitch
