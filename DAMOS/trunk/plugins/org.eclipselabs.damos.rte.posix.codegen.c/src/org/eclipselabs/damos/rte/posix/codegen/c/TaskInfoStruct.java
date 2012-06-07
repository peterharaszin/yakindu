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

package org.eclipselabs.damos.rte.posix.codegen.c;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipselabs.damos.codegen.c.IGeneratorContext;
import org.eclipselabs.damos.codegen.c.ITaskInfoStruct;
import org.eclipselabs.damos.codegen.c.PrimaryCodeFragment;

/**
 * @author Andreas Unger
 *
 */
public class TaskInfoStruct extends PrimaryCodeFragment implements ITaskInfoStruct {

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.codegen.c.PrimaryCodeFragment#doInitialize(org.eclipselabs.damos.codegen.c.IGeneratorContext, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected void doInitialize(IGeneratorContext context, IProgressMonitor monitor) {
	}

	public CharSequence generateForwardDeclaration(boolean internal) {
		StringBuilder sb = new StringBuilder();
		sb.append("#ifndef DAMOS_POSIX_TASK_INFO_DEFINED\n");
		sb.append("#define DAMOS_POSIX_TASK_INFO_DEFINED\n\n");
		sb.append("typedef struct {\n");
		sb.append("void *(*function)(void *context);\n");
		sb.append("int priority;\n");
		sb.append("} Damos_Posix_TaskInfo;\n\n");
		sb.append("#endif /* DAMOS_POSIX_TASK_INFO_DEFINED */\n");
		return sb;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof TaskInfoStruct;
	}

}
