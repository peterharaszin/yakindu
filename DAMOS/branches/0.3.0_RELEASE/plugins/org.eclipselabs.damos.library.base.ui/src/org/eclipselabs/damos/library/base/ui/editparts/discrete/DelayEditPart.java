package org.eclipselabs.damos.library.base.ui.editparts.discrete;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editparts.RectangularBlockEditPart;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.library.base.util.discrete.DelayConstants;
import org.eclipselabs.damos.library.common.ui.figures.MathExpressionLabel;

public class DelayEditPart extends RectangularBlockEditPart {

	private MathExpressionLabel contentFigure;
	
	public DelayEditPart(View view) {
		super(view);
	}
	
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshDelay();
	}
	
	protected void refreshDelay() {
		String text = "z^{n}";
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			int delay = DMLUtil.getArgumentValueAsInteger(block, DelayConstants.PARAMETER__DELAY, 0);
			if (delay > 0) {
				text = "z^{-" + delay + "}";
			}
		}
		contentFigure.setText(text);
	}
	
	protected NodeFigure createMainFigure() {
		NodeFigure figure = super.createMainFigure();
		contentFigure = new MathExpressionLabel();
		figure.add(contentFigure);
		return figure;
	}

	protected void handleNotificationEvent(Notification notification) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof Argument) {
			String parameterName = ((Argument) notifier).getParameter().getName();
			if (DelayConstants.PARAMETER__DELAY.equals(parameterName)) {
				refreshDelay();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
