/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.dml.internal.operations;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputPort;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Component</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.dml.Component#getInputPorts() <em>Get Input Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Component#getOutputPorts() <em>Get Output Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Component#getFirstInputPort() <em>Get First Input Port</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Component#getFirstOutputPort() <em>Get First Output Port</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Component#getPrimaryInputPorts() <em>Get Primary Input Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Component#getPrimaryOutputPorts() <em>Get Primary Output Ports</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Component#isSource() <em>Is Source</em>}</li>
 *   <li>{@link org.eclipselabs.damos.dml.Component#isSink() <em>Is Sink</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<InputPort> getInputPorts(Component component) {
		EList<InputPort> inputPorts = new BasicInternalEList<InputPort>(InputPort.class);
		for (Input input : component.getInputs()) {
			inputPorts.addAll(input.getPorts());
		}
		return inputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<OutputPort> getOutputPorts(Component component) {
		EList<OutputPort> outputPorts = new BasicInternalEList<OutputPort>(OutputPort.class);
		for (Output output : component.getOutputs()) {
			outputPorts.addAll(output.getPorts());
		}
		return outputPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  InputPort getFirstInputPort(Component component) {
		List<Input> inputs = component.getInputs();
		if (!inputs.isEmpty()) {
			List<InputPort> inputPorts = inputs.get(0).getPorts();
			if (!inputPorts.isEmpty()) {
				return inputPorts.get(0);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  OutputPort getFirstOutputPort(Component component) {
		List<Output> outputs = component.getOutputs();
		if (!outputs.isEmpty()) {
			List<OutputPort> outputPorts = outputs.get(0).getPorts();
			if (!outputPorts.isEmpty()) {
				return outputPorts.get(0);
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<InputPort> getPrimaryInputPorts(Component component) {
		EList<Input> inputs = component.getInputs();
		if (!inputs.isEmpty()) {
			return ECollections.unmodifiableEList(inputs.get(0).getPorts());
		}
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  EList<OutputPort> getPrimaryOutputPorts(Component component) {
		EList<Output> outputs = component.getOutputs();
		if (!outputs.isEmpty()) {
			return ECollections.unmodifiableEList(outputs.get(0).getPorts());
		}
		return ECollections.emptyEList();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isSource(Component component) {
		return component.getInputs().isEmpty();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isSink(Component component) {
		return component.getOutputs().isEmpty();
	}

} // ComponentOperations