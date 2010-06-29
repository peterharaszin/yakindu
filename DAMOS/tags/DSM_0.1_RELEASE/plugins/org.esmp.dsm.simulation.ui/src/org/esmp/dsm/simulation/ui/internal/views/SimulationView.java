package org.esmp.dsm.simulation.ui.internal.views;

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
import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;
import org.esmp.dsm.simulation.IChartData;
import org.esmp.dsm.simulation.SimulationModel;
import org.esmp.dsm.simulation.internal.util.SimulationUtil;

public class SimulationView extends ViewPart {

	public static final String ID = "org.esmp.dsm.simulation.ui.main";
	
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
					if (rootElement instanceof BlockDiagram) {
						if (selectedElement instanceof Block) {
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

	public void setExecutionGraph(ExecutionGraph executionGraph) {
		Map<IChartData, URI> dataset = new TreeMap<IChartData, URI>(new Comparator<IChartData>() {
			public int compare(IChartData data1, IChartData data2) {
				return data1.getChartTitle().compareTo(data2.getChartTitle());
			}
		});
		for (ExecutionNode node : executionGraph.getNodes()) {
			SimulationModel simulationModel = SimulationUtil.getSimulationModel(node.getBlock());
			if (simulationModel instanceof IAdaptable) {
				IChartData simulationData = (IChartData) ((IAdaptable) simulationModel).getAdapter(IChartData.class);
				if (simulationData != null) {
					dataset.put(simulationData, EcoreUtil.getURI(node.getBlock()));
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
