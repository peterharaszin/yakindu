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

package org.eclipse.damos.diagram.ui.internal.dnd;

import java.util.Collection;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;

/**
 * @author Andreas Unger
 *
 */
abstract class BlockTypeTransferDropTargetListener extends AbstractTransferDropTargetListener {

	private EditingDomain editingDomain;
	private PreferencesHint preferencesHint;

	/**
	 * @param viewer
	 */
	public BlockTypeTransferDropTargetListener(EditPartViewer viewer, Transfer transfer, EditingDomain editingDomain, PreferencesHint preferencesHint) {
		super(viewer, transfer);
		this.setEditingDomain(editingDomain);
		this.setPreferencesHint(preferencesHint);
	}

	@Override
	protected void handleDragOver() {
		getCurrentEvent().feedback = DND.FEEDBACK_SCROLL | DND.FEEDBACK_EXPAND;
		super.handleDragOver();
	}

	@Override
	protected void handleDrop() {
		if (!getTargetRequest().getExtendedData().containsKey(IBlockTypeProvider.class)) {
			getCurrentEvent().detail = DND.DROP_NONE;
		} else {
			super.handleDrop();
			if (getCurrentEvent().detail != DND.DROP_NONE) {
				selectAddedObject();
			}
		}
	}

	private void selectAddedObject() {
		Object model = getTargetRequest().getNewObject();
		if (model instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>) model;
			if (!collection.isEmpty()) {
				model = collection.iterator().next();
			}
		}
		if (model instanceof IAdaptable) {
			IAdaptable adaptable = (IAdaptable) model;
			model = adaptable.getAdapter(View.class);
		}
		if (model == null) {
			return;
		}
		EditPartViewer viewer = getViewer();
		viewer.getControl().forceFocus();
		Object editpart = viewer.getEditPartRegistry().get(model);
		if (editpart instanceof EditPart) {
			// Force a layout first.
			getViewer().flush();
			viewer.select((EditPart) editpart);
		}
	}
	
	@Override
	protected abstract CreateRequest createTargetRequest();

	@Override
	protected CreateRequest getTargetRequest() {
		return (CreateRequest) super.getTargetRequest();
	}

	@Override
	protected void updateTargetRequest() {
		CreateRequest request = getTargetRequest();
		request.setLocation(getDropLocation());
	}

	/**
	 * @param editingDomain the editingDomain to set
	 */
	protected void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * @return the editingDomain
	 */
	protected EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @param preferencesHint the preferencesHint to set
	 */
	protected void setPreferencesHint(PreferencesHint preferencesHint) {
		this.preferencesHint = preferencesHint;
	}

	/**
	 * @return the preferencesHint
	 */
	protected PreferencesHint getPreferencesHint() {
		return preferencesHint;
	}

}