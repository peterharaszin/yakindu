package org.eclipselabs.damos.simulation.ui.internal.part;

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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.execution.executionflow.ComponentNode;
import org.eclipselabs.damos.execution.executionflow.ExecutionFlow;
import org.eclipselabs.damos.execution.executionflow.Node;
import org.eclipselabs.damos.simulation.engine.IChartData;
import org.eclipselabs.damos.simulation.engine.IComponentSimulationObject;
import org.eclipselabs.damos.simulation.engine.util.SimulationUtil;

public class SimulationView extends ViewPart {

	public static final String ID = "org.eclipselabs.damos.simulation.ui.simulationView";
	
	private ChartCanvas canvas;
	private URI selectedBlock;
	private List<URI> chartBlocks = Collections.emptyList();
	
	private ISelectionListener selectionListener = new ISelectionListener() {

		public void selectionChanged(IWorkbenchPart part, ISelection selection) {
			if (!canvas.isDisposed()) {
				processSelection(selection);
			}
		}
		
	};
	
	public void createPartControl(Composite parent) {
		canvas = new ChartCanvas(parent, SWT.NONE);
		ISelectionService selectionService = getSite().getWorkbenchWindow().getSelectionService();
		selectionService.addSelectionListener(selectionListener);
		processSelection(selectionService.getSelection());
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
							selectedBlock = EcoreUtil.getURI(selectedElement);
							canvas.setSingleChartIndex(chartBlocks.indexOf(selectedBlock));
						} else {
							selectedBlock = null;
							canvas.setSingleChartIndex(-1);
						}
					}
				}
			}
		}
	}

	public void setExecutionFlow(ExecutionFlow executionFlow) {
		Map<IChartData, URI> dataset = new TreeMap<IChartData, URI>(new Comparator<IChartData>() {
			public int compare(IChartData data1, IChartData data2) {
				return data1.getChartTitle().compareTo(data2.getChartTitle());
			}
		});
		for (Node node : executionFlow.getGraph().getNodes()) {
			IComponentSimulationObject simulationObject = SimulationUtil.getComponentSimulationObject(node);
			if (simulationObject instanceof IAdaptable) {
				IChartData simulationData = (IChartData) ((IAdaptable) simulationObject).getAdapter(IChartData.class);
				if (simulationData != null && node instanceof ComponentNode) {
					ComponentNode componentNode = (ComponentNode) node;
					dataset.put(simulationData, EcoreUtil.getURI(componentNode.getComponent()));
				}
			}
		}
		canvas.setDataset(dataset.keySet());
		chartBlocks = new ArrayList<URI>(dataset.values());
		if (selectedBlock != null) {
			canvas.setSingleChartIndex(chartBlocks.indexOf(selectedBlock));
		} else {
			canvas.setSingleChartIndex(-1);
		}
	}
	
	public void clear() {
		canvas.clear();
	}
	
	public void setProgress(int progress) {
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
	}
	
}
