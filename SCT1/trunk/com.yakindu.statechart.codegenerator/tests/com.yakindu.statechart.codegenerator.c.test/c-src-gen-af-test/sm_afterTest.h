
#ifndef SM_AFTERTEST_H
#define SM_AFTERTEST_H

#include "afterTest_Iface.h"
#include "definitions.h"
#include "afterTest_Handle.h"
#include "afterTest_timerIface.h"
/* #include "sys.h" */

#ifdef __cplusplus
 extern "C" {
#endif

/*! Function calls the cycle of this region */
extern BOOL sm_afterTest_runCycle(SM_AfterTest_Handle* rhandle);
extern BOOL sm_afterTest_isIn(AfterTest_StateType testState);
extern void sm_afterTest_enter(SM_AfterTest_Handle* rhandle);
extern void sm_afterTest_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState);

#ifdef __cplusplus
 }
#endif

#endif

