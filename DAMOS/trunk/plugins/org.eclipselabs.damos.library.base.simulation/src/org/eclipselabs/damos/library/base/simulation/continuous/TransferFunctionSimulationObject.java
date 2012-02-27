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

package org.eclipselabs.damos.library.base.simulation.continuous;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.common.math.jama.Matrix;
import org.eclipselabs.damos.execution.util.ExpressionUtil;
import org.eclipselabs.damos.library.base.simulation.LibraryBaseSimulationPlugin;
import org.eclipselabs.damos.library.base.util.continuous.TransferFunctionConstants;
import org.eclipselabs.damos.mscript.MscriptFactory;
import org.eclipselabs.damos.mscript.RealType;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.interpreter.value.IArrayValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;

public class TransferFunctionSimulationObject extends AbstractBlockSimulationObject {

	private RealType outputDataType;
	
	private IValue outputValue;
	
	private Matrix stateMatrix;
	private double[] stateVector;
	private Matrix inputVector;
	private Matrix outputMatrix;
	
	private double[] y;
		
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		outputDataType = MscriptFactory.eINSTANCE.createRealType();
		outputDataType.setUnit(TypeUtil.createUnit());
		
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
		stateVector = new double[stateVariableCount];
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
		
		y = new double[stateVariableCount];
	}
	
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		inputVector.set(0, 0, ((ISimpleNumericValue) value).doubleValue());
	}

	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue;
	}
	
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		outputValue = Values.valueOf(getComputationContext(), outputDataType, outputMatrix.times(vectorToMatrix(y)).get(0, 0));
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getStateVector()
	 */
	@Override
	public double[] getStateVector() {
		return stateVector;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeDerivatives(double, double[])
	 */
	@Override
	public void computeDerivatives(double t, double[] y, double[] yDot) {
		Matrix yDotMatrix = stateMatrix.times(vectorToMatrix(y)).plus(inputVector);
		for (int i = 0; i < yDotMatrix.getRowDimension(); ++i) {
			yDot[i] = yDotMatrix.get(i, 0);
		}
		System.arraycopy(y, 0, this.y, 0, y.length);
	}
	
	private static Matrix vectorToMatrix(double[] vector) {
		return new Matrix(vector, 1).transpose();
	}
	
	private double[] getCoefficients(String parameterName) throws CoreException {
		double[] coefficients = null;
		IValue coefficientVector = ExpressionUtil.evaluateArgumentExpression(getComponent(), parameterName);

		if (!(coefficientVector.getDataType() instanceof TensorType)) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Parameter '"
					+ parameterName + "' of block '" + getComponent().getName() + "' must be vector"));
		}

		if (!(coefficientVector instanceof IArrayValue)) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Parameter '"
					+ parameterName + "' of block '" + getComponent().getName() + "' contains invalid value"));
		}

		TensorType tensorType = (TensorType) coefficientVector.getDataType();
		IArrayValue arrayValue = (IArrayValue) coefficientVector;
		
		int arraySize = TypeUtil.getArraySize(tensorType);
		coefficients = new double[arraySize];
		for (int i = 0; i < arraySize; ++i) {
			IValue element = arrayValue.get(i);
			if (!(element instanceof ISimpleNumericValue)) {
				throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Parameter '"
						+ parameterName + "' of block '" + getComponent().getName() + "' contains invalid vector value"));
			}
			coefficients[i] = ((ISimpleNumericValue) element).doubleValue();
		}
		
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

		return coefficients;
	}
	
}
