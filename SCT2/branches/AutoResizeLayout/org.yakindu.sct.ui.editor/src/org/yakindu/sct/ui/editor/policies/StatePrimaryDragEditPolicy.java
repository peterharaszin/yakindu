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
package org.yakindu.sct.ui.editor.policies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatePrimaryDragEditPolicy extends PreferredSizeEditPolicy {

	public static final int SPACEING = 10;

	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		if (!isRequestValid(request)) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getResizeCommand(request);
	}

	protected boolean isRequestValid(ChangeBoundsRequest request) {
		final Rectangle newBounds = request
				.getTransformedRectangle(getHostFigure().getBounds());
		Dimension prefSize = getHost().getFigure().getPreferredSize().getCopy();
		prefSize = prefSize.expand(SPACEING, SPACEING);
		if (!newBounds.getSize().contains(prefSize))
			return false;
		return true;
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}
}
