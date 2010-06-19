
#include "afterTest_timerIface.h"

void afterTest_timerIface_raiseTimer(void* ihandle, uint32 trigger)
{ 
  afterTest_Iface_raiseTrigger((AfterTest_IfaceHandle*)ihandle, (AfterTest_TrgType)trigger); 
}

void afterTest_timerIface_installTimer(void* handle, uint32 trigger, uint64 time_ms)
{

}

void afterTest_timerIface_resetTimer(void* handle, uint32 trigger)
{

}

