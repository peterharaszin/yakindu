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

package org.eclipselabs.damos.dml.ui.properties;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipselabs.damos.dml.Component;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractModelPropertySection extends AbstractPropertySection {

	/**
	 * 
	 */
	public AbstractModelPropertySection() {
		super();
	}

	protected EObject getModel() {
		IStructuredSelection selection = (IStructuredSelection) getSelection();
		if (selection != null) {
			Object element = selection.getFirstElement();
			if (element instanceof Component) {
				return (EObject) element;
			}
			if (element instanceof IAdaptable) {
				return (EObject) ((IAdaptable) element).getAdapter(EObject.class);
			}
		}
		return null;
	}
	
	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getModel());
	}

}