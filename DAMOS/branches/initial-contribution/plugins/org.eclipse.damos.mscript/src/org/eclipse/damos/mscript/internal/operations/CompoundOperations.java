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

package org.eclipse.damos.mscript.internal.operations;

import org.eclipse.damos.mscript.CompoundStatement;
import org.eclipse.damos.mscript.LocalVariableDeclaration;
import org.eclipse.damos.mscript.Statement;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

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
