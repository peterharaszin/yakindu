package org.eclipselabs.damos.diagram.ui.internal.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipselabs.damos.common.util.NameUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.Output;

public class ChangePortCountContributionItem extends CompoundContributionItem {

	private static final String COMMAND_ID = "org.eclipselabs.damos.diagram.ui.commands.changePortCount";
	
	public ChangePortCountContributionItem() {
	}

	public ChangePortCountContributionItem(String id) {
		super(id);
	}

	@Override
	protected IContributionItem[] getContributionItems() {
		Block block = getSelectedBlock();
		if (block == null) {
			return new IContributionItem[0];
		}
		
		int itemCount = 0;

		for (Input input : block.getInputs()) {
			if (input instanceof BlockInput) {
				BlockInput blockInput = (BlockInput) input;
				if (blockInput.getDefinition().getMaximumPortCount() == -1 || blockInput.getDefinition().getMinimumPortCount() < blockInput.getDefinition().getMaximumPortCount()) {
					++itemCount;
				}
			}
		}

		for (Output output : block.getOutputs()) {
			if (output instanceof BlockOutput) {
				BlockOutput blockOutput = (BlockOutput) output;
				if (blockOutput.getDefinition().getMaximumPortCount() == -1 || blockOutput.getDefinition().getMinimumPortCount() < blockOutput.getDefinition().getMaximumPortCount()) {
					++itemCount;
				}
			}
		}
		
		if (itemCount == 0) {
			return new IContributionItem[0];
		}

		int i = 0;
		
		IContributionItem[] items = new IContributionItem[2 * itemCount + 1];
		items[i++] = new Separator();

		for (Input input : block.getInputs()) {
			if (input instanceof BlockInput) {
				BlockInput blockInput = (BlockInput) input;
				if (blockInput.getDefinition().getMaximumPortCount() == -1 || blockInput.getDefinition().getMinimumPortCount() < blockInput.getDefinition().getMaximumPortCount()) {
					items[i++] = createCommandContributionItem(
							blockInput.getDefinition().getName(),
							IChangePortCountCommandConstants.PARAMETER__KIND__INPUT,
							IChangePortCountCommandConstants.PARAMETER__ACTION__ADD,
							blockInput.getDefinition().getMaximumPortCount() == -1 || blockInput.getPorts().size() < blockInput.getDefinition().getMaximumPortCount());
					items[i++] = createCommandContributionItem(
							blockInput.getDefinition().getName(),
							IChangePortCountCommandConstants.PARAMETER__KIND__INPUT,
							IChangePortCountCommandConstants.PARAMETER__ACTION__REMOVE,
							blockInput.getPorts().size() > blockInput.getDefinition().getMinimumPortCount());
				}
			}
		}

		for (Output output : block.getOutputs()) {
			if (output instanceof BlockOutput) {
				BlockOutput blockOutput = (BlockOutput) output;
				if (blockOutput.getDefinition().getMaximumPortCount() == -1 || blockOutput.getDefinition().getMinimumPortCount() < blockOutput.getDefinition().getMaximumPortCount()) {
					items[i++] = createCommandContributionItem(
							blockOutput.getDefinition().getName(),
							IChangePortCountCommandConstants.PARAMETER__KIND__OUTPUT,
							IChangePortCountCommandConstants.PARAMETER__ACTION__ADD,
							blockOutput.getDefinition().getMaximumPortCount() == -1 || blockOutput.getPorts().size() < blockOutput.getDefinition().getMaximumPortCount());
					items[i++] = createCommandContributionItem(
							blockOutput.getDefinition().getName(),
							IChangePortCountCommandConstants.PARAMETER__KIND__OUTPUT,
							IChangePortCountCommandConstants.PARAMETER__ACTION__REMOVE,
							blockOutput.getPorts().size() > blockOutput.getDefinition().getMinimumPortCount());
				}
			}
		}

		return items;
	}
	
	private CommandContributionItem createCommandContributionItem(String name, String kind, String action, boolean enabled) {
	    Map<String, String> parameters = new HashMap<String, String>();
	    parameters.put(IChangePortCountCommandConstants.PARAMETER__NAME, name);
	    parameters.put(IChangePortCountCommandConstants.PARAMETER__KIND, kind);
	    parameters.put(IChangePortCountCommandConstants.PARAMETER__ACTION, action);
		return new ChangePortCountCommandContributionItem(new CommandContributionItemParameter(PlatformUI.getWorkbench(),
	    		null,
	    		COMMAND_ID,
	            parameters,
	            null,
	            null,
	            null,
	            (IChangePortCountCommandConstants.PARAMETER__ACTION__ADD.equals(action) ? "Add " : "Remove ") + NameUtil.formatName(name) + " Port",
	            null,
	            null,
	            CommandContributionItem.STYLE_PUSH,
	            null,
	            false), enabled);
	}
	
	protected Block getSelectedBlock() {
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (workbenchWindow != null) {
			ISelection selection = workbenchWindow.getSelectionService().getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.getFirstElement() instanceof IAdaptable) {
					return (Block) ((IAdaptable) structuredSelection.getFirstElement()).getAdapter(Block.class);
				}
			}
		}
		return null;
	}
	
	private static class ChangePortCountCommandContributionItem extends CommandContributionItem {

		private boolean enabled;
		
		/**
		 * @param contributionParameters
		 */
		public ChangePortCountCommandContributionItem(CommandContributionItemParameter contributionParameters, boolean enabled) {
			super(contributionParameters);
			this.enabled = enabled;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.ui.menus.CommandContributionItem#isEnabled()
		 */
		@Override
		public boolean isEnabled() {
			return enabled;
		}
		
	}

}
