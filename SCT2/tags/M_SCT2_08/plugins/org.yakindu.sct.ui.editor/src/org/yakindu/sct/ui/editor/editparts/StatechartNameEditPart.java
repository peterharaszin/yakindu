package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.DiagramActivator;

import de.itemis.gmf.runtime.commons.editparts.TextAwareLabelEditPart;

/**
 * 
 * @author muelder
 * 
 */
public class StatechartNameEditPart extends TextAwareLabelEditPart {

	public StatechartNameEditPart(View view) {
		super(view, SGraphPackage.Literals.NAMED_ELEMENT__NAME,
				DiagramActivator.PLUGIN_ID);
	}

	public void setLabel(IFigure label) {
		setFigure(label);
	}

	@Override
	protected IFigure createFigure() {
		// Figure is set from parent addChild
		return null;
	}
}
