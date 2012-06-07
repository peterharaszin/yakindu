package org.eclipselabs.damos.diagram.ui.internal.handlers;

import java.util.regex.Pattern;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.util.FragmentSelectionManager;

public class RenameFragmentHandler extends AbstractHandler {

	static final Pattern QUALIFIED_NAME_PATTERN = Pattern.compile("\\A([a-zA-Z]\\w*)(\\.[a-zA-Z]\\w*)+\\z");

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof IAdaptable) {
					FragmentSelectionManager fragmentSelectionManager = (FragmentSelectionManager) ((IAdaptable) element).getAdapter(FragmentSelectionManager.class);
					if (fragmentSelectionManager != null && fragmentSelectionManager.getSelectedFragment() != null) {
						element = fragmentSelectionManager.getSelectedFragment();
					}
				}
				if (element instanceof Fragment) {
					Fragment fragment = (Fragment) element;
					InputDialog d = new InputDialog(HandlerUtil.getActiveShell(event), "Rename Fragment",
							"Qualified name (e.g. mypackage.MyFragment):", fragment.getQualifiedName(),
							new QualifiedNameValidator());
					if (d.open() == Dialog.OK) {
						EditingDomain editingDomain = TransactionUtil.getEditingDomain(fragment);
						Command command = editingDomain.createCommand(
								SetCommand.class,
								new CommandParameter(fragment, DMLPackage.eINSTANCE.getQualifiedElement_QualifiedName(), d.getValue()));
						editingDomain.getCommandStack().execute(command);
					}
				}
			}
		}
		return null;
	}

}
