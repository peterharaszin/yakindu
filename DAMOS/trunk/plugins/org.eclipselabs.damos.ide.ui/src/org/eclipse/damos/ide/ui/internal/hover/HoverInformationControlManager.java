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

package org.eclipse.damos.ide.ui.internal.hover;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoration;
import org.eclipse.jface.text.AbstractReusableInformationControlCreator;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;

/*
 * Classes of this package have been copied from other Eclipse projects like Jface and Xtext,
 * since only parts of the required classes are public API.
 * 
 * TODO: Clean-up this code
 */

public class HoverInformationControlManager extends AbstractHoverInformationControlManager {

	private EditPartViewer viewer;
	
	public HoverInformationControlManager(EditPartViewer viewer) {
		super(new HoverControlCreator(new PresenterControlCreator()));
		this.viewer = viewer;

		StickyHoverManager stickyHoverManager = new StickyHoverManager(viewer.getControl());
		install(viewer.getControl());
		setInformationControlReplacer(stickyHoverManager);
	}

	@Override
	protected void computeInformation() {
		Point p = getHoverEventLocation();

		IFigure root = FigureUtilities.getRoot(((GraphicalEditPart) viewer.getRootEditPart().getContents()).getFigure());
		if (isDecoration(root.findFigureAt(p.x, p.y))) {
			List<Problem> resourceProblems = ProblemUtil.getResourceProblems(getElement(), getFile(getElement()), getSelectedFragment());
			List<Problem> liveProblems = ProblemUtil.getLiveProblems(getElement(), getSelectedFragment());
			setInformation(new AnnotationInfo(resourceProblems, liveProblems), new Rectangle(p.x, p.y, 10, 10));
		} else {
			setInformation(null, null);
		}
	}

	private boolean isDecoration(IFigure figure) {
		while (figure != null) {
			if (figure instanceof IDecoration) {
				return true;
			}
			figure = figure.getParent();
		}
		return false;
	}
	
	private Fragment getSelectedFragment() {
		FragmentSelectionManager manager = (FragmentSelectionManager) viewer.getRootEditPart().getContents().getAdapter(FragmentSelectionManager.class);
		if (manager != null) {
			return manager.getSelectedFragment();
		}
		return null;
	}
	
	private EObject getElement() {
		Point p = getHoverEventLocation();
		EditPart editPart = viewer.findObjectAt(new org.eclipse.draw2d.geometry.Point(p.x, p.y));
		if (editPart instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart) editPart).resolveSemanticElement();
		}
		return null;
	}
	
	private IFile getFile(EObject element) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		Resource resource = element.eResource();
		if (resource != null) {
			URI uri = resource.getURI();
			if (uri != null) {
				String uriString;
				if (uri.isPlatform()) {
					uriString = uri.toPlatformString(false);
				} else {
					uriString = uri.toString();
				}
				IPath path = new Path(uriString);
				return root.getFile(path);
			}
		}
		return null;
	}

	private static final class PresenterControlCreator extends AbstractReusableInformationControlCreator {

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			// DIFF: do not show toolbar in hover, no configuration supported (2)
			// return new AnnotationInformationControl(parent, new ToolBarManager(SWT.FLAT));
			return new AnnotationInformationControl(parent, true);
		}
	}

	private static final class HoverControlCreator extends AbstractReusableInformationControlCreator {
		private final IInformationControlCreator fPresenterControlCreator;

		public HoverControlCreator(IInformationControlCreator presenterControlCreator) {
			fPresenterControlCreator= presenterControlCreator;
		}

		@Override
		public IInformationControl doCreateInformationControl(Shell parent) {
			return new AnnotationInformationControl(parent, (String) null) {

				@Override
				public IInformationControlCreator getInformationPresenterControlCreator() {
					return fPresenterControlCreator;
				}
				
			};
		}

	}

}
