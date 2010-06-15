/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package statemachine.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import statemachine.StatemachinePackage;
import statemachine.diagram.edit.parts.RegionPriority2EditPart;
import statemachine.diagram.edit.parts.RegionPriorityEditPart;
import statemachine.diagram.edit.parts.StateDoEditPart;
import statemachine.diagram.edit.parts.StateEntryEditPart;
import statemachine.diagram.edit.parts.StateExitEditPart;
import statemachine.diagram.edit.parts.StateNameEditPart;
import statemachine.diagram.edit.parts.TransitionExpressionEditPart;
import statemachine.diagram.edit.parts.TransitionPriorityEditPart;
import statemachine.diagram.parsers.MessageFormatParser;
import statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class StatemachineParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser regionPriority_5006Parser;

	/**
	 * @generated
	 */
	private IParser getRegionPriority_5006Parser() {
		if (regionPriority_5006Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getRegion_Priority() };
			MessageFormatParser parser = new MessageFormatParser(features);
			regionPriority_5006Parser = parser;
		}
		return regionPriority_5006Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getStateName_5002Parser() {
		if (stateName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getNode_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateName_5002Parser = parser;
		}
		return stateName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateEntry_5003Parser;

	/**
	 * @generated
	 */
	private IParser getStateEntry_5003Parser() {
		if (stateEntry_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getState_Entry() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateEntry_5003Parser = parser;
		}
		return stateEntry_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateDo_5004Parser;

	/**
	 * @generated
	 */
	private IParser getStateDo_5004Parser() {
		if (stateDo_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getState_Do() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateDo_5004Parser = parser;
		}
		return stateDo_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser stateExit_5005Parser;

	/**
	 * @generated
	 */
	private IParser getStateExit_5005Parser() {
		if (stateExit_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getState_Exit() };
			MessageFormatParser parser = new MessageFormatParser(features);
			stateExit_5005Parser = parser;
		}
		return stateExit_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser regionPriority_5001Parser;

	/**
	 * @generated
	 */
	private IParser getRegionPriority_5001Parser() {
		if (regionPriority_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getRegion_Priority() };
			MessageFormatParser parser = new MessageFormatParser(features);
			regionPriority_5001Parser = parser;
		}
		return regionPriority_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionExpression_6001Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionExpression_6001Parser() {
		if (transitionExpression_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getTransition_Expression() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionExpression_6001Parser = parser;
		}
		return transitionExpression_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser transitionPriority_6002Parser;

	/**
	 * @generated
	 */
	private IParser getTransitionPriority_6002Parser() {
		if (transitionPriority_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { StatemachinePackage.eINSTANCE
					.getTransition_Priority() };
			MessageFormatParser parser = new MessageFormatParser(features);
			transitionPriority_6002Parser = parser;
		}
		return transitionPriority_6002Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case RegionPriorityEditPart.VISUAL_ID:
			return getRegionPriority_5006Parser();
		case StateNameEditPart.VISUAL_ID:
			return getStateName_5002Parser();
		case StateEntryEditPart.VISUAL_ID:
			return getStateEntry_5003Parser();
		case StateDoEditPart.VISUAL_ID:
			return getStateDo_5004Parser();
		case StateExitEditPart.VISUAL_ID:
			return getStateExit_5005Parser();
		case RegionPriority2EditPart.VISUAL_ID:
			return getRegionPriority_5001Parser();
		case TransitionExpressionEditPart.VISUAL_ID:
			return getTransitionExpression_6001Parser();
		case TransitionPriorityEditPart.VISUAL_ID:
			return getTransitionPriority_6002Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(StatemachineVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(StatemachineVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (StatemachineElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
