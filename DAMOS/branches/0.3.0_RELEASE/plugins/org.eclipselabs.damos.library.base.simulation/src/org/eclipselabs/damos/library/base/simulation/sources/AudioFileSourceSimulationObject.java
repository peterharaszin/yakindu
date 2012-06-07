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

package org.eclipselabs.damos.library.base.simulation.sources;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipselabs.damos.library.base.simulation.LibraryBaseSimulationPlugin;
import org.eclipselabs.damos.library.base.simulation.audio.AudioFileReader;
import org.eclipselabs.damos.library.base.util.sources.AudioFileSourceConstants;
import org.eclipselabs.damos.mscript.interpreter.value.IValue;
import org.eclipselabs.damos.mscript.interpreter.value.Values;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.eclipselabs.damos.simulation.ISimulationMonitor;
import org.eclipselabs.damos.simulation.simulator.AbstractBlockSimulationObject;

/**
 * @author Andreas Unger
 *
 */
public class AudioFileSourceSimulationObject extends AbstractBlockSimulationObject {

	private AudioFileReader audioFileReader;

	private double[] rawOutputValues;
	private IValue[] outputValue;

	@Override
	public void initialize(IProgressMonitor monitor) throws CoreException {
		String fileURIString = getComponent().getArgumentStringValue(AudioFileSourceConstants.PARAMETER__FILE_URI);
		if (fileURIString == null || fileURIString.trim().length() == 0) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "No file URI specified for block '" + getComponent().getName() + "'"));
		}
		
		try {
			InputStream inputStream;
			URI fileURI = URI.createURI(fileURIString);
			if (fileURI.isFile()) {
				inputStream = new FileInputStream(fileURI.toFileString());
			} else if (fileURI.isPlatformResource()) {
				IPath path = new Path(fileURI.toPlatformString(true));

				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				if (!file.exists()) {
					throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "File '" + file.getName() + "' not found"));
				}
				inputStream = file.getContents();
			} else {
				String scheme = fileURI.scheme() != null ? " '" + fileURI.scheme() + "'" : "";
				throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Unknown file scheme" + scheme));
			}

			audioFileReader = new AudioFileReader(new BufferedInputStream(inputStream));
			int channelCount = audioFileReader.getFormat().getChannels();
			int portCount = getComponent().getPrimaryOutputPorts().size();
			if (channelCount < portCount) {
				throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Channel count of audio file does not correspond to output port count"));
			}
			rawOutputValues = new double[channelCount];
			outputValue = new IValue[portCount];
		} catch (UnsupportedAudioFileException e) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Audio file not supported", e));
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Reading audio file failed", e));
		}
	}
	
	@Override
	public IValue getOutputValue(int outputIndex, int portIndex) {
		return outputValue[portIndex];
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#computeOutputValues()
	 */
	@Override
	public void computeOutputValues(double t, ISimulationMonitor monitor) throws CoreException {
		try {
			audioFileReader.getInterleavedSamples(rawOutputValues);
			for (int i = 0; i < outputValue.length; ++i) {
				outputValue[i] = Values.valueOf(getComputationContext(), TypeUtil.createRealType(), rawOutputValues[i]);
			}
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "Reading audio file failed", e));
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.simulation.simulator.AbstractSimulationObject#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		try {
			audioFileReader.close();
		} catch (IOException e) {
			LibraryBaseSimulationPlugin.getDefault().getLog().log(new Status(IStatus.ERROR, LibraryBaseSimulationPlugin.PLUGIN_ID, "I/O error", e));
		}
	}
	
}
