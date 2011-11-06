/****************************************************************************
 * Copyright (c) 2008, 2009 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.diagram.ui.editparts;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;
import org.eclipselabs.damos.diagram.ui.figures.SubsystemFigure;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.Subsystem;
import org.eclipselabs.damos.dml.SubsystemRealization;
import org.eclipselabs.damos.dml.SystemInterface;
import org.eclipselabs.damos.dml.util.DMLUtil;
import org.eclipselabs.damos.dml.util.DMLUtil.SubsystemRealizationType;

/**
 * @author Andreas Unger
 *
 */
public class SubsystemEditPart extends StandardComponentEditPart {

	private ImageDescriptor blankImageDescriptor;
	private ImageDescriptor implementationImageDescriptor;
	private ImageDescriptor overrideImageDescriptor;
	private Image blankImage;
	private Image implementationImage;
	private Image overrideImage;

	private Adapter adapter = new EContentAdapter() {
		
		public void notifyChanged(Notification notification) {
			super.notifyChanged(notification);
			if (notification.getFeature() == DMLPackage.Literals.FRAGMENT__FRAGMENT_ELEMENTS) {
				refreshRealizationIndicators();
			}
		}
		
		public void setTarget(Notifier newTarget) {
			if (newTarget instanceof ResourceSet || newTarget instanceof Resource) {
				super.setTarget(newTarget);
			}
		}
		
		public void unsetTarget(Notifier oldTarget) {
			if (oldTarget instanceof ResourceSet || oldTarget instanceof Resource) {
				super.unsetTarget(oldTarget);
			}
		}

	};

	private IFragmentSelectionChangeListener fragmentSelectionChangeListener = new IFragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refreshRealizationIndicators();
		}
		
	};
	
	/**
	 * @param view
	 */
	public SubsystemEditPart(View view) {
		super(view);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#activate()
	 */
	@Override
	public void activate() {
		super.activate();
		
		getEditingDomain().getResourceSet().eAdapters().add(adapter);
		
		FragmentSelectionManager fragmentSelectionManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentSelectionManager != null) {
			fragmentSelectionManager.addFragmentSelectionChangeListener(fragmentSelectionChangeListener);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#deactivate()
	 */
	@Override
	public void deactivate() {
		FragmentSelectionManager fragmentSelectionManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		if (fragmentSelectionManager != null) {
			fragmentSelectionManager.removeFragmentSelectionChangeListener(fragmentSelectionChangeListener);
		}
		
		getEditingDomain().getResourceSet().eAdapters().remove(adapter);

		if (blankImage != null) {
			blankImage.dispose();
			blankImage = null;
		}
		if (implementationImage != null) {
			implementationImage.dispose();
			implementationImage = null;
		}
		if (overrideImage != null) {
			overrideImage.dispose();
			overrideImage = null;
		}

		super.deactivate();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.diagram.ui.editparts.BlockEditPart#refreshVisuals()
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshRealizationIndicators();
		refreshText();
	}
	
	protected void refreshRealizationIndicators() {
		SubsystemFigure subsystemFigure = (SubsystemFigure) getMainFigure();
		switch (getSubsystemRealizationType()) {
		case EXISTS:
			subsystemFigure.setBorderStyle(SWT.LINE_SOLID);
			subsystemFigure.setLeftTextIcon(getBlankImage());
			break;
		case IMPLEMENTS:
			subsystemFigure.setBorderStyle(SWT.LINE_SOLID);
			subsystemFigure.setLeftTextIcon(getImplementationImage());
			break;
		case OVERRIDES:
			subsystemFigure.setBorderStyle(SWT.LINE_SOLID);
			subsystemFigure.setLeftTextIcon(getOverrideImage());
			break;
		default:
			subsystemFigure.setBorderStyle(SWT.LINE_DASH);
			subsystemFigure.setLeftTextIcon(getBlankImage());
			break;
		}
		subsystemFigure.setRightTextIcon(getBlankImage());
	}
	
	private SubsystemRealizationType getSubsystemRealizationType() {
		Fragment contextualFragment = getContextualFragment();
		if (contextualFragment != null) {
			return DMLUtil.getSubsystemRealizationType((Subsystem) resolveSemanticElement(), contextualFragment);
		}
		return SubsystemRealizationType.NONE;
	}
	
	protected void refreshText() {
		EObject element = resolveSemanticElement();
		if (element instanceof Subsystem) {
			SubsystemFigure figure = (SubsystemFigure) getMainFigure();
			SystemInterface providedInterface = ((Subsystem) element).getProvidedInterface();
			if (providedInterface != null) {
				figure.setText(providedInterface.getName());
			} else {
				figure.setText("");
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#performRequest(org.eclipse.gef.Request)
	 */
	@Override
	public void performRequest(Request request) {
		if (RequestConstants.REQ_OPEN.equals(request.getType())) {
			Subsystem subsystem = (Subsystem) resolveSemanticElement();
			if (subsystem != null) {
				Fragment contextualFragment = getContextualFragment();
				if (contextualFragment != null) {
					SubsystemRealization subsystemRealization = subsystem.getRealization(contextualFragment);
					if (subsystemRealization != null) {
						Fragment realizingFragment = subsystemRealization.getRealizingFragment();
						if (realizingFragment != null) {
							Resource resource = realizingFragment.eResource();
							if (resource != null) {
								Path path = new Path(resource.getURI().toPlatformString(true));
								if (path != null) {
									IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
									try {
										IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file, true);
									} catch (PartInitException e) {
										DiagramUIPlugin.getDefault().getLog().log(e.getStatus());
									}
								}
							}
						}
					}
				}
			}
		} else {
			super.performRequest(request);
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart#createMainFigure()
	 */
	@Override
	protected NodeFigure createMainFigure() {
		return new SubsystemFigure();
	}
	
	private Image getBlankImage() {
		if (blankImageDescriptor == null) {
			blankImageDescriptor = DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID, "icons/blank.gif");
		}
		if (blankImage == null) {
			blankImage = blankImageDescriptor.createImage();
		}
		return blankImage;
	}
	
	private Image getImplementationImage() {
		if (implementationImageDescriptor == null) {
			implementationImageDescriptor = DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID, "icons/implm_co.gif");
		}
		if (implementationImage == null) {
			implementationImage = implementationImageDescriptor.createImage();
		}
		return implementationImage;
	}
	
	private Image getOverrideImage() {
		if (overrideImageDescriptor == null) {
			overrideImageDescriptor = DiagramUIPlugin.imageDescriptorFromPlugin(DiagramUIPlugin.PLUGIN_ID, "icons/over_co.gif");
		}
		if (overrideImage == null) {
			overrideImage = overrideImageDescriptor.createImage();
		}
		return overrideImage;
	}
	
	private Fragment getContextualFragment() {
		EObject element = resolveSemanticElement();
		if (element instanceof Subsystem) {
			FragmentSelectionManager fragmentSelectionManager = (FragmentSelectionManager) getRoot().getContents().getAdapter(FragmentSelectionManager.class);
			if (fragmentSelectionManager != null) {
				return fragmentSelectionManager.getSelectedFragment();
			}
		}
		return null;
	}

}
