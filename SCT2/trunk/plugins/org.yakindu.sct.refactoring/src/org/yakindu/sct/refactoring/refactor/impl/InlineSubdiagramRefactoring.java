/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.breadcrumb.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class InlineSubdiagramRefactoring extends SubdiagramRefactoring {

	@Override
	public boolean isExecutable() {
		return super.isExecutable() && getInlineStyle() != null && !getInlineStyle().isBooleanValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void internalExecute() {
		BooleanValueStyle inlineStyle = getInlineStyle();
		if (inlineStyle == null) {
			inlineStyle = createInlineStyle();
			getContextObject().getStyles().add(inlineStyle);
		}
		inlineStyle.setBooleanValue(true);
		View contextView = getContextObject();
		State contextElement = (State) contextView.getElement();
		Diagram diagramToInline = DiagramPartitioningUtil.getSubDiagram(contextElement);
		View containerView = ViewUtil.getChildBySemanticHint(contextView, SemanticHints.STATE_FIGURE_COMPARTMENT);

		EList<View> children = diagramToInline.getChildren();
		for (View view : children) {
			containerView.insertChild(view);
			EList<Edge> edges = diagramToInline.getEdges();
			for (Edge edge : edges) {
				containerView.getDiagram().insertEdge(edge);
			}
		}

		getResource().getContents().remove(diagramToInline);
	}
}
