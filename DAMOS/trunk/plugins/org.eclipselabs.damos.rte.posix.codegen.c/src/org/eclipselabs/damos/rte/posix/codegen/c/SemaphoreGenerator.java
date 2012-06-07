/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.damos.rte.posix.codegen.c;

import org.eclipselabs.damos.codegen.c.rte.AbstractSemaphoreGenerator;
import org.eclipselabs.damos.codegen.c.rte.ISemaphoreInfo;

/**
 * @author Andreas Unger
 *
 */
public class SemaphoreGenerator extends AbstractSemaphoreGenerator {

	@Override
	public boolean contributesContextCode() {
		return true;
	}
	
	@Override
	public CharSequence generateContextCode(String variableName, ISemaphoreInfo info) {
		return new StringBuilder().append("sem_t ").append(variableName).append(";\n");
	}
	
	@Override
	public boolean contributesInitializationCode() {
		return true;
	}
	
	@Override
	public CharSequence generateInitializationCode(String variableName, ISemaphoreInfo info) {
		return new StringBuilder().append("sem_init(&").append(variableName).append(", 0, ").append(info.getInitialCount()).append(");\n");
	}
	
	@Override
	public CharSequence generateDownCode(String variableName, ISemaphoreInfo info) {
		return new StringBuilder().append("sem_wait(&").append(variableName).append(");\n");
	}
	
	@Override
	public CharSequence generateUpCode(String variableName, ISemaphoreInfo info) {
		return new StringBuilder().append("sem_post(&").append(variableName).append(");\n");
	}
	
}
