package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

import de.itemis.xtext.utils.gmf.directedit.IXtextAwareEditPart;

/**
 * 
 * @author muelder
 * 
 */
public class StateTextCompartmentExpressionEditPart extends
		PlugableXtextLabelEditPart implements IXtextAwareEditPart {

	public StateTextCompartmentExpressionEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		installEditPolicy(
				EditPolicy.SELECTION_FEEDBACK_ROLE,
				new ContextSensitiveHelpPolicy(
						IYakinduSctHelpContextIds.SC_PROPERTIES_STATE_EXPRESSION));
	}
}
