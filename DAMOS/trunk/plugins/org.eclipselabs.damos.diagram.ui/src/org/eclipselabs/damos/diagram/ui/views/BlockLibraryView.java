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

package org.eclipselabs.damos.diagram.ui.views;

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
import org.eclipselabs.damos.diagram.ui.internal.registry.BlockImageDescriptor;
import org.eclipselabs.damos.diagram.ui.internal.registry.BlockImageRegistry;
import org.eclipselabs.damos.diagram.ui.internal.viewers.BlockLibraryContentProvider;
import org.eclipselabs.damos.diagram.ui.internal.viewers.BlockLibraryLabelProvider;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BlockLibraryView extends ViewPart {

	private TreeViewer viewer;

	public BlockLibraryView() {
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
						BlockImageDescriptor blockImage = BlockImageRegistry.getInstance().getBlockImage(blockType.getQualifiedName());
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
		
		viewer.setContentProvider(new BlockLibraryContentProvider());
		viewer.setLabelProvider(new BlockLibraryLabelProvider());
		viewer.setInput(new Object());
	}

	@Override
	public void setFocus() {
		viewer.getTree().setFocus();
	}

}
