
#ifndef SM_HISTORYTEST_MAINSTATE_STATE0_STATE3_H
#define SM_HISTORYTEST_MAINSTATE_STATE0_STATE3_H

#include "historyTest_Iface.h"
#include "definitions.h"
#include "historyTest_Handle.h"
#include "historyTest_timerIface.h"
/* #include "sys.h" */

#ifdef __cplusplus
 extern "C" {
#endif

/*! Function calls the cycle of this region */
extern BOOL sm_historyTest_MainState_State0_State3_runCycle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
extern BOOL sm_historyTest_MainState_State0_State3_isIn(HistoryTest_StateType testState);
extern void sm_historyTest_MainState_State0_State3_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
extern void sm_historyTest_MainState_State0_State3_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState);

#ifdef __cplusplus
 }
#endif

#endif

