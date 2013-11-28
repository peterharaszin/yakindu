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
#ifndef SYS_H
#define SYS_H

#include "definitions.h"

#ifdef __cplusplus
 extern "C" {
#endif

extern volatile uint64 tics;

extern uint64 time();
extern void delay_ms(unsigned int wait);

#ifdef __cplusplus
 }
#endif

#endif
