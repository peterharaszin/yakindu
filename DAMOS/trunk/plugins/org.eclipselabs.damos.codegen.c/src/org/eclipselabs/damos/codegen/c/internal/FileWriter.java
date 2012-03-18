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

package org.eclipselabs.damos.codegen.c.internal;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.Writer;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipselabs.damos.codegen.c.CodegenCPlugin;
import org.eclipselabs.damos.mscript.codegen.c.IWriter;

public class FileWriter {

	public void write(IWriter writer, final IFile targetFile, final IProgressMonitor monitor) throws CoreException {
		final PipedInputStream pipedInputStream = new PipedInputStream();
		PipedOutputStream pipedOutputStream;
		try {
			pipedOutputStream = new PipedOutputStream(pipedInputStream);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Writing file '" + targetFile.getName() + "' failed", e));
		}

		Writer outputStreamWriter = new OutputStreamWriter(pipedOutputStream);
		WriterThread thread = new WriterThread(targetFile, pipedInputStream, monitor);

		thread.start();

		IStatus status = Status.OK_STATUS;
		try {
			writer.write(outputStreamWriter);
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Writing file '" + targetFile.getName() + "' failed", e));
		} finally {
			try {
				outputStreamWriter.close();
			} catch (IOException e) {
				if (status.isOK()) {
					status = new Status(IStatus.ERROR, CodegenCPlugin.PLUGIN_ID, "Closing file '" + targetFile.getName() + "' failed", e);
				}
			} finally {
				try {
					thread.join();
					if (status.isOK() && !thread.getStatus().isOK()) {
						status = thread.getStatus();
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		}
		if (status.getSeverity() > IStatus.WARNING) {
			throw new CoreException(status);
		}
	}
	
	/**
	 * @author Andreas Unger
	 *
	 */
	private final class WriterThread extends Thread {
		/**
		 * 
		 */
		private final IFile targetFile;
		/**
		 * 
		 */
		private final IProgressMonitor monitor;
		/**
		 * 
		 */
		private final PipedInputStream pipedInputStream;
		
		private IStatus status = Status.OK_STATUS;
	
		/**
		 * @param targetFile
		 * @param pipedInputStream
		 * @param monitor
		 */
		private WriterThread(IFile targetFile, PipedInputStream pipedInputStream, IProgressMonitor monitor) {
			this.targetFile = targetFile;
			this.monitor = monitor;
			this.pipedInputStream = pipedInputStream;
		}
	
		@Override
		public void run() {
			try {
				if (targetFile.exists()) {
					targetFile.setContents(pipedInputStream, true, false, monitor);
				} else {
					targetFile.create(pipedInputStream, true, monitor);
				}
			} catch (CoreException e) {
				status = e.getStatus();
			}
		}
		
		/**
		 * @return the status
		 */
		public IStatus getStatus() {
			return status;
		}
		
	}
	
}