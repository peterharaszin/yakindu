
#include "afterTest_Handle.h"

#define var(x) (global->ihandle.x)
#define send(x) (afterTest_Iface_raiseTrigger(&SMGlobal->ihandle,x))
 
 
void sm_afterTest_initHandle(SM_AfterTest_Handle* rhandle, AfterTest_IfaceHandle* ihandle, AfterTest_Handle* global)
{
  /* maintain pointers */ 
  rhandle->global  = global;

  
   
}


void afterTest_callTransitionAction(AfterTest_Handle* global)
{
  switch (global->transition) {
  
  default: {
   /* nothing to do here */
  }
  
  }
  
  return;
}

