#include "historyTest_Handle.h"
#include "historyTest_Iface.h"
#include "sm_historyTest.h"

#ifdef __cplusplus
 extern "C" {
#endif

/** @brief Function to initialize the state machine handle 
 *
 * The handle is initialized completely, the interface communication is set up and the 
 * state is set to the initial state of the most global region.
 * 
 * The function did not allocate any new memory from the heap, so the size of a handle 
 * structure is of static size and does not change during initialization or operation. 
 * 
 * @param handle
 * : The handle must be a pointer to a valid memory region, great enough
 *         to hold the handle data.
 *  
*/
extern void historyTest_init(HistoryTest_Handle* handle);

/** @brief Function to call one cycle of the state machine
 * 
 * The call to historyTest_runCycle() initiates one run to completion cycle process of the state machine. 
 *
 * @param handle
 * : A valid/initialized state machine handle
 *
 * Please be aware that, if there are uncondition transitions between two states or the transitions (e.g. guards)
 * are always taken, the do-while loop runs infinite!
 *
 */
extern void historyTest_runCycle(HistoryTest_Handle* handle);

/** @brief Function to clean up the external triggers.
 * 
 * Function can be called explicitly, but is called whenever historyTest_runCycle() is called
 *
 * @param handle
 * : A valid/initialized state machine handle
 *   
*/
extern void historyTest_cleanUnusedTriggers(HistoryTest_Handle* handle);

/** @brief Function to access the integer value of variable \em inState0  for reading
 * 
 * Function gives read access to the variable \em inState0 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em inState0  belongs to.
 * 
 * @return
 * The actual value of variable \em inState0 .   
*/
extern int32 historyTest_getVar_inState0(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em inState1  for reading
 * 
 * Function gives read access to the variable \em inState1 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em inState1  belongs to.
 * 
 * @return
 * The actual value of variable \em inState1 .   
*/
extern int32 historyTest_getVar_inState1(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em inState2  for reading
 * 
 * Function gives read access to the variable \em inState2 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em inState2  belongs to.
 * 
 * @return
 * The actual value of variable \em inState2 .   
*/
extern int32 historyTest_getVar_inState2(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em inState3  for reading
 * 
 * Function gives read access to the variable \em inState3 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em inState3  belongs to.
 * 
 * @return
 * The actual value of variable \em inState3 .   
*/
extern int32 historyTest_getVar_inState3(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em inState4  for reading
 * 
 * Function gives read access to the variable \em inState4 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em inState4  belongs to.
 * 
 * @return
 * The actual value of variable \em inState4 .   
*/
extern int32 historyTest_getVar_inState4(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em inState5  for reading
 * 
 * Function gives read access to the variable \em inState5 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em inState5  belongs to.
 * 
 * @return
 * The actual value of variable \em inState5 .   
*/
extern int32 historyTest_getVar_inState5(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em inState6  for reading
 * 
 * Function gives read access to the variable \em inState6 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em inState6  belongs to.
 * 
 * @return
 * The actual value of variable \em inState6 .   
*/
extern int32 historyTest_getVar_inState6(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em counter  for reading
 * 
 * Function gives read access to the variable \em counter , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em counter  belongs to.
 * 
 * @return
 * The actual value of variable \em counter .   
*/
extern int32 historyTest_getVar_counter(HistoryTest_Handle* handle);
/** @brief Function to access the integer value of variable \em selfTrans  for reading
 * 
 * Function gives read access to the variable \em selfTrans , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em selfTrans  belongs to.
 * 
 * @return
 * The actual value of variable \em selfTrans .   
*/
extern int32 historyTest_getVar_selfTrans(HistoryTest_Handle* handle);



/** @brief Function to raise trigger \em event1 
 * 
 * Function raises the trigger \em event1, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em event1 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_event1(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em event2 
 * 
 * Function raises the trigger \em event2, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em event2 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_event2(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em event3 
 * 
 * Function raises the trigger \em event3, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em event3 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_event3(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em event4 
 * 
 * Function raises the trigger \em event4, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em event4 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_event4(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em event5 
 * 
 * Function raises the trigger \em event5, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em event5 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_event5(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em event6 
 * 
 * Function raises the trigger \em event6, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em event6 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_event6(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em key1 
 * 
 * Function raises the trigger \em key1, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em key1 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_key1(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em key2 
 * 
 * Function raises the trigger \em key2, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em key2 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_key2(HistoryTest_Handle* handle);    
/** @brief Function to raise trigger \em event7 
 * 
 * Function raises the trigger \em event7, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em event7 belongs to.
 * 
*/
extern void historyTest_raiseTrigger_event7(HistoryTest_Handle* handle);    


#ifdef __cplusplus
  }
#endif

