/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipse.damos.library.base.simulation;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.sound.sampled.AudioFormat;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.damos.library.base.simulation.audio.AudioFileWriter;
import org.eclipse.damos.library.base.util.AudioFileSourceConstants;
import org.eclipse.damos.mscript.interpreter.value.ISimpleNumericValue;
import org.eclipse.damos.mscript.interpreter.value.IValue;
import org.eclipse.damos.mscript.util.SampleRate;
import org.eclipse.damos.simulation.simulator.AbstractBlockSimulationObject;
import org.eclipse.damos.simulation.util.SimulationConfigurationUtil;
import org.eclipse.emf.common.util.URI;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileSinkSimulationObject extends AbstractBlockSimulationObject {

	/**
	 * 
	 */
	private static final int SAMPLE_SIZE = 32;

	private AudioFileWriter audioFileWriter;

	private long length;
	private OutputStream outputStream;
	private InputStream inputStream;
	
	private Thread thread;
	
	private double[] inputValues;
	
	private volatile IStatus status = Status.OK_STATUS;

	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		String fileURIString = getComponent().getArgumentStringValue(AudioFileSourceConstants.PARAMETER__FILE_URI);
		if (fileURIString == null || fileURIString.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "No file URI specified for block '" + getComponent().getName() + "'"));
		}
		
		int channelCount = getComponent().getPrimaryInputPorts().size();
		inputValues = new double[channelCount];
		
		double simulationTime = SimulationConfigurationUtil.getSimulationTime(getConfiguration());
		if (simulationTime <= 0) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Invalid simulation time"));
		}
		
		if (getNode().getSampleInterval().sampleTime() == 0 || getNode().getSampleInterval().sampleTime() == Double.MAX_VALUE) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Sample time of audio file sinks must be synchronous"));
		}
		
		float sampleRate;
		if (getNode().getSampleInterval() instanceof SampleRate) {
			sampleRate = ((SampleRate) getNode().getSampleInterval()).longValue();
		} else {
			sampleRate = (float) (1.0 / getNode().getSampleInterval().sampleTime());
		}
		
		length = Math.round(simulationTime * sampleRate);

		try {
			URI fileURI = URI.createURI(fileURIString);
			if (fileURI.isFile()) {
				outputStream = new FileOutputStream(fileURI.toFileString());
			} else if (fileURI.isPlatformResource()) {
				IPath path = new Path(fileURI.toPlatformString(true));

				final IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				if (!file.exists()) {
					file.create(new ByteArrayInputStream(new byte[0]), true, monitor);
				}

				PipedOutputStream pipedOutputStream = new PipedOutputStream();
				outputStream = pipedOutputStream;
				inputStream = new PipedInputStream(pipedOutputStream);

				thread = new Thread() {
					
					public void run() {
						try {
							file.setContents(inputStream, IFile.FORCE | IFile.KEEP_HISTORY, null);
						} catch (CoreException e) {
							status = e.getStatus();
						}
					}
					
				};
			} else {
				String scheme = fileURI.scheme() != null ? " '" + fileURI.scheme() + "'" : "";
				throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Unknown file scheme" + scheme));
			}
			audioFileWriter = new AudioFileWriter(outputStream, new AudioFormat(sampleRate, SAMPLE_SIZE, channelCount, true, false), Type.WAVE, length);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Writing audio file failed", e));
		}

		if (thread != null) {
			thread.start();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#setInputValue(int, int, org.eclipse.damos.mscript.interpreter.value.IValue)
	 */
	@Override
	public void setInputValue(int inputIndex, int portIndex, IValue value) {
		inputValues[portIndex] = ((ISimpleNumericValue) value).doubleValue();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#update(double)
	 */
	@Override
	public void update(double t) throws CoreException {
		try {
			if (status.isOK()) {
				if (length > 0) {
					audioFileWriter.write(inputValues);
					--length;
				}
			} else {
				throw new CoreException(status);
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Writing audio file failed", e));
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.damos.simulation.simulator.AbstractSimulationObject#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		try {
			outputStream.close();
			if (thread != null) {
				thread.join();
			}
			audioFileWriter.close();
		} catch (IOException e) {
			LibraryBaseSimulationPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "I/O error", e));
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
}
