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
#ifndef TASTERTESTEVENT_H
#define TASTERTESTEVENT_H

#include "event.h"

class KeyTask;

namespace KeyEvent {

class Timeout : public EventHandle {

protected:
	KeyTask* keyTask;

public:
	Timeout(KeyTask& task);
	virtual ~Timeout();

	virtual EventHandle* clone();
	virtual void runTask();
	virtual Task& getTask() const;

};

}

#endif
