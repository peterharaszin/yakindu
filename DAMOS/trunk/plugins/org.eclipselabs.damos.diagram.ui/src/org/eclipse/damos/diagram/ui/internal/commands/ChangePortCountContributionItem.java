package org.eclipse.damos.diagram.ui.internal.commands;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.damos.common.util.NameUtil;
import org.eclipse.damos.dml.Component;
import org.eclipse.damos.dml.Input;
import org.eclipse.damos.dml.Output;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

public class ChangePortCountContributionItem extends CompoundContributionItem {

	private static final String COMMAND_ID = "org.eclipse.damos.diagram.ui.commands.changePortCount";
	
	public ChangePortCountContributionItem() {
	}

	public ChangePortCountContributionItem(String id) {
		super(id);
	}

	@Override
	protected IContributionItem[] getContributionItems() {
		Component component = getSelectedComponent();
		if (component == null) {
			return new IContributionItem[0];
		}
		
		int itemCount = 0;

		for (Input input : component.getInputs()) {
			if (input.canAddPort() || input.canRemovePort()) {
				++itemCount;
			}
		}

		for (Output output : component.getOutputs()) {
			if (output.canAddPort() || output.canRemovePort()) {
				++itemCount;
			}
		}
		
		if (itemCount == 0) {
			return new IContributionItem[0];
		}

		int i = 0;
		
		IContributionItem[] items = new IContributionItem[2 * itemCount + 1];
		items[i++] = new Separator();

		for (Input input : component.getInputs()) {
			if (input.canAddPort() || input.canRemovePort()) {
				items[i++] = createCommandContributionItem(
						input.getName(),
						IChangePortCountCommandConstants.PARAMETER__KIND__INPUT,
						IChangePortCountCommandConstants.PARAMETER__ACTION__ADD,
						input.canAddPort());
				items[i++] = createCommandContributionItem(
						input.getName(),
						IChangePortCountCommandConstants.PARAMETER__KIND__INPUT,
						IChangePortCountCommandConstants.PARAMETER__ACTION__REMOVE,
						input.canRemovePort());
			}
		}

		for (Output output : component.getOutputs()) {
			if (output.canAddPort() || output.canRemovePort()) {
				items[i++] = createCommandContributionItem(
						output.getName(),
						IChangePortCountCommandConstants.PARAMETER__KIND__OUTPUT,
						IChangePortCountCommandConstants.PARAMETER__ACTION__ADD,
						output.canAddPort());
				items[i++] = createCommandContributionItem(
						output.getName(),
						IChangePortCountCommandConstants.PARAMETER__KIND__OUTPUT,
						IChangePortCountCommandConstants.PARAMETER__ACTION__REMOVE,
						output.canRemovePort());
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
	
	protected Component getSelectedComponent() {
		IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (workbenchWindow != null) {
			ISelection selection = workbenchWindow.getSelectionService().getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection structuredSelection = (IStructuredSelection) selection;
				if (structuredSelection.getFirstElement() instanceof IAdaptable) {
					return (Component) ((IAdaptable) structuredSelection.getFirstElement()).getAdapter(Component.class);
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
