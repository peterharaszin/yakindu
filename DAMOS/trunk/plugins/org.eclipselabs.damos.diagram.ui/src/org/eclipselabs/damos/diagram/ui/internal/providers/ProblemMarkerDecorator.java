package org.eclipselabs.damos.diagram.ui.internal.providers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipselabs.damos.common.markers.IMarkerConstants;
import org.eclipselabs.damos.dml.FragmentElement;

class ProblemMarkerDecorator extends AbstractDecorator {

	private FragmentElement element;
	private URI cachedElementURI;
	private IFile cachedFile;
	
	private IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		
		public void resourceChanged(IResourceChangeEvent event) {
			if (event.getType() == IResourceChangeEvent.POST_BUILD) {
				IMarkerDelta[] markerDeltas = event.findMarkerDeltas(IMarkerConstants.PROBLEM_MARKER_ID, false);
				for (IMarkerDelta markerDelta : markerDeltas) {
					String elementURIString = markerDelta.getAttribute(IMarkerConstants.ATTRIBUTE__ELEMENT_URI, null);
					if (elementURIString != null) {
						String uriFragment = URI.createURI(elementURIString).fragment();
						if (uriFragment != null && EcoreUtil.isAncestor(element, element.eResource().getEObject(uriFragment))) {
							refresh();
							break;
						}
					}
				}
			}
		}

	};
	
	public ProblemMarkerDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		element = (FragmentElement) getDecoratorTarget().getAdapter(FragmentElement.class);
	}
	
	public FragmentElement getElement() {
		return element;
	}

	public void activate() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener, IResourceChangeEvent.POST_BUILD);
	}
	
	public void deactivate() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		super.deactivate();
	}
	
	public void refresh() {
		refreshDecorations(getMarkerProblems(getFile()));
	}
	
	private void refreshDecorations(List<Problem> problems) {
		removeDecoration();
		
		if (!problems.isEmpty()) {
			int severity = getSeverity(problems);
			Image image = getImage(severity);
			if (getDecoratorTarget().getAdapter(View.class) instanceof Edge) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(image, 50, true));
			} else {
				setDecoration(getDecoratorTarget().addShapeDecoration(image, IDecoratorTarget.Direction.NORTH_EAST, 0, true));
			}
			getDecoration().setToolTip(createToolTip(problems));
		}
	}
	
	private URI getElementURI() {
		if (cachedElementURI == null) {
			cachedElementURI = EcoreUtil.getURI(element);
		}
		return cachedElementURI;
	}
	
	private IFile getFile() {
		if (cachedFile == null) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IPath path = new Path(getElementURI().path()).removeFirstSegments(1);
			cachedFile = root.getFile(path);
		}
		return cachedFile;
	}
	
	private List<Problem> getMarkerProblems(IFile file) {
		List<Problem> problems = Collections.emptyList();
		try {
			IMarker[] allMarkers = file.findMarkers(IMarkerConstants.PROBLEM_MARKER_ID, false, IResource.DEPTH_INFINITE);
			if (allMarkers.length > 0) {
				problems = new ArrayList<Problem>();
				for (IMarker marker : allMarkers) {
					String elementURIString = marker.getAttribute(IMarkerConstants.ATTRIBUTE__ELEMENT_URI, null);
					if (elementURIString != null) {
						String uriFragment = URI.createURI(elementURIString).fragment();
						if (uriFragment != null && EcoreUtil.isAncestor(element, element.eResource().getEObject(uriFragment))) {
							int severity = marker.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
							String message = marker.getAttribute(IMarker.MESSAGE, "");
							problems.add(new Problem(convertMarkerSeverityToStatusSeverity(severity), message));
						}
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return problems;
	}
	
	private int getSeverity(List<Problem> problems) {
		int severity = IStatus.OK;
		for (Problem problem : problems) {
			if (problem.severity > severity) {
				severity = problem.severity;
			}
		}
		return severity;
	}
	
	private int convertMarkerSeverityToStatusSeverity(int markerSeverity) {
		switch (markerSeverity) {
		case IMarker.SEVERITY_ERROR:
			return IStatus.ERROR;
		case IMarker.SEVERITY_WARNING:
			return IStatus.WARNING;
		}
		return IStatus.INFO;
	}
	
	private IFigure createToolTip(List<Problem> problems) {
		if (problems.isEmpty()) {
			return new Label();
		}
		if (problems.size() == 1) {
			return createToolTipLabel(problems.get(0));
		}
		IFigure figure = new Figure();
		FlowLayout layout = new FlowLayout(false);
		layout.setMinorSpacing(0);
		figure.setLayoutManager(layout);
		for (Problem problem : problems) {
			figure.add(createToolTipLabel(problem));
		}
		return figure;
	}
	
	private IFigure createToolTipLabel(Problem problem) {
		return new Label(problem.message, getImage(problem.severity));
	}
	
	private Image getImage(int severity) {
		String imageName;
		switch (severity) {
		case IStatus.ERROR:
			imageName = ISharedImages.IMG_OBJS_ERROR_TSK;
			break;
		case IStatus.WARNING:
			imageName = ISharedImages.IMG_OBJS_WARN_TSK;
			break;
		default:
			imageName = ISharedImages.IMG_OBJS_INFO_TSK;
			break;
		}
		return PlatformUI.getWorkbench().getSharedImages().getImage(imageName);
	}
	
	private class Problem {
		
		public int severity;
		public String message;
		
		public Problem(int severity, String message) {
			this.severity = severity;
			this.message = message;
		}
		
	}

}
