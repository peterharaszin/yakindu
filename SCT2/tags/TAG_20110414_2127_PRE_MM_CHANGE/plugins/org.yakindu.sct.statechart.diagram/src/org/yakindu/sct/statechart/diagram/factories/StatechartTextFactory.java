package org.yakindu.sct.statechart.diagram.factories;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartTextFactory extends ShapeViewFactory {

	@Override
	protected void decorateView(View containerView, View view,
			IAdaptable semanticAdapter, String semanticHint, int index,
			boolean persisted) {
		super.decorateView(containerView, view, semanticAdapter, semanticHint,
				index, persisted);

		IAdaptable eObjectAdapter = null;
		EObject eObject = (EObject) semanticAdapter.getAdapter(EObject.class);
		if (eObject != null) {
			eObjectAdapter = new EObjectAdapter(eObject);
		}

		Node textCompartment = getViewService().createNode(eObjectAdapter, view,
				SemanticHints.STATECHART_TEXT_EXPRESSION, ViewUtil.APPEND,
				true, getPreferencesHint());
		Assert.isNotNull(textCompartment);		
		ShapeStyle style = (ShapeStyle) view.getStyle(NotationPackage.eINSTANCE
				.getShapeStyle());
		style.setFillColor(FigureUtilities.RGBToInteger(ColorConstants.white
				.getRGB()));
		
	}
}
