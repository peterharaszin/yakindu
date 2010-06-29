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

package org.esmp.dsm.codegen.c.internal.launching;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.esmp.dsm.codegen.c.BlockCGenerator;
import org.esmp.dsm.codegen.c.CCodegenContext;
import org.esmp.dsm.codegen.c.internal.services.BlockCGeneratorService;
import org.esmp.dsm.execution.datatype.DataTypeResolver;
import org.esmp.dsm.execution.datatype.InvalidDataTypeException;
import org.esmp.dsm.execution.executiongraph.ExecutionGraph;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphBuilder;
import org.esmp.dsm.execution.executiongraph.ExecutionGraphDeadlockException;
import org.esmp.dsm.execution.executiongraph.ExecutionNode;
import org.esmp.dsm.expressions.DoubleDataType;
import org.esmp.dsm.semantic.blockdiagram.Block;
import org.esmp.dsm.semantic.blockdiagram.BlockDiagram;

/**
 * @author Andreas Unger
 *
 */
public class CCodegenProcess implements IProcess {

	private ILaunch launch;
	private String name;

	private Job job;
	private boolean terminated;

	/**
	 * 
	 */
	public CCodegenProcess(ILaunch launch, String name) {
		this.launch = launch;
		this.name = name;
		launch.addProcess(this);
		fireCreationEvent();
	}

	public ILaunch getLaunch() {
		return launch;
	}
	
	public String getLabel() {
		return name;
	}

	public void generate(BlockDiagram blockDiagram, CCodegenContext configuration) throws UnknownBlockException, ExecutionGraphDeadlockException, InvalidDataTypeException {
		ExecutionGraph executionGraph = new ExecutionGraphBuilder().build(blockDiagram);
		new DataTypeResolver().resolve(executionGraph, new DoubleDataType());
		adaptCGenerators(executionGraph);
		job = new CCodegenJob(executionGraph, configuration);
		job.addJobChangeListener(new JobChangeAdapter() {
			public void done(IJobChangeEvent event) {
				terminated = true;
				fireTerminateEvent();
			}
		});
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.schedule();
	}
	
	protected void adaptCGenerators(ExecutionGraph executionGraph) throws UnknownBlockException {
		List<Block> unknownBlocks = new ArrayList<Block>();
		
		for (ExecutionNode node : executionGraph.getNodes()) {
			Block block = node.getBlock();
			if (!block.isVirtual() && !block.getType().isStructural()) {
				BlockCGenerator blockState = BlockCGeneratorService.getInstance().createCCodeGenerator(block.getType().eResource().getURI());
				if (blockState != null) {
					block.eAdapters().add(blockState);
				} else {
					unknownBlocks.add(block);
				}
			}
		}
		
		if (!unknownBlocks.isEmpty()) {
			throw new UnknownBlockException(unknownBlocks);
		}
	}

	public boolean canTerminate() {
		return !terminated;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void terminate() throws DebugException {
		terminated = job.cancel();
	}

	public String getAttribute(String key) {
		return null;
	}

	public void setAttribute(String key, String value) {
	}

	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	public int getExitValue() throws DebugException {
		return job.getResult().getCode() == IStatus.OK ? 0 : 1;
	}

	/**
	 * Fires a creation event.
	 */
	protected void fireCreationEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.CREATE));
	}

	/**
	 * Fires a terminate event.
	 */
	protected void fireTerminateEvent() {
		fireEvent(new DebugEvent(this, DebugEvent.TERMINATE));
	}

	/**
	 * Fires the given debug event.
	 * 
	 * @param event debug event to fire
	 */
	protected void fireEvent(DebugEvent event) {
		DebugPlugin manager= DebugPlugin.getDefault();
		if (manager != null) {
			manager.fireDebugEventSet(new DebugEvent[] { event });
		}
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return null;
	}

}
