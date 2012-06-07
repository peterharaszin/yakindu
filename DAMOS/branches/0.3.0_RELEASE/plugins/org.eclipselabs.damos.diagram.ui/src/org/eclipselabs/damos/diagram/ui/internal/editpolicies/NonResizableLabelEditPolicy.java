package org.eclipselabs.damos.diagram.ui.internal.editpolicies;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;

/**
 * Fix for bug #362973
 * 
 * @author Andreas Unger
 */
public class NonResizableLabelEditPolicy extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableLabelEditPolicy {

	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		super.showChangeBoundsFeedback(request);

		IFigure p = getDragSourceFeedbackFigure();
		Rectangle r = p.getBounds();
		PrecisionPoint refPoint = new PrecisionPoint(((LabelEditPart) getHost()).getReferencePoint());
		getHostFigure().translateToAbsolute(refPoint);

		// translate the feedback figure
		PrecisionRectangle rect = new PrecisionRectangle(
			getInitialFeedbackBounds().getCopy());
		getHostFigure().translateToAbsolute(rect);
		rect.translate(request.getMoveDelta());
		rect.resize(request.getSizeDelta());
		p.translateToRelative(rect);
		p.setBounds(rect);

		Rectangle centerMain = null;
		// TODO: remove this hack. We should be using the reference point for
		// the teher end, however,
		// the reference point is causing miscaculation when positioning. This
		// has to be redone in version 2.
		if (((IGraphicalEditPart) getHost().getParent()).getFigure() instanceof Connection) {
			centerMain = new Rectangle(refPoint.x, refPoint.y, 0, 0);
		} else {
			centerMain = new PrecisionRectangle(((IGraphicalEditPart) getHost().getParent())
				.getFigure().getBounds());
			centerMain.translate(centerMain.width / 2, centerMain.height / 2);
			getHostFigure().translateToAbsolute(centerMain);
		}
		p.translateToRelative(centerMain);

		PrecisionRectangle ref = new PrecisionRectangle(centerMain);

		Point midTop = new Point(r.x + r.width / 2, r.y);
		Point midBottom = new Point(r.x + r.width / 2, r.y + r.height);
		Point midLeft = new Point(r.x, r.y + r.height / 2);
		Point midRight = new Point(r.x + r.width, r.y + r.height / 2);

		Point startPoint = midTop;

		int x = r.x + r.width / 2 - refPoint.x;
		int y = r.y + r.height / 2 - refPoint.y;

		if (y > 0 && y > x && y > -x)
			startPoint = midTop;
		else if (y < 0 && y < x && y < -x)
			startPoint = midBottom;
		else if (x < 0 && y > x && y < -x)
			startPoint = midRight;
		else
			startPoint = midLeft;

		Polyline tether = getTether();
		tether.setStart(startPoint);
		tether.setEnd(ref.getLocation());
	}
	
	protected Polyline getTether() {
		for (Object child : getFeedbackLayer().getChildren()) {
			if (child instanceof Polyline) {
				return (Polyline) child;
			}
		}
		throw new IllegalStateException();
	}

}
