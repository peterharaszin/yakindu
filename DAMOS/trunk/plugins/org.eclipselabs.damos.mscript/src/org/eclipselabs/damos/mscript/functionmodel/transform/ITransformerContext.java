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

import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.VariableDeclaration;
import org.eclipselabs.damos.mscript.interpreter.IStaticEvaluationResult;

/**
 * @author Andreas Unger
 *
 * @noextend
 * @noimplement
 */
public interface ITransformerContext {

	IStaticEvaluationResult getStaticEvaluationResult();
	
	void enterScope();
	void leaveScope();
	
	CompoundStatement getCompound();
	void setCompound(CompoundStatement compoundStatement);
	
	void addVariableDeclarationMapping(VariableDeclaration oldVariableDeclaration, VariableDeclaration newVariableDeclaration);
	VariableDeclaration mapVariableDeclaration(VariableDeclaration variableDeclaration);
	
}