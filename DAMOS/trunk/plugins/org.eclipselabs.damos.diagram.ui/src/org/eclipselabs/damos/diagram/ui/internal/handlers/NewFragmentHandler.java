package org.eclipselabs.damos.diagram.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Fragment;

public class NewFragmentHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof Fragment) {
					Fragment fragment = (Fragment) element;
					InputDialog d = new InputDialog(HandlerUtil.getActiveShell(event), "Create Fragment", "Qualified name:", "org.example.Unnamed", null);
					if (d.open() == Dialog.OK) {
						Fragment newFragment = DMLFactory.eINSTANCE.createFragment();
						newFragment.setQualifiedName(d.getValue());
						newFragment.setParent(fragment);
						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(fragment);
						Command command = new AddFragmentCommand(fragment.eResource(), newFragment);
						editingDomain.getCommandStack().execute(command);
					}
				}
			}
		}
		return null;
	}
	
	private static class AddFragmentCommand extends ChangeCommand {

		private Resource resource;
		private Fragment fragment;
		
		/**
		 * @param notifier
		 */
		public AddFragmentCommand(Resource resource, Fragment fragment) {
			super(resource);
			this.resource = resource;
			this.fragment = fragment;
			setLabel("Add Structure");
		}

		protected void doExecute() {
			resource.getContents().add(fragment);
		}
		
	}

}
