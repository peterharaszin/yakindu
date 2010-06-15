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
/*
 * cppAdditions.cpp
 *
 *  Created on: 26.02.2009
 *      Author: seger
 */

#include "cppAdditions.h"

__extension__ typedef int __guard __attribute__((mode (__DI__)));
int __cxa_guard_acquire(__guard *g) {return !*(char *)(g);}
void __cxa_guard_release (__guard *g) {*(char *)g = 1;}
void __cxa_guard_abort (__guard *) {}
void __cxa_pure_virtual(void) {}

void * operator new(size_t size)
{ return malloc(size); }

void operator delete(void * ptr)
{ free(ptr); }

