
#ifndef GUARDTEST_IFACE_H
#define GUARDTEST_IFACE_H

#include "definitions.h"

#ifdef __cplusplus
 extern "C" {
#endif

typedef enum {

  /* Signals defined by editor */
  trigger1,
  trigger2,
  trigger3,
  trigger4,
  trigger5,
  
  /* time trigger signals */
  
  trigger_GuardTest_MAX
} GuardTest_TrgType;

typedef struct {

  GuardTest_TrgType trigger[trigger_GuardTest_MAX];

  int32 startState;
  int32 state1;
  int32 state2;
  int32 state3;
  int32 out;
  int32 gValue;
  int32 value1;
  int32 value2;
  int32 state4;
  int32 state5;
  int32 state6;

  /* There is no boolean variable */

  /* There is no floating point variable */

} GuardTest_IfaceHandle;

extern void guardTest_Iface_initInterfaceHandle(GuardTest_IfaceHandle* handle);
extern void guardTest_Iface_raiseTrigger(GuardTest_IfaceHandle* handle, GuardTest_TrgType type);
extern void guardTest_Iface_resetTrigger(GuardTest_IfaceHandle* handle, GuardTest_TrgType type);
extern BOOL guardTest_Iface_isTriggerRaised(GuardTest_IfaceHandle* handle, GuardTest_TrgType type);

#ifdef __cplusplus
 }
#endif

#endif
