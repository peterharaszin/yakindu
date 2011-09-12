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
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.DiagramActivator;

import de.itemis.gmf.runtime.commons.editparts.TextAwareLabelEditPart;

/**
 * 
 * @author andreas muelder
 * 
 */
public class NamedElementLabelEditPart extends TextAwareLabelEditPart {

	public NamedElementLabelEditPart(View view) {
		super(view, SGraphPackage.Literals.NAMED_ELEMENT__NAME,
				DiagramActivator.PLUGIN_ID);
	}
}
