#include "afterTest_Iface.h"

void afterTest_Iface_initInterfaceHandle(AfterTest_IfaceHandle* handle)
{
  uint8 i;

  /* Clean triggers */  
  for(i = 0; i<trigger_AfterTest_MAX; ++i)
    handle->trigger[i] = FALSE;
  
  /* Clean integer variables */
  handle->waitTime = 0;
  handle->st = 0;

  /* Clean boolean variables */

  /* Clean float variables */
  
}

void afterTest_Iface_raiseTrigger(AfterTest_IfaceHandle* handle, AfterTest_TrgType type)
{
  handle->trigger[type] = TRUE;
}

BOOL afterTest_Iface_isTriggerRaised(AfterTest_IfaceHandle* handle, AfterTest_TrgType type)
{
  return(handle->trigger[type]);
}

void afterTest_Iface_resetTrigger(AfterTest_IfaceHandle* handle, AfterTest_TrgType type)
{
  handle->trigger[type] = FALSE;
}
 

