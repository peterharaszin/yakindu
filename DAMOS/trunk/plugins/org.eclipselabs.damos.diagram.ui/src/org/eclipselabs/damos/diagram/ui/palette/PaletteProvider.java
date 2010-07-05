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

package org.eclipselabs.damos.diagram.ui.palette;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.DSMDiagramUIPlugin;
import org.eclipselabs.damos.diagram.ui.part.BlockDiagramEditor;
import org.eclipselabs.damos.dml.registry.BlockGroupRegistry;
import org.eclipselabs.damos.dml.registry.BlockTypeRegistry;
import org.eclipselabs.damos.dml.registry.IBlockGroupDescriptor;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class PaletteProvider extends AbstractProvider implements IPaletteProvider {

	private static final ImageDescriptor CONNECTION_16_IMAGE_DESCRIPTOR = DSMDiagramUIPlugin.imageDescriptorFromPlugin(DSMDiagramUIPlugin.PLUGIN_ID, "icons/full/etool16/connection.gif");
	private static final ImageDescriptor CONNECTION_24_IMAGE_DESCRIPTOR = DSMDiagramUIPlugin.imageDescriptorFromPlugin(DSMDiagramUIPlugin.PLUGIN_ID, "icons/full/etool24/connection.gif");

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.services.palette.IPaletteProvider#contributeToPalette(org.eclipse.ui.IEditorPart, java.lang.Object, org.eclipse.gef.palette.PaletteRoot, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public void contributeToPalette(IEditorPart editor, Object content, PaletteRoot root, Map predefinedEntries) {
		if (!(editor instanceof BlockDiagramEditor)) {
			return;
		}
		BlockDiagramEditor blockDiagramEditor = (BlockDiagramEditor) editor;
		
		PaletteToolbar toolbar = getToolbar(root);
		if (toolbar != null) {
			contributeToolbar(blockDiagramEditor, content, toolbar, predefinedEntries);
		}
		contributeBuiltinComponents(blockDiagramEditor, content, root, predefinedEntries);
		contributeBlocks(blockDiagramEditor, content, root, predefinedEntries);
	}
		
	@SuppressWarnings("unchecked")
	protected void contributeToolbar(BlockDiagramEditor editor, Object content, PaletteToolbar toolbar, Map predefinedEntries) {
		toolbar.add(new ConnectionElementCreationToolEntry(ElementTypes.CONNECTION, CONNECTION_16_IMAGE_DESCRIPTOR, CONNECTION_24_IMAGE_DESCRIPTOR));
	}
	
	@SuppressWarnings("unchecked")
	protected void contributeBuiltinComponents(BlockDiagramEditor editor, Object content, PaletteRoot root, Map predefinedEntries) {
		List<PaletteEntry> entries = createBuiltinComponentEntries(editor);
		if (entries != null && !entries.isEmpty()) {
			PaletteContainer builtinComponentContainer = createBuiltinComponentContainer();
			builtinComponentContainer.addAll(entries);
			root.add(builtinComponentContainer);
		}
	}
	
	protected PaletteContainer createBuiltinComponentContainer() {
		PaletteDrawer drawer = new PaletteDrawer("Built-in Components");
		drawer.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
		return drawer;
	}
	
	protected List<PaletteEntry> createBuiltinComponentEntries(BlockDiagramEditor editor) {
		List<PaletteEntry> entries = new ArrayList<PaletteEntry>();
		entries.add(new SubsystemCreationToolEntry(editor));
		entries.add(new ElementCreationToolEntry(ElementTypes.INPORT, null, null));
		entries.add(new ElementCreationToolEntry(ElementTypes.OUTPORT, null, null));
		return entries;
	}
	
	@SuppressWarnings("unchecked")
	protected void contributeBlocks(BlockDiagramEditor blockDiagramEditor, Object content, PaletteRoot root, Map predefinedEntries) {
		for (IBlockGroupDescriptor group : getTopLevelBlockGroupDescriptors()) {
			Collection<IBlockTypeDescriptor> blockTypeDescriptors = getBlockTypeDescriptors(group);
			if (!blockTypeDescriptors.isEmpty()) {
				PaletteDrawer drawer = new PaletteDrawer(group.getName());
				drawer.setInitialState(PaletteDrawer.INITIAL_STATE_CLOSED);
				root.add(drawer);
				for (final IBlockTypeDescriptor blockTypeDescriptor : blockTypeDescriptors) {
					ToolEntry entry = new BlockCreationToolEntry(blockDiagramEditor, blockTypeDescriptor);
					drawer.add(entry);
				}
			}
		}
	}
	
	protected PaletteToolbar getToolbar(PaletteRoot root) {
		for (Object o : root.getChildren()) {
			if (o instanceof PaletteToolbar) {
				return (PaletteToolbar) o;
			}
		}
		return null;
	}

	private Collection<IBlockGroupDescriptor> getTopLevelBlockGroupDescriptors() {
		Collection<IBlockGroupDescriptor> groups = new TreeSet<IBlockGroupDescriptor>(new Comparator<IBlockGroupDescriptor>() {

			public int compare(IBlockGroupDescriptor d1, IBlockGroupDescriptor d2) {
				return d1.getName().compareTo(d2.getName());
			}
				
		});
		
		for (IBlockGroupDescriptor group : BlockGroupRegistry.getInstance().getDescriptors()) {
			if (group.getSupergroup() == null) {
				groups.add(group);
			}
		}
		
		return groups;
	}

	private Collection<IBlockTypeDescriptor> getBlockTypeDescriptors(IBlockGroupDescriptor topLevelGroup) {
		Collection<IBlockTypeDescriptor> blockTypes = new TreeSet<IBlockTypeDescriptor>(new Comparator<IBlockTypeDescriptor>() {

			public int compare(IBlockTypeDescriptor d1, IBlockTypeDescriptor d2) {
				return d1.getName().compareTo(d2.getName());
			}
				
		});
		
		for (IBlockTypeDescriptor blockType : BlockTypeRegistry.getInstance().getDescriptors()) {
			if (blockType.getGroup() != null && getTopLevelGroup(blockType.getGroup()) == topLevelGroup) {
				blockTypes.add(blockType);
			}
		}
		
		return blockTypes;
	}
	
	private IBlockGroupDescriptor getTopLevelGroup(IBlockGroupDescriptor group) {
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

}
