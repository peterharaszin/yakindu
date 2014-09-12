package org.yakindu.base.expressions.types;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;

import de.itemis.xtext.typesystem.messages.IErrorMessageProvider;

public class OperatorErrorMessageProvider implements IErrorMessageProvider<EObject> {

	private String operator;
	private String message;
	private EAttribute operatorFeature;

	public OperatorErrorMessageProvider(String message, EAttribute operatorFeature) {
		this.message = message;
		this.operatorFeature = operatorFeature;
	}

	public OperatorErrorMessageProvider(String message, String operator) {
		this.message = message;
		this.operator = operator;
	}

	public String create(EObject element, EObject... type) {
		List<String> varargs = new ArrayList<String>();
		varargs.add(operator != null ? operator : element.eGet(operatorFeature).toString());
		for (EObject eObject : type) {
			varargs.add(eObject.toString());
		}
		return String.format(message, varargs.toArray());
	}
}
