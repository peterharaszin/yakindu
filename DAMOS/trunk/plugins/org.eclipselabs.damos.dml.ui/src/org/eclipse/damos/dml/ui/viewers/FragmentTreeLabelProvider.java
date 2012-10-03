/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.dml.ui.viewers;

import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.ui.DMLUIPlugin;
import org.eclipse.damos.dml.util.DMLUtil;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;

public class FragmentTreeLabelProvider extends BaseLabelProvider implements ILabelProvider, IFontProvider {
	
	private FragmentSelectionManager fragmentManager;
	private Font boldFont;
	
	private Image visibleImage;
	private ImageDescriptor visibleImageDescriptor;
	private Image invisibleImage;
	private ImageDescriptor invisibleImageDescriptor;
	
	/**
	 * 
	 */
	public FragmentTreeLabelProvider(FragmentSelectionManager fragmentManager, Font defaultFont) {
		this.fragmentManager = fragmentManager;
		
		FontData fontData = defaultFont.getFontData()[0];
		fontData.setStyle(SWT.BOLD);
		this.boldFont = new Font(defaultFont.getDevice(), fontData);
		
		visibleImageDescriptor = DMLUIPlugin.Implementation.imageDescriptorFromPlugin(DMLUIPlugin.PLUGIN_ID, "icons/fragment_visible.gif");
		visibleImage = JFaceResources.getResources().createImageWithDefault(visibleImageDescriptor);
		invisibleImageDescriptor = DMLUIPlugin.Implementation.imageDescriptorFromPlugin(DMLUIPlugin.PLUGIN_ID, "icons/fragment_invisible.gif");
		invisibleImage = JFaceResources.getResources().createImageWithDefault(invisibleImageDescriptor);
	}

	public Image getImage(Object element) {
		return fragmentManager.getSelectedFragment() == element || DMLUtil.isChildFragment(fragmentManager.getSelectedFragment(), (Fragment) element) ? visibleImage : invisibleImage;
	}

	public String getText(Object element) {
		return ((Fragment) element).getName();
	}
	
	public Font getFont(Object element) {
		return element == fragmentManager.getSelectedFragment() ? boldFont : null;
	}
	
	public void dispose() {
		super.dispose();
		boldFont.dispose();
		if (visibleImageDescriptor != null) {
			visibleImage = null;
			JFaceResources.getResources().destroyImage(visibleImageDescriptor);
			visibleImageDescriptor = null;
		}
		if (invisibleImageDescriptor != null) {
			invisibleImage = null;
			JFaceResources.getResources().destroyImage(invisibleImageDescriptor);
			invisibleImageDescriptor = null;
		}
	}

}