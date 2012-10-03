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

package org.eclipse.damos.execution.internal.providers;

import org.eclipse.damos.dml.Choice;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Inoutport;
import org.eclipse.damos.dml.Join;
import org.eclipse.damos.dml.Latch;
import org.eclipse.damos.dml.Memory;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.execution.datatype.IComponentSignaturePolicy;
import org.eclipse.damos.execution.datatype.IComponentSignaturePolicyProvider;
import org.eclipse.damos.execution.internal.signaturepolicies.ChoiceSignaturePolicy;
import org.eclipse.damos.execution.internal.signaturepolicies.InoutportSignaturePolicy;
import org.eclipse.damos.execution.internal.signaturepolicies.JoinSignaturePolicy;
import org.eclipse.damos.execution.internal.signaturepolicies.LatchSignaturePolicy;
import org.eclipse.damos.execution.internal.signaturepolicies.MemorySignaturePolicy;
import org.eclipse.damos.execution.internal.signaturepolicies.SubsystemSignaturePolicy;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinComponentSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.damos.execution.componentsignature.IComponentSignaturePolicyProvider#createPolicy(org.eclipse.damos.dml.Component)
	 */
	public IComponentSignaturePolicy createPolicy(Component component) {
		if (component instanceof Subsystem) {
			return new SubsystemSignaturePolicy();
		}
		if (component instanceof Inoutport) {
			return new InoutportSignaturePolicy();
		}
		if (component instanceof Choice) {
			return new ChoiceSignaturePolicy();
		}
		if (component instanceof Join) {
			return new JoinSignaturePolicy();
		}
		if (component instanceof Memory) {
			return new MemorySignaturePolicy();
		}
		if (component instanceof Latch) {
			return new LatchSignaturePolicy();
		}
		return null;
	}

}
