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

package org.eclipselabs.damos.ide.ui.internal.editpolicies;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dmltext.MscriptDataTypeSpecification;
import org.eclipselabs.damos.dmltext.MscriptValueSpecification;

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
			if (notification.getNotifier() instanceof Fragment && notification.getFeature() == DMLPackage.eINSTANCE.getQualifiedElement_PackageName()) {
				linker.linkModel(getHost().resolveSemanticElement(), new ListBasedDiagnosticConsumer());
			} else if (notification.getNewValue() instanceof MscriptValueSpecification) {
				MscriptValueSpecification valueSpecification = (MscriptValueSpecification) notification.getNewValue();
				linker.linkModel(valueSpecification.getExpression(), new ListBasedDiagnosticConsumer());
			} else if (notification.getNewValue() instanceof MscriptDataTypeSpecification) {
				MscriptDataTypeSpecification dataTypeSpecification = (MscriptDataTypeSpecification) notification.getNewValue();
				linker.linkModel(dataTypeSpecification.getTypeSpecifier(), new ListBasedDiagnosticConsumer());
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
