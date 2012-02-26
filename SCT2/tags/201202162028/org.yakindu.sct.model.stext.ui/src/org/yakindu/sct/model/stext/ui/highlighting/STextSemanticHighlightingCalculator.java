package org.yakindu.sct.model.stext.ui.highlighting;

import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.yakindu.base.types.Type;

public class STextSemanticHighlightingCalculator implements
		ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();

		for (INode node : root.getAsTreeIterable()) {
			if (node.getGrammarElement() instanceof CrossReference) {
				CrossReference cr = (CrossReference) node.getGrammarElement();
				if (Type.class.isAssignableFrom(cr.getType().getClassifier()
						.getInstanceClass())) {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							STextHighlightingConfiguration.HMI_CONCEPT);
				} else {
					acceptor.addPosition(node.getOffset(), node.getLength(),
							STextHighlightingConfiguration.WIDGET_TYPE);
				}

			}
		}
	}

}
