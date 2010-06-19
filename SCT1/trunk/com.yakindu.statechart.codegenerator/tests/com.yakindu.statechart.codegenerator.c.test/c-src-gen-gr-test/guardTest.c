#include "guardTest.h"

void guardTest_init(GuardTest_Handle* SMGlobal)
{
  SMGlobal->state = st_guardTest_Initial;

  guardTest_Iface_initInterfaceHandle(&SMGlobal->ihandle);

  sm_guardTest_initHandle(&SMGlobal->startHandle, &SMGlobal->ihandle, SMGlobal);
} 

void guardTest_runCycle(GuardTest_Handle* SMGlobal) 
{
  while (sm_guardTest_runCycle(&SMGlobal->startHandle) == FALSE)
    guardTest_cleanUnusedTriggers(SMGlobal);

  return;
}

void guardTest_cleanUnusedTriggers(GuardTest_Handle* handle)
{
  handle->ihandle.trigger[trigger1] = FALSE;
  handle->ihandle.trigger[trigger2] = FALSE;
  handle->ihandle.trigger[trigger3] = FALSE;
  handle->ihandle.trigger[trigger4] = FALSE;
  
}

int32 guardTest_getVar_startState(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.startState);
}

int32 guardTest_getVar_state1(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.state1);
}

int32 guardTest_getVar_state2(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.state2);
}

int32 guardTest_getVar_state3(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.state3);
}

int32 guardTest_getVar_out(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.out);
}

int32 guardTest_getVar_gValue(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.gValue);
}

int32 guardTest_getVar_value1(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.value1);
}

int32 guardTest_getVar_value2(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.value2);
}

int32 guardTest_getVar_state4(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.state4);
}

int32 guardTest_getVar_state5(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.state5);
}

int32 guardTest_getVar_state6(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.state6);
}




void guardTest_raiseTrigger_trigger1(GuardTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[trigger1] = TRUE;
}
void guardTest_raiseTrigger_trigger2(GuardTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[trigger2] = TRUE;
}
void guardTest_raiseTrigger_trigger3(GuardTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[trigger3] = TRUE;
}
void guardTest_raiseTrigger_trigger4(GuardTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[trigger4] = TRUE;
}
BOOL guardTest_getTrigger_trigger5(GuardTest_Handle* bHandle)
{
  return(bHandle->ihandle.trigger[trigger5]);
}



