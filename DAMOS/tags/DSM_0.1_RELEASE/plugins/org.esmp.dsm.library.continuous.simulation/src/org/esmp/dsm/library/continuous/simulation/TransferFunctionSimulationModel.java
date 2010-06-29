/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.esmp.dsm.library.continuous.simulation;

import org.esmp.dsm.common.math.jama.Matrix;
import org.esmp.dsm.expressions.util.ExpressionsUtil;
import org.esmp.dsm.library.continuous.util.TransferFunctionConstants;
import org.esmp.dsm.semantic.blockdiagram.InputPort;
import org.esmp.dsm.semantic.blockdiagram.OutputPort;
import org.esmp.dsm.simulation.AbstractSimulationModel;
import org.esmp.dsm.simulation.Value;
import org.esmp.dsm.simulation.ValueFactory;

public class TransferFunctionSimulationModel extends AbstractSimulationModel {

	private Matrix stateMatrix;
	private Matrix stateVector;
	private Matrix inputVector;
	private Matrix outputMatrix;
	
	public void initialize() {
		double[] numeratorCoefficients = getCoefficients(TransferFunctionConstants.PARAMETER__NUMERATOR_COEFFICIENTS);
		if (numeratorCoefficients == null) {
			numeratorCoefficients = new double[] { 1 };
		}
		
		double[] denominatorCoefficients = getCoefficients(TransferFunctionConstants.PARAMETER__DENOMINATOR_COEFFICIENTS);
		if (denominatorCoefficients == null) {
			denominatorCoefficients = new double[] { 1, 1 };
		}
		
		if (denominatorCoefficients[0] != 0 && denominatorCoefficients[0] != 1) {
			double d0 = denominatorCoefficients[0];
			for (int i = 0; i < numeratorCoefficients.length; ++i) {
				numeratorCoefficients[i] /= d0;
			}
			for (int i = 0; i < denominatorCoefficients.length; ++i) {
				denominatorCoefficients[i] /= d0;
			}
		}
		
		int stateVariableCount = denominatorCoefficients.length - 1;
		if (stateVariableCount < 1) {
			stateVariableCount = 1;
		}
		
		stateMatrix = new Matrix(stateVariableCount, stateVariableCount);
		stateVector = new Matrix(stateVariableCount, 1);
		inputVector = new Matrix(stateVariableCount, 1);
		outputMatrix = new Matrix(1, stateVariableCount);
		
		for (int j = 0; j < denominatorCoefficients.length - 1; ++j) {
			stateMatrix.set(0, j, -denominatorCoefficients[j + 1]);
		}
		for (int i = 1; i < stateVariableCount; ++i) {
			stateMatrix.set(i, i - 1, 1);
		}
		
		int numeratorOffset = stateVariableCount - numeratorCoefficients.length;
		if (numeratorOffset < 0) {
			numeratorOffset = 0;
		}
		for (int j = numeratorOffset; j < stateVariableCount; ++j) {
			outputMatrix.set(0, j, numeratorCoefficients[j - numeratorOffset]);
		}
	}
	
	public void consumeInputValue(InputPort inputPort, Value value) {
		inputVector.set(0, 0, value.toDouble());
	}
	
	public Value getOutputValue(OutputPort outputPort) {
		return ValueFactory.INSTANCE.newValue(this, getBlockDataType(), outputMatrix.times(stateVector).get(0, 0));
	}
	
	public void update() {
		stateVector = stateVector.plus(stateMatrix.times(stateVector).plus(inputVector).times(1.0 / getContext().getSamplingFrequency()));
	}
	
	private double[] getCoefficients(String parameterName) {
		double[] coefficients = null;
		String param = getBlock().getParameterValue(parameterName);
		if (param != null) {
			coefficients = ExpressionsUtil.parseListExpression(param);
			if (coefficients.length > 0) {
				int firstNonZeroIndex = 0;
				while (firstNonZeroIndex < coefficients.length && coefficients[firstNonZeroIndex] == 0) {
					++firstNonZeroIndex;
				}
				if (firstNonZeroIndex == coefficients.length) {
					coefficients = null;
				} else if (firstNonZeroIndex > 0) {
					double[] temp = new double[coefficients.length - firstNonZeroIndex];
					System.arraycopy(coefficients, firstNonZeroIndex, temp, 0, temp.length);
					coefficients = temp;
				}
			}
		}
		return coefficients;
	}
	
}
