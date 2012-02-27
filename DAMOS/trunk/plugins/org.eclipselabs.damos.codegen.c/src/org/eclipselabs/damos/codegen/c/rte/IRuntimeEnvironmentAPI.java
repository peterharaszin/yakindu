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

package org.eclipselabs.damos.codegen.c.rte;

import java.io.IOException;


/**
 * @author Andreas Unger
 *
 */
public interface IRuntimeEnvironmentAPI {

	boolean contributesMultitaskingIncludes();
	void writeMultitaskingIncludes(Appendable appendable) throws IOException;
	
	void writeTaskInfoInclude(Appendable appendable) throws IOException;
	String getTaskInfoStructName();
	
	IFastLockGenerator getFastLockGenerator();
	ISemaphoreGenerator getSemaphoreGenerator();
	IMessageQueueGenerator getMessageQueueGenerator();
	
	void writeTaskFunctionType(Appendable appendable, String name) throws IOException;
	void writeTaskSignature(Appendable appendable, String name) throws IOException;
	void writeTaskReturnStatement(Appendable appendable, String name) throws IOException;
	
}
