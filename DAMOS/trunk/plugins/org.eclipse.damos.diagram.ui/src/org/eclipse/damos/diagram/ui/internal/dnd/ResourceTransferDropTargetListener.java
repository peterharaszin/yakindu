package org.eclipse.damos.diagram.ui.internal.dnd;

import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipse.damos.diagram.core.type.ElementTypes;
import org.eclipse.damos.diagram.ui.internal.providers.FileBlockTypeProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequestFactory;
import org.eclipse.swt.dnd.DND;
import org.eclipse.ui.part.ResourceTransfer;

/**
 * @author Andreas Unger
 *
 */
public class ResourceTransferDropTargetListener extends BlockTypeTransferDropTargetListener {

	/**
	 * @param viewer
	 * @param blockDiagramEditor TODO
	 * @param xfer
	 */
	public ResourceTransferDropTargetListener(EditPartViewer viewer, EditingDomain editingDomain, PreferencesHint preferencesHint) {
		super(viewer, ResourceTransfer.getInstance(), editingDomain, preferencesHint);
	}

	@Override
	protected void handleDrop() {
		getCurrentEvent().detail = DND.DROP_COPY;
		super.handleDrop();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.dnd.AbstractTransferDropTargetListener#createTargetRequest()
	 */
	@Override
	protected CreateRequest createTargetRequest() {
		CreateRequest createRequest = CreateViewRequestFactory.getCreateShapeRequest(ElementTypes.BLOCK, getPreferencesHint());

		Object o = getCurrentEvent().data;
		if (o instanceof IResource[]) {
			IResource[] resources = (IResource[]) o;
			if (resources.length > 0 && resources[0] instanceof IFile) {
				IFile file = (IFile) resources[0];
				@SuppressWarnings("unchecked")
				Map<Object, Object> extendedData = createRequest.getExtendedData();
				extendedData.put(IBlockTypeProvider.class, new FileBlockTypeProvider(getEditingDomain(), file));
			}
		}
		
		return createRequest;
	}

}