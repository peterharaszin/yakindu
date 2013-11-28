/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package org.mda4e.statemachine.contribution.parsers;

import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.issues.IssuesImpl;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.xtend.check.CheckFacade;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.Variable;
import org.eclipse.xtend.typesystem.MetaModel;
import org.eclipse.xtend.typesystem.emf.EcoreUtil2;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.mda4e.statemachine.contribution.part.OurStatemachineDiagramEditorPlugin;

import statemachine.StatemachinePackage;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public abstract class XtextParserDelegate extends EAttributeParser {

	protected Class<? extends AbstractAntlrParser> parserClass;
	protected Module module;

	protected EObject selectedElement;
	private final static Log LOG = LogFactory.getLog(XtextParserDelegate.class);
	
	public XtextParserDelegate(Module module, EClass class1,
			EStructuralFeature structuralFeature,
			Class<? extends AbstractAntlrParser> parserClass) {
		super(class1, structuralFeature);
		this.parserClass = parserClass;
		this.module = module;
	}

	public void setSelectedElement(EObject selectedElement) {
		this.selectedElement = selectedElement;
	}
	
	protected IParserEditStatus getParseResult(String parserRuleToApply,
			String editString) {
		try {
			if (editString == null || editString.equals("")) {
				return ParserEditStatus.EDITABLE_STATUS;
			}

			AbstractAntlrParser parser = constructParser(module, parserClass,
					editString);

			IParseResult parseResult;
			try {
				parseResult = parser.parse(parserRuleToApply,
						new ByteArrayInputStream(editString.getBytes()));
			} catch (WrappedException e) {
				throw new IllegalArgumentException(e.getMessage(), e);
			}

			CompositeNode rootNode = parseResult.getRootNode();
			if (rootNode != null) {
				List<SyntaxError> allSyntaxErrors = getAllSyntaxErrors(rootNode);
				if (allSyntaxErrors.isEmpty()) {
					if (selectedElement == null) {
						throw new IllegalStateException("Selected element not set. Own checks can't be run.");
					}
					return checkOwnChecks(rootNode);
				}
				return new ParserEditStatus(IParserEditStatus.ERROR,
						OurStatemachineDiagramEditorPlugin.ID,
						IParserEditStatus.EDITABLE, allSyntaxErrors.get(0).getMessage(), null);
			} else {
				return new ParserEditStatus(IParserEditStatus.ERROR,
						OurStatemachineDiagramEditorPlugin.ID,
						IParserEditStatus.EDITABLE, parseResult
								.getParseErrors().get(0).getMessage(), null);
			}
		} catch (InvocationTargetException e) {
			return new ParserEditStatus(IParserEditStatus.ERROR,
					OurStatemachineDiagramEditorPlugin.ID,
					IParserEditStatus.EDITABLE, e.getCause().getMessage(), e);
		} catch (Exception e) {
			return new ParserEditStatus(IParserEditStatus.ERROR,
					OurStatemachineDiagramEditorPlugin.ID,
					IParserEditStatus.EDITABLE, e.getMessage(), e);
		}
	}

	protected IParserEditStatus checkOwnChecks(CompositeNode action) {
		String[] checkFiles = new String[] { "org::mda4e::statemachine::contribution::parsers::Checks" };
		IssuesImpl issues = new IssuesImpl();
		Map<String, Variable> globalVars = new HashMap<String, Variable>();
		globalVars.put("selectedElement", new Variable("selectedElement", selectedElement));
		globalVars.put("statechart", new Variable("statechart", EcoreUtil.getRootContainer(selectedElement)));
		ExecutionContextImpl ctx = new ExecutionContextImpl(globalVars);
		ctx.registerMetaModel(new EmfMetaModel(com.yakindu.statechart.model.expressions.statechartexpressions.StatechartexpressionsPackage.eINSTANCE));
		ctx.registerMetaModel(new EmfMetaModel(EcorePackage.eINSTANCE));
		ctx.registerMetaModel(new EmfMetaModel(StatemachinePackage.eINSTANCE));
		for (String checkFile : checkFiles) {
			Collection<EObject> allElements;
			if(action == null)
			{
				allElements = new ArrayList<EObject>();
			} else
			{
				allElements = EcoreUtil2.allContents((EObject) action);
				allElements.add((EObject) action);
			}					
			allElements.add(selectedElement);
			CheckFacade.checkAll(checkFile, allElements, ctx, issues);
			if(issues.hasErrors())
			{
				return new ParserEditStatus(IParserEditStatus.ERROR,
						OurStatemachineDiagramEditorPlugin.ID,
						IParserEditStatus.EDITABLE, issues.getErrors()[0].getMessage(), null);
			}
		}
		
		return ParserEditStatus.EDITABLE_STATUS;
	}

	private List<SyntaxError> getAllSyntaxErrors(AbstractNode node) {
		List<SyntaxError> syntaxErrors = new ArrayList<SyntaxError>();
		
		if (node instanceof CompositeNode) {
			for (AbstractNode childNode : ((CompositeNode) node).getChildren()) {
				syntaxErrors.addAll(getAllSyntaxErrors(childNode));
			}
		}
		if ( node.getSyntaxError() != null){
			syntaxErrors.add(node.getSyntaxError());
		}
		return syntaxErrors;
	}

	protected AbstractAntlrParser constructParser(Module module,
			Class<? extends AbstractAntlrParser> parserClass, String snippet)
			throws IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		// parse expression string
		Injector injector = Guice.createInjector(module);// new
															// com.yakindu.statechart.model.expressions.StatechartExpressionsRuntimeModule()
		AbstractAntlrParser parser = (AbstractAntlrParser) injector
				.getInstance(parserClass);
		return parser;
	}

}