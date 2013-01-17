package org.yakindu.sct.ui.editor.policies;

import static org.yakindu.sct.ui.editor.policies.RegionCompartmentXYLayoutEditPolicy.SPACEING;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;

/**
 * 
 * @author muelder
 * 
 */
public class StatePrimaryDragEditPolicy extends PreferredSizeEditPolicy {

	private Map<IFigure, Rectangle> boundsCache = new HashMap<IFigure, Rectangle>();

	protected IGraphicalEditPart getParentRegion(EditPart part) {
		part = part.getParent();
		while (!(part instanceof RegionEditPart)) {
			part = part.getParent();
			if (part == null)
				return null;
		}
		return (IGraphicalEditPart) part;
	}

	protected IGraphicalEditPart getParentState(EditPart part) {
		part = part.getParent();
		while (!(part instanceof StateEditPart)) {
			part = part.getParent();
			if (part == null)
				return null;
		}
		return (IGraphicalEditPart) part;
	}

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.showChangeBoundsFeedback(request);
		long t = System.currentTimeMillis();
		showContainerFeedback(request);
		System.out.println("Took : " + (System.currentTimeMillis() - t));
	}

	protected void showContainerFeedback(ChangeBoundsRequest request) {

		List<IGraphicalEditPart> container = collectContainerHierachy();
		for (int level = 1; level <= container.size(); level++) {
			IGraphicalEditPart containerEditPart = container.get(level - 1);
			IFigure containerFigure = containerEditPart.getFigure();
			Rectangle feedbackBounds = getOriginalBounds(containerFigure);
			containerFigure.getParent().translateToAbsolute(feedbackBounds);
			feedbackBounds = calculateFeedbackBounds(request, feedbackBounds,
					level, containerFigure);
			showChildrenFeedback(containerEditPart, containerFigure,
					feedbackBounds);
			containerFigure.getParent().translateToRelative(feedbackBounds);
			setBounds(containerFigure, feedbackBounds);
		}
	}

	protected List<IGraphicalEditPart> collectContainerHierachy() {
		List<IGraphicalEditPart> result = new ArrayList<IGraphicalEditPart>();
		IGraphicalEditPart containerEditPart = getHost();
		while (containerEditPart != null) {
			containerEditPart = getContainer(containerEditPart);
			if (containerEditPart != null)
				result.add(containerEditPart);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	/**
	 * containerFeedbackBounds as absolute
	 * 
	 * @param containerEditPart
	 * @param containerFigure
	 * @param containerFeedbackBounds
	 */
	protected void showChildrenFeedback(
			final IGraphicalEditPart containerEditPart,
			final IFigure containerFigure,
			final Rectangle containerFeedbackBounds) {
		Rectangle originalBounds = getOriginalBounds(containerFigure);

		Point moveDelta = new Point(containerFeedbackBounds.width
				- originalBounds.width, containerFeedbackBounds.height
				- originalBounds.height);

		List<IGraphicalEditPart> children = containerEditPart.getParent()
				.getChildren();

		for (IGraphicalEditPart childPart : children) {
			if (childPart == containerEditPart)
				continue;
			showChildFeedback(childPart, moveDelta, containerFeedbackBounds);
		}
	}

	protected void showChildFeedback(IGraphicalEditPart childPart,
			Point moveDelta, Rectangle containerFeedbackBounds) {

		IFigure childFigure = childPart.getFigure();
		Rectangle originalChildBounds = getOriginalBounds(childFigure);
		childFigure.getParent().translateToAbsolute(originalChildBounds);

		boolean horizontalAffected = isHorizontalAffected(
				containerFeedbackBounds, moveDelta, originalChildBounds);
		boolean verticalAffected = isVerticalAffected(containerFeedbackBounds,
				moveDelta, originalChildBounds);
		if (!(horizontalAffected || verticalAffected)) {
			return;
		}
		if (horizontalAffected) {
			originalChildBounds.translate(moveDelta.x, 0);
		}
		if (verticalAffected) {
			originalChildBounds.translate(0, moveDelta.y);
		}
		childFigure.getParent().translateToRelative(originalChildBounds);
		setBounds(childFigure, originalChildBounds);
	}

	/**
	 * Return a copy of the bounds from the cache
	 * 
	 * @param figure
	 * @return
	 */
	private Rectangle getOriginalBounds(IFigure figure) {
		Rectangle originalContainerBounds = boundsCache.get(figure);
		if (originalContainerBounds == null) {
			originalContainerBounds = figure.getBounds().getCopy();
			boundsCache.put(figure, originalContainerBounds);
		}
		return boundsCache.get(figure).getCopy();
	}

	private IGraphicalEditPart getContainer(IGraphicalEditPart host) {
		IGraphicalEditPart containerEditPart = getParentState(host);
		if (containerEditPart == null) {
			containerEditPart = getParentRegion(host);
			if (containerEditPart == null)
				return null;
		}
		return containerEditPart;
	}

	private boolean isVerticalAffected(Rectangle newBounds, Point moveDelta,
			Rectangle bounds) {
		boolean verticalAffected = (bounds.x > newBounds.x || bounds.x
				+ bounds.width > newBounds.x)
				&& bounds.x < newBounds.x + newBounds.width
				|| bounds.x + bounds.width < newBounds.x + newBounds.width;
		if (verticalAffected) {
			verticalAffected = bounds.y + moveDelta.y > newBounds.y
					+ newBounds.height;
		}
		return verticalAffected;
	}

	private boolean isHorizontalAffected(Rectangle newBounds, Point moveDelta,
			Rectangle bounds) {
		boolean horizontalAffected = (bounds.y > newBounds.y || bounds.y
				+ bounds.height > newBounds.y)
				&& bounds.y < newBounds.y + newBounds.height
				|| bounds.y + bounds.height < newBounds.y + newBounds.height;
		if (horizontalAffected) {
			horizontalAffected = bounds.x + moveDelta.x > newBounds.x
					+ newBounds.width;
		}
		return horizontalAffected;
	}

	protected void setBounds(IFigure figure, Rectangle bounds) {
		figure.setBounds(bounds);
		figure.getParent().setConstraint(figure, bounds);

	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	private Rectangle calculateFeedbackBounds(ChangeBoundsRequest request,
			Rectangle feedbackBounds, int level, IFigure containerFigure) {
		Rectangle result = feedbackBounds.getCopy();
		List<IGraphicalEditPart> editParts = request.getEditParts();
		for (IGraphicalEditPart editPart : editParts) {
			PrecisionRectangle transformedRect = new PrecisionRectangle(
					editPart.getFigure().getBounds());
			editPart.getFigure().translateToAbsolute(transformedRect);
			transformedRect.translate(request.getMoveDelta());
			transformedRect.resize(request.getSizeDelta());
			transformedRect.expand(SPACEING * level, SPACEING * level);
			result.union(transformedRect);
			result.union(containerFigure.getPreferredSize());
			// does not work for negative resizes upper left now, if fixed,
			// remove
			if (result.x < feedbackBounds.x || result.y < feedbackBounds.y) {
				return feedbackBounds;
			}
		}
		return result;
	}

	@Override
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.eraseChangeBoundsFeedback(request);
		boundsCache.clear();
	}
}
