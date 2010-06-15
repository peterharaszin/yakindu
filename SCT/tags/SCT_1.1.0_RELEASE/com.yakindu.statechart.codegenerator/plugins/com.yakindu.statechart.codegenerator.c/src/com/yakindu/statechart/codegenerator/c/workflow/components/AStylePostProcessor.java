/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.codegenerator.c.workflow.components;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;

/**
 * 
 * @author muelder
 * 
 */
public class AStylePostProcessor implements PostProcessor {

	Logger log = Logger.getLogger(AStylePostProcessor.class);
	
	public void afterClose(FileHandle impl) {
		String astyle = "astyle -n -A7 -V \""
				+ impl.getTargetFile().getAbsolutePath() + "\"";
		Runtime runtime = Runtime.getRuntime();
		try {
			//AStyle uncommented -> not working on every machine
			runtime.exec(astyle);
		} catch (IOException e) {
			log.info("No astyle found in path");
			log.debug(e);
		}
	}

	public void beforeWriteAndClose(FileHandle impl) {

	}

}
