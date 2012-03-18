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

#ifndef DAMOS_POSIX_MQ_H_
#define DAMOS_POSIX_MQ_H_

#include <pthread.h>
#include <semaphore.h>

#ifdef __cplusplus
extern "C" {
#endif

typedef struct {
	pthread_mutex_t mutex;
	sem_t fillCount;
	sem_t emptyCount;
	int tail;
	int head;
	int size;
	int elementSize;
} DamosPosixMessageQueue;

#define DAMOS_POSIX_MESSAGE_QUEUE(capacity, elementSize) \
		struct { \
			DamosPosixMessageQueue base; \
			unsigned char buffer[capacity * elementSize]; \
		}

void DamosPosixMessageQueue_init(DamosPosixMessageQueue *mq, int capacity, int elementSize);

void DamosPosixMessageQueue_send(DamosPosixMessageQueue *mq, const void *data);

void DamosPosixMessageQueue_receive(DamosPosixMessageQueue *mq, void *data);

#ifdef __cplusplus
}
#endif

#endif /* DAMOS_POSIX_MQ_H_ */
