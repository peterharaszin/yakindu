/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RelativeLocator;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.handles.SquareHandle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.tools.SimpleDragTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;

/**
 * Adds a square selection handle that set the bounds to the preferred size
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("all")
public class PreferredSizeEditPolicy extends PreferredSizeCompartmentEditPolicy {

	public class PreferredSizeDragTracker extends SimpleDragTracker {
		@Override
		protected Request createSourceRequest() {
			return new ChangeBoundsRequest(REQ_RESIZE);
		}

		@Override
		protected ChangeBoundsRequest getSourceRequest() {
			return (ChangeBoundsRequest) super.getSourceRequest();
		}

		@Override
		protected Command getCommand() {
			return getHost().getCommand(getSourceRequest());
		}

		@Override
		protected boolean handleButtonDown(int button) {
			Dimension prefSize = getHostFigure().getLayoutManager().getPreferredSize(getHostFigure(), -1, -1);
			Dimension currentSize = getHostFigure().getSize();
			getSourceRequest().setSizeDelta(
					new Dimension(prefSize.width - currentSize.width, prefSize.height - currentSize.height));
			getSourceRequest().setEditParts(getOperationSet());
			setCurrentCommand(getCommand());
			executeCurrentCommand();
			getHost().refresh();
			return true;
		}

		@Override
		protected String getCommandName() {
			return "set preferred size";
		}
	}

	public class PreferredSizeSquareHandle extends SquareHandle {

		public PreferredSizeSquareHandle(GraphicalEditPart editpart) {
			super(editpart, new RelativeLocator(getHostFigure(), 0.75, 1) {
				protected Rectangle getReferenceBox() {
					IFigure f = getReferenceFigure();
					if (f instanceof HandleBounds)
						return ((HandleBounds) f).getHandleBounds();
					return super.getReferenceBox();
				}
			});
		}

		@Override
		protected DragTracker createDragTracker() {
			return new PreferredSizeDragTracker();
		}

		@Override
		protected void init() {
			setPreferredSize(9, 9);
		}

		@Override
		protected boolean isPrimary() {
			// Paint inverse colors
			return false;
		}

	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected List createSelectionHandles() {
		List result = super.createSelectionHandles();
		SquareHandle squareHandle = new PreferredSizeSquareHandle(getHost());
		squareHandle.setToolTip(new Label("set preferred size"));
		result.add(squareHandle);
		return result;
	}

}
