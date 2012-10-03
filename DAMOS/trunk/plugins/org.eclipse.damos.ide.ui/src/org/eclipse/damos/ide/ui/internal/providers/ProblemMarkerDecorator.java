package org.eclipse.damos.ide.ui.internal.providers;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.damos.dml.Fragment;
import org.eclipse.damos.dml.util.FragmentSelectionChangeEvent;
import org.eclipse.damos.dml.util.FragmentSelectionManager;
import org.eclipse.damos.dml.util.IFragmentSelectionChangeListener;
import org.eclipse.damos.ide.core.validation.IValidationListener;
import org.eclipse.damos.ide.core.validation.Problem;
import org.eclipse.damos.ide.core.validation.ValidationAdapter;
import org.eclipse.damos.ide.core.validation.ValidationEvent;
import org.eclipse.damos.ide.ui.internal.hover.AbstractHoverInformationControlManager;
import org.eclipse.damos.ide.ui.internal.hover.AbstractInformationControlManager;
import org.eclipse.damos.ide.ui.internal.hover.HoverInformationControlManager;
import org.eclipse.damos.ide.ui.internal.registry.QuickFixProviderRegistry;
import org.eclipse.damos.ide.ui.internal.util.ProblemUtil;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

class ProblemMarkerDecorator extends AbstractDecorator {

	private static boolean quickFixProviderRegistryInitialized;

	private boolean active;
	
	private EObject element;
	private ValidationAdapter validationAdapter;
	private IFile file;
	
	private IValidationListener validationListener = new IValidationListener() {
		
		public void validationPerformed(ValidationEvent event) {
			scheduleRefresh();
		}
		
	};
	
	private IFragmentSelectionChangeListener fragmentSelectionChangeListener = new IFragmentSelectionChangeListener() {
		
		public void fragmentSelectionChanged(FragmentSelectionChangeEvent event) {
			refresh();
		}
		
	};
	
	public ProblemMarkerDecorator(IDecoratorTarget decoratorTarget) {
		super(decoratorTarget);
		element = (EObject) getDecoratorTarget().getAdapter(EObject.class);
		validationAdapter = ValidationAdapter.get(element.eResource());
		initializeFile();
	}
	
	public void activate() {
		if (!quickFixProviderRegistryInitialized) {
			// Query quick fix provider registry once to speed up tooltip
			QuickFixProviderRegistry.getInstance().getProviders();
			quickFixProviderRegistryInitialized = true;
		}

		installHoverInformationControlManager();
		
		FragmentSelectionManager fragmentSelectionManager = getFragmentSelectionManager();
		if (fragmentSelectionManager != null) {
			fragmentSelectionManager.addFragmentSelectionChangeListener(fragmentSelectionChangeListener);
		}
		
		validationAdapter.addValidationListener(validationListener);
		
		active = true;
	}
	
	public void deactivate() {
		active = false;
		
		validationAdapter.removeValidationListener(validationListener);

		FragmentSelectionManager fragmentSelectionManager = getFragmentSelectionManager();
		if (fragmentSelectionManager != null) {
			fragmentSelectionManager.removeFragmentSelectionChangeListener(fragmentSelectionChangeListener);
		}
		super.deactivate();
	}
	
	private void scheduleRefresh() {
		Display.getDefault().asyncExec(new Runnable() {
			
			public void run() {
				if (active) {
					refresh();
				}
			}
			
		});
	}
	
	public void refresh() {
		if (file != null && file.exists()) {
			Fragment selectedFragment = getSelectedFragment();
			List<Problem> resourceProblems = ProblemUtil.getResourceProblems(element, file, selectedFragment);
			List<Problem> liveProblems = ProblemUtil.getLiveProblems(element, selectedFragment);
			refreshDecorations(resourceProblems, liveProblems);
		}
	}
	
	private void refreshDecorations(List<Problem> resourceProblems, List<Problem> liveProblems) {
		removeDecoration();
		
		Image image = null;
		
		if (!liveProblems.isEmpty()) {
			image = ProblemUtil.getMarkerImage(getMaximumSeverity(liveProblems), false);
		} else if (!resourceProblems.isEmpty()) {
			image = ProblemUtil.getMarkerImage(getMaximumSeverity(resourceProblems), true);
		}

		if (image != null) {
			if (getDecoratorTarget().getAdapter(View.class) instanceof Edge) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(image, 50, true));
			} else {
				setDecoration(getDecoratorTarget().addShapeDecoration(image, IDecoratorTarget.Direction.NORTH_EAST, 0, true));
			}
		}
	}
	
	private void initializeFile() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		Resource resource = element.eResource();
		if (resource != null) {
			URI uri = resource.getURI();
			if (uri != null) {
				String uriString;
				if (uri.isPlatform()) {
					uriString = uri.toPlatformString(false);
				} else {
					uriString = uri.toString();
				}
				IPath path = new Path(uriString);
				file = root.getFile(path);
			}
		}
	}
	
	private FragmentSelectionManager getFragmentSelectionManager() {
		EditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);
		if (editPart != null) {
			return (FragmentSelectionManager) editPart.getRoot().getContents().getAdapter(FragmentSelectionManager.class);
		}
		return null;
	}
	
	private int getMaximumSeverity(List<Problem> problems) {
		int maximumSeverity = IMarker.SEVERITY_INFO;
		for (Problem marker : problems) {
			int severity = marker.getSeverity();
			if (severity > maximumSeverity) {
				maximumSeverity = severity;
			}
		}
		return maximumSeverity;
	}
	
	private void installHoverInformationControlManager() {
		Object adapter = getDecoratorTarget().getAdapter(EditPart.class);
		if (!(adapter instanceof IGraphicalEditPart)) {
			return;
		}

		EditPartViewer viewer = ((IGraphicalEditPart) adapter).getViewer();
		Object existingManager = viewer.getControl().getData(AbstractInformationControlManager.class.getCanonicalName());
		if (existingManager != null) {
			return;
		}
		
		AbstractHoverInformationControlManager manager = new HoverInformationControlManager(viewer);
				
		viewer.getControl().setData(AbstractInformationControlManager.class.getCanonicalName(), manager);
	}
		
	private Fragment getSelectedFragment() {
		FragmentSelectionManager fragmentSelectionManager = getFragmentSelectionManager();
		if (fragmentSelectionManager != null) {
			return fragmentSelectionManager.getSelectedFragment();
		}
		return null;
	}

}
