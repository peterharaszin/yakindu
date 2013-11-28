/**
 * Copyright (c) 2006-2009 committers of mda4e and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of mda4e (http://www.mda4e.org/) - initial API and implementation
 *
 */
package statemachine.diagram.navigator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

import statemachine.diagram.edit.parts.FinalStateEditPart;
import statemachine.diagram.edit.parts.Pseudostate2EditPart;
import statemachine.diagram.edit.parts.Pseudostate3EditPart;
import statemachine.diagram.edit.parts.Pseudostate4EditPart;
import statemachine.diagram.edit.parts.Pseudostate5EditPart;
import statemachine.diagram.edit.parts.PseudostateEditPart;
import statemachine.diagram.edit.parts.Region2EditPart;
import statemachine.diagram.edit.parts.RegionEditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartment2EditPart;
import statemachine.diagram.edit.parts.RegionRegionCompartmentEditPart;
import statemachine.diagram.edit.parts.StateEditPart;
import statemachine.diagram.edit.parts.StateStateCompartmentEditPart;
import statemachine.diagram.edit.parts.StatechartEditPart;
import statemachine.diagram.edit.parts.TransitionEditPart;
import statemachine.diagram.part.Messages;
import statemachine.diagram.part.StatemachineVisualIDRegistry;

/**
 * @generated
 */
public class StatemachineNavigatorContentProvider implements
		ICommonContentProvider {

	/**
	 * @generated
	 */
	private static final Object[] EMPTY_ARRAY = new Object[0];

	/**
	 * @generated
	 */
	private Viewer myViewer;

	/**
	 * @generated
	 */
	private AdapterFactoryEditingDomain myEditingDomain;

	/**
	 * @generated
	 */
	private WorkspaceSynchronizer myWorkspaceSynchronizer;

	/**
	 * @generated
	 */
	private Runnable myViewerRefreshRunnable;

	/**
	 * @generated
	 */
	public StatemachineNavigatorContentProvider() {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE
				.createEditingDomain();
		myEditingDomain = (AdapterFactoryEditingDomain) editingDomain;
		myEditingDomain.setResourceToReadOnlyMap(new HashMap() {
			public Object get(Object key) {
				if (!containsKey(key)) {
					put(key, Boolean.TRUE);
				}
				return super.get(key);
			}
		});
		myViewerRefreshRunnable = new Runnable() {
			public void run() {
				if (myViewer != null) {
					myViewer.refresh();
				}
			}
		};
		myWorkspaceSynchronizer = new WorkspaceSynchronizer(editingDomain,
				new WorkspaceSynchronizer.Delegate() {
					public void dispose() {
					}

					public boolean handleResourceChanged(final Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceDeleted(Resource resource) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}

					public boolean handleResourceMoved(Resource resource,
							final URI newURI) {
						for (Iterator it = myEditingDomain.getResourceSet()
								.getResources().iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							nextResource.unload();
						}
						if (myViewer != null) {
							myViewer.getControl().getDisplay().asyncExec(
									myViewerRefreshRunnable);
						}
						return true;
					}
				});
	}

	/**
	 * @generated
	 */
	public void dispose() {
		myWorkspaceSynchronizer.dispose();
		myWorkspaceSynchronizer = null;
		myViewerRefreshRunnable = null;
		for (Iterator it = myEditingDomain.getResourceSet().getResources()
				.iterator(); it.hasNext();) {
			Resource resource = (Resource) it.next();
			resource.unload();
		}
		((TransactionalEditingDomain) myEditingDomain).dispose();
		myEditingDomain = null;
	}

	/**
	 * @generated
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		myViewer = viewer;
	}

	/**
	 * @generated
	 */
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @generated
	 */
	public void restoreState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void saveState(IMemento aMemento) {
	}

	/**
	 * @generated
	 */
	public void init(ICommonContentExtensionSite aConfig) {
	}

	/**
	 * @generated
	 */
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
					.toString(), true);
			Resource resource = myEditingDomain.getResourceSet().getResource(
					fileURI, true);
			Collection result = new ArrayList();
			result.addAll(createNavigatorItems(selectViewsByType(resource
					.getContents(), StatechartEditPart.MODEL_ID), file, false));
			return result.toArray();
		}

		if (parentElement instanceof StatemachineNavigatorGroup) {
			StatemachineNavigatorGroup group = (StatemachineNavigatorGroup) parentElement;
			return group.getChildren();
		}

		if (parentElement instanceof StatemachineNavigatorItem) {
			StatemachineNavigatorItem navigatorItem = (StatemachineNavigatorItem) parentElement;
			if (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {
				return EMPTY_ARRAY;
			}
			return getViewChildren(navigatorItem.getView(), parentElement);
		}

		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Object[] getViewChildren(View view, Object parentElement) {
		switch (StatemachineVisualIDRegistry.getVisualID(view)) {

		case StatechartEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup links = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Statechart_1000_links,
					"icons/linksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(RegionEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getDiagramLinksByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			links
					.addChildren(createNavigatorItems(connectedViews, links,
							false));
			if (!links.isEmpty()) {
				result.add(links);
			}
			return result.toArray();
		}

		case RegionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(RegionRegionCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(StateEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(PseudostateEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(FinalStateEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case StateEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup incominglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_State_3001_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup outgoinglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_State_3001_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(StateStateCompartmentEditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Region2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getIncomingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Region2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			Collection connectedViews = getChildrenByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(RegionRegionCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(StateEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(PseudostateEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(FinalStateEditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate2EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate3EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate4EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			connectedViews = getChildrenByType(
					Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(RegionRegionCompartment2EditPart.VISUAL_ID));
			connectedViews = getChildrenByType(connectedViews,
					StatemachineVisualIDRegistry
							.getType(Pseudostate5EditPart.VISUAL_ID));
			result.addAll(createNavigatorItems(connectedViews, parentElement,
					false));
			return result.toArray();
		}

		case PseudostateEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup incominglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3003_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup outgoinglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3003_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(TransitionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case FinalStateEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup incominglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_FinalState_3004_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup outgoinglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_FinalState_3004_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(TransitionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate2EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup incominglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3005_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup outgoinglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3005_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(TransitionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate3EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup incominglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3006_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup outgoinglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3006_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(TransitionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate4EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup incominglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3007_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup outgoinglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3007_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(TransitionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case Pseudostate5EditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup incominglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3008_incominglinks,
					"icons/incomingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup outgoinglinks = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Pseudostate_3008_outgoinglinks,
					"icons/outgoingLinksNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getIncomingLinksByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(TransitionEditPart.VISUAL_ID));
			incominglinks.addChildren(createNavigatorItems(connectedViews,
					incominglinks, true));
			connectedViews = getOutgoingLinksByType(
					Collections.singleton(view), StatemachineVisualIDRegistry
							.getType(TransitionEditPart.VISUAL_ID));
			outgoinglinks.addChildren(createNavigatorItems(connectedViews,
					outgoinglinks, true));
			if (!incominglinks.isEmpty()) {
				result.add(incominglinks);
			}
			if (!outgoinglinks.isEmpty()) {
				result.add(outgoinglinks);
			}
			return result.toArray();
		}

		case TransitionEditPart.VISUAL_ID: {
			Collection result = new ArrayList();
			StatemachineNavigatorGroup target = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Transition_4001_target,
					"icons/linkTargetNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			StatemachineNavigatorGroup source = new StatemachineNavigatorGroup(
					Messages.NavigatorGroupName_Transition_4001_source,
					"icons/linkSourceNavigatorGroup.gif", parentElement); //$NON-NLS-1$
			Collection connectedViews = getLinksTargetByType(Collections
					.singleton(view), StatemachineVisualIDRegistry
					.getType(StateEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(PseudostateEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(FinalStateEditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate2EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate3EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate4EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksTargetByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate5EditPart.VISUAL_ID));
			target.addChildren(createNavigatorItems(connectedViews, target,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(StateEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(PseudostateEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(FinalStateEditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate2EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate3EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate4EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			connectedViews = getLinksSourceByType(Collections.singleton(view),
					StatemachineVisualIDRegistry
							.getType(Pseudostate5EditPart.VISUAL_ID));
			source.addChildren(createNavigatorItems(connectedViews, source,
					true));
			if (!target.isEmpty()) {
				result.add(target);
			}
			if (!source.isEmpty()) {
				result.add(source);
			}
			return result.toArray();
		}
		}
		return EMPTY_ARRAY;
	}

	/**
	 * @generated
	 */
	private Collection getLinksSourceByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeSource = nextEdge.getSource();
			if (type.equals(nextEdgeSource.getType())
					&& isOwnView(nextEdgeSource)) {
				result.add(nextEdgeSource);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getLinksTargetByType(Collection edges, String type) {
		Collection result = new ArrayList();
		for (Iterator it = edges.iterator(); it.hasNext();) {
			Edge nextEdge = (Edge) it.next();
			View nextEdgeTarget = nextEdge.getTarget();
			if (type.equals(nextEdgeTarget.getType())
					&& isOwnView(nextEdgeTarget)) {
				result.add(nextEdgeTarget);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getOutgoingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getSourceEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getIncomingLinksByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getTargetEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getChildrenByType(Collection nodes, String type) {
		Collection result = new ArrayList();
		for (Iterator it = nodes.iterator(); it.hasNext();) {
			View nextNode = (View) it.next();
			result.addAll(selectViewsByType(nextNode.getChildren(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection getDiagramLinksByType(Collection diagrams, String type) {
		Collection result = new ArrayList();
		for (Iterator it = diagrams.iterator(); it.hasNext();) {
			Diagram nextDiagram = (Diagram) it.next();
			result.addAll(selectViewsByType(nextDiagram.getEdges(), type));
		}
		return result;
	}

	/**
	 * @generated
	 */
	private Collection selectViewsByType(Collection views, String type) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (type.equals(nextView.getType()) && isOwnView(nextView)) {
				result.add(nextView);
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	private boolean isOwnView(View view) {
		return StatechartEditPart.MODEL_ID.equals(StatemachineVisualIDRegistry
				.getModelID(view));
	}

	/**
	 * @generated
	 */
	private Collection createNavigatorItems(Collection views, Object parent,
			boolean isLeafs) {
		Collection result = new ArrayList();
		for (Iterator it = views.iterator(); it.hasNext();) {
			result.add(new StatemachineNavigatorItem((View) it.next(), parent,
					isLeafs));
		}
		return result;
	}

	/**
	 * @generated
	 */
	public Object getParent(Object element) {
		if (element instanceof StatemachineAbstractNavigatorItem) {
			StatemachineAbstractNavigatorItem abstractNavigatorItem = (StatemachineAbstractNavigatorItem) element;
			return abstractNavigatorItem.getParent();
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean hasChildren(Object element) {
		return element instanceof IFile || getChildren(element).length > 0;
	}

}
