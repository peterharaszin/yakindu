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
package org.yakindu.sct.ui.editor.edithelper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.dialogs.SelectSubmachineDialog;
import org.yakindu.sct.ui.editor.dialogs.SelectSubmachineDialog.StatechartViewerFilter;
import org.yakindu.sct.ui.editor.editor.StatechartElementTypes;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateEditHelper extends VertexEditHelper {
	/**
	 * Creates regions for {@link State}s created with the Composite/Orthogonal
	 * State tool.
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {

		if (StatechartElementTypes.COMPOSITE_STATE.equals(req
				.getTypeToConfigure())) {
			return createCompositeStateCommand(req);
		} else if (StatechartElementTypes.ORTHOGONAL_STATE.equals(req
				.getTypeToConfigure())) {
			return createOrthogonalState(req);
		} else if (StatechartElementTypes.SUBMACHINE_STATE.equals(req
				.getTypeToConfigure())) {
			return createSubmachineStateCommand(req);
		}
		return null;
	}

	private ICommand createSubmachineStateCommand(ConfigureRequest req) {
		SelectSubmachineDialog dialog = new SelectSubmachineDialog(new Shell(),
				new StatechartViewerFilter(req.getElementToConfigure()));
		if (Dialog.OK == dialog.open()) {
			Statechart selectedSubmachine = dialog.getSelectedSubmachine();
			if (selectedSubmachine != null) {
				return new SetValueCommand(new SetRequest(
						req.getElementToConfigure(),
						SGraphPackage.Literals.STATE__SUBSTATECHART,
						selectedSubmachine));
			}
		}
		return null;
	}

	private ICommand createOrthogonalState(ConfigureRequest req) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName("r1");
		Region region2 = SGraphFactory.eINSTANCE.createRegion();
		region2.setName("r2");
		return new SetValueCommand(new SetRequest(req.getElementToConfigure(),
				SGraphPackage.Literals.STATE__SUB_REGIONS,
				com.google.common.collect.Lists.newArrayList(region, region2)));
	}

	private ICommand createCompositeStateCommand(ConfigureRequest req) {
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName("r1");
		return new SetValueCommand(new SetRequest(req.getElementToConfigure(),
				SGraphPackage.Literals.STATE__SUB_REGIONS, region));
	}
}
