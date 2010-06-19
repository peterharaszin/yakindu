
#include "historyTest_timerIface.h"

void historyTest_timerIface_raiseTimer(void* ihandle, uint32 trigger)
{ 
  historyTest_Iface_raiseTrigger((HistoryTest_IfaceHandle*)ihandle, (HistoryTest_TrgType)trigger); 
}

void historyTest_timerIface_installTimer(void* handle, uint32 trigger, uint64 time_ms)
{

}

void historyTest_timerIface_resetTimer(void* handle, uint32 trigger)
{

}

