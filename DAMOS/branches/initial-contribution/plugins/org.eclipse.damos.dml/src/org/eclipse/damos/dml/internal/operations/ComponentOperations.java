/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.internal.operations;

import java.util.List;

import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputPort;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputPort;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.BasicInternalEList;

public class ComponentOperations {

	public static Input getInput(Component component, String name) {
		for (Input input : component.getInputs()) {
			if (name.equals(input.getName())) {
				return input;
			}
		}
		return null;
	}

	public static Output getOutput(Component component, String name) {
		for (Output output : component.getOutputs()) {
			if (name.equals(output.getName())) {
				return output;
			}
		}
		return null;
	}

	public static EList<InputPort> getInputPorts(Component component) {
		if (component.getInputs().isEmpty()) {
			return ECollections.emptyEList();
		}
		if (component.getInputs().size() == 1) {
			return getPrimaryInputPorts(component);
		}
		EList<InputPort> inputPorts = new BasicInternalEList<InputPort>(InputPort.class);
		for (Input input : component.getInputs()) {
			inputPorts.addAll(input.getPorts());
		}
		return ECollections.unmodifiableEList(inputPorts);
	}

	public static EList<OutputPort> getOutputPorts(Component component) {
		if (component.getOutputs().isEmpty()) {
			return ECollections.emptyEList();
		}
		if (component.getOutputs().size() == 1) {
			return getPrimaryOutputPorts(component);
		}
		EList<OutputPort> outputPorts = new BasicInternalEList<OutputPort>(OutputPort.class);
		for (Output output : component.getOutputs()) {
			outputPorts.addAll(output.getPorts());
		}
		return ECollections.unmodifiableEList(outputPorts);
	}

	public static InputPort getFirstInputPort(Component component) {
		List<Input> inputs = component.getInputs();
		if (!inputs.isEmpty()) {
			List<InputPort> inputPorts = inputs.get(0).getPorts();
			if (!inputPorts.isEmpty()) {
				return inputPorts.get(0);
			}
		}
		return null;
	}

	public static InputPort getFirstInputPort(Component component, String inputName) {
		Input input = component.getInput(inputName);
		if (input != null && !input.getPorts().isEmpty()) {
			return input.getPorts().get(0);
		}
		return null;
	}

	public static OutputPort getFirstOutputPort(Component component) {
		List<Output> outputs = component.getOutputs();
		if (!outputs.isEmpty()) {
			List<OutputPort> outputPorts = outputs.get(0).getPorts();
			if (!outputPorts.isEmpty()) {
				return outputPorts.get(0);
			}
		}
		return null;
	}

	public static OutputPort getFirstOutputPort(Component component, String outputName) {
		Output output = component.getOutput(outputName);
		if (output != null && !output.getPorts().isEmpty()) {
			return output.getPorts().get(0);
		}
		return null;
	}

	public static EList<InputPort> getPrimaryInputPorts(Component component) {
		EList<Input> inputs = component.getInputs();
		if (!inputs.isEmpty()) {
			return ECollections.unmodifiableEList(inputs.get(0).getPorts());
		}
		return ECollections.emptyEList();
	}

	public static EList<OutputPort> getPrimaryOutputPorts(Component component) {
		EList<Output> outputs = component.getOutputs();
		if (!outputs.isEmpty()) {
			return ECollections.unmodifiableEList(outputs.get(0).getPorts());
		}
		return ECollections.emptyEList();
	}
	
	public static EList<Input> getInputSockets(Component component) {
		EList<Input> inputSockets = null;
		for (Input input : component.getInputs()) {
			if (input.isSocket()) {
				if (inputSockets == null) {
					inputSockets = new BasicEList<Input>();
				}
				inputSockets.add(input);
			}
		}
		return inputSockets != null ? inputSockets : ECollections.<Input>emptyEList();
	}

	public static EList<Output> getOutputSockets(Component component) {
		EList<Output> outputSockets = null;
		for (Output output : component.getOutputs()) {
			if (output.isSocket()) {
				if (outputSockets == null) {
					outputSockets = new BasicEList<Output>();
				}
				outputSockets.add(output);
			}
		}
		return outputSockets != null ? outputSockets : ECollections.<Output>emptyEList();
	}

	public static boolean isSource(Component component) {
		return component.getInputs().isEmpty();
	}

	public static boolean isSink(Component component) {
		return component.getOutputs().isEmpty();
	}

}
