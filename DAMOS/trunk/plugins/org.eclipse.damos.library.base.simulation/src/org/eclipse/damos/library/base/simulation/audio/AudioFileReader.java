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
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioFormat.Encoding;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioFileReader {

	private AudioInputStream audioInputStream;
	private AudioFormat format;
	private byte[] buffer;

	public AudioFileReader(InputStream inputStream) throws UnsupportedAudioFileException, IOException {
		audioInputStream = AudioSystem.getAudioInputStream(inputStream);
		format = audioInputStream.getFormat();
		buffer = new byte[format.getSampleSizeInBits() / 8 * format.getChannels()];
	}

	public AudioFormat getFormat() {
		return format;
	}

	public void getInterleavedSamples(double[] samples) throws IOException {
		audioInputStream.read(buffer, 0, buffer.length);
		decodeBytes(buffer, samples);
	}

	public void close() throws IOException {
		audioInputStream.close();
	}

	private void decodeBytes(byte[] audioBytes, double[] audioSamples) {
		int sampleSizeInBytes = format.getSampleSizeInBits() / 8;
		int[] sampleBytes = new int[sampleSizeInBytes];
		int k = 0; // index in audioBytes
		boolean unsigned = format.getSampleSizeInBits() == 8 && format.getEncoding() == Encoding.PCM_UNSIGNED;
		for (int i = 0; i < audioSamples.length; i++) {
			if (format.isBigEndian()) {
				for (int j = 0; j < sampleSizeInBytes; j++) {
					sampleBytes[j] = audioBytes[k++];
				}
			} else {
				for (int j = sampleSizeInBytes - 1; j >= 0; j--) {
					sampleBytes[j] = audioBytes[k++];
				}
			}
			int value = 0;
			for (int j = 0; j < sampleSizeInBytes; j++) {
				value += sampleBytes[j];
				if (j < sampleSizeInBytes - 1) {
					value <<= 8;
				}
			}
			if (unsigned) {
				value -= 128;
			}
			// decode value
			double ratio = Math.pow(2.0, format.getSampleSizeInBits() - 1);
			audioSamples[i] = ((double) value) / ratio;
		}
	}
	
}
