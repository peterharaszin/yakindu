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

package org.eclipselabs.damos.dmltext.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipselabs.damos.dmltext.internal.util.TextAdapter;

/**
 * @author Andreas Unger
 *
 */
public class DMLTextUtil {

	public static String getText(EObject eObject) {
		TextAdapter adapter = (TextAdapter) EcoreUtil.getAdapter(eObject.eAdapters(), TextAdapter.class);
		if (adapter != null) {
			return adapter.getText();
		}
		INode node = NodeModelUtils.findActualNodeFor(eObject);
		if (node != null) {
			return node.getText().trim();
		}
		return null;
	}

	public static void setText(EObject eObject, String text) {
		TextAdapter adapter = (TextAdapter) EcoreUtil.getAdapter(eObject.eAdapters(), TextAdapter.class);
		if (adapter != null) {
			adapter.setText(text);
		} else {
			eObject.eAdapters().add(new TextAdapter(text));
		}
	}

}
