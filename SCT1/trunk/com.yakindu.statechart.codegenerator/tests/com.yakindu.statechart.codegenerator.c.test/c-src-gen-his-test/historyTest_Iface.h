
#ifndef HISTORYTEST_IFACE_H
#define HISTORYTEST_IFACE_H

#include "definitions.h"

#ifdef __cplusplus
 extern "C" {
#endif

typedef enum {

  /* Signals defined by editor */
  event1,
  event2,
  event3,
  event4,
  event5,
  event6,
  key1,
  key2,
  event7,
  
  /* time trigger signals */
  
  trigger_HistoryTest_MAX
} HistoryTest_TrgType;

typedef struct {

  HistoryTest_TrgType trigger[trigger_HistoryTest_MAX];

  int32 inState0;
  int32 inState1;
  int32 inState2;
  int32 inState3;
  int32 inState4;
  int32 inState5;
  int32 inState6;
  int32 counter;
  int32 selfTrans;

  /* There is no boolean variable */

  /* There is no floating point variable */

} HistoryTest_IfaceHandle;

extern void historyTest_Iface_initInterfaceHandle(HistoryTest_IfaceHandle* handle);
extern void historyTest_Iface_raiseTrigger(HistoryTest_IfaceHandle* handle, HistoryTest_TrgType type);
extern void historyTest_Iface_resetTrigger(HistoryTest_IfaceHandle* handle, HistoryTest_TrgType type);
extern BOOL historyTest_Iface_isTriggerRaised(HistoryTest_IfaceHandle* handle, HistoryTest_TrgType type);

#ifdef __cplusplus
 }
#endif

#endif
