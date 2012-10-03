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

package org.eclipse.damos.codegen.c.internal.componentgenerators;

import org.eclipse.damos.mscript.FeatureReference;
import org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy;

/**
 * @author Andreas Unger
 *
 */
class ChoiceVariableAccessStrategy implements IVariableAccessStrategy {

	public CharSequence generateContextMemberAccess(boolean pointer, String memberName) {
		return "";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.mscript.codegen.c.IVariableAccessStrategy#generateVariableReference(org.eclipse.damos.mscript.FeatureReference)
	 */
	public CharSequence generateVariableReference(FeatureReference variableReference) {
		return "";
	}

}
