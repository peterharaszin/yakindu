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

package org.eclipselabs.damos.dmltext.resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;

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
			} else if (eObject instanceof Subsystem) {
				Subsystem subsystem = (Subsystem) eObject;
				String qualifiedName = subsystem.getOwningFragment().getQualifiedName();
				if (qualifiedName != null) {
					exportedObjects.add(new EObjectDescription(qualifiedNameConverter.toQualifiedName(qualifiedName).append(subsystem.getName()), eObject, userData));
				}
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
		return Collections.emptyList();
	}

}
