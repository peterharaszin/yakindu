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

package org.esmp.dsm.codegen.c.internal;

import java.util.HashMap;
import java.util.Map;

import org.esmp.dsm.codegen.c.CCodegenContext;

/**
 * @author Andreas Unger
 *
 */
public class CCodegenContextImpl implements CCodegenContext {

	private String headerFolder;
	private String sourceFolder;
	private String prefix;
	private long samplingFrequency;
	
	private Map<Object, Object> data = new HashMap<Object, Object>();
	
	public String getHeaderFolder() {
		return headerFolder;
	}
	
	/**
	 * @param headerFolder the headerFolder to set
	 */
	public void setHeaderFolder(String headerFolder) {
		this.headerFolder = headerFolder;
	}

	public String getSourceFolder() {
		return sourceFolder;
	}
	
	/**
	 * @param sourceFolder the sourceFolder to set
	 */
	public void setSourceFolder(String sourceFolder) {
		this.sourceFolder = sourceFolder;
	}

	public String getPrefix() {
		return prefix;
	}
	
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public long getSamplingFrequency() {
		return samplingFrequency;
	}
	
	/**
	 * @param samplingFrequency the samplingFrequency to set
	 */
	public void setSamplingFrequency(long samplingFrequency) {
		this.samplingFrequency = samplingFrequency;
	}
	
	public Map<Object, Object> getData() {
		return data;
	}

}
