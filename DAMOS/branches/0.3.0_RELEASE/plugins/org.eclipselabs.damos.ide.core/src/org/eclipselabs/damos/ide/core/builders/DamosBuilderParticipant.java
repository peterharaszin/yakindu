/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.ide.core.builders;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipselabs.damos.common.markers.IMarkerConstants;
import org.eclipselabs.damos.ide.core.validation.DamosValidator;
import org.eclipselabs.damos.ide.core.validation.Problem;

/**
 * @author Andreas Unger
 * 
 */
public class DamosBuilderParticipant implements IXtextBuilderParticipant {
	
	/**
	 * 
	 */
	private static final String BLOCK_DIAGRAM_FILE_EXTENSION = "blockdiagram";
	
	private final DamosValidator validator = new DamosValidator();

	public void build(IBuildContext buildContext, IProgressMonitor monitor) throws CoreException {
		ResourceSet resourceSet = buildContext.getResourceSet();
		
		for (IResourceDescription.Delta delta : buildContext.getDeltas()) {
			if (delta.getNew() == null) {
				continue;
			}
			
			URI uri = delta.getUri();
			
			if (!BLOCK_DIAGRAM_FILE_EXTENSION.equals(uri.fileExtension())) {
				continue;
			}
			
			Resource resource = resourceSet.getResource(uri, true);
			
			if (!uri.isPlatformResource()) {
				continue;
			}

			IPath path = new Path(uri.toPlatformString(true));

			IFile file = buildContext.getBuiltProject().getWorkspace().getRoot().getFile(path);

			file.deleteMarkers(IMarkerConstants.PROBLEM_MARKER_ID, false, IResource.DEPTH_INFINITE);

			List<Problem> problems = validator.validate(resource, monitor);
			for (Problem problem : problems) {
				attachMarker(file, problem);
			}
		}
	}

	protected void attachMarker(IResource resource, Problem problem) throws CoreException {
		IMarker marker = resource.createMarker(IMarkerConstants.PROBLEM_MARKER_ID);

		marker.setAttribute(IMarker.SEVERITY, problem.getSeverity());
		
		marker.setAttribute(IMarkerConstants.SOURCE, problem.getSource());
		marker.setAttribute(IMarkerConstants.CODE, problem.getCode());
		
		if (problem.getFragmentURI() != null) {
			marker.setAttribute(IMarkerConstants.ATTRIBUTE__FRAGMENT_URI, problem.getFragmentURI().toString());
		}
		
		if (problem.getElementURI() != null) {
			marker.setAttribute(EValidator.URI_ATTRIBUTE, problem.getElementURI().toString());
		}

		if (problem.getLocation() != null) {
			marker.setAttribute(IMarker.LOCATION, problem.getLocation());
		}

		if (problem.getMessage() != null) {
			marker.setAttribute(IMarker.MESSAGE, problem.getMessage());
		}
	}

}
