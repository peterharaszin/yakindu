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
#include "trafficlightWaiting_timerIface.h"
#include "timerService.h"

void trafficlightWaiting_timerIface_raiseTimer(void* ihandle, uint32 trigger)
{
  trafficlightWaiting_Iface_raiseTrigger((TrafficlightWaiting_IfaceHandle*)ihandle, (TrafficlightWaiting_TrgType)trigger);
}

void trafficlightWaiting_timerIface_installTimer(void* handle, uint32 trigger, uint64 time_ms)
{
	/* we do not have to care for the handle, as we only have one statemachine */
	timerService.setTimer((uint32) trigger, time_ms);
}

void trafficlightWaiting_timerIface_resetTimer(void* handle, uint32 trigger)
{
	/* we do not have to care for the handle, as we only have one statemachine */
	timerService.resetTimer((uint32) trigger);
}
