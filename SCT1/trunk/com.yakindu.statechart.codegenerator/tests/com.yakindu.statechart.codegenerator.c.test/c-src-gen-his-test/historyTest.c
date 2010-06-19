#include "historyTest.h"

void historyTest_init(HistoryTest_Handle* SMGlobal)
{
  SMGlobal->state = st_historyTest_Initial;

  historyTest_Iface_initInterfaceHandle(&SMGlobal->ihandle);

  sm_historyTest_initHandle(&SMGlobal->startHandle, &SMGlobal->ihandle, SMGlobal);
} 

void historyTest_runCycle(HistoryTest_Handle* SMGlobal) 
{
  while (sm_historyTest_runCycle(&SMGlobal->startHandle) == FALSE)
    historyTest_cleanUnusedTriggers(SMGlobal);

  return;
}

void historyTest_cleanUnusedTriggers(HistoryTest_Handle* handle)
{
  handle->ihandle.trigger[event1] = FALSE;
  handle->ihandle.trigger[event2] = FALSE;
  handle->ihandle.trigger[event3] = FALSE;
  handle->ihandle.trigger[event4] = FALSE;
  handle->ihandle.trigger[event5] = FALSE;
  handle->ihandle.trigger[event6] = FALSE;
  handle->ihandle.trigger[key1] = FALSE;
  handle->ihandle.trigger[key2] = FALSE;
  handle->ihandle.trigger[event7] = FALSE;
  
}

int32 historyTest_getVar_inState0(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.inState0);
}

int32 historyTest_getVar_inState1(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.inState1);
}

int32 historyTest_getVar_inState2(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.inState2);
}

int32 historyTest_getVar_inState3(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.inState3);
}

int32 historyTest_getVar_inState4(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.inState4);
}

int32 historyTest_getVar_inState5(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.inState5);
}

int32 historyTest_getVar_inState6(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.inState6);
}

int32 historyTest_getVar_counter(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.counter);
}

int32 historyTest_getVar_selfTrans(HistoryTest_Handle* bHandle)
{
  return(bHandle->ihandle.selfTrans);
}




void historyTest_raiseTrigger_event1(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[event1] = TRUE;
}
void historyTest_raiseTrigger_event2(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[event2] = TRUE;
}
void historyTest_raiseTrigger_event3(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[event3] = TRUE;
}
void historyTest_raiseTrigger_event4(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[event4] = TRUE;
}
void historyTest_raiseTrigger_event5(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[event5] = TRUE;
}
void historyTest_raiseTrigger_event6(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[event6] = TRUE;
}
void historyTest_raiseTrigger_key1(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[key1] = TRUE;
}
void historyTest_raiseTrigger_key2(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[key2] = TRUE;
}
void historyTest_raiseTrigger_event7(HistoryTest_Handle* bHandle)
{
  bHandle->ihandle.trigger[event7] = TRUE;
}


