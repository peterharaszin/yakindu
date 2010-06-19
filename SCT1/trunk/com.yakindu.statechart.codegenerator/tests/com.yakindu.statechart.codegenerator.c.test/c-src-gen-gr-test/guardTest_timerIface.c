
#include "guardTest_timerIface.h"

void guardTest_timerIface_raiseTimer(void* ihandle, uint32 trigger)
{ 
  guardTest_Iface_raiseTrigger((GuardTest_IfaceHandle*)ihandle, (GuardTest_TrgType)trigger); 
}

void guardTest_timerIface_installTimer(void* handle, uint32 trigger, uint64 time_ms)
{

}

void guardTest_timerIface_resetTimer(void* handle, uint32 trigger)
{

}

