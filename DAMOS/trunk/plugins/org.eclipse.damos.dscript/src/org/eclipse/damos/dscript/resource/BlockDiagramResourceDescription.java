/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dscript.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.damos.dml.Argument;
import org.eclipse.damos.dml.Block;
import org.eclipse.damos.dml.BlockInput;
import org.eclipse.damos.dml.BlockOutput;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.Inlet;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.InputDefinition;
import org.eclipse.damos.dml.Outlet;
import org.eclipse.damos.dml.Output;
import org.eclipse.damos.dml.OutputDefinition;
import org.eclipse.damos.dml.Subsystem;
import org.eclipse.damos.dml.SubsystemInput;
import org.eclipse.damos.dml.SubsystemOutput;
import org.eclipse.damos.dml.SubsystemRealization;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;

import com.google.inject.Inject;

public class BlockDiagramResourceDescription extends AbstractResourceDescription implements IResourceDescription {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	private final Resource resource;

	private final URI uri;

	public BlockDiagramResourceDescription(Resource resource) {
		this.resource = resource;
		this.uri = getNormalizedURI(resource);
	}

	protected List<IEObjectDescription> computeExportedObjects() {
		List<IEObjectDescription> exportedObjects = new ArrayList<IEObjectDescription>();
		Map<String, String> userData = new HashMap<String, String>();
		for (TreeIterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject eObject = it.next();
			if (eObject instanceof Fragment) {
				String qualifiedName = ((Fragment) eObject).getQualifiedName();
				if (qualifiedName != null) {
					exportedObjects.add(new EObjectDescription(qualifiedNameConverter.toQualifiedName(qualifiedName), eObject, userData));
				}
				it.prune();
			}
		}
		return exportedObjects;
	}

	public URI getURI() {
		return uri;
	}

	public Iterable<QualifiedName> getImportedNames() {
		return Collections.emptyList();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		List<IReferenceDescription> references = new ArrayList<IReferenceDescription>();
		for (TreeIterator<EObject> it = resource.getAllContents(); it.hasNext();) {
			EObject element = it.next();
			if (element instanceof Block) {
				getBlockReferenceDescriptions((Block) element, references);
				it.prune();
			} else if (element instanceof Subsystem) {
				getSubsystemReferenceDescriptions((Subsystem) element, references);
				it.prune();
			} else if (element instanceof SubsystemRealization) {
				getSubsystemRealizationReferenceDescriptions((SubsystemRealization) element, references);
				it.prune();
			} else if (element.eClass().getEPackage() != DMLPackage.eINSTANCE) {
				it.prune();
			}
		}
		return references;
	}

	private void getBlockReferenceDescriptions(Block block, List<IReferenceDescription> references) {
		references.add(new DefaultReferenceDescription(block, block.getType(), DMLPackage.eINSTANCE.getBlock_Type(), -1, null));
		
		for (Input input : block.getInputs()) {
			if (!(input instanceof BlockInput)) {
				continue;
			}
			BlockInput blockInput = (BlockInput) input;
			InputDefinition definition = blockInput.getDefinition();
			references.add(new DefaultReferenceDescription(input, definition, DMLPackage.eINSTANCE.getBlockInput_Definition(), -1, null));
		}

		for (Output output : block.getOutputs()) {
			if (!(output instanceof BlockOutput)) {
				continue;
			}
			BlockOutput blockOutput = (BlockOutput) output;
			OutputDefinition definition = blockOutput.getDefinition();
			references.add(new DefaultReferenceDescription(output, definition, DMLPackage.eINSTANCE.getBlockOutput_Definition(), -1, null));
		}
		
		for (Argument argument : block.getArguments()) {
			references.add(new DefaultReferenceDescription(argument, argument.getParameter(), DMLPackage.eINSTANCE.getArgument_Parameter(), -1, null));
		}
	}

	private void getSubsystemReferenceDescriptions(Subsystem subsystem, List<IReferenceDescription> references) {
		references.add(new DefaultReferenceDescription(subsystem, subsystem.getInterface(), DMLPackage.eINSTANCE.getSubsystem_Interface(), -1, null));
		
		for (Input input : subsystem.getInputs()) {
			if (!(input instanceof SubsystemInput)) {
				continue;
			}
			SubsystemInput subsystemInput = (SubsystemInput) input;
			Inlet inlet = subsystemInput.getInlet();
			references.add(new DefaultReferenceDescription(input, inlet, DMLPackage.eINSTANCE.getSubsystemInput_Inlet(), -1, null));
		}

		for (Output output : subsystem.getOutputs()) {
			if (!(output instanceof SubsystemOutput)) {
				continue;
			}
			SubsystemOutput blockOutput = (SubsystemOutput) output;
			Outlet outlet = blockOutput.getOutlet();
			references.add(new DefaultReferenceDescription(output, outlet, DMLPackage.eINSTANCE.getSubsystemOutput_Outlet(), -1, null));
		}
	}

	private void getSubsystemRealizationReferenceDescriptions(SubsystemRealization subsystemRealization, List<IReferenceDescription> references) {
		references.add(new DefaultReferenceDescription(subsystemRealization, subsystemRealization.getRealizingFragment(), DMLPackage.eINSTANCE.getSubsystemRealization_RealizingFragment(), -1, null));
	}

}
