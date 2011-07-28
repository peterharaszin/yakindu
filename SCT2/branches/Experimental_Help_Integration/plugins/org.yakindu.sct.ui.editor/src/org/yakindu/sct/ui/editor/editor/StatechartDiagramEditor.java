/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.validation.ValidationAction;


/**
 * 
 * @author andreas muelder
 * 
 */
public class StatechartDiagramEditor extends DiagramDocumentEditor implements
		IGotoMarker/*, IContextProvider*/ {

//	private ContextProviderDelegate contextProviderDelegate =
//			new ContextProviderDelegate(DiagramActivator.getDefault().getBundle().getSymbolicName());

	
	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";
	
	public StatechartDiagramEditor() {
		super(true);
	}

	@Override
	public String getContributorId() {
		return ID;
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);

		getEditingDomain().addResourceSetListener(
				new ResourceSetListenerImpl() {
					@Override
					public void resourceSetChanged(ResourceSetChangeEvent event) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								if (getDiagram() != null) {
									ValidationAction.validate(
											getDiagramEditPart(), getDiagram());
								}
							}
						});

					}
				});
	}

	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	@Override
	protected PreferencesHint getPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}
	
	/*
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getDiagramGraphicalViewer().getControl(), "org.yakindu.sct.ui.editor.YAKINDU_SCT_EDITOR");
//		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IYakinduSCTHelpConstants.YAKINDU_PROPERTY_SHEETS);
//		 getSite().getShell().setData( HelpUtil.CONTEXT_PROVIDER_KEY, this);
//	        HelpUtil.setHelp( getSite().getShell(), 
//	        		HelpUtil.getContextId(IYakinduSCTHelpConstants.YAKINDU_PROPERTY_SHEETS,
//	        				DiagramActivator.getDefault().getBundle().getSymbolicName()));
		
	} */
	
//	public IContext getContext(Object target) {
//		return contextProviderDelegate.getContext(target);
//	}
//
//	public int getContextChangeMask() {
//		return contextProviderDelegate.getContextChangeMask();
//	}
//
//	public String getSearchExpression(Object target) {
//		return contextProviderDelegate.getSearchExpression(target);
//	}

}
