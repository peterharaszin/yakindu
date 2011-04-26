package org.eclipselabs.damos.diagram.core.internal.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class CreateBlockCommand extends CreateElementCommand {

	/**
	 * @param editingDomain
	 */
	public CreateBlockCommand(CreateElementRequest request) {
		super(request);
		setElementToEdit(request.getContainer());
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
    	name = DMLUtil.findAvailableComponentName(getFragment(), name);
		
    	Block block = blockType.newInstance(name);
    	getFragment().getFragmentElements().add(block);
    	
		return block;
	}

	private Fragment getFragment() {
		return (Fragment) getElementToEdit();
	}
	
}
