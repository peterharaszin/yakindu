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

package org.eclipse.damos.dml.ui.properties;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

/**
 * @author Andreas Unger
 *
 */
class PropertySectionUtil {

	private static final int MARGIN_WIDTH = ITabbedPropertyConstants.HSPACE + 2;
	private static final int MARGIN_HEIGHT = ITabbedPropertyConstants.VSPACE;
	private static final int HORIZONTAL_SPACING = ITabbedPropertyConstants.HMARGIN + 1;
	private static final int VERTICAL_SPACING = ITabbedPropertyConstants.VMARGIN + 1;

	public static GridLayout createDefaultGridLayout() {
		return createDefaultGridLayout(1);
	}
	
	public static GridLayout createDefaultGridLayout(int numColumns) {
		GridLayout layout = new GridLayout(numColumns, false);
		layout.marginWidth = MARGIN_WIDTH;
		layout.marginHeight = MARGIN_HEIGHT;
		layout.horizontalSpacing = HORIZONTAL_SPACING;
		layout.verticalSpacing = VERTICAL_SPACING;
		return layout;
	}

	public static Composite createTopLevelComposite(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
		return createTopLevelComposite(parent, 1, widgetFactory);
	}

	public static Composite createTopLevelComposite(Composite parent, int numColumns, TabbedPropertySheetWidgetFactory widgetFactory) {
		Composite composite = widgetFactory.createComposite(parent);
		GridLayout layout = PropertySectionUtil.createDefaultGridLayout(numColumns);
		layout.marginHeight *= 2;
		composite.setLayout(layout);
		return composite;
	}
	
	public static Composite createComposite(Composite parent, TabbedPropertySheetWidgetFactory widgetFactory) {
		return createComposite(parent, 1, widgetFactory);
	}

	public static Composite createComposite(Composite parent, int numColumns, TabbedPropertySheetWidgetFactory widgetFactory) {
		Composite composite = widgetFactory.createComposite(parent);
		composite.setLayout(PropertySectionUtil.createDefaultGridLayout(numColumns));
		return composite;
	}

	public static Section createTopLevelSection(Composite parent, String title, int numColumns, TabbedPropertySheetWidgetFactory widgetFactory) {
		Composite composite = PropertySectionUtil.createComposite(parent, widgetFactory);
		
		Section section = widgetFactory.createSection(composite, Section.TITLE_BAR);
		section.setText(title);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
		Composite client = widgetFactory.createComposite(section);
		section.setClient(client);
		client.setLayout(PropertySectionUtil.createDefaultGridLayout(numColumns));
		
		return section;
	}
	
}
