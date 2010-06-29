package org.esmp.dsm.library.discrete.ui.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.esmp.dsm.diagram.ui.editparts.RectangularBlockEditPart;
import org.esmp.dsm.library.basic.ui.figures.MathExpressionLabel;
import org.esmp.dsm.library.discrete.util.DelayConstants;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.Parameter;
import org.esmp.dsm.semantic.blockdiagram.util.BlockDiagramUtil;

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
		String text = "INVALID";
		Block block = (Block) resolveSemanticElement();
		if (block != null) {
			int delay = BlockDiagramUtil.getParameterValueAsInteger(block, DelayConstants.PARAMETER__DELAY, 0);
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
		if (notifier instanceof Parameter) {
			String parameterName = ((Parameter) notifier).getName();
			if (DelayConstants.PARAMETER__DELAY.equals(parameterName)) {
				refreshDelay();
			}
		}
		super.handleNotificationEvent(notification);
	}

}
