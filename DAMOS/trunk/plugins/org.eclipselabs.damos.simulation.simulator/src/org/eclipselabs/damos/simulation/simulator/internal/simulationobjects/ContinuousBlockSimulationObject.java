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
import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.functionmodel.ComputationCompound;
import org.eclipselabs.damos.mscript.interpreter.CompoundInterpreter;
import org.eclipselabs.damos.mscript.interpreter.ICompoundInterpreter;
import org.eclipselabs.damos.mscript.interpreter.IComputationContext;
import org.eclipselabs.damos.mscript.interpreter.IInterpreterContext;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;
import org.eclipselabs.damos.mscript.interpreter.IVariable;
import org.eclipselabs.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;

/**
 * @author Andreas Unger
 *
 */
public class ContinuousBlockSimulationObject extends BehavioredBlockSimulationObject {

	private final ICompoundInterpreter compoundInterpreter = new CompoundInterpreter();

	private double[] stateVector;
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
			stateVector = new double[derivatives.size()];
			int i = 0;
			for (VariableDeclaration derivative : derivatives) {
				ISimpleNumericValue value = (ISimpleNumericValue) getInterpreterContext().getVariable(derivative).getValue(0);
				stateVector[i++] = value.doubleValue();
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.internal.simulationobjects.BehavioredBlockSimulationObject#initializeComputationCompound(org.eclipselabs.damos.mscript.functionmodel.ComputationCompound)
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
			IInterpreterContext context = new DerivativeInterpreterContext(getInterpreterContext(), yDot);
			for (ComputationCompound compound : computeDerivativesCompounds) {
				compoundInterpreter.execute(context, compound);
			}
		}
		
		int i = 0;
		for (VariableDeclaration derivative : derivatives) {
			IVariable variable = getInterpreterContext().getVariable(derivative);
			DataType dataType = variable.getValue(0).getDataType();
			variable.setValue(0, Values.valueOf(getComputationContext(), (NumericType) dataType, y[i++]));
		}
	}
	
	private class DerivativeInterpreterContext implements IInterpreterContext {

		private final IInterpreterContext context;
		private final double[] yDot;
		
		/**
		 * 
		 */
		public DerivativeInterpreterContext(IInterpreterContext context, double[] yDot) {
			this.context = context;
			this.yDot = yDot;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#getStaticEvaluationContext()
		 */
		public IStaticEvaluationContext getStaticEvaluationContext() {
			return context.getStaticEvaluationContext();
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
		public void enterScope() {
			context.enterScope();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#leaveScope()
		 */
		public void leaveScope() {
			context.leaveScope();
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.IInterpreterContext#getVariable(org.eclipselabs.damos.mscript.VariableDeclaration)
		 */
		public IVariable getVariable(final VariableDeclaration variableDeclaration) {
			final int index = derivatives.indexOf(variableDeclaration);
			if (index != -1) {
				return new IVariable() {
					
					public void setValue(int stepIndex, IValue value) {
						yDot[index] = ((ISimpleNumericValue) value).doubleValue();
					}
					
					public void incrementStepIndex() {
						throw new UnsupportedOperationException("Derivative variables cannot be incremented");
					}
					
					public IValue getValue(int stepIndex) {
						return context.getVariable(variableDeclaration).getValue(stepIndex);
					}
					
					public VariableDeclaration getDeclaration() {
						return variableDeclaration;
					}
					
				};
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

}
