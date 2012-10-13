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

package org.eclipse.damos.ide.ui.internal.editpolicies;

import org.eclipse.damos.dml.DMLPackage;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dscript.DscriptDataTypeSpecification;
import org.eclipse.damos.dscript.DscriptValueSpecification;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class LinkerEditPolicy extends AbstractEditPolicy {

	@Inject
	private ILinker linker;
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		EObject element = getHost().resolveSemanticElement();
		if (EcoreUtil.getAdapter(element.eAdapters(), LinkerAdapter.class) == null) {
			element.eAdapters().add(0, new LinkerAdapter());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getHost()
	 */
	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}
	
	private class LinkerAdapter extends EContentAdapter {
		
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.isTouch()) {
				return;
			}
			EObject element = null;
			if (notification.getNotifier() instanceof Fragment && notification.getFeature() == DMLPackage.eINSTANCE.getQualifiedElement_PackageName()) {
				element = getHost().resolveSemanticElement();
			} else if (notification.getNewValue() instanceof DscriptValueSpecification) {
				DscriptValueSpecification valueSpecification = (DscriptValueSpecification) notification.getNewValue();
				element = valueSpecification.getExpression();
			} else if (notification.getNewValue() instanceof DscriptDataTypeSpecification) {
				DscriptDataTypeSpecification dataTypeSpecification = (DscriptDataTypeSpecification) notification.getNewValue();
				element = dataTypeSpecification.getTypeSpecifier();
			}
			if (element != null) {
				linker.linkModel(element, new ListBasedDiagnosticConsumer());
			}
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#isAdapterForType(java.lang.Object)
		 */
		@Override
		public boolean isAdapterForType(Object type) {
			return type == LinkerAdapter.class;
		}

	}
	
}
