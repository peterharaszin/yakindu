package org.yakindu.base.expressions.types;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.expressions.expressions.Expression;

import de.itemis.xtext.typesystem.messages.IErrorMessageProvider;

public class OperatorErrorMessageProvider implements IErrorMessageProvider<Expression> {

	private String message;
	private EAttribute operatorFeature;

	public OperatorErrorMessageProvider(String message, EAttribute operatorFeature) {
		this.message = message;
		this.operatorFeature = operatorFeature;
	}

	public String create(Expression element, EObject type) {
		return String.format(message, element.eGet(operatorFeature), type);
	}

}
