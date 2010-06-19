
#ifndef HISTORYTEST_HANDLE_H
#define HISTORYTEST_HANDLE_H

#include "definitions.h"
#include "historyTest_Iface.h"

#ifdef __cplusplus
 extern "C" {
#endif

/*! Enumeration to identify the states 
**/
typedef enum {
  st_historyTest_MainState_State0_State3,
  st_historyTest_MainState_State0_Initial,
  
  st_historyTest_MainState_State0_State3_State4,
  st_historyTest_MainState_State0_State3_State5,
  st_historyTest_MainState_State0_State3_Initial,
  
  st_historyTest_MainState_State0,
  st_historyTest_MainState_Initial,
  st_historyTest_MainState_State1,
  st_historyTest_MainState_State2,
  st_historyTest_MainState_ShallowHistory,
  st_historyTest_MainState_DeepHistory,
  
  st_historyTest_MainState,
  st_historyTest_Initial,
  st_historyTest_StateKey1,
  st_historyTest_StateKey2,
  
  st_historyTest_MainState_State2_State6,
  st_historyTest_MainState_State2_Initial,
  
  st_HistoryTest_MAX
} HistoryTest_StateType;

/*! Enumeration to identify the transition uniquely 
**/
typedef enum {
  trans_HistoryTest_noTransition,
  historyTest_StateKey2_TO_historyTest_MainState_DeepHistory_P1,
  historyTest_MainState_Initial_TO_historyTest_MainState_State1_P1,
  historyTest_MainState_State0_TO_historyTest_MainState_State0_P2,
  historyTest_MainState_TO_historyTest_StateKey1_P1,
  historyTest_MainState_State0_TO_historyTest_MainState_State1_P1,
  historyTest_MainState_State0_State3_State5_TO_historyTest_MainState_State0_State3_State4_P1,
  historyTest_MainState_State0_State3_State5_TO_historyTest_MainState_State0_State3_State5_P2,
  historyTest_MainState_TO_historyTest_StateKey2_P1,
  historyTest_MainState_State0_Initial_TO_historyTest_MainState_State0_State3_P1,
  historyTest_StateKey1_TO_historyTest_MainState_ShallowHistory_P1,
  historyTest_MainState_State1_TO_historyTest_MainState_State0_State3_State5_P1,
  historyTest_Initial_TO_historyTest_MainState_P1,
  historyTest_MainState_State0_State3_State4_TO_historyTest_MainState_State2_State6_P1,
  historyTest_MainState_State0_State3_Initial_TO_historyTest_MainState_State0_State3_State4_P1,
  historyTest_MainState_State2_TO_historyTest_MainState_State1_P2,
  historyTest_MainState_State1_TO_historyTest_MainState_State0_P3,
  historyTest_MainState_State2_Initial_TO_historyTest_MainState_State2_State6_P1,
  trans_HistoryTest_MAX
} HistoryTest_TrnsType;

/* Forward declaration of the main handle "HistoryTest_Handle" */
struct HistoryTest_Handle;


/*! Structure to carry all neccessary information for one region.

**/
typedef struct {

/*  HistoryTest_IfaceHandle*   ihandle; */
  struct HistoryTest_Handle*    global; /*!< keep a pointer to the global handle */

  
} SM_HistoryTest_MainState_State2_Handle;

/*! Structure to carry all neccessary information for one region.

**/
typedef struct {

/*  HistoryTest_IfaceHandle*   ihandle; */
  struct HistoryTest_Handle*    global; /*!< keep a pointer to the global handle */

  
} SM_HistoryTest_MainState_State0_State3_Handle;

/*! Structure to carry all neccessary information for one region.

**/
typedef struct {

/*  HistoryTest_IfaceHandle*   ihandle; */
  struct HistoryTest_Handle*    global; /*!< keep a pointer to the global handle */

  SM_HistoryTest_MainState_State0_State3_Handle historyTest_MainState_State0_State3_Handle;
  
} SM_HistoryTest_MainState_State0_Handle;

/*! Structure to carry all neccessary information for one region.

**/
typedef struct {

/*  HistoryTest_IfaceHandle*   ihandle; */
  struct HistoryTest_Handle*    global; /*!< keep a pointer to the global handle */
  HistoryTest_StateType    deepHistory; /*!< keep history information regarding the global level */
  HistoryTest_StateType    shallowHistory; /*!< keep history information regarding the actual level */

  SM_HistoryTest_MainState_State0_Handle historyTest_MainState_State0_Handle;
  SM_HistoryTest_MainState_State2_Handle historyTest_MainState_State2_Handle;
  
} SM_HistoryTest_MainState_Handle;

/*! Structure to carry all neccessary information for one region.

**/
typedef struct {

/*  HistoryTest_IfaceHandle*   ihandle; */
  struct HistoryTest_Handle*    global; /*!< keep a pointer to the global handle */

  SM_HistoryTest_MainState_Handle historyTest_MainState_Handle;
  
} SM_HistoryTest_Handle;


typedef struct HistoryTest_Handle {
  HistoryTest_StateType       state;
  HistoryTest_TrnsType  transition;
  SM_HistoryTest_Handle startHandle;
  HistoryTest_IfaceHandle  ihandle;
} HistoryTest_Handle;

extern void sm_historyTest_MainState_State0_initHandle(SM_HistoryTest_MainState_State0_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global);
extern void sm_historyTest_MainState_State0_State3_initHandle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global);
extern void sm_historyTest_MainState_initHandle(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global);
extern void sm_historyTest_initHandle(SM_HistoryTest_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global);
extern void sm_historyTest_MainState_State2_initHandle(SM_HistoryTest_MainState_State2_Handle* rhandle, HistoryTest_IfaceHandle* ihandle, HistoryTest_Handle* global);

extern void historyTest_callTransitionAction(HistoryTest_Handle* SMGlobal);

#ifdef __cplusplus
}
#endif

#endif
