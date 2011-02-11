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

package org.eclipselabs.damos.simulation.engine;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.execution.engine.ComponentSignatureResolver;
import org.eclipselabs.damos.execution.engine.ComponentSignatureResolverResult;
import org.eclipselabs.damos.execution.engine.IComponentSignature;
import org.eclipselabs.damos.execution.executiongraph.Node;
import org.eclipselabs.damos.simulation.engine.internal.ComponentSimulationObjectAdapter;
import org.eclipselabs.damos.simulation.engine.internal.DelegatingOverflowMonitor;
import org.eclipselabs.damos.simulation.engine.internal.registry.ComponentSimulationObjectProviderRegistry;

/**
 * @author Andreas Unger
 *
 */
public class ComponentSimulationObjectAdaptor {

	private ComponentSignatureResolver signatureResolver = new ComponentSignatureResolver();
	
	public void adaptSimulationObjects(ISimulationContext context, IComponentOverflowMonitor overflowMonitor, IProgressMonitor progressMonitor) throws CoreException {
		ComponentSignatureResolverResult signatureResolverResult = signatureResolver.resolve(context.getExecutionGraph().getTopLevelFragment(), true);
		if (!signatureResolverResult.getStatus().isOK()) {
			throw new CoreException(signatureResolverResult.getStatus());
		}
		
		List<Component> missingSimulationObjectComponents = new ArrayList<Component>();
		
		for (Node node : context.getExecutionGraph().getNodes()) {
			Component component = node.getComponent();
			IComponentSimulationObject simulationObject;
			simulationObject = ComponentSimulationObjectProviderRegistry.getInstance().createSimulationObject(component);
			if (simulationObject != null) {
				IComponentSignature componentSignature = signatureResolverResult.getSignatures().get(component);
				simulationObject.setInfo(new ComponentSimulationInfo(component, componentSignature, context.getSimulationModel(), new DelegatingOverflowMonitor(context, component, overflowMonitor)));
				node.eAdapters().add(new ComponentSimulationObjectAdapter(simulationObject));
			} else {
				missingSimulationObjectComponents.add(component);
			}
		}
		
		if (!missingSimulationObjectComponents.isEmpty()) {
			StringBuilder sb = new StringBuilder("Missing component simulation object for ");
			boolean first = true;
			for (Component component : missingSimulationObjectComponents) {
				if (first) {
					first = false;
				} else {
					sb.append(", ");
				}
				sb.append("'");
				sb.append(component.getName());
				sb.append("'");
			}
			throw new CoreException(new ComponentSimulationObjectStatus(
					IStatus.ERROR, SimulationEnginePlugin.PLUGIN_ID, 0, sb.toString(), null, missingSimulationObjectComponents));
		}
	}

}
