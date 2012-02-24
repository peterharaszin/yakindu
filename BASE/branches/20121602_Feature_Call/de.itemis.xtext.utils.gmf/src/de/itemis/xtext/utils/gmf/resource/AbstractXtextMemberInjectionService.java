/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package de.itemis.xtext.utils.gmf.resource;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
@SuppressWarnings("unchecked")
public abstract class AbstractXtextMemberInjectionService<S extends EObject, T extends EObject>
		implements IMemberInjectionService {

	List<org.eclipse.emf.common.util.Diagnostic> diagnostics = new ArrayList<org.eclipse.emf.common.util.Diagnostic>();

	@Inject
	private IParser parser;

	/**
	 * The ParserRule that should be invoked with the expression
	 * 
	 * @return the parser rule
	 */
	public abstract String getParserRule();

	/**
	 * Hook method, where the feature values from the rootAST element can be
	 * copied to the original EObject
	 * 
	 * @param original
	 * @param rootAST
	 */
	public abstract void setFeatures(S original, T rootAST);

	public void injectMembers(EObject object) {
		clearInternalState();
		EObject rootAst = parse((S) object);
		setFeatures((S) object, (T) rootAst);
	}

	public String getExpression(S object) {
		EAttribute feature = (EAttribute) getSourceFeature();
		if (feature.getEType() != EcorePackage.Literals.ESTRING) {
			throw new IllegalStateException(
					"source feature must be of type 'EString'");
		}
		String expression = (String) object.eGet(feature);
		return expression != null ? expression : "";
	}

	private S parse(S object) {
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(getParserRule());
		String expression = getExpression(object);
		IParseResult result = parser.parse(parserRule, new StringReader(
				expression != null ? expression : ""));
		addSyntaxErrors(result, object);
		return (S) result.getRootASTElement();
	}

	private void addSyntaxErrors(IParseResult result, final EObject object) {
		for (INode error : result.getSyntaxErrors()) {
			diagnostics.add(new BasicDiagnostic(
					org.eclipse.emf.common.util.Diagnostic.ERROR, "source", 0,
					error.getSyntaxErrorMessage().getMessage(),
					new Object[] { object }));
		}
	}

	private void clearInternalState() {
		diagnostics.clear();
	}

	public List<org.eclipse.emf.common.util.Diagnostic> getDiagnostics() {
		return diagnostics;
	}

}
