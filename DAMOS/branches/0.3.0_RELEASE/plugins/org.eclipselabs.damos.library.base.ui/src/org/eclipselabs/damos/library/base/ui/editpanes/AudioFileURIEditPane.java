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

package org.eclipselabs.damos.library.base.ui.editpanes;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipselabs.damos.common.ui.widgets.IWidgetFactory;
import org.eclipselabs.damos.dml.ui.editpane.StringValueSpecificationEditPane;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileURIEditPane extends StringValueSpecificationEditPane {

	private Composite composite;
	private Text text;
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.editpane.StringValueSpecificationEditPane#createControl(org.eclipse.swt.widgets.Composite, org.eclipselabs.damos.common.ui.widgets.IWidgetFactory)
	 */
	@Override
	public void createControl(Composite parent, IWidgetFactory widgetFactory) {
		composite = widgetFactory.createComposite(parent);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		GridLayout layout = new GridLayout(3, false);
		composite.setLayout(layout);
		text = widgetFactory.createText(composite, "");
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Button browseWorkspaceButton = widgetFactory.createButton(composite, "Browse Workspace...", SWT.PUSH);
		browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				FilteredResourcesSelectionDialog d = new FilteredResourcesSelectionDialog(
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE);
				d.setInitialPattern("*.wav");
				d.open();
				Object firstResult = d.getFirstResult();
				if (firstResult instanceof IFile) {
					String pathString = ((IFile) firstResult).getFullPath().toString();
					setValue(URI.createPlatformResourceURI(pathString, true).toString());
				}
			}
			
		});

		Button browseFileSystemButton = widgetFactory.createButton(composite, "Browse File System...", SWT.PUSH);
		browseFileSystemButton.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				FileDialog d = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
				d.setFilterExtensions(new String[] { "*.wav" });
				String fileName = d.open();
				if (fileName != null) {
					setValue(URI.createFileURI(fileName).toString());
				}
			}
			
		});
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.editpane.StringValueSpecificationEditPane#getControl()
	 */
	@Override
	public Control getControl() {
		return composite;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.dml.ui.editpane.StringValueSpecificationEditPane#getText()
	 */
	@Override
	protected Text getText() {
		return text;
	}
	
}
