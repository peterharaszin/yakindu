package org.eclipselabs.damos.diagram.ui.internal.dnd;

import java.util.Map;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.dnd.LocalTransfer;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipselabs.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipselabs.damos.diagram.core.type.ElementTypes;
import org.eclipselabs.damos.diagram.ui.internal.providers.BlockTypeProvider;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class LocalTransferDropTargetListener extends BlockTypeTransferDropTargetListener {

	public LocalTransferDropTargetListener(EditPartViewer viewer, EditingDomain editingDomain, PreferencesHint preferencesHint) {
		super(viewer, LocalTransfer.getInstance(), editingDomain, preferencesHint);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#createTargetRequest()
	 */
	@Override
	protected CreateRequest createTargetRequest() {
		CreateRequest createRequest = CreateViewRequestFactory.getCreateShapeRequest(ElementTypes.BLOCK,
				getPreferencesHint());
		
		IBlockTypeDescriptor blockType = getBlockType();
		if (blockType != null) {
			@SuppressWarnings("unchecked")
			Map<Object, Object> extendedData = createRequest.getExtendedData();
			extendedData.put(IBlockTypeProvider.class, new BlockTypeProvider(getEditingDomain(), blockType));
		}
		
		return createRequest;
	}
	
	private IBlockTypeDescriptor getBlockType() {
		if (getCurrentEvent().data instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) getCurrentEvent().data;
			if (structuredSelection.getFirstElement() instanceof IBlockTypeDescriptor) {
				return (IBlockTypeDescriptor) structuredSelection.getFirstElement();
			}
		}
		return null;
	}
	
}