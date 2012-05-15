/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.mscript.interpreter;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.mscript.Evaluable;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.internal.MscriptPlugin;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;

/**
 * @author Andreas Unger
 *
 */
public class StaticExpressionEvaluator {

	public IStatus evaluate(IStaticEvaluationContext context, Expression expression) {
		return evaluate(context, expression, false);
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IExpressionValueEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IEvaluationContext, org.eclipselabs.mscript.language.ast.Expression)
	 */
	public IStatus evaluate(IStaticEvaluationContext context, Expression expression, boolean staticScope) {
		Switch switch_ = new Switch(context, staticScope);
		switch_.evaluate(expression);
		return switch_.getStatus();
	}
	
	private static class Switch extends ExpressionEvaluatorSwitch {
		
		private final IStaticEvaluationContext context;

		private final MultiStatus status = new MultiStatus(MscriptPlugin.PLUGIN_ID, 0, "Expression evaluation", null);

		public Switch(IStaticEvaluationContext context, boolean staticScope) {
			super(staticScope);
			this.context = context;
		}
		
		/**
		 * @return the status
		 */
		public MultiStatus getStatus() {
			return status;
		}

		public IValue evaluate(Expression expression) {
			IValue value = doSwitch(expression);
			setStaticValue(expression, value);
			return value;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorSwitch#setValue(org.eclipselabs.damos.mscript.Evaluable, org.eclipselabs.damos.mscript.interpreter.value.IValue)
		 */
		@Override
		protected void setStaticValue(Evaluable evaluable, IValue value) {
			context.setValue(evaluable, value);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorSwitch#getValue(org.eclipselabs.damos.mscript.Evaluable)
		 */
		@Override
		protected IValue getStaticValue(Evaluable evaluable) {
			return context.getValue(evaluable);
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorSwitch#getComputationContext()
		 */
		@Override
		protected IComputationContext getComputationContext() {
			return context.getComputationContext();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorSwitch#isCollectStatus()
		 */
		@Override
		protected boolean isCollectStatus() {
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.damos.mscript.interpreter.ExpressionEvaluatorSwitch#collectStatus(org.eclipse.core.runtime.IStatus)
		 */
		@Override
		protected void collectStatus(IStatus status) {
			this.status.add(status);
		}
		
	}
	
}
