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

package org.eclipse.damos.dml.ui.parts;

import org.eclipse.damos.dml.LanguageId;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.damos.dml.ui.registry.BlockImageRegistry;
import org.eclipse.damos.dml.ui.registry.IBlockImageDescriptor;
import org.eclipse.damos.dml.ui.viewers.BlockLibraryContentProvider;
import org.eclipse.damos.dml.ui.viewers.BlockLibraryLabelProvider;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.emf.edit.ui.dnd.ViewerDragAdapter;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class BlockLibraryView extends ViewPart {

	private final String languageId;
	
	private TreeViewer viewer;

	@Inject
	public BlockLibraryView(@LanguageId String languageId) {
		this.languageId = languageId;
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setComparator(new ViewerComparator());
		
		Transfer[] transfers = new Transfer[] { LocalTransfer.getInstance() };
		viewer.addDragSupport(DND.DROP_COPY | DND.DROP_MOVE | DND.DROP_LINK, transfers, new ViewerDragAdapter(viewer) {
			
			private Image iconImage;
			
			@Override
			public void dragStart(DragSourceEvent event) {
				super.dragStart(event);
				if (selection instanceof IStructuredSelection) {
					IStructuredSelection structuredSelection = (IStructuredSelection) selection;
					Object element = structuredSelection.getFirstElement();
					if (element instanceof IBlockTypeDescriptor) {
						IBlockTypeDescriptor blockType = (IBlockTypeDescriptor) element;
						IBlockImageDescriptor blockImage = BlockImageRegistry.getInstance().getBlockImage(blockType.getQualifiedName());
						if (blockImage != null) {
							ImageDescriptor icon = blockImage.getIcon24ImageDescriptor();
							if (icon == null) {
								icon = blockImage.getIcon16ImageDescriptor();
							}
							if (icon != null) {
								iconImage = icon.createImage();
							}
						}
						event.image = iconImage;
						event.offsetX = 0;
						event.offsetY = 0;
						return;
					}
				}
				event.doit = false;
			}
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				super.dragFinished(event);
				if (iconImage != null) {
					iconImage.dispose();
					iconImage = null;
				}
			}
			
		});
		
		viewer.setContentProvider(new BlockLibraryContentProvider(languageId));
		viewer.setLabelProvider(new BlockLibraryLabelProvider());
		viewer.setInput(new Object());
	}

	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
	}

}
