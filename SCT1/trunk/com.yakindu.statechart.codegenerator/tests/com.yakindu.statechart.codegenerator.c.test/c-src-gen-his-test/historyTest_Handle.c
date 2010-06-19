
#include "historyTest_Handle.h"

#define var(x) (global->ihandle.x)
#define send(x) (historyTest_Iface_raiseTrigger(&SMGlobal->ihandle,x))
 
 
void sm_historyTest_MainState_State0_initHandle(SM_HistoryTest_MainState_State0_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global)
{
  /* maintain pointers */ 
  rhandle->global  = global;

  
    sm_historyTest_MainState_State0_State3_initHandle(&rhandle->historyTest_MainState_State0_State3_Handle, ihandle, global);
   
}
 
void sm_historyTest_MainState_State0_State3_initHandle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global)
{
  /* maintain pointers */ 
  rhandle->global  = global;

  
   
}
 
void sm_historyTest_MainState_initHandle(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global)
{
  /* maintain pointers */ 
  rhandle->global  = global;

  rhandle->deepHistory    = st_historyTest_MainState_Initial;
  
  rhandle->shallowHistory = st_historyTest_MainState_Initial;

  
    sm_historyTest_MainState_State0_initHandle(&rhandle->historyTest_MainState_State0_Handle, ihandle, global);
    sm_historyTest_MainState_State2_initHandle(&rhandle->historyTest_MainState_State2_Handle, ihandle, global);
   
}
 
void sm_historyTest_initHandle(SM_HistoryTest_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global)
{
  /* maintain pointers */ 
  rhandle->global  = global;

  
    sm_historyTest_MainState_initHandle(&rhandle->historyTest_MainState_Handle, ihandle, global);
   
}
 
void sm_historyTest_MainState_State2_initHandle(SM_HistoryTest_MainState_State2_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global)
{
  /* maintain pointers */ 
  rhandle->global  = global;

  
   
}


void historyTest_callTransitionAction(HistoryTest_Handle* global)
{
  switch (global->transition) {
  
  case historyTest_MainState_State0_TO_historyTest_MainState_State0_P2: {
	var(selfTrans) = var(selfTrans) + (1);
    break;
  }
  
  case historyTest_MainState_State0_State3_State5_TO_historyTest_MainState_State0_State3_State5_P2: {
	var(selfTrans) = var(selfTrans) + (2);
    break;
  }
  
  default: {
   /* nothing to do here */
  }
  
  }
  
  return;
}

