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

package org.eclipselabs.damos.evaluation.internal.policies;

import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Inoutport;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicy;
import org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicyProvider;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinComponentSignaturePolicyProvider implements IComponentSignaturePolicyProvider {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.componentsignature.IComponentSignaturePolicyProvider#createPolicy(org.eclipselabs.damos.dml.Component)
	 */
	public IComponentSignaturePolicy createPolicy(Component component) {
		if (component instanceof Subsystem) {
			return new SubsystemSignaturePolicy();
		}
		if (component instanceof Inoutport) {
			return new InoutportSignaturePolicy();
		}
		return null;
	}

}
