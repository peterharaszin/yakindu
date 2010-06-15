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
package statemachine.diagram.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.ITreePathLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.ViewerLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonLabelProvider;

import statemachine.FinalState;
import statemachine.Pseudostate;
import statemachine.Statechart;
import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.Region2EditPart;
import statemachine.diagram.edit.parts.RegionEditPart;
import statemachine.diagram.edit.parts.RegionPriority2EditPart;
import statemachine.diagram.edit.parts.RegionPriorityEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StateNameEditPart;
import statemachine.diagram.edit.parts.StatechartEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.edit.parts.TransitionExpressionEditPart;
import statemachine.diagram.part.StatemachineDiagramEditorPlugin;
import statemachine.diagram.part.StatemachineVisualIDRegistry;
import statemachine.diagram.providers.StatemachineElementTypes;
import statemachine.diagram.providers.StatemachineParserProvider;

/**
 * @generated
 */
public class StatemachineNavigatorLabelProvider extends LabelProvider implements
		ICommonLabelProvider, ITreePathLabelProvider {

	/**
	 * @generated
	 */
	static {
		StatemachineDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?UnknownElement", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
		StatemachineDiagramEditorPlugin
				.getInstance()
				.getImageRegistry()
				.put(
						"Navigator?ImageNotFound", ImageDescriptor.getMissingImageDescriptor()); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	public void updateLabel(ViewerLabel label, TreePath elementPath) {
		Object element = elementPath.getLastSegment();
		if (element instanceof StatemachineNavigatorItem
				&& !isOwnView(((StatemachineNavigatorItem) element).getView())) {
			return;
		}
		label.setText(getText(element));
		label.setImage(getImage(element));
	}

	/**
	 * @generated
	 */
	public Image getImage(Object element) {
		if (element instanceof StatemachineNavigatorGroup) {
			StatemachineNavigatorGroup group = (StatemachineNavigatorGroup) element;
			return StatemachineDiagramEditorPlugin.getInstance()
					.getBundledImage(group.getIcon());
		}

		if (element instanceof StatemachineNavigatorItem) {
			StatemachineNavigatorItem navigatorItem = (StatemachineNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return super.getImage(element);
			}
			return getImage(navigatorItem.getView());
		}

		return super.getImage(element);
	}

	/**
	 * @generated
	 */
	public Image getImage(View view) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StatechartEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Diagram?org.mda4e.statemachine.model?Statechart", StatemachineElementTypes.Statechart_1000); //$NON-NLS-1$
		case RegionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?TopLevelNode?org.mda4e.statemachine.model?Region", StatemachineElementTypes.Region_2001); //$NON-NLS-1$
		case StateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?State", StatemachineElementTypes.State_3001); //$NON-NLS-1$
		case Region2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?Region", StatemachineElementTypes.Region_3002); //$NON-NLS-1$
		case PseudostateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?Pseudostate", StatemachineElementTypes.Pseudostate_3003); //$NON-NLS-1$
		case FinalStateEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?FinalState", StatemachineElementTypes.FinalState_3004); //$NON-NLS-1$
		case Pseudostate2EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?Pseudostate", StatemachineElementTypes.Pseudostate_3005); //$NON-NLS-1$
		case Pseudostate3EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?Pseudostate", StatemachineElementTypes.Pseudostate_3006); //$NON-NLS-1$
		case Pseudostate4EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?Pseudostate", StatemachineElementTypes.Pseudostate_3007); //$NON-NLS-1$
		case Pseudostate5EditPart.VISUAL_ID:
			return getImage(
					"Navigator?Node?org.mda4e.statemachine.model?Pseudostate", StatemachineElementTypes.Pseudostate_3008); //$NON-NLS-1$
		case TransitionEditPart.VISUAL_ID:
			return getImage(
					"Navigator?Link?org.mda4e.statemachine.model?Transition", StatemachineElementTypes.Transition_4001); //$NON-NLS-1$
		}
		return getImage("Navigator?UnknownElement", null); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	private Image getImage(String key, IElementType elementType) {
		ImageRegistry imageRegistry = StatemachineDiagramEditorPlugin
				.getInstance().getImageRegistry();
		Image image = imageRegistry.get(key);
		if (image == null && elementType != null
				&& StatemachineElementTypes.isKnownElementType(elementType)) {
			image = StatemachineElementTypes.getImage(elementType);
			imageRegistry.put(key, image);
		}

		if (image == null) {
			image = imageRegistry.get("Navigator?ImageNotFound"); //$NON-NLS-1$
			imageRegistry.put(key, image);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public String getText(Object element) {
		if (element instanceof StatemachineNavigatorGroup) {
			StatemachineNavigatorGroup group = (StatemachineNavigatorGroup) element;
			return group.getGroupName();
		}

		if (element instanceof StatemachineNavigatorItem) {
			StatemachineNavigatorItem navigatorItem = (StatemachineNavigatorItem) element;
			if (!isOwnView(navigatorItem.getView())) {
				return null;
			}
			return getText(navigatorItem.getView());
		}

		return super.getText(element);
	}

	/**
	 * @generated
	 */
	public String getText(View view) {
		if (view.getElement() != null && view.getElement().eIsProxy()) {
			return getUnresolvedDomainElementProxyText(view);
		}
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {
		case StatechartEditPart.VISUAL_ID:
			return getStatechart_1000Text(view);
		case RegionEditPart.VISUAL_ID:
			return getRegion_2001Text(view);
		case StateEditPart.VISUAL_ID:
			return getState_3001Text(view);
		case Region2EditPart.VISUAL_ID:
			return getRegion_3002Text(view);
		case PseudostateEditPart.VISUAL_ID:
			return getPseudostate_3003Text(view);
		case FinalStateEditPart.VISUAL_ID:
			return getFinalState_3004Text(view);
		case Pseudostate2EditPart.VISUAL_ID:
			return getPseudostate_3005Text(view);
		case Pseudostate3EditPart.VISUAL_ID:
			return getPseudostate_3006Text(view);
		case Pseudostate4EditPart.VISUAL_ID:
			return getPseudostate_3007Text(view);
		case Pseudostate5EditPart.VISUAL_ID:
			return getPseudostate_3008Text(view);
		case TransitionEditPart.VISUAL_ID:
			return getTransition_4001Text(view);
		}
		return getUnknownElementText(view);
	}

	/**
	 * @generated
	 */
	private String getStatechart_1000Text(View view) {
		Statechart domainModelElement = (Statechart) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 1000); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRegion_2001Text(View view) {
		IParser parser = StatemachineParserProvider.getParser(
				StatemachineElementTypes.Region_2001,
				view.getElement() != null ? view.getElement() : view,
				StatemachineVisualIDRegistry
						.getType(RegionPriorityEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getState_3001Text(View view) {
		IParser parser = StatemachineParserProvider.getParser(
				StatemachineElementTypes.State_3001,
				view.getElement() != null ? view.getElement() : view,
				StatemachineVisualIDRegistry
						.getType(StateNameEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5002); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getRegion_3002Text(View view) {
		IParser parser = StatemachineParserProvider.getParser(
				StatemachineElementTypes.Region_3002,
				view.getElement() != null ? view.getElement() : view,
				StatemachineVisualIDRegistry
						.getType(RegionPriority2EditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 5001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3003Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3003); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getFinalState_3004Text(View view) {
		FinalState domainModelElement = (FinalState) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3004); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3005Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3005); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3006Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3006); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3007Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3007); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getPseudostate_3008Text(View view) {
		Pseudostate domainModelElement = (Pseudostate) view.getElement();
		if (domainModelElement != null) {
			return domainModelElement.getName();
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"No domain element for view with visualID = " + 3008); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getTransition_4001Text(View view) {
		IParser parser = StatemachineParserProvider.getParser(
				StatemachineElementTypes.Transition_4001,
				view.getElement() != null ? view.getElement() : view,
				StatemachineVisualIDRegistry
						.getType(TransitionExpressionEditPart.VISUAL_ID));
		if (parser != null) {
			return parser.getPrintString(new EObjectAdapter(
					view.getElement() != null ? view.getElement() : view),
					ParserOptions.NONE.intValue());
		} else {
			StatemachineDiagramEditorPlugin.getInstance().logError(
					"Parser was not found for label " + 6001); //$NON-NLS-1$
			return ""; //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	private String getUnknownElementText(View view) {
		return "<UnknownElement Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	private String getUnresolvedDomainElementProxyText(View view) {
		return "<Unresolved domain element Visual_ID = " + view.getType() + ">"; //$NON-NLS-1$  //$NON-NLS-2$
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public String getDescription(Object anElement) {
		return null;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return StatechartEditPart.MODEL_ID.equals(StatemachineVisualIDRegistry
				.getModelID(view));
	}

}
