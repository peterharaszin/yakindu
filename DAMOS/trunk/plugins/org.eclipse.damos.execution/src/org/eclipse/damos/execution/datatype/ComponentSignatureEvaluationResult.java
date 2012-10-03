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

package org.eclipse.damos.execution.datatype;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignatureEvaluationResult implements IComponentSignatureEvaluationResult {

	private IComponentSignature signature;
	
	private IStatus status = Status.OK_STATUS;
	
	/**
	 * 
	 */
	public ComponentSignatureEvaluationResult() {
	}
	
	public ComponentSignatureEvaluationResult(IComponentSignature signature) {
		this.signature = signature;
	}
	
	public ComponentSignatureEvaluationResult(IStatus status) {
		this.status = status;
	}

	public ComponentSignatureEvaluationResult(IComponentSignature signature, IStatus status) {
		this.signature = signature;
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.execution.componentsignature.IComponentSignatureEvaluationResult#getSignature()
	 */
	public IComponentSignature getSignature() {
		return signature;
	}
	
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(IComponentSignature signature) {
		this.signature = signature;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.damos.execution.componentsignature.IComponentSignatureEvaluationResult#getStatus()
	 */
	public IStatus getStatus() {
		return status;
	}
	
	/**
	 * @param status the status to set
	 */
	public void setStatus(IStatus status) {
		this.status = status;
	}

}
