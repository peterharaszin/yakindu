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
#ifndef DEBOUNCE_H
#define DEBOUNCE_H

#include "definitions.h"

class Debounce {

protected:
  uint8 counter;
  uint8 maxCounter;
  uint8 actValue;
  uint8 newValue;

  public:
  Debounce(uint8 maxCounter, uint8 startValue = 0);
  ~Debounce();

  void setValue(uint8 value);
  void trigger();

  uint8 getValue();

};

inline Debounce::Debounce(uint8 _maxCounter, uint8 startValue)
: counter(0), maxCounter(_maxCounter), actValue(startValue), newValue(startValue)
{}

inline Debounce::~Debounce()
{}

inline void Debounce::setValue(uint8 value)
{
  if (newValue != value) {
    newValue = value;
    counter = maxCounter;
  }
}

inline void Debounce::trigger()
{
  if (counter != 0) {
    counter--;
    if (counter == 0)
      actValue = newValue;
  }
}

inline uint8 Debounce::getValue()
{
  return(actValue);
}

#endif
