package org.eclipse.damos.diagram.ui.internal.handlers;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.System;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class DeleteFragmentHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object element = structuredSelection.getFirstElement();
				if (element instanceof Fragment && !(element instanceof System)) {
					Fragment fragment = (Fragment) element;
					if (MessageDialog.openQuestion(
							HandlerUtil.getActiveShell(event),
							"Confirm Delete",
							"Are you sure you want to delete fragment '" + fragment.getName() + "' and its children?")) {
						TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(fragment);
						if (editingDomain != null) {
							Command command = new DeleteFragmentCommand(editingDomain.getResourceSet(), fragment);
							editingDomain.getCommandStack().execute(command);
						}
					}
				}
			}
		}
		return null;
	}

	private static class DeleteFragmentCommand extends ChangeCommand {

		private ResourceSet resourceSet;
		private Fragment fragment;
		
		/**
		 * @param notifier
		 */
		public DeleteFragmentCommand(ResourceSet resourceSet, Fragment fragment) {
			super(resourceSet);
			this.resourceSet = resourceSet;
			this.fragment = fragment;
			setLabel("Delete Structure");
		}

		protected void doExecute() {
			removeFragment(fragment);
		}
		
		private void removeFragment(Fragment fragment) {
			for (Fragment specific : fragment.getChildren()) {
				removeFragment(specific);
			}
			
			for (EObject eObject : fragment.eContents()) {
				for (View view : getViews(resourceSet, eObject)) {
					ViewUtil.destroy(view);
				}
			}
			
			EcoreUtil.remove(fragment);
		}
		
		private EList<View> getViews(ResourceSet resourceSet, EObject eObject) {
			EList<View> views = new UniqueEList.FastCompare<View>();
			for (EStructuralFeature.Setting nonNavigableInverseReference : getNonNavigableInverseReferences(resourceSet, eObject)) {
				if (nonNavigableInverseReference.getEStructuralFeature() == NotationPackage.Literals.VIEW__ELEMENT) {
					EObject referenceEObject = nonNavigableInverseReference.getEObject();
					if (referenceEObject instanceof View) {
						views.add((View) referenceEObject);
					}
				}
			}
			return views;
		}

		private Collection<Setting> getNonNavigableInverseReferences(ResourceSet resourceSet, EObject eObject) {
			ECrossReferenceAdapter adapter = ECrossReferenceAdapter.getCrossReferenceAdapter(resourceSet);
			if (adapter == null) {
				adapter = new ECrossReferenceAdapter();
				resourceSet.eAdapters().add(adapter);
			}
			return adapter.getNonNavigableInverseReferences(eObject, true);
		}
				
	}

}
