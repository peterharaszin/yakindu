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

package org.eclipselabs.damos.ide.ui.internal.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.common.markers.IMarkerConstants;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;
import org.eclipselabs.damos.dml.ActionLink;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.ide.core.validation.Problem;
import org.eclipselabs.damos.ide.core.validation.ValidationAdapter;

/**
 * @author Andreas Unger
 *
 */
public class ProblemUtil {

	public static List<Problem> getResourceProblems(EObject element, IFile file, Fragment selectedFragment) {
		List<Problem> problems = Collections.emptyList();
		try {
			IMarker[] allMarkers = file.findMarkers(IMarkerConstants.PROBLEM_MARKER_ID, false, IResource.DEPTH_INFINITE);
			if (allMarkers.length > 0) {
				problems = new ArrayList<Problem>();
				for (IMarker marker : allMarkers) {
					Problem problem = Problem.create(marker);
					if (includeProblem(problem, element, selectedFragment)) {
						problems.add(Problem.create(marker));
					}
				}
			}
		} catch (CoreException e) {
			DiagramUIPlugin.getDefault().getLog().log(new Status(
					IStatus.ERROR, DiagramUIPlugin.PLUGIN_ID,
					"Retrieving problem markers from " + file.getFullPath().toString() + " failed", e));
		}
		return problems;
	}
	
	public static List<Problem> getLiveProblems(EObject element, Fragment selectedFragment) {
		Resource resource = element.eResource();
		if (resource == null) {
			return Collections.emptyList();
		}

		ValidationAdapter adapter = ValidationAdapter.get(resource);
		List<Problem> allLiveProblems = adapter.getProblems();
		if (allLiveProblems.isEmpty()) {
			return Collections.emptyList();
		}
		
		List<Problem> liveProblems = new ArrayList<Problem>();
		for (Problem problem : allLiveProblems) {
			if (ProblemUtil.includeProblem(problem, element, selectedFragment)) {
				liveProblems.add(problem);
			}
		}
		
		return liveProblems;
	}
	
	public static boolean includeProblem(Problem problem, EObject element, Fragment selectedFragment) {
		if (problem.getFragmentURI() == null || problem.getElementURI() == null) {
			return false;
		}
		if (!EcoreUtil.getURI(selectedFragment).equals(problem.getFragmentURI())) {
			return false;
		}

		String uriFragment = problem.getElementURI().fragment();
		if (uriFragment == null) {
			return false;
		}

		EObject eObject = element.eResource().getEObject(uriFragment);
		return isAncestor(element, eObject);
	}

	private static boolean isAncestor(EObject element, EObject eObject) {
		if (element instanceof Component && eObject instanceof ActionLink) {
			return false;
		}
		if (element instanceof Subsystem && eObject instanceof SubsystemRealization) {
			return element == ((SubsystemRealization) eObject).getRealizedSubsystem();
		}
		return eObject != null && (element == eObject || (element instanceof Component && EcoreUtil.isAncestor(element, eObject)));
	}

	public static URI getPlatformResourceElementURI(Problem problem) {
		URI uri = problem.getElementURI();
		if (uri != null && uri.isPlatformResource()) {
			return uri;
		}
		return null;
	}

}
