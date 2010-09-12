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

package org.eclipselabs.damos.evaluation.internal;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.evaluation.EvaluationPlugin;
import org.eclipselabs.damos.evaluation.IEvaluationContext;
import org.eclipselabs.damos.evaluation.util.EvaluationUtil;
import org.eclipselabs.damos.scripting.mscript.SymbolReference;
import org.eclipselabs.damos.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class BlockEvaluationContext implements IEvaluationContext {

	private ComponentEvaluationContext delegate;
	
	/**
	 * 
	 */
	public BlockEvaluationContext(ComponentEvaluationContext delegate) {
		if (!(delegate.getComponent() instanceof Block)) {
			throw new IllegalArgumentException();
		}
		this.delegate = delegate;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.IEvaluationContext#getSymbolDataType(org.eclipselabs.damos.scripting.mscript.SymbolReference)
	 */
	public DataType getSymbolDataType(SymbolReference symbolReference) throws CoreException {
		if (!symbolReference.isGlobal()
				&& !symbolReference.isFunctionCall()
				&& symbolReference.getComponentReferences().isEmpty()
				&& symbolReference.getName().getIdentifiers().size() == 1) {
			String name = symbolReference.getName().getIdentifiers().get(0);
			return EvaluationUtil.evaluateArgumentDataType(this, getBlock(), name);
		}
		throw new CoreException(new Status(IStatus.ERROR, EvaluationPlugin.PLUGIN_ID, "Symbol '" + symbolReference.getName().getIdentifiers().get(0) + "' not found"));
	}
	
	private Block getBlock() {
		return (Block) delegate.getComponent();
	}

}
