
#ifndef AFTERTEST_IFACE_H
#define AFTERTEST_IFACE_H

#include "definitions.h"

#ifdef __cplusplus
 extern "C" {
#endif

typedef enum {

  /* Signals defined by editor */
  trigger1,
  trigger2,
  key1,
  key2,
  outputEvent1,
  outputEvent2,
  
  /* time trigger signals */
  timer_afterTest_State1_TO_afterTest_State2_P1,
  
  trigger_AfterTest_MAX
} AfterTest_TrgType;

typedef struct {

  AfterTest_TrgType trigger[trigger_AfterTest_MAX];

  int32 waitTime;
  int32 st;

  /* There is no boolean variable */

  /* There is no floating point variable */

} AfterTest_IfaceHandle;

extern void afterTest_Iface_initInterfaceHandle(AfterTest_IfaceHandle* handle);
extern void afterTest_Iface_raiseTrigger(AfterTest_IfaceHandle* handle, AfterTest_TrgType type);
extern void afterTest_Iface_resetTrigger(AfterTest_IfaceHandle* handle, AfterTest_TrgType type);
extern BOOL afterTest_Iface_isTriggerRaised(AfterTest_IfaceHandle* handle, AfterTest_TrgType type);

#ifdef __cplusplus
 }
#endif

#endif
