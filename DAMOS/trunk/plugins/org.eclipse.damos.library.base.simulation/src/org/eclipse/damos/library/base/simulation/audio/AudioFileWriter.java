/*******************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Andreas Unger - initial API and implementation
 *******************************************************************************/
package org.eclipse.damos.library.base.simulation.audio;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class AudioFileWriter {

	private OutputStream outputStream;
	private AudioFormat format;
	private AudioFileFormat.Type targetType;

	private PipedOutputStream pipedOutputStream;
	private PipedInputStream pipedInputStream;
	private AudioInputStream audioInputStream;
	private byte[] buffer;

	private Thread thread;
	
	private Runnable runnable = new Runnable() {

		public void run() {
			try {
				AudioSystem.write(audioInputStream, targetType, outputStream);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	};

	public AudioFileWriter(OutputStream outputStream, AudioFormat format, AudioFileFormat.Type targetType, long length)
			throws IOException {
		this.format = format;
		this.targetType = targetType;
		this.outputStream = outputStream;

		pipedOutputStream = new PipedOutputStream();
		pipedInputStream = new PipedInputStream(pipedOutputStream);
		audioInputStream = new AudioInputStream(pipedInputStream, format, length);
		
		buffer = new byte[format.getSampleSizeInBits() / 8 * format.getChannels()];

		thread = new Thread(runnable);
		thread.start();
	}

	public void write(double[] samples) throws IOException {
		encodeSamples(samples, buffer);
		pipedOutputStream.write(buffer);
	}

	public void close() throws IOException {
		if (pipedOutputStream != null) {
			audioInputStream.close();
			pipedInputStream.close();
			pipedOutputStream.close();
		}
	}

	private void encodeSamples(double[] audioData, byte[] audioBytes) {
		int length = format.getChannels();
		if (format.getSampleSizeInBits() == 8) {
			if (format.getEncoding() == Encoding.PCM_SIGNED) {
				for (int i = 0; i < length; i++) {
					audioBytes[i] = (byte) (audioData[i] * 127);
				}
			} else {
				for (int i = 0; i < length; i++) {
					audioBytes[i] = (byte) (audioData[i] * 127 + 127);
				}
			}
		} else {
			int factor = (1 << (format.getSampleSizeInBits() - 1)) - 1;
			int sampleSizeInBytes = format.getSampleSizeInBits() / 8;
			if (format.isBigEndian()) {
				for (int i = 0; i < length; i++) {
					int value = (int) (audioData[i] * factor);
					for (int j = sampleSizeInBytes - 1; j >= 0; --j) {
						audioBytes[sampleSizeInBytes * i + j] = (byte) (value & 0xff);
						value >>= 8;
					}
				}
			} else {
				for (int i = 0; i < length; i++) {
					int value = (int) (audioData[i] * factor);
					for (int j = 0; j < sampleSizeInBytes; ++j) {
						audioBytes[sampleSizeInBytes * i + j] = (byte) (value & 0xff);
						value >>= 8;
					}
				}
			}
		}
	}

}
