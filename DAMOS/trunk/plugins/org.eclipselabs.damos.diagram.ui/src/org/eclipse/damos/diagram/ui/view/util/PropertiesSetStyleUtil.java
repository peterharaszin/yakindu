/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.view.util;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.PropertiesSetStyle;
import org.eclipse.gmf.runtime.notation.PropertyValue;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @author Andreas Unger
 *
 */
public class PropertiesSetStyleUtil {

	public static Object getValue(View view, String styleName, String propertyName) {
		PropertiesSetStyle style = (PropertiesSetStyle) view.getNamedStyle(NotationPackage.eINSTANCE.getPropertiesSetStyle(), styleName);
		if (style != null) {
			return style.getProperty(propertyName);
		}
		return null;
	}
	
	public static String getStringValue(View view, String styleName, String propertyName) {
		Object o = getValue(view, styleName, propertyName);
		if (o instanceof String) {
			return (String) o;
		}
		return null;
	}
	
	public static boolean isNotifier(Notification notification, String styleName, String propertyName) {
		Object notifier = notification.getNotifier();
		if (notifier instanceof PropertyValue) {
			View view = ViewUtil.getViewContainer((PropertyValue) notifier);
			if (view != null) {
				PropertiesSetStyle style = (PropertiesSetStyle) view.getNamedStyle(NotationPackage.eINSTANCE.getPropertiesSetStyle(), styleName);
				if (style != null && notifier.equals(style.getPropertiesMap().get(propertyName))) {
					return true;
				}
			}
		}
		return false;
	}
	
}
