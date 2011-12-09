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

package org.eclipselabs.damos.mscript.functionmodel.transform;

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.damos.mscript.Compound;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.internal.util.Scope;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationContext;

/**
 * @author Andreas Unger
 *
 */
public class TransformerContext implements ITransformerContext {

	private IStaticEvaluationContext staticEvaluationContext;
	
	private TransformerScope scope = new TransformerScope(null);
	
	private Map<VariableDeclaration, VariableDeclaration> variableDeclarationMappings = new HashMap<VariableDeclaration, VariableDeclaration>();
	
	/**
	 * 
	 */
	public TransformerContext(IStaticEvaluationContext staticEvaluationContext) {
		this.staticEvaluationContext = staticEvaluationContext;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.ITransformerContext#getStaticEvaluationContext()
	 */
	public IStaticEvaluationContext getStaticEvaluationContext() {
		return staticEvaluationContext;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerContext#enterScope()
	 */
	public void enterScope() {
		scope = new TransformerScope(scope);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerContext#leaveScope()
	 */
	public void leaveScope() {
		scope = scope.getOuterScope();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerContext#getCompound()
	 */
	public Compound getCompound() {
		return scope.getCompound();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerContext#setCompound(org.eclipselabs.mscript.language.il.Compound)
	 */
	public void setCompound(Compound compound) {
		scope.setCompound(compound);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.il.transform.ITransformerContext#addVariableDeclarationMapping(org.eclipselabs.damos.mscript.VariableDeclaration, org.eclipselabs.damos.mscript.VariableDeclaration)
	 */
	public void addVariableDeclarationMapping(VariableDeclaration oldVariableDeclaration,
			VariableDeclaration newVariableDeclaration) {
		variableDeclarationMappings.put(oldVariableDeclaration, newVariableDeclaration);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.mscript.il.transform.ITransformerContext#mapVariableDeclaration(org.eclipselabs.damos.mscript.VariableDeclaration)
	 */
	public VariableDeclaration mapVariableDeclaration(VariableDeclaration variableDeclaration) {
		VariableDeclaration newVariableDeclaration = variableDeclarationMappings.get(variableDeclaration);
		return newVariableDeclaration != null ? newVariableDeclaration : variableDeclaration;
	}

	private static class TransformerScope extends Scope<TransformerScope, String, VariableDeclaration> {
	
		private Compound compound;
		
		/**
		 * 
		 */
		public TransformerScope(TransformerScope outerScope) {
			super(outerScope);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerScope#getCompound()
		 */
		public Compound getCompound() {
			return compound;
		}
		
		/**
		 * @param compound the compound to set
		 */
		public void setCompound(Compound compound) {
			this.compound = compound;
		}
		
	}

}
