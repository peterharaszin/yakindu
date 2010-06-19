
#ifndef SM_HISTORYTEST_MAINSTATE_STATE2_H
#define SM_HISTORYTEST_MAINSTATE_STATE2_H

#include "historyTest_Iface.h"
#include "definitions.h"
#include "historyTest_Handle.h"
#include "historyTest_timerIface.h"
/* #include "sys.h" */

#ifdef __cplusplus
 extern "C" {
#endif

/*! Function calls the cycle of this region */
extern BOOL sm_historyTest_MainState_State2_runCycle(SM_HistoryTest_MainState_State2_Handle* rhandle);
extern BOOL sm_historyTest_MainState_State2_isIn(HistoryTest_StateType testState);
extern void sm_historyTest_MainState_State2_enter(SM_HistoryTest_MainState_State2_Handle* rhandle);
extern void sm_historyTest_MainState_State2_exit(SM_HistoryTest_MainState_State2_Handle* rhandle, HistoryTest_StateType oldState);

#ifdef __cplusplus
 }
#endif

#endif

