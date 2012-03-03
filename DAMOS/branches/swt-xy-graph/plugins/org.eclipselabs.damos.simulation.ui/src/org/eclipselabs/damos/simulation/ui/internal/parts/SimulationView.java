package org.eclipselabs.damos.simulation.ui.internal.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.simulation.ISimulation;
import org.eclipselabs.damos.simulation.ISimulationAgent;
import org.eclipselabs.damos.simulation.ISimulationListener;
import org.eclipselabs.damos.simulation.IXYChartData;
import org.eclipselabs.damos.simulation.IXYChartDataProvider;
import org.eclipselabs.damos.simulation.SimulationEvent;
import org.eclipselabs.damos.simulation.SimulationManager;

public class SimulationView extends ViewPart {

	public static final String ID = "org.eclipselabs.damos.simulation.ui.simulationView";
	
	private ChartCanvas canvas;
	private URI selectedComponentURI;
	private List<URI> chartComponentURIs = Collections.emptyList();
	
	private Action terminateAction;
	
	private ISelectionListener selectionListener = new ISelectionListener() {

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (!canvas.isDisposed()) {
				processSelection(selection);
			}
		}
		
	};
	
	private ISimulationListener simulationListener = new ISimulationListener() {
		
		public void handleSimulationEvent(final SimulationEvent event) {
			switch (event.getKind()) {
			case SimulationEvent.START:
			case SimulationEvent.FINISH:
			case SimulationEvent.CANCEL:
				Display.getDefault().asyncExec(new Runnable() {
					
					public void run() {
						updateTerminateAction();
					}
				
				});
				break;
			}
		}
		
	};
	
	public void createPartControl(Composite parent) {
		canvas = new ChartCanvas(parent, SWT.NONE);
		ISelectionService selectionService = getSite().getWorkbenchWindow().getSelectionService();
		selectionService.addSelectionListener(selectionListener);
		processSelection(selectionService.getSelection());
		
		terminateAction = new Action() {
			
			/* (non-Javadoc)
			 * @see org.eclipse.jface.action.Action#run()
			 */
			@Override
			public void run() {
				for (ISimulation simulation : SimulationManager.getInstance().getRunningSimulations()) {
					simulation.getMonitor().setCanceled(true);
				}
			}
			
		};
		
		terminateAction.setText("Terminate");  
		terminateAction.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ELCL_STOP));
		terminateAction.setEnabled(false);
		getViewSite().getActionBars().getToolBarManager().add(terminateAction);
		
		SimulationManager.getInstance().addSimulationListener(simulationListener);
		
		updateTerminateAction();
	}
	
	private void updateTerminateAction() {
		terminateAction.setEnabled(!SimulationManager.getInstance().getRunningSimulations().isEmpty());
	}
	
	private void processSelection(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object o = ((IStructuredSelection) selection).getFirstElement();
			if (o instanceof IAdaptable) {
				EObject selectedElement = (EObject) ((IAdaptable) o).getAdapter(EObject.class);
				if (selectedElement != null) {
					EObject rootElement = EcoreUtil.getRootContainer(selectedElement);
					if (rootElement instanceof Fragment) {
						if (selectedElement instanceof Component) {
							selectedComponentURI = EcoreUtil.getURI(selectedElement);
							canvas.setSingleChartIndex(chartComponentURIs.indexOf(selectedComponentURI));
						} else {
							selectedComponentURI = null;
							canvas.setSingleChartIndex(-1);
						}
					}
				}
			}
		}
	}
	
	public void setSimulation(ISimulation simulation) {
		Map<IXYChartData, URI> dataset = new TreeMap<IXYChartData, URI>(new Comparator<IXYChartData>() {
			public int compare(IXYChartData data1, IXYChartData data2) {
				return data1.getChartTitle().compareTo(data2.getChartTitle());
			}
		});
		
		for (ISimulationAgent agent : simulation.getAgents()) {
			if (agent instanceof IXYChartDataProvider) {
				IXYChartData data = ((IXYChartDataProvider) agent).getXYChartData();
				dataset.put(data, EcoreUtil.getURI(agent.getComponent()));
			}
		}
		
		canvas.setDataset(dataset.keySet());
		
		chartComponentURIs = new ArrayList<URI>(dataset.values());
		if (selectedComponentURI != null) {
			canvas.setSingleChartIndex(chartComponentURIs.indexOf(selectedComponentURI));
		} else {
			canvas.setSingleChartIndex(-1);
		}
	}

	public void clear() {
		canvas.clear();
	}
	
	public void setRealtime(boolean realtime) {
		canvas.setRealtime(realtime);
	}
	
	public void setProgress(long progress) {
		canvas.setProgress(progress);
	}

	public void setFocus() {
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#dispose()
	 */
	public void dispose() {
		super.dispose();
		ISelectionService selectionService = getSite().getWorkbenchWindow().getSelectionService();
		selectionService.removeSelectionListener(selectionListener);
		SimulationManager.getInstance().removeSimulationListener(simulationListener);
	}
	
}
