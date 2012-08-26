/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.simulation.simulator.internal.simulationobjects;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.function.ComputationCompound;
import org.eclipselabs.damos.mscript.interpreter.CompoundStatementInterpreter;
import org.eclipselabs.damos.mscript.interpreter.ICompoundStatementInterpreter;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IInterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;
import org.eclipselabs.damos.mscript.interpreter.IVariable;
import org.eclipselabs.damos.mscript.interpreter.value.INumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.MatrixValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.interpreter.value.VectorValue;

/**
 * @author Andreas Unger
 *
 */
public class ContinuousBlockSimulationObject extends BehavioredBlockSimulationObject {

	private final ICompoundStatementInterpreter compoundStatementInterpreter = new CompoundStatementInterpreter();

	private double[] stateVector;
	private int[] stateVectorIndices;
	
	private boolean initialComputeDerivatives;
	private List<VariableDeclaration> derivatives = new ArrayList<VariableDeclaration>();
	
	private List<ComputationCompound> computeDerivativesCompounds = new ArrayList<ComputationCompound>();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#initialize()
	 */
	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		super.initialize(monitor);
		
		if (!derivatives.isEmpty()) {
			stateVectorIndices = new int[derivatives.size()];
			int n = 0;

			int i = 0;
			for (VariableDeclaration derivative : derivatives) {
				stateVectorIndices[i] = n;
				IValue value = getInterpreterContext().getVariable(derivative).getValue(0);
				if (value instanceof ISimpleNumericValue) {
					++n;
				} else if (value instanceof VectorValue) {
					VectorValue vectorValue = (VectorValue) value;
					n += vectorValue.getSize();
				} else if (value instanceof MatrixValue) {
					MatrixValue matrixValue = (MatrixValue) value;
					n += matrixValue.getRowSize() * matrixValue.getColumnSize();
				}
				++i;
			}
			
			stateVector = new double[n];
			i = 0;
			for (VariableDeclaration derivative : derivatives) {
				IValue value = getInterpreterContext().getVariable(derivative).getValue(0);
				if (value instanceof ISimpleNumericValue) {
					stateVector[i] = ((ISimpleNumericValue) value).doubleValue();
					++i;
				} else if (value instanceof VectorValue) {
					VectorValue vectorValue = (VectorValue) value;
					for (int j = 0; j < vectorValue.getSize(); ++j) {
						IValue elementValue = vectorValue.get(j);
						if (elementValue instanceof ISimpleNumericValue) {
							stateVector[i] = ((ISimpleNumericValue) elementValue).doubleValue();
						}
						++i;
					}
				} else if (value instanceof MatrixValue) {
					MatrixValue matrixValue = (MatrixValue) value;
					for (int j = 0; j < matrixValue.getRowSize(); ++j) {
						for (int k = 0; k < matrixValue.getColumnSize(); ++k) {
							IValue elementValue = matrixValue.get(j, k);
							if (elementValue instanceof ISimpleNumericValue) {
								stateVector[i] = ((ISimpleNumericValue) elementValue).doubleValue();
							}
							++i;
						}
					}
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.BehavioredBlockSimulationObject#initializeComputationCompound(org.eclipselabs.damos.mscript.function.ComputationCompound)
	 */
	@Override
	protected void initializeComputationCompound(ComputationCompound compound) {
		if (compound.getDerivatives().isEmpty()) {
			super.initializeComputationCompound(compound);
		} else {
			computeDerivativesCompounds.add(compound);
			derivatives.addAll(compound.getDerivatives());
			initialComputeDerivatives = true;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#getStateVector()
	 */
	@Override
	public double[] getStateVector() {
		return stateVector;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeDerivatives(double, double[], double[])
	 */
	@Override
	public void computeDerivatives(double t, double[] y, double[] yDot) {
		if (initialComputeDerivatives) {
			initialComputeDerivatives = false;
		} else {
			IInterpreterContext context = new DerivativeInterpreterContext(getInterpreterContext(), y, yDot);
			for (ComputationCompound compound : computeDerivativesCompounds) {
				compoundStatementInterpreter.execute(context, compound);
			}
		}
		
		int i = 0;
		for (VariableDeclaration derivative : derivatives) {
			IVariable variable = getInterpreterContext().getVariable(derivative);
			IValue value = variable.getValue(0);
			if (value instanceof INumericValue) {
				variable.setValue(0, Values.valueOf(getComputationContext(), (NumericType) value.getDataType(), y[i++]));
			} else if (value instanceof VectorValue) {
				VectorValue vectorValue = (VectorValue) value;
				IValue[] elements = new IValue[vectorValue.getSize()];
				for (int j = 0; j < vectorValue.getSize(); ++j) {
					elements[j] = Values.valueOf(getComputationContext(), (NumericType) vectorValue.getDataType().getElementType(), y[i++]);
				}
				variable.setValue(0, new VectorValue(getComputationContext(), vectorValue.getDataType(), elements));
			} else if (value instanceof MatrixValue) {
				MatrixValue matrixValue = (MatrixValue) value;
				IValue[][] elements = new IValue[matrixValue.getRowSize()][matrixValue.getColumnSize()];
				for (int j = 0; j < matrixValue.getRowSize(); ++j) {
					for (int k = 0; k < matrixValue.getColumnSize(); ++k) {
						elements[j][k] = Values.valueOf(getComputationContext(), (NumericType) matrixValue.getDataType().getElementType(), y[i++]);
					}
				}
				variable.setValue(0, new MatrixValue(getComputationContext(), matrixValue.getDataType(), elements));
			}
		}
	}
	
	private class DerivativeInterpreterContext implements IInterpreterContext {

		private final IInterpreterContext context;
		private final double[] y;
		private final double[] yDot;
		
		/**
		 * 
		 */
		public DerivativeInterpreterContext(IInterpreterContext context, double[] y, double[] yDot) {
			this.context = context;
			this.y = y;
			this.yDot = yDot;
		}
		
		public IStaticEvaluationResult getStaticEvaluationResult() {
			return context.getStaticEvaluationResult();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#getComputationContext()
		 */
		public IComputationContext getComputationContext() {
			return context.getComputationContext();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#enterScope()
		 */
		public void enterVariableScope() {
			context.enterVariableScope();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#leaveScope()
		 */
		public void leaveVariableScope() {
			context.leaveVariableScope();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#getVariable(org.eclipselabs.damos.mscript.VariableDeclaration)
		 */
		public IVariable getVariable(VariableDeclaration variableDeclaration) {
			int index = derivatives.indexOf(variableDeclaration);
			if (index != -1) {
				return new DerivativeVariable(context, variableDeclaration, stateVectorIndices[index], y, yDot);
			}
			return context.getVariable(variableDeclaration);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#addVariable(org.eclipselabs.damos.mscript.interpreter.IVariable)
		 */
		public void addVariable(IVariable variable) {
			context.addVariable(variable);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#setCanceled(boolean)
		 */
		public void setCanceled(boolean canceled) {
			context.setCanceled(canceled);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#isCanceled()
		 */
		public boolean isCanceled() {
			return context.isCanceled();
		}
		
	}

	private static class DerivativeVariable implements IVariable {

		private final IInterpreterContext context;
		private final VariableDeclaration variableDeclaration;
		private final int index;
		private final double[] y;
		private final double[] yDot;

		public DerivativeVariable(IInterpreterContext context, VariableDeclaration variableDeclaration, int index, double[] y, double[] yDot) {
			this.context = context;
			this.variableDeclaration = variableDeclaration;
			this.index = index;
			this.y = y;
			this.yDot = yDot;
		}

		public VariableDeclaration getDeclaration() {
			return variableDeclaration;
		}
		
		public IValue getValue(int stepIndex) {
			IValue value = context.getVariable(variableDeclaration).getValue(stepIndex);
			int i = index;
			if (value instanceof ISimpleNumericValue) {
				return Values.valueOf(context.getComputationContext(), (NumericType) value.getDataType(), y[i++]);
			} else if (value instanceof VectorValue) {
				VectorValue vectorValue = (VectorValue) value;
				IValue[] elements = new IValue[vectorValue.getSize()];
				for (int j = 0; j < vectorValue.getSize(); ++j) {
					elements[j] = Values.valueOf(context.getComputationContext(), (NumericType) vectorValue.getDataType().getElementType(), y[i++]);
				}
				return new VectorValue(context.getComputationContext(), vectorValue.getDataType(), elements);
			} else if (value instanceof MatrixValue) {
				MatrixValue matrixValue = (MatrixValue) value;
				IValue[][] elements = new IValue[matrixValue.getRowSize()][matrixValue.getColumnSize()];
				for (int j = 0; j < matrixValue.getRowSize(); ++j) {
					for (int k = 0; k < matrixValue.getColumnSize(); ++k) {
						elements[j][k] = Values.valueOf(context.getComputationContext(), (NumericType) matrixValue.getDataType().getElementType(), y[i++]);
					}
				}
				return new MatrixValue(context.getComputationContext(), matrixValue.getDataType(), elements);
			}
			throw new IllegalStateException();
		}

		public void setValue(int stepIndex, IValue value) {
			int i = index;
			if (value instanceof ISimpleNumericValue) {
				yDot[i] = ((ISimpleNumericValue) value).doubleValue();
			} else if (value instanceof VectorValue) {
				VectorValue vectorValue = (VectorValue) value;
				for (int j = 0; j < vectorValue.getSize(); ++j) {
					yDot[i++] = ((ISimpleNumericValue) vectorValue.get(j)).doubleValue();
				}
			} else if (value instanceof MatrixValue) {
				MatrixValue matrixValue = (MatrixValue) value;
				for (int j = 0; j < matrixValue.getRowSize(); ++j) {
					for (int k = 0; k < matrixValue.getColumnSize(); ++k) {
						yDot[i++] = ((ISimpleNumericValue) matrixValue.get(j, k)).doubleValue();
					}
				}
			}
		}

		public void incrementStepIndex() {
			throw new UnsupportedOperationException("Derivative variables cannot be incremented");
		}

	}

}
