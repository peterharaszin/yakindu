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

package org.eclipselabs.damos.execution.internal.providers;

import org.eclipselabs.damos.dml.Choice;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Join;
import org.eclipselabs.damos.dml.Latch;
import org.eclipselabs.damos.dml.Memory;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.execution.datatype.IComponentSignaturePolicy;
import org.eclipselabs.damos.execution.datatype.IComponentSignaturePolicyProvider;
import org.eclipselabs.damos.execution.internal.signaturepolicies.ChoiceSignaturePolicy;
import org.eclipselabs.damos.execution.internal.signaturepolicies.InoutportSignaturePolicy;
import org.eclipselabs.damos.execution.internal.signaturepolicies.JoinSignaturePolicy;
import org.eclipselabs.damos.execution.internal.signaturepolicies.LatchSignaturePolicy;
import org.eclipselabs.damos.execution.internal.signaturepolicies.MemorySignaturePolicy;
import org.eclipselabs.damos.execution.internal.signaturepolicies.SubsystemSignaturePolicy;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinComponentSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.execution.componentsignature.IComponentSignaturePolicyProvider#createPolicy(org.eclipselabs.damos.dml.Component)
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
