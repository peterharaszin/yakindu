/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.diagram.ui.internal.dnd;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.Tool;
import org.eclipse.gef.dnd.TemplateTransfer;
import org.eclipse.gef.dnd.TemplateTransferDropTargetListener;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;
import org.eclipse.swt.dnd.DND;

/**
 * @author Andreas Unger
 *
 */
public class ToolTransferDropTargetListener extends TemplateTransferDropTargetListener {

	/**
	 * @param viewer
	 */
	public ToolTransferDropTargetListener(EditPartViewer viewer) {
		super(viewer);
	}

	protected Request createTargetRequest() {
		CreationTool tool = getCreationTool();
		if (tool != null) {
			tool.setViewer(getViewer());
			tool.setEditDomain(getViewer().getEditDomain());
			return tool.createCreateRequest();
		}
		return null;
	}

	protected void handleDragOver() {
		int originalDetail = getCurrentEvent().detail;
		getCurrentEvent().feedback = DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
		super.handleDragOver();
		getCurrentEvent().detail = originalDetail; // Restore original detail
	}

	protected void handleDrop() {
		super.handleDrop();
		if (getTargetRequest() instanceof CreateRequest) {
			Object newObject = getCreateRequest().getNewObject();
			Collection<?> newObjects = (newObject instanceof Collection<?> ? (Collection<?>) newObject
					: Collections.singletonList(newObject));
			getCreationTool().selectNewShapes(getViewer(), newObjects);
		}
	}

	private CreationTool getCreationTool() {
		Object template = TemplateTransfer.getInstance().getTemplate();
		if (template instanceof CreationToolEntry) {
			Tool tool = ((CreationToolEntry) template).createTool();
			if (tool instanceof CreationTool) {
				return (CreationTool) tool;
			}
		}
		return null;
	}
	
}