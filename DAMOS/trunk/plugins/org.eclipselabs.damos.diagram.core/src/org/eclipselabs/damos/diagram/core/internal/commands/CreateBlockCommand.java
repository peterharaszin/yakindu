package org.eclipselabs.damos.diagram.core.internal.commands;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
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
		BlockType blockType = (BlockType) getRequest().getParameters().get(BlockType.class);

		String name = blockType.getName();
    	if (name.length() == 0) {
    		name = "Block";
    	}
    	name = DMLUtil.findAvailableComponentName(DMLUtil.getOwner(getElementToEdit(), Fragment.class), name);
		
    	Block block = blockType.newInstance(name);
    	
    	@SuppressWarnings("unchecked")
		List<EObject> list = (List<EObject>) (List<?>) getElementToEdit().eGet(reference);
		list.add(block);
    	
		return block;
	}

}
