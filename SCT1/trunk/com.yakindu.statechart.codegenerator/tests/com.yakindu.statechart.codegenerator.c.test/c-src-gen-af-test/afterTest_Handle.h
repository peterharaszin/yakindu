
#ifndef AFTERTEST_HANDLE_H
#define AFTERTEST_HANDLE_H

#include "definitions.h"
#include "afterTest_Iface.h"

#ifdef __cplusplus
 extern "C" {
#endif

/*! Enumeration to identify the states 
**/
typedef enum {
  st_afterTest_State1,
  st_afterTest_State2,
  st_afterTest_State3,
  st_afterTest_Initial,
  st_afterTest_State4,
  
  st_AfterTest_MAX
} AfterTest_StateType;

/*! Enumeration to identify the transition uniquely 
**/
typedef enum {
  trans_AfterTest_noTransition,
  afterTest_State1_TO_afterTest_State4_P2,
  afterTest_State2_TO_afterTest_State1_P1,
  afterTest_State1_TO_afterTest_State2_P1,
  afterTest_State1_TO_afterTest_State3_P3,
  afterTest_State4_TO_afterTest_State1_P1,
  afterTest_Initial_TO_afterTest_State1_P1,
  afterTest_State3_TO_afterTest_State1_P1,
  trans_AfterTest_MAX
} AfterTest_TrnsType;

/* Forward declaration of the main handle "AfterTest_Handle" */
struct AfterTest_Handle;


/*! Structure to carry all neccessary information for one region.

**/
typedef struct {

/*  AfterTest_IfaceHandle*   ihandle; */
  struct AfterTest_Handle*    global; /*!< keep a pointer to the global handle */

  
} SM_AfterTest_Handle;


typedef struct AfterTest_Handle {
  AfterTest_StateType       state;
  AfterTest_TrnsType  transition;
  SM_AfterTest_Handle startHandle;
  AfterTest_IfaceHandle  ihandle;
} AfterTest_Handle;

extern void sm_afterTest_initHandle(SM_AfterTest_Handle* rhandle, AfterTest_IfaceHandle* ihandle, AfterTest_Handle* global);

extern void afterTest_callTransitionAction(AfterTest_Handle* SMGlobal);

#ifdef __cplusplus
}
#endif

#endif
