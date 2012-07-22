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

package org.eclipselabs.damos.mscript.internal.operations;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.mscript.CompoundStatement;
import org.eclipselabs.damos.mscript.LocalVariableDeclaration;
import org.eclipselabs.damos.mscript.Statement;

/**
 * @author Andreas Unger
 *
 */
public class CompoundOperations {

	public static EList<LocalVariableDeclaration> getLocalVariableDeclarations(CompoundStatement compoundStatement) {
		EList<LocalVariableDeclaration> localVariableDeclarations = new BasicEList<LocalVariableDeclaration>();
		for (Statement statement : compoundStatement.getStatements()) {
			if (statement instanceof LocalVariableDeclaration) {
				localVariableDeclarations.add((LocalVariableDeclaration) statement);
			}
		}
		return localVariableDeclarations;
	}

}
