/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.ui.contentassist;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.base.types.Operation;
import org.yakindu.sct.model.stext.services.STextGrammarAccess;
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.FeatureCall;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.SimpleScope;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionReaction;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

import com.google.inject.Inject;

/**
 * Several filters to make proposals more useful.
 * 
 * @author muehlbrandt
 */
public class STextProposalProvider extends AbstractSTextProposalProvider {

	@Inject
	private STextGrammarAccess grammarAccess;

	/**
	 * Validates if a keyword should be viewed by the proposal view.
	 * 
	 * Builds dependent on the ContentAssistContext a list with keywords which
	 * shouldn't be displayed by the proposal view.
	 */
	@Override
	public void completeKeyword(Keyword keyword,
			ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		List<Keyword> keywords = new ArrayList<Keyword>();
		// context Transition
		if (contentAssistContext.getRootModel() instanceof TransitionReaction) {
			keywords.addAll(getKeywords(grammarAccess.getEntryEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getExitEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getOnCycleEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess()
					.getGroup().eContents()));
		}
		// context States
		else if (contentAssistContext.getRootModel() instanceof SimpleScope) {
			keywords.addAll(getKeywords(grammarAccess
					.getVariableDefinitionAccess().getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess
					.getEventDefinitionAccess().getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getExitpointAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getEntrypointAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getDirectionAccess()
					.getAlternatives().eContents()));
			keywords.addAll(getKeywords(grammarAccess
					.getOperationDefinitionAccess().getGroup().eContents()));
		}
		// context Statechart
		else if (contentAssistContext.getRootModel() instanceof StatechartSpecification) {
			keywords.addAll(getKeywords(grammarAccess.getExitEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getEntryEventAccess()
					.getGroup().eContents()));
		}

		EObject currentModel = contentAssistContext.getCurrentModel();
		if (currentModel instanceof InterfaceScope) {
			keywords.addAll(getKeywords(grammarAccess.getLocalReactionAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getAlwaysEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getOnCycleEventAccess()
					.getGroup().eContents()));
			keywords.addAll(getKeywords(grammarAccess.getTimeEventTypeAccess()
					.getAlternatives().eContents()));
			keywords.add(grammarAccess.getDirectionAccess()
					.getLOCALLocalKeyword_0_0());
		}

		if (currentModel instanceof FeatureCall) {
			FeatureCall featureCall = (FeatureCall) currentModel;
			if (!(featureCall.getFeature() instanceof Operation)) {
				keywords.add(grammarAccess.getFeatureCallAccess()
						.getOperationCallLeftParenthesisKeyword_1_3_0_0());
			}
		}
		if (currentModel instanceof ElementReferenceExpression) {
			ElementReferenceExpression referenceExpression = (ElementReferenceExpression) currentModel;
			if (!(referenceExpression.getReference() instanceof Operation)) {
				keywords.add(grammarAccess
						.getElementReferenceExpressionAccess()
						.getOperationCallLeftParenthesisKeyword_2_0_0());
			}
		}
		if (currentModel instanceof InternalScope) {
			keywords.add(grammarAccess.getDirectionAccess()
					.getINInKeyword_1_0());
			keywords.add(grammarAccess.getDirectionAccess()
					.getOUTOutKeyword_2_0());
		}

		if (!keywords.contains(keyword)) {
			super.completeKeyword(keyword, contentAssistContext,
					new AcceptorDelegate(acceptor));

		}
	}

	private List<Keyword> getKeywords(EList<EObject> list) {
		final List<Keyword> keywords = new ArrayList<Keyword>();
		for (EObject eObject : list) {
			if (eObject instanceof Keyword) {
				keywords.add((Keyword) eObject);
			} else if (eObject instanceof EnumLiteralDeclaration) {
				keywords.add(((EnumLiteralDeclaration) eObject).getLiteral());
			}
		}
		return keywords;
	}

	@Override
	public void complete_BOOL(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(
				model, "boolean", acceptor);

		for (String s : new String[] { "true", "false", "yes", "no" }) {
			ICompletionProposal proposal = createCompletionProposal(s, s
					+ " - " + ruleCall.getRule().getName(), null, context);

			priorityOptimizer.accept(proposal);
		}
	}

	protected ICompletionProposalAcceptor getCustomAcceptor(EObject model,
			String typeName, ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = acceptor;
		if (model instanceof VariableDefinition) {
			VariableDefinition vd = (VariableDefinition) model;
			if (vd.getType() != null
					&& typeName.equalsIgnoreCase(vd.getType().getName())) {
				priorityOptimizer = new ICompletionProposalAcceptor.Delegate(
						acceptor) {
					@Override
					public void accept(ICompletionProposal proposal) {
						alterPriority(proposal, 1);
						super.accept(proposal);
					}
				};
			}
		}
		return priorityOptimizer;
	}

	@Override
	public void complete_STRING(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {

		super.complete_STRING(model, ruleCall, context,
				getCustomAcceptor(model, "string", acceptor));
	}

	@Override
	public void complete_INT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.complete_INT(model, ruleCall, context,
				getCustomAcceptor(model, "integer", acceptor));
	}

	@Override
	public void complete_HEX(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(
				model, "integer", acceptor);

		String proposalText = "0x1";
		ICompletionProposal proposal = createCompletionProposal(proposalText,
				proposalText + " - " + ruleCall.getRule().getName(), null,
				context);

		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
			configurable
					.setSelectionStart(configurable.getReplacementOffset() + 2);
			configurable.setSelectionLength(proposalText.length() - 2);
			configurable.setAutoInsertable(false);
			configurable.setSimpleLinkedMode(context.getViewer(), '\t', ' ');
		}

		priorityOptimizer.accept(proposal);
	}

	@Override
	public void complete_FLOAT(EObject model, RuleCall ruleCall,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ICompletionProposalAcceptor priorityOptimizer = getCustomAcceptor(
				model, "real", acceptor);

		String proposalText = "0.1";
		ICompletionProposal proposal = createCompletionProposal(proposalText,
				proposalText + " - " + ruleCall.getRule().getName(), null,
				context);
		priorityOptimizer.accept(proposal);
	}

	private void alterPriority(ICompletionProposal proposal, int delta) {
		if (proposal == null
				|| !(proposal instanceof ConfigurableCompletionProposal))
			return;
		ConfigurableCompletionProposal castedProposal = (ConfigurableCompletionProposal) proposal;
		castedProposal.setPriority(castedProposal.getPriority() + delta);
	}

	/**
	 * The acceptor delegate creates a Dummy EObject of type Keyword for the
	 * User Help Hover integration
	 * 
	 */
	public class AcceptorDelegate implements ICompletionProposalAcceptor {

		private final ICompletionProposalAcceptor delegate;

		public AcceptorDelegate(ICompletionProposalAcceptor delegate) {
			this.delegate = delegate;
		}

		public void accept(ICompletionProposal proposal) {
			if (proposal instanceof ConfigurableCompletionProposal) {
				Keyword keyword = XtextFactory.eINSTANCE.createKeyword();
				keyword.setValue(proposal.getDisplayString());
				((ConfigurableCompletionProposal) proposal)
						.setAdditionalProposalInfo(keyword);
				((ConfigurableCompletionProposal) proposal)
						.setHover(STextProposalProvider.this.getHover());
			}
			delegate.accept(proposal);
		}

		public boolean canAcceptMoreProposals() {
			return delegate.canAcceptMoreProposals();
		}

	}

}
