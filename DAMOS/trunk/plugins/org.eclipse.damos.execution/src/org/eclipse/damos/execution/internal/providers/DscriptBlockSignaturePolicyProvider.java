/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.execution.internal.providers;

import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dscript.DscriptBlockType;
import org.eclipse.damos.execution.datatype.IComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.IComponentSignaturePolicyProvider;
import org.eclipse.damos.execution.internal.signaturepolicies.DscriptBlockSignaturePolicy;

public class DscriptBlockSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	public IComponentSignaturePolicy createPolicy(Component component) {
		if (component instanceof Block) {
			Block block = (Block) component;
			if (block.getType() instanceof DscriptBlockType) {
				DscriptBlockType blockType = (DscriptBlockType) block.getType();
				if (blockType.getBehavior() != null) {
					return new DscriptBlockSignaturePolicy();
				}
			}
		}
		return null;
	}

}
