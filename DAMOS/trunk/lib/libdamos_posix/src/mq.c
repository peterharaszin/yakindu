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

#include <stddef.h>
#include <string.h>

#include "damos/posix/mq.h"

typedef struct {
	DamosPosixMessageQueue base;
	unsigned char buffer[1];
} DamosPosixMessageQueueWithBuffer;

void DamosPosixMessageQueue_init(DamosPosixMessageQueue *mq, int capacity, int elementSize) {
	mq->tail = 0;
	mq->head = 0;
	pthread_mutex_init(&mq->mutex, NULL);
	sem_init(&mq->fillCount, 0, 0);
	sem_init(&mq->emptyCount, 0, capacity);
	mq->size = capacity * elementSize;
	mq->elementSize = elementSize;
}

void DamosPosixMessageQueue_send(DamosPosixMessageQueue *mq, const void *data) {
	sem_wait(&mq->emptyCount);
	pthread_mutex_lock(&mq->mutex);
	memcpy(((DamosPosixMessageQueueWithBuffer *) mq)->buffer + mq->tail, data, mq->elementSize);
	mq->tail = (mq->tail + mq->elementSize) % mq->size;
	pthread_mutex_unlock(&mq->mutex);
	sem_post(&mq->fillCount);
}

void DamosPosixMessageQueue_receive(DamosPosixMessageQueue *mq, void *data) {
	sem_wait(&mq->fillCount);
	pthread_mutex_lock(&mq->mutex);
	memcpy(data, ((DamosPosixMessageQueueWithBuffer *) mq)->buffer + mq->head, mq->elementSize);
	mq->head = (mq->head + mq->elementSize) % mq->size;
	pthread_mutex_unlock(&mq->mutex);
	sem_post(&mq->emptyCount);
}
