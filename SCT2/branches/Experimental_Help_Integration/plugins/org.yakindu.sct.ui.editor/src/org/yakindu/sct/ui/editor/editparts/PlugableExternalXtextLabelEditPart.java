package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.ExpressionElement;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.extensions.Extensions;
import org.yakindu.sct.ui.editor.extensions.IExpressionsProvider;
import org.yakindu.sct.ui.editor.policies.ExpressionDirectEditPolicy;

import com.google.inject.Injector;

import de.itemis.xtext.utils.gmf.directedit.ExternalXtextLabelEditPart;
import de.itemis.xtext.utils.gmf.directedit.XtextDirectEditManager;

/**
 * 
 * @author muelder
 * 
 */
public abstract class PlugableExternalXtextLabelEditPart extends ExternalXtextLabelEditPart {

	private Injector injector;
	private int editorStyle;

	public PlugableExternalXtextLabelEditPart(View view) {
		super(view);
		init();
	}

	private void init() {
		Extensions<IExpressionsProvider> extensions = new Extensions<IExpressionsProvider>(
				IExpressionsProvider.EXPRESSIONS_EXTENSION);
		IExpressionsProvider registeredProvider = extensions
				.getRegisteredProvider(resolveSemanticElement());
		injector = registeredProvider.getInjector();
		editorStyle = registeredProvider.getStyle();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		ExpressionDirectEditPolicy expressionDirectEditPolicy = new ExpressionDirectEditPolicy();
		injector.injectMembers(expressionDirectEditPolicy);
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				expressionDirectEditPolicy);
	}

	@Override
	protected XtextDirectEditManager createXTextDirectEditManager() {
		return new XtextDirectEditManager(this, injector, getEditorStyles());
	}

	@Override
	public ExpressionElement resolveSemanticElement() {
		return (ExpressionElement) super.resolveSemanticElement();
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);
		if (notification.getFeature() == SGraphPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION)
			refreshVisuals();
	}

	public String getEditText() {
		String exp = resolveSemanticElement().getExpression();
		return exp != null ? exp : "";
	}
	
	protected int getEditorStyles() {
		return editorStyle;
	}

	public Injector getInjector() {
		return injector;
	}


}
