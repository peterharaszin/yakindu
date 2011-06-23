package org.eclipselabs.damos.diagram.core.internal.commands;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipselabs.damos.diagram.core.DiagramCorePlugin;
import org.eclipselabs.damos.diagram.core.internal.provider.IBlockTypeProvider;
import org.eclipselabs.damos.diagram.core.internal.util.ConfigureUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class CreateBlockCommand extends CreateElementCommand {

	private EReference reference;
	
	/**
	 * @param editingDomain
	 */
	public CreateBlockCommand(CreateElementRequest request, EReference reference) {
		super(request);
		setElementToEdit(request.getContainer());
		this.reference = reference;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doDefaultElementCreation()
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		IBlockTypeProvider provider = (IBlockTypeProvider) getRequest().getParameters().get(IBlockTypeProvider.class);
		if (provider == null) {
			setDefaultElementCreationStatus(new Status(IStatus.ERROR, DiagramCorePlugin.PLUGIN_ID, "No block type provider supplied"));
			return null;
		}

		BlockType blockType = provider.getBlockType();
		if (blockType == null) {
			setDefaultElementCreationStatus(new Status(IStatus.ERROR, DiagramCorePlugin.PLUGIN_ID, "No block type returned by block type provider"));
			return null;
		}
		
		String name = blockType.getName();
    	if (name == null || name.length() == 0) {
    		name = "Block";
    	}
    	name = DMLUtil.findAvailableComponentName(DMLUtil.getOwner(getElementToEdit(), Fragment.class), name);
		
    	Block block = blockType.newInstance(name);
    	
		switch (block.getType().getTiming()) {
		case ANY:
			if (block.isSource()) {
				block.setTimingConstraint(DMLFactory.eINSTANCE.createContinuousTimingConstraint());
			}
			break;
		case SYNCHRONOUS:
			ConfigureUtil.setSampleTime(block, "1");
			break;
		}
    	
    	@SuppressWarnings("unchecked")
		List<EObject> list = (List<EObject>) (List<?>) getElementToEdit().eGet(reference);
		list.add(block);
    	
		return block;
	}
	
}
