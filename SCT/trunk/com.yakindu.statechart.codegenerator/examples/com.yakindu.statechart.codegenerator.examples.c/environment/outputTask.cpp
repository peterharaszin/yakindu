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

#include "outputTask.h"
#include "outputEvent.h"

//#include "sys.h"

extern void delay_ms(unsigned int wait);

#ifdef WITH_DP3000_GL
#include "glcd-Display3000-211.h"
#endif

#define SETRED       0x01
#define SETYELLOW    0x02
#define SETGREEN     0x04
#define SETINDICATOR 0x08

using namespace OutputEvent;

/********************************/
/* Start:  LED hardware control */
enum Street1Type {
	street1_green,
	street1_amber,
	street1_red,
	street1_max
};
/* green, amber, red */
static const uint32 street1[street1_max] =    { 0x00008004, 0x002008, 0x004010 };

enum Pedstreet1Type {
	pedstreet1_green,
	pedstreet1_red,
	pedstreet1_indication,
	pedstreet1_max
};
/* green, red, indication */
static const uint32 pedstreet1[pedstreet1_max] = { 0x00001080, 0x00000840, 0x00000420 };

/* Start:  LED hardware control */
/********************************/

/* state string to state ID combination */
static const char* state_str[] = {"                      ",
		                          "     Street Green     ",
		                          "  Pedestrian Waiting  ",
		                          "     Street Amber     ",
		                          "      Street Red      ",
		                          "   Pedestrian Green   ",
		                          "    Pedestrian Red    ",
		                          "    Street Prepare    "};

OutputTask::OutputTask(Scheduler& _scheduler, uint32 duration)
  : Task(_scheduler), outputDuration(duration), outputValue(1), addition(0), oldLight_Car(0), oldLight_Ped(0)
{
    outputValue = 0x00000000;
	outputEvent = Event(new Timeout(*this));
	setEvent(outputEvent);

}

OutputTask::~OutputTask()
{
}


void OutputTask::handleOutput(const uint8& ID)
{
	// actually not used
  //outputValue = IDToValue[ID];
}


void OutputTask::handleTimeout()
{

  uint32 pos;
  uint32 output = 0x0;
  uint8  lightID_Car(0);
  uint8  lightID_Ped(0);

#ifdef WITH_DP3000_GL
  initLCD();
  LCD_Print(state_str[trafficlightWaiting_Iface_getVariable(ifaceHandle, stateID)], 0, 160, 1, 1, 1, white, black);
#endif

#ifdef WITH_ALIVE_LED
  static uint32 aliveLEDcounter = 0;
  static uint32 aliveLED = 0x000000;

  aliveLEDcounter++;

  if ((aliveLEDcounter%100) == 0) {
	  if (aliveLED == 0)
	    aliveLED = 0x400000;
	  else
		aliveLED = 0x00;
  }
#endif

  /* Street */
 if (trafficlightWaiting_getVar_tl_red(tl_handle) == 1) {
	  output |= street1[street1_red]; //IDToValue[s1_red_s2_red_p1_red_p2_red];
	  lightID_Car |= SETRED;
 }

  if (trafficlightWaiting_getVar_tl_yellow(tl_handle) == 1) {
	  output |= street1[street1_amber];//IDToValue[s1_yellow_s2_red_p1_red_p2_red];
	  lightID_Car |= SETYELLOW;
  }

  if (trafficlightWaiting_getVar_tl_green(tl_handle) == 1) {
	  output |= street1[street1_green];//IDToValue[s1_green_s2_red_p1_green_p2_red];
     lightID_Car |= SETGREEN;
  }

  /* Pedestrians */
  if (trafficlightWaiting_getVar_ped_request(tl_handle) == 1) {
	  output |= pedstreet1[pedstreet1_indication];
	  lightID_Ped |= SETINDICATOR;
  }

  if (trafficlightWaiting_getVar_ped_green(tl_handle) == 1) {
	  output |= pedstreet1[pedstreet1_green];
	  lightID_Ped |= SETGREEN;
  }

  if (trafficlightWaiting_getVar_ped_red(tl_handle) == 1) {
	  output |= pedstreet1[pedstreet1_red];
	  lightID_Ped |= SETRED;
  }

#ifdef WITH_DP3000_GL
  if (lightID_Car != oldLight_Car) {
	  TrafficLight(0, lightID_Car);
      TrafficLight(1, lightID_Car);
      oldLight_Car = lightID_Car;
  }

  if (lightID_Ped != oldLight_Ped) {
    TrafficLight(2, lightID_Ped);
    TrafficLight(3, lightID_Ped);
    oldLight_Ped = lightID_Ped;
  }
#endif


#ifdef WITH_ALIVE_LED
  output |= aliveLED;
#endif

  if (output > 0x00FFFFFF)
    output = 0x00FFFFFF;

  for (uint8 i(0);i<24;++i) {
  	pos = (((uint32)1)<<i); // *= 2;
  	if (output & pos) {
      PORTA = 0x00;
      PORTA = 0x04;
      PORTA = 0x00;
  	}
  	else {
      PORTA = 0x01;
      PORTA = 0x05;
      PORTA = 0x01;
  	}
  }

  PORTA = 0x00;
  PORTA = 0x02;
  PORTA = 0x00;

  outputEvent.setTimeout(getTics()+outputDuration);
  setEvent(outputEvent);

}

#ifdef WITH_DP3000_GL
void OutputTask::initLCD()
{
	static bool start(true);

	if (start) {


		/* Initialisation */
	  LCD_Init();
      delay_ms(1400);
	  LCD_Cls(dark_green);

	  /* Street */
      LCD_Rect(44,0,85,175, 1, white);
      LCD_Box(45,0,85,176, black);

      /* Median Strip */
      LCD_Draw(65,0,65,10, 1, white);
      LCD_Draw(65,20,65,30, 1, white);
      LCD_Draw(65,40,65,50, 1, white);
      LCD_Draw(65,60,65,70, 1, white);
      //LCD_Draw(65,80,65,90, 1, white);
      LCD_Draw(65,100,65,110, 1, white);
      LCD_Draw(65,120,65,130, 1, white);
      LCD_Draw(65,140,65,150, 1, white);
      LCD_Draw(65,160,65,170, 1, white);

      //LCD_Draw(45,70,85,70, 5, white);
      //LCD_Draw(45,97,85,97, 5, white);

      LCD_Draw(45,75,50,75, 6, white);
      LCD_Draw(57,75,62,75, 6, white);
      LCD_Draw(69,75,74,75, 6, white);
      LCD_Draw(80,75,85,75, 6, white);

      LCD_Draw(45,95,50,95, 6, white);
      LCD_Draw(57,95,62,95, 6, white);
      LCD_Draw(69,95,74,95, 6, white);
      LCD_Draw(80,95,85,95, 6, white);

      start = false;

	}

}

struct rect {
	uint8 x1;
	uint8 y1;
	uint8 x2;
	uint8 y2;
};

struct circle {
   uint8 x;
   uint8 y;
   uint8 radius;
};

struct lightData {
	uint8 x_offset;
	uint8 y_offset;
	rect greyBox;
	circle redCycle;
	circle yellowCycle;
	circle greenCycle;
	circle indicCycle;
};

#define MAXTRAFFICLIGHT 4
void OutputTask::TrafficLight(uint8 ID, uint8 LightID)
{
	static const lightData ampel[MAXTRAFFICLIGHT] = {{20,20,{0,0,20,43}, {10,8,5}, {10,21,5}, {10,34,5}, {0,0,0}},
	                                                  {90,100,{0,0,20,43}, {10,34,5}, {10,21,5}, {10,8,5}, {0,0,0}},
	                                                  {10,70,{0,0,30,17},  {15,8,3}, {0,0,0}, {23,8,3}, {7,8,3}},
	                                                  {90,80,{0,0,30,17}, {15,8,3}, {0,0,0}, {7,8,3}, {23,8,3}}
	                                                 };


    LCD_Box(ampel[ID].greyBox.x1+ampel[ID].x_offset, ampel[ID].greyBox.y1+ampel[ID].y_offset,ampel[ID].greyBox.x2+ampel[ID].x_offset, ampel[ID].greyBox.y2+ampel[ID].y_offset, RGB(50,50,50));
    LCD_Rect(ampel[ID].greyBox.x1+ampel[ID].x_offset, ampel[ID].greyBox.y1+ampel[ID].y_offset,ampel[ID].greyBox.x2+ampel[ID].x_offset, ampel[ID].greyBox.y2+ampel[ID].y_offset,0,grey);

    if ((LightID & SETRED) == SETRED)
      LCD_Circle(ampel[ID].redCycle.x+ampel[ID].x_offset, ampel[ID].redCycle.y+ampel[ID].y_offset, ampel[ID].redCycle.radius, 1, 1, red);
    else
      LCD_Circle(ampel[ID].redCycle.x+ampel[ID].x_offset, ampel[ID].redCycle.y+ampel[ID].y_offset, ampel[ID].redCycle.radius, 1, 1, black);

    if ((LightID & SETYELLOW) == SETYELLOW)
      LCD_Circle(ampel[ID].yellowCycle.x+ampel[ID].x_offset, ampel[ID].yellowCycle.y+ampel[ID].y_offset, ampel[ID].yellowCycle.radius, 1, 1, yellow);
    else
      LCD_Circle(ampel[ID].yellowCycle.x+ampel[ID].x_offset, ampel[ID].yellowCycle.y+ampel[ID].y_offset, ampel[ID].yellowCycle.radius, 1, 1, black);

    if ((LightID & SETGREEN) == SETGREEN)
      LCD_Circle(ampel[ID].greenCycle.x+ampel[ID].x_offset, ampel[ID].greenCycle.y+ampel[ID].y_offset, ampel[ID].greenCycle.radius, 1, 1, green);
    else
      LCD_Circle(ampel[ID].greenCycle.x+ampel[ID].x_offset, ampel[ID].greenCycle.y+ampel[ID].y_offset, ampel[ID].greenCycle.radius, 1, 1, black);

    if ((LightID & SETINDICATOR) == SETINDICATOR)
      LCD_Circle(ampel[ID].indicCycle.x+ampel[ID].x_offset, ampel[ID].indicCycle.y+ampel[ID].y_offset, ampel[ID].indicCycle.radius, 1, 1, white);
    else
      LCD_Circle(ampel[ID].indicCycle.x+ampel[ID].x_offset, ampel[ID].indicCycle.y+ampel[ID].y_offset, ampel[ID].indicCycle.radius, 1, 1, black);

}
#endif
