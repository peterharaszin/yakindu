#include "afterTest.h"

void afterTest_init(AfterTest_Handle* SMGlobal)
{
  SMGlobal->state = st_afterTest_Initial;

  afterTest_Iface_initInterfaceHandle(&SMGlobal->ihandle);

  sm_afterTest_initHandle(&SMGlobal->startHandle, &SMGlobal->ihandle, SMGlobal);
} 

void afterTest_runCycle(AfterTest_Handle* SMGlobal) 
{
  while (sm_afterTest_runCycle(&SMGlobal->startHandle) == FALSE)
    afterTest_cleanUnusedTriggers(SMGlobal);

  return;
}

void afterTest_cleanUnusedTriggers(AfterTest_Handle* handle)
{
  handle->ihandle.trigger[trigger1] = FALSE;
  handle->ihandle.trigger[trigger2] = FALSE;
  handle->ihandle.trigger[key1] = FALSE;
  handle->ihandle.trigger[key2] = FALSE;
  
}

int32 afterTest_getVar_waitTime(AfterTest_Handle* bHandle)
{
  return(bHandle->ihandle.waitTime);
}

int32 afterTest_getVar_st(AfterTest_Handle* bHandle)
{
  return(bHandle->ihandle.st);
}




void afterTest_raiseTrigger_trigger1(AfterTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[trigger1] = TRUE;
}
void afterTest_raiseTrigger_trigger2(AfterTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[trigger2] = TRUE;
}
void afterTest_raiseTrigger_key1(AfterTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[key1] = TRUE;
}
void afterTest_raiseTrigger_key2(AfterTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[key2] = TRUE;
}
BOOL afterTest_getTrigger_outputEvent1(AfterTest_Handle* bHandle)
{
  return(bHandle->ihandle.trigger[outputEvent1]);
}

BOOL afterTest_getTrigger_outputEvent2(AfterTest_Handle* bHandle)
{
  return(bHandle->ihandle.trigger[outputEvent2]);
}



