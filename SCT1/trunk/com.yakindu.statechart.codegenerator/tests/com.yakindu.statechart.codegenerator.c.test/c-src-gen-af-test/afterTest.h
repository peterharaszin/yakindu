#include "afterTest_Handle.h"
#include "afterTest_Iface.h"
#include "sm_afterTest.h"

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
extern void afterTest_init(AfterTest_Handle* handle);

/** @brief Function to call one cycle of the state machine
 * 
 * The call to afterTest_runCycle() initiates one run to completion cycle process of the state machine. 
 *
 * @param handle
 * : A valid/initialized state machine handle
 *
 * Please be aware that, if there are uncondition transitions between two states or the transitions (e.g. guards)
 * are always taken, the do-while loop runs infinite!
 *
 */
extern void afterTest_runCycle(AfterTest_Handle* handle);

/** @brief Function to clean up the external triggers.
 * 
 * Function can be called explicitly, but is called whenever afterTest_runCycle() is called
 *
 * @param handle
 * : A valid/initialized state machine handle
 *   
*/
extern void afterTest_cleanUnusedTriggers(AfterTest_Handle* handle);

/** @brief Function to access the integer value of variable \em waitTime  for reading
 * 
 * Function gives read access to the variable \em waitTime , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em waitTime  belongs to.
 * 
 * @return
 * The actual value of variable \em waitTime .   
*/
extern int32 afterTest_getVar_waitTime(AfterTest_Handle* handle);
/** @brief Function to access the integer value of variable \em st  for reading
 * 
 * Function gives read access to the variable \em st , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em st  belongs to.
 * 
 * @return
 * The actual value of variable \em st .   
*/
extern int32 afterTest_getVar_st(AfterTest_Handle* handle);



/** @brief Function to raise trigger \em trigger1 
 * 
 * Function raises the trigger \em trigger1, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em trigger1 belongs to.
 * 
*/
extern void afterTest_raiseTrigger_trigger1(AfterTest_Handle* handle);    
/** @brief Function to raise trigger \em trigger2 
 * 
 * Function raises the trigger \em trigger2, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em trigger2 belongs to.
 * 
*/
extern void afterTest_raiseTrigger_trigger2(AfterTest_Handle* handle);    
/** @brief Function to raise trigger \em key1 
 * 
 * Function raises the trigger \em key1, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em key1 belongs to.
 * 
*/
extern void afterTest_raiseTrigger_key1(AfterTest_Handle* handle);    
/** @brief Function to raise trigger \em key2 
 * 
 * Function raises the trigger \em key2, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em key2 belongs to.
 * 
*/
extern void afterTest_raiseTrigger_key2(AfterTest_Handle* handle);    
/** @brief Function to access the trigger \em outputEvent1 for reading
 * 
 * Function gives read access to the trigger \em outputEvent1, created by the state machine editor.
 * This function is only available if the trigger is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em outputEvent1 belongs to.
 * 
 * @return
 * The actual status of trigger \em outputEvent1; true if set, false if not.   
*/
extern BOOL afterTest_getTrigger_outputEvent1(AfterTest_Handle* handle);
/** @brief Function to access the trigger \em outputEvent2 for reading
 * 
 * Function gives read access to the trigger \em outputEvent2, created by the state machine editor.
 * This function is only available if the trigger is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em outputEvent2 belongs to.
 * 
 * @return
 * The actual status of trigger \em outputEvent2; true if set, false if not.   
*/
extern BOOL afterTest_getTrigger_outputEvent2(AfterTest_Handle* handle);


#ifdef __cplusplus
  }
#endif

