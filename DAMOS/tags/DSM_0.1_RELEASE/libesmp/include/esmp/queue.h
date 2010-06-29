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
#ifndef _ESMP_QUEUE_H_
#define _ESMP_QUEUE_H_

#define ESMP_QUEUE(name, type, size) \
	struct name { \
		unsigned int front; \
		unsigned int back; \
		type data[(size)]; \
	}

#define ESMP_QUEUE_DECL(name) struct name
#define ESMP_QUEUE_INITIALIZE(queue) \
	do { \
		(queue).front = 0; \
		(queue).back = 0; \
	} while (0)
#define ESMP_QUEUE_INITIALIZER { 0, 0 }

#define ESMP_QUEUE_SIZE(queue) (sizeof ((queue).data) / sizeof (*(queue).data))
#define ESMP_QUEUE_LAST_INDEX(queue) (ESMP_QUEUE_SIZE(queue) - 1)

#define ESMP_QUEUE_IS_EMPTY(queue) ((queue).front == (queue).back)
#define ESMP_QUEUE_IS_ALMOST_FULL(queue) ((queue).front == ((queue).back < ESMP_QUEUE_LAST_INDEX(queue) ? (queue).back + 1 : 0))

#define ESMP_QUEUE_FRONT(queue) ((queue).data[(queue).front])
#define ESMP_QUEUE_BACK(queue) ((queue).data[(queue).back > 0 ? (queue).back - 1 : ESMP_QUEUE_LAST_INDEX(queue)])

#define ESMP_QUEUE_ADD(queue, element) \
	do { \
		(queue).data[(queue).back] = (element); \
		if ((queue).back < ESMP_QUEUE_LAST_INDEX(queue)) { \
			++(queue).back; \
		} else { \
			(queue).back = 0; \
		} \
	} while (0)

#define ESMP_QUEUE_REMOVE(queue) \
	do { \
		if ((queue).front < ESMP_QUEUE_LAST_INDEX(queue)) { \
			++(queue).front; \
		} else { \
			(queue).front = 0; \
		} \
	} while (0)

#endif /* _ESMP_QUEUE_H_ */
