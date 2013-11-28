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
package statemachine.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import statemachine.diagram.providers.StatemachineElementTypes;

/**
 * @generated
 */
public class StatemachinePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createBaseTools1Group());
		paletteRoot.add(createTransitionTools2Group());
		paletteRoot.add(createPseudostates3Group());
	}

	/**
	 * Creates "Base Tools" palette tool group
	 * @generated
	 */
	private PaletteContainer createBaseTools1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.BaseTools1Group_title);
		paletteContainer.setId("createBaseTools1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.BaseTools1Group_desc);
		paletteContainer.add(createRegion1CreationTool());
		paletteContainer.add(createState2CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Transition Tools" palette tool group
	 * @generated
	 */
	private PaletteContainer createTransitionTools2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.TransitionTools2Group_title);
		paletteContainer.setId("createTransitionTools2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.TransitionTools2Group_desc);
		paletteContainer.add(createTransition1CreationTool());
		paletteContainer.add(createChoice2CreationTool());
		paletteContainer.add(createJunction3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Pseudostates" palette tool group
	 * @generated
	 */
	private PaletteContainer createPseudostates3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Pseudostates3Group_title);
		paletteContainer.setId("createPseudostates3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Pseudostates3Group_desc);
		paletteContainer.add(createInitialState1CreationTool());
		paletteContainer.add(createFinalState2CreationTool());
		paletteContainer.add(createShallowHistory3CreationTool());
		paletteContainer.add(createDeepHistory4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRegion1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(StatemachineElementTypes.Region_2001);
		types.add(StatemachineElementTypes.Region_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Region1CreationTool_title,
				Messages.Region1CreationTool_desc, types);
		entry.setId("createRegion1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/region_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.State_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.State2CreationTool_title,
				Messages.State2CreationTool_desc, types);
		entry.setId("createState2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/state_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.Transition_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.Transition1CreationTool_title,
				Messages.Transition1CreationTool_desc, types);
		entry.setId("createTransition1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/transition_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createChoice2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.Pseudostate_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Choice2CreationTool_title,
				Messages.Choice2CreationTool_desc, types);
		entry.setId("createChoice2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/choice_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createJunction3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.Pseudostate_3008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Junction3CreationTool_title,
				Messages.Junction3CreationTool_desc, types);
		entry.setId("createJunction3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/junction_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitialState1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.Pseudostate_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InitialState1CreationTool_title,
				Messages.InitialState1CreationTool_desc, types);
		entry.setId("createInitialState1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/initial_state_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFinalState2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.FinalState_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.FinalState2CreationTool_title,
				Messages.FinalState2CreationTool_desc, types);
		entry.setId("createFinalState2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/final_state_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createShallowHistory3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.Pseudostate_3007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ShallowHistory3CreationTool_title,
				Messages.ShallowHistory3CreationTool_desc, types);
		entry.setId("createShallowHistory3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/shallow_history_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDeepHistory4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(StatemachineElementTypes.Pseudostate_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DeepHistory4CreationTool_title,
				Messages.DeepHistory4CreationTool_desc, types);
		entry.setId("createDeepHistory4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(StatemachineDiagramEditorPlugin
						.findImageDescriptor("/org.mda4e.statemachine.diagram/icons/obj16/deep_history_16x16.png")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
