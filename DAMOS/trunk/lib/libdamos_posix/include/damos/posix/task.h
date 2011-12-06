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

#ifndef DAMOS_POSIX_TASK_H_
#define DAMOS_POSIX_TASK_H_

#ifdef __cplusplus
extern "C" {
#endif

typedef struct {
	void *(*function)(void *context);
	int priority;
} DamosPosixTaskInfo;

#ifdef __cplusplus
}
#endif

#endif /* DAMOS_POSIX_TASK_H_ */
