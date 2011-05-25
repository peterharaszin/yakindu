/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.statechart.diagram.editor;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramActionBarContributor;
import org.eclipse.ui.IActionBars;
/**
 * 
 * @author Andreas Muelder <a href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
*
 */
public class StatechartDiagramActionbarContributor extends
		DiagramActionBarContributor {


	@Override
	public void init(IActionBars bars) {
		super.init(bars);
		//workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=346648
		bars.clearGlobalActionHandlers();
	}
	
	@Override
	protected String getEditorId() {
		return StatechartDiagramEditor.ID;
	}

	@Override
	protected Class<StatechartDiagramEditor> getEditorClass() {
		return StatechartDiagramEditor.class;
	}
	

}
