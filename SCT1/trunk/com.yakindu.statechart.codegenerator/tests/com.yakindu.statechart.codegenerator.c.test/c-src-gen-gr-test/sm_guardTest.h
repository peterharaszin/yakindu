
#ifndef SM_GUARDTEST_H
#define SM_GUARDTEST_H

#include "guardTest_Iface.h"
#include "definitions.h"
#include "guardTest_Handle.h"
#include "guardTest_timerIface.h"
/* #include "sys.h" */

#ifdef __cplusplus
 extern "C" {
#endif

/*! Function calls the cycle of this region */
extern BOOL sm_guardTest_runCycle(SM_GuardTest_Handle* rhandle);
extern BOOL sm_guardTest_isIn(GuardTest_StateType testState);
extern void sm_guardTest_enter(SM_GuardTest_Handle* rhandle);
extern void sm_guardTest_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);

#ifdef __cplusplus
 }
#endif

#endif

