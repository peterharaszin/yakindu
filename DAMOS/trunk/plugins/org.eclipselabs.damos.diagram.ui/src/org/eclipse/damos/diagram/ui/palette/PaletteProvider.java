/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.diagram.ui.palette;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.damos.diagram.core.type.ElementTypes;
import org.eclipse.damos.diagram.ui.DiagramUIPlugin;
import org.eclipse.damos.diagram.ui.internal.palette.ConnectionElementCreationToolEntry;
import org.eclipse.damos.diagram.ui.internal.palette.InstantiateBlockTypeToolEntry;
import org.eclipse.damos.diagram.ui.internal.palette.LinkEntry;
import org.eclipse.damos.diagram.ui.internal.palette.PaletteDrawer;
import org.eclipse.damos.diagram.ui.internal.palette.SubsystemCreationToolEntry;
import org.eclipse.damos.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.damos.dml.registry.BlockTypeRegistry;
import org.eclipse.damos.dml.registry.IBlockGroupDescriptor;
import org.eclipse.damos.dml.registry.IBlockTypeDescriptor;
import org.eclipse.damos.dml.ui.parts.BlockLibraryViewId;
import org.eclipse.damos.dml.ui.registry.BlockImageRegistry;
import org.eclipse.damos.dml.ui.registry.IBlockImageDescriptor;
import org.eclipse.draw2d.ActionEvent;
import org.eclipse.draw2d.ActionListener;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import com.google.inject.Inject;

/**
 * @author Andreas Unger
 *
 */
public class PaletteProvider extends AbstractProvider implements IPaletteProvider {
	
	@Inject
	@BlockLibraryViewId
	private String blockLibraryViewId;
	
	@Inject
	private PreferencesHint preferencesHint;

	private static final BlockGroupComparator BLOCK_GROUP_COMPARATOR = new BlockGroupComparator();
	
	private static final BlockTypeComparator BLOCK_TYPE_COMPARATOR = new BlockTypeComparator();
	
	private static final Pattern STRING_LIST_SEPARATOR_PATTERN = Pattern.compile(",");

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#contributeToPalette(org.eclipse.ui.IEditorPart, java.lang.Object, org.eclipse.gef.palette.PaletteRoot, java.util.Map)
	 */
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, @SuppressWarnings("rawtypes") Map predefinedEntries) {
		contributeGeneral(editor, content, root, predefinedEntries);
		contributeCommonBlocks(editor, content, root, predefinedEntries);
	}
		
	protected void contributeGeneral(IEditorPart editor, Object content, PaletteRoot root, @SuppressWarnings("rawtypes") Map predefinedEntries) {
		List<PaletteEntry> entries = createGeneralEntries(editor);
		if (entries != null && !entries.isEmpty()) {
			PaletteContainer container = createGeneralContainer();
			container.addAll(entries);
			root.add(container);
		}
	}
	
	protected PaletteContainer createGeneralContainer() {
		PaletteDrawer drawer = new PaletteDrawer("General");
		drawer.setId(IPaletteConstants.GENERAL_CONTAINER_ID);
		drawer.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
		return drawer;
	}
	
	protected void contributeCommonBlocks(IEditorPart editor, Object content, PaletteRoot root, @SuppressWarnings("rawtypes") Map predefinedEntries) {
		List<PaletteEntry> entries = createCommonBlockEntries(editor);
		if (entries != null && !entries.isEmpty()) {
			PaletteContainer container = createCommonBlocksContainer();
			container.addAll(entries);
			root.add(container);
		}
	}

	protected PaletteContainer createCommonBlocksContainer() {
		PaletteDrawer drawer = new PaletteDrawer("Common Blocks");
		drawer.setId(IPaletteConstants.COMMON_BLOCKS_CONTAINER_ID);
		drawer.setInitialState(PaletteDrawer.INITIAL_STATE_OPEN);
		return drawer;
	}

	protected List<PaletteEntry> createGeneralEntries(IEditorPart editor) {
		List<PaletteEntry> entries = new ArrayList<PaletteEntry>();
		PaletteEntry entry;

		if (includeElementType(ElementTypes.CONNECTION)) {
			entry = new ConnectionElementCreationToolEntry(ElementTypes.CONNECTION,
					DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
							"icons/builtin/Connection16.png"), DiagramUIPlugin.imageDescriptorFromPlugin(
							DiagramUIPlugin.PLUGIN_ID, "icons/builtin/Connection24.png"));
			entry.setId(IPaletteConstants.CONNECTION_ENTRY_ID);
			entries.add(entry);

			entries.add(new PaletteSeparator());
		}

		boolean separate = false;

		if (includeElementType(ElementTypes.INPORT)) {
			entry = new ElementCreationToolEntry(ElementTypes.INPORT, null, null);
			entry.setId(IPaletteConstants.INPORT_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Inport16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Inport24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeElementType(ElementTypes.OUTPORT)) {
			entry = new ElementCreationToolEntry(ElementTypes.OUTPORT, null, null);
			entry.setId(IPaletteConstants.OUTPORT_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Outport16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Outport24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeElementType(ElementTypes.SUBSYSTEM)) {
			entry = new SubsystemCreationToolEntry(editor);
			entry.setId(IPaletteConstants.SUBSYSTEM_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Subsystem16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Subsystem24.png"));
			entries.add(entry);
			separate = true;
		}

		if (separate) {
			entries.add(new PaletteSeparator());
			separate = false;
		}

		if (includeElementType(ElementTypes.CHOICE)) {
			entry = new ElementCreationToolEntry(ElementTypes.CHOICE, null, null);
			entry.setId(IPaletteConstants.CHOICE_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Choice16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Choice24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeElementType(ElementTypes.JOIN)) {
			entry = new ElementCreationToolEntry(ElementTypes.JOIN, null, null);
			entry.setId(IPaletteConstants.JOIN_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Join16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Join24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeElementType(ElementTypes.ACTION)) {
			entry = new ElementCreationToolEntry(ElementTypes.ACTION, null, null);
			entry.setId(IPaletteConstants.ACTION_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Action16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Action24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeElementType(ElementTypes.ACTION_LINK)) {
			entry = new ConnectionElementCreationToolEntry(ElementTypes.ACTION_LINK, null, null);
			entry.setId(IPaletteConstants.ACTION_LINK_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/ActionLink16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/ActionLink24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeElementType(ElementTypes.WHILE_LOOP)) {
			entry = new ElementCreationToolEntry(ElementTypes.WHILE_LOOP, null, null);
			entry.setId(IPaletteConstants.WHILE_LOOP_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/WhileLoop16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/WhileLoop24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeElementType(ElementTypes.MEMORY)) {
			entry = new ElementCreationToolEntry(ElementTypes.MEMORY, null, null);
			entry.setId(IPaletteConstants.MEMORY_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Memory16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Memory24.png"));
			entries.add(entry);
			separate = true;
		}

		if (separate) {
			entries.add(new PaletteSeparator());
			separate = false;
		}

		if (includeElementType(ElementTypes.LATCH)) {
			entry = new ElementCreationToolEntry(ElementTypes.LATCH, null, null);
			entry.setId(IPaletteConstants.LATCH_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Latch16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/Latch24.png"));
			entries.add(entry);
			separate = true;
		}

		if (includeInstantiateBlockType()) {
			if (separate) {
				entries.add(new PaletteSeparator());
			}
	
			entry = new InstantiateBlockTypeToolEntry(editor);
			entry.setId(IPaletteConstants.INSTANTIATE_BLOCK_TYPE_ENTRY_ID);
			entry.setSmallIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/InstantiateBlockType16.png"));
			entry.setLargeIcon(DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID,
					"icons/builtin/InstantiateBlockType24.png"));
			entries.add(entry);
		}

		return entries;
	}
	
	protected boolean includeElementType(IElementType elementType) {
		return true;
	}
	
	protected boolean includeInstantiateBlockType() {
		return true;
	}

	protected List<PaletteEntry> createCommonBlockEntries(IEditorPart editor) {
		List<PaletteEntry> entries = new ArrayList<PaletteEntry>();
		
		String commonBlocksString = ((IPreferenceStore) preferencesHint.getPreferenceStore()).getString(IPreferenceConstants.COMMON_BLOCKS);
		if (commonBlocksString != null) {
			String[] commonBlocks = STRING_LIST_SEPARATOR_PATTERN.split(commonBlocksString);
			for (String commonBlock : commonBlocks) {
				if ("|".equals(commonBlock)) {
					entries.add(new PaletteSeparator());
				} else {
					IBlockTypeDescriptor blockType = BlockTypeRegistry.getInstance().getBlockType(commonBlock);
					if (blockType != null) {
						entries.add(createBlockCreationToolEntry(editor, blockType));
					}
				}
			}
		}
		
		entries.add(new PaletteSeparator());
		LinkEntry linkEntry = new LinkEntry("Show All", "Show all blocks from block library");
		linkEntry.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(blockLibraryViewId);
				} catch (PartInitException e) {
					ErrorDialog.openError(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Show All", "Opening block library view failed", e.getStatus());
				}
			}
			
		});
		entries.add(linkEntry);

		return entries;
	}

	protected void contributeBlocks(IEditorPart editor, Object content, PaletteRoot root, @SuppressWarnings("rawtypes") Map predefinedEntries) {
		for (IBlockGroupDescriptor group : getTopLevelBlockGroups()) {
			Collection<IBlockTypeDescriptor> blockTypes = getBlockTypes(group);
			if (!blockTypes.isEmpty()) {
				PaletteDrawer drawer = new PaletteDrawer(group.getName());
				drawer.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				root.add(drawer);
				for (IBlockTypeDescriptor blockType : blockTypes) {
					drawer.add(createBlockCreationToolEntry(editor, blockType));
				}
			}
		}
	}

	protected ToolEntry createBlockCreationToolEntry(IEditorPart editor, IBlockTypeDescriptor blockType) {
		BlockCreationToolEntry entry = new BlockCreationToolEntry(editor, blockType);
		IBlockImageDescriptor blockImageDescriptor = BlockImageRegistry.getInstance().getBlockImage(blockType.getQualifiedName());
		if (blockImageDescriptor != null) {
			entry.setSmallIcon(blockImageDescriptor.getIcon16ImageDescriptor());
			entry.setLargeIcon(blockImageDescriptor.getIcon24ImageDescriptor());
		}
		return entry;
	}
	
	protected PaletteToolbar getToolbar(PaletteRoot root) {
		for (Object o : root.getChildren()) {
			if (o instanceof PaletteToolbar) {
				return (PaletteToolbar) o;
			}
		}
		return null;
	}

	private Collection<IBlockGroupDescriptor> getTopLevelBlockGroups() {
		Collection<IBlockGroupDescriptor> groups = new TreeSet<IBlockGroupDescriptor>(BLOCK_GROUP_COMPARATOR);
		
		for (IBlockGroupDescriptor group : BlockTypeRegistry.getInstance().getBlockGroups()) {
			if (group.getSupergroup() == null) {
				groups.add(group);
			}
		}
		
		return groups;
	}

	private Collection<IBlockTypeDescriptor> getBlockTypes(IBlockGroupDescriptor topLevelGroup) {
		Collection<IBlockTypeDescriptor> blockTypes = new TreeSet<IBlockTypeDescriptor>(BLOCK_TYPE_COMPARATOR);
		
		for (IBlockTypeDescriptor blockType : BlockTypeRegistry.getInstance().getBlockTypes()) {
			if (blockType.getGroup() != null && getTopLevelBlockGroup(blockType.getGroup()) == topLevelGroup) {
				blockTypes.add(blockType);
			}
		}
		
		return blockTypes;
	}
	
	private IBlockGroupDescriptor getTopLevelBlockGroup(IBlockGroupDescriptor group) {
		while (group.getSupergroup() != null) {
			group = group.getSupergroup();
		}
		return group;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#setContributions(org.eclipse.core.runtime.IConfigurationElement)
	 */
	public void setContributions(IConfigurationElement configElement) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.common.core.service.IProvider#provides(org.eclipse.gmf.runtime.common.core.service.IOperation)
	 */
	public boolean provides(IOperation operation) {
		return false;
	}

	/**
	 * @author Andreas Unger
	 *
	 */
	private final static class BlockTypeComparator implements Comparator<IBlockTypeDescriptor> {
		
		public int compare(IBlockTypeDescriptor blockType1, IBlockTypeDescriptor blockType2) {
			return blockType1.getName().compareTo(blockType2.getName());
		}
		
	}

	/**
	 * @author Andreas Unger
	 *
	 */
	private final static class BlockGroupComparator implements Comparator<IBlockGroupDescriptor> {
		
		public int compare(IBlockGroupDescriptor group1, IBlockGroupDescriptor group2) {
			return group1.getName().compareTo(group2.getName());
		}
		
	}

}
