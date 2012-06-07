package org.eclipselabs.damos.diagram.ui.internal.handlers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipselabs.damos.common.ui.dialogs.SelectFragmentDialog;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.util.DMLUtil;

public class MoveToAnotherFragmentHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.getFirstElement() instanceof IGraphicalEditPart) {
				IGraphicalEditPart firstEditPart = (IGraphicalEditPart) structuredSelection.getFirstElement();
				TransactionalEditingDomain editingDomain = firstEditPart.getEditingDomain();
				EObject firstElement = firstEditPart.resolveSemanticElement();
				if (firstElement instanceof FragmentElement) {
					Fragment destinationFragment = SelectFragmentDialog.open(HandlerUtil.getActiveShell(event), "Move to another Fragment", "Move to another fragment:", DMLUtil.getRootFragment(((FragmentElement) firstElement).getOwningFragment()));
					if (destinationFragment != null) {
						List<FragmentElement> elements = new ArrayList<FragmentElement>();
						for (Object o : structuredSelection.toList()) {
							if (o instanceof IGraphicalEditPart) {
								IGraphicalEditPart editPart = (IGraphicalEditPart) o;
								EObject element = editPart.resolveSemanticElement();
								if (element instanceof FragmentElement) {
									FragmentElement fragmentElement = (FragmentElement) element;
									if (fragmentElement.getOwningFragment() != destinationFragment) {
										elements.add(fragmentElement);
									}
								}
							}
						}
						if (elements.isEmpty()) {
							MessageDialog.openInformation(HandlerUtil.getActiveShell(event), "Move", "Nothing to be done.");
						} else if (!validateFragmentRelation(elements, destinationFragment)) {
							MessageDialog.openError(HandlerUtil.getActiveShell(event), "Move", "Moving selected elements would lead to connections between elements of unrelated fragments.");
						} else if (!validateInputPorts(elements, destinationFragment)) {
							MessageDialog.openError(HandlerUtil.getActiveShell(event), "Move", "Moving selected elements would lead to incoming component connections from the same fragment.");
						} else {
							Command command = new MoveToFragmentCommand(editingDomain.getResourceSet(), elements, destinationFragment);
							editingDomain.getCommandStack().execute(command);
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * @param elements
	 * @param destinationFragment
	 * @return
	 */
	private boolean validateFragmentRelation(Collection<FragmentElement> elements, Fragment destinationFragment) {
		for (FragmentElement element : elements) {
			if (element instanceof Component) {
				for (Connection connection : DMLUtil.getConnections((Component) element)) {
					if (!validateFragmentRelation(connection, elements, destinationFragment)) {
						return false;
					}
				}
			} else if (element instanceof Connection) {
				if (!validateFragmentRelation((Connection) element, elements, destinationFragment)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean validateFragmentRelation(Connection connection, Collection<FragmentElement> elements, Fragment destinationFragment) {
		Component sourceComponent = getSourcePort(connection).getComponent();
		Component targetComponent = getTargetPort(connection).getComponent();
		if (!elements.contains(sourceComponent)
				&& !DMLUtil.areFragmentsRelated(sourceComponent.getOwningFragment(), destinationFragment)
				|| !elements.contains(targetComponent)
				&& !DMLUtil.areFragmentsRelated(targetComponent.getOwningFragment(), destinationFragment)) {
			return false;
		}
		return true;
	}
	
	private boolean validateInputPorts(Collection<FragmentElement> elements, Fragment destinationFragment) {
		for (FragmentElement element : elements) {
			if (element instanceof Component) {
				for (Connection connection : DMLUtil.getConnections((Component) element)) {
					if (!validateInputPorts(connection, elements, destinationFragment)) {
						return false;
					}
				}
			} else if (element instanceof Connection) {
				if (!validateInputPorts((Connection) element, elements, destinationFragment)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean validateInputPorts(Connection connection, Collection<FragmentElement> elements, Fragment destinationFragment) {
		if (!(validateInputPorts(getSourcePort(connection).getComponent(), elements, destinationFragment)
				&& validateInputPorts(getTargetPort(connection).getComponent(), elements, destinationFragment))) {
			return false;
		}
		return true;
	}
	
	private boolean validateInputPorts(Component component, Collection<FragmentElement> elements, Fragment destinationFragment) {
		for (InputPort port : component.getInputPorts()) {
			List<Connection> allIncomingConnections = port.getConnections();
			if (allIncomingConnections.size() > 1) {
				Set<Fragment> fragments = new HashSet<Fragment>();
				for (Connection connection : allIncomingConnections) {
					Fragment connectionFragment = computeConnectionFragment(connection, elements, destinationFragment);
					if (!fragments.add(connectionFragment)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	// TODO: Check if this method works properly.
	private Fragment computeConnectionFragment(Connection connection, Collection<FragmentElement> elements, Fragment destinationFragment) {
		Fragment connectionFragment = connection.getOwningFragment();
		if (elements.contains(connection)
				|| (DMLUtil.isChildFragment(destinationFragment, connectionFragment)
						|| !DMLUtil.areFragmentsRelated(destinationFragment, connectionFragment))
						&& (elements.contains(getSourcePort(connection).getComponent())
								|| elements.contains(getTargetPort(connection).getComponent()))) {
			connectionFragment = destinationFragment;
		}
		return connectionFragment;
	}

	private static class MoveToFragmentCommand extends ChangeCommand {

		private Collection<FragmentElement> elements;
		private Fragment newFragment;
		
		/**
		 * @param notifier
		 */
		public MoveToFragmentCommand(ResourceSet resourceSet, Collection<FragmentElement> elements, Fragment newFragment) {
			super(resourceSet);
			this.elements = elements;
			this.newFragment = newFragment;
			setLabel("Move to another Fragment");
		}

		protected void doExecute() {
			for (FragmentElement element : elements) {
				element.setOwningFragment(newFragment);
			}
			for (FragmentElement element : elements) {
				if (element instanceof Component) {
					Component component = (Component) element;
					for (Connection connection : DMLUtil.getConnections(component)) {
						if (!DMLUtil.areFragmentsRelated(component.getOwningFragment(), connection.getOwningFragment())) {
							connection.setOwningFragment(component.getOwningFragment());
						} else {
							adjustConnectionContainer(connection);
						}
					}
				}
			}
			for (FragmentElement element : elements) {
				if (element instanceof Connection) {
					adjustConnectionContainer((Connection) element);
				}
			}
		}
		
		private void adjustConnectionContainer(Connection connection) {
			Fragment connectionFragment = connection.getOwningFragment();
			if (DMLUtil.isChildFragment(getSourcePort(connection).getComponent().getOwningFragment(), connectionFragment)) {
				connectionFragment = getSourcePort(connection).getComponent().getOwningFragment();
			}
			if (DMLUtil.isChildFragment(getTargetPort(connection).getComponent().getOwningFragment(), connectionFragment)) {
				connectionFragment = getTargetPort(connection).getComponent().getOwningFragment();
			}
			if (connectionFragment != connection.getOwningFragment()) {
				connection.setOwningFragment(connectionFragment);
			}
		}
		
	}
	
	private static OutputPort getSourcePort(Connection connection) {
		if (connection.getSource() instanceof OutputPort) {
			return (OutputPort) connection.getSource();
		}
		return null;
	}
	
	private static InputPort getTargetPort(Connection connection) {
		if (connection.getTarget() instanceof InputPort) {
			return (InputPort) connection.getTarget();
		}
		return null;
	}

}
