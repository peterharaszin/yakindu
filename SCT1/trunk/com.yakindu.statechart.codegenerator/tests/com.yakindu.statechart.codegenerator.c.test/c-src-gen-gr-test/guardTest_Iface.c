#include "guardTest_Iface.h"

void guardTest_Iface_initInterfaceHandle(GuardTest_IfaceHandle* handle)
{
  uint8 i;

  /* Clean triggers */  
  for(i = 0; i<trigger_GuardTest_MAX; ++i)
    handle->trigger[i] = FALSE;
  
  /* Clean integer variables */
  handle->startState = 0;
  handle->state1 = 0;
  handle->state2 = 0;
  handle->state3 = 0;
  handle->out = 0;
  handle->gValue = 0;
  handle->value1 = 0;
  handle->value2 = 0;
  handle->state4 = 0;
  handle->state5 = 0;
  handle->state6 = 0;

  /* Clean boolean variables */

  /* Clean float variables */
  
}

void guardTest_Iface_raiseTrigger(GuardTest_IfaceHandle* handle, GuardTest_TrgType type)
{
  handle->trigger[type] = TRUE;
}

BOOL guardTest_Iface_isTriggerRaised(GuardTest_IfaceHandle* handle, GuardTest_TrgType type)
{
  return(handle->trigger[type]);
}

void guardTest_Iface_resetTrigger(GuardTest_IfaceHandle* handle, GuardTest_TrgType type)
{
  handle->trigger[type] = FALSE;
}
 

