package org.eclipselabs.damos.diagram.ui.internal.handlers;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.diagram.ui.dialogs.ChangeRealizationDialog;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dml.util.FragmentSelectionManager;

public class ChangeRealizationHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object o = structuredSelection.getFirstElement();
				if (o instanceof IGraphicalEditPart) {
					IGraphicalEditPart editPart = (IGraphicalEditPart) o;
					EObject element = editPart.resolveSemanticElement();
					if (element instanceof Subsystem) {
						FragmentSelectionManager fragmentSelectionManager = (FragmentSelectionManager) editPart.getRoot().getContents().getAdapter(FragmentSelectionManager.class);
						if (fragmentSelectionManager != null && fragmentSelectionManager.getSelectedFragment() != null) {
							Subsystem subsystem = (Subsystem) element;
							Fragment oldRealizingFragment = null;
							SubsystemRealization realization = subsystem.getRealization(fragmentSelectionManager.getSelectedFragment());
							if (realization != null && realization.getOwningFragment() == fragmentSelectionManager.getSelectedFragment()) {
								oldRealizingFragment = realization.getRealizingFragment();
							} else {
								realization = null;
							}
							ChangeRealizationDialog d = new ChangeRealizationDialog(HandlerUtil.getActiveShell(event), editPart.getEditingDomain(), Collections.singleton(DMLUtil.getRootFragment(subsystem.getOwningFragment())), oldRealizingFragment);
							if (d.open() == Dialog.OK) {
								Fragment newRealizingFragment = d.getNewRealizingFragment();
								if (newRealizingFragment != oldRealizingFragment) {
									Command command = new ChangeRealizationCommand(fragmentSelectionManager.getSelectedFragment(), subsystem, realization, newRealizingFragment);
									editPart.getEditingDomain().getCommandStack().execute(command);
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	private static class ChangeRealizationCommand extends ChangeCommand {

		private Fragment owningFragment;
		private Subsystem subsystem;
		private SubsystemRealization realization;
		private Fragment newRealizingFragment;
		
		/**
		 * @param notifier
		 */
		public ChangeRealizationCommand(Fragment owningFragment, Subsystem subsystem, SubsystemRealization realization, Fragment newRealizingFragment) {
			super(owningFragment);
			this.owningFragment = owningFragment;
			this.subsystem = subsystem;
			this.realization = realization;
			this.newRealizingFragment = newRealizingFragment;
			setLabel("Change Subsystem Realization");
		}

		protected void doExecute() {
			if (newRealizingFragment != null) {
				if (realization != null) {
					realization.setRealizingFragment(newRealizingFragment);
				} else {
					realization = DMLFactory.eINSTANCE.createSubsystemRealization();
					realization.setRealizedSubsystem(subsystem);
					realization.setRealizingFragment(newRealizingFragment);
					realization.setOwningFragment(owningFragment);
				}
			} else {
				EcoreUtil.remove(realization);
			}
		}
		
	}
	
}
