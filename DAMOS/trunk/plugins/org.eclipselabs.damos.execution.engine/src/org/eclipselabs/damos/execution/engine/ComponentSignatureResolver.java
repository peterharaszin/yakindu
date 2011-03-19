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

package org.eclipselabs.damos.execution.engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.execution.engine.internal.ComponentSignatureResolverHelper;
import org.eclipselabs.damos.execution.engine.internal.ComponentStatus;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSignatureResolver {
	
	public ComponentSignatureResolverResult resolve(Fragment fragment, boolean descend) {
		Map<Component, IComponentSignature> signatures = new HashMap<Component, IComponentSignature>();
		MultiStatus status = new MultiStatus(ExecutionEnginePlugin.PLUGIN_ID, 0, "Resolving component signatures failed", null);

		if (descend) {
			doResolveAll(fragment, signatures, status, new HashSet<Fragment>());
		} else {
			new ComponentSignatureResolverHelper(fragment, signatures, status).resolve();
		}
		
		if (!status.isOK()) {
			return new ComponentSignatureResolverResult(signatures, status);
		}
		return new ComponentSignatureResolverResult(signatures);
	}
	
	private void doResolveAll(Fragment fragment, Map<Component, IComponentSignature> signatures, MultiStatus status, HashSet<Fragment> visitedFragments) {
		new ComponentSignatureResolverHelper(fragment, signatures, status).resolve();
		visitedFragments.add(fragment);
		
		for (FragmentElement element : fragment.getFragmentElements()) {
			if (element instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) element;
				SubsystemRealization realization = subsystem.getRealization(fragment);
				if (realization != null) {
					Fragment realizingFragment = realization.getRealizingFragment();
					if (realizingFragment != null) {
						if (!visitedFragments.contains(realizingFragment)) {
							doResolveAll(realizingFragment, signatures, status, visitedFragments);
						}
					} else {
						status.add(new ComponentStatus(IStatus.ERROR, subsystem, "No realizing fragment in subsystem realization specified"));
					}
				} else {
					status.add(new ComponentStatus(IStatus.ERROR, subsystem, "No subsystem realization specified"));
				}
			}
		}
	}

}
