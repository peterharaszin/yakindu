/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.internal.editparts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipselabs.damos.diagram.ui.editpolicies.IEditPolicyRoles;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.NonDestroySemanticEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.editpolicies.TerminalEditPolicy;
import org.eclipselabs.damos.diagram.ui.internal.figures.IConnectorFigure;
import org.eclipselabs.damos.diagram.ui.internal.figures.WhileLoopConditionFigure;
import org.eclipselabs.damos.dml.Connector;

/**
 * @author Andreas Unger
 *
 */
public class WhileLoopConditionEditPart extends AbstractBorderItemEditPart implements IConnectorEditPart {

	/**
	 * @param view
	 */
	public WhileLoopConditionEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createDefaultEditPolicies()
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicy.COMPONENT_ROLE);
		installEditPolicy(IEditPolicyRoles.TERMINAL_ROLE, new TerminalEditPolicy());
		installEditPolicy(IEditPolicyRoles.SEMANTIC_ROLE, new NonDestroySemanticEditPolicy());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart#createNodeFigure()
	 */
	@Override
	protected NodeFigure createNodeFigure() {
		return new WhileLoopConditionFigure();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart#refreshBounds()
	 */
	@Override
	protected void refreshBounds() {
		super.refreshBounds();
		getFigure().revalidate();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.editparts.IConnectorEditPart#getConnector()
	 */
	public Connector getConnector() {
		return (Connector) resolveSemanticElement();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.internal.editparts.IConnectorEditPart#getConnectorFigure()
	 */
	public IConnectorFigure getConnectorFigure() {
		return (IConnectorFigure) getFigure();
	}
	
}
