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
#include "sys.h"
#include "scheduler.h"

/* Variable for the system timer */
volatile uint64 tics(0);

uint64 time()
{
	return(tics);
}

/* the graphic library needs a delay function */
void delay_ms(unsigned int wait)
{
  uint64 end(tics + wait);
  while(tics < end); /* busy loop -> call me evel! */

}

