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

package org.eclipselabs.damos.diagram.ui.internal.palette;

import java.util.List;

import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.dnd.TemplateTransferDragSourceListener;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.graphics.Image;

/**
 * @author Andreas Unger
 *
 */
public class PaletteViewerProvider extends org.eclipse.gef.ui.palette.PaletteViewerProvider {

	/**
	 * @param graphicalViewerDomain
	 */
	public PaletteViewerProvider(EditDomain graphicalViewerDomain) {
		super(graphicalViewerDomain);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.ui.palette.PaletteViewerProvider#configurePaletteViewer(org.eclipse.gef.ui.palette.PaletteViewer)
	 */
	@Override
	protected void configurePaletteViewer(PaletteViewer viewer) {
		super.configurePaletteViewer(viewer);
		viewer.setEditPartFactory(new PaletteEditPartFactory());
		viewer.addDragSourceListener(new TemplateTransferDragSourceListener(viewer) {
			
			private Image iconImage;
			
			@Override
			public void dragStart(DragSourceEvent event) {
				super.dragStart(event);
				PaletteEntry entry = getPaletteEntry();
				if (entry != null) {
					ImageDescriptor icon = entry.getLargeIcon();
					if (icon == null) {
						icon = entry.getSmallIcon();
					}
					if (icon != null) {
						iconImage = icon.createImage();
					}
				}
				event.image = iconImage;
				event.offsetX = 0;
				event.offsetY = 0;
			}
			
			@Override
			public void dragFinished(DragSourceEvent event) {
				super.dragFinished(event);
				if (iconImage != null) {
					iconImage.dispose();
					iconImage = null;
				}
			}
			
			private PaletteEntry getPaletteEntry() {
				List<?> selection = getViewer().getSelectedEditParts();
				if (selection.size() == 1) {
					EditPart editpart = (EditPart) getViewer().getSelectedEditParts().get(0);
					Object model = editpart.getModel();
					if (model instanceof PaletteEntry) {
						return (PaletteEntry) model;
					}
				}
				return null;
			}
			
		});
	}
	
}
