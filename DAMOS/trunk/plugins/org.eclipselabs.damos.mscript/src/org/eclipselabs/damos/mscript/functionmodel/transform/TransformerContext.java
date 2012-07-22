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

import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.internal.util.Scope;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;

/**
 * @author Andreas Unger
 *
 */
public class TransformerContext implements ITransformerContext {

	private IStaticEvaluationResult staticEvaluationResult;
	
	private TransformerScope scope = new TransformerScope(null);
	
	private Map<VariableDeclaration, VariableDeclaration> variableDeclarationMappings = new HashMap<VariableDeclaration, VariableDeclaration>();
	
	/**
	 * 
	 */
	public TransformerContext(IStaticEvaluationResult staticEvaluationResult) {
		this.staticEvaluationResult = staticEvaluationResult;
	}
	
	public IStaticEvaluationResult getStaticEvaluationResult() {
		return staticEvaluationResult;
	}
	
	public void enterScope() {
		scope = new TransformerScope(scope);
	}
	
	public void leaveScope() {
		scope = scope.getOuterScope();
	}
	
	public CompoundStatement getCompound() {
		return scope.getCompound();
	}
	
	public void setCompound(CompoundStatement compoundStatement) {
		scope.setCompound(compoundStatement);
	}
	
	public void addVariableDeclarationMapping(VariableDeclaration oldVariableDeclaration,
			VariableDeclaration newVariableDeclaration) {
		variableDeclarationMappings.put(oldVariableDeclaration, newVariableDeclaration);
	}

	public VariableDeclaration mapVariableDeclaration(VariableDeclaration variableDeclaration) {
		VariableDeclaration newVariableDeclaration = variableDeclarationMappings.get(variableDeclaration);
		return newVariableDeclaration != null ? newVariableDeclaration : variableDeclaration;
	}

	private static class TransformerScope extends Scope<TransformerScope, String, VariableDeclaration> {
	
		private CompoundStatement compoundStatement;
		
		/**
		 * 
		 */
		public TransformerScope(TransformerScope outerScope) {
			super(outerScope);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.il.transform.IExpressionTransformerScope#getCompound()
		 */
		public CompoundStatement getCompound() {
			return compoundStatement;
		}
		
		/**
		 * @param compoundStatement the compound to set
		 */
		public void setCompound(CompoundStatement compoundStatement) {
			this.compoundStatement = compoundStatement;
		}
		
	}

}
