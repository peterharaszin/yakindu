
#ifndef GUARDTEST_HANDLE_H
#define GUARDTEST_HANDLE_H

#include "definitions.h"
#include "guardTest_Iface.h"

#ifdef __cplusplus
 extern "C" {
#endif

/*! Enumeration to identify the states 
**/
typedef enum {
  st_guardTest_StartState,
  st_guardTest_State1,
  st_guardTest_State2,
  st_guardTest_State3,
  st_guardTest_Initial,
  st_guardTest_State4,
  st_guardTest_Choice,
  st_guardTest_State5,
  st_guardTest_State6,
  st_guardTest_Junction,
  
  st_GuardTest_MAX
} GuardTest_StateType;

/*! Enumeration to identify the transition uniquely 
**/
typedef enum {
  trans_GuardTest_noTransition,
  guardTest_StartState_TO_guardTest_State2_P2,
  guardTest_Initial_TO_guardTest_StartState_P1,
  guardTest_State1_TO_guardTest_StartState_P1,
  guardTest_StartState_TO_guardTest_State4_P8,
  guardTest_StartState_TO_guardTest_State3_P6,
  guardTest_Choice_TO_guardTest_State5_P1,
  guardTest_StartState_TO_guardTest_State3_P5,
  guardTest_Junction_TO_guardTest_StartState_P1,
  guardTest_State6_TO_guardTest_Junction_P1,
  guardTest_State3_TO_guardTest_StartState_P1,
  guardTest_State4_TO_guardTest_StartState_P1,
  guardTest_Choice_TO_guardTest_State6_P2,
  guardTest_State5_TO_guardTest_Junction_P1,
  guardTest_State2_TO_guardTest_StartState_P1,
  guardTest_StartState_TO_guardTest_State2_P1,
  guardTest_StartState_TO_guardTest_State1_P3,
  guardTest_StartState_TO_guardTest_Choice_P7,
  guardTest_StartState_TO_guardTest_State1_P4,
  trans_GuardTest_MAX
} GuardTest_TrnsType;

/* Forward declaration of the main handle "GuardTest_Handle" */
struct GuardTest_Handle;


/*! Structure to carry all neccessary information for one region.

**/
typedef struct {

/*  GuardTest_IfaceHandle*   ihandle; */
  struct GuardTest_Handle*    global; /*!< keep a pointer to the global handle */

  
} SM_GuardTest_Handle;


typedef struct GuardTest_Handle {
  GuardTest_StateType       state;
  GuardTest_TrnsType  transition;
  SM_GuardTest_Handle startHandle;
  GuardTest_IfaceHandle  ihandle;
} GuardTest_Handle;

extern void sm_guardTest_initHandle(SM_GuardTest_Handle* rhandle, GuardTest_IfaceHandle* ihandle, GuardTest_Handle* global);

extern void guardTest_callTransitionAction(GuardTest_Handle* SMGlobal);

#ifdef __cplusplus
}
#endif

#endif
