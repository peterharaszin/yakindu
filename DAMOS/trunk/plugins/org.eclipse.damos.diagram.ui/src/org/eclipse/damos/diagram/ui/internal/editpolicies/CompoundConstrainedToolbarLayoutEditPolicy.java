/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.internal.editpolicies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.SharedCursors;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableCompartmentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;

/**
 * @author Andreas Unger
 *
 */
public class CompoundConstrainedToolbarLayoutEditPolicy extends ConstrainedToolbarLayoutEditPolicy {

	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		if (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {
			if (child instanceof ResizableCompartmentEditPart) {
				return new ResizableCompartmentEditPolicy(isHorizontal()) {
	
					protected java.util.List<?> createCollapseHandles() {
						return Collections.emptyList();
					}
					
				};
			}
			if (child instanceof IBorderItemEditPart) {
				return new BorderItemSelectionEditPolicy() {

					@Override
					protected List<?> createSelectionHandles() {
						List<?> list = new ArrayList<Object>();
						DragEditPartsTrackerEx tracker = new DragEditPartsTrackerEx(getHost()) {

							protected boolean isMove() {
								return true;
							}

						};
						NonResizableHandleKit.addMoveHandle((GraphicalEditPart) getHost(), list, tracker,
								SharedCursors.ARROW);
						NonResizableHandleKit.addCornerHandles((GraphicalEditPart) getHost(), list, tracker,
								SharedCursors.ARROW);
						return list;
					}

				};
			}
		}
		return super.createChildEditPolicy(child);
	}

}
