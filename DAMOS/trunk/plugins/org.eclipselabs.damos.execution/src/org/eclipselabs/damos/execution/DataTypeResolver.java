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

package org.eclipselabs.damos.execution;

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
import org.eclipselabs.damos.execution.internal.DataTypeResolverHelper;
import org.eclipselabs.damos.execution.internal.EObjectStatus;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeResolver {
	
	public DataTypeResolverResult resolve(Fragment fragment, boolean descend) {
		Map<Component, IComponentSignature> signatures = new HashMap<Component, IComponentSignature>();
		MultiStatus status = new MultiStatus(ExecutionCorePlugin.PLUGIN_ID, 0, "Data type resolution", null);

		if (descend) {
			doResolveAll(fragment, signatures, status, new HashSet<Fragment>());
		} else {
			new DataTypeResolverHelper(fragment, signatures, status).resolve();
		}
		
		return new DataTypeResolverResult(signatures, status);
	}
	
	private void doResolveAll(Fragment fragment, Map<Component, IComponentSignature> signatures, MultiStatus status, HashSet<Fragment> visitedFragments) {
		new DataTypeResolverHelper(fragment, signatures, status).resolve();
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
						status.add(new EObjectStatus(IStatus.ERROR, subsystem, "No realizing fragment in subsystem realization specified"));
					}
				} else {
					status.add(new EObjectStatus(IStatus.ERROR, subsystem, "No subsystem realization specified"));
				}
			}
		}
	}

}
