package org.kieler.synccharts.editor.helper;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementType;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.kieler.synccharts.editor.factory.KielerMetaModelTypeFactory;
import org.kieler.syncharts.model.synccharts.SyncchartsPackage;
import org.kieler.syncharts.model.synccharts.TransitionType;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.ui.editor.edithelper.TransitionEditHelper;

public class SyncTransitionEditHelper extends TransitionEditHelper {

	public SyncTransitionEditHelper() {
		System.out.println("Created");
	}

	@Override
	protected ICommand getCreateCommand(CreateElementRequest req) {
		// TODO Auto-generated method stub
		return super.getCreateCommand(req);
	}

	/**
	 * Set the right {@link EntryKind} for the given {@link ElementType}
	 */
	@Override
	protected ICommand getConfigureCommand(ConfigureRequest req) {
		CompositeCommand result = new CompositeCommand("Create Transition");
		result.add(super.getConfigureCommand(req));

		ElementTypeRegistry registry = ElementTypeRegistry.getInstance();
		IElementType normalTransition = registry
				.getType(KielerMetaModelTypeFactory.NORMAL_TRANSITION_ID);
		IElementType weakTransition = registry
				.getType(KielerMetaModelTypeFactory.WEAK_TRANSITION_ID);
		IElementType strongTransition = registry
				.getType(KielerMetaModelTypeFactory.STRONG_TRANSITION_ID);

		if (normalTransition.equals(req.getTypeToConfigure())) {
			result.add(new SetValueCommand(
					new SetRequest(req.getElementToConfigure(),
							SyncchartsPackage.eINSTANCE
									.getSyncTransition_Type(),
							TransitionType.NORMALTERMINATION)));
		} else if (weakTransition.equals(req.getTypeToConfigure())) {
			result.add(new SetValueCommand(new SetRequest(req
					.getElementToConfigure(), SyncchartsPackage.eINSTANCE
					.getSyncTransition_Type(), TransitionType.WEAKABORT)));
		} else if (strongTransition.equals(req.getTypeToConfigure())) {
			result.add(new SetValueCommand(new SetRequest(req
					.getElementToConfigure(), SyncchartsPackage.eINSTANCE
					.getSyncTransition_Type(), TransitionType.STRONGABORT)));
		}
		return result;
	}

}
