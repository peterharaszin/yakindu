#include "historyTest_Iface.h"

void historyTest_Iface_initInterfaceHandle(HistoryTest_IfaceHandle* handle)
{
  uint8 i;

  /* Clean triggers */  
  for(i = 0; i<trigger_HistoryTest_MAX; ++i)
    handle->trigger[i] = FALSE;
  
  /* Clean integer variables */
  handle->inState0 = 0;
  handle->inState1 = 0;
  handle->inState2 = 0;
  handle->inState3 = 0;
  handle->inState4 = 0;
  handle->inState5 = 0;
  handle->inState6 = 0;
  handle->counter = 0;
  handle->selfTrans = 0;

  /* Clean boolean variables */

  /* Clean float variables */
  
}

void historyTest_Iface_raiseTrigger(HistoryTest_IfaceHandle* handle, HistoryTest_TrgType type)
{
  handle->trigger[type] = TRUE;
}

BOOL historyTest_Iface_isTriggerRaised(HistoryTest_IfaceHandle* handle, HistoryTest_TrgType type)
{
  return(handle->trigger[type]);
}

void historyTest_Iface_resetTrigger(HistoryTest_IfaceHandle* handle, HistoryTest_TrgType type)
{
  handle->trigger[type] = FALSE;
}
 

