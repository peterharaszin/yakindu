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
#include <avr/io.h>
#include <avr/interrupt.h>

#include "cppAdditions.h"
#include "definitions.h"
#include "scheduler.h"
#include "outputTask.h"
#include "keyTask.h"
#include "statemachineTask.h"
#include "timerService.h"
#include "trafficlightWaiting.h"

volatile uint64 tics = 0;

/* the graphic library needs a delay function */
void delay_ms(unsigned int wait)
{
  uint64 end(tics + wait);
  while(tics < end); /* busy loop -> call me evel! */

}

/* Interrupt-Function for the Scheduler */
ISR(TIMER2_COMP_vect)
{
 	tics++;
}

uint64 sys_time()
{
  return(tics);
}

Scheduler  scheduler;

TimerService timerService(scheduler);

int main()
{

    // Pins 1,2,3 of port group A should be handled as output
	DDRA = 0x07;	// read-mode and pull up Resistors enabled
	PORTA = 0xf8;

	DDRB = 0x00;	// read-mode and pull up Resistors enabled
	PORTB = 0xff;

    DDRC = 0x00;	// read-mode and pull up Resistors enabled
	PORTC = 0xff;

	DDRD = 0x00;	// read-mode and pull up Resistors enabled
	PORTD = 0xff;

	DDRE = 0x00;	// read-mode and pull up Resistors enabled
	PORTE = 0xff;

    // starting Timer
    OCR2 = 230;           // 14,74 MZ/64(prescaler) * 0.001 (one tick per Millisecond)
    TCCR2  = 0x2B;        // Clear time on compare match + prescaler Settings

    TIMSK |= (1<<OCIE2);  // Enable Timer compare match Interrupt

    sei();                // Enable global Interrupts

    TrafficlightWaiting_Handle      sMachine;

    trafficlightWaiting_init(&sMachine);

    OutputTask outputTask(scheduler,0.01*HZ);
    KeyTask    tasterTask(scheduler);

    StatemachineTask statema(scheduler, &sMachine);

    outputTask.setSMInterfaceHandle(&sMachine);
    tasterTask.setSMInterfaceHandle(&sMachine);
    timerService.setIntfaceHandle(&sMachine);

    // give control loop to scheduler
    scheduler.schedule();

}
