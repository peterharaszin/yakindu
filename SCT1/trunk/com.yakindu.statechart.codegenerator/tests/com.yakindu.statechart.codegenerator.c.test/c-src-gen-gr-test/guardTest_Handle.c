
#include "guardTest_Handle.h"

#define var(x) (global->ihandle.x)
#define send(x) (guardTest_Iface_raiseTrigger(&SMGlobal->ihandle,x))
 
 
void sm_guardTest_initHandle(SM_GuardTest_Handle* rhandle, GuardTest_IfaceHandle* ihandle, GuardTest_Handle* global)
{
  /* maintain pointers */ 
  rhandle->global  = global;

  
   
}


void guardTest_callTransitionAction(GuardTest_Handle* global)
{
  switch (global->transition) {
  
  case guardTest_StartState_TO_guardTest_State3_P6: {
	var(out) = 4;
    break;
  }
  
  case guardTest_StartState_TO_guardTest_State3_P5: {
	var(out) = 3;
    break;
  }
  
  case guardTest_StartState_TO_guardTest_State2_P1: {
	var(out) = 2;
    break;
  }
  
  case guardTest_StartState_TO_guardTest_State1_P3: {
	var(out) = 1;
    break;
  }
  
  default: {
   /* nothing to do here */
  }
  
  }
  
  return;
}

