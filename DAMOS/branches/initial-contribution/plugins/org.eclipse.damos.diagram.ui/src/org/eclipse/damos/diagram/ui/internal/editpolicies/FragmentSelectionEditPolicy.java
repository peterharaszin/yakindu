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

import org.eclipse.damos.diagram.ui.internal.figures.IBlankableFigure;
import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.FragmentElement;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dml.util.FragmentSelectionChangeEvent;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.damos.dml.util.IFragmentSelectionChangeListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;

/**
 * @author Andreas Unger
 *
 */
public class FragmentSelectionEditPolicy extends GraphicalEditPolicy {

	private IFragmentSelectionChangeListener fragmentChangeListener = new IFragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refreshBlanked();
		}

	};

	private Adapter semanticAdapter = new AdapterImpl() {
		
		public void notifyChanged(Notification msg) {
			if (msg.getFeature() == DMLPackage.Literals.FRAGMENT_ELEMENT__OWNING_FRAGMENT) {
				refreshBlanked();
			}
		}
		
	};
	
	private FragmentElement cachedFragmentElement;

	public void activate() {
		super.activate();
		
		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getHost().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.addFragmentSelectionChangeListener(fragmentChangeListener);
		}

		EObject element = getHost().resolveSemanticElement();
		if (element != null) {
			cachedFragmentElement = DMLUtil.getOwner(element, FragmentElement.class);
			if (cachedFragmentElement != null) {
				cachedFragmentElement.eAdapters().add(semanticAdapter);
			}
		}
		
		refreshBlanked();
	}
	
	public void deactivate() {
		if (cachedFragmentElement != null) {
			cachedFragmentElement.eAdapters().remove(semanticAdapter);
		}

		FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getHost().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentManager != null) {
			fragmentManager.removeFragmentSelectionChangeListener(fragmentChangeListener);
		}
		
		super.deactivate();
	}

	private void refreshBlanked() {
		boolean blanked = false;
		
		EObject element = getHost().resolveSemanticElement();
		if (element instanceof FragmentElement) {
			FragmentElement fragmentElement = (FragmentElement) element;
			FragmentSelectionManager fragmentManager = (FragmentSelectionManager) getHost().getRoot().getContents().getAdapter(FragmentSelectionManager.class);
			if (fragmentManager != null) {
				Fragment selectedFragment = fragmentManager.getSelectedFragment();
				blanked = selectedFragment != fragmentElement.getOwningFragment() && !DMLUtil.isChildFragment(selectedFragment, fragmentElement.getOwningFragment());
			}
		}
		
        if (blanked && getHost().getSelected() != EditPart.SELECTED_NONE) {
        	getHost().getViewer().deselect(getHost());
        }

        IBlankableFigure blankableFigure = getBlankableFigure();
		if (blankableFigure != null) {
			blankableFigure.setBlanked(blanked);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getHost()
	 */
	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}
	
	protected IBlankableFigure getBlankableFigure() {
		IFigure figure = getHostFigure();
		if (figure instanceof IBlankableFigure) {
			return (IBlankableFigure) figure;
		}
		return null;
	}

}
