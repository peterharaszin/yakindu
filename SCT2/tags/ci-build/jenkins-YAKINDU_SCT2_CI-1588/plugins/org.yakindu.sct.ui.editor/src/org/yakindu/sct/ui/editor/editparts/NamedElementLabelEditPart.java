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
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.ui.editor.DiagramActivator;

import de.itemis.gmf.runtime.commons.editparts.TextAwareLabelEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class NamedElementLabelEditPart extends TextAwareLabelEditPart {

	public NamedElementLabelEditPart(View view) {
		super(view, BasePackage.Literals.NAMED_ELEMENT__NAME,
				DiagramActivator.PLUGIN_ID);
	}
}
