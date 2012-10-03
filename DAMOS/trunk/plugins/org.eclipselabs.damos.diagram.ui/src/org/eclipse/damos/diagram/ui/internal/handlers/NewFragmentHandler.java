package org.eclipse.damos.diagram.ui.internal.handlers;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.damos.dml.DMLFactory;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class NewFragmentHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof Fragment) {
					Fragment fragment = (Fragment) element;
					InputDialog d = new InputDialog(HandlerUtil.getActiveShell(event), "Create Fragment",
							"Qualified name (e.g. mypackage.MyFragment):", findAvailableFragmentName(fragment),
							new QualifiedNameValidator());
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

	private String findAvailableFragmentName(Fragment fragment) {
		String packageName = fragment.getName() != null ? fragment.getQualifiedName().toLowerCase() : "org.example";
		String preferredName = packageName + ".Unnamed";
		String name = preferredName;
		if (fragment.eResource() != null) {
			Set<String> usedNames = new HashSet<String>();
			for (EObject eObject : fragment.eResource().getContents()) {
				if (eObject instanceof Fragment) {
					usedNames.add(((Fragment) eObject).getQualifiedName());
				}
			}
			int i = 1;
			while (usedNames.contains(name)) {
				name = preferredName + ++i;
			}
		}
		return name;
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
